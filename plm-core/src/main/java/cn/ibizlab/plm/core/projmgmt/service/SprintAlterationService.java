/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
import cn.ibizlab.plm.core.projmgmt.filter.SprintAlterationSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 迭代变更服务接口[SprintAlterationService]
 *
 * @author generator
 */
public interface SprintAlterationService extends IService<SprintAlteration> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SprintAlterationService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SprintAlteration et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SprintAlteration> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SprintAlteration et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SprintAlteration> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SprintAlteration().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SprintAlteration et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SprintAlteration> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SprintAlteration().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SprintAlteration> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SprintAlteration get(String key) {
        return getSelf().get(new SprintAlteration().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SprintAlteration get(SprintAlteration et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SprintAlteration> get(Collection<String> keys) {
        List<SprintAlteration> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SprintAlteration().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SprintAlteration> get(List<SprintAlteration> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SprintAlteration getDraft(SprintAlteration et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(SprintAlteration et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SprintAlteration et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SprintAlteration> list);

    /**
    * repChange
    * 
    * @param et
    * @return
    */
    default SprintAlteration repChange(SprintAlteration et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SprintAlteration> fetchDefault(SprintAlterationSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SprintAlteration> listDefault(SprintAlterationSearchContext context);

    /**
    * fetchChange
    * 
    * @param context
    * @return
    */
    Page<SprintAlteration> fetchChange(SprintAlterationSearchContext context);

    /**
    * listChange
    * 
    * @param context
    * @return
    */
    List<SprintAlteration> listChange(SprintAlterationSearchContext context);

    /**
    * findBySprintId
    * @param sprintIds
    * @return
    */
    List<SprintAlteration> findBySprintId(List<String> sprintIds);
    default List<SprintAlteration> findBySprintId(String sprintId){
        return findBySprint(new Sprint().setId(sprintId));
    }

    /**
    * findBySprint
    * @param sprint
    * @return
    */
    List<SprintAlteration> findBySprint(Sprint sprint);

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
    default boolean saveBySprintId(String sprintId, List<SprintAlteration> list){
        return getSelf().saveBySprint(new Sprint().setId(sprintId),list);
    }

    /**
    * saveBySprint
    * @param sprint
    * @param list
    * @return
    */
    boolean saveBySprint(Sprint sprint, List<SprintAlteration> list);

    /**
    * findByWorkItemId
    * @param workItemIds
    * @return
    */
    List<SprintAlteration> findByWorkItemId(List<String> workItemIds);
    default List<SprintAlteration> findByWorkItemId(String workItemId){
        return findByWorkItem(new WorkItem().setId(workItemId));
    }

    /**
    * findByWorkItem
    * @param workItem
    * @return
    */
    List<SprintAlteration> findByWorkItem(WorkItem workItem);

    /**
    * removeByWorkItemId
    * @param workItemId
    * @return
    */
    boolean removeByWorkItemId(String workItemId);

    /**
    * resetByWorkItemId
    * @param workItemId
    * @return
    */
    boolean resetByWorkItemId(String workItemId);

    /**
    * saveByWorkItemId
    * @param workItemId
    * @param list
    * @return
    */
    default boolean saveByWorkItemId(String workItemId, List<SprintAlteration> list){
        return getSelf().saveByWorkItem(new WorkItem().setId(workItemId),list);
    }

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<SprintAlteration> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<SprintAlteration> fetchView(SprintAlterationSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<SprintAlteration> listView(SprintAlterationSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<SprintAlteration> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SprintAlteration et=list.get(i);
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
    default SprintAlteration getEntity() {
        return new SprintAlteration();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SprintAlterationSearchContext getSearchContext() {
        return new SprintAlterationSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}