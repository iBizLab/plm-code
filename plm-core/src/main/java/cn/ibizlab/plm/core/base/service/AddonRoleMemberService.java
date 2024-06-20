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
import cn.ibizlab.plm.core.base.domain.AddonRoleMember;
import cn.ibizlab.plm.core.base.filter.AddonRoleMemberSearchContext;
import cn.ibizlab.plm.core.base.domain.Addon;

/**
 * 组件权限成员服务接口[AddonRoleMemberService]
 *
 * @author generator
 */
public interface AddonRoleMemberService extends IService<AddonRoleMember> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AddonRoleMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(AddonRoleMember et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<AddonRoleMember> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(AddonRoleMember et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<AddonRoleMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new AddonRoleMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(AddonRoleMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<AddonRoleMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AddonRoleMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<AddonRoleMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default AddonRoleMember get(String key) {
        return getSelf().get(new AddonRoleMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    AddonRoleMember get(AddonRoleMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<AddonRoleMember> get(Collection<String> keys) {
        List<AddonRoleMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AddonRoleMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<AddonRoleMember> get(List<AddonRoleMember> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    AddonRoleMember getDraft(AddonRoleMember et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(AddonRoleMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(AddonRoleMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<AddonRoleMember> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<AddonRoleMember> fetchDefault(AddonRoleMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<AddonRoleMember> listDefault(AddonRoleMemberSearchContext context);

    /**
    * findByAddonId
    * @param addonIds
    * @return
    */
    List<AddonRoleMember> findByAddonId(List<String> addonIds);
    default List<AddonRoleMember> findByAddonId(String addonId){
        return findByAddonId(Arrays.asList(addonId));
    }

    /**
    * removeByAddonId
    * @param addonId
    * @return
    */
    boolean removeByAddonId(String addonId);

    /**
    * resetByAddonId
    * @param addonId
    * @return
    */
    boolean resetByAddonId(String addonId);

    /**
    * saveByAddonId
    * @param addonId
    * @param list
    * @return
    */
    default boolean saveByAddonId(String addonId, List<AddonRoleMember> list){
        return getSelf().saveByAddon(new Addon().setId(addonId),list);
    }

    /**
    * saveByAddon
    * @param addon
    * @param list
    * @return
    */
    boolean saveByAddon(Addon addon, List<AddonRoleMember> list);


    default ImportResult importData(String config, Boolean ignoreError, List<AddonRoleMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            AddonRoleMember et=list.get(i);
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
    default AddonRoleMember getEntity() {
        return new AddonRoleMember();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default AddonRoleMemberSearchContext getSearchContext() {
        return new AddonRoleMemberSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}