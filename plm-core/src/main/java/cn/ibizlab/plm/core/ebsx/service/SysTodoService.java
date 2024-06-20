/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.ebsx.domain.SysTodo;
import cn.ibizlab.plm.core.ebsx.filter.SysTodoSearchContext;

/**
 * 待办服务接口[SysTodoService]
 *
 * @author generator
 */
public interface SysTodoService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysTodoService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SysTodo et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SysTodo> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SysTodo et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SysTodo> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysTodo().setTodoId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SysTodo et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SysTodo> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysTodo().setTodoId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SysTodo> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SysTodo get(String key) {
        return getSelf().get(new SysTodo().setTodoId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysTodo get(SysTodo et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SysTodo> get(Collection<String> keys) {
        List<SysTodo> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysTodo().setTodoId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SysTodo> get(List<SysTodo> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SysTodo getDraft(SysTodo et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(SysTodo et);

    /**
    * getLinkUrl
    * 
    * @param key
    * @return
    */
    default SysTodo getLinkUrl(String key) {
        return getSelf().getLinkUrl(new SysTodo().setTodoId(key));
    }

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SysTodo et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SysTodo> list);

    /**
    * fetchCurUser
    * 
    * @param context
    * @return
    */
    Page<SysTodo> fetchCurUser(SysTodoSearchContext context);

    /**
    * listCurUser
    * 
    * @param context
    * @return
    */
    List<SysTodo> listCurUser(SysTodoSearchContext context);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SysTodo> fetchDefault(SysTodoSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SysTodo> listDefault(SysTodoSearchContext context);

    /**
    * getLinkUrl
    * 
    * @param et
    * @return
    */
    default SysTodo getLinkUrl(SysTodo et) {
        return et;
    }


    default ImportResult importData(String config, Boolean ignoreError, List<SysTodo> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SysTodo et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getTitle(),ex.getMessage());
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
    default SysTodo getEntity() {
        return new SysTodo();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SysTodoSearchContext getSearchContext() {
        return new SysTodoSearchContext();
    }

}