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
import cn.ibizlab.util.enums.CheckKeyStatus;
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
    boolean create(List<BaselineTestCase> list);

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
    boolean update(List<BaselineTestCase> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new BaselineTestCase().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(BaselineTestCase et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<BaselineTestCase> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BaselineTestCase().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<BaselineTestCase> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default BaselineTestCase get(String key) {
        return getSelf().get(new BaselineTestCase().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    BaselineTestCase get(BaselineTestCase et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<BaselineTestCase> get(Collection<String> keys) {
        List<BaselineTestCase> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BaselineTestCase().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<BaselineTestCase> get(List<BaselineTestCase> entities);

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
    CheckKeyStatus checkKey(BaselineTestCase et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(BaselineTestCase et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<BaselineTestCase> list);

    /**
    * shiftInBaseline
    * 
    * @param et
    * @return
    */
    default BaselineTestCase shiftInBaseline(BaselineTestCase et) {
        return et;
    }

    /**
    * shiftOutBaseline
    * 
    * @param et
    * @return
    */
    default BaselineTestCase shiftOutBaseline(BaselineTestCase et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<BaselineTestCase> fetchDefault(BaselineTestCaseSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<BaselineTestCase> listDefault(BaselineTestCaseSearchContext context);

    /**
    * fetchBaselineRelationVersion
    * 
    * @param context
    * @return
    */
    Page<BaselineTestCase> fetchBaselineRelationVersion(BaselineTestCaseSearchContext context);

    /**
    * listBaselineRelationVersion
    * 
    * @param context
    * @return
    */
    List<BaselineTestCase> listBaselineRelationVersion(BaselineTestCaseSearchContext context);

    /**
    * fetchFillVersionData
    * 
    * @param context
    * @return
    */
    Page<BaselineTestCase> fetchFillVersionData(BaselineTestCaseSearchContext context);

    /**
    * listFillVersionData
    * 
    * @param context
    * @return
    */
    List<BaselineTestCase> listFillVersionData(BaselineTestCaseSearchContext context);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<BaselineTestCase> findByPrincipalId(List<String> principalIds);
    default List<BaselineTestCase> findByPrincipalId(String principalId){
        return findByBaselinePrincipalTestCase(new Baseline().setId(principalId));
    }
	
    /**
    * findByBaselinePrincipalTestCase
    * @param baseline
    * @return
    */
    List<BaselineTestCase> findByBaselinePrincipalTestCase(Baseline baseline);	

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
    default boolean saveByPrincipalId(String principalId, List<BaselineTestCase> list){
        return getSelf().saveByBaselinePrincipalTestCase(new Baseline().setId(principalId),list);
    }

    /**
    * saveByBaselinePrincipalTestCase
    * @param baseline
    * @param list
    * @return
    */
    boolean saveByBaselinePrincipalTestCase(Baseline baseline, List<BaselineTestCase> list);

    /**
    * findByTargetVersionId
    * @param targetVersionIds
    * @return
    */
    List<BaselineTestCase> findByTargetVersionId(List<String> targetVersionIds);
    default List<BaselineTestCase> findByTargetVersionId(String targetVersionId){
        return findByTargetVersion(new Version().setId(targetVersionId));
    }
	
    /**
    * findByTargetVersion
    * @param version
    * @return
    */
    List<BaselineTestCase> findByTargetVersion(Version version);	

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
    default boolean saveByTargetVersionId(String targetVersionId, List<BaselineTestCase> list){
        return getSelf().saveByTargetVersion(new Version().setId(targetVersionId),list);
    }

    /**
    * saveByTargetVersion
    * @param version
    * @param list
    * @return
    */
    boolean saveByTargetVersion(Version version, List<BaselineTestCase> list);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}