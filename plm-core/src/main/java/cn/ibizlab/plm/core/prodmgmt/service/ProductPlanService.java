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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductPlanSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.Relation;

/**
 * 排期服务接口[ProductPlanService]
 *
 * @author generator
 */
public interface ProductPlanService extends IService<ProductPlan> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProductPlanService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ProductPlan et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ProductPlan> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ProductPlan et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ProductPlan> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProductPlan().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ProductPlan et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ProductPlan> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProductPlan().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ProductPlan> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ProductPlan get(String key) {
        return getSelf().get(new ProductPlan().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProductPlan get(ProductPlan et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ProductPlan> get(Collection<String> keys) {
        List<ProductPlan> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProductPlan().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ProductPlan> get(List<ProductPlan> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ProductPlan getDraft(ProductPlan et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(ProductPlan et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ProductPlan et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ProductPlan> list);

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default ProductPlan delete(ProductPlan et) {
        return et;
    }

    /**
    * deleteCategories
    * 
    * @param et
    * @return
    */
    default ProductPlan deleteCategories(ProductPlan et) {
        return et;
    }

    /**
    * productPlanRelationIdea
    * 
    * @param et
    * @return
    */
    default ProductPlan productPlanRelationIdea(ProductPlan et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ProductPlan> fetchDefault(ProductPlanSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ProductPlan> listDefault(ProductPlanSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<ProductPlan> fetchNormal(ProductPlanSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<ProductPlan> listNormal(ProductPlanSearchContext context);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<ProductPlan> findByProductId(List<String> productIds);
    default List<ProductPlan> findByProductId(String productId){
        return findByProductId(Arrays.asList(productId));
    }

    /**
    * removeByProductId
    * @param productId
    * @return
    */
    boolean removeByProductId(String productId);

    /**
    * resetByProductId
    * @param productId
    * @return
    */
    boolean resetByProductId(String productId);

    /**
    * saveByProductId
    * @param productId
    * @param list
    * @return
    */
    default boolean saveByProductId(String productId, List<ProductPlan> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<ProductPlan> list);


    default ImportResult importData(String config, Boolean ignoreError, List<ProductPlan> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ProductPlan et=list.get(i);
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
    default ProductPlan getEntity() {
        return new ProductPlan();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ProductPlanSearchContext getSearchContext() {
        return new ProductPlanSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}