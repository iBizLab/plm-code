/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.team.domain.UpdateRecord;
import cn.ibizlab.plm.core.team.filter.UpdateRecordSearchContext;
import cn.ibizlab.plm.core.team.domain.KeyResult;
import cn.ibizlab.plm.core.team.domain.Objective;

/**
 * 进展服务接口[UpdateRecordService]
 *
 * @author generator
 */
public interface UpdateRecordService extends IService<UpdateRecord> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default UpdateRecordService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(UpdateRecord et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<UpdateRecord> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(UpdateRecord et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<UpdateRecord> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new UpdateRecord().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(UpdateRecord et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<UpdateRecord> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new UpdateRecord().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<UpdateRecord> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default UpdateRecord get(String key) {
        return getSelf().get(new UpdateRecord().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    UpdateRecord get(UpdateRecord et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<UpdateRecord> get(Collection<String> keys) {
        List<UpdateRecord> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new UpdateRecord().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<UpdateRecord> get(List<UpdateRecord> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    UpdateRecord getDraft(UpdateRecord et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(UpdateRecord et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(UpdateRecord et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<UpdateRecord> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<UpdateRecord> fetchDefault(UpdateRecordSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<UpdateRecord> listDefault(UpdateRecordSearchContext context);

    /**
    * findByKeyResultId
    * @param keyResultIds
    * @return
    */
    List<UpdateRecord> findByKeyResultId(List<String> keyResultIds);
    default List<UpdateRecord> findByKeyResultId(String keyResultId){
        return findByKeyResult(new KeyResult().setId(keyResultId));
    }

    /**
    * findByKeyResult
    * @param keyResult
    * @return
    */
    List<UpdateRecord> findByKeyResult(KeyResult keyResult);

    /**
    * removeByKeyResultId
    * @param keyResultId
    * @return
    */
    boolean removeByKeyResultId(String keyResultId);

    /**
    * resetByKeyResultId
    * @param keyResultId
    * @return
    */
    boolean resetByKeyResultId(String keyResultId);

    /**
    * saveByKeyResultId
    * @param keyResultId
    * @param list
    * @return
    */
    default boolean saveByKeyResultId(String keyResultId, List<UpdateRecord> list){
        return getSelf().saveByKeyResult(new KeyResult().setId(keyResultId),list);
    }

    /**
    * saveByKeyResult
    * @param keyResult
    * @param list
    * @return
    */
    boolean saveByKeyResult(KeyResult keyResult, List<UpdateRecord> list);

    /**
    * findByObjectiveId
    * @param objectiveIds
    * @return
    */
    List<UpdateRecord> findByObjectiveId(List<String> objectiveIds);
    default List<UpdateRecord> findByObjectiveId(String objectiveId){
        return findByObjective(new Objective().setId(objectiveId));
    }

    /**
    * findByObjective
    * @param objective
    * @return
    */
    List<UpdateRecord> findByObjective(Objective objective);

    /**
    * removeByObjectiveId
    * @param objectiveId
    * @return
    */
    boolean removeByObjectiveId(String objectiveId);

    /**
    * resetByObjectiveId
    * @param objectiveId
    * @return
    */
    boolean resetByObjectiveId(String objectiveId);

    /**
    * saveByObjectiveId
    * @param objectiveId
    * @param list
    * @return
    */
    default boolean saveByObjectiveId(String objectiveId, List<UpdateRecord> list){
        return getSelf().saveByObjective(new Objective().setId(objectiveId),list);
    }

    /**
    * saveByObjective
    * @param objective
    * @param list
    * @return
    */
    boolean saveByObjective(Objective objective, List<UpdateRecord> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<UpdateRecord> fetchView(UpdateRecordSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<UpdateRecord> listView(UpdateRecordSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<UpdateRecord> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            UpdateRecord et=list.get(i);
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
    default UpdateRecord getEntity() {
        return new UpdateRecord();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default UpdateRecordSearchContext getSearchContext() {
        return new UpdateRecordSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}