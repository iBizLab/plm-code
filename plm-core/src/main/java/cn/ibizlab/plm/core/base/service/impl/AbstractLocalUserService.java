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
import cn.ibizlab.plm.core.base.domain.LocalUser;
import cn.ibizlab.plm.core.base.filter.LocalUserSearchContext;
import cn.ibizlab.plm.core.base.service.LocalUserService;
import cn.ibizlab.plm.core.base.mapper.LocalUserMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.LocalDepartment;
import cn.ibizlab.plm.core.base.service.LocalDepartmentService;

/**
 * 实体[企业用户] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractLocalUserService extends ServiceImpl<LocalUserMapper,LocalUser> implements LocalUserService {

    @Autowired
    @Lazy
    protected LocalDepartmentService localDepartmentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(LocalUser et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<LocalUser> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(LocalUser et) {
        UpdateWrapper<LocalUser> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<LocalUser> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(LocalUser et) {
        if(!remove(Wrappers.<LocalUser>lambdaQuery().eq(LocalUser::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<LocalUser> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public LocalUser get(LocalUser et) {
        LocalUser rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.LOCAL_USER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<LocalUser> get(List<LocalUser> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public LocalUser getDraft(LocalUser et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(LocalUser et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<LocalUser>lambdaQuery().eq(LocalUser::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(LocalUser et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<LocalUser> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,LocalUser> before = get(list).stream().collect(Collectors.toMap(LocalUser::getId,e->e));
        List<LocalUser> create = new ArrayList<>();
        List<LocalUser> update = new ArrayList<>();
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
	
   public Page<LocalUser> fetchDefault(LocalUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<LocalUser> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<LocalUser> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<LocalUser> listDefault(LocalUserSearchContext context) {
        List<LocalUser> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<LocalUser> findByDepartmentId(List<String> departmentIds){
        List<LocalUser> list = baseMapper.findByDepartmentId(departmentIds);
        return list;	
	}

	public List<LocalUser> findByLocalDepartment(LocalDepartment localDepartment){
        List<LocalUser> list = findByDepartmentId(Arrays.asList(localDepartment.getId()));
		return list;
	}
	public boolean removeByDepartmentId(String departmentId){
        return this.remove(Wrappers.<LocalUser>lambdaQuery().eq(LocalUser::getDepartmentId,departmentId));
	}

	public boolean resetByDepartmentId(String departmentId){
		return this.update(Wrappers.<LocalUser>lambdaUpdate().set(LocalUser::getDepartmentId, null).eq(LocalUser::getDepartmentId,departmentId));
	}
	public boolean saveByLocalDepartment(LocalDepartment localDepartment, List<LocalUser> list){
        if(list==null)
            return true;

        Map<String,LocalUser> before = findByLocalDepartment(localDepartment).stream().collect(Collectors.toMap(LocalUser::getId,e->e));
        List<LocalUser> update = new ArrayList<>();
        List<LocalUser> create = new ArrayList<>();

        for(LocalUser sub:list) {
            sub.setDepartmentId(localDepartment.getId());
            sub.setLocalDepartment(localDepartment);
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
   public Page<LocalUser> fetchView(LocalUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<LocalUser> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<LocalUser> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<LocalUser> listView(LocalUserSearchContext context) {
        List<LocalUser> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(LocalUser et) {
        if(Entities.LOCAL_DEPARTMENT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setDepartmentId((String)et.getContextParentKey());
            LocalDepartment localDepartment = et.getLocalDepartment();
            if(localDepartment == null) {
                localDepartment = localDepartmentService.getById(et.getDepartmentId());
                et.setLocalDepartment(localDepartment);
            }
            if(!ObjectUtils.isEmpty(localDepartment)) {
                et.setDepartmentId(localDepartment.getId());
                et.setDepartmentName(localDepartment.getName());
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
        return LocalUserMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return LocalUser.class;
    }

}