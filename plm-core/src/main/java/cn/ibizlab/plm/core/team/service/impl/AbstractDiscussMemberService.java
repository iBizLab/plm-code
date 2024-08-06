/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service.impl;

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
import cn.ibizlab.plm.core.team.domain.DiscussMember;
import cn.ibizlab.plm.core.team.filter.DiscussMemberSearchContext;
import cn.ibizlab.plm.core.team.service.DiscussMemberService;
import cn.ibizlab.plm.core.team.mapper.DiscussMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.team.service.DiscussTopicService;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 实体[协作成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDiscussMemberService extends ServiceImpl<DiscussMemberMapper,DiscussMember> implements DiscussMemberService {

    @Autowired
    @Lazy
    protected DiscussTopicService discussTopicService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DiscussMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<DiscussMember> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(DiscussMember et) {
        fillParentData(et);
        UpdateWrapper<DiscussMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<DiscussMember> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(DiscussMember et) {
        if(!remove(Wrappers.<DiscussMember>lambdaQuery().eq(DiscussMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<DiscussMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public DiscussMember get(DiscussMember et) {
        DiscussMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DISCUSS_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<DiscussMember> get(List<DiscussMember> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public DiscussMember getDraft(DiscussMember et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(DiscussMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<DiscussMember>lambdaQuery().eq(DiscussMember::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(DiscussMember et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<DiscussMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,DiscussMember> before = get(list).stream().collect(Collectors.toMap(DiscussMember::getId,e->e));
        List<DiscussMember> create = new ArrayList<>();
        List<DiscussMember> update = new ArrayList<>();
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
	
   public Page<DiscussMember> fetchDefault(DiscussMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<DiscussMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussMember> listDefault(DiscussMemberSearchContext context) {
        List<DiscussMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<DiscussMember> findByOwnerId(List<String> ownerIds){
        List<DiscussMember> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<DiscussMember> findByDiscussTopic(DiscussTopic discussTopic){
        List<DiscussMember> list = findByOwnerId(Arrays.asList(discussTopic.getId()));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<DiscussMember>lambdaQuery().eq(DiscussMember::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<DiscussMember>lambdaUpdate().eq(DiscussMember::getOwnerId,ownerId));
	}
	public boolean saveByDiscussTopic(DiscussTopic discussTopic, List<DiscussMember> list){
        if(list==null)
            return true;

        Map<String,DiscussMember> before = findByDiscussTopic(discussTopic).stream().collect(Collectors.toMap(DiscussMember::getId,e->e));
        List<DiscussMember> update = new ArrayList<>();
        List<DiscussMember> create = new ArrayList<>();

        for(DiscussMember sub:list) {
            sub.setOwnerId(discussTopic.getId());
            sub.setDiscussTopic(discussTopic);
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
	public List<DiscussMember> findByUserId(List<String> userIds){
        List<DiscussMember> list = baseMapper.findByUserId(userIds);
        return list;	
	}

	public List<DiscussMember> findByUser(User user){
        List<DiscussMember> list = findByUserId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByUserId(String userId){
        return this.remove(Wrappers.<DiscussMember>lambdaQuery().eq(DiscussMember::getUserId,userId));
	}

	public boolean resetByUserId(String userId){
		return this.update(Wrappers.<DiscussMember>lambdaUpdate().eq(DiscussMember::getUserId,userId));
	}
	public boolean saveByUser(User user, List<DiscussMember> list){
        if(list==null)
            return true;

        Map<String,DiscussMember> before = findByUser(user).stream().collect(Collectors.toMap(DiscussMember::getId,e->e));
        List<DiscussMember> update = new ArrayList<>();
        List<DiscussMember> create = new ArrayList<>();

        for(DiscussMember sub:list) {
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
   public Page<DiscussMember> fetchView(DiscussMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussMember> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<DiscussMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussMember> listView(DiscussMemberSearchContext context) {
        List<DiscussMember> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(DiscussMember et) {
        if(Entities.DISCUSS_TOPIC.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return DiscussMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return DiscussMember.class;
    }

}