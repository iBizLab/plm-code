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

    public Attachment get(Attachment et) {
        Attachment rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ATTACHMENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Attachment> getByEntities(List<Attachment> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Attachment et) {
        if(Entities.STENCIL.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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

    public Attachment getDraft(Attachment et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Attachment et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getId, et.getId()))>0)?1:0;
    }

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
    public boolean createBatch(List<Attachment> list) {
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
    public boolean updateBatch(List<Attachment> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Attachment et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Attachment> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Attachment> before = getByEntities(list).stream().collect(Collectors.toMap(Attachment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Attachment et) {
        if(!remove(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Attachment> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Attachment> searchDefault(AttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attachment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Attachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Attachment> listDefault(AttachmentSearchContext context) {
        List<Attachment> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Attachment> searchProjectDeliverable(AttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attachment> pages=baseMapper.searchProjectDeliverable(context.getPages(),context,context.getSelectCond());
        List<Attachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Attachment> listProjectDeliverable(AttachmentSearchContext context) {
        List<Attachment> list = baseMapper.listProjectDeliverable(context,context.getSelectCond());
        return list;
    }

    public Page<Attachment> searchWorkItemDeliverable(AttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Attachment> pages=baseMapper.searchWorkItemDeliverable(context.getPages(),context,context.getSelectCond());
        List<Attachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Attachment> listWorkItemDeliverable(AttachmentSearchContext context) {
        List<Attachment> list = baseMapper.listWorkItemDeliverable(context,context.getSelectCond());
        return list;
    }

    public List<Attachment> findByOwnerId(List<String> ownerIds) {
        List<Attachment> list = baseMapper.findByOwnerId(ownerIds);
        return list;
    }
    public boolean removeByOwnerId(String ownerId) {
        return this.remove(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getOwnerId,ownerId));
    }

    public boolean resetByOwnerId(String ownerId) {
        return this.update(Wrappers.<Attachment>lambdaUpdate().eq(Attachment::getOwnerId,ownerId));
    }

    public boolean saveByStencil(Stencil stencil,List<Attachment> list) {
        if(list==null)
            return true;
        Map<String,Attachment> before = findByOwnerId(stencil.getId()).stream().collect(Collectors.toMap(Attachment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByIdea(Idea idea,List<Attachment> list) {
        if(list==null)
            return true;
        Map<String,Attachment> before = findByOwnerId(idea.getId()).stream().collect(Collectors.toMap(Attachment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByPage(ArticlePage articlePage,List<Attachment> list) {
        if(list==null)
            return true;
        Map<String,Attachment> before = findByOwnerId(articlePage.getId()).stream().collect(Collectors.toMap(Attachment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByRun(Run run,List<Attachment> list) {
        if(list==null)
            return true;
        Map<String,Attachment> before = findByOwnerId(run.getId()).stream().collect(Collectors.toMap(Attachment::getId,e->e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for(Attachment sub:list) {
            sub.setOwnerId(run.getId());
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

    public boolean saveByTestCase(TestCase testCase,List<Attachment> list) {
        if(list==null)
            return true;
        Map<String,Attachment> before = findByOwnerId(testCase.getId()).stream().collect(Collectors.toMap(Attachment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByTicket(Ticket ticket,List<Attachment> list) {
        if(list==null)
            return true;
        Map<String,Attachment> before = findByOwnerId(ticket.getId()).stream().collect(Collectors.toMap(Attachment::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByWorkItem(WorkItem workItem,List<Attachment> list) {
        if(list==null)
            return true;
        Map<String,Attachment> before = findByOwnerId(workItem.getId()).stream().collect(Collectors.toMap(Attachment::getId,e->e));
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
        return AttachmentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Attachment.class;
    }
}