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
    boolean create(List<SearchAttachment> list);

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
    boolean update(List<SearchAttachment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SearchAttachment().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SearchAttachment et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SearchAttachment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SearchAttachment().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SearchAttachment> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SearchAttachment get(String key) {
        return getSelf().get(new SearchAttachment().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SearchAttachment get(SearchAttachment et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SearchAttachment> get(Collection<String> keys) {
        List<SearchAttachment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SearchAttachment().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SearchAttachment> get(List<SearchAttachment> entities);

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
    CheckKeyStatus checkKey(SearchAttachment et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SearchAttachment et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SearchAttachment> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SearchAttachment> fetchDefault(SearchAttachmentSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SearchAttachment> listDefault(SearchAttachmentSearchContext context);

    /**
    * fetchRelation
    * 
    * @param context
    * @return
    */
    Page<SearchAttachment> fetchRelation(SearchAttachmentSearchContext context);

    /**
    * listRelation
    * 
    * @param context
    * @return
    */
    List<SearchAttachment> listRelation(SearchAttachmentSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<SearchAttachment> findByOwnerId(List<String> ownerIds);
    default List<SearchAttachment> findByOwnerId(String ownerId){
        return findByDerCustomer(new Customer().setId(ownerId));
    }

    /**
    * findByDerCustomer
    * @param customer
    * @return
    */
    List<SearchAttachment> findByDerCustomer(Customer customer);

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
    default boolean saveByOwnerId(String ownerId, List<SearchAttachment> list){
        return getSelf().saveByDerCustomer(new Customer().setId(ownerId),list);
    }

    /**
    * saveByDerCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByDerCustomer(Customer customer, List<SearchAttachment> list);

    /**
    * findByDerIdea
    * @param idea
    * @return
    */
    List<SearchAttachment> findByDerIdea(Idea idea);

    /**
    * saveByDerIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByDerIdea(Idea idea, List<SearchAttachment> list);

    /**
    * findByDerPage
    * @param articlePage
    * @return
    */
    List<SearchAttachment> findByDerPage(ArticlePage articlePage);

    /**
    * saveByDerPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByDerPage(ArticlePage articlePage, List<SearchAttachment> list);

    /**
    * findByDerTestCase
    * @param testCase
    * @return
    */
    List<SearchAttachment> findByDerTestCase(TestCase testCase);

    /**
    * saveByDerTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByDerTestCase(TestCase testCase, List<SearchAttachment> list);

    /**
    * findByDerTicket
    * @param ticket
    * @return
    */
    List<SearchAttachment> findByDerTicket(Ticket ticket);

    /**
    * saveByDerTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByDerTicket(Ticket ticket, List<SearchAttachment> list);

    /**
    * findByDerWorkItem
    * @param workItem
    * @return
    */
    List<SearchAttachment> findByDerWorkItem(WorkItem workItem);

    /**
    * saveByDerWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByDerWorkItem(WorkItem workItem, List<SearchAttachment> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<SearchAttachment> fetchView(SearchAttachmentSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<SearchAttachment> listView(SearchAttachmentSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}