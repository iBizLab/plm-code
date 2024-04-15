/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysPerson;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysPersonSearchContext;

/**
 * 人员服务接口[SysPersonService]
 *
 * @author generator
 */
public interface SysPersonService {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysPersonService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysPerson get(SysPerson et);
    /**
     * 获取
     * @param key
     * @return
     */
    default SysPerson get(String key) {
        return getById(key);
    }
    default SysPerson getById(String key) {
        return null;
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<SysPerson> getByIds(Collection<String> ids) {
        List<SysPerson> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SysPerson().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<SysPerson> getByEntities(List<SysPerson> entities);

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
    Integer checkKey(SysPerson et);

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
    boolean createBatch(List<SysPerson> list);

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
    boolean updateBatch(List<SysPerson> list);

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
    boolean saveBatch(List<SysPerson> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysPerson().setId(key));
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
    boolean remove(SysPerson et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<SysPerson> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SysPerson().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<SysPerson> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<SysPerson> searchDefault(SysPersonSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<SysPerson> listDefault(SysPersonSearchContext context);

    /**
     * searchuser
     * 
     * @param context
     * @return
     */
    Page<SysPerson> searchUser(SysPersonSearchContext context);
    /**
     * listuser
     * 
     * @param context
     * @return
     */
    List<SysPerson> listUser(SysPersonSearchContext context);

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