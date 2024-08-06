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
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.filter.SwimlaneSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.SwimlaneService;
import cn.ibizlab.plm.core.projmgmt.mapper.SwimlaneMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.service.BoardService;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[泳道] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSwimlaneService extends ServiceImpl<SwimlaneMapper,Swimlane> implements SwimlaneService {

    @Autowired
    @Lazy
    protected BoardService boardService;

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Swimlane et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Swimlane> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Swimlane et) {
        UpdateWrapper<Swimlane> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Swimlane> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Swimlane et) {
        String key = et.getId();
        workItemService.resetBySwimlaneId(key);
        if(!remove(Wrappers.<Swimlane>lambdaQuery().eq(Swimlane::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Swimlane> entities) {
        for (Swimlane et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public Swimlane get(Swimlane et) {
        Swimlane rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SWIMLANE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Swimlane> get(List<Swimlane> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Swimlane getDraft(Swimlane et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Swimlane et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Swimlane>lambdaQuery().eq(Swimlane::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Swimlane et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Swimlane> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Swimlane> before = get(list).stream().collect(Collectors.toMap(Swimlane::getId,e->e));
        List<Swimlane> create = new ArrayList<>();
        List<Swimlane> update = new ArrayList<>();
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
	
   public Page<Swimlane> fetchDefault(SwimlaneSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Swimlane> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Swimlane> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Swimlane> listDefault(SwimlaneSearchContext context) {
        List<Swimlane> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<Swimlane> findByBoardId(List<String> boardIds){
        List<Swimlane> list = baseMapper.findByBoardId(boardIds);
        return list;	
	}

	public List<Swimlane> findByBoard(Board board){
        List<Swimlane> list = findByBoardId(Arrays.asList(board.getId()));
		return list;
	}
	public boolean removeByBoardId(String boardId){
        List<String> ids = baseMapper.findByBoardId(Arrays.asList(boardId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetByBoardId(String boardId){
		return this.update(Wrappers.<Swimlane>lambdaUpdate().eq(Swimlane::getBoardId,boardId));
	}
	public boolean saveByBoard(Board board, List<Swimlane> list){
        if(list==null)
            return true;

        Map<String,Swimlane> before = findByBoard(board).stream().collect(Collectors.toMap(Swimlane::getId,e->e));
        List<Swimlane> update = new ArrayList<>();
        List<Swimlane> create = new ArrayList<>();

        for(Swimlane sub:list) {
            sub.setBoardId(board.getId());
            sub.setBoard(board);
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
	public List<Swimlane> findByProjectId(List<String> projectIds){
        List<Swimlane> list = baseMapper.findByProjectId(projectIds);
        return list;	
	}

	public List<Swimlane> findByProject(Project project){
        List<Swimlane> list = findByProjectId(Arrays.asList(project.getId()));
		return list;
	}
	public boolean removeByProjectId(String projectId){
        List<String> ids = baseMapper.findByProjectId(Arrays.asList(projectId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetByProjectId(String projectId){
		return this.update(Wrappers.<Swimlane>lambdaUpdate().eq(Swimlane::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<Swimlane> list){
        if(list==null)
            return true;

        Map<String,Swimlane> before = findByProject(project).stream().collect(Collectors.toMap(Swimlane::getId,e->e));
        List<Swimlane> update = new ArrayList<>();
        List<Swimlane> create = new ArrayList<>();

        for(Swimlane sub:list) {
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
   public Page<Swimlane> fetchView(SwimlaneSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Swimlane> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Swimlane> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Swimlane> listView(SwimlaneSearchContext context) {
        List<Swimlane> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Swimlane et) {
        if(Entities.BOARD.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setBoardId((String)et.getContextParentKey());
        }
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
        return SwimlaneMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Swimlane.class;
    }

}