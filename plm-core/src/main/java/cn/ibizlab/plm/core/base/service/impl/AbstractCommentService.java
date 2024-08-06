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
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.filter.CommentSearchContext;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.mapper.CommentMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.service.RunService;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.service.CustomerService;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.service.DiscussPostService;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.team.service.DiscussReplyService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[评论] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractCommentService extends ServiceImpl<CommentMapper,Comment> implements CommentService {

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    @Autowired
    @Lazy
    protected RunService runService;

    @Autowired
    @Lazy
    protected CustomerService customerService;

    @Autowired
    @Lazy
    protected DiscussPostService discussPostService;

    @Autowired
    @Lazy
    protected DiscussReplyService discussReplyService;

    @Autowired
    @Lazy
    protected IdeaService ideaService;

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

    @Autowired
    @Lazy
    protected CommentService commentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Comment et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Comment> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Comment et) {
        UpdateWrapper<Comment> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Comment> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Comment et) {
        if(!remove(Wrappers.<Comment>lambdaQuery().eq(Comment::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Comment> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Comment get(Comment et) {
        Comment rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.COMMENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Comment> get(List<Comment> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Comment getDraft(Comment et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Comment et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Comment>lambdaQuery().eq(Comment::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Comment et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Comment> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Comment> before = get(list).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> create = new ArrayList<>();
        List<Comment> update = new ArrayList<>();
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
	
   public Page<Comment> fetchDefault(CommentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Comment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Comment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Comment> listDefault(CommentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,ASC");
        List<Comment> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<Comment> findByPid(List<String> pids){
        List<Comment> list = baseMapper.findByPid(pids);
        return list;	
	}

	public List<Comment> findByComment(Comment comment){
        List<Comment> list = findByPid(Arrays.asList(comment.getId()));
		return list;
	}
	public boolean removeByPid(String pid){
        return this.remove(Wrappers.<Comment>lambdaQuery().eq(Comment::getPid,pid));
	}

	public boolean resetByPid(String pid){
		return this.update(Wrappers.<Comment>lambdaUpdate().set(Comment::getPid, null).eq(Comment::getPid,pid));
	}
	public boolean saveByComment(Comment comment, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByComment(comment).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPid(comment.getId());
            sub.setComment(comment);
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
	public List<Comment> findByPrincipalId(List<String> principalIds){
        List<Comment> list = baseMapper.findByPrincipalId(principalIds);
        return list;	
	}

	public List<Comment> findByPage(ArticlePage articlePage){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, articlePage.getId())
                        .eq(Comment::getOwnerType,"PAGE")
                        .eq(Comment::getPrincipalType,"PAGE"));
		return list;
	}
	public boolean removeByPrincipalId(String principalId){
        return this.remove(Wrappers.<Comment>lambdaQuery().eq(Comment::getPrincipalId,principalId));
	}

	public boolean resetByPrincipalId(String principalId){
		return this.update(Wrappers.<Comment>lambdaUpdate().set(Comment::getPrincipalId, null).eq(Comment::getPrincipalId,principalId));
	}
	public boolean saveByPage(ArticlePage articlePage, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByPage(articlePage).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(articlePage.getId());
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
	public List<Comment> findByRun(Run run){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, run.getId())
                        .eq(Comment::getOwnerType,"RUN")
                        .eq(Comment::getPrincipalType,"RUN"));
		return list;
	}
	public boolean saveByRun(Run run, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByRun(run).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(run.getId());
            sub.setRun(run);
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
	public List<Comment> findByCustomer(Customer customer){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, customer.getId())
                        .eq(Comment::getOwnerType,"CUSTOMER")
                        .eq(Comment::getPrincipalType,"CUSTOMER"));
		return list;
	}
	public boolean saveByCustomer(Customer customer, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByCustomer(customer).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(customer.getId());
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Comment> findByDiscussPost(DiscussPost discussPost){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, discussPost.getId())
                        .eq(Comment::getOwnerType,"DISCUSS_POST")
                        .eq(Comment::getPrincipalType,"DISCUSS_POST"));
		return list;
	}
	public boolean saveByDiscussPost(DiscussPost discussPost, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByDiscussPost(discussPost).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(discussPost.getId());
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
	public List<Comment> findByDiscussReply(DiscussReply discussReply){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, discussReply.getId())
                        .eq(Comment::getOwnerType,"DISCUSS_REPLY")
                        .eq(Comment::getPrincipalType,"DISCUSS_REPLY"));
		return list;
	}
	public boolean saveByDiscussReply(DiscussReply discussReply, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByDiscussReply(discussReply).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(discussReply.getId());
            sub.setDiscussReply(discussReply);
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
	public List<Comment> findByIdea(Idea idea){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, idea.getId())
                        .eq(Comment::getOwnerType,"IDEA")
                        .eq(Comment::getPrincipalType,"IDEA"));
		return list;
	}
	public boolean saveByIdea(Idea idea, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByIdea(idea).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(idea.getId());
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
	public List<Comment> findByReview(Review review){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, review.getId())
                        .eq(Comment::getOwnerType,"REVIEW")
                        .eq(Comment::getPrincipalType,"REVIEW"));
		return list;
	}
	public boolean saveByReview(Review review, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByReview(review).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(review.getId());
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
	public List<Comment> findByTestCase(TestCase testCase){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, testCase.getId())
                        .eq(Comment::getOwnerType,"TEST_CASE")
                        .eq(Comment::getPrincipalType,"TEST_CASE"));
		return list;
	}
	public boolean saveByTestCase(TestCase testCase, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByTestCase(testCase).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(testCase.getId());
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
	public List<Comment> findByTicket(Ticket ticket){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, ticket.getId())
                        .eq(Comment::getOwnerType,"TICKET")
                        .eq(Comment::getPrincipalType,"TICKET"));
		return list;
	}
	public boolean saveByTicket(Ticket ticket, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByTicket(ticket).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(ticket.getId());
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
	public List<Comment> findByWorkItem(WorkItem workItem){
        List<Comment> list = this.baseMapper.selectList(Wrappers.<Comment>lambdaQuery()
                        .eq(Comment::getPrincipalId, workItem.getId())
                        .eq(Comment::getOwnerType,"WORK_ITEM")
                        .eq(Comment::getPrincipalType,"WORK_ITEM"));
		return list;
	}
	public boolean saveByWorkItem(WorkItem workItem, List<Comment> list){
        if(list==null)
            return true;

        Map<String,Comment> before = findByWorkItem(workItem).stream().collect(Collectors.toMap(Comment::getId,e->e));
        List<Comment> update = new ArrayList<>();
        List<Comment> create = new ArrayList<>();

        for(Comment sub:list) {
            sub.setPrincipalId(workItem.getId());
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
   public Page<Comment> fetchView(CommentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Comment> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Comment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Comment> listView(CommentSearchContext context) {
        List<Comment> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Comment et) {
        if(Entities.COMMENT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPid((String)et.getContextParentKey());
            Comment comment = et.getComment();
            if(comment == null) {
                comment = commentService.getById(et.getPid());
                et.setComment(comment);
            }
            if(!ObjectUtils.isEmpty(comment)) {
                et.setPcontent(comment.getContent());
                et.setPcreateMan(comment.getCreateMan());
                et.setPid(comment.getId());
            }
        }
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.RUN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.CUSTOMER.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.DISCUSS_POST.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.DISCUSS_REPLY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.REVIEW.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return CommentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Comment.class;
    }

}