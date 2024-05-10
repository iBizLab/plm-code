/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@MINHERIT}}Service.java.hbs
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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewContentSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentService;
import cn.ibizlab.plm.core.testmgmt.mapper.ReviewContentMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.service.VersionService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentExtendService;

/**
 * 实体[评审内容] 服务对象接口实现（常规多继承虚拟实体）
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewContentService extends ServiceImpl<ReviewContentMapper,ReviewContent> implements ReviewContentService {

    @Autowired
    @Lazy
    protected ReviewService reviewService;

    @Autowired
    @Lazy
    protected VersionService versionService;

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    @Autowired
    @Lazy
    protected ReviewContentExtendService reviewContentExtendService;

    @Autowired
    @Lazy
    protected cn.ibizlab.plm.core.testmgmt.mapping.ReviewContentInheritMapping reviewContentInheritMapping;

    protected int batchSize = 500;

    public ReviewContent get(ReviewContent et) {
        ReviewContent rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.REVIEW_CONTENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<ReviewContent> getByEntities(List<ReviewContent> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(ReviewContent et) {
        if(Entities.REVIEW.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.VERSION.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetVersionId((String)et.getContextParentKey());
        }
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTargetId((String)et.getContextParentKey());
        }
    }

    public ReviewContent getDraft(ReviewContent et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(ReviewContent et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ReviewContent>lambdaQuery().eq(ReviewContent::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(ReviewContent et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        relationService.create(reviewContentInheritMapping.toRelation(et));
        reviewContentExtendService.create(reviewContentInheritMapping.toReviewContentExtend(et));
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<ReviewContent> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }

    @Transactional
    public boolean update(ReviewContent et) {
        relationService.update(reviewContentInheritMapping.toRelation(et));
        reviewContentExtendService.update(reviewContentInheritMapping.toReviewContentExtend(et));
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<ReviewContent> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }

    @Override
    @Transactional
    public boolean save(ReviewContent et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<ReviewContent> list) {
        list.forEach(et->getSelf().save(et));
        return true;
    }

    @Transactional
    public boolean remove(ReviewContent et) {
        relationService.remove(reviewContentInheritMapping.toRelation(et));
        reviewContentExtendService.remove(reviewContentInheritMapping.toReviewContentExtend(et));
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<ReviewContent> entities) {
        for (ReviewContent et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }

    public Page<ReviewContent> searchDefault(ReviewContentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReviewContent> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ReviewContent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<ReviewContent> listDefault(ReviewContentSearchContext context) {
        List<ReviewContent> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<ReviewContent> searchAll(ReviewContentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReviewContent> pages=baseMapper.searchAll(context.getPages(),context,context.getSelectCond());
        List<ReviewContent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<ReviewContent> listAll(ReviewContentSearchContext context) {
        List<ReviewContent> list = baseMapper.listAll(context,context.getSelectCond());
        return list;
    }

    public List<ReviewContent> findByPrincipalId(List<String> principalIds) {
        List<ReviewContent> list = baseMapper.findByPrincipalId(principalIds);
        return list;
    }

    public List<ReviewContent> findByTargetVersionId(List<String> targetVersionIds) {
        List<ReviewContent> list = baseMapper.findByTargetVersionId(targetVersionIds);
        return list;
    }

    public List<ReviewContent> findByTargetId(List<String> targetIds) {
        List<ReviewContent> list = baseMapper.findByTargetId(targetIds);
        return list;
    }

    public boolean removeByPrincipalId(String principalId) {
        return this.remove(Wrappers.<ReviewContent>lambdaQuery().eq(ReviewContent::getPrincipalId,principalId));
    }

    public boolean resetByPrincipalId(String principalId) {
        return this.update(Wrappers.<ReviewContent>lambdaUpdate().eq(ReviewContent::getPrincipalId,principalId));
    }

    public boolean saveByReview(Review review,List<ReviewContent> list) {
        if(list==null)
            return true;
        Map<String,ReviewContent> before = findByPrincipalId(review.getId()).stream().collect(Collectors.toMap(ReviewContent::getId,e->e));
        List<ReviewContent> update = new ArrayList<>();
        List<ReviewContent> create = new ArrayList<>();

        for(ReviewContent sub:list) {
            sub.setPrincipalId(review.getId());
            sub.setReview(review);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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

    public boolean removeByTargetVersionId(String targetVersionId) {
        return this.remove(Wrappers.<ReviewContent>lambdaQuery().eq(ReviewContent::getTargetVersionId,targetVersionId));
    }

    public boolean resetByTargetVersionId(String targetVersionId) {
        return this.update(Wrappers.<ReviewContent>lambdaUpdate().eq(ReviewContent::getTargetVersionId,targetVersionId));
    }

    public boolean saveByTargetVersion(Version version,List<ReviewContent> list) {
        if(list==null)
            return true;
        Map<String,ReviewContent> before = findByTargetVersionId(version.getId()).stream().collect(Collectors.toMap(ReviewContent::getId,e->e));
        List<ReviewContent> update = new ArrayList<>();
        List<ReviewContent> create = new ArrayList<>();

        for(ReviewContent sub:list) {
            sub.setTargetVersionId(version.getId());
            sub.setTargetVersion(version);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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

    public boolean removeByTargetId(String targetId) {
        return this.remove(Wrappers.<ReviewContent>lambdaQuery().eq(ReviewContent::getTargetId,targetId));
    }

    public boolean resetByTargetId(String targetId) {
        return this.update(Wrappers.<ReviewContent>lambdaUpdate().eq(ReviewContent::getTargetId,targetId));
    }

    public boolean saveByTestCase(TestCase testCase,List<ReviewContent> list) {
        if(list==null)
            return true;
        Map<String,ReviewContent> before = findByTargetId(testCase.getId()).stream().collect(Collectors.toMap(ReviewContent::getId,e->e));
        List<ReviewContent> update = new ArrayList<>();
        List<ReviewContent> create = new ArrayList<>();

        for(ReviewContent sub:list) {
            sub.setTargetId(testCase.getId());
            sub.setTestCase(testCase);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
        return ReviewContentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ReviewContent.class;
    }
}