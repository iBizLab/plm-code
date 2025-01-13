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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.filter.WorkSearchContext;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 工作服务接口[WorkService]
 *
 * @author generator
 */
public interface WorkService extends IService<Work> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default WorkService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Work et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Work> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Work et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Work> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Work().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Work et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Work> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Work().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Work> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Work get(String key) {
        return getSelf().get(new Work().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Work get(Work et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Work> get(Collection<String> keys) {
        List<Work> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Work().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Work> get(List<Work> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Work getDraft(Work et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Work et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Work et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Work> list);

    /**
    * addProject
    * 
    * @param et
    * @return
    */
    default Work addProject(Work et) {
        return et;
    }

    /**
    * addProjectPortfolio
    * 
    * @param et
    * @return
    */
    default Work addProjectPortfolio(Work et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Work> fetchDefault(WorkSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Work> listDefault(WorkSearchContext context);

    /**
    * fetchItemSetOwner
    * 
    * @param context
    * @return
    */
    Page<Work> fetchItemSetOwner(WorkSearchContext context);

    /**
    * listItemSetOwner
    * 
    * @param context
    * @return
    */
    List<Work> listItemSetOwner(WorkSearchContext context);

    /**
    * findByPortfolioId
    * @param portfolioIds
    * @return
    */
    List<Work> findByPortfolioId(List<String> portfolioIds);
    default List<Work> findByPortfolioId(String portfolioId){
        return findByPortfolio(new Portfolio().setId(portfolioId));
    }

    /**
    * findByPortfolio
    * @param portfolio
    * @return
    */
    List<Work> findByPortfolio(Portfolio portfolio);

    /**
    * removeByPortfolioId
    * @param portfolioId
    * @return
    */
    boolean removeByPortfolioId(String portfolioId);

    /**
    * resetByPortfolioId
    * @param portfolioId
    * @return
    */
    boolean resetByPortfolioId(String portfolioId);

    /**
    * saveByPortfolioId
    * @param portfolioId
    * @param list
    * @return
    */
    default boolean saveByPortfolioId(String portfolioId, List<Work> list){
        return getSelf().saveByPortfolio(new Portfolio().setId(portfolioId),list);
    }

    /**
    * saveByPortfolio
    * @param portfolio
    * @param list
    * @return
    */
    boolean saveByPortfolio(Portfolio portfolio, List<Work> list);

    /**
    * findByPilotId
    * @param pilotIds
    * @return
    */
    List<Work> findByPilotId(List<String> pilotIds);
    default List<Work> findByPilotId(String pilotId){
        return findByProject(new Project().setId(pilotId));
    }

    /**
    * findByProject
    * @param project
    * @return
    */
    List<Work> findByProject(Project project);

    /**
    * removeByPilotId
    * @param pilotId
    * @return
    */
    boolean removeByPilotId(String pilotId);

    /**
    * resetByPilotId
    * @param pilotId
    * @return
    */
    boolean resetByPilotId(String pilotId);

    /**
    * saveByPilotId
    * @param pilotId
    * @param list
    * @return
    */
    default boolean saveByPilotId(String pilotId, List<Work> list){
        return getSelf().saveByProject(new Project().setId(pilotId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<Work> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Work> fetchView(WorkSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Work> listView(WorkSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Work> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Work et=list.get(i);
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
    default Work getEntity() {
        return new Work();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default WorkSearchContext getSearchContext() {
        return new WorkSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}