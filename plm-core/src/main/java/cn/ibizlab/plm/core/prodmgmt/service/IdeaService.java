/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaSearchContext;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attachment;

/**
 * 需求服务接口[IdeaService]
 *
 * @author generator
 */
public interface IdeaService extends IService<Idea> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default IdeaService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Idea get(Idea et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Idea get(String key) {
        return getSelf().get(new Idea().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Idea> getByIds(Collection<String> ids) {
        List<Idea> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Idea().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Idea> getByEntities(List<Idea> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Idea getDraft(Idea et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Idea et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Idea et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Idea> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Idea et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Idea> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Idea et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Idea> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Idea().setId(key));
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
    boolean remove(Idea et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Idea> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Idea().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Idea> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Idea> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Idea et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getTitle(),ex.getMessage());
                if(!ignoreError)
                    break;
            }
        }
        return rt;
    }

    /**
     * Activate
     * 
     * @param dto
     * @return
     */
    default Idea activate(Idea dto) {
        return dto;
    }

    /**
     * Archive
     * 
     * @param dto
     * @return
     */
    default Idea archive(Idea dto) {
        return dto;
    }

    /**
     * Change_state
     * 
     * @param dto
     * @return
     */
    default Idea changeState(Idea dto) {
        return dto;
    }

    /**
     * Del_relation
     * 
     * @param dto
     * @return
     */
    default Idea delRelation(Idea dto) {
        return dto;
    }

    /**
     * Delete
     * 
     * @param dto
     * @return
     */
    default Idea delete(Idea dto) {
        return dto;
    }

    /**
     * Get_actual_workload
     * 
     * @param key
     * @return
     */
    default Idea getActualWorkload(String key) {
        return null;
    }

    /**
     * Get_attention
     * 
     * @param key
     * @return
     */
    default Idea getAttention(String key) {
        return null;
    }

    /**
     * Idea_category
     * 
     * @param dto
     * @return
     */
    default Idea ideaCategory(Idea dto) {
        return dto;
    }

    /**
     * Idea_copy
     * 
     * @param dto
     * @return
     */
    default Idea ideaCopy(Idea dto) {
        return dto;
    }

    /**
     * Idea_move
     * 
     * @param dto
     * @return
     */
    default Idea ideaMove(Idea dto) {
        return dto;
    }

    /**
     * Idea_re_plan
     * 
     * @param dto
     * @return
     */
    default Idea ideaRePlan(Idea dto) {
        return dto;
    }

    /**
     * Nothing
     * 
     * @param dto
     * @return
     */
    default Idea nothing(Idea dto) {
        return dto;
    }

    /**
     * Others_relation_idea
     * 
     * @param dto
     * @return
     */
    default Idea othersRelationIdea(Idea dto) {
        return dto;
    }

    /**
     * Plan_delete_idea
     * 
     * @param dto
     * @return
     */
    default Idea planDeleteIdea(Idea dto) {
        return dto;
    }

    /**
     * Product_get_category
     * 
     * @param dto
     * @return
     */
    default Idea productGetCategory(Idea dto) {
        return dto;
    }

    /**
     * Product_idea_re_counters
     * 
     * @param dto
     * @return
     */
    default Idea productIdeaReCounters(Idea dto) {
        return dto;
    }

    /**
     * Recover
     * 
     * @param dto
     * @return
     */
    default Idea recover(Idea dto) {
        return dto;
    }

    /**
     * searchArchived
     * 
     * @param context
     * @return
     */
    Page<Idea> searchArchived(IdeaSearchContext context);
    /**
     * listArchived
     * 
     * @param context
     * @return
     */
    List<Idea> listArchived(IdeaSearchContext context);

    /**
     * searchComment_notify_assignee
     * 
     * @param context
     * @return
     */
    Page<Idea> searchCommentNotifyAssignee(IdeaSearchContext context);
    /**
     * listComment_notify_assignee
     * 
     * @param context
     * @return
     */
    List<Idea> listCommentNotifyAssignee(IdeaSearchContext context);

    /**
     * searchCommon
     * 
     * @param context
     * @return
     */
    Page<Idea> searchCommon(IdeaSearchContext context);
    /**
     * listCommon
     * 
     * @param context
     * @return
     */
    List<Idea> listCommon(IdeaSearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Idea> searchDefault(IdeaSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Idea> listDefault(IdeaSearchContext context);

    /**
     * searchDeleted
     * 
     * @param context
     * @return
     */
    Page<Idea> searchDeleted(IdeaSearchContext context);
    /**
     * listDeleted
     * 
     * @param context
     * @return
     */
    List<Idea> listDeleted(IdeaSearchContext context);

    /**
     * searchIdea_relation_idea
     * 
     * @param context
     * @return
     */
    Page<Idea> searchIdeaRelationIdea(IdeaSearchContext context);
    /**
     * listIdea_relation_idea
     * 
     * @param context
     * @return
     */
    List<Idea> listIdeaRelationIdea(IdeaSearchContext context);

    /**
     * searchMy_assign
     * 
     * @param context
     * @return
     */
    Page<Idea> searchMyAssign(IdeaSearchContext context);
    /**
     * listMy_assign
     * 
     * @param context
     * @return
     */
    List<Idea> listMyAssign(IdeaSearchContext context);

    /**
     * searchMy_assignee_count
     * 
     * @param context
     * @return
     */
    Page<Idea> searchMyAssigneeCount(IdeaSearchContext context);
    /**
     * listMy_assignee_count
     * 
     * @param context
     * @return
     */
    List<Idea> listMyAssigneeCount(IdeaSearchContext context);

    /**
     * searchMy_attention
     * 
     * @param context
     * @return
     */
    Page<Idea> searchMyAttention(IdeaSearchContext context);
    /**
     * listMy_attention
     * 
     * @param context
     * @return
     */
    List<Idea> listMyAttention(IdeaSearchContext context);

    /**
     * searchMy_created
     * 
     * @param context
     * @return
     */
    Page<Idea> searchMyCreated(IdeaSearchContext context);
    /**
     * listMy_created
     * 
     * @param context
     * @return
     */
    List<Idea> listMyCreated(IdeaSearchContext context);

    /**
     * searchNormal
     * 
     * @param context
     * @return
     */
    Page<Idea> searchNormal(IdeaSearchContext context);
    /**
     * listNormal
     * 
     * @param context
     * @return
     */
    List<Idea> listNormal(IdeaSearchContext context);

    /**
     * searchNot_exsists_relation
     * 
     * @param context
     * @return
     */
    Page<Idea> searchNotExsistsRelation(IdeaSearchContext context);
    /**
     * listNot_exsists_relation
     * 
     * @param context
     * @return
     */
    List<Idea> listNotExsistsRelation(IdeaSearchContext context);

    /**
     * searchPlan_relation_idea
     * 
     * @param context
     * @return
     */
    Page<Idea> searchPlanRelationIdea(IdeaSearchContext context);
    /**
     * listPlan_relation_idea
     * 
     * @param context
     * @return
     */
    List<Idea> listPlanRelationIdea(IdeaSearchContext context);

    /**
     * searchRecent_idea
     * 
     * @param context
     * @return
     */
    Page<Idea> searchRecentIdea(IdeaSearchContext context);
    /**
     * listRecent_idea
     * 
     * @param context
     * @return
     */
    List<Idea> listRecentIdea(IdeaSearchContext context);

    /**
     * searchTest_case_relation
     * 
     * @param context
     * @return
     */
    Page<Idea> searchTestCaseRelation(IdeaSearchContext context);
    /**
     * listTest_case_relation
     * 
     * @param context
     * @return
     */
    List<Idea> listTestCaseRelation(IdeaSearchContext context);

    /**
     * searchTicket_relation_idea
     * 
     * @param context
     * @return
     */
    Page<Idea> searchTicketRelationIdea(IdeaSearchContext context);
    /**
     * listTicket_relation_idea
     * 
     * @param context
     * @return
     */
    List<Idea> listTicketRelationIdea(IdeaSearchContext context);

    /**
     * searchWork_item_relation_idea
     * 
     * @param context
     * @return
     */
    Page<Idea> searchWorkItemRelationIdea(IdeaSearchContext context);
    /**
     * listWork_item_relation_idea
     * 
     * @param context
     * @return
     */
    List<Idea> listWorkItemRelationIdea(IdeaSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Idea getEntity() {
        return new Idea();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default IdeaSearchContext getSearchContext() {
        return new IdeaSearchContext();
    }
    /**
     * selectRelByCategoryId
     * @param categoryIds
     * @return
     */
    List<Idea> findByCategoryId(List<String> categoryIds);
    default List<Idea> findByCategoryId(String categoryId) {
        return findByCategoryId(Arrays.asList(categoryId));
    }
    /**
     * removeRelByCategoryId
     * @param categoryId
     * @return
     */
    boolean removeByCategoryId(String categoryId);
    /**
     * resetRelByCategoryId
     * @param categoryId
     * @return
     */
    boolean resetByCategoryId(String categoryId);
    /**
     * saveRelByCategoryId
     * @param categoryId
     * @param list
     * @return
     */
    default boolean saveByCategoryId(String categoryId,List<Idea> list) {
        return getSelf().saveByCategory(new Category().setId(categoryId),list);
    }
    /**
    * saveRelByCategory
    * @param category
    * @param list
    * @return
    */
    boolean saveByCategory(Category category,List<Idea> list);

    /**
     * selectRelByProductId
     * @param productIds
     * @return
     */
    List<Idea> findByProductId(List<String> productIds);
    default List<Idea> findByProductId(String productId) {
        return findByProductId(Arrays.asList(productId));
    }
    /**
     * removeRelByProductId
     * @param productId
     * @return
     */
    boolean removeByProductId(String productId);
    /**
     * resetRelByProductId
     * @param productId
     * @return
     */
    boolean resetByProductId(String productId);
    /**
     * saveRelByProductId
     * @param productId
     * @param list
     * @return
     */
    default boolean saveByProductId(String productId,List<Idea> list) {
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }
    /**
    * saveRelByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product,List<Idea> list);

    /**
     * selectRelByAssigneeId
     * @param assigneeIds
     * @return
     */
    List<Idea> findByAssigneeId(List<String> assigneeIds);
    default List<Idea> findByAssigneeId(String assigneeId) {
        return findByAssigneeId(Arrays.asList(assigneeId));
    }
    /**
     * removeRelByAssigneeId
     * @param assigneeId
     * @return
     */
    boolean removeByAssigneeId(String assigneeId);
    /**
     * resetRelByAssigneeId
     * @param assigneeId
     * @return
     */
    boolean resetByAssigneeId(String assigneeId);
    /**
     * saveRelByAssigneeId
     * @param assigneeId
     * @param list
     * @return
     */
    default boolean saveByAssigneeId(String assigneeId,List<Idea> list) {
        return getSelf().saveByUser(new User().setId(assigneeId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<Idea> list);

    default List<Attention> getAttentions(Idea et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(Idea et) {
        return new ArrayList<>();
    }


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