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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext;
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 动态数据看板服务接口[DynaDashboardService]
 *
 * @author generator
 */
public interface DynaDashboardService extends IService<DynaDashboard> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DynaDashboardService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(DynaDashboard et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<DynaDashboard> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(DynaDashboard et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<DynaDashboard> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DynaDashboard().setDynaDashboardId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(DynaDashboard et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<DynaDashboard> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DynaDashboard().setDynaDashboardId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<DynaDashboard> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default DynaDashboard get(String key) {
        return getSelf().get(new DynaDashboard().setDynaDashboardId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DynaDashboard get(DynaDashboard et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<DynaDashboard> get(Collection<String> keys) {
        List<DynaDashboard> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DynaDashboard().setDynaDashboardId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<DynaDashboard> get(List<DynaDashboard> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    DynaDashboard getDraft(DynaDashboard et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(DynaDashboard et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(DynaDashboard et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<DynaDashboard> list);

    /**
    * fillOtherBoard
    * 
    * @param et
    * @return
    */
    default DynaDashboard fillOtherBoard(DynaDashboard et) {
        return et;
    }

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<DynaDashboard> moveOrder(DynaDashboard et) {
        return new ArrayList<>();
    }

    /**
    * onlyGet
    * 
    * @param key
    * @return
    */
    default DynaDashboard onlyGet(String key) {
        return getSelf().onlyGet(new DynaDashboard().setDynaDashboardId(key));
    }

    /**
    * useCurTemplate
    * 
    * @param et
    * @return
    */
    default DynaDashboard useCurTemplate(DynaDashboard et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<DynaDashboard> fetchDefault(DynaDashboardSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<DynaDashboard> listDefault(DynaDashboardSearchContext context);

    /**
    * fetchExampleChart
    * 
    * @param context
    * @return
    */
    Page<DynaDashboard> fetchExampleChart(DynaDashboardSearchContext context);

    /**
    * listExampleChart
    * 
    * @param context
    * @return
    */
    List<DynaDashboard> listExampleChart(DynaDashboardSearchContext context);

    /**
    * fetchIsSystem
    * 
    * @param context
    * @return
    */
    Page<DynaDashboard> fetchIsSystem(DynaDashboardSearchContext context);

    /**
    * listIsSystem
    * 
    * @param context
    * @return
    */
    List<DynaDashboard> listIsSystem(DynaDashboardSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<DynaDashboard> fetchNormal(DynaDashboardSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<DynaDashboard> listNormal(DynaDashboardSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<DynaDashboard> findByOwnerId(List<String> ownerIds);
    default List<DynaDashboard> findByOwnerId(String ownerId){
        return findByInsightView(new InsightView().setId(ownerId));
    }

    /**
    * findByInsightView
    * @param insightView
    * @return
    */
    List<DynaDashboard> findByInsightView(InsightView insightView);

    /**
    * removeByOwnerId
    * @param ownerId
    * @return
    */
    boolean removeByOwnerId(String ownerId);

    /**
    * resetByOwnerId
    * @param ownerId
    * @return
    */
    boolean resetByOwnerId(String ownerId);

    /**
    * saveByOwnerId
    * @param ownerId
    * @param list
    * @return
    */
    default boolean saveByOwnerId(String ownerId, List<DynaDashboard> list){
        return getSelf().saveByInsightView(new InsightView().setId(ownerId),list);
    }

    /**
    * saveByInsightView
    * @param insightView
    * @param list
    * @return
    */
    boolean saveByInsightView(InsightView insightView, List<DynaDashboard> list);

    /**
    * onlyGet
    * 
    * @param et
    * @return
    */
    default DynaDashboard onlyGet(DynaDashboard et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<DynaDashboard> fetchView(DynaDashboardSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<DynaDashboard> listView(DynaDashboardSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<DynaDashboard> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DynaDashboard et=list.get(i);
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
     * 创建实体对象
     * @return
     */
    default DynaDashboard getEntity() {
        return new DynaDashboard();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DynaDashboardSearchContext getSearchContext() {
        return new DynaDashboardSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}