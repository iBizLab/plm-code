/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@MINHERIT}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service.impl;

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
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.testmgmt.filter.BaselineTestCaseSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.BaselineTestCaseService;
import cn.ibizlab.plm.core.testmgmt.mapper.BaselineTestCaseMapper;
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
 * 实体[基线用例] 服务对象接口实现（常规多继承虚拟实体）
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineTestCaseService extends ServiceImpl<BaselineTestCaseMapper,BaselineTestCase> implements BaselineTestCaseService {

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
    protected cn.ibizlab.plm.core.testmgmt.mapping.BaselineTestCaseInheritMapping baselineTestCaseInheritMapping;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(BaselineTestCase et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
            relationService.create(baselineTestCaseInheritMapping.toRelation(et));
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<BaselineTestCase> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }
	
    @Transactional
    public boolean update(BaselineTestCase et) {
        relationService.update(baselineTestCaseInheritMapping.toRelation(et));
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<BaselineTestCase> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }
	
   @Transactional
    public boolean remove(BaselineTestCase et) {
        relationService.remove(baselineTestCaseInheritMapping.toRelation(et));
        return true;
    }

    @Transactional
    public boolean remove(List<BaselineTestCase> entities) {
       for (BaselineTestCase et : entities)
            if(!getSelf().remove(et))
                return false;
       return true;
    }		
    public BaselineTestCase get(BaselineTestCase et) {
        BaselineTestCase rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BASELINE_TEST_CASE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<BaselineTestCase> get(List<BaselineTestCase> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public BaselineTestCase getDraft(BaselineTestCase et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(BaselineTestCase et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<BaselineTestCase>lambdaQuery().eq(BaselineTestCase::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED: CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(BaselineTestCase et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<BaselineTestCase> list) {
        list.forEach(et->getSelf().save(et));
        return true;
    }
	
   public Page<BaselineTestCase> fetchDefault(BaselineTestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineTestCase> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<BaselineTestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineTestCase> listDefault(BaselineTestCaseSearchContext context) {
        List<BaselineTestCase> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<BaselineTestCase> fetchBaselineRelationVersion(BaselineTestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineTestCase> pages=baseMapper.searchBaselineRelationVersion(context.getPages(),context,context.getSelectCond());
        List<BaselineTestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineTestCase> listBaselineRelationVersion(BaselineTestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<BaselineTestCase> list = baseMapper.listBaselineRelationVersion(context,context.getSelectCond());
        return list;
   }
	
   public Page<BaselineTestCase> fetchFillVersionData(BaselineTestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BaselineTestCase> pages=baseMapper.searchFillVersionData(context.getPages(),context,context.getSelectCond());
        List<BaselineTestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
   }

   public List<BaselineTestCase> listFillVersionData(BaselineTestCaseSearchContext context) {
        List<BaselineTestCase> list = baseMapper.listFillVersionData(context,context.getSelectCond());
        return list;
   }
	
	public List<BaselineTestCase> findByPrincipalId(List<String> principalIds){
        List<BaselineTestCase> list = baseMapper.findByPrincipalId(principalIds);
        return list;	
	}
	
	public List<BaselineTestCase> findByBaselinePrincipalTestCase(Baseline baseline){
        List<BaselineTestCase> list = findByPrincipalId(Arrays.asList(baseline.getId()));
		return list;
	}	

	public boolean removeByPrincipalId(String principalId){
        return this.remove(Wrappers.<BaselineTestCase>lambdaQuery().eq(BaselineTestCase::getPrincipalId,principalId));
	}

	public boolean resetByPrincipalId(String principalId){
		return this.update(Wrappers.<BaselineTestCase>lambdaUpdate().eq(BaselineTestCase::getPrincipalId,principalId));
	}
	public boolean saveByBaselinePrincipalTestCase(Baseline baseline, List<BaselineTestCase> list){
        if(list==null)
            return true;
        Map<String,BaselineTestCase> before = findByPrincipalId(baseline.getId()).stream().collect(Collectors.toMap(BaselineTestCase::getId,e->e));
        List<BaselineTestCase> update = new ArrayList<>();
        List<BaselineTestCase> create = new ArrayList<>();

        for(BaselineTestCase sub:list) {
            sub.setPrincipalId(baseline.getId());
            sub.setBaselinePrincipalTestCase(baseline);
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
	public List<BaselineTestCase> findByTargetVersionId(List<String> targetVersionIds){
        List<BaselineTestCase> list = baseMapper.findByTargetVersionId(targetVersionIds);
        return list;	
	}
	
	public List<BaselineTestCase> findByTargetVersion(Version version){
        List<BaselineTestCase> list = findByTargetVersionId(Arrays.asList(version.getId()));
		return list;
	}	

	public boolean removeByTargetVersionId(String targetVersionId){
        return this.remove(Wrappers.<BaselineTestCase>lambdaQuery().eq(BaselineTestCase::getTargetVersionId,targetVersionId));
	}

	public boolean resetByTargetVersionId(String targetVersionId){
		return this.update(Wrappers.<BaselineTestCase>lambdaUpdate().eq(BaselineTestCase::getTargetVersionId,targetVersionId));
	}
	public boolean saveByTargetVersion(Version version, List<BaselineTestCase> list){
        if(list==null)
            return true;
        Map<String,BaselineTestCase> before = findByTargetVersionId(version.getId()).stream().collect(Collectors.toMap(BaselineTestCase::getId,e->e));
        List<BaselineTestCase> update = new ArrayList<>();
        List<BaselineTestCase> create = new ArrayList<>();

        for(BaselineTestCase sub:list) {
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

    public void fillParentData(BaselineTestCase et) {
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
        return BaselineTestCaseMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return BaselineTestCase.class;
    }
}