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
import cn.ibizlab.plm.core.base.domain.AddonRoleMember;
import cn.ibizlab.plm.core.base.filter.AddonRoleMemberSearchContext;
import cn.ibizlab.plm.core.base.service.AddonRoleMemberService;
import cn.ibizlab.plm.core.base.mapper.AddonRoleMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.service.AddonService;

/**
 * 实体[组件权限成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAddonRoleMemberService extends ServiceImpl<AddonRoleMemberMapper,AddonRoleMember> implements AddonRoleMemberService {

    @Autowired
    @Lazy
    protected AddonService addonService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(AddonRoleMember et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<AddonRoleMember> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(AddonRoleMember et) {
        UpdateWrapper<AddonRoleMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<AddonRoleMember> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(AddonRoleMember et) {
        if(!remove(Wrappers.<AddonRoleMember>lambdaQuery().eq(AddonRoleMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<AddonRoleMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public AddonRoleMember get(AddonRoleMember et) {
        AddonRoleMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ADDON_ROLE_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<AddonRoleMember> get(List<AddonRoleMember> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public AddonRoleMember getDraft(AddonRoleMember et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(AddonRoleMember et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<AddonRoleMember>lambdaQuery().eq(AddonRoleMember::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(AddonRoleMember et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<AddonRoleMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,AddonRoleMember> before = get(list).stream().collect(Collectors.toMap(AddonRoleMember::getId,e->e));
        List<AddonRoleMember> create = new ArrayList<>();
        List<AddonRoleMember> update = new ArrayList<>();
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
	
   public Page<AddonRoleMember> fetchDefault(AddonRoleMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AddonRoleMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<AddonRoleMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AddonRoleMember> listDefault(AddonRoleMemberSearchContext context) {
        List<AddonRoleMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<AddonRoleMember> findByAddonId(List<String> addonIds){
        List<AddonRoleMember> list = baseMapper.findByAddonId(addonIds);
        return list;	
	}

	public boolean removeByAddonId(String addonId){
        return this.remove(Wrappers.<AddonRoleMember>lambdaQuery().eq(AddonRoleMember::getAddonId,addonId));
	}

	public boolean resetByAddonId(String addonId){
		return this.update(Wrappers.<AddonRoleMember>lambdaUpdate().eq(AddonRoleMember::getAddonId,addonId));
	}
	public boolean saveByAddon(Addon addon, List<AddonRoleMember> list){
        if(list==null)
            return true;
        Map<String,AddonRoleMember> before = findByAddonId(addon.getId()).stream().collect(Collectors.toMap(AddonRoleMember::getId,e->e));

        List<AddonRoleMember> update = new ArrayList<>();
        List<AddonRoleMember> create = new ArrayList<>();

        for(AddonRoleMember sub:list) {
            sub.setAddonId(addon.getId());
            sub.setAddon(addon);
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

    public void fillParentData(AddonRoleMember et) {
        if(Entities.ADDON.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setAddonId((String)et.getContextParentKey());
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
        return AddonRoleMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return AddonRoleMember.class;
    }

}