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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.team.filter.DiscussReplySearchContext;
import cn.ibizlab.plm.core.team.service.DiscussReplyService;
import cn.ibizlab.plm.core.team.mapper.DiscussReplyMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.service.DiscussPostService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;

/**
 * 实体[讨论回复] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDiscussReplyService extends ServiceImpl<DiscussReplyMapper,DiscussReply> implements DiscussReplyService {

    @Autowired
    @Lazy
    protected DiscussPostService discussPostService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DiscussReply et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        commentService.saveByDiscussReply(et,et.getComments());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<DiscussReply> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(DiscussReply et) {
        UpdateWrapper<DiscussReply> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        commentService.saveByDiscussReply(et,et.getComments());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<DiscussReply> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(DiscussReply et) {
        if(!remove(Wrappers.<DiscussReply>lambdaQuery().eq(DiscussReply::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<DiscussReply> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public DiscussReply get(DiscussReply et) {
        DiscussReply rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DISCUSS_REPLY.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [评论]
        getComments(et);
        return et;
    }	

    public List<DiscussReply> get(List<DiscussReply> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public DiscussReply getDraft(DiscussReply et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(DiscussReply et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<DiscussReply>lambdaQuery().eq(DiscussReply::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(DiscussReply et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<DiscussReply> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,DiscussReply> before = get(list).stream().collect(Collectors.toMap(DiscussReply::getId,e->e));
        List<DiscussReply> create = new ArrayList<>();
        List<DiscussReply> update = new ArrayList<>();
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
	
   public Page<DiscussReply> fetchDefault(DiscussReplySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussReply> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<DiscussReply> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussReply> listDefault(DiscussReplySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,ASC");
        List<DiscussReply> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussReply> fetchMyReply(DiscussReplySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussReply> pages=baseMapper.searchMyReply(context.getPages(),context,context.getSelectCond());
        List<DiscussReply> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussReply> listMyReply(DiscussReplySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussReply> list = baseMapper.listMyReply(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussReply> fetchRecent(DiscussReplySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussReply> pages=baseMapper.searchRecent(context.getPages(),context,context.getSelectCond());
        List<DiscussReply> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussReply> listRecent(DiscussReplySearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussReply> list = baseMapper.listRecent(context,context.getSelectCond());
        return list;
   }
	
	public List<DiscussReply> findByPostId(List<String> postIds){
        List<DiscussReply> list = baseMapper.findByPostId(postIds);
        if(!ObjectUtils.isEmpty(list))
            commentService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setComments(sub.getValue())));
        return list;	
	}

	public List<DiscussReply> findByDiscussPost(DiscussPost discussPost){
        List<DiscussReply> list = findByPostId(Arrays.asList(discussPost.getId()));
		return list;
	}
	public boolean removeByPostId(String postId){
        return this.remove(Wrappers.<DiscussReply>lambdaQuery().eq(DiscussReply::getPostId,postId));
	}

	public boolean resetByPostId(String postId){
		return this.update(Wrappers.<DiscussReply>lambdaUpdate().eq(DiscussReply::getPostId,postId));
	}
	public boolean saveByDiscussPost(DiscussPost discussPost, List<DiscussReply> list){
        if(list==null)
            return true;

        Map<String,DiscussReply> before = findByDiscussPost(discussPost).stream().collect(Collectors.toMap(DiscussReply::getId,e->e));
        List<DiscussReply> update = new ArrayList<>();
        List<DiscussReply> create = new ArrayList<>();

        for(DiscussReply sub:list) {
            sub.setPostId(discussPost.getId());
            sub.setDiscussPost(discussPost);
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
    public List<Comment> getComments(DiscussReply et) {
        List<Comment> list = commentService.findByDiscussReply(et);
        et.setComments(list);
        return list;
    }
	
   public Page<DiscussReply> fetchView(DiscussReplySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussReply> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<DiscussReply> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussReply> listView(DiscussReplySearchContext context) {
        List<DiscussReply> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(DiscussReply et) {
        if(Entities.DISCUSS_POST.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPostId((String)et.getContextParentKey());
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
        return DiscussReplyMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return DiscussReply.class;
    }

}