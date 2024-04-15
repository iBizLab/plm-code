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

    public Entry get(Entry et) {
        Entry rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ENTRY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Entry> getByEntities(List<Entry> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Entry et) {
        if(Entities.BOARD.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setBoardId((String)et.getContextParentKey());
        }
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
        }
    }

    public Entry getDraft(Entry et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Entry et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Entry>lambdaQuery().eq(Entry::getId, et.getId()))>0)?1:0;
    }

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
    public boolean createBatch(List<Entry> list) {
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
    public boolean updateBatch(List<Entry> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Entry et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Entry> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Entry> before = getByEntities(list).stream().collect(Collectors.toMap(Entry::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Entry et) {
        if(!remove(Wrappers.<Entry>lambdaQuery().eq(Entry::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Entry> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Entry> searchDefault(EntrySearchContext context) {
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

    public List<Entry> findByBoardId(List<String> boardIds) {
        List<Entry> list = baseMapper.findByBoardId(boardIds);
        return list;
    }
    public List<Entry> findByProjectId(List<String> projectIds) {
        List<Entry> list = baseMapper.findByProjectId(projectIds);
        return list;
    }
    public boolean removeByBoardId(String boardId) {
        return this.remove(Wrappers.<Entry>lambdaQuery().eq(Entry::getBoardId,boardId));
    }

    public boolean resetByBoardId(String boardId) {
        return this.update(Wrappers.<Entry>lambdaUpdate().eq(Entry::getBoardId,boardId));
    }

    public boolean saveByBoard(Board board,List<Entry> list) {
        if(list==null)
            return true;
        Map<String,Entry> before = findByBoardId(board.getId()).stream().collect(Collectors.toMap(Entry::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByProjectId(String projectId) {
        return this.remove(Wrappers.<Entry>lambdaQuery().eq(Entry::getProjectId,projectId));
    }

    public boolean resetByProjectId(String projectId) {
        return this.update(Wrappers.<Entry>lambdaUpdate().eq(Entry::getProjectId,projectId));
    }

    public boolean saveByProject(Project project,List<Entry> list) {
        if(list==null)
            return true;
        Map<String,Entry> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(Entry::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
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