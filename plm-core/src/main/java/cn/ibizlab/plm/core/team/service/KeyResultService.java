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
import cn.ibizlab.plm.core.team.domain.KeyResult;
import cn.ibizlab.plm.core.team.filter.KeyResultSearchContext;
import cn.ibizlab.plm.core.team.domain.Objective;
import cn.ibizlab.plm.core.team.domain.UpdateRecord;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 关键结果服务接口[KeyResultService]
 *
 * @author generator
 */
public interface KeyResultService extends IService<KeyResult> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default KeyResultService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(KeyResult et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<KeyResult> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(KeyResult et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<KeyResult> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new KeyResult().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(KeyResult et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<KeyResult> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new KeyResult().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<KeyResult> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default KeyResult get(String key) {
        return getSelf().get(new KeyResult().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    KeyResult get(KeyResult et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<KeyResult> get(Collection<String> keys) {
        List<KeyResult> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new KeyResult().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<KeyResult> get(List<KeyResult> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    KeyResult getDraft(KeyResult et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(KeyResult et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(KeyResult et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<KeyResult> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<KeyResult> fetchDefault(KeyResultSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<KeyResult> listDefault(KeyResultSearchContext context);

    /**
    * findByObjectiveId
    * @param objectiveIds
    * @return
    */
    List<KeyResult> findByObjectiveId(List<String> objectiveIds);
    default List<KeyResult> findByObjectiveId(String objectiveId){
        return findByObjective(new Objective().setId(objectiveId));
    }

    /**
    * findByObjective
    * @param objective
    * @return
    */
    List<KeyResult> findByObjective(Objective objective);

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
    default boolean saveByObjectiveId(String objectiveId, List<KeyResult> list){
        return getSelf().saveByObjective(new Objective().setId(objectiveId),list);
    }

    /**
    * saveByObjective
    * @param objective
    * @param list
    * @return
    */
    boolean saveByObjective(Objective objective, List<KeyResult> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<KeyResult> fetchView(KeyResultSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<KeyResult> listView(KeyResultSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<KeyResult> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            KeyResult et=list.get(i);
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
    default KeyResult getEntity() {
        return new KeyResult();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default KeyResultSearchContext getSearchContext() {
        return new KeyResultSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}