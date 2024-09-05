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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.DataSyncTask;
import cn.ibizlab.plm.core.base.filter.DataSyncTaskSearchContext;
import cn.ibizlab.plm.core.base.service.DataSyncTaskService;
import cn.ibizlab.plm.core.base.mapper.DataSyncTaskMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[数据同步任务] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDataSyncTaskService extends ServiceImpl<DataSyncTaskMapper,DataSyncTask> implements DataSyncTaskService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DataSyncTask et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<DataSyncTask> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(DataSyncTask et) {
        UpdateWrapper<DataSyncTask> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<DataSyncTask> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(DataSyncTask et) {
        if(!remove(Wrappers.<DataSyncTask>lambdaQuery().eq(DataSyncTask::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<DataSyncTask> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public DataSyncTask get(DataSyncTask et) {
        DataSyncTask rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DATA_SYNC_TASK.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<DataSyncTask> get(List<DataSyncTask> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public DataSyncTask getDraft(DataSyncTask et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(DataSyncTask et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<DataSyncTask>lambdaQuery().eq(DataSyncTask::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(DataSyncTask et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<DataSyncTask> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,DataSyncTask> before = get(list).stream().collect(Collectors.toMap(DataSyncTask::getId,e->e));
        List<DataSyncTask> create = new ArrayList<>();
        List<DataSyncTask> update = new ArrayList<>();
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
	
   public Page<DataSyncTask> fetchDefault(DataSyncTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DataSyncTask> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<DataSyncTask> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DataSyncTask> listDefault(DataSyncTaskSearchContext context) {
        List<DataSyncTask> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<DataSyncTask> fetchView(DataSyncTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DataSyncTask> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<DataSyncTask> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DataSyncTask> listView(DataSyncTaskSearchContext context) {
        List<DataSyncTask> list = baseMapper.listView(context,context.getSelectCond());
        return list;
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
        return DataSyncTaskMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return DataSyncTask.class;
    }

}