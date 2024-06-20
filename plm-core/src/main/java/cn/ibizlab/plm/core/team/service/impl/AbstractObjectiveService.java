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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.team.domain.Objective;
import cn.ibizlab.plm.core.team.filter.ObjectiveSearchContext;
import cn.ibizlab.plm.core.team.service.ObjectiveService;
import cn.ibizlab.plm.core.team.mapper.ObjectiveMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.team.domain.Period;
import cn.ibizlab.plm.core.team.service.PeriodService;
import cn.ibizlab.plm.core.team.domain.KeyResult;
import cn.ibizlab.plm.core.team.service.KeyResultService;
import cn.ibizlab.plm.core.team.domain.UpdateRecord;
import cn.ibizlab.plm.core.team.service.UpdateRecordService;

/**
 * 实体[目标] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractObjectiveService extends ServiceImpl<ObjectiveMapper,Objective> implements ObjectiveService {

    @Autowired
    @Lazy
    protected PeriodService periodService;

    @Autowired
    @Lazy
    protected KeyResultService keyResultService;

    @Autowired
    @Lazy
    protected UpdateRecordService updateRecordService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Objective et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Objective> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Objective et) {
        UpdateWrapper<Objective> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Objective> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Objective et) {
        if(!remove(Wrappers.<Objective>lambdaQuery().eq(Objective::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Objective> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Objective get(Objective et) {
        Objective rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.OBJECTIVE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Objective> get(List<Objective> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Objective getDraft(Objective et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(Objective et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Objective>lambdaQuery().eq(Objective::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(Objective et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Objective> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Objective> before = get(list).stream().collect(Collectors.toMap(Objective::getId,e->e));
        List<Objective> create = new ArrayList<>();
        List<Objective> update = new ArrayList<>();
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
	
   public Page<Objective> fetchDefault(ObjectiveSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Objective> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Objective> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Objective> listDefault(ObjectiveSearchContext context) {
        List<Objective> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<Objective> findByPeriodId(List<String> periodIds){
        List<Objective> list = baseMapper.findByPeriodId(periodIds);
        return list;	
	}

	public boolean removeByPeriodId(String periodId){
        return this.remove(Wrappers.<Objective>lambdaQuery().eq(Objective::getPeriodId,periodId));
	}

	public boolean resetByPeriodId(String periodId){
		return this.update(Wrappers.<Objective>lambdaUpdate().eq(Objective::getPeriodId,periodId));
	}
	public boolean saveByPeriod(Period period, List<Objective> list){
        if(list==null)
            return true;
        Map<String,Objective> before = findByPeriodId(period.getId()).stream().collect(Collectors.toMap(Objective::getId,e->e));

        List<Objective> update = new ArrayList<>();
        List<Objective> create = new ArrayList<>();

        for(Objective sub:list) {
            sub.setPeriodId(period.getId());
            sub.setPeriod(period);
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}

    public void fillParentData(Objective et) {
        if(Entities.PERIOD.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPeriodId((String)et.getContextParentKey());
        }
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
        return ObjectiveMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Objective.class;
    }

}