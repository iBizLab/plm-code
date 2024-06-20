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
import cn.ibizlab.plm.core.base.domain.AddonResource;
import cn.ibizlab.plm.core.base.filter.AddonResourceSearchContext;
import cn.ibizlab.plm.core.base.service.AddonResourceService;
import cn.ibizlab.plm.core.base.mapper.AddonResourceMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.base.domain.ResourceMember;

/**
 * 实体[资源组件] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAddonResourceService extends ServiceImpl<AddonResourceMapper,AddonResource> implements AddonResourceService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(AddonResource et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<AddonResource> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(AddonResource et) {
        UpdateWrapper<AddonResource> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<AddonResource> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(AddonResource et) {
        if(!remove(Wrappers.<AddonResource>lambdaQuery().eq(AddonResource::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<AddonResource> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public AddonResource get(AddonResource et) {
        AddonResource rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ADDON_RESOURCE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<AddonResource> get(List<AddonResource> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public AddonResource getDraft(AddonResource et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(AddonResource et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<AddonResource>lambdaQuery().eq(AddonResource::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(AddonResource et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<AddonResource> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,AddonResource> before = get(list).stream().collect(Collectors.toMap(AddonResource::getId,e->e));
        List<AddonResource> create = new ArrayList<>();
        List<AddonResource> update = new ArrayList<>();
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
	
   public Page<AddonResource> fetchDefault(AddonResourceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AddonResource> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<AddonResource> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AddonResource> listDefault(AddonResourceSearchContext context) {
        List<AddonResource> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<AddonResource> fetchAll(AddonResourceSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AddonResource> pages=baseMapper.searchAll(context.getPages(),context,context.getSelectCond());
        List<AddonResource> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AddonResource> listAll(AddonResourceSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,ASC");
        List<AddonResource> list = baseMapper.listAll(context,context.getSelectCond());
        return list;
   }
	
	public List<AddonResource> findByOwnerId(List<String> ownerIds){
        List<AddonResource> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<AddonResource>lambdaQuery().eq(AddonResource::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<AddonResource>lambdaUpdate().eq(AddonResource::getOwnerId,ownerId));
	}
	public boolean saveByProject(Project project, List<AddonResource> list){
        if(list==null)
            return true;
        Map<String,AddonResource> before = findByOwnerId(project.getId()).stream().collect(Collectors.toMap(AddonResource::getId,e->e));

        List<AddonResource> update = new ArrayList<>();
        List<AddonResource> create = new ArrayList<>();

        for(AddonResource sub:list) {
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

    public void fillParentData(AddonResource et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return AddonResourceMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return AddonResource.class;
    }

}