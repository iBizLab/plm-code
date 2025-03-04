/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysPerson;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysPersonSearchContext;

/**
 * 人员服务接口[SysPersonService]
 *
 * @author generator
 */
public interface SysPersonService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysPersonService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SysPerson et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SysPerson> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SysPerson et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SysPerson> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysPerson().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SysPerson et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SysPerson> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysPerson().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SysPerson> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SysPerson get(String key) {
        return getSelf().get(new SysPerson().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysPerson get(SysPerson et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SysPerson> get(Collection<String> keys) {
        List<SysPerson> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysPerson().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SysPerson> get(List<SysPerson> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SysPerson getDraft(SysPerson et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(SysPerson et);

    /**
    * getSimple
    * 
    * @param key
    * @return
    */
    default SysPerson getSimple(String key) {
        return getSelf().getSimple(new SysPerson().setId(key));
    }

    /**
    * resetPassword
    * 
    * @param et
    * @return
    */
    default SysPerson resetPassword(SysPerson et) {
        return et;
    }

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SysPerson et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SysPerson> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SysPerson> fetchDefault(SysPersonSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SysPerson> listDefault(SysPersonSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<SysPerson> fetchUser(SysPersonSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<SysPerson> listUser(SysPersonSearchContext context);

    /**
    * getSimple
    * 
    * @param et
    * @return
    */
    default SysPerson getSimple(SysPerson et) {
        return et;
    }


    default ImportResult importData(String config, Boolean ignoreError, List<SysPerson> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SysPerson et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getId(),ex.getMessage());
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
    default SysPerson getEntity() {
        return new SysPerson();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SysPersonSearchContext getSearchContext() {
        return new SysPersonSearchContext();
    }

}