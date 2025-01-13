/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysRole;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysRoleSearchContext;

/**
 * 系统角色服务接口[SysRoleService]
 *
 * @author generator
 */
public interface SysRoleService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysRoleService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SysRole et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SysRole> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SysRole et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SysRole> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysRole().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SysRole et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SysRole> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysRole().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SysRole> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SysRole get(String key) {
        return getSelf().get(new SysRole().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysRole get(SysRole et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SysRole> get(Collection<String> keys) {
        List<SysRole> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysRole().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SysRole> get(List<SysRole> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SysRole getDraft(SysRole et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(SysRole et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SysRole et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SysRole> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SysRole> fetchDefault(SysRoleSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SysRole> listDefault(SysRoleSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<SysRole> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SysRole et=list.get(i);
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
    default SysRole getEntity() {
        return new SysRole();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SysRoleSearchContext getSearchContext() {
        return new SysRoleSearchContext();
    }

}