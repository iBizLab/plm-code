/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.base.domain.ExtendStorage;
import cn.ibizlab.plm.core.base.filter.ExtendStorageSearchContext;

/**
 * 扩展存储服务接口[ExtendStorageService]
 *
 * @author generator
 */
public interface ExtendStorageService extends IService<ExtendStorage> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ExtendStorageService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ExtendStorage get(ExtendStorage et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ExtendStorage get(String key) {
        return getSelf().get(new ExtendStorage().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ExtendStorage> getByIds(Collection<String> ids) {
        List<ExtendStorage> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ExtendStorage().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ExtendStorage> getByEntities(List<ExtendStorage> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    ExtendStorage getDraft(ExtendStorage et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(ExtendStorage et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(ExtendStorage et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<ExtendStorage> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(ExtendStorage et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<ExtendStorage> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ExtendStorage et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ExtendStorage> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ExtendStorage().setId(key));
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
    boolean remove(ExtendStorage et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ExtendStorage> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ExtendStorage().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ExtendStorage> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<ExtendStorage> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ExtendStorage et=list.get(i);
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
    Page<ExtendStorage> searchDefault(ExtendStorageSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ExtendStorage> listDefault(ExtendStorageSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default ExtendStorage getEntity() {
        return new ExtendStorage();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ExtendStorageSearchContext getSearchContext() {
        return new ExtendStorageSearchContext();
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