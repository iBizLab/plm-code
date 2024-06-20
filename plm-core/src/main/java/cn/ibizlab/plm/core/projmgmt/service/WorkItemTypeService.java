/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemTypeSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 工作项类型服务接口[WorkItemTypeService]
 *
 * @author generator
 */
public interface WorkItemTypeService extends IService<WorkItemType> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default WorkItemTypeService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(WorkItemType et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<WorkItemType> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(WorkItemType et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<WorkItemType> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new WorkItemType().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(WorkItemType et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<WorkItemType> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new WorkItemType().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<WorkItemType> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default WorkItemType get(String key) {
        return getSelf().get(new WorkItemType().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    WorkItemType get(WorkItemType et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<WorkItemType> get(Collection<String> keys) {
        List<WorkItemType> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new WorkItemType().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<WorkItemType> get(List<WorkItemType> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    WorkItemType getDraft(WorkItemType et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(WorkItemType et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(WorkItemType et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<WorkItemType> list);

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default WorkItemType nothing(WorkItemType et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<WorkItemType> fetchDefault(WorkItemTypeSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<WorkItemType> listDefault(WorkItemTypeSearchContext context);

    /**
    * fetchCurProjectType
    * 
    * @param context
    * @return
    */
    Page<WorkItemType> fetchCurProjectType(WorkItemTypeSearchContext context);

    /**
    * listCurProjectType
    * 
    * @param context
    * @return
    */
    List<WorkItemType> listCurProjectType(WorkItemTypeSearchContext context);

    /**
    * fetchProjectWorkItemType
    * 
    * @param context
    * @return
    */
    Page<WorkItemType> fetchProjectWorkItemType(WorkItemTypeSearchContext context);

    /**
    * listProjectWorkItemType
    * 
    * @param context
    * @return
    */
    List<WorkItemType> listProjectWorkItemType(WorkItemTypeSearchContext context);

    /**
    * fetchProjectWorkItemTypeNotBug
    * 
    * @param context
    * @return
    */
    Page<WorkItemType> fetchProjectWorkItemTypeNotBug(WorkItemTypeSearchContext context);

    /**
    * listProjectWorkItemTypeNotBug
    * 
    * @param context
    * @return
    */
    List<WorkItemType> listProjectWorkItemTypeNotBug(WorkItemTypeSearchContext context);

    /**
    * findByProjectId
    * @param projectIds
    * @return
    */
    List<WorkItemType> findByProjectId(List<String> projectIds);
    default List<WorkItemType> findByProjectId(String projectId){
        return findByProjectId(Arrays.asList(projectId));
    }

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
    default boolean saveByProjectId(String projectId, List<WorkItemType> list){
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<WorkItemType> list);


    default ImportResult importData(String config, Boolean ignoreError, List<WorkItemType> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            WorkItemType et=list.get(i);
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
    default WorkItemType getEntity() {
        return new WorkItemType();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default WorkItemTypeSearchContext getSearchContext() {
        return new WorkItemTypeSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}