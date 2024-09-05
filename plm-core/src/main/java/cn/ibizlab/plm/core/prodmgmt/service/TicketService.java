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
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;

/**
 * 工单服务接口[TicketService]
 *
 * @author generator
 */
public interface TicketService extends IService<Ticket> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default TicketService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Ticket et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Ticket> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Ticket et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Ticket> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Ticket().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Ticket et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Ticket> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Ticket().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Ticket> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Ticket get(String key) {
        return getSelf().get(new Ticket().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Ticket get(Ticket et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Ticket> get(Collection<String> keys) {
        List<Ticket> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Ticket().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Ticket> get(List<Ticket> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Ticket getDraft(Ticket et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Ticket et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Ticket et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Ticket> list);

    /**
    * activate
    * 
    * @param et
    * @return
    */
    default Ticket activate(Ticket et) {
        return et;
    }

    /**
    * allocatePerson
    * 
    * @param et
    * @return
    */
    default Ticket allocatePerson(Ticket et) {
        return et;
    }

    /**
    * archive
    * 
    * @param et
    * @return
    */
    default Ticket archive(Ticket et) {
        return et;
    }

    /**
    * chooseTag
    * 
    * @param et
    * @return
    */
    default Ticket chooseTag(Ticket et) {
        return et;
    }

    /**
    * customerChooseTicket
    * 
    * @param et
    * @return
    */
    default Ticket customerChooseTicket(Ticket et) {
        return et;
    }

    /**
    * customerDelTicket
    * 
    * @param et
    * @return
    */
    default Ticket customerDelTicket(Ticket et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default Ticket delete(Ticket et) {
        return et;
    }

    /**
    * fillBiFormDefault
    * 
    * @param et
    * @return
    */
    default Ticket fillBiFormDefault(Ticket et) {
        return et;
    }

    /**
    * getAttention
    * 
    * @param key
    * @return
    */
    default Ticket getAttention(String key) {
        return null;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Ticket nothing(Ticket et) {
        return et;
    }

    /**
    * othersRelationTicket
    * 
    * @param et
    * @return
    */
    default Ticket othersRelationTicket(Ticket et) {
        return et;
    }

    /**
    * productTicketReCounters
    * 
    * @param et
    * @return
    */
    default Ticket productTicketReCounters(Ticket et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default Ticket recover(Ticket et) {
        return et;
    }

    /**
    * testGetArchivedInfo
    * 
    * @param key
    * @return
    */
    default Ticket testGetArchivedInfo(String key) {
        return getSelf().testGetArchivedInfo(new Ticket().setId(key));
    }

    /**
    * ticketReadonlyRecognize
    * 
    * @param et
    * @return
    */
    default Ticket ticketReadonlyRecognize(Ticket et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchDefault(TicketSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Ticket> listDefault(TicketSearchContext context);

    /**
    * fetchAdvancedSearch
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchAdvancedSearch(TicketSearchContext context);

    /**
    * listAdvancedSearch
    * 
    * @param context
    * @return
    */
    List<Ticket> listAdvancedSearch(TicketSearchContext context);

    /**
    * fetchArchived
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchArchived(TicketSearchContext context);

    /**
    * listArchived
    * 
    * @param context
    * @return
    */
    List<Ticket> listArchived(TicketSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchBiDetail(TicketSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<Ticket> listBiDetail(TicketSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchBiSearch(TicketSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<Ticket> listBiSearch(TicketSearchContext context);

    /**
    * fetchCommentNotifyAssignee
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchCommentNotifyAssignee(TicketSearchContext context);

    /**
    * listCommentNotifyAssignee
    * 
    * @param context
    * @return
    */
    List<Ticket> listCommentNotifyAssignee(TicketSearchContext context);

    /**
    * fetchCommon
    * 通用查询，非删除数据
    * @param context
    * @return
    */
    Page<Ticket> fetchCommon(TicketSearchContext context);

    /**
    * listCommon
    * 通用查询，非删除数据
    * @param context
    * @return
    */
    List<Ticket> listCommon(TicketSearchContext context);

    /**
    * fetchCustomerNotreTicket
    * 查询未关联工单的数据；客户关联工单表格调用
    * @param context
    * @return
    */
    Page<Ticket> fetchCustomerNotreTicket(TicketSearchContext context);

    /**
    * listCustomerNotreTicket
    * 查询未关联工单的数据；客户关联工单表格调用
    * @param context
    * @return
    */
    List<Ticket> listCustomerNotreTicket(TicketSearchContext context);

    /**
    * fetchCustomerRelationTicket
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchCustomerRelationTicket(TicketSearchContext context);

    /**
    * listCustomerRelationTicket
    * 
    * @param context
    * @return
    */
    List<Ticket> listCustomerRelationTicket(TicketSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchDeleted(TicketSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<Ticket> listDeleted(TicketSearchContext context);

    /**
    * fetchIdeaRelationTicket
    * 产品关联工单表格调用
    * @param context
    * @return
    */
    Page<Ticket> fetchIdeaRelationTicket(TicketSearchContext context);

    /**
    * listIdeaRelationTicket
    * 产品关联工单表格调用
    * @param context
    * @return
    */
    List<Ticket> listIdeaRelationTicket(TicketSearchContext context);

    /**
    * fetchMyAssign
    * 首页我负责的工单表格调用
    * @param context
    * @return
    */
    Page<Ticket> fetchMyAssign(TicketSearchContext context);

    /**
    * listMyAssign
    * 首页我负责的工单表格调用
    * @param context
    * @return
    */
    List<Ticket> listMyAssign(TicketSearchContext context);

    /**
    * fetchMyAssigneeCount
    * 首页我负责的工单表格调用
    * @param context
    * @return
    */
    Page<Ticket> fetchMyAssigneeCount(TicketSearchContext context);

    /**
    * listMyAssigneeCount
    * 首页我负责的工单表格调用
    * @param context
    * @return
    */
    List<Ticket> listMyAssigneeCount(TicketSearchContext context);

    /**
    * fetchMyAttention
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchMyAttention(TicketSearchContext context);

    /**
    * listMyAttention
    * 
    * @param context
    * @return
    */
    List<Ticket> listMyAttention(TicketSearchContext context);

    /**
    * fetchMyCreated
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchMyCreated(TicketSearchContext context);

    /**
    * listMyCreated
    * 
    * @param context
    * @return
    */
    List<Ticket> listMyCreated(TicketSearchContext context);

    /**
    * fetchMyFilter
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchMyFilter(TicketSearchContext context);

    /**
    * listMyFilter
    * 
    * @param context
    * @return
    */
    List<Ticket> listMyFilter(TicketSearchContext context);

    /**
    * fetchNormal
    * 非归档，非删除数据
    * @param context
    * @return
    */
    Page<Ticket> fetchNormal(TicketSearchContext context);

    /**
    * listNormal
    * 非归档，非删除数据
    * @param context
    * @return
    */
    List<Ticket> listNormal(TicketSearchContext context);

    /**
    * fetchNotExsistsRelation
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchNotExsistsRelation(TicketSearchContext context);

    /**
    * listNotExsistsRelation
    * 
    * @param context
    * @return
    */
    List<Ticket> listNotExsistsRelation(TicketSearchContext context);

    /**
    * fetchNotifyAssignee
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchNotifyAssignee(TicketSearchContext context);

    /**
    * listNotifyAssignee
    * 
    * @param context
    * @return
    */
    List<Ticket> listNotifyAssignee(TicketSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchReader(TicketSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Ticket> listReader(TicketSearchContext context);

    /**
    * fetchRecentTicket
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchRecentTicket(TicketSearchContext context);

    /**
    * listRecentTicket
    * 
    * @param context
    * @return
    */
    List<Ticket> listRecentTicket(TicketSearchContext context);

    /**
    * fetchTicketReProductTag
    * 当前标签下工单表格视图调用
    * @param context
    * @return
    */
    Page<Ticket> fetchTicketReProductTag(TicketSearchContext context);

    /**
    * listTicketReProductTag
    * 当前标签下工单表格视图调用
    * @param context
    * @return
    */
    List<Ticket> listTicketReProductTag(TicketSearchContext context);

    /**
    * fetchTicketRelationTicket
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchTicketRelationTicket(TicketSearchContext context);

    /**
    * listTicketRelationTicket
    * 
    * @param context
    * @return
    */
    List<Ticket> listTicketRelationTicket(TicketSearchContext context);

    /**
    * fetchTicketStatePieChart
    * 工单状态饼图数据
在需求关联工单统计视图中使用
    * @param context
    * @return
    */
    Page<Ticket> fetchTicketStatePieChart(TicketSearchContext context);

    /**
    * listTicketStatePieChart
    * 工单状态饼图数据
在需求关联工单统计视图中使用
    * @param context
    * @return
    */
    List<Ticket> listTicketStatePieChart(TicketSearchContext context);

    /**
    * fetchWorkItemRelationTicket
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchWorkItemRelationTicket(TicketSearchContext context);

    /**
    * listWorkItemRelationTicket
    * 
    * @param context
    * @return
    */
    List<Ticket> listWorkItemRelationTicket(TicketSearchContext context);

    /**
    * findByCustomerId
    * @param customerIds
    * @return
    */
    List<Ticket> findByCustomerId(List<String> customerIds);
    default List<Ticket> findByCustomerId(String customerId){
        return findByCustomer(new Customer().setId(customerId));
    }

    /**
    * findByCustomer
    * @param customer
    * @return
    */
    List<Ticket> findByCustomer(Customer customer);

    /**
    * removeByCustomerId
    * @param customerId
    * @return
    */
    boolean removeByCustomerId(String customerId);

    /**
    * resetByCustomerId
    * @param customerId
    * @return
    */
    boolean resetByCustomerId(String customerId);

    /**
    * saveByCustomerId
    * @param customerId
    * @param list
    * @return
    */
    default boolean saveByCustomerId(String customerId, List<Ticket> list){
        return getSelf().saveByCustomer(new Customer().setId(customerId),list);
    }

    /**
    * saveByCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByCustomer(Customer customer, List<Ticket> list);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<Ticket> findByProductId(List<String> productIds);
    default List<Ticket> findByProductId(String productId){
        return findByProduct(new Product().setId(productId));
    }

    /**
    * findByProduct
    * @param product
    * @return
    */
    List<Ticket> findByProduct(Product product);

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
    default boolean saveByProductId(String productId, List<Ticket> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<Ticket> list);

    /**
    * findByAssigneeId
    * @param assigneeIds
    * @return
    */
    List<Ticket> findByAssigneeId(List<String> assigneeIds);
    default List<Ticket> findByAssigneeId(String assigneeId){
        return findByUser(new User().setId(assigneeId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<Ticket> findByUser(User user);

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
    default boolean saveByAssigneeId(String assigneeId, List<Ticket> list){
        return getSelf().saveByUser(new User().setId(assigneeId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<Ticket> list);

    default List<Attention> getAttentions(Ticket et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(Ticket et) {
        return new ArrayList<>();
    }

    /**
    * testGetArchivedInfo
    * 
    * @param et
    * @return
    */
    default Ticket testGetArchivedInfo(Ticket et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Ticket> fetchView(TicketSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Ticket> listView(TicketSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Ticket> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Ticket et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getTitle(),ex.getMessage());
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
    default Ticket getEntity() {
        return new Ticket();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default TicketSearchContext getSearchContext() {
        return new TicketSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}