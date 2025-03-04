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
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.filter.FavoriteSearchContext;
import cn.ibizlab.plm.core.base.service.FavoriteService;
import cn.ibizlab.plm.core.base.mapper.FavoriteMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;

/**
 * 实体[收藏] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractFavoriteService extends ServiceImpl<FavoriteMapper,Favorite> implements FavoriteService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected ProductService productService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Favorite et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Favorite> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Favorite et) {
        UpdateWrapper<Favorite> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Favorite> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Favorite et) {
        if(!remove(Wrappers.<Favorite>lambdaQuery().eq(Favorite::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Favorite> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Favorite get(Favorite et) {
        Favorite rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.FAVORITE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Favorite> get(List<Favorite> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Favorite getDraft(Favorite et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Favorite et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Favorite>lambdaQuery().eq(Favorite::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Favorite et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Favorite> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Favorite> before = get(list).stream().collect(Collectors.toMap(Favorite::getId,e->e));
        List<Favorite> create = new ArrayList<>();
        List<Favorite> update = new ArrayList<>();
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
	
   public Page<Favorite> fetchDefault(FavoriteSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Favorite> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Favorite> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Favorite> listDefault(FavoriteSearchContext context) {
        List<Favorite> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Favorite> fetchMyFavorite(FavoriteSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Favorite> pages=baseMapper.searchMyFavorite(context.getPages(),context,context.getSelectCond());
        List<Favorite> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Favorite> listMyFavorite(FavoriteSearchContext context) {
        List<Favorite> list = baseMapper.listMyFavorite(context,context.getSelectCond());
        return list;
   }
	
	public List<Favorite> findByOwnerId(List<String> ownerIds){
        List<Favorite> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Favorite> findByProject(Project project){
        List<Favorite> list = this.baseMapper.selectList(Wrappers.<Favorite>lambdaQuery()
                        .eq(Favorite::getOwnerId, project.getId())
                        .eq(Favorite::getOwnerType,"PROJECT")
                        .eq(Favorite::getOwnerSubtype,"project"));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Favorite>lambdaQuery().eq(Favorite::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Favorite>lambdaUpdate().set(Favorite::getOwnerId, null).eq(Favorite::getOwnerId,ownerId));
	}
	public boolean saveByProject(Project project, List<Favorite> list){
        if(list==null)
            return true;

        Map<String,Favorite> before = findByProject(project).stream().collect(Collectors.toMap(Favorite::getId,e->e));
        List<Favorite> update = new ArrayList<>();
        List<Favorite> create = new ArrayList<>();

        for(Favorite sub:list) {
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
	public List<Favorite> findByProduct(Product product){
        List<Favorite> list = this.baseMapper.selectList(Wrappers.<Favorite>lambdaQuery()
                        .eq(Favorite::getOwnerId, product.getId())
                        .eq(Favorite::getOwnerType,"PRODUCT").isNull(Favorite::getOwnerSubtype));
		return list;
	}
	public boolean saveByProduct(Product product, List<Favorite> list){
        if(list==null)
            return true;

        Map<String,Favorite> before = findByProduct(product).stream().collect(Collectors.toMap(Favorite::getId,e->e));
        List<Favorite> update = new ArrayList<>();
        List<Favorite> create = new ArrayList<>();

        for(Favorite sub:list) {
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
   public Page<Favorite> fetchView(FavoriteSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Favorite> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Favorite> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Favorite> listView(FavoriteSearchContext context) {
        List<Favorite> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Favorite et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return FavoriteMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Favorite.class;
    }

}