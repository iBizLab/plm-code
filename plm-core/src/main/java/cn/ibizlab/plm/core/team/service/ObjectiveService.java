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
import cn.ibizlab.plm.core.team.domain.Objective;
import cn.ibizlab.plm.core.team.filter.ObjectiveSearchContext;
import cn.ibizlab.plm.core.team.domain.Period;
import cn.ibizlab.plm.core.team.domain.KeyResult;
import cn.ibizlab.plm.core.team.domain.UpdateRecord;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 目标服务接口[ObjectiveService]
 *
 * @author generator
 */
public interface ObjectiveService extends IService<Objective> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ObjectiveService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Objective et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Objective> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Objective et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Objective> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Objective().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Objective et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Objective> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Objective().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Objective> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Objective get(String key) {
        return getSelf().get(new Objective().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Objective get(Objective et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Objective> get(Collection<String> keys) {
        List<Objective> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Objective().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Objective> get(List<Objective> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Objective getDraft(Objective et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Objective et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Objective et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Objective> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Objective> fetchDefault(ObjectiveSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Objective> listDefault(ObjectiveSearchContext context);

    /**
    * findByPeriodId
    * @param periodIds
    * @return
    */
    List<Objective> findByPeriodId(List<String> periodIds);
    default List<Objective> findByPeriodId(String periodId){
        return findByPeriod(new Period().setId(periodId));
    }

    /**
    * findByPeriod
    * @param period
    * @return
    */
    List<Objective> findByPeriod(Period period);

    /**
    * removeByPeriodId
    * @param periodId
    * @return
    */
    boolean removeByPeriodId(String periodId);

    /**
    * resetByPeriodId
    * @param periodId
    * @return
    */
    boolean resetByPeriodId(String periodId);

    /**
    * saveByPeriodId
    * @param periodId
    * @param list
    * @return
    */
    default boolean saveByPeriodId(String periodId, List<Objective> list){
        return getSelf().saveByPeriod(new Period().setId(periodId),list);
    }

    /**
    * saveByPeriod
    * @param period
    * @param list
    * @return
    */
    boolean saveByPeriod(Period period, List<Objective> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Objective> fetchView(ObjectiveSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Objective> listView(ObjectiveSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Objective> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Objective et=list.get(i);
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
    default Objective getEntity() {
        return new Objective();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ObjectiveSearchContext getSearchContext() {
        return new ObjectiveSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}