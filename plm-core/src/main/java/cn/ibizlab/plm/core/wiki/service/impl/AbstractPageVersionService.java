/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service.impl;

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
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.core.wiki.filter.PageVersionSearchContext;
import cn.ibizlab.plm.core.wiki.service.PageVersionService;
import cn.ibizlab.plm.core.wiki.mapper.PageVersionMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;

/**
 * 实体[页面版本] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPageVersionService extends ServiceImpl<PageVersionMapper,PageVersion> implements PageVersionService {

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    protected int batchSize = 500;

    public PageVersion get(PageVersion et) {
        PageVersion rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PAGE_VERSION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<PageVersion> getByEntities(List<PageVersion> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(PageVersion et) {
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPageId((String)et.getContextParentKey());
        }
    }

    public PageVersion getDraft(PageVersion et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(PageVersion et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<PageVersion>lambdaQuery().eq(PageVersion::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(PageVersion et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<PageVersion> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(PageVersion et) {
        UpdateWrapper<PageVersion> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<PageVersion> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(PageVersion et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<PageVersion> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,PageVersion> before = getByEntities(list).stream().collect(Collectors.toMap(PageVersion::getId,e->e));
        List<PageVersion> create = new ArrayList<>();
        List<PageVersion> update = new ArrayList<>();
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
    public boolean remove(PageVersion et) {
        if(!remove(Wrappers.<PageVersion>lambdaQuery().eq(PageVersion::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<PageVersion> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<PageVersion> searchDefault(PageVersionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PageVersion> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<PageVersion> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<PageVersion> listDefault(PageVersionSearchContext context) {
        List<PageVersion> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<PageVersion> findByPageId(List<String> pageIds) {
        List<PageVersion> list = baseMapper.findByPageId(pageIds);
        return list;
    }
    public boolean removeByPageId(String pageId) {
        return this.remove(Wrappers.<PageVersion>lambdaQuery().eq(PageVersion::getPageId,pageId));
    }

    public boolean resetByPageId(String pageId) {
        return this.update(Wrappers.<PageVersion>lambdaUpdate().eq(PageVersion::getPageId,pageId));
    }

    public boolean saveByPage(ArticlePage articlePage,List<PageVersion> list) {
        if(list==null)
            return true;
        Map<String,PageVersion> before = findByPageId(articlePage.getId()).stream().collect(Collectors.toMap(PageVersion::getId,e->e));
        List<PageVersion> update = new ArrayList<>();
        List<PageVersion> create = new ArrayList<>();

        for(PageVersion sub:list) {
            sub.setPageId(articlePage.getId());
            sub.setPage(articlePage);
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
        return PageVersionMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return PageVersion.class;
    }
}