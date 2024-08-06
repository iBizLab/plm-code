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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.filter.VersionSearchContext;
import cn.ibizlab.plm.core.base.service.VersionService;
import cn.ibizlab.plm.core.base.mapper.VersionMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.prodmgmt.service.BaselineIdeaService;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.wiki.service.BaselinePageService;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.testmgmt.service.BaselineTestCaseService;
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.projmgmt.service.BaselineWorkItemService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentService;

/**
 * 实体[版本] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractVersionService extends ServiceImpl<VersionMapper,Version> implements VersionService {

    @Autowired
    @Lazy
    protected IdeaService ideaService;

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    @Autowired
    @Lazy
    protected BaselineIdeaService baselineIdeaService;

    @Autowired
    @Lazy
    protected BaselinePageService baselinePageService;

    @Autowired
    @Lazy
    protected BaselineTestCaseService baselineTestCaseService;

    @Autowired
    @Lazy
    protected BaselineWorkItemService baselineWorkItemService;

    @Autowired
    @Lazy
    protected ReviewContentService reviewContentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Version et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Version> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Version et) {
        UpdateWrapper<Version> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Version> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Version et) {
        if(!remove(Wrappers.<Version>lambdaQuery().eq(Version::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Version> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Version get(Version et) {
        Version rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.VERSION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Version> get(List<Version> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Version getDraft(Version et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Version et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Version>lambdaQuery().eq(Version::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Version et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Version> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Version> before = get(list).stream().collect(Collectors.toMap(Version::getId,e->e));
        List<Version> create = new ArrayList<>();
        List<Version> update = new ArrayList<>();
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
	
   public Page<Version> fetchDefault(VersionSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Version> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Version> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Version> listDefault(VersionSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Version> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Version> fetchNameVersion(VersionSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Version> pages=baseMapper.searchNameVersion(context.getPages(),context,context.getSelectCond());
        List<Version> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Version> listNameVersion(VersionSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<Version> list = baseMapper.listNameVersion(context,context.getSelectCond());
        return list;
   }
	
   public Page<Version> fetchOwner(VersionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Version> pages=baseMapper.searchOwner(context.getPages(),context,context.getSelectCond());
        List<Version> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Version> listOwner(VersionSearchContext context) {
        List<Version> list = baseMapper.listOwner(context,context.getSelectCond());
        return list;
   }
	
	public List<Version> findByOwnerId(List<String> ownerIds){
        List<Version> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Version> findByIdea(Idea idea){
        List<Version> list = findByOwnerId(Arrays.asList(idea.getId()));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Version>lambdaQuery().eq(Version::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Version>lambdaUpdate().eq(Version::getOwnerId,ownerId));
	}
	public boolean saveByIdea(Idea idea, List<Version> list){
        if(list==null)
            return true;

        Map<String,Version> before = findByIdea(idea).stream().collect(Collectors.toMap(Version::getId,e->e));
        List<Version> update = new ArrayList<>();
        List<Version> create = new ArrayList<>();

        for(Version sub:list) {
            sub.setOwnerId(idea.getId());
            sub.setIdea(idea);
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
	public List<Version> findByPage(ArticlePage articlePage){
        List<Version> list = findByOwnerId(Arrays.asList(articlePage.getId()));
		return list;
	}
	public boolean saveByPage(ArticlePage articlePage, List<Version> list){
        if(list==null)
            return true;

        Map<String,Version> before = findByPage(articlePage).stream().collect(Collectors.toMap(Version::getId,e->e));
        List<Version> update = new ArrayList<>();
        List<Version> create = new ArrayList<>();

        for(Version sub:list) {
            sub.setOwnerId(articlePage.getId());
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Version> findByTestCase(TestCase testCase){
        List<Version> list = findByOwnerId(Arrays.asList(testCase.getId()));
		return list;
	}
	public boolean saveByTestCase(TestCase testCase, List<Version> list){
        if(list==null)
            return true;

        Map<String,Version> before = findByTestCase(testCase).stream().collect(Collectors.toMap(Version::getId,e->e));
        List<Version> update = new ArrayList<>();
        List<Version> create = new ArrayList<>();

        for(Version sub:list) {
            sub.setOwnerId(testCase.getId());
            sub.setTestCase(testCase);
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
	public List<Version> findByWorkItem(WorkItem workItem){
        List<Version> list = findByOwnerId(Arrays.asList(workItem.getId()));
		return list;
	}
	public boolean saveByWorkItem(WorkItem workItem, List<Version> list){
        if(list==null)
            return true;

        Map<String,Version> before = findByWorkItem(workItem).stream().collect(Collectors.toMap(Version::getId,e->e));
        List<Version> update = new ArrayList<>();
        List<Version> create = new ArrayList<>();

        for(Version sub:list) {
            sub.setOwnerId(workItem.getId());
            sub.setWorkItem(workItem);
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
   public Page<Version> fetchView(VersionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Version> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Version> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Version> listView(VersionSearchContext context) {
        List<Version> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Version et) {
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
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
        return VersionMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Version.class;
    }

}