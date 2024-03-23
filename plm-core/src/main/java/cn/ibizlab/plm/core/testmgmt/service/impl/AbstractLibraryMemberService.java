/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service.impl;

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
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.testmgmt.filter.LibraryMemberSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.LibraryMemberService;
import cn.ibizlab.plm.core.testmgmt.mapper.LibraryMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 实体[测试库成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractLibraryMemberService extends ServiceImpl<LibraryMemberMapper,LibraryMember> implements LibraryMemberService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    protected int batchSize = 500;

    public LibraryMember get(LibraryMember et) {
        LibraryMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.LIBRARY_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<LibraryMember> getByEntities(List<LibraryMember> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(LibraryMember et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setLibraryId((String)et.getContextParentKey());
            Library library = et.getLibrary();
            if(library == null) {
                library = libraryService.getById(et.getLibraryId());
                et.setLibrary(library);
            }
            if(!ObjectUtils.isEmpty(library)) {
                et.setLibraryName(library.getName());
                et.setLibraryIdentifier(library.getIdentifier());
                et.setLibraryId(library.getId());
            }
        }
    }

    public LibraryMember getDraft(LibraryMember et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(LibraryMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<LibraryMember>lambdaQuery().eq(LibraryMember::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(LibraryMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<LibraryMember> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(LibraryMember et) {
        fillParentData(et);
        UpdateWrapper<LibraryMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<LibraryMember> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(LibraryMember et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<LibraryMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,LibraryMember> before = getByEntities(list).stream().collect(Collectors.toMap(LibraryMember::getId,e->e));
        List<LibraryMember> create = new ArrayList<>();
        List<LibraryMember> update = new ArrayList<>();
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
    public boolean remove(LibraryMember et) {
        if(!remove(Wrappers.<LibraryMember>lambdaQuery().eq(LibraryMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<LibraryMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<LibraryMember> searchCurLibraryMember(LibraryMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<LibraryMember> pages=baseMapper.searchCurLibraryMember(context.getPages(),context,context.getSelectCond());
        List<LibraryMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<LibraryMember> listCurLibraryMember(LibraryMemberSearchContext context) {
        List<LibraryMember> list = baseMapper.listCurLibraryMember(context,context.getSelectCond());
        return list;
    }

    public Page<LibraryMember> searchDefault(LibraryMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<LibraryMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<LibraryMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<LibraryMember> listDefault(LibraryMemberSearchContext context) {
        List<LibraryMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<LibraryMember> findByLibraryId(List<String> libraryIds) {
        List<LibraryMember> list = baseMapper.findByLibraryId(libraryIds);
        return list;
    }
    public List<LibraryMember> findByUserId(List<String> userIds) {
        List<LibraryMember> list = baseMapper.findByUserId(userIds);
        return list;
    }
    public boolean removeByLibraryId(String libraryId) {
        return this.remove(Wrappers.<LibraryMember>lambdaQuery().eq(LibraryMember::getLibraryId,libraryId));
    }

    public boolean resetByLibraryId(String libraryId) {
        return this.update(Wrappers.<LibraryMember>lambdaUpdate().eq(LibraryMember::getLibraryId,libraryId));
    }

    public boolean saveByLibrary(Library library,List<LibraryMember> list) {
        if(list==null)
            return true;
        Map<String,LibraryMember> before = findByLibraryId(library.getId()).stream().collect(Collectors.toMap(LibraryMember::getId,e->e));
        List<LibraryMember> update = new ArrayList<>();
        List<LibraryMember> create = new ArrayList<>();

        for(LibraryMember sub:list) {
            sub.setLibraryId(library.getId());
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByUserId(String userId) {
        return this.remove(Wrappers.<LibraryMember>lambdaQuery().eq(LibraryMember::getUserId,userId));
    }

    public boolean resetByUserId(String userId) {
        return this.update(Wrappers.<LibraryMember>lambdaUpdate().eq(LibraryMember::getUserId,userId));
    }

    public boolean saveByUser(User user,List<LibraryMember> list) {
        if(list==null)
            return true;
        Map<String,LibraryMember> before = findByUserId(user.getId()).stream().collect(Collectors.toMap(LibraryMember::getId,e->e));
        List<LibraryMember> update = new ArrayList<>();
        List<LibraryMember> create = new ArrayList<>();

        for(LibraryMember sub:list) {
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
        return LibraryMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return LibraryMember.class;
    }
}