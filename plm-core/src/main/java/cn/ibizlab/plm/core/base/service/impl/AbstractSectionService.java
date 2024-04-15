/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.filter.SectionSearchContext;
import cn.ibizlab.plm.core.base.service.SectionService;
import cn.ibizlab.plm.core.base.mapper.SectionMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.service.CategoryService;

/**
 * 实体[分组] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSectionService extends ServiceImpl<SectionMapper,Section> implements SectionService {

    @Autowired
    @Lazy
    protected CategoryService categoryService;

    protected int batchSize = 500;

    public Section get(Section et) {
        Section rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SECTION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Section> getByEntities(List<Section> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public Section getDraft(Section et) {
        return et;
    }

    public Integer checkKey(Section et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Section>lambdaQuery().eq(Section::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Section et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Section> list) {
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Section et) {
        UpdateWrapper<Section> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Section> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Section et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Section> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Section> before = getByEntities(list).stream().collect(Collectors.toMap(Section::getId,e->e));
        List<Section> create = new ArrayList<>();
        List<Section> update = new ArrayList<>();
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
    public boolean remove(Section et) {
        String key = et.getId();
        categoryService.removeBySectionId(key);
        if(!remove(Wrappers.<Section>lambdaQuery().eq(Section::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Section> entities) {
        for (Section et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }

    public Page<Section> searchDefault(SectionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Section> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Section> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Section> listDefault(SectionSearchContext context) {
        List<Section> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Section> searchThisProductSection(SectionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Section> pages=baseMapper.searchThisProductSection(context.getPages(),context,context.getSelectCond());
        List<Section> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Section> listThisProductSection(SectionSearchContext context) {
        List<Section> list = baseMapper.listThisProductSection(context,context.getSelectCond());
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
        return SectionMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Section.class;
    }
}