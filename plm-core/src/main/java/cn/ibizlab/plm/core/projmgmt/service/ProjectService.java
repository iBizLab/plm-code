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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.domain.Progress;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;

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
     * 获取
     * @param et
     * @return
     */
    Project get(Project et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Project get(String key) {
        return getSelf().get(new Project().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Project> getByIds(Collection<String> ids) {
        List<Project> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Project().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Project> getByEntities(List<Project> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Project getDraft(Project et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Project et);

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
    boolean createBatch(List<Project> list);

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
    boolean updateBatch(List<Project> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Project et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Project> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Project().setId(key));
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
    boolean remove(Project et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Project> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Project().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Project> entities);

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
     * CreateTemp
     * 
     * @param dto
     * @return
     */
    default Project createTemp(Project dto) {
        return dto;
    }

    /**
     * CreateTempMajor
     * 
     * @param dto
     * @return
     */
    default Project createTempMajor(Project dto) {
        return dto;
    }

    /**
     * UpdateTemp
     * 
     * @param dto
     * @return
     */
    default Project updateTemp(Project dto) {
        return dto;
    }

    /**
     * UpdateTempMajor
     * 
     * @param dto
     * @return
     */
    default Project updateTempMajor(Project dto) {
        return dto;
    }

    /**
     * RemoveTemp
     * 
     * @param keys
     * @return
     */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
     * RemoveTempMajor
     * 
     * @param keys
     * @return
     */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
     * GetTemp
     * 
     * @param key
     * @return
     */
    default Project getTemp(String key) {
        return null;
    }

    /**
     * GetTempMajor
     * 
     * @param key
     * @return
     */
    default Project getTempMajor(String key) {
        return null;
    }

    /**
     * GetDraftTemp
     * 
     * @param dto
     * @return
     */
    default Project getDraftTemp(Project dto) {
        return dto;
    }

    /**
     * GetDraftTempMajor
     * 
     * @param dto
     * @return
     */
    default Project getDraftTempMajor(Project dto) {
        return dto;
    }

    /**
     * activate
     * 
     * @param dto
     * @return
     */
    default Project activate(Project dto) {
        return dto;
    }

    /**
     * archive
     * 
     * @param dto
     * @return
     */
    default Project archive(Project dto) {
        return dto;
    }

    /**
     * delete
     * 
     * @param dto
     * @return
     */
    default Project delete(Project dto) {
        return dto;
    }

    /**
     * favorite
     * 
     * @param dto
     * @return
     */
    default Project favorite(Project dto) {
        return dto;
    }

    /**
     * get_major_data
     * 
     * @param key
     * @return
     */
    default Project getMajorData(String key) {
        return getSelf().getMajorData(new Project().setId(key));
    }

    /**
     * other_re_space
     * 
     * @param dto
     * @return
     */
    default Project otherReSpace(Project dto) {
        return dto;
    }

    /**
     * recover
     * 
     * @param dto
     * @return
     */
    default Project recover(Project dto) {
        return dto;
    }

    /**
     * remove_from_project_set
     * 
     * @param dto
     * @return
     */
    default Project removeFromProjectSet(Project dto) {
        return dto;
    }

    /**
     * un_favorite
     * 
     * @param dto
     * @return
     */
    default Project unFavorite(Project dto) {
        return dto;
    }

    /**
     * get_major_data
     * 
     * @param et
     * @return
     */
    default Project getMajorData(Project et) {
        return et;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Project> searchDefault(ProjectSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Project> listDefault(ProjectSearchContext context);

    /**
     * searchadmin
     * 
     * @param context
     * @return
     */
    Page<Project> searchAdmin(ProjectSearchContext context);
    /**
     * listadmin
     * 
     * @param context
     * @return
     */
    List<Project> listAdmin(ProjectSearchContext context);

    /**
     * searcharchived
     * 
     * @param context
     * @return
     */
    Page<Project> searchArchived(ProjectSearchContext context);
    /**
     * listarchived
     * 
     * @param context
     * @return
     */
    List<Project> listArchived(ProjectSearchContext context);

    /**
     * searchchoose_project
     * 
     * @param context
     * @return
     */
    Page<Project> searchChooseProject(ProjectSearchContext context);
    /**
     * listchoose_project
     * 
     * @param context
     * @return
     */
    List<Project> listChooseProject(ProjectSearchContext context);

    /**
     * searchcurrent
     * 
     * @param context
     * @return
     */
    Page<Project> searchCurrent(ProjectSearchContext context);
    /**
     * listcurrent
     * 
     * @param context
     * @return
     */
    List<Project> listCurrent(ProjectSearchContext context);

    /**
     * searchdeleted
     * 
     * @param context
     * @return
     */
    Page<Project> searchDeleted(ProjectSearchContext context);
    /**
     * listdeleted
     * 
     * @param context
     * @return
     */
    List<Project> listDeleted(ProjectSearchContext context);

    /**
     * searchfavorite
     * 
     * @param context
     * @return
     */
    Page<Project> searchFavorite(ProjectSearchContext context);
    /**
     * listfavorite
     * 
     * @param context
     * @return
     */
    List<Project> listFavorite(ProjectSearchContext context);

    /**
     * searchnormal
     * 
     * @param context
     * @return
     */
    Page<Project> searchNormal(ProjectSearchContext context);
    /**
     * listnormal
     * 
     * @param context
     * @return
     */
    List<Project> listNormal(ProjectSearchContext context);

    /**
     * searchreader
     * 
     * @param context
     * @return
     */
    Page<Project> searchReader(ProjectSearchContext context);
    /**
     * listreader
     * 
     * @param context
     * @return
     */
    List<Project> listReader(ProjectSearchContext context);

    /**
     * searchsame_type
     * 
     * @param context
     * @return
     */
    Page<Project> searchSameType(ProjectSearchContext context);
    /**
     * listsame_type
     * 
     * @param context
     * @return
     */
    List<Project> listSameType(ProjectSearchContext context);

    /**
     * searchunder_project_portfolio
     * 
     * @param context
     * @return
     */
    Page<Project> searchUnderProjectPortfolio(ProjectSearchContext context);
    /**
     * listunder_project_portfolio
     * 
     * @param context
     * @return
     */
    List<Project> listUnderProjectPortfolio(ProjectSearchContext context);

    /**
     * searchuser
     * 
     * @param context
     * @return
     */
    Page<Project> searchUser(ProjectSearchContext context);
    /**
     * listuser
     * 
     * @param context
     * @return
     */
    List<Project> listUser(ProjectSearchContext context);

    /**
     * searchwork_project
     * 
     * @param context
     * @return
     */
    Page<Project> searchWorkProject(ProjectSearchContext context);
    /**
     * listwork_project
     * 
     * @param context
     * @return
     */
    List<Project> listWorkProject(ProjectSearchContext context);

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
    default List<ProjectMember> getMembers(Project et) {
        return new ArrayList<>();
    }


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