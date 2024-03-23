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
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.filter.SectionSearchContext;
import cn.ibizlab.plm.core.base.domain.Category;

/**
 * 分组服务接口[SectionService]
 *
 * @author generator
 */
public interface SectionService extends IService<Section> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SectionService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Section get(Section et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Section get(String key) {
        return getSelf().get(new Section().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Section> getByIds(Collection<String> ids) {
        List<Section> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Section().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Section> getByEntities(List<Section> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Section getDraft(Section et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Section et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Section et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Section> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Section et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Section> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Section et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Section> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Section().setId(key));
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
    boolean remove(Section et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Section> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Section().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Section> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Section> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Section et=list.get(i);
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
     * Delete_section
     * 
     * @param dto
     * @return
     */
    default Section deleteSection(Section dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Section> searchDefault(SectionSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Section> listDefault(SectionSearchContext context);

    /**
     * searchThis_product_section
     * 
     * @param context
     * @return
     */
    Page<Section> searchThisProductSection(SectionSearchContext context);
    /**
     * listThis_product_section
     * 
     * @param context
     * @return
     */
    List<Section> listThisProductSection(SectionSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Section getEntity() {
        return new Section();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default SectionSearchContext getSearchContext() {
        return new SectionSearchContext();
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