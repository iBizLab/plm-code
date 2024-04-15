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
     * 获取
     * @param et
     * @return
     */
    Recent get(Recent et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Recent get(String key) {
        return getSelf().get(new Recent().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Recent> getByIds(Collection<String> ids) {
        List<Recent> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Recent().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Recent> getByEntities(List<Recent> entities);

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
    boolean createBatch(List<Recent> list);

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
    boolean updateBatch(List<Recent> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Recent et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Recent> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Recent().setId(key));
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
    boolean remove(Recent et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Recent> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Recent().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Recent> entities);

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
     * my_charge_entry
     * 
     * @param dto
     * @return
     */
    default Recent myChargeEntry(Recent dto) {
        return dto;
    }

    /**
     * my_created_entry
     * 
     * @param dto
     * @return
     */
    default Recent myCreatedEntry(Recent dto) {
        return dto;
    }

    /**
     * recent_clean
     * 每天定时清理最近访问数据，每人每个访问类型数据只保留100条
     * @param dto
     * @return
     */
    default Recent recentClean(Recent dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Recent> searchDefault(RecentSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Recent> listDefault(RecentSearchContext context);

    /**
     * searchrecent_access
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentAccess(RecentSearchContext context);
    /**
     * listrecent_access
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentAccess(RecentSearchContext context);

    /**
     * searchrecent_curproduct_ticket
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentCurproductTicket(RecentSearchContext context);
    /**
     * listrecent_curproduct_ticket
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentCurproductTicket(RecentSearchContext context);

    /**
     * searchrecent_curproject_child_work_item
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentCurprojectChildWorkItem(RecentSearchContext context);
    /**
     * listrecent_curproject_child_work_item
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentCurprojectChildWorkItem(RecentSearchContext context);

    /**
     * searchrecent_curproject_work_item
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentCurprojectWorkItem(RecentSearchContext context);
    /**
     * listrecent_curproject_work_item
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentCurprojectWorkItem(RecentSearchContext context);

    /**
     * searchrecent_idea
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentIdea(RecentSearchContext context);
    /**
     * listrecent_idea
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentIdea(RecentSearchContext context);

    /**
     * searchrecent_page
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentPage(RecentSearchContext context);
    /**
     * listrecent_page
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentPage(RecentSearchContext context);

    /**
     * searchrecent_project
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentProject(RecentSearchContext context);
    /**
     * listrecent_project
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentProject(RecentSearchContext context);

    /**
     * searchrecent_test_case
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentTestCase(RecentSearchContext context);
    /**
     * listrecent_test_case
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentTestCase(RecentSearchContext context);

    /**
     * searchrecent_test_case_index
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentTestCaseIndex(RecentSearchContext context);
    /**
     * listrecent_test_case_index
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentTestCaseIndex(RecentSearchContext context);

    /**
     * searchrecent_ticket
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentTicket(RecentSearchContext context);
    /**
     * listrecent_ticket
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentTicket(RecentSearchContext context);

    /**
     * searchrecent_use
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentUse(RecentSearchContext context);
    /**
     * listrecent_use
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentUse(RecentSearchContext context);

    /**
     * searchrecent_work_item
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentWorkItem(RecentSearchContext context);
    /**
     * listrecent_work_item
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentWorkItem(RecentSearchContext context);

    /**
     * searchrecent_work_item_and_nobug
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentWorkItemAndNobug(RecentSearchContext context);
    /**
     * listrecent_work_item_and_nobug
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentWorkItemAndNobug(RecentSearchContext context);

    /**
     * searchrecent_work_item_bug
     * 
     * @param context
     * @return
     */
    Page<Recent> searchRecentWorkItemBug(RecentSearchContext context);
    /**
     * listrecent_work_item_bug
     * 
     * @param context
     * @return
     */
    List<Recent> listRecentWorkItemBug(RecentSearchContext context);

    /**
     * searchuser
     * 
     * @param context
     * @return
     */
    Page<Recent> searchUser(RecentSearchContext context);
    /**
     * listuser
     * 
     * @param context
     * @return
     */
    List<Recent> listUser(RecentSearchContext context);

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
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<Recent> findByOwnerId(List<String> ownerIds);
    default List<Recent> findByOwnerId(String ownerId) {
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
    default boolean saveByOwnerId(String ownerId,List<Recent> list) {
        return getSelf().saveByDercustomRecentWorkItem(new WorkItem().setId(ownerId),list);
    }
    /**
    * saveRelByDercustomRecentWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByDercustomRecentWorkItem(WorkItem workItem,List<Recent> list);


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