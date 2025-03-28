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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseTemplateSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseTemplateService;
import cn.ibizlab.plm.core.testmgmt.mapper.TestCaseTemplateMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.service.TestSuiteService;
import cn.ibizlab.plm.core.testmgmt.domain.Step;

/**
 * 实体[用例模板] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTestCaseTemplateService extends ServiceImpl<TestCaseTemplateMapper,TestCaseTemplate> implements TestCaseTemplateService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected TestSuiteService testSuiteService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TestCaseTemplate et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<TestCaseTemplate> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(TestCaseTemplate et) {
        UpdateWrapper<TestCaseTemplate> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<TestCaseTemplate> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(TestCaseTemplate et) {
        if(!remove(Wrappers.<TestCaseTemplate>lambdaQuery().eq(TestCaseTemplate::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<TestCaseTemplate> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public TestCaseTemplate get(TestCaseTemplate et) {
        TestCaseTemplate rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.TEST_CASE_TEMPLATE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<TestCaseTemplate> get(List<TestCaseTemplate> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public TestCaseTemplate getDraft(TestCaseTemplate et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(TestCaseTemplate et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<TestCaseTemplate>lambdaQuery().eq(TestCaseTemplate::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(TestCaseTemplate et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<TestCaseTemplate> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,TestCaseTemplate> before = get(list).stream().collect(Collectors.toMap(TestCaseTemplate::getId,e->e));
        List<TestCaseTemplate> create = new ArrayList<>();
        List<TestCaseTemplate> update = new ArrayList<>();
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
	
   public Page<TestCaseTemplate> fetchDefault(TestCaseTemplateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCaseTemplate> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<TestCaseTemplate> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCaseTemplate> listDefault(TestCaseTemplateSearchContext context) {
        List<TestCaseTemplate> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<TestCaseTemplate> findByTestLibraryId(List<String> testLibraryIds){
        List<TestCaseTemplate> list = baseMapper.findByTestLibraryId(testLibraryIds);
        return list;	
	}

	public List<TestCaseTemplate> findByLibrary(Library library){
        List<TestCaseTemplate> list = findByTestLibraryId(Arrays.asList(library.getId()));
		return list;
	}
	public boolean removeByTestLibraryId(String testLibraryId){
        return this.remove(Wrappers.<TestCaseTemplate>lambdaQuery().eq(TestCaseTemplate::getTestLibraryId,testLibraryId));
	}

	public boolean resetByTestLibraryId(String testLibraryId){
		return this.update(Wrappers.<TestCaseTemplate>lambdaUpdate().set(TestCaseTemplate::getTestLibraryId, null).eq(TestCaseTemplate::getTestLibraryId,testLibraryId));
	}
	public boolean saveByLibrary(Library library, List<TestCaseTemplate> list){
        if(list==null)
            return true;

        Map<String,TestCaseTemplate> before = findByLibrary(library).stream().collect(Collectors.toMap(TestCaseTemplate::getId,e->e));
        List<TestCaseTemplate> update = new ArrayList<>();
        List<TestCaseTemplate> create = new ArrayList<>();

        for(TestCaseTemplate sub:list) {
            sub.setTestLibraryId(library.getId());
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<TestCaseTemplate> findBySuiteId(List<String> suiteIds){
        List<TestCaseTemplate> list = baseMapper.findBySuiteId(suiteIds);
        return list;	
	}

	public List<TestCaseTemplate> findByTestSuite(TestSuite testSuite){
        List<TestCaseTemplate> list = findBySuiteId(Arrays.asList(testSuite.getId()));
		return list;
	}
	public boolean removeBySuiteId(String suiteId){
        return this.remove(Wrappers.<TestCaseTemplate>lambdaQuery().eq(TestCaseTemplate::getSuiteId,suiteId));
	}

	public boolean resetBySuiteId(String suiteId){
		return this.update(Wrappers.<TestCaseTemplate>lambdaUpdate().set(TestCaseTemplate::getSuiteId, null).eq(TestCaseTemplate::getSuiteId,suiteId));
	}
	public boolean saveByTestSuite(TestSuite testSuite, List<TestCaseTemplate> list){
        if(list==null)
            return true;

        Map<String,TestCaseTemplate> before = findByTestSuite(testSuite).stream().collect(Collectors.toMap(TestCaseTemplate::getId,e->e));
        List<TestCaseTemplate> update = new ArrayList<>();
        List<TestCaseTemplate> create = new ArrayList<>();

        for(TestCaseTemplate sub:list) {
            sub.setSuiteId(testSuite.getId());
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
   public Page<TestCaseTemplate> fetchView(TestCaseTemplateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCaseTemplate> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<TestCaseTemplate> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCaseTemplate> listView(TestCaseTemplateSearchContext context) {
        List<TestCaseTemplate> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(TestCaseTemplate et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTestLibraryId((String)et.getContextParentKey());
            Library library = et.getLibrary();
            if(library == null) {
                library = libraryService.getById(et.getTestLibraryId());
                et.setLibrary(library);
            }
            if(!ObjectUtils.isEmpty(library)) {
                et.setTestLibraryId(library.getId());
                et.setTestLibraryName(library.getName());
            }
        }
        if(Entities.TEST_SUITE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSuiteId((String)et.getContextParentKey());
            TestSuite testSuite = et.getTestSuite();
            if(testSuite == null) {
                testSuite = testSuiteService.getById(et.getSuiteId());
                et.setTestSuite(testSuite);
            }
            if(!ObjectUtils.isEmpty(testSuite)) {
                et.setSuites(testSuite.getSuites());
                et.setSuiteId(testSuite.getId());
                et.setSuiteName(testSuite.getName());
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
        return TestCaseTemplateMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return TestCaseTemplate.class;
    }

}