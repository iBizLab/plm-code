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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTag;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
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
     * 获取
     * @param et
     * @return
     */
    Product get(Product et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Product get(String key) {
        return getSelf().get(new Product().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Product> getByIds(Collection<String> ids) {
        List<Product> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Product().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Product> getByEntities(List<Product> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Product getDraft(Product et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Product et);

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
    boolean createBatch(List<Product> list);

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
    boolean updateBatch(List<Product> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Product et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Product> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Product().setId(key));
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
    boolean remove(Product et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Product> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Product().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Product> entities);

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
     * CreateTemp
     * 
     * @param dto
     * @return
     */
    default Product createTemp(Product dto) {
        return dto;
    }

    /**
     * CreateTempMajor
     * 
     * @param dto
     * @return
     */
    default Product createTempMajor(Product dto) {
        return dto;
    }

    /**
     * UpdateTemp
     * 
     * @param dto
     * @return
     */
    default Product updateTemp(Product dto) {
        return dto;
    }

    /**
     * UpdateTempMajor
     * 
     * @param dto
     * @return
     */
    default Product updateTempMajor(Product dto) {
        return dto;
    }

    /**
     * RemoveTemp
     * 
     * @param keys
     * @return
     */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
     * RemoveTempMajor
     * 
     * @param keys
     * @return
     */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
     * GetTemp
     * 
     * @param key
     * @return
     */
    default Product getTemp(String key) {
        return null;
    }

    /**
     * GetTempMajor
     * 
     * @param key
     * @return
     */
    default Product getTempMajor(String key) {
        return null;
    }

    /**
     * GetDraftTemp
     * 
     * @param dto
     * @return
     */
    default Product getDraftTemp(Product dto) {
        return dto;
    }

    /**
     * GetDraftTempMajor
     * 
     * @param dto
     * @return
     */
    default Product getDraftTempMajor(Product dto) {
        return dto;
    }

    /**
     * activate
     * 
     * @param dto
     * @return
     */
    default Product activate(Product dto) {
        return dto;
    }

    /**
     * archive
     * 
     * @param dto
     * @return
     */
    default Product archive(Product dto) {
        return dto;
    }

    /**
     * delete
     * 
     * @param dto
     * @return
     */
    default Product delete(Product dto) {
        return dto;
    }

    /**
     * favorite
     * 
     * @param dto
     * @return
     */
    default Product favorite(Product dto) {
        return dto;
    }

    /**
     * other_re_space
     * 
     * @param dto
     * @return
     */
    default Product otherReSpace(Product dto) {
        return dto;
    }

    /**
     * product_counters
     * 
     * @param dto
     * @return
     */
    default Product productCounters(Product dto) {
        return dto;
    }

    /**
     * recover
     * 
     * @param dto
     * @return
     */
    default Product recover(Product dto) {
        return dto;
    }

    /**
     * un_favorite
     * 
     * @param dto
     * @return
     */
    default Product unFavorite(Product dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Product> searchDefault(ProductSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Product> listDefault(ProductSearchContext context);

    /**
     * searchadmin
     * 
     * @param context
     * @return
     */
    Page<Product> searchAdmin(ProductSearchContext context);
    /**
     * listadmin
     * 
     * @param context
     * @return
     */
    List<Product> listAdmin(ProductSearchContext context);

    /**
     * searcharchived
     * 
     * @param context
     * @return
     */
    Page<Product> searchArchived(ProductSearchContext context);
    /**
     * listarchived
     * 
     * @param context
     * @return
     */
    List<Product> listArchived(ProductSearchContext context);

    /**
     * searchdeleted
     * 
     * @param context
     * @return
     */
    Page<Product> searchDeleted(ProductSearchContext context);
    /**
     * listdeleted
     * 
     * @param context
     * @return
     */
    List<Product> listDeleted(ProductSearchContext context);

    /**
     * searchfavorite
     * 
     * @param context
     * @return
     */
    Page<Product> searchFavorite(ProductSearchContext context);
    /**
     * listfavorite
     * 
     * @param context
     * @return
     */
    List<Product> listFavorite(ProductSearchContext context);

    /**
     * searchnormal
     * 
     * @param context
     * @return
     */
    Page<Product> searchNormal(ProductSearchContext context);
    /**
     * listnormal
     * 
     * @param context
     * @return
     */
    List<Product> listNormal(ProductSearchContext context);

    /**
     * searchreader
     * 
     * @param context
     * @return
     */
    Page<Product> searchReader(ProductSearchContext context);
    /**
     * listreader
     * 
     * @param context
     * @return
     */
    List<Product> listReader(ProductSearchContext context);

    /**
     * searchuser
     * 
     * @param context
     * @return
     */
    Page<Product> searchUser(ProductSearchContext context);
    /**
     * listuser
     * 
     * @param context
     * @return
     */
    List<Product> listUser(ProductSearchContext context);

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
    default List<ProductMember> getMembers(Product et) {
        return new ArrayList<>();
    }


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