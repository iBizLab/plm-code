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
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.filter.MemberSearchContext;
import cn.ibizlab.plm.core.base.service.MemberService;
import cn.ibizlab.plm.core.base.mapper.MemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Group;

/**
 * 实体[成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractMemberService extends ServiceImpl<MemberMapper,Member> implements MemberService {

    protected int batchSize = 500;

    public Member get(Member et) {
        Member rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Member> getByEntities(List<Member> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Member et) {
    }

    public Member getDraft(Member et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Member et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Member>lambdaQuery().eq(Member::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Member et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Member> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Member et) {
        fillParentData(et);
        UpdateWrapper<Member> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Member> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Member et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Member> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Member> before = getByEntities(list).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> create = new ArrayList<>();
        List<Member> update = new ArrayList<>();
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Member et) {
        if(!remove(Wrappers.<Member>lambdaQuery().eq(Member::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Member> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Member> searchDefault(MemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Member> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Member> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Member> listDefault(MemberSearchContext context) {
        List<Member> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<Member> findByUserId(List<String> userIds) {
        List<Member> list = baseMapper.findByUserId(userIds);
        return list;
    }
    public List<Member> findByOwnerId(List<String> ownerIds) {
        List<Member> list = baseMapper.findByOwnerId(ownerIds);
        return list;
    }
    public boolean removeByUserId(String userId) {
        return this.remove(Wrappers.<Member>lambdaQuery().eq(Member::getUserId,userId));
    }

    public boolean resetByUserId(String userId) {
        return this.update(Wrappers.<Member>lambdaUpdate().eq(Member::getUserId,userId));
    }

    public boolean saveByUser(User user,List<Member> list) {
        if(list==null)
            return true;
        Map<String,Member> before = findByUserId(user.getId()).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> update = new ArrayList<>();
        List<Member> create = new ArrayList<>();

        for(Member sub:list) {
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByOwnerId(String ownerId) {
        return this.remove(Wrappers.<Member>lambdaQuery().eq(Member::getOwnerId,ownerId));
    }

    public boolean resetByOwnerId(String ownerId) {
        return this.update(Wrappers.<Member>lambdaUpdate().eq(Member::getOwnerId,ownerId));
    }

    public boolean saveByGroup(Group group,List<Member> list) {
        if(list==null)
            return true;
        Map<String,Member> before = findByOwnerId(group.getId()).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> update = new ArrayList<>();
        List<Member> create = new ArrayList<>();

        for(Member sub:list) {
            sub.setOwnerId(group.getId());
            sub.setGroup(group);
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
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
        return MemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Member.class;
    }
}