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
import cn.ibizlab.plm.core.base.domain.Attachment;

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
     * 获取
     * @param et
     * @return
     */
    TestCase get(TestCase et);
    /**
     * 获取
     * @param key
     * @return
     */
    default TestCase get(String key) {
        return getSelf().get(new TestCase().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<TestCase> getByIds(Collection<String> ids) {
        List<TestCase> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TestCase().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<TestCase> getByEntities(List<TestCase> entities);

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
    Integer checkKey(TestCase et);

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
    boolean createBatch(List<TestCase> list);

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
    boolean updateBatch(List<TestCase> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(TestCase et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<TestCase> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TestCase().setId(key));
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
    boolean remove(TestCase et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<TestCase> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TestCase().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<TestCase> entities);

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
     * Case_move_plan
     * 
     * @param dto
     * @return
     */
    default TestCase caseMovePlan(TestCase dto) {
        return dto;
    }

    /**
     * Copy_case
     * 
     * @param dto
     * @return
     */
    default TestCase copyCase(TestCase dto) {
        return dto;
    }

    /**
     * Del_relation
     * 
     * @param dto
     * @return
     */
    default TestCase delRelation(TestCase dto) {
        return dto;
    }

    /**
     * Delete
     * 
     * @param dto
     * @return
     */
    default TestCase delete(TestCase dto) {
        return dto;
    }

    /**
     * Get_actual_workload
     * 
     * @param key
     * @return
     */
    default TestCase getActualWorkload(String key) {
        return null;
    }

    /**
     * Move_case
     * 
     * @param dto
     * @return
     */
    default TestCase moveCase(TestCase dto) {
        return dto;
    }

    /**
     * Newest_run
     * 
     * @param key
     * @return
     */
    default TestCase newestRun(String key) {
        return null;
    }

    /**
     * Nothing
     * 
     * @param dto
     * @return
     */
    default TestCase nothing(TestCase dto) {
        return dto;
    }

    /**
     * Others_relation_case
     * 
     * @param dto
     * @return
     */
    default TestCase othersRelationCase(TestCase dto) {
        return dto;
    }

    /**
     * Recover
     * 
     * @param dto
     * @return
     */
    default TestCase recover(TestCase dto) {
        return dto;
    }

    /**
     * Set_level
     * 
     * @param dto
     * @return
     */
    default TestCase setLevel(TestCase dto) {
        return dto;
    }

    /**
     * Set_maintenance
     * 
     * @param dto
     * @return
     */
    default TestCase setMaintenance(TestCase dto) {
        return dto;
    }

    /**
     * Set_state
     * 
     * @param dto
     * @return
     */
    default TestCase setState(TestCase dto) {
        return dto;
    }

    /**
     * Test_case_re_counters
     * 
     * @param dto
     * @return
     */
    default TestCase testCaseReCounters(TestCase dto) {
        return dto;
    }

    /**
     * searchComment_notify_maintenance
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchCommentNotifyMaintenance(TestCaseSearchContext context);
    /**
     * listComment_notify_maintenance
     * 
     * @param context
     * @return
     */
    List<TestCase> listCommentNotifyMaintenance(TestCaseSearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchDefault(TestCaseSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<TestCase> listDefault(TestCaseSearchContext context);

    /**
     * searchDeleted
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchDeleted(TestCaseSearchContext context);
    /**
     * listDeleted
     * 
     * @param context
     * @return
     */
    List<TestCase> listDeleted(TestCaseSearchContext context);

    /**
     * searchIdea_relation_test_case
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchIdeaRelationTestCase(TestCaseSearchContext context);
    /**
     * listIdea_relation_test_case
     * 
     * @param context
     * @return
     */
    List<TestCase> listIdeaRelationTestCase(TestCaseSearchContext context);

    /**
     * searchMy_assign
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchMyAssign(TestCaseSearchContext context);
    /**
     * listMy_assign
     * 
     * @param context
     * @return
     */
    List<TestCase> listMyAssign(TestCaseSearchContext context);

    /**
     * searchMy_assignee_count_test_case
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchMyAssigneeCountTestCase(TestCaseSearchContext context);
    /**
     * listMy_assignee_count_test_case
     * 
     * @param context
     * @return
     */
    List<TestCase> listMyAssigneeCountTestCase(TestCaseSearchContext context);

    /**
     * searchMy_attention
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchMyAttention(TestCaseSearchContext context);
    /**
     * listMy_attention
     * 
     * @param context
     * @return
     */
    List<TestCase> listMyAttention(TestCaseSearchContext context);

    /**
     * searchMy_created
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchMyCreated(TestCaseSearchContext context);
    /**
     * listMy_created
     * 
     * @param context
     * @return
     */
    List<TestCase> listMyCreated(TestCaseSearchContext context);

    /**
     * searchNormal
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchNormal(TestCaseSearchContext context);
    /**
     * listNormal
     * 
     * @param context
     * @return
     */
    List<TestCase> listNormal(TestCaseSearchContext context);

    /**
     * searchNosuite_test_case
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchNosuiteTestCase(TestCaseSearchContext context);
    /**
     * listNosuite_test_case
     * 
     * @param context
     * @return
     */
    List<TestCase> listNosuiteTestCase(TestCaseSearchContext context);

    /**
     * searchNot_add_case
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchNotAddCase(TestCaseSearchContext context);
    /**
     * listNot_add_case
     * 
     * @param context
     * @return
     */
    List<TestCase> listNotAddCase(TestCaseSearchContext context);

    /**
     * searchNot_exsists_relation
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchNotExsistsRelation(TestCaseSearchContext context);
    /**
     * listNot_exsists_relation
     * 
     * @param context
     * @return
     */
    List<TestCase> listNotExsistsRelation(TestCaseSearchContext context);

    /**
     * searchRecent_test_case
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchRecentTestCase(TestCaseSearchContext context);
    /**
     * listRecent_test_case
     * 
     * @param context
     * @return
     */
    List<TestCase> listRecentTestCase(TestCaseSearchContext context);

    /**
     * searchSuites_test_case
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchSuitesTestCase(TestCaseSearchContext context);
    /**
     * listSuites_test_case
     * 
     * @param context
     * @return
     */
    List<TestCase> listSuitesTestCase(TestCaseSearchContext context);

    /**
     * searchWork_item_relation_test_case
     * 
     * @param context
     * @return
     */
    Page<TestCase> searchWorkItemRelationTestCase(TestCaseSearchContext context);
    /**
     * listWork_item_relation_test_case
     * 
     * @param context
     * @return
     */
    List<TestCase> listWorkItemRelationTestCase(TestCaseSearchContext context);

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
     * selectRelByTestLibraryId
     * @param testLibraryIds
     * @return
     */
    List<TestCase> findByTestLibraryId(List<String> testLibraryIds);
    default List<TestCase> findByTestLibraryId(String testLibraryId) {
        return findByTestLibraryId(Arrays.asList(testLibraryId));
    }
    /**
     * removeRelByTestLibraryId
     * @param testLibraryId
     * @return
     */
    boolean removeByTestLibraryId(String testLibraryId);
    /**
     * resetRelByTestLibraryId
     * @param testLibraryId
     * @return
     */
    boolean resetByTestLibraryId(String testLibraryId);
    /**
     * saveRelByTestLibraryId
     * @param testLibraryId
     * @param list
     * @return
     */
    default boolean saveByTestLibraryId(String testLibraryId,List<TestCase> list) {
        return getSelf().saveByLibrary(new Library().setId(testLibraryId),list);
    }
    /**
    * saveRelByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library,List<TestCase> list);

    /**
     * selectRelBySuiteId
     * @param suiteIds
     * @return
     */
    List<TestCase> findBySuiteId(List<String> suiteIds);
    default List<TestCase> findBySuiteId(String suiteId) {
        return findBySuiteId(Arrays.asList(suiteId));
    }
    /**
     * removeRelBySuiteId
     * @param suiteId
     * @return
     */
    boolean removeBySuiteId(String suiteId);
    /**
     * resetRelBySuiteId
     * @param suiteId
     * @return
     */
    boolean resetBySuiteId(String suiteId);
    /**
     * saveRelBySuiteId
     * @param suiteId
     * @param list
     * @return
     */
    default boolean saveBySuiteId(String suiteId,List<TestCase> list) {
        return getSelf().saveByTestSuite(new TestSuite().setId(suiteId),list);
    }
    /**
    * saveRelByTestSuite
    * @param testSuite
    * @param list
    * @return
    */
    boolean saveByTestSuite(TestSuite testSuite,List<TestCase> list);

    /**
     * selectRelByMaintenanceId
     * @param maintenanceIds
     * @return
     */
    List<TestCase> findByMaintenanceId(List<String> maintenanceIds);
    default List<TestCase> findByMaintenanceId(String maintenanceId) {
        return findByMaintenanceId(Arrays.asList(maintenanceId));
    }
    /**
     * removeRelByMaintenanceId
     * @param maintenanceId
     * @return
     */
    boolean removeByMaintenanceId(String maintenanceId);
    /**
     * resetRelByMaintenanceId
     * @param maintenanceId
     * @return
     */
    boolean resetByMaintenanceId(String maintenanceId);
    /**
     * saveRelByMaintenanceId
     * @param maintenanceId
     * @param list
     * @return
     */
    default boolean saveByMaintenanceId(String maintenanceId,List<TestCase> list) {
        return getSelf().saveByUser(new User().setId(maintenanceId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<TestCase> list);

    default List<Attention> getAttentions(TestCase et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(TestCase et) {
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