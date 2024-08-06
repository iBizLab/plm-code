/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service.impl;

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
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.projmgmt.filter.StageSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.StageService;
import cn.ibizlab.plm.core.projmgmt.mapper.StageMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.service.ReleaseService;

/**
 * 实体[发布阶段] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractStageService extends ServiceImpl<StageMapper,Stage> implements StageService {

    @Autowired
    @Lazy
    protected ReleaseService releaseService;

    @Autowired
    @Lazy
    protected StageService stageService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Stage et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Stage> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Stage et) {
        UpdateWrapper<Stage> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Stage> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Stage et) {
        String key = et.getId();
        stageService.removeByPid(key);
        if(!remove(Wrappers.<Stage>lambdaQuery().eq(Stage::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Stage> entities) {
        for (Stage et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public Stage get(Stage et) {
        Stage rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.STAGE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Stage> get(List<Stage> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Stage getDraft(Stage et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Stage et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Stage>lambdaQuery().eq(Stage::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Stage et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Stage> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Stage> before = get(list).stream().collect(Collectors.toMap(Stage::getId,e->e));
        List<Stage> create = new ArrayList<>();
        List<Stage> update = new ArrayList<>();
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
	
   public Page<Stage> fetchDefault(StageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stage> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Stage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stage> listDefault(StageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<Stage> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Stage> fetchCurOwnerSys(StageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stage> pages=baseMapper.searchCurOwnerSys(context.getPages(),context,context.getSelectCond());
        List<Stage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stage> listCurOwnerSys(StageSearchContext context) {
        List<Stage> list = baseMapper.listCurOwnerSys(context,context.getSelectCond());
        return list;
   }
	
   public Page<Stage> fetchCurProject(StageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stage> pages=baseMapper.searchCurProject(context.getPages(),context,context.getSelectCond());
        List<Stage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stage> listCurProject(StageSearchContext context) {
        List<Stage> list = baseMapper.listCurProject(context,context.getSelectCond());
        return list;
   }
	
   public Page<Stage> fetchCurStage(StageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stage> pages=baseMapper.searchCurStage(context.getPages(),context,context.getSelectCond());
        List<Stage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stage> listCurStage(StageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<Stage> list = baseMapper.listCurStage(context,context.getSelectCond());
        return list;
   }
	
   public Page<Stage> fetchOwner(StageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stage> pages=baseMapper.searchOwner(context.getPages(),context,context.getSelectCond());
        List<Stage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stage> listOwner(StageSearchContext context) {
        List<Stage> list = baseMapper.listOwner(context,context.getSelectCond());
        return list;
   }
	
   public Page<Stage> fetchSystem(StageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stage> pages=baseMapper.searchSystem(context.getPages(),context,context.getSelectCond());
        List<Stage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stage> listSystem(StageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<Stage> list = baseMapper.listSystem(context,context.getSelectCond());
        return list;
   }
	
	public List<Stage> findByReleaseId(List<String> releaseIds){
        List<Stage> list = baseMapper.findByReleaseId(releaseIds);
        return list;	
	}

	public List<Stage> findByRelease(Release release){
        List<Stage> list = findByReleaseId(Arrays.asList(release.getId()));
		return list;
	}
	public boolean removeByReleaseId(String releaseId){
        List<String> ids = baseMapper.findByReleaseId(Arrays.asList(releaseId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetByReleaseId(String releaseId){
		return this.update(Wrappers.<Stage>lambdaUpdate().set(Stage::getReleaseId, null).eq(Stage::getReleaseId,releaseId));
	}
	public boolean saveByRelease(Release release, List<Stage> list){
        if(list==null)
            return true;

        Map<String,Stage> before = findByRelease(release).stream().collect(Collectors.toMap(Stage::getId,e->e));
        List<Stage> update = new ArrayList<>();
        List<Stage> create = new ArrayList<>();

        for(Stage sub:list) {
            sub.setReleaseId(release.getId());
            sub.setRelease(release);
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
	public List<Stage> findByPid(List<String> pids){
        List<Stage> list = baseMapper.findByPid(pids);
        return list;	
	}

	public List<Stage> findByStage(Stage stage){
        List<Stage> list = findByPid(Arrays.asList(stage.getId()));
		return list;
	}
	public boolean removeByPid(String pid){
        List<String> ids = baseMapper.findByPid(Arrays.asList(pid)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetByPid(String pid){
		return this.update(Wrappers.<Stage>lambdaUpdate().set(Stage::getPid, null).eq(Stage::getPid,pid));
	}
	public boolean saveByStage(Stage stage, List<Stage> list){
        if(list==null)
            return true;

        Map<String,Stage> before = findByStage(stage).stream().collect(Collectors.toMap(Stage::getId,e->e));
        List<Stage> update = new ArrayList<>();
        List<Stage> create = new ArrayList<>();

        for(Stage sub:list) {
            sub.setPid(stage.getId());
            sub.setStage(stage);
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
   public Page<Stage> fetchView(StageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stage> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Stage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Stage> listView(StageSearchContext context) {
        List<Stage> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Stage et) {
        if(Entities.RELEASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setReleaseId((String)et.getContextParentKey());
        }
        if(Entities.STAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPid((String)et.getContextParentKey());
            Stage stage = et.getStage();
            if(stage == null) {
                stage = stageService.getById(et.getPid());
                et.setStage(stage);
            }
            if(!ObjectUtils.isEmpty(stage)) {
                et.setPColor(stage.getColor());
                et.setPType(stage.getType());
                et.setPSequence(stage.getSequence());
                et.setPid(stage.getId());
                et.setPname(stage.getName());
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
        return StageMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Stage.class;
    }

}