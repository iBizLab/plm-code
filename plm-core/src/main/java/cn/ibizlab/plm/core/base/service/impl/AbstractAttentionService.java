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
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.filter.AttentionSearchContext;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.mapper.AttentionMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.service.CustomerService;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.service.DiscussPostService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.testmgmt.service.ReviewWizardService;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.service.RunService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[关注] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAttentionService extends ServiceImpl<AttentionMapper,Attention> implements AttentionService {

    @Autowired
    @Lazy
    protected CustomerService customerService;

    @Autowired
    @Lazy
    protected DiscussPostService discussPostService;

    @Autowired
    @Lazy
    protected IdeaService ideaService;

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    @Autowired
    @Lazy
    protected ReviewService reviewService;

    @Autowired
    @Lazy
    protected ReviewWizardService reviewWizardService;

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
    public boolean create(Attention et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Attention> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Attention et) {
        UpdateWrapper<Attention> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Attention> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Attention et) {
        if(!remove(Wrappers.<Attention>lambdaQuery().eq(Attention::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Attention> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Attention get(Attention et) {
        Attention rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ATTENTION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Attention> get(List<Attention> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Attention getDraft(Attention et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Attention et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Attention>lambdaQuery().eq(Attention::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Attention et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Attention> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Attention> before = get(list).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> create = new ArrayList<>();
        List<Attention> update = new ArrayList<>();
        list.forEach(sub->{
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	
   public Page<Attention> fetchDefault(AttentionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attention> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Attention> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attention> listDefault(AttentionSearchContext context) {
        List<Attention> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Attention> fetchAttentionByOwnerid(AttentionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attention> pages=baseMapper.searchAttentionByOwnerid(context.getPages(),context,context.getSelectCond());
        List<Attention> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attention> listAttentionByOwnerid(AttentionSearchContext context) {
        List<Attention> list = baseMapper.listAttentionByOwnerid(context,context.getSelectCond());
        return list;
   }
	
   public Page<Attention> fetchCommentAttention(AttentionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attention> pages=baseMapper.searchCommentAttention(context.getPages(),context,context.getSelectCond());
        List<Attention> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attention> listCommentAttention(AttentionSearchContext context) {
        List<Attention> list = baseMapper.listCommentAttention(context,context.getSelectCond());
        return list;
   }
	
   public Page<Attention> fetchNotify(AttentionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attention> pages=baseMapper.searchNotify(context.getPages(),context,context.getSelectCond());
        List<Attention> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attention> listNotify(AttentionSearchContext context) {
        List<Attention> list = baseMapper.listNotify(context,context.getSelectCond());
        return list;
   }
	
	public List<Attention> findByOwnerId(List<String> ownerIds){
        List<Attention> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Attention> findByCustomer(Customer customer){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, customer.getId())
                        .eq(Attention::getOwnerType,"CUSTOMER")
                        .eq(Attention::getOwnerSubtype,"CUSTOMER"));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Attention>lambdaQuery().eq(Attention::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Attention>lambdaUpdate().eq(Attention::getOwnerId,ownerId));
	}
	public boolean saveByCustomer(Customer customer, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByCustomer(customer).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(customer.getId());
            sub.setCustomer(customer);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByDiscussPost(DiscussPost discussPost){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, discussPost.getId())
                        .eq(Attention::getOwnerType,"DISCUSS_POST")
                        .eq(Attention::getOwnerSubtype,"DISCUSS_POST"));
		return list;
	}
	public boolean saveByDiscussPost(DiscussPost discussPost, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByDiscussPost(discussPost).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(discussPost.getId());
            sub.setDiscussPost(discussPost);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByIdea(Idea idea){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, idea.getId())
                        .eq(Attention::getOwnerType,"IDEA")
                        .eq(Attention::getOwnerSubtype,"IDEA"));
		return list;
	}
	public boolean saveByIdea(Idea idea, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByIdea(idea).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(idea.getId());
            sub.setIdea(idea);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByPage(ArticlePage articlePage){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, articlePage.getId())
                        .eq(Attention::getOwnerType,"PAGE")
                        .eq(Attention::getOwnerSubtype,"PAGE"));
		return list;
	}
	public boolean saveByPage(ArticlePage articlePage, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByPage(articlePage).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(articlePage.getId());
            sub.setPage(articlePage);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByReview(Review review){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, review.getId())
                        .eq(Attention::getOwnerType,"REVIEW")
                        .eq(Attention::getOwnerSubtype,"REVIEW"));
		return list;
	}
	public boolean saveByReview(Review review, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByReview(review).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(review.getId());
            sub.setReview(review);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByReviewWizard(ReviewWizard reviewWizard){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, reviewWizard.getId())
                        .eq(Attention::getOwnerType,"REVIEW_WIZARD")
                        .eq(Attention::getOwnerSubtype,"REVIEW:REVIEW"));
		return list;
	}
	public boolean saveByReviewWizard(ReviewWizard reviewWizard, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByReviewWizard(reviewWizard).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(reviewWizard.getId());
            sub.setReviewWizard(reviewWizard);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByRun(Run run){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, run.getId())
                        .eq(Attention::getOwnerType,"RUN")
                        .eq(Attention::getOwnerSubtype,"RUN"));
		return list;
	}
	public boolean saveByRun(Run run, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByRun(run).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(run.getId());
            sub.setRun(run);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByTestCase(TestCase testCase){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, testCase.getId())
                        .eq(Attention::getOwnerType,"TEST_CASE")
                        .eq(Attention::getOwnerSubtype,"TEST_CASE"));
		return list;
	}
	public boolean saveByTestCase(TestCase testCase, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByTestCase(testCase).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(testCase.getId());
            sub.setTestCase(testCase);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByTicket(Ticket ticket){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, ticket.getId())
                        .eq(Attention::getOwnerType,"TICKET")
                        .eq(Attention::getOwnerSubtype,"TICKET"));
		return list;
	}
	public boolean saveByTicket(Ticket ticket, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByTicket(ticket).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(ticket.getId());
            sub.setTicket(ticket);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Attention> findByWorkItem(WorkItem workItem){
        List<Attention> list = this.baseMapper.selectList(Wrappers.<Attention>lambdaQuery()
                        .eq(Attention::getOwnerId, workItem.getId())
                        .eq(Attention::getOwnerType,"WORK_ITEM")
                        .eq(Attention::getOwnerSubtype,"WORK_ITEM"));
		return list;
	}
	public boolean saveByWorkItem(WorkItem workItem, List<Attention> list){
        if(list==null)
            return true;

        Map<String,Attention> before = findByWorkItem(workItem).stream().collect(Collectors.toMap(Attention::getId,e->e));
        List<Attention> update = new ArrayList<>();
        List<Attention> create = new ArrayList<>();

        for(Attention sub:list) {
            sub.setOwnerId(workItem.getId());
            sub.setWorkItem(workItem);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
   public Page<Attention> fetchView(AttentionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attention> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Attention> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attention> listView(AttentionSearchContext context) {
        List<Attention> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Attention et) {
        if(Entities.CUSTOMER.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.DISCUSS_POST.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.REVIEW.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.REVIEW_WIZARD.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.RUN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return AttentionMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Attention.class;
    }

}