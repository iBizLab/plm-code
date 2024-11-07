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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.ProjectMemberService;
import cn.ibizlab.plm.core.projmgmt.mapper.ProjectMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.DayCapacity;

/**
 * 实体[项目成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectMemberService extends ServiceImpl<ProjectMemberMapper,ProjectMember> implements ProjectMemberService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ProjectMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ProjectMember> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ProjectMember et) {
        fillParentData(et);
        UpdateWrapper<ProjectMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ProjectMember> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ProjectMember et) {
        if(!remove(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ProjectMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public ProjectMember get(ProjectMember et) {
        ProjectMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PROJECT_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<ProjectMember> get(List<ProjectMember> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ProjectMember getDraft(ProjectMember et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(ProjectMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ProjectMember et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ProjectMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ProjectMember> before = get(list).stream().collect(Collectors.toMap(ProjectMember::getId,e->e));
        List<ProjectMember> create = new ArrayList<>();
        List<ProjectMember> update = new ArrayList<>();
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
	
   public Page<ProjectMember> fetchDefault(ProjectMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProjectMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ProjectMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProjectMember> listDefault(ProjectMemberSearchContext context) {
        List<ProjectMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<ProjectMember> fetchCurProject(ProjectMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProjectMember> pages=baseMapper.searchCurProject(context.getPages(),context,context.getSelectCond());
        List<ProjectMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProjectMember> listCurProject(ProjectMemberSearchContext context) {
        List<ProjectMember> list = baseMapper.listCurProject(context,context.getSelectCond());
        return list;
   }
	
   public Page<ProjectMember> fetchNoAttention(ProjectMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProjectMember> pages=baseMapper.searchNoAttention(context.getPages(),context,context.getSelectCond());
        List<ProjectMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProjectMember> listNoAttention(ProjectMemberSearchContext context) {
        List<ProjectMember> list = baseMapper.listNoAttention(context,context.getSelectCond());
        return list;
   }
	
	public List<ProjectMember> findByProjectId(List<String> projectIds){
        List<ProjectMember> list = baseMapper.findByProjectId(projectIds);
        return list;	
	}

	public List<ProjectMember> findByProject(Project project){
        List<ProjectMember> list = findByProjectId(Arrays.asList(project.getId()));
		return list;
	}
	public boolean removeByProjectId(String projectId){
        return this.remove(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getProjectId,projectId));
	}

	public boolean resetByProjectId(String projectId){
		return this.update(Wrappers.<ProjectMember>lambdaUpdate().set(ProjectMember::getProjectId, null).eq(ProjectMember::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<ProjectMember> list){
        if(list==null)
            return true;

        Map<String,ProjectMember> before = findByProject(project).stream().collect(Collectors.toMap(ProjectMember::getId,e->e));
        List<ProjectMember> update = new ArrayList<>();
        List<ProjectMember> create = new ArrayList<>();

        for(ProjectMember sub:list) {
            sub.setProjectId(project.getId());
            sub.setProject(project);
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
	public List<ProjectMember> findByUserId(List<String> userIds){
        List<ProjectMember> list = baseMapper.findByUserId(userIds);
        return list;	
	}

	public List<ProjectMember> findByUser(User user){
        List<ProjectMember> list = findByUserId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByUserId(String userId){
        return this.remove(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getUserId,userId));
	}

	public boolean resetByUserId(String userId){
		return this.update(Wrappers.<ProjectMember>lambdaUpdate().set(ProjectMember::getUserId, null).eq(ProjectMember::getUserId,userId));
	}
	public boolean saveByUser(User user, List<ProjectMember> list){
        if(list==null)
            return true;

        Map<String,ProjectMember> before = findByUser(user).stream().collect(Collectors.toMap(ProjectMember::getId,e->e));
        List<ProjectMember> update = new ArrayList<>();
        List<ProjectMember> create = new ArrayList<>();

        for(ProjectMember sub:list) {
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
   public Page<ProjectMember> fetchView(ProjectMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProjectMember> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ProjectMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ProjectMember> listView(ProjectMemberSearchContext context) {
        List<ProjectMember> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(ProjectMember et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
            Project project = et.getProject();
            if(project == null) {
                project = projectService.getById(et.getProjectId());
                et.setProject(project);
            }
            if(!ObjectUtils.isEmpty(project)) {
                et.setProjectName(project.getName());
                et.setProjectIdentifier(project.getIdentifier());
                et.setProjectType(project.getType());
                et.setProjectId(project.getId());
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
        return ProjectMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ProjectMember.class;
    }

}