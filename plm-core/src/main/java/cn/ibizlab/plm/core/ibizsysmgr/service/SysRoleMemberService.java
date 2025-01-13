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
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysRoleMember;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysRoleMemberSearchContext;

/**
 * 系统角色成员服务接口[SysRoleMemberService]
 *
 * @author generator
 */
public interface SysRoleMemberService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysRoleMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SysRoleMember et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SysRoleMember> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SysRoleMember et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SysRoleMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysRoleMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SysRoleMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SysRoleMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysRoleMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SysRoleMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SysRoleMember get(String key) {
        return getSelf().get(new SysRoleMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysRoleMember get(SysRoleMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SysRoleMember> get(Collection<String> keys) {
        List<SysRoleMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysRoleMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SysRoleMember> get(List<SysRoleMember> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SysRoleMember getDraft(SysRoleMember et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(SysRoleMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SysRoleMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SysRoleMember> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SysRoleMember> fetchDefault(SysRoleMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SysRoleMember> listDefault(SysRoleMemberSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<SysRoleMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SysRoleMember et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getId(),ex.getMessage());
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
    default SysRoleMember getEntity() {
        return new SysRoleMember();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SysRoleMemberSearchContext getSearchContext() {
        return new SysRoleMemberSearchContext();
    }

}