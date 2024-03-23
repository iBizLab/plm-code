/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.prodmgmt.mapper.TicketMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.service.CustomerService;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;

/**
 * 实体[工单] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTicketService extends ServiceImpl<TicketMapper,Ticket> implements TicketService {

    @Autowired
    @Lazy
    protected CustomerService customerService;

    @Autowired
    @Lazy
    protected ProductService productService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    @Autowired
    @Lazy
    protected AttachmentService attachmentService;

    protected int batchSize = 500;

    public Ticket get(Ticket et) {
        Ticket rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.TICKET.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [附件]
        getAttachments(et);
        return et;
    }

    public List<Ticket> getByEntities(List<Ticket> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Ticket et) {
        if(Entities.CUSTOMER.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setCustomerId((String)et.getContextParentKey());
            Customer customer = et.getCustomer();
            if(customer == null) {
                customer = customerService.getById(et.getCustomerId());
                et.setCustomer(customer);
            }
            if(!ObjectUtils.isEmpty(customer)) {
                et.setCustomerId(customer.getId());
                et.setCustomerName(customer.getName());
            }
        }
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProductId((String)et.getContextParentKey());
            Product product = et.getProduct();
            if(product == null) {
                product = productService.getById(et.getProductId());
                et.setProduct(product);
            }
            if(!ObjectUtils.isEmpty(product)) {
                et.setProductIdentifier(product.getIdentifier());
                et.setProductId(product.getId());
                et.setProductName(product.getName());
            }
        }
    }

    public Ticket getDraft(Ticket et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Ticket et) {
        fillParentData(et);
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Ticket>lambdaQuery().eq(Ticket::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Ticket et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByTicket(et,et.getAttentions());
        attachmentService.saveByTicket(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Ticket> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Ticket et) {
        fillParentData(et);
        UpdateWrapper<Ticket> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByTicket(et,et.getAttentions());
        attachmentService.saveByTicket(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Ticket> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Ticket et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Ticket> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Ticket> before = getByEntities(list).stream().collect(Collectors.toMap(Ticket::getId,e->e));
        List<Ticket> create = new ArrayList<>();
        List<Ticket> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getId()) && before.containsKey(sub.getId()))
                update.add(sub);
            else
                create.add(sub);
        });
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Ticket et) {
        if(!remove(Wrappers.<Ticket>lambdaQuery().eq(Ticket::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Ticket> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Ticket> searchArchived(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listArchived(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchCommentNotifyAssignee(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchCommentNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listCommentNotifyAssignee(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listCommentNotifyAssignee(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchCommon(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchCommon(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listCommon(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<Ticket> list = baseMapper.listCommon(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchCustomerNotreTicket(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchCustomerNotreTicket(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listCustomerNotreTicket(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listCustomerNotreTicket(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchCustomerRelationTicket(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchCustomerRelationTicket(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listCustomerRelationTicket(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listCustomerRelationTicket(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchDefault(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listDefault(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchDeleted(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listDeleted(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchIdeaRelationTicket(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchIdeaRelationTicket(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listIdeaRelationTicket(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listIdeaRelationTicket(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchMyAssign(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchMyAssign(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listMyAssign(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Ticket> list = baseMapper.listMyAssign(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchMyAssigneeCount(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchMyAssigneeCount(context.getPages(),context,context.getSelectCond());
        return new PageImpl<Ticket>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),Ticket.class), context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listMyAssigneeCount(TicketSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listMyAssigneeCount(context,context.getSelectCond()),Ticket.class);
    }

    public Page<Ticket> searchMyAttention(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchMyAttention(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listMyAttention(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listMyAttention(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchMyCreated(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchMyCreated(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listMyCreated(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Ticket> list = baseMapper.listMyCreated(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchNormal(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listNormal(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchNotExsistsRelation(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchNotExsistsRelation(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listNotExsistsRelation(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Ticket> list = baseMapper.listNotExsistsRelation(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchRecentTicket(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchRecentTicket(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listRecentTicket(TicketSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<Ticket> list = baseMapper.listRecentTicket(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchTicketReProductTag(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchTicketReProductTag(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listTicketReProductTag(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listTicketReProductTag(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchTicketRelationTicket(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchTicketRelationTicket(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listTicketRelationTicket(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listTicketRelationTicket(context,context.getSelectCond());
        return list;
    }

    public Page<Ticket> searchWorkItemRelationTicket(TicketSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Ticket> pages=baseMapper.searchWorkItemRelationTicket(context.getPages(),context,context.getSelectCond());
        List<Ticket> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Ticket> listWorkItemRelationTicket(TicketSearchContext context) {
        List<Ticket> list = baseMapper.listWorkItemRelationTicket(context,context.getSelectCond());
        return list;
    }

    public List<Ticket> findByCustomerId(List<String> customerIds) {
        List<Ticket> list = baseMapper.findByCustomerId(customerIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;
    }
    public List<Ticket> findByProductId(List<String> productIds) {
        List<Ticket> list = baseMapper.findByProductId(productIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;
    }
    public List<Ticket> findByAssigneeId(List<String> assigneeIds) {
        List<Ticket> list = baseMapper.findByAssigneeId(assigneeIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;
    }
    public boolean removeByCustomerId(String customerId) {
        return this.remove(Wrappers.<Ticket>lambdaQuery().eq(Ticket::getCustomerId,customerId));
    }

    public boolean resetByCustomerId(String customerId) {
        return this.update(Wrappers.<Ticket>lambdaUpdate().eq(Ticket::getCustomerId,customerId));
    }

    public boolean saveByCustomer(Customer customer,List<Ticket> list) {
        if(list==null)
            return true;
        Map<String,Ticket> before = findByCustomerId(customer.getId()).stream().collect(Collectors.toMap(Ticket::getId,e->e));
        List<Ticket> update = new ArrayList<>();
        List<Ticket> create = new ArrayList<>();

        for(Ticket sub:list) {
            sub.setCustomerId(customer.getId());
            sub.setCustomer(customer);
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByProductId(String productId) {
        return this.remove(Wrappers.<Ticket>lambdaQuery().eq(Ticket::getProductId,productId));
    }

    public boolean resetByProductId(String productId) {
        return this.update(Wrappers.<Ticket>lambdaUpdate().eq(Ticket::getProductId,productId));
    }

    public boolean saveByProduct(Product product,List<Ticket> list) {
        if(list==null)
            return true;
        Map<String,Ticket> before = findByProductId(product.getId()).stream().collect(Collectors.toMap(Ticket::getId,e->e));
        List<Ticket> update = new ArrayList<>();
        List<Ticket> create = new ArrayList<>();

        for(Ticket sub:list) {
            sub.setProductId(product.getId());
            sub.setProduct(product);
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByAssigneeId(String assigneeId) {
        return this.remove(Wrappers.<Ticket>lambdaQuery().eq(Ticket::getAssigneeId,assigneeId));
    }

    public boolean resetByAssigneeId(String assigneeId) {
        return this.update(Wrappers.<Ticket>lambdaUpdate().eq(Ticket::getAssigneeId,assigneeId));
    }

    public boolean saveByUser(User user,List<Ticket> list) {
        if(list==null)
            return true;
        Map<String,Ticket> before = findByAssigneeId(user.getId()).stream().collect(Collectors.toMap(Ticket::getId,e->e));
        List<Ticket> update = new ArrayList<>();
        List<Ticket> create = new ArrayList<>();

        for(Ticket sub:list) {
            sub.setAssigneeId(user.getId());
            sub.setUser(user);
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    @Override
    public List<Attention> getAttentions(Ticket et) {
        List<Attention> list = attentionService.findByOwnerId(et.getId());
        et.setAttentions(list);
        return list;
    }

    @Override
    public List<Attachment> getAttachments(Ticket et) {
        List<Attachment> list = attachmentService.findByOwnerId(et.getId());
        et.setAttachments(list);
        return list;
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.INSERT_ONE.getMethod())) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.UPDATE.getMethod())) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.DELETE.getMethod())) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }

    @Override
    protected Class currentMapperClass() {
        return TicketMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Ticket.class;
    }
}