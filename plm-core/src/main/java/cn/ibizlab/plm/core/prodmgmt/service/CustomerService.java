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
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.filter.CustomerSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.domain.Relation;

/**
 * 客户服务接口[CustomerService]
 *
 * @author generator
 */
public interface CustomerService extends IService<Customer> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default CustomerService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Customer get(Customer et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Customer get(String key) {
        return getSelf().get(new Customer().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Customer> getByIds(Collection<String> ids) {
        List<Customer> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Customer().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Customer> getByEntities(List<Customer> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Customer getDraft(Customer et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Customer et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Customer et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Customer> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Customer et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Customer> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Customer et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Customer> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Customer().setId(key));
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
    boolean remove(Customer et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Customer> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Customer().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Customer> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Customer> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Customer et=list.get(i);
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
     * add_categories
     * 
     * @param dto
     * @return
     */
    default Customer addCategories(Customer dto) {
        return dto;
    }

    /**
     * customer_choose_ticket
     * 
     * @param dto
     * @return
     */
    default Customer customerChooseTicket(Customer dto) {
        return dto;
    }

    /**
     * del_relation
     * 
     * @param dto
     * @return
     */
    default Customer delRelation(Customer dto) {
        return dto;
    }

    /**
     * delete_categories
     * 
     * @param dto
     * @return
     */
    default Customer deleteCategories(Customer dto) {
        return dto;
    }

    /**
     * fill_product_member
     * 
     * @param dto
     * @return
     */
    default Customer fillProductMember(Customer dto) {
        return dto;
    }

    /**
     * get_attention
     * 
     * @param key
     * @return
     */
    default Customer getAttention(String key) {
        return null;
    }

    /**
     * nothing
     * 
     * @param dto
     * @return
     */
    default Customer nothing(Customer dto) {
        return dto;
    }

    /**
     * others_relation_customer
     * 
     * @param dto
     * @return
     */
    default Customer othersRelationCustomer(Customer dto) {
        return dto;
    }

    /**
     * product_customer_re_counters
     * 
     * @param dto
     * @return
     */
    default Customer productCustomerReCounters(Customer dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Customer> searchDefault(CustomerSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Customer> listDefault(CustomerSearchContext context);

    /**
     * searchcomment_notify_assignee
     * 
     * @param context
     * @return
     */
    Page<Customer> searchCommentNotifyAssignee(CustomerSearchContext context);
    /**
     * listcomment_notify_assignee
     * 
     * @param context
     * @return
     */
    List<Customer> listCommentNotifyAssignee(CustomerSearchContext context);

    /**
     * searchidea_notre_customer
     * 
     * @param context
     * @return
     */
    Page<Customer> searchIdeaNotreCustomer(CustomerSearchContext context);
    /**
     * listidea_notre_customer
     * 
     * @param context
     * @return
     */
    List<Customer> listIdeaNotreCustomer(CustomerSearchContext context);

    /**
     * searchidea_relation_customer
     * 
     * @param context
     * @return
     */
    Page<Customer> searchIdeaRelationCustomer(CustomerSearchContext context);
    /**
     * listidea_relation_customer
     * 
     * @param context
     * @return
     */
    List<Customer> listIdeaRelationCustomer(CustomerSearchContext context);

    /**
     * searchnormal
     * 
     * @param context
     * @return
     */
    Page<Customer> searchNormal(CustomerSearchContext context);
    /**
     * listnormal
     * 
     * @param context
     * @return
     */
    List<Customer> listNormal(CustomerSearchContext context);

    /**
     * searchnotify_assignee
     * 
     * @param context
     * @return
     */
    Page<Customer> searchNotifyAssignee(CustomerSearchContext context);
    /**
     * listnotify_assignee
     * 
     * @param context
     * @return
     */
    List<Customer> listNotifyAssignee(CustomerSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Customer getEntity() {
        return new Customer();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default CustomerSearchContext getSearchContext() {
        return new CustomerSearchContext();
    }
    /**
     * selectRelByProductId
     * @param productIds
     * @return
     */
    List<Customer> findByProductId(List<String> productIds);
    default List<Customer> findByProductId(String productId) {
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
    default boolean saveByProductId(String productId,List<Customer> list) {
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }
    /**
    * saveRelByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product,List<Customer> list);

    /**
     * selectRelByAssigneeId
     * @param assigneeIds
     * @return
     */
    List<Customer> findByAssigneeId(List<String> assigneeIds);
    default List<Customer> findByAssigneeId(String assigneeId) {
        return findByAssigneeId(Arrays.asList(assigneeId));
    }
    /**
     * removeRelByAssigneeId
     * @param assigneeId
     * @return
     */
    boolean removeByAssigneeId(String assigneeId);
    /**
     * resetRelByAssigneeId
     * @param assigneeId
     * @return
     */
    boolean resetByAssigneeId(String assigneeId);
    /**
     * saveRelByAssigneeId
     * @param assigneeId
     * @param list
     * @return
     */
    default boolean saveByAssigneeId(String assigneeId,List<Customer> list) {
        return getSelf().saveByUser(new User().setId(assigneeId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<Customer> list);

    default List<Attention> getAttentions(Customer et) {
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