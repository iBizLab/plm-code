/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service.impl;

import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.filter.RunSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.RunService;
import cn.ibizlab.plm.core.testmgmt.mapper.RunMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.service.RunHistoryService;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;

/**
 * 实体[执行用例] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRunService extends ServiceImpl<RunMapper,Run> implements RunService {

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    @Autowired
    @Lazy
    protected TestPlanService testPlanService;

    @Autowired
    @Lazy
    protected RunHistoryService runHistoryService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected AttachmentService attachmentService;

    protected int batchSize = 500;

    public Run get(Run et) {
        Run rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.RUN.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [执行结果]
        getRunHistories(et);
        //设置 [关注]
        getAttentions(et);
        //设置 [附件]
        getAttachments(et);
        return et;
    }

    public List<Run> getByEntities(List<Run> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Run et) {
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setCaseId((String)et.getContextParentKey());
            TestCase testCase = et.getTestCase();
            if(testCase == null) {
                testCase = testCaseService.getById(et.getCaseId());
                et.setTestCase(testCase);
            }
            if(!ObjectUtils.isEmpty(testCase)) {
                et.setIdentifier(testCase.getIdentifier());
                et.setTitle(testCase.getTitle());
                et.setState(testCase.getState());
                et.setLevel(testCase.getLevel());
                et.setType(testCase.getType());
                et.setTestType(testCase.getTestType());
                et.setMaintenanceName(testCase.getMaintenanceName());
                et.setSuiteId(testCase.getSuiteId());
                et.setSuiteName(testCase.getSuiteName());
                et.setPrecondition(testCase.getPrecondition());
                et.setSuites(testCase.getSuites());
                et.setCaseId(testCase.getId());
                et.setCaseName(testCase.getName());
            }
        }
        if(Entities.TEST_PLAN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPlanId((String)et.getContextParentKey());
            TestPlan testPlan = et.getTestPlan();
            if(testPlan == null) {
                testPlan = testPlanService.getById(et.getPlanId());
                et.setTestPlan(testPlan);
            }
            if(!ObjectUtils.isEmpty(testPlan)) {
                et.setPlanName(testPlan.getName());
                et.setLibraryName(testPlan.getLibraryName());
                et.setLibraryId(testPlan.getLibraryId());
                et.setPlanId(testPlan.getId());
            }
        }
    }

    public Run getDraft(Run et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Run et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Run>lambdaQuery().eq(Run::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Run et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        runHistoryService.saveByRun(et,et.getRunHistories());
        attentionService.saveByRun(et,et.getAttentions());
        attachmentService.saveByRun(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Run> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Run et) {
        UpdateWrapper<Run> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        runHistoryService.saveByRun(et,et.getRunHistories());
        attentionService.saveByRun(et,et.getAttentions());
        attachmentService.saveByRun(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Run> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Run et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Run> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Run> before = getByEntities(list).stream().collect(Collectors.toMap(Run::getId,e->e));
        List<Run> create = new ArrayList<>();
        List<Run> update = new ArrayList<>();
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
    public boolean remove(Run et) {
        String key = et.getId();
        runHistoryService.removeByRunId(key);
        if(!remove(Wrappers.<Run>lambdaQuery().eq(Run::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Run> entities) {
        for (Run et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }

    public Page<Run> searchCasePerson(RunSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchCasePerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<Run>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),Run.class), context.getPageable(), pages.getTotal());
    }

    public List<Run> listCasePerson(RunSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listCasePerson(context,context.getSelectCond()),Run.class);
    }

    public Page<Run> searchCommentNotifyExecutor(RunSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Run> pages=baseMapper.searchCommentNotifyExecutor(context.getPages(),context,context.getSelectCond());
        List<Run> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Run> listCommentNotifyExecutor(RunSearchContext context) {
        List<Run> list = baseMapper.listCommentNotifyExecutor(context,context.getSelectCond());
        return list;
    }

    public Page<Run> searchDefault(RunSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Run> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Run> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Run> listDefault(RunSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<Run> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Run> searchImplementationResults(RunSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchImplementationResults(context.getPages(),context,context.getSelectCond());
        return new PageImpl<Run>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),Run.class), context.getPageable(), pages.getTotal());
    }

    public List<Run> listImplementationResults(RunSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listImplementationResults(context,context.getSelectCond()),Run.class);
    }

    public Page<Run> searchNormal(RunSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Run> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Run> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Run> listNormal(RunSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<Run> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
    }

    public Page<Run> searchPriorityDistributions(RunSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchPriorityDistributions(context.getPages(),context,context.getSelectCond());
        return new PageImpl<Run>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),Run.class), context.getPageable(), pages.getTotal());
    }

    public List<Run> listPriorityDistributions(RunSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listPriorityDistributions(context,context.getSelectCond()),Run.class);
    }

    public List<Run> findByCaseId(List<String> caseIds) {
        List<Run> list = baseMapper.findByCaseId(caseIds);
        if(!ObjectUtils.isEmpty(list))
            runHistoryService.findByRunId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getRunId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setRunHistories(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;
    }
    public List<Run> findByPlanId(List<String> planIds) {
        List<Run> list = baseMapper.findByPlanId(planIds);
        if(!ObjectUtils.isEmpty(list))
            runHistoryService.findByRunId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getRunId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setRunHistories(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;
    }
    public boolean removeByCaseId(String caseId) {
        List<String> ids = baseMapper.findByCaseId(Arrays.asList(caseId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.removeBatch(ids);
        else
            return true;
    }

    public boolean resetByCaseId(String caseId) {
        return this.update(Wrappers.<Run>lambdaUpdate().eq(Run::getCaseId,caseId));
    }

    public boolean saveByTestCase(TestCase testCase,List<Run> list) {
        if(list==null)
            return true;
        Map<String,Run> before = findByCaseId(testCase.getId()).stream().collect(Collectors.toMap(Run::getId,e->e));
        List<Run> update = new ArrayList<>();
        List<Run> create = new ArrayList<>();

        for(Run sub:list) {
            sub.setCaseId(testCase.getId());
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByPlanId(String planId) {
        List<String> ids = baseMapper.findByPlanId(Arrays.asList(planId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.removeBatch(ids);
        else
            return true;
    }

    public boolean resetByPlanId(String planId) {
        return this.update(Wrappers.<Run>lambdaUpdate().eq(Run::getPlanId,planId));
    }

    public boolean saveByTestPlan(TestPlan testPlan,List<Run> list) {
        if(list==null)
            return true;
        Map<String,Run> before = findByPlanId(testPlan.getId()).stream().collect(Collectors.toMap(Run::getId,e->e));
        List<Run> update = new ArrayList<>();
        List<Run> create = new ArrayList<>();

        for(Run sub:list) {
            sub.setPlanId(testPlan.getId());
            sub.setTestPlan(testPlan);
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
    public List<RunHistory> getRunHistories(Run et) {
        List<RunHistory> list = runHistoryService.findByRunId(et.getId());
        et.setRunHistories(list);
        return list;
    }

    @Override
    public List<Attention> getAttentions(Run et) {
        List<Attention> list = attentionService.findByOwnerId(et.getId());
        et.setAttentions(list);
        return list;
    }

    @Override
    public List<Attachment> getAttachments(Run et) {
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
        return RunMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Run.class;
    }
}