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
import cn.ibizlab.plm.core.base.domain.Activity;
import cn.ibizlab.plm.core.base.filter.ActivitySearchContext;
import cn.ibizlab.plm.core.base.service.ActivityService;
import cn.ibizlab.plm.core.base.mapper.ActivityMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[活动] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractActivityService extends ServiceImpl<ActivityMapper,Activity> implements ActivityService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Activity et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Activity> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Activity et) {
        UpdateWrapper<Activity> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Activity> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Activity et) {
        if(!remove(Wrappers.<Activity>lambdaQuery().eq(Activity::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Activity> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Activity get(Activity et) {
        Activity rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ACTIVITY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Activity> get(List<Activity> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Activity getDraft(Activity et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(Activity et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Activity>lambdaQuery().eq(Activity::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Activity et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Activity> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Activity> before = get(list).stream().collect(Collectors.toMap(Activity::getId,e->e));
        List<Activity> create = new ArrayList<>();
        List<Activity> update = new ArrayList<>();
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
	
   public Page<Activity> fetchAll(ActivitySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Activity> pages=baseMapper.searchAll(context.getPages(),context,context.getSelectCond());
        List<Activity> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Activity> listAll(ActivitySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Activity> list = baseMapper.listAll(context,context.getSelectCond());
        return list;
   }
	
   public Page<Activity> fetchDefault(ActivitySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Activity> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Activity> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Activity> listDefault(ActivitySearchContext context) {
        List<Activity> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Activity> fetchView(ActivitySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Activity> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Activity> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Activity> listView(ActivitySearchContext context) {
        List<Activity> list = baseMapper.listView(context,context.getSelectCond());
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
        return ActivityMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Activity.class;
    }

}