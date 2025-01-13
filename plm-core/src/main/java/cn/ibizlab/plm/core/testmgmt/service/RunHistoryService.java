/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.filter.RunHistorySearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 执行结果服务接口[RunHistoryService]
 *
 * @author generator
 */
public interface RunHistoryService extends IService<RunHistory> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default RunHistoryService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(RunHistory et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<RunHistory> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(RunHistory et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<RunHistory> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new RunHistory().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(RunHistory et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<RunHistory> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new RunHistory().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<RunHistory> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default RunHistory get(String key) {
        return getSelf().get(new RunHistory().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    RunHistory get(RunHistory et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<RunHistory> get(Collection<String> keys) {
        List<RunHistory> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new RunHistory().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<RunHistory> get(List<RunHistory> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    RunHistory getDraft(RunHistory et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(RunHistory et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(RunHistory et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<RunHistory> list);

    /**
    * runHistoryGet
    * 
    * @param et
    * @return
    */
    default RunHistory runHistoryGet(RunHistory et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<RunHistory> fetchDefault(RunHistorySearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<RunHistory> listDefault(RunHistorySearchContext context);

    /**
    * fetchThis
    * 
    * @param context
    * @return
    */
    Page<RunHistory> fetchThis(RunHistorySearchContext context);

    /**
    * listThis
    * 
    * @param context
    * @return
    */
    List<RunHistory> listThis(RunHistorySearchContext context);

    /**
    * findByRunId
    * @param runIds
    * @return
    */
    List<RunHistory> findByRunId(List<String> runIds);
    default List<RunHistory> findByRunId(String runId){
        return findByRun(new Run().setId(runId));
    }

    /**
    * findByRun
    * @param run
    * @return
    */
    List<RunHistory> findByRun(Run run);

    /**
    * removeByRunId
    * @param runId
    * @return
    */
    boolean removeByRunId(String runId);

    /**
    * resetByRunId
    * @param runId
    * @return
    */
    boolean resetByRunId(String runId);

    /**
    * saveByRunId
    * @param runId
    * @param list
    * @return
    */
    default boolean saveByRunId(String runId, List<RunHistory> list){
        return getSelf().saveByRun(new Run().setId(runId),list);
    }

    /**
    * saveByRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByRun(Run run, List<RunHistory> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<RunHistory> fetchView(RunHistorySearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<RunHistory> listView(RunHistorySearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<RunHistory> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            RunHistory et=list.get(i);
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
    default RunHistory getEntity() {
        return new RunHistory();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default RunHistorySearchContext getSearchContext() {
        return new RunHistorySearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}