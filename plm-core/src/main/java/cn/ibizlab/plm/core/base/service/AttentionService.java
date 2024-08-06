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
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.filter.AttentionSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 关注服务接口[AttentionService]
 *
 * @author generator
 */
public interface AttentionService extends IService<Attention> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AttentionService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Attention et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Attention> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Attention et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Attention> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Attention().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Attention et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Attention> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Attention().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Attention> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Attention get(String key) {
        return getSelf().get(new Attention().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Attention get(Attention et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Attention> get(Collection<String> keys) {
        List<Attention> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Attention().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Attention> get(List<Attention> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Attention getDraft(Attention et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Attention et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Attention et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Attention> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Attention> fetchDefault(AttentionSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Attention> listDefault(AttentionSearchContext context);

    /**
    * fetchAttentionByOwnerid
    * 
    * @param context
    * @return
    */
    Page<Attention> fetchAttentionByOwnerid(AttentionSearchContext context);

    /**
    * listAttentionByOwnerid
    * 
    * @param context
    * @return
    */
    List<Attention> listAttentionByOwnerid(AttentionSearchContext context);

    /**
    * fetchCommentAttention
    * 
    * @param context
    * @return
    */
    Page<Attention> fetchCommentAttention(AttentionSearchContext context);

    /**
    * listCommentAttention
    * 
    * @param context
    * @return
    */
    List<Attention> listCommentAttention(AttentionSearchContext context);

    /**
    * fetchNotify
    * 
    * @param context
    * @return
    */
    Page<Attention> fetchNotify(AttentionSearchContext context);

    /**
    * listNotify
    * 
    * @param context
    * @return
    */
    List<Attention> listNotify(AttentionSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Attention> findByOwnerId(List<String> ownerIds);
    default List<Attention> findByOwnerId(String ownerId){
        return findByCustomer(new Customer().setId(ownerId));
    }

    /**
    * findByCustomer
    * @param customer
    * @return
    */
    List<Attention> findByCustomer(Customer customer);

    /**
    * removeByOwnerId
    * @param ownerId
    * @return
    */
    boolean removeByOwnerId(String ownerId);

    /**
    * resetByOwnerId
    * @param ownerId
    * @return
    */
    boolean resetByOwnerId(String ownerId);

    /**
    * saveByOwnerId
    * @param ownerId
    * @param list
    * @return
    */
    default boolean saveByOwnerId(String ownerId, List<Attention> list){
        return getSelf().saveByCustomer(new Customer().setId(ownerId),list);
    }

    /**
    * saveByCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByCustomer(Customer customer, List<Attention> list);

    /**
    * findByDiscussPost
    * @param discussPost
    * @return
    */
    List<Attention> findByDiscussPost(DiscussPost discussPost);

    /**
    * saveByDiscussPost
    * @param discussPost
    * @param list
    * @return
    */
    boolean saveByDiscussPost(DiscussPost discussPost, List<Attention> list);

    /**
    * findByIdea
    * @param idea
    * @return
    */
    List<Attention> findByIdea(Idea idea);

    /**
    * saveByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea, List<Attention> list);

    /**
    * findByPage
    * @param articlePage
    * @return
    */
    List<Attention> findByPage(ArticlePage articlePage);

    /**
    * saveByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage, List<Attention> list);

    /**
    * findByReview
    * @param review
    * @return
    */
    List<Attention> findByReview(Review review);

    /**
    * saveByReview
    * @param review
    * @param list
    * @return
    */
    boolean saveByReview(Review review, List<Attention> list);

    /**
    * findByReviewWizard
    * @param reviewWizard
    * @return
    */
    List<Attention> findByReviewWizard(ReviewWizard reviewWizard);

    /**
    * saveByReviewWizard
    * @param reviewWizard
    * @param list
    * @return
    */
    boolean saveByReviewWizard(ReviewWizard reviewWizard, List<Attention> list);

    /**
    * findByRun
    * @param run
    * @return
    */
    List<Attention> findByRun(Run run);

    /**
    * saveByRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByRun(Run run, List<Attention> list);

    /**
    * findByTestCase
    * @param testCase
    * @return
    */
    List<Attention> findByTestCase(TestCase testCase);

    /**
    * saveByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase, List<Attention> list);

    /**
    * findByTicket
    * @param ticket
    * @return
    */
    List<Attention> findByTicket(Ticket ticket);

    /**
    * saveByTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTicket(Ticket ticket, List<Attention> list);

    /**
    * findByWorkItem
    * @param workItem
    * @return
    */
    List<Attention> findByWorkItem(WorkItem workItem);

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<Attention> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Attention> fetchView(AttentionSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Attention> listView(AttentionSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Attention> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Attention et=list.get(i);
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
    default Attention getEntity() {
        return new Attention();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default AttentionSearchContext getSearchContext() {
        return new AttentionSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}