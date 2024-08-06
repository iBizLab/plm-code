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
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import cn.ibizlab.plm.core.base.filter.ReferencesIndexSearchContext;
import cn.ibizlab.plm.core.base.service.ReferencesIndexService;
import cn.ibizlab.plm.core.base.mapper.ReferencesIndexMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[引用索引] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReferencesIndexService extends ServiceImpl<ReferencesIndexMapper,ReferencesIndex> implements ReferencesIndexService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ReferencesIndex et) {
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ReferencesIndex> list) {
        return true;
    }
	
    @Transactional
    public boolean update(ReferencesIndex et) {
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ReferencesIndex> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }
	
   @Transactional
    public boolean remove(ReferencesIndex et) {
        return true;
    }

    @Transactional
    public boolean remove(List<ReferencesIndex> entities) {
        return true;
    }		
    public ReferencesIndex get(ReferencesIndex et) {
        ReferencesIndex rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.REFERENCES_INDEX.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<ReferencesIndex> get(List<ReferencesIndex> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ReferencesIndex getDraft(ReferencesIndex et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(ReferencesIndex et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ReferencesIndex>lambdaQuery().eq(ReferencesIndex::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ReferencesIndex et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ReferencesIndex> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ReferencesIndex> before = get(list).stream().collect(Collectors.toMap(ReferencesIndex::getId,e->e));
        List<ReferencesIndex> create = new ArrayList<>();
        List<ReferencesIndex> update = new ArrayList<>();
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
	
   public Page<ReferencesIndex> fetchDefault(ReferencesIndexSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReferencesIndex> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ReferencesIndex> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ReferencesIndex> listDefault(ReferencesIndexSearchContext context) {
        List<ReferencesIndex> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<ReferencesIndex> fetchView(ReferencesIndexSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReferencesIndex> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ReferencesIndex> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ReferencesIndex> listView(ReferencesIndexSearchContext context) {
        List<ReferencesIndex> list = baseMapper.listView(context,context.getSelectCond());
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
        return ReferencesIndexMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ReferencesIndex.class;
    }

}