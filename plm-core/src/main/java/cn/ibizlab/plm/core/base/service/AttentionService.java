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
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.filter.AttentionSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
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
     * 获取
     * @param et
     * @return
     */
    Attention get(Attention et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Attention get(String key) {
        return getSelf().get(new Attention().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Attention> getByIds(Collection<String> ids) {
        List<Attention> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Attention().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Attention> getByEntities(List<Attention> entities);

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
    Integer checkKey(Attention et);

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
    boolean createBatch(List<Attention> list);

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
    boolean updateBatch(List<Attention> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Attention et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Attention> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Attention().setId(key));
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
    boolean remove(Attention et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Attention> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Attention().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Attention> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Attention> searchDefault(AttentionSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Attention> listDefault(AttentionSearchContext context);

    /**
     * searchattention_by_ownerid
     * 
     * @param context
     * @return
     */
    Page<Attention> searchAttentionByOwnerid(AttentionSearchContext context);
    /**
     * listattention_by_ownerid
     * 
     * @param context
     * @return
     */
    List<Attention> listAttentionByOwnerid(AttentionSearchContext context);

    /**
     * searchcomment_attention
     * 
     * @param context
     * @return
     */
    Page<Attention> searchCommentAttention(AttentionSearchContext context);
    /**
     * listcomment_attention
     * 
     * @param context
     * @return
     */
    List<Attention> listCommentAttention(AttentionSearchContext context);

    /**
     * searchnotify
     * 
     * @param context
     * @return
     */
    Page<Attention> searchNotify(AttentionSearchContext context);
    /**
     * listnotify
     * 
     * @param context
     * @return
     */
    List<Attention> listNotify(AttentionSearchContext context);

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
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<Attention> findByOwnerId(List<String> ownerIds);
    default List<Attention> findByOwnerId(String ownerId) {
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
    default boolean saveByOwnerId(String ownerId,List<Attention> list) {
        return getSelf().saveByCustomer(new Customer().setId(ownerId),list);
    }
    /**
    * saveRelByCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByCustomer(Customer customer,List<Attention> list);

    /**
    * saveRelByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea,List<Attention> list);

    /**
    * saveRelByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage,List<Attention> list);

    /**
    * saveRelByReview
    * @param review
    * @param list
    * @return
    */
    boolean saveByReview(Review review,List<Attention> list);

    /**
    * saveRelByRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByRun(Run run,List<Attention> list);

    /**
    * saveRelByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase,List<Attention> list);

    /**
    * saveRelByTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTicket(Ticket ticket,List<Attention> list);

    /**
    * saveRelByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem,List<Attention> list);


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