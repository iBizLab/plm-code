/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.base.domain.Group;
import cn.ibizlab.plm.core.base.filter.GroupSearchContext;
import cn.ibizlab.plm.core.base.service.GroupService;
import cn.ibizlab.plm.core.base.mapper.GroupMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.service.SectionService;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.service.MemberService;

/**
 * 实体[团队] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractGroupService extends ServiceImpl<GroupMapper,Group> implements GroupService {

    @Autowired
    @Lazy
    protected SectionService sectionService;

    @Autowired
    @Lazy
    protected MemberService memberService;

    protected int batchSize = 500;

    public Group get(Group et) {
        Group rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.GROUP.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Group> getByEntities(List<Group> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Group et) {
        if(Entities.SECTION.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSectionId((String)et.getContextParentKey());
            Section section = et.getSection();
            if(section == null) {
                section = sectionService.getById(et.getSectionId());
                et.setSection(section);
            }
            if(!ObjectUtils.isEmpty(section)) {
                et.setSectionId(section.getId());
                et.setSectionName(section.getName());
            }
        }
    }

    public Group getDraft(Group et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Group et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Group>lambdaQuery().eq(Group::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Group et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Group> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Group et) {
        UpdateWrapper<Group> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Group> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Group et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Group> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Group> before = getByEntities(list).stream().collect(Collectors.toMap(Group::getId,e->e));
        List<Group> create = new ArrayList<>();
        List<Group> update = new ArrayList<>();
        list.forEach(sub->{
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
    public boolean remove(Group et) {
        if(!remove(Wrappers.<Group>lambdaQuery().eq(Group::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Group> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Group> searchDefault(GroupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Group> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Group> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Group> listDefault(GroupSearchContext context) {
        List<Group> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Group> searchNoSection(GroupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Group> pages=baseMapper.searchNoSection(context.getPages(),context,context.getSelectCond());
        List<Group> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Group> listNoSection(GroupSearchContext context) {
        List<Group> list = baseMapper.listNoSection(context,context.getSelectCond());
        return list;
    }

    public Page<Group> searchUserGroupAdmin(GroupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Group> pages=baseMapper.searchUserGroupAdmin(context.getPages(),context,context.getSelectCond());
        List<Group> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Group> listUserGroupAdmin(GroupSearchContext context) {
        List<Group> list = baseMapper.listUserGroupAdmin(context,context.getSelectCond());
        return list;
    }

    public List<Group> findBySectionId(List<String> sectionIds) {
        List<Group> list = baseMapper.findBySectionId(sectionIds);
        return list;
    }
    public boolean removeBySectionId(String sectionId) {
        return this.remove(Wrappers.<Group>lambdaQuery().eq(Group::getSectionId,sectionId));
    }

    public boolean resetBySectionId(String sectionId) {
        return this.update(Wrappers.<Group>lambdaUpdate().eq(Group::getSectionId,sectionId));
    }

    public boolean saveBySection(Section section,List<Group> list) {
        if(list==null)
            return true;
        Map<String,Group> before = findBySectionId(section.getId()).stream().collect(Collectors.toMap(Group::getId,e->e));
        List<Group> update = new ArrayList<>();
        List<Group> create = new ArrayList<>();

        for(Group sub:list) {
            sub.setSectionId(section.getId());
            sub.setSection(section);
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
        return GroupMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Group.class;
    }
}