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
     * 获取
     * @param et
     * @return
     */
    BaselineWorkItem get(BaselineWorkItem et);
    /**
     * 获取
     * @param key
     * @return
     */
    default BaselineWorkItem get(String key) {
        return getSelf().get(new BaselineWorkItem().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<BaselineWorkItem> getByIds(Collection<String> ids) {
        List<BaselineWorkItem> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new BaselineWorkItem().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<BaselineWorkItem> getByEntities(List<BaselineWorkItem> entities);

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
    Integer checkKey(BaselineWorkItem et);

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
    boolean createBatch(List<BaselineWorkItem> list);

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
    boolean updateBatch(List<BaselineWorkItem> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(BaselineWorkItem et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<BaselineWorkItem> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new BaselineWorkItem().setId(key));
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
    boolean remove(BaselineWorkItem et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<BaselineWorkItem> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new BaselineWorkItem().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<BaselineWorkItem> entities);

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
     * shift_in_baseline
     * 
     * @param dto
     * @return
     */
    default BaselineWorkItem shiftInBaseline(BaselineWorkItem dto) {
        return dto;
    }

    /**
     * shift_out_baseline
     * 
     * @param dto
     * @return
     */
    default BaselineWorkItem shiftOutBaseline(BaselineWorkItem dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<BaselineWorkItem> searchDefault(BaselineWorkItemSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<BaselineWorkItem> listDefault(BaselineWorkItemSearchContext context);

    /**
     * searchfill_version_data
     * 
     * @param context
     * @return
     */
    Page<BaselineWorkItem> searchFillVersionData(BaselineWorkItemSearchContext context);
    /**
     * listfill_version_data
     * 
     * @param context
     * @return
     */
    List<BaselineWorkItem> listFillVersionData(BaselineWorkItemSearchContext context);

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
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<BaselineWorkItem> findByPrincipalId(List<String> principalIds);
    default List<BaselineWorkItem> findByPrincipalId(String principalId) {
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
     * saveRelByPrincipalBaseline
     * @param baseline
     * @param list
     * @return
     */
    boolean saveByPrincipalBaseline(Baseline baseline,List<BaselineWorkItem> list);
    /**
     * saveRelByPrincipalId
     * @param principalId
     * @param list
     * @return
     */
    default boolean saveByPrincipalId(String principalId,List<BaselineWorkItem> list) {
        return getSelf().saveByPrincipalBaseline(new Baseline().setId(principalId),list);
    }

    /**
     * selectRelByTargetVersionId
     * @param targetVersionIds
     * @return
     */
    List<BaselineWorkItem> findByTargetVersionId(List<String> targetVersionIds);
    default List<BaselineWorkItem> findByTargetVersionId(String targetVersionId) {
        return findByTargetVersionId(Arrays.asList(targetVersionId));
    }
    /**
     * removeRelByTargetVersionId
     * @param targetVersionId
     * @return
     */
    boolean removeByTargetVersionId(String targetVersionId);
    /**
     * resetRelByTargetVersionId
     * @param targetVersionId
     * @return
     */
    boolean resetByTargetVersionId(String targetVersionId);
    /**
     * saveRelByTargetVersion
     * @param version
     * @param list
     * @return
     */
    boolean saveByTargetVersion(Version version,List<BaselineWorkItem> list);
    /**
     * saveRelByTargetVersionId
     * @param targetVersionId
     * @param list
     * @return
     */
    default boolean saveByTargetVersionId(String targetVersionId,List<BaselineWorkItem> list) {
        return getSelf().saveByTargetVersion(new Version().setId(targetVersionId),list);
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