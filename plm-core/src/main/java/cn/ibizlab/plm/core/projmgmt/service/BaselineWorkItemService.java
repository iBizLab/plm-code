/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@MINHERIT}}Service.java.hbs
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
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.projmgmt.filter.BaselineWorkItemSearchContext;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 基线工作项服务接口[BaselineWorkItemService]
 *
 * @author generator
 */
public interface BaselineWorkItemService extends IService<BaselineWorkItem> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default BaselineWorkItemService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(BaselineWorkItem et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<BaselineWorkItem> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(BaselineWorkItem et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<BaselineWorkItem> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new BaselineWorkItem().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(BaselineWorkItem et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<BaselineWorkItem> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BaselineWorkItem().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<BaselineWorkItem> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default BaselineWorkItem get(String key) {
        return getSelf().get(new BaselineWorkItem().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    BaselineWorkItem get(BaselineWorkItem et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<BaselineWorkItem> get(Collection<String> keys) {
        List<BaselineWorkItem> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BaselineWorkItem().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<BaselineWorkItem> get(List<BaselineWorkItem> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    BaselineWorkItem getDraft(BaselineWorkItem et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(BaselineWorkItem et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(BaselineWorkItem et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<BaselineWorkItem> list);

    /**
    * shiftInBaseline
    * 
    * @param et
    * @return
    */
    default BaselineWorkItem shiftInBaseline(BaselineWorkItem et) {
        return et;
    }

    /**
    * shiftOutBaseline
    * 
    * @param et
    * @return
    */
    default BaselineWorkItem shiftOutBaseline(BaselineWorkItem et) {
        return et;
    }

    /**
    * snapshotSetBaseline
    * 
    * @param et
    * @return
    */
    default BaselineWorkItem snapshotSetBaseline(BaselineWorkItem et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<BaselineWorkItem> fetchDefault(BaselineWorkItemSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<BaselineWorkItem> listDefault(BaselineWorkItemSearchContext context);

    /**
    * fetchBaselineRelationVersion
    * 
    * @param context
    * @return
    */
    Page<BaselineWorkItem> fetchBaselineRelationVersion(BaselineWorkItemSearchContext context);

    /**
    * listBaselineRelationVersion
    * 
    * @param context
    * @return
    */
    List<BaselineWorkItem> listBaselineRelationVersion(BaselineWorkItemSearchContext context);

    /**
    * fetchFillVersionData
    * 
    * @param context
    * @return
    */
    Page<BaselineWorkItem> fetchFillVersionData(BaselineWorkItemSearchContext context);

    /**
    * listFillVersionData
    * 
    * @param context
    * @return
    */
    List<BaselineWorkItem> listFillVersionData(BaselineWorkItemSearchContext context);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<BaselineWorkItem> findByPrincipalId(List<String> principalIds);
    default List<BaselineWorkItem> findByPrincipalId(String principalId){
        return findByPrincipalBaseline(new Baseline().setId(principalId));
    }
	
    /**
    * findByPrincipalBaseline
    * @param baseline
    * @return
    */
    List<BaselineWorkItem> findByPrincipalBaseline(Baseline baseline);	

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
    default boolean saveByPrincipalId(String principalId, List<BaselineWorkItem> list){
        return getSelf().saveByPrincipalBaseline(new Baseline().setId(principalId),list);
    }

    /**
    * saveByPrincipalBaseline
    * @param baseline
    * @param list
    * @return
    */
    boolean saveByPrincipalBaseline(Baseline baseline, List<BaselineWorkItem> list);

    /**
    * findByTargetVersionId
    * @param targetVersionIds
    * @return
    */
    List<BaselineWorkItem> findByTargetVersionId(List<String> targetVersionIds);
    default List<BaselineWorkItem> findByTargetVersionId(String targetVersionId){
        return findByTargetVersion(new Version().setId(targetVersionId));
    }
	
    /**
    * findByTargetVersion
    * @param version
    * @return
    */
    List<BaselineWorkItem> findByTargetVersion(Version version);	

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
    default boolean saveByTargetVersionId(String targetVersionId, List<BaselineWorkItem> list){
        return getSelf().saveByTargetVersion(new Version().setId(targetVersionId),list);
    }

    /**
    * saveByTargetVersion
    * @param version
    * @param list
    * @return
    */
    boolean saveByTargetVersion(Version version, List<BaselineWorkItem> list);


    default ImportResult importData(String config, Boolean ignoreError, List<BaselineWorkItem> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            BaselineWorkItem et=list.get(i);
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
    default BaselineWorkItem getEntity() {
        return new BaselineWorkItem();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default BaselineWorkItemSearchContext getSearchContext() {
        return new BaselineWorkItemSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}