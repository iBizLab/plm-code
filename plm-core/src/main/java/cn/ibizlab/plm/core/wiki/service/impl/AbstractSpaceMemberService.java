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
import cn.ibizlab.plm.core.wiki.domain.SpaceMember;
import cn.ibizlab.plm.core.wiki.filter.SpaceMemberSearchContext;
import cn.ibizlab.plm.core.wiki.service.SpaceMemberService;
import cn.ibizlab.plm.core.wiki.mapper.SpaceMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.service.SpaceService;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 实体[空间成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSpaceMemberService extends ServiceImpl<SpaceMemberMapper,SpaceMember> implements SpaceMemberService {

    @Autowired
    @Lazy
    protected SpaceService spaceService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SpaceMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<SpaceMember> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(SpaceMember et) {
        fillParentData(et);
        UpdateWrapper<SpaceMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<SpaceMember> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(SpaceMember et) {
        if(!remove(Wrappers.<SpaceMember>lambdaQuery().eq(SpaceMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<SpaceMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public SpaceMember get(SpaceMember et) {
        SpaceMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SPACE_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<SpaceMember> get(List<SpaceMember> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public SpaceMember getDraft(SpaceMember et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(SpaceMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<SpaceMember>lambdaQuery().eq(SpaceMember::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(SpaceMember et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<SpaceMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SpaceMember> before = get(list).stream().collect(Collectors.toMap(SpaceMember::getId,e->e));
        List<SpaceMember> create = new ArrayList<>();
        List<SpaceMember> update = new ArrayList<>();
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
	
   public Page<SpaceMember> fetchDefault(SpaceMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SpaceMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<SpaceMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SpaceMember> listDefault(SpaceMemberSearchContext context) {
        List<SpaceMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<SpaceMember> fetchCurSpace(SpaceMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SpaceMember> pages=baseMapper.searchCurSpace(context.getPages(),context,context.getSelectCond());
        List<SpaceMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SpaceMember> listCurSpace(SpaceMemberSearchContext context) {
        List<SpaceMember> list = baseMapper.listCurSpace(context,context.getSelectCond());
        return list;
   }
	
	public List<SpaceMember> findBySpaceId(List<String> spaceIds){
        List<SpaceMember> list = baseMapper.findBySpaceId(spaceIds);
        return list;	
	}

	public List<SpaceMember> findBySpace(Space space){
        List<SpaceMember> list = findBySpaceId(Arrays.asList(space.getId()));
		return list;
	}
	public boolean removeBySpaceId(String spaceId){
        return this.remove(Wrappers.<SpaceMember>lambdaQuery().eq(SpaceMember::getSpaceId,spaceId));
	}

	public boolean resetBySpaceId(String spaceId){
		return this.update(Wrappers.<SpaceMember>lambdaUpdate().eq(SpaceMember::getSpaceId,spaceId));
	}
	public boolean saveBySpace(Space space, List<SpaceMember> list){
        if(list==null)
            return true;

        Map<String,SpaceMember> before = findBySpace(space).stream().collect(Collectors.toMap(SpaceMember::getId,e->e));
        List<SpaceMember> update = new ArrayList<>();
        List<SpaceMember> create = new ArrayList<>();

        for(SpaceMember sub:list) {
            sub.setSpaceId(space.getId());
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
	public List<SpaceMember> findByUserId(List<String> userIds){
        List<SpaceMember> list = baseMapper.findByUserId(userIds);
        return list;	
	}

	public List<SpaceMember> findByUser(User user){
        List<SpaceMember> list = findByUserId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByUserId(String userId){
        return this.remove(Wrappers.<SpaceMember>lambdaQuery().eq(SpaceMember::getUserId,userId));
	}

	public boolean resetByUserId(String userId){
		return this.update(Wrappers.<SpaceMember>lambdaUpdate().eq(SpaceMember::getUserId,userId));
	}
	public boolean saveByUser(User user, List<SpaceMember> list){
        if(list==null)
            return true;

        Map<String,SpaceMember> before = findByUser(user).stream().collect(Collectors.toMap(SpaceMember::getId,e->e));
        List<SpaceMember> update = new ArrayList<>();
        List<SpaceMember> create = new ArrayList<>();

        for(SpaceMember sub:list) {
            sub.setUserId(user.getId());
            sub.setUser(user);
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
   public Page<SpaceMember> fetchView(SpaceMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SpaceMember> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<SpaceMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SpaceMember> listView(SpaceMemberSearchContext context) {
        List<SpaceMember> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(SpaceMember et) {
        if(Entities.SPACE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSpaceId((String)et.getContextParentKey());
            Space space = et.getSpace();
            if(space == null) {
                space = spaceService.getById(et.getSpaceId());
                et.setSpace(space);
            }
            if(!ObjectUtils.isEmpty(space)) {
                et.setSpaceIdentifier(space.getIdentifier());
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
        return SpaceMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return SpaceMember.class;
    }

}