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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.VersionData;
import cn.ibizlab.plm.core.base.filter.VersionDataSearchContext;
import cn.ibizlab.plm.core.base.service.VersionDataService;
import cn.ibizlab.plm.core.base.mapper.VersionDataMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 实体[附加数据版本] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractVersionDataService extends ServiceImpl<VersionDataMapper,VersionData> implements VersionDataService {

    protected int batchSize = 500;

    public VersionData get(VersionData et) {
        VersionData rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.VERSION_DATA.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<VersionData> getByEntities(List<VersionData> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public VersionData getDraft(VersionData et) {
        return et;
    }

    public Integer checkKey(VersionData et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<VersionData>lambdaQuery().eq(VersionData::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(VersionData et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<VersionData> list) {
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(VersionData et) {
        UpdateWrapper<VersionData> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<VersionData> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(VersionData et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<VersionData> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,VersionData> before = getByEntities(list).stream().collect(Collectors.toMap(VersionData::getId,e->e));
        List<VersionData> create = new ArrayList<>();
        List<VersionData> update = new ArrayList<>();
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
    public boolean remove(VersionData et) {
        if(!remove(Wrappers.<VersionData>lambdaQuery().eq(VersionData::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<VersionData> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<VersionData> searchDefault(VersionDataSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VersionData> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<VersionData> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<VersionData> listDefault(VersionDataSearchContext context) {
        List<VersionData> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
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
        return VersionDataMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return VersionData.class;
    }
}