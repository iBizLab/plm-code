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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.filter.CustomerSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.CustomerService;
import cn.ibizlab.plm.core.prodmgmt.mapper.CustomerMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.service.SearchAttachmentService;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.service.SearchCommentService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[客户] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractCustomerService extends ServiceImpl<CustomerMapper,Customer> implements CustomerService {

    @Autowired
    @Lazy
    protected ProductService productService;

    @Autowired
    @Lazy
    protected TicketService ticketService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    @Autowired
    @Lazy
    protected SearchAttachmentService searchAttachmentService;

    @Autowired
    @Lazy
    protected SearchCommentService searchCommentService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Customer et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByCustomer(et,et.getAttentions());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Customer> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Customer et) {
        fillParentData(et);
        UpdateWrapper<Customer> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByCustomer(et,et.getAttentions());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Customer> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Customer et) {
        if(!remove(Wrappers.<Customer>lambdaQuery().eq(Customer::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Customer> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Customer get(Customer et) {
        Customer rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.CUSTOMER.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        return et;
    }	

    public List<Customer> get(List<Customer> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Customer getDraft(Customer et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Customer et) {
        fillParentData(et);
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Customer>lambdaQuery().eq(Customer::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Customer et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Customer> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Customer> before = get(list).stream().collect(Collectors.toMap(Customer::getId,e->e));
        List<Customer> create = new ArrayList<>();
        List<Customer> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getId()) && before.containsKey(sub.getId()))
                update.add(sub);
            else
                create.add(sub);
        });
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else
            return true;
    }
	
   public Page<Customer> fetchDefault(CustomerSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Customer> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Customer> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Customer> listDefault(CustomerSearchContext context) {
        List<Customer> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Customer> fetchCommentNotifyAssignee(CustomerSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Customer> pages=baseMapper.searchCommentNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<Customer> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Customer> listCommentNotifyAssignee(CustomerSearchContext context) {
        List<Customer> list = baseMapper.listCommentNotifyAssignee(context,context.getSelectCond());
        return list;
   }
	
   public Page<Customer> fetchIdeaNotreCustomer(CustomerSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Customer> pages=baseMapper.searchIdeaNotreCustomer(context.getPages(),context,context.getSelectCond());
        List<Customer> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Customer> listIdeaNotreCustomer(CustomerSearchContext context) {
        List<Customer> list = baseMapper.listIdeaNotreCustomer(context,context.getSelectCond());
        return list;
   }
	
   public Page<Customer> fetchIdeaRelationCustomer(CustomerSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Customer> pages=baseMapper.searchIdeaRelationCustomer(context.getPages(),context,context.getSelectCond());
        List<Customer> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Customer> listIdeaRelationCustomer(CustomerSearchContext context) {
        List<Customer> list = baseMapper.listIdeaRelationCustomer(context,context.getSelectCond());
        return list;
   }
	
   public Page<Customer> fetchNormal(CustomerSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Customer> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Customer> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Customer> listNormal(CustomerSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Customer> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<Customer> fetchNotifyAssignee(CustomerSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Customer> pages=baseMapper.searchNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<Customer> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Customer> listNotifyAssignee(CustomerSearchContext context) {
        List<Customer> list = baseMapper.listNotifyAssignee(context,context.getSelectCond());
        return list;
   }
	
	public List<Customer> findByProductId(List<String> productIds){
        List<Customer> list = baseMapper.findByProductId(productIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        return list;	
	}

	public List<Customer> findByProduct(Product product){
        List<Customer> list = findByProductId(Arrays.asList(product.getId()));
		return list;
	}
	public boolean removeByProductId(String productId){
        return this.remove(Wrappers.<Customer>lambdaQuery().eq(Customer::getProductId,productId));
	}

	public boolean resetByProductId(String productId){
		return this.update(Wrappers.<Customer>lambdaUpdate().eq(Customer::getProductId,productId));
	}
	public boolean saveByProduct(Product product, List<Customer> list){
        if(list==null)
            return true;

        Map<String,Customer> before = findByProduct(product).stream().collect(Collectors.toMap(Customer::getId,e->e));
        List<Customer> update = new ArrayList<>();
        List<Customer> create = new ArrayList<>();

        for(Customer sub:list) {
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Customer> findByAssigneeId(List<String> assigneeIds){
        List<Customer> list = baseMapper.findByAssigneeId(assigneeIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        return list;	
	}

	public List<Customer> findByUser(User user){
        List<Customer> list = findByAssigneeId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByAssigneeId(String assigneeId){
        return this.remove(Wrappers.<Customer>lambdaQuery().eq(Customer::getAssigneeId,assigneeId));
	}

	public boolean resetByAssigneeId(String assigneeId){
		return this.update(Wrappers.<Customer>lambdaUpdate().eq(Customer::getAssigneeId,assigneeId));
	}
	public boolean saveByUser(User user, List<Customer> list){
        if(list==null)
            return true;

        Map<String,Customer> before = findByUser(user).stream().collect(Collectors.toMap(Customer::getId,e->e));
        List<Customer> update = new ArrayList<>();
        List<Customer> create = new ArrayList<>();

        for(Customer sub:list) {
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	@Override
    public List<Attention> getAttentions(Customer et) {
        List<Attention> list = attentionService.findByCustomer(et);
        et.setAttentions(list);
        return list;
    }
	
   public Page<Customer> fetchView(CustomerSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Customer> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Customer> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Customer> listView(CustomerSearchContext context) {
        List<Customer> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Customer et) {
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProductId((String)et.getContextParentKey());
            Product product = et.getProduct();
            if(product == null) {
                product = productService.getById(et.getProductId());
                et.setProduct(product);
            }
            if(!ObjectUtils.isEmpty(product)) {
                et.setProductName(product.getName());
                et.setProductId(product.getId());
            }
        }
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
        return CustomerMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Customer.class;
    }

}