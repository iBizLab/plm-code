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
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.filter.WorkSearchContext;
import cn.ibizlab.plm.core.base.service.WorkService;
import cn.ibizlab.plm.core.base.mapper.WorkMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.service.PortfolioService;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;

/**
 * 实体[工作] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkService extends ServiceImpl<WorkMapper,Work> implements WorkService {

    @Autowired
    @Lazy
    protected PortfolioService portfolioService;

    @Autowired
    @Lazy
    protected ProjectService projectService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Work et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Work> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Work et) {
        UpdateWrapper<Work> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Work> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Work et) {
        if(!remove(Wrappers.<Work>lambdaQuery().eq(Work::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Work> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Work get(Work et) {
        Work rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.WORK.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Work> get(List<Work> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Work getDraft(Work et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(Work et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Work>lambdaQuery().eq(Work::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(Work et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Work> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Work> before = get(list).stream().collect(Collectors.toMap(Work::getId,e->e));
        List<Work> create = new ArrayList<>();
        List<Work> update = new ArrayList<>();
        list.forEach(sub->{
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	
   public Page<Work> fetchDefault(WorkSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Work> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Work> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Work> listDefault(WorkSearchContext context) {
        List<Work> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Work> fetchItemSetOwner(WorkSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Work> pages=baseMapper.searchItemSetOwner(context.getPages(),context,context.getSelectCond());
        List<Work> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Work> listItemSetOwner(WorkSearchContext context) {
        List<Work> list = baseMapper.listItemSetOwner(context,context.getSelectCond());
        return list;
   }
	
	public List<Work> findByPortfolioId(List<String> portfolioIds){
        List<Work> list = baseMapper.findByPortfolioId(portfolioIds);
        return list;	
	}

	public boolean removeByPortfolioId(String portfolioId){
        return this.remove(Wrappers.<Work>lambdaQuery().eq(Work::getPortfolioId,portfolioId));
	}

	public boolean resetByPortfolioId(String portfolioId){
		return this.update(Wrappers.<Work>lambdaUpdate().eq(Work::getPortfolioId,portfolioId));
	}
	public boolean saveByPortfolio(Portfolio portfolio, List<Work> list){
        if(list==null)
            return true;
        Map<String,Work> before = findByPortfolioId(portfolio.getId()).stream().collect(Collectors.toMap(Work::getId,e->e));

        List<Work> update = new ArrayList<>();
        List<Work> create = new ArrayList<>();

        for(Work sub:list) {
            sub.setPortfolioId(portfolio.getId());
            sub.setPortfolio(portfolio);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Work> findByPilotId(List<String> pilotIds){
        List<Work> list = baseMapper.findByPilotId(pilotIds);
        return list;	
	}

	public boolean removeByPilotId(String pilotId){
        return this.remove(Wrappers.<Work>lambdaQuery().eq(Work::getPilotId,pilotId));
	}

	public boolean resetByPilotId(String pilotId){
		return this.update(Wrappers.<Work>lambdaUpdate().eq(Work::getPilotId,pilotId));
	}
	public boolean saveByProject(Project project, List<Work> list){
        if(list==null)
            return true;
        Map<String,Work> before = findByPilotId(project.getId()).stream().collect(Collectors.toMap(Work::getId,e->e));

        List<Work> update = new ArrayList<>();
        List<Work> create = new ArrayList<>();

        for(Work sub:list) {
            sub.setPilotId(project.getId());
            sub.setProject(project);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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

    public void fillParentData(Work et) {
        if(Entities.PORTFOLIO.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPortfolioId((String)et.getContextParentKey());
        }
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPilotId((String)et.getContextParentKey());
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
        return WorkMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Work.class;
    }

}