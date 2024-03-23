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
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
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
     * 获取
     * @param et
     * @return
     */
    Comment get(Comment et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Comment get(String key) {
        return getSelf().get(new Comment().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Comment> getByIds(Collection<String> ids) {
        List<Comment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Comment().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Comment> getByEntities(List<Comment> entities);

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
    boolean createBatch(List<Comment> list);

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
    boolean updateBatch(List<Comment> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Comment et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Comment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Comment().setId(key));
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
    boolean remove(Comment et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Comment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Comment().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Comment> entities);

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
     * Delete
     * 
     * @param dto
     * @return
     */
    default Comment delete(Comment dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Comment> searchDefault(CommentSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Comment> listDefault(CommentSearchContext context);

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
     * selectRelByPid
     * @param pids
     * @return
     */
    List<Comment> findByPid(List<String> pids);
    default List<Comment> findByPid(String pid) {
        return findByPid(Arrays.asList(pid));
    }
    /**
     * removeRelByPid
     * @param pid
     * @return
     */
    boolean removeByPid(String pid);
    /**
     * resetRelByPid
     * @param pid
     * @return
     */
    boolean resetByPid(String pid);
    /**
     * saveRelByPid
     * @param pid
     * @param list
     * @return
     */
    default boolean saveByPid(String pid,List<Comment> list) {
        return getSelf().saveByComment(new Comment().setId(pid),list);
    }
    /**
    * saveRelByComment
    * @param comment
    * @param list
    * @return
    */
    boolean saveByComment(Comment comment,List<Comment> list);

    /**
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<Comment> findByPrincipalId(List<String> principalIds);
    default List<Comment> findByPrincipalId(String principalId) {
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
    default boolean saveByPrincipalId(String principalId,List<Comment> list) {
        return getSelf().saveByPage(new ArticlePage().setId(principalId),list);
    }
    /**
    * saveRelByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage,List<Comment> list);

    /**
    * saveRelByRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByRun(Run run,List<Comment> list);

    /**
    * saveRelByCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByCustomer(Customer customer,List<Comment> list);

    /**
    * saveRelByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea,List<Comment> list);

    /**
    * saveRelByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase,List<Comment> list);

    /**
    * saveRelByTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTicket(Ticket ticket,List<Comment> list);

    /**
    * saveRelByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem,List<Comment> list);


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