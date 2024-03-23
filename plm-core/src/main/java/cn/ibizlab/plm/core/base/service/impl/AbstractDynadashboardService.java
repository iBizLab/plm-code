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
import cn.ibizlab.plm.core.base.domain.Dynadashboard;
import cn.ibizlab.plm.core.base.filter.DynadashboardSearchContext;
import cn.ibizlab.plm.core.base.service.DynadashboardService;
import cn.ibizlab.plm.core.base.mapper.DynadashboardMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[动态数据看板] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDynadashboardService extends ServiceImpl<DynadashboardMapper,Dynadashboard> implements DynadashboardService {

    protected int batchSize = 500;

    public Dynadashboard get(Dynadashboard et) {
        Dynadashboard rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DYNADASHBOARD.toString(),et.getDynaDashboardId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Dynadashboard> getByEntities(List<Dynadashboard> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public Dynadashboard getDraft(Dynadashboard et) {
        return et;
    }

    public Integer checkKey(Dynadashboard et) {
        return (!ObjectUtils.isEmpty(et.getDynaDashboardId()) && this.count(Wrappers.<Dynadashboard>lambdaQuery().eq(Dynadashboard::getDynaDashboardId, et.getDynaDashboardId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Dynadashboard et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Dynadashboard> list) {
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Dynadashboard et) {
        UpdateWrapper<Dynadashboard> qw = et.getUpdateWrapper(true);
        qw.eq("dynadashboardid", et.getDynaDashboardId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Dynadashboard> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Dynadashboard et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Dynadashboard> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Dynadashboard> before = getByEntities(list).stream().collect(Collectors.toMap(Dynadashboard::getDynaDashboardId,e->e));
        List<Dynadashboard> create = new ArrayList<>();
        List<Dynadashboard> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getDynaDashboardId()) && before.containsKey(sub.getDynaDashboardId()))
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
    public boolean remove(Dynadashboard et) {
        if(!remove(Wrappers.<Dynadashboard>lambdaQuery().eq(Dynadashboard::getDynaDashboardId, et.getDynaDashboardId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Dynadashboard> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Dynadashboard> searchDefault(DynadashboardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Dynadashboard> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Dynadashboard> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Dynadashboard> listDefault(DynadashboardSearchContext context) {
        List<Dynadashboard> list = baseMapper.listDefault(context,context.getSelectCond());
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
        return DynadashboardMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Dynadashboard.class;
    }
}