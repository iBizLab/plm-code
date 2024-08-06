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
import cn.ibizlab.plm.core.team.domain.UpdateRecord;
import cn.ibizlab.plm.core.team.filter.UpdateRecordSearchContext;
import cn.ibizlab.plm.core.team.service.UpdateRecordService;
import cn.ibizlab.plm.core.team.mapper.UpdateRecordMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.team.domain.KeyResult;
import cn.ibizlab.plm.core.team.service.KeyResultService;
import cn.ibizlab.plm.core.team.domain.Objective;
import cn.ibizlab.plm.core.team.service.ObjectiveService;

/**
 * 实体[进展] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractUpdateRecordService extends ServiceImpl<UpdateRecordMapper,UpdateRecord> implements UpdateRecordService {

    @Autowired
    @Lazy
    protected KeyResultService keyResultService;

    @Autowired
    @Lazy
    protected ObjectiveService objectiveService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(UpdateRecord et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<UpdateRecord> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(UpdateRecord et) {
        UpdateWrapper<UpdateRecord> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<UpdateRecord> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(UpdateRecord et) {
        if(!remove(Wrappers.<UpdateRecord>lambdaQuery().eq(UpdateRecord::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<UpdateRecord> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public UpdateRecord get(UpdateRecord et) {
        UpdateRecord rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.UPDATE_RECORD.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<UpdateRecord> get(List<UpdateRecord> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public UpdateRecord getDraft(UpdateRecord et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(UpdateRecord et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<UpdateRecord>lambdaQuery().eq(UpdateRecord::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(UpdateRecord et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<UpdateRecord> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,UpdateRecord> before = get(list).stream().collect(Collectors.toMap(UpdateRecord::getId,e->e));
        List<UpdateRecord> create = new ArrayList<>();
        List<UpdateRecord> update = new ArrayList<>();
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
	
   public Page<UpdateRecord> fetchDefault(UpdateRecordSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UpdateRecord> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<UpdateRecord> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<UpdateRecord> listDefault(UpdateRecordSearchContext context) {
        List<UpdateRecord> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<UpdateRecord> findByKeyResultId(List<String> keyResultIds){
        List<UpdateRecord> list = baseMapper.findByKeyResultId(keyResultIds);
        return list;	
	}

	public List<UpdateRecord> findByKeyResult(KeyResult keyResult){
        List<UpdateRecord> list = findByKeyResultId(Arrays.asList(keyResult.getId()));
		return list;
	}
	public boolean removeByKeyResultId(String keyResultId){
        return this.remove(Wrappers.<UpdateRecord>lambdaQuery().eq(UpdateRecord::getKeyResultId,keyResultId));
	}

	public boolean resetByKeyResultId(String keyResultId){
		return this.update(Wrappers.<UpdateRecord>lambdaUpdate().eq(UpdateRecord::getKeyResultId,keyResultId));
	}
	public boolean saveByKeyResult(KeyResult keyResult, List<UpdateRecord> list){
        if(list==null)
            return true;

        Map<String,UpdateRecord> before = findByKeyResult(keyResult).stream().collect(Collectors.toMap(UpdateRecord::getId,e->e));
        List<UpdateRecord> update = new ArrayList<>();
        List<UpdateRecord> create = new ArrayList<>();

        for(UpdateRecord sub:list) {
            sub.setKeyResultId(keyResult.getId());
            sub.setKeyResult(keyResult);
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
	public List<UpdateRecord> findByObjectiveId(List<String> objectiveIds){
        List<UpdateRecord> list = baseMapper.findByObjectiveId(objectiveIds);
        return list;	
	}

	public List<UpdateRecord> findByObjective(Objective objective){
        List<UpdateRecord> list = findByObjectiveId(Arrays.asList(objective.getId()));
		return list;
	}
	public boolean removeByObjectiveId(String objectiveId){
        return this.remove(Wrappers.<UpdateRecord>lambdaQuery().eq(UpdateRecord::getObjectiveId,objectiveId));
	}

	public boolean resetByObjectiveId(String objectiveId){
		return this.update(Wrappers.<UpdateRecord>lambdaUpdate().eq(UpdateRecord::getObjectiveId,objectiveId));
	}
	public boolean saveByObjective(Objective objective, List<UpdateRecord> list){
        if(list==null)
            return true;

        Map<String,UpdateRecord> before = findByObjective(objective).stream().collect(Collectors.toMap(UpdateRecord::getId,e->e));
        List<UpdateRecord> update = new ArrayList<>();
        List<UpdateRecord> create = new ArrayList<>();

        for(UpdateRecord sub:list) {
            sub.setObjectiveId(objective.getId());
            sub.setObjective(objective);
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
   public Page<UpdateRecord> fetchView(UpdateRecordSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UpdateRecord> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<UpdateRecord> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<UpdateRecord> listView(UpdateRecordSearchContext context) {
        List<UpdateRecord> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(UpdateRecord et) {
        if(Entities.KEY_RESULT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setKeyResultId((String)et.getContextParentKey());
        }
        if(Entities.OBJECTIVE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setObjectiveId((String)et.getContextParentKey());
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
        return UpdateRecordMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return UpdateRecord.class;
    }

}