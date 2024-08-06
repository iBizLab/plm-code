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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTag;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTagSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.ProductTagService;
import cn.ibizlab.plm.core.prodmgmt.mapper.ProductTagMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;

/**
 * 实体[产品标签] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductTagService extends ServiceImpl<ProductTagMapper,ProductTag> implements ProductTagService {

    @Autowired
    @Lazy
    protected ProductService productService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ProductTag et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ProductTag> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ProductTag et) {
        UpdateWrapper<ProductTag> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ProductTag> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ProductTag et) {
        if(!remove(Wrappers.<ProductTag>lambdaQuery().eq(ProductTag::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ProductTag> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public ProductTag get(ProductTag et) {
        ProductTag rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PRODUCT_TAG.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<ProductTag> get(List<ProductTag> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ProductTag getDraft(ProductTag et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(ProductTag et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ProductTag>lambdaQuery().eq(ProductTag::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ProductTag et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ProductTag> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ProductTag> before = get(list).stream().collect(Collectors.toMap(ProductTag::getId,e->e));
        List<ProductTag> create = new ArrayList<>();
        List<ProductTag> update = new ArrayList<>();
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
	
   public Page<ProductTag> fetchDefault(ProductTagSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductTag> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ProductTag> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProductTag> listDefault(ProductTagSearchContext context) {
        List<ProductTag> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<ProductTag> fetchCurProductTag(ProductTagSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductTag> pages=baseMapper.searchCurProductTag(context.getPages(),context,context.getSelectCond());
        List<ProductTag> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProductTag> listCurProductTag(ProductTagSearchContext context) {
        List<ProductTag> list = baseMapper.listCurProductTag(context,context.getSelectCond());
        return list;
   }
	
	public List<ProductTag> findByProductId(List<String> productIds){
        List<ProductTag> list = baseMapper.findByProductId(productIds);
        return list;	
	}

	public List<ProductTag> findByProduct(Product product){
        List<ProductTag> list = findByProductId(Arrays.asList(product.getId()));
		return list;
	}
	public boolean removeByProductId(String productId){
        return this.remove(Wrappers.<ProductTag>lambdaQuery().eq(ProductTag::getProductId,productId));
	}

	public boolean resetByProductId(String productId){
		return this.update(Wrappers.<ProductTag>lambdaUpdate().eq(ProductTag::getProductId,productId));
	}
	public boolean saveByProduct(Product product, List<ProductTag> list){
        if(list==null)
            return true;

        Map<String,ProductTag> before = findByProduct(product).stream().collect(Collectors.toMap(ProductTag::getId,e->e));
        List<ProductTag> update = new ArrayList<>();
        List<ProductTag> create = new ArrayList<>();

        for(ProductTag sub:list) {
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
   public Page<ProductTag> fetchView(ProductTagSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductTag> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ProductTag> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProductTag> listView(ProductTagSearchContext context) {
        List<ProductTag> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(ProductTag et) {
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProductId((String)et.getContextParentKey());
            Product product = et.getProduct();
            if(product == null) {
                product = productService.getById(et.getProductId());
                et.setProduct(product);
            }
            if(!ObjectUtils.isEmpty(product)) {
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
        return ProductTagMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ProductTag.class;
    }

}