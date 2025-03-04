/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.team.filter.DiscussReplySearchContext;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 讨论回复服务接口[DiscussReplyService]
 *
 * @author generator
 */
public interface DiscussReplyService extends IService<DiscussReply> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DiscussReplyService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(DiscussReply et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<DiscussReply> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(DiscussReply et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<DiscussReply> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DiscussReply().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(DiscussReply et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<DiscussReply> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DiscussReply().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<DiscussReply> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default DiscussReply get(String key) {
        return getSelf().get(new DiscussReply().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DiscussReply get(DiscussReply et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<DiscussReply> get(Collection<String> keys) {
        List<DiscussReply> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DiscussReply().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<DiscussReply> get(List<DiscussReply> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    DiscussReply getDraft(DiscussReply et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(DiscussReply et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(DiscussReply et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<DiscussReply> list);

    /**
    * addReply
    * 
    * @param et
    * @return
    */
    default DiscussReply addReply(DiscussReply et) {
        return et;
    }

    /**
    * delComment
    * 
    * @param et
    * @return
    */
    default DiscussReply delComment(DiscussReply et) {
        return et;
    }

    /**
    * delReply
    * 
    * @param et
    * @return
    */
    default DiscussReply delReply(DiscussReply et) {
        return et;
    }

    /**
    * editReply
    * 
    * @param et
    * @return
    */
    default DiscussReply editReply(DiscussReply et) {
        return et;
    }

    /**
    * sendComment
    * 
    * @param et
    * @return
    */
    default DiscussReply sendComment(DiscussReply et) {
        return et;
    }

    /**
    * updateComment
    * 
    * @param et
    * @return
    */
    default DiscussReply updateComment(DiscussReply et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<DiscussReply> fetchDefault(DiscussReplySearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<DiscussReply> listDefault(DiscussReplySearchContext context);

    /**
    * fetchMyAllReply
    * 
    * @param context
    * @return
    */
    Page<DiscussReply> fetchMyAllReply(DiscussReplySearchContext context);

    /**
    * listMyAllReply
    * 
    * @param context
    * @return
    */
    List<DiscussReply> listMyAllReply(DiscussReplySearchContext context);

    /**
    * fetchMyReply
    * 
    * @param context
    * @return
    */
    Page<DiscussReply> fetchMyReply(DiscussReplySearchContext context);

    /**
    * listMyReply
    * 
    * @param context
    * @return
    */
    List<DiscussReply> listMyReply(DiscussReplySearchContext context);

    /**
    * fetchRecent
    * 
    * @param context
    * @return
    */
    Page<DiscussReply> fetchRecent(DiscussReplySearchContext context);

    /**
    * listRecent
    * 
    * @param context
    * @return
    */
    List<DiscussReply> listRecent(DiscussReplySearchContext context);

    /**
    * findByPostId
    * @param postIds
    * @return
    */
    List<DiscussReply> findByPostId(List<String> postIds);
    default List<DiscussReply> findByPostId(String postId){
        return findByDiscussPost(new DiscussPost().setId(postId));
    }

    /**
    * findByDiscussPost
    * @param discussPost
    * @return
    */
    List<DiscussReply> findByDiscussPost(DiscussPost discussPost);

    /**
    * removeByPostId
    * @param postId
    * @return
    */
    boolean removeByPostId(String postId);

    /**
    * resetByPostId
    * @param postId
    * @return
    */
    boolean resetByPostId(String postId);

    /**
    * saveByPostId
    * @param postId
    * @param list
    * @return
    */
    default boolean saveByPostId(String postId, List<DiscussReply> list){
        return getSelf().saveByDiscussPost(new DiscussPost().setId(postId),list);
    }

    /**
    * saveByDiscussPost
    * @param discussPost
    * @param list
    * @return
    */
    boolean saveByDiscussPost(DiscussPost discussPost, List<DiscussReply> list);

    default List<Comment> getComments(DiscussReply et) {
        return new ArrayList<>();
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<DiscussReply> fetchView(DiscussReplySearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<DiscussReply> listView(DiscussReplySearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<DiscussReply> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DiscussReply et=list.get(i);
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
    default DiscussReply getEntity() {
        return new DiscussReply();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DiscussReplySearchContext getSearchContext() {
        return new DiscussReplySearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}