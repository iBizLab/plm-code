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
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.filter.AttachmentSearchContext;
import cn.ibizlab.plm.core.base.service.AttachmentService;
import cn.ibizlab.plm.core.base.mapper.AttachmentMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.core.wiki.service.StencilService;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.service.DiscussPostService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[附件] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAttachmentService extends ServiceImpl<AttachmentMapper,Attachment> implements AttachmentService {

    @Autowired
    @Lazy
    protected StencilService stencilService;

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
    public boolean create(Attachment et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Attachment> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Attachment et) {
        UpdateWrapper<Attachment> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Attachment> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Attachment et) {
        if(!remove(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Attachment> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Attachment get(Attachment et) {
        Attachment rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ATTACHMENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Attachment> get(List<Attachment> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Attachment getDraft(Attachment et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Attachment et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Attachment et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Attachment> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Attachment> before = get(list).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> create = new ArrayList<>();
        List<Attachment> update = new ArrayList<>();
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
	
   public Page<Attachment> fetchDefault(AttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attachment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Attachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attachment> listDefault(AttachmentSearchContext context) {
        List<Attachment> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Attachment> fetchMobWorkItemAttachment(AttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attachment> pages=baseMapper.searchMobWorkItemAttachment(context.getPages(),context,context.getSelectCond());
        List<Attachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attachment> listMobWorkItemAttachment(AttachmentSearchContext context) {
        List<Attachment> list = baseMapper.listMobWorkItemAttachment(context,context.getSelectCond());
        return list;
   }
	
   public Page<Attachment> fetchProjectDeliverable(AttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attachment> pages=baseMapper.searchProjectDeliverable(context.getPages(),context,context.getSelectCond());
        List<Attachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attachment> listProjectDeliverable(AttachmentSearchContext context) {
        List<Attachment> list = baseMapper.listProjectDeliverable(context,context.getSelectCond());
        return list;
   }
	
   public Page<Attachment> fetchWorkItemDeliverable(AttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attachment> pages=baseMapper.searchWorkItemDeliverable(context.getPages(),context,context.getSelectCond());
        List<Attachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attachment> listWorkItemDeliverable(AttachmentSearchContext context) {
        List<Attachment> list = baseMapper.listWorkItemDeliverable(context,context.getSelectCond());
        return list;
   }
	
	public List<Attachment> findByOwnerId(List<String> ownerIds){
        List<Attachment> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Attachment> findByStencil(Stencil stencil){
        List<Attachment> list = this.baseMapper.selectList(Wrappers.<Attachment>lambdaQuery()
                        .eq(Attachment::getOwnerId, stencil.getId())
                        .eq(Attachment::getOwnerType,"STENCIL").isNull(Attachment::getOwnerSubtype));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Attachment>lambdaUpdate().set(Attachment::getOwnerId, null).eq(Attachment::getOwnerId,ownerId));
	}
	public boolean saveByStencil(Stencil stencil, List<Attachment> list){
        if(list==null)
            return true;

        Map<String,Attachment> before = findByStencil(stencil).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(stencil.getId());
            sub.setStencil(stencil);
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
	public List<Attachment> findByDiscussPost(DiscussPost discussPost){
        List<Attachment> list = this.baseMapper.selectList(Wrappers.<Attachment>lambdaQuery()
                        .eq(Attachment::getOwnerId, discussPost.getId())
                        .eq(Attachment::getOwnerType,"DISCUSS_POST").isNull(Attachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByDiscussPost(DiscussPost discussPost, List<Attachment> list){
        if(list==null)
            return true;

        Map<String,Attachment> before = findByDiscussPost(discussPost).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(discussPost.getId());
            sub.setDiscussPost(discussPost);
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
	public List<Attachment> findByIdea(Idea idea){
        List<Attachment> list = this.baseMapper.selectList(Wrappers.<Attachment>lambdaQuery()
                        .eq(Attachment::getOwnerId, idea.getId())
                        .eq(Attachment::getOwnerType,"IDEA").isNull(Attachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByIdea(Idea idea, List<Attachment> list){
        if(list==null)
            return true;

        Map<String,Attachment> before = findByIdea(idea).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(idea.getId());
            sub.setIdea(idea);
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
	public List<Attachment> findByPage(ArticlePage articlePage){
        List<Attachment> list = this.baseMapper.selectList(Wrappers.<Attachment>lambdaQuery()
                        .eq(Attachment::getOwnerId, articlePage.getId())
                        .eq(Attachment::getOwnerType,"PAGE").isNull(Attachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByPage(ArticlePage articlePage, List<Attachment> list){
        if(list==null)
            return true;

        Map<String,Attachment> before = findByPage(articlePage).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(articlePage.getId());
            sub.setPage(articlePage);
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
	public List<Attachment> findByReview(Review review){
        List<Attachment> list = this.baseMapper.selectList(Wrappers.<Attachment>lambdaQuery()
                        .eq(Attachment::getOwnerId, review.getId())
                        .eq(Attachment::getOwnerType,"REVIEW").isNull(Attachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByReview(Review review, List<Attachment> list){
        if(list==null)
            return true;

        Map<String,Attachment> before = findByReview(review).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(review.getId());
            sub.setReview(review);
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
	public List<Attachment> findByTestCase(TestCase testCase){
        List<Attachment> list = this.baseMapper.selectList(Wrappers.<Attachment>lambdaQuery()
                        .eq(Attachment::getOwnerId, testCase.getId())
                        .eq(Attachment::getOwnerType,"TEST_CASE").isNull(Attachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByTestCase(TestCase testCase, List<Attachment> list){
        if(list==null)
            return true;

        Map<String,Attachment> before = findByTestCase(testCase).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(testCase.getId());
            sub.setTestCase(testCase);
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
	public List<Attachment> findByTicket(Ticket ticket){
        List<Attachment> list = this.baseMapper.selectList(Wrappers.<Attachment>lambdaQuery()
                        .eq(Attachment::getOwnerId, ticket.getId())
                        .eq(Attachment::getOwnerType,"TICKET").isNull(Attachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByTicket(Ticket ticket, List<Attachment> list){
        if(list==null)
            return true;

        Map<String,Attachment> before = findByTicket(ticket).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(ticket.getId());
            sub.setTicket(ticket);
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
	public List<Attachment> findByWorkItem(WorkItem workItem){
        List<Attachment> list = this.baseMapper.selectList(Wrappers.<Attachment>lambdaQuery()
                        .eq(Attachment::getOwnerId, workItem.getId())
                        .eq(Attachment::getOwnerType,"WORK_ITEM").isNull(Attachment::getOwnerSubtype));
		return list;
	}
	public boolean saveByWorkItem(WorkItem workItem, List<Attachment> list){
        if(list==null)
            return true;

        Map<String,Attachment> before = findByWorkItem(workItem).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(workItem.getId());
            sub.setWorkItem(workItem);
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
   public Page<Attachment> fetchView(AttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attachment> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Attachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Attachment> listView(AttachmentSearchContext context) {
        List<Attachment> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Attachment et) {
        if(Entities.STENCIL.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return AttachmentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Attachment.class;
    }

}