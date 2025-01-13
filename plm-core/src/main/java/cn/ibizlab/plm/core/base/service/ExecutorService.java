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
import cn.ibizlab.plm.core.base.domain.Executor;
import cn.ibizlab.plm.core.base.filter.ExecutorSearchContext;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 执行人服务接口[ExecutorService]
 *
 * @author generator
 */
public interface ExecutorService extends IService<Executor> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ExecutorService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Executor et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Executor> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Executor et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Executor> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Executor().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Executor et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Executor> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Executor().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Executor> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Executor get(String key) {
        return getSelf().get(new Executor().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Executor get(Executor et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Executor> get(Collection<String> keys) {
        List<Executor> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Executor().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Executor> get(List<Executor> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Executor getDraft(Executor et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Executor et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Executor et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Executor> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Executor> fetchDefault(ExecutorSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Executor> listDefault(ExecutorSearchContext context);

    /**
    * fetchCommentWorkItemExecutor
    * 
    * @param context
    * @return
    */
    Page<Executor> fetchCommentWorkItemExecutor(ExecutorSearchContext context);

    /**
    * listCommentWorkItemExecutor
    * 
    * @param context
    * @return
    */
    List<Executor> listCommentWorkItemExecutor(ExecutorSearchContext context);

    /**
    * fetchExecutorByOwnerid
    * 
    * @param context
    * @return
    */
    Page<Executor> fetchExecutorByOwnerid(ExecutorSearchContext context);

    /**
    * listExecutorByOwnerid
    * 
    * @param context
    * @return
    */
    List<Executor> listExecutorByOwnerid(ExecutorSearchContext context);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<Executor> findByUserId(List<String> userIds);
    default List<Executor> findByUserId(String userId){
        return findByUser(new User().setId(userId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<Executor> findByUser(User user);

    /**
    * removeByUserId
    * @param userId
    * @return
    */
    boolean removeByUserId(String userId);

    /**
    * resetByUserId
    * @param userId
    * @return
    */
    boolean resetByUserId(String userId);

    /**
    * saveByUserId
    * @param userId
    * @param list
    * @return
    */
    default boolean saveByUserId(String userId, List<Executor> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<Executor> list);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Executor> findByOwnerId(List<String> ownerIds);
    default List<Executor> findByOwnerId(String ownerId){
        return findByWorkItem(new WorkItem().setId(ownerId));
    }

    /**
    * findByWorkItem
    * @param workItem
    * @return
    */
    List<Executor> findByWorkItem(WorkItem workItem);

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
    default boolean saveByOwnerId(String ownerId, List<Executor> list){
        return getSelf().saveByWorkItem(new WorkItem().setId(ownerId),list);
    }

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<Executor> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Executor> fetchView(ExecutorSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Executor> listView(ExecutorSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Executor> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Executor et=list.get(i);
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
    default Executor getEntity() {
        return new Executor();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ExecutorSearchContext getSearchContext() {
        return new ExecutorSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}