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
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Channel;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTag;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;

/**
 * 产品服务接口[ProductService]
 *
 * @author generator
 */
public interface ProductService extends IService<Product> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProductService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Product et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Product> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default Product createTemp(Product et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default Product createTempMajor(Product et) {
        return et;
    }

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Product et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Product> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default Product updateTemp(Product et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default Product updateTempMajor(Product et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Product().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Product et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Product> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Product().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Product> entities);

    /**
    * removeTemp
    * 
    * @param keys
    * @return
    */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
    * removeTempMajor
    * 
    * @param keys
    * @return
    */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
    * 获取
    * @param key
    * @return
    */
    default Product get(String key) {
        return getSelf().get(new Product().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Product get(Product et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Product> get(Collection<String> keys) {
        List<Product> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Product().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Product> get(List<Product> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default Product getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default Product getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    Product getDraft(Product et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default Product getDraftTemp(Product et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default Product getDraftTempMajor(Product et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(Product et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Product et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Product> list);

    /**
    * activate
    * 
    * @param et
    * @return
    */
    default Product activate(Product et) {
        return et;
    }

    /**
    * archive
    * 
    * @param et
    * @return
    */
    default Product archive(Product et) {
        return et;
    }

    /**
    * changeAdminRole
    * 
    * @param et
    * @return
    */
    default Product changeAdminRole(Product et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default Product delete(Product et) {
        return et;
    }

    /**
    * favorite
    * 
    * @param et
    * @return
    */
    default Product favorite(Product et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Product nothing(Product et) {
        return et;
    }

    /**
    * otherReSpace
    * 
    * @param et
    * @return
    */
    default Product otherReSpace(Product et) {
        return et;
    }

    /**
    * productCounters
    * 
    * @param et
    * @return
    */
    default Product productCounters(Product et) {
        return et;
    }

    /**
    * productIndexAddonCounter
    * 
    * @param et
    * @return
    */
    default Product productIndexAddonCounter(Product et) {
        return et;
    }

    /**
    * productMove
    * 
    * @param et
    * @return
    */
    default Product productMove(Product et) {
        return et;
    }

    /**
    * productReadonlyRecognize
    * 
    * @param et
    * @return
    */
    default Product productReadonlyRecognize(Product et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default Product recover(Product et) {
        return et;
    }

    /**
    * unFavorite
    * 
    * @param et
    * @return
    */
    default Product unFavorite(Product et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Product> fetchDefault(ProductSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Product> listDefault(ProductSearchContext context);

    /**
    * fetchAdmin
    * 
    * @param context
    * @return
    */
    Page<Product> fetchAdmin(ProductSearchContext context);

    /**
    * listAdmin
    * 
    * @param context
    * @return
    */
    List<Product> listAdmin(ProductSearchContext context);

    /**
    * fetchArchived
    * 
    * @param context
    * @return
    */
    Page<Product> fetchArchived(ProductSearchContext context);

    /**
    * listArchived
    * 
    * @param context
    * @return
    */
    List<Product> listArchived(ProductSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<Product> fetchDeleted(ProductSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<Product> listDeleted(ProductSearchContext context);

    /**
    * fetchFavorite
    * 
    * @param context
    * @return
    */
    Page<Product> fetchFavorite(ProductSearchContext context);

    /**
    * listFavorite
    * 
    * @param context
    * @return
    */
    List<Product> listFavorite(ProductSearchContext context);

    /**
    * fetchMain
    * 
    * @param context
    * @return
    */
    Page<Product> fetchMain(ProductSearchContext context);

    /**
    * listMain
    * 
    * @param context
    * @return
    */
    List<Product> listMain(ProductSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<Product> fetchNormal(ProductSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<Product> listNormal(ProductSearchContext context);

    /**
    * fetchQuickUser
    * 
    * @param context
    * @return
    */
    Page<Product> fetchQuickUser(ProductSearchContext context);

    /**
    * listQuickUser
    * 
    * @param context
    * @return
    */
    List<Product> listQuickUser(ProductSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Product> fetchReader(ProductSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Product> listReader(ProductSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<Product> fetchUser(ProductSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<Product> listUser(ProductSearchContext context);

    default List<ProductMember> getMembers(Product et) {
        return new ArrayList<>();
    }


    default ImportResult importData(String config, Boolean ignoreError, List<Product> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Product et=list.get(i);
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
    default Product getEntity() {
        return new Product();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ProductSearchContext getSearchContext() {
        return new ProductSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}