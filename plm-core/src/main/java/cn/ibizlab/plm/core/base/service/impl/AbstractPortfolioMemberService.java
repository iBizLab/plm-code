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
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.base.filter.PortfolioMemberSearchContext;
import cn.ibizlab.plm.core.base.service.PortfolioMemberService;
import cn.ibizlab.plm.core.base.mapper.PortfolioMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.service.PortfolioService;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 实体[文件夹成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPortfolioMemberService extends ServiceImpl<PortfolioMemberMapper,PortfolioMember> implements PortfolioMemberService {

    @Autowired
    @Lazy
    protected PortfolioService portfolioService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PortfolioMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<PortfolioMember> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(PortfolioMember et) {
        fillParentData(et);
        UpdateWrapper<PortfolioMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<PortfolioMember> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(PortfolioMember et) {
        if(!remove(Wrappers.<PortfolioMember>lambdaQuery().eq(PortfolioMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<PortfolioMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public PortfolioMember get(PortfolioMember et) {
        PortfolioMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PORTFOLIO_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<PortfolioMember> get(List<PortfolioMember> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public PortfolioMember getDraft(PortfolioMember et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(PortfolioMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<PortfolioMember>lambdaQuery().eq(PortfolioMember::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(PortfolioMember et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<PortfolioMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,PortfolioMember> before = get(list).stream().collect(Collectors.toMap(PortfolioMember::getId,e->e));
        List<PortfolioMember> create = new ArrayList<>();
        List<PortfolioMember> update = new ArrayList<>();
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
	
   public Page<PortfolioMember> fetchDefault(PortfolioMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PortfolioMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<PortfolioMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<PortfolioMember> listDefault(PortfolioMemberSearchContext context) {
        List<PortfolioMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<PortfolioMember> fetchCurProjectSet(PortfolioMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PortfolioMember> pages=baseMapper.searchCurProjectSet(context.getPages(),context,context.getSelectCond());
        List<PortfolioMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<PortfolioMember> listCurProjectSet(PortfolioMemberSearchContext context) {
        List<PortfolioMember> list = baseMapper.listCurProjectSet(context,context.getSelectCond());
        return list;
   }
	
	public List<PortfolioMember> findByPortfolioId(List<String> portfolioIds){
        List<PortfolioMember> list = baseMapper.findByPortfolioId(portfolioIds);
        return list;	
	}

	public boolean removeByPortfolioId(String portfolioId){
        return this.remove(Wrappers.<PortfolioMember>lambdaQuery().eq(PortfolioMember::getPortfolioId,portfolioId));
	}

	public boolean resetByPortfolioId(String portfolioId){
		return this.update(Wrappers.<PortfolioMember>lambdaUpdate().eq(PortfolioMember::getPortfolioId,portfolioId));
	}
	public boolean saveByPortfolio(Portfolio portfolio, List<PortfolioMember> list){
        if(list==null)
            return true;
        Map<String,PortfolioMember> before = findByPortfolioId(portfolio.getId()).stream().collect(Collectors.toMap(PortfolioMember::getId,e->e));

        List<PortfolioMember> update = new ArrayList<>();
        List<PortfolioMember> create = new ArrayList<>();

        for(PortfolioMember sub:list) {
            sub.setPortfolioId(portfolio.getId());
            sub.setPortfolio(portfolio);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<PortfolioMember> findByUserId(List<String> userIds){
        List<PortfolioMember> list = baseMapper.findByUserId(userIds);
        return list;	
	}

	public boolean removeByUserId(String userId){
        return this.remove(Wrappers.<PortfolioMember>lambdaQuery().eq(PortfolioMember::getUserId,userId));
	}

	public boolean resetByUserId(String userId){
		return this.update(Wrappers.<PortfolioMember>lambdaUpdate().eq(PortfolioMember::getUserId,userId));
	}
	public boolean saveByUser(User user, List<PortfolioMember> list){
        if(list==null)
            return true;
        Map<String,PortfolioMember> before = findByUserId(user.getId()).stream().collect(Collectors.toMap(PortfolioMember::getId,e->e));

        List<PortfolioMember> update = new ArrayList<>();
        List<PortfolioMember> create = new ArrayList<>();

        for(PortfolioMember sub:list) {
            sub.setUserId(user.getId());
            sub.setUser(user);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}

    public void fillParentData(PortfolioMember et) {
        if(Entities.PORTFOLIO.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPortfolioId((String)et.getContextParentKey());
            Portfolio portfolio = et.getPortfolio();
            if(portfolio == null) {
                portfolio = portfolioService.getById(et.getPortfolioId());
                et.setPortfolio(portfolio);
            }
            if(!ObjectUtils.isEmpty(portfolio)) {
                et.setPortfolioName(portfolio.getName());
                et.setPortfolioIdentifier(portfolio.getIdentifier());
                et.setPortfolioId(portfolio.getId());
            }
        }
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
        return PortfolioMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return PortfolioMember.class;
    }

}