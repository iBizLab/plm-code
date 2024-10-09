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
import cn.ibizlab.plm.core.devops.domain.Branch;
import cn.ibizlab.plm.core.devops.filter.BranchSearchContext;
import cn.ibizlab.plm.core.devops.service.BranchService;
import cn.ibizlab.plm.core.devops.mapper.BranchMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.devops.domain.Repository;
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;
import cn.ibizlab.plm.core.devops.service.BranchRefCommitService;

/**
 * 实体[代码分支] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBranchService extends ServiceImpl<BranchMapper,Branch> implements BranchService {

    @Autowired
    @Lazy
    protected BranchRefCommitService branchRefCommitService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Branch et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Branch> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Branch et) {
        UpdateWrapper<Branch> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Branch> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Branch et) {
        if(!remove(Wrappers.<Branch>lambdaQuery().eq(Branch::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Branch> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Branch get(Branch et) {
        Branch rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BRANCH.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Branch> get(List<Branch> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Branch getDraft(Branch et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Branch et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Branch>lambdaQuery().eq(Branch::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Branch et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Branch> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Branch> before = get(list).stream().collect(Collectors.toMap(Branch::getId,e->e));
        List<Branch> create = new ArrayList<>();
        List<Branch> update = new ArrayList<>();
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
	
   public Page<Branch> fetchDefault(BranchSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Branch> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Branch> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Branch> listDefault(BranchSearchContext context) {
        List<Branch> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<Branch> findByRepositoryId(List<String> repositoryIds){
        List<Branch> list = baseMapper.findByRepositoryId(repositoryIds);
        return list;	
	}

	public List<Branch> findByRepository(Repository repository){
        List<Branch> list = findByRepositoryId(Arrays.asList(repository.getId()));
		return list;
	}
	public boolean removeByRepositoryId(String repositoryId){
        return this.remove(Wrappers.<Branch>lambdaQuery().eq(Branch::getRepositoryId,repositoryId));
	}

	public boolean resetByRepositoryId(String repositoryId){
		return this.update(Wrappers.<Branch>lambdaUpdate().set(Branch::getRepositoryId, null).eq(Branch::getRepositoryId,repositoryId));
	}
	public boolean saveByRepository(Repository repository, List<Branch> list){
        if(list==null)
            return true;

        Map<String,Branch> before = findByRepository(repository).stream().collect(Collectors.toMap(Branch::getId,e->e));
        List<Branch> update = new ArrayList<>();
        List<Branch> create = new ArrayList<>();

        for(Branch sub:list) {
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
   public Page<Branch> fetchView(BranchSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Branch> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Branch> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Branch> listView(BranchSearchContext context) {
        List<Branch> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Branch et) {
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
        return BranchMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Branch.class;
    }

}