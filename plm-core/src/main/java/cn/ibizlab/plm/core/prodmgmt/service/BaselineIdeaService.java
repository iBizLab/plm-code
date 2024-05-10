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
     * 获取
     * @param et
     * @return
     */
    BaselineIdea get(BaselineIdea et);
    /**
     * 获取
     * @param key
     * @return
     */
    default BaselineIdea get(String key) {
        return getSelf().get(new BaselineIdea().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<BaselineIdea> getByIds(Collection<String> ids) {
        List<BaselineIdea> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new BaselineIdea().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<BaselineIdea> getByEntities(List<BaselineIdea> entities);

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
    Integer checkKey(BaselineIdea et);

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
    boolean createBatch(List<BaselineIdea> list);

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
    boolean updateBatch(List<BaselineIdea> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(BaselineIdea et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<BaselineIdea> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new BaselineIdea().setId(key));
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
    boolean remove(BaselineIdea et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<BaselineIdea> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new BaselineIdea().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<BaselineIdea> entities);

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
     * shift_in_baseline
     * 
     * @param dto
     * @return
     */
    default BaselineIdea shiftInBaseline(BaselineIdea dto) {
        return dto;
    }

    /**
     * shift_out_baseline
     * 
     * @param dto
     * @return
     */
    default BaselineIdea shiftOutBaseline(BaselineIdea dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<BaselineIdea> searchDefault(BaselineIdeaSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<BaselineIdea> listDefault(BaselineIdeaSearchContext context);

    /**
     * searchfill_version_data
     * 
     * @param context
     * @return
     */
    Page<BaselineIdea> searchFillVersionData(BaselineIdeaSearchContext context);
    /**
     * listfill_version_data
     * 
     * @param context
     * @return
     */
    List<BaselineIdea> listFillVersionData(BaselineIdeaSearchContext context);

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
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<BaselineIdea> findByPrincipalId(List<String> principalIds);
    default List<BaselineIdea> findByPrincipalId(String principalId) {
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
     * saveRelByBaselinePrincipalIdea
     * @param baseline
     * @param list
     * @return
     */
    boolean saveByBaselinePrincipalIdea(Baseline baseline,List<BaselineIdea> list);
    /**
     * saveRelByPrincipalId
     * @param principalId
     * @param list
     * @return
     */
    default boolean saveByPrincipalId(String principalId,List<BaselineIdea> list) {
        return getSelf().saveByBaselinePrincipalIdea(new Baseline().setId(principalId),list);
    }

    /**
     * selectRelByTargetVersionId
     * @param targetVersionIds
     * @return
     */
    List<BaselineIdea> findByTargetVersionId(List<String> targetVersionIds);
    default List<BaselineIdea> findByTargetVersionId(String targetVersionId) {
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
    boolean saveByTargetVersion(Version version,List<BaselineIdea> list);
    /**
     * saveRelByTargetVersionId
     * @param targetVersionId
     * @param list
     * @return
     */
    default boolean saveByTargetVersionId(String targetVersionId,List<BaselineIdea> list) {
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