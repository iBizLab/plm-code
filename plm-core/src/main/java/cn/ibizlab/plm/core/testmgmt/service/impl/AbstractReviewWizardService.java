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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewWizardSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.ReviewWizardService;
import cn.ibizlab.plm.core.testmgmt.mapper.ReviewWizardMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.service.GuidelineService;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentService;

/**
 * 实体[评审向导] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewWizardService extends ServiceImpl<ReviewWizardMapper,ReviewWizard> implements ReviewWizardService {

    @Autowired
    @Lazy
    protected GuidelineService guidelineService;

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected ReviewContentService reviewContentService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ReviewWizard et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByReviewWizard(et,et.getAttentions());
        reviewContentService.saveByReviewWizard(et,et.getContents());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<ReviewWizard> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(ReviewWizard et) {
        UpdateWrapper<ReviewWizard> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByReviewWizard(et,et.getAttentions());
        reviewContentService.saveByReviewWizard(et,et.getContents());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<ReviewWizard> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(ReviewWizard et) {
        if(!remove(Wrappers.<ReviewWizard>lambdaQuery().eq(ReviewWizard::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<ReviewWizard> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public ReviewWizard get(ReviewWizard et) {
        ReviewWizard rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.REVIEW_WIZARD.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [评审内容]
        getContents(et);
        return et;
    }	

    public List<ReviewWizard> get(List<ReviewWizard> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public ReviewWizard getDraft(ReviewWizard et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(ReviewWizard et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ReviewWizard>lambdaQuery().eq(ReviewWizard::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(ReviewWizard et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<ReviewWizard> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ReviewWizard> before = get(list).stream().collect(Collectors.toMap(ReviewWizard::getId,e->e));
        List<ReviewWizard> create = new ArrayList<>();
        List<ReviewWizard> update = new ArrayList<>();
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
	
   public Page<ReviewWizard> fetchDefault(ReviewWizardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReviewWizard> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ReviewWizard> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ReviewWizard> listDefault(ReviewWizardSearchContext context) {
        List<ReviewWizard> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<ReviewWizard> findByGuidelineId(List<String> guidelineIds){
        List<ReviewWizard> list = baseMapper.findByGuidelineId(guidelineIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            reviewContentService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setContents(sub.getValue())));
        return list;	
	}

	public List<ReviewWizard> findByGuideline(Guideline guideline){
        List<ReviewWizard> list = findByGuidelineId(Arrays.asList(guideline.getId()));
		return list;
	}
	public boolean removeByGuidelineId(String guidelineId){
        return this.remove(Wrappers.<ReviewWizard>lambdaQuery().eq(ReviewWizard::getGuidelineId,guidelineId));
	}

	public boolean resetByGuidelineId(String guidelineId){
		return this.update(Wrappers.<ReviewWizard>lambdaUpdate().set(ReviewWizard::getGuidelineId, null).eq(ReviewWizard::getGuidelineId,guidelineId));
	}
	public boolean saveByGuideline(Guideline guideline, List<ReviewWizard> list){
        if(list==null)
            return true;

        Map<String,ReviewWizard> before = findByGuideline(guideline).stream().collect(Collectors.toMap(ReviewWizard::getId,e->e));
        List<ReviewWizard> update = new ArrayList<>();
        List<ReviewWizard> create = new ArrayList<>();

        for(ReviewWizard sub:list) {
            sub.setGuidelineId(guideline.getId());
            sub.setGuideline(guideline);
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
	public List<ReviewWizard> findByLibraryId(List<String> libraryIds){
        List<ReviewWizard> list = baseMapper.findByLibraryId(libraryIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            reviewContentService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setContents(sub.getValue())));
        return list;	
	}

	public List<ReviewWizard> findByLibrary(Library library){
        List<ReviewWizard> list = findByLibraryId(Arrays.asList(library.getId()));
		return list;
	}
	public boolean removeByLibraryId(String libraryId){
        return this.remove(Wrappers.<ReviewWizard>lambdaQuery().eq(ReviewWizard::getLibraryId,libraryId));
	}

	public boolean resetByLibraryId(String libraryId){
		return this.update(Wrappers.<ReviewWizard>lambdaUpdate().set(ReviewWizard::getLibraryId, null).eq(ReviewWizard::getLibraryId,libraryId));
	}
	public boolean saveByLibrary(Library library, List<ReviewWizard> list){
        if(list==null)
            return true;

        Map<String,ReviewWizard> before = findByLibrary(library).stream().collect(Collectors.toMap(ReviewWizard::getId,e->e));
        List<ReviewWizard> update = new ArrayList<>();
        List<ReviewWizard> create = new ArrayList<>();

        for(ReviewWizard sub:list) {
            sub.setLibraryId(library.getId());
            sub.setLibrary(library);
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
    public List<Attention> getAttentions(ReviewWizard et) {
        List<Attention> list = attentionService.findByReviewWizard(et);
        et.setAttentions(list);
        return list;
    }
	
	@Override
    public List<ReviewContent> getContents(ReviewWizard et) {
        List<ReviewContent> list = reviewContentService.findByReviewWizard(et);
        et.setContents(list);
        return list;
    }
	
   public Page<ReviewWizard> fetchView(ReviewWizardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ReviewWizard> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<ReviewWizard> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<ReviewWizard> listView(ReviewWizardSearchContext context) {
        List<ReviewWizard> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(ReviewWizard et) {
        if(Entities.GUIDELINE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setGuidelineId((String)et.getContextParentKey());
        }
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setLibraryId((String)et.getContextParentKey());
            Library library = et.getLibrary();
            if(library == null) {
                library = libraryService.getById(et.getLibraryId());
                et.setLibrary(library);
            }
            if(!ObjectUtils.isEmpty(library)) {
                et.setLibraryIdentifier(library.getIdentifier());
                et.setLibraryName(library.getName());
                et.setLibraryId(library.getId());
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
        return ReviewWizardMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ReviewWizard.class;
    }

}