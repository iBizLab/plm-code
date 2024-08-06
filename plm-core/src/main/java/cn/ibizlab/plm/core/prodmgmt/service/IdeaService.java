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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaSearchContext;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Version;

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
    boolean create(List<Idea> list);

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
    boolean update(List<Idea> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Idea().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Idea et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Idea> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Idea().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Idea> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Idea get(String key) {
        return getSelf().get(new Idea().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Idea get(Idea et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Idea> get(Collection<String> keys) {
        List<Idea> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Idea().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Idea> get(List<Idea> entities);

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
    CheckKeyStatus checkKey(Idea et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Idea et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Idea> list);

    /**
    * activate
    * 
    * @param et
    * @return
    */
    default Idea activate(Idea et) {
        return et;
    }

    /**
    * archive
    * 
    * @param et
    * @return
    */
    default Idea archive(Idea et) {
        return et;
    }

    /**
    * changeState
    * 
    * @param et
    * @return
    */
    default Idea changeState(Idea et) {
        return et;
    }

    /**
    * chooseCaseTemplate
    * 
    * @param et
    * @return
    */
    default Idea chooseCaseTemplate(Idea et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default Idea delete(Idea et) {
        return et;
    }

    /**
    * getAttention
    * 
    * @param key
    * @return
    */
    default Idea getAttention(String key) {
        return null;
    }

    /**
    * getBaselineName
    * 
    * @param key
    * @return
    */
    default Idea getBaselineName(String key) {
        return getSelf().getBaselineName(new Idea().setId(key));
    }

    /**
    * getCustomerScore
    * 获取客户分数数据
    * @param key
    * @return
    */
    default Idea getCustomerScore(String key) {
        return getSelf().getCustomerScore(new Idea().setId(key));
    }

    /**
    * getTicketNum
    * 
    * @param key
    * @return
    */
    default Idea getTicketNum(String key) {
        return getSelf().getTicketNum(new Idea().setId(key));
    }

    /**
    * ideaCategory
    * 
    * @param et
    * @return
    */
    default Idea ideaCategory(Idea et) {
        return et;
    }

    /**
    * ideaCopy
    * 
    * @param et
    * @return
    */
    default Idea ideaCopy(Idea et) {
        return et;
    }

    /**
    * ideaMove
    * 
    * @param et
    * @return
    */
    default Idea ideaMove(Idea et) {
        return et;
    }

    /**
    * ideaRePlan
    * 
    * @param et
    * @return
    */
    default Idea ideaRePlan(Idea et) {
        return et;
    }

    /**
    * ideaReadonlyRecognize
    * 
    * @param et
    * @return
    */
    default Idea ideaReadonlyRecognize(Idea et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Idea nothing(Idea et) {
        return et;
    }

    /**
    * othersRelationIdea
    * 
    * @param et
    * @return
    */
    default Idea othersRelationIdea(Idea et) {
        return et;
    }

    /**
    * planDeleteIdea
    * 
    * @param et
    * @return
    */
    default Idea planDeleteIdea(Idea et) {
        return et;
    }

    /**
    * productIdeaReCounters
    * 
    * @param et
    * @return
    */
    default Idea productIdeaReCounters(Idea et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default Idea recover(Idea et) {
        return et;
    }

    /**
    * fetchDefault
    * 默认普通数据查询
    * @param context
    * @return
    */
    Page<Idea> fetchDefault(IdeaSearchContext context);

    /**
    * listDefault
    * 默认普通数据查询
    * @param context
    * @return
    */
    List<Idea> listDefault(IdeaSearchContext context);

    /**
    * fetchAdvancedSearch
    * 指定属性组；查询未删除的需求数据
    * @param context
    * @return
    */
    Page<Idea> fetchAdvancedSearch(IdeaSearchContext context);

    /**
    * listAdvancedSearch
    * 指定属性组；查询未删除的需求数据
    * @param context
    * @return
    */
    List<Idea> listAdvancedSearch(IdeaSearchContext context);

    /**
    * fetchArchived
    * 查询已归档且未删除的需求数据
    * @param context
    * @return
    */
    Page<Idea> fetchArchived(IdeaSearchContext context);

    /**
    * listArchived
    * 查询已归档且未删除的需求数据
    * @param context
    * @return
    */
    List<Idea> listArchived(IdeaSearchContext context);

    /**
    * fetchBaselineChooseIdea
    * 基线选择需求
    * @param context
    * @return
    */
    Page<Idea> fetchBaselineChooseIdea(IdeaSearchContext context);

    /**
    * listBaselineChooseIdea
    * 基线选择需求
    * @param context
    * @return
    */
    List<Idea> listBaselineChooseIdea(IdeaSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<Idea> fetchBiDetail(IdeaSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<Idea> listBiDetail(IdeaSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<Idea> fetchBiSearch(IdeaSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<Idea> listBiSearch(IdeaSearchContext context);

    /**
    * fetchCommentNotifyAssignee
    * 查询指定属性组；评论负责人
    * @param context
    * @return
    */
    Page<Idea> fetchCommentNotifyAssignee(IdeaSearchContext context);

    /**
    * listCommentNotifyAssignee
    * 查询指定属性组；评论负责人
    * @param context
    * @return
    */
    List<Idea> listCommentNotifyAssignee(IdeaSearchContext context);

    /**
    * fetchCommon
    * 状态非删除，如果上下文传递了类别参数，显示该类别下数据
    * @param context
    * @return
    */
    Page<Idea> fetchCommon(IdeaSearchContext context);

    /**
    * listCommon
    * 状态非删除，如果上下文传递了类别参数，显示该类别下数据
    * @param context
    * @return
    */
    List<Idea> listCommon(IdeaSearchContext context);

    /**
    * fetchDeleted
    * 查询已删除的需求数据
    * @param context
    * @return
    */
    Page<Idea> fetchDeleted(IdeaSearchContext context);

    /**
    * listDeleted
    * 查询已删除的需求数据
    * @param context
    * @return
    */
    List<Idea> listDeleted(IdeaSearchContext context);

    /**
    * fetchMyAssign
    * 非归档数据，且负责人为当前登录人的数据
    * @param context
    * @return
    */
    Page<Idea> fetchMyAssign(IdeaSearchContext context);

    /**
    * listMyAssign
    * 非归档数据，且负责人为当前登录人的数据
    * @param context
    * @return
    */
    List<Idea> listMyAssign(IdeaSearchContext context);

    /**
    * fetchMyAssigneeCount
    * 非归档数据，且负责人为当前登录人的数据
    * @param context
    * @return
    */
    Page<Idea> fetchMyAssigneeCount(IdeaSearchContext context);

    /**
    * listMyAssigneeCount
    * 非归档数据，且负责人为当前登录人的数据
    * @param context
    * @return
    */
    List<Idea> listMyAssigneeCount(IdeaSearchContext context);

    /**
    * fetchMyAttention
    * 查询我关注的需求（未归档、未删除）
    * @param context
    * @return
    */
    Page<Idea> fetchMyAttention(IdeaSearchContext context);

    /**
    * listMyAttention
    * 查询我关注的需求（未归档、未删除）
    * @param context
    * @return
    */
    List<Idea> listMyAttention(IdeaSearchContext context);

    /**
    * fetchMyCreated
    * 首页我创建的需求表格调用
    * @param context
    * @return
    */
    Page<Idea> fetchMyCreated(IdeaSearchContext context);

    /**
    * listMyCreated
    * 首页我创建的需求表格调用
    * @param context
    * @return
    */
    List<Idea> listMyCreated(IdeaSearchContext context);

    /**
    * fetchNormal
    * 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求
    * @param context
    * @return
    */
    Page<Idea> fetchNormal(IdeaSearchContext context);

    /**
    * listNormal
    * 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求
    * @param context
    * @return
    */
    List<Idea> listNormal(IdeaSearchContext context);

    /**
    * fetchNotExsistsRelation
    * 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。
    * @param context
    * @return
    */
    Page<Idea> fetchNotExsistsRelation(IdeaSearchContext context);

    /**
    * listNotExsistsRelation
    * 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。
    * @param context
    * @return
    */
    List<Idea> listNotExsistsRelation(IdeaSearchContext context);

    /**
    * fetchNotifyAssignee
    * 查询指定属性组（负责人相关）
    * @param context
    * @return
    */
    Page<Idea> fetchNotifyAssignee(IdeaSearchContext context);

    /**
    * listNotifyAssignee
    * 查询指定属性组（负责人相关）
    * @param context
    * @return
    */
    List<Idea> listNotifyAssignee(IdeaSearchContext context);

    /**
    * fetchPlanRelationIdea
    * 计划关联需求表格调用
    * @param context
    * @return
    */
    Page<Idea> fetchPlanRelationIdea(IdeaSearchContext context);

    /**
    * listPlanRelationIdea
    * 计划关联需求表格调用
    * @param context
    * @return
    */
    List<Idea> listPlanRelationIdea(IdeaSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Idea> fetchReader(IdeaSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Idea> listReader(IdeaSearchContext context);

    /**
    * fetchRecentIdea
    * 最近浏览的且未关联当前主体且非归档非删除的数据
    * @param context
    * @return
    */
    Page<Idea> fetchRecentIdea(IdeaSearchContext context);

    /**
    * listRecentIdea
    * 最近浏览的且未关联当前主体且非归档非删除的数据
    * @param context
    * @return
    */
    List<Idea> listRecentIdea(IdeaSearchContext context);

    /**
    * findByCategoryId
    * @param categoryIds
    * @return
    */
    List<Idea> findByCategoryId(List<String> categoryIds);
    default List<Idea> findByCategoryId(String categoryId){
        return findByCategory(new Category().setId(categoryId));
    }

    /**
    * findByCategory
    * @param category
    * @return
    */
    List<Idea> findByCategory(Category category);

    /**
    * removeByCategoryId
    * @param categoryId
    * @return
    */
    boolean removeByCategoryId(String categoryId);

    /**
    * resetByCategoryId
    * @param categoryId
    * @return
    */
    boolean resetByCategoryId(String categoryId);

    /**
    * saveByCategoryId
    * @param categoryId
    * @param list
    * @return
    */
    default boolean saveByCategoryId(String categoryId, List<Idea> list){
        return getSelf().saveByCategory(new Category().setId(categoryId),list);
    }

    /**
    * saveByCategory
    * @param category
    * @param list
    * @return
    */
    boolean saveByCategory(Category category, List<Idea> list);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<Idea> findByProductId(List<String> productIds);
    default List<Idea> findByProductId(String productId){
        return findByProduct(new Product().setId(productId));
    }

    /**
    * findByProduct
    * @param product
    * @return
    */
    List<Idea> findByProduct(Product product);

    /**
    * removeByProductId
    * @param productId
    * @return
    */
    boolean removeByProductId(String productId);

    /**
    * resetByProductId
    * @param productId
    * @return
    */
    boolean resetByProductId(String productId);

    /**
    * saveByProductId
    * @param productId
    * @param list
    * @return
    */
    default boolean saveByProductId(String productId, List<Idea> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<Idea> list);

    /**
    * findByAssigneeId
    * @param assigneeIds
    * @return
    */
    List<Idea> findByAssigneeId(List<String> assigneeIds);
    default List<Idea> findByAssigneeId(String assigneeId){
        return findByUser(new User().setId(assigneeId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<Idea> findByUser(User user);

    /**
    * removeByAssigneeId
    * @param assigneeId
    * @return
    */
    boolean removeByAssigneeId(String assigneeId);

    /**
    * resetByAssigneeId
    * @param assigneeId
    * @return
    */
    boolean resetByAssigneeId(String assigneeId);

    /**
    * saveByAssigneeId
    * @param assigneeId
    * @param list
    * @return
    */
    default boolean saveByAssigneeId(String assigneeId, List<Idea> list){
        return getSelf().saveByUser(new User().setId(assigneeId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<Idea> list);

    default List<Attention> getAttentions(Idea et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(Idea et) {
        return new ArrayList<>();
    }

    /**
    * getBaselineName
    * 
    * @param et
    * @return
    */
    default Idea getBaselineName(Idea et) {
        return et;
    }

    /**
    * getCustomerScore
    * 获取客户分数数据
    * @param et
    * @return
    */
    default Idea getCustomerScore(Idea et) {
        return et;
    }

    /**
    * getTicketNum
    * 
    * @param et
    * @return
    */
    default Idea getTicketNum(Idea et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Idea> fetchView(IdeaSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Idea> listView(IdeaSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}