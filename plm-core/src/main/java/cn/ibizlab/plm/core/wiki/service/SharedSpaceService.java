/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.wiki.domain.SharedSpace;
import cn.ibizlab.plm.core.wiki.filter.SharedSpaceSearchContext;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 共享空间服务接口[SharedSpaceService]
 *
 * @author generator
 */
public interface SharedSpaceService extends IService<SharedSpace> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SharedSpaceService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SharedSpace et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SharedSpace> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SharedSpace et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SharedSpace> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SharedSpace().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SharedSpace et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SharedSpace> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SharedSpace().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SharedSpace> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SharedSpace get(String key) {
        return getSelf().get(new SharedSpace().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SharedSpace get(SharedSpace et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SharedSpace> get(Collection<String> keys) {
        List<SharedSpace> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SharedSpace().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SharedSpace> get(List<SharedSpace> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SharedSpace getDraft(SharedSpace et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(SharedSpace et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SharedSpace et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SharedSpace> list);

    /**
    * checkAccessPassword
    * 
    * @param et
    * @return
    */
    default SharedSpace checkAccessPassword(SharedSpace et) {
        return et;
    }

    /**
    * checkShared
    * 
    * @param key
    * @return
    */
    default SharedSpace checkShared(String key) {
        return getSelf().checkShared(new SharedSpace().setId(key));
    }

    /**
    * closedShared
    * 
    * @param et
    * @return
    */
    default SharedSpace closedShared(SharedSpace et) {
        return et;
    }

    /**
    * sharedSetting
    * 
    * @param et
    * @return
    */
    default SharedSpace sharedSetting(SharedSpace et) {
        return et;
    }

    /**
    * sharedSpaceInfo
    * 
    * @param key
    * @return
    */
    default SharedSpace sharedSpaceInfo(String key) {
        return getSelf().sharedSpaceInfo(new SharedSpace().setId(key));
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SharedSpace> fetchDefault(SharedSpaceSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SharedSpace> listDefault(SharedSpaceSearchContext context);

    /**
    * fetchAdmin
    * 
    * @param context
    * @return
    */
    Page<SharedSpace> fetchAdmin(SharedSpaceSearchContext context);

    /**
    * listAdmin
    * 
    * @param context
    * @return
    */
    List<SharedSpace> listAdmin(SharedSpaceSearchContext context);

    /**
    * fetchShared
    * 
    * @param context
    * @return
    */
    Page<SharedSpace> fetchShared(SharedSpaceSearchContext context);

    /**
    * listShared
    * 
    * @param context
    * @return
    */
    List<SharedSpace> listShared(SharedSpaceSearchContext context);

    /**
    * checkShared
    * 
    * @param et
    * @return
    */
    default SharedSpace checkShared(SharedSpace et) {
        return et;
    }

    /**
    * sharedSpaceInfo
    * 
    * @param et
    * @return
    */
    default SharedSpace sharedSpaceInfo(SharedSpace et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<SharedSpace> fetchView(SharedSpaceSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<SharedSpace> listView(SharedSpaceSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<SharedSpace> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SharedSpace et=list.get(i);
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
    default SharedSpace getEntity() {
        return new SharedSpace();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SharedSpaceSearchContext getSearchContext() {
        return new SharedSpaceSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}