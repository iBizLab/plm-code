/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service.impl;

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
import cn.ibizlab.plm.core.wiki.domain.SharedSpace;
import cn.ibizlab.plm.core.wiki.filter.SharedSpaceSearchContext;
import cn.ibizlab.plm.core.wiki.service.SharedSpaceService;
import cn.ibizlab.plm.core.wiki.mapper.SharedSpaceMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;

/**
 * 实体[共享空间] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSharedSpaceService extends ServiceImpl<SharedSpaceMapper,SharedSpace> implements SharedSpaceService {

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SharedSpace et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<SharedSpace> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(SharedSpace et) {
        UpdateWrapper<SharedSpace> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<SharedSpace> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(SharedSpace et) {
        if(!remove(Wrappers.<SharedSpace>lambdaQuery().eq(SharedSpace::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<SharedSpace> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public SharedSpace get(SharedSpace et) {
        SharedSpace rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SHARED_SPACE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<SharedSpace> get(List<SharedSpace> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public SharedSpace getDraft(SharedSpace et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(SharedSpace et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<SharedSpace>lambdaQuery().eq(SharedSpace::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(SharedSpace et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<SharedSpace> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SharedSpace> before = get(list).stream().collect(Collectors.toMap(SharedSpace::getId,e->e));
        List<SharedSpace> create = new ArrayList<>();
        List<SharedSpace> update = new ArrayList<>();
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
	
   public Page<SharedSpace> fetchDefault(SharedSpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SharedSpace> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<SharedSpace> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SharedSpace> listDefault(SharedSpaceSearchContext context) {
        List<SharedSpace> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<SharedSpace> fetchAdmin(SharedSpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SharedSpace> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<SharedSpace> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SharedSpace> listAdmin(SharedSpaceSearchContext context) {
        List<SharedSpace> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
   }
	
   public Page<SharedSpace> fetchShared(SharedSpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SharedSpace> pages=baseMapper.searchShared(context.getPages(),context,context.getSelectCond());
        List<SharedSpace> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SharedSpace> listShared(SharedSpaceSearchContext context) {
        List<SharedSpace> list = baseMapper.listShared(context,context.getSelectCond());
        return list;
   }
	
   public Page<SharedSpace> fetchView(SharedSpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SharedSpace> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<SharedSpace> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SharedSpace> listView(SharedSpaceSearchContext context) {
        List<SharedSpace> list = baseMapper.listView(context,context.getSelectCond());
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
        return SharedSpaceMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return SharedSpace.class;
    }

}