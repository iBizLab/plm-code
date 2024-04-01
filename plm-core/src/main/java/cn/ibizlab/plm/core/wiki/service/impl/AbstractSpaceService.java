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
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.filter.SpaceSearchContext;
import cn.ibizlab.plm.core.wiki.service.SpaceService;
import cn.ibizlab.plm.core.wiki.mapper.SpaceMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.service.CategoryService;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.wiki.domain.SpaceMember;
import cn.ibizlab.plm.core.wiki.service.SpaceMemberService;
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.core.wiki.service.StencilService;

/**
 * 实体[空间] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSpaceService extends ServiceImpl<SpaceMapper,Space> implements SpaceService {

    @Autowired
    @Lazy
    protected CategoryService categoryService;

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    @Autowired
    @Lazy
    protected SpaceMemberService spaceMemberService;

    @Autowired
    @Lazy
    protected StencilService stencilService;

    protected int batchSize = 500;

    public Space get(Space et) {
        Space rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SPACE.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [空间成员]
        getMembers(et);
        return et;
    }

    public List<Space> getByEntities(List<Space> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Space et) {
        if(Entities.CATEGORY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setCategoryId((String)et.getContextParentKey());
            Category category = et.getCategory();
            if(category == null) {
                category = categoryService.getById(et.getCategoryId());
                et.setCategory(category);
            }
            if(!ObjectUtils.isEmpty(category)) {
                et.setCategories(category.getCategories());
                et.setCategoryId(category.getId());
                et.setCategoryName(category.getName());
            }
        }
    }

    public Space getDraft(Space et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Space et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Space>lambdaQuery().eq(Space::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Space et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        spaceMemberService.saveBySpace(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Space> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Space et) {
        UpdateWrapper<Space> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        spaceMemberService.saveBySpace(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Space> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Space et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Space> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Space> before = getByEntities(list).stream().collect(Collectors.toMap(Space::getId,e->e));
        List<Space> create = new ArrayList<>();
        List<Space> update = new ArrayList<>();
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
    public boolean remove(Space et) {
        if(!remove(Wrappers.<Space>lambdaQuery().eq(Space::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Space> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Space> searchAdmin(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listAdmin(SpaceSearchContext context) {
        List<Space> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchArchived(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listArchived(SpaceSearchContext context) {
        List<Space> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchCategorySpace(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchCategorySpace(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listCategorySpace(SpaceSearchContext context) {
        List<Space> list = baseMapper.listCategorySpace(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchDefault(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listDefault(SpaceSearchContext context) {
        List<Space> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchDeleted(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listDeleted(SpaceSearchContext context) {
        List<Space> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchFavorite(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchFavorite(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listFavorite(SpaceSearchContext context) {
        List<Space> list = baseMapper.listFavorite(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchNoCategorySpace(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchNoCategorySpace(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listNoCategorySpace(SpaceSearchContext context) {
        List<Space> list = baseMapper.listNoCategorySpace(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchNoReSpace(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchNoReSpace(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listNoReSpace(SpaceSearchContext context) {
        List<Space> list = baseMapper.listNoReSpace(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchNormal(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listNormal(SpaceSearchContext context) {
        List<Space> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchOtherReSpace(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchOtherReSpace(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listOtherReSpace(SpaceSearchContext context) {
        List<Space> list = baseMapper.listOtherReSpace(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchReader(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listReader(SpaceSearchContext context) {
        List<Space> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
    }

    public Page<Space> searchUser(SpaceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Space> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<Space> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Space> listUser(SpaceSearchContext context) {
        List<Space> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
    }

    public List<Space> findByCategoryId(List<String> categoryIds) {
        List<Space> list = baseMapper.findByCategoryId(categoryIds);
        if(!ObjectUtils.isEmpty(list))
            spaceMemberService.findBySpaceId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getSpaceId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setMembers(sub.getValue())));
        return list;
    }
    public boolean removeByCategoryId(String categoryId) {
        return this.remove(Wrappers.<Space>lambdaQuery().eq(Space::getCategoryId,categoryId));
    }

    public boolean resetByCategoryId(String categoryId) {
        return this.update(Wrappers.<Space>lambdaUpdate().eq(Space::getCategoryId,categoryId));
    }

    public boolean saveByCategory(Category category,List<Space> list) {
        if(list==null)
            return true;
        Map<String,Space> before = findByCategoryId(category.getId()).stream().collect(Collectors.toMap(Space::getId,e->e));
        List<Space> update = new ArrayList<>();
        List<Space> create = new ArrayList<>();

        for(Space sub:list) {
            sub.setCategoryId(category.getId());
            sub.setCategory(category);
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
    public List<SpaceMember> getMembers(Space et) {
        List<SpaceMember> list = spaceMemberService.findBySpaceId(et.getId());
        et.setMembers(list);
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
        return SpaceMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Space.class;
    }
}