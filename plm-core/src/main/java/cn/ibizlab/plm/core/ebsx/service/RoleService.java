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
import cn.ibizlab.plm.core.ebsx.domain.Role;
import cn.ibizlab.plm.core.ebsx.filter.RoleSearchContext;

/**
 * 系统角色服务接口[RoleService]
 *
 * @author generator
 */
public interface RoleService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default RoleService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Role et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Role> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Role et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Role> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Role().setRoleId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Role et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Role> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Role().setRoleId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Role> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Role get(String key) {
        return getSelf().get(new Role().setRoleId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Role get(Role et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Role> get(Collection<String> keys) {
        List<Role> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Role().setRoleId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Role> get(List<Role> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Role getDraft(Role et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Role et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Role et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Role> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Role> fetchDefault(RoleSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Role> listDefault(RoleSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Role> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Role et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getRoleName(),ex.getMessage());
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
    default Role getEntity() {
        return new Role();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default RoleSearchContext getSearchContext() {
        return new RoleSearchContext();
    }

}