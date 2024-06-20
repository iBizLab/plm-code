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
    boolean create(List<Customer> list);

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
    boolean update(List<Customer> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Customer().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Customer et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Customer> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Customer().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Customer> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Customer get(String key) {
        return getSelf().get(new Customer().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Customer get(Customer et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Customer> get(Collection<String> keys) {
        List<Customer> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Customer().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Customer> get(List<Customer> entities);

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
    * 保存
    * @param et
    * @return
    */
    boolean save(Customer et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Customer> list);

    /**
    * addCategories
    * 
    * @param et
    * @return
    */
    default Customer addCategories(Customer et) {
        return et;
    }

    /**
    * customerChooseTicket
    * 
    * @param et
    * @return
    */
    default Customer customerChooseTicket(Customer et) {
        return et;
    }

    /**
    * customerReadonlyRecognize
    * 
    * @param et
    * @return
    */
    default Customer customerReadonlyRecognize(Customer et) {
        return et;
    }

    /**
    * delRelation
    * 
    * @param et
    * @return
    */
    default Customer delRelation(Customer et) {
        return et;
    }

    /**
    * deleteCategories
    * 
    * @param et
    * @return
    */
    default Customer deleteCategories(Customer et) {
        return et;
    }

    /**
    * getAttention
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
    * @param et
    * @return
    */
    default Customer nothing(Customer et) {
        return et;
    }

    /**
    * othersRelationCustomer
    * 
    * @param et
    * @return
    */
    default Customer othersRelationCustomer(Customer et) {
        return et;
    }

    /**
    * productCustomerReCounters
    * 
    * @param et
    * @return
    */
    default Customer productCustomerReCounters(Customer et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Customer> fetchDefault(CustomerSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Customer> listDefault(CustomerSearchContext context);

    /**
    * fetchCommentNotifyAssignee
    * 
    * @param context
    * @return
    */
    Page<Customer> fetchCommentNotifyAssignee(CustomerSearchContext context);

    /**
    * listCommentNotifyAssignee
    * 
    * @param context
    * @return
    */
    List<Customer> listCommentNotifyAssignee(CustomerSearchContext context);

    /**
    * fetchIdeaNotreCustomer
    * 
    * @param context
    * @return
    */
    Page<Customer> fetchIdeaNotreCustomer(CustomerSearchContext context);

    /**
    * listIdeaNotreCustomer
    * 
    * @param context
    * @return
    */
    List<Customer> listIdeaNotreCustomer(CustomerSearchContext context);

    /**
    * fetchIdeaRelationCustomer
    * 
    * @param context
    * @return
    */
    Page<Customer> fetchIdeaRelationCustomer(CustomerSearchContext context);

    /**
    * listIdeaRelationCustomer
    * 
    * @param context
    * @return
    */
    List<Customer> listIdeaRelationCustomer(CustomerSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<Customer> fetchNormal(CustomerSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<Customer> listNormal(CustomerSearchContext context);

    /**
    * fetchNotifyAssignee
    * 
    * @param context
    * @return
    */
    Page<Customer> fetchNotifyAssignee(CustomerSearchContext context);

    /**
    * listNotifyAssignee
    * 
    * @param context
    * @return
    */
    List<Customer> listNotifyAssignee(CustomerSearchContext context);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<Customer> findByProductId(List<String> productIds);
    default List<Customer> findByProductId(String productId){
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
    default boolean saveByProductId(String productId, List<Customer> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<Customer> list);

    /**
    * findByAssigneeId
    * @param assigneeIds
    * @return
    */
    List<Customer> findByAssigneeId(List<String> assigneeIds);
    default List<Customer> findByAssigneeId(String assigneeId){
        return findByAssigneeId(Arrays.asList(assigneeId));
    }

    /**
    * removeByAssigneeId
    * @param assigneeId
    * @return
    */
    boolean removeByAssigneeId(String assigneeId);

    /**
    * resetByAssigneeId
    * @param assigneeId
    * @return
    */
    boolean resetByAssigneeId(String assigneeId);

    /**
    * saveByAssigneeId
    * @param assigneeId
    * @param list
    * @return
    */
    default boolean saveByAssigneeId(String assigneeId, List<Customer> list){
        return getSelf().saveByUser(new User().setId(assigneeId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<Customer> list);

    default List<Attention> getAttentions(Customer et) {
        return new ArrayList<>();
    }


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}