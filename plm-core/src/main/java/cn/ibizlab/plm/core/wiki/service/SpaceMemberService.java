/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.wiki.domain.SpaceMember;
import cn.ibizlab.plm.core.wiki.filter.SpaceMemberSearchContext;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 空间成员服务接口[SpaceMemberService]
 *
 * @author generator
 */
public interface SpaceMemberService extends IService<SpaceMember> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SpaceMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SpaceMember et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SpaceMember> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SpaceMember et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SpaceMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SpaceMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SpaceMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SpaceMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SpaceMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SpaceMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SpaceMember get(String key) {
        return getSelf().get(new SpaceMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SpaceMember get(SpaceMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SpaceMember> get(Collection<String> keys) {
        List<SpaceMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SpaceMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SpaceMember> get(List<SpaceMember> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SpaceMember getDraft(SpaceMember et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(SpaceMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SpaceMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SpaceMember> list);

    /**
    * changeRole
    * 
    * @param et
    * @return
    */
    default SpaceMember changeRole(SpaceMember et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default SpaceMember nothing(SpaceMember et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SpaceMember> fetchDefault(SpaceMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SpaceMember> listDefault(SpaceMemberSearchContext context);

    /**
    * fetchCurSpace
    * 
    * @param context
    * @return
    */
    Page<SpaceMember> fetchCurSpace(SpaceMemberSearchContext context);

    /**
    * listCurSpace
    * 
    * @param context
    * @return
    */
    List<SpaceMember> listCurSpace(SpaceMemberSearchContext context);

    /**
    * findBySpaceId
    * @param spaceIds
    * @return
    */
    List<SpaceMember> findBySpaceId(List<String> spaceIds);
    default List<SpaceMember> findBySpaceId(String spaceId){
        return findBySpace(new Space().setId(spaceId));
    }

    /**
    * findBySpace
    * @param space
    * @return
    */
    List<SpaceMember> findBySpace(Space space);

    /**
    * removeBySpaceId
    * @param spaceId
    * @return
    */
    boolean removeBySpaceId(String spaceId);

    /**
    * resetBySpaceId
    * @param spaceId
    * @return
    */
    boolean resetBySpaceId(String spaceId);

    /**
    * saveBySpaceId
    * @param spaceId
    * @param list
    * @return
    */
    default boolean saveBySpaceId(String spaceId, List<SpaceMember> list){
        return getSelf().saveBySpace(new Space().setId(spaceId),list);
    }

    /**
    * saveBySpace
    * @param space
    * @param list
    * @return
    */
    boolean saveBySpace(Space space, List<SpaceMember> list);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<SpaceMember> findByUserId(List<String> userIds);
    default List<SpaceMember> findByUserId(String userId){
        return findByUser(new User().setId(userId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<SpaceMember> findByUser(User user);

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
    default boolean saveByUserId(String userId, List<SpaceMember> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<SpaceMember> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<SpaceMember> fetchView(SpaceMemberSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<SpaceMember> listView(SpaceMemberSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<SpaceMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SpaceMember et=list.get(i);
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
    default SpaceMember getEntity() {
        return new SpaceMember();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SpaceMemberSearchContext getSearchContext() {
        return new SpaceMemberSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}