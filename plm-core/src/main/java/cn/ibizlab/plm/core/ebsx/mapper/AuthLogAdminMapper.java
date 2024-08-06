/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.ebsx.domain.AuthLogAdmin;
import cn.ibizlab.plm.core.ebsx.filter.AuthLogAdminSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 认证日志Mapper[AuthLogAdmin]
 *
 * @author generator
 */
@DS("db2")
public interface AuthLogAdminMapper extends BaseMapper<AuthLogAdmin> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AuthLogAdmin> searchDefault(IPage<AuthLogAdmin> page, @Param("ctx") AuthLogAdminSearchContext context, @Param("ew") Wrapper<AuthLogAdmin> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AuthLogAdmin> listDefault(@Param("ctx") AuthLogAdminSearchContext context, @Param("ew") Wrapper<AuthLogAdmin> wrapper);

    /**
     * 数据集合distinct_userid分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchDistinctUserid(IPage<AuthLogAdmin> page, @Param("ctx") AuthLogAdminSearchContext context, @Param("ew") Wrapper<AuthLogAdmin> wrapper);
    
    /**
     * 数据集合distinct_userid查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listDistinctUserid(@Param("ctx") AuthLogAdminSearchContext context, @Param("ew") Wrapper<AuthLogAdmin> wrapper);

    /**
     * 数据集合group_by_data分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchGroupByData(IPage<AuthLogAdmin> page, @Param("ctx") AuthLogAdminSearchContext context, @Param("ew") Wrapper<AuthLogAdmin> wrapper);
    
    /**
     * 数据集合group_by_data查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listGroupByData(@Param("ctx") AuthLogAdminSearchContext context, @Param("ew") Wrapper<AuthLogAdmin> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AuthLogAdmin> searchView(IPage<AuthLogAdmin> page, @Param("ctx") AuthLogAdminSearchContext context, @Param("ew") Wrapper<AuthLogAdmin> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AuthLogAdmin> listView(@Param("ctx") AuthLogAdminSearchContext context, @Param("ew") Wrapper<AuthLogAdmin> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    AuthLogAdmin selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    AuthLogAdmin selectEntity(AuthLogAdmin entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<AuthLogAdmin> selectEntities(@Param("list") List<AuthLogAdmin> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(AuthLogAdmin entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) AuthLogAdmin entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) AuthLogAdmin entity, @Param("ew") Wrapper<AuthLogAdmin> updateWrapper);

    /**
     * 主键删除
     *
     * @param id
     * @return
     */
    @Override
    int deleteById(Serializable id);

    /**
     * 数据对象集合删除
     *
     * @param list
     * @return
     */
    int deleteEntities(@Param("list") List<AuthLogAdmin> list);

    /**
     * 自定义查询SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Select("${sql}")
    List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义更新SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义插入SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义删除SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);
}