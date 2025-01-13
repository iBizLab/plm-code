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
import cn.ibizlab.plm.core.base.domain.AddonApplicationActivity;
import cn.ibizlab.plm.core.base.filter.AddonApplicationActivitySearchContext;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 应用插件活动服务接口[AddonApplicationActivityService]
 *
 * @author generator
 */
public interface AddonApplicationActivityService extends IService<AddonApplicationActivity> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AddonApplicationActivityService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(AddonApplicationActivity et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<AddonApplicationActivity> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(AddonApplicationActivity et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<AddonApplicationActivity> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new AddonApplicationActivity().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(AddonApplicationActivity et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<AddonApplicationActivity> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AddonApplicationActivity().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<AddonApplicationActivity> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default AddonApplicationActivity get(String key) {
        return getSelf().get(new AddonApplicationActivity().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    AddonApplicationActivity get(AddonApplicationActivity et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<AddonApplicationActivity> get(Collection<String> keys) {
        List<AddonApplicationActivity> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AddonApplicationActivity().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<AddonApplicationActivity> get(List<AddonApplicationActivity> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    AddonApplicationActivity getDraft(AddonApplicationActivity et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(AddonApplicationActivity et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(AddonApplicationActivity et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<AddonApplicationActivity> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<AddonApplicationActivity> fetchDefault(AddonApplicationActivitySearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<AddonApplicationActivity> listDefault(AddonApplicationActivitySearchContext context);

    /**
    * findByPid
    * @param pids
    * @return
    */
    List<AddonApplicationActivity> findByPid(List<String> pids);
    default List<AddonApplicationActivity> findByPid(String pid){
        return findByAddonApplicationActivity(new AddonApplicationActivity().setId(pid));
    }

    /**
    * findByAddonApplicationActivity
    * @param addonApplicationActivity
    * @return
    */
    List<AddonApplicationActivity> findByAddonApplicationActivity(AddonApplicationActivity addonApplicationActivity);

    /**
    * removeByPid
    * @param pid
    * @return
    */
    boolean removeByPid(String pid);

    /**
    * resetByPid
    * @param pid
    * @return
    */
    boolean resetByPid(String pid);

    /**
    * saveByPid
    * @param pid
    * @param list
    * @return
    */
    default boolean saveByPid(String pid, List<AddonApplicationActivity> list){
        return getSelf().saveByAddonApplicationActivity(new AddonApplicationActivity().setId(pid),list);
    }

    /**
    * saveByAddonApplicationActivity
    * @param addonApplicationActivity
    * @param list
    * @return
    */
    boolean saveByAddonApplicationActivity(AddonApplicationActivity addonApplicationActivity, List<AddonApplicationActivity> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<AddonApplicationActivity> fetchView(AddonApplicationActivitySearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<AddonApplicationActivity> listView(AddonApplicationActivitySearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<AddonApplicationActivity> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            AddonApplicationActivity et=list.get(i);
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
    default AddonApplicationActivity getEntity() {
        return new AddonApplicationActivity();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default AddonApplicationActivitySearchContext getSearchContext() {
        return new AddonApplicationActivitySearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}