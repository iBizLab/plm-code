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
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

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
     * 获取
     * @param et
     * @return
     */
    Sprint get(Sprint et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Sprint get(String key) {
        return getSelf().get(new Sprint().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Sprint> getByIds(Collection<String> ids) {
        List<Sprint> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Sprint().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Sprint> getByEntities(List<Sprint> entities);

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
    Integer checkKey(Sprint et);

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
    boolean createBatch(List<Sprint> list);

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
    boolean updateBatch(List<Sprint> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Sprint et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Sprint> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Sprint().setId(key));
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
    boolean remove(Sprint et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Sprint> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Sprint().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Sprint> entities);

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
     * End_sprint
     * 
     * @param dto
     * @return
     */
    default Sprint endSprint(Sprint dto) {
        return dto;
    }

    /**
     * Get_not_finish
     * 
     * @param key
     * @return
     */
    default Sprint getNotFinish(String key) {
        return getSelf().getNotFinish(new Sprint().setId(key));
    }

    /**
     * Nothing
     * 
     * @param dto
     * @return
     */
    default Sprint nothing(Sprint dto) {
        return dto;
    }

    /**
     * Start_sprint
     * 
     * @param dto
     * @return
     */
    default Sprint startSprint(Sprint dto) {
        return dto;
    }

    /**
     * Get_not_finish
     * 
     * @param et
     * @return
     */
    default Sprint getNotFinish(Sprint et) {
        return et;
    }

    /**
     * searchChoose_move
     * 确认迭代完成时，选择移动至其他迭代
     * @param context
     * @return
     */
    Page<Sprint> searchChooseMove(SprintSearchContext context);
    /**
     * listChoose_move
     * 确认迭代完成时，选择移动至其他迭代
     * @param context
     * @return
     */
    List<Sprint> listChooseMove(SprintSearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Sprint> searchDefault(SprintSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Sprint> listDefault(SprintSearchContext context);

    /**
     * searchNot_finish
     * 
     * @param context
     * @return
     */
    Page<Sprint> searchNotFinish(SprintSearchContext context);
    /**
     * listNot_finish
     * 
     * @param context
     * @return
     */
    List<Sprint> listNotFinish(SprintSearchContext context);

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
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<Sprint> findByProjectId(List<String> projectIds);
    default List<Sprint> findByProjectId(String projectId) {
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
    default boolean saveByProjectId(String projectId,List<Sprint> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<Sprint> list);

    /**
     * selectRelByPid
     * @param pids
     * @return
     */
    List<Sprint> findByPid(List<String> pids);
    default List<Sprint> findByPid(String pid) {
        return findByPid(Arrays.asList(pid));
    }
    /**
     * removeRelByPid
     * @param pid
     * @return
     */
    boolean removeByPid(String pid);
    /**
     * resetRelByPid
     * @param pid
     * @return
     */
    boolean resetByPid(String pid);
    /**
     * saveRelByPid
     * @param pid
     * @param list
     * @return
     */
    default boolean saveByPid(String pid,List<Sprint> list) {
        return getSelf().saveBySprint(new Sprint().setId(pid),list);
    }
    /**
    * saveRelBySprint
    * @param sprint
    * @param list
    * @return
    */
    boolean saveBySprint(Sprint sprint,List<Sprint> list);


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