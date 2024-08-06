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
import cn.ibizlab.plm.core.base.domain.Insight;
import cn.ibizlab.plm.core.base.filter.InsightSearchContext;

/**
 * 洞察力服务接口[InsightService]
 *
 * @author generator
 */
public interface InsightService extends IService<Insight> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default InsightService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Insight et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Insight> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Insight et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Insight> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Insight().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Insight et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Insight> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Insight().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Insight> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Insight get(String key) {
        return getSelf().get(new Insight().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Insight get(Insight et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Insight> get(Collection<String> keys) {
        List<Insight> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Insight().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Insight> get(List<Insight> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Insight getDraft(Insight et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Insight et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Insight et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Insight> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Insight> fetchDefault(InsightSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Insight> listDefault(InsightSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Insight> fetchView(InsightSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Insight> listView(InsightSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Insight> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Insight et=list.get(i);
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
    default Insight getEntity() {
        return new Insight();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default InsightSearchContext getSearchContext() {
        return new InsightSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}