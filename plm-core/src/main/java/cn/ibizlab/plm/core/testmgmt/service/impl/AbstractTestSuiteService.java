/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service.impl;

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
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.filter.TestSuiteSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.TestSuiteService;
import cn.ibizlab.plm.core.testmgmt.mapper.TestSuiteMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;

/**
 * 实体[用例模块] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTestSuiteService extends ServiceImpl<TestSuiteMapper,TestSuite> implements TestSuiteService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    @Autowired
    @Lazy
    protected TestSuiteService testSuiteService;

    protected int batchSize = 500;

    public TestSuite get(TestSuite et) {
        TestSuite rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.TEST_SUITE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<TestSuite> getByEntities(List<TestSuite> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(TestSuite et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setLibraryId((String)et.getContextParentKey());
            Library library = et.getLibrary();
            if(library == null) {
                library = libraryService.getById(et.getLibraryId());
                et.setLibrary(library);
            }
            if(!ObjectUtils.isEmpty(library)) {
                et.setLibraryId(library.getId());
                et.setLibraryName(library.getName());
            }
        }
        if(Entities.TEST_SUITE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPid((String)et.getContextParentKey());
            TestSuite testSuite = et.getTestSuite();
            if(testSuite == null) {
                testSuite = testSuiteService.getById(et.getPid());
                et.setTestSuite(testSuite);
            }
            if(!ObjectUtils.isEmpty(testSuite)) {
                et.setPid(testSuite.getId());
                et.setPname(testSuite.getName());
            }
        }
    }

    public TestSuite getDraft(TestSuite et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(TestSuite et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<TestSuite>lambdaQuery().eq(TestSuite::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(TestSuite et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<TestSuite> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(TestSuite et) {
        UpdateWrapper<TestSuite> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<TestSuite> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(TestSuite et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<TestSuite> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,TestSuite> before = getByEntities(list).stream().collect(Collectors.toMap(TestSuite::getId,e->e));
        List<TestSuite> create = new ArrayList<>();
        List<TestSuite> update = new ArrayList<>();
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
    public boolean remove(TestSuite et) {
        String key = et.getId();
        testCaseService.resetBySuiteId(key);
        if(!remove(Wrappers.<TestSuite>lambdaQuery().eq(TestSuite::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<TestSuite> entities) {
        for (TestSuite et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }

    public Page<TestSuite> searchDefault(TestSuiteSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestSuite> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<TestSuite> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<TestSuite> listDefault(TestSuiteSearchContext context) {
        List<TestSuite> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<TestSuite> searchNoParent(TestSuiteSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestSuite> pages=baseMapper.searchNoParent(context.getPages(),context,context.getSelectCond());
        List<TestSuite> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<TestSuite> listNoParent(TestSuiteSearchContext context) {
        List<TestSuite> list = baseMapper.listNoParent(context,context.getSelectCond());
        return list;
    }

    public Page<TestSuite> searchNormal(TestSuiteSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestSuite> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<TestSuite> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<TestSuite> listNormal(TestSuiteSearchContext context) {
        List<TestSuite> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
    }

    public Page<TestSuite> searchRoot(TestSuiteSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestSuite> pages=baseMapper.searchRoot(context.getPages(),context,context.getSelectCond());
        List<TestSuite> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<TestSuite> listRoot(TestSuiteSearchContext context) {
        List<TestSuite> list = baseMapper.listRoot(context,context.getSelectCond());
        return list;
    }

    public List<TestSuite> findByLibraryId(List<String> libraryIds) {
        List<TestSuite> list = baseMapper.findByLibraryId(libraryIds);
        return list;
    }
    public List<TestSuite> findByPid(List<String> pids) {
        List<TestSuite> list = baseMapper.findByPid(pids);
        return list;
    }
    public boolean removeByLibraryId(String libraryId) {
        List<String> ids = baseMapper.findByLibraryId(Arrays.asList(libraryId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.removeBatch(ids);
        else
            return true;
    }

    public boolean resetByLibraryId(String libraryId) {
        return this.update(Wrappers.<TestSuite>lambdaUpdate().eq(TestSuite::getLibraryId,libraryId));
    }

    public boolean saveByLibrary(Library library,List<TestSuite> list) {
        if(list==null)
            return true;
        Map<String,TestSuite> before = findByLibraryId(library.getId()).stream().collect(Collectors.toMap(TestSuite::getId,e->e));
        List<TestSuite> update = new ArrayList<>();
        List<TestSuite> create = new ArrayList<>();

        for(TestSuite sub:list) {
            sub.setLibraryId(library.getId());
            sub.setLibrary(library);
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

    public boolean removeByPid(String pid) {
        List<String> ids = baseMapper.findByPid(Arrays.asList(pid)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.removeBatch(ids);
        else
            return true;
    }

    public boolean resetByPid(String pid) {
        return this.update(Wrappers.<TestSuite>lambdaUpdate().eq(TestSuite::getPid,pid));
    }

    public boolean saveByTestSuite(TestSuite testSuite,List<TestSuite> list) {
        if(list==null)
            return true;
        Map<String,TestSuite> before = findByPid(testSuite.getId()).stream().collect(Collectors.toMap(TestSuite::getId,e->e));
        List<TestSuite> update = new ArrayList<>();
        List<TestSuite> create = new ArrayList<>();

        for(TestSuite sub:list) {
            sub.setPid(testSuite.getId());
            sub.setTestSuite(testSuite);
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
        return TestSuiteMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return TestSuite.class;
    }
}