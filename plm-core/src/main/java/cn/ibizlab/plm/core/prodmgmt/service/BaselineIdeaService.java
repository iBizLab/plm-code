/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@MINHERIT}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.prodmgmt.filter.BaselineIdeaSearchContext;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 基线需求服务接口[BaselineIdeaService]
 *
 * @author generator
 */
public interface BaselineIdeaService extends IService<BaselineIdea> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default BaselineIdeaService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(BaselineIdea et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<BaselineIdea> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(BaselineIdea et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<BaselineIdea> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new BaselineIdea().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(BaselineIdea et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<BaselineIdea> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BaselineIdea().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<BaselineIdea> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default BaselineIdea get(String key) {
        return getSelf().get(new BaselineIdea().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    BaselineIdea get(BaselineIdea et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<BaselineIdea> get(Collection<String> keys) {
        List<BaselineIdea> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BaselineIdea().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<BaselineIdea> get(List<BaselineIdea> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    BaselineIdea getDraft(BaselineIdea et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(BaselineIdea et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(BaselineIdea et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<BaselineIdea> list);

    /**
    * shiftInBaseline
    * 
    * @param et
    * @return
    */
    default BaselineIdea shiftInBaseline(BaselineIdea et) {
        return et;
    }

    /**
    * shiftOutBaseline
    * 
    * @param et
    * @return
    */
    default BaselineIdea shiftOutBaseline(BaselineIdea et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<BaselineIdea> fetchDefault(BaselineIdeaSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<BaselineIdea> listDefault(BaselineIdeaSearchContext context);

    /**
    * fetchBaselineRelationVersion
    * 
    * @param context
    * @return
    */
    Page<BaselineIdea> fetchBaselineRelationVersion(BaselineIdeaSearchContext context);

    /**
    * listBaselineRelationVersion
    * 
    * @param context
    * @return
    */
    List<BaselineIdea> listBaselineRelationVersion(BaselineIdeaSearchContext context);

    /**
    * fetchFillVersionData
    * 
    * @param context
    * @return
    */
    Page<BaselineIdea> fetchFillVersionData(BaselineIdeaSearchContext context);

    /**
    * listFillVersionData
    * 
    * @param context
    * @return
    */
    List<BaselineIdea> listFillVersionData(BaselineIdeaSearchContext context);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<BaselineIdea> findByPrincipalId(List<String> principalIds);
    default List<BaselineIdea> findByPrincipalId(String principalId){
        return findByBaselinePrincipalIdea(new Baseline().setId(principalId));
    }
	
    /**
    * findByBaselinePrincipalIdea
    * @param baseline
    * @return
    */
    List<BaselineIdea> findByBaselinePrincipalIdea(Baseline baseline);	

    /**
    * removeByPrincipalId
    * @param principalId
    * @return
    */
    boolean removeByPrincipalId(String principalId);

    /**
    * resetByPrincipalId
    * @param principalId
    * @return
    */
    boolean resetByPrincipalId(String principalId);

    /**
    * saveByPrincipalId
    * @param principalId
    * @param list
    * @return
    */
    default boolean saveByPrincipalId(String principalId, List<BaselineIdea> list){
        return getSelf().saveByBaselinePrincipalIdea(new Baseline().setId(principalId),list);
    }

    /**
    * saveByBaselinePrincipalIdea
    * @param baseline
    * @param list
    * @return
    */
    boolean saveByBaselinePrincipalIdea(Baseline baseline, List<BaselineIdea> list);

    /**
    * findByTargetVersionId
    * @param targetVersionIds
    * @return
    */
    List<BaselineIdea> findByTargetVersionId(List<String> targetVersionIds);
    default List<BaselineIdea> findByTargetVersionId(String targetVersionId){
        return findByTargetVersion(new Version().setId(targetVersionId));
    }
	
    /**
    * findByTargetVersion
    * @param version
    * @return
    */
    List<BaselineIdea> findByTargetVersion(Version version);	

    /**
    * removeByTargetVersionId
    * @param targetVersionId
    * @return
    */
    boolean removeByTargetVersionId(String targetVersionId);

    /**
    * resetByTargetVersionId
    * @param targetVersionId
    * @return
    */
    boolean resetByTargetVersionId(String targetVersionId);

    /**
    * saveByTargetVersionId
    * @param targetVersionId
    * @param list
    * @return
    */
    default boolean saveByTargetVersionId(String targetVersionId, List<BaselineIdea> list){
        return getSelf().saveByTargetVersion(new Version().setId(targetVersionId),list);
    }

    /**
    * saveByTargetVersion
    * @param version
    * @param list
    * @return
    */
    boolean saveByTargetVersion(Version version, List<BaselineIdea> list);


    default ImportResult importData(String config, Boolean ignoreError, List<BaselineIdea> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            BaselineIdea et=list.get(i);
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
    default BaselineIdea getEntity() {
        return new BaselineIdea();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default BaselineIdeaSearchContext getSearchContext() {
        return new BaselineIdeaSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}