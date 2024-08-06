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
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.filter.BoardSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 看板服务接口[BoardService]
 *
 * @author generator
 */
public interface BoardService extends IService<Board> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default BoardService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Board et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Board> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Board et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Board> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Board().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Board et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Board> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Board().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Board> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Board get(String key) {
        return getSelf().get(new Board().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Board get(Board et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Board> get(Collection<String> keys) {
        List<Board> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Board().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Board> get(List<Board> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Board getDraft(Board et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Board et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Board et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Board> list);

    /**
    * checkBoardIsDeleted
    * 
    * @param et
    * @return
    */
    default Board checkBoardIsDeleted(Board et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Board nothing(Board et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Board> fetchDefault(BoardSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Board> listDefault(BoardSearchContext context);

    /**
    * fetchCurBoardUpload
    * 
    * @param context
    * @return
    */
    Page<Board> fetchCurBoardUpload(BoardSearchContext context);

    /**
    * listCurBoardUpload
    * 
    * @param context
    * @return
    */
    List<Board> listCurBoardUpload(BoardSearchContext context);

    /**
    * fetchCurProjectBoard
    * 
    * @param context
    * @return
    */
    Page<Board> fetchCurProjectBoard(BoardSearchContext context);

    /**
    * listCurProjectBoard
    * 
    * @param context
    * @return
    */
    List<Board> listCurProjectBoard(BoardSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Board> fetchReader(BoardSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Board> listReader(BoardSearchContext context);

    /**
    * findByProjectId
    * @param projectIds
    * @return
    */
    List<Board> findByProjectId(List<String> projectIds);
    default List<Board> findByProjectId(String projectId){
        return findByProject(new Project().setId(projectId));
    }

    /**
    * findByProject
    * @param project
    * @return
    */
    List<Board> findByProject(Project project);

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
    default boolean saveByProjectId(String projectId, List<Board> list){
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<Board> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Board> fetchView(BoardSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Board> listView(BoardSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Board> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Board et=list.get(i);
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
    default Board getEntity() {
        return new Board();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default BoardSearchContext getSearchContext() {
        return new BoardSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}