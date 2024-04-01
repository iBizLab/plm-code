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
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
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
    protected IdeaService ideaService;

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

    public Comment get(Comment et) {
        Comment rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.COMMENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Comment> getByEntities(List<Comment> entities) {
        return this.baseMapper.selectEntities(entities);
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
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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

    public Comment getDraft(Comment et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Comment et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Comment>lambdaQuery().eq(Comment::getId, et.getId()))>0)?1:0;
    }

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
    public boolean createBatch(List<Comment> list) {
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
    public boolean updateBatch(List<Comment> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Comment et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Comment> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Comment> before = getByEntities(list).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Comment et) {
        if(!remove(Wrappers.<Comment>lambdaQuery().eq(Comment::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Comment> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Comment> searchAdvancedSearch(CommentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Comment> pages=baseMapper.searchAdvancedSearch(context.getPages(),context,context.getSelectCond());
        List<Comment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Comment> listAdvancedSearch(CommentSearchContext context) {
        List<Comment> list = baseMapper.listAdvancedSearch(context,context.getSelectCond());
        return list;
    }

    public Page<Comment> searchDefault(CommentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Comment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Comment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Comment> listDefault(CommentSearchContext context) {
        List<Comment> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<Comment> findByPid(List<String> pids) {
        List<Comment> list = baseMapper.findByPid(pids);
        return list;
    }
    public List<Comment> findByPrincipalId(List<String> principalIds) {
        List<Comment> list = baseMapper.findByPrincipalId(principalIds);
        return list;
    }
    public boolean removeByPid(String pid) {
        return this.remove(Wrappers.<Comment>lambdaQuery().eq(Comment::getPid,pid));
    }

    public boolean resetByPid(String pid) {
        return this.update(Wrappers.<Comment>lambdaUpdate().eq(Comment::getPid,pid));
    }

    public boolean saveByComment(Comment comment,List<Comment> list) {
        if(list==null)
            return true;
        Map<String,Comment> before = findByPid(comment.getId()).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByPrincipalId(String principalId) {
        return this.remove(Wrappers.<Comment>lambdaQuery().eq(Comment::getPrincipalId,principalId));
    }

    public boolean resetByPrincipalId(String principalId) {
        return this.update(Wrappers.<Comment>lambdaUpdate().eq(Comment::getPrincipalId,principalId));
    }

    public boolean saveByPage(ArticlePage articlePage,List<Comment> list) {
        if(list==null)
            return true;
        Map<String,Comment> before = findByPrincipalId(articlePage.getId()).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByRun(Run run,List<Comment> list) {
        if(list==null)
            return true;
        Map<String,Comment> before = findByPrincipalId(run.getId()).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByCustomer(Customer customer,List<Comment> list) {
        if(list==null)
            return true;
        Map<String,Comment> before = findByPrincipalId(customer.getId()).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByIdea(Idea idea,List<Comment> list) {
        if(list==null)
            return true;
        Map<String,Comment> before = findByPrincipalId(idea.getId()).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByTestCase(TestCase testCase,List<Comment> list) {
        if(list==null)
            return true;
        Map<String,Comment> before = findByPrincipalId(testCase.getId()).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByTicket(Ticket ticket,List<Comment> list) {
        if(list==null)
            return true;
        Map<String,Comment> before = findByPrincipalId(ticket.getId()).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByWorkItem(WorkItem workItem,List<Comment> list) {
        if(list==null)
            return true;
        Map<String,Comment> before = findByPrincipalId(workItem.getId()).stream().collect(Collectors.toMap(Comment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
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
        return CommentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Comment.class;
    }
}