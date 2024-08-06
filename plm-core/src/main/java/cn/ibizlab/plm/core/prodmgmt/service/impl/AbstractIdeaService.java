/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service.impl;

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
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaSearchContext;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.prodmgmt.mapper.IdeaMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.service.CategoryService;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.service.SearchAttachmentService;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.service.SearchCommentService;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.service.WorkloadService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.service.VersionService;

/**
 * 实体[需求] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractIdeaService extends ServiceImpl<IdeaMapper,Idea> implements IdeaService {

    @Autowired
    @Lazy
    protected CategoryService categoryService;

    @Autowired
    @Lazy
    protected ProductService productService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected CommentService commentService;

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
    protected WorkloadService workloadService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    @Autowired
    @Lazy
    protected VersionService versionService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Idea et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByIdea(et,et.getAttentions());
        attachmentService.saveByIdea(et,et.getAttachments());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Idea> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Idea et) {
        fillParentData(et);
        UpdateWrapper<Idea> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByIdea(et,et.getAttentions());
        attachmentService.saveByIdea(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Idea> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Idea et) {
        if(!remove(Wrappers.<Idea>lambdaQuery().eq(Idea::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Idea> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Idea get(Idea et) {
        Idea rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.IDEA.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [附件]
        getAttachments(et);
        return et;
    }	

    public List<Idea> get(List<Idea> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Idea getDraft(Idea et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Idea et) {
        fillParentData(et);
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Idea>lambdaQuery().eq(Idea::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Idea et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Idea> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Idea> before = get(list).stream().collect(Collectors.toMap(Idea::getId,e->e));
        List<Idea> create = new ArrayList<>();
        List<Idea> update = new ArrayList<>();
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
	
   public Page<Idea> fetchDefault(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listDefault(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchAdvancedSearch(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchAdvancedSearch(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listAdvancedSearch(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listAdvancedSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchArchived(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listArchived(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchBaselineChooseIdea(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchBaselineChooseIdea(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listBaselineChooseIdea(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listBaselineChooseIdea(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchBiDetail(IdeaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchBiDetail(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listBiDetail(IdeaSearchContext context) {
        List<Idea> list = baseMapper.listBiDetail(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchBiSearch(IdeaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchBiSearch(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listBiSearch(IdeaSearchContext context) {
        List<Idea> list = baseMapper.listBiSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchCommentNotifyAssignee(IdeaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchCommentNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listCommentNotifyAssignee(IdeaSearchContext context) {
        List<Idea> list = baseMapper.listCommentNotifyAssignee(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchCommon(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchCommon(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listCommon(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listCommon(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchDeleted(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listDeleted(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchMyAssign(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchMyAssign(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listMyAssign(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listMyAssign(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchMyAssigneeCount(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchMyAssigneeCount(context.getPages(),context,context.getSelectCond());
        return new PageImpl<Idea>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),Idea.class), context.getPageable(), pages.getTotal());
    }

   public List<Idea> listMyAssigneeCount(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listMyAssigneeCount(context,context.getSelectCond()),Idea.class);
   }
	
   public Page<Idea> fetchMyAttention(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchMyAttention(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listMyAttention(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listMyAttention(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchMyCreated(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchMyCreated(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listMyCreated(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listMyCreated(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchNormal(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listNormal(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchNotExsistsRelation(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchNotExsistsRelation(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listNotExsistsRelation(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listNotExsistsRelation(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchNotifyAssignee(IdeaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listNotifyAssignee(IdeaSearchContext context) {
        List<Idea> list = baseMapper.listNotifyAssignee(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchPlanRelationIdea(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchPlanRelationIdea(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listPlanRelationIdea(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listPlanRelationIdea(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchReader(IdeaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listReader(IdeaSearchContext context) {
        List<Idea> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<Idea> fetchRecentIdea(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchRecentIdea(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listRecentIdea(IdeaSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<Idea> list = baseMapper.listRecentIdea(context,context.getSelectCond());
        return list;
   }
	
	public List<Idea> findByCategoryId(List<String> categoryIds){
        List<Idea> list = baseMapper.findByCategoryId(categoryIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<Idea> findByCategory(Category category){
        List<Idea> list = findByCategoryId(Arrays.asList(category.getId()));
		return list;
	}
	public boolean removeByCategoryId(String categoryId){
        return this.remove(Wrappers.<Idea>lambdaQuery().eq(Idea::getCategoryId,categoryId));
	}

	public boolean resetByCategoryId(String categoryId){
		return this.update(Wrappers.<Idea>lambdaUpdate().eq(Idea::getCategoryId,categoryId));
	}
	public boolean saveByCategory(Category category, List<Idea> list){
        if(list==null)
            return true;

        Map<String,Idea> before = findByCategory(category).stream().collect(Collectors.toMap(Idea::getId,e->e));
        List<Idea> update = new ArrayList<>();
        List<Idea> create = new ArrayList<>();

        for(Idea sub:list) {
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Idea> findByProductId(List<String> productIds){
        List<Idea> list = baseMapper.findByProductId(productIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<Idea> findByProduct(Product product){
        List<Idea> list = findByProductId(Arrays.asList(product.getId()));
		return list;
	}
	public boolean removeByProductId(String productId){
        return this.remove(Wrappers.<Idea>lambdaQuery().eq(Idea::getProductId,productId));
	}

	public boolean resetByProductId(String productId){
		return this.update(Wrappers.<Idea>lambdaUpdate().eq(Idea::getProductId,productId));
	}
	public boolean saveByProduct(Product product, List<Idea> list){
        if(list==null)
            return true;

        Map<String,Idea> before = findByProduct(product).stream().collect(Collectors.toMap(Idea::getId,e->e));
        List<Idea> update = new ArrayList<>();
        List<Idea> create = new ArrayList<>();

        for(Idea sub:list) {
            sub.setProductId(product.getId());
            sub.setProduct(product);
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
	public List<Idea> findByAssigneeId(List<String> assigneeIds){
        List<Idea> list = baseMapper.findByAssigneeId(assigneeIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<Idea> findByUser(User user){
        List<Idea> list = findByAssigneeId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByAssigneeId(String assigneeId){
        return this.remove(Wrappers.<Idea>lambdaQuery().eq(Idea::getAssigneeId,assigneeId));
	}

	public boolean resetByAssigneeId(String assigneeId){
		return this.update(Wrappers.<Idea>lambdaUpdate().eq(Idea::getAssigneeId,assigneeId));
	}
	public boolean saveByUser(User user, List<Idea> list){
        if(list==null)
            return true;

        Map<String,Idea> before = findByUser(user).stream().collect(Collectors.toMap(Idea::getId,e->e));
        List<Idea> update = new ArrayList<>();
        List<Idea> create = new ArrayList<>();

        for(Idea sub:list) {
            sub.setAssigneeId(user.getId());
            sub.setUser(user);
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
    public List<Attention> getAttentions(Idea et) {
        List<Attention> list = attentionService.findByIdea(et);
        et.setAttentions(list);
        return list;
    }
	
	@Override
    public List<Attachment> getAttachments(Idea et) {
        List<Attachment> list = attachmentService.findByIdea(et);
        et.setAttachments(list);
        return list;
    }
	
   public Page<Idea> fetchView(IdeaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Idea> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Idea> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Idea> listView(IdeaSearchContext context) {
        List<Idea> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Idea et) {
        if(Entities.CATEGORY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setCategoryId((String)et.getContextParentKey());
            Category category = et.getCategory();
            if(category == null) {
                category = categoryService.getById(et.getCategoryId());
                et.setCategory(category);
            }
            if(!ObjectUtils.isEmpty(category)) {
                et.setSectionName(category.getSectionName());
                et.setSectionId(category.getSectionId());
                et.setCategories(category.getCategories());
                et.setCategoryId(category.getId());
                et.setCategoryName(category.getName());
            }
        }
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProductId((String)et.getContextParentKey());
            Product product = et.getProduct();
            if(product == null) {
                product = productService.getById(et.getProductId());
                et.setProduct(product);
            }
            if(!ObjectUtils.isEmpty(product)) {
                et.setProductIdentifier(product.getIdentifier());
                et.setProductId(product.getId());
                et.setProductName(product.getName());
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
        return IdeaMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Idea.class;
    }

}