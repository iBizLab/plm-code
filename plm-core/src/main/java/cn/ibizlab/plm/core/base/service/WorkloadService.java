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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.util.annotation.DEAction;

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
    boolean create(List<Workload> list);

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
    boolean update(List<Workload> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Workload().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Workload et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Workload> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Workload().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Workload> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Workload get(String key) {
        return getSelf().get(new Workload().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Workload get(Workload et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Workload> get(Collection<String> keys) {
        List<Workload> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Workload().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Workload> get(List<Workload> entities);

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
    CheckKeyStatus checkKey(Workload et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Workload et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Workload> list);

    /**
    * createWorkload
    * 
    * @param et
    * @return
    */
    default Workload createWorkload(Workload et) {
        return et;
    }

    /**
    * fillBiFormDefault
    * 
    * @param et
    * @return
    */
    default Workload fillBiFormDefault(Workload et) {
        return et;
    }

    /**
    * fillWorkloadData
    * 
    * @param et
    * @return
    */
    default Workload fillWorkloadData(Workload et) {
        return et;
    }

    /**
    * getRegisterWorkload
    * 修改实际工时表单获取数据行为
    * @param key
    * @return
    */
    default Workload getRegisterWorkload(String key) {
        return getSelf().getRegisterWorkload(new Workload().setId(key));
    }

    /**
    * updateWorkload
    * 
    * @param et
    * @return
    */
    default Workload updateWorkload(Workload et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchDefault(WorkloadSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Workload> listDefault(WorkloadSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchBiDetail(WorkloadSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<Workload> listBiDetail(WorkloadSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchBiSearch(WorkloadSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<Workload> listBiSearch(WorkloadSearchContext context);

    /**
    * fetchCalendar
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchCalendar(WorkloadSearchContext context);

    /**
    * listCalendar
    * 
    * @param context
    * @return
    */
    List<Workload> listCalendar(WorkloadSearchContext context);

    /**
    * fetchIdeaWorkload
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchIdeaWorkload(WorkloadSearchContext context);

    /**
    * listIdeaWorkload
    * 
    * @param context
    * @return
    */
    List<Workload> listIdeaWorkload(WorkloadSearchContext context);

    /**
    * fetchLog
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchLog(WorkloadSearchContext context);

    /**
    * listLog
    * 
    * @param context
    * @return
    */
    List<Workload> listLog(WorkloadSearchContext context);

    /**
    * fetchMemberDimension
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchMemberDimension(WorkloadSearchContext context);

    /**
    * listMemberDimension
    * 
    * @param context
    * @return
    */
    List<Workload> listMemberDimension(WorkloadSearchContext context);

    /**
    * fetchMobCalendar
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchMobCalendar(WorkloadSearchContext context);

    /**
    * listMobCalendar
    * 
    * @param context
    * @return
    */
    List<Workload> listMobCalendar(WorkloadSearchContext context);

    /**
    * fetchMyCalendar
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchMyCalendar(WorkloadSearchContext context);

    /**
    * listMyCalendar
    * 
    * @param context
    * @return
    */
    List<Workload> listMyCalendar(WorkloadSearchContext context);

    /**
    * fetchMyIdeaWorkload
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchMyIdeaWorkload(WorkloadSearchContext context);

    /**
    * listMyIdeaWorkload
    * 
    * @param context
    * @return
    */
    List<Workload> listMyIdeaWorkload(WorkloadSearchContext context);

    /**
    * fetchMyLog
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchMyLog(WorkloadSearchContext context);

    /**
    * listMyLog
    * 
    * @param context
    * @return
    */
    List<Workload> listMyLog(WorkloadSearchContext context);

    /**
    * fetchMyMobLog
    * 移动端我的工时日志
    * @param context
    * @return
    */
    Page<Workload> fetchMyMobLog(WorkloadSearchContext context);

    /**
    * listMyMobLog
    * 移动端我的工时日志
    * @param context
    * @return
    */
    List<Workload> listMyMobLog(WorkloadSearchContext context);

    /**
    * fetchMyTestCaseWorkload
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchMyTestCaseWorkload(WorkloadSearchContext context);

    /**
    * listMyTestCaseWorkload
    * 
    * @param context
    * @return
    */
    List<Workload> listMyTestCaseWorkload(WorkloadSearchContext context);

    /**
    * fetchMyTypeOf
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchMyTypeOf(WorkloadSearchContext context);

    /**
    * listMyTypeOf
    * 
    * @param context
    * @return
    */
    List<Workload> listMyTypeOf(WorkloadSearchContext context);

    /**
    * fetchMyWorkItemWorkload
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchMyWorkItemWorkload(WorkloadSearchContext context);

    /**
    * listMyWorkItemWorkload
    * 
    * @param context
    * @return
    */
    List<Workload> listMyWorkItemWorkload(WorkloadSearchContext context);

    /**
    * fetchTestCaseWorkload
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchTestCaseWorkload(WorkloadSearchContext context);

    /**
    * listTestCaseWorkload
    * 
    * @param context
    * @return
    */
    List<Workload> listTestCaseWorkload(WorkloadSearchContext context);

    /**
    * fetchTypeOf
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchTypeOf(WorkloadSearchContext context);

    /**
    * listTypeOf
    * 
    * @param context
    * @return
    */
    List<Workload> listTypeOf(WorkloadSearchContext context);

    /**
    * fetchUserGroupLink
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchUserGroupLink(WorkloadSearchContext context);

    /**
    * listUserGroupLink
    * 
    * @param context
    * @return
    */
    List<Workload> listUserGroupLink(WorkloadSearchContext context);

    /**
    * fetchUserGroupWorkload
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchUserGroupWorkload(WorkloadSearchContext context);

    /**
    * listUserGroupWorkload
    * 
    * @param context
    * @return
    */
    List<Workload> listUserGroupWorkload(WorkloadSearchContext context);

    /**
    * fetchWorkItemWorkload
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchWorkItemWorkload(WorkloadSearchContext context);

    /**
    * listWorkItemWorkload
    * 
    * @param context
    * @return
    */
    List<Workload> listWorkItemWorkload(WorkloadSearchContext context);

    /**
    * findByTypeId
    * @param typeIds
    * @return
    */
    List<Workload> findByTypeId(List<String> typeIds);
    default List<Workload> findByTypeId(String typeId){
        return findByWorkloadType(new WorkloadType().setId(typeId));
    }

    /**
    * findByWorkloadType
    * @param workloadType
    * @return
    */
    List<Workload> findByWorkloadType(WorkloadType workloadType);

    /**
    * removeByTypeId
    * @param typeId
    * @return
    */
    boolean removeByTypeId(String typeId);

    /**
    * resetByTypeId
    * @param typeId
    * @return
    */
    boolean resetByTypeId(String typeId);

    /**
    * saveByTypeId
    * @param typeId
    * @param list
    * @return
    */
    default boolean saveByTypeId(String typeId, List<Workload> list){
        return getSelf().saveByWorkloadType(new WorkloadType().setId(typeId),list);
    }

    /**
    * saveByWorkloadType
    * @param workloadType
    * @param list
    * @return
    */
    boolean saveByWorkloadType(WorkloadType workloadType, List<Workload> list);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<Workload> findByPrincipalId(List<String> principalIds);
    default List<Workload> findByPrincipalId(String principalId){
        return findByRelIdea(new Idea().setId(principalId));
    }

    /**
    * findByRelIdea
    * @param idea
    * @return
    */
    List<Workload> findByRelIdea(Idea idea);

    /**
    * removeByPrincipalId
    * @param principalId
    * @return
    */
    boolean removeByPrincipalId(String principalId);

    /**
    * resetByPrincipalId
    * @param principalId
    * @return
    */
    boolean resetByPrincipalId(String principalId);

    /**
    * saveByPrincipalId
    * @param principalId
    * @param list
    * @return
    */
    default boolean saveByPrincipalId(String principalId, List<Workload> list){
        return getSelf().saveByRelIdea(new Idea().setId(principalId),list);
    }

    /**
    * saveByRelIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByRelIdea(Idea idea, List<Workload> list);

    /**
    * findByRelTestCase
    * @param testCase
    * @return
    */
    List<Workload> findByRelTestCase(TestCase testCase);

    /**
    * saveByRelTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByRelTestCase(TestCase testCase, List<Workload> list);

    /**
    * findByRelWorkItem
    * @param workItem
    * @return
    */
    List<Workload> findByRelWorkItem(WorkItem workItem);

    /**
    * saveByRelWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByRelWorkItem(WorkItem workItem, List<Workload> list);

    /**
    * getRegisterWorkload
    * 修改实际工时表单获取数据行为
    * @param et
    * @return
    */
    default Workload getRegisterWorkload(Workload et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Workload> fetchView(WorkloadSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Workload> listView(WorkloadSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}