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
import cn.ibizlab.util.enums.CheckKeyStatus;
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
    boolean create(List<ProjectTag> list);

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
    boolean update(List<ProjectTag> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProjectTag().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ProjectTag et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ProjectTag> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProjectTag().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ProjectTag> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ProjectTag get(String key) {
        return getSelf().get(new ProjectTag().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProjectTag get(ProjectTag et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ProjectTag> get(Collection<String> keys) {
        List<ProjectTag> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProjectTag().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ProjectTag> get(List<ProjectTag> entities);

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
    CheckKeyStatus checkKey(ProjectTag et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ProjectTag et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ProjectTag> list);

    /**
    * deleteTag
    * 
    * @param et
    * @return
    */
    default ProjectTag deleteTag(ProjectTag et) {
        return et;
    }

    /**
    * getConProjectTag
    * 
    * @param key
    * @return
    */
    default ProjectTag getConProjectTag(String key) {
        return getSelf().getConProjectTag(new ProjectTag().setId(key));
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default ProjectTag nothing(ProjectTag et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ProjectTag> fetchDefault(ProjectTagSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ProjectTag> listDefault(ProjectTagSearchContext context);

    /**
    * getConProjectTag
    * 
    * @param et
    * @return
    */
    default ProjectTag getConProjectTag(ProjectTag et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ProjectTag> fetchView(ProjectTagSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ProjectTag> listView(ProjectTagSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}