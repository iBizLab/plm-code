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
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.filter.CategorySearchContext;
import cn.ibizlab.plm.core.base.service.CategoryService;
import cn.ibizlab.plm.core.base.mapper.CategoryMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.service.SectionService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaTemplateService;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.service.SpaceService;

/**
 * 实体[类别] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractCategoryService extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

    @Autowired
    @Lazy
    protected SectionService sectionService;

    @Autowired
    @Lazy
    protected IdeaService ideaService;

    @Autowired
    @Lazy
    protected IdeaTemplateService ideaTemplateService;

    @Autowired
    @Lazy
    protected SpaceService spaceService;

    @Autowired
    @Lazy
    protected CategoryService categoryService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Category et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Category> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Category et) {
        UpdateWrapper<Category> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Category> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Category et) {
        String key = et.getId();
        categoryService.resetByPid(key);
        ideaService.resetByCategoryId(key);
        if(!remove(Wrappers.<Category>lambdaQuery().eq(Category::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Category> entities) {
        for (Category et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public Category get(Category et) {
        Category rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.CATEGORY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Category> get(List<Category> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Category getDraft(Category et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(Category et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Category>lambdaQuery().eq(Category::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(Category et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Category> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Category> before = get(list).stream().collect(Collectors.toMap(Category::getId,e->e));
        List<Category> create = new ArrayList<>();
        List<Category> update = new ArrayList<>();
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
	
   public Page<Category> fetchDefault(CategorySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Category> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Category> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Category> listDefault(CategorySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<Category> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Category> fetchCheckName(CategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Category> pages=baseMapper.searchCheckName(context.getPages(),context,context.getSelectCond());
        List<Category> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Category> listCheckName(CategorySearchContext context) {
        List<Category> list = baseMapper.listCheckName(context,context.getSelectCond());
        return list;
   }
	
   public Page<Category> fetchCommonCategories(CategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Category> pages=baseMapper.searchCommonCategories(context.getPages(),context,context.getSelectCond());
        List<Category> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Category> listCommonCategories(CategorySearchContext context) {
        List<Category> list = baseMapper.listCommonCategories(context,context.getSelectCond());
        return list;
   }
	
   public Page<Category> fetchNoSection(CategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Category> pages=baseMapper.searchNoSection(context.getPages(),context,context.getSelectCond());
        List<Category> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Category> listNoSection(CategorySearchContext context) {
        List<Category> list = baseMapper.listNoSection(context,context.getSelectCond());
        return list;
   }
	
   public Page<Category> fetchProductIdeaCategory(CategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Category> pages=baseMapper.searchProductIdeaCategory(context.getPages(),context,context.getSelectCond());
        List<Category> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Category> listProductIdeaCategory(CategorySearchContext context) {
        List<Category> list = baseMapper.listProductIdeaCategory(context,context.getSelectCond());
        return list;
   }
	
   public Page<Category> fetchProductPlan(CategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Category> pages=baseMapper.searchProductPlan(context.getPages(),context,context.getSelectCond());
        List<Category> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Category> listProductPlan(CategorySearchContext context) {
        List<Category> list = baseMapper.listProductPlan(context,context.getSelectCond());
        return list;
   }
	
   public Page<Category> fetchSpaceCategory(CategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Category> pages=baseMapper.searchSpaceCategory(context.getPages(),context,context.getSelectCond());
        List<Category> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Category> listSpaceCategory(CategorySearchContext context) {
        List<Category> list = baseMapper.listSpaceCategory(context,context.getSelectCond());
        return list;
   }
	
   public Page<Category> fetchSpaceCategoryTop(CategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Category> pages=baseMapper.searchSpaceCategoryTop(context.getPages(),context,context.getSelectCond());
        List<Category> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Category> listSpaceCategoryTop(CategorySearchContext context) {
        List<Category> list = baseMapper.listSpaceCategoryTop(context,context.getSelectCond());
        return list;
   }
	
	public List<Category> findByPid(List<String> pids){
        List<Category> list = baseMapper.findByPid(pids);
        return list;	
	}

	public boolean removeByPid(String pid){
        List<String> ids = baseMapper.findByPid(Arrays.asList(pid)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetByPid(String pid){
		return this.update(Wrappers.<Category>lambdaUpdate().eq(Category::getPid,pid));
	}
	public boolean saveByCategory(Category category, List<Category> list){
        if(list==null)
            return true;
        Map<String,Category> before = findByPid(category.getId()).stream().collect(Collectors.toMap(Category::getId,e->e));

        List<Category> update = new ArrayList<>();
        List<Category> create = new ArrayList<>();

        for(Category sub:list) {
            sub.setPid(category.getId());
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Category> findBySectionId(List<String> sectionIds){
        List<Category> list = baseMapper.findBySectionId(sectionIds);
        return list;	
	}

	public boolean removeBySectionId(String sectionId){
        List<String> ids = baseMapper.findBySectionId(Arrays.asList(sectionId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetBySectionId(String sectionId){
		return this.update(Wrappers.<Category>lambdaUpdate().eq(Category::getSectionId,sectionId));
	}
	public boolean saveBySection(Section section, List<Category> list){
        if(list==null)
            return true;
        Map<String,Category> before = findBySectionId(section.getId()).stream().collect(Collectors.toMap(Category::getId,e->e));

        List<Category> update = new ArrayList<>();
        List<Category> create = new ArrayList<>();

        for(Category sub:list) {
            sub.setSectionId(section.getId());
            sub.setSection(section);
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

    public void fillParentData(Category et) {
        if(Entities.CATEGORY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPid((String)et.getContextParentKey());
        }
        if(Entities.SECTION.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSectionId((String)et.getContextParentKey());
            Section section = et.getSection();
            if(section == null) {
                section = sectionService.getById(et.getSectionId());
                et.setSection(section);
            }
            if(!ObjectUtils.isEmpty(section)) {
                et.setSectionId(section.getId());
                et.setSectionName(section.getName());
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
        return CategoryMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Category.class;
    }

}