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
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.filter.RelationSearchContext;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.base.mapper.RelationMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentExtendService;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.service.CustomerService;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.service.ProductPlanService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;

/**
 * 实体[关联] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRelationService extends ServiceImpl<RelationMapper,Relation> implements RelationService {

    @Autowired
    @Lazy
    protected BaselineService baselineService;

    @Autowired
    @Lazy
    protected IdeaService ideaService;

    @Autowired
    @Lazy
    protected ReviewService reviewService;

    @Autowired
    @Lazy
    protected ReviewContentExtendService reviewContentExtendService;

    @Autowired
    @Lazy
    protected CustomerService customerService;

    @Autowired
    @Lazy
    protected ProductPlanService productPlanService;

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
    protected TestPlanService testPlanService;

    protected int batchSize = 500;

    public Relation get(Relation et) {
        Relation rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.RELATION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Relation> getByEntities(List<Relation> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Relation et) {
        if(Entities.BASELINE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.REVIEW.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.REVIEW_CONTENT_EXTEND.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setId((String)et.getContextParentKey());
        }
        if(Entities.CUSTOMER.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetId((String)et.getContextParentKey());
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetId((String)et.getContextParentKey());
        }
        if(Entities.PRODUCT_PLAN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetId((String)et.getContextParentKey());
        }
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetId((String)et.getContextParentKey());
        }
        if(Entities.TICKET.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetId((String)et.getContextParentKey());
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetId((String)et.getContextParentKey());
        }
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.TEST_PLAN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
    }

    public Relation getDraft(Relation et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Relation et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Relation>lambdaQuery().eq(Relation::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Relation et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Relation> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Relation et) {
        UpdateWrapper<Relation> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Relation> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Relation et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Relation> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Relation> before = getByEntities(list).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> create = new ArrayList<>();
        List<Relation> update = new ArrayList<>();
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Relation et) {
        if(!remove(Wrappers.<Relation>lambdaQuery().eq(Relation::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Relation> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Relation> searchDefault(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listDefault(RelationSearchContext context) {
        List<Relation> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchAll(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchAll(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listAll(RelationSearchContext context) {
        List<Relation> list = baseMapper.listAll(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchExistsRunRelationBug(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchExistsRunRelationBug(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listExistsRunRelationBug(RelationSearchContext context) {
        List<Relation> list = baseMapper.listExistsRunRelationBug(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchIdeaReCustomer(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchIdeaReCustomer(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listIdeaReCustomer(RelationSearchContext context) {
        List<Relation> list = baseMapper.listIdeaReCustomer(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchIdeaReIdea(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchIdeaReIdea(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listIdeaReIdea(RelationSearchContext context) {
        List<Relation> list = baseMapper.listIdeaReIdea(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchIdeaReTestCase(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchIdeaReTestCase(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listIdeaReTestCase(RelationSearchContext context) {
        List<Relation> list = baseMapper.listIdeaReTestCase(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchIdeaReTicket(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchIdeaReTicket(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listIdeaReTicket(RelationSearchContext context) {
        List<Relation> list = baseMapper.listIdeaReTicket(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchIdeaReWorkItem(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchIdeaReWorkItem(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listIdeaReWorkItem(RelationSearchContext context) {
        List<Relation> list = baseMapper.listIdeaReWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchIdeaVersionRelation(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchIdeaVersionRelation(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listIdeaVersionRelation(RelationSearchContext context) {
        List<Relation> list = baseMapper.listIdeaVersionRelation(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchReviewReTestCase(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchReviewReTestCase(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listReviewReTestCase(RelationSearchContext context) {
        List<Relation> list = baseMapper.listReviewReTestCase(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchRunReBug(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchRunReBug(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listRunReBug(RelationSearchContext context) {
        List<Relation> list = baseMapper.listRunReBug(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchRunReIdea(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchRunReIdea(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listRunReIdea(RelationSearchContext context) {
        List<Relation> list = baseMapper.listRunReIdea(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchRunReWorkItem(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchRunReWorkItem(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listRunReWorkItem(RelationSearchContext context) {
        List<Relation> list = baseMapper.listRunReWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchTestCaseReBug(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchTestCaseReBug(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listTestCaseReBug(RelationSearchContext context) {
        List<Relation> list = baseMapper.listTestCaseReBug(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchTestCaseReIdea(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchTestCaseReIdea(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listTestCaseReIdea(RelationSearchContext context) {
        List<Relation> list = baseMapper.listTestCaseReIdea(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchTestCaseReWorkItem(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchTestCaseReWorkItem(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listTestCaseReWorkItem(RelationSearchContext context) {
        List<Relation> list = baseMapper.listTestCaseReWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchTestCaseVersionRelation(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchTestCaseVersionRelation(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listTestCaseVersionRelation(RelationSearchContext context) {
        List<Relation> list = baseMapper.listTestCaseVersionRelation(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchTicketReIdea(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchTicketReIdea(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listTicketReIdea(RelationSearchContext context) {
        List<Relation> list = baseMapper.listTicketReIdea(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchTicketReSelf(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchTicketReSelf(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listTicketReSelf(RelationSearchContext context) {
        List<Relation> list = baseMapper.listTicketReSelf(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchTicketReWorkItem(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchTicketReWorkItem(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listTicketReWorkItem(RelationSearchContext context) {
        List<Relation> list = baseMapper.listTicketReWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchWorkItemRelationIdea(RelationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchWorkItemRelationIdea(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listWorkItemRelationIdea(RelationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Relation> list = baseMapper.listWorkItemRelationIdea(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchWorkItemRelationSelf(RelationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchWorkItemRelationSelf(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listWorkItemRelationSelf(RelationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Relation> list = baseMapper.listWorkItemRelationSelf(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchWorkItemRelationTestCase(RelationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchWorkItemRelationTestCase(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listWorkItemRelationTestCase(RelationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Relation> list = baseMapper.listWorkItemRelationTestCase(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchWorkItemRelationTicket(RelationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchWorkItemRelationTicket(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listWorkItemRelationTicket(RelationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Relation> list = baseMapper.listWorkItemRelationTicket(context,context.getSelectCond());
        return list;
    }

    public Page<Relation> searchWorkItemVersionRelation(RelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Relation> pages=baseMapper.searchWorkItemVersionRelation(context.getPages(),context,context.getSelectCond());
        List<Relation> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Relation> listWorkItemVersionRelation(RelationSearchContext context) {
        List<Relation> list = baseMapper.listWorkItemVersionRelation(context,context.getSelectCond());
        return list;
    }

    public List<Relation> findByPrincipalId(List<String> principalIds) {
        List<Relation> list = baseMapper.findByPrincipalId(principalIds);
        return list;
    }
    public List<Relation> findById(List<String> ids) {
        List<Relation> list = baseMapper.findById(ids);
        return list;
    }
    public List<Relation> findByTargetId(List<String> targetIds) {
        List<Relation> list = baseMapper.findByTargetId(targetIds);
        return list;
    }
    public boolean removeByPrincipalId(String principalId) {
        return this.remove(Wrappers.<Relation>lambdaQuery().eq(Relation::getPrincipalId,principalId));
    }

    public boolean resetByPrincipalId(String principalId) {
        return this.update(Wrappers.<Relation>lambdaUpdate().eq(Relation::getPrincipalId,principalId));
    }

    public boolean saveByPrincipalBaseline(Baseline baseline,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByPrincipalId(baseline.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setPrincipalId(baseline.getId());
            sub.setPrincipalBaseline(baseline);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByPrincipalIdea(Idea idea,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByPrincipalId(idea.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setPrincipalId(idea.getId());
            sub.setPrincipalIdea(idea);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByPrincipalReview(Review review,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByPrincipalId(review.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setPrincipalId(review.getId());
            sub.setPrincipalReview(review);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeById(String id) {
        return this.remove(Wrappers.<Relation>lambdaQuery().eq(Relation::getId,id));
    }

    public boolean resetById(String id) {
        return this.update(Wrappers.<Relation>lambdaUpdate().eq(Relation::getId,id));
    }

    public boolean saveByReviewContentExtend(ReviewContentExtend reviewContentExtend,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findById(reviewContentExtend.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setId(reviewContentExtend.getId());
            sub.setReviewContentExtend(reviewContentExtend);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByTargetId(String targetId) {
        return this.remove(Wrappers.<Relation>lambdaQuery().eq(Relation::getTargetId,targetId));
    }

    public boolean resetByTargetId(String targetId) {
        return this.update(Wrappers.<Relation>lambdaUpdate().eq(Relation::getTargetId,targetId));
    }

    public boolean saveByTargetCustomer(Customer customer,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByTargetId(customer.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setTargetId(customer.getId());
            sub.setTargetCustomer(customer);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByTargetIdea(Idea idea,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByTargetId(idea.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setTargetId(idea.getId());
            sub.setTargetIdea(idea);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByTargetProductPlanCategory(ProductPlan productPlan,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByTargetId(productPlan.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setTargetId(productPlan.getId());
            sub.setTargetProductPlanCategory(productPlan);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByTargetTestCase(TestCase testCase,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByTargetId(testCase.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setTargetId(testCase.getId());
            sub.setTargetTestCase(testCase);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByTargetTicket(Ticket ticket,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByTargetId(ticket.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setTargetId(ticket.getId());
            sub.setTargetTicket(ticket);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByTargetWorkItem(WorkItem workItem,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByTargetId(workItem.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setTargetId(workItem.getId());
            sub.setTargetWorkItem(workItem);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByPrincipalTestCase(TestCase testCase,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByPrincipalId(testCase.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setPrincipalId(testCase.getId());
            sub.setPrincipalTestCase(testCase);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByPrincipalTestPlan(TestPlan testPlan,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByPrincipalId(testPlan.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setPrincipalId(testPlan.getId());
            sub.setPrincipalTestPlan(testPlan);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByPrincipalWorkItem(WorkItem workItem,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByPrincipalId(workItem.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setPrincipalId(workItem.getId());
            sub.setPrincipalWorkItem(workItem);
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
        return RelationMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Relation.class;
    }
}