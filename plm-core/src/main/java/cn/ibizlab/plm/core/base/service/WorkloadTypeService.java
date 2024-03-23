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
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.core.base.filter.WorkloadTypeSearchContext;
import cn.ibizlab.plm.core.base.domain.Workload;

/**
 * 工时类别服务接口[WorkloadTypeService]
 *
 * @author generator
 */
public interface WorkloadTypeService extends IService<WorkloadType> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default WorkloadTypeService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    WorkloadType get(WorkloadType et);
    /**
     * 获取
     * @param key
     * @return
     */
    default WorkloadType get(String key) {
        return getSelf().get(new WorkloadType().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<WorkloadType> getByIds(Collection<String> ids) {
        List<WorkloadType> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new WorkloadType().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<WorkloadType> getByEntities(List<WorkloadType> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    WorkloadType getDraft(WorkloadType et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(WorkloadType et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(WorkloadType et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<WorkloadType> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(WorkloadType et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<WorkloadType> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(WorkloadType et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<WorkloadType> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new WorkloadType().setId(key));
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
    boolean remove(WorkloadType et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<WorkloadType> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new WorkloadType().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<WorkloadType> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<WorkloadType> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            WorkloadType et=list.get(i);
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
    Page<WorkloadType> searchDefault(WorkloadTypeSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<WorkloadType> listDefault(WorkloadTypeSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default WorkloadType getEntity() {
        return new WorkloadType();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default WorkloadTypeSearchContext getSearchContext() {
        return new WorkloadTypeSearchContext();
    }

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