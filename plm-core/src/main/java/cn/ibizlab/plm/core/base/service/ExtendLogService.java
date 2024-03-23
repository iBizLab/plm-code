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
import cn.ibizlab.plm.core.base.domain.ExtendLog;
import cn.ibizlab.plm.core.base.filter.ExtendLogSearchContext;

/**
 * 扩展日志服务接口[ExtendLogService]
 *
 * @author generator
 */
public interface ExtendLogService extends IService<ExtendLog> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ExtendLogService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ExtendLog get(ExtendLog et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ExtendLog get(String key) {
        return getSelf().get(new ExtendLog().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ExtendLog> getByIds(Collection<String> ids) {
        List<ExtendLog> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ExtendLog().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ExtendLog> getByEntities(List<ExtendLog> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    ExtendLog getDraft(ExtendLog et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(ExtendLog et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(ExtendLog et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<ExtendLog> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(ExtendLog et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<ExtendLog> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ExtendLog et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ExtendLog> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ExtendLog().setId(key));
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
    boolean remove(ExtendLog et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ExtendLog> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ExtendLog().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ExtendLog> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<ExtendLog> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ExtendLog et=list.get(i);
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
    Page<ExtendLog> searchDefault(ExtendLogSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ExtendLog> listDefault(ExtendLogSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default ExtendLog getEntity() {
        return new ExtendLog();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ExtendLogSearchContext getSearchContext() {
        return new ExtendLogSearchContext();
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