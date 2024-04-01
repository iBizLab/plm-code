/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.extension.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.extension.domain.SystemExtensionNotifySetting;
import cn.ibizlab.plm.core.extension.filter.SystemExtensionNotifySettingSearchContext;

/**
 * 通知设置服务接口[SystemExtensionNotifySettingService]
 *
 * @author generator
 */
public interface SystemExtensionNotifySettingService {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SystemExtensionNotifySettingService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SystemExtensionNotifySetting get(SystemExtensionNotifySetting et);
    /**
     * 获取
     * @param key
     * @return
     */
    default SystemExtensionNotifySetting get(String key) {
        return getById(key);
    }
    default SystemExtensionNotifySetting getById(String key) {
        return null;
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<SystemExtensionNotifySetting> getByIds(Collection<String> ids) {
        List<SystemExtensionNotifySetting> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SystemExtensionNotifySetting().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<SystemExtensionNotifySetting> getByEntities(List<SystemExtensionNotifySetting> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    SystemExtensionNotifySetting getDraft(SystemExtensionNotifySetting et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(SystemExtensionNotifySetting et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(SystemExtensionNotifySetting et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<SystemExtensionNotifySetting> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(SystemExtensionNotifySetting et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<SystemExtensionNotifySetting> list);

    /**
     * 保存
     * @param et
     * @return
     */
    boolean save(SystemExtensionNotifySetting et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<SystemExtensionNotifySetting> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SystemExtensionNotifySetting().setId(key));
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
    boolean remove(SystemExtensionNotifySetting et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<SystemExtensionNotifySetting> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SystemExtensionNotifySetting().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<SystemExtensionNotifySetting> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<SystemExtensionNotifySetting> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SystemExtensionNotifySetting et=list.get(i);
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
    Page<SystemExtensionNotifySetting> searchDefault(SystemExtensionNotifySettingSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<SystemExtensionNotifySetting> listDefault(SystemExtensionNotifySettingSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default SystemExtensionNotifySetting getEntity() {
        return new SystemExtensionNotifySetting();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default SystemExtensionNotifySettingSearchContext getSearchContext() {
        return new SystemExtensionNotifySettingSearchContext();
    }
}