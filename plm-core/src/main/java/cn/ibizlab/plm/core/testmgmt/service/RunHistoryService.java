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
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.filter.RunHistorySearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.Step;

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
     * 获取
     * @param et
     * @return
     */
    RunHistory get(RunHistory et);
    /**
     * 获取
     * @param key
     * @return
     */
    default RunHistory get(String key) {
        return getSelf().get(new RunHistory().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<RunHistory> getByIds(Collection<String> ids) {
        List<RunHistory> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new RunHistory().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<RunHistory> getByEntities(List<RunHistory> entities);

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
    Integer checkKey(RunHistory et);

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
    boolean createBatch(List<RunHistory> list);

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
    boolean updateBatch(List<RunHistory> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(RunHistory et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<RunHistory> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new RunHistory().setId(key));
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
    boolean remove(RunHistory et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<RunHistory> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new RunHistory().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<RunHistory> entities);

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
     * run_history_get
     * 
     * @param dto
     * @return
     */
    default RunHistory runHistoryGet(RunHistory dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<RunHistory> searchDefault(RunHistorySearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<RunHistory> listDefault(RunHistorySearchContext context);

    /**
     * searchthis
     * 
     * @param context
     * @return
     */
    Page<RunHistory> searchThis(RunHistorySearchContext context);
    /**
     * listthis
     * 
     * @param context
     * @return
     */
    List<RunHistory> listThis(RunHistorySearchContext context);

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
     * selectRelByRunId
     * @param runIds
     * @return
     */
    List<RunHistory> findByRunId(List<String> runIds);
    default List<RunHistory> findByRunId(String runId) {
        return findByRunId(Arrays.asList(runId));
    }
    /**
     * removeRelByRunId
     * @param runId
     * @return
     */
    boolean removeByRunId(String runId);
    /**
     * resetRelByRunId
     * @param runId
     * @return
     */
    boolean resetByRunId(String runId);
    /**
     * saveRelByRunId
     * @param runId
     * @param list
     * @return
     */
    default boolean saveByRunId(String runId,List<RunHistory> list) {
        return getSelf().saveByRun(new Run().setId(runId),list);
    }
    /**
    * saveRelByRun
    * @param run
    * @param list
    * @return
    */
    boolean saveByRun(Run run,List<RunHistory> list);


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