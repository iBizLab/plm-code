/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.dynamic.datasource.annotation.DS;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.ebsx.domain.AppViewTheme;
import cn.ibizlab.plm.core.ebsx.filter.AppViewThemeSearchContext;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 应用视图主题服务接口[AppViewThemeService]
 *
 * @author generator
 */
@DS("db2")
public interface AppViewThemeService extends IService<AppViewTheme> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AppViewThemeService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(AppViewTheme et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<AppViewTheme> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(AppViewTheme et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<AppViewTheme> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new AppViewTheme().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(AppViewTheme et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<AppViewTheme> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AppViewTheme().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<AppViewTheme> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default AppViewTheme get(String key) {
        return getSelf().get(new AppViewTheme().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    AppViewTheme get(AppViewTheme et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<AppViewTheme> get(Collection<String> keys) {
        List<AppViewTheme> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AppViewTheme().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<AppViewTheme> get(List<AppViewTheme> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    AppViewTheme getDraft(AppViewTheme et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(AppViewTheme et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(AppViewTheme et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<AppViewTheme> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<AppViewTheme> fetchDefault(AppViewThemeSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<AppViewTheme> listDefault(AppViewThemeSearchContext context);

    /**
    * fetchCurSystem
    * 
    * @param context
    * @return
    */
    Page<AppViewTheme> fetchCurSystem(AppViewThemeSearchContext context);

    /**
    * listCurSystem
    * 
    * @param context
    * @return
    */
    List<AppViewTheme> listCurSystem(AppViewThemeSearchContext context);

    /**
    * fetchCurSystemAll
    * 
    * @param context
    * @return
    */
    Page<AppViewTheme> fetchCurSystemAll(AppViewThemeSearchContext context);

    /**
    * listCurSystemAll
    * 
    * @param context
    * @return
    */
    List<AppViewTheme> listCurSystemAll(AppViewThemeSearchContext context);

    /**
    * fetchCurUser
    * 
    * @param context
    * @return
    */
    Page<AppViewTheme> fetchCurUser(AppViewThemeSearchContext context);

    /**
    * listCurUser
    * 
    * @param context
    * @return
    */
    List<AppViewTheme> listCurUser(AppViewThemeSearchContext context);

    /**
    * fetchCurUserAll
    * 
    * @param context
    * @return
    */
    Page<AppViewTheme> fetchCurUserAll(AppViewThemeSearchContext context);

    /**
    * listCurUserAll
    * 
    * @param context
    * @return
    */
    List<AppViewTheme> listCurUserAll(AppViewThemeSearchContext context);

    /**
    * fetchPsmodelSync
    * 用于定义实体数据关系界面组同步的数据
    * @param context
    * @return
    */
    Page<AppViewTheme> fetchPsmodelSync(AppViewThemeSearchContext context);

    /**
    * listPsmodelSync
    * 用于定义实体数据关系界面组同步的数据
    * @param context
    * @return
    */
    List<AppViewTheme> listPsmodelSync(AppViewThemeSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<AppViewTheme> fetchView(AppViewThemeSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<AppViewTheme> listView(AppViewThemeSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<AppViewTheme> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            AppViewTheme et=list.get(i);
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
    default AppViewTheme getEntity() {
        return new AppViewTheme();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default AppViewThemeSearchContext getSearchContext() {
        return new AppViewThemeSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}