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
import cn.ibizlab.plm.core.base.domain.LocalDepartment;
import cn.ibizlab.plm.core.base.filter.LocalDepartmentSearchContext;
import cn.ibizlab.plm.core.base.service.LocalDepartmentService;
import cn.ibizlab.plm.core.base.mapper.LocalDepartmentMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.LocalUser;
import cn.ibizlab.plm.core.base.service.LocalUserService;

/**
 * 实体[部门] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractLocalDepartmentService extends ServiceImpl<LocalDepartmentMapper,LocalDepartment> implements LocalDepartmentService {

    @Autowired
    @Lazy
    protected LocalUserService localUserService;

    @Autowired
    @Lazy
    protected LocalDepartmentService localDepartmentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(LocalDepartment et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<LocalDepartment> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(LocalDepartment et) {
        UpdateWrapper<LocalDepartment> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<LocalDepartment> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(LocalDepartment et) {
        if(!remove(Wrappers.<LocalDepartment>lambdaQuery().eq(LocalDepartment::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<LocalDepartment> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public LocalDepartment get(LocalDepartment et) {
        LocalDepartment rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.LOCAL_DEPARTMENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<LocalDepartment> get(List<LocalDepartment> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public LocalDepartment getDraft(LocalDepartment et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(LocalDepartment et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<LocalDepartment>lambdaQuery().eq(LocalDepartment::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(LocalDepartment et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<LocalDepartment> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,LocalDepartment> before = get(list).stream().collect(Collectors.toMap(LocalDepartment::getId,e->e));
        List<LocalDepartment> create = new ArrayList<>();
        List<LocalDepartment> update = new ArrayList<>();
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
	
   public Page<LocalDepartment> fetchDefault(LocalDepartmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<LocalDepartment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<LocalDepartment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<LocalDepartment> listDefault(LocalDepartmentSearchContext context) {
        List<LocalDepartment> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<LocalDepartment> findByParentId(List<String> parentIds){
        List<LocalDepartment> list = baseMapper.findByParentId(parentIds);
        return list;	
	}

	public List<LocalDepartment> findByLocalDepartment(LocalDepartment localDepartment){
        List<LocalDepartment> list = findByParentId(Arrays.asList(localDepartment.getId()));
		return list;
	}
	public boolean removeByParentId(String parentId){
        return this.remove(Wrappers.<LocalDepartment>lambdaQuery().eq(LocalDepartment::getParentId,parentId));
	}

	public boolean resetByParentId(String parentId){
		return this.update(Wrappers.<LocalDepartment>lambdaUpdate().set(LocalDepartment::getParentId, null).eq(LocalDepartment::getParentId,parentId));
	}
	public boolean saveByLocalDepartment(LocalDepartment localDepartment, List<LocalDepartment> list){
        if(list==null)
            return true;

        Map<String,LocalDepartment> before = findByLocalDepartment(localDepartment).stream().collect(Collectors.toMap(LocalDepartment::getId,e->e));
        List<LocalDepartment> update = new ArrayList<>();
        List<LocalDepartment> create = new ArrayList<>();

        for(LocalDepartment sub:list) {
            sub.setParentId(localDepartment.getId());
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
	public List<LocalDepartment> findByHeadId(List<String> headIds){
        List<LocalDepartment> list = baseMapper.findByHeadId(headIds);
        return list;	
	}

	public List<LocalDepartment> findByLocalUser(LocalUser localUser){
        List<LocalDepartment> list = findByHeadId(Arrays.asList(localUser.getId()));
		return list;
	}
	public boolean removeByHeadId(String headId){
        return this.remove(Wrappers.<LocalDepartment>lambdaQuery().eq(LocalDepartment::getHeadId,headId));
	}

	public boolean resetByHeadId(String headId){
		return this.update(Wrappers.<LocalDepartment>lambdaUpdate().set(LocalDepartment::getHeadId, null).eq(LocalDepartment::getHeadId,headId));
	}
	public boolean saveByLocalUser(LocalUser localUser, List<LocalDepartment> list){
        if(list==null)
            return true;

        Map<String,LocalDepartment> before = findByLocalUser(localUser).stream().collect(Collectors.toMap(LocalDepartment::getId,e->e));
        List<LocalDepartment> update = new ArrayList<>();
        List<LocalDepartment> create = new ArrayList<>();

        for(LocalDepartment sub:list) {
            sub.setHeadId(localUser.getId());
            sub.setLocalUser(localUser);
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
   public Page<LocalDepartment> fetchView(LocalDepartmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<LocalDepartment> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<LocalDepartment> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<LocalDepartment> listView(LocalDepartmentSearchContext context) {
        List<LocalDepartment> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(LocalDepartment et) {
        if(Entities.LOCAL_DEPARTMENT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setParentId((String)et.getContextParentKey());
        }
        if(Entities.LOCAL_USER.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setHeadId((String)et.getContextParentKey());
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
        return LocalDepartmentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return LocalDepartment.class;
    }

}