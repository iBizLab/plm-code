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
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.filter.RunSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.testmgmt.domain.RunAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;

/**
 * 执行用例服务接口[RunService]
 *
 * @author generator
 */
public interface RunService extends IService<Run> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default RunService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Run et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Run> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Run et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Run> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Run().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Run et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Run> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Run().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Run> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Run get(String key) {
        return getSelf().get(new Run().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Run get(Run et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Run> get(Collection<String> keys) {
        List<Run> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Run().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Run> get(List<Run> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Run getDraft(Run et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Run et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Run et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Run> list);

    /**
    * addPlanRun
    * 
    * @param et
    * @return
    */
    default Run addPlanRun(Run et) {
        return et;
    }

    /**
    * batchSaveRunHistory
    * 
    * @param et
    * @return
    */
    default Run batchSaveRunHistory(Run et) {
        return et;
    }

    /**
    * getActualWorkload
    * 
    * @param key
    * @return
    */
    default Run getActualWorkload(String key) {
        return getSelf().getActualWorkload(new Run().setId(key));
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Run nothing(Run et) {
        return et;
    }

    /**
    * otherRelationRun
    * 
    * @param et
    * @return
    */
    default Run otherRelationRun(Run et) {
        return et;
    }

    /**
    * programPlan
    * 
    * @param et
    * @return
    */
    default Run programPlan(Run et) {
        return et;
    }

    /**
    * resetNotTest
    * 
    * @param et
    * @return
    */
    default Run resetNotTest(Run et) {
        return et;
    }

    /**
    * runHistoryGet
    * 
    * @param et
    * @return
    */
    default Run runHistoryGet(Run et) {
        return et;
    }

    /**
    * runReCounters
    * 
    * @param et
    * @return
    */
    default Run runReCounters(Run et) {
        return et;
    }

    /**
    * saveRunHistory
    * 
    * @param et
    * @return
    */
    default Run saveRunHistory(Run et) {
        return et;
    }

    /**
    * setExecutor
    * 
    * @param et
    * @return
    */
    default Run setExecutor(Run et) {
        return et;
    }

    /**
    * thisRunDetails
    * 
    * @param key
    * @return
    */
    default Run thisRunDetails(String key) {
        return getSelf().thisRunDetails(new Run().setId(key));
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Run> fetchDefault(RunSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Run> listDefault(RunSearchContext context);

    /**
    * fetchImplementationResults
    * 
    * @param context
    * @return
    */
    Page<Run> fetchImplementationResults(RunSearchContext context);

    /**
    * listImplementationResults
    * 
    * @param context
    * @return
    */
    List<Run> listImplementationResults(RunSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<Run> fetchBiDetail(RunSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<Run> listBiDetail(RunSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<Run> fetchBiSearch(RunSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<Run> listBiSearch(RunSearchContext context);

    /**
    * fetchCasePerson
    * 
    * @param context
    * @return
    */
    Page<Run> fetchCasePerson(RunSearchContext context);

    /**
    * listCasePerson
    * 
    * @param context
    * @return
    */
    List<Run> listCasePerson(RunSearchContext context);

    /**
    * fetchCommentNotifyExecutor
    * 
    * @param context
    * @return
    */
    Page<Run> fetchCommentNotifyExecutor(RunSearchContext context);

    /**
    * listCommentNotifyExecutor
    * 
    * @param context
    * @return
    */
    List<Run> listCommentNotifyExecutor(RunSearchContext context);

    /**
    * fetchMyFilter
    * 
    * @param context
    * @return
    */
    Page<Run> fetchMyFilter(RunSearchContext context);

    /**
    * listMyFilter
    * 
    * @param context
    * @return
    */
    List<Run> listMyFilter(RunSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<Run> fetchNormal(RunSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<Run> listNormal(RunSearchContext context);

    /**
    * fetchPlanRunHistory
    * 
    * @param context
    * @return
    */
    Page<Run> fetchPlanRunHistory(RunSearchContext context);

    /**
    * listPlanRunHistory
    * 
    * @param context
    * @return
    */
    List<Run> listPlanRunHistory(RunSearchContext context);

    /**
    * fetchPriorityDistributions
    * 
    * @param context
    * @return
    */
    Page<Run> fetchPriorityDistributions(RunSearchContext context);

    /**
    * listPriorityDistributions
    * 
    * @param context
    * @return
    */
    List<Run> listPriorityDistributions(RunSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Run> fetchReader(RunSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Run> listReader(RunSearchContext context);

    /**
    * findByCaseId
    * @param caseIds
    * @return
    */
    List<Run> findByCaseId(List<String> caseIds);
    default List<Run> findByCaseId(String caseId){
        return findByTestCase(new TestCase().setId(caseId));
    }

    /**
    * findByTestCase
    * @param testCase
    * @return
    */
    List<Run> findByTestCase(TestCase testCase);

    /**
    * removeByCaseId
    * @param caseId
    * @return
    */
    boolean removeByCaseId(String caseId);

    /**
    * resetByCaseId
    * @param caseId
    * @return
    */
    boolean resetByCaseId(String caseId);

    /**
    * saveByCaseId
    * @param caseId
    * @param list
    * @return
    */
    default boolean saveByCaseId(String caseId, List<Run> list){
        return getSelf().saveByTestCase(new TestCase().setId(caseId),list);
    }

    /**
    * saveByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase, List<Run> list);

    /**
    * findByPlanId
    * @param planIds
    * @return
    */
    List<Run> findByPlanId(List<String> planIds);
    default List<Run> findByPlanId(String planId){
        return findByTestPlan(new TestPlan().setId(planId));
    }

    /**
    * findByTestPlan
    * @param testPlan
    * @return
    */
    List<Run> findByTestPlan(TestPlan testPlan);

    /**
    * removeByPlanId
    * @param planId
    * @return
    */
    boolean removeByPlanId(String planId);

    /**
    * resetByPlanId
    * @param planId
    * @return
    */
    boolean resetByPlanId(String planId);

    /**
    * saveByPlanId
    * @param planId
    * @param list
    * @return
    */
    default boolean saveByPlanId(String planId, List<Run> list){
        return getSelf().saveByTestPlan(new TestPlan().setId(planId),list);
    }

    /**
    * saveByTestPlan
    * @param testPlan
    * @param list
    * @return
    */
    boolean saveByTestPlan(TestPlan testPlan, List<Run> list);

    default List<Attention> getAttentions(Run et) {
        return new ArrayList<>();
    }

    default List<RunAttachment> getRunAttachment(Run et) {
        return new ArrayList<>();
    }

    /**
    * getActualWorkload
    * 
    * @param et
    * @return
    */
    default Run getActualWorkload(Run et) {
        return et;
    }

    /**
    * thisRunDetails
    * 
    * @param et
    * @return
    */
    default Run thisRunDetails(Run et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Run> fetchView(RunSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Run> listView(RunSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Run> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Run et=list.get(i);
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
    default Run getEntity() {
        return new Run();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default RunSearchContext getSearchContext() {
        return new RunSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}