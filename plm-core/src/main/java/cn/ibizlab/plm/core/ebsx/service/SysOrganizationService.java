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
import cn.ibizlab.plm.core.ebsx.domain.SysOrganization;
import cn.ibizlab.plm.core.ebsx.filter.SysOrganizationSearchContext;

/**
 * 组织服务接口[SysOrganizationService]
 *
 * @author generator
 */
public interface SysOrganizationService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysOrganizationService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SysOrganization et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SysOrganization> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SysOrganization et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SysOrganization> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysOrganization().setOrgId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SysOrganization et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SysOrganization> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysOrganization().setOrgId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SysOrganization> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SysOrganization get(String key) {
        return getSelf().get(new SysOrganization().setOrgId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysOrganization get(SysOrganization et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SysOrganization> get(Collection<String> keys) {
        List<SysOrganization> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysOrganization().setOrgId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SysOrganization> get(List<SysOrganization> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SysOrganization getDraft(SysOrganization et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(SysOrganization et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SysOrganization et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SysOrganization> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SysOrganization> fetchDefault(SysOrganizationSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SysOrganization> listDefault(SysOrganizationSearchContext context);

    /**
    * findByParentOrgId
    * @param parentOrgIds
    * @return
    */
    default List<SysOrganization> findByParentOrgId(List<String> parentOrgIds){
        return new ArrayList<>();
    }

    default List<SysOrganization> findByParentOrgId(String parentOrgId){
        return findByParentOrg(new SysOrganization().setOrgId(parentOrgId));
    }
	
    /**
    * findByParentOrg
    * @param sysOrganization
    * @return
    */
    default List<SysOrganization> findByParentOrg(SysOrganization sysOrganization){
        return findByParentOrgId(Arrays.asList(sysOrganization.getOrgId()));
    }

    /**
    * removeByParentOrgId
    * @param parentOrgId
    * @return
    */
    boolean removeByParentOrgId(String parentOrgId);

    /**
    * resetByParentOrgId
    * @param parentOrgId
    * @return
    */
    boolean resetByParentOrgId(String parentOrgId);

    /**
    * saveByParentOrgId
    * @param parentOrgId
    * @param list
    * @return
    */
    default boolean saveByParentOrgId(String parentOrgId, List<SysOrganization> list){
        return getSelf().saveByParentOrg(new SysOrganization().setOrgId(parentOrgId),list);
    }

    /**
    * saveByParentOrg
    * @param sysOrganization
    * @param list
    * @return
    */
    boolean saveByParentOrg(SysOrganization sysOrganization, List<SysOrganization> list);


    default ImportResult importData(String config, Boolean ignoreError, List<SysOrganization> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SysOrganization et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getOrgName(),ex.getMessage());
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
    default SysOrganization getEntity() {
        return new SysOrganization();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SysOrganizationSearchContext getSearchContext() {
        return new SysOrganizationSearchContext();
    }

}