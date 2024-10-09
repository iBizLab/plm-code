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
import cn.ibizlab.plm.core.devops.domain.Commit;
import cn.ibizlab.plm.core.devops.filter.CommitSearchContext;
import cn.ibizlab.plm.core.devops.service.CommitService;
import cn.ibizlab.plm.core.devops.mapper.CommitMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;
import cn.ibizlab.plm.core.devops.service.BranchRefCommitService;

/**
 * 实体[代码提交] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractCommitService extends ServiceImpl<CommitMapper,Commit> implements CommitService {

    @Autowired
    @Lazy
    protected BranchRefCommitService branchRefCommitService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Commit et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Commit> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Commit et) {
        UpdateWrapper<Commit> qw = et.getUpdateWrapper(true);
        qw.eq("sha", et.getSha());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Commit> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Commit et) {
        if(!remove(Wrappers.<Commit>lambdaQuery().eq(Commit::getSha, et.getSha())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Commit> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Commit get(Commit et) {
        Commit rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.COMMIT.toString(),et.getSha());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Commit> get(List<Commit> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Commit getDraft(Commit et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(Commit et) {
        return (!ObjectUtils.isEmpty(et.getSha()) && this.count(Wrappers.<Commit>lambdaQuery().eq(Commit::getSha, et.getSha()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Commit et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Commit> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Commit> before = get(list).stream().collect(Collectors.toMap(Commit::getSha,e->e));
        List<Commit> create = new ArrayList<>();
        List<Commit> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getSha()) && before.containsKey(sub.getSha()))
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
	
   public Page<Commit> fetchDefault(CommitSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Commit> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Commit> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Commit> listDefault(CommitSearchContext context) {
        List<Commit> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Commit> fetchView(CommitSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Commit> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Commit> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Commit> listView(CommitSearchContext context) {
        List<Commit> list = baseMapper.listView(context,context.getSelectCond());
        return list;
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
        return CommitMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Commit.class;
    }

}