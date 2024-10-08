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
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.filter.EntrySearchContext;
import cn.ibizlab.plm.core.projmgmt.service.EntryService;
import cn.ibizlab.plm.core.projmgmt.mapper.EntryMapper;
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
 * 实体[看板栏] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractEntryService extends ServiceImpl<EntryMapper,Entry> implements EntryService {

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
    public boolean create(Entry et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Entry> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Entry et) {
        UpdateWrapper<Entry> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Entry> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Entry et) {
        String key = et.getId();
        workItemService.resetByEntryId(key);
        if(!remove(Wrappers.<Entry>lambdaQuery().eq(Entry::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Entry> entities) {
        for (Entry et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public Entry get(Entry et) {
        Entry rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ENTRY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Entry> get(List<Entry> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Entry getDraft(Entry et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Entry et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Entry>lambdaQuery().eq(Entry::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Entry et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Entry> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Entry> before = get(list).stream().collect(Collectors.toMap(Entry::getId,e->e));
        List<Entry> create = new ArrayList<>();
        List<Entry> update = new ArrayList<>();
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
	
   public Page<Entry> fetchDefault(EntrySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOWORDER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Entry> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Entry> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Entry> listDefault(EntrySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOWORDER,ASC");
        List<Entry> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<Entry> findByBoardId(List<String> boardIds){
        List<Entry> list = baseMapper.findByBoardId(boardIds);
        return list;	
	}

	public List<Entry> findByBoard(Board board){
        List<Entry> list = findByBoardId(Arrays.asList(board.getId()));
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
		return this.update(Wrappers.<Entry>lambdaUpdate().set(Entry::getBoardId, null).eq(Entry::getBoardId,boardId));
	}
	public boolean saveByBoard(Board board, List<Entry> list){
        if(list==null)
            return true;

        Map<String,Entry> before = findByBoard(board).stream().collect(Collectors.toMap(Entry::getId,e->e));
        List<Entry> update = new ArrayList<>();
        List<Entry> create = new ArrayList<>();

        for(Entry sub:list) {
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
	public List<Entry> findByProjectId(List<String> projectIds){
        List<Entry> list = baseMapper.findByProjectId(projectIds);
        return list;	
	}

	public List<Entry> findByProject(Project project){
        List<Entry> list = findByProjectId(Arrays.asList(project.getId()));
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
		return this.update(Wrappers.<Entry>lambdaUpdate().set(Entry::getProjectId, null).eq(Entry::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<Entry> list){
        if(list==null)
            return true;

        Map<String,Entry> before = findByProject(project).stream().collect(Collectors.toMap(Entry::getId,e->e));
        List<Entry> update = new ArrayList<>();
        List<Entry> create = new ArrayList<>();

        for(Entry sub:list) {
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
   public Page<Entry> fetchView(EntrySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Entry> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Entry> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Entry> listView(EntrySearchContext context) {
        List<Entry> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Entry et) {
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
        return EntryMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Entry.class;
    }

}