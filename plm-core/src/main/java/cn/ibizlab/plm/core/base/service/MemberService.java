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
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.filter.MemberSearchContext;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.CommonFlow;
import cn.ibizlab.plm.core.base.domain.Group;
import cn.ibizlab.plm.core.projmgmt.domain.Project;

/**
 * 成员服务接口[MemberService]
 *
 * @author generator
 */
public interface MemberService extends IService<Member> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default MemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Member et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Member> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Member et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Member> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Member().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Member et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Member> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Member().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Member> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Member get(String key) {
        return getSelf().get(new Member().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Member get(Member et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Member> get(Collection<String> keys) {
        List<Member> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Member().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Member> get(List<Member> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Member getDraft(Member et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(Member et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Member et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Member> list);

    /**
    * changeRole
    * 
    * @param et
    * @return
    */
    default Member changeRole(Member et) {
        return et;
    }

    /**
    * createMember
    * 
    * @param et
    * @return
    */
    default Member createMember(Member et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Member nothing(Member et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Member> fetchDefault(MemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Member> listDefault(MemberSearchContext context);

    /**
    * fetchUserGroupAdmin
    * 
    * @param context
    * @return
    */
    Page<Member> fetchUserGroupAdmin(MemberSearchContext context);

    /**
    * listUserGroupAdmin
    * 
    * @param context
    * @return
    */
    List<Member> listUserGroupAdmin(MemberSearchContext context);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<Member> findByUserId(List<String> userIds);
    default List<Member> findByUserId(String userId){
        return findByUserId(Arrays.asList(userId));
    }

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
    default boolean saveByUserId(String userId, List<Member> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<Member> list);

    /**
    * findById
    * @param ids
    * @return
    */
    List<Member> findById(List<String> ids);
    default List<Member> findById(String id){
        return findById(Arrays.asList(id));
    }

    /**
    * removeById
    * @param id
    * @return
    */
    boolean removeById(String id);

    /**
    * resetById
    * @param id
    * @return
    */
    boolean resetById(String id);

    /**
    * saveById
    * @param id
    * @param list
    * @return
    */
    default boolean saveById(String id, List<Member> list){
        return getSelf().saveByMemberCommonFlow(new CommonFlow().setId(id),list);
    }

    /**
    * saveByMemberCommonFlow
    * @param commonFlow
    * @param list
    * @return
    */
    boolean saveByMemberCommonFlow(CommonFlow commonFlow, List<Member> list);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Member> findByOwnerId(List<String> ownerIds);
    default List<Member> findByOwnerId(String ownerId){
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
    default boolean saveByOwnerId(String ownerId, List<Member> list){
        return getSelf().saveByMemberGroup(new Group().setId(ownerId),list);
    }

    /**
    * saveByMemberGroup
    * @param group
    * @param list
    * @return
    */
    boolean saveByMemberGroup(Group group, List<Member> list);

    /**
    * saveByProjectResource
    * @param project
    * @param list
    * @return
    */
    boolean saveByProjectResource(Project project, List<Member> list);


    default ImportResult importData(String config, Boolean ignoreError, List<Member> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Member et=list.get(i);
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
    default Member getEntity() {
        return new Member();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default MemberSearchContext getSearchContext() {
        return new MemberSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}