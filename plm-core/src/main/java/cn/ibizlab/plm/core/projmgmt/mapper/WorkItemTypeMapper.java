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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemTypeSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 工作项类型Mapper[WorkItemType]
 *
 * @author generator
 */
public interface WorkItemTypeMapper extends BaseMapper<WorkItemType> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItemType> searchDefault(IPage<WorkItemType> page, @Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItemType> listDefault(@Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);

    /**
     * 数据集合choose_target_type分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItemType> searchChooseTargetType(IPage<WorkItemType> page, @Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);
    
    /**
     * 数据集合choose_target_type查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItemType> listChooseTargetType(@Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);

    /**
     * 数据集合cur_project_type分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItemType> searchCurProjectType(IPage<WorkItemType> page, @Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);
    
    /**
     * 数据集合cur_project_type查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItemType> listCurProjectType(@Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);

    /**
     * 数据集合group_by_origin_state分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchGroupByOriginState(IPage<WorkItemType> page, @Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);
    
    /**
     * 数据集合group_by_origin_state查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listGroupByOriginState(@Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);

    /**
     * 数据集合project_work_item_type分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItemType> searchProjectWorkItemType(IPage<WorkItemType> page, @Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);
    
    /**
     * 数据集合project_work_item_type查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItemType> listProjectWorkItemType(@Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);

    /**
     * 数据集合project_work_item_type_not_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItemType> searchProjectWorkItemTypeNotBug(IPage<WorkItemType> page, @Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);
    
    /**
     * 数据集合project_work_item_type_not_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItemType> listProjectWorkItemTypeNotBug(@Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);

    /**
    * 根据projectId查询
    *
    * @param projectIds
    * @return
    */
    List<WorkItemType> findByProjectId(@Param("projectIds") List<String> projectIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItemType> searchView(IPage<WorkItemType> page, @Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItemType> listView(@Param("ctx") WorkItemTypeSearchContext context, @Param("ew") Wrapper<WorkItemType> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    WorkItemType selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    WorkItemType selectEntity(WorkItemType entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<WorkItemType> selectEntities(@Param("list") List<WorkItemType> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(WorkItemType entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) WorkItemType entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) WorkItemType entity, @Param("ew") Wrapper<WorkItemType> updateWrapper);

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
    int deleteEntities(@Param("list") List<WorkItemType> list);

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