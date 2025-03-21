/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
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
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.core.wiki.filter.StencilSearchContext;
import cn.ibizlab.plm.core.wiki.service.StencilService;
import cn.ibizlab.plm.core.wiki.mapper.StencilMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.service.SpaceService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;

/**
 * 实体[页面模板] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractStencilService extends ServiceImpl<StencilMapper,Stencil> implements StencilService {

    @Autowired
    @Lazy
    protected SpaceService spaceService;

    @Autowired
    @Lazy
    protected AttachmentService attachmentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Stencil et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attachmentService.saveByStencil(et,et.getAttachments());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Stencil> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Stencil et) {
        UpdateWrapper<Stencil> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attachmentService.saveByStencil(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Stencil> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Stencil et) {
        if(!remove(Wrappers.<Stencil>lambdaQuery().eq(Stencil::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Stencil> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Stencil get(Stencil et) {
        Stencil rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.STENCIL.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [附件]
        getAttachments(et);
        return et;
    }	

    public List<Stencil> get(List<Stencil> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Stencil getDraft(Stencil et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Stencil et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Stencil>lambdaQuery().eq(Stencil::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Stencil et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Stencil> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Stencil> before = get(list).stream().collect(Collectors.toMap(Stencil::getId,e->e));
        List<Stencil> create = new ArrayList<>();
        List<Stencil> update = new ArrayList<>();
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
	
   public Page<Stencil> fetchDefault(StencilSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stencil> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Stencil> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stencil> listDefault(StencilSearchContext context) {
        List<Stencil> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Stencil> fetchNoSpaceStencil(StencilSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stencil> pages=baseMapper.searchNoSpaceStencil(context.getPages(),context,context.getSelectCond());
        List<Stencil> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stencil> listNoSpaceStencil(StencilSearchContext context) {
        List<Stencil> list = baseMapper.listNoSpaceStencil(context,context.getSelectCond());
        return list;
   }
	
   public Page<Stencil> fetchReader(StencilSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stencil> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Stencil> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stencil> listReader(StencilSearchContext context) {
        List<Stencil> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<Stencil> fetchSpaceStencil(StencilSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stencil> pages=baseMapper.searchSpaceStencil(context.getPages(),context,context.getSelectCond());
        List<Stencil> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stencil> listSpaceStencil(StencilSearchContext context) {
        List<Stencil> list = baseMapper.listSpaceStencil(context,context.getSelectCond());
        return list;
   }
	
	public List<Stencil> findBySpaceId(List<String> spaceIds){
        List<Stencil> list = baseMapper.findBySpaceId(spaceIds);
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<Stencil> findBySpace(Space space){
        List<Stencil> list = findBySpaceId(Arrays.asList(space.getId()));
		return list;
	}
	public boolean removeBySpaceId(String spaceId){
        return this.remove(Wrappers.<Stencil>lambdaQuery().eq(Stencil::getSpaceId,spaceId));
	}

	public boolean resetBySpaceId(String spaceId){
		return this.update(Wrappers.<Stencil>lambdaUpdate().set(Stencil::getSpaceId, null).eq(Stencil::getSpaceId,spaceId));
	}
	public boolean saveBySpace(Space space, List<Stencil> list){
        if(list==null)
            return true;

        Map<String,Stencil> before = findBySpace(space).stream().collect(Collectors.toMap(Stencil::getId,e->e));
        List<Stencil> update = new ArrayList<>();
        List<Stencil> create = new ArrayList<>();

        for(Stencil sub:list) {
            sub.setSpaceId(space.getId());
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
	@Override
    public List<Attachment> getAttachments(Stencil et) {
        List<Attachment> list = attachmentService.findByStencil(et);
        et.setAttachments(list);
        return list;
    }
	
   public Page<Stencil> fetchView(StencilSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stencil> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Stencil> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stencil> listView(StencilSearchContext context) {
        List<Stencil> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Stencil et) {
        if(Entities.SPACE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSpaceId((String)et.getContextParentKey());
            Space space = et.getSpace();
            if(space == null) {
                space = spaceService.getById(et.getSpaceId());
                et.setSpace(space);
            }
            if(!ObjectUtils.isEmpty(space)) {
                et.setSpaceId(space.getId());
                et.setSpaceName(space.getName());
            }
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
        return StencilMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Stencil.class;
    }

}