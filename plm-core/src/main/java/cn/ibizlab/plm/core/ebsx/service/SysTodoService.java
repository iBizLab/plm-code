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
public interface SysTodoService {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysTodoService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysTodo get(SysTodo et);
    /**
     * 获取
     * @param key
     * @return
     */
    default SysTodo get(String key) {
        return getById(key);
    }
    default SysTodo getById(String key) {
        return null;
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<SysTodo> getByIds(Collection<String> ids) {
        List<SysTodo> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SysTodo().setTodoId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<SysTodo> getByEntities(List<SysTodo> entities);

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
    boolean createBatch(List<SysTodo> list);

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
    boolean updateBatch(List<SysTodo> list);

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
    boolean saveBatch(List<SysTodo> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysTodo().setTodoId(key));
    }
    /**
     * 根据keys批量删除
     * @param keys
     * @return
     */
    default boolean remove(List<String> keys) {
        return removeBatch(keys);
    }
    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SysTodo et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<SysTodo> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SysTodo().setTodoId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<SysTodo> entities);

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
     * GetLinkUrl
     * 
     * @param key
     * @return
     */
    default SysTodo getLinkUrl(String key) {
        return null;
    }

    /**
     * searchCurUser
     * 
     * @param context
     * @return
     */
    Page<SysTodo> searchCurUser(SysTodoSearchContext context);
    /**
     * listCurUser
     * 
     * @param context
     * @return
     */
    List<SysTodo> listCurUser(SysTodoSearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<SysTodo> searchDefault(SysTodoSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<SysTodo> listDefault(SysTodoSearchContext context);

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