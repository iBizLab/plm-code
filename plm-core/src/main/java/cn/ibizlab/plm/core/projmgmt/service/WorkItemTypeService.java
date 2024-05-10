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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemTypeSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 工作项类型服务接口[WorkItemTypeService]
 *
 * @author generator
 */
public interface WorkItemTypeService extends IService<WorkItemType> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default WorkItemTypeService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    WorkItemType get(WorkItemType et);
    /**
     * 获取
     * @param key
     * @return
     */
    default WorkItemType get(String key) {
        return getSelf().get(new WorkItemType().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<WorkItemType> getByIds(Collection<String> ids) {
        List<WorkItemType> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new WorkItemType().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<WorkItemType> getByEntities(List<WorkItemType> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    WorkItemType getDraft(WorkItemType et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(WorkItemType et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(WorkItemType et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<WorkItemType> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(WorkItemType et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<WorkItemType> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(WorkItemType et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<WorkItemType> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new WorkItemType().setId(key));
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
    boolean remove(WorkItemType et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<WorkItemType> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new WorkItemType().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<WorkItemType> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<WorkItemType> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            WorkItemType et=list.get(i);
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
     * nothing
     * 
     * @param dto
     * @return
     */
    default WorkItemType nothing(WorkItemType dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<WorkItemType> searchDefault(WorkItemTypeSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<WorkItemType> listDefault(WorkItemTypeSearchContext context);

    /**
     * searchproject_work_item_type
     * 
     * @param context
     * @return
     */
    Page<WorkItemType> searchProjectWorkItemType(WorkItemTypeSearchContext context);
    /**
     * listproject_work_item_type
     * 
     * @param context
     * @return
     */
    List<WorkItemType> listProjectWorkItemType(WorkItemTypeSearchContext context);

    /**
     * searchproject_work_item_type_not_bug
     * 
     * @param context
     * @return
     */
    Page<WorkItemType> searchProjectWorkItemTypeNotBug(WorkItemTypeSearchContext context);
    /**
     * listproject_work_item_type_not_bug
     * 
     * @param context
     * @return
     */
    List<WorkItemType> listProjectWorkItemTypeNotBug(WorkItemTypeSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default WorkItemType getEntity() {
        return new WorkItemType();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default WorkItemTypeSearchContext getSearchContext() {
        return new WorkItemTypeSearchContext();
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