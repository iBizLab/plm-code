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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.filter.BoardSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.BoardService;
import cn.ibizlab.plm.core.projmgmt.mapper.BoardMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.service.EntryService;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.service.SwimlaneService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[看板] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBoardService extends ServiceImpl<BoardMapper,Board> implements BoardService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected EntryService entryService;

    @Autowired
    @Lazy
    protected SwimlaneService swimlaneService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Board et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Board> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Board et) {
        UpdateWrapper<Board> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Board> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Board et) {
        String key = et.getId();
        entryService.removeByBoardId(key);
        swimlaneService.removeByBoardId(key);
        workItemService.resetByBoardId(key);
        if(!remove(Wrappers.<Board>lambdaQuery().eq(Board::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Board> entities) {
        for (Board et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public Board get(Board et) {
        Board rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BOARD.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Board> get(List<Board> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Board getDraft(Board et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(Board et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Board>lambdaQuery().eq(Board::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(Board et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Board> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Board> before = get(list).stream().collect(Collectors.toMap(Board::getId,e->e));
        List<Board> create = new ArrayList<>();
        List<Board> update = new ArrayList<>();
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
	
   public Page<Board> fetchDefault(BoardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Board> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Board> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Board> listDefault(BoardSearchContext context) {
        List<Board> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Board> fetchCurBoardUpload(BoardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Board> pages=baseMapper.searchCurBoardUpload(context.getPages(),context,context.getSelectCond());
        List<Board> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Board> listCurBoardUpload(BoardSearchContext context) {
        List<Board> list = baseMapper.listCurBoardUpload(context,context.getSelectCond());
        return list;
   }
	
   public Page<Board> fetchCurProjectBoard(BoardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Board> pages=baseMapper.searchCurProjectBoard(context.getPages(),context,context.getSelectCond());
        List<Board> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Board> listCurProjectBoard(BoardSearchContext context) {
        List<Board> list = baseMapper.listCurProjectBoard(context,context.getSelectCond());
        return list;
   }
	
	public List<Board> findByProjectId(List<String> projectIds){
        List<Board> list = baseMapper.findByProjectId(projectIds);
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
		return this.update(Wrappers.<Board>lambdaUpdate().eq(Board::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<Board> list){
        if(list==null)
            return true;
        Map<String,Board> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(Board::getId,e->e));

        List<Board> update = new ArrayList<>();
        List<Board> create = new ArrayList<>();

        for(Board sub:list) {
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

    public void fillParentData(Board et) {
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
        return BoardMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Board.class;
    }

}