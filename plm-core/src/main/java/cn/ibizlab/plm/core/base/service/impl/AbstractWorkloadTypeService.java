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
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.core.base.filter.WorkloadTypeSearchContext;
import cn.ibizlab.plm.core.base.service.WorkloadTypeService;
import cn.ibizlab.plm.core.base.mapper.WorkloadTypeMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.service.WorkloadService;

/**
 * 实体[工时类别] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkloadTypeService extends ServiceImpl<WorkloadTypeMapper,WorkloadType> implements WorkloadTypeService {

    @Autowired
    @Lazy
    protected WorkloadService workloadService;

    protected int batchSize = 500;

    public WorkloadType get(WorkloadType et) {
        WorkloadType rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.WORKLOAD_TYPE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<WorkloadType> getByEntities(List<WorkloadType> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public WorkloadType getDraft(WorkloadType et) {
        return et;
    }

    public Integer checkKey(WorkloadType et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<WorkloadType>lambdaQuery().eq(WorkloadType::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(WorkloadType et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<WorkloadType> list) {
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(WorkloadType et) {
        UpdateWrapper<WorkloadType> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<WorkloadType> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(WorkloadType et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<WorkloadType> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,WorkloadType> before = getByEntities(list).stream().collect(Collectors.toMap(WorkloadType::getId,e->e));
        List<WorkloadType> create = new ArrayList<>();
        List<WorkloadType> update = new ArrayList<>();
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
    public boolean remove(WorkloadType et) {
        if(!remove(Wrappers.<WorkloadType>lambdaQuery().eq(WorkloadType::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<WorkloadType> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<WorkloadType> searchDefault(WorkloadTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkloadType> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<WorkloadType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkloadType> listDefault(WorkloadTypeSearchContext context) {
        List<WorkloadType> list = baseMapper.listDefault(context,context.getSelectCond());
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
        return WorkloadTypeMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return WorkloadType.class;
    }
}