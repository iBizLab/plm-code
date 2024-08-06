/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.projmgmt.domain.TransitionHistory;
import cn.ibizlab.plm.core.projmgmt.filter.TransitionHistorySearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 流转记录服务接口[TransitionHistoryService]
 *
 * @author generator
 */
public interface TransitionHistoryService extends IService<TransitionHistory> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default TransitionHistoryService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(TransitionHistory et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<TransitionHistory> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(TransitionHistory et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<TransitionHistory> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TransitionHistory().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(TransitionHistory et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<TransitionHistory> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TransitionHistory().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<TransitionHistory> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default TransitionHistory get(String key) {
        return getSelf().get(new TransitionHistory().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    TransitionHistory get(TransitionHistory et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<TransitionHistory> get(Collection<String> keys) {
        List<TransitionHistory> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TransitionHistory().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<TransitionHistory> get(List<TransitionHistory> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    TransitionHistory getDraft(TransitionHistory et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(TransitionHistory et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(TransitionHistory et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<TransitionHistory> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<TransitionHistory> fetchDefault(TransitionHistorySearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<TransitionHistory> listDefault(TransitionHistorySearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<TransitionHistory> findByOwnerId(List<String> ownerIds);
    default List<TransitionHistory> findByOwnerId(String ownerId){
        return findByWorkItem(new WorkItem().setId(ownerId));
    }

    /**
    * findByWorkItem
    * @param workItem
    * @return
    */
    List<TransitionHistory> findByWorkItem(WorkItem workItem);

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
    default boolean saveByOwnerId(String ownerId, List<TransitionHistory> list){
        return getSelf().saveByWorkItem(new WorkItem().setId(ownerId),list);
    }

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<TransitionHistory> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<TransitionHistory> fetchView(TransitionHistorySearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<TransitionHistory> listView(TransitionHistorySearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<TransitionHistory> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            TransitionHistory et=list.get(i);
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
    default TransitionHistory getEntity() {
        return new TransitionHistory();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default TransitionHistorySearchContext getSearchContext() {
        return new TransitionHistorySearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}