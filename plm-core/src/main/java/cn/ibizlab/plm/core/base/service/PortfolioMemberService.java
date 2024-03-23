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
     * 获取
     * @param et
     * @return
     */
    PortfolioMember get(PortfolioMember et);
    /**
     * 获取
     * @param key
     * @return
     */
    default PortfolioMember get(String key) {
        return getSelf().get(new PortfolioMember().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<PortfolioMember> getByIds(Collection<String> ids) {
        List<PortfolioMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new PortfolioMember().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<PortfolioMember> getByEntities(List<PortfolioMember> entities);

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
    boolean createBatch(List<PortfolioMember> list);

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
    boolean updateBatch(List<PortfolioMember> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(PortfolioMember et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<PortfolioMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new PortfolioMember().setId(key));
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
    boolean remove(PortfolioMember et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<PortfolioMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new PortfolioMember().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<PortfolioMember> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<PortfolioMember> searchDefault(PortfolioMemberSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<PortfolioMember> listDefault(PortfolioMemberSearchContext context);

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
     * selectRelByPortfolioId
     * @param portfolioIds
     * @return
     */
    List<PortfolioMember> findByPortfolioId(List<String> portfolioIds);
    default List<PortfolioMember> findByPortfolioId(String portfolioId) {
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
    default boolean saveByPortfolioId(String portfolioId,List<PortfolioMember> list) {
        return getSelf().saveByPortfolio(new Portfolio().setId(portfolioId),list);
    }
    /**
    * saveRelByPortfolio
    * @param portfolio
    * @param list
    * @return
    */
    boolean saveByPortfolio(Portfolio portfolio,List<PortfolioMember> list);

    /**
     * selectRelByUserId
     * @param userIds
     * @return
     */
    List<PortfolioMember> findByUserId(List<String> userIds);
    default List<PortfolioMember> findByUserId(String userId) {
        return findByUserId(Arrays.asList(userId));
    }
    /**
     * removeRelByUserId
     * @param userId
     * @return
     */
    boolean removeByUserId(String userId);
    /**
     * resetRelByUserId
     * @param userId
     * @return
     */
    boolean resetByUserId(String userId);
    /**
     * saveRelByUserId
     * @param userId
     * @param list
     * @return
     */
    default boolean saveByUserId(String userId,List<PortfolioMember> list) {
        return getSelf().saveByUser(new User().setId(userId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<PortfolioMember> list);


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