/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@MINHERIT}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service.impl;

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
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.projmgmt.filter.BaselineWorkItemSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.BaselineWorkItemService;
import cn.ibizlab.plm.core.projmgmt.mapper.BaselineWorkItemMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.service.VersionService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[基线工作项] 服务对象接口实现（常规多继承虚拟实体）
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineWorkItemService extends ServiceImpl<BaselineWorkItemMapper,BaselineWorkItem> implements BaselineWorkItemService {

    @Autowired
    @Lazy
    protected BaselineService baselineService;

    @Autowired
    @Lazy
    protected VersionService versionService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    @Autowired
    @Lazy
    protected cn.ibizlab.plm.core.projmgmt.mapping.BaselineWorkItemInheritMapping baselineWorkItemInheritMapping;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(BaselineWorkItem et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
            relationService.create(baselineWorkItemInheritMapping.toRelation(et));
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<BaselineWorkItem> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }
	
    @Transactional
    public boolean update(BaselineWorkItem et) {
        relationService.update(baselineWorkItemInheritMapping.toRelation(et));
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<BaselineWorkItem> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }
	
   @Transactional
    public boolean remove(BaselineWorkItem et) {
        relationService.remove(baselineWorkItemInheritMapping.toRelation(et));
        return true;
    }

    @Transactional
    public boolean remove(List<BaselineWorkItem> entities) {
       for (BaselineWorkItem et : entities)
            if(!getSelf().remove(et))
                return false;
       return true;
    }		
    public BaselineWorkItem get(BaselineWorkItem et) {
        BaselineWorkItem rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BASELINE_WORK_ITEM.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<BaselineWorkItem> get(List<BaselineWorkItem> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public BaselineWorkItem getDraft(BaselineWorkItem et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(BaselineWorkItem et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<BaselineWorkItem>lambdaQuery().eq(BaselineWorkItem::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED: CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(BaselineWorkItem et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<BaselineWorkItem> list) {
        list.forEach(et->getSelf().save(et));
        return true;
    }
	
   public Page<BaselineWorkItem> fetchDefault(BaselineWorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineWorkItem> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<BaselineWorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineWorkItem> listDefault(BaselineWorkItemSearchContext context) {
        List<BaselineWorkItem> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<BaselineWorkItem> fetchBaselineRelationVersion(BaselineWorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineWorkItem> pages=baseMapper.searchBaselineRelationVersion(context.getPages(),context,context.getSelectCond());
        List<BaselineWorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineWorkItem> listBaselineRelationVersion(BaselineWorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<BaselineWorkItem> list = baseMapper.listBaselineRelationVersion(context,context.getSelectCond());
        return list;
   }
	
   public Page<BaselineWorkItem> fetchFillVersionData(BaselineWorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineWorkItem> pages=baseMapper.searchFillVersionData(context.getPages(),context,context.getSelectCond());
        List<BaselineWorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineWorkItem> listFillVersionData(BaselineWorkItemSearchContext context) {
        List<BaselineWorkItem> list = baseMapper.listFillVersionData(context,context.getSelectCond());
        return list;
   }
	
	public List<BaselineWorkItem> findByPrincipalId(List<String> principalIds){
        List<BaselineWorkItem> list = baseMapper.findByPrincipalId(principalIds);
        return list;	
	}
	
	public List<BaselineWorkItem> findByPrincipalBaseline(Baseline baseline){
        List<BaselineWorkItem> list = findByPrincipalId(Arrays.asList(baseline.getId()));
		return list;
	}	

	public boolean removeByPrincipalId(String principalId){
        return this.remove(Wrappers.<BaselineWorkItem>lambdaQuery().eq(BaselineWorkItem::getPrincipalId,principalId));
	}

	public boolean resetByPrincipalId(String principalId){
		return this.update(Wrappers.<BaselineWorkItem>lambdaUpdate().eq(BaselineWorkItem::getPrincipalId,principalId));
	}
	public boolean saveByPrincipalBaseline(Baseline baseline, List<BaselineWorkItem> list){
        if(list==null)
            return true;
        Map<String,BaselineWorkItem> before = findByPrincipalId(baseline.getId()).stream().collect(Collectors.toMap(BaselineWorkItem::getId,e->e));
        List<BaselineWorkItem> update = new ArrayList<>();
        List<BaselineWorkItem> create = new ArrayList<>();

        for(BaselineWorkItem sub:list) {
            sub.setPrincipalId(baseline.getId());
            sub.setPrincipalBaseline(baseline);
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
	public List<BaselineWorkItem> findByTargetVersionId(List<String> targetVersionIds){
        List<BaselineWorkItem> list = baseMapper.findByTargetVersionId(targetVersionIds);
        return list;	
	}
	
	public List<BaselineWorkItem> findByTargetVersion(Version version){
        List<BaselineWorkItem> list = findByTargetVersionId(Arrays.asList(version.getId()));
		return list;
	}	

	public boolean removeByTargetVersionId(String targetVersionId){
        return this.remove(Wrappers.<BaselineWorkItem>lambdaQuery().eq(BaselineWorkItem::getTargetVersionId,targetVersionId));
	}

	public boolean resetByTargetVersionId(String targetVersionId){
		return this.update(Wrappers.<BaselineWorkItem>lambdaUpdate().eq(BaselineWorkItem::getTargetVersionId,targetVersionId));
	}
	public boolean saveByTargetVersion(Version version, List<BaselineWorkItem> list){
        if(list==null)
            return true;
        Map<String,BaselineWorkItem> before = findByTargetVersionId(version.getId()).stream().collect(Collectors.toMap(BaselineWorkItem::getId,e->e));
        List<BaselineWorkItem> update = new ArrayList<>();
        List<BaselineWorkItem> create = new ArrayList<>();

        for(BaselineWorkItem sub:list) {
            sub.setTargetVersionId(version.getId());
            sub.setTargetVersion(version);
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

    public void fillParentData(BaselineWorkItem et) {
        if(Entities.BASELINE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.VERSION.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetVersionId((String)et.getContextParentKey());
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
        return BaselineWorkItemMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return BaselineWorkItem.class;
    }
}