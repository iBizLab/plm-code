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
import cn.ibizlab.plm.core.base.domain.Parameter;
import cn.ibizlab.plm.core.base.filter.ParameterSearchContext;

/**
 * 系统参数服务接口[ParameterService]
 *
 * @author generator
 */
public interface ParameterService extends IService<Parameter> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ParameterService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Parameter et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Parameter> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Parameter et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Parameter> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Parameter().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Parameter et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Parameter> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Parameter().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Parameter> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Parameter get(String key) {
        return getSelf().get(new Parameter().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Parameter get(Parameter et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Parameter> get(Collection<String> keys) {
        List<Parameter> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Parameter().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Parameter> get(List<Parameter> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Parameter getDraft(Parameter et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(Parameter et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Parameter et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Parameter> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Parameter> fetchDefault(ParameterSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Parameter> listDefault(ParameterSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Parameter> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Parameter et=list.get(i);
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
    default Parameter getEntity() {
        return new Parameter();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ParameterSearchContext getSearchContext() {
        return new ParameterSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}