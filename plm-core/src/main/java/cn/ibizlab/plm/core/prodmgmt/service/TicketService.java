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
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attachment;

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
     * 获取
     * @param et
     * @return
     */
    Ticket get(Ticket et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Ticket get(String key) {
        return getSelf().get(new Ticket().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Ticket> getByIds(Collection<String> ids) {
        List<Ticket> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Ticket().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Ticket> getByEntities(List<Ticket> entities);

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
    Integer checkKey(Ticket et);

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
    boolean createBatch(List<Ticket> list);

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
    boolean updateBatch(List<Ticket> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Ticket et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Ticket> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Ticket().setId(key));
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
    boolean remove(Ticket et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Ticket> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Ticket().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Ticket> entities);

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
     * Activate
     * 
     * @param dto
     * @return
     */
    default Ticket activate(Ticket dto) {
        return dto;
    }

    /**
     * Allocate_person
     * 
     * @param dto
     * @return
     */
    default Ticket allocatePerson(Ticket dto) {
        return dto;
    }

    /**
     * Archive
     * 
     * @param dto
     * @return
     */
    default Ticket archive(Ticket dto) {
        return dto;
    }

    /**
     * Choose_tag
     * 
     * @param dto
     * @return
     */
    default Ticket chooseTag(Ticket dto) {
        return dto;
    }

    /**
     * Customer_choose_ticket
     * 
     * @param dto
     * @return
     */
    default Ticket customerChooseTicket(Ticket dto) {
        return dto;
    }

    /**
     * Customer_del_ticket
     * 
     * @param dto
     * @return
     */
    default Ticket customerDelTicket(Ticket dto) {
        return dto;
    }

    /**
     * Del_relation
     * 
     * @param dto
     * @return
     */
    default Ticket delRelation(Ticket dto) {
        return dto;
    }

    /**
     * Delete
     * 
     * @param dto
     * @return
     */
    default Ticket delete(Ticket dto) {
        return dto;
    }

    /**
     * Get_attention
     * 
     * @param key
     * @return
     */
    default Ticket getAttention(String key) {
        return null;
    }

    /**
     * Nothing
     * 
     * @param dto
     * @return
     */
    default Ticket nothing(Ticket dto) {
        return dto;
    }

    /**
     * Others_relation_ticket
     * 
     * @param dto
     * @return
     */
    default Ticket othersRelationTicket(Ticket dto) {
        return dto;
    }

    /**
     * Product_ticket_re_counters
     * 
     * @param dto
     * @return
     */
    default Ticket productTicketReCounters(Ticket dto) {
        return dto;
    }

    /**
     * Recover
     * 
     * @param dto
     * @return
     */
    default Ticket recover(Ticket dto) {
        return dto;
    }

    /**
     * searchArchived
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchArchived(TicketSearchContext context);
    /**
     * listArchived
     * 
     * @param context
     * @return
     */
    List<Ticket> listArchived(TicketSearchContext context);

    /**
     * searchComment_notify_assignee
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchCommentNotifyAssignee(TicketSearchContext context);
    /**
     * listComment_notify_assignee
     * 
     * @param context
     * @return
     */
    List<Ticket> listCommentNotifyAssignee(TicketSearchContext context);

    /**
     * searchCommon
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchCommon(TicketSearchContext context);
    /**
     * listCommon
     * 
     * @param context
     * @return
     */
    List<Ticket> listCommon(TicketSearchContext context);

    /**
     * searchCustomer_notre_ticket
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchCustomerNotreTicket(TicketSearchContext context);
    /**
     * listCustomer_notre_ticket
     * 
     * @param context
     * @return
     */
    List<Ticket> listCustomerNotreTicket(TicketSearchContext context);

    /**
     * searchCustomer_relation_ticket
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchCustomerRelationTicket(TicketSearchContext context);
    /**
     * listCustomer_relation_ticket
     * 
     * @param context
     * @return
     */
    List<Ticket> listCustomerRelationTicket(TicketSearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchDefault(TicketSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Ticket> listDefault(TicketSearchContext context);

    /**
     * searchDeleted
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchDeleted(TicketSearchContext context);
    /**
     * listDeleted
     * 
     * @param context
     * @return
     */
    List<Ticket> listDeleted(TicketSearchContext context);

    /**
     * searchIdea_relation_ticket
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchIdeaRelationTicket(TicketSearchContext context);
    /**
     * listIdea_relation_ticket
     * 
     * @param context
     * @return
     */
    List<Ticket> listIdeaRelationTicket(TicketSearchContext context);

    /**
     * searchMy_assign
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchMyAssign(TicketSearchContext context);
    /**
     * listMy_assign
     * 
     * @param context
     * @return
     */
    List<Ticket> listMyAssign(TicketSearchContext context);

    /**
     * searchMy_assignee_count
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchMyAssigneeCount(TicketSearchContext context);
    /**
     * listMy_assignee_count
     * 
     * @param context
     * @return
     */
    List<Ticket> listMyAssigneeCount(TicketSearchContext context);

    /**
     * searchMy_attention
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchMyAttention(TicketSearchContext context);
    /**
     * listMy_attention
     * 
     * @param context
     * @return
     */
    List<Ticket> listMyAttention(TicketSearchContext context);

    /**
     * searchMy_created
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchMyCreated(TicketSearchContext context);
    /**
     * listMy_created
     * 
     * @param context
     * @return
     */
    List<Ticket> listMyCreated(TicketSearchContext context);

    /**
     * searchNormal
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchNormal(TicketSearchContext context);
    /**
     * listNormal
     * 
     * @param context
     * @return
     */
    List<Ticket> listNormal(TicketSearchContext context);

    /**
     * searchNot_exsists_relation
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchNotExsistsRelation(TicketSearchContext context);
    /**
     * listNot_exsists_relation
     * 
     * @param context
     * @return
     */
    List<Ticket> listNotExsistsRelation(TicketSearchContext context);

    /**
     * searchRecent_ticket
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchRecentTicket(TicketSearchContext context);
    /**
     * listRecent_ticket
     * 
     * @param context
     * @return
     */
    List<Ticket> listRecentTicket(TicketSearchContext context);

    /**
     * searchTicket_re_product_tag
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchTicketReProductTag(TicketSearchContext context);
    /**
     * listTicket_re_product_tag
     * 
     * @param context
     * @return
     */
    List<Ticket> listTicketReProductTag(TicketSearchContext context);

    /**
     * searchTicket_relation_ticket
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchTicketRelationTicket(TicketSearchContext context);
    /**
     * listTicket_relation_ticket
     * 
     * @param context
     * @return
     */
    List<Ticket> listTicketRelationTicket(TicketSearchContext context);

    /**
     * searchWork_item_relation_ticket
     * 
     * @param context
     * @return
     */
    Page<Ticket> searchWorkItemRelationTicket(TicketSearchContext context);
    /**
     * listWork_item_relation_ticket
     * 
     * @param context
     * @return
     */
    List<Ticket> listWorkItemRelationTicket(TicketSearchContext context);

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
     * selectRelByCustomerId
     * @param customerIds
     * @return
     */
    List<Ticket> findByCustomerId(List<String> customerIds);
    default List<Ticket> findByCustomerId(String customerId) {
        return findByCustomerId(Arrays.asList(customerId));
    }
    /**
     * removeRelByCustomerId
     * @param customerId
     * @return
     */
    boolean removeByCustomerId(String customerId);
    /**
     * resetRelByCustomerId
     * @param customerId
     * @return
     */
    boolean resetByCustomerId(String customerId);
    /**
     * saveRelByCustomerId
     * @param customerId
     * @param list
     * @return
     */
    default boolean saveByCustomerId(String customerId,List<Ticket> list) {
        return getSelf().saveByCustomer(new Customer().setId(customerId),list);
    }
    /**
    * saveRelByCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByCustomer(Customer customer,List<Ticket> list);

    /**
     * selectRelByProductId
     * @param productIds
     * @return
     */
    List<Ticket> findByProductId(List<String> productIds);
    default List<Ticket> findByProductId(String productId) {
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
    default boolean saveByProductId(String productId,List<Ticket> list) {
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }
    /**
    * saveRelByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product,List<Ticket> list);

    /**
     * selectRelByAssigneeId
     * @param assigneeIds
     * @return
     */
    List<Ticket> findByAssigneeId(List<String> assigneeIds);
    default List<Ticket> findByAssigneeId(String assigneeId) {
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
    default boolean saveByAssigneeId(String assigneeId,List<Ticket> list) {
        return getSelf().saveByUser(new User().setId(assigneeId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<Ticket> list);

    default List<Attention> getAttentions(Ticket et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(Ticket et) {
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