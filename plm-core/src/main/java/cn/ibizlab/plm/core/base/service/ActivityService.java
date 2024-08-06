/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.Activity;
import cn.ibizlab.plm.core.base.filter.ActivitySearchContext;

/**
 * 活动服务接口[ActivityService]
 *
 * @author generator
 */
public interface ActivityService extends IService<Activity> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ActivityService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Activity et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Activity> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Activity et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Activity> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Activity().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Activity et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Activity> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Activity().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Activity> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Activity get(String key) {
        return getSelf().get(new Activity().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Activity get(Activity et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Activity> get(Collection<String> keys) {
        List<Activity> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Activity().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Activity> get(List<Activity> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Activity getDraft(Activity et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Activity et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Activity et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Activity> list);

    /**
    * getActivityObjDetail
    * 
    * @param et
    * @return
    */
    default Activity getActivityObjDetail(Activity et) {
        return et;
    }

    /**
    * fetchAll
    * 
    * @param context
    * @return
    */
    Page<Activity> fetchAll(ActivitySearchContext context);

    /**
    * listAll
    * 
    * @param context
    * @return
    */
    List<Activity> listAll(ActivitySearchContext context);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Activity> fetchDefault(ActivitySearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Activity> listDefault(ActivitySearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Activity> fetchView(ActivitySearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Activity> listView(ActivitySearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Activity> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Activity et=list.get(i);
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
    default Activity getEntity() {
        return new Activity();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ActivitySearchContext getSearchContext() {
        return new ActivitySearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}