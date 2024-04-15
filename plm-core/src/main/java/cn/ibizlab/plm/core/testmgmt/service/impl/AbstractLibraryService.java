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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.filter.LibrarySearchContext;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.testmgmt.mapper.LibraryMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.testmgmt.service.LibraryMemberService;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseTemplateService;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.service.TestSuiteService;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import cn.ibizlab.plm.core.base.service.ReferencesIndexService;

/**
 * 实体[测试库] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractLibraryService extends ServiceImpl<LibraryMapper,Library> implements LibraryService {

    @Autowired
    @Lazy
    protected LibraryMemberService libraryMemberService;

    @Autowired
    @Lazy
    protected ReviewService reviewService;

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    @Autowired
    @Lazy
    protected TestCaseTemplateService testCaseTemplateService;

    @Autowired
    @Lazy
    protected TestPlanService testPlanService;

    @Autowired
    @Lazy
    protected TestSuiteService testSuiteService;

    @Autowired
    @Lazy
    protected ReferencesIndexService referencesIndexService;

    @Autowired
    @Lazy
    protected cn.ibizlab.plm.core.testmgmt.mapping.LibraryInheritMapping libraryInheritMapping;

    protected int batchSize = 500;

    public Library get(Library et) {
        Library rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.LIBRARY.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [测试库成员]
        getMembers(et);
        return et;
    }

    public List<Library> getByEntities(List<Library> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public Library getDraft(Library et) {
        return et;
    }

    public Integer checkKey(Library et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Library>lambdaQuery().eq(Library::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Library et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        libraryMemberService.saveByLibrary(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Library> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }

    @Transactional
    public boolean update(Library et) {
        UpdateWrapper<Library> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        libraryMemberService.saveByLibrary(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Library> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }

    @Override
    @Transactional
    public boolean save(Library et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Library> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Library> before = getByEntities(list).stream().collect(Collectors.toMap(Library::getId,e->e));
        List<Library> create = new ArrayList<>();
        List<Library> update = new ArrayList<>();
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
    public boolean remove(Library et) {
        if(!remove(Wrappers.<Library>lambdaQuery().eq(Library::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Library> entities) {
        for (Library et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }

    public Page<Library> searchDefault(LibrarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listDefault(LibrarySearchContext context) {
        List<Library> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Library> searchAdmin(LibrarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listAdmin(LibrarySearchContext context) {
        List<Library> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
    }

    public Page<Library> searchArchived(LibrarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listArchived(LibrarySearchContext context) {
        List<Library> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
    }

    public Page<Library> searchDeleted(LibrarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listDeleted(LibrarySearchContext context) {
        List<Library> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
    }

    public Page<Library> searchFavorite(LibrarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchFavorite(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listFavorite(LibrarySearchContext context) {
        List<Library> list = baseMapper.listFavorite(context,context.getSelectCond());
        return list;
    }

    public Page<Library> searchNormal(LibrarySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("NAME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listNormal(LibrarySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("NAME,DESC");
        List<Library> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
    }

    public Page<Library> searchProjectRelationLibrary(LibrarySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("NAME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchProjectRelationLibrary(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listProjectRelationLibrary(LibrarySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("NAME,DESC");
        List<Library> list = baseMapper.listProjectRelationLibrary(context,context.getSelectCond());
        return list;
    }

    public Page<Library> searchReader(LibrarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listReader(LibrarySearchContext context) {
        List<Library> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
    }

    public Page<Library> searchUser(LibrarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Library> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<Library> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Library> listUser(LibrarySearchContext context) {
        List<Library> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
    }

    @Override
    public List<LibraryMember> getMembers(Library et) {
        List<LibraryMember> list = libraryMemberService.findByLibraryId(et.getId());
        et.setMembers(list);
        return list;
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
        return LibraryMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Library.class;
    }
}