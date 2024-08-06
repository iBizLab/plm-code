/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service.impl;

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
import cn.ibizlab.plm.core.projmgmt.domain.Progress;
import cn.ibizlab.plm.core.projmgmt.filter.ProgressSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.ProgressService;
import cn.ibizlab.plm.core.projmgmt.mapper.ProgressMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;

/**
 * 实体[项目进度] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProgressService extends ServiceImpl<ProgressMapper,Progress> implements ProgressService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Progress et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Progress> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Progress et) {
        UpdateWrapper<Progress> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Progress> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Progress et) {
        if(!remove(Wrappers.<Progress>lambdaQuery().eq(Progress::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Progress> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Progress get(Progress et) {
        Progress rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PROGRESS.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Progress> get(List<Progress> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Progress getDraft(Progress et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Progress et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Progress>lambdaQuery().eq(Progress::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Progress et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Progress> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Progress> before = get(list).stream().collect(Collectors.toMap(Progress::getId,e->e));
        List<Progress> create = new ArrayList<>();
        List<Progress> update = new ArrayList<>();
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
	
   public Page<Progress> fetchDefault(ProgressSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Progress> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Progress> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Progress> listDefault(ProgressSearchContext context) {
        List<Progress> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<Progress> findByProjectId(List<String> projectIds){
        List<Progress> list = baseMapper.findByProjectId(projectIds);
        return list;	
	}

	public List<Progress> findByProject(Project project){
        List<Progress> list = findByProjectId(Arrays.asList(project.getId()));
		return list;
	}
	public boolean removeByProjectId(String projectId){
        return this.remove(Wrappers.<Progress>lambdaQuery().eq(Progress::getProjectId,projectId));
	}

	public boolean resetByProjectId(String projectId){
		return this.update(Wrappers.<Progress>lambdaUpdate().eq(Progress::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<Progress> list){
        if(list==null)
            return true;

        Map<String,Progress> before = findByProject(project).stream().collect(Collectors.toMap(Progress::getId,e->e));
        List<Progress> update = new ArrayList<>();
        List<Progress> create = new ArrayList<>();

        for(Progress sub:list) {
            sub.setProjectId(project.getId());
            sub.setProject(project);
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
   public Page<Progress> fetchView(ProgressSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Progress> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Progress> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Progress> listView(ProgressSearchContext context) {
        List<Progress> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Progress et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
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
        return ProgressMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Progress.class;
    }

}