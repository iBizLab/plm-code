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
import cn.ibizlab.plm.core.base.domain.CommonFlow;
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
    boolean create(List<TestPlan> list);

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
    boolean update(List<TestPlan> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TestPlan().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(TestPlan et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<TestPlan> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TestPlan().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<TestPlan> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default TestPlan get(String key) {
        return getSelf().get(new TestPlan().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    TestPlan get(TestPlan et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<TestPlan> get(Collection<String> keys) {
        List<TestPlan> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TestPlan().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<TestPlan> get(List<TestPlan> entities);

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
    * 保存
    * @param et
    * @return
    */
    boolean save(TestPlan et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<TestPlan> list);

    /**
    * deleteCategories
    * 
    * @param et
    * @return
    */
    default TestPlan deleteCategories(TestPlan et) {
        return et;
    }

    /**
    * endTestPlan
    * 
    * @param et
    * @return
    */
    default TestPlan endTestPlan(TestPlan et) {
        return et;
    }

    /**
    * startTestPlan
    * 
    * @param et
    * @return
    */
    default TestPlan startTestPlan(TestPlan et) {
        return et;
    }

    /**
    * testPlanReportSurvey
    * 
    * @param key
    * @return
    */
    default TestPlan testPlanReportSurvey(String key) {
        return getSelf().testPlanReportSurvey(new TestPlan().setId(key));
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<TestPlan> fetchDefault(TestPlanSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<TestPlan> listDefault(TestPlanSearchContext context);

    /**
    * fetchMyAssignee
    * 
    * @param context
    * @return
    */
    Page<TestPlan> fetchMyAssignee(TestPlanSearchContext context);

    /**
    * listMyAssignee
    * 
    * @param context
    * @return
    */
    List<TestPlan> listMyAssignee(TestPlanSearchContext context);

    /**
    * fetchMyInProgress
    * 
    * @param context
    * @return
    */
    Page<TestPlan> fetchMyInProgress(TestPlanSearchContext context);

    /**
    * listMyInProgress
    * 
    * @param context
    * @return
    */
    List<TestPlan> listMyInProgress(TestPlanSearchContext context);

    /**
    * fetchMyParticipate
    * 
    * @param context
    * @return
    */
    Page<TestPlan> fetchMyParticipate(TestPlanSearchContext context);

    /**
    * listMyParticipate
    * 
    * @param context
    * @return
    */
    List<TestPlan> listMyParticipate(TestPlanSearchContext context);

    /**
    * fetchPendingAndInProgress
    * 
    * @param context
    * @return
    */
    Page<TestPlan> fetchPendingAndInProgress(TestPlanSearchContext context);

    /**
    * listPendingAndInProgress
    * 
    * @param context
    * @return
    */
    List<TestPlan> listPendingAndInProgress(TestPlanSearchContext context);

    /**
    * fetchQueryNoShiftIn
    * 
    * @param context
    * @return
    */
    Page<TestPlan> fetchQueryNoShiftIn(TestPlanSearchContext context);

    /**
    * listQueryNoShiftIn
    * 
    * @param context
    * @return
    */
    List<TestPlan> listQueryNoShiftIn(TestPlanSearchContext context);

    /**
    * fetchUnJoinPlan
    * 
    * @param context
    * @return
    */
    Page<TestPlan> fetchUnJoinPlan(TestPlanSearchContext context);

    /**
    * listUnJoinPlan
    * 
    * @param context
    * @return
    */
    List<TestPlan> listUnJoinPlan(TestPlanSearchContext context);

    /**
    * findByLibraryId
    * @param libraryIds
    * @return
    */
    List<TestPlan> findByLibraryId(List<String> libraryIds);
    default List<TestPlan> findByLibraryId(String libraryId){
        return findByLibraryId(Arrays.asList(libraryId));
    }

    /**
    * removeByLibraryId
    * @param libraryId
    * @return
    */
    boolean removeByLibraryId(String libraryId);

    /**
    * resetByLibraryId
    * @param libraryId
    * @return
    */
    boolean resetByLibraryId(String libraryId);

    /**
    * saveByLibraryId
    * @param libraryId
    * @param list
    * @return
    */
    default boolean saveByLibraryId(String libraryId, List<TestPlan> list){
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<TestPlan> list);

    /**
    * findByProjectId
    * @param projectIds
    * @return
    */
    List<TestPlan> findByProjectId(List<String> projectIds);
    default List<TestPlan> findByProjectId(String projectId){
        return findByProjectId(Arrays.asList(projectId));
    }

    /**
    * removeByProjectId
    * @param projectId
    * @return
    */
    boolean removeByProjectId(String projectId);

    /**
    * resetByProjectId
    * @param projectId
    * @return
    */
    boolean resetByProjectId(String projectId);

    /**
    * saveByProjectId
    * @param projectId
    * @param list
    * @return
    */
    default boolean saveByProjectId(String projectId, List<TestPlan> list){
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<TestPlan> list);

    /**
    * findByReleaseId
    * @param releaseIds
    * @return
    */
    List<TestPlan> findByReleaseId(List<String> releaseIds);
    default List<TestPlan> findByReleaseId(String releaseId){
        return findByReleaseId(Arrays.asList(releaseId));
    }

    /**
    * removeByReleaseId
    * @param releaseId
    * @return
    */
    boolean removeByReleaseId(String releaseId);

    /**
    * resetByReleaseId
    * @param releaseId
    * @return
    */
    boolean resetByReleaseId(String releaseId);

    /**
    * saveByReleaseId
    * @param releaseId
    * @param list
    * @return
    */
    default boolean saveByReleaseId(String releaseId, List<TestPlan> list){
        return getSelf().saveByRelease(new Release().setId(releaseId),list);
    }

    /**
    * saveByRelease
    * @param release
    * @param list
    * @return
    */
    boolean saveByRelease(Release release, List<TestPlan> list);

    /**
    * findBySprintId
    * @param sprintIds
    * @return
    */
    List<TestPlan> findBySprintId(List<String> sprintIds);
    default List<TestPlan> findBySprintId(String sprintId){
        return findBySprintId(Arrays.asList(sprintId));
    }

    /**
    * removeBySprintId
    * @param sprintId
    * @return
    */
    boolean removeBySprintId(String sprintId);

    /**
    * resetBySprintId
    * @param sprintId
    * @return
    */
    boolean resetBySprintId(String sprintId);

    /**
    * saveBySprintId
    * @param sprintId
    * @param list
    * @return
    */
    default boolean saveBySprintId(String sprintId, List<TestPlan> list){
        return getSelf().saveBySprint(new Sprint().setId(sprintId),list);
    }

    /**
    * saveBySprint
    * @param sprint
    * @param list
    * @return
    */
    boolean saveBySprint(Sprint sprint, List<TestPlan> list);

    /**
    * findById
    * @param ids
    * @return
    */
    List<TestPlan> findById(List<String> ids);
    default List<TestPlan> findById(String id){
        return findById(Arrays.asList(id));
    }

    /**
    * removeById
    * @param id
    * @return
    */
    boolean removeById(String id);

    /**
    * resetById
    * @param id
    * @return
    */
    boolean resetById(String id);

    /**
    * saveById
    * @param id
    * @param list
    * @return
    */
    default boolean saveById(String id, List<TestPlan> list){
        return getSelf().saveByTestPlan(new CommonFlow().setId(id),list);
    }

    /**
    * saveByTestPlan
    * @param commonFlow
    * @param list
    * @return
    */
    boolean saveByTestPlan(CommonFlow commonFlow, List<TestPlan> list);

    default List<Relation> getWorkItemRelations(TestPlan et) {
        return new ArrayList<>();
    }

    /**
    * testPlanReportSurvey
    * 
    * @param et
    * @return
    */
    default TestPlan testPlanReportSurvey(TestPlan et) {
        return et;
    }


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}