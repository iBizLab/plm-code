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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Parameter;
import cn.ibizlab.plm.core.base.filter.ParameterSearchContext;
import cn.ibizlab.plm.core.base.service.ParameterService;
import cn.ibizlab.plm.core.base.mapper.ParameterMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[系统参数] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractParameterService extends ServiceImpl<ParameterMapper,Parameter> implements ParameterService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Parameter et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Parameter> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Parameter et) {
        UpdateWrapper<Parameter> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Parameter> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Parameter et) {
        if(!remove(Wrappers.<Parameter>lambdaQuery().eq(Parameter::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Parameter> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Parameter get(Parameter et) {
        Parameter rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PARAMETER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Parameter> get(List<Parameter> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Parameter getDraft(Parameter et) {
        return et;
    }
	
    public Integer checkKey(Parameter et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Parameter>lambdaQuery().eq(Parameter::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(Parameter et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Parameter> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Parameter> before = get(list).stream().collect(Collectors.toMap(Parameter::getId,e->e));
        List<Parameter> create = new ArrayList<>();
        List<Parameter> update = new ArrayList<>();
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
	
   public Page<Parameter> fetchDefault(ParameterSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Parameter> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Parameter> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Parameter> listDefault(ParameterSearchContext context) {
        List<Parameter> list = baseMapper.listDefault(context,context.getSelectCond());
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
        return ParameterMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Parameter.class;
    }

}