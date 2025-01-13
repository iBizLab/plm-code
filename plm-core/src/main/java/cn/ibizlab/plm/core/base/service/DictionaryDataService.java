/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.DictionaryData;
import cn.ibizlab.plm.core.base.filter.DictionaryDataSearchContext;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 数据字典服务接口[DictionaryDataService]
 *
 * @author generator
 */
public interface DictionaryDataService extends IService<DictionaryData> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DictionaryDataService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(DictionaryData et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<DictionaryData> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(DictionaryData et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<DictionaryData> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DictionaryData().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(DictionaryData et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<DictionaryData> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DictionaryData().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<DictionaryData> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default DictionaryData get(String key) {
        return getSelf().get(new DictionaryData().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DictionaryData get(DictionaryData et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<DictionaryData> get(Collection<String> keys) {
        List<DictionaryData> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DictionaryData().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<DictionaryData> get(List<DictionaryData> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    DictionaryData getDraft(DictionaryData et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(DictionaryData et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(DictionaryData et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<DictionaryData> list);

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<DictionaryData> moveOrder(DictionaryData et) {
        return new ArrayList<>();
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default DictionaryData nothing(DictionaryData et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<DictionaryData> fetchDefault(DictionaryDataSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<DictionaryData> listDefault(DictionaryDataSearchContext context);

    /**
    * fetchIdeaState
    * 
    * @param context
    * @return
    */
    Page<DictionaryData> fetchIdeaState(DictionaryDataSearchContext context);

    /**
    * listIdeaState
    * 
    * @param context
    * @return
    */
    List<DictionaryData> listIdeaState(DictionaryDataSearchContext context);

    /**
    * fetchReleaseStage
    * 
    * @param context
    * @return
    */
    Page<DictionaryData> fetchReleaseStage(DictionaryDataSearchContext context);

    /**
    * listReleaseStage
    * 
    * @param context
    * @return
    */
    List<DictionaryData> listReleaseStage(DictionaryDataSearchContext context);

    /**
    * fetchTicketState
    * 
    * @param context
    * @return
    */
    Page<DictionaryData> fetchTicketState(DictionaryDataSearchContext context);

    /**
    * listTicketState
    * 
    * @param context
    * @return
    */
    List<DictionaryData> listTicketState(DictionaryDataSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<DictionaryData> fetchView(DictionaryDataSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<DictionaryData> listView(DictionaryDataSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<DictionaryData> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DictionaryData et=list.get(i);
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
    default DictionaryData getEntity() {
        return new DictionaryData();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DictionaryDataSearchContext getSearchContext() {
        return new DictionaryDataSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}