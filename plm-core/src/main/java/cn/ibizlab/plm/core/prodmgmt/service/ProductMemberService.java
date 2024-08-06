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
    boolean create(List<ProductMember> list);

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
    boolean update(List<ProductMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProductMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ProductMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ProductMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProductMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ProductMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ProductMember get(String key) {
        return getSelf().get(new ProductMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProductMember get(ProductMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ProductMember> get(Collection<String> keys) {
        List<ProductMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProductMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ProductMember> get(List<ProductMember> entities);

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
    CheckKeyStatus checkKey(ProductMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ProductMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ProductMember> list);

    /**
    * changeRole
    * 
    * @param et
    * @return
    */
    default ProductMember changeRole(ProductMember et) {
        return et;
    }

    /**
    * createProductMember
    * 
    * @param et
    * @return
    */
    default ProductMember createProductMember(ProductMember et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default ProductMember nothing(ProductMember et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ProductMember> fetchDefault(ProductMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ProductMember> listDefault(ProductMemberSearchContext context);

    /**
    * fetchCurProduct
    * 
    * @param context
    * @return
    */
    Page<ProductMember> fetchCurProduct(ProductMemberSearchContext context);

    /**
    * listCurProduct
    * 
    * @param context
    * @return
    */
    List<ProductMember> listCurProduct(ProductMemberSearchContext context);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<ProductMember> findByProductId(List<String> productIds);
    default List<ProductMember> findByProductId(String productId){
        return findByProduct(new Product().setId(productId));
    }

    /**
    * findByProduct
    * @param product
    * @return
    */
    List<ProductMember> findByProduct(Product product);

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
    default boolean saveByProductId(String productId, List<ProductMember> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<ProductMember> list);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<ProductMember> findByUserId(List<String> userIds);
    default List<ProductMember> findByUserId(String userId){
        return findByUser(new User().setId(userId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<ProductMember> findByUser(User user);

    /**
    * removeByUserId
    * @param userId
    * @return
    */
    boolean removeByUserId(String userId);

    /**
    * resetByUserId
    * @param userId
    * @return
    */
    boolean resetByUserId(String userId);

    /**
    * saveByUserId
    * @param userId
    * @param list
    * @return
    */
    default boolean saveByUserId(String userId, List<ProductMember> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<ProductMember> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ProductMember> fetchView(ProductMemberSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ProductMember> listView(ProductMemberSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}