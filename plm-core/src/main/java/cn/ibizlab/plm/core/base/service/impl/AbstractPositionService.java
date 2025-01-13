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
import cn.ibizlab.plm.core.base.domain.Position;
import cn.ibizlab.plm.core.base.filter.PositionSearchContext;
import cn.ibizlab.plm.core.base.service.PositionService;
import cn.ibizlab.plm.core.base.mapper.PositionMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.service.CategoryService;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.service.MemberService;

/**
 * 实体[职位] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPositionService extends ServiceImpl<PositionMapper,Position> implements PositionService {

    @Autowired
    @Lazy
    protected CategoryService categoryService;

    @Autowired
    @Lazy
    protected MemberService memberService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Position et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Position> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Position et) {
        UpdateWrapper<Position> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Position> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Position et) {
        if(!remove(Wrappers.<Position>lambdaQuery().eq(Position::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Position> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Position get(Position et) {
        Position rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.POSITION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Position> get(List<Position> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Position getDraft(Position et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Position et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Position>lambdaQuery().eq(Position::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Position et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Position> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Position> before = get(list).stream().collect(Collectors.toMap(Position::getId,e->e));
        List<Position> create = new ArrayList<>();
        List<Position> update = new ArrayList<>();
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
	
   public Page<Position> fetchDefault(PositionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Position> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Position> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Position> listDefault(PositionSearchContext context) {
        List<Position> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Position> fetchNoCategory(PositionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Position> pages=baseMapper.searchNoCategory(context.getPages(),context,context.getSelectCond());
        List<Position> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Position> listNoCategory(PositionSearchContext context) {
        List<Position> list = baseMapper.listNoCategory(context,context.getSelectCond());
        return list;
   }
	
	public List<Position> findByCategoryId(List<String> categoryIds){
        List<Position> list = baseMapper.findByCategoryId(categoryIds);
        return list;	
	}

	public List<Position> findByCategory(Category category){
        List<Position> list = findByCategoryId(Arrays.asList(category.getId()));
		return list;
	}
	public boolean removeByCategoryId(String categoryId){
        return this.remove(Wrappers.<Position>lambdaQuery().eq(Position::getCategoryId,categoryId));
	}

	public boolean resetByCategoryId(String categoryId){
		return this.update(Wrappers.<Position>lambdaUpdate().set(Position::getCategoryId, null).eq(Position::getCategoryId,categoryId));
	}
	public boolean saveByCategory(Category category, List<Position> list){
        if(list==null)
            return true;

        Map<String,Position> before = findByCategory(category).stream().collect(Collectors.toMap(Position::getId,e->e));
        List<Position> update = new ArrayList<>();
        List<Position> create = new ArrayList<>();

        for(Position sub:list) {
            sub.setCategoryId(category.getId());
            sub.setCategory(category);
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
   public Page<Position> fetchView(PositionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Position> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Position> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Position> listView(PositionSearchContext context) {
        List<Position> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Position et) {
        if(Entities.CATEGORY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setCategoryId((String)et.getContextParentKey());
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
        return PositionMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Position.class;
    }

}