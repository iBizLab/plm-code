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
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.base.filter.DeliverableSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

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
     * 获取
     * @param et
     * @return
     */
    Deliverable get(Deliverable et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Deliverable get(String key) {
        return getSelf().get(new Deliverable().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Deliverable> getByIds(Collection<String> ids) {
        List<Deliverable> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Deliverable().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Deliverable> getByEntities(List<Deliverable> entities);

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
    Integer checkKey(Deliverable et);

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
    boolean createBatch(List<Deliverable> list);

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
    boolean updateBatch(List<Deliverable> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Deliverable et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Deliverable> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Deliverable().setId(key));
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
    boolean remove(Deliverable et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Deliverable> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Deliverable().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Deliverable> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Deliverable> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Deliverable et=list.get(i);
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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Deliverable> searchDefault(DeliverableSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Deliverable> listDefault(DeliverableSearchContext context);

    /**
     * searchProject_deliverable
     * 
     * @param context
     * @return
     */
    Page<Deliverable> searchProjectDeliverable(DeliverableSearchContext context);
    /**
     * listProject_deliverable
     * 
     * @param context
     * @return
     */
    List<Deliverable> listProjectDeliverable(DeliverableSearchContext context);

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
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<Deliverable> findByOwnerId(List<String> ownerIds);
    default List<Deliverable> findByOwnerId(String ownerId) {
        return findByOwnerId(Arrays.asList(ownerId));
    }
    /**
     * removeRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean removeByOwnerId(String ownerId);
    /**
     * resetRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean resetByOwnerId(String ownerId);
    /**
     * saveRelByOwnerId
     * @param ownerId
     * @param list
     * @return
     */
    default boolean saveByOwnerId(String ownerId,List<Deliverable> list) {
        return getSelf().saveByWorkItem(new WorkItem().setId(ownerId),list);
    }
    /**
    * saveRelByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem,List<Deliverable> list);


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