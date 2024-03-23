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
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.filter.EntrySearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 看板栏服务接口[EntryService]
 *
 * @author generator
 */
public interface EntryService extends IService<Entry> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default EntryService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Entry get(Entry et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Entry get(String key) {
        return getSelf().get(new Entry().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Entry> getByIds(Collection<String> ids) {
        List<Entry> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Entry().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Entry> getByEntities(List<Entry> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Entry getDraft(Entry et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Entry et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Entry et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Entry> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Entry et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Entry> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Entry et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Entry> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Entry().setId(key));
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
    boolean remove(Entry et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Entry> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Entry().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Entry> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Entry> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Entry et=list.get(i);
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
    Page<Entry> searchDefault(EntrySearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Entry> listDefault(EntrySearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Entry getEntity() {
        return new Entry();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default EntrySearchContext getSearchContext() {
        return new EntrySearchContext();
    }
    /**
     * selectRelByBoardId
     * @param boardIds
     * @return
     */
    List<Entry> findByBoardId(List<String> boardIds);
    default List<Entry> findByBoardId(String boardId) {
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
    default boolean saveByBoardId(String boardId,List<Entry> list) {
        return getSelf().saveByBoard(new Board().setId(boardId),list);
    }
    /**
    * saveRelByBoard
    * @param board
    * @param list
    * @return
    */
    boolean saveByBoard(Board board,List<Entry> list);

    /**
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<Entry> findByProjectId(List<String> projectIds);
    default List<Entry> findByProjectId(String projectId) {
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
    default boolean saveByProjectId(String projectId,List<Entry> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<Entry> list);


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