/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTag;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTagSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;

/**
 * 产品标签服务接口[ProductTagService]
 *
 * @author generator
 */
public interface ProductTagService extends IService<ProductTag> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProductTagService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProductTag get(ProductTag et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ProductTag get(String key) {
        return getSelf().get(new ProductTag().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ProductTag> getByIds(Collection<String> ids) {
        List<ProductTag> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProductTag().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ProductTag> getByEntities(List<ProductTag> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    ProductTag getDraft(ProductTag et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(ProductTag et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(ProductTag et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<ProductTag> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(ProductTag et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<ProductTag> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ProductTag et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ProductTag> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProductTag().setId(key));
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
    boolean remove(ProductTag et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ProductTag> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProductTag().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ProductTag> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<ProductTag> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ProductTag et=list.get(i);
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
    Page<ProductTag> searchDefault(ProductTagSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ProductTag> listDefault(ProductTagSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default ProductTag getEntity() {
        return new ProductTag();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ProductTagSearchContext getSearchContext() {
        return new ProductTagSearchContext();
    }
    /**
     * selectRelByProductId
     * @param productIds
     * @return
     */
    List<ProductTag> findByProductId(List<String> productIds);
    default List<ProductTag> findByProductId(String productId) {
        return findByProductId(Arrays.asList(productId));
    }
    /**
     * removeRelByProductId
     * @param productId
     * @return
     */
    boolean removeByProductId(String productId);
    /**
     * resetRelByProductId
     * @param productId
     * @return
     */
    boolean resetByProductId(String productId);
    /**
     * saveRelByProductId
     * @param productId
     * @param list
     * @return
     */
    default boolean saveByProductId(String productId,List<ProductTag> list) {
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }
    /**
    * saveRelByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product,List<ProductTag> list);


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