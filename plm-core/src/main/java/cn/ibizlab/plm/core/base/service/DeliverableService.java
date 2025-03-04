/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.base.filter.DeliverableSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 交付物服务接口[DeliverableService]
 *
 * @author generator
 */
public interface DeliverableService extends IService<Deliverable> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DeliverableService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Deliverable et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Deliverable> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Deliverable et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Deliverable> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Deliverable().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Deliverable et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Deliverable> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Deliverable().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Deliverable> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Deliverable get(String key) {
        return getSelf().get(new Deliverable().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Deliverable get(Deliverable et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Deliverable> get(Collection<String> keys) {
        List<Deliverable> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Deliverable().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Deliverable> get(List<Deliverable> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Deliverable getDraft(Deliverable et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Deliverable et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Deliverable et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Deliverable> list);

    /**
    * getDelivery
    * 
    * @param key
    * @return
    */
    default Deliverable getDelivery(String key) {
        return getSelf().getDelivery(new Deliverable().setId(key));
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Deliverable nothing(Deliverable et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Deliverable> fetchDefault(DeliverableSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Deliverable> listDefault(DeliverableSearchContext context);

    /**
    * fetchMyDeliverable
    * 
    * @param context
    * @return
    */
    Page<Deliverable> fetchMyDeliverable(DeliverableSearchContext context);

    /**
    * listMyDeliverable
    * 
    * @param context
    * @return
    */
    List<Deliverable> listMyDeliverable(DeliverableSearchContext context);

    /**
    * fetchProjectDeliverable
    * 
    * @param context
    * @return
    */
    Page<Deliverable> fetchProjectDeliverable(DeliverableSearchContext context);

    /**
    * listProjectDeliverable
    * 
    * @param context
    * @return
    */
    List<Deliverable> listProjectDeliverable(DeliverableSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Deliverable> findByOwnerId(List<String> ownerIds);
    default List<Deliverable> findByOwnerId(String ownerId){
        return findByWorkItem(new WorkItem().setId(ownerId));
    }

    /**
    * findByWorkItem
    * @param workItem
    * @return
    */
    List<Deliverable> findByWorkItem(WorkItem workItem);

    /**
    * removeByOwnerId
    * @param ownerId
    * @return
    */
    boolean removeByOwnerId(String ownerId);

    /**
    * resetByOwnerId
    * @param ownerId
    * @return
    */
    boolean resetByOwnerId(String ownerId);

    /**
    * saveByOwnerId
    * @param ownerId
    * @param list
    * @return
    */
    default boolean saveByOwnerId(String ownerId, List<Deliverable> list){
        return getSelf().saveByWorkItem(new WorkItem().setId(ownerId),list);
    }

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<Deliverable> list);

    /**
    * getDelivery
    * 
    * @param et
    * @return
    */
    default Deliverable getDelivery(Deliverable et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Deliverable> fetchView(DeliverableSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Deliverable> listView(DeliverableSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Deliverable> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Deliverable et=list.get(i);
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
    default Deliverable getEntity() {
        return new Deliverable();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DeliverableSearchContext getSearchContext() {
        return new DeliverableSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}