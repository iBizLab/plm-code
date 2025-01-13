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
import cn.ibizlab.plm.core.base.domain.VersionData;
import cn.ibizlab.plm.core.base.filter.VersionDataSearchContext;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 附加数据版本服务接口[VersionDataService]
 *
 * @author generator
 */
public interface VersionDataService extends IService<VersionData> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default VersionDataService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(VersionData et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<VersionData> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(VersionData et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<VersionData> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new VersionData().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(VersionData et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<VersionData> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new VersionData().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<VersionData> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default VersionData get(String key) {
        return getSelf().get(new VersionData().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    VersionData get(VersionData et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<VersionData> get(Collection<String> keys) {
        List<VersionData> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new VersionData().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<VersionData> get(List<VersionData> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    VersionData getDraft(VersionData et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(VersionData et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(VersionData et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<VersionData> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<VersionData> fetchDefault(VersionDataSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<VersionData> listDefault(VersionDataSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<VersionData> fetchView(VersionDataSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<VersionData> listView(VersionDataSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<VersionData> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            VersionData et=list.get(i);
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
    default VersionData getEntity() {
        return new VersionData();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default VersionDataSearchContext getSearchContext() {
        return new VersionDataSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}