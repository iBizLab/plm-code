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
import cn.ibizlab.plm.core.devops.domain.Branch;
import cn.ibizlab.plm.core.devops.filter.BranchSearchContext;
import cn.ibizlab.plm.core.devops.domain.Repository;
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;

/**
 * 代码分支服务接口[BranchService]
 *
 * @author generator
 */
public interface BranchService extends IService<Branch> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default BranchService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Branch et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Branch> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Branch et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Branch> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Branch().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Branch et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Branch> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Branch().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Branch> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Branch get(String key) {
        return getSelf().get(new Branch().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Branch get(Branch et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Branch> get(Collection<String> keys) {
        List<Branch> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Branch().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Branch> get(List<Branch> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Branch getDraft(Branch et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Branch et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Branch et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Branch> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Branch> fetchDefault(BranchSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Branch> listDefault(BranchSearchContext context);

    /**
    * findByRepositoryId
    * @param repositoryIds
    * @return
    */
    List<Branch> findByRepositoryId(List<String> repositoryIds);
    default List<Branch> findByRepositoryId(String repositoryId){
        return findByRepository(new Repository().setId(repositoryId));
    }

    /**
    * findByRepository
    * @param repository
    * @return
    */
    List<Branch> findByRepository(Repository repository);

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
    default boolean saveByRepositoryId(String repositoryId, List<Branch> list){
        return getSelf().saveByRepository(new Repository().setId(repositoryId),list);
    }

    /**
    * saveByRepository
    * @param repository
    * @param list
    * @return
    */
    boolean saveByRepository(Repository repository, List<Branch> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Branch> fetchView(BranchSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Branch> listView(BranchSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Branch> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Branch et=list.get(i);
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
    default Branch getEntity() {
        return new Branch();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default BranchSearchContext getSearchContext() {
        return new BranchSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}