/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.ebsx.domain.UserRole;
import cn.ibizlab.plm.core.ebsx.filter.UserRoleSearchContext;

/**
 * 用户角色关系服务接口[UserRoleService]
 *
 * @author generator
 */
public interface UserRoleService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default UserRoleService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(UserRole et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<UserRole> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(UserRole et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<UserRole> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new UserRole().setUserRoleId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(UserRole et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<UserRole> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new UserRole().setUserRoleId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<UserRole> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default UserRole get(String key) {
        return getSelf().get(new UserRole().setUserRoleId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    UserRole get(UserRole et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<UserRole> get(Collection<String> keys) {
        List<UserRole> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new UserRole().setUserRoleId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<UserRole> get(List<UserRole> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    UserRole getDraft(UserRole et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(UserRole et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(UserRole et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<UserRole> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<UserRole> fetchDefault(UserRoleSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<UserRole> listDefault(UserRoleSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<UserRole> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            UserRole et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getUserId(),ex.getMessage());
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
    default UserRole getEntity() {
        return new UserRole();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default UserRoleSearchContext getSearchContext() {
        return new UserRoleSearchContext();
    }

}