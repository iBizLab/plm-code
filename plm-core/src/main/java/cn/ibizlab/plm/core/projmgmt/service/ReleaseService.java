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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.filter.ReleaseSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.base.domain.Relation;

/**
 * 项目发布服务接口[ReleaseService]
 *
 * @author generator
 */
public interface ReleaseService extends IService<Release> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ReleaseService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Release et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Release> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Release et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Release> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Release().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Release et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Release> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Release().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Release> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Release get(String key) {
        return getSelf().get(new Release().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Release get(Release et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Release> get(Collection<String> keys) {
        List<Release> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Release().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Release> get(List<Release> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Release getDraft(Release et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Release et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Release et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Release> list);

    /**
    * calReleaseWorkItemNum
    * 
    * @param key
    * @return
    */
    default Release calReleaseWorkItemNum(String key) {
        return getSelf().calReleaseWorkItemNum(new Release().setId(key));
    }

    /**
    * changeDraft
    * 
    * @param et
    * @return
    */
    default Release changeDraft(Release et) {
        return et;
    }

    /**
    * changeStage
    * 
    * @param et
    * @return
    */
    default Release changeStage(Release et) {
        return et;
    }

    /**
    * delRelation
    * 
    * @param et
    * @return
    */
    default Release delRelation(Release et) {
        return et;
    }

    /**
    * deleteCategories
    * 
    * @param et
    * @return
    */
    default Release deleteCategories(Release et) {
        return et;
    }

    /**
    * planWorkItem
    * 
    * @param et
    * @return
    */
    default Release planWorkItem(Release et) {
        return et;
    }

    /**
    * releaseRelationSprint
    * 
    * @param et
    * @return
    */
    default Release releaseRelationSprint(Release et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Release> fetchDefault(ReleaseSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Release> listDefault(ReleaseSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<Release> fetchBiDetail(ReleaseSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<Release> listBiDetail(ReleaseSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<Release> fetchBiSearch(ReleaseSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<Release> listBiSearch(ReleaseSearchContext context);

    /**
    * fetchChooseReleseRelation
    * 
    * @param context
    * @return
    */
    Page<Release> fetchChooseReleseRelation(ReleaseSearchContext context);

    /**
    * listChooseReleseRelation
    * 
    * @param context
    * @return
    */
    List<Release> listChooseReleseRelation(ReleaseSearchContext context);

    /**
    * fetchNotPublished
    * 
    * @param context
    * @return
    */
    Page<Release> fetchNotPublished(ReleaseSearchContext context);

    /**
    * listNotPublished
    * 
    * @param context
    * @return
    */
    List<Release> listNotPublished(ReleaseSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Release> fetchReader(ReleaseSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Release> listReader(ReleaseSearchContext context);

    /**
    * fetchSprintRelation
    * 
    * @param context
    * @return
    */
    Page<Release> fetchSprintRelation(ReleaseSearchContext context);

    /**
    * listSprintRelation
    * 
    * @param context
    * @return
    */
    List<Release> listSprintRelation(ReleaseSearchContext context);

    /**
    * findByProjectId
    * @param projectIds
    * @return
    */
    List<Release> findByProjectId(List<String> projectIds);
    default List<Release> findByProjectId(String projectId){
        return findByProject(new Project().setId(projectId));
    }

    /**
    * findByProject
    * @param project
    * @return
    */
    List<Release> findByProject(Project project);

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
    default boolean saveByProjectId(String projectId, List<Release> list){
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<Release> list);

    default List<Stage> getStageTransitions(Release et) {
        return new ArrayList<>();
    }

    /**
    * calReleaseWorkItemNum
    * 
    * @param et
    * @return
    */
    default Release calReleaseWorkItemNum(Release et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Release> fetchView(ReleaseSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Release> listView(ReleaseSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Release> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Release et=list.get(i);
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
    default Release getEntity() {
        return new Release();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ReleaseSearchContext getSearchContext() {
        return new ReleaseSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}