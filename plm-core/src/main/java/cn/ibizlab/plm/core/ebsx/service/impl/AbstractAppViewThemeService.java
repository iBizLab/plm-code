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
import cn.ibizlab.plm.core.ebsx.domain.AppViewTheme;
import cn.ibizlab.plm.core.ebsx.filter.AppViewThemeSearchContext;
import cn.ibizlab.plm.core.ebsx.service.AppViewThemeService;
import cn.ibizlab.plm.core.ebsx.mapper.AppViewThemeMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[应用视图主题] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAppViewThemeService extends ServiceImpl<AppViewThemeMapper,AppViewTheme> implements AppViewThemeService {

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(AppViewTheme et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<AppViewTheme> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(AppViewTheme et) {
        UpdateWrapper<AppViewTheme> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<AppViewTheme> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(AppViewTheme et) {
        if(!remove(Wrappers.<AppViewTheme>lambdaQuery().eq(AppViewTheme::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<AppViewTheme> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public AppViewTheme get(AppViewTheme et) {
        AppViewTheme rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.APP_VIEW_THEME.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<AppViewTheme> get(List<AppViewTheme> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public AppViewTheme getDraft(AppViewTheme et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(AppViewTheme et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<AppViewTheme>lambdaQuery().eq(AppViewTheme::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(AppViewTheme et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<AppViewTheme> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,AppViewTheme> before = get(list).stream().collect(Collectors.toMap(AppViewTheme::getId,e->e));
        List<AppViewTheme> create = new ArrayList<>();
        List<AppViewTheme> update = new ArrayList<>();
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
	
   public Page<AppViewTheme> fetchDefault(AppViewThemeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AppViewTheme> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<AppViewTheme> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AppViewTheme> listDefault(AppViewThemeSearchContext context) {
        List<AppViewTheme> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<AppViewTheme> fetchCurSystem(AppViewThemeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AppViewTheme> pages=baseMapper.searchCurSystem(context.getPages(),context,context.getSelectCond());
        List<AppViewTheme> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AppViewTheme> listCurSystem(AppViewThemeSearchContext context) {
        List<AppViewTheme> list = baseMapper.listCurSystem(context,context.getSelectCond());
        return list;
   }
	
   public Page<AppViewTheme> fetchCurSystemAll(AppViewThemeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AppViewTheme> pages=baseMapper.searchCurSystemAll(context.getPages(),context,context.getSelectCond());
        List<AppViewTheme> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AppViewTheme> listCurSystemAll(AppViewThemeSearchContext context) {
        List<AppViewTheme> list = baseMapper.listCurSystemAll(context,context.getSelectCond());
        return list;
   }
	
   public Page<AppViewTheme> fetchCurUser(AppViewThemeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AppViewTheme> pages=baseMapper.searchCurUser(context.getPages(),context,context.getSelectCond());
        List<AppViewTheme> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AppViewTheme> listCurUser(AppViewThemeSearchContext context) {
        List<AppViewTheme> list = baseMapper.listCurUser(context,context.getSelectCond());
        return list;
   }
	
   public Page<AppViewTheme> fetchCurUserAll(AppViewThemeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AppViewTheme> pages=baseMapper.searchCurUserAll(context.getPages(),context,context.getSelectCond());
        List<AppViewTheme> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AppViewTheme> listCurUserAll(AppViewThemeSearchContext context) {
        List<AppViewTheme> list = baseMapper.listCurUserAll(context,context.getSelectCond());
        return list;
   }
	
   public Page<AppViewTheme> fetchPsmodelSync(AppViewThemeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AppViewTheme> pages=baseMapper.searchPsmodelSync(context.getPages(),context,context.getSelectCond());
        List<AppViewTheme> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AppViewTheme> listPsmodelSync(AppViewThemeSearchContext context) {
        List<AppViewTheme> list = baseMapper.listPsmodelSync(context,context.getSelectCond());
        return list;
   }
	
   public Page<AppViewTheme> fetchView(AppViewThemeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AppViewTheme> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<AppViewTheme> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AppViewTheme> listView(AppViewThemeSearchContext context) {
        List<AppViewTheme> list = baseMapper.listView(context,context.getSelectCond());
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
        return AppViewThemeMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return AppViewTheme.class;
    }

}