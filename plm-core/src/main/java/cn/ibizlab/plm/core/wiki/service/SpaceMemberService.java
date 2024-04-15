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
     * 获取
     * @param et
     * @return
     */
    SpaceMember get(SpaceMember et);
    /**
     * 获取
     * @param key
     * @return
     */
    default SpaceMember get(String key) {
        return getSelf().get(new SpaceMember().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<SpaceMember> getByIds(Collection<String> ids) {
        List<SpaceMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SpaceMember().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<SpaceMember> getByEntities(List<SpaceMember> entities);

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
    Integer checkKey(SpaceMember et);

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
    boolean createBatch(List<SpaceMember> list);

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
    boolean updateBatch(List<SpaceMember> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(SpaceMember et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<SpaceMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SpaceMember().setId(key));
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
    boolean remove(SpaceMember et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<SpaceMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SpaceMember().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<SpaceMember> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<SpaceMember> searchDefault(SpaceMemberSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<SpaceMember> listDefault(SpaceMemberSearchContext context);

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
     * selectRelBySpaceId
     * @param spaceIds
     * @return
     */
    List<SpaceMember> findBySpaceId(List<String> spaceIds);
    default List<SpaceMember> findBySpaceId(String spaceId) {
        return findBySpaceId(Arrays.asList(spaceId));
    }
    /**
     * removeRelBySpaceId
     * @param spaceId
     * @return
     */
    boolean removeBySpaceId(String spaceId);
    /**
     * resetRelBySpaceId
     * @param spaceId
     * @return
     */
    boolean resetBySpaceId(String spaceId);
    /**
     * saveRelBySpaceId
     * @param spaceId
     * @param list
     * @return
     */
    default boolean saveBySpaceId(String spaceId,List<SpaceMember> list) {
        return getSelf().saveBySpace(new Space().setId(spaceId),list);
    }
    /**
    * saveRelBySpace
    * @param space
    * @param list
    * @return
    */
    boolean saveBySpace(Space space,List<SpaceMember> list);

    /**
     * selectRelByUserId
     * @param userIds
     * @return
     */
    List<SpaceMember> findByUserId(List<String> userIds);
    default List<SpaceMember> findByUserId(String userId) {
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
    default boolean saveByUserId(String userId,List<SpaceMember> list) {
        return getSelf().saveByUser(new User().setId(userId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<SpaceMember> list);


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