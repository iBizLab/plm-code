/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.filter.TestPlanSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.base.domain.Relation;

/**
 * 测试计划服务接口[TestPlanService]
 *
 * @author generator
 */
public interface TestPlanService extends IService<TestPlan> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default TestPlanService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    TestPlan get(TestPlan et);
    /**
     * 获取
     * @param key
     * @return
     */
    default TestPlan get(String key) {
        return getSelf().get(new TestPlan().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<TestPlan> getByIds(Collection<String> ids) {
        List<TestPlan> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TestPlan().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<TestPlan> getByEntities(List<TestPlan> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    TestPlan getDraft(TestPlan et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(TestPlan et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(TestPlan et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<TestPlan> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(TestPlan et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<TestPlan> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(TestPlan et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<TestPlan> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TestPlan().setId(key));
    }
    /**
     * 根据keys批量删除
     * @param keys
     * @return
     */
    default boolean remove(List<String> keys) {
        return removeBatch(keys);
    }
    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(TestPlan et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<TestPlan> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TestPlan().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<TestPlan> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<TestPlan> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            TestPlan et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getName(),ex.getMessage());
                if(!ignoreError)
                    break;
            }
        }
        return rt;
    }

    /**
     * end_test_plan
     * 
     * @param dto
     * @return
     */
    default TestPlan endTestPlan(TestPlan dto) {
        return dto;
    }

    /**
     * start_test_plan
     * 
     * @param dto
     * @return
     */
    default TestPlan startTestPlan(TestPlan dto) {
        return dto;
    }

    /**
     * test_plan_report_survey
     * 
     * @param key
     * @return
     */
    default TestPlan testPlanReportSurvey(String key) {
        return getSelf().testPlanReportSurvey(new TestPlan().setId(key));
    }

    /**
     * test_plan_report_survey
     * 
     * @param et
     * @return
     */
    default TestPlan testPlanReportSurvey(TestPlan et) {
        return et;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<TestPlan> searchDefault(TestPlanSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<TestPlan> listDefault(TestPlanSearchContext context);

    /**
     * searchmy_assignee
     * 
     * @param context
     * @return
     */
    Page<TestPlan> searchMyAssignee(TestPlanSearchContext context);
    /**
     * listmy_assignee
     * 
     * @param context
     * @return
     */
    List<TestPlan> listMyAssignee(TestPlanSearchContext context);

    /**
     * searchmy_in_progress
     * 
     * @param context
     * @return
     */
    Page<TestPlan> searchMyInProgress(TestPlanSearchContext context);
    /**
     * listmy_in_progress
     * 
     * @param context
     * @return
     */
    List<TestPlan> listMyInProgress(TestPlanSearchContext context);

    /**
     * searchmy_participate
     * 
     * @param context
     * @return
     */
    Page<TestPlan> searchMyParticipate(TestPlanSearchContext context);
    /**
     * listmy_participate
     * 
     * @param context
     * @return
     */
    List<TestPlan> listMyParticipate(TestPlanSearchContext context);

    /**
     * searchpending_and_in_progress
     * 
     * @param context
     * @return
     */
    Page<TestPlan> searchPendingAndInProgress(TestPlanSearchContext context);
    /**
     * listpending_and_in_progress
     * 
     * @param context
     * @return
     */
    List<TestPlan> listPendingAndInProgress(TestPlanSearchContext context);

    /**
     * searchquery_no_shift_in
     * 
     * @param context
     * @return
     */
    Page<TestPlan> searchQueryNoShiftIn(TestPlanSearchContext context);
    /**
     * listquery_no_shift_in
     * 
     * @param context
     * @return
     */
    List<TestPlan> listQueryNoShiftIn(TestPlanSearchContext context);

    /**
     * searchun_join_plan
     * 
     * @param context
     * @return
     */
    Page<TestPlan> searchUnJoinPlan(TestPlanSearchContext context);
    /**
     * listun_join_plan
     * 
     * @param context
     * @return
     */
    List<TestPlan> listUnJoinPlan(TestPlanSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default TestPlan getEntity() {
        return new TestPlan();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default TestPlanSearchContext getSearchContext() {
        return new TestPlanSearchContext();
    }
    /**
     * selectRelByLibraryId
     * @param libraryIds
     * @return
     */
    List<TestPlan> findByLibraryId(List<String> libraryIds);
    default List<TestPlan> findByLibraryId(String libraryId) {
        return findByLibraryId(Arrays.asList(libraryId));
    }
    /**
     * removeRelByLibraryId
     * @param libraryId
     * @return
     */
    boolean removeByLibraryId(String libraryId);
    /**
     * resetRelByLibraryId
     * @param libraryId
     * @return
     */
    boolean resetByLibraryId(String libraryId);
    /**
     * saveRelByLibraryId
     * @param libraryId
     * @param list
     * @return
     */
    default boolean saveByLibraryId(String libraryId,List<TestPlan> list) {
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }
    /**
    * saveRelByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library,List<TestPlan> list);

    /**
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<TestPlan> findByProjectId(List<String> projectIds);
    default List<TestPlan> findByProjectId(String projectId) {
        return findByProjectId(Arrays.asList(projectId));
    }
    /**
     * removeRelByProjectId
     * @param projectId
     * @return
     */
    boolean removeByProjectId(String projectId);
    /**
     * resetRelByProjectId
     * @param projectId
     * @return
     */
    boolean resetByProjectId(String projectId);
    /**
     * saveRelByProjectId
     * @param projectId
     * @param list
     * @return
     */
    default boolean saveByProjectId(String projectId,List<TestPlan> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<TestPlan> list);

    /**
     * selectRelByReleaseId
     * @param releaseIds
     * @return
     */
    List<TestPlan> findByReleaseId(List<String> releaseIds);
    default List<TestPlan> findByReleaseId(String releaseId) {
        return findByReleaseId(Arrays.asList(releaseId));
    }
    /**
     * removeRelByReleaseId
     * @param releaseId
     * @return
     */
    boolean removeByReleaseId(String releaseId);
    /**
     * resetRelByReleaseId
     * @param releaseId
     * @return
     */
    boolean resetByReleaseId(String releaseId);
    /**
     * saveRelByReleaseId
     * @param releaseId
     * @param list
     * @return
     */
    default boolean saveByReleaseId(String releaseId,List<TestPlan> list) {
        return getSelf().saveByRelease(new Release().setId(releaseId),list);
    }
    /**
    * saveRelByRelease
    * @param release
    * @param list
    * @return
    */
    boolean saveByRelease(Release release,List<TestPlan> list);

    /**
     * selectRelBySprintId
     * @param sprintIds
     * @return
     */
    List<TestPlan> findBySprintId(List<String> sprintIds);
    default List<TestPlan> findBySprintId(String sprintId) {
        return findBySprintId(Arrays.asList(sprintId));
    }
    /**
     * removeRelBySprintId
     * @param sprintId
     * @return
     */
    boolean removeBySprintId(String sprintId);
    /**
     * resetRelBySprintId
     * @param sprintId
     * @return
     */
    boolean resetBySprintId(String sprintId);
    /**
     * saveRelBySprintId
     * @param sprintId
     * @param list
     * @return
     */
    default boolean saveBySprintId(String sprintId,List<TestPlan> list) {
        return getSelf().saveBySprint(new Sprint().setId(sprintId),list);
    }
    /**
    * saveRelBySprint
    * @param sprint
    * @param list
    * @return
    */
    boolean saveBySprint(Sprint sprint,List<TestPlan> list);

    default List<Relation> getWorkItemRelations(TestPlan et) {
        return new ArrayList<>();
    }


    /**
     * 自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    List<JSONObject> select(String sql, Map<String,Object> param);

    /**
     * 自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    boolean execute(String sql, Map<String,Object> param);

}