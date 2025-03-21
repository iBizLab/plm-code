/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.team.domain.Period;
import cn.ibizlab.plm.core.team.filter.PeriodSearchContext;
import cn.ibizlab.plm.core.team.service.PeriodService;
import cn.ibizlab.plm.core.team.mapper.PeriodMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.team.domain.Objective;
import cn.ibizlab.plm.core.team.service.ObjectiveService;

/**
 * 实体[周期] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPeriodService extends ServiceImpl<PeriodMapper,Period> implements PeriodService {

    @Autowired
    @Lazy
    protected ObjectiveService objectiveService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Period et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Period> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Period et) {
        UpdateWrapper<Period> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Period> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Period et) {
        if(!remove(Wrappers.<Period>lambdaQuery().eq(Period::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Period> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Period get(Period et) {
        Period rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PERIOD.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Period> get(List<Period> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Period getDraft(Period et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(Period et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Period>lambdaQuery().eq(Period::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Period et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Period> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Period> before = get(list).stream().collect(Collectors.toMap(Period::getId,e->e));
        List<Period> create = new ArrayList<>();
        List<Period> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getId()) && before.containsKey(sub.getId()))
                update.add(sub);
            else
                create.add(sub);
        });
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else
            return true;
    }
	
   public Page<Period> fetchDefault(PeriodSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Period> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Period> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Period> listDefault(PeriodSearchContext context) {
        List<Period> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Period> fetchView(PeriodSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Period> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Period> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Period> listView(PeriodSearchContext context) {
        List<Period> list = baseMapper.listView(context,context.getSelectCond());
        return list;
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
        return PeriodMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Period.class;
    }

}