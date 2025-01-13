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
import cn.ibizlab.plm.core.devops.domain.PullRequest;
import cn.ibizlab.plm.core.devops.filter.PullRequestSearchContext;
import cn.ibizlab.plm.core.devops.domain.Repository;
import cn.ibizlab.plm.core.devops.domain.ScmReview;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 拉取提交服务接口[PullRequestService]
 *
 * @author generator
 */
public interface PullRequestService extends IService<PullRequest> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default PullRequestService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(PullRequest et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<PullRequest> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(PullRequest et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<PullRequest> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new PullRequest().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(PullRequest et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<PullRequest> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new PullRequest().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<PullRequest> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default PullRequest get(String key) {
        return getSelf().get(new PullRequest().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    PullRequest get(PullRequest et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<PullRequest> get(Collection<String> keys) {
        List<PullRequest> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new PullRequest().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<PullRequest> get(List<PullRequest> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    PullRequest getDraft(PullRequest et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(PullRequest et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(PullRequest et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<PullRequest> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<PullRequest> fetchDefault(PullRequestSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<PullRequest> listDefault(PullRequestSearchContext context);

    /**
    * findByRepositoryId
    * @param repositoryIds
    * @return
    */
    List<PullRequest> findByRepositoryId(List<String> repositoryIds);
    default List<PullRequest> findByRepositoryId(String repositoryId){
        return findByRepository(new Repository().setId(repositoryId));
    }

    /**
    * findByRepository
    * @param repository
    * @return
    */
    List<PullRequest> findByRepository(Repository repository);

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
    default boolean saveByRepositoryId(String repositoryId, List<PullRequest> list){
        return getSelf().saveByRepository(new Repository().setId(repositoryId),list);
    }

    /**
    * saveByRepository
    * @param repository
    * @param list
    * @return
    */
    boolean saveByRepository(Repository repository, List<PullRequest> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<PullRequest> fetchView(PullRequestSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<PullRequest> listView(PullRequestSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<PullRequest> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            PullRequest et=list.get(i);
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
    default PullRequest getEntity() {
        return new PullRequest();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default PullRequestSearchContext getSearchContext() {
        return new PullRequestSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}