/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.team.domain.DiscussMember;
import cn.ibizlab.plm.core.team.filter.DiscussMemberSearchContext;
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 协作成员服务接口[DiscussMemberService]
 *
 * @author generator
 */
public interface DiscussMemberService extends IService<DiscussMember> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DiscussMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(DiscussMember et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<DiscussMember> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(DiscussMember et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<DiscussMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DiscussMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(DiscussMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<DiscussMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DiscussMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<DiscussMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default DiscussMember get(String key) {
        return getSelf().get(new DiscussMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DiscussMember get(DiscussMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<DiscussMember> get(Collection<String> keys) {
        List<DiscussMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DiscussMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<DiscussMember> get(List<DiscussMember> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    DiscussMember getDraft(DiscussMember et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(DiscussMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(DiscussMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<DiscussMember> list);

    /**
    * changeRole
    * 
    * @param et
    * @return
    */
    default DiscussMember changeRole(DiscussMember et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default DiscussMember nothing(DiscussMember et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<DiscussMember> fetchDefault(DiscussMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<DiscussMember> listDefault(DiscussMemberSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<DiscussMember> findByOwnerId(List<String> ownerIds);
    default List<DiscussMember> findByOwnerId(String ownerId){
        return findByDiscussTopic(new DiscussTopic().setId(ownerId));
    }

    /**
    * findByDiscussTopic
    * @param discussTopic
    * @return
    */
    List<DiscussMember> findByDiscussTopic(DiscussTopic discussTopic);

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
    default boolean saveByOwnerId(String ownerId, List<DiscussMember> list){
        return getSelf().saveByDiscussTopic(new DiscussTopic().setId(ownerId),list);
    }

    /**
    * saveByDiscussTopic
    * @param discussTopic
    * @param list
    * @return
    */
    boolean saveByDiscussTopic(DiscussTopic discussTopic, List<DiscussMember> list);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<DiscussMember> findByUserId(List<String> userIds);
    default List<DiscussMember> findByUserId(String userId){
        return findByUser(new User().setId(userId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<DiscussMember> findByUser(User user);

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
    default boolean saveByUserId(String userId, List<DiscussMember> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<DiscussMember> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<DiscussMember> fetchView(DiscussMemberSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<DiscussMember> listView(DiscussMemberSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<DiscussMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DiscussMember et=list.get(i);
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
    default DiscussMember getEntity() {
        return new DiscussMember();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DiscussMemberSearchContext getSearchContext() {
        return new DiscussMemberSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}