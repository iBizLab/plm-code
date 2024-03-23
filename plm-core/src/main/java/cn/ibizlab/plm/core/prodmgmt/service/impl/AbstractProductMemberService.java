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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductMemberSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.ProductMemberService;
import cn.ibizlab.plm.core.prodmgmt.mapper.ProductMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 实体[产品成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductMemberService extends ServiceImpl<ProductMemberMapper,ProductMember> implements ProductMemberService {

    @Autowired
    @Lazy
    protected ProductService productService;

    protected int batchSize = 500;

    public ProductMember get(ProductMember et) {
        ProductMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PRODUCT_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<ProductMember> getByEntities(List<ProductMember> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(ProductMember et) {
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProductId((String)et.getContextParentKey());
            Product product = et.getProduct();
            if(product == null) {
                product = productService.getById(et.getProductId());
                et.setProduct(product);
            }
            if(!ObjectUtils.isEmpty(product)) {
                et.setProductName(product.getName());
                et.setProductIdentifier(product.getIdentifier());
                et.setProductId(product.getId());
            }
        }
    }

    public ProductMember getDraft(ProductMember et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(ProductMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ProductMember>lambdaQuery().eq(ProductMember::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(ProductMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<ProductMember> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(ProductMember et) {
        fillParentData(et);
        UpdateWrapper<ProductMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<ProductMember> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(ProductMember et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<ProductMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ProductMember> before = getByEntities(list).stream().collect(Collectors.toMap(ProductMember::getId,e->e));
        List<ProductMember> create = new ArrayList<>();
        List<ProductMember> update = new ArrayList<>();
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(ProductMember et) {
        if(!remove(Wrappers.<ProductMember>lambdaQuery().eq(ProductMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<ProductMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<ProductMember> searchCurProduct(ProductMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductMember> pages=baseMapper.searchCurProduct(context.getPages(),context,context.getSelectCond());
        List<ProductMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<ProductMember> listCurProduct(ProductMemberSearchContext context) {
        List<ProductMember> list = baseMapper.listCurProduct(context,context.getSelectCond());
        return list;
    }

    public Page<ProductMember> searchDefault(ProductMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ProductMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<ProductMember> listDefault(ProductMemberSearchContext context) {
        List<ProductMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<ProductMember> findByProductId(List<String> productIds) {
        List<ProductMember> list = baseMapper.findByProductId(productIds);
        return list;
    }
    public List<ProductMember> findByUserId(List<String> userIds) {
        List<ProductMember> list = baseMapper.findByUserId(userIds);
        return list;
    }
    public boolean removeByProductId(String productId) {
        return this.remove(Wrappers.<ProductMember>lambdaQuery().eq(ProductMember::getProductId,productId));
    }

    public boolean resetByProductId(String productId) {
        return this.update(Wrappers.<ProductMember>lambdaUpdate().eq(ProductMember::getProductId,productId));
    }

    public boolean saveByProduct(Product product,List<ProductMember> list) {
        if(list==null)
            return true;
        Map<String,ProductMember> before = findByProductId(product.getId()).stream().collect(Collectors.toMap(ProductMember::getId,e->e));
        List<ProductMember> update = new ArrayList<>();
        List<ProductMember> create = new ArrayList<>();

        for(ProductMember sub:list) {
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByUserId(String userId) {
        return this.remove(Wrappers.<ProductMember>lambdaQuery().eq(ProductMember::getUserId,userId));
    }

    public boolean resetByUserId(String userId) {
        return this.update(Wrappers.<ProductMember>lambdaUpdate().eq(ProductMember::getUserId,userId));
    }

    public boolean saveByUser(User user,List<ProductMember> list) {
        if(list==null)
            return true;
        Map<String,ProductMember> before = findByUserId(user.getId()).stream().collect(Collectors.toMap(ProductMember::getId,e->e));
        List<ProductMember> update = new ArrayList<>();
        List<ProductMember> create = new ArrayList<>();

        for(ProductMember sub:list) {
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
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
        return ProductMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ProductMember.class;
    }
}