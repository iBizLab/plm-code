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
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.filter.SearchCommentSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 评论搜索服务接口[SearchCommentService]
 *
 * @author generator
 */
public interface SearchCommentService extends IService<SearchComment> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SearchCommentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SearchComment et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SearchComment> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SearchComment et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SearchComment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SearchComment().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SearchComment et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SearchComment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SearchComment().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SearchComment> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SearchComment get(String key) {
        return getSelf().get(new SearchComment().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SearchComment get(SearchComment et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SearchComment> get(Collection<String> keys) {
        List<SearchComment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SearchComment().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SearchComment> get(List<SearchComment> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SearchComment getDraft(SearchComment et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(SearchComment et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SearchComment et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SearchComment> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SearchComment> fetchDefault(SearchCommentSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SearchComment> listDefault(SearchCommentSearchContext context);

    /**
    * fetchRelation
    * 
    * @param context
    * @return
    */
    Page<SearchComment> fetchRelation(SearchCommentSearchContext context);

    /**
    * listRelation
    * 
    * @param context
    * @return
    */
    List<SearchComment> listRelation(SearchCommentSearchContext context);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<SearchComment> findByPrincipalId(List<String> principalIds);
    default List<SearchComment> findByPrincipalId(String principalId){
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
    default boolean saveByPrincipalId(String principalId, List<SearchComment> list){
        return getSelf().saveByDerCustomer(new Customer().setId(principalId),list);
    }

    /**
    * saveByDerCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByDerCustomer(Customer customer, List<SearchComment> list);

    /**
    * saveByDerIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByDerIdea(Idea idea, List<SearchComment> list);

    /**
    * saveByDerPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByDerPage(ArticlePage articlePage, List<SearchComment> list);

    /**
    * saveByDerRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByDerRun(Run run, List<SearchComment> list);

    /**
    * saveByDerTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByDerTestCase(TestCase testCase, List<SearchComment> list);

    /**
    * saveByDerTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByDerTicket(Ticket ticket, List<SearchComment> list);

    /**
    * saveByDerWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByDerWorkItem(WorkItem workItem, List<SearchComment> list);


    default ImportResult importData(String config, Boolean ignoreError, List<SearchComment> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SearchComment et=list.get(i);
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
    default SearchComment getEntity() {
        return new SearchComment();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SearchCommentSearchContext getSearchContext() {
        return new SearchCommentSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}