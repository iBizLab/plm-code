/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/config/MybatisConfiguration.java.hbs
 */
package cn.ibizlab.plm.util.config;

import cn.ibizlab.util.db.dialect.MySqlDialect;
import cn.ibizlab.util.filter.DbTypeContextHolder;
import cn.ibizlab.util.helper.UniqueNameGenerator;
import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.ds.ItemDataSource;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * mybatis全局配置类
 *
 * @author generator
 */
@Configuration
@MapperScan(value={"cn.ibizlab.util.mapper","cn.ibizlab.plm.core.*.mapper"},nameGenerator = UniqueNameGenerator.class)
public class MybatisConfiguration {
    /**
     * mybatis适配多数据库
     * @return
     */
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties p = new Properties();
        p.setProperty("Oracle", "oracle");
        p.setProperty("MySQL", "mysql");
        p.setProperty("PostgreSQL", "postgresql");
        p.setProperty("DM", "oracle");//达梦数据库使用oracle模式
        p.setProperty("H2", "mysql");//根据当前运行的数据库设置h2对应的databaseid
        databaseIdProvider.setProperties(p);
        return databaseIdProvider;
    }

    /**
     * 分页拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(DataSource dataSource) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        DbTypeContextHolder.register(new DbTypeContextHolder.DbTypeContext() {
            @Override
            public void init(DataSource dataSource) {
                if(dataSource instanceof DynamicRoutingDataSource){
                    ((DynamicRoutingDataSource) dataSource).getCurrentDataSources().entrySet().forEach(
                            item->{
                                if(item.getValue() instanceof ItemDataSource) {
                                   push(item.getKey(), getDbType(((ItemDataSource) item.getValue()).getDataSource()));
                                }
                            }
                    );
                }
                else
                    push(getDbType(dataSource));
            }
            @Override
            public DbType get() {
                return peek(DynamicDataSourceContextHolder.peek());
            }
        }, dataSource);
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        initDialect(dataSource,paginationInnerInterceptor);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }

    public DbType getDbType(DataSource dataSource) {
        if (dataSource instanceof DruidDataSource) {
            return DbType.getDbType(((DruidDataSource) dataSource).getDbType());
        }
        return DbTypeContextHolder.getDbType(dataSource);
    }

    public void initDialect(DataSource dataSource, PaginationInnerInterceptor paginationInnerInterceptor) {
        DbType dbType = getDbType(dataSource);
        if (dbType == DbType.MYSQL) {
            Properties properties = new Properties();
            properties.put("dialect", MySqlDialect.class.getCanonicalName());
            paginationInnerInterceptor.setProperties(properties);
        }
    }
    

}