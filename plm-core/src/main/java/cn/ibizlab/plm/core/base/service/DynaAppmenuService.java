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
import cn.ibizlab.plm.core.base.domain.DynaAppmenu;
import cn.ibizlab.plm.core.base.filter.DynaAppmenuSearchContext;

/**
 * 动态应用菜单服务接口[DynaAppmenuService]
 *
 * @author generator
 */
public interface DynaAppmenuService extends IService<DynaAppmenu> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DynaAppmenuService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(DynaAppmenu et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<DynaAppmenu> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(DynaAppmenu et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<DynaAppmenu> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DynaAppmenu().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(DynaAppmenu et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<DynaAppmenu> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DynaAppmenu().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<DynaAppmenu> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default DynaAppmenu get(String key) {
        return getSelf().get(new DynaAppmenu().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DynaAppmenu get(DynaAppmenu et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<DynaAppmenu> get(Collection<String> keys) {
        List<DynaAppmenu> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DynaAppmenu().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<DynaAppmenu> get(List<DynaAppmenu> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    DynaAppmenu getDraft(DynaAppmenu et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(DynaAppmenu et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(DynaAppmenu et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<DynaAppmenu> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<DynaAppmenu> fetchDefault(DynaAppmenuSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<DynaAppmenu> listDefault(DynaAppmenuSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<DynaAppmenu> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DynaAppmenu et=list.get(i);
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
    default DynaAppmenu getEntity() {
        return new DynaAppmenu();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DynaAppmenuSearchContext getSearchContext() {
        return new DynaAppmenuSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}