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
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;
import cn.ibizlab.plm.core.devops.filter.BranchRefCommitSearchContext;
import cn.ibizlab.plm.core.devops.domain.Branch;
import cn.ibizlab.plm.core.devops.domain.Commit;
import cn.ibizlab.plm.core.devops.domain.Repository;

/**
 * 分支提交关联服务接口[BranchRefCommitService]
 *
 * @author generator
 */
public interface BranchRefCommitService extends IService<BranchRefCommit> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default BranchRefCommitService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(BranchRefCommit et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<BranchRefCommit> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(BranchRefCommit et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<BranchRefCommit> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new BranchRefCommit().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(BranchRefCommit et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<BranchRefCommit> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BranchRefCommit().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<BranchRefCommit> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default BranchRefCommit get(String key) {
        return getSelf().get(new BranchRefCommit().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    BranchRefCommit get(BranchRefCommit et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<BranchRefCommit> get(Collection<String> keys) {
        List<BranchRefCommit> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BranchRefCommit().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<BranchRefCommit> get(List<BranchRefCommit> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    BranchRefCommit getDraft(BranchRefCommit et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(BranchRefCommit et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(BranchRefCommit et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<BranchRefCommit> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<BranchRefCommit> fetchDefault(BranchRefCommitSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<BranchRefCommit> listDefault(BranchRefCommitSearchContext context);

    /**
    * findByMetaId
    * @param metaIds
    * @return
    */
    List<BranchRefCommit> findByMetaId(List<String> metaIds);
    default List<BranchRefCommit> findByMetaId(String metaId){
        return findByBranch(new Branch().setId(metaId));
    }

    /**
    * findByBranch
    * @param branch
    * @return
    */
    List<BranchRefCommit> findByBranch(Branch branch);

    /**
    * removeByMetaId
    * @param metaId
    * @return
    */
    boolean removeByMetaId(String metaId);

    /**
    * resetByMetaId
    * @param metaId
    * @return
    */
    boolean resetByMetaId(String metaId);

    /**
    * saveByMetaId
    * @param metaId
    * @param list
    * @return
    */
    default boolean saveByMetaId(String metaId, List<BranchRefCommit> list){
        return getSelf().saveByBranch(new Branch().setId(metaId),list);
    }

    /**
    * saveByBranch
    * @param branch
    * @param list
    * @return
    */
    boolean saveByBranch(Branch branch, List<BranchRefCommit> list);

    /**
    * findBySha
    * @param shas
    * @return
    */
    List<BranchRefCommit> findBySha(List<String> shas);
    default List<BranchRefCommit> findBySha(String sha){
        return findByCommit(new Commit().setSha(sha));
    }

    /**
    * findByCommit
    * @param commit
    * @return
    */
    List<BranchRefCommit> findByCommit(Commit commit);

    /**
    * removeBySha
    * @param sha
    * @return
    */
    boolean removeBySha(String sha);

    /**
    * resetBySha
    * @param sha
    * @return
    */
    boolean resetBySha(String sha);

    /**
    * saveBySha
    * @param sha
    * @param list
    * @return
    */
    default boolean saveBySha(String sha, List<BranchRefCommit> list){
        return getSelf().saveByCommit(new Commit().setSha(sha),list);
    }

    /**
    * saveByCommit
    * @param commit
    * @param list
    * @return
    */
    boolean saveByCommit(Commit commit, List<BranchRefCommit> list);

    /**
    * findByRepositoryId
    * @param repositoryIds
    * @return
    */
    List<BranchRefCommit> findByRepositoryId(List<String> repositoryIds);
    default List<BranchRefCommit> findByRepositoryId(String repositoryId){
        return findByRepository(new Repository().setId(repositoryId));
    }

    /**
    * findByRepository
    * @param repository
    * @return
    */
    List<BranchRefCommit> findByRepository(Repository repository);

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
    default boolean saveByRepositoryId(String repositoryId, List<BranchRefCommit> list){
        return getSelf().saveByRepository(new Repository().setId(repositoryId),list);
    }

    /**
    * saveByRepository
    * @param repository
    * @param list
    * @return
    */
    boolean saveByRepository(Repository repository, List<BranchRefCommit> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<BranchRefCommit> fetchView(BranchRefCommitSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<BranchRefCommit> listView(BranchRefCommitSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<BranchRefCommit> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            BranchRefCommit et=list.get(i);
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
    default BranchRefCommit getEntity() {
        return new BranchRefCommit();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default BranchRefCommitSearchContext getSearchContext() {
        return new BranchRefCommitSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}