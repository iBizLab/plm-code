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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductMemberSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 产品成员服务接口[ProductMemberService]
 *
 * @author generator
 */
public interface ProductMemberService extends IService<ProductMember> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProductMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProductMember get(ProductMember et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ProductMember get(String key) {
        return getSelf().get(new ProductMember().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ProductMember> getByIds(Collection<String> ids) {
        List<ProductMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProductMember().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ProductMember> getByEntities(List<ProductMember> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    ProductMember getDraft(ProductMember et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(ProductMember et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(ProductMember et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<ProductMember> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(ProductMember et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<ProductMember> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ProductMember et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ProductMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProductMember().setId(key));
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
    boolean remove(ProductMember et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ProductMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProductMember().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ProductMember> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<ProductMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ProductMember et=list.get(i);
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
     * change_role
     * 
     * @param dto
     * @return
     */
    default ProductMember changeRole(ProductMember dto) {
        return dto;
    }

    /**
     * create_product_member
     * 
     * @param dto
     * @return
     */
    default ProductMember createProductMember(ProductMember dto) {
        return dto;
    }

    /**
     * nothing
     * 
     * @param dto
     * @return
     */
    default ProductMember nothing(ProductMember dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<ProductMember> searchDefault(ProductMemberSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ProductMember> listDefault(ProductMemberSearchContext context);

    /**
     * searchcur_product
     * 
     * @param context
     * @return
     */
    Page<ProductMember> searchCurProduct(ProductMemberSearchContext context);
    /**
     * listcur_product
     * 
     * @param context
     * @return
     */
    List<ProductMember> listCurProduct(ProductMemberSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default ProductMember getEntity() {
        return new ProductMember();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ProductMemberSearchContext getSearchContext() {
        return new ProductMemberSearchContext();
    }
    /**
     * selectRelByProductId
     * @param productIds
     * @return
     */
    List<ProductMember> findByProductId(List<String> productIds);
    default List<ProductMember> findByProductId(String productId) {
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
    default boolean saveByProductId(String productId,List<ProductMember> list) {
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }
    /**
    * saveRelByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product,List<ProductMember> list);

    /**
     * selectRelByUserId
     * @param userIds
     * @return
     */
    List<ProductMember> findByUserId(List<String> userIds);
    default List<ProductMember> findByUserId(String userId) {
        return findByUserId(Arrays.asList(userId));
    }
    /**
     * removeRelByUserId
     * @param userId
     * @return
     */
    boolean removeByUserId(String userId);
    /**
     * resetRelByUserId
     * @param userId
     * @return
     */
    boolean resetByUserId(String userId);
    /**
     * saveRelByUserId
     * @param userId
     * @param list
     * @return
     */
    default boolean saveByUserId(String userId,List<ProductMember> list) {
        return getSelf().saveByUser(new User().setId(userId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<ProductMember> list);


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