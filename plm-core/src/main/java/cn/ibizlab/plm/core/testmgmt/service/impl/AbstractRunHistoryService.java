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
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.filter.RunHistorySearchContext;
import cn.ibizlab.plm.core.testmgmt.service.RunHistoryService;
import cn.ibizlab.plm.core.testmgmt.mapper.RunHistoryMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.service.RunService;
import cn.ibizlab.plm.core.testmgmt.domain.Step;

/**
 * 实体[执行结果] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRunHistoryService extends ServiceImpl<RunHistoryMapper,RunHistory> implements RunHistoryService {

    @Autowired
    @Lazy
    protected RunService runService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(RunHistory et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<RunHistory> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(RunHistory et) {
        UpdateWrapper<RunHistory> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<RunHistory> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(RunHistory et) {
        if(!remove(Wrappers.<RunHistory>lambdaQuery().eq(RunHistory::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<RunHistory> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public RunHistory get(RunHistory et) {
        RunHistory rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.RUN_HISTORY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<RunHistory> get(List<RunHistory> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public RunHistory getDraft(RunHistory et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(RunHistory et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<RunHistory>lambdaQuery().eq(RunHistory::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(RunHistory et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<RunHistory> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,RunHistory> before = get(list).stream().collect(Collectors.toMap(RunHistory::getId,e->e));
        List<RunHistory> create = new ArrayList<>();
        List<RunHistory> update = new ArrayList<>();
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
	
   public Page<RunHistory> fetchDefault(RunHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<RunHistory> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<RunHistory> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<RunHistory> listDefault(RunHistorySearchContext context) {
        List<RunHistory> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<RunHistory> fetchThis(RunHistorySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<RunHistory> pages=baseMapper.searchThis(context.getPages(),context,context.getSelectCond());
        List<RunHistory> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<RunHistory> listThis(RunHistorySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<RunHistory> list = baseMapper.listThis(context,context.getSelectCond());
        return list;
   }
	
	public List<RunHistory> findByRunId(List<String> runIds){
        List<RunHistory> list = baseMapper.findByRunId(runIds);
        return list;	
	}

	public boolean removeByRunId(String runId){
        return this.remove(Wrappers.<RunHistory>lambdaQuery().eq(RunHistory::getRunId,runId));
	}

	public boolean resetByRunId(String runId){
		return this.update(Wrappers.<RunHistory>lambdaUpdate().eq(RunHistory::getRunId,runId));
	}
	public boolean saveByRun(Run run, List<RunHistory> list){
        if(list==null)
            return true;
        Map<String,RunHistory> before = findByRunId(run.getId()).stream().collect(Collectors.toMap(RunHistory::getId,e->e));

        List<RunHistory> update = new ArrayList<>();
        List<RunHistory> create = new ArrayList<>();

        for(RunHistory sub:list) {
            sub.setRunId(run.getId());
            sub.setRun(run);
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

    public void fillParentData(RunHistory et) {
        if(Entities.RUN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setRunId((String)et.getContextParentKey());
            Run run = et.getRun();
            if(run == null) {
                run = runService.getById(et.getRunId());
                et.setRun(run);
            }
            if(!ObjectUtils.isEmpty(run)) {
                et.setCaseId(run.getCaseId());
                et.setRunId(run.getId());
                et.setRunTitle(run.getTitle());
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
        return RunHistoryMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return RunHistory.class;
    }

}