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
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.filter.PortfolioSearchContext;
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.domain.Addon;

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
    boolean create(List<Portfolio> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default Portfolio createTemp(Portfolio et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default Portfolio createTempMajor(Portfolio et) {
        return et;
    }

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
    boolean update(List<Portfolio> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default Portfolio updateTemp(Portfolio et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default Portfolio updateTempMajor(Portfolio et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Portfolio().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Portfolio et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Portfolio> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Portfolio().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Portfolio> entities);

    /**
    * removeTemp
    * 
    * @param keys
    * @return
    */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
    * removeTempMajor
    * 
    * @param keys
    * @return
    */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
    * 获取
    * @param key
    * @return
    */
    default Portfolio get(String key) {
        return getSelf().get(new Portfolio().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Portfolio get(Portfolio et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Portfolio> get(Collection<String> keys) {
        List<Portfolio> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Portfolio().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Portfolio> get(List<Portfolio> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default Portfolio getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default Portfolio getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    Portfolio getDraft(Portfolio et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default Portfolio getDraftTemp(Portfolio et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default Portfolio getDraftTempMajor(Portfolio et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Portfolio et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Portfolio et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Portfolio> list);

    /**
    * deleteProjectSet
    * 
    * @param et
    * @return
    */
    default Portfolio deleteProjectSet(Portfolio et) {
        return et;
    }

    /**
    * favorite
    * 
    * @param et
    * @return
    */
    default Portfolio favorite(Portfolio et) {
        return et;
    }

    /**
    * portfolioIndexAddonCounter
    * 
    * @param et
    * @return
    */
    default Portfolio portfolioIndexAddonCounter(Portfolio et) {
        return et;
    }

    /**
    * recoverProjectSet
    * 
    * @param et
    * @return
    */
    default Portfolio recoverProjectSet(Portfolio et) {
        return et;
    }

    /**
    * removeFromProjectSet
    * 
    * @param et
    * @return
    */
    default Portfolio removeFromProjectSet(Portfolio et) {
        return et;
    }

    /**
    * resourceSetting
    * 
    * @param et
    * @return
    */
    default Portfolio resourceSetting(Portfolio et) {
        return et;
    }

    /**
    * unFavorite
    * 
    * @param et
    * @return
    */
    default Portfolio unFavorite(Portfolio et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchDefault(PortfolioSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Portfolio> listDefault(PortfolioSearchContext context);

    /**
    * fetchAdmin
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchAdmin(PortfolioSearchContext context);

    /**
    * listAdmin
    * 
    * @param context
    * @return
    */
    List<Portfolio> listAdmin(PortfolioSearchContext context);

    /**
    * fetchChooseProjectPortfolio
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchChooseProjectPortfolio(PortfolioSearchContext context);

    /**
    * listChooseProjectPortfolio
    * 
    * @param context
    * @return
    */
    List<Portfolio> listChooseProjectPortfolio(PortfolioSearchContext context);

    /**
    * fetchFavorite
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchFavorite(PortfolioSearchContext context);

    /**
    * listFavorite
    * 
    * @param context
    * @return
    */
    List<Portfolio> listFavorite(PortfolioSearchContext context);

    /**
    * fetchProjectSetDeleted
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchProjectSetDeleted(PortfolioSearchContext context);

    /**
    * listProjectSetDeleted
    * 
    * @param context
    * @return
    */
    List<Portfolio> listProjectSetDeleted(PortfolioSearchContext context);

    /**
    * fetchProjectSetGoing
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchProjectSetGoing(PortfolioSearchContext context);

    /**
    * listProjectSetGoing
    * 
    * @param context
    * @return
    */
    List<Portfolio> listProjectSetGoing(PortfolioSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchReader(PortfolioSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Portfolio> listReader(PortfolioSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchUser(PortfolioSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<Portfolio> listUser(PortfolioSearchContext context);

    /**
    * fetchWorkProjectPortfolio
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchWorkProjectPortfolio(PortfolioSearchContext context);

    /**
    * listWorkProjectPortfolio
    * 
    * @param context
    * @return
    */
    List<Portfolio> listWorkProjectPortfolio(PortfolioSearchContext context);

    default List<PortfolioMember> getMembers(Portfolio et) {
        return new ArrayList<>();
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Portfolio> fetchView(PortfolioSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Portfolio> listView(PortfolioSearchContext context);


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


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}