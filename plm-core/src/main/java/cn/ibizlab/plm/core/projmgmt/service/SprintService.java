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
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 迭代服务接口[SprintService]
 *
 * @author generator
 */
public interface SprintService extends IService<Sprint> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SprintService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Sprint et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Sprint> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Sprint et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Sprint> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Sprint().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Sprint et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Sprint> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Sprint().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Sprint> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Sprint get(String key) {
        return getSelf().get(new Sprint().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Sprint get(Sprint et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Sprint> get(Collection<String> keys) {
        List<Sprint> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Sprint().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Sprint> get(List<Sprint> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Sprint getDraft(Sprint et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Sprint et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Sprint et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Sprint> list);

    /**
    * calSprintWorkItemNum
    * 
    * @param key
    * @return
    */
    default Sprint calSprintWorkItemNum(String key) {
        return getSelf().calSprintWorkItemNum(new Sprint().setId(key));
    }

    /**
    * delRelation
    * 
    * @param et
    * @return
    */
    default Sprint delRelation(Sprint et) {
        return et;
    }

    /**
    * deleteCategories
    * 
    * @param et
    * @return
    */
    default Sprint deleteCategories(Sprint et) {
        return et;
    }

    /**
    * endSprint
    * 
    * @param et
    * @return
    */
    default Sprint endSprint(Sprint et) {
        return et;
    }

    /**
    * getNotFinish
    * 
    * @param key
    * @return
    */
    default Sprint getNotFinish(String key) {
        return getSelf().getNotFinish(new Sprint().setId(key));
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Sprint nothing(Sprint et) {
        return et;
    }

    /**
    * overview
    * 
    * @param key
    * @return
    */
    default Sprint overview(String key) {
        return getSelf().overview(new Sprint().setId(key));
    }

    /**
    * sprintRelationRelease
    * 
    * @param et
    * @return
    */
    default Sprint sprintRelationRelease(Sprint et) {
        return et;
    }

    /**
    * startSprint
    * 
    * @param et
    * @return
    */
    default Sprint startSprint(Sprint et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchDefault(SprintSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Sprint> listDefault(SprintSearchContext context);

    /**
    * fetchAll
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchAll(SprintSearchContext context);

    /**
    * listAll
    * 
    * @param context
    * @return
    */
    List<Sprint> listAll(SprintSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchBiDetail(SprintSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<Sprint> listBiDetail(SprintSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchBiSearch(SprintSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<Sprint> listBiSearch(SprintSearchContext context);

    /**
    * fetchChooseMove
    * 确认迭代完成时，选择移动至其他迭代
    * @param context
    * @return
    */
    Page<Sprint> fetchChooseMove(SprintSearchContext context);

    /**
    * listChooseMove
    * 确认迭代完成时，选择移动至其他迭代
    * @param context
    * @return
    */
    List<Sprint> listChooseMove(SprintSearchContext context);

    /**
    * fetchChooseSprintRelation
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchChooseSprintRelation(SprintSearchContext context);

    /**
    * listChooseSprintRelation
    * 
    * @param context
    * @return
    */
    List<Sprint> listChooseSprintRelation(SprintSearchContext context);

    /**
    * fetchCurSprintNotFinish
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchCurSprintNotFinish(SprintSearchContext context);

    /**
    * listCurSprintNotFinish
    * 
    * @param context
    * @return
    */
    List<Sprint> listCurSprintNotFinish(SprintSearchContext context);

    /**
    * fetchNotFinish
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchNotFinish(SprintSearchContext context);

    /**
    * listNotFinish
    * 
    * @param context
    * @return
    */
    List<Sprint> listNotFinish(SprintSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchReader(SprintSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Sprint> listReader(SprintSearchContext context);

    /**
    * fetchReleaseRelation
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchReleaseRelation(SprintSearchContext context);

    /**
    * listReleaseRelation
    * 
    * @param context
    * @return
    */
    List<Sprint> listReleaseRelation(SprintSearchContext context);

    /**
    * findByProjectId
    * @param projectIds
    * @return
    */
    List<Sprint> findByProjectId(List<String> projectIds);
    default List<Sprint> findByProjectId(String projectId){
        return findByProject(new Project().setId(projectId));
    }

    /**
    * findByProject
    * @param project
    * @return
    */
    List<Sprint> findByProject(Project project);

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
    default boolean saveByProjectId(String projectId, List<Sprint> list){
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<Sprint> list);

    /**
    * findByPid
    * @param pids
    * @return
    */
    List<Sprint> findByPid(List<String> pids);
    default List<Sprint> findByPid(String pid){
        return findBySprint(new Sprint().setId(pid));
    }

    /**
    * findBySprint
    * @param sprint
    * @return
    */
    List<Sprint> findBySprint(Sprint sprint);

    /**
    * removeByPid
    * @param pid
    * @return
    */
    boolean removeByPid(String pid);

    /**
    * resetByPid
    * @param pid
    * @return
    */
    boolean resetByPid(String pid);

    /**
    * saveByPid
    * @param pid
    * @param list
    * @return
    */
    default boolean saveByPid(String pid, List<Sprint> list){
        return getSelf().saveBySprint(new Sprint().setId(pid),list);
    }

    /**
    * saveBySprint
    * @param sprint
    * @param list
    * @return
    */
    boolean saveBySprint(Sprint sprint, List<Sprint> list);

    /**
    * calSprintWorkItemNum
    * 
    * @param et
    * @return
    */
    default Sprint calSprintWorkItemNum(Sprint et) {
        return et;
    }

    /**
    * getNotFinish
    * 
    * @param et
    * @return
    */
    default Sprint getNotFinish(Sprint et) {
        return et;
    }

    /**
    * overview
    * 
    * @param et
    * @return
    */
    default Sprint overview(Sprint et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Sprint> fetchView(SprintSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Sprint> listView(SprintSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Sprint> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Sprint et=list.get(i);
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
    default Sprint getEntity() {
        return new Sprint();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SprintSearchContext getSearchContext() {
        return new SprintSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}