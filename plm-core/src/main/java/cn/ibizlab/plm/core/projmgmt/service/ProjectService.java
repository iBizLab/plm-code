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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectState;
import cn.ibizlab.plm.core.base.domain.CommonFlow;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.domain.Progress;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.extension.domain.PSDELogicNode;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.domain.AddonResource;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 项目服务接口[ProjectService]
 *
 * @author generator
 */
public interface ProjectService extends IService<Project> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProjectService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Project et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Project> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default Project createTemp(Project et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default Project createTempMajor(Project et) {
        return et;
    }

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Project et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Project> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default Project updateTemp(Project et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default Project updateTempMajor(Project et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Project().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Project et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Project> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Project().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Project> entities);

    /**
    * removeTemp
    * 
    * @param keys
    * @return
    */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
    * removeTempMajor
    * 
    * @param keys
    * @return
    */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
    * 获取
    * @param key
    * @return
    */
    default Project get(String key) {
        return getSelf().get(new Project().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Project get(Project et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Project> get(Collection<String> keys) {
        List<Project> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Project().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Project> get(List<Project> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default Project getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default Project getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    Project getDraft(Project et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default Project getDraftTemp(Project et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default Project getDraftTempMajor(Project et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Project et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Project et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Project> list);

    /**
    * activate
    * 
    * @param et
    * @return
    */
    default Project activate(Project et) {
        return et;
    }

    /**
    * archive
    * 
    * @param et
    * @return
    */
    default Project archive(Project et) {
        return et;
    }

    /**
    * changeAdminRole
    * 
    * @param et
    * @return
    */
    default Project changeAdminRole(Project et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default Project delete(Project et) {
        return et;
    }

    /**
    * favorite
    * 
    * @param et
    * @return
    */
    default Project favorite(Project et) {
        return et;
    }

    /**
    * fillBiFormDefault
    * 
    * @param et
    * @return
    */
    default Project fillBiFormDefault(Project et) {
        return et;
    }

    /**
    * getMajorData
    * 
    * @param key
    * @return
    */
    default Project getMajorData(String key) {
        return getSelf().getMajorData(new Project().setId(key));
    }

    /**
    * hybridIndexAddonCounter
    * 
    * @param et
    * @return
    */
    default Project hybridIndexAddonCounter(Project et) {
        return et;
    }

    /**
    * kanbanIndexAddonCounter
    * 
    * @param et
    * @return
    */
    default Project kanbanIndexAddonCounter(Project et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Project nothing(Project et) {
        return et;
    }

    /**
    * otherReProject
    * 
    * @param et
    * @return
    */
    default Project otherReProject(Project et) {
        return et;
    }

    /**
    * otherReSpace
    * 
    * @param et
    * @return
    */
    default Project otherReSpace(Project et) {
        return et;
    }

    /**
    * projectAutomaticChangeState
    * 
    * @param et
    * @return
    */
    default Project projectAutomaticChangeState(Project et) {
        return et;
    }

    /**
    * projectMove
    * 
    * @param et
    * @return
    */
    default Project projectMove(Project et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default Project recover(Project et) {
        return et;
    }

    /**
    * removeFromProjectSet
    * 
    * @param et
    * @return
    */
    default Project removeFromProjectSet(Project et) {
        return et;
    }

    /**
    * scrumIndexAddonCounter
    * 
    * @param et
    * @return
    */
    default Project scrumIndexAddonCounter(Project et) {
        return et;
    }

    /**
    * unFavorite
    * 
    * @param et
    * @return
    */
    default Project unFavorite(Project et) {
        return et;
    }

    /**
    * warningCountLogic
    * 
    * @param et
    * @return
    */
    default Project warningCountLogic(Project et) {
        return et;
    }

    /**
    * waterfallIndexAddonCounter
    * 
    * @param et
    * @return
    */
    default Project waterfallIndexAddonCounter(Project et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Project> fetchDefault(ProjectSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Project> listDefault(ProjectSearchContext context);

    /**
    * fetchAdmin
    * 
    * @param context
    * @return
    */
    Page<Project> fetchAdmin(ProjectSearchContext context);

    /**
    * listAdmin
    * 
    * @param context
    * @return
    */
    List<Project> listAdmin(ProjectSearchContext context);

    /**
    * fetchArchived
    * 
    * @param context
    * @return
    */
    Page<Project> fetchArchived(ProjectSearchContext context);

    /**
    * listArchived
    * 
    * @param context
    * @return
    */
    List<Project> listArchived(ProjectSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<Project> fetchBiDetail(ProjectSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<Project> listBiDetail(ProjectSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<Project> fetchBiSearch(ProjectSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<Project> listBiSearch(ProjectSearchContext context);

    /**
    * fetchChooseProject
    * 
    * @param context
    * @return
    */
    Page<Project> fetchChooseProject(ProjectSearchContext context);

    /**
    * listChooseProject
    * 
    * @param context
    * @return
    */
    List<Project> listChooseProject(ProjectSearchContext context);

    /**
    * fetchCurrent
    * 
    * @param context
    * @return
    */
    Page<Project> fetchCurrent(ProjectSearchContext context);

    /**
    * listCurrent
    * 
    * @param context
    * @return
    */
    List<Project> listCurrent(ProjectSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<Project> fetchDeleted(ProjectSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<Project> listDeleted(ProjectSearchContext context);

    /**
    * fetchFavorite
    * 
    * @param context
    * @return
    */
    Page<Project> fetchFavorite(ProjectSearchContext context);

    /**
    * listFavorite
    * 
    * @param context
    * @return
    */
    List<Project> listFavorite(ProjectSearchContext context);

    /**
    * fetchMain
    * 
    * @param context
    * @return
    */
    Page<Project> fetchMain(ProjectSearchContext context);

    /**
    * listMain
    * 
    * @param context
    * @return
    */
    List<Project> listMain(ProjectSearchContext context);

    /**
    * fetchMobMain
    * 
    * @param context
    * @return
    */
    Page<Project> fetchMobMain(ProjectSearchContext context);

    /**
    * listMobMain
    * 
    * @param context
    * @return
    */
    List<Project> listMobMain(ProjectSearchContext context);

    /**
    * fetchNoRelation
    * 
    * @param context
    * @return
    */
    Page<Project> fetchNoRelation(ProjectSearchContext context);

    /**
    * listNoRelation
    * 
    * @param context
    * @return
    */
    List<Project> listNoRelation(ProjectSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<Project> fetchNormal(ProjectSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<Project> listNormal(ProjectSearchContext context);

    /**
    * fetchProductReProject
    * 
    * @param context
    * @return
    */
    Page<Project> fetchProductReProject(ProjectSearchContext context);

    /**
    * listProductReProject
    * 
    * @param context
    * @return
    */
    List<Project> listProductReProject(ProjectSearchContext context);

    /**
    * fetchQuickUser
    * 
    * @param context
    * @return
    */
    Page<Project> fetchQuickUser(ProjectSearchContext context);

    /**
    * listQuickUser
    * 
    * @param context
    * @return
    */
    List<Project> listQuickUser(ProjectSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Project> fetchReader(ProjectSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Project> listReader(ProjectSearchContext context);

    /**
    * fetchSameType
    * 
    * @param context
    * @return
    */
    Page<Project> fetchSameType(ProjectSearchContext context);

    /**
    * listSameType
    * 
    * @param context
    * @return
    */
    List<Project> listSameType(ProjectSearchContext context);

    /**
    * fetchUnderProjectPortfolio
    * 
    * @param context
    * @return
    */
    Page<Project> fetchUnderProjectPortfolio(ProjectSearchContext context);

    /**
    * listUnderProjectPortfolio
    * 
    * @param context
    * @return
    */
    List<Project> listUnderProjectPortfolio(ProjectSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<Project> fetchUser(ProjectSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<Project> listUser(ProjectSearchContext context);

    /**
    * fetchWorkProject
    * 
    * @param context
    * @return
    */
    Page<Project> fetchWorkProject(ProjectSearchContext context);

    /**
    * listWorkProject
    * 
    * @param context
    * @return
    */
    List<Project> listWorkProject(ProjectSearchContext context);

    /**
    * findByState
    * @param states
    * @return
    */
    List<Project> findByState(List<String> states);
    default List<Project> findByState(String state){
        return findByProjectState(new ProjectState().setId(state));
    }

    /**
    * findByProjectState
    * @param projectState
    * @return
    */
    List<Project> findByProjectState(ProjectState projectState);

    /**
    * removeByState
    * @param state
    * @return
    */
    boolean removeByState(String state);

    /**
    * resetByState
    * @param state
    * @return
    */
    boolean resetByState(String state);

    /**
    * saveByState
    * @param state
    * @param list
    * @return
    */
    default boolean saveByState(String state, List<Project> list){
        return getSelf().saveByProjectState(new ProjectState().setId(state),list);
    }

    /**
    * saveByProjectState
    * @param projectState
    * @param list
    * @return
    */
    boolean saveByProjectState(ProjectState projectState, List<Project> list);

    /**
    * findById
    * @param ids
    * @return
    */
    List<Project> findById(List<String> ids);
    default List<Project> findById(String id){
        return findByProject(new CommonFlow().setId(id));
    }

    /**
    * findByProject
    * @param commonFlow
    * @return
    */
    List<Project> findByProject(CommonFlow commonFlow);

    /**
    * removeById
    * @param id
    * @return
    */
    boolean removeById(String id);

    /**
    * resetById
    * @param id
    * @return
    */
    boolean resetById(String id);

    /**
    * saveById
    * @param id
    * @param list
    * @return
    */
    default boolean saveById(String id, List<Project> list){
        return getSelf().saveByProject(new CommonFlow().setId(id),list);
    }

    /**
    * saveByProject
    * @param commonFlow
    * @param list
    * @return
    */
    boolean saveByProject(CommonFlow commonFlow, List<Project> list);

    default List<ProjectMember> getMembers(Project et) {
        return new ArrayList<>();
    }

    /**
    * getMajorData
    * 
    * @param et
    * @return
    */
    default Project getMajorData(Project et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Project> fetchView(ProjectSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Project> listView(ProjectSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Project> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Project et=list.get(i);
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
    default Project getEntity() {
        return new Project();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ProjectSearchContext getSearchContext() {
        return new ProjectSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}