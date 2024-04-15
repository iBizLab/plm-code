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
     * 获取
     * @param et
     * @return
     */
    Favorite get(Favorite et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Favorite get(String key) {
        return getSelf().get(new Favorite().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Favorite> getByIds(Collection<String> ids) {
        List<Favorite> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Favorite().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Favorite> getByEntities(List<Favorite> entities);

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
    Integer checkKey(Favorite et);

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
    boolean createBatch(List<Favorite> list);

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
    boolean updateBatch(List<Favorite> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Favorite et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Favorite> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Favorite().setId(key));
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
    boolean remove(Favorite et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Favorite> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Favorite().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Favorite> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Favorite> searchDefault(FavoriteSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Favorite> listDefault(FavoriteSearchContext context);

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
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<Favorite> findByOwnerId(List<String> ownerIds);
    default List<Favorite> findByOwnerId(String ownerId) {
        return findByOwnerId(Arrays.asList(ownerId));
    }
    /**
     * removeRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean removeByOwnerId(String ownerId);
    /**
     * resetRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean resetByOwnerId(String ownerId);
    /**
     * saveRelByOwnerId
     * @param ownerId
     * @param list
     * @return
     */
    default boolean saveByOwnerId(String ownerId,List<Favorite> list) {
        return getSelf().saveByProject(new Project().setId(ownerId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<Favorite> list);

    /**
    * saveRelByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product,List<Favorite> list);


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