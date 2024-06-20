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
import cn.ibizlab.plm.core.insight.domain.InsightReport;
import cn.ibizlab.plm.core.insight.filter.InsightReportSearchContext;
import cn.ibizlab.plm.core.insight.domain.InsightView;

/**
 * 效能报表服务接口[InsightReportService]
 *
 * @author generator
 */
public interface InsightReportService extends IService<InsightReport> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default InsightReportService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(InsightReport et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<InsightReport> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(InsightReport et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<InsightReport> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new InsightReport().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(InsightReport et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<InsightReport> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new InsightReport().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<InsightReport> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default InsightReport get(String key) {
        return getSelf().get(new InsightReport().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    InsightReport get(InsightReport et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<InsightReport> get(Collection<String> keys) {
        List<InsightReport> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new InsightReport().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<InsightReport> get(List<InsightReport> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    InsightReport getDraft(InsightReport et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(InsightReport et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(InsightReport et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<InsightReport> list);

    /**
    * deleteCategories
    * 
    * @param et
    * @return
    */
    default InsightReport deleteCategories(InsightReport et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<InsightReport> fetchDefault(InsightReportSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<InsightReport> listDefault(InsightReportSearchContext context);

    /**
    * findByViewId
    * @param viewIds
    * @return
    */
    List<InsightReport> findByViewId(List<String> viewIds);
    default List<InsightReport> findByViewId(String viewId){
        return findByViewId(Arrays.asList(viewId));
    }

    /**
    * removeByViewId
    * @param viewId
    * @return
    */
    boolean removeByViewId(String viewId);

    /**
    * resetByViewId
    * @param viewId
    * @return
    */
    boolean resetByViewId(String viewId);

    /**
    * saveByViewId
    * @param viewId
    * @param list
    * @return
    */
    default boolean saveByViewId(String viewId, List<InsightReport> list){
        return getSelf().saveByInsightView(new InsightView().setId(viewId),list);
    }

    /**
    * saveByInsightView
    * @param insightView
    * @param list
    * @return
    */
    boolean saveByInsightView(InsightView insightView, List<InsightReport> list);


    default ImportResult importData(String config, Boolean ignoreError, List<InsightReport> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            InsightReport et=list.get(i);
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
    default InsightReport getEntity() {
        return new InsightReport();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default InsightReportSearchContext getSearchContext() {
        return new InsightReportSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}