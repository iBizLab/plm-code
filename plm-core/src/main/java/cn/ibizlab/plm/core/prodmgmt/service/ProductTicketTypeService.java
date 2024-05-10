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
     * 获取
     * @param et
     * @return
     */
    ProductTicketType get(ProductTicketType et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ProductTicketType get(String key) {
        return getSelf().get(new ProductTicketType().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ProductTicketType> getByIds(Collection<String> ids) {
        List<ProductTicketType> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProductTicketType().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ProductTicketType> getByEntities(List<ProductTicketType> entities);

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
    boolean createBatch(List<ProductTicketType> list);

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
    boolean updateBatch(List<ProductTicketType> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ProductTicketType et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ProductTicketType> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProductTicketType().setId(key));
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
    boolean remove(ProductTicketType et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ProductTicketType> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProductTicketType().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ProductTicketType> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<ProductTicketType> searchDefault(ProductTicketTypeSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ProductTicketType> listDefault(ProductTicketTypeSearchContext context);

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
     * selectRelByProductId
     * @param productIds
     * @return
     */
    List<ProductTicketType> findByProductId(List<String> productIds);
    default List<ProductTicketType> findByProductId(String productId) {
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
    default boolean saveByProductId(String productId,List<ProductTicketType> list) {
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }
    /**
    * saveRelByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product,List<ProductTicketType> list);

    /**
     * selectRelByTicketTypeId
     * @param ticketTypeIds
     * @return
     */
    List<ProductTicketType> findByTicketTypeId(List<String> ticketTypeIds);
    default List<ProductTicketType> findByTicketTypeId(String ticketTypeId) {
        return findByTicketTypeId(Arrays.asList(ticketTypeId));
    }
    /**
     * removeRelByTicketTypeId
     * @param ticketTypeId
     * @return
     */
    boolean removeByTicketTypeId(String ticketTypeId);
    /**
     * resetRelByTicketTypeId
     * @param ticketTypeId
     * @return
     */
    boolean resetByTicketTypeId(String ticketTypeId);
    /**
     * saveRelByTicketTypeId
     * @param ticketTypeId
     * @param list
     * @return
     */
    default boolean saveByTicketTypeId(String ticketTypeId,List<ProductTicketType> list) {
        return getSelf().saveByTicketType(new TicketType().setId(ticketTypeId),list);
    }
    /**
    * saveRelByTicketType
    * @param ticketType
    * @param list
    * @return
    */
    boolean saveByTicketType(TicketType ticketType,List<ProductTicketType> list);


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