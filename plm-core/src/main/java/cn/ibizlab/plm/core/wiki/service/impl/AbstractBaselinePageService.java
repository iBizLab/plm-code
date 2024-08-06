/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@MINHERIT}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service.impl;

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
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.wiki.filter.BaselinePageSearchContext;
import cn.ibizlab.plm.core.wiki.service.BaselinePageService;
import cn.ibizlab.plm.core.wiki.mapper.BaselinePageMapper;
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
 * 实体[基线页面] 服务对象接口实现（常规多继承虚拟实体）
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselinePageService extends ServiceImpl<BaselinePageMapper,BaselinePage> implements BaselinePageService {

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
    protected cn.ibizlab.plm.core.wiki.mapping.BaselinePageInheritMapping baselinePageInheritMapping;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(BaselinePage et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
            relationService.create(baselinePageInheritMapping.toRelation(et));
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<BaselinePage> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }
	
    @Transactional
    public boolean update(BaselinePage et) {
        relationService.update(baselinePageInheritMapping.toRelation(et));
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<BaselinePage> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }
	
   @Transactional
    public boolean remove(BaselinePage et) {
        relationService.remove(baselinePageInheritMapping.toRelation(et));
        return true;
    }

    @Transactional
    public boolean remove(List<BaselinePage> entities) {
       for (BaselinePage et : entities)
            if(!getSelf().remove(et))
                return false;
       return true;
    }		
    public BaselinePage get(BaselinePage et) {
        BaselinePage rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BASELINE_PAGE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<BaselinePage> get(List<BaselinePage> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public BaselinePage getDraft(BaselinePage et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(BaselinePage et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<BaselinePage>lambdaQuery().eq(BaselinePage::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED: CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(BaselinePage et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<BaselinePage> list) {
        list.forEach(et->getSelf().save(et));
        return true;
    }
	
   public Page<BaselinePage> fetchDefault(BaselinePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselinePage> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<BaselinePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselinePage> listDefault(BaselinePageSearchContext context) {
        List<BaselinePage> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<BaselinePage> fetchFillVersionData(BaselinePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselinePage> pages=baseMapper.searchFillVersionData(context.getPages(),context,context.getSelectCond());
        List<BaselinePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselinePage> listFillVersionData(BaselinePageSearchContext context) {
        List<BaselinePage> list = baseMapper.listFillVersionData(context,context.getSelectCond());
        return list;
   }
	
	public List<BaselinePage> findByPrincipalId(List<String> principalIds){
        List<BaselinePage> list = baseMapper.findByPrincipalId(principalIds);
        return list;	
	}
	
	public List<BaselinePage> findByBaselinePrincipalPage(Baseline baseline){
        List<BaselinePage> list = findByPrincipalId(Arrays.asList(baseline.getId()));
		return list;
	}	

	public boolean removeByPrincipalId(String principalId){
        return this.remove(Wrappers.<BaselinePage>lambdaQuery().eq(BaselinePage::getPrincipalId,principalId));
	}

	public boolean resetByPrincipalId(String principalId){
		return this.update(Wrappers.<BaselinePage>lambdaUpdate().eq(BaselinePage::getPrincipalId,principalId));
	}
	public boolean saveByBaselinePrincipalPage(Baseline baseline, List<BaselinePage> list){
        if(list==null)
            return true;
        Map<String,BaselinePage> before = findByPrincipalId(baseline.getId()).stream().collect(Collectors.toMap(BaselinePage::getId,e->e));
        List<BaselinePage> update = new ArrayList<>();
        List<BaselinePage> create = new ArrayList<>();

        for(BaselinePage sub:list) {
            sub.setPrincipalId(baseline.getId());
            sub.setBaselinePrincipalPage(baseline);
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
	public List<BaselinePage> findByTargetVersionId(List<String> targetVersionIds){
        List<BaselinePage> list = baseMapper.findByTargetVersionId(targetVersionIds);
        return list;	
	}
	
	public List<BaselinePage> findByTargetVersion(Version version){
        List<BaselinePage> list = findByTargetVersionId(Arrays.asList(version.getId()));
		return list;
	}	

	public boolean removeByTargetVersionId(String targetVersionId){
        return this.remove(Wrappers.<BaselinePage>lambdaQuery().eq(BaselinePage::getTargetVersionId,targetVersionId));
	}

	public boolean resetByTargetVersionId(String targetVersionId){
		return this.update(Wrappers.<BaselinePage>lambdaUpdate().eq(BaselinePage::getTargetVersionId,targetVersionId));
	}
	public boolean saveByTargetVersion(Version version, List<BaselinePage> list){
        if(list==null)
            return true;
        Map<String,BaselinePage> before = findByTargetVersionId(version.getId()).stream().collect(Collectors.toMap(BaselinePage::getId,e->e));
        List<BaselinePage> update = new ArrayList<>();
        List<BaselinePage> create = new ArrayList<>();

        for(BaselinePage sub:list) {
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

    public void fillParentData(BaselinePage et) {
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
        return BaselinePageMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return BaselinePage.class;
    }
}