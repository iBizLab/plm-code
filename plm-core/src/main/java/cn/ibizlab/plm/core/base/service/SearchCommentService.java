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
     * 获取
     * @param et
     * @return
     */
    SearchComment get(SearchComment et);
    /**
     * 获取
     * @param key
     * @return
     */
    default SearchComment get(String key) {
        return getSelf().get(new SearchComment().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<SearchComment> getByIds(Collection<String> ids) {
        List<SearchComment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SearchComment().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<SearchComment> getByEntities(List<SearchComment> entities);

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
    boolean createBatch(List<SearchComment> list);

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
    boolean updateBatch(List<SearchComment> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(SearchComment et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<SearchComment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SearchComment().setId(key));
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
    boolean remove(SearchComment et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<SearchComment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SearchComment().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<SearchComment> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<SearchComment> searchDefault(SearchCommentSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<SearchComment> listDefault(SearchCommentSearchContext context);

    /**
     * searchrelation
     * 
     * @param context
     * @return
     */
    Page<SearchComment> searchRelation(SearchCommentSearchContext context);
    /**
     * listrelation
     * 
     * @param context
     * @return
     */
    List<SearchComment> listRelation(SearchCommentSearchContext context);

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
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<SearchComment> findByPrincipalId(List<String> principalIds);
    default List<SearchComment> findByPrincipalId(String principalId) {
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
    default boolean saveByPrincipalId(String principalId,List<SearchComment> list) {
        return getSelf().saveByCustomer(new Customer().setId(principalId),list);
    }
    /**
    * saveRelByCustomer
    * @param customer
    * @param list
    * @return
    */
    boolean saveByCustomer(Customer customer,List<SearchComment> list);

    /**
    * saveRelByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea,List<SearchComment> list);

    /**
    * saveRelByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage,List<SearchComment> list);

    /**
    * saveRelByRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByRun(Run run,List<SearchComment> list);

    /**
    * saveRelByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase,List<SearchComment> list);

    /**
    * saveRelByTicket
    * @param ticket
    * @param list
    * @return
    */
    boolean saveByTicket(Ticket ticket,List<SearchComment> list);

    /**
    * saveRelByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem,List<SearchComment> list);


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