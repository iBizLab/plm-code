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
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.filter.SwimlaneSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 泳道服务接口[SwimlaneService]
 *
 * @author generator
 */
public interface SwimlaneService extends IService<Swimlane> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SwimlaneService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Swimlane get(Swimlane et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Swimlane get(String key) {
        return getSelf().get(new Swimlane().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Swimlane> getByIds(Collection<String> ids) {
        List<Swimlane> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Swimlane().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Swimlane> getByEntities(List<Swimlane> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Swimlane getDraft(Swimlane et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Swimlane et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Swimlane et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Swimlane> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Swimlane et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Swimlane> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Swimlane et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Swimlane> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Swimlane().setId(key));
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
    boolean remove(Swimlane et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Swimlane> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Swimlane().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Swimlane> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Swimlane> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Swimlane et=list.get(i);
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
    Page<Swimlane> searchDefault(SwimlaneSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Swimlane> listDefault(SwimlaneSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Swimlane getEntity() {
        return new Swimlane();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default SwimlaneSearchContext getSearchContext() {
        return new SwimlaneSearchContext();
    }
    /**
     * selectRelByBoardId
     * @param boardIds
     * @return
     */
    List<Swimlane> findByBoardId(List<String> boardIds);
    default List<Swimlane> findByBoardId(String boardId) {
        return findByBoardId(Arrays.asList(boardId));
    }
    /**
     * removeRelByBoardId
     * @param boardId
     * @return
     */
    boolean removeByBoardId(String boardId);
    /**
     * resetRelByBoardId
     * @param boardId
     * @return
     */
    boolean resetByBoardId(String boardId);
    /**
     * saveRelByBoardId
     * @param boardId
     * @param list
     * @return
     */
    default boolean saveByBoardId(String boardId,List<Swimlane> list) {
        return getSelf().saveByBoard(new Board().setId(boardId),list);
    }
    /**
    * saveRelByBoard
    * @param board
    * @param list
    * @return
    */
    boolean saveByBoard(Board board,List<Swimlane> list);

    /**
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<Swimlane> findByProjectId(List<String> projectIds);
    default List<Swimlane> findByProjectId(String projectId) {
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
    default boolean saveByProjectId(String projectId,List<Swimlane> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<Swimlane> list);


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