/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.ebsx.domain.SysEmployee;
import cn.ibizlab.plm.core.ebsx.filter.SysEmployeeSearchContext;

/**
 * 人员服务接口[SysEmployeeService]
 *
 * @author generator
 */
public interface SysEmployeeService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysEmployeeService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SysEmployee et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SysEmployee> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SysEmployee et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SysEmployee> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysEmployee().setUserId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SysEmployee et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SysEmployee> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysEmployee().setUserId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SysEmployee> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SysEmployee get(String key) {
        return getSelf().get(new SysEmployee().setUserId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysEmployee get(SysEmployee et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SysEmployee> get(Collection<String> keys) {
        List<SysEmployee> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysEmployee().setUserId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SysEmployee> get(List<SysEmployee> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SysEmployee getDraft(SysEmployee et);

    /**
    * changePwd
    * 
    * @param et
    * @return
    */
    default SysEmployee changePwd(SysEmployee et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(SysEmployee et);

    /**
    * initPwd
    * 
    * @param et
    * @return
    */
    default SysEmployee initPwd(SysEmployee et) {
        return et;
    }

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SysEmployee et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SysEmployee> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SysEmployee> fetchDefault(SysEmployeeSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SysEmployee> listDefault(SysEmployeeSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<SysEmployee> fetchUser(SysEmployeeSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<SysEmployee> listUser(SysEmployeeSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<SysEmployee> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SysEmployee et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getPersonName(),ex.getMessage());
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
    default SysEmployee getEntity() {
        return new SysEmployee();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SysEmployeeSearchContext getSearchContext() {
        return new SysEmployeeSearchContext();
    }

}