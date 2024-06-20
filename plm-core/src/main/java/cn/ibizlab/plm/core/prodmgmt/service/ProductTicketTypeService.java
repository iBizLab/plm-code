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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTicketTypeSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.domain.TicketType;

/**
 * 产品工单类型服务接口[ProductTicketTypeService]
 *
 * @author generator
 */
public interface ProductTicketTypeService extends IService<ProductTicketType> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProductTicketTypeService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ProductTicketType et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ProductTicketType> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ProductTicketType et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ProductTicketType> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProductTicketType().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ProductTicketType et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ProductTicketType> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProductTicketType().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ProductTicketType> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ProductTicketType get(String key) {
        return getSelf().get(new ProductTicketType().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProductTicketType get(ProductTicketType et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ProductTicketType> get(Collection<String> keys) {
        List<ProductTicketType> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProductTicketType().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ProductTicketType> get(List<ProductTicketType> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ProductTicketType getDraft(ProductTicketType et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(ProductTicketType et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ProductTicketType et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ProductTicketType> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ProductTicketType> fetchDefault(ProductTicketTypeSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ProductTicketType> listDefault(ProductTicketTypeSearchContext context);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<ProductTicketType> findByProductId(List<String> productIds);
    default List<ProductTicketType> findByProductId(String productId){
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
    default boolean saveByProductId(String productId, List<ProductTicketType> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<ProductTicketType> list);

    /**
    * findByTicketTypeId
    * @param ticketTypeIds
    * @return
    */
    List<ProductTicketType> findByTicketTypeId(List<String> ticketTypeIds);
    default List<ProductTicketType> findByTicketTypeId(String ticketTypeId){
        return findByTicketTypeId(Arrays.asList(ticketTypeId));
    }

    /**
    * removeByTicketTypeId
    * @param ticketTypeId
    * @return
    */
    boolean removeByTicketTypeId(String ticketTypeId);

    /**
    * resetByTicketTypeId
    * @param ticketTypeId
    * @return
    */
    boolean resetByTicketTypeId(String ticketTypeId);

    /**
    * saveByTicketTypeId
    * @param ticketTypeId
    * @param list
    * @return
    */
    default boolean saveByTicketTypeId(String ticketTypeId, List<ProductTicketType> list){
        return getSelf().saveByTicketType(new TicketType().setId(ticketTypeId),list);
    }

    /**
    * saveByTicketType
    * @param ticketType
    * @param list
    * @return
    */
    boolean saveByTicketType(TicketType ticketType, List<ProductTicketType> list);


    default ImportResult importData(String config, Boolean ignoreError, List<ProductTicketType> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ProductTicketType et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getTicketTypeName(),ex.getMessage());
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
    default ProductTicketType getEntity() {
        return new ProductTicketType();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ProductTicketTypeSearchContext getSearchContext() {
        return new ProductTicketTypeSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}