/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.insight.service.impl;

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
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.core.insight.filter.InsightMemberSearchContext;
import cn.ibizlab.plm.core.insight.service.InsightMemberService;
import cn.ibizlab.plm.core.insight.mapper.InsightMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.insight.service.InsightViewService;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 实体[效能成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightMemberService extends ServiceImpl<InsightMemberMapper,InsightMember> implements InsightMemberService {

    @Autowired
    @Lazy
    protected InsightViewService insightViewService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(InsightMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<InsightMember> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(InsightMember et) {
        fillParentData(et);
        UpdateWrapper<InsightMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<InsightMember> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(InsightMember et) {
        if(!remove(Wrappers.<InsightMember>lambdaQuery().eq(InsightMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<InsightMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public InsightMember get(InsightMember et) {
        InsightMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.INSIGHT_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<InsightMember> get(List<InsightMember> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public InsightMember getDraft(InsightMember et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(InsightMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<InsightMember>lambdaQuery().eq(InsightMember::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(InsightMember et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<InsightMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,InsightMember> before = get(list).stream().collect(Collectors.toMap(InsightMember::getId,e->e));
        List<InsightMember> create = new ArrayList<>();
        List<InsightMember> update = new ArrayList<>();
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
	
   public Page<InsightMember> fetchDefault(InsightMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<InsightMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightMember> listDefault(InsightMemberSearchContext context) {
        List<InsightMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<InsightMember> findByOwnerId(List<String> ownerIds){
        List<InsightMember> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<InsightMember> findByInsightView(InsightView insightView){
        List<InsightMember> list = findByOwnerId(Arrays.asList(insightView.getId()));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<InsightMember>lambdaQuery().eq(InsightMember::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<InsightMember>lambdaUpdate().eq(InsightMember::getOwnerId,ownerId));
	}
	public boolean saveByInsightView(InsightView insightView, List<InsightMember> list){
        if(list==null)
            return true;

        Map<String,InsightMember> before = findByInsightView(insightView).stream().collect(Collectors.toMap(InsightMember::getId,e->e));
        List<InsightMember> update = new ArrayList<>();
        List<InsightMember> create = new ArrayList<>();

        for(InsightMember sub:list) {
            sub.setOwnerId(insightView.getId());
            sub.setInsightView(insightView);
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
	public List<InsightMember> findByUserId(List<String> userIds){
        List<InsightMember> list = baseMapper.findByUserId(userIds);
        return list;	
	}

	public List<InsightMember> findByUser(User user){
        List<InsightMember> list = findByUserId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByUserId(String userId){
        return this.remove(Wrappers.<InsightMember>lambdaQuery().eq(InsightMember::getUserId,userId));
	}

	public boolean resetByUserId(String userId){
		return this.update(Wrappers.<InsightMember>lambdaUpdate().eq(InsightMember::getUserId,userId));
	}
	public boolean saveByUser(User user, List<InsightMember> list){
        if(list==null)
            return true;

        Map<String,InsightMember> before = findByUser(user).stream().collect(Collectors.toMap(InsightMember::getId,e->e));
        List<InsightMember> update = new ArrayList<>();
        List<InsightMember> create = new ArrayList<>();

        for(InsightMember sub:list) {
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
   public Page<InsightMember> fetchView(InsightMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<InsightMember> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<InsightMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<InsightMember> listView(InsightMemberSearchContext context) {
        List<InsightMember> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(InsightMember et) {
        if(Entities.INSIGHT_VIEW.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
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
        return InsightMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return InsightMember.class;
    }

}