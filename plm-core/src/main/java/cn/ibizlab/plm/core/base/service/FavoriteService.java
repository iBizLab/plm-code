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
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.filter.FavoriteSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;

/**
 * 收藏服务接口[FavoriteService]
 *
 * @author generator
 */
public interface FavoriteService extends IService<Favorite> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default FavoriteService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Favorite et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Favorite> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Favorite et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Favorite> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Favorite().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Favorite et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Favorite> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Favorite().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Favorite> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Favorite get(String key) {
        return getSelf().get(new Favorite().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Favorite get(Favorite et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Favorite> get(Collection<String> keys) {
        List<Favorite> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Favorite().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Favorite> get(List<Favorite> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Favorite getDraft(Favorite et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Favorite et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Favorite et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Favorite> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Favorite> fetchDefault(FavoriteSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Favorite> listDefault(FavoriteSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Favorite> findByOwnerId(List<String> ownerIds);
    default List<Favorite> findByOwnerId(String ownerId){
        return findByProject(new Project().setId(ownerId));
    }

    /**
    * findByProject
    * @param project
    * @return
    */
    List<Favorite> findByProject(Project project);

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
    default boolean saveByOwnerId(String ownerId, List<Favorite> list){
        return getSelf().saveByProject(new Project().setId(ownerId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<Favorite> list);

    /**
    * findByProduct
    * @param product
    * @return
    */
    List<Favorite> findByProduct(Product product);

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<Favorite> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Favorite> fetchView(FavoriteSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Favorite> listView(FavoriteSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Favorite> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Favorite et=list.get(i);
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
    default Favorite getEntity() {
        return new Favorite();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default FavoriteSearchContext getSearchContext() {
        return new FavoriteSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}