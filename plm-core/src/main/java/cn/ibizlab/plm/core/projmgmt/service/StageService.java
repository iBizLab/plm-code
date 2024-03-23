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
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.projmgmt.filter.StageSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.domain.Version;

/**
 * 发布阶段服务接口[StageService]
 *
 * @author generator
 */
public interface StageService extends IService<Stage> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default StageService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Stage get(Stage et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Stage get(String key) {
        return getSelf().get(new Stage().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Stage> getByIds(Collection<String> ids) {
        List<Stage> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Stage().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Stage> getByEntities(List<Stage> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Stage getDraft(Stage et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Stage et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Stage et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Stage> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Stage et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Stage> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Stage et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Stage> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Stage().setId(key));
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
    boolean remove(Stage et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Stage> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Stage().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Stage> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Stage> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Stage et=list.get(i);
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
    Page<Stage> searchDefault(StageSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Stage> listDefault(StageSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Stage getEntity() {
        return new Stage();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default StageSearchContext getSearchContext() {
        return new StageSearchContext();
    }
    /**
     * selectRelByReleaseId
     * @param releaseIds
     * @return
     */
    List<Stage> findByReleaseId(List<String> releaseIds);
    default List<Stage> findByReleaseId(String releaseId) {
        return findByReleaseId(Arrays.asList(releaseId));
    }
    /**
     * removeRelByReleaseId
     * @param releaseId
     * @return
     */
    boolean removeByReleaseId(String releaseId);
    /**
     * resetRelByReleaseId
     * @param releaseId
     * @return
     */
    boolean resetByReleaseId(String releaseId);
    /**
     * saveRelByReleaseId
     * @param releaseId
     * @param list
     * @return
     */
    default boolean saveByReleaseId(String releaseId,List<Stage> list) {
        return getSelf().saveByRelease(new Release().setId(releaseId),list);
    }
    /**
    * saveRelByRelease
    * @param release
    * @param list
    * @return
    */
    boolean saveByRelease(Release release,List<Stage> list);

    /**
     * selectRelByVersionId
     * @param versionIds
     * @return
     */
    List<Stage> findByVersionId(List<String> versionIds);
    default List<Stage> findByVersionId(String versionId) {
        return findByVersionId(Arrays.asList(versionId));
    }
    /**
     * removeRelByVersionId
     * @param versionId
     * @return
     */
    boolean removeByVersionId(String versionId);
    /**
     * resetRelByVersionId
     * @param versionId
     * @return
     */
    boolean resetByVersionId(String versionId);
    /**
     * saveRelByVersionId
     * @param versionId
     * @param list
     * @return
     */
    default boolean saveByVersionId(String versionId,List<Stage> list) {
        return getSelf().saveByVersion(new Version().setId(versionId),list);
    }
    /**
    * saveRelByVersion
    * @param version
    * @param list
    * @return
    */
    boolean saveByVersion(Version version,List<Stage> list);


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