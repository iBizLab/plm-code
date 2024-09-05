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
import cn.ibizlab.plm.core.base.domain.DataSyncTask;
import cn.ibizlab.plm.core.base.filter.DataSyncTaskSearchContext;

/**
 * 数据同步任务服务接口[DataSyncTaskService]
 *
 * @author generator
 */
public interface DataSyncTaskService extends IService<DataSyncTask> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DataSyncTaskService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(DataSyncTask et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<DataSyncTask> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(DataSyncTask et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<DataSyncTask> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DataSyncTask().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(DataSyncTask et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<DataSyncTask> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DataSyncTask().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<DataSyncTask> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default DataSyncTask get(String key) {
        return getSelf().get(new DataSyncTask().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DataSyncTask get(DataSyncTask et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<DataSyncTask> get(Collection<String> keys) {
        List<DataSyncTask> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DataSyncTask().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<DataSyncTask> get(List<DataSyncTask> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    DataSyncTask getDraft(DataSyncTask et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(DataSyncTask et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(DataSyncTask et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<DataSyncTask> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<DataSyncTask> fetchDefault(DataSyncTaskSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<DataSyncTask> listDefault(DataSyncTaskSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<DataSyncTask> fetchView(DataSyncTaskSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<DataSyncTask> listView(DataSyncTaskSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<DataSyncTask> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DataSyncTask et=list.get(i);
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
    default DataSyncTask getEntity() {
        return new DataSyncTask();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DataSyncTaskSearchContext getSearchContext() {
        return new DataSyncTaskSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}