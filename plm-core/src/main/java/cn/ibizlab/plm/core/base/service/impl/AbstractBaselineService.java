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
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.filter.BaselineSearchContext;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.base.mapper.BaselineMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[基线] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineService extends ServiceImpl<BaselineMapper,Baseline> implements BaselineService {

    @Autowired
    @Lazy
    protected RelationService relationService;

    protected int batchSize = 500;

    public Baseline get(Baseline et) {
        Baseline rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BASELINE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Baseline> getByEntities(List<Baseline> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public Baseline getDraft(Baseline et) {
        return et;
    }

    public Integer checkKey(Baseline et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Baseline>lambdaQuery().eq(Baseline::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Baseline et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Baseline> list) {
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Baseline et) {
        UpdateWrapper<Baseline> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Baseline> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Baseline et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Baseline> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Baseline> before = getByEntities(list).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> create = new ArrayList<>();
        List<Baseline> update = new ArrayList<>();
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
    public boolean remove(Baseline et) {
        if(!remove(Wrappers.<Baseline>lambdaQuery().eq(Baseline::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Baseline> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Baseline> searchDefault(BaselineSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Baseline> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Baseline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Baseline> listDefault(BaselineSearchContext context) {
        List<Baseline> list = baseMapper.listDefault(context,context.getSelectCond());
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
        return BaselineMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Baseline.class;
    }
}