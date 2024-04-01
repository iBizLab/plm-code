/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 工单Mapper[Ticket]
 *
 * @author generator
 */
public interface TicketMapper extends BaseMapper<Ticket> {

    /**
     * 数据集合Advanced_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchAdvancedSearch(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Advanced_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listAdvancedSearch(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchArchived(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listArchived(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Comment_notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchCommentNotifyAssignee(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Comment_notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listCommentNotifyAssignee(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Common分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchCommon(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Common查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listCommon(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Customer_notre_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchCustomerNotreTicket(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Customer_notre_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listCustomerNotreTicket(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Customer_relation_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchCustomerRelationTicket(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Customer_relation_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listCustomerRelationTicket(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchDefault(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listDefault(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchDeleted(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listDeleted(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Idea_relation_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchIdeaRelationTicket(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Idea_relation_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listIdeaRelationTicket(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合My_assign分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchMyAssign(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合My_assign查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listMyAssign(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合My_assignee_count分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchMyAssigneeCount(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合My_assignee_count查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listMyAssigneeCount(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合My_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchMyAttention(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合My_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listMyAttention(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合My_created分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchMyCreated(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合My_created查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listMyCreated(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchNormal(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listNormal(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Not_exsists_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchNotExsistsRelation(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Not_exsists_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listNotExsistsRelation(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchNotifyAssignee(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listNotifyAssignee(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Recent_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchRecentTicket(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Recent_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listRecentTicket(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Ticket_re_product_tag分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchTicketReProductTag(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Ticket_re_product_tag查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listTicketReProductTag(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Ticket_relation_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchTicketRelationTicket(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Ticket_relation_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listTicketRelationTicket(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 数据集合Work_item_relation_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Ticket> searchWorkItemRelationTicket(IPage<Ticket> page, @Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);
    
    /**
     * 数据集合Work_item_relation_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Ticket> listWorkItemRelationTicket(@Param("ctx") TicketSearchContext context, @Param("ew") Wrapper<Ticket> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Ticket selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Ticket selectEntity(Ticket entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Ticket> selectEntities(@Param("list") List<Ticket> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Ticket entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Ticket entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Ticket entity, @Param("ew") Wrapper<Ticket> updateWrapper);

    /**
     * 主键删除
     *
     * @param id
     * @return
     */
    @Override
    int deleteById(Serializable id);

    /**
     * 数据对象集合删除
     *
     * @param list
     * @return
     */
    int deleteEntities(@Param("list") List<Ticket> list);

    /**
     * 自定义查询SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Select("${sql}")
    List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义更新SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义插入SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义删除SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 根据customerId查询
     *
     * @param customerIds
     * @return
     */
    List<Ticket> findByCustomerId(@Param("customerIds") List<String> customerIds);

    /**
     * 根据productId查询
     *
     * @param productIds
     * @return
     */
    List<Ticket> findByProductId(@Param("productIds") List<String> productIds);

    /**
     * 根据assigneeId查询
     *
     * @param assigneeIds
     * @return
     */
    List<Ticket> findByAssigneeId(@Param("assigneeIds") List<String> assigneeIds);

}