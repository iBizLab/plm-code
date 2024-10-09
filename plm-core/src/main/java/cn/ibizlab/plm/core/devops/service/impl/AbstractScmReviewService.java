/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.devops.service.impl;

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
import cn.ibizlab.plm.core.devops.domain.ScmReview;
import cn.ibizlab.plm.core.devops.filter.ScmReviewSearchContext;
import cn.ibizlab.plm.core.devops.service.ScmReviewService;
import cn.ibizlab.plm.core.devops.mapper.ScmReviewMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.devops.domain.PullRequest;
import cn.ibizlab.plm.core.devops.service.PullRequestService;
import cn.ibizlab.plm.core.devops.domain.Repository;

/**
 * 实体[代码评审] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractScmReviewService extends ServiceImpl<ScmReviewMapper,ScmReview> implements ScmReviewService {

    @Autowired
    @Lazy
    protected PullRequestService pullRequestService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ScmReview et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ScmReview> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ScmReview et) {
        UpdateWrapper<ScmReview> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ScmReview> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ScmReview et) {
        if(!remove(Wrappers.<ScmReview>lambdaQuery().eq(ScmReview::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ScmReview> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public ScmReview get(ScmReview et) {
        ScmReview rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SCM_REVIEW.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<ScmReview> get(List<ScmReview> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ScmReview getDraft(ScmReview et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(ScmReview et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ScmReview>lambdaQuery().eq(ScmReview::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ScmReview et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ScmReview> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ScmReview> before = get(list).stream().collect(Collectors.toMap(ScmReview::getId,e->e));
        List<ScmReview> create = new ArrayList<>();
        List<ScmReview> update = new ArrayList<>();
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
	
   public Page<ScmReview> fetchDefault(ScmReviewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ScmReview> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ScmReview> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ScmReview> listDefault(ScmReviewSearchContext context) {
        List<ScmReview> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<ScmReview> findByPullRequestId(List<String> pullRequestIds){
        List<ScmReview> list = baseMapper.findByPullRequestId(pullRequestIds);
        return list;	
	}

	public List<ScmReview> findByPullRequest(PullRequest pullRequest){
        List<ScmReview> list = findByPullRequestId(Arrays.asList(pullRequest.getId()));
		return list;
	}
	public boolean removeByPullRequestId(String pullRequestId){
        return this.remove(Wrappers.<ScmReview>lambdaQuery().eq(ScmReview::getPullRequestId,pullRequestId));
	}

	public boolean resetByPullRequestId(String pullRequestId){
		return this.update(Wrappers.<ScmReview>lambdaUpdate().set(ScmReview::getPullRequestId, null).eq(ScmReview::getPullRequestId,pullRequestId));
	}
	public boolean saveByPullRequest(PullRequest pullRequest, List<ScmReview> list){
        if(list==null)
            return true;

        Map<String,ScmReview> before = findByPullRequest(pullRequest).stream().collect(Collectors.toMap(ScmReview::getId,e->e));
        List<ScmReview> update = new ArrayList<>();
        List<ScmReview> create = new ArrayList<>();

        for(ScmReview sub:list) {
            sub.setPullRequestId(pullRequest.getId());
            sub.setPullRequest(pullRequest);
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
	public List<ScmReview> findByRepositoryId(List<String> repositoryIds){
        List<ScmReview> list = baseMapper.findByRepositoryId(repositoryIds);
        return list;	
	}

	public List<ScmReview> findByRepository(Repository repository){
        List<ScmReview> list = findByRepositoryId(Arrays.asList(repository.getId()));
		return list;
	}
	public boolean removeByRepositoryId(String repositoryId){
        return this.remove(Wrappers.<ScmReview>lambdaQuery().eq(ScmReview::getRepositoryId,repositoryId));
	}

	public boolean resetByRepositoryId(String repositoryId){
		return this.update(Wrappers.<ScmReview>lambdaUpdate().set(ScmReview::getRepositoryId, null).eq(ScmReview::getRepositoryId,repositoryId));
	}
	public boolean saveByRepository(Repository repository, List<ScmReview> list){
        if(list==null)
            return true;

        Map<String,ScmReview> before = findByRepository(repository).stream().collect(Collectors.toMap(ScmReview::getId,e->e));
        List<ScmReview> update = new ArrayList<>();
        List<ScmReview> create = new ArrayList<>();

        for(ScmReview sub:list) {
            sub.setRepositoryId(repository.getId());
            sub.setRepository(repository);
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
   public Page<ScmReview> fetchView(ScmReviewSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ScmReview> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ScmReview> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ScmReview> listView(ScmReviewSearchContext context) {
        List<ScmReview> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(ScmReview et) {
        if(Entities.PULL_REQUEST.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPullRequestId((String)et.getContextParentKey());
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
        return ScmReviewMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ScmReview.class;
    }

}