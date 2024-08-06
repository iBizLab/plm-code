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
import cn.ibizlab.plm.core.team.domain.KeyResult;
import cn.ibizlab.plm.core.team.filter.KeyResultSearchContext;
import cn.ibizlab.plm.core.team.service.KeyResultService;
import cn.ibizlab.plm.core.team.mapper.KeyResultMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.team.domain.Objective;
import cn.ibizlab.plm.core.team.service.ObjectiveService;
import cn.ibizlab.plm.core.team.domain.UpdateRecord;
import cn.ibizlab.plm.core.team.service.UpdateRecordService;

/**
 * 实体[关键结果] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractKeyResultService extends ServiceImpl<KeyResultMapper,KeyResult> implements KeyResultService {

    @Autowired
    @Lazy
    protected ObjectiveService objectiveService;

    @Autowired
    @Lazy
    protected UpdateRecordService updateRecordService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(KeyResult et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<KeyResult> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(KeyResult et) {
        UpdateWrapper<KeyResult> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<KeyResult> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(KeyResult et) {
        if(!remove(Wrappers.<KeyResult>lambdaQuery().eq(KeyResult::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<KeyResult> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public KeyResult get(KeyResult et) {
        KeyResult rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.KEY_RESULT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<KeyResult> get(List<KeyResult> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public KeyResult getDraft(KeyResult et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(KeyResult et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<KeyResult>lambdaQuery().eq(KeyResult::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(KeyResult et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<KeyResult> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,KeyResult> before = get(list).stream().collect(Collectors.toMap(KeyResult::getId,e->e));
        List<KeyResult> create = new ArrayList<>();
        List<KeyResult> update = new ArrayList<>();
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
	
   public Page<KeyResult> fetchDefault(KeyResultSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<KeyResult> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<KeyResult> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<KeyResult> listDefault(KeyResultSearchContext context) {
        List<KeyResult> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<KeyResult> findByObjectiveId(List<String> objectiveIds){
        List<KeyResult> list = baseMapper.findByObjectiveId(objectiveIds);
        return list;	
	}

	public List<KeyResult> findByObjective(Objective objective){
        List<KeyResult> list = findByObjectiveId(Arrays.asList(objective.getId()));
		return list;
	}
	public boolean removeByObjectiveId(String objectiveId){
        return this.remove(Wrappers.<KeyResult>lambdaQuery().eq(KeyResult::getObjectiveId,objectiveId));
	}

	public boolean resetByObjectiveId(String objectiveId){
		return this.update(Wrappers.<KeyResult>lambdaUpdate().eq(KeyResult::getObjectiveId,objectiveId));
	}
	public boolean saveByObjective(Objective objective, List<KeyResult> list){
        if(list==null)
            return true;

        Map<String,KeyResult> before = findByObjective(objective).stream().collect(Collectors.toMap(KeyResult::getId,e->e));
        List<KeyResult> update = new ArrayList<>();
        List<KeyResult> create = new ArrayList<>();

        for(KeyResult sub:list) {
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
   public Page<KeyResult> fetchView(KeyResultSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<KeyResult> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<KeyResult> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<KeyResult> listView(KeyResultSearchContext context) {
        List<KeyResult> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(KeyResult et) {
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
        return KeyResultMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return KeyResult.class;
    }

}