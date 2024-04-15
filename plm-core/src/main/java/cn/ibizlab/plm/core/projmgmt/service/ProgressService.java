/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.projmgmt.domain.Progress;
import cn.ibizlab.plm.core.projmgmt.filter.ProgressSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;

/**
 * 项目进度服务接口[ProgressService]
 *
 * @author generator
 */
public interface ProgressService extends IService<Progress> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProgressService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Progress get(Progress et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Progress get(String key) {
        return getSelf().get(new Progress().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Progress> getByIds(Collection<String> ids) {
        List<Progress> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Progress().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Progress> getByEntities(List<Progress> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Progress getDraft(Progress et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Progress et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Progress et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Progress> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Progress et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Progress> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Progress et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Progress> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Progress().setId(key));
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
    boolean remove(Progress et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Progress> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Progress().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Progress> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Progress> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Progress et=list.get(i);
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
    Page<Progress> searchDefault(ProgressSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Progress> listDefault(ProgressSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Progress getEntity() {
        return new Progress();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ProgressSearchContext getSearchContext() {
        return new ProgressSearchContext();
    }
    /**
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<Progress> findByProjectId(List<String> projectIds);
    default List<Progress> findByProjectId(String projectId) {
        return findByProjectId(Arrays.asList(projectId));
    }
    /**
     * removeRelByProjectId
     * @param projectId
     * @return
     */
    boolean removeByProjectId(String projectId);
    /**
     * resetRelByProjectId
     * @param projectId
     * @return
     */
    boolean resetByProjectId(String projectId);
    /**
     * saveRelByProjectId
     * @param projectId
     * @param list
     * @return
     */
    default boolean saveByProjectId(String projectId,List<Progress> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<Progress> list);


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