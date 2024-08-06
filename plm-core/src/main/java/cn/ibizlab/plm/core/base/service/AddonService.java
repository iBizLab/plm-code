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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.filter.AddonSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.base.domain.AddonRoleMember;

/**
 * 组件服务接口[AddonService]
 *
 * @author generator
 */
public interface AddonService extends IService<Addon> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AddonService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Addon et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Addon> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Addon et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Addon> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Addon().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Addon et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Addon> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Addon().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Addon> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Addon get(String key) {
        return getSelf().get(new Addon().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Addon get(Addon et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Addon> get(Collection<String> keys) {
        List<Addon> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Addon().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Addon> get(List<Addon> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Addon getDraft(Addon et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Addon et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Addon et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Addon> list);

    /**
    * addonAuthority
    * 
    * @param et
    * @return
    */
    default Addon addonAuthority(Addon et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Addon nothing(Addon et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Addon> fetchDefault(AddonSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Addon> listDefault(AddonSearchContext context);

    /**
    * fetchCurOwnerSys
    * 
    * @param context
    * @return
    */
    Page<Addon> fetchCurOwnerSys(AddonSearchContext context);

    /**
    * listCurOwnerSys
    * 
    * @param context
    * @return
    */
    List<Addon> listCurOwnerSys(AddonSearchContext context);

    /**
    * fetchPsmodelSync
    * 用于定义实体数据关系界面组同步的数据
    * @param context
    * @return
    */
    Page<Addon> fetchPsmodelSync(AddonSearchContext context);

    /**
    * listPsmodelSync
    * 用于定义实体数据关系界面组同步的数据
    * @param context
    * @return
    */
    List<Addon> listPsmodelSync(AddonSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Addon> findByOwnerId(List<String> ownerIds);
    default List<Addon> findByOwnerId(String ownerId){
        return findByLibrary(new Library().setId(ownerId));
    }

    /**
    * findByLibrary
    * @param library
    * @return
    */
    List<Addon> findByLibrary(Library library);

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
    default boolean saveByOwnerId(String ownerId, List<Addon> list){
        return getSelf().saveByLibrary(new Library().setId(ownerId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<Addon> list);

    /**
    * findByPortfolio
    * @param portfolio
    * @return
    */
    List<Addon> findByPortfolio(Portfolio portfolio);

    /**
    * saveByPortfolio
    * @param portfolio
    * @param list
    * @return
    */
    boolean saveByPortfolio(Portfolio portfolio, List<Addon> list);

    /**
    * findByProduct
    * @param product
    * @return
    */
    List<Addon> findByProduct(Product product);

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<Addon> list);

    /**
    * findByProject
    * @param project
    * @return
    */
    List<Addon> findByProject(Project project);

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<Addon> list);

    /**
    * findBySpace
    * @param space
    * @return
    */
    List<Addon> findBySpace(Space space);

    /**
    * saveBySpace
    * @param space
    * @param list
    * @return
    */
    boolean saveBySpace(Space space, List<Addon> list);

    default List<AddonRoleMember> getAddonRoleMembers(Addon et) {
        return new ArrayList<>();
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Addon> fetchView(AddonSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Addon> listView(AddonSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Addon> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Addon et=list.get(i);
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
    default Addon getEntity() {
        return new Addon();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default AddonSearchContext getSearchContext() {
        return new AddonSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}