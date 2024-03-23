/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.projmgmt.domain.VersionCategory;
import cn.ibizlab.plm.core.projmgmt.filter.VersionCategorySearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.VersionSection;
import cn.ibizlab.plm.core.projmgmt.domain.Version;

/**
 * 发布类别服务接口[VersionCategoryService]
 *
 * @author generator
 */
public interface VersionCategoryService extends IService<VersionCategory> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default VersionCategoryService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    VersionCategory get(VersionCategory et);
    /**
     * 获取
     * @param key
     * @return
     */
    default VersionCategory get(String key) {
        return getSelf().get(new VersionCategory().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<VersionCategory> getByIds(Collection<String> ids) {
        List<VersionCategory> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new VersionCategory().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<VersionCategory> getByEntities(List<VersionCategory> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    VersionCategory getDraft(VersionCategory et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(VersionCategory et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(VersionCategory et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<VersionCategory> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(VersionCategory et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<VersionCategory> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(VersionCategory et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<VersionCategory> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new VersionCategory().setId(key));
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
    boolean remove(VersionCategory et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<VersionCategory> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new VersionCategory().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<VersionCategory> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<VersionCategory> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            VersionCategory et=list.get(i);
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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<VersionCategory> searchDefault(VersionCategorySearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<VersionCategory> listDefault(VersionCategorySearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default VersionCategory getEntity() {
        return new VersionCategory();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default VersionCategorySearchContext getSearchContext() {
        return new VersionCategorySearchContext();
    }
    /**
     * selectRelByVersionSectionId
     * @param versionSectionIds
     * @return
     */
    List<VersionCategory> findByVersionSectionId(List<String> versionSectionIds);
    default List<VersionCategory> findByVersionSectionId(String versionSectionId) {
        return findByVersionSectionId(Arrays.asList(versionSectionId));
    }
    /**
     * removeRelByVersionSectionId
     * @param versionSectionId
     * @return
     */
    boolean removeByVersionSectionId(String versionSectionId);
    /**
     * resetRelByVersionSectionId
     * @param versionSectionId
     * @return
     */
    boolean resetByVersionSectionId(String versionSectionId);
    /**
     * saveRelByVersionSectionId
     * @param versionSectionId
     * @param list
     * @return
     */
    default boolean saveByVersionSectionId(String versionSectionId,List<VersionCategory> list) {
        return getSelf().saveByVersionSection(new VersionSection().setId(versionSectionId),list);
    }
    /**
    * saveRelByVersionSection
    * @param versionSection
    * @param list
    * @return
    */
    boolean saveByVersionSection(VersionSection versionSection,List<VersionCategory> list);


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