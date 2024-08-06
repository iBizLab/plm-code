/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@MINHERIT}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.wiki.filter.BaselinePageSearchContext;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 基线页面服务接口[BaselinePageService]
 *
 * @author generator
 */
public interface BaselinePageService extends IService<BaselinePage> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default BaselinePageService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(BaselinePage et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<BaselinePage> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(BaselinePage et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<BaselinePage> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new BaselinePage().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(BaselinePage et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<BaselinePage> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BaselinePage().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<BaselinePage> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default BaselinePage get(String key) {
        return getSelf().get(new BaselinePage().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    BaselinePage get(BaselinePage et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<BaselinePage> get(Collection<String> keys) {
        List<BaselinePage> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new BaselinePage().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<BaselinePage> get(List<BaselinePage> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    BaselinePage getDraft(BaselinePage et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(BaselinePage et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(BaselinePage et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<BaselinePage> list);

    /**
    * shiftInBaseline
    * 
    * @param et
    * @return
    */
    default BaselinePage shiftInBaseline(BaselinePage et) {
        return et;
    }

    /**
    * shiftOutBaseline
    * 
    * @param et
    * @return
    */
    default BaselinePage shiftOutBaseline(BaselinePage et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<BaselinePage> fetchDefault(BaselinePageSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<BaselinePage> listDefault(BaselinePageSearchContext context);

    /**
    * fetchFillVersionData
    * 
    * @param context
    * @return
    */
    Page<BaselinePage> fetchFillVersionData(BaselinePageSearchContext context);

    /**
    * listFillVersionData
    * 
    * @param context
    * @return
    */
    List<BaselinePage> listFillVersionData(BaselinePageSearchContext context);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<BaselinePage> findByPrincipalId(List<String> principalIds);
    default List<BaselinePage> findByPrincipalId(String principalId){
        return findByBaselinePrincipalPage(new Baseline().setId(principalId));
    }
	
    /**
    * findByBaselinePrincipalPage
    * @param baseline
    * @return
    */
    List<BaselinePage> findByBaselinePrincipalPage(Baseline baseline);	

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
    default boolean saveByPrincipalId(String principalId, List<BaselinePage> list){
        return getSelf().saveByBaselinePrincipalPage(new Baseline().setId(principalId),list);
    }

    /**
    * saveByBaselinePrincipalPage
    * @param baseline
    * @param list
    * @return
    */
    boolean saveByBaselinePrincipalPage(Baseline baseline, List<BaselinePage> list);

    /**
    * findByTargetVersionId
    * @param targetVersionIds
    * @return
    */
    List<BaselinePage> findByTargetVersionId(List<String> targetVersionIds);
    default List<BaselinePage> findByTargetVersionId(String targetVersionId){
        return findByTargetVersion(new Version().setId(targetVersionId));
    }
	
    /**
    * findByTargetVersion
    * @param version
    * @return
    */
    List<BaselinePage> findByTargetVersion(Version version);	

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
    default boolean saveByTargetVersionId(String targetVersionId, List<BaselinePage> list){
        return getSelf().saveByTargetVersion(new Version().setId(targetVersionId),list);
    }

    /**
    * saveByTargetVersion
    * @param version
    * @param list
    * @return
    */
    boolean saveByTargetVersion(Version version, List<BaselinePage> list);


    default ImportResult importData(String config, Boolean ignoreError, List<BaselinePage> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            BaselinePage et=list.get(i);
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
    default BaselinePage getEntity() {
        return new BaselinePage();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default BaselinePageSearchContext getSearchContext() {
        return new BaselinePageSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}