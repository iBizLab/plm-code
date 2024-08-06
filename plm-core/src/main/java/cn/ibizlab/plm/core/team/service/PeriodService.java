/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.team.domain.Period;
import cn.ibizlab.plm.core.team.filter.PeriodSearchContext;
import cn.ibizlab.plm.core.team.domain.Objective;

/**
 * 周期服务接口[PeriodService]
 *
 * @author generator
 */
public interface PeriodService extends IService<Period> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default PeriodService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Period et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Period> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Period et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Period> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Period().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Period et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Period> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Period().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Period> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Period get(String key) {
        return getSelf().get(new Period().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Period get(Period et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Period> get(Collection<String> keys) {
        List<Period> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Period().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Period> get(List<Period> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Period getDraft(Period et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Period et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Period et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Period> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Period> fetchDefault(PeriodSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Period> listDefault(PeriodSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Period> fetchView(PeriodSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Period> listView(PeriodSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Period> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Period et=list.get(i);
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
    default Period getEntity() {
        return new Period();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default PeriodSearchContext getSearchContext() {
        return new PeriodSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}