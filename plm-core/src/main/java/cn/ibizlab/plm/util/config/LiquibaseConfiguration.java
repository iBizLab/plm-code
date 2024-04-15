/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/config/LiquibaseConfiguration.java.hbs
 */
package cn.ibizlab.plm.util.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(prefix = "spring.liquibase",value = "enabled",matchIfMissing = true)
public class LiquibaseConfiguration {

    @Value("${spring.datasource.isSyncDBSchema:false}")
    private boolean syncDBSchema;

    @Value("${spring.datasource.defaultSchema:public}")
    private String defaultSchema;

    @Bean
    public SpringLiquibase masterliquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(syncDBSchema?"classpath:liquibase/master.xml":"classpath:liquibase/empty.xml");
        liquibase.setContexts("development,test,production");
        liquibase.setShouldRun(true);
        liquibase.setDefaultSchema(defaultSchema);
        return liquibase;
    }

}