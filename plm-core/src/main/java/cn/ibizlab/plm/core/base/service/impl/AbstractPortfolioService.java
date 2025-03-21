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
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.filter.PortfolioSearchContext;
import cn.ibizlab.plm.core.base.service.PortfolioService;
import cn.ibizlab.plm.core.base.mapper.PortfolioMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.base.service.PortfolioMemberService;
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.service.WorkService;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.service.AddonService;

/**
 * 实体[文件夹] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPortfolioService extends ServiceImpl<PortfolioMapper,Portfolio> implements PortfolioService {

    @Autowired
    @Lazy
    protected PortfolioMemberService portfolioMemberService;

    @Autowired
    @Lazy
    protected WorkService workService;

    @Autowired
    @Lazy
    protected AddonService addonService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Portfolio et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        portfolioMemberService.saveByPortfolio(et,et.getMembers());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Portfolio> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Portfolio et) {
        UpdateWrapper<Portfolio> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        portfolioMemberService.saveByPortfolio(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Portfolio> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Portfolio et) {
        if(!remove(Wrappers.<Portfolio>lambdaQuery().eq(Portfolio::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Portfolio> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Portfolio get(Portfolio et) {
        Portfolio rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PORTFOLIO.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [文件夹成员]
        getMembers(et);
        return et;
    }	

    public List<Portfolio> get(List<Portfolio> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Portfolio getDraft(Portfolio et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(Portfolio et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Portfolio>lambdaQuery().eq(Portfolio::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Portfolio et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Portfolio> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Portfolio> before = get(list).stream().collect(Collectors.toMap(Portfolio::getId,e->e));
        List<Portfolio> create = new ArrayList<>();
        List<Portfolio> update = new ArrayList<>();
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
	
   public Page<Portfolio> fetchDefault(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listDefault(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Portfolio> fetchAdmin(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listAdmin(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
   }
	
   public Page<Portfolio> fetchChooseProjectPortfolio(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchChooseProjectPortfolio(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listChooseProjectPortfolio(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listChooseProjectPortfolio(context,context.getSelectCond());
        return list;
   }
	
   public Page<Portfolio> fetchFavorite(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchFavorite(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listFavorite(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listFavorite(context,context.getSelectCond());
        return list;
   }
	
   public Page<Portfolio> fetchProjectSetDeleted(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchProjectSetDeleted(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listProjectSetDeleted(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listProjectSetDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<Portfolio> fetchProjectSetGoing(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchProjectSetGoing(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listProjectSetGoing(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listProjectSetGoing(context,context.getSelectCond());
        return list;
   }
	
   public Page<Portfolio> fetchReader(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listReader(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<Portfolio> fetchUser(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listUser(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
   }
	
   public Page<Portfolio> fetchWorkProjectPortfolio(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchWorkProjectPortfolio(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listWorkProjectPortfolio(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listWorkProjectPortfolio(context,context.getSelectCond());
        return list;
   }
	
	@Override
    public List<PortfolioMember> getMembers(Portfolio et) {
        List<PortfolioMember> list = portfolioMemberService.findByPortfolio(et);
        et.setMembers(list);
        return list;
    }
	
   public Page<Portfolio> fetchView(PortfolioSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Portfolio> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Portfolio> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Portfolio> listView(PortfolioSearchContext context) {
        List<Portfolio> list = baseMapper.listView(context,context.getSelectCond());
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
        return PortfolioMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Portfolio.class;
    }

}