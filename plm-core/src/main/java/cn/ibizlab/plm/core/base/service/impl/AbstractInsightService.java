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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Insight;
import cn.ibizlab.plm.core.base.filter.InsightSearchContext;
import cn.ibizlab.plm.core.base.service.InsightService;
import cn.ibizlab.plm.core.base.mapper.InsightMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[洞察力] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightService extends ServiceImpl<InsightMapper,Insight> implements InsightService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Insight et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Insight> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Insight et) {
        UpdateWrapper<Insight> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Insight> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Insight et) {
        if(!remove(Wrappers.<Insight>lambdaQuery().eq(Insight::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Insight> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Insight get(Insight et) {
        Insight rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.INSIGHT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Insight> get(List<Insight> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Insight getDraft(Insight et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(Insight et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Insight>lambdaQuery().eq(Insight::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Insight et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Insight> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Insight> before = get(list).stream().collect(Collectors.toMap(Insight::getId,e->e));
        List<Insight> create = new ArrayList<>();
        List<Insight> update = new ArrayList<>();
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
	
   public Page<Insight> fetchDefault(InsightSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Insight> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Insight> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Insight> listDefault(InsightSearchContext context) {
        List<Insight> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Insight> fetchView(InsightSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Insight> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Insight> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Insight> listView(InsightSearchContext context) {
        List<Insight> list = baseMapper.listView(context,context.getSelectCond());
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
        return InsightMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Insight.class;
    }

}