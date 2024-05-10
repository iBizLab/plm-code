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
import cn.hutool.core.convert.Convert;
import cn.ibizlab.util.enums.FlowEventType;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentService;

/**
 * 实体[评审] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewService extends ServiceImpl<ReviewMapper,Review> implements ReviewService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

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

    public Review get(Review et) {
        Review rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.REVIEW.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [附件]
        getAttachments(et);
        //设置 [评审内容]
        getContents(et);
        return et;
    }

    public List<Review> getByEntities(List<Review> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Review et) {
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

    public Review getDraft(Review et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Review et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Review>lambdaQuery().eq(Review::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Review et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByReview(et,et.getAttentions());
        attachmentService.saveByReview(et,et.getAttachments());
        reviewContentService.saveByReview(et,et.getContents());
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Review> list) {
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
        reviewContentService.saveByReview(et,et.getContents());
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Review> list) {
        updateBatchById(list, batchSize);
        return true;
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
    public boolean saveBatch(List<Review> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Review> before = getByEntities(list).stream().collect(Collectors.toMap(Review::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Review et) {
        if(!remove(Wrappers.<Review>lambdaQuery().eq(Review::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Review> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Review> searchDefault(ReviewSearchContext context) {
        Map<String,Map<String,Object>> businesskeys = fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Review> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        if(!ObjectUtils.isEmpty(context.getSrfWF()))
            fillWFParam(pages,businesskeys);
        List<Review> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Review> listDefault(ReviewSearchContext context) {
        List<Review> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<Review> findByLibraryId(List<String> libraryIds) {
        List<Review> list = baseMapper.findByLibraryId(libraryIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            reviewContentService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setContents(sub.getValue())));
        return list;
    }
    public boolean removeByLibraryId(String libraryId) {
        return this.remove(Wrappers.<Review>lambdaQuery().eq(Review::getLibraryId,libraryId));
    }

    public boolean resetByLibraryId(String libraryId) {
        return this.update(Wrappers.<Review>lambdaUpdate().eq(Review::getLibraryId,libraryId));
    }

    public boolean saveByLibrary(Library library,List<Review> list) {
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
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

    @Override
    public List<ReviewContent> getContents(Review et) {
        List<ReviewContent> list = reviewContentService.findByPrincipalId(et.getId());
        et.setContents(list);
        return list;
    }

    @Autowired
    protected cn.ibizlab.util.client.FlowFeignClient flowFeignClient;

    /**
     * 查询统一工作流待办
     * @param context
     */
    protected Map<String,Map<String,Object>> fillWFTaskContext(ReviewSearchContext context){
        Map<String, Map<String, Object>> businessKeys = null;
        if(!ObjectUtils.isEmpty(context.getSrfWF())){
            businessKeys = flowFeignClient.toDoKeys("ibizplm","review",context.getProcessDefinitionKey(),context.getUserTaskId(),null);
            if(!ObjectUtils.isEmpty(businessKeys)) {
                context.getSelectCond().in("id", businessKeys.keySet());
            }
            else {
                context.getSelectCond().apply("1<>1");
            }
        }
        return businessKeys;
    }

    /**
     * 填充工作流参数
     * @param pages
     * @param businessKeys
     */
    protected void fillWFParam(com.baomidou.mybatisplus.extension.plugins.pagination.Page<Review> pages, Map<String, Map<String, Object>> businessKeys) {
        if (!ObjectUtils.isEmpty(businessKeys)) {
            pages.getRecords().forEach(entity->{
                Object id = entity.getId();
                if (!ObjectUtils.isEmpty(id) && businessKeys.containsKey(id.toString())) {
                    businessKeys.get(id.toString()).entrySet().forEach(entry->{
                        entity.set(entry.getKey(),entry.getValue());
                    });
                }
            });
        }
    }

    @Override
    public boolean onFlowEvent(String eventType, Review et) {
        switch (FlowEventType.valueOf(eventType.toUpperCase())) {
            case PROCESS_STARTED:
                this.getSelf().update(et);
                break;
            case ACTIVITY_STARTED:
                this.getSelf().update(et);
                break;
            case PROCESS_COMPLETED:
                this.getSelf().update(et);
                break;
            case TASK_COMPLETED:
                break;
        }
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
        return ReviewMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Review.class;
    }
}