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
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.filter.SearchAttachmentSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 附件搜索服务接口[SearchAttachmentService]
 *
 * @author generator
 */
public interface SearchAttachmentService extends IService<SearchAttachment> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SearchAttachmentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SearchAttachment get(SearchAttachment et);
    /**
     * 获取
     * @param key
     * @return
     */
    default SearchAttachment get(String key) {
        return getSelf().get(new SearchAttachment().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<SearchAttachment> getByIds(Collection<String> ids) {
        List<SearchAttachment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SearchAttachment().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<SearchAttachment> getByEntities(List<SearchAttachment> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    SearchAttachment getDraft(SearchAttachment et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(SearchAttachment et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(SearchAttachment et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<SearchAttachment> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(SearchAttachment et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<SearchAttachment> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(SearchAttachment et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<SearchAttachment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SearchAttachment().setId(key));
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
    boolean remove(SearchAttachment et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<SearchAttachment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SearchAttachment().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<SearchAttachment> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<SearchAttachment> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SearchAttachment et=list.get(i);
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
    Page<SearchAttachment> searchDefault(SearchAttachmentSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<SearchAttachment> listDefault(SearchAttachmentSearchContext context);

    /**
     * searchrelation
     * 
     * @param context
     * @return
     */
    Page<SearchAttachment> searchRelation(SearchAttachmentSearchContext context);
    /**
     * listrelation
     * 
     * @param context
     * @return
     */
    List<SearchAttachment> listRelation(SearchAttachmentSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default SearchAttachment getEntity() {
        return new SearchAttachment();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default SearchAttachmentSearchContext getSearchContext() {
        return new SearchAttachmentSearchContext();
    }
    /**
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<SearchAttachment> findByOwnerId(List<String> ownerIds);
    default List<SearchAttachment> findByOwnerId(String ownerId) {
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
    default boolean saveByOwnerId(String ownerId,List<SearchAttachment> list) {
        return getSelf().saveByCustomer(new Customer().setId(ownerId),list);
    }
    /**
    * saveRelByCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByCustomer(Customer customer,List<SearchAttachment> list);

    /**
    * saveRelByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea,List<SearchAttachment> list);

    /**
    * saveRelByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage,List<SearchAttachment> list);

    /**
    * saveRelByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase,List<SearchAttachment> list);

    /**
    * saveRelByTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTicket(Ticket ticket,List<SearchAttachment> list);

    /**
    * saveRelByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem,List<SearchAttachment> list);


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