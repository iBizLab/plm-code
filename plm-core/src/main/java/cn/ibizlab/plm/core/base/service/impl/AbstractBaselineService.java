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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.filter.BaselineSearchContext;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.base.mapper.BaselineMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.service.SpaceService;
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.prodmgmt.service.BaselineIdeaService;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.wiki.service.BaselinePageService;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.testmgmt.service.BaselineTestCaseService;
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.projmgmt.service.BaselineWorkItemService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[基线] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineService extends ServiceImpl<BaselineMapper,Baseline> implements BaselineService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected ProductService productService;

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected SpaceService spaceService;

    @Autowired
    @Lazy
    protected BaselineIdeaService baselineIdeaService;

    @Autowired
    @Lazy
    protected BaselinePageService baselinePageService;

    @Autowired
    @Lazy
    protected BaselineTestCaseService baselineTestCaseService;

    @Autowired
    @Lazy
    protected BaselineWorkItemService baselineWorkItemService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Baseline et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Baseline> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Baseline et) {
        UpdateWrapper<Baseline> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Baseline> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Baseline et) {
        if(!remove(Wrappers.<Baseline>lambdaQuery().eq(Baseline::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Baseline> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Baseline get(Baseline et) {
        Baseline rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BASELINE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Baseline> get(List<Baseline> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Baseline getDraft(Baseline et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Baseline et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Baseline>lambdaQuery().eq(Baseline::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Baseline et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Baseline> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Baseline> before = get(list).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> create = new ArrayList<>();
        List<Baseline> update = new ArrayList<>();
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
	
   public Page<Baseline> fetchDefault(BaselineSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Baseline> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Baseline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Baseline> listDefault(BaselineSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Baseline> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Baseline> fetchBaseline(BaselineSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Baseline> pages=baseMapper.searchBaseline(context.getPages(),context,context.getSelectCond());
        List<Baseline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Baseline> listBaseline(BaselineSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Baseline> list = baseMapper.listBaseline(context,context.getSelectCond());
        return list;
   }
	
   public Page<Baseline> fetchSnapshot(BaselineSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Baseline> pages=baseMapper.searchSnapshot(context.getPages(),context,context.getSelectCond());
        List<Baseline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Baseline> listSnapshot(BaselineSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Baseline> list = baseMapper.listSnapshot(context,context.getSelectCond());
        return list;
   }
	
	public List<Baseline> findByOwnerId(List<String> ownerIds){
        List<Baseline> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Baseline> findByLibrary(Library library){
        List<Baseline> list = this.baseMapper.selectList(Wrappers.<Baseline>lambdaQuery()
                        .eq(Baseline::getOwnerId, library.getId())
                        .eq(Baseline::getOwnerType,"LIBRARY")
                        .eq(Baseline::getOwnerSubtype,"LIBRARY"));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Baseline>lambdaQuery().eq(Baseline::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Baseline>lambdaUpdate().eq(Baseline::getOwnerId,ownerId));
	}
	public boolean saveByLibrary(Library library, List<Baseline> list){
        if(list==null)
            return true;

        Map<String,Baseline> before = findByLibrary(library).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> update = new ArrayList<>();
        List<Baseline> create = new ArrayList<>();

        for(Baseline sub:list) {
            sub.setOwnerId(library.getId());
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
	public List<Baseline> findByProduct(Product product){
        List<Baseline> list = this.baseMapper.selectList(Wrappers.<Baseline>lambdaQuery()
                        .eq(Baseline::getOwnerId, product.getId())
                        .eq(Baseline::getOwnerType,"PRODUCT")
                        .eq(Baseline::getOwnerSubtype,"PRODUCT"));
		return list;
	}
	public boolean saveByProduct(Product product, List<Baseline> list){
        if(list==null)
            return true;

        Map<String,Baseline> before = findByProduct(product).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> update = new ArrayList<>();
        List<Baseline> create = new ArrayList<>();

        for(Baseline sub:list) {
            sub.setOwnerId(product.getId());
            sub.setProduct(product);
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
	public List<Baseline> findByProject(Project project){
        List<Baseline> list = this.baseMapper.selectList(Wrappers.<Baseline>lambdaQuery()
                        .eq(Baseline::getOwnerId, project.getId())
                        .eq(Baseline::getOwnerType,"PROJECT")
                        .eq(Baseline::getOwnerSubtype,"PROJECT"));
		return list;
	}
	public boolean saveByProject(Project project, List<Baseline> list){
        if(list==null)
            return true;

        Map<String,Baseline> before = findByProject(project).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> update = new ArrayList<>();
        List<Baseline> create = new ArrayList<>();

        for(Baseline sub:list) {
            sub.setOwnerId(project.getId());
            sub.setProject(project);
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
	public List<Baseline> findBySpace(Space space){
        List<Baseline> list = this.baseMapper.selectList(Wrappers.<Baseline>lambdaQuery()
                        .eq(Baseline::getOwnerId, space.getId())
                        .eq(Baseline::getOwnerType,"SPACE")
                        .eq(Baseline::getOwnerSubtype,"SPACE"));
		return list;
	}
	public boolean saveBySpace(Space space, List<Baseline> list){
        if(list==null)
            return true;

        Map<String,Baseline> before = findBySpace(space).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> update = new ArrayList<>();
        List<Baseline> create = new ArrayList<>();

        for(Baseline sub:list) {
            sub.setOwnerId(space.getId());
            sub.setSpace(space);
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
   public Page<Baseline> fetchView(BaselineSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Baseline> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Baseline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Baseline> listView(BaselineSearchContext context) {
        List<Baseline> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Baseline et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.SPACE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return BaselineMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Baseline.class;
    }

}