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
import cn.ibizlab.plm.core.projmgmt.domain.VersionSection;
import cn.ibizlab.plm.core.projmgmt.filter.VersionSectionSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.VersionCategory;

/**
 * 发布分组服务接口[VersionSectionService]
 *
 * @author generator
 */
public interface VersionSectionService extends IService<VersionSection> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default VersionSectionService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    VersionSection get(VersionSection et);
    /**
     * 获取
     * @param key
     * @return
     */
    default VersionSection get(String key) {
        return getSelf().get(new VersionSection().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<VersionSection> getByIds(Collection<String> ids) {
        List<VersionSection> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new VersionSection().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<VersionSection> getByEntities(List<VersionSection> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    VersionSection getDraft(VersionSection et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(VersionSection et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(VersionSection et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<VersionSection> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(VersionSection et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<VersionSection> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(VersionSection et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<VersionSection> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new VersionSection().setId(key));
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
    boolean remove(VersionSection et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<VersionSection> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new VersionSection().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<VersionSection> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<VersionSection> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            VersionSection et=list.get(i);
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
    Page<VersionSection> searchDefault(VersionSectionSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<VersionSection> listDefault(VersionSectionSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default VersionSection getEntity() {
        return new VersionSection();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default VersionSectionSearchContext getSearchContext() {
        return new VersionSectionSearchContext();
    }
    /**
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<VersionSection> findByProjectId(List<String> projectIds);
    default List<VersionSection> findByProjectId(String projectId) {
        return findByProjectId(Arrays.asList(projectId));
    }
    /**
     * removeRelByProjectId
     * @param projectId
     * @return
     */
    boolean removeByProjectId(String projectId);
    /**
     * resetRelByProjectId
     * @param projectId
     * @return
     */
    boolean resetByProjectId(String projectId);
    /**
     * saveRelByProjectId
     * @param projectId
     * @param list
     * @return
     */
    default boolean saveByProjectId(String projectId,List<VersionSection> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<VersionSection> list);


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