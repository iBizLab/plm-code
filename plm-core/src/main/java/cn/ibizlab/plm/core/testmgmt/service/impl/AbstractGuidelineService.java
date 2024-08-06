/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
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
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.filter.GuidelineSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.GuidelineService;
import cn.ibizlab.plm.core.testmgmt.mapper.GuidelineMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewActionRule;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewRule;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewStage;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.testmgmt.service.ReviewWizardService;

/**
 * 实体[流程准则] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractGuidelineService extends ServiceImpl<GuidelineMapper,Guideline> implements GuidelineService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected ReviewService reviewService;

    @Autowired
    @Lazy
    protected ReviewWizardService reviewWizardService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Guideline et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Guideline> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Guideline et) {
        UpdateWrapper<Guideline> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Guideline> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Guideline et) {
        if(!remove(Wrappers.<Guideline>lambdaQuery().eq(Guideline::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Guideline> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Guideline get(Guideline et) {
        Guideline rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.GUIDELINE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Guideline> get(List<Guideline> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Guideline getDraft(Guideline et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Guideline et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Guideline>lambdaQuery().eq(Guideline::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Guideline et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Guideline> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Guideline> before = get(list).stream().collect(Collectors.toMap(Guideline::getId,e->e));
        List<Guideline> create = new ArrayList<>();
        List<Guideline> update = new ArrayList<>();
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
	
   public Page<Guideline> fetchDefault(GuidelineSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Guideline> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Guideline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Guideline> listDefault(GuidelineSearchContext context) {
        List<Guideline> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Guideline> fetchBase(GuidelineSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Guideline> pages=baseMapper.searchBase(context.getPages(),context,context.getSelectCond());
        List<Guideline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Guideline> listBase(GuidelineSearchContext context) {
        List<Guideline> list = baseMapper.listBase(context,context.getSelectCond());
        return list;
   }
	
   public Page<Guideline> fetchNormal(GuidelineSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Guideline> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Guideline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Guideline> listNormal(GuidelineSearchContext context) {
        List<Guideline> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<Guideline> fetchUnderLibrary(GuidelineSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Guideline> pages=baseMapper.searchUnderLibrary(context.getPages(),context,context.getSelectCond());
        List<Guideline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Guideline> listUnderLibrary(GuidelineSearchContext context) {
        List<Guideline> list = baseMapper.listUnderLibrary(context,context.getSelectCond());
        return list;
   }
	
	public List<Guideline> findByScopeId(List<String> scopeIds){
        List<Guideline> list = baseMapper.findByScopeId(scopeIds);
        return list;	
	}

	public List<Guideline> findByLibrary(Library library){
        List<Guideline> list = findByScopeId(Arrays.asList(library.getId()));
		return list;
	}
	public boolean removeByScopeId(String scopeId){
        return this.remove(Wrappers.<Guideline>lambdaQuery().eq(Guideline::getScopeId,scopeId));
	}

	public boolean resetByScopeId(String scopeId){
		return this.update(Wrappers.<Guideline>lambdaUpdate().eq(Guideline::getScopeId,scopeId));
	}
	public boolean saveByLibrary(Library library, List<Guideline> list){
        if(list==null)
            return true;

        Map<String,Guideline> before = findByLibrary(library).stream().collect(Collectors.toMap(Guideline::getId,e->e));
        List<Guideline> update = new ArrayList<>();
        List<Guideline> create = new ArrayList<>();

        for(Guideline sub:list) {
            sub.setScopeId(library.getId());
            sub.setLibrary(library);
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
   public Page<Guideline> fetchView(GuidelineSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Guideline> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Guideline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Guideline> listView(GuidelineSearchContext context) {
        List<Guideline> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Guideline et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setScopeId((String)et.getContextParentKey());
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
        return GuidelineMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Guideline.class;
    }

}