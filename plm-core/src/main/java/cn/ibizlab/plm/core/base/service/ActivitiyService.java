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
import cn.ibizlab.plm.core.base.domain.Activitiy;
import cn.ibizlab.plm.core.base.filter.ActivitiySearchContext;

/**
 * 活动服务接口[ActivitiyService]
 *
 * @author generator
 */
public interface ActivitiyService extends IService<Activitiy> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ActivitiyService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Activitiy get(Activitiy et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Activitiy get(String key) {
        return getSelf().get(new Activitiy().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Activitiy> getByIds(Collection<String> ids) {
        List<Activitiy> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Activitiy().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Activitiy> getByEntities(List<Activitiy> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Activitiy getDraft(Activitiy et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Activitiy et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Activitiy et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Activitiy> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Activitiy et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Activitiy> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Activitiy et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Activitiy> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Activitiy().setId(key));
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
    boolean remove(Activitiy et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Activitiy> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Activitiy().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Activitiy> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Activitiy> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Activitiy et=list.get(i);
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
     * searchALL
     * 
     * @param context
     * @return
     */
    Page<Activitiy> searchAll(ActivitiySearchContext context);
    /**
     * listALL
     * 
     * @param context
     * @return
     */
    List<Activitiy> listAll(ActivitiySearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Activitiy> searchDefault(ActivitiySearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Activitiy> listDefault(ActivitiySearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Activitiy getEntity() {
        return new Activitiy();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ActivitiySearchContext getSearchContext() {
        return new ActivitiySearchContext();
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