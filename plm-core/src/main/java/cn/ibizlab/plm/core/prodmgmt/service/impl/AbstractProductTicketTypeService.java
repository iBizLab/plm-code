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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTicketTypeSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.ProductTicketTypeService;
import cn.ibizlab.plm.core.prodmgmt.mapper.ProductTicketTypeMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.prodmgmt.domain.TicketType;
import cn.ibizlab.plm.core.prodmgmt.service.TicketTypeService;

/**
 * 实体[产品工单类型] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductTicketTypeService extends ServiceImpl<ProductTicketTypeMapper,ProductTicketType> implements ProductTicketTypeService {

    @Autowired
    @Lazy
    protected ProductService productService;

    @Autowired
    @Lazy
    protected TicketTypeService ticketTypeService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ProductTicketType et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ProductTicketType> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ProductTicketType et) {
        UpdateWrapper<ProductTicketType> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ProductTicketType> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ProductTicketType et) {
        if(!remove(Wrappers.<ProductTicketType>lambdaQuery().eq(ProductTicketType::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ProductTicketType> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public ProductTicketType get(ProductTicketType et) {
        ProductTicketType rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PRODUCT_TICKET_TYPE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<ProductTicketType> get(List<ProductTicketType> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ProductTicketType getDraft(ProductTicketType et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(ProductTicketType et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ProductTicketType>lambdaQuery().eq(ProductTicketType::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ProductTicketType et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ProductTicketType> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ProductTicketType> before = get(list).stream().collect(Collectors.toMap(ProductTicketType::getId,e->e));
        List<ProductTicketType> create = new ArrayList<>();
        List<ProductTicketType> update = new ArrayList<>();
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
	
   public Page<ProductTicketType> fetchDefault(ProductTicketTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductTicketType> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ProductTicketType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProductTicketType> listDefault(ProductTicketTypeSearchContext context) {
        List<ProductTicketType> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<ProductTicketType> findByProductId(List<String> productIds){
        List<ProductTicketType> list = baseMapper.findByProductId(productIds);
        return list;	
	}

	public List<ProductTicketType> findByProduct(Product product){
        List<ProductTicketType> list = findByProductId(Arrays.asList(product.getId()));
		return list;
	}
	public boolean removeByProductId(String productId){
        return this.remove(Wrappers.<ProductTicketType>lambdaQuery().eq(ProductTicketType::getProductId,productId));
	}

	public boolean resetByProductId(String productId){
		return this.update(Wrappers.<ProductTicketType>lambdaUpdate().eq(ProductTicketType::getProductId,productId));
	}
	public boolean saveByProduct(Product product, List<ProductTicketType> list){
        if(list==null)
            return true;

        Map<String,ProductTicketType> before = findByProduct(product).stream().collect(Collectors.toMap(ProductTicketType::getId,e->e));
        List<ProductTicketType> update = new ArrayList<>();
        List<ProductTicketType> create = new ArrayList<>();

        for(ProductTicketType sub:list) {
            sub.setProductId(product.getId());
            sub.setProduct(product);
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
	public List<ProductTicketType> findByTicketTypeId(List<String> ticketTypeIds){
        List<ProductTicketType> list = baseMapper.findByTicketTypeId(ticketTypeIds);
        return list;	
	}

	public List<ProductTicketType> findByTicketType(TicketType ticketType){
        List<ProductTicketType> list = findByTicketTypeId(Arrays.asList(ticketType.getId()));
		return list;
	}
	public boolean removeByTicketTypeId(String ticketTypeId){
        return this.remove(Wrappers.<ProductTicketType>lambdaQuery().eq(ProductTicketType::getTicketTypeId,ticketTypeId));
	}

	public boolean resetByTicketTypeId(String ticketTypeId){
		return this.update(Wrappers.<ProductTicketType>lambdaUpdate().eq(ProductTicketType::getTicketTypeId,ticketTypeId));
	}
	public boolean saveByTicketType(TicketType ticketType, List<ProductTicketType> list){
        if(list==null)
            return true;

        Map<String,ProductTicketType> before = findByTicketType(ticketType).stream().collect(Collectors.toMap(ProductTicketType::getId,e->e));
        List<ProductTicketType> update = new ArrayList<>();
        List<ProductTicketType> create = new ArrayList<>();

        for(ProductTicketType sub:list) {
            sub.setTicketTypeId(ticketType.getId());
            sub.setTicketType(ticketType);
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
   public Page<ProductTicketType> fetchView(ProductTicketTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductTicketType> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ProductTicketType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProductTicketType> listView(ProductTicketTypeSearchContext context) {
        List<ProductTicketType> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(ProductTicketType et) {
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProductId((String)et.getContextParentKey());
        }
        if(Entities.TICKET_TYPE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTicketTypeId((String)et.getContextParentKey());
            TicketType ticketType = et.getTicketType();
            if(ticketType == null) {
                ticketType = ticketTypeService.getById(et.getTicketTypeId());
                et.setTicketType(ticketType);
            }
            if(!ObjectUtils.isEmpty(ticketType)) {
                et.setDescription(ticketType.getDescription());
                et.setTicketTypeName(ticketType.getName());
                et.setTicketTypeId(ticketType.getId());
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
        return ProductTicketTypeMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ProductTicketType.class;
    }

}