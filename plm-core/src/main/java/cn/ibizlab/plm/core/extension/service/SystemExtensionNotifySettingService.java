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
public interface SystemExtensionNotifySettingService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default SystemExtensionNotifySettingService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

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
    boolean create(List<SystemExtensionNotifySetting> list);

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
    boolean update(List<SystemExtensionNotifySetting> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SystemExtensionNotifySetting().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SystemExtensionNotifySetting et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SystemExtensionNotifySetting> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SystemExtensionNotifySetting().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SystemExtensionNotifySetting> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SystemExtensionNotifySetting get(String key) {
        return getSelf().get(new SystemExtensionNotifySetting().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SystemExtensionNotifySetting get(SystemExtensionNotifySetting et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SystemExtensionNotifySetting> get(Collection<String> keys) {
        List<SystemExtensionNotifySetting> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SystemExtensionNotifySetting().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SystemExtensionNotifySetting> get(List<SystemExtensionNotifySetting> entities);

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
    boolean save(List<SystemExtensionNotifySetting> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SystemExtensionNotifySetting> fetchDefault(SystemExtensionNotifySettingSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SystemExtensionNotifySetting> listDefault(SystemExtensionNotifySettingSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<SystemExtensionNotifySetting> fetchView(SystemExtensionNotifySettingSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<SystemExtensionNotifySetting> listView(SystemExtensionNotifySettingSearchContext context);


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