/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.insight.service.impl;

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
import cn.ibizlab.plm.core.insight.domain.InsightReport;
import cn.ibizlab.plm.core.insight.filter.InsightReportSearchContext;
import cn.ibizlab.plm.core.insight.service.InsightReportService;
import cn.ibizlab.plm.core.insight.mapper.InsightReportMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.insight.service.InsightViewService;

/**
 * 实体[效能报表] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightReportService extends ServiceImpl<InsightReportMapper,InsightReport> implements InsightReportService {

    @Autowired
    @Lazy
    protected InsightViewService insightViewService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(InsightReport et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<InsightReport> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(InsightReport et) {
        UpdateWrapper<InsightReport> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<InsightReport> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(InsightReport et) {
        if(!remove(Wrappers.<InsightReport>lambdaQuery().eq(InsightReport::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<InsightReport> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public InsightReport get(InsightReport et) {
        InsightReport rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.INSIGHT_REPORT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<InsightReport> get(List<InsightReport> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public InsightReport getDraft(InsightReport et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(InsightReport et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<InsightReport>lambdaQuery().eq(InsightReport::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(InsightReport et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<InsightReport> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,InsightReport> before = get(list).stream().collect(Collectors.toMap(InsightReport::getId,e->e));
        List<InsightReport> create = new ArrayList<>();
        List<InsightReport> update = new ArrayList<>();
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
	
   public Page<InsightReport> fetchDefault(InsightReportSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightReport> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<InsightReport> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightReport> listDefault(InsightReportSearchContext context) {
        List<InsightReport> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightReport> fetchIsSystem(InsightReportSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightReport> pages=baseMapper.searchIsSystem(context.getPages(),context,context.getSelectCond());
        List<InsightReport> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightReport> listIsSystem(InsightReportSearchContext context) {
        List<InsightReport> list = baseMapper.listIsSystem(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightReport> fetchNormal(InsightReportSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightReport> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<InsightReport> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightReport> listNormal(InsightReportSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<InsightReport> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
	public List<InsightReport> findByViewId(List<String> viewIds){
        List<InsightReport> list = baseMapper.findByViewId(viewIds);
        return list;	
	}

	public List<InsightReport> findByInsightView(InsightView insightView){
        List<InsightReport> list = findByViewId(Arrays.asList(insightView.getId()));
		return list;
	}
	public boolean removeByViewId(String viewId){
        return this.remove(Wrappers.<InsightReport>lambdaQuery().eq(InsightReport::getViewId,viewId));
	}

	public boolean resetByViewId(String viewId){
		return this.update(Wrappers.<InsightReport>lambdaUpdate().eq(InsightReport::getViewId,viewId));
	}
	public boolean saveByInsightView(InsightView insightView, List<InsightReport> list){
        if(list==null)
            return true;

        Map<String,InsightReport> before = findByInsightView(insightView).stream().collect(Collectors.toMap(InsightReport::getId,e->e));
        List<InsightReport> update = new ArrayList<>();
        List<InsightReport> create = new ArrayList<>();

        for(InsightReport sub:list) {
            sub.setViewId(insightView.getId());
            sub.setInsightView(insightView);
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
   public Page<InsightReport> fetchView(InsightReportSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightReport> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<InsightReport> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightReport> listView(InsightReportSearchContext context) {
        List<InsightReport> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(InsightReport et) {
        if(Entities.INSIGHT_VIEW.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setViewId((String)et.getContextParentKey());
            InsightView insightView = et.getInsightView();
            if(insightView == null) {
                insightView = insightViewService.getById(et.getViewId());
                et.setInsightView(insightView);
            }
            if(!ObjectUtils.isEmpty(insightView)) {
                et.setViewId(insightView.getId());
                et.setViewName(insightView.getName());
            }
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
        return InsightReportMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return InsightReport.class;
    }

}