/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service.impl;

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
import cn.ibizlab.plm.core.ebsx.domain.AuthLogAdmin;
import cn.ibizlab.plm.core.ebsx.filter.AuthLogAdminSearchContext;
import cn.ibizlab.plm.core.ebsx.service.AuthLogAdminService;
import cn.ibizlab.plm.core.ebsx.mapper.AuthLogAdminMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[认证日志] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAuthLogAdminService extends ServiceImpl<AuthLogAdminMapper,AuthLogAdmin> implements AuthLogAdminService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(AuthLogAdmin et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<AuthLogAdmin> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(AuthLogAdmin et) {
        UpdateWrapper<AuthLogAdmin> qw = et.getUpdateWrapper(true);
        qw.eq("logid", et.getLogId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<AuthLogAdmin> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(AuthLogAdmin et) {
        if(!remove(Wrappers.<AuthLogAdmin>lambdaQuery().eq(AuthLogAdmin::getLogId, et.getLogId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<AuthLogAdmin> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public AuthLogAdmin get(AuthLogAdmin et) {
        AuthLogAdmin rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.AUTH_LOG_ADMIN.toString(),et.getLogId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<AuthLogAdmin> get(List<AuthLogAdmin> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public AuthLogAdmin getDraft(AuthLogAdmin et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(AuthLogAdmin et) {
        return (!ObjectUtils.isEmpty(et.getLogId()) && this.count(Wrappers.<AuthLogAdmin>lambdaQuery().eq(AuthLogAdmin::getLogId, et.getLogId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(AuthLogAdmin et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<AuthLogAdmin> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,AuthLogAdmin> before = get(list).stream().collect(Collectors.toMap(AuthLogAdmin::getLogId,e->e));
        List<AuthLogAdmin> create = new ArrayList<>();
        List<AuthLogAdmin> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getLogId()) && before.containsKey(sub.getLogId()))
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
	
   public Page<AuthLogAdmin> fetchDefault(AuthLogAdminSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AuthLogAdmin> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<AuthLogAdmin> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AuthLogAdmin> listDefault(AuthLogAdminSearchContext context) {
        List<AuthLogAdmin> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<AuthLogAdmin> fetchDistinctUserid(AuthLogAdminSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchDistinctUserid(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AuthLogAdmin>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),AuthLogAdmin.class), context.getPageable(), pages.getTotal());
    }

   public List<AuthLogAdmin> listDistinctUserid(AuthLogAdminSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listDistinctUserid(context,context.getSelectCond()),AuthLogAdmin.class);
   }
	
   public Page<AuthLogAdmin> fetchGroupByData(AuthLogAdminSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchGroupByData(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AuthLogAdmin>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),AuthLogAdmin.class), context.getPageable(), pages.getTotal());
    }

   public List<AuthLogAdmin> listGroupByData(AuthLogAdminSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listGroupByData(context,context.getSelectCond()),AuthLogAdmin.class);
   }
	
   public Page<AuthLogAdmin> fetchView(AuthLogAdminSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AuthLogAdmin> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<AuthLogAdmin> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AuthLogAdmin> listView(AuthLogAdminSearchContext context) {
        List<AuthLogAdmin> list = baseMapper.listView(context,context.getSelectCond());
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
        return AuthLogAdminMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return AuthLogAdmin.class;
    }

}