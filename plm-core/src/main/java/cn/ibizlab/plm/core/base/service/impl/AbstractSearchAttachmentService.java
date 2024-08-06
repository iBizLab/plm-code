/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

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
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.filter.SearchAttachmentSearchContext;
import cn.ibizlab.plm.core.base.service.SearchAttachmentService;
import cn.ibizlab.plm.core.base.mapper.SearchAttachmentMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.service.CustomerService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[附件搜索] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSearchAttachmentService extends ServiceImpl<SearchAttachmentMapper,SearchAttachment> implements SearchAttachmentService {

    @Autowired
    @Lazy
    protected CustomerService customerService;

    @Autowired
    @Lazy
    protected IdeaService ideaService;

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    @Autowired
    @Lazy
    protected TicketService ticketService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SearchAttachment et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<SearchAttachment> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(SearchAttachment et) {
        UpdateWrapper<SearchAttachment> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<SearchAttachment> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(SearchAttachment et) {
        if(!remove(Wrappers.<SearchAttachment>lambdaQuery().eq(SearchAttachment::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<SearchAttachment> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public SearchAttachment get(SearchAttachment et) {
        SearchAttachment rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SEARCH_ATTACHMENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<SearchAttachment> get(List<SearchAttachment> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public SearchAttachment getDraft(SearchAttachment et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(SearchAttachment et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<SearchAttachment>lambdaQuery().eq(SearchAttachment::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(SearchAttachment et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<SearchAttachment> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SearchAttachment> before = get(list).stream().collect(Collectors.toMap(SearchAttachment::getId,e->e));
        List<SearchAttachment> create = new ArrayList<>();
        List<SearchAttachment> update = new ArrayList<>();
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
	
   public Page<SearchAttachment> fetchDefault(SearchAttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SearchAttachment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<SearchAttachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SearchAttachment> listDefault(SearchAttachmentSearchContext context) {
        List<SearchAttachment> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<SearchAttachment> fetchRelation(SearchAttachmentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SearchAttachment> pages=baseMapper.searchRelation(context.getPages(),context,context.getSelectCond());
        List<SearchAttachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SearchAttachment> listRelation(SearchAttachmentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<SearchAttachment> list = baseMapper.listRelation(context,context.getSelectCond());
        return list;
   }
	
	public List<SearchAttachment> findByOwnerId(List<String> ownerIds){
        List<SearchAttachment> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<SearchAttachment> findByDerCustomer(Customer customer){
        List<SearchAttachment> list = this.baseMapper.selectList(Wrappers.<SearchAttachment>lambdaQuery()
                        .eq(SearchAttachment::getOwnerId, customer.getId())
                        .eq(SearchAttachment::getOwnerType,"CUSTOMER").isNull(SearchAttachment::getOwnerSubtype));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<SearchAttachment>lambdaQuery().eq(SearchAttachment::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<SearchAttachment>lambdaUpdate().set(SearchAttachment::getOwnerId, null).eq(SearchAttachment::getOwnerId,ownerId));
	}
	public boolean saveByDerCustomer(Customer customer, List<SearchAttachment> list){
        if(list==null)
            return true;

        Map<String,SearchAttachment> before = findByDerCustomer(customer).stream().collect(Collectors.toMap(SearchAttachment::getId,e->e));
        List<SearchAttachment> update = new ArrayList<>();
        List<SearchAttachment> create = new ArrayList<>();

        for(SearchAttachment sub:list) {
            sub.setOwnerId(customer.getId());
            sub.setDerCustomer(customer);
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
	public List<SearchAttachment> findByDerIdea(Idea idea){
        List<SearchAttachment> list = this.baseMapper.selectList(Wrappers.<SearchAttachment>lambdaQuery()
                        .eq(SearchAttachment::getOwnerId, idea.getId())
                        .eq(SearchAttachment::getOwnerType,"IDEA").isNull(SearchAttachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByDerIdea(Idea idea, List<SearchAttachment> list){
        if(list==null)
            return true;

        Map<String,SearchAttachment> before = findByDerIdea(idea).stream().collect(Collectors.toMap(SearchAttachment::getId,e->e));
        List<SearchAttachment> update = new ArrayList<>();
        List<SearchAttachment> create = new ArrayList<>();

        for(SearchAttachment sub:list) {
            sub.setOwnerId(idea.getId());
            sub.setDerIdea(idea);
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
	public List<SearchAttachment> findByDerPage(ArticlePage articlePage){
        List<SearchAttachment> list = this.baseMapper.selectList(Wrappers.<SearchAttachment>lambdaQuery()
                        .eq(SearchAttachment::getOwnerId, articlePage.getId())
                        .eq(SearchAttachment::getOwnerType,"PAGE").isNull(SearchAttachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByDerPage(ArticlePage articlePage, List<SearchAttachment> list){
        if(list==null)
            return true;

        Map<String,SearchAttachment> before = findByDerPage(articlePage).stream().collect(Collectors.toMap(SearchAttachment::getId,e->e));
        List<SearchAttachment> update = new ArrayList<>();
        List<SearchAttachment> create = new ArrayList<>();

        for(SearchAttachment sub:list) {
            sub.setOwnerId(articlePage.getId());
            sub.setDerPage(articlePage);
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
	public List<SearchAttachment> findByDerTestCase(TestCase testCase){
        List<SearchAttachment> list = this.baseMapper.selectList(Wrappers.<SearchAttachment>lambdaQuery()
                        .eq(SearchAttachment::getOwnerId, testCase.getId())
                        .eq(SearchAttachment::getOwnerType,"TEST_CASE").isNull(SearchAttachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByDerTestCase(TestCase testCase, List<SearchAttachment> list){
        if(list==null)
            return true;

        Map<String,SearchAttachment> before = findByDerTestCase(testCase).stream().collect(Collectors.toMap(SearchAttachment::getId,e->e));
        List<SearchAttachment> update = new ArrayList<>();
        List<SearchAttachment> create = new ArrayList<>();

        for(SearchAttachment sub:list) {
            sub.setOwnerId(testCase.getId());
            sub.setDerTestCase(testCase);
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
	public List<SearchAttachment> findByDerTicket(Ticket ticket){
        List<SearchAttachment> list = this.baseMapper.selectList(Wrappers.<SearchAttachment>lambdaQuery()
                        .eq(SearchAttachment::getOwnerId, ticket.getId())
                        .eq(SearchAttachment::getOwnerType,"TICKET").isNull(SearchAttachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByDerTicket(Ticket ticket, List<SearchAttachment> list){
        if(list==null)
            return true;

        Map<String,SearchAttachment> before = findByDerTicket(ticket).stream().collect(Collectors.toMap(SearchAttachment::getId,e->e));
        List<SearchAttachment> update = new ArrayList<>();
        List<SearchAttachment> create = new ArrayList<>();

        for(SearchAttachment sub:list) {
            sub.setOwnerId(ticket.getId());
            sub.setDerTicket(ticket);
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
	public List<SearchAttachment> findByDerWorkItem(WorkItem workItem){
        List<SearchAttachment> list = this.baseMapper.selectList(Wrappers.<SearchAttachment>lambdaQuery()
                        .eq(SearchAttachment::getOwnerId, workItem.getId())
                        .eq(SearchAttachment::getOwnerType,"WORK_ITEM").isNull(SearchAttachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByDerWorkItem(WorkItem workItem, List<SearchAttachment> list){
        if(list==null)
            return true;

        Map<String,SearchAttachment> before = findByDerWorkItem(workItem).stream().collect(Collectors.toMap(SearchAttachment::getId,e->e));
        List<SearchAttachment> update = new ArrayList<>();
        List<SearchAttachment> create = new ArrayList<>();

        for(SearchAttachment sub:list) {
            sub.setOwnerId(workItem.getId());
            sub.setDerWorkItem(workItem);
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
   public Page<SearchAttachment> fetchView(SearchAttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SearchAttachment> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<SearchAttachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SearchAttachment> listView(SearchAttachmentSearchContext context) {
        List<SearchAttachment> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(SearchAttachment et) {
        if(Entities.CUSTOMER.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.TICKET.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
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
        return SearchAttachmentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return SearchAttachment.class;
    }

}