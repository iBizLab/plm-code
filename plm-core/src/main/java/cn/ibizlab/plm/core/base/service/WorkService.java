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
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.filter.WorkSearchContext;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.projmgmt.domain.Project;

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
     * 获取
     * @param et
     * @return
     */
    Work get(Work et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Work get(String key) {
        return getSelf().get(new Work().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Work> getByIds(Collection<String> ids) {
        List<Work> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Work().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Work> getByEntities(List<Work> entities);

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
    Integer checkKey(Work et);

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
    boolean createBatch(List<Work> list);

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
    boolean updateBatch(List<Work> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Work et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Work> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Work().setId(key));
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
    boolean remove(Work et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Work> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Work().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Work> entities);

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
     * add_project
     * 
     * @param dto
     * @return
     */
    default Work addProject(Work dto) {
        return dto;
    }

    /**
     * add_project_portfolio
     * 
     * @param dto
     * @return
     */
    default Work addProjectPortfolio(Work dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Work> searchDefault(WorkSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Work> listDefault(WorkSearchContext context);

    /**
     * searchitem_set_owner
     * 
     * @param context
     * @return
     */
    Page<Work> searchItemSetOwner(WorkSearchContext context);
    /**
     * listitem_set_owner
     * 
     * @param context
     * @return
     */
    List<Work> listItemSetOwner(WorkSearchContext context);

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
     * selectRelByPortfolioId
     * @param portfolioIds
     * @return
     */
    List<Work> findByPortfolioId(List<String> portfolioIds);
    default List<Work> findByPortfolioId(String portfolioId) {
        return findByPortfolioId(Arrays.asList(portfolioId));
    }
    /**
     * removeRelByPortfolioId
     * @param portfolioId
     * @return
     */
    boolean removeByPortfolioId(String portfolioId);
    /**
     * resetRelByPortfolioId
     * @param portfolioId
     * @return
     */
    boolean resetByPortfolioId(String portfolioId);
    /**
     * saveRelByPortfolioId
     * @param portfolioId
     * @param list
     * @return
     */
    default boolean saveByPortfolioId(String portfolioId,List<Work> list) {
        return getSelf().saveByPortfolio(new Portfolio().setId(portfolioId),list);
    }
    /**
    * saveRelByPortfolio
    * @param portfolio
    * @param list
    * @return
    */
    boolean saveByPortfolio(Portfolio portfolio,List<Work> list);

    /**
     * selectRelByPilotId
     * @param pilotIds
     * @return
     */
    List<Work> findByPilotId(List<String> pilotIds);
    default List<Work> findByPilotId(String pilotId) {
        return findByPilotId(Arrays.asList(pilotId));
    }
    /**
     * removeRelByPilotId
     * @param pilotId
     * @return
     */
    boolean removeByPilotId(String pilotId);
    /**
     * resetRelByPilotId
     * @param pilotId
     * @return
     */
    boolean resetByPilotId(String pilotId);
    /**
     * saveRelByPilotId
     * @param pilotId
     * @param list
     * @return
     */
    default boolean saveByPilotId(String pilotId,List<Work> list) {
        return getSelf().saveByProject(new Project().setId(pilotId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<Work> list);


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