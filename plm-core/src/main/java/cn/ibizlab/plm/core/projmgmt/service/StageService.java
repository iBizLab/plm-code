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
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.projmgmt.filter.StageSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 发布阶段服务接口[StageService]
 *
 * @author generator
 */
public interface StageService extends IService<Stage> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default StageService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Stage et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Stage> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Stage et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Stage> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Stage().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Stage et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Stage> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Stage().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Stage> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Stage get(String key) {
        return getSelf().get(new Stage().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Stage get(Stage et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Stage> get(Collection<String> keys) {
        List<Stage> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Stage().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Stage> get(List<Stage> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Stage getDraft(Stage et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Stage et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Stage et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Stage> list);

    /**
    * addPredefined
    * 
    * @param et
    * @return
    */
    default Stage addPredefined(Stage et) {
        return et;
    }

    /**
    * del
    * 
    * @param et
    * @return
    */
    default Stage del(Stage et) {
        return et;
    }

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<Stage> moveOrder(Stage et) {
        return new ArrayList<>();
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Stage nothing(Stage et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Stage> fetchDefault(StageSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Stage> listDefault(StageSearchContext context);

    /**
    * fetchCurOwnerSys
    * 
    * @param context
    * @return
    */
    Page<Stage> fetchCurOwnerSys(StageSearchContext context);

    /**
    * listCurOwnerSys
    * 
    * @param context
    * @return
    */
    List<Stage> listCurOwnerSys(StageSearchContext context);

    /**
    * fetchCurProject
    * 
    * @param context
    * @return
    */
    Page<Stage> fetchCurProject(StageSearchContext context);

    /**
    * listCurProject
    * 
    * @param context
    * @return
    */
    List<Stage> listCurProject(StageSearchContext context);

    /**
    * fetchCurStage
    * 
    * @param context
    * @return
    */
    Page<Stage> fetchCurStage(StageSearchContext context);

    /**
    * listCurStage
    * 
    * @param context
    * @return
    */
    List<Stage> listCurStage(StageSearchContext context);

    /**
    * fetchOwner
    * 
    * @param context
    * @return
    */
    Page<Stage> fetchOwner(StageSearchContext context);

    /**
    * listOwner
    * 
    * @param context
    * @return
    */
    List<Stage> listOwner(StageSearchContext context);

    /**
    * fetchSystem
    * 
    * @param context
    * @return
    */
    Page<Stage> fetchSystem(StageSearchContext context);

    /**
    * listSystem
    * 
    * @param context
    * @return
    */
    List<Stage> listSystem(StageSearchContext context);

    /**
    * findByReleaseId
    * @param releaseIds
    * @return
    */
    List<Stage> findByReleaseId(List<String> releaseIds);
    default List<Stage> findByReleaseId(String releaseId){
        return findByRelease(new Release().setId(releaseId));
    }

    /**
    * findByRelease
    * @param release
    * @return
    */
    List<Stage> findByRelease(Release release);

    /**
    * removeByReleaseId
    * @param releaseId
    * @return
    */
    boolean removeByReleaseId(String releaseId);

    /**
    * resetByReleaseId
    * @param releaseId
    * @return
    */
    boolean resetByReleaseId(String releaseId);

    /**
    * saveByReleaseId
    * @param releaseId
    * @param list
    * @return
    */
    default boolean saveByReleaseId(String releaseId, List<Stage> list){
        return getSelf().saveByRelease(new Release().setId(releaseId),list);
    }

    /**
    * saveByRelease
    * @param release
    * @param list
    * @return
    */
    boolean saveByRelease(Release release, List<Stage> list);

    /**
    * findByPid
    * @param pids
    * @return
    */
    List<Stage> findByPid(List<String> pids);
    default List<Stage> findByPid(String pid){
        return findByStage(new Stage().setId(pid));
    }

    /**
    * findByStage
    * @param stage
    * @return
    */
    List<Stage> findByStage(Stage stage);

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
    default boolean saveByPid(String pid, List<Stage> list){
        return getSelf().saveByStage(new Stage().setId(pid),list);
    }

    /**
    * saveByStage
    * @param stage
    * @param list
    * @return
    */
    boolean saveByStage(Stage stage, List<Stage> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Stage> fetchView(StageSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Stage> listView(StageSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Stage> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Stage et=list.get(i);
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
    default Stage getEntity() {
        return new Stage();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default StageSearchContext getSearchContext() {
        return new StageSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}