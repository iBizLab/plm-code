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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductPlanSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.ProductPlanService;
import cn.ibizlab.plm.core.prodmgmt.mapper.ProductPlanMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[排期] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductPlanService extends ServiceImpl<ProductPlanMapper,ProductPlan> implements ProductPlanService {

    @Autowired
    @Lazy
    protected ProductService productService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ProductPlan et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ProductPlan> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ProductPlan et) {
        UpdateWrapper<ProductPlan> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ProductPlan> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ProductPlan et) {
        if(!remove(Wrappers.<ProductPlan>lambdaQuery().eq(ProductPlan::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ProductPlan> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public ProductPlan get(ProductPlan et) {
        ProductPlan rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PRODUCT_PLAN.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<ProductPlan> get(List<ProductPlan> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ProductPlan getDraft(ProductPlan et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(ProductPlan et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ProductPlan>lambdaQuery().eq(ProductPlan::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(ProductPlan et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ProductPlan> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ProductPlan> before = get(list).stream().collect(Collectors.toMap(ProductPlan::getId,e->e));
        List<ProductPlan> create = new ArrayList<>();
        List<ProductPlan> update = new ArrayList<>();
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
	
   public Page<ProductPlan> fetchDefault(ProductPlanSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductPlan> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ProductPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProductPlan> listDefault(ProductPlanSearchContext context) {
        List<ProductPlan> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<ProductPlan> fetchNormal(ProductPlanSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductPlan> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<ProductPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProductPlan> listNormal(ProductPlanSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<ProductPlan> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
	public List<ProductPlan> findByProductId(List<String> productIds){
        List<ProductPlan> list = baseMapper.findByProductId(productIds);
        return list;	
	}

	public boolean removeByProductId(String productId){
        return this.remove(Wrappers.<ProductPlan>lambdaQuery().eq(ProductPlan::getProductId,productId));
	}

	public boolean resetByProductId(String productId){
		return this.update(Wrappers.<ProductPlan>lambdaUpdate().eq(ProductPlan::getProductId,productId));
	}
	public boolean saveByProduct(Product product, List<ProductPlan> list){
        if(list==null)
            return true;
        Map<String,ProductPlan> before = findByProductId(product.getId()).stream().collect(Collectors.toMap(ProductPlan::getId,e->e));

        List<ProductPlan> update = new ArrayList<>();
        List<ProductPlan> create = new ArrayList<>();

        for(ProductPlan sub:list) {
            sub.setProductId(product.getId());
            sub.setProduct(product);
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

    public void fillParentData(ProductPlan et) {
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProductId((String)et.getContextParentKey());
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
        return ProductPlanMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ProductPlan.class;
    }

}