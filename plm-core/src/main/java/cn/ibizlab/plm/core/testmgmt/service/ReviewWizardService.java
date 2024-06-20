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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewWizardSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;

/**
 * 评审向导服务接口[ReviewWizardService]
 *
 * @author generator
 */
public interface ReviewWizardService extends IService<ReviewWizard> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ReviewWizardService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ReviewWizard et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ReviewWizard> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default ReviewWizard createTemp(ReviewWizard et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default ReviewWizard createTempMajor(ReviewWizard et) {
        return et;
    }

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ReviewWizard et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ReviewWizard> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default ReviewWizard updateTemp(ReviewWizard et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default ReviewWizard updateTempMajor(ReviewWizard et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ReviewWizard().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ReviewWizard et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ReviewWizard> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReviewWizard().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ReviewWizard> entities);

    /**
    * removeTemp
    * 
    * @param keys
    * @return
    */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
    * removeTempMajor
    * 
    * @param keys
    * @return
    */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
    * 获取
    * @param key
    * @return
    */
    default ReviewWizard get(String key) {
        return getSelf().get(new ReviewWizard().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ReviewWizard get(ReviewWizard et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ReviewWizard> get(Collection<String> keys) {
        List<ReviewWizard> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReviewWizard().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ReviewWizard> get(List<ReviewWizard> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default ReviewWizard getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default ReviewWizard getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    ReviewWizard getDraft(ReviewWizard et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default ReviewWizard getDraftTemp(ReviewWizard et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default ReviewWizard getDraftTempMajor(ReviewWizard et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(ReviewWizard et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ReviewWizard et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ReviewWizard> list);

    /**
    * fillGuideline
    * 
    * @param et
    * @return
    */
    default ReviewWizard fillGuideline(ReviewWizard et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ReviewWizard> fetchDefault(ReviewWizardSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ReviewWizard> listDefault(ReviewWizardSearchContext context);

    /**
    * findByGuidelineId
    * @param guidelineIds
    * @return
    */
    List<ReviewWizard> findByGuidelineId(List<String> guidelineIds);
    default List<ReviewWizard> findByGuidelineId(String guidelineId){
        return findByGuidelineId(Arrays.asList(guidelineId));
    }

    /**
    * removeByGuidelineId
    * @param guidelineId
    * @return
    */
    boolean removeByGuidelineId(String guidelineId);

    /**
    * resetByGuidelineId
    * @param guidelineId
    * @return
    */
    boolean resetByGuidelineId(String guidelineId);

    /**
    * saveByGuidelineId
    * @param guidelineId
    * @param list
    * @return
    */
    default boolean saveByGuidelineId(String guidelineId, List<ReviewWizard> list){
        return getSelf().saveByGuideline(new Guideline().setId(guidelineId),list);
    }

    /**
    * saveByGuideline
    * @param guideline
    * @param list
    * @return
    */
    boolean saveByGuideline(Guideline guideline, List<ReviewWizard> list);

    /**
    * findByLibraryId
    * @param libraryIds
    * @return
    */
    List<ReviewWizard> findByLibraryId(List<String> libraryIds);
    default List<ReviewWizard> findByLibraryId(String libraryId){
        return findByLibraryId(Arrays.asList(libraryId));
    }

    /**
    * removeByLibraryId
    * @param libraryId
    * @return
    */
    boolean removeByLibraryId(String libraryId);

    /**
    * resetByLibraryId
    * @param libraryId
    * @return
    */
    boolean resetByLibraryId(String libraryId);

    /**
    * saveByLibraryId
    * @param libraryId
    * @param list
    * @return
    */
    default boolean saveByLibraryId(String libraryId, List<ReviewWizard> list){
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<ReviewWizard> list);

    default List<ReviewContent> getContents(ReviewWizard et) {
        return new ArrayList<>();
    }


    default ImportResult importData(String config, Boolean ignoreError, List<ReviewWizard> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ReviewWizard et=list.get(i);
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
    default ReviewWizard getEntity() {
        return new ReviewWizard();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ReviewWizardSearchContext getSearchContext() {
        return new ReviewWizardSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}