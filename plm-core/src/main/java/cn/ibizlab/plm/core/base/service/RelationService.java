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
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.filter.RelationSearchContext;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;

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
     * 获取
     * @param et
     * @return
     */
    Relation get(Relation et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Relation get(String key) {
        return getSelf().get(new Relation().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Relation> getByIds(Collection<String> ids) {
        List<Relation> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Relation().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Relation> getByEntities(List<Relation> entities);

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
    Integer checkKey(Relation et);

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
    boolean createBatch(List<Relation> list);

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
    boolean updateBatch(List<Relation> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Relation et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Relation> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Relation().setId(key));
    }
    /**
     * 根据keys批量删除
     * @param keys
     * @return
     */
    default boolean remove(List<String> keys) {
        return removeBatch(keys);
    }
    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Relation et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Relation> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Relation().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Relation> entities);

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
     * del_relation
     * 
     * @param dto
     * @return
     */
    default Relation delRelation(Relation dto) {
        return dto;
    }

    /**
     * program_test_case
     * 
     * @param dto
     * @return
     */
    default Relation programTestCase(Relation dto) {
        return dto;
    }

    /**
     * run_del_relation_bug
     * 
     * @param dto
     * @return
     */
    default Relation runDelRelationBug(Relation dto) {
        return dto;
    }

    /**
     * test_case_del_relation_bug
     * 
     * @param dto
     * @return
     */
    default Relation testCaseDelRelationBug(Relation dto) {
        return dto;
    }

    /**
     * work_item_del_relation_case
     * 
     * @param dto
     * @return
     */
    default Relation workItemDelRelationCase(Relation dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Relation> searchDefault(RelationSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Relation> listDefault(RelationSearchContext context);

    /**
     * searchall
     * 
     * @param context
     * @return
     */
    Page<Relation> searchAll(RelationSearchContext context);
    /**
     * listall
     * 
     * @param context
     * @return
     */
    List<Relation> listAll(RelationSearchContext context);

    /**
     * searchexists_run_relation_bug
     * 
     * @param context
     * @return
     */
    Page<Relation> searchExistsRunRelationBug(RelationSearchContext context);
    /**
     * listexists_run_relation_bug
     * 
     * @param context
     * @return
     */
    List<Relation> listExistsRunRelationBug(RelationSearchContext context);

    /**
     * searchidea_re_customer
     * 
     * @param context
     * @return
     */
    Page<Relation> searchIdeaReCustomer(RelationSearchContext context);
    /**
     * listidea_re_customer
     * 
     * @param context
     * @return
     */
    List<Relation> listIdeaReCustomer(RelationSearchContext context);

    /**
     * searchidea_re_idea
     * 
     * @param context
     * @return
     */
    Page<Relation> searchIdeaReIdea(RelationSearchContext context);
    /**
     * listidea_re_idea
     * 
     * @param context
     * @return
     */
    List<Relation> listIdeaReIdea(RelationSearchContext context);

    /**
     * searchidea_re_test_case
     * 
     * @param context
     * @return
     */
    Page<Relation> searchIdeaReTestCase(RelationSearchContext context);
    /**
     * listidea_re_test_case
     * 
     * @param context
     * @return
     */
    List<Relation> listIdeaReTestCase(RelationSearchContext context);

    /**
     * searchidea_re_ticket
     * 
     * @param context
     * @return
     */
    Page<Relation> searchIdeaReTicket(RelationSearchContext context);
    /**
     * listidea_re_ticket
     * 
     * @param context
     * @return
     */
    List<Relation> listIdeaReTicket(RelationSearchContext context);

    /**
     * searchidea_re_work_item
     * 
     * @param context
     * @return
     */
    Page<Relation> searchIdeaReWorkItem(RelationSearchContext context);
    /**
     * listidea_re_work_item
     * 
     * @param context
     * @return
     */
    List<Relation> listIdeaReWorkItem(RelationSearchContext context);

    /**
     * searchidea_version_relation
     * 主实体版本创建时，查询关联principal_type为需求的数据存入version_data
     * @param context
     * @return
     */
    Page<Relation> searchIdeaVersionRelation(RelationSearchContext context);
    /**
     * listidea_version_relation
     * 主实体版本创建时，查询关联principal_type为需求的数据存入version_data
     * @param context
     * @return
     */
    List<Relation> listIdeaVersionRelation(RelationSearchContext context);

    /**
     * searchreview_re_test_case
     * 
     * @param context
     * @return
     */
    Page<Relation> searchReviewReTestCase(RelationSearchContext context);
    /**
     * listreview_re_test_case
     * 
     * @param context
     * @return
     */
    List<Relation> listReviewReTestCase(RelationSearchContext context);

    /**
     * searchrun_re_bug
     * 
     * @param context
     * @return
     */
    Page<Relation> searchRunReBug(RelationSearchContext context);
    /**
     * listrun_re_bug
     * 
     * @param context
     * @return
     */
    List<Relation> listRunReBug(RelationSearchContext context);

    /**
     * searchrun_re_idea
     * 
     * @param context
     * @return
     */
    Page<Relation> searchRunReIdea(RelationSearchContext context);
    /**
     * listrun_re_idea
     * 
     * @param context
     * @return
     */
    List<Relation> listRunReIdea(RelationSearchContext context);

    /**
     * searchrun_re_work_item
     * 
     * @param context
     * @return
     */
    Page<Relation> searchRunReWorkItem(RelationSearchContext context);
    /**
     * listrun_re_work_item
     * 
     * @param context
     * @return
     */
    List<Relation> listRunReWorkItem(RelationSearchContext context);

    /**
     * searchtest_case_re_bug
     * 仅关联缺陷类型工作项
     * @param context
     * @return
     */
    Page<Relation> searchTestCaseReBug(RelationSearchContext context);
    /**
     * listtest_case_re_bug
     * 仅关联缺陷类型工作项
     * @param context
     * @return
     */
    List<Relation> listTestCaseReBug(RelationSearchContext context);

    /**
     * searchtest_case_re_idea
     * 
     * @param context
     * @return
     */
    Page<Relation> searchTestCaseReIdea(RelationSearchContext context);
    /**
     * listtest_case_re_idea
     * 
     * @param context
     * @return
     */
    List<Relation> listTestCaseReIdea(RelationSearchContext context);

    /**
     * searchtest_case_re_work_item
     * 排除了缺陷类型的工作项
     * @param context
     * @return
     */
    Page<Relation> searchTestCaseReWorkItem(RelationSearchContext context);
    /**
     * listtest_case_re_work_item
     * 排除了缺陷类型的工作项
     * @param context
     * @return
     */
    List<Relation> listTestCaseReWorkItem(RelationSearchContext context);

    /**
     * searchtest_case_version_relation
     * 主实体版本创建时，查询关联principal_type为用例的数据存入version_data
     * @param context
     * @return
     */
    Page<Relation> searchTestCaseVersionRelation(RelationSearchContext context);
    /**
     * listtest_case_version_relation
     * 主实体版本创建时，查询关联principal_type为用例的数据存入version_data
     * @param context
     * @return
     */
    List<Relation> listTestCaseVersionRelation(RelationSearchContext context);

    /**
     * searchticket_re_idea
     * 
     * @param context
     * @return
     */
    Page<Relation> searchTicketReIdea(RelationSearchContext context);
    /**
     * listticket_re_idea
     * 
     * @param context
     * @return
     */
    List<Relation> listTicketReIdea(RelationSearchContext context);

    /**
     * searchticket_re_self
     * 
     * @param context
     * @return
     */
    Page<Relation> searchTicketReSelf(RelationSearchContext context);
    /**
     * listticket_re_self
     * 
     * @param context
     * @return
     */
    List<Relation> listTicketReSelf(RelationSearchContext context);

    /**
     * searchticket_re_work_item
     * 
     * @param context
     * @return
     */
    Page<Relation> searchTicketReWorkItem(RelationSearchContext context);
    /**
     * listticket_re_work_item
     * 
     * @param context
     * @return
     */
    List<Relation> listTicketReWorkItem(RelationSearchContext context);

    /**
     * searchwork_item_relation_idea
     * 
     * @param context
     * @return
     */
    Page<Relation> searchWorkItemRelationIdea(RelationSearchContext context);
    /**
     * listwork_item_relation_idea
     * 
     * @param context
     * @return
     */
    List<Relation> listWorkItemRelationIdea(RelationSearchContext context);

    /**
     * searchwork_item_relation_self
     * 
     * @param context
     * @return
     */
    Page<Relation> searchWorkItemRelationSelf(RelationSearchContext context);
    /**
     * listwork_item_relation_self
     * 
     * @param context
     * @return
     */
    List<Relation> listWorkItemRelationSelf(RelationSearchContext context);

    /**
     * searchwork_item_relation_test_case
     * 
     * @param context
     * @return
     */
    Page<Relation> searchWorkItemRelationTestCase(RelationSearchContext context);
    /**
     * listwork_item_relation_test_case
     * 
     * @param context
     * @return
     */
    List<Relation> listWorkItemRelationTestCase(RelationSearchContext context);

    /**
     * searchwork_item_relation_ticket
     * 
     * @param context
     * @return
     */
    Page<Relation> searchWorkItemRelationTicket(RelationSearchContext context);
    /**
     * listwork_item_relation_ticket
     * 
     * @param context
     * @return
     */
    List<Relation> listWorkItemRelationTicket(RelationSearchContext context);

    /**
     * searchwork_item_version_relation
     * 主实体版本创建时，查询关联principal_type为工作项的数据存入version_data
     * @param context
     * @return
     */
    Page<Relation> searchWorkItemVersionRelation(RelationSearchContext context);
    /**
     * listwork_item_version_relation
     * 主实体版本创建时，查询关联principal_type为工作项的数据存入version_data
     * @param context
     * @return
     */
    List<Relation> listWorkItemVersionRelation(RelationSearchContext context);

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
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<Relation> findByPrincipalId(List<String> principalIds);
    default List<Relation> findByPrincipalId(String principalId) {
        return findByPrincipalId(Arrays.asList(principalId));
    }
    /**
     * removeRelByPrincipalId
     * @param principalId
     * @return
     */
    boolean removeByPrincipalId(String principalId);
    /**
     * resetRelByPrincipalId
     * @param principalId
     * @return
     */
    boolean resetByPrincipalId(String principalId);
    /**
     * saveRelByPrincipalId
     * @param principalId
     * @param list
     * @return
     */
    default boolean saveByPrincipalId(String principalId,List<Relation> list) {
        return getSelf().saveByPrincipalBaseline(new Baseline().setId(principalId),list);
    }
    /**
    * saveRelByPrincipalBaseline
    * @param baseline
    * @param list
    * @return
    */
    boolean saveByPrincipalBaseline(Baseline baseline,List<Relation> list);

    /**
    * saveRelByPrincipalIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByPrincipalIdea(Idea idea,List<Relation> list);

    /**
    * saveRelByPrincipalReview
    * @param review
    * @param list
    * @return
    */
    boolean saveByPrincipalReview(Review review,List<Relation> list);

    /**
     * selectRelById
     * @param ids
     * @return
     */
    List<Relation> findById(List<String> ids);
    default List<Relation> findById(String id) {
        return findById(Arrays.asList(id));
    }
    /**
     * removeRelById
     * @param id
     * @return
     */
    boolean removeById(String id);
    /**
     * resetRelById
     * @param id
     * @return
     */
    boolean resetById(String id);
    /**
     * saveRelById
     * @param id
     * @param list
     * @return
     */
    default boolean saveById(String id,List<Relation> list) {
        return getSelf().saveByReviewContentExtend(new ReviewContentExtend().setId(id),list);
    }
    /**
    * saveRelByReviewContentExtend
    * @param reviewContentExtend
    * @param list
    * @return
    */
    boolean saveByReviewContentExtend(ReviewContentExtend reviewContentExtend,List<Relation> list);

    /**
     * selectRelByTargetId
     * @param targetIds
     * @return
     */
    List<Relation> findByTargetId(List<String> targetIds);
    default List<Relation> findByTargetId(String targetId) {
        return findByTargetId(Arrays.asList(targetId));
    }
    /**
     * removeRelByTargetId
     * @param targetId
     * @return
     */
    boolean removeByTargetId(String targetId);
    /**
     * resetRelByTargetId
     * @param targetId
     * @return
     */
    boolean resetByTargetId(String targetId);
    /**
     * saveRelByTargetId
     * @param targetId
     * @param list
     * @return
     */
    default boolean saveByTargetId(String targetId,List<Relation> list) {
        return getSelf().saveByTargetCustomer(new Customer().setId(targetId),list);
    }
    /**
    * saveRelByTargetCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByTargetCustomer(Customer customer,List<Relation> list);

    /**
    * saveRelByTargetIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByTargetIdea(Idea idea,List<Relation> list);

    /**
    * saveRelByTargetProductPlanCategory
    * @param productPlan
    * @param list
    * @return
    */
    boolean saveByTargetProductPlanCategory(ProductPlan productPlan,List<Relation> list);

    /**
    * saveRelByTargetTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTargetTestCase(TestCase testCase,List<Relation> list);

    /**
    * saveRelByTargetTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTargetTicket(Ticket ticket,List<Relation> list);

    /**
    * saveRelByTargetWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByTargetWorkItem(WorkItem workItem,List<Relation> list);

    /**
    * saveRelByPrincipalTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByPrincipalTestCase(TestCase testCase,List<Relation> list);

    /**
    * saveRelByPrincipalTestPlan
    * @param testPlan
    * @param list
    * @return
    */
    boolean saveByPrincipalTestPlan(TestPlan testPlan,List<Relation> list);

    /**
    * saveRelByPrincipalWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByPrincipalWorkItem(WorkItem workItem,List<Relation> list);


    /**
     * 自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    List<JSONObject> select(String sql, Map<String,Object> param);

    /**
     * 自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    boolean execute(String sql, Map<String,Object> param);

}