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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.DictionaryData;
import cn.ibizlab.plm.core.base.filter.DictionaryDataSearchContext;
import cn.ibizlab.plm.core.base.service.DictionaryDataService;
import cn.ibizlab.plm.core.base.mapper.DictionaryDataMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[数据字典] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDictionaryDataService extends ServiceImpl<DictionaryDataMapper,DictionaryData> implements DictionaryDataService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DictionaryData et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<DictionaryData> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(DictionaryData et) {
        UpdateWrapper<DictionaryData> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<DictionaryData> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(DictionaryData et) {
        if(!remove(Wrappers.<DictionaryData>lambdaQuery().eq(DictionaryData::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<DictionaryData> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public DictionaryData get(DictionaryData et) {
        DictionaryData rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DICTIONARY_DATA.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<DictionaryData> get(List<DictionaryData> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public DictionaryData getDraft(DictionaryData et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(DictionaryData et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<DictionaryData>lambdaQuery().eq(DictionaryData::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(DictionaryData et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<DictionaryData> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,DictionaryData> before = get(list).stream().collect(Collectors.toMap(DictionaryData::getId,e->e));
        List<DictionaryData> create = new ArrayList<>();
        List<DictionaryData> update = new ArrayList<>();
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
	
   public Page<DictionaryData> fetchDefault(DictionaryDataSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DictionaryData> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<DictionaryData> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DictionaryData> listDefault(DictionaryDataSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<DictionaryData> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<DictionaryData> fetchIdeaState(DictionaryDataSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DictionaryData> pages=baseMapper.searchIdeaState(context.getPages(),context,context.getSelectCond());
        List<DictionaryData> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DictionaryData> listIdeaState(DictionaryDataSearchContext context) {
        List<DictionaryData> list = baseMapper.listIdeaState(context,context.getSelectCond());
        return list;
   }
	
   public Page<DictionaryData> fetchReleaseStage(DictionaryDataSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DictionaryData> pages=baseMapper.searchReleaseStage(context.getPages(),context,context.getSelectCond());
        List<DictionaryData> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DictionaryData> listReleaseStage(DictionaryDataSearchContext context) {
        List<DictionaryData> list = baseMapper.listReleaseStage(context,context.getSelectCond());
        return list;
   }
	
   public Page<DictionaryData> fetchTicketState(DictionaryDataSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DictionaryData> pages=baseMapper.searchTicketState(context.getPages(),context,context.getSelectCond());
        List<DictionaryData> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DictionaryData> listTicketState(DictionaryDataSearchContext context) {
        List<DictionaryData> list = baseMapper.listTicketState(context,context.getSelectCond());
        return list;
   }
	
   public Page<DictionaryData> fetchView(DictionaryDataSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DictionaryData> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<DictionaryData> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DictionaryData> listView(DictionaryDataSearchContext context) {
        List<DictionaryData> list = baseMapper.listView(context,context.getSelectCond());
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
        return DictionaryDataMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return DictionaryData.class;
    }

}