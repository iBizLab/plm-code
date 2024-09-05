/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.insight.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.insight.filter.InsightViewSearchContext;
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.core.insight.domain.InsightReport;
import cn.ibizlab.plm.core.base.domain.DynaDashboard;

/**
 * 效能视图服务接口[InsightViewService]
 *
 * @author generator
 */
public interface InsightViewService extends IService<InsightView> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default InsightViewService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(InsightView et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<InsightView> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default InsightView createTemp(InsightView et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default InsightView createTempMajor(InsightView et) {
        return et;
    }

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(InsightView et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<InsightView> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default InsightView updateTemp(InsightView et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default InsightView updateTempMajor(InsightView et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new InsightView().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(InsightView et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<InsightView> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new InsightView().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<InsightView> entities);

    /**
    * removeTemp
    * 
    * @param keys
    * @return
    */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
    * removeTempMajor
    * 
    * @param keys
    * @return
    */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
    * 获取
    * @param key
    * @return
    */
    default InsightView get(String key) {
        return getSelf().get(new InsightView().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    InsightView get(InsightView et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<InsightView> get(Collection<String> keys) {
        List<InsightView> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new InsightView().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<InsightView> get(List<InsightView> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default InsightView getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default InsightView getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    InsightView getDraft(InsightView et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default InsightView getDraftTemp(InsightView et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default InsightView getDraftTempMajor(InsightView et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(InsightView et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(InsightView et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<InsightView> list);

    /**
    * changeAdminRole
    * 
    * @param et
    * @return
    */
    default InsightView changeAdminRole(InsightView et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default InsightView delete(InsightView et) {
        return et;
    }

    /**
    * favorite
    * 
    * @param et
    * @return
    */
    default InsightView favorite(InsightView et) {
        return et;
    }

    /**
    * fillBiFormDefault
    * 
    * @param et
    * @return
    */
    default InsightView fillBiFormDefault(InsightView et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default InsightView nothing(InsightView et) {
        return et;
    }

    /**
    * recognizeChooseTemplate
    * 
    * @param et
    * @return
    */
    default InsightView recognizeChooseTemplate(InsightView et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default InsightView recover(InsightView et) {
        return et;
    }

    /**
    * unFavorite
    * 
    * @param et
    * @return
    */
    default InsightView unFavorite(InsightView et) {
        return et;
    }

    /**
    * useCurTemplate
    * 
    * @param et
    * @return
    */
    default InsightView useCurTemplate(InsightView et) {
        return et;
    }

    /**
    * viewMove
    * 
    * @param et
    * @return
    */
    default InsightView viewMove(InsightView et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<InsightView> fetchDefault(InsightViewSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<InsightView> listDefault(InsightViewSearchContext context);

    /**
    * fetchAdmin
    * 
    * @param context
    * @return
    */
    Page<InsightView> fetchAdmin(InsightViewSearchContext context);

    /**
    * listAdmin
    * 
    * @param context
    * @return
    */
    List<InsightView> listAdmin(InsightViewSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<InsightView> fetchDeleted(InsightViewSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<InsightView> listDeleted(InsightViewSearchContext context);

    /**
    * fetchFavorite
    * 
    * @param context
    * @return
    */
    Page<InsightView> fetchFavorite(InsightViewSearchContext context);

    /**
    * listFavorite
    * 
    * @param context
    * @return
    */
    List<InsightView> listFavorite(InsightViewSearchContext context);

    /**
    * fetchMain
    * 
    * @param context
    * @return
    */
    Page<InsightView> fetchMain(InsightViewSearchContext context);

    /**
    * listMain
    * 
    * @param context
    * @return
    */
    List<InsightView> listMain(InsightViewSearchContext context);

    /**
    * fetchNormal
    * 正常状态
    * @param context
    * @return
    */
    Page<InsightView> fetchNormal(InsightViewSearchContext context);

    /**
    * listNormal
    * 正常状态
    * @param context
    * @return
    */
    List<InsightView> listNormal(InsightViewSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<InsightView> fetchReader(InsightViewSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<InsightView> listReader(InsightViewSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<InsightView> fetchUser(InsightViewSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<InsightView> listUser(InsightViewSearchContext context);

    default List<InsightMember> getMembers(InsightView et) {
        return new ArrayList<>();
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<InsightView> fetchView(InsightViewSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<InsightView> listView(InsightViewSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<InsightView> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            InsightView et=list.get(i);
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
    default InsightView getEntity() {
        return new InsightView();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default InsightViewSearchContext getSearchContext() {
        return new InsightViewSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}