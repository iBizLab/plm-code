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
import cn.ibizlab.plm.core.base.domain.AddonResource;
import cn.ibizlab.plm.core.base.filter.AddonResourceSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.base.domain.ResourceMember;

/**
 * 资源组件服务接口[AddonResourceService]
 *
 * @author generator
 */
public interface AddonResourceService extends IService<AddonResource> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AddonResourceService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(AddonResource et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<AddonResource> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(AddonResource et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<AddonResource> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new AddonResource().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(AddonResource et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<AddonResource> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AddonResource().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<AddonResource> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default AddonResource get(String key) {
        return getSelf().get(new AddonResource().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    AddonResource get(AddonResource et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<AddonResource> get(Collection<String> keys) {
        List<AddonResource> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AddonResource().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<AddonResource> get(List<AddonResource> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    AddonResource getDraft(AddonResource et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(AddonResource et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(AddonResource et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<AddonResource> list);

    /**
    * checkResourceIsDeleted
    * 
    * @param et
    * @return
    */
    default AddonResource checkResourceIsDeleted(AddonResource et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<AddonResource> fetchDefault(AddonResourceSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<AddonResource> listDefault(AddonResourceSearchContext context);

    /**
    * fetchAll
    * 
    * @param context
    * @return
    */
    Page<AddonResource> fetchAll(AddonResourceSearchContext context);

    /**
    * listAll
    * 
    * @param context
    * @return
    */
    List<AddonResource> listAll(AddonResourceSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<AddonResource> findByOwnerId(List<String> ownerIds);
    default List<AddonResource> findByOwnerId(String ownerId){
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
    default boolean saveByOwnerId(String ownerId, List<AddonResource> list){
        return getSelf().saveByProject(new Project().setId(ownerId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<AddonResource> list);


    default ImportResult importData(String config, Boolean ignoreError, List<AddonResource> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            AddonResource et=list.get(i);
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
    default AddonResource getEntity() {
        return new AddonResource();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default AddonResourceSearchContext getSearchContext() {
        return new AddonResourceSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}