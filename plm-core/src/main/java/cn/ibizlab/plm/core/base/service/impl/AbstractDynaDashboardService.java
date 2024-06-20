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
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext;
import cn.ibizlab.plm.core.base.service.DynaDashboardService;
import cn.ibizlab.plm.core.base.mapper.DynaDashboardMapper;
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
public abstract class AbstractDynaDashboardService extends ServiceImpl<DynaDashboardMapper,DynaDashboard> implements DynaDashboardService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DynaDashboard et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<DynaDashboard> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(DynaDashboard et) {
        UpdateWrapper<DynaDashboard> qw = et.getUpdateWrapper(true);
        qw.eq("dynadashboardid", et.getDynaDashboardId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<DynaDashboard> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(DynaDashboard et) {
        if(!remove(Wrappers.<DynaDashboard>lambdaQuery().eq(DynaDashboard::getDynaDashboardId, et.getDynaDashboardId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<DynaDashboard> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public DynaDashboard get(DynaDashboard et) {
        DynaDashboard rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DYNA_DASHBOARD.toString(),et.getDynaDashboardId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<DynaDashboard> get(List<DynaDashboard> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public DynaDashboard getDraft(DynaDashboard et) {
        return et;
    }
	
    public Integer checkKey(DynaDashboard et) {
        return (!ObjectUtils.isEmpty(et.getDynaDashboardId()) && this.count(Wrappers.<DynaDashboard>lambdaQuery().eq(DynaDashboard::getDynaDashboardId, et.getDynaDashboardId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(DynaDashboard et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<DynaDashboard> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,DynaDashboard> before = get(list).stream().collect(Collectors.toMap(DynaDashboard::getDynaDashboardId,e->e));
        List<DynaDashboard> create = new ArrayList<>();
        List<DynaDashboard> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getDynaDashboardId()) && before.containsKey(sub.getDynaDashboardId()))
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
	
   public Page<DynaDashboard> fetchDefault(DynaDashboardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DynaDashboard> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<DynaDashboard> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DynaDashboard> listDefault(DynaDashboardSearchContext context) {
        List<DynaDashboard> list = baseMapper.listDefault(context,context.getSelectCond());
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
        return DynaDashboardMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return DynaDashboard.class;
    }

}