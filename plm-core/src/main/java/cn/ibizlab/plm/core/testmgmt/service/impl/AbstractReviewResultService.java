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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewResultSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.ReviewResultService;
import cn.ibizlab.plm.core.testmgmt.mapper.ReviewResultMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentExtendService;

/**
 * 实体[评审结果] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewResultService extends ServiceImpl<ReviewResultMapper,ReviewResult> implements ReviewResultService {

    @Autowired
    @Lazy
    protected ReviewContentExtendService reviewContentExtendService;

    protected int batchSize = 500;

    public ReviewResult get(ReviewResult et) {
        ReviewResult rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.REVIEW_RESULT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<ReviewResult> getByEntities(List<ReviewResult> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(ReviewResult et) {
        if(Entities.REVIEW_CONTENT_EXTEND.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setContentId((String)et.getContextParentKey());
        }
    }

    public ReviewResult getDraft(ReviewResult et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(ReviewResult et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ReviewResult>lambdaQuery().eq(ReviewResult::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(ReviewResult et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<ReviewResult> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(ReviewResult et) {
        UpdateWrapper<ReviewResult> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<ReviewResult> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(ReviewResult et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<ReviewResult> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ReviewResult> before = getByEntities(list).stream().collect(Collectors.toMap(ReviewResult::getId,e->e));
        List<ReviewResult> create = new ArrayList<>();
        List<ReviewResult> update = new ArrayList<>();
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
    public boolean remove(ReviewResult et) {
        if(!remove(Wrappers.<ReviewResult>lambdaQuery().eq(ReviewResult::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<ReviewResult> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<ReviewResult> searchDefault(ReviewResultSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReviewResult> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ReviewResult> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<ReviewResult> listDefault(ReviewResultSearchContext context) {
        List<ReviewResult> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<ReviewResult> findByContentId(List<String> contentIds) {
        List<ReviewResult> list = baseMapper.findByContentId(contentIds);
        return list;
    }
    public boolean removeByContentId(String contentId) {
        return this.remove(Wrappers.<ReviewResult>lambdaQuery().eq(ReviewResult::getContentId,contentId));
    }

    public boolean resetByContentId(String contentId) {
        return this.update(Wrappers.<ReviewResult>lambdaUpdate().eq(ReviewResult::getContentId,contentId));
    }

    public boolean saveByReviewContentExtend(ReviewContentExtend reviewContentExtend,List<ReviewResult> list) {
        if(list==null)
            return true;
        Map<String,ReviewResult> before = findByContentId(reviewContentExtend.getId()).stream().collect(Collectors.toMap(ReviewResult::getId,e->e));
        List<ReviewResult> update = new ArrayList<>();
        List<ReviewResult> create = new ArrayList<>();

        for(ReviewResult sub:list) {
            sub.setContentId(reviewContentExtend.getId());
            sub.setReviewContentExtend(reviewContentExtend);
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
        return ReviewResultMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ReviewResult.class;
    }
}