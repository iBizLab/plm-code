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
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext;

/**
 * 动态数据看板服务接口[DynaDashboardService]
 *
 * @author generator
 */
public interface DynaDashboardService extends IService<DynaDashboard> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DynaDashboardService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DynaDashboard get(DynaDashboard et);
    /**
     * 获取
     * @param key
     * @return
     */
    default DynaDashboard get(String key) {
        return getSelf().get(new DynaDashboard().setDynaDashboardId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<DynaDashboard> getByIds(Collection<String> ids) {
        List<DynaDashboard> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new DynaDashboard().setDynaDashboardId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<DynaDashboard> getByEntities(List<DynaDashboard> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    DynaDashboard getDraft(DynaDashboard et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(DynaDashboard et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(DynaDashboard et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<DynaDashboard> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(DynaDashboard et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<DynaDashboard> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(DynaDashboard et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<DynaDashboard> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DynaDashboard().setDynaDashboardId(key));
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
    boolean remove(DynaDashboard et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<DynaDashboard> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new DynaDashboard().setDynaDashboardId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<DynaDashboard> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<DynaDashboard> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DynaDashboard et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getDynaDashboardName(),ex.getMessage());
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
    Page<DynaDashboard> searchDefault(DynaDashboardSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<DynaDashboard> listDefault(DynaDashboardSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default DynaDashboard getEntity() {
        return new DynaDashboard();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default DynaDashboardSearchContext getSearchContext() {
        return new DynaDashboardSearchContext();
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