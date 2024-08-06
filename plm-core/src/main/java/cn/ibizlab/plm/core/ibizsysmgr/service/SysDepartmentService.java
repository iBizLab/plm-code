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
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysDepartment;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysDepartmentSearchContext;

/**
 * 部门服务接口[SysDepartmentService]
 *
 * @author generator
 */
public interface SysDepartmentService{

    /**
     * 获取当前Service
     *
     * @return
     */
    default SysDepartmentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SysDepartment et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SysDepartment> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SysDepartment et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SysDepartment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SysDepartment().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SysDepartment et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SysDepartment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysDepartment().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SysDepartment> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SysDepartment get(String key) {
        return getSelf().get(new SysDepartment().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SysDepartment get(SysDepartment et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SysDepartment> get(Collection<String> keys) {
        List<SysDepartment> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SysDepartment().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SysDepartment> get(List<SysDepartment> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SysDepartment getDraft(SysDepartment et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(SysDepartment et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SysDepartment et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SysDepartment> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SysDepartment> fetchDefault(SysDepartmentSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SysDepartment> listDefault(SysDepartmentSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<SysDepartment> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SysDepartment et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getDepartmentName(),ex.getMessage());
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
    default SysDepartment getEntity() {
        return new SysDepartment();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SysDepartmentSearchContext getSearchContext() {
        return new SysDepartmentSearchContext();
    }

}