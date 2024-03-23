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
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 用例Mapper[TestCase]
 *
 * @author generator
 */
public interface TestCaseMapper extends BaseMapper<TestCase> {

    /**
     * 数据集合Comment_notify_maintenance分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchCommentNotifyMaintenance(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Comment_notify_maintenance查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listCommentNotifyMaintenance(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchDefault(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listDefault(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchDeleted(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listDeleted(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Idea_relation_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchIdeaRelationTestCase(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Idea_relation_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listIdeaRelationTestCase(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合My_assign分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchMyAssign(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合My_assign查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listMyAssign(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合My_assignee_count_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchMyAssigneeCountTestCase(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合My_assignee_count_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listMyAssigneeCountTestCase(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合My_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchMyAttention(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合My_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listMyAttention(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合My_created分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchMyCreated(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合My_created查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listMyCreated(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchNormal(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listNormal(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Nosuite_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchNosuiteTestCase(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Nosuite_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listNosuiteTestCase(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Not_add_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchNotAddCase(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Not_add_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listNotAddCase(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Not_exsists_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchNotExsistsRelation(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Not_exsists_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listNotExsistsRelation(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Recent_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchRecentTestCase(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Recent_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listRecentTestCase(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Suites_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchSuitesTestCase(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Suites_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listSuitesTestCase(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 数据集合Work_item_relation_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCase> searchWorkItemRelationTestCase(IPage<TestCase> page, @Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);
    
    /**
     * 数据集合Work_item_relation_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCase> listWorkItemRelationTestCase(@Param("ctx") TestCaseSearchContext context, @Param("ew") Wrapper<TestCase> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    TestCase selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    TestCase selectEntity(TestCase entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<TestCase> selectEntities(@Param("list") List<TestCase> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(TestCase entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) TestCase entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) TestCase entity, @Param("ew") Wrapper<TestCase> updateWrapper);

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
    int deleteEntities(@Param("list") List<TestCase> list);

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
     * 根据testLibraryId查询
     *
     * @param testLibraryIds
     * @return
     */
    List<TestCase> findByTestLibraryId(@Param("testLibraryIds") List<String> testLibraryIds);

    /**
     * 根据suiteId查询
     *
     * @param suiteIds
     * @return
     */
    List<TestCase> findBySuiteId(@Param("suiteIds") List<String> suiteIds);

    /**
     * 根据maintenanceId查询
     *
     * @param maintenanceIds
     * @return
     */
    List<TestCase> findByMaintenanceId(@Param("maintenanceIds") List<String> maintenanceIds);

}