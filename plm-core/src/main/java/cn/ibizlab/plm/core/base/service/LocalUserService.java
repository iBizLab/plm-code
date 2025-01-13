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
import cn.ibizlab.plm.core.base.domain.LocalUser;
import cn.ibizlab.plm.core.base.filter.LocalUserSearchContext;
import cn.ibizlab.plm.core.base.domain.LocalDepartment;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 企业用户服务接口[LocalUserService]
 *
 * @author generator
 */
public interface LocalUserService extends IService<LocalUser> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default LocalUserService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(LocalUser et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<LocalUser> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(LocalUser et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<LocalUser> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new LocalUser().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(LocalUser et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<LocalUser> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new LocalUser().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<LocalUser> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default LocalUser get(String key) {
        return getSelf().get(new LocalUser().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    LocalUser get(LocalUser et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<LocalUser> get(Collection<String> keys) {
        List<LocalUser> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new LocalUser().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<LocalUser> get(List<LocalUser> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    LocalUser getDraft(LocalUser et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(LocalUser et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(LocalUser et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<LocalUser> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<LocalUser> fetchDefault(LocalUserSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<LocalUser> listDefault(LocalUserSearchContext context);

    /**
    * findByDepartmentId
    * @param departmentIds
    * @return
    */
    List<LocalUser> findByDepartmentId(List<String> departmentIds);
    default List<LocalUser> findByDepartmentId(String departmentId){
        return findByLocalDepartment(new LocalDepartment().setId(departmentId));
    }

    /**
    * findByLocalDepartment
    * @param localDepartment
    * @return
    */
    List<LocalUser> findByLocalDepartment(LocalDepartment localDepartment);

    /**
    * removeByDepartmentId
    * @param departmentId
    * @return
    */
    boolean removeByDepartmentId(String departmentId);

    /**
    * resetByDepartmentId
    * @param departmentId
    * @return
    */
    boolean resetByDepartmentId(String departmentId);

    /**
    * saveByDepartmentId
    * @param departmentId
    * @param list
    * @return
    */
    default boolean saveByDepartmentId(String departmentId, List<LocalUser> list){
        return getSelf().saveByLocalDepartment(new LocalDepartment().setId(departmentId),list);
    }

    /**
    * saveByLocalDepartment
    * @param localDepartment
    * @param list
    * @return
    */
    boolean saveByLocalDepartment(LocalDepartment localDepartment, List<LocalUser> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<LocalUser> fetchView(LocalUserSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<LocalUser> listView(LocalUserSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<LocalUser> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            LocalUser et=list.get(i);
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
    default LocalUser getEntity() {
        return new LocalUser();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default LocalUserSearchContext getSearchContext() {
        return new LocalUserSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}