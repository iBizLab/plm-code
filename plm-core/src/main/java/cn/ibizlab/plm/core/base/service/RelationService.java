/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.filter.RelationSearchContext;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 关联服务接口[RelationService]
 *
 * @author generator
 */
public interface RelationService extends IService<Relation> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default RelationService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Relation et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Relation> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Relation et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Relation> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Relation().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Relation et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Relation> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Relation().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Relation> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Relation get(String key) {
        return getSelf().get(new Relation().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Relation get(Relation et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Relation> get(Collection<String> keys) {
        List<Relation> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Relation().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Relation> get(List<Relation> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Relation getDraft(Relation et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Relation et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Relation et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Relation> list);

    /**
    * addDependency
    * 
    * @param et
    * @return
    */
    default Relation addDependency(Relation et) {
        return et;
    }

    /**
    * delRelation
    * 
    * @param et
    * @return
    */
    default Relation delRelation(Relation et) {
        return et;
    }

    /**
    * programTestCase
    * 
    * @param et
    * @return
    */
    default Relation programTestCase(Relation et) {
        return et;
    }

    /**
    * runDelRelationBug
    * 
    * @param et
    * @return
    */
    default Relation runDelRelationBug(Relation et) {
        return et;
    }

    /**
    * testCaseDelRelationBug
    * 
    * @param et
    * @return
    */
    default Relation testCaseDelRelationBug(Relation et) {
        return et;
    }

    /**
    * workItemDelRelationCase
    * 
    * @param et
    * @return
    */
    default Relation workItemDelRelationCase(Relation et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchDefault(RelationSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Relation> listDefault(RelationSearchContext context);

    /**
    * fetchAll
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchAll(RelationSearchContext context);

    /**
    * listAll
    * 
    * @param context
    * @return
    */
    List<Relation> listAll(RelationSearchContext context);

    /**
    * fetchDependencyWorkItems
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchDependencyWorkItems(RelationSearchContext context);

    /**
    * listDependencyWorkItems
    * 
    * @param context
    * @return
    */
    List<Relation> listDependencyWorkItems(RelationSearchContext context);

    /**
    * fetchExistsRunRelationBug
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchExistsRunRelationBug(RelationSearchContext context);

    /**
    * listExistsRunRelationBug
    * 
    * @param context
    * @return
    */
    List<Relation> listExistsRunRelationBug(RelationSearchContext context);

    /**
    * fetchIdeaReCustomer
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchIdeaReCustomer(RelationSearchContext context);

    /**
    * listIdeaReCustomer
    * 
    * @param context
    * @return
    */
    List<Relation> listIdeaReCustomer(RelationSearchContext context);

    /**
    * fetchIdeaReIdea
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchIdeaReIdea(RelationSearchContext context);

    /**
    * listIdeaReIdea
    * 
    * @param context
    * @return
    */
    List<Relation> listIdeaReIdea(RelationSearchContext context);

    /**
    * fetchIdeaReTestCase
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchIdeaReTestCase(RelationSearchContext context);

    /**
    * listIdeaReTestCase
    * 
    * @param context
    * @return
    */
    List<Relation> listIdeaReTestCase(RelationSearchContext context);

    /**
    * fetchIdeaReTicket
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchIdeaReTicket(RelationSearchContext context);

    /**
    * listIdeaReTicket
    * 
    * @param context
    * @return
    */
    List<Relation> listIdeaReTicket(RelationSearchContext context);

    /**
    * fetchIdeaReWorkItem
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchIdeaReWorkItem(RelationSearchContext context);

    /**
    * listIdeaReWorkItem
    * 
    * @param context
    * @return
    */
    List<Relation> listIdeaReWorkItem(RelationSearchContext context);

    /**
    * fetchIdeaVersionRelation
    * 主实体版本创建时，查询关联principal_type为需求的数据存入version_data
    * @param context
    * @return
    */
    Page<Relation> fetchIdeaVersionRelation(RelationSearchContext context);

    /**
    * listIdeaVersionRelation
    * 主实体版本创建时，查询关联principal_type为需求的数据存入version_data
    * @param context
    * @return
    */
    List<Relation> listIdeaVersionRelation(RelationSearchContext context);

    /**
    * fetchMyRelation
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchMyRelation(RelationSearchContext context);

    /**
    * listMyRelation
    * 
    * @param context
    * @return
    */
    List<Relation> listMyRelation(RelationSearchContext context);

    /**
    * fetchProductPlanIdea
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchProductPlanIdea(RelationSearchContext context);

    /**
    * listProductPlanIdea
    * 
    * @param context
    * @return
    */
    List<Relation> listProductPlanIdea(RelationSearchContext context);

    /**
    * fetchProductReProject
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchProductReProject(RelationSearchContext context);

    /**
    * listProductReProject
    * 
    * @param context
    * @return
    */
    List<Relation> listProductReProject(RelationSearchContext context);

    /**
    * fetchProjectReProduct
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchProjectReProduct(RelationSearchContext context);

    /**
    * listProjectReProduct
    * 
    * @param context
    * @return
    */
    List<Relation> listProjectReProduct(RelationSearchContext context);

    /**
    * fetchReviewReTestCase
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchReviewReTestCase(RelationSearchContext context);

    /**
    * listReviewReTestCase
    * 
    * @param context
    * @return
    */
    List<Relation> listReviewReTestCase(RelationSearchContext context);

    /**
    * fetchRunReBug
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchRunReBug(RelationSearchContext context);

    /**
    * listRunReBug
    * 
    * @param context
    * @return
    */
    List<Relation> listRunReBug(RelationSearchContext context);

    /**
    * fetchRunReIdea
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchRunReIdea(RelationSearchContext context);

    /**
    * listRunReIdea
    * 
    * @param context
    * @return
    */
    List<Relation> listRunReIdea(RelationSearchContext context);

    /**
    * fetchRunReWorkItem
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchRunReWorkItem(RelationSearchContext context);

    /**
    * listRunReWorkItem
    * 
    * @param context
    * @return
    */
    List<Relation> listRunReWorkItem(RelationSearchContext context);

    /**
    * fetchTestCaseReBug
    * 仅关联缺陷类型工作项
    * @param context
    * @return
    */
    Page<Relation> fetchTestCaseReBug(RelationSearchContext context);

    /**
    * listTestCaseReBug
    * 仅关联缺陷类型工作项
    * @param context
    * @return
    */
    List<Relation> listTestCaseReBug(RelationSearchContext context);

    /**
    * fetchTestCaseReIdea
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchTestCaseReIdea(RelationSearchContext context);

    /**
    * listTestCaseReIdea
    * 
    * @param context
    * @return
    */
    List<Relation> listTestCaseReIdea(RelationSearchContext context);

    /**
    * fetchTestCaseReWorkItem
    * 排除了缺陷类型的工作项
    * @param context
    * @return
    */
    Page<Relation> fetchTestCaseReWorkItem(RelationSearchContext context);

    /**
    * listTestCaseReWorkItem
    * 排除了缺陷类型的工作项
    * @param context
    * @return
    */
    List<Relation> listTestCaseReWorkItem(RelationSearchContext context);

    /**
    * fetchTestCaseVersionRelation
    * 主实体版本创建时，查询关联principal_type为用例的数据存入version_data
    * @param context
    * @return
    */
    Page<Relation> fetchTestCaseVersionRelation(RelationSearchContext context);

    /**
    * listTestCaseVersionRelation
    * 主实体版本创建时，查询关联principal_type为用例的数据存入version_data
    * @param context
    * @return
    */
    List<Relation> listTestCaseVersionRelation(RelationSearchContext context);

    /**
    * fetchTicketReIdea
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchTicketReIdea(RelationSearchContext context);

    /**
    * listTicketReIdea
    * 
    * @param context
    * @return
    */
    List<Relation> listTicketReIdea(RelationSearchContext context);

    /**
    * fetchTicketReSelf
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchTicketReSelf(RelationSearchContext context);

    /**
    * listTicketReSelf
    * 
    * @param context
    * @return
    */
    List<Relation> listTicketReSelf(RelationSearchContext context);

    /**
    * fetchTicketReWorkItem
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchTicketReWorkItem(RelationSearchContext context);

    /**
    * listTicketReWorkItem
    * 
    * @param context
    * @return
    */
    List<Relation> listTicketReWorkItem(RelationSearchContext context);

    /**
    * fetchWorkItemRelationIdea
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchWorkItemRelationIdea(RelationSearchContext context);

    /**
    * listWorkItemRelationIdea
    * 
    * @param context
    * @return
    */
    List<Relation> listWorkItemRelationIdea(RelationSearchContext context);

    /**
    * fetchWorkItemRelationSelf
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchWorkItemRelationSelf(RelationSearchContext context);

    /**
    * listWorkItemRelationSelf
    * 
    * @param context
    * @return
    */
    List<Relation> listWorkItemRelationSelf(RelationSearchContext context);

    /**
    * fetchWorkItemRelationTestCase
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchWorkItemRelationTestCase(RelationSearchContext context);

    /**
    * listWorkItemRelationTestCase
    * 
    * @param context
    * @return
    */
    List<Relation> listWorkItemRelationTestCase(RelationSearchContext context);

    /**
    * fetchWorkItemRelationTicket
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchWorkItemRelationTicket(RelationSearchContext context);

    /**
    * listWorkItemRelationTicket
    * 
    * @param context
    * @return
    */
    List<Relation> listWorkItemRelationTicket(RelationSearchContext context);

    /**
    * fetchWorkItemVersionRelation
    * 主实体版本创建时，查询关联principal_type为工作项的数据存入version_data
    * @param context
    * @return
    */
    Page<Relation> fetchWorkItemVersionRelation(RelationSearchContext context);

    /**
    * listWorkItemVersionRelation
    * 主实体版本创建时，查询关联principal_type为工作项的数据存入version_data
    * @param context
    * @return
    */
    List<Relation> listWorkItemVersionRelation(RelationSearchContext context);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<Relation> findByPrincipalId(List<String> principalIds);
    default List<Relation> findByPrincipalId(String principalId){
        return findByPrincipalBaseline(new Baseline().setId(principalId));
    }

    /**
    * findByPrincipalBaseline
    * @param baseline
    * @return
    */
    List<Relation> findByPrincipalBaseline(Baseline baseline);

    /**
    * removeByPrincipalId
    * @param principalId
    * @return
    */
    boolean removeByPrincipalId(String principalId);

    /**
    * resetByPrincipalId
    * @param principalId
    * @return
    */
    boolean resetByPrincipalId(String principalId);

    /**
    * saveByPrincipalId
    * @param principalId
    * @param list
    * @return
    */
    default boolean saveByPrincipalId(String principalId, List<Relation> list){
        return getSelf().saveByPrincipalBaseline(new Baseline().setId(principalId),list);
    }

    /**
    * saveByPrincipalBaseline
    * @param baseline
    * @param list
    * @return
    */
    boolean saveByPrincipalBaseline(Baseline baseline, List<Relation> list);

    /**
    * findByPrincipalIdea
    * @param idea
    * @return
    */
    List<Relation> findByPrincipalIdea(Idea idea);

    /**
    * saveByPrincipalIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByPrincipalIdea(Idea idea, List<Relation> list);

    /**
    * findByPrincipalProduct
    * @param product
    * @return
    */
    List<Relation> findByPrincipalProduct(Product product);

    /**
    * saveByPrincipalProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByPrincipalProduct(Product product, List<Relation> list);

    /**
    * findByPrincipalProject
    * @param project
    * @return
    */
    List<Relation> findByPrincipalProject(Project project);

    /**
    * saveByPrincipalProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByPrincipalProject(Project project, List<Relation> list);

    /**
    * findByRelationRelease
    * @param release
    * @return
    */
    List<Relation> findByRelationRelease(Release release);

    /**
    * saveByRelationRelease
    * @param release
    * @param list
    * @return
    */
    boolean saveByRelationRelease(Release release, List<Relation> list);

    /**
    * findByPrincipalReview
    * @param review
    * @return
    */
    List<Relation> findByPrincipalReview(Review review);

    /**
    * saveByPrincipalReview
    * @param review
    * @param list
    * @return
    */
    boolean saveByPrincipalReview(Review review, List<Relation> list);

    /**
    * findById
    * @param ids
    * @return
    */
    List<Relation> findById(List<String> ids);
    default List<Relation> findById(String id){
        return findByReviewContentExtend(new ReviewContentExtend().setId(id));
    }

    /**
    * findByReviewContentExtend
    * @param reviewContentExtend
    * @return
    */
    List<Relation> findByReviewContentExtend(ReviewContentExtend reviewContentExtend);

    /**
    * removeById
    * @param id
    * @return
    */
    boolean removeById(String id);

    /**
    * resetById
    * @param id
    * @return
    */
    boolean resetById(String id);

    /**
    * saveById
    * @param id
    * @param list
    * @return
    */
    default boolean saveById(String id, List<Relation> list){
        return getSelf().saveByReviewContentExtend(new ReviewContentExtend().setId(id),list);
    }

    /**
    * saveByReviewContentExtend
    * @param reviewContentExtend
    * @param list
    * @return
    */
    boolean saveByReviewContentExtend(ReviewContentExtend reviewContentExtend, List<Relation> list);

    /**
    * findByPrincipalSprint
    * @param sprint
    * @return
    */
    List<Relation> findByPrincipalSprint(Sprint sprint);

    /**
    * saveByPrincipalSprint
    * @param sprint
    * @param list
    * @return
    */
    boolean saveByPrincipalSprint(Sprint sprint, List<Relation> list);

    /**
    * findByTargetId
    * @param targetIds
    * @return
    */
    List<Relation> findByTargetId(List<String> targetIds);
    default List<Relation> findByTargetId(String targetId){
        return findByTargetCustomer(new Customer().setId(targetId));
    }

    /**
    * findByTargetCustomer
    * @param customer
    * @return
    */
    List<Relation> findByTargetCustomer(Customer customer);

    /**
    * removeByTargetId
    * @param targetId
    * @return
    */
    boolean removeByTargetId(String targetId);

    /**
    * resetByTargetId
    * @param targetId
    * @return
    */
    boolean resetByTargetId(String targetId);

    /**
    * saveByTargetId
    * @param targetId
    * @param list
    * @return
    */
    default boolean saveByTargetId(String targetId, List<Relation> list){
        return getSelf().saveByTargetCustomer(new Customer().setId(targetId),list);
    }

    /**
    * saveByTargetCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByTargetCustomer(Customer customer, List<Relation> list);

    /**
    * findByTargetIdea
    * @param idea
    * @return
    */
    List<Relation> findByTargetIdea(Idea idea);

    /**
    * saveByTargetIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByTargetIdea(Idea idea, List<Relation> list);

    /**
    * findByTargetPage
    * @param articlePage
    * @return
    */
    List<Relation> findByTargetPage(ArticlePage articlePage);

    /**
    * saveByTargetPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByTargetPage(ArticlePage articlePage, List<Relation> list);

    /**
    * findByTargetProduct
    * @param product
    * @return
    */
    List<Relation> findByTargetProduct(Product product);

    /**
    * saveByTargetProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByTargetProduct(Product product, List<Relation> list);

    /**
    * findByTargetProductPlanCategory
    * @param productPlan
    * @return
    */
    List<Relation> findByTargetProductPlanCategory(ProductPlan productPlan);

    /**
    * saveByTargetProductPlanCategory
    * @param productPlan
    * @param list
    * @return
    */
    boolean saveByTargetProductPlanCategory(ProductPlan productPlan, List<Relation> list);

    /**
    * findByTargetProject
    * @param project
    * @return
    */
    List<Relation> findByTargetProject(Project project);

    /**
    * saveByTargetProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByTargetProject(Project project, List<Relation> list);

    /**
    * findByTargetRun
    * @param run
    * @return
    */
    List<Relation> findByTargetRun(Run run);

    /**
    * saveByTargetRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByTargetRun(Run run, List<Relation> list);

    /**
    * findByTargetTestCase
    * @param testCase
    * @return
    */
    List<Relation> findByTargetTestCase(TestCase testCase);

    /**
    * saveByTargetTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTargetTestCase(TestCase testCase, List<Relation> list);

    /**
    * findByTargetTicket
    * @param ticket
    * @return
    */
    List<Relation> findByTargetTicket(Ticket ticket);

    /**
    * saveByTargetTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTargetTicket(Ticket ticket, List<Relation> list);

    /**
    * findByTargetWorkItem
    * @param workItem
    * @return
    */
    List<Relation> findByTargetWorkItem(WorkItem workItem);

    /**
    * saveByTargetWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByTargetWorkItem(WorkItem workItem, List<Relation> list);

    /**
    * findByPrincipalTestCase
    * @param testCase
    * @return
    */
    List<Relation> findByPrincipalTestCase(TestCase testCase);

    /**
    * saveByPrincipalTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByPrincipalTestCase(TestCase testCase, List<Relation> list);

    /**
    * findByPrincipalTestPlan
    * @param testPlan
    * @return
    */
    List<Relation> findByPrincipalTestPlan(TestPlan testPlan);

    /**
    * saveByPrincipalTestPlan
    * @param testPlan
    * @param list
    * @return
    */
    boolean saveByPrincipalTestPlan(TestPlan testPlan, List<Relation> list);

    /**
    * findByPrincipalWorkItem
    * @param workItem
    * @return
    */
    List<Relation> findByPrincipalWorkItem(WorkItem workItem);

    /**
    * saveByPrincipalWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByPrincipalWorkItem(WorkItem workItem, List<Relation> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Relation> fetchView(RelationSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Relation> listView(RelationSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Relation> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Relation et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getName(),ex.getMessage());
                if(!ignoreError)
                    break;
            }
        }
        return rt;
    }
	
    /**
     * 创建实体对象
     * @return
     */
    default Relation getEntity() {
        return new Relation();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default RelationSearchContext getSearchContext() {
        return new RelationSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}