/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.insight.service.InsightViewService;

/**
 * 实体[动态数据看板] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDynaDashboardService extends ServiceImpl<DynaDashboardMapper,DynaDashboard> implements DynaDashboardService {

    @Autowired
    @Lazy
    protected InsightViewService insightViewService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DynaDashboard et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<DynaDashboard> list) {
        list.forEach(this::fillParentData);
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
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(DynaDashboard et) {
        return (!ObjectUtils.isEmpty(et.getDynaDashboardId()) && this.count(Wrappers.<DynaDashboard>lambdaQuery().eq(DynaDashboard::getDynaDashboardId, et.getDynaDashboardId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(DynaDashboard et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
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
	
   public Page<DynaDashboard> fetchExampleChart(DynaDashboardSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCES,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DynaDashboard> pages=baseMapper.searchExampleChart(context.getPages(),context,context.getSelectCond());
        List<DynaDashboard> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DynaDashboard> listExampleChart(DynaDashboardSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCES,ASC");
        List<DynaDashboard> list = baseMapper.listExampleChart(context,context.getSelectCond());
        return list;
   }
	
   public Page<DynaDashboard> fetchIsSystem(DynaDashboardSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCES,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DynaDashboard> pages=baseMapper.searchIsSystem(context.getPages(),context,context.getSelectCond());
        List<DynaDashboard> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DynaDashboard> listIsSystem(DynaDashboardSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCES,DESC");
        List<DynaDashboard> list = baseMapper.listIsSystem(context,context.getSelectCond());
        return list;
   }
	
   public Page<DynaDashboard> fetchNormal(DynaDashboardSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCES,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DynaDashboard> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<DynaDashboard> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DynaDashboard> listNormal(DynaDashboardSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCES,ASC");
        List<DynaDashboard> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
	public List<DynaDashboard> findByOwnerId(List<String> ownerIds){
        List<DynaDashboard> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<DynaDashboard> findByInsightView(InsightView insightView){
        List<DynaDashboard> list = findByOwnerId(Arrays.asList(insightView.getId()));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<DynaDashboard>lambdaQuery().eq(DynaDashboard::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<DynaDashboard>lambdaUpdate().set(DynaDashboard::getOwnerId, null).eq(DynaDashboard::getOwnerId,ownerId));
	}
	public boolean saveByInsightView(InsightView insightView, List<DynaDashboard> list){
        if(list==null)
            return true;

        Map<String,DynaDashboard> before = findByInsightView(insightView).stream().collect(Collectors.toMap(DynaDashboard::getDynaDashboardId,e->e));
        List<DynaDashboard> update = new ArrayList<>();
        List<DynaDashboard> create = new ArrayList<>();

        for(DynaDashboard sub:list) {
            sub.setOwnerId(insightView.getId());
            sub.setInsightView(insightView);
            if(!ObjectUtils.isEmpty(sub.getDynaDashboardId())&&before.containsKey(sub.getDynaDashboardId())) {
                before.remove(sub.getDynaDashboardId());
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
   public Page<DynaDashboard> fetchView(DynaDashboardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DynaDashboard> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<DynaDashboard> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DynaDashboard> listView(DynaDashboardSearchContext context) {
        List<DynaDashboard> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(DynaDashboard et) {
        if(Entities.INSIGHT_VIEW.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
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
        return DynaDashboardMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return DynaDashboard.class;
    }

}