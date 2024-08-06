/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service.impl;

import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.testmgmt.mapper.TestCaseMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.service.TestSuiteService;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.testmgmt.domain.CaseHistory;
import cn.ibizlab.plm.core.testmgmt.service.CaseHistoryService;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.service.RunService;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentService;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.service.SearchAttachmentService;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.service.SearchCommentService;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.service.WorkloadService;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.service.VersionService;

/**
 * 实体[用例] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTestCaseService extends ServiceImpl<TestCaseMapper,TestCase> implements TestCaseService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected TestSuiteService testSuiteService;

    @Autowired
    @Lazy
    protected CaseHistoryService caseHistoryService;

    @Autowired
    @Lazy
    protected RunService runService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    @Autowired
    @Lazy
    protected AttachmentService attachmentService;

    @Autowired
    @Lazy
    protected ReviewContentService reviewContentService;

    @Autowired
    @Lazy
    protected SearchAttachmentService searchAttachmentService;

    @Autowired
    @Lazy
    protected SearchCommentService searchCommentService;

    @Autowired
    @Lazy
    protected WorkloadService workloadService;

    @Autowired
    @Lazy
    protected VersionService versionService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TestCase et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByTestCase(et,et.getAttentions());
        attachmentService.saveByTestCase(et,et.getAttachments());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<TestCase> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(TestCase et) {
        fillParentData(et);
        UpdateWrapper<TestCase> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByTestCase(et,et.getAttentions());
        attachmentService.saveByTestCase(et,et.getAttachments());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<TestCase> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(TestCase et) {
        if(!remove(Wrappers.<TestCase>lambdaQuery().eq(TestCase::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<TestCase> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public TestCase get(TestCase et) {
        TestCase rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.TEST_CASE.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [附件]
        getAttachments(et);
        return et;
    }	

    public List<TestCase> get(List<TestCase> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public TestCase getDraft(TestCase et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(TestCase et) {
        fillParentData(et);
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<TestCase>lambdaQuery().eq(TestCase::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(TestCase et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<TestCase> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,TestCase> before = get(list).stream().collect(Collectors.toMap(TestCase::getId,e->e));
        List<TestCase> create = new ArrayList<>();
        List<TestCase> update = new ArrayList<>();
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
	
   public Page<TestCase> fetchDefault(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listDefault(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<TestCase> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchImplementationResults(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchImplementationResults(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listImplementationResults(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listImplementationResults(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchPersonDistributions(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchPersonDistributions(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listPersonDistributions(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listPersonDistributions(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchAdvancedSearch(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchAdvancedSearch(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listAdvancedSearch(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        List<TestCase> list = baseMapper.listAdvancedSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchAssessmentResult(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchAssessmentResult(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listAssessmentResult(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listAssessmentResult(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchBaselineChooseCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchBaselineChooseCase(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listBaselineChooseCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<TestCase> list = baseMapper.listBaselineChooseCase(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchBiDetail(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchBiDetail(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listBiDetail(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listBiDetail(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchBiSearch(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchBiSearch(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listBiSearch(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listBiSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchCasePerson(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchCasePerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listCasePerson(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listCasePerson(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchCaseType(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchCaseType(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listCaseType(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listCaseType(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchCommentNotifyMaintenance(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchCommentNotifyMaintenance(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listCommentNotifyMaintenance(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listCommentNotifyMaintenance(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchDailyTendencies(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchDailyTendencies(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listDailyTendencies(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listDailyTendencies(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchDegreeImportance(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchDegreeImportance(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listDegreeImportance(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listDegreeImportance(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchDeleted(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listDeleted(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<TestCase> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchEverydayTest(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchEverydayTest(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listEverydayTest(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listEverydayTest(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchIdeaRelationTestCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchIdeaRelationTestCase(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listIdeaRelationTestCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<TestCase> list = baseMapper.listIdeaRelationTestCase(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchMyAssign(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchMyAssign(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listMyAssign(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listMyAssign(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchMyAssigneeCountTestCase(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchMyAssigneeCountTestCase(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listMyAssigneeCountTestCase(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listMyAssigneeCountTestCase(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchMyAttention(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchMyAttention(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listMyAttention(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listMyAttention(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchMyCreated(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchMyCreated(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listMyCreated(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listMyCreated(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchNormal(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listNormal(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<TestCase> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchNosuiteTestCase(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchNosuiteTestCase(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listNosuiteTestCase(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listNosuiteTestCase(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchNotAddCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchNotAddCase(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listNotAddCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<TestCase> list = baseMapper.listNotAddCase(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchNotExsistsRelation(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchNotExsistsRelation(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listNotExsistsRelation(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<TestCase> list = baseMapper.listNotExsistsRelation(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchNotifyAssignee(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listNotifyAssignee(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listNotifyAssignee(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchPriorityDistributions(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchPriorityDistributions(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestCase>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),TestCase.class), context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listPriorityDistributions(TestCaseSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listPriorityDistributions(context,context.getSelectCond()),TestCase.class);
   }
	
   public Page<TestCase> fetchReader(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listReader(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchRecentTestCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchRecentTestCase(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listRecentTestCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<TestCase> list = baseMapper.listRecentTestCase(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchSuitesTestCase(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchSuitesTestCase(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listSuitesTestCase(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listSuitesTestCase(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestCase> fetchWorkItemRelationTestCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchWorkItemRelationTestCase(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listWorkItemRelationTestCase(TestCaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<TestCase> list = baseMapper.listWorkItemRelationTestCase(context,context.getSelectCond());
        return list;
   }
	
	public List<TestCase> findByTestLibraryId(List<String> testLibraryIds){
        List<TestCase> list = baseMapper.findByTestLibraryId(testLibraryIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<TestCase> findByLibrary(Library library){
        List<TestCase> list = findByTestLibraryId(Arrays.asList(library.getId()));
		return list;
	}
	public boolean removeByTestLibraryId(String testLibraryId){
        return this.remove(Wrappers.<TestCase>lambdaQuery().eq(TestCase::getTestLibraryId,testLibraryId));
	}

	public boolean resetByTestLibraryId(String testLibraryId){
		return this.update(Wrappers.<TestCase>lambdaUpdate().eq(TestCase::getTestLibraryId,testLibraryId));
	}
	public boolean saveByLibrary(Library library, List<TestCase> list){
        if(list==null)
            return true;

        Map<String,TestCase> before = findByLibrary(library).stream().collect(Collectors.toMap(TestCase::getId,e->e));
        List<TestCase> update = new ArrayList<>();
        List<TestCase> create = new ArrayList<>();

        for(TestCase sub:list) {
            sub.setTestLibraryId(library.getId());
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
	public List<TestCase> findBySuiteId(List<String> suiteIds){
        List<TestCase> list = baseMapper.findBySuiteId(suiteIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<TestCase> findByTestSuite(TestSuite testSuite){
        List<TestCase> list = findBySuiteId(Arrays.asList(testSuite.getId()));
		return list;
	}
	public boolean removeBySuiteId(String suiteId){
        return this.remove(Wrappers.<TestCase>lambdaQuery().eq(TestCase::getSuiteId,suiteId));
	}

	public boolean resetBySuiteId(String suiteId){
		return this.update(Wrappers.<TestCase>lambdaUpdate().eq(TestCase::getSuiteId,suiteId));
	}
	public boolean saveByTestSuite(TestSuite testSuite, List<TestCase> list){
        if(list==null)
            return true;

        Map<String,TestCase> before = findByTestSuite(testSuite).stream().collect(Collectors.toMap(TestCase::getId,e->e));
        List<TestCase> update = new ArrayList<>();
        List<TestCase> create = new ArrayList<>();

        for(TestCase sub:list) {
            sub.setSuiteId(testSuite.getId());
            sub.setTestSuite(testSuite);
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
	public List<TestCase> findByMaintenanceId(List<String> maintenanceIds){
        List<TestCase> list = baseMapper.findByMaintenanceId(maintenanceIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        return list;	
	}

	public List<TestCase> findByUser(User user){
        List<TestCase> list = findByMaintenanceId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByMaintenanceId(String maintenanceId){
        return this.remove(Wrappers.<TestCase>lambdaQuery().eq(TestCase::getMaintenanceId,maintenanceId));
	}

	public boolean resetByMaintenanceId(String maintenanceId){
		return this.update(Wrappers.<TestCase>lambdaUpdate().eq(TestCase::getMaintenanceId,maintenanceId));
	}
	public boolean saveByUser(User user, List<TestCase> list){
        if(list==null)
            return true;

        Map<String,TestCase> before = findByUser(user).stream().collect(Collectors.toMap(TestCase::getId,e->e));
        List<TestCase> update = new ArrayList<>();
        List<TestCase> create = new ArrayList<>();

        for(TestCase sub:list) {
            sub.setMaintenanceId(user.getId());
            sub.setUser(user);
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
    public List<Attention> getAttentions(TestCase et) {
        List<Attention> list = attentionService.findByTestCase(et);
        et.setAttentions(list);
        return list;
    }
	
	@Override
    public List<Attachment> getAttachments(TestCase et) {
        List<Attachment> list = attachmentService.findByTestCase(et);
        et.setAttachments(list);
        return list;
    }
	
   public Page<TestCase> fetchView(TestCaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestCase> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<TestCase> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestCase> listView(TestCaseSearchContext context) {
        List<TestCase> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(TestCase et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTestLibraryId((String)et.getContextParentKey());
            Library library = et.getLibrary();
            if(library == null) {
                library = libraryService.getById(et.getTestLibraryId());
                et.setLibrary(library);
            }
            if(!ObjectUtils.isEmpty(library)) {
                et.setLibraryIdentifier(library.getIdentifier());
                et.setTestLibraryId(library.getId());
                et.setTestLibraryName(library.getName());
            }
        }
        if(Entities.TEST_SUITE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSuiteId((String)et.getContextParentKey());
            TestSuite testSuite = et.getTestSuite();
            if(testSuite == null) {
                testSuite = testSuiteService.getById(et.getSuiteId());
                et.setTestSuite(testSuite);
            }
            if(!ObjectUtils.isEmpty(testSuite)) {
                et.setSuites(testSuite.getSuites());
                et.setSuiteId(testSuite.getId());
                et.setSuiteName(testSuite.getName());
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
        return TestCaseMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return TestCase.class;
    }

}