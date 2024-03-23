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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.DayCapacity;

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
     * 获取
     * @param et
     * @return
     */
    ProjectMember get(ProjectMember et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ProjectMember get(String key) {
        return getSelf().get(new ProjectMember().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ProjectMember> getByIds(Collection<String> ids) {
        List<ProjectMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProjectMember().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ProjectMember> getByEntities(List<ProjectMember> entities);

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
    Integer checkKey(ProjectMember et);

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
    boolean createBatch(List<ProjectMember> list);

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
    boolean updateBatch(List<ProjectMember> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ProjectMember et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ProjectMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProjectMember().setId(key));
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
    boolean remove(ProjectMember et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ProjectMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProjectMember().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ProjectMember> entities);

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
     * Create_project_member
     * 
     * @param dto
     * @return
     */
    default ProjectMember createProjectMember(ProjectMember dto) {
        return dto;
    }

    /**
     * searchCur_project
     * 
     * @param context
     * @return
     */
    Page<ProjectMember> searchCurProject(ProjectMemberSearchContext context);
    /**
     * listCur_project
     * 
     * @param context
     * @return
     */
    List<ProjectMember> listCurProject(ProjectMemberSearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<ProjectMember> searchDefault(ProjectMemberSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ProjectMember> listDefault(ProjectMemberSearchContext context);

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
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<ProjectMember> findByProjectId(List<String> projectIds);
    default List<ProjectMember> findByProjectId(String projectId) {
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
    default boolean saveByProjectId(String projectId,List<ProjectMember> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<ProjectMember> list);

    /**
     * selectRelByUserId
     * @param userIds
     * @return
     */
    List<ProjectMember> findByUserId(List<String> userIds);
    default List<ProjectMember> findByUserId(String userId) {
        return findByUserId(Arrays.asList(userId));
    }
    /**
     * removeRelByUserId
     * @param userId
     * @return
     */
    boolean removeByUserId(String userId);
    /**
     * resetRelByUserId
     * @param userId
     * @return
     */
    boolean resetByUserId(String userId);
    /**
     * saveRelByUserId
     * @param userId
     * @param list
     * @return
     */
    default boolean saveByUserId(String userId,List<ProjectMember> list) {
        return getSelf().saveByUser(new User().setId(userId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<ProjectMember> list);


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