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
import cn.ibizlab.plm.core.base.domain.SequenceGenerator;
import cn.ibizlab.plm.core.base.filter.SequenceGeneratorSearchContext;

/**
 * 序列服务接口[SequenceGeneratorService]
 *
 * @author generator
 */
public interface SequenceGeneratorService extends IService<SequenceGenerator> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SequenceGeneratorService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(SequenceGenerator et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<SequenceGenerator> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(SequenceGenerator et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<SequenceGenerator> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SequenceGenerator().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(SequenceGenerator et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<SequenceGenerator> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SequenceGenerator().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<SequenceGenerator> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default SequenceGenerator get(String key) {
        return getSelf().get(new SequenceGenerator().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SequenceGenerator get(SequenceGenerator et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<SequenceGenerator> get(Collection<String> keys) {
        List<SequenceGenerator> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new SequenceGenerator().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<SequenceGenerator> get(List<SequenceGenerator> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    SequenceGenerator getDraft(SequenceGenerator et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(SequenceGenerator et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(SequenceGenerator et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<SequenceGenerator> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<SequenceGenerator> fetchDefault(SequenceGeneratorSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<SequenceGenerator> listDefault(SequenceGeneratorSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<SequenceGenerator> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SequenceGenerator et=list.get(i);
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
    default SequenceGenerator getEntity() {
        return new SequenceGenerator();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SequenceGeneratorSearchContext getSearchContext() {
        return new SequenceGeneratorSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}