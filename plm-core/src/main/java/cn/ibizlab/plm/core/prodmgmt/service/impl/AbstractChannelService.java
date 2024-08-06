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
import cn.ibizlab.plm.core.prodmgmt.domain.Channel;
import cn.ibizlab.plm.core.prodmgmt.filter.ChannelSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.ChannelService;
import cn.ibizlab.plm.core.prodmgmt.mapper.ChannelMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;

/**
 * 实体[工单渠道] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractChannelService extends ServiceImpl<ChannelMapper,Channel> implements ChannelService {

    @Autowired
    @Lazy
    protected ProductService productService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Channel et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Channel> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Channel et) {
        UpdateWrapper<Channel> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Channel> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Channel et) {
        if(!remove(Wrappers.<Channel>lambdaQuery().eq(Channel::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Channel> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Channel get(Channel et) {
        Channel rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.CHANNEL.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Channel> get(List<Channel> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Channel getDraft(Channel et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Channel et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Channel>lambdaQuery().eq(Channel::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Channel et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Channel> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Channel> before = get(list).stream().collect(Collectors.toMap(Channel::getId,e->e));
        List<Channel> create = new ArrayList<>();
        List<Channel> update = new ArrayList<>();
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
	
   public Page<Channel> fetchDefault(ChannelSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Channel> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Channel> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Channel> listDefault(ChannelSearchContext context) {
        List<Channel> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<Channel> findByProductId(List<String> productIds){
        List<Channel> list = baseMapper.findByProductId(productIds);
        return list;	
	}

	public List<Channel> findByProduct(Product product){
        List<Channel> list = findByProductId(Arrays.asList(product.getId()));
		return list;
	}
	public boolean removeByProductId(String productId){
        return this.remove(Wrappers.<Channel>lambdaQuery().eq(Channel::getProductId,productId));
	}

	public boolean resetByProductId(String productId){
		return this.update(Wrappers.<Channel>lambdaUpdate().eq(Channel::getProductId,productId));
	}
	public boolean saveByProduct(Product product, List<Channel> list){
        if(list==null)
            return true;

        Map<String,Channel> before = findByProduct(product).stream().collect(Collectors.toMap(Channel::getId,e->e));
        List<Channel> update = new ArrayList<>();
        List<Channel> create = new ArrayList<>();

        for(Channel sub:list) {
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
   public Page<Channel> fetchView(ChannelSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Channel> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Channel> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Channel> listView(ChannelSearchContext context) {
        List<Channel> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Channel et) {
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
        return ChannelMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Channel.class;
    }

}