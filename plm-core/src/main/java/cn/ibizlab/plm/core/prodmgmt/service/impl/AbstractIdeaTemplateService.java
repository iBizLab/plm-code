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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaTemplateSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaTemplateService;
import cn.ibizlab.plm.core.prodmgmt.mapper.IdeaTemplateMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.service.CategoryService;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;

/**
 * 实体[需求模板] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractIdeaTemplateService extends ServiceImpl<IdeaTemplateMapper,IdeaTemplate> implements IdeaTemplateService {

    @Autowired
    @Lazy
    protected CategoryService categoryService;

    @Autowired
    @Lazy
    protected ProductService productService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(IdeaTemplate et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<IdeaTemplate> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(IdeaTemplate et) {
        UpdateWrapper<IdeaTemplate> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<IdeaTemplate> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(IdeaTemplate et) {
        if(!remove(Wrappers.<IdeaTemplate>lambdaQuery().eq(IdeaTemplate::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<IdeaTemplate> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public IdeaTemplate get(IdeaTemplate et) {
        IdeaTemplate rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.IDEA_TEMPLATE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<IdeaTemplate> get(List<IdeaTemplate> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public IdeaTemplate getDraft(IdeaTemplate et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(IdeaTemplate et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<IdeaTemplate>lambdaQuery().eq(IdeaTemplate::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(IdeaTemplate et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<IdeaTemplate> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,IdeaTemplate> before = get(list).stream().collect(Collectors.toMap(IdeaTemplate::getId,e->e));
        List<IdeaTemplate> create = new ArrayList<>();
        List<IdeaTemplate> update = new ArrayList<>();
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
	
   public Page<IdeaTemplate> fetchDefault(IdeaTemplateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<IdeaTemplate> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<IdeaTemplate> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<IdeaTemplate> listDefault(IdeaTemplateSearchContext context) {
        List<IdeaTemplate> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<IdeaTemplate> findByCategoryId(List<String> categoryIds){
        List<IdeaTemplate> list = baseMapper.findByCategoryId(categoryIds);
        return list;	
	}

	public List<IdeaTemplate> findByCategory(Category category){
        List<IdeaTemplate> list = findByCategoryId(Arrays.asList(category.getId()));
		return list;
	}
	public boolean removeByCategoryId(String categoryId){
        return this.remove(Wrappers.<IdeaTemplate>lambdaQuery().eq(IdeaTemplate::getCategoryId,categoryId));
	}

	public boolean resetByCategoryId(String categoryId){
		return this.update(Wrappers.<IdeaTemplate>lambdaUpdate().set(IdeaTemplate::getCategoryId, null).eq(IdeaTemplate::getCategoryId,categoryId));
	}
	public boolean saveByCategory(Category category, List<IdeaTemplate> list){
        if(list==null)
            return true;

        Map<String,IdeaTemplate> before = findByCategory(category).stream().collect(Collectors.toMap(IdeaTemplate::getId,e->e));
        List<IdeaTemplate> update = new ArrayList<>();
        List<IdeaTemplate> create = new ArrayList<>();

        for(IdeaTemplate sub:list) {
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
	public List<IdeaTemplate> findByProductId(List<String> productIds){
        List<IdeaTemplate> list = baseMapper.findByProductId(productIds);
        return list;	
	}

	public List<IdeaTemplate> findByProduct(Product product){
        List<IdeaTemplate> list = findByProductId(Arrays.asList(product.getId()));
		return list;
	}
	public boolean removeByProductId(String productId){
        return this.remove(Wrappers.<IdeaTemplate>lambdaQuery().eq(IdeaTemplate::getProductId,productId));
	}

	public boolean resetByProductId(String productId){
		return this.update(Wrappers.<IdeaTemplate>lambdaUpdate().set(IdeaTemplate::getProductId, null).eq(IdeaTemplate::getProductId,productId));
	}
	public boolean saveByProduct(Product product, List<IdeaTemplate> list){
        if(list==null)
            return true;

        Map<String,IdeaTemplate> before = findByProduct(product).stream().collect(Collectors.toMap(IdeaTemplate::getId,e->e));
        List<IdeaTemplate> update = new ArrayList<>();
        List<IdeaTemplate> create = new ArrayList<>();

        for(IdeaTemplate sub:list) {
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
   public Page<IdeaTemplate> fetchView(IdeaTemplateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<IdeaTemplate> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<IdeaTemplate> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<IdeaTemplate> listView(IdeaTemplateSearchContext context) {
        List<IdeaTemplate> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(IdeaTemplate et) {
        if(Entities.CATEGORY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setCategoryId((String)et.getContextParentKey());
            Category category = et.getCategory();
            if(category == null) {
                category = categoryService.getById(et.getCategoryId());
                et.setCategory(category);
            }
            if(!ObjectUtils.isEmpty(category)) {
                et.setSectionName(category.getSectionName());
                et.setSectionId(category.getSectionId());
                et.setCategories(category.getCategories());
                et.setCategoryId(category.getId());
                et.setCategoryName(category.getName());
            }
        }
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProductId((String)et.getContextParentKey());
            Product product = et.getProduct();
            if(product == null) {
                product = productService.getById(et.getProductId());
                et.setProduct(product);
            }
            if(!ObjectUtils.isEmpty(product)) {
                et.setProductIdentifier(product.getIdentifier());
                et.setProductId(product.getId());
                et.setProductName(product.getName());
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
        return IdeaTemplateMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return IdeaTemplate.class;
    }

}