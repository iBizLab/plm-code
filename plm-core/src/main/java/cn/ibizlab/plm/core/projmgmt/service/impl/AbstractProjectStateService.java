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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectState;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectStateSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.ProjectStateService;
import cn.ibizlab.plm.core.projmgmt.mapper.ProjectStateMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;

/**
 * 实体[项目状态] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectStateService extends ServiceImpl<ProjectStateMapper,ProjectState> implements ProjectStateService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ProjectState et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ProjectState> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ProjectState et) {
        UpdateWrapper<ProjectState> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ProjectState> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ProjectState et) {
        if(!remove(Wrappers.<ProjectState>lambdaQuery().eq(ProjectState::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ProjectState> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public ProjectState get(ProjectState et) {
        ProjectState rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PROJECT_STATE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<ProjectState> get(List<ProjectState> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ProjectState getDraft(ProjectState et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(ProjectState et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ProjectState>lambdaQuery().eq(ProjectState::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ProjectState et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ProjectState> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ProjectState> before = get(list).stream().collect(Collectors.toMap(ProjectState::getId,e->e));
        List<ProjectState> create = new ArrayList<>();
        List<ProjectState> update = new ArrayList<>();
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
	
   public Page<ProjectState> fetchDefault(ProjectStateSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProjectState> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ProjectState> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProjectState> listDefault(ProjectStateSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<ProjectState> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<ProjectState> fetchView(ProjectStateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProjectState> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ProjectState> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProjectState> listView(ProjectStateSearchContext context) {
        List<ProjectState> list = baseMapper.listView(context,context.getSelectCond());
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
        return ProjectStateMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ProjectState.class;
    }

}