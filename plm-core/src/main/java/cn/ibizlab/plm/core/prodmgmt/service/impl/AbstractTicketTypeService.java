/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service.impl;

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
import cn.ibizlab.plm.core.prodmgmt.domain.TicketType;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketTypeSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.TicketTypeService;
import cn.ibizlab.plm.core.prodmgmt.mapper.TicketTypeMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.service.ProductTicketTypeService;

/**
 * 实体[工单类型] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTicketTypeService extends ServiceImpl<TicketTypeMapper,TicketType> implements TicketTypeService {

    @Autowired
    @Lazy
    protected ProductTicketTypeService productTicketTypeService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TicketType et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<TicketType> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(TicketType et) {
        UpdateWrapper<TicketType> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<TicketType> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(TicketType et) {
        String key = et.getId();
        productTicketTypeService.removeByTicketTypeId(key);
        if(!remove(Wrappers.<TicketType>lambdaQuery().eq(TicketType::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<TicketType> entities) {
        for (TicketType et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public TicketType get(TicketType et) {
        TicketType rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.TICKET_TYPE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<TicketType> get(List<TicketType> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public TicketType getDraft(TicketType et) {
        return et;
    }
	
    public Integer checkKey(TicketType et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<TicketType>lambdaQuery().eq(TicketType::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(TicketType et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<TicketType> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,TicketType> before = get(list).stream().collect(Collectors.toMap(TicketType::getId,e->e));
        List<TicketType> create = new ArrayList<>();
        List<TicketType> update = new ArrayList<>();
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
	
   public Page<TicketType> fetchDefault(TicketTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TicketType> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<TicketType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TicketType> listDefault(TicketTypeSearchContext context) {
        List<TicketType> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<TicketType> fetchNotExistsTicketType(TicketTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TicketType> pages=baseMapper.searchNotExistsTicketType(context.getPages(),context,context.getSelectCond());
        List<TicketType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TicketType> listNotExistsTicketType(TicketTypeSearchContext context) {
        List<TicketType> list = baseMapper.listNotExistsTicketType(context,context.getSelectCond());
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
        return TicketTypeMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return TicketType.class;
    }

}