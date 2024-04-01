/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

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
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import cn.ibizlab.plm.core.base.service.WorkloadService;
import cn.ibizlab.plm.core.base.mapper.WorkloadMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.core.base.service.WorkloadTypeService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[工时] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkloadService extends ServiceImpl<WorkloadMapper,Workload> implements WorkloadService {

    @Autowired
    @Lazy
    protected WorkloadTypeService workloadTypeService;

    @Autowired
    @Lazy
    protected IdeaService ideaService;

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    public Workload get(Workload et) {
        Workload rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.WORKLOAD.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Workload> getByEntities(List<Workload> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Workload et) {
        if(Entities.WORKLOAD_TYPE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTypeId((String)et.getContextParentKey());
            WorkloadType workloadType = et.getWorkloadType();
            if(workloadType == null) {
                workloadType = workloadTypeService.getById(et.getTypeId());
                et.setWorkloadType(workloadType);
            }
            if(!ObjectUtils.isEmpty(workloadType)) {
                et.setTypeId(workloadType.getId());
                et.setTypeName(workloadType.getName());
            }
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
    }

    public Workload getDraft(Workload et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Workload et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Workload>lambdaQuery().eq(Workload::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Workload et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Workload> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Workload et) {
        UpdateWrapper<Workload> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Workload> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Workload et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Workload> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Workload> before = getByEntities(list).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> create = new ArrayList<>();
        List<Workload> update = new ArrayList<>();
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
    public boolean remove(Workload et) {
        if(!remove(Wrappers.<Workload>lambdaQuery().eq(Workload::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Workload> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Workload> searchCalendar(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchCalendar(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listCalendar(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        List<Workload> list = baseMapper.listCalendar(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchDefault(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listDefault(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchIdeaWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchIdeaWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listIdeaWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listIdeaWorkload(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchLog(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("REGISTER_DATE,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchLog(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listLog(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("REGISTER_DATE,DESC");
        List<Workload> list = baseMapper.listLog(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchMyCalendar(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyCalendar(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listMyCalendar(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        List<Workload> list = baseMapper.listMyCalendar(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchMyIdeaWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyIdeaWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listMyIdeaWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMyIdeaWorkload(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchMyLog(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("REGISTER_DATE,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyLog(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listMyLog(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("REGISTER_DATE,DESC");
        List<Workload> list = baseMapper.listMyLog(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchMyTestCaseWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyTestCaseWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listMyTestCaseWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMyTestCaseWorkload(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchMyTypeOf(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyTypeOf(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listMyTypeOf(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMyTypeOf(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchMyWorkItemWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyWorkItemWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listMyWorkItemWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMyWorkItemWorkload(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchTestCaseWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchTestCaseWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listTestCaseWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listTestCaseWorkload(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchTypeOf(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchTypeOf(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listTypeOf(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listTypeOf(context,context.getSelectCond());
        return list;
    }

    public Page<Workload> searchWorkItemWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchWorkItemWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Workload> listWorkItemWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listWorkItemWorkload(context,context.getSelectCond());
        return list;
    }

    public List<Workload> findByTypeId(List<String> typeIds) {
        List<Workload> list = baseMapper.findByTypeId(typeIds);
        return list;
    }
    public List<Workload> findByPrincipalId(List<String> principalIds) {
        List<Workload> list = baseMapper.findByPrincipalId(principalIds);
        return list;
    }
    public boolean removeByTypeId(String typeId) {
        return this.remove(Wrappers.<Workload>lambdaQuery().eq(Workload::getTypeId,typeId));
    }

    public boolean resetByTypeId(String typeId) {
        return this.update(Wrappers.<Workload>lambdaUpdate().eq(Workload::getTypeId,typeId));
    }

    public boolean saveByWorkloadType(WorkloadType workloadType,List<Workload> list) {
        if(list==null)
            return true;
        Map<String,Workload> before = findByTypeId(workloadType.getId()).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> update = new ArrayList<>();
        List<Workload> create = new ArrayList<>();

        for(Workload sub:list) {
            sub.setTypeId(workloadType.getId());
            sub.setWorkloadType(workloadType);
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
        return this.remove(Wrappers.<Workload>lambdaQuery().eq(Workload::getPrincipalId,principalId));
    }

    public boolean resetByPrincipalId(String principalId) {
        return this.update(Wrappers.<Workload>lambdaUpdate().eq(Workload::getPrincipalId,principalId));
    }

    public boolean saveByRelIdea(Idea idea,List<Workload> list) {
        if(list==null)
            return true;
        Map<String,Workload> before = findByPrincipalId(idea.getId()).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> update = new ArrayList<>();
        List<Workload> create = new ArrayList<>();

        for(Workload sub:list) {
            sub.setPrincipalId(idea.getId());
            sub.setRelIdea(idea);
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

    public boolean saveByRelTestCase(TestCase testCase,List<Workload> list) {
        if(list==null)
            return true;
        Map<String,Workload> before = findByPrincipalId(testCase.getId()).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> update = new ArrayList<>();
        List<Workload> create = new ArrayList<>();

        for(Workload sub:list) {
            sub.setPrincipalId(testCase.getId());
            sub.setRelTestCase(testCase);
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

    public boolean saveByRelWorkItem(WorkItem workItem,List<Workload> list) {
        if(list==null)
            return true;
        Map<String,Workload> before = findByPrincipalId(workItem.getId()).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> update = new ArrayList<>();
        List<Workload> create = new ArrayList<>();

        for(Workload sub:list) {
            sub.setPrincipalId(workItem.getId());
            sub.setRelWorkItem(workItem);
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
        return WorkloadMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Workload.class;
    }
}