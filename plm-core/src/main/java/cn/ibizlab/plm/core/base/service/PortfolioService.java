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
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.filter.PortfolioSearchContext;
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.base.domain.Work;

/**
 * 文件夹服务接口[PortfolioService]
 *
 * @author generator
 */
public interface PortfolioService extends IService<Portfolio> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default PortfolioService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Portfolio get(Portfolio et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Portfolio get(String key) {
        return getSelf().get(new Portfolio().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Portfolio> getByIds(Collection<String> ids) {
        List<Portfolio> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Portfolio().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Portfolio> getByEntities(List<Portfolio> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Portfolio getDraft(Portfolio et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Portfolio et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Portfolio et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Portfolio> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Portfolio et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Portfolio> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Portfolio et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Portfolio> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Portfolio().setId(key));
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
    boolean remove(Portfolio et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Portfolio> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Portfolio().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Portfolio> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Portfolio> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Portfolio et=list.get(i);
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
     * CreateTemp
     * 
     * @param dto
     * @return
     */
    default Portfolio createTemp(Portfolio dto) {
        return dto;
    }

    /**
     * CreateTempMajor
     * 
     * @param dto
     * @return
     */
    default Portfolio createTempMajor(Portfolio dto) {
        return dto;
    }

    /**
     * UpdateTemp
     * 
     * @param dto
     * @return
     */
    default Portfolio updateTemp(Portfolio dto) {
        return dto;
    }

    /**
     * UpdateTempMajor
     * 
     * @param dto
     * @return
     */
    default Portfolio updateTempMajor(Portfolio dto) {
        return dto;
    }

    /**
     * RemoveTemp
     * 
     * @param keys
     * @return
     */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
     * RemoveTempMajor
     * 
     * @param keys
     * @return
     */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
     * GetTemp
     * 
     * @param key
     * @return
     */
    default Portfolio getTemp(String key) {
        return null;
    }

    /**
     * GetTempMajor
     * 
     * @param key
     * @return
     */
    default Portfolio getTempMajor(String key) {
        return null;
    }

    /**
     * GetDraftTemp
     * 
     * @param dto
     * @return
     */
    default Portfolio getDraftTemp(Portfolio dto) {
        return dto;
    }

    /**
     * GetDraftTempMajor
     * 
     * @param dto
     * @return
     */
    default Portfolio getDraftTempMajor(Portfolio dto) {
        return dto;
    }

    /**
     * delete_project_set
     * 
     * @param dto
     * @return
     */
    default Portfolio deleteProjectSet(Portfolio dto) {
        return dto;
    }

    /**
     * favorite
     * 
     * @param dto
     * @return
     */
    default Portfolio favorite(Portfolio dto) {
        return dto;
    }

    /**
     * recover_project_set
     * 
     * @param dto
     * @return
     */
    default Portfolio recoverProjectSet(Portfolio dto) {
        return dto;
    }

    /**
     * remove_from_project_set
     * 
     * @param dto
     * @return
     */
    default Portfolio removeFromProjectSet(Portfolio dto) {
        return dto;
    }

    /**
     * un_favorite
     * 
     * @param dto
     * @return
     */
    default Portfolio unFavorite(Portfolio dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchDefault(PortfolioSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Portfolio> listDefault(PortfolioSearchContext context);

    /**
     * searchadmin
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchAdmin(PortfolioSearchContext context);
    /**
     * listadmin
     * 
     * @param context
     * @return
     */
    List<Portfolio> listAdmin(PortfolioSearchContext context);

    /**
     * searchchoose_project_portfolio
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchChooseProjectPortfolio(PortfolioSearchContext context);
    /**
     * listchoose_project_portfolio
     * 
     * @param context
     * @return
     */
    List<Portfolio> listChooseProjectPortfolio(PortfolioSearchContext context);

    /**
     * searchfavorite
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchFavorite(PortfolioSearchContext context);
    /**
     * listfavorite
     * 
     * @param context
     * @return
     */
    List<Portfolio> listFavorite(PortfolioSearchContext context);

    /**
     * searchproject_set_deleted
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchProjectSetDeleted(PortfolioSearchContext context);
    /**
     * listproject_set_deleted
     * 
     * @param context
     * @return
     */
    List<Portfolio> listProjectSetDeleted(PortfolioSearchContext context);

    /**
     * searchproject_set_going
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchProjectSetGoing(PortfolioSearchContext context);
    /**
     * listproject_set_going
     * 
     * @param context
     * @return
     */
    List<Portfolio> listProjectSetGoing(PortfolioSearchContext context);

    /**
     * searchreader
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchReader(PortfolioSearchContext context);
    /**
     * listreader
     * 
     * @param context
     * @return
     */
    List<Portfolio> listReader(PortfolioSearchContext context);

    /**
     * searchuser
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchUser(PortfolioSearchContext context);
    /**
     * listuser
     * 
     * @param context
     * @return
     */
    List<Portfolio> listUser(PortfolioSearchContext context);

    /**
     * searchwork_project_portfolio
     * 
     * @param context
     * @return
     */
    Page<Portfolio> searchWorkProjectPortfolio(PortfolioSearchContext context);
    /**
     * listwork_project_portfolio
     * 
     * @param context
     * @return
     */
    List<Portfolio> listWorkProjectPortfolio(PortfolioSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Portfolio getEntity() {
        return new Portfolio();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default PortfolioSearchContext getSearchContext() {
        return new PortfolioSearchContext();
    }
    default List<PortfolioMember> getMembers(Portfolio et) {
        return new ArrayList<>();
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