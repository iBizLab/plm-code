/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service.impl;

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
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.mapper.ReviewMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.service.GuidelineService;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewRule;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewStage;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewActionRule;

/**
 * 实体[评审] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewService extends ServiceImpl<ReviewMapper,Review> implements ReviewService {

    @Autowired
    @Lazy
    protected GuidelineService guidelineService;

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    @Autowired
    @Lazy
    protected AttachmentService attachmentService;

    @Autowired
    @Lazy
    protected ReviewContentService reviewContentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Review et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByReview(et,et.getAttentions());
        attachmentService.saveByReview(et,et.getAttachments());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Review> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Review et) {
        UpdateWrapper<Review> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByReview(et,et.getAttentions());
        attachmentService.saveByReview(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Review> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Review et) {
        if(!remove(Wrappers.<Review>lambdaQuery().eq(Review::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Review> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Review get(Review et) {
        Review rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.REVIEW.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [附件]
        getAttachments(et);
        return et;
    }	

    public List<Review> get(List<Review> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Review getDraft(Review et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(Review et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Review>lambdaQuery().eq(Review::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(Review et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Review> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Review> before = get(list).stream().collect(Collectors.toMap(Review::getId,e->e));
        List<Review> create = new ArrayList<>();
        List<Review> update = new ArrayList<>();
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
	
   public Page<Review> fetchDefault(ReviewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Review> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Review> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Review> listDefault(ReviewSearchContext context) {
        List<Review> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Review> fetchMyAttention(ReviewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Review> pages=baseMapper.searchMyAttention(context.getPages(),context,context.getSelectCond());
        List<Review> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Review> listMyAttention(ReviewSearchContext context) {
        List<Review> list = baseMapper.listMyAttention(context,context.getSelectCond());
        return list;
   }
	
   public Page<Review> fetchMyReviewed(ReviewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Review> pages=baseMapper.searchMyReviewed(context.getPages(),context,context.getSelectCond());
        List<Review> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Review> listMyReviewed(ReviewSearchContext context) {
        List<Review> list = baseMapper.listMyReviewed(context,context.getSelectCond());
        return list;
   }
	
	public List<Review> findByGuidelineId(List<String> guidelineIds){
        List<Review> list = baseMapper.findByGuidelineId(guidelineIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public boolean removeByGuidelineId(String guidelineId){
        return this.remove(Wrappers.<Review>lambdaQuery().eq(Review::getGuidelineId,guidelineId));
	}

	public boolean resetByGuidelineId(String guidelineId){
		return this.update(Wrappers.<Review>lambdaUpdate().eq(Review::getGuidelineId,guidelineId));
	}
	public boolean saveByGuideline(Guideline guideline, List<Review> list){
        if(list==null)
            return true;
        Map<String,Review> before = findByGuidelineId(guideline.getId()).stream().collect(Collectors.toMap(Review::getId,e->e));

        List<Review> update = new ArrayList<>();
        List<Review> create = new ArrayList<>();

        for(Review sub:list) {
            sub.setGuidelineId(guideline.getId());
            sub.setGuideline(guideline);
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
	public List<Review> findByLibraryId(List<String> libraryIds){
        List<Review> list = baseMapper.findByLibraryId(libraryIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public boolean removeByLibraryId(String libraryId){
        return this.remove(Wrappers.<Review>lambdaQuery().eq(Review::getLibraryId,libraryId));
	}

	public boolean resetByLibraryId(String libraryId){
		return this.update(Wrappers.<Review>lambdaUpdate().eq(Review::getLibraryId,libraryId));
	}
	public boolean saveByLibrary(Library library, List<Review> list){
        if(list==null)
            return true;
        Map<String,Review> before = findByLibraryId(library.getId()).stream().collect(Collectors.toMap(Review::getId,e->e));

        List<Review> update = new ArrayList<>();
        List<Review> create = new ArrayList<>();

        for(Review sub:list) {
            sub.setLibraryId(library.getId());
            sub.setLibrary(library);
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
    public List<Attention> getAttentions(Review et) {
        List<Attention> list = attentionService.findByOwnerId(et.getId());
        et.setAttentions(list);
        return list;
    }
	
	@Override
    public List<Attachment> getAttachments(Review et) {
        List<Attachment> list = attachmentService.findByOwnerId(et.getId());
        et.setAttachments(list);
        return list;
    }
	

    public void fillParentData(Review et) {
        if(Entities.GUIDELINE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setGuidelineId((String)et.getContextParentKey());
        }
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setLibraryId((String)et.getContextParentKey());
            Library library = et.getLibrary();
            if(library == null) {
                library = libraryService.getById(et.getLibraryId());
                et.setLibrary(library);
            }
            if(!ObjectUtils.isEmpty(library)) {
                et.setLibraryIdentifier(library.getIdentifier());
                et.setLibraryId(library.getId());
                et.setLibraryName(library.getName());
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
        return ReviewMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Review.class;
    }

}