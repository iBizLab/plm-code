/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.ebsx.domain.AuthLog;
import cn.ibizlab.plm.core.ebsx.filter.AuthLogSearchContext;

/**
 * 认证日志服务接口[AuthLogService]
 *
 * @author generator
 */
public interface AuthLogService {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AuthLogService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    AuthLog get(AuthLog et);
    /**
     * 获取
     * @param key
     * @return
     */
    default AuthLog get(String key) {
        return getById(key);
    }
    default AuthLog getById(String key) {
        return null;
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<AuthLog> getByIds(Collection<String> ids) {
        List<AuthLog> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new AuthLog().setLogId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<AuthLog> getByEntities(List<AuthLog> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    AuthLog getDraft(AuthLog et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(AuthLog et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(AuthLog et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<AuthLog> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(AuthLog et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<AuthLog> list);

    /**
     * 保存
     * @param et
     * @return
     */
    boolean save(AuthLog et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<AuthLog> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new AuthLog().setLogId(key));
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
    boolean remove(AuthLog et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<AuthLog> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new AuthLog().setLogId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<AuthLog> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<AuthLog> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            AuthLog et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getUserName(),ex.getMessage());
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
    Page<AuthLog> searchDefault(AuthLogSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<AuthLog> listDefault(AuthLogSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default AuthLog getEntity() {
        return new AuthLog();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default AuthLogSearchContext getSearchContext() {
        return new AuthLogSearchContext();
    }
}