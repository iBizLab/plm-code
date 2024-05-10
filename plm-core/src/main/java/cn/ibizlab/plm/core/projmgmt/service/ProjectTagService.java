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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectTag;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectTagSearchContext;

/**
 * 项目标签服务接口[ProjectTagService]
 *
 * @author generator
 */
public interface ProjectTagService extends IService<ProjectTag> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProjectTagService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProjectTag get(ProjectTag et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ProjectTag get(String key) {
        return getSelf().get(new ProjectTag().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ProjectTag> getByIds(Collection<String> ids) {
        List<ProjectTag> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProjectTag().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ProjectTag> getByEntities(List<ProjectTag> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    ProjectTag getDraft(ProjectTag et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(ProjectTag et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(ProjectTag et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<ProjectTag> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(ProjectTag et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<ProjectTag> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ProjectTag et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ProjectTag> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProjectTag().setId(key));
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
    boolean remove(ProjectTag et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ProjectTag> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ProjectTag().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ProjectTag> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<ProjectTag> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ProjectTag et=list.get(i);
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
    default ProjectTag nothing(ProjectTag dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<ProjectTag> searchDefault(ProjectTagSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ProjectTag> listDefault(ProjectTagSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default ProjectTag getEntity() {
        return new ProjectTag();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ProjectTagSearchContext getSearchContext() {
        return new ProjectTagSearchContext();
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