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
import cn.ibizlab.plm.core.base.domain.Group;

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
     * 获取
     * @param et
     * @return
     */
    Member get(Member et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Member get(String key) {
        return getSelf().get(new Member().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Member> getByIds(Collection<String> ids) {
        List<Member> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Member().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Member> getByEntities(List<Member> entities);

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
    boolean createBatch(List<Member> list);

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
    boolean updateBatch(List<Member> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Member et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Member> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Member().setId(key));
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
    boolean remove(Member et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Member> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Member().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Member> entities);

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
     * change_role
     * 
     * @param dto
     * @return
     */
    default Member changeRole(Member dto) {
        return dto;
    }

    /**
     * create_member
     * 
     * @param dto
     * @return
     */
    default Member createMember(Member dto) {
        return dto;
    }

    /**
     * nothing
     * 
     * @param dto
     * @return
     */
    default Member nothing(Member dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Member> searchDefault(MemberSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Member> listDefault(MemberSearchContext context);

    /**
     * searchuser_group_admin
     * 
     * @param context
     * @return
     */
    Page<Member> searchUserGroupAdmin(MemberSearchContext context);
    /**
     * listuser_group_admin
     * 
     * @param context
     * @return
     */
    List<Member> listUserGroupAdmin(MemberSearchContext context);

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
     * selectRelByUserId
     * @param userIds
     * @return
     */
    List<Member> findByUserId(List<String> userIds);
    default List<Member> findByUserId(String userId) {
        return findByUserId(Arrays.asList(userId));
    }
    /**
     * removeRelByUserId
     * @param userId
     * @return
     */
    boolean removeByUserId(String userId);
    /**
     * resetRelByUserId
     * @param userId
     * @return
     */
    boolean resetByUserId(String userId);
    /**
     * saveRelByUserId
     * @param userId
     * @param list
     * @return
     */
    default boolean saveByUserId(String userId,List<Member> list) {
        return getSelf().saveByUser(new User().setId(userId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<Member> list);

    /**
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<Member> findByOwnerId(List<String> ownerIds);
    default List<Member> findByOwnerId(String ownerId) {
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
    default boolean saveByOwnerId(String ownerId,List<Member> list) {
        return getSelf().saveByGroup(new Group().setId(ownerId),list);
    }
    /**
    * saveRelByGroup
    * @param group
    * @param list
    * @return
    */
    boolean saveByGroup(Group group,List<Member> list);


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