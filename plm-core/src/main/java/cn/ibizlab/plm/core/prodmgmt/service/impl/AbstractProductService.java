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
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.prodmgmt.mapper.ProductMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Channel;
import cn.ibizlab.plm.core.prodmgmt.service.ChannelService;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.service.CustomerService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaTemplateService;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.service.ProductPlanService;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.service.ProductMemberService;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTag;
import cn.ibizlab.plm.core.prodmgmt.service.ProductTagService;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.service.ProductTicketTypeService;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.service.AddonService;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.service.FavoriteService;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import cn.ibizlab.plm.core.base.service.ReferencesIndexService;

/**
 * 实体[产品] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductService extends ServiceImpl<ProductMapper,Product> implements ProductService {

    @Autowired
    @Lazy
    protected ChannelService channelService;

    @Autowired
    @Lazy
    protected CustomerService customerService;

    @Autowired
    @Lazy
    protected IdeaService ideaService;

    @Autowired
    @Lazy
    protected IdeaTemplateService ideaTemplateService;

    @Autowired
    @Lazy
    protected ProductPlanService productPlanService;

    @Autowired
    @Lazy
    protected ProductMemberService productMemberService;

    @Autowired
    @Lazy
    protected ProductTagService productTagService;

    @Autowired
    @Lazy
    protected ProductTicketTypeService productTicketTypeService;

    @Autowired
    @Lazy
    protected TicketService ticketService;

    @Autowired
    @Lazy
    protected AddonService addonService;

    @Autowired
    @Lazy
    protected BaselineService baselineService;

    @Autowired
    @Lazy
    protected FavoriteService favoriteService;

    @Autowired
    @Lazy
    protected ReferencesIndexService referencesIndexService;

    @Autowired
    @Lazy
    protected cn.ibizlab.plm.core.prodmgmt.mapping.ProductInheritMapping productInheritMapping;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Product et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        productMemberService.saveByProduct(et,et.getMembers());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Product> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }
	
    @Transactional
    public boolean update(Product et) {
        UpdateWrapper<Product> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        productMemberService.saveByProduct(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Product> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }
	
   @Transactional
    public boolean remove(Product et) {
        if(!remove(Wrappers.<Product>lambdaQuery().eq(Product::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Product> entities) {
        for (Product et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public Product get(Product et) {
        Product rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PRODUCT.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [产品成员]
        getMembers(et);
        return et;
    }	

    public List<Product> get(List<Product> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Product getDraft(Product et) {
        return et;
    }
	
    public Integer checkKey(Product et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Product>lambdaQuery().eq(Product::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(Product et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Product> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Product> before = get(list).stream().collect(Collectors.toMap(Product::getId,e->e));
        List<Product> create = new ArrayList<>();
        List<Product> update = new ArrayList<>();
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
	
   public Page<Product> fetchDefault(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listDefault(ProductSearchContext context) {
        List<Product> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchAdmin(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listAdmin(ProductSearchContext context) {
        List<Product> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchArchived(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listArchived(ProductSearchContext context) {
        List<Product> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchDeleted(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listDeleted(ProductSearchContext context) {
        List<Product> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchFavorite(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchFavorite(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listFavorite(ProductSearchContext context) {
        List<Product> list = baseMapper.listFavorite(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchMain(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchMain(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listMain(ProductSearchContext context) {
        List<Product> list = baseMapper.listMain(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchNormal(ProductSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listNormal(ProductSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Product> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchQuickUser(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchQuickUser(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listQuickUser(ProductSearchContext context) {
        List<Product> list = baseMapper.listQuickUser(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchReader(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listReader(ProductSearchContext context) {
        List<Product> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<Product> fetchUser(ProductSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Product> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<Product> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Product> listUser(ProductSearchContext context) {
        List<Product> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
   }
	
	@Override
    public List<ProductMember> getMembers(Product et) {
        List<ProductMember> list = productMemberService.findByProductId(et.getId());
        et.setMembers(list);
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
        return ProductMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Product.class;
    }

}