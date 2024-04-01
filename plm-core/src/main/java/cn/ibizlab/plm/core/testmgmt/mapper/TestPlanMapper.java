/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.filter.TestPlanSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 测试计划Mapper[TestPlan]
 *
 * @author generator
 */
public interface TestPlanMapper extends BaseMapper<TestPlan> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestPlan> searchDefault(IPage<TestPlan> page, @Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestPlan> listDefault(@Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);

    /**
     * 数据集合My_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestPlan> searchMyAssignee(IPage<TestPlan> page, @Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);
    
    /**
     * 数据集合My_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestPlan> listMyAssignee(@Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);

    /**
     * 数据集合My_in_progress分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestPlan> searchMyInProgress(IPage<TestPlan> page, @Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);
    
    /**
     * 数据集合My_in_progress查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestPlan> listMyInProgress(@Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);

    /**
     * 数据集合My_participate分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestPlan> searchMyParticipate(IPage<TestPlan> page, @Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);
    
    /**
     * 数据集合My_participate查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestPlan> listMyParticipate(@Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);

    /**
     * 数据集合Pending_and_in_progress分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestPlan> searchPendingAndInProgress(IPage<TestPlan> page, @Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);
    
    /**
     * 数据集合Pending_and_in_progress查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestPlan> listPendingAndInProgress(@Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);

    /**
     * 数据集合Query_no_shift_in分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestPlan> searchQueryNoShiftIn(IPage<TestPlan> page, @Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);
    
    /**
     * 数据集合Query_no_shift_in查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestPlan> listQueryNoShiftIn(@Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);

    /**
     * 数据集合Un_join_plan分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestPlan> searchUnJoinPlan(IPage<TestPlan> page, @Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);
    
    /**
     * 数据集合Un_join_plan查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestPlan> listUnJoinPlan(@Param("ctx") TestPlanSearchContext context, @Param("ew") Wrapper<TestPlan> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    TestPlan selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    TestPlan selectEntity(TestPlan entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<TestPlan> selectEntities(@Param("list") List<TestPlan> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(TestPlan entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) TestPlan entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) TestPlan entity, @Param("ew") Wrapper<TestPlan> updateWrapper);

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
    int deleteEntities(@Param("list") List<TestPlan> list);

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
     * 根据libraryId查询
     *
     * @param libraryIds
     * @return
     */
    List<TestPlan> findByLibraryId(@Param("libraryIds") List<String> libraryIds);

    /**
     * 根据projectId查询
     *
     * @param projectIds
     * @return
     */
    List<TestPlan> findByProjectId(@Param("projectIds") List<String> projectIds);

    /**
     * 根据releaseId查询
     *
     * @param releaseIds
     * @return
     */
    List<TestPlan> findByReleaseId(@Param("releaseIds") List<String> releaseIds);

    /**
     * 根据sprintId查询
     *
     * @param sprintIds
     * @return
     */
    List<TestPlan> findBySprintId(@Param("sprintIds") List<String> sprintIds);

}