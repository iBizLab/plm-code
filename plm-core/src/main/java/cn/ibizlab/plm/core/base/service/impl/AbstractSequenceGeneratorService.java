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
import cn.ibizlab.plm.core.base.domain.SequenceGenerator;
import cn.ibizlab.plm.core.base.filter.SequenceGeneratorSearchContext;
import cn.ibizlab.plm.core.base.service.SequenceGeneratorService;
import cn.ibizlab.plm.core.base.mapper.SequenceGeneratorMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[序列] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSequenceGeneratorService extends ServiceImpl<SequenceGeneratorMapper,SequenceGenerator> implements SequenceGeneratorService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SequenceGenerator et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<SequenceGenerator> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(SequenceGenerator et) {
        UpdateWrapper<SequenceGenerator> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<SequenceGenerator> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(SequenceGenerator et) {
        if(!remove(Wrappers.<SequenceGenerator>lambdaQuery().eq(SequenceGenerator::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<SequenceGenerator> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public SequenceGenerator get(SequenceGenerator et) {
        SequenceGenerator rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SEQUENCE_GENERATOR.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<SequenceGenerator> get(List<SequenceGenerator> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public SequenceGenerator getDraft(SequenceGenerator et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(SequenceGenerator et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<SequenceGenerator>lambdaQuery().eq(SequenceGenerator::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(SequenceGenerator et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<SequenceGenerator> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SequenceGenerator> before = get(list).stream().collect(Collectors.toMap(SequenceGenerator::getId,e->e));
        List<SequenceGenerator> create = new ArrayList<>();
        List<SequenceGenerator> update = new ArrayList<>();
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
	
   public Page<SequenceGenerator> fetchDefault(SequenceGeneratorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SequenceGenerator> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<SequenceGenerator> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SequenceGenerator> listDefault(SequenceGeneratorSearchContext context) {
        List<SequenceGenerator> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<SequenceGenerator> fetchView(SequenceGeneratorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SequenceGenerator> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<SequenceGenerator> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SequenceGenerator> listView(SequenceGeneratorSearchContext context) {
        List<SequenceGenerator> list = baseMapper.listView(context,context.getSelectCond());
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
        return SequenceGeneratorMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return SequenceGenerator.class;
    }

}