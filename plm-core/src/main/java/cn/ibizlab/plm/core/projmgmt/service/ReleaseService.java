/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.filter.ReleaseSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 项目发布服务接口[ReleaseService]
 *
 * @author generator
 */
public interface ReleaseService extends IService<Release> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ReleaseService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Release get(Release et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Release get(String key) {
        return getSelf().get(new Release().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Release> getByIds(Collection<String> ids) {
        List<Release> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Release().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Release> getByEntities(List<Release> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Release getDraft(Release et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Release et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Release et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Release> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Release et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Release> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Release et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Release> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Release().setId(key));
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
    boolean remove(Release et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Release> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Release().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Release> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Release> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Release et=list.get(i);
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
     * Plan_work_item
     * 
     * @param dto
     * @return
     */
    default Release planWorkItem(Release dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Release> searchDefault(ReleaseSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Release> listDefault(ReleaseSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Release getEntity() {
        return new Release();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ReleaseSearchContext getSearchContext() {
        return new ReleaseSearchContext();
    }
    /**
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<Release> findByProjectId(List<String> projectIds);
    default List<Release> findByProjectId(String projectId) {
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
    default boolean saveByProjectId(String projectId,List<Release> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<Release> list);


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