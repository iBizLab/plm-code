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
        if(Entities.TEST_PLAN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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

    public List<Relation> findByPrincipalId(List<String> principalIds) {
        List<Relation> list = baseMapper.findByPrincipalId(principalIds);
        return list;
    }
    public boolean removeByPrincipalId(String principalId) {
        return this.remove(Wrappers.<Relation>lambdaQuery().eq(Relation::getPrincipalId,principalId));
    }

    public boolean resetByPrincipalId(String principalId) {
        return this.update(Wrappers.<Relation>lambdaUpdate().eq(Relation::getPrincipalId,principalId));
    }

    public boolean saveByTestPlan(TestPlan testPlan,List<Relation> list) {
        if(list==null)
            return true;
        Map<String,Relation> before = findByPrincipalId(testPlan.getId()).stream().collect(Collectors.toMap(Relation::getId,e->e));
        List<Relation> update = new ArrayList<>();
        List<Relation> create = new ArrayList<>();

        for(Relation sub:list) {
            sub.setPrincipalId(testPlan.getId());
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