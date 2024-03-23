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
import cn.ibizlab.plm.core.base.domain.ExtendLog;
import cn.ibizlab.plm.core.base.filter.ExtendLogSearchContext;
import cn.ibizlab.plm.core.base.service.ExtendLogService;
import cn.ibizlab.plm.core.base.mapper.ExtendLogMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[扩展日志] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractExtendLogService extends ServiceImpl<ExtendLogMapper,ExtendLog> implements ExtendLogService {

    protected int batchSize = 500;

    public ExtendLog get(ExtendLog et) {
        ExtendLog rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.EXTEND_LOG.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<ExtendLog> getByEntities(List<ExtendLog> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public ExtendLog getDraft(ExtendLog et) {
        return et;
    }

    public Integer checkKey(ExtendLog et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ExtendLog>lambdaQuery().eq(ExtendLog::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(ExtendLog et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<ExtendLog> list) {
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(ExtendLog et) {
        UpdateWrapper<ExtendLog> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<ExtendLog> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(ExtendLog et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<ExtendLog> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ExtendLog> before = getByEntities(list).stream().collect(Collectors.toMap(ExtendLog::getId,e->e));
        List<ExtendLog> create = new ArrayList<>();
        List<ExtendLog> update = new ArrayList<>();
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
    public boolean remove(ExtendLog et) {
        if(!remove(Wrappers.<ExtendLog>lambdaQuery().eq(ExtendLog::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<ExtendLog> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<ExtendLog> searchDefault(ExtendLogSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ExtendLog> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ExtendLog> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<ExtendLog> listDefault(ExtendLogSearchContext context) {
        List<ExtendLog> list = baseMapper.listDefault(context,context.getSelectCond());
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
        return ExtendLogMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ExtendLog.class;
    }
}