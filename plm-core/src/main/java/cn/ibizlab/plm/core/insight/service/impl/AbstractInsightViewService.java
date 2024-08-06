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
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.insight.filter.InsightViewSearchContext;
import cn.ibizlab.plm.core.insight.service.InsightViewService;
import cn.ibizlab.plm.core.insight.mapper.InsightViewMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.core.insight.service.InsightMemberService;
import cn.ibizlab.plm.core.insight.domain.InsightReport;
import cn.ibizlab.plm.core.insight.service.InsightReportService;
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.core.base.service.DynaDashboardService;

/**
 * 实体[效能视图] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightViewService extends ServiceImpl<InsightViewMapper,InsightView> implements InsightViewService {

    @Autowired
    @Lazy
    protected InsightMemberService insightMemberService;

    @Autowired
    @Lazy
    protected InsightReportService insightReportService;

    @Autowired
    @Lazy
    protected DynaDashboardService dynaDashboardService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(InsightView et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        insightMemberService.saveByInsightView(et,et.getMembers());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<InsightView> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(InsightView et) {
        UpdateWrapper<InsightView> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        insightMemberService.saveByInsightView(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<InsightView> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(InsightView et) {
        String key = et.getId();
        insightReportService.removeByViewId(key);
        if(!remove(Wrappers.<InsightView>lambdaQuery().eq(InsightView::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<InsightView> entities) {
        for (InsightView et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public InsightView get(InsightView et) {
        InsightView rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.INSIGHT_VIEW.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [效能成员]
        getMembers(et);
        return et;
    }	

    public List<InsightView> get(List<InsightView> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public InsightView getDraft(InsightView et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(InsightView et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<InsightView>lambdaQuery().eq(InsightView::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(InsightView et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<InsightView> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,InsightView> before = get(list).stream().collect(Collectors.toMap(InsightView::getId,e->e));
        List<InsightView> create = new ArrayList<>();
        List<InsightView> update = new ArrayList<>();
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
	
   public Page<InsightView> fetchDefault(InsightViewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listDefault(InsightViewSearchContext context) {
        List<InsightView> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightView> fetchAdmin(InsightViewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listAdmin(InsightViewSearchContext context) {
        List<InsightView> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightView> fetchDeleted(InsightViewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listDeleted(InsightViewSearchContext context) {
        List<InsightView> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightView> fetchFavorite(InsightViewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchFavorite(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listFavorite(InsightViewSearchContext context) {
        List<InsightView> list = baseMapper.listFavorite(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightView> fetchMain(InsightViewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchMain(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listMain(InsightViewSearchContext context) {
        List<InsightView> list = baseMapper.listMain(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightView> fetchNormal(InsightViewSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listNormal(InsightViewSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<InsightView> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightView> fetchReader(InsightViewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listReader(InsightViewSearchContext context) {
        List<InsightView> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<InsightView> fetchUser(InsightViewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listUser(InsightViewSearchContext context) {
        List<InsightView> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
   }
	
	@Override
    public List<InsightMember> getMembers(InsightView et) {
        List<InsightMember> list = insightMemberService.findByInsightView(et);
        et.setMembers(list);
        return list;
    }
	
   public Page<InsightView> fetchView(InsightViewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightView> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<InsightView> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightView> listView(InsightViewSearchContext context) {
        List<InsightView> list = baseMapper.listView(context,context.getSelectCond());
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
        return InsightViewMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return InsightView.class;
    }

}