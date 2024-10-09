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
import cn.ibizlab.plm.core.devops.domain.PullRequest;
import cn.ibizlab.plm.core.devops.filter.PullRequestSearchContext;
import cn.ibizlab.plm.core.devops.service.PullRequestService;
import cn.ibizlab.plm.core.devops.mapper.PullRequestMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.devops.domain.Repository;
import cn.ibizlab.plm.core.devops.domain.ScmReview;
import cn.ibizlab.plm.core.devops.service.ScmReviewService;

/**
 * 实体[拉取提交] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPullRequestService extends ServiceImpl<PullRequestMapper,PullRequest> implements PullRequestService {

    @Autowired
    @Lazy
    protected ScmReviewService scmReviewService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PullRequest et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<PullRequest> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(PullRequest et) {
        UpdateWrapper<PullRequest> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<PullRequest> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(PullRequest et) {
        if(!remove(Wrappers.<PullRequest>lambdaQuery().eq(PullRequest::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<PullRequest> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public PullRequest get(PullRequest et) {
        PullRequest rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PULL_REQUEST.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<PullRequest> get(List<PullRequest> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public PullRequest getDraft(PullRequest et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(PullRequest et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<PullRequest>lambdaQuery().eq(PullRequest::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(PullRequest et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<PullRequest> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,PullRequest> before = get(list).stream().collect(Collectors.toMap(PullRequest::getId,e->e));
        List<PullRequest> create = new ArrayList<>();
        List<PullRequest> update = new ArrayList<>();
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
	
   public Page<PullRequest> fetchDefault(PullRequestSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PullRequest> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<PullRequest> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<PullRequest> listDefault(PullRequestSearchContext context) {
        List<PullRequest> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<PullRequest> findByRepositoryId(List<String> repositoryIds){
        List<PullRequest> list = baseMapper.findByRepositoryId(repositoryIds);
        return list;	
	}

	public List<PullRequest> findByRepository(Repository repository){
        List<PullRequest> list = findByRepositoryId(Arrays.asList(repository.getId()));
		return list;
	}
	public boolean removeByRepositoryId(String repositoryId){
        return this.remove(Wrappers.<PullRequest>lambdaQuery().eq(PullRequest::getRepositoryId,repositoryId));
	}

	public boolean resetByRepositoryId(String repositoryId){
		return this.update(Wrappers.<PullRequest>lambdaUpdate().set(PullRequest::getRepositoryId, null).eq(PullRequest::getRepositoryId,repositoryId));
	}
	public boolean saveByRepository(Repository repository, List<PullRequest> list){
        if(list==null)
            return true;

        Map<String,PullRequest> before = findByRepository(repository).stream().collect(Collectors.toMap(PullRequest::getId,e->e));
        List<PullRequest> update = new ArrayList<>();
        List<PullRequest> create = new ArrayList<>();

        for(PullRequest sub:list) {
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
   public Page<PullRequest> fetchView(PullRequestSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PullRequest> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<PullRequest> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<PullRequest> listView(PullRequestSearchContext context) {
        List<PullRequest> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(PullRequest et) {
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
        return PullRequestMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return PullRequest.class;
    }

}