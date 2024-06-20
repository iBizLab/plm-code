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
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.filter.CommentSearchContext;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 评论服务接口[CommentService]
 *
 * @author generator
 */
public interface CommentService extends IService<Comment> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default CommentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Comment et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Comment> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Comment et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Comment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Comment().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Comment et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Comment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Comment().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Comment> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Comment get(String key) {
        return getSelf().get(new Comment().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Comment get(Comment et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Comment> get(Collection<String> keys) {
        List<Comment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Comment().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Comment> get(List<Comment> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Comment getDraft(Comment et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(Comment et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Comment et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Comment> list);

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default Comment delete(Comment et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Comment> fetchDefault(CommentSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Comment> listDefault(CommentSearchContext context);

    /**
    * findByPid
    * @param pids
    * @return
    */
    List<Comment> findByPid(List<String> pids);
    default List<Comment> findByPid(String pid){
        return findByPid(Arrays.asList(pid));
    }

    /**
    * removeByPid
    * @param pid
    * @return
    */
    boolean removeByPid(String pid);

    /**
    * resetByPid
    * @param pid
    * @return
    */
    boolean resetByPid(String pid);

    /**
    * saveByPid
    * @param pid
    * @param list
    * @return
    */
    default boolean saveByPid(String pid, List<Comment> list){
        return getSelf().saveByComment(new Comment().setId(pid),list);
    }

    /**
    * saveByComment
    * @param comment
    * @param list
    * @return
    */
    boolean saveByComment(Comment comment, List<Comment> list);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<Comment> findByPrincipalId(List<String> principalIds);
    default List<Comment> findByPrincipalId(String principalId){
        return findByPrincipalId(Arrays.asList(principalId));
    }

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
    default boolean saveByPrincipalId(String principalId, List<Comment> list){
        return getSelf().saveByPage(new ArticlePage().setId(principalId),list);
    }

    /**
    * saveByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage, List<Comment> list);

    /**
    * saveByRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByRun(Run run, List<Comment> list);

    /**
    * saveByCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByCustomer(Customer customer, List<Comment> list);

    /**
    * saveByDiscussPost
    * @param discussPost
    * @param list
    * @return
    */
    boolean saveByDiscussPost(DiscussPost discussPost, List<Comment> list);

    /**
    * saveByDiscussReply
    * @param discussReply
    * @param list
    * @return
    */
    boolean saveByDiscussReply(DiscussReply discussReply, List<Comment> list);

    /**
    * saveByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea, List<Comment> list);

    /**
    * saveByReview
    * @param review
    * @param list
    * @return
    */
    boolean saveByReview(Review review, List<Comment> list);

    /**
    * saveByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase, List<Comment> list);

    /**
    * saveByTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTicket(Ticket ticket, List<Comment> list);

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<Comment> list);


    default ImportResult importData(String config, Boolean ignoreError, List<Comment> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Comment et=list.get(i);
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
    default Comment getEntity() {
        return new Comment();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default CommentSearchContext getSearchContext() {
        return new CommentSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}