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
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.filter.RunSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Attachment;

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
     * 获取
     * @param et
     * @return
     */
    Run get(Run et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Run get(String key) {
        return getSelf().get(new Run().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Run> getByIds(Collection<String> ids) {
        List<Run> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Run().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Run> getByEntities(List<Run> entities);

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
    Integer checkKey(Run et);

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
    boolean createBatch(List<Run> list);

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
    boolean updateBatch(List<Run> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Run et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Run> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Run().setId(key));
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
    boolean remove(Run et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Run> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Run().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Run> entities);

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
     * Add_plan_run
     * 
     * @param dto
     * @return
     */
    default Run addPlanRun(Run dto) {
        return dto;
    }

    /**
     * Batch_save_run_history
     * 
     * @param dto
     * @return
     */
    default Run batchSaveRunHistory(Run dto) {
        return dto;
    }

    /**
     * Delete_run_info
     * 
     * @param dto
     * @return
     */
    default Run deleteRunInfo(Run dto) {
        return dto;
    }

    /**
     * Get_actual_workload
     * 
     * @param key
     * @return
     */
    default Run getActualWorkload(String key) {
        return getSelf().getActualWorkload(new Run().setId(key));
    }

    /**
     * Nothing
     * 
     * @param dto
     * @return
     */
    default Run nothing(Run dto) {
        return dto;
    }

    /**
     * Program_plan
     * 
     * @param dto
     * @return
     */
    default Run programPlan(Run dto) {
        return dto;
    }

    /**
     * Reset_not_test
     * 
     * @param dto
     * @return
     */
    default Run resetNotTest(Run dto) {
        return dto;
    }

    /**
     * Run_history_get
     * 
     * @param dto
     * @return
     */
    default Run runHistoryGet(Run dto) {
        return dto;
    }

    /**
     * Run_re_counters
     * 
     * @param dto
     * @return
     */
    default Run runReCounters(Run dto) {
        return dto;
    }

    /**
     * Save_run_history
     * 
     * @param dto
     * @return
     */
    default Run saveRunHistory(Run dto) {
        return dto;
    }

    /**
     * Set_executor
     * 
     * @param dto
     * @return
     */
    default Run setExecutor(Run dto) {
        return dto;
    }

    /**
     * This_run_details
     * 
     * @param key
     * @return
     */
    default Run thisRunDetails(String key) {
        return getSelf().thisRunDetails(new Run().setId(key));
    }

    /**
     * Get_actual_workload
     * 
     * @param et
     * @return
     */
    default Run getActualWorkload(Run et) {
        return et;
    }

    /**
     * This_run_details
     * 
     * @param et
     * @return
     */
    default Run thisRunDetails(Run et) {
        return et;
    }

    /**
     * searchComment_notify_executor
     * 
     * @param context
     * @return
     */
    Page<Run> searchCommentNotifyExecutor(RunSearchContext context);
    /**
     * listComment_notify_executor
     * 
     * @param context
     * @return
     */
    List<Run> listCommentNotifyExecutor(RunSearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Run> searchDefault(RunSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Run> listDefault(RunSearchContext context);

    /**
     * searchNormal
     * 
     * @param context
     * @return
     */
    Page<Run> searchNormal(RunSearchContext context);
    /**
     * listNormal
     * 
     * @param context
     * @return
     */
    List<Run> listNormal(RunSearchContext context);

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
     * selectRelByCaseId
     * @param caseIds
     * @return
     */
    List<Run> findByCaseId(List<String> caseIds);
    default List<Run> findByCaseId(String caseId) {
        return findByCaseId(Arrays.asList(caseId));
    }
    /**
     * removeRelByCaseId
     * @param caseId
     * @return
     */
    boolean removeByCaseId(String caseId);
    /**
     * resetRelByCaseId
     * @param caseId
     * @return
     */
    boolean resetByCaseId(String caseId);
    /**
     * saveRelByCaseId
     * @param caseId
     * @param list
     * @return
     */
    default boolean saveByCaseId(String caseId,List<Run> list) {
        return getSelf().saveByTestCase(new TestCase().setId(caseId),list);
    }
    /**
    * saveRelByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase,List<Run> list);

    /**
     * selectRelByPlanId
     * @param planIds
     * @return
     */
    List<Run> findByPlanId(List<String> planIds);
    default List<Run> findByPlanId(String planId) {
        return findByPlanId(Arrays.asList(planId));
    }
    /**
     * removeRelByPlanId
     * @param planId
     * @return
     */
    boolean removeByPlanId(String planId);
    /**
     * resetRelByPlanId
     * @param planId
     * @return
     */
    boolean resetByPlanId(String planId);
    /**
     * saveRelByPlanId
     * @param planId
     * @param list
     * @return
     */
    default boolean saveByPlanId(String planId,List<Run> list) {
        return getSelf().saveByTestPlan(new TestPlan().setId(planId),list);
    }
    /**
    * saveRelByTestPlan
    * @param testPlan
    * @param list
    * @return
    */
    boolean saveByTestPlan(TestPlan testPlan,List<Run> list);

    default List<RunHistory> getRunHistories(Run et) {
        return new ArrayList<>();
    }

    default List<Attention> getAttentions(Run et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(Run et) {
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