/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.base.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.filter.RelationSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 关联Mapper[Relation]
 *
 * @author generator
 */
public interface RelationMapper extends BaseMapper<Relation> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchDefault(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listDefault(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合all分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchAll(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合all查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listAll(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合dependency_work_items分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchDependencyWorkItems(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合dependency_work_items查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listDependencyWorkItems(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合exists_run_relation_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchExistsRunRelationBug(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合exists_run_relation_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listExistsRunRelationBug(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合idea_re_customer分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchIdeaReCustomer(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合idea_re_customer查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listIdeaReCustomer(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合idea_re_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchIdeaReIdea(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合idea_re_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listIdeaReIdea(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合idea_re_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchIdeaReTestCase(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合idea_re_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listIdeaReTestCase(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合idea_re_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchIdeaReTicket(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合idea_re_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listIdeaReTicket(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合idea_re_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchIdeaReWorkItem(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合idea_re_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listIdeaReWorkItem(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合idea_version_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchIdeaVersionRelation(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合idea_version_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listIdeaVersionRelation(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合product_plan_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchProductPlanIdea(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合product_plan_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listProductPlanIdea(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合product_re_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchProductReProject(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合product_re_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listProductReProject(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合project_re_product分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchProjectReProduct(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合project_re_product查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listProjectReProduct(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合review_re_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchReviewReTestCase(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合review_re_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listReviewReTestCase(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合run_re_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchRunReBug(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合run_re_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listRunReBug(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合run_re_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchRunReIdea(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合run_re_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listRunReIdea(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合run_re_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchRunReWorkItem(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合run_re_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listRunReWorkItem(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合test_case_re_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchTestCaseReBug(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合test_case_re_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listTestCaseReBug(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合test_case_re_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchTestCaseReIdea(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合test_case_re_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listTestCaseReIdea(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合test_case_re_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchTestCaseReWorkItem(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合test_case_re_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listTestCaseReWorkItem(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合test_case_version_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchTestCaseVersionRelation(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合test_case_version_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listTestCaseVersionRelation(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合ticket_re_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchTicketReIdea(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合ticket_re_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listTicketReIdea(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合ticket_re_self分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchTicketReSelf(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合ticket_re_self查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listTicketReSelf(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合ticket_re_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchTicketReWorkItem(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合ticket_re_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listTicketReWorkItem(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合work_item_relation_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchWorkItemRelationIdea(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合work_item_relation_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listWorkItemRelationIdea(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合work_item_relation_self分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchWorkItemRelationSelf(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合work_item_relation_self查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listWorkItemRelationSelf(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合work_item_relation_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchWorkItemRelationTestCase(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合work_item_relation_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listWorkItemRelationTestCase(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合work_item_relation_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchWorkItemRelationTicket(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合work_item_relation_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listWorkItemRelationTicket(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 数据集合work_item_version_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchWorkItemVersionRelation(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合work_item_version_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listWorkItemVersionRelation(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
    * 根据principalId查询
    *
    * @param principalIds
    * @return
    */
    List<Relation> findByPrincipalId(@Param("principalIds") List<String> principalIds);

    /**
    * 根据id查询
    *
    * @param ids
    * @return
    */
    List<Relation> findById(@Param("ids") List<String> ids);

    /**
    * 根据targetId查询
    *
    * @param targetIds
    * @return
    */
    List<Relation> findByTargetId(@Param("targetIds") List<String> targetIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Relation> searchView(IPage<Relation> page, @Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Relation> listView(@Param("ctx") RelationSearchContext context, @Param("ew") Wrapper<Relation> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Relation selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Relation selectEntity(Relation entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Relation> selectEntities(@Param("list") List<Relation> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Relation entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Relation entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Relation entity, @Param("ew") Wrapper<Relation> updateWrapper);

    /**
     * 主键删除
     *
     * @param id
     * @return
     */
    @Override
    int deleteById(Serializable id);

    /**
     * 数据对象集合删除
     *
     * @param list
     * @return
     */
    int deleteEntities(@Param("list") List<Relation> list);

    /**
     * 自定义查询SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Select("${sql}")
    List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义更新SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义插入SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义删除SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);
}