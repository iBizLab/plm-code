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
import cn.ibizlab.plm.core.base.domain.LocalDepartment;
import cn.ibizlab.plm.core.base.filter.LocalDepartmentSearchContext;
import cn.ibizlab.plm.core.base.domain.LocalUser;

/**
 * 部门服务接口[LocalDepartmentService]
 *
 * @author generator
 */
public interface LocalDepartmentService extends IService<LocalDepartment> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default LocalDepartmentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(LocalDepartment et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<LocalDepartment> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(LocalDepartment et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<LocalDepartment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new LocalDepartment().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(LocalDepartment et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<LocalDepartment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new LocalDepartment().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<LocalDepartment> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default LocalDepartment get(String key) {
        return getSelf().get(new LocalDepartment().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    LocalDepartment get(LocalDepartment et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<LocalDepartment> get(Collection<String> keys) {
        List<LocalDepartment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new LocalDepartment().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<LocalDepartment> get(List<LocalDepartment> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    LocalDepartment getDraft(LocalDepartment et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(LocalDepartment et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(LocalDepartment et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<LocalDepartment> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<LocalDepartment> fetchDefault(LocalDepartmentSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<LocalDepartment> listDefault(LocalDepartmentSearchContext context);

    /**
    * findByParentId
    * @param parentIds
    * @return
    */
    List<LocalDepartment> findByParentId(List<String> parentIds);
    default List<LocalDepartment> findByParentId(String parentId){
        return findByLocalDepartment(new LocalDepartment().setId(parentId));
    }

    /**
    * findByLocalDepartment
    * @param localDepartment
    * @return
    */
    List<LocalDepartment> findByLocalDepartment(LocalDepartment localDepartment);

    /**
    * removeByParentId
    * @param parentId
    * @return
    */
    boolean removeByParentId(String parentId);

    /**
    * resetByParentId
    * @param parentId
    * @return
    */
    boolean resetByParentId(String parentId);

    /**
    * saveByParentId
    * @param parentId
    * @param list
    * @return
    */
    default boolean saveByParentId(String parentId, List<LocalDepartment> list){
        return getSelf().saveByLocalDepartment(new LocalDepartment().setId(parentId),list);
    }

    /**
    * saveByLocalDepartment
    * @param localDepartment
    * @param list
    * @return
    */
    boolean saveByLocalDepartment(LocalDepartment localDepartment, List<LocalDepartment> list);

    /**
    * findByHeadId
    * @param headIds
    * @return
    */
    List<LocalDepartment> findByHeadId(List<String> headIds);
    default List<LocalDepartment> findByHeadId(String headId){
        return findByLocalUser(new LocalUser().setId(headId));
    }

    /**
    * findByLocalUser
    * @param localUser
    * @return
    */
    List<LocalDepartment> findByLocalUser(LocalUser localUser);

    /**
    * removeByHeadId
    * @param headId
    * @return
    */
    boolean removeByHeadId(String headId);

    /**
    * resetByHeadId
    * @param headId
    * @return
    */
    boolean resetByHeadId(String headId);

    /**
    * saveByHeadId
    * @param headId
    * @param list
    * @return
    */
    default boolean saveByHeadId(String headId, List<LocalDepartment> list){
        return getSelf().saveByLocalUser(new LocalUser().setId(headId),list);
    }

    /**
    * saveByLocalUser
    * @param localUser
    * @param list
    * @return
    */
    boolean saveByLocalUser(LocalUser localUser, List<LocalDepartment> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<LocalDepartment> fetchView(LocalDepartmentSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<LocalDepartment> listView(LocalDepartmentSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<LocalDepartment> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            LocalDepartment et=list.get(i);
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
    default LocalDepartment getEntity() {
        return new LocalDepartment();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default LocalDepartmentSearchContext getSearchContext() {
        return new LocalDepartmentSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}