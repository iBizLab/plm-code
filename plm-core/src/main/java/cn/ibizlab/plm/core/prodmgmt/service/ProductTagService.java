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
import cn.ibizlab.util.enums.CheckKeyStatus;
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
    boolean create(List<ProductTag> list);

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
    boolean update(List<ProductTag> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProductTag().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ProductTag et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ProductTag> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProductTag().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ProductTag> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ProductTag get(String key) {
        return getSelf().get(new ProductTag().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProductTag get(ProductTag et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ProductTag> get(Collection<String> keys) {
        List<ProductTag> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProductTag().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ProductTag> get(List<ProductTag> entities);

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
    CheckKeyStatus checkKey(ProductTag et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ProductTag et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ProductTag> list);

    /**
    * deleteTag
    * 
    * @param et
    * @return
    */
    default ProductTag deleteTag(ProductTag et) {
        return et;
    }

    /**
    * getConProductTag
    * 
    * @param key
    * @return
    */
    default ProductTag getConProductTag(String key) {
        return getSelf().getConProductTag(new ProductTag().setId(key));
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default ProductTag nothing(ProductTag et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ProductTag> fetchDefault(ProductTagSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ProductTag> listDefault(ProductTagSearchContext context);

    /**
    * fetchCurProductTag
    * 
    * @param context
    * @return
    */
    Page<ProductTag> fetchCurProductTag(ProductTagSearchContext context);

    /**
    * listCurProductTag
    * 
    * @param context
    * @return
    */
    List<ProductTag> listCurProductTag(ProductTagSearchContext context);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<ProductTag> findByProductId(List<String> productIds);
    default List<ProductTag> findByProductId(String productId){
        return findByProduct(new Product().setId(productId));
    }

    /**
    * findByProduct
    * @param product
    * @return
    */
    List<ProductTag> findByProduct(Product product);

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
    default boolean saveByProductId(String productId, List<ProductTag> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<ProductTag> list);

    /**
    * getConProductTag
    * 
    * @param et
    * @return
    */
    default ProductTag getConProductTag(ProductTag et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ProductTag> fetchView(ProductTagSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ProductTag> listView(ProductTagSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}