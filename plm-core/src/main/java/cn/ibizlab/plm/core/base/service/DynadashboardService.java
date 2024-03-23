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
import cn.ibizlab.plm.core.base.domain.Dynadashboard;
import cn.ibizlab.plm.core.base.filter.DynadashboardSearchContext;

/**
 * 动态数据看板服务接口[DynadashboardService]
 *
 * @author generator
 */
public interface DynadashboardService extends IService<Dynadashboard> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DynadashboardService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Dynadashboard get(Dynadashboard et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Dynadashboard get(String key) {
        return getSelf().get(new Dynadashboard().setDynaDashboardId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Dynadashboard> getByIds(Collection<String> ids) {
        List<Dynadashboard> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Dynadashboard().setDynaDashboardId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Dynadashboard> getByEntities(List<Dynadashboard> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Dynadashboard getDraft(Dynadashboard et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Dynadashboard et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Dynadashboard et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Dynadashboard> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Dynadashboard et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Dynadashboard> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Dynadashboard et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Dynadashboard> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Dynadashboard().setDynaDashboardId(key));
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
    boolean remove(Dynadashboard et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Dynadashboard> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Dynadashboard().setDynaDashboardId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Dynadashboard> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Dynadashboard> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Dynadashboard et=list.get(i);
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
    Page<Dynadashboard> searchDefault(DynadashboardSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Dynadashboard> listDefault(DynadashboardSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Dynadashboard getEntity() {
        return new Dynadashboard();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default DynadashboardSearchContext getSearchContext() {
        return new DynadashboardSearchContext();
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