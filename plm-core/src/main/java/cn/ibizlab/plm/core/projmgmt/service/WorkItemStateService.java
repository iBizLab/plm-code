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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemStateSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 工作项状态服务接口[WorkItemStateService]
 *
 * @author generator
 */
public interface WorkItemStateService extends IService<WorkItemState> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default WorkItemStateService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(WorkItemState et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<WorkItemState> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(WorkItemState et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<WorkItemState> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new WorkItemState().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(WorkItemState et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<WorkItemState> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new WorkItemState().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<WorkItemState> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default WorkItemState get(String key) {
        return getSelf().get(new WorkItemState().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    WorkItemState get(WorkItemState et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<WorkItemState> get(Collection<String> keys) {
        List<WorkItemState> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new WorkItemState().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<WorkItemState> get(List<WorkItemState> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    WorkItemState getDraft(WorkItemState et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(WorkItemState et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(WorkItemState et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<WorkItemState> list);

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default WorkItemState nothing(WorkItemState et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<WorkItemState> fetchDefault(WorkItemStateSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<WorkItemState> listDefault(WorkItemStateSearchContext context);

    /**
    * findByWorkItemTypeId
    * @param workItemTypeIds
    * @return
    */
    List<WorkItemState> findByWorkItemTypeId(List<String> workItemTypeIds);
    default List<WorkItemState> findByWorkItemTypeId(String workItemTypeId){
        return findByWorkItemTypeId(Arrays.asList(workItemTypeId));
    }

    /**
    * removeByWorkItemTypeId
    * @param workItemTypeId
    * @return
    */
    boolean removeByWorkItemTypeId(String workItemTypeId);

    /**
    * resetByWorkItemTypeId
    * @param workItemTypeId
    * @return
    */
    boolean resetByWorkItemTypeId(String workItemTypeId);

    /**
    * saveByWorkItemTypeId
    * @param workItemTypeId
    * @param list
    * @return
    */
    default boolean saveByWorkItemTypeId(String workItemTypeId, List<WorkItemState> list){
        return getSelf().saveByWorkItemType(new WorkItemType().setId(workItemTypeId),list);
    }

    /**
    * saveByWorkItemType
    * @param workItemType
    * @param list
    * @return
    */
    boolean saveByWorkItemType(WorkItemType workItemType, List<WorkItemState> list);


    default ImportResult importData(String config, Boolean ignoreError, List<WorkItemState> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            WorkItemState et=list.get(i);
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
    default WorkItemState getEntity() {
        return new WorkItemState();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default WorkItemStateSearchContext getSearchContext() {
        return new WorkItemStateSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}