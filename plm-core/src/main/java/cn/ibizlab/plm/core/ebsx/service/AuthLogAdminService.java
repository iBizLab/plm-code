/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.dynamic.datasource.annotation.DS;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.ebsx.domain.AuthLogAdmin;
import cn.ibizlab.plm.core.ebsx.filter.AuthLogAdminSearchContext;

/**
 * 认证日志服务接口[AuthLogAdminService]
 *
 * @author generator
 */
@DS("db2")
public interface AuthLogAdminService extends IService<AuthLogAdmin> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default AuthLogAdminService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(AuthLogAdmin et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<AuthLogAdmin> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(AuthLogAdmin et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<AuthLogAdmin> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new AuthLogAdmin().setLogId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(AuthLogAdmin et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<AuthLogAdmin> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AuthLogAdmin().setLogId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<AuthLogAdmin> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default AuthLogAdmin get(String key) {
        return getSelf().get(new AuthLogAdmin().setLogId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    AuthLogAdmin get(AuthLogAdmin et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<AuthLogAdmin> get(Collection<String> keys) {
        List<AuthLogAdmin> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new AuthLogAdmin().setLogId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<AuthLogAdmin> get(List<AuthLogAdmin> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    AuthLogAdmin getDraft(AuthLogAdmin et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(AuthLogAdmin et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(AuthLogAdmin et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<AuthLogAdmin> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<AuthLogAdmin> fetchDefault(AuthLogAdminSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<AuthLogAdmin> listDefault(AuthLogAdminSearchContext context);

    /**
    * fetchDistinctUserid
    * 
    * @param context
    * @return
    */
    Page<AuthLogAdmin> fetchDistinctUserid(AuthLogAdminSearchContext context);

    /**
    * listDistinctUserid
    * 
    * @param context
    * @return
    */
    List<AuthLogAdmin> listDistinctUserid(AuthLogAdminSearchContext context);

    /**
    * fetchGroupByData
    * 
    * @param context
    * @return
    */
    Page<AuthLogAdmin> fetchGroupByData(AuthLogAdminSearchContext context);

    /**
    * listGroupByData
    * 
    * @param context
    * @return
    */
    List<AuthLogAdmin> listGroupByData(AuthLogAdminSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<AuthLogAdmin> fetchView(AuthLogAdminSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<AuthLogAdmin> listView(AuthLogAdminSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<AuthLogAdmin> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            AuthLogAdmin et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getUserName(),ex.getMessage());
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
    default AuthLogAdmin getEntity() {
        return new AuthLogAdmin();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default AuthLogAdminSearchContext getSearchContext() {
        return new AuthLogAdminSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}