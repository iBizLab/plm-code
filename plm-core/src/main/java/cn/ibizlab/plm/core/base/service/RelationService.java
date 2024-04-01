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
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.filter.RelationSearchContext;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;

/**
 * 关联服务接口[RelationService]
 *
 * @author generator
 */
public interface RelationService extends IService<Relation> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default RelationService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Relation get(Relation et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Relation get(String key) {
        return getSelf().get(new Relation().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Relation> getByIds(Collection<String> ids) {
        List<Relation> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Relation().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Relation> getByEntities(List<Relation> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Relation getDraft(Relation et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Relation et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Relation et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Relation> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Relation et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Relation> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Relation et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Relation> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Relation().setId(key));
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
    boolean remove(Relation et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Relation> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Relation().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Relation> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Relation> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Relation et=list.get(i);
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
    Page<Relation> searchDefault(RelationSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Relation> listDefault(RelationSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Relation getEntity() {
        return new Relation();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default RelationSearchContext getSearchContext() {
        return new RelationSearchContext();
    }
    /**
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<Relation> findByPrincipalId(List<String> principalIds);
    default List<Relation> findByPrincipalId(String principalId) {
        return findByPrincipalId(Arrays.asList(principalId));
    }
    /**
     * removeRelByPrincipalId
     * @param principalId
     * @return
     */
    boolean removeByPrincipalId(String principalId);
    /**
     * resetRelByPrincipalId
     * @param principalId
     * @return
     */
    boolean resetByPrincipalId(String principalId);
    /**
     * saveRelByPrincipalId
     * @param principalId
     * @param list
     * @return
     */
    default boolean saveByPrincipalId(String principalId,List<Relation> list) {
        return getSelf().saveByBaseline(new Baseline().setId(principalId),list);
    }
    /**
    * saveRelByBaseline
    * @param baseline
    * @param list
    * @return
    */
    boolean saveByBaseline(Baseline baseline,List<Relation> list);

    /**
    * saveRelByReview
    * @param review
    * @param list
    * @return
    */
    boolean saveByReview(Review review,List<Relation> list);

    /**
    * saveRelByTestPlan
    * @param testPlan
    * @param list
    * @return
    */
    boolean saveByTestPlan(TestPlan testPlan,List<Relation> list);


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