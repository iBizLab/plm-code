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
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.filter.AttachmentSearchContext;
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
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
     * 获取
     * @param et
     * @return
     */
    Attachment get(Attachment et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Attachment get(String key) {
        return getSelf().get(new Attachment().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Attachment> getByIds(Collection<String> ids) {
        List<Attachment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Attachment().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Attachment> getByEntities(List<Attachment> entities);

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
    Integer checkKey(Attachment et);

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
    boolean createBatch(List<Attachment> list);

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
    boolean updateBatch(List<Attachment> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Attachment et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Attachment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Attachment().setId(key));
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
    boolean remove(Attachment et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Attachment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Attachment().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Attachment> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Attachment> searchDefault(AttachmentSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Attachment> listDefault(AttachmentSearchContext context);

    /**
     * searchproject_deliverable
     * 
     * @param context
     * @return
     */
    Page<Attachment> searchProjectDeliverable(AttachmentSearchContext context);
    /**
     * listproject_deliverable
     * 
     * @param context
     * @return
     */
    List<Attachment> listProjectDeliverable(AttachmentSearchContext context);

    /**
     * searchwork_item_deliverable
     * 
     * @param context
     * @return
     */
    Page<Attachment> searchWorkItemDeliverable(AttachmentSearchContext context);
    /**
     * listwork_item_deliverable
     * 
     * @param context
     * @return
     */
    List<Attachment> listWorkItemDeliverable(AttachmentSearchContext context);

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
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<Attachment> findByOwnerId(List<String> ownerIds);
    default List<Attachment> findByOwnerId(String ownerId) {
        return findByOwnerId(Arrays.asList(ownerId));
    }
    /**
     * removeRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean removeByOwnerId(String ownerId);
    /**
     * resetRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean resetByOwnerId(String ownerId);
    /**
     * saveRelByOwnerId
     * @param ownerId
     * @param list
     * @return
     */
    default boolean saveByOwnerId(String ownerId,List<Attachment> list) {
        return getSelf().saveByStencil(new Stencil().setId(ownerId),list);
    }
    /**
    * saveRelByStencil
    * @param stencil
    * @param list
    * @return
    */
    boolean saveByStencil(Stencil stencil,List<Attachment> list);

    /**
    * saveRelByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea,List<Attachment> list);

    /**
    * saveRelByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage,List<Attachment> list);

    /**
    * saveRelByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase,List<Attachment> list);

    /**
    * saveRelByTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTicket(Ticket ticket,List<Attachment> list);

    /**
    * saveRelByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem,List<Attachment> list);


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