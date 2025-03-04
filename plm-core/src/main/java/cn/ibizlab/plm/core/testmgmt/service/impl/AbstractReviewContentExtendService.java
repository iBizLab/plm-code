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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewContentExtendSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentExtendService;
import cn.ibizlab.plm.core.testmgmt.mapper.ReviewContentExtendMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.core.testmgmt.service.ReviewResultService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[评审内容扩展] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewContentExtendService extends ServiceImpl<ReviewContentExtendMapper,ReviewContentExtend> implements ReviewContentExtendService {

    @Autowired
    @Lazy
    protected ReviewResultService reviewResultService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ReviewContentExtend et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        reviewResultService.saveByReviewContentExtend(et,et.getStageResults());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ReviewContentExtend> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ReviewContentExtend et) {
        UpdateWrapper<ReviewContentExtend> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        reviewResultService.saveByReviewContentExtend(et,et.getStageResults());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ReviewContentExtend> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ReviewContentExtend et) {
        String key = et.getId();
        reviewResultService.removeByContentId(key);
        if(!remove(Wrappers.<ReviewContentExtend>lambdaQuery().eq(ReviewContentExtend::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ReviewContentExtend> entities) {
        for (ReviewContentExtend et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public ReviewContentExtend get(ReviewContentExtend et) {
        ReviewContentExtend rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.REVIEW_CONTENT_EXTEND.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [评审结果]
        getStageResults(et);
        return et;
    }	

    public List<ReviewContentExtend> get(List<ReviewContentExtend> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ReviewContentExtend getDraft(ReviewContentExtend et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(ReviewContentExtend et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ReviewContentExtend>lambdaQuery().eq(ReviewContentExtend::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ReviewContentExtend et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ReviewContentExtend> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ReviewContentExtend> before = get(list).stream().collect(Collectors.toMap(ReviewContentExtend::getId,e->e));
        List<ReviewContentExtend> create = new ArrayList<>();
        List<ReviewContentExtend> update = new ArrayList<>();
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
	
   public Page<ReviewContentExtend> fetchDefault(ReviewContentExtendSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReviewContentExtend> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ReviewContentExtend> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ReviewContentExtend> listDefault(ReviewContentExtendSearchContext context) {
        List<ReviewContentExtend> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	@Override
    public List<ReviewResult> getStageResults(ReviewContentExtend et) {
        List<ReviewResult> list = reviewResultService.findByReviewContentExtend(et);
        et.setStageResults(list);
        return list;
    }
	
   public Page<ReviewContentExtend> fetchView(ReviewContentExtendSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReviewContentExtend> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ReviewContentExtend> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ReviewContentExtend> listView(ReviewContentExtendSearchContext context) {
        List<ReviewContentExtend> list = baseMapper.listView(context,context.getSelectCond());
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
        return ReviewContentExtendMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ReviewContentExtend.class;
    }

}