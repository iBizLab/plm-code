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
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.filter.AttachmentSearchContext;
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 附件服务接口[AttachmentService]
 *
 * @author generator
 */
public interface AttachmentService extends IService<Attachment> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AttachmentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Attachment et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Attachment> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Attachment et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Attachment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Attachment().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Attachment et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Attachment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Attachment().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Attachment> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Attachment get(String key) {
        return getSelf().get(new Attachment().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Attachment get(Attachment et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Attachment> get(Collection<String> keys) {
        List<Attachment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Attachment().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Attachment> get(List<Attachment> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Attachment getDraft(Attachment et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Attachment et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Attachment et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Attachment> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Attachment> fetchDefault(AttachmentSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Attachment> listDefault(AttachmentSearchContext context);

    /**
    * fetchProjectDeliverable
    * 
    * @param context
    * @return
    */
    Page<Attachment> fetchProjectDeliverable(AttachmentSearchContext context);

    /**
    * listProjectDeliverable
    * 
    * @param context
    * @return
    */
    List<Attachment> listProjectDeliverable(AttachmentSearchContext context);

    /**
    * fetchWorkItemDeliverable
    * 
    * @param context
    * @return
    */
    Page<Attachment> fetchWorkItemDeliverable(AttachmentSearchContext context);

    /**
    * listWorkItemDeliverable
    * 
    * @param context
    * @return
    */
    List<Attachment> listWorkItemDeliverable(AttachmentSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Attachment> findByOwnerId(List<String> ownerIds);
    default List<Attachment> findByOwnerId(String ownerId){
        return findByStencil(new Stencil().setId(ownerId));
    }

    /**
    * findByStencil
    * @param stencil
    * @return
    */
    List<Attachment> findByStencil(Stencil stencil);

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
    default boolean saveByOwnerId(String ownerId, List<Attachment> list){
        return getSelf().saveByStencil(new Stencil().setId(ownerId),list);
    }

    /**
    * saveByStencil
    * @param stencil
    * @param list
    * @return
    */
    boolean saveByStencil(Stencil stencil, List<Attachment> list);

    /**
    * findByDiscussPost
    * @param discussPost
    * @return
    */
    List<Attachment> findByDiscussPost(DiscussPost discussPost);

    /**
    * saveByDiscussPost
    * @param discussPost
    * @param list
    * @return
    */
    boolean saveByDiscussPost(DiscussPost discussPost, List<Attachment> list);

    /**
    * findByIdea
    * @param idea
    * @return
    */
    List<Attachment> findByIdea(Idea idea);

    /**
    * saveByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea, List<Attachment> list);

    /**
    * findByPage
    * @param articlePage
    * @return
    */
    List<Attachment> findByPage(ArticlePage articlePage);

    /**
    * saveByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage, List<Attachment> list);

    /**
    * findByReview
    * @param review
    * @return
    */
    List<Attachment> findByReview(Review review);

    /**
    * saveByReview
    * @param review
    * @param list
    * @return
    */
    boolean saveByReview(Review review, List<Attachment> list);

    /**
    * findByTestCase
    * @param testCase
    * @return
    */
    List<Attachment> findByTestCase(TestCase testCase);

    /**
    * saveByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase, List<Attachment> list);

    /**
    * findByTicket
    * @param ticket
    * @return
    */
    List<Attachment> findByTicket(Ticket ticket);

    /**
    * saveByTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTicket(Ticket ticket, List<Attachment> list);

    /**
    * findByWorkItem
    * @param workItem
    * @return
    */
    List<Attachment> findByWorkItem(WorkItem workItem);

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<Attachment> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Attachment> fetchView(AttachmentSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Attachment> listView(AttachmentSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Attachment> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Attachment et=list.get(i);
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
    default Attachment getEntity() {
        return new Attachment();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default AttachmentSearchContext getSearchContext() {
        return new AttachmentSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}