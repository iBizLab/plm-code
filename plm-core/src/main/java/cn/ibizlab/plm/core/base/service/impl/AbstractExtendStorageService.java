/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.base.domain.ExtendStorage;
import cn.ibizlab.plm.core.base.filter.ExtendStorageSearchContext;
import cn.ibizlab.plm.core.base.service.ExtendStorageService;
import cn.ibizlab.plm.core.base.mapper.ExtendStorageMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[扩展存储] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractExtendStorageService extends ServiceImpl<ExtendStorageMapper,ExtendStorage> implements ExtendStorageService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ExtendStorage et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ExtendStorage> list) {
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ExtendStorage et) {
        UpdateWrapper<ExtendStorage> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ExtendStorage> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ExtendStorage et) {
        if(!remove(Wrappers.<ExtendStorage>lambdaQuery().eq(ExtendStorage::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ExtendStorage> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public ExtendStorage get(ExtendStorage et) {
        ExtendStorage rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.EXTEND_STORAGE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<ExtendStorage> get(List<ExtendStorage> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ExtendStorage getDraft(ExtendStorage et) {
        return et;
    }
	
    public Integer checkKey(ExtendStorage et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ExtendStorage>lambdaQuery().eq(ExtendStorage::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(ExtendStorage et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ExtendStorage> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ExtendStorage> before = get(list).stream().collect(Collectors.toMap(ExtendStorage::getId,e->e));
        List<ExtendStorage> create = new ArrayList<>();
        List<ExtendStorage> update = new ArrayList<>();
        list.forEach(sub->{
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	
   public Page<ExtendStorage> fetchDefault(ExtendStorageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ExtendStorage> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ExtendStorage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ExtendStorage> listDefault(ExtendStorageSearchContext context) {
        List<ExtendStorage> list = baseMapper.listDefault(context,context.getSelectCond());
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
        return ExtendStorageMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ExtendStorage.class;
    }

}