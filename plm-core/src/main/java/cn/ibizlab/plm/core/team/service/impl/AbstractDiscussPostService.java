/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service.impl;

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
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.filter.DiscussPostSearchContext;
import cn.ibizlab.plm.core.team.service.DiscussPostService;
import cn.ibizlab.plm.core.team.mapper.DiscussPostMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.team.service.DiscussTopicService;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.team.service.DiscussReplyService;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;

/**
 * 实体[讨论] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDiscussPostService extends ServiceImpl<DiscussPostMapper,DiscussPost> implements DiscussPostService {

    @Autowired
    @Lazy
    protected DiscussTopicService discussTopicService;

    @Autowired
    @Lazy
    protected DiscussReplyService discussReplyService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    @Autowired
    @Lazy
    protected AttachmentService attachmentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DiscussPost et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByDiscussPost(et,et.getAttentions());
        commentService.saveByDiscussPost(et,et.getComments());
        attachmentService.saveByDiscussPost(et,et.getAttachments());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<DiscussPost> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(DiscussPost et) {
        UpdateWrapper<DiscussPost> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByDiscussPost(et,et.getAttentions());
        commentService.saveByDiscussPost(et,et.getComments());
        attachmentService.saveByDiscussPost(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<DiscussPost> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(DiscussPost et) {
        if(!remove(Wrappers.<DiscussPost>lambdaQuery().eq(DiscussPost::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<DiscussPost> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public DiscussPost get(DiscussPost et) {
        DiscussPost rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DISCUSS_POST.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [评论]
        getComments(et);
        //设置 [附件]
        getAttachments(et);
        return et;
    }	

    public List<DiscussPost> get(List<DiscussPost> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public DiscussPost getDraft(DiscussPost et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(DiscussPost et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<DiscussPost>lambdaQuery().eq(DiscussPost::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(DiscussPost et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<DiscussPost> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,DiscussPost> before = get(list).stream().collect(Collectors.toMap(DiscussPost::getId,e->e));
        List<DiscussPost> create = new ArrayList<>();
        List<DiscussPost> update = new ArrayList<>();
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
	
   public Page<DiscussPost> fetchDefault(DiscussPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussPost> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<DiscussPost> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussPost> listDefault(DiscussPostSearchContext context) {
        List<DiscussPost> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussPost> fetchDeleted(DiscussPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussPost> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<DiscussPost> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussPost> listDeleted(DiscussPostSearchContext context) {
        List<DiscussPost> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussPost> fetchMyAttention(DiscussPostSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussPost> pages=baseMapper.searchMyAttention(context.getPages(),context,context.getSelectCond());
        List<DiscussPost> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussPost> listMyAttention(DiscussPostSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussPost> list = baseMapper.listMyAttention(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussPost> fetchMyCreate(DiscussPostSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussPost> pages=baseMapper.searchMyCreate(context.getPages(),context,context.getSelectCond());
        List<DiscussPost> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussPost> listMyCreate(DiscussPostSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussPost> list = baseMapper.listMyCreate(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussPost> fetchMyReply(DiscussPostSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussPost> pages=baseMapper.searchMyReply(context.getPages(),context,context.getSelectCond());
        List<DiscussPost> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussPost> listMyReply(DiscussPostSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussPost> list = baseMapper.listMyReply(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussPost> fetchNormal(DiscussPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussPost> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<DiscussPost> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussPost> listNormal(DiscussPostSearchContext context) {
        List<DiscussPost> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussPost> fetchReader(DiscussPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussPost> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<DiscussPost> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussPost> listReader(DiscussPostSearchContext context) {
        List<DiscussPost> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussPost> fetchRecent(DiscussPostSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussPost> pages=baseMapper.searchRecent(context.getPages(),context,context.getSelectCond());
        List<DiscussPost> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussPost> listRecent(DiscussPostSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussPost> list = baseMapper.listRecent(context,context.getSelectCond());
        return list;
   }
	
	public List<DiscussPost> findByTopicId(List<String> topicIds){
        List<DiscussPost> list = baseMapper.findByTopicId(topicIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            commentService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setComments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public boolean removeByTopicId(String topicId){
        return this.remove(Wrappers.<DiscussPost>lambdaQuery().eq(DiscussPost::getTopicId,topicId));
	}

	public boolean resetByTopicId(String topicId){
		return this.update(Wrappers.<DiscussPost>lambdaUpdate().eq(DiscussPost::getTopicId,topicId));
	}
	public boolean saveByDiscussTopic(DiscussTopic discussTopic, List<DiscussPost> list){
        if(list==null)
            return true;
        Map<String,DiscussPost> before = findByTopicId(discussTopic.getId()).stream().collect(Collectors.toMap(DiscussPost::getId,e->e));

        List<DiscussPost> update = new ArrayList<>();
        List<DiscussPost> create = new ArrayList<>();

        for(DiscussPost sub:list) {
            sub.setTopicId(discussTopic.getId());
            sub.setDiscussTopic(discussTopic);
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
    public List<Attention> getAttentions(DiscussPost et) {
        List<Attention> list = attentionService.findByOwnerId(et.getId());
        et.setAttentions(list);
        return list;
    }
	
	@Override
    public List<Comment> getComments(DiscussPost et) {
        List<Comment> list = commentService.findByPrincipalId(et.getId());
        et.setComments(list);
        return list;
    }
	
	@Override
    public List<Attachment> getAttachments(DiscussPost et) {
        List<Attachment> list = attachmentService.findByOwnerId(et.getId());
        et.setAttachments(list);
        return list;
    }
	

    public void fillParentData(DiscussPost et) {
        if(Entities.DISCUSS_TOPIC.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTopicId((String)et.getContextParentKey());
            DiscussTopic discussTopic = et.getDiscussTopic();
            if(discussTopic == null) {
                discussTopic = discussTopicService.getById(et.getTopicId());
                et.setDiscussTopic(discussTopic);
            }
            if(!ObjectUtils.isEmpty(discussTopic)) {
                et.setTopicId(discussTopic.getId());
                et.setTopicName(discussTopic.getName());
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
        return DiscussPostMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return DiscussPost.class;
    }

}