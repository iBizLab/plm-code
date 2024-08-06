/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
import cn.ibizlab.plm.core.projmgmt.filter.SprintAlterationSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 迭代变更Mapper[SprintAlteration]
 *
 * @author generator
 */
public interface SprintAlterationMapper extends BaseMapper<SprintAlteration> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SprintAlteration> searchDefault(IPage<SprintAlteration> page, @Param("ctx") SprintAlterationSearchContext context, @Param("ew") Wrapper<SprintAlteration> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SprintAlteration> listDefault(@Param("ctx") SprintAlterationSearchContext context, @Param("ew") Wrapper<SprintAlteration> wrapper);

    /**
     * 数据集合change分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SprintAlteration> searchChange(IPage<SprintAlteration> page, @Param("ctx") SprintAlterationSearchContext context, @Param("ew") Wrapper<SprintAlteration> wrapper);
    
    /**
     * 数据集合change查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SprintAlteration> listChange(@Param("ctx") SprintAlterationSearchContext context, @Param("ew") Wrapper<SprintAlteration> wrapper);

    /**
    * 根据sprintId查询
    *
    * @param sprintIds
    * @return
    */
    List<SprintAlteration> findBySprintId(@Param("sprintIds") List<String> sprintIds);

    /**
    * 根据workItemId查询
    *
    * @param workItemIds
    * @return
    */
    List<SprintAlteration> findByWorkItemId(@Param("workItemIds") List<String> workItemIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SprintAlteration> searchView(IPage<SprintAlteration> page, @Param("ctx") SprintAlterationSearchContext context, @Param("ew") Wrapper<SprintAlteration> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SprintAlteration> listView(@Param("ctx") SprintAlterationSearchContext context, @Param("ew") Wrapper<SprintAlteration> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    SprintAlteration selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    SprintAlteration selectEntity(SprintAlteration entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<SprintAlteration> selectEntities(@Param("list") List<SprintAlteration> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(SprintAlteration entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) SprintAlteration entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) SprintAlteration entity, @Param("ew") Wrapper<SprintAlteration> updateWrapper);

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
    int deleteEntities(@Param("list") List<SprintAlteration> list);

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