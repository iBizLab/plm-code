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
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.filter.AddonSearchContext;
import cn.ibizlab.plm.core.base.service.AddonService;
import cn.ibizlab.plm.core.base.mapper.AddonMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.service.PortfolioService;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.service.SpaceService;
import cn.ibizlab.plm.core.base.domain.AddonRoleMember;
import cn.ibizlab.plm.core.base.service.AddonRoleMemberService;

/**
 * 实体[组件] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAddonService extends ServiceImpl<AddonMapper,Addon> implements AddonService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected PortfolioService portfolioService;

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
    protected AddonRoleMemberService addonRoleMemberService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Addon et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        addonRoleMemberService.saveByAddon(et,et.getAddonRoleMembers());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Addon> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Addon et) {
        UpdateWrapper<Addon> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        addonRoleMemberService.saveByAddon(et,et.getAddonRoleMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Addon> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Addon et) {
        if(!remove(Wrappers.<Addon>lambdaQuery().eq(Addon::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Addon> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Addon get(Addon et) {
        Addon rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ADDON.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [组件权限成员]
        getAddonRoleMembers(et);
        return et;
    }	

    public List<Addon> get(List<Addon> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Addon getDraft(Addon et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Addon et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Addon>lambdaQuery().eq(Addon::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Addon et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Addon> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Addon> before = get(list).stream().collect(Collectors.toMap(Addon::getId,e->e));
        List<Addon> create = new ArrayList<>();
        List<Addon> update = new ArrayList<>();
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
	
   public Page<Addon> fetchDefault(AddonSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("ORDER_VALUE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Addon> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Addon> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Addon> listDefault(AddonSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("ORDER_VALUE,ASC");
        List<Addon> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Addon> fetchCurOwnerSys(AddonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Addon> pages=baseMapper.searchCurOwnerSys(context.getPages(),context,context.getSelectCond());
        List<Addon> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Addon> listCurOwnerSys(AddonSearchContext context) {
        List<Addon> list = baseMapper.listCurOwnerSys(context,context.getSelectCond());
        return list;
   }
	
   public Page<Addon> fetchPsmodelSync(AddonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Addon> pages=baseMapper.searchPsmodelSync(context.getPages(),context,context.getSelectCond());
        List<Addon> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Addon> listPsmodelSync(AddonSearchContext context) {
        List<Addon> list = baseMapper.listPsmodelSync(context,context.getSelectCond());
        return list;
   }
	
	public List<Addon> findByOwnerId(List<String> ownerIds){
        List<Addon> list = baseMapper.findByOwnerId(ownerIds);
        if(!ObjectUtils.isEmpty(list))
            addonRoleMemberService.findByAddonId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getAddonId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAddonRoleMembers(sub.getValue())));
        return list;	
	}

	public List<Addon> findByLibrary(Library library){
        List<Addon> list = findByOwnerId(Arrays.asList(library.getId()));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Addon>lambdaQuery().eq(Addon::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Addon>lambdaUpdate().set(Addon::getOwnerId, null).eq(Addon::getOwnerId,ownerId));
	}
	public boolean saveByLibrary(Library library, List<Addon> list){
        if(list==null)
            return true;

        Map<String,Addon> before = findByLibrary(library).stream().collect(Collectors.toMap(Addon::getId,e->e));
        List<Addon> update = new ArrayList<>();
        List<Addon> create = new ArrayList<>();

        for(Addon sub:list) {
            sub.setOwnerId(library.getId());
            sub.setLibrary(library);
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
	public List<Addon> findByPortfolio(Portfolio portfolio){
        List<Addon> list = findByOwnerId(Arrays.asList(portfolio.getId()));
		return list;
	}
	public boolean saveByPortfolio(Portfolio portfolio, List<Addon> list){
        if(list==null)
            return true;

        Map<String,Addon> before = findByPortfolio(portfolio).stream().collect(Collectors.toMap(Addon::getId,e->e));
        List<Addon> update = new ArrayList<>();
        List<Addon> create = new ArrayList<>();

        for(Addon sub:list) {
            sub.setOwnerId(portfolio.getId());
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
	public List<Addon> findByProduct(Product product){
        List<Addon> list = findByOwnerId(Arrays.asList(product.getId()));
		return list;
	}
	public boolean saveByProduct(Product product, List<Addon> list){
        if(list==null)
            return true;

        Map<String,Addon> before = findByProduct(product).stream().collect(Collectors.toMap(Addon::getId,e->e));
        List<Addon> update = new ArrayList<>();
        List<Addon> create = new ArrayList<>();

        for(Addon sub:list) {
            sub.setOwnerId(product.getId());
            sub.setProduct(product);
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
	public List<Addon> findByProject(Project project){
        List<Addon> list = findByOwnerId(Arrays.asList(project.getId()));
		return list;
	}
	public boolean saveByProject(Project project, List<Addon> list){
        if(list==null)
            return true;

        Map<String,Addon> before = findByProject(project).stream().collect(Collectors.toMap(Addon::getId,e->e));
        List<Addon> update = new ArrayList<>();
        List<Addon> create = new ArrayList<>();

        for(Addon sub:list) {
            sub.setOwnerId(project.getId());
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
	public List<Addon> findBySpace(Space space){
        List<Addon> list = findByOwnerId(Arrays.asList(space.getId()));
		return list;
	}
	public boolean saveBySpace(Space space, List<Addon> list){
        if(list==null)
            return true;

        Map<String,Addon> before = findBySpace(space).stream().collect(Collectors.toMap(Addon::getId,e->e));
        List<Addon> update = new ArrayList<>();
        List<Addon> create = new ArrayList<>();

        for(Addon sub:list) {
            sub.setOwnerId(space.getId());
            sub.setSpace(space);
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
	@Override
    public List<AddonRoleMember> getAddonRoleMembers(Addon et) {
        List<AddonRoleMember> list = addonRoleMemberService.findByAddon(et);
        et.setAddonRoleMembers(list);
        return list;
    }
	
   public Page<Addon> fetchView(AddonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Addon> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Addon> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Addon> listView(AddonSearchContext context) {
        List<Addon> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Addon et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.PORTFOLIO.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return AddonMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Addon.class;
    }

}