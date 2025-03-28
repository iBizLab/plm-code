/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service.impl;

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
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.filter.ArticlePageSearchContext;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.wiki.mapper.ArticlePageMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.service.SpaceService;
import cn.ibizlab.plm.core.wiki.domain.SharedSpace;
import cn.ibizlab.plm.core.wiki.service.SharedSpaceService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.service.MemberService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.service.SearchAttachmentService;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.service.SearchCommentService;
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.core.wiki.service.PageVersionService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.service.VersionService;

/**
 * 实体[页面] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractArticlePageService extends ServiceImpl<ArticlePageMapper,ArticlePage> implements ArticlePageService {

    @Autowired
    @Lazy
    protected SpaceService spaceService;

    @Autowired
    @Lazy
    protected SharedSpaceService sharedSpaceService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected MemberService memberService;

    @Autowired
    @Lazy
    protected AttachmentService attachmentService;

    @Autowired
    @Lazy
    protected SearchAttachmentService searchAttachmentService;

    @Autowired
    @Lazy
    protected SearchCommentService searchCommentService;

    @Autowired
    @Lazy
    protected PageVersionService pageVersionService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    @Autowired
    @Lazy
    protected VersionService versionService;

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ArticlePage et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByPage(et,et.getAttentions());
        attachmentService.saveByPage(et,et.getAttachments());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ArticlePage> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ArticlePage et) {
        UpdateWrapper<ArticlePage> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByPage(et,et.getAttentions());
        attachmentService.saveByPage(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ArticlePage> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ArticlePage et) {
        String key = et.getId();
        articlePageService.resetByParentId(key);
        if(!remove(Wrappers.<ArticlePage>lambdaQuery().eq(ArticlePage::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ArticlePage> entities) {
        for (ArticlePage et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public ArticlePage get(ArticlePage et) {
        ArticlePage rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.ARTICLE_PAGE.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [附件]
        getAttachments(et);
        return et;
    }	

    public List<ArticlePage> get(List<ArticlePage> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ArticlePage getDraft(ArticlePage et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(ArticlePage et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ArticlePage>lambdaQuery().eq(ArticlePage::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ArticlePage et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ArticlePage> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ArticlePage> before = get(list).stream().collect(Collectors.toMap(ArticlePage::getId,e->e));
        List<ArticlePage> create = new ArrayList<>();
        List<ArticlePage> update = new ArrayList<>();
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
	
   public Page<ArticlePage> fetchDefault(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listDefault(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchAdvancedSearch(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchAdvancedSearch(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listAdvancedSearch(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<ArticlePage> list = baseMapper.listAdvancedSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchAllSharedPages(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHARED_TIME,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchAllSharedPages(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listAllSharedPages(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHARED_TIME,ASC");
        List<ArticlePage> list = baseMapper.listAllSharedPages(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchBaselineChoosePage(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchBaselineChoosePage(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listBaselineChoosePage(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listBaselineChoosePage(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchChooseShared(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchChooseShared(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listChooseShared(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listChooseShared(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchDraftPage(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchDraftPage(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listDraftPage(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listDraftPage(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchHomePage(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchHomePage(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listHomePage(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listHomePage(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchIsDeleted(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchIsDeleted(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listIsDeleted(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listIsDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchMyFavoritePage(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchMyFavoritePage(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listMyFavoritePage(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<ArticlePage> list = baseMapper.listMyFavoritePage(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchMyFilter(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchMyFilter(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listMyFilter(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<ArticlePage> list = baseMapper.listMyFilter(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchNoParentPage(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchNoParentPage(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listNoParentPage(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listNoParentPage(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchNormal(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listNormal(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchNormalTreePage(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchNormalTreePage(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listNormalTreePage(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listNormalTreePage(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchOnlyPage(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchOnlyPage(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listOnlyPage(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listOnlyPage(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchReader(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listReader(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchSharedPage(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchSharedPage(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listSharedPage(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listSharedPage(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchSharedReader(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchSharedReader(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listSharedReader(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listSharedReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchSharedSearch(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchSharedSearch(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listSharedSearch(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listSharedSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchSharedSubPages(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchSharedSubPages(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listSharedSubPages(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listSharedSubPages(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchSharedWithMe(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHARED_TIME,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchSharedWithMe(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listSharedWithMe(ArticlePageSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHARED_TIME,ASC");
        List<ArticlePage> list = baseMapper.listSharedWithMe(context,context.getSelectCond());
        return list;
   }
	
   public Page<ArticlePage> fetchSharedWithMeEdit(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchSharedWithMeEdit(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listSharedWithMeEdit(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listSharedWithMeEdit(context,context.getSelectCond());
        return list;
   }
	
	public List<ArticlePage> findByParentId(List<String> parentIds){
        List<ArticlePage> list = baseMapper.findByParentId(parentIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<ArticlePage> findByPage(ArticlePage articlePage){
        List<ArticlePage> list = findByParentId(Arrays.asList(articlePage.getId()));
		return list;
	}
	public boolean removeByParentId(String parentId){
        List<String> ids = baseMapper.findByParentId(Arrays.asList(parentId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetByParentId(String parentId){
		return this.update(Wrappers.<ArticlePage>lambdaUpdate().set(ArticlePage::getParentId, null).eq(ArticlePage::getParentId,parentId));
	}
	public boolean saveByPage(ArticlePage articlePage, List<ArticlePage> list){
        if(list==null)
            return true;

        Map<String,ArticlePage> before = findByPage(articlePage).stream().collect(Collectors.toMap(ArticlePage::getId,e->e));
        List<ArticlePage> update = new ArrayList<>();
        List<ArticlePage> create = new ArrayList<>();

        for(ArticlePage sub:list) {
            sub.setParentId(articlePage.getId());
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
	public List<ArticlePage> findBySpaceId(List<String> spaceIds){
        List<ArticlePage> list = baseMapper.findBySpaceId(spaceIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<ArticlePage> findBySpace(Space space){
        List<ArticlePage> list = findBySpaceId(Arrays.asList(space.getId()));
		return list;
	}
	public boolean removeBySpaceId(String spaceId){
        List<String> ids = baseMapper.findBySpaceId(Arrays.asList(spaceId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetBySpaceId(String spaceId){
		return this.update(Wrappers.<ArticlePage>lambdaUpdate().set(ArticlePage::getSpaceId, null).eq(ArticlePage::getSpaceId,spaceId));
	}
	public boolean saveBySpace(Space space, List<ArticlePage> list){
        if(list==null)
            return true;

        Map<String,ArticlePage> before = findBySpace(space).stream().collect(Collectors.toMap(ArticlePage::getId,e->e));
        List<ArticlePage> update = new ArrayList<>();
        List<ArticlePage> create = new ArrayList<>();

        for(ArticlePage sub:list) {
            sub.setSpaceId(space.getId());
            sub.setSpace(space);
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
	public List<ArticlePage> findBySharedSpacePage(SharedSpace sharedSpace){
        List<ArticlePage> list = findBySpaceId(Arrays.asList(sharedSpace.getId()));
		return list;
	}
	public boolean saveBySharedSpacePage(SharedSpace sharedSpace, List<ArticlePage> list){
        if(list==null)
            return true;

        Map<String,ArticlePage> before = findBySharedSpacePage(sharedSpace).stream().collect(Collectors.toMap(ArticlePage::getId,e->e));
        List<ArticlePage> update = new ArrayList<>();
        List<ArticlePage> create = new ArrayList<>();

        for(ArticlePage sub:list) {
            sub.setSpaceId(sharedSpace.getId());
            sub.setSharedSpacePage(sharedSpace);
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
	@Override
    public List<Attention> getAttentions(ArticlePage et) {
        List<Attention> list = attentionService.findByPage(et);
        et.setAttentions(list);
        return list;
    }
	
	@Override
    public List<Attachment> getAttachments(ArticlePage et) {
        List<Attachment> list = attachmentService.findByPage(et);
        et.setAttachments(list);
        return list;
    }
	
   public Page<ArticlePage> fetchView(ArticlePageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ArticlePage> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ArticlePage> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ArticlePage> listView(ArticlePageSearchContext context) {
        List<ArticlePage> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(ArticlePage et) {
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setParentId((String)et.getContextParentKey());
        }
        if(Entities.SPACE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSpaceId((String)et.getContextParentKey());
            Space space = et.getSpace();
            if(space == null) {
                space = spaceService.getById(et.getSpaceId());
                et.setSpace(space);
            }
            if(!ObjectUtils.isEmpty(space)) {
                et.setSpaceIdentifier(space.getIdentifier());
                et.setSpaceId(space.getId());
                et.setSpaceName(space.getName());
            }
        }
        if(Entities.SHARED_SPACE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSpaceId((String)et.getContextParentKey());
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
        return ArticlePageMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ArticlePage.class;
    }

}