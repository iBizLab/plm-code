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
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;
import cn.ibizlab.plm.core.devops.filter.BranchRefCommitSearchContext;
import cn.ibizlab.plm.core.devops.service.BranchRefCommitService;
import cn.ibizlab.plm.core.devops.mapper.BranchRefCommitMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.devops.domain.Branch;
import cn.ibizlab.plm.core.devops.service.BranchService;
import cn.ibizlab.plm.core.devops.domain.Commit;
import cn.ibizlab.plm.core.devops.service.CommitService;
import cn.ibizlab.plm.core.devops.domain.Repository;

/**
 * 实体[分支提交关联] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBranchRefCommitService extends ServiceImpl<BranchRefCommitMapper,BranchRefCommit> implements BranchRefCommitService {

    @Autowired
    @Lazy
    protected BranchService branchService;

    @Autowired
    @Lazy
    protected CommitService commitService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(BranchRefCommit et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<BranchRefCommit> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(BranchRefCommit et) {
        UpdateWrapper<BranchRefCommit> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<BranchRefCommit> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(BranchRefCommit et) {
        if(!remove(Wrappers.<BranchRefCommit>lambdaQuery().eq(BranchRefCommit::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<BranchRefCommit> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public BranchRefCommit get(BranchRefCommit et) {
        BranchRefCommit rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BRANCH_REF_COMMIT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<BranchRefCommit> get(List<BranchRefCommit> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public BranchRefCommit getDraft(BranchRefCommit et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(BranchRefCommit et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<BranchRefCommit>lambdaQuery().eq(BranchRefCommit::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(BranchRefCommit et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<BranchRefCommit> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,BranchRefCommit> before = get(list).stream().collect(Collectors.toMap(BranchRefCommit::getId,e->e));
        List<BranchRefCommit> create = new ArrayList<>();
        List<BranchRefCommit> update = new ArrayList<>();
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
	
   public Page<BranchRefCommit> fetchDefault(BranchRefCommitSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BranchRefCommit> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<BranchRefCommit> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<BranchRefCommit> listDefault(BranchRefCommitSearchContext context) {
        List<BranchRefCommit> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<BranchRefCommit> findByMetaId(List<String> metaIds){
        List<BranchRefCommit> list = baseMapper.findByMetaId(metaIds);
        return list;	
	}

	public List<BranchRefCommit> findByBranch(Branch branch){
        List<BranchRefCommit> list = findByMetaId(Arrays.asList(branch.getId()));
		return list;
	}
	public boolean removeByMetaId(String metaId){
        return this.remove(Wrappers.<BranchRefCommit>lambdaQuery().eq(BranchRefCommit::getMetaId,metaId));
	}

	public boolean resetByMetaId(String metaId){
		return this.update(Wrappers.<BranchRefCommit>lambdaUpdate().set(BranchRefCommit::getMetaId, null).eq(BranchRefCommit::getMetaId,metaId));
	}
	public boolean saveByBranch(Branch branch, List<BranchRefCommit> list){
        if(list==null)
            return true;

        Map<String,BranchRefCommit> before = findByBranch(branch).stream().collect(Collectors.toMap(BranchRefCommit::getId,e->e));
        List<BranchRefCommit> update = new ArrayList<>();
        List<BranchRefCommit> create = new ArrayList<>();

        for(BranchRefCommit sub:list) {
            sub.setMetaId(branch.getId());
            sub.setBranch(branch);
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
	public List<BranchRefCommit> findBySha(List<String> shas){
        List<BranchRefCommit> list = baseMapper.findBySha(shas);
        return list;	
	}

	public List<BranchRefCommit> findByCommit(Commit commit){
        List<BranchRefCommit> list = findBySha(Arrays.asList(commit.getSha()));
		return list;
	}
	public boolean removeBySha(String sha){
        return this.remove(Wrappers.<BranchRefCommit>lambdaQuery().eq(BranchRefCommit::getSha,sha));
	}

	public boolean resetBySha(String sha){
		return this.update(Wrappers.<BranchRefCommit>lambdaUpdate().set(BranchRefCommit::getSha, null).eq(BranchRefCommit::getSha,sha));
	}
	public boolean saveByCommit(Commit commit, List<BranchRefCommit> list){
        if(list==null)
            return true;

        Map<String,BranchRefCommit> before = findByCommit(commit).stream().collect(Collectors.toMap(BranchRefCommit::getId,e->e));
        List<BranchRefCommit> update = new ArrayList<>();
        List<BranchRefCommit> create = new ArrayList<>();

        for(BranchRefCommit sub:list) {
            sub.setSha(commit.getSha());
            sub.setCommit(commit);
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
	public List<BranchRefCommit> findByRepositoryId(List<String> repositoryIds){
        List<BranchRefCommit> list = baseMapper.findByRepositoryId(repositoryIds);
        return list;	
	}

	public List<BranchRefCommit> findByRepository(Repository repository){
        List<BranchRefCommit> list = findByRepositoryId(Arrays.asList(repository.getId()));
		return list;
	}
	public boolean removeByRepositoryId(String repositoryId){
        return this.remove(Wrappers.<BranchRefCommit>lambdaQuery().eq(BranchRefCommit::getRepositoryId,repositoryId));
	}

	public boolean resetByRepositoryId(String repositoryId){
		return this.update(Wrappers.<BranchRefCommit>lambdaUpdate().set(BranchRefCommit::getRepositoryId, null).eq(BranchRefCommit::getRepositoryId,repositoryId));
	}
	public boolean saveByRepository(Repository repository, List<BranchRefCommit> list){
        if(list==null)
            return true;

        Map<String,BranchRefCommit> before = findByRepository(repository).stream().collect(Collectors.toMap(BranchRefCommit::getId,e->e));
        List<BranchRefCommit> update = new ArrayList<>();
        List<BranchRefCommit> create = new ArrayList<>();

        for(BranchRefCommit sub:list) {
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
   public Page<BranchRefCommit> fetchView(BranchRefCommitSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<BranchRefCommit> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<BranchRefCommit> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<BranchRefCommit> listView(BranchRefCommitSearchContext context) {
        List<BranchRefCommit> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(BranchRefCommit et) {
        if(Entities.BRANCH.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setMetaId((String)et.getContextParentKey());
        }
        if(Entities.COMMIT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSha((String)et.getContextParentKey());
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
        return BranchRefCommitMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return BranchRefCommit.class;
    }

}