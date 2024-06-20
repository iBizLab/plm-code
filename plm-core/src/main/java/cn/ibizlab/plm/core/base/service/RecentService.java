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
import cn.ibizlab.plm.core.base.domain.Recent;
import cn.ibizlab.plm.core.base.filter.RecentSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 最近访问服务接口[RecentService]
 *
 * @author generator
 */
public interface RecentService extends IService<Recent> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default RecentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Recent et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Recent> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Recent et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Recent> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Recent().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Recent et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Recent> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Recent().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Recent> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Recent get(String key) {
        return getSelf().get(new Recent().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Recent get(Recent et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Recent> get(Collection<String> keys) {
        List<Recent> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Recent().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Recent> get(List<Recent> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Recent getDraft(Recent et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(Recent et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Recent et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Recent> list);

    /**
    * myChargeEntry
    * 
    * @param et
    * @return
    */
    default Recent myChargeEntry(Recent et) {
        return et;
    }

    /**
    * myCreatedEntry
    * 
    * @param et
    * @return
    */
    default Recent myCreatedEntry(Recent et) {
        return et;
    }

    /**
    * recentClean
    * 
    * @param et
    * @return
    */
    default Recent recentClean(Recent et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchDefault(RecentSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Recent> listDefault(RecentSearchContext context);

    /**
    * fetchRecentAccess
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentAccess(RecentSearchContext context);

    /**
    * listRecentAccess
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentAccess(RecentSearchContext context);

    /**
    * fetchRecentCurproductTicket
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentCurproductTicket(RecentSearchContext context);

    /**
    * listRecentCurproductTicket
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentCurproductTicket(RecentSearchContext context);

    /**
    * fetchRecentCurprojectChildWorkItem
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentCurprojectChildWorkItem(RecentSearchContext context);

    /**
    * listRecentCurprojectChildWorkItem
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentCurprojectChildWorkItem(RecentSearchContext context);

    /**
    * fetchRecentCurprojectWorkItem
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentCurprojectWorkItem(RecentSearchContext context);

    /**
    * listRecentCurprojectWorkItem
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentCurprojectWorkItem(RecentSearchContext context);

    /**
    * fetchRecentIdea
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentIdea(RecentSearchContext context);

    /**
    * listRecentIdea
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentIdea(RecentSearchContext context);

    /**
    * fetchRecentPage
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentPage(RecentSearchContext context);

    /**
    * listRecentPage
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentPage(RecentSearchContext context);

    /**
    * fetchRecentProject
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentProject(RecentSearchContext context);

    /**
    * listRecentProject
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentProject(RecentSearchContext context);

    /**
    * fetchRecentTestCase
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentTestCase(RecentSearchContext context);

    /**
    * listRecentTestCase
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentTestCase(RecentSearchContext context);

    /**
    * fetchRecentTestCaseIndex
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentTestCaseIndex(RecentSearchContext context);

    /**
    * listRecentTestCaseIndex
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentTestCaseIndex(RecentSearchContext context);

    /**
    * fetchRecentTicket
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentTicket(RecentSearchContext context);

    /**
    * listRecentTicket
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentTicket(RecentSearchContext context);

    /**
    * fetchRecentUse
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentUse(RecentSearchContext context);

    /**
    * listRecentUse
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentUse(RecentSearchContext context);

    /**
    * fetchRecentWorkItem
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentWorkItem(RecentSearchContext context);

    /**
    * listRecentWorkItem
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentWorkItem(RecentSearchContext context);

    /**
    * fetchRecentWorkItemAndNobug
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentWorkItemAndNobug(RecentSearchContext context);

    /**
    * listRecentWorkItemAndNobug
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentWorkItemAndNobug(RecentSearchContext context);

    /**
    * fetchRecentWorkItemBug
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchRecentWorkItemBug(RecentSearchContext context);

    /**
    * listRecentWorkItemBug
    * 
    * @param context
    * @return
    */
    List<Recent> listRecentWorkItemBug(RecentSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<Recent> fetchUser(RecentSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<Recent> listUser(RecentSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Recent> findByOwnerId(List<String> ownerIds);
    default List<Recent> findByOwnerId(String ownerId){
        return findByOwnerId(Arrays.asList(ownerId));
    }

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
    default boolean saveByOwnerId(String ownerId, List<Recent> list){
        return getSelf().saveByDercustomRecentWorkItem(new WorkItem().setId(ownerId),list);
    }

    /**
    * saveByDercustomRecentWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByDercustomRecentWorkItem(WorkItem workItem, List<Recent> list);


    default ImportResult importData(String config, Boolean ignoreError, List<Recent> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Recent et=list.get(i);
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
    default Recent getEntity() {
        return new Recent();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default RecentSearchContext getSearchContext() {
        return new RecentSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}