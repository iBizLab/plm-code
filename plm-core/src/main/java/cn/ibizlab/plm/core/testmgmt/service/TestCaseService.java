/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.testmgmt.domain.CaseHistory;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 用例服务接口[TestCaseService]
 *
 * @author generator
 */
public interface TestCaseService extends IService<TestCase> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default TestCaseService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(TestCase et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<TestCase> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(TestCase et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<TestCase> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TestCase().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(TestCase et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<TestCase> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TestCase().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<TestCase> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default TestCase get(String key) {
        return getSelf().get(new TestCase().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    TestCase get(TestCase et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<TestCase> get(Collection<String> keys) {
        List<TestCase> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TestCase().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<TestCase> get(List<TestCase> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    TestCase getDraft(TestCase et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(TestCase et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(TestCase et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<TestCase> list);

    /**
    * caseMovePlan
    * 
    * @param et
    * @return
    */
    default TestCase caseMovePlan(TestCase et) {
        return et;
    }

    /**
    * chooseCaseTemplate
    * 
    * @param et
    * @return
    */
    default TestCase chooseCaseTemplate(TestCase et) {
        return et;
    }

    /**
    * copyCase
    * 
    * @param et
    * @return
    */
    default TestCase copyCase(TestCase et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default TestCase delete(TestCase et) {
        return et;
    }

    /**
    * fillBiFormDefault
    * 
    * @param et
    * @return
    */
    default TestCase fillBiFormDefault(TestCase et) {
        return et;
    }

    /**
    * getAttention
    * 
    * @param key
    * @return
    */
    default TestCase getAttention(String key) {
        return null;
    }

    /**
    * getBaselineName
    * 
    * @param key
    * @return
    */
    default TestCase getBaselineName(String key) {
        return getSelf().getBaselineName(new TestCase().setId(key));
    }

    /**
    * moveCase
    * 
    * @param et
    * @return
    */
    default TestCase moveCase(TestCase et) {
        return et;
    }

    /**
    * newestRun
    * 
    * @param key
    * @return
    */
    default TestCase newestRun(String key) {
        return getSelf().newestRun(new TestCase().setId(key));
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default TestCase nothing(TestCase et) {
        return et;
    }

    /**
    * othersRelationCase
    * 
    * @param et
    * @return
    */
    default TestCase othersRelationCase(TestCase et) {
        return et;
    }

    /**
    * programTestCase
    * 
    * @param et
    * @return
    */
    default TestCase programTestCase(TestCase et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default TestCase recover(TestCase et) {
        return et;
    }

    /**
    * setLevel
    * 
    * @param et
    * @return
    */
    default TestCase setLevel(TestCase et) {
        return et;
    }

    /**
    * setMaintenance
    * 
    * @param et
    * @return
    */
    default TestCase setMaintenance(TestCase et) {
        return et;
    }

    /**
    * setState
    * 
    * @param et
    * @return
    */
    default TestCase setState(TestCase et) {
        return et;
    }

    /**
    * testCaseReCounters
    * 
    * @param et
    * @return
    */
    default TestCase testCaseReCounters(TestCase et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchDefault(TestCaseSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<TestCase> listDefault(TestCaseSearchContext context);

    /**
    * fetchImplementationResults
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchImplementationResults(TestCaseSearchContext context);

    /**
    * listImplementationResults
    * 
    * @param context
    * @return
    */
    List<TestCase> listImplementationResults(TestCaseSearchContext context);

    /**
    * fetchPersonDistributions
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchPersonDistributions(TestCaseSearchContext context);

    /**
    * listPersonDistributions
    * 
    * @param context
    * @return
    */
    List<TestCase> listPersonDistributions(TestCaseSearchContext context);

    /**
    * fetchAdvancedSearch
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchAdvancedSearch(TestCaseSearchContext context);

    /**
    * listAdvancedSearch
    * 
    * @param context
    * @return
    */
    List<TestCase> listAdvancedSearch(TestCaseSearchContext context);

    /**
    * fetchAssessmentResult
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchAssessmentResult(TestCaseSearchContext context);

    /**
    * listAssessmentResult
    * 
    * @param context
    * @return
    */
    List<TestCase> listAssessmentResult(TestCaseSearchContext context);

    /**
    * fetchBaselineChooseCase
    * 基线选择用例
    * @param context
    * @return
    */
    Page<TestCase> fetchBaselineChooseCase(TestCaseSearchContext context);

    /**
    * listBaselineChooseCase
    * 基线选择用例
    * @param context
    * @return
    */
    List<TestCase> listBaselineChooseCase(TestCaseSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchBiDetail(TestCaseSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<TestCase> listBiDetail(TestCaseSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchBiSearch(TestCaseSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<TestCase> listBiSearch(TestCaseSearchContext context);

    /**
    * fetchCasePerson
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchCasePerson(TestCaseSearchContext context);

    /**
    * listCasePerson
    * 
    * @param context
    * @return
    */
    List<TestCase> listCasePerson(TestCaseSearchContext context);

    /**
    * fetchCaseType
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchCaseType(TestCaseSearchContext context);

    /**
    * listCaseType
    * 
    * @param context
    * @return
    */
    List<TestCase> listCaseType(TestCaseSearchContext context);

    /**
    * fetchCommentNotifyMaintenance
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchCommentNotifyMaintenance(TestCaseSearchContext context);

    /**
    * listCommentNotifyMaintenance
    * 
    * @param context
    * @return
    */
    List<TestCase> listCommentNotifyMaintenance(TestCaseSearchContext context);

    /**
    * fetchDailyTendencies
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchDailyTendencies(TestCaseSearchContext context);

    /**
    * listDailyTendencies
    * 
    * @param context
    * @return
    */
    List<TestCase> listDailyTendencies(TestCaseSearchContext context);

    /**
    * fetchDegreeImportance
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchDegreeImportance(TestCaseSearchContext context);

    /**
    * listDegreeImportance
    * 
    * @param context
    * @return
    */
    List<TestCase> listDegreeImportance(TestCaseSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchDeleted(TestCaseSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<TestCase> listDeleted(TestCaseSearchContext context);

    /**
    * fetchEverydayTest
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchEverydayTest(TestCaseSearchContext context);

    /**
    * listEverydayTest
    * 
    * @param context
    * @return
    */
    List<TestCase> listEverydayTest(TestCaseSearchContext context);

    /**
    * fetchIdeaRelationTestCase
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchIdeaRelationTestCase(TestCaseSearchContext context);

    /**
    * listIdeaRelationTestCase
    * 
    * @param context
    * @return
    */
    List<TestCase> listIdeaRelationTestCase(TestCaseSearchContext context);

    /**
    * fetchMyAssign
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchMyAssign(TestCaseSearchContext context);

    /**
    * listMyAssign
    * 
    * @param context
    * @return
    */
    List<TestCase> listMyAssign(TestCaseSearchContext context);

    /**
    * fetchMyAssigneeCountTestCase
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchMyAssigneeCountTestCase(TestCaseSearchContext context);

    /**
    * listMyAssigneeCountTestCase
    * 
    * @param context
    * @return
    */
    List<TestCase> listMyAssigneeCountTestCase(TestCaseSearchContext context);

    /**
    * fetchMyAttention
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchMyAttention(TestCaseSearchContext context);

    /**
    * listMyAttention
    * 
    * @param context
    * @return
    */
    List<TestCase> listMyAttention(TestCaseSearchContext context);

    /**
    * fetchMyCreated
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchMyCreated(TestCaseSearchContext context);

    /**
    * listMyCreated
    * 
    * @param context
    * @return
    */
    List<TestCase> listMyCreated(TestCaseSearchContext context);

    /**
    * fetchMyFilter
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchMyFilter(TestCaseSearchContext context);

    /**
    * listMyFilter
    * 
    * @param context
    * @return
    */
    List<TestCase> listMyFilter(TestCaseSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchNormal(TestCaseSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<TestCase> listNormal(TestCaseSearchContext context);

    /**
    * fetchNosuiteTestCase
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchNosuiteTestCase(TestCaseSearchContext context);

    /**
    * listNosuiteTestCase
    * 
    * @param context
    * @return
    */
    List<TestCase> listNosuiteTestCase(TestCaseSearchContext context);

    /**
    * fetchNotAddCase
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchNotAddCase(TestCaseSearchContext context);

    /**
    * listNotAddCase
    * 
    * @param context
    * @return
    */
    List<TestCase> listNotAddCase(TestCaseSearchContext context);

    /**
    * fetchNotExsistsRelation
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchNotExsistsRelation(TestCaseSearchContext context);

    /**
    * listNotExsistsRelation
    * 
    * @param context
    * @return
    */
    List<TestCase> listNotExsistsRelation(TestCaseSearchContext context);

    /**
    * fetchNotifyAssignee
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchNotifyAssignee(TestCaseSearchContext context);

    /**
    * listNotifyAssignee
    * 
    * @param context
    * @return
    */
    List<TestCase> listNotifyAssignee(TestCaseSearchContext context);

    /**
    * fetchPriorityDistributions
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchPriorityDistributions(TestCaseSearchContext context);

    /**
    * listPriorityDistributions
    * 
    * @param context
    * @return
    */
    List<TestCase> listPriorityDistributions(TestCaseSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchReader(TestCaseSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<TestCase> listReader(TestCaseSearchContext context);

    /**
    * fetchRecentTestCase
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchRecentTestCase(TestCaseSearchContext context);

    /**
    * listRecentTestCase
    * 
    * @param context
    * @return
    */
    List<TestCase> listRecentTestCase(TestCaseSearchContext context);

    /**
    * fetchSuitesTestCase
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchSuitesTestCase(TestCaseSearchContext context);

    /**
    * listSuitesTestCase
    * 
    * @param context
    * @return
    */
    List<TestCase> listSuitesTestCase(TestCaseSearchContext context);

    /**
    * fetchWorkItemRelationTestCase
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchWorkItemRelationTestCase(TestCaseSearchContext context);

    /**
    * listWorkItemRelationTestCase
    * 
    * @param context
    * @return
    */
    List<TestCase> listWorkItemRelationTestCase(TestCaseSearchContext context);

    /**
    * findByTestLibraryId
    * @param testLibraryIds
    * @return
    */
    List<TestCase> findByTestLibraryId(List<String> testLibraryIds);
    default List<TestCase> findByTestLibraryId(String testLibraryId){
        return findByLibrary(new Library().setId(testLibraryId));
    }

    /**
    * findByLibrary
    * @param library
    * @return
    */
    List<TestCase> findByLibrary(Library library);

    /**
    * removeByTestLibraryId
    * @param testLibraryId
    * @return
    */
    boolean removeByTestLibraryId(String testLibraryId);

    /**
    * resetByTestLibraryId
    * @param testLibraryId
    * @return
    */
    boolean resetByTestLibraryId(String testLibraryId);

    /**
    * saveByTestLibraryId
    * @param testLibraryId
    * @param list
    * @return
    */
    default boolean saveByTestLibraryId(String testLibraryId, List<TestCase> list){
        return getSelf().saveByLibrary(new Library().setId(testLibraryId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<TestCase> list);

    /**
    * findBySuiteId
    * @param suiteIds
    * @return
    */
    List<TestCase> findBySuiteId(List<String> suiteIds);
    default List<TestCase> findBySuiteId(String suiteId){
        return findByTestSuite(new TestSuite().setId(suiteId));
    }

    /**
    * findByTestSuite
    * @param testSuite
    * @return
    */
    List<TestCase> findByTestSuite(TestSuite testSuite);

    /**
    * removeBySuiteId
    * @param suiteId
    * @return
    */
    boolean removeBySuiteId(String suiteId);

    /**
    * resetBySuiteId
    * @param suiteId
    * @return
    */
    boolean resetBySuiteId(String suiteId);

    /**
    * saveBySuiteId
    * @param suiteId
    * @param list
    * @return
    */
    default boolean saveBySuiteId(String suiteId, List<TestCase> list){
        return getSelf().saveByTestSuite(new TestSuite().setId(suiteId),list);
    }

    /**
    * saveByTestSuite
    * @param testSuite
    * @param list
    * @return
    */
    boolean saveByTestSuite(TestSuite testSuite, List<TestCase> list);

    /**
    * findByMaintenanceId
    * @param maintenanceIds
    * @return
    */
    List<TestCase> findByMaintenanceId(List<String> maintenanceIds);
    default List<TestCase> findByMaintenanceId(String maintenanceId){
        return findByUser(new User().setId(maintenanceId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<TestCase> findByUser(User user);

    /**
    * removeByMaintenanceId
    * @param maintenanceId
    * @return
    */
    boolean removeByMaintenanceId(String maintenanceId);

    /**
    * resetByMaintenanceId
    * @param maintenanceId
    * @return
    */
    boolean resetByMaintenanceId(String maintenanceId);

    /**
    * saveByMaintenanceId
    * @param maintenanceId
    * @param list
    * @return
    */
    default boolean saveByMaintenanceId(String maintenanceId, List<TestCase> list){
        return getSelf().saveByUser(new User().setId(maintenanceId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<TestCase> list);

    default List<Attention> getAttentions(TestCase et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(TestCase et) {
        return new ArrayList<>();
    }

    /**
    * getBaselineName
    * 
    * @param et
    * @return
    */
    default TestCase getBaselineName(TestCase et) {
        return et;
    }

    /**
    * newestRun
    * 
    * @param et
    * @return
    */
    default TestCase newestRun(TestCase et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<TestCase> fetchView(TestCaseSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<TestCase> listView(TestCaseSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<TestCase> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            TestCase et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getTitle(),ex.getMessage());
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
    default TestCase getEntity() {
        return new TestCase();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default TestCaseSearchContext getSearchContext() {
        return new TestCaseSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}