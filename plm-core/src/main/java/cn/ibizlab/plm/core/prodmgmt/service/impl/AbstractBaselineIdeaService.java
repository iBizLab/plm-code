/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@MINHERIT}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service.impl;

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
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.prodmgmt.filter.BaselineIdeaSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.BaselineIdeaService;
import cn.ibizlab.plm.core.prodmgmt.mapper.BaselineIdeaMapper;
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
 * 实体[基线需求] 服务对象接口实现（常规多继承虚拟实体）
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineIdeaService extends ServiceImpl<BaselineIdeaMapper,BaselineIdea> implements BaselineIdeaService {

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
    protected cn.ibizlab.plm.core.prodmgmt.mapping.BaselineIdeaInheritMapping baselineIdeaInheritMapping;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(BaselineIdea et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
            relationService.create(baselineIdeaInheritMapping.toRelation(et));
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<BaselineIdea> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }
	
    @Transactional
    public boolean update(BaselineIdea et) {
        relationService.update(baselineIdeaInheritMapping.toRelation(et));
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<BaselineIdea> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }
	
   @Transactional
    public boolean remove(BaselineIdea et) {
        relationService.remove(baselineIdeaInheritMapping.toRelation(et));
        return true;
    }

    @Transactional
    public boolean remove(List<BaselineIdea> entities) {
       for (BaselineIdea et : entities)
            if(!getSelf().remove(et))
                return false;
       return true;
    }		
    public BaselineIdea get(BaselineIdea et) {
        BaselineIdea rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BASELINE_IDEA.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<BaselineIdea> get(List<BaselineIdea> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public BaselineIdea getDraft(BaselineIdea et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(BaselineIdea et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<BaselineIdea>lambdaQuery().eq(BaselineIdea::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED: CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(BaselineIdea et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<BaselineIdea> list) {
        list.forEach(et->getSelf().save(et));
        return true;
    }
	
   public Page<BaselineIdea> fetchDefault(BaselineIdeaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineIdea> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<BaselineIdea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineIdea> listDefault(BaselineIdeaSearchContext context) {
        List<BaselineIdea> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<BaselineIdea> fetchBaselineRelationVersion(BaselineIdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineIdea> pages=baseMapper.searchBaselineRelationVersion(context.getPages(),context,context.getSelectCond());
        List<BaselineIdea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineIdea> listBaselineRelationVersion(BaselineIdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<BaselineIdea> list = baseMapper.listBaselineRelationVersion(context,context.getSelectCond());
        return list;
   }
	
   public Page<BaselineIdea> fetchFillVersionData(BaselineIdeaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineIdea> pages=baseMapper.searchFillVersionData(context.getPages(),context,context.getSelectCond());
        List<BaselineIdea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineIdea> listFillVersionData(BaselineIdeaSearchContext context) {
        List<BaselineIdea> list = baseMapper.listFillVersionData(context,context.getSelectCond());
        return list;
   }
	
	public List<BaselineIdea> findByPrincipalId(List<String> principalIds){
        List<BaselineIdea> list = baseMapper.findByPrincipalId(principalIds);
        return list;	
	}
	
	public List<BaselineIdea> findByBaselinePrincipalIdea(Baseline baseline){
        List<BaselineIdea> list = findByPrincipalId(Arrays.asList(baseline.getId()));
		return list;
	}	

	public boolean removeByPrincipalId(String principalId){
        return this.remove(Wrappers.<BaselineIdea>lambdaQuery().eq(BaselineIdea::getPrincipalId,principalId));
	}

	public boolean resetByPrincipalId(String principalId){
		return this.update(Wrappers.<BaselineIdea>lambdaUpdate().eq(BaselineIdea::getPrincipalId,principalId));
	}
	public boolean saveByBaselinePrincipalIdea(Baseline baseline, List<BaselineIdea> list){
        if(list==null)
            return true;
        Map<String,BaselineIdea> before = findByPrincipalId(baseline.getId()).stream().collect(Collectors.toMap(BaselineIdea::getId,e->e));
        List<BaselineIdea> update = new ArrayList<>();
        List<BaselineIdea> create = new ArrayList<>();

        for(BaselineIdea sub:list) {
            sub.setPrincipalId(baseline.getId());
            sub.setBaselinePrincipalIdea(baseline);
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
	public List<BaselineIdea> findByTargetVersionId(List<String> targetVersionIds){
        List<BaselineIdea> list = baseMapper.findByTargetVersionId(targetVersionIds);
        return list;	
	}
	
	public List<BaselineIdea> findByTargetVersion(Version version){
        List<BaselineIdea> list = findByTargetVersionId(Arrays.asList(version.getId()));
		return list;
	}	

	public boolean removeByTargetVersionId(String targetVersionId){
        return this.remove(Wrappers.<BaselineIdea>lambdaQuery().eq(BaselineIdea::getTargetVersionId,targetVersionId));
	}

	public boolean resetByTargetVersionId(String targetVersionId){
		return this.update(Wrappers.<BaselineIdea>lambdaUpdate().eq(BaselineIdea::getTargetVersionId,targetVersionId));
	}
	public boolean saveByTargetVersion(Version version, List<BaselineIdea> list){
        if(list==null)
            return true;
        Map<String,BaselineIdea> before = findByTargetVersionId(version.getId()).stream().collect(Collectors.toMap(BaselineIdea::getId,e->e));
        List<BaselineIdea> update = new ArrayList<>();
        List<BaselineIdea> create = new ArrayList<>();

        for(BaselineIdea sub:list) {
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

    public void fillParentData(BaselineIdea et) {
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
        return BaselineIdeaMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return BaselineIdea.class;
    }
}