/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.insight.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.core.insight.filter.InsightMemberSearchContext;
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 效能成员服务接口[InsightMemberService]
 *
 * @author generator
 */
public interface InsightMemberService extends IService<InsightMember> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default InsightMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(InsightMember et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<InsightMember> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(InsightMember et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<InsightMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new InsightMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(InsightMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<InsightMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new InsightMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<InsightMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default InsightMember get(String key) {
        return getSelf().get(new InsightMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    InsightMember get(InsightMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<InsightMember> get(Collection<String> keys) {
        List<InsightMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new InsightMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<InsightMember> get(List<InsightMember> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    InsightMember getDraft(InsightMember et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(InsightMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(InsightMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<InsightMember> list);

    /**
    * changeRole
    * 
    * @param et
    * @return
    */
    default InsightMember changeRole(InsightMember et) {
        return et;
    }

    /**
    * choosePosition
    * 
    * @param et
    * @return
    */
    default InsightMember choosePosition(InsightMember et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default InsightMember nothing(InsightMember et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<InsightMember> fetchDefault(InsightMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<InsightMember> listDefault(InsightMemberSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<InsightMember> findByOwnerId(List<String> ownerIds);
    default List<InsightMember> findByOwnerId(String ownerId){
        return findByInsightView(new InsightView().setId(ownerId));
    }

    /**
    * findByInsightView
    * @param insightView
    * @return
    */
    List<InsightMember> findByInsightView(InsightView insightView);

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
    default boolean saveByOwnerId(String ownerId, List<InsightMember> list){
        return getSelf().saveByInsightView(new InsightView().setId(ownerId),list);
    }

    /**
    * saveByInsightView
    * @param insightView
    * @param list
    * @return
    */
    boolean saveByInsightView(InsightView insightView, List<InsightMember> list);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<InsightMember> findByUserId(List<String> userIds);
    default List<InsightMember> findByUserId(String userId){
        return findByUser(new User().setId(userId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<InsightMember> findByUser(User user);

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
    default boolean saveByUserId(String userId, List<InsightMember> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<InsightMember> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<InsightMember> fetchView(InsightMemberSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<InsightMember> listView(InsightMemberSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<InsightMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            InsightMember et=list.get(i);
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
    default InsightMember getEntity() {
        return new InsightMember();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default InsightMemberSearchContext getSearchContext() {
        return new InsightMemberSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}