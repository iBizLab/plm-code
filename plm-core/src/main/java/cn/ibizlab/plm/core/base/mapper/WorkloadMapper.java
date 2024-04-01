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
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 工时Mapper[Workload]
 *
 * @author generator
 */
public interface WorkloadMapper extends BaseMapper<Workload> {

    /**
     * 数据集合Calendar分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchCalendar(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合Calendar查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listCalendar(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchDefault(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listDefault(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合Idea_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchIdeaWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合Idea_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listIdeaWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合Log分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchLog(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合Log查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listLog(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合My_calendar分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyCalendar(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合My_calendar查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyCalendar(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合My_idea_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyIdeaWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合My_idea_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyIdeaWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合My_log分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyLog(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合My_log查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyLog(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合My_test_case_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyTestCaseWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合My_test_case_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyTestCaseWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合My_type_of分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyTypeOf(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合My_type_of查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyTypeOf(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合My_work_item_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyWorkItemWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合My_work_item_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyWorkItemWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合Test_case_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchTestCaseWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合Test_case_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listTestCaseWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合Type_of分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchTypeOf(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合Type_of查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listTypeOf(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合Work_item_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchWorkItemWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合Work_item_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listWorkItemWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Workload selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Workload selectEntity(Workload entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Workload> selectEntities(@Param("list") List<Workload> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Workload entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Workload entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Workload entity, @Param("ew") Wrapper<Workload> updateWrapper);

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
    int deleteEntities(@Param("list") List<Workload> list);

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

    /**
     * 根据typeId查询
     *
     * @param typeIds
     * @return
     */
    List<Workload> findByTypeId(@Param("typeIds") List<String> typeIds);

    /**
     * 根据principalId查询
     *
     * @param principalIds
     * @return
     */
    List<Workload> findByPrincipalId(@Param("principalIds") List<String> principalIds);

}