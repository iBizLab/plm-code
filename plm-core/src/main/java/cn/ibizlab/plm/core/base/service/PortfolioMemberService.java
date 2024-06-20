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
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.base.filter.PortfolioMemberSearchContext;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 文件夹成员服务接口[PortfolioMemberService]
 *
 * @author generator
 */
public interface PortfolioMemberService extends IService<PortfolioMember> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default PortfolioMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(PortfolioMember et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<PortfolioMember> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(PortfolioMember et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<PortfolioMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new PortfolioMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(PortfolioMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<PortfolioMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new PortfolioMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<PortfolioMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default PortfolioMember get(String key) {
        return getSelf().get(new PortfolioMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    PortfolioMember get(PortfolioMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<PortfolioMember> get(Collection<String> keys) {
        List<PortfolioMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new PortfolioMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<PortfolioMember> get(List<PortfolioMember> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    PortfolioMember getDraft(PortfolioMember et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(PortfolioMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(PortfolioMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<PortfolioMember> list);

    /**
    * changeRole
    * 
    * @param et
    * @return
    */
    default PortfolioMember changeRole(PortfolioMember et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default PortfolioMember nothing(PortfolioMember et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<PortfolioMember> fetchDefault(PortfolioMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<PortfolioMember> listDefault(PortfolioMemberSearchContext context);

    /**
    * fetchCurProjectSet
    * 
    * @param context
    * @return
    */
    Page<PortfolioMember> fetchCurProjectSet(PortfolioMemberSearchContext context);

    /**
    * listCurProjectSet
    * 
    * @param context
    * @return
    */
    List<PortfolioMember> listCurProjectSet(PortfolioMemberSearchContext context);

    /**
    * findByPortfolioId
    * @param portfolioIds
    * @return
    */
    List<PortfolioMember> findByPortfolioId(List<String> portfolioIds);
    default List<PortfolioMember> findByPortfolioId(String portfolioId){
        return findByPortfolioId(Arrays.asList(portfolioId));
    }

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
    default boolean saveByPortfolioId(String portfolioId, List<PortfolioMember> list){
        return getSelf().saveByPortfolio(new Portfolio().setId(portfolioId),list);
    }

    /**
    * saveByPortfolio
    * @param portfolio
    * @param list
    * @return
    */
    boolean saveByPortfolio(Portfolio portfolio, List<PortfolioMember> list);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<PortfolioMember> findByUserId(List<String> userIds);
    default List<PortfolioMember> findByUserId(String userId){
        return findByUserId(Arrays.asList(userId));
    }

    /**
    * removeByUserId
    * @param userId
    * @return
    */
    boolean removeByUserId(String userId);

    /**
    * resetByUserId
    * @param userId
    * @return
    */
    boolean resetByUserId(String userId);

    /**
    * saveByUserId
    * @param userId
    * @param list
    * @return
    */
    default boolean saveByUserId(String userId, List<PortfolioMember> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<PortfolioMember> list);


    default ImportResult importData(String config, Boolean ignoreError, List<PortfolioMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            PortfolioMember et=list.get(i);
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
    default PortfolioMember getEntity() {
        return new PortfolioMember();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default PortfolioMemberSearchContext getSearchContext() {
        return new PortfolioMemberSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}