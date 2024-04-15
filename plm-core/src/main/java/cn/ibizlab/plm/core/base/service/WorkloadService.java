/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 工时服务接口[WorkloadService]
 *
 * @author generator
 */
public interface WorkloadService extends IService<Workload> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default WorkloadService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Workload get(Workload et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Workload get(String key) {
        return getSelf().get(new Workload().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Workload> getByIds(Collection<String> ids) {
        List<Workload> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Workload().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Workload> getByEntities(List<Workload> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Workload getDraft(Workload et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Workload et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Workload et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Workload> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Workload et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Workload> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Workload et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Workload> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Workload().setId(key));
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
    boolean remove(Workload et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Workload> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Workload().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Workload> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Workload> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Workload et=list.get(i);
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
     * create_workload
     * 
     * @param dto
     * @return
     */
    default Workload createWorkload(Workload dto) {
        return dto;
    }

    /**
     * get_register_workload
     * 修改实际工时表单获取数据行为
     * @param key
     * @return
     */
    default Workload getRegisterWorkload(String key) {
        return getSelf().getRegisterWorkload(new Workload().setId(key));
    }

    /**
     * update_workload
     * 
     * @param dto
     * @return
     */
    default Workload updateWorkload(Workload dto) {
        return dto;
    }

    /**
     * get_register_workload
     * 修改实际工时表单获取数据行为
     * @param et
     * @return
     */
    default Workload getRegisterWorkload(Workload et) {
        return et;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Workload> searchDefault(WorkloadSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Workload> listDefault(WorkloadSearchContext context);

    /**
     * searchcalendar
     * 
     * @param context
     * @return
     */
    Page<Workload> searchCalendar(WorkloadSearchContext context);
    /**
     * listcalendar
     * 
     * @param context
     * @return
     */
    List<Workload> listCalendar(WorkloadSearchContext context);

    /**
     * searchidea_workload
     * 
     * @param context
     * @return
     */
    Page<Workload> searchIdeaWorkload(WorkloadSearchContext context);
    /**
     * listidea_workload
     * 
     * @param context
     * @return
     */
    List<Workload> listIdeaWorkload(WorkloadSearchContext context);

    /**
     * searchlog
     * 
     * @param context
     * @return
     */
    Page<Workload> searchLog(WorkloadSearchContext context);
    /**
     * listlog
     * 
     * @param context
     * @return
     */
    List<Workload> listLog(WorkloadSearchContext context);

    /**
     * searchmy_calendar
     * 
     * @param context
     * @return
     */
    Page<Workload> searchMyCalendar(WorkloadSearchContext context);
    /**
     * listmy_calendar
     * 
     * @param context
     * @return
     */
    List<Workload> listMyCalendar(WorkloadSearchContext context);

    /**
     * searchmy_idea_workload
     * 
     * @param context
     * @return
     */
    Page<Workload> searchMyIdeaWorkload(WorkloadSearchContext context);
    /**
     * listmy_idea_workload
     * 
     * @param context
     * @return
     */
    List<Workload> listMyIdeaWorkload(WorkloadSearchContext context);

    /**
     * searchmy_log
     * 
     * @param context
     * @return
     */
    Page<Workload> searchMyLog(WorkloadSearchContext context);
    /**
     * listmy_log
     * 
     * @param context
     * @return
     */
    List<Workload> listMyLog(WorkloadSearchContext context);

    /**
     * searchmy_test_case_workload
     * 
     * @param context
     * @return
     */
    Page<Workload> searchMyTestCaseWorkload(WorkloadSearchContext context);
    /**
     * listmy_test_case_workload
     * 
     * @param context
     * @return
     */
    List<Workload> listMyTestCaseWorkload(WorkloadSearchContext context);

    /**
     * searchmy_type_of
     * 
     * @param context
     * @return
     */
    Page<Workload> searchMyTypeOf(WorkloadSearchContext context);
    /**
     * listmy_type_of
     * 
     * @param context
     * @return
     */
    List<Workload> listMyTypeOf(WorkloadSearchContext context);

    /**
     * searchmy_work_item_workload
     * 
     * @param context
     * @return
     */
    Page<Workload> searchMyWorkItemWorkload(WorkloadSearchContext context);
    /**
     * listmy_work_item_workload
     * 
     * @param context
     * @return
     */
    List<Workload> listMyWorkItemWorkload(WorkloadSearchContext context);

    /**
     * searchtest_case_workload
     * 
     * @param context
     * @return
     */
    Page<Workload> searchTestCaseWorkload(WorkloadSearchContext context);
    /**
     * listtest_case_workload
     * 
     * @param context
     * @return
     */
    List<Workload> listTestCaseWorkload(WorkloadSearchContext context);

    /**
     * searchtype_of
     * 
     * @param context
     * @return
     */
    Page<Workload> searchTypeOf(WorkloadSearchContext context);
    /**
     * listtype_of
     * 
     * @param context
     * @return
     */
    List<Workload> listTypeOf(WorkloadSearchContext context);

    /**
     * searchwork_item_workload
     * 
     * @param context
     * @return
     */
    Page<Workload> searchWorkItemWorkload(WorkloadSearchContext context);
    /**
     * listwork_item_workload
     * 
     * @param context
     * @return
     */
    List<Workload> listWorkItemWorkload(WorkloadSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Workload getEntity() {
        return new Workload();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default WorkloadSearchContext getSearchContext() {
        return new WorkloadSearchContext();
    }
    /**
     * selectRelByTypeId
     * @param typeIds
     * @return
     */
    List<Workload> findByTypeId(List<String> typeIds);
    default List<Workload> findByTypeId(String typeId) {
        return findByTypeId(Arrays.asList(typeId));
    }
    /**
     * removeRelByTypeId
     * @param typeId
     * @return
     */
    boolean removeByTypeId(String typeId);
    /**
     * resetRelByTypeId
     * @param typeId
     * @return
     */
    boolean resetByTypeId(String typeId);
    /**
     * saveRelByTypeId
     * @param typeId
     * @param list
     * @return
     */
    default boolean saveByTypeId(String typeId,List<Workload> list) {
        return getSelf().saveByWorkloadType(new WorkloadType().setId(typeId),list);
    }
    /**
    * saveRelByWorkloadType
    * @param workloadType
    * @param list
    * @return
    */
    boolean saveByWorkloadType(WorkloadType workloadType,List<Workload> list);

    /**
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<Workload> findByPrincipalId(List<String> principalIds);
    default List<Workload> findByPrincipalId(String principalId) {
        return findByPrincipalId(Arrays.asList(principalId));
    }
    /**
     * removeRelByPrincipalId
     * @param principalId
     * @return
     */
    boolean removeByPrincipalId(String principalId);
    /**
     * resetRelByPrincipalId
     * @param principalId
     * @return
     */
    boolean resetByPrincipalId(String principalId);
    /**
     * saveRelByPrincipalId
     * @param principalId
     * @param list
     * @return
     */
    default boolean saveByPrincipalId(String principalId,List<Workload> list) {
        return getSelf().saveByRelIdea(new Idea().setId(principalId),list);
    }
    /**
    * saveRelByRelIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByRelIdea(Idea idea,List<Workload> list);

    /**
    * saveRelByRelTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByRelTestCase(TestCase testCase,List<Workload> list);

    /**
    * saveRelByRelWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByRelWorkItem(WorkItem workItem,List<Workload> list);


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