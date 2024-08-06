/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.filter.GuidelineSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewActionRule;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewRule;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewStage;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;

/**
 * 流程准则服务接口[GuidelineService]
 *
 * @author generator
 */
public interface GuidelineService extends IService<Guideline> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default GuidelineService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Guideline et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Guideline> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Guideline et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Guideline> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Guideline().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Guideline et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Guideline> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Guideline().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Guideline> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Guideline get(String key) {
        return getSelf().get(new Guideline().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Guideline get(Guideline et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Guideline> get(Collection<String> keys) {
        List<Guideline> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Guideline().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Guideline> get(List<Guideline> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Guideline getDraft(Guideline et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Guideline et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Guideline et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Guideline> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Guideline> fetchDefault(GuidelineSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Guideline> listDefault(GuidelineSearchContext context);

    /**
    * fetchBase
    * 
    * @param context
    * @return
    */
    Page<Guideline> fetchBase(GuidelineSearchContext context);

    /**
    * listBase
    * 
    * @param context
    * @return
    */
    List<Guideline> listBase(GuidelineSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<Guideline> fetchNormal(GuidelineSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<Guideline> listNormal(GuidelineSearchContext context);

    /**
    * fetchUnderLibrary
    * 
    * @param context
    * @return
    */
    Page<Guideline> fetchUnderLibrary(GuidelineSearchContext context);

    /**
    * listUnderLibrary
    * 
    * @param context
    * @return
    */
    List<Guideline> listUnderLibrary(GuidelineSearchContext context);

    /**
    * findByScopeId
    * @param scopeIds
    * @return
    */
    List<Guideline> findByScopeId(List<String> scopeIds);
    default List<Guideline> findByScopeId(String scopeId){
        return findByLibrary(new Library().setId(scopeId));
    }

    /**
    * findByLibrary
    * @param library
    * @return
    */
    List<Guideline> findByLibrary(Library library);

    /**
    * removeByScopeId
    * @param scopeId
    * @return
    */
    boolean removeByScopeId(String scopeId);

    /**
    * resetByScopeId
    * @param scopeId
    * @return
    */
    boolean resetByScopeId(String scopeId);

    /**
    * saveByScopeId
    * @param scopeId
    * @param list
    * @return
    */
    default boolean saveByScopeId(String scopeId, List<Guideline> list){
        return getSelf().saveByLibrary(new Library().setId(scopeId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<Guideline> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Guideline> fetchView(GuidelineSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Guideline> listView(GuidelineSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Guideline> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Guideline et=list.get(i);
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
    default Guideline getEntity() {
        return new Guideline();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default GuidelineSearchContext getSearchContext() {
        return new GuidelineSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}