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
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.filter.DiscussPostSearchContext;
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attachment;

/**
 * 讨论服务接口[DiscussPostService]
 *
 * @author generator
 */
public interface DiscussPostService extends IService<DiscussPost> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DiscussPostService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(DiscussPost et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<DiscussPost> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(DiscussPost et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<DiscussPost> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DiscussPost().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(DiscussPost et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<DiscussPost> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DiscussPost().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<DiscussPost> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default DiscussPost get(String key) {
        return getSelf().get(new DiscussPost().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DiscussPost get(DiscussPost et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<DiscussPost> get(Collection<String> keys) {
        List<DiscussPost> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DiscussPost().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<DiscussPost> get(List<DiscussPost> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    DiscussPost getDraft(DiscussPost et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(DiscussPost et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(DiscussPost et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<DiscussPost> list);

    /**
    * close
    * 
    * @param et
    * @return
    */
    default DiscussPost close(DiscussPost et) {
        return et;
    }

    /**
    * delComment
    * 
    * @param et
    * @return
    */
    default DiscussPost delComment(DiscussPost et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default DiscussPost delete(DiscussPost et) {
        return et;
    }

    /**
    * fillAddition
    * 
    * @param et
    * @return
    */
    default DiscussPost fillAddition(DiscussPost et) {
        return et;
    }

    /**
    * getAttention
    * 
    * @param key
    * @return
    */
    default DiscussPost getAttention(String key) {
        return null;
    }

    /**
    * move
    * 
    * @param et
    * @return
    */
    default DiscussPost move(DiscussPost et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default DiscussPost nothing(DiscussPost et) {
        return et;
    }

    /**
    * open
    * 
    * @param et
    * @return
    */
    default DiscussPost open(DiscussPost et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default DiscussPost recover(DiscussPost et) {
        return et;
    }

    /**
    * sendComment
    * 
    * @param et
    * @return
    */
    default DiscussPost sendComment(DiscussPost et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<DiscussPost> fetchDefault(DiscussPostSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<DiscussPost> listDefault(DiscussPostSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<DiscussPost> fetchDeleted(DiscussPostSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<DiscussPost> listDeleted(DiscussPostSearchContext context);

    /**
    * fetchMyAttention
    * 
    * @param context
    * @return
    */
    Page<DiscussPost> fetchMyAttention(DiscussPostSearchContext context);

    /**
    * listMyAttention
    * 
    * @param context
    * @return
    */
    List<DiscussPost> listMyAttention(DiscussPostSearchContext context);

    /**
    * fetchMyCreate
    * 
    * @param context
    * @return
    */
    Page<DiscussPost> fetchMyCreate(DiscussPostSearchContext context);

    /**
    * listMyCreate
    * 
    * @param context
    * @return
    */
    List<DiscussPost> listMyCreate(DiscussPostSearchContext context);

    /**
    * fetchMyReply
    * 
    * @param context
    * @return
    */
    Page<DiscussPost> fetchMyReply(DiscussPostSearchContext context);

    /**
    * listMyReply
    * 
    * @param context
    * @return
    */
    List<DiscussPost> listMyReply(DiscussPostSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<DiscussPost> fetchNormal(DiscussPostSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<DiscussPost> listNormal(DiscussPostSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<DiscussPost> fetchReader(DiscussPostSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<DiscussPost> listReader(DiscussPostSearchContext context);

    /**
    * fetchRecent
    * 
    * @param context
    * @return
    */
    Page<DiscussPost> fetchRecent(DiscussPostSearchContext context);

    /**
    * listRecent
    * 
    * @param context
    * @return
    */
    List<DiscussPost> listRecent(DiscussPostSearchContext context);

    /**
    * findByTopicId
    * @param topicIds
    * @return
    */
    List<DiscussPost> findByTopicId(List<String> topicIds);
    default List<DiscussPost> findByTopicId(String topicId){
        return findByTopicId(Arrays.asList(topicId));
    }

    /**
    * removeByTopicId
    * @param topicId
    * @return
    */
    boolean removeByTopicId(String topicId);

    /**
    * resetByTopicId
    * @param topicId
    * @return
    */
    boolean resetByTopicId(String topicId);

    /**
    * saveByTopicId
    * @param topicId
    * @param list
    * @return
    */
    default boolean saveByTopicId(String topicId, List<DiscussPost> list){
        return getSelf().saveByDiscussTopic(new DiscussTopic().setId(topicId),list);
    }

    /**
    * saveByDiscussTopic
    * @param discussTopic
    * @param list
    * @return
    */
    boolean saveByDiscussTopic(DiscussTopic discussTopic, List<DiscussPost> list);

    default List<Attention> getAttentions(DiscussPost et) {
        return new ArrayList<>();
    }

    default List<Comment> getComments(DiscussPost et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(DiscussPost et) {
        return new ArrayList<>();
    }


    default ImportResult importData(String config, Boolean ignoreError, List<DiscussPost> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DiscussPost et=list.get(i);
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
    default DiscussPost getEntity() {
        return new DiscussPost();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DiscussPostSearchContext getSearchContext() {
        return new DiscussPostSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}