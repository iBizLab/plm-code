/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.base.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.base.domain.Executor;
import cn.ibizlab.plm.core.base.filter.ExecutorSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 执行人Mapper[Executor]
 *
 * @author generator
 */
public interface ExecutorMapper extends BaseMapper<Executor> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Executor> searchDefault(IPage<Executor> page, @Param("ctx") ExecutorSearchContext context, @Param("ew") Wrapper<Executor> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Executor> listDefault(@Param("ctx") ExecutorSearchContext context, @Param("ew") Wrapper<Executor> wrapper);

    /**
     * 数据集合comment_work_item_executor分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Executor> searchCommentWorkItemExecutor(IPage<Executor> page, @Param("ctx") ExecutorSearchContext context, @Param("ew") Wrapper<Executor> wrapper);
    
    /**
     * 数据集合comment_work_item_executor查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Executor> listCommentWorkItemExecutor(@Param("ctx") ExecutorSearchContext context, @Param("ew") Wrapper<Executor> wrapper);

    /**
     * 数据集合executor_by_ownerid分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Executor> searchExecutorByOwnerid(IPage<Executor> page, @Param("ctx") ExecutorSearchContext context, @Param("ew") Wrapper<Executor> wrapper);
    
    /**
     * 数据集合executor_by_ownerid查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Executor> listExecutorByOwnerid(@Param("ctx") ExecutorSearchContext context, @Param("ew") Wrapper<Executor> wrapper);

    /**
    * 根据userId查询
    *
    * @param userIds
    * @return
    */
    List<Executor> findByUserId(@Param("userIds") List<String> userIds);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Executor> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Executor> searchView(IPage<Executor> page, @Param("ctx") ExecutorSearchContext context, @Param("ew") Wrapper<Executor> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Executor> listView(@Param("ctx") ExecutorSearchContext context, @Param("ew") Wrapper<Executor> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Executor selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Executor selectEntity(Executor entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Executor> selectEntities(@Param("list") List<Executor> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Executor entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Executor entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Executor entity, @Param("ew") Wrapper<Executor> updateWrapper);

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
    int deleteEntities(@Param("list") List<Executor> list);

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