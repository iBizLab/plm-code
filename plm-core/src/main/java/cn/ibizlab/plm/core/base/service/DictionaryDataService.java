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
import cn.ibizlab.plm.core.base.domain.DictionaryData;
import cn.ibizlab.plm.core.base.filter.DictionaryDataSearchContext;

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
     * 获取
     * @param et
     * @return
     */
    DictionaryData get(DictionaryData et);
    /**
     * 获取
     * @param key
     * @return
     */
    default DictionaryData get(String key) {
        return getSelf().get(new DictionaryData().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<DictionaryData> getByIds(Collection<String> ids) {
        List<DictionaryData> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new DictionaryData().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<DictionaryData> getByEntities(List<DictionaryData> entities);

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
    Integer checkKey(DictionaryData et);

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
    boolean createBatch(List<DictionaryData> list);

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
    boolean updateBatch(List<DictionaryData> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(DictionaryData et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<DictionaryData> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DictionaryData().setId(key));
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
    boolean remove(DictionaryData et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<DictionaryData> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new DictionaryData().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<DictionaryData> entities);

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
     * nothing
     * 
     * @param dto
     * @return
     */
    default DictionaryData nothing(DictionaryData dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<DictionaryData> searchDefault(DictionaryDataSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<DictionaryData> listDefault(DictionaryDataSearchContext context);

    /**
     * searchidea_state
     * 
     * @param context
     * @return
     */
    Page<DictionaryData> searchIdeaState(DictionaryDataSearchContext context);
    /**
     * listidea_state
     * 
     * @param context
     * @return
     */
    List<DictionaryData> listIdeaState(DictionaryDataSearchContext context);

    /**
     * searchrelease_stage
     * 
     * @param context
     * @return
     */
    Page<DictionaryData> searchReleaseStage(DictionaryDataSearchContext context);
    /**
     * listrelease_stage
     * 
     * @param context
     * @return
     */
    List<DictionaryData> listReleaseStage(DictionaryDataSearchContext context);

    /**
     * searchticket_state
     * 
     * @param context
     * @return
     */
    Page<DictionaryData> searchTicketState(DictionaryDataSearchContext context);
    /**
     * listticket_state
     * 
     * @param context
     * @return
     */
    List<DictionaryData> listTicketState(DictionaryDataSearchContext context);

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
     * 自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    List<JSONObject> select(String sql, Map<String,Object> param);

    /**
     * 自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    boolean execute(String sql, Map<String,Object> param);

}