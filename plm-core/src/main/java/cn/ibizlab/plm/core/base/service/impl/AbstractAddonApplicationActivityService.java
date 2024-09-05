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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.AddonApplicationActivity;
import cn.ibizlab.plm.core.base.filter.AddonApplicationActivitySearchContext;
import cn.ibizlab.plm.core.base.service.AddonApplicationActivityService;
import cn.ibizlab.plm.core.base.mapper.AddonApplicationActivityMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[应用插件活动] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAddonApplicationActivityService extends ServiceImpl<AddonApplicationActivityMapper,AddonApplicationActivity> implements AddonApplicationActivityService {

    @Autowired
    @Lazy
    protected AddonApplicationActivityService addonApplicationActivityService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(AddonApplicationActivity et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<AddonApplicationActivity> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(AddonApplicationActivity et) {
        UpdateWrapper<AddonApplicationActivity> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<AddonApplicationActivity> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(AddonApplicationActivity et) {
        if(!remove(Wrappers.<AddonApplicationActivity>lambdaQuery().eq(AddonApplicationActivity::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<AddonApplicationActivity> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public AddonApplicationActivity get(AddonApplicationActivity et) {
        AddonApplicationActivity rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ADDON_APPLICATION_ACTIVITY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<AddonApplicationActivity> get(List<AddonApplicationActivity> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public AddonApplicationActivity getDraft(AddonApplicationActivity et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(AddonApplicationActivity et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<AddonApplicationActivity>lambdaQuery().eq(AddonApplicationActivity::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(AddonApplicationActivity et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<AddonApplicationActivity> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,AddonApplicationActivity> before = get(list).stream().collect(Collectors.toMap(AddonApplicationActivity::getId,e->e));
        List<AddonApplicationActivity> create = new ArrayList<>();
        List<AddonApplicationActivity> update = new ArrayList<>();
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
	
   public Page<AddonApplicationActivity> fetchDefault(AddonApplicationActivitySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AddonApplicationActivity> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<AddonApplicationActivity> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AddonApplicationActivity> listDefault(AddonApplicationActivitySearchContext context) {
        List<AddonApplicationActivity> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<AddonApplicationActivity> findByPid(List<String> pids){
        List<AddonApplicationActivity> list = baseMapper.findByPid(pids);
        return list;	
	}

	public List<AddonApplicationActivity> findByAddonApplicationActivity(AddonApplicationActivity addonApplicationActivity){
        List<AddonApplicationActivity> list = findByPid(Arrays.asList(addonApplicationActivity.getId()));
		return list;
	}
	public boolean removeByPid(String pid){
        return this.remove(Wrappers.<AddonApplicationActivity>lambdaQuery().eq(AddonApplicationActivity::getPid,pid));
	}

	public boolean resetByPid(String pid){
		return this.update(Wrappers.<AddonApplicationActivity>lambdaUpdate().set(AddonApplicationActivity::getPid, null).eq(AddonApplicationActivity::getPid,pid));
	}
	public boolean saveByAddonApplicationActivity(AddonApplicationActivity addonApplicationActivity, List<AddonApplicationActivity> list){
        if(list==null)
            return true;

        Map<String,AddonApplicationActivity> before = findByAddonApplicationActivity(addonApplicationActivity).stream().collect(Collectors.toMap(AddonApplicationActivity::getId,e->e));
        List<AddonApplicationActivity> update = new ArrayList<>();
        List<AddonApplicationActivity> create = new ArrayList<>();

        for(AddonApplicationActivity sub:list) {
            sub.setPid(addonApplicationActivity.getId());
            sub.setAddonApplicationActivity(addonApplicationActivity);
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
   public Page<AddonApplicationActivity> fetchView(AddonApplicationActivitySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AddonApplicationActivity> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<AddonApplicationActivity> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<AddonApplicationActivity> listView(AddonApplicationActivitySearchContext context) {
        List<AddonApplicationActivity> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(AddonApplicationActivity et) {
        if(Entities.ADDON_APPLICATION_ACTIVITY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPid((String)et.getContextParentKey());
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
        return AddonApplicationActivityMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return AddonApplicationActivity.class;
    }

}