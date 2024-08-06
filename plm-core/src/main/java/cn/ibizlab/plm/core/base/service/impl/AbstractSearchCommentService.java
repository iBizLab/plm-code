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
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.filter.SearchCommentSearchContext;
import cn.ibizlab.plm.core.base.service.SearchCommentService;
import cn.ibizlab.plm.core.base.mapper.SearchCommentMapper;
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
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.service.RunService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[评论搜索] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSearchCommentService extends ServiceImpl<SearchCommentMapper,SearchComment> implements SearchCommentService {

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
    protected RunService runService;

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
    public boolean create(SearchComment et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<SearchComment> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(SearchComment et) {
        UpdateWrapper<SearchComment> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<SearchComment> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(SearchComment et) {
        if(!remove(Wrappers.<SearchComment>lambdaQuery().eq(SearchComment::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<SearchComment> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public SearchComment get(SearchComment et) {
        SearchComment rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SEARCH_COMMENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<SearchComment> get(List<SearchComment> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public SearchComment getDraft(SearchComment et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(SearchComment et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<SearchComment>lambdaQuery().eq(SearchComment::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(SearchComment et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<SearchComment> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SearchComment> before = get(list).stream().collect(Collectors.toMap(SearchComment::getId,e->e));
        List<SearchComment> create = new ArrayList<>();
        List<SearchComment> update = new ArrayList<>();
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
	
   public Page<SearchComment> fetchDefault(SearchCommentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SearchComment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<SearchComment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SearchComment> listDefault(SearchCommentSearchContext context) {
        List<SearchComment> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<SearchComment> fetchRelation(SearchCommentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SearchComment> pages=baseMapper.searchRelation(context.getPages(),context,context.getSelectCond());
        List<SearchComment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SearchComment> listRelation(SearchCommentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<SearchComment> list = baseMapper.listRelation(context,context.getSelectCond());
        return list;
   }
	
	public List<SearchComment> findByPrincipalId(List<String> principalIds){
        List<SearchComment> list = baseMapper.findByPrincipalId(principalIds);
        return list;	
	}

	public List<SearchComment> findByDerCustomer(Customer customer){
        List<SearchComment> list = this.baseMapper.selectList(Wrappers.<SearchComment>lambdaQuery()
                        .eq(SearchComment::getPrincipalId, customer.getId())
                        .eq(SearchComment::getOwnerType,"CUSTOMER").isNull(SearchComment::getPrincipalType));
		return list;
	}
	public boolean removeByPrincipalId(String principalId){
        return this.remove(Wrappers.<SearchComment>lambdaQuery().eq(SearchComment::getPrincipalId,principalId));
	}

	public boolean resetByPrincipalId(String principalId){
		return this.update(Wrappers.<SearchComment>lambdaUpdate().eq(SearchComment::getPrincipalId,principalId));
	}
	public boolean saveByDerCustomer(Customer customer, List<SearchComment> list){
        if(list==null)
            return true;

        Map<String,SearchComment> before = findByDerCustomer(customer).stream().collect(Collectors.toMap(SearchComment::getId,e->e));
        List<SearchComment> update = new ArrayList<>();
        List<SearchComment> create = new ArrayList<>();

        for(SearchComment sub:list) {
            sub.setPrincipalId(customer.getId());
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
	public List<SearchComment> findByDerIdea(Idea idea){
        List<SearchComment> list = this.baseMapper.selectList(Wrappers.<SearchComment>lambdaQuery()
                        .eq(SearchComment::getPrincipalId, idea.getId())
                        .eq(SearchComment::getOwnerType,"IDEA").isNull(SearchComment::getPrincipalType));
		return list;
	}
	public boolean saveByDerIdea(Idea idea, List<SearchComment> list){
        if(list==null)
            return true;

        Map<String,SearchComment> before = findByDerIdea(idea).stream().collect(Collectors.toMap(SearchComment::getId,e->e));
        List<SearchComment> update = new ArrayList<>();
        List<SearchComment> create = new ArrayList<>();

        for(SearchComment sub:list) {
            sub.setPrincipalId(idea.getId());
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
	public List<SearchComment> findByDerPage(ArticlePage articlePage){
        List<SearchComment> list = this.baseMapper.selectList(Wrappers.<SearchComment>lambdaQuery()
                        .eq(SearchComment::getPrincipalId, articlePage.getId())
                        .eq(SearchComment::getOwnerType,"PAGE").isNull(SearchComment::getPrincipalType));
		return list;
	}
	public boolean saveByDerPage(ArticlePage articlePage, List<SearchComment> list){
        if(list==null)
            return true;

        Map<String,SearchComment> before = findByDerPage(articlePage).stream().collect(Collectors.toMap(SearchComment::getId,e->e));
        List<SearchComment> update = new ArrayList<>();
        List<SearchComment> create = new ArrayList<>();

        for(SearchComment sub:list) {
            sub.setPrincipalId(articlePage.getId());
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
	public List<SearchComment> findByDerRun(Run run){
        List<SearchComment> list = this.baseMapper.selectList(Wrappers.<SearchComment>lambdaQuery()
                        .eq(SearchComment::getPrincipalId, run.getId())
                        .eq(SearchComment::getOwnerType,"RUN").isNull(SearchComment::getPrincipalType));
		return list;
	}
	public boolean saveByDerRun(Run run, List<SearchComment> list){
        if(list==null)
            return true;

        Map<String,SearchComment> before = findByDerRun(run).stream().collect(Collectors.toMap(SearchComment::getId,e->e));
        List<SearchComment> update = new ArrayList<>();
        List<SearchComment> create = new ArrayList<>();

        for(SearchComment sub:list) {
            sub.setPrincipalId(run.getId());
            sub.setDerRun(run);
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
	public List<SearchComment> findByDerTestCase(TestCase testCase){
        List<SearchComment> list = this.baseMapper.selectList(Wrappers.<SearchComment>lambdaQuery()
                        .eq(SearchComment::getPrincipalId, testCase.getId())
                        .eq(SearchComment::getOwnerType,"TEST_CASE").isNull(SearchComment::getPrincipalType));
		return list;
	}
	public boolean saveByDerTestCase(TestCase testCase, List<SearchComment> list){
        if(list==null)
            return true;

        Map<String,SearchComment> before = findByDerTestCase(testCase).stream().collect(Collectors.toMap(SearchComment::getId,e->e));
        List<SearchComment> update = new ArrayList<>();
        List<SearchComment> create = new ArrayList<>();

        for(SearchComment sub:list) {
            sub.setPrincipalId(testCase.getId());
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
	public List<SearchComment> findByDerTicket(Ticket ticket){
        List<SearchComment> list = this.baseMapper.selectList(Wrappers.<SearchComment>lambdaQuery()
                        .eq(SearchComment::getPrincipalId, ticket.getId())
                        .eq(SearchComment::getOwnerType,"TICKET").isNull(SearchComment::getPrincipalType));
		return list;
	}
	public boolean saveByDerTicket(Ticket ticket, List<SearchComment> list){
        if(list==null)
            return true;

        Map<String,SearchComment> before = findByDerTicket(ticket).stream().collect(Collectors.toMap(SearchComment::getId,e->e));
        List<SearchComment> update = new ArrayList<>();
        List<SearchComment> create = new ArrayList<>();

        for(SearchComment sub:list) {
            sub.setPrincipalId(ticket.getId());
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
	public List<SearchComment> findByDerWorkItem(WorkItem workItem){
        List<SearchComment> list = this.baseMapper.selectList(Wrappers.<SearchComment>lambdaQuery()
                        .eq(SearchComment::getPrincipalId, workItem.getId())
                        .eq(SearchComment::getOwnerType,"WORK_ITEM").isNull(SearchComment::getPrincipalType));
		return list;
	}
	public boolean saveByDerWorkItem(WorkItem workItem, List<SearchComment> list){
        if(list==null)
            return true;

        Map<String,SearchComment> before = findByDerWorkItem(workItem).stream().collect(Collectors.toMap(SearchComment::getId,e->e));
        List<SearchComment> update = new ArrayList<>();
        List<SearchComment> create = new ArrayList<>();

        for(SearchComment sub:list) {
            sub.setPrincipalId(workItem.getId());
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
   public Page<SearchComment> fetchView(SearchCommentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SearchComment> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<SearchComment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SearchComment> listView(SearchCommentSearchContext context) {
        List<SearchComment> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(SearchComment et) {
        if(Entities.CUSTOMER.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.RUN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.TICKET.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
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
        return SearchCommentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return SearchComment.class;
    }

}