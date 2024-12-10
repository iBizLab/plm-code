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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectState;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectStateSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Project;

/**
 * 项目状态服务接口[ProjectStateService]
 *
 * @author generator
 */
public interface ProjectStateService extends IService<ProjectState> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ProjectStateService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ProjectState et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ProjectState> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ProjectState et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ProjectState> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ProjectState().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ProjectState et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ProjectState> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProjectState().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ProjectState> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ProjectState get(String key) {
        return getSelf().get(new ProjectState().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ProjectState get(ProjectState et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ProjectState> get(Collection<String> keys) {
        List<ProjectState> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ProjectState().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ProjectState> get(List<ProjectState> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ProjectState getDraft(ProjectState et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(ProjectState et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ProjectState et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ProjectState> list);

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<ProjectState> moveOrder(ProjectState et) {
        return new ArrayList<>();
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ProjectState> fetchDefault(ProjectStateSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ProjectState> listDefault(ProjectStateSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ProjectState> fetchView(ProjectStateSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ProjectState> listView(ProjectStateSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<ProjectState> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ProjectState et=list.get(i);
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
    default ProjectState getEntity() {
        return new ProjectState();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ProjectStateSearchContext getSearchContext() {
        return new ProjectStateSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}