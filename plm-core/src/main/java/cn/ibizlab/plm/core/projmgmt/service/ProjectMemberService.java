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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.DayCapacity;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 项目成员服务接口[ProjectMemberService]
 *
 * @author generator
 */
public interface ProjectMemberService extends IService<ProjectMember> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProjectMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ProjectMember et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ProjectMember> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ProjectMember et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ProjectMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProjectMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ProjectMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ProjectMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProjectMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ProjectMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ProjectMember get(String key) {
        return getSelf().get(new ProjectMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProjectMember get(ProjectMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ProjectMember> get(Collection<String> keys) {
        List<ProjectMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProjectMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ProjectMember> get(List<ProjectMember> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ProjectMember getDraft(ProjectMember et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(ProjectMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ProjectMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ProjectMember> list);

    /**
    * changePosition
    * 
    * @param et
    * @return
    */
    default ProjectMember changePosition(ProjectMember et) {
        return et;
    }

    /**
    * changeRole
    * 
    * @param et
    * @return
    */
    default ProjectMember changeRole(ProjectMember et) {
        return et;
    }

    /**
    * createProjectMember
    * 
    * @param et
    * @return
    */
    default ProjectMember createProjectMember(ProjectMember et) {
        return et;
    }

    /**
    * mobCreateProjectMember
    * 
    * @param et
    * @return
    */
    default ProjectMember mobCreateProjectMember(ProjectMember et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default ProjectMember nothing(ProjectMember et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ProjectMember> fetchDefault(ProjectMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ProjectMember> listDefault(ProjectMemberSearchContext context);

    /**
    * fetchCurProject
    * 
    * @param context
    * @return
    */
    Page<ProjectMember> fetchCurProject(ProjectMemberSearchContext context);

    /**
    * listCurProject
    * 
    * @param context
    * @return
    */
    List<ProjectMember> listCurProject(ProjectMemberSearchContext context);

    /**
    * fetchNoAttention
    * 
    * @param context
    * @return
    */
    Page<ProjectMember> fetchNoAttention(ProjectMemberSearchContext context);

    /**
    * listNoAttention
    * 
    * @param context
    * @return
    */
    List<ProjectMember> listNoAttention(ProjectMemberSearchContext context);

    /**
    * findByProjectId
    * @param projectIds
    * @return
    */
    List<ProjectMember> findByProjectId(List<String> projectIds);
    default List<ProjectMember> findByProjectId(String projectId){
        return findByProject(new Project().setId(projectId));
    }

    /**
    * findByProject
    * @param project
    * @return
    */
    List<ProjectMember> findByProject(Project project);

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
    default boolean saveByProjectId(String projectId, List<ProjectMember> list){
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<ProjectMember> list);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<ProjectMember> findByUserId(List<String> userIds);
    default List<ProjectMember> findByUserId(String userId){
        return findByUser(new User().setId(userId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<ProjectMember> findByUser(User user);

    /**
    * removeByUserId
    * @param userId
    * @return
    */
    boolean removeByUserId(String userId);

    /**
    * resetByUserId
    * @param userId
    * @return
    */
    boolean resetByUserId(String userId);

    /**
    * saveByUserId
    * @param userId
    * @param list
    * @return
    */
    default boolean saveByUserId(String userId, List<ProjectMember> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<ProjectMember> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ProjectMember> fetchView(ProjectMemberSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ProjectMember> listView(ProjectMemberSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<ProjectMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ProjectMember et=list.get(i);
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
    default ProjectMember getEntity() {
        return new ProjectMember();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ProjectMemberSearchContext getSearchContext() {
        return new ProjectMemberSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}