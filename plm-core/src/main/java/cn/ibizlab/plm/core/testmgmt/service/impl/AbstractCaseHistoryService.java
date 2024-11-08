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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.testmgmt.domain.CaseHistory;
import cn.ibizlab.plm.core.testmgmt.filter.CaseHistorySearchContext;
import cn.ibizlab.plm.core.testmgmt.service.CaseHistoryService;
import cn.ibizlab.plm.core.testmgmt.mapper.CaseHistoryMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;

/**
 * 实体[用例执行历史] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractCaseHistoryService extends ServiceImpl<CaseHistoryMapper,CaseHistory> implements CaseHistoryService {

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(CaseHistory et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<CaseHistory> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(CaseHistory et) {
        UpdateWrapper<CaseHistory> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<CaseHistory> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(CaseHistory et) {
        if(!remove(Wrappers.<CaseHistory>lambdaQuery().eq(CaseHistory::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<CaseHistory> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public CaseHistory get(CaseHistory et) {
        CaseHistory rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.CASE_HISTORY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<CaseHistory> get(List<CaseHistory> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public CaseHistory getDraft(CaseHistory et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(CaseHistory et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<CaseHistory>lambdaQuery().eq(CaseHistory::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(CaseHistory et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<CaseHistory> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,CaseHistory> before = get(list).stream().collect(Collectors.toMap(CaseHistory::getId,e->e));
        List<CaseHistory> create = new ArrayList<>();
        List<CaseHistory> update = new ArrayList<>();
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
	
   public Page<CaseHistory> fetchDefault(CaseHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<CaseHistory> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<CaseHistory> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<CaseHistory> listDefault(CaseHistorySearchContext context) {
        List<CaseHistory> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<CaseHistory> findByCaseId(List<String> caseIds){
        List<CaseHistory> list = baseMapper.findByCaseId(caseIds);
        return list;	
	}

	public List<CaseHistory> findByTestCase(TestCase testCase){
        List<CaseHistory> list = findByCaseId(Arrays.asList(testCase.getId()));
		return list;
	}
	public boolean removeByCaseId(String caseId){
        return this.remove(Wrappers.<CaseHistory>lambdaQuery().eq(CaseHistory::getCaseId,caseId));
	}

	public boolean resetByCaseId(String caseId){
		return this.update(Wrappers.<CaseHistory>lambdaUpdate().set(CaseHistory::getCaseId, null).eq(CaseHistory::getCaseId,caseId));
	}
	public boolean saveByTestCase(TestCase testCase, List<CaseHistory> list){
        if(list==null)
            return true;

        Map<String,CaseHistory> before = findByTestCase(testCase).stream().collect(Collectors.toMap(CaseHistory::getId,e->e));
        List<CaseHistory> update = new ArrayList<>();
        List<CaseHistory> create = new ArrayList<>();

        for(CaseHistory sub:list) {
            sub.setCaseId(testCase.getId());
            sub.setTestCase(testCase);
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
   public Page<CaseHistory> fetchView(CaseHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<CaseHistory> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<CaseHistory> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<CaseHistory> listView(CaseHistorySearchContext context) {
        List<CaseHistory> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(CaseHistory et) {
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setCaseId((String)et.getContextParentKey());
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
        return CaseHistoryMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return CaseHistory.class;
    }

}