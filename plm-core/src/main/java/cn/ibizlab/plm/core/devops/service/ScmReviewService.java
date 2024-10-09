/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.devops.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.devops.domain.ScmReview;
import cn.ibizlab.plm.core.devops.filter.ScmReviewSearchContext;
import cn.ibizlab.plm.core.devops.domain.PullRequest;
import cn.ibizlab.plm.core.devops.domain.Repository;

/**
 * 代码评审服务接口[ScmReviewService]
 *
 * @author generator
 */
public interface ScmReviewService extends IService<ScmReview> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ScmReviewService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ScmReview et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ScmReview> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ScmReview et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ScmReview> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ScmReview().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ScmReview et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ScmReview> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ScmReview().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ScmReview> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ScmReview get(String key) {
        return getSelf().get(new ScmReview().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ScmReview get(ScmReview et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ScmReview> get(Collection<String> keys) {
        List<ScmReview> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ScmReview().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ScmReview> get(List<ScmReview> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ScmReview getDraft(ScmReview et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(ScmReview et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ScmReview et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ScmReview> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ScmReview> fetchDefault(ScmReviewSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ScmReview> listDefault(ScmReviewSearchContext context);

    /**
    * findByPullRequestId
    * @param pullRequestIds
    * @return
    */
    List<ScmReview> findByPullRequestId(List<String> pullRequestIds);
    default List<ScmReview> findByPullRequestId(String pullRequestId){
        return findByPullRequest(new PullRequest().setId(pullRequestId));
    }

    /**
    * findByPullRequest
    * @param pullRequest
    * @return
    */
    List<ScmReview> findByPullRequest(PullRequest pullRequest);

    /**
    * removeByPullRequestId
    * @param pullRequestId
    * @return
    */
    boolean removeByPullRequestId(String pullRequestId);

    /**
    * resetByPullRequestId
    * @param pullRequestId
    * @return
    */
    boolean resetByPullRequestId(String pullRequestId);

    /**
    * saveByPullRequestId
    * @param pullRequestId
    * @param list
    * @return
    */
    default boolean saveByPullRequestId(String pullRequestId, List<ScmReview> list){
        return getSelf().saveByPullRequest(new PullRequest().setId(pullRequestId),list);
    }

    /**
    * saveByPullRequest
    * @param pullRequest
    * @param list
    * @return
    */
    boolean saveByPullRequest(PullRequest pullRequest, List<ScmReview> list);

    /**
    * findByRepositoryId
    * @param repositoryIds
    * @return
    */
    List<ScmReview> findByRepositoryId(List<String> repositoryIds);
    default List<ScmReview> findByRepositoryId(String repositoryId){
        return findByRepository(new Repository().setId(repositoryId));
    }

    /**
    * findByRepository
    * @param repository
    * @return
    */
    List<ScmReview> findByRepository(Repository repository);

    /**
    * removeByRepositoryId
    * @param repositoryId
    * @return
    */
    boolean removeByRepositoryId(String repositoryId);

    /**
    * resetByRepositoryId
    * @param repositoryId
    * @return
    */
    boolean resetByRepositoryId(String repositoryId);

    /**
    * saveByRepositoryId
    * @param repositoryId
    * @param list
    * @return
    */
    default boolean saveByRepositoryId(String repositoryId, List<ScmReview> list){
        return getSelf().saveByRepository(new Repository().setId(repositoryId),list);
    }

    /**
    * saveByRepository
    * @param repository
    * @param list
    * @return
    */
    boolean saveByRepository(Repository repository, List<ScmReview> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ScmReview> fetchView(ScmReviewSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ScmReview> listView(ScmReviewSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<ScmReview> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ScmReview et=list.get(i);
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
    default ScmReview getEntity() {
        return new ScmReview();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ScmReviewSearchContext getSearchContext() {
        return new ScmReviewSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}