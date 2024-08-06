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
import cn.ibizlab.plm.core.testmgmt.domain.RunAttachment;
import cn.ibizlab.plm.core.testmgmt.filter.RunAttachmentSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.RunAttachmentService;
import cn.ibizlab.plm.core.testmgmt.mapper.RunAttachmentMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.service.RunService;

/**
 * 实体[执行用例结果附件] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRunAttachmentService extends ServiceImpl<RunAttachmentMapper,RunAttachment> implements RunAttachmentService {

    @Autowired
    @Lazy
    protected RunService runService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(RunAttachment et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<RunAttachment> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(RunAttachment et) {
        UpdateWrapper<RunAttachment> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<RunAttachment> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(RunAttachment et) {
        if(!remove(Wrappers.<RunAttachment>lambdaQuery().eq(RunAttachment::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<RunAttachment> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public RunAttachment get(RunAttachment et) {
        RunAttachment rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.RUN_ATTACHMENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<RunAttachment> get(List<RunAttachment> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public RunAttachment getDraft(RunAttachment et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(RunAttachment et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<RunAttachment>lambdaQuery().eq(RunAttachment::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(RunAttachment et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<RunAttachment> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,RunAttachment> before = get(list).stream().collect(Collectors.toMap(RunAttachment::getId,e->e));
        List<RunAttachment> create = new ArrayList<>();
        List<RunAttachment> update = new ArrayList<>();
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
	
   public Page<RunAttachment> fetchDefault(RunAttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<RunAttachment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<RunAttachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<RunAttachment> listDefault(RunAttachmentSearchContext context) {
        List<RunAttachment> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<RunAttachment> findByOwnerId(List<String> ownerIds){
        List<RunAttachment> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<RunAttachment> findByRunAttachment(Run run){
        List<RunAttachment> list = this.baseMapper.selectList(Wrappers.<RunAttachment>lambdaQuery()
                        .eq(RunAttachment::getOwnerId, run.getId())
                        .eq(RunAttachment::getOwnerType,"RUN")
                        .eq(RunAttachment::getOwnerSubtype,"RUN"));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<RunAttachment>lambdaQuery().eq(RunAttachment::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<RunAttachment>lambdaUpdate().eq(RunAttachment::getOwnerId,ownerId));
	}
	public boolean saveByRunAttachment(Run run, List<RunAttachment> list){
        if(list==null)
            return true;

        Map<String,RunAttachment> before = findByRunAttachment(run).stream().collect(Collectors.toMap(RunAttachment::getId,e->e));
        List<RunAttachment> update = new ArrayList<>();
        List<RunAttachment> create = new ArrayList<>();

        for(RunAttachment sub:list) {
            sub.setOwnerId(run.getId());
            sub.setRunAttachment(run);
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
   public Page<RunAttachment> fetchView(RunAttachmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<RunAttachment> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<RunAttachment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<RunAttachment> listView(RunAttachmentSearchContext context) {
        List<RunAttachment> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(RunAttachment et) {
        if(Entities.RUN.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
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
        return RunAttachmentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return RunAttachment.class;
    }

}