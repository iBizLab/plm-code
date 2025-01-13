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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.projmgmt.domain.Progress;
import cn.ibizlab.plm.core.projmgmt.filter.ProgressSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.util.annotation.DEAction;

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
    boolean create(List<Progress> list);

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
    boolean update(List<Progress> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Progress().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Progress et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Progress> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Progress().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Progress> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Progress get(String key) {
        return getSelf().get(new Progress().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Progress get(Progress et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Progress> get(Collection<String> keys) {
        List<Progress> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Progress().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Progress> get(List<Progress> entities);

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
    CheckKeyStatus checkKey(Progress et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Progress et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Progress> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Progress> fetchDefault(ProgressSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Progress> listDefault(ProgressSearchContext context);

    /**
    * findByProjectId
    * @param projectIds
    * @return
    */
    List<Progress> findByProjectId(List<String> projectIds);
    default List<Progress> findByProjectId(String projectId){
        return findByProject(new Project().setId(projectId));
    }

    /**
    * findByProject
    * @param project
    * @return
    */
    List<Progress> findByProject(Project project);

    /**
    * removeByProjectId
    * @param projectId
    * @return
    */
    boolean removeByProjectId(String projectId);

    /**
    * resetByProjectId
    * @param projectId
    * @return
    */
    boolean resetByProjectId(String projectId);

    /**
    * saveByProjectId
    * @param projectId
    * @param list
    * @return
    */
    default boolean saveByProjectId(String projectId, List<Progress> list){
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<Progress> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Progress> fetchView(ProgressSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Progress> listView(ProgressSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}