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
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import cn.ibizlab.plm.core.base.filter.ReferencesIndexSearchContext;

/**
 * 引用索引服务接口[ReferencesIndexService]
 *
 * @author generator
 */
public interface ReferencesIndexService extends IService<ReferencesIndex> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ReferencesIndexService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ReferencesIndex et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ReferencesIndex> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ReferencesIndex et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ReferencesIndex> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ReferencesIndex().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ReferencesIndex et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ReferencesIndex> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReferencesIndex().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ReferencesIndex> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ReferencesIndex get(String key) {
        return getSelf().get(new ReferencesIndex().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ReferencesIndex get(ReferencesIndex et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ReferencesIndex> get(Collection<String> keys) {
        List<ReferencesIndex> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReferencesIndex().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ReferencesIndex> get(List<ReferencesIndex> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ReferencesIndex getDraft(ReferencesIndex et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(ReferencesIndex et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ReferencesIndex et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ReferencesIndex> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ReferencesIndex> fetchDefault(ReferencesIndexSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ReferencesIndex> listDefault(ReferencesIndexSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ReferencesIndex> fetchView(ReferencesIndexSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ReferencesIndex> listView(ReferencesIndexSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<ReferencesIndex> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ReferencesIndex et=list.get(i);
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
    default ReferencesIndex getEntity() {
        return new ReferencesIndex();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ReferencesIndexSearchContext getSearchContext() {
        return new ReferencesIndexSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}