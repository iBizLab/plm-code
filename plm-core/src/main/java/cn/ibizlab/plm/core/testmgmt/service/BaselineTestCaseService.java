/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@MINHERIT}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.testmgmt.filter.BaselineTestCaseSearchContext;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 基线用例服务接口[BaselineTestCaseService]
 *
 * @author generator
 */
public interface BaselineTestCaseService extends IService<BaselineTestCase> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default BaselineTestCaseService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    BaselineTestCase get(BaselineTestCase et);
    /**
     * 获取
     * @param key
     * @return
     */
    default BaselineTestCase get(String key) {
        return getSelf().get(new BaselineTestCase().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<BaselineTestCase> getByIds(Collection<String> ids) {
        List<BaselineTestCase> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new BaselineTestCase().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<BaselineTestCase> getByEntities(List<BaselineTestCase> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    BaselineTestCase getDraft(BaselineTestCase et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(BaselineTestCase et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(BaselineTestCase et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<BaselineTestCase> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(BaselineTestCase et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<BaselineTestCase> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(BaselineTestCase et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<BaselineTestCase> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new BaselineTestCase().setId(key));
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
    boolean remove(BaselineTestCase et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<BaselineTestCase> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new BaselineTestCase().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<BaselineTestCase> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<BaselineTestCase> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            BaselineTestCase et=list.get(i);
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
    default BaselineTestCase shiftInBaseline(BaselineTestCase dto) {
        return dto;
    }

    /**
     * shift_out_baseline
     * 
     * @param dto
     * @return
     */
    default BaselineTestCase shiftOutBaseline(BaselineTestCase dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<BaselineTestCase> searchDefault(BaselineTestCaseSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<BaselineTestCase> listDefault(BaselineTestCaseSearchContext context);

    /**
     * searchfill_version_data
     * 
     * @param context
     * @return
     */
    Page<BaselineTestCase> searchFillVersionData(BaselineTestCaseSearchContext context);
    /**
     * listfill_version_data
     * 
     * @param context
     * @return
     */
    List<BaselineTestCase> listFillVersionData(BaselineTestCaseSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default BaselineTestCase getEntity() {
        return new BaselineTestCase();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default BaselineTestCaseSearchContext getSearchContext() {
        return new BaselineTestCaseSearchContext();
    }
    /**
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<BaselineTestCase> findByPrincipalId(List<String> principalIds);
    default List<BaselineTestCase> findByPrincipalId(String principalId) {
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
     * saveRelByBaselinePrincipalTestCase
     * @param baseline
     * @param list
     * @return
     */
    boolean saveByBaselinePrincipalTestCase(Baseline baseline,List<BaselineTestCase> list);
    /**
     * saveRelByPrincipalId
     * @param principalId
     * @param list
     * @return
     */
    default boolean saveByPrincipalId(String principalId,List<BaselineTestCase> list) {
        return getSelf().saveByBaselinePrincipalTestCase(new Baseline().setId(principalId),list);
    }

    /**
     * selectRelByTargetVersionId
     * @param targetVersionIds
     * @return
     */
    List<BaselineTestCase> findByTargetVersionId(List<String> targetVersionIds);
    default List<BaselineTestCase> findByTargetVersionId(String targetVersionId) {
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
    boolean saveByTargetVersion(Version version,List<BaselineTestCase> list);
    /**
     * saveRelByTargetVersionId
     * @param targetVersionId
     * @param list
     * @return
     */
    default boolean saveByTargetVersionId(String targetVersionId,List<BaselineTestCase> list) {
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