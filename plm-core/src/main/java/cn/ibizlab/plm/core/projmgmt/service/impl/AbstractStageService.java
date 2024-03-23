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
import cn.ibizlab.plm.core.projmgmt.domain.Version;
import cn.ibizlab.plm.core.projmgmt.service.VersionService;

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
    protected VersionService versionService;

    protected int batchSize = 500;

    public Stage get(Stage et) {
        Stage rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.STAGE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Stage> getByEntities(List<Stage> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Stage et) {
        if(Entities.RELEASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setReleaseId((String)et.getContextParentKey());
        }
        if(Entities.VERSION.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setVersionId((String)et.getContextParentKey());
        }
    }

    public Stage getDraft(Stage et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Stage et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Stage>lambdaQuery().eq(Stage::getId, et.getId()))>0)?1:0;
    }

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
    public boolean createBatch(List<Stage> list) {
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
    public boolean updateBatch(List<Stage> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Stage et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Stage> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Stage> before = getByEntities(list).stream().collect(Collectors.toMap(Stage::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Stage et) {
        if(!remove(Wrappers.<Stage>lambdaQuery().eq(Stage::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Stage> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Stage> searchDefault(StageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Stage> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Stage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Stage> listDefault(StageSearchContext context) {
        List<Stage> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<Stage> findByReleaseId(List<String> releaseIds) {
        List<Stage> list = baseMapper.findByReleaseId(releaseIds);
        return list;
    }
    public List<Stage> findByVersionId(List<String> versionIds) {
        List<Stage> list = baseMapper.findByVersionId(versionIds);
        return list;
    }
    public boolean removeByReleaseId(String releaseId) {
        return this.remove(Wrappers.<Stage>lambdaQuery().eq(Stage::getReleaseId,releaseId));
    }

    public boolean resetByReleaseId(String releaseId) {
        return this.update(Wrappers.<Stage>lambdaUpdate().eq(Stage::getReleaseId,releaseId));
    }

    public boolean saveByRelease(Release release,List<Stage> list) {
        if(list==null)
            return true;
        Map<String,Stage> before = findByReleaseId(release.getId()).stream().collect(Collectors.toMap(Stage::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByVersionId(String versionId) {
        return this.remove(Wrappers.<Stage>lambdaQuery().eq(Stage::getVersionId,versionId));
    }

    public boolean resetByVersionId(String versionId) {
        return this.update(Wrappers.<Stage>lambdaUpdate().eq(Stage::getVersionId,versionId));
    }

    public boolean saveByVersion(Version version,List<Stage> list) {
        if(list==null)
            return true;
        Map<String,Stage> before = findByVersionId(version.getId()).stream().collect(Collectors.toMap(Stage::getId,e->e));
        List<Stage> update = new ArrayList<>();
        List<Stage> create = new ArrayList<>();

        for(Stage sub:list) {
            sub.setVersionId(version.getId());
            sub.setVersion(version);
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
        return StageMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Stage.class;
    }
}