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
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;

/**
 * 评审服务接口[ReviewService]
 *
 * @author generator
 */
public interface ReviewService extends IService<Review> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ReviewService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Review et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Review> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default Review createTemp(Review et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default Review createTempMajor(Review et) {
        return et;
    }

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Review et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Review> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default Review updateTemp(Review et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default Review updateTempMajor(Review et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Review().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Review et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Review> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Review().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Review> entities);

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
    default Review get(String key) {
        return getSelf().get(new Review().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Review get(Review et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Review> get(Collection<String> keys) {
        List<Review> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Review().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Review> get(List<Review> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default Review getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default Review getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    Review getDraft(Review et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default Review getDraftTemp(Review et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default Review getDraftTempMajor(Review et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(Review et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Review et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Review> list);

    /**
    * addReviewContent
    * 
    * @param et
    * @return
    */
    default Review addReviewContent(Review et) {
        return et;
    }

    /**
    * changeReviewStage
    * 
    * @param et
    * @return
    */
    default Review changeReviewStage(Review et) {
        return et;
    }

    /**
    * fillGuideline
    * 
    * @param et
    * @return
    */
    default Review fillGuideline(Review et) {
        return et;
    }

    /**
    * getAttention
    * 
    * @param key
    * @return
    */
    default Review getAttention(String key) {
        return null;
    }

    /**
    * repealReview
    * 
    * @param et
    * @return
    */
    default Review repealReview(Review et) {
        return et;
    }

    /**
    * submitReview
    * 
    * @param et
    * @return
    */
    default Review submitReview(Review et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Review> fetchDefault(ReviewSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Review> listDefault(ReviewSearchContext context);

    /**
    * fetchMyAttention
    * 
    * @param context
    * @return
    */
    Page<Review> fetchMyAttention(ReviewSearchContext context);

    /**
    * listMyAttention
    * 
    * @param context
    * @return
    */
    List<Review> listMyAttention(ReviewSearchContext context);

    /**
    * fetchMyReviewed
    * 
    * @param context
    * @return
    */
    Page<Review> fetchMyReviewed(ReviewSearchContext context);

    /**
    * listMyReviewed
    * 
    * @param context
    * @return
    */
    List<Review> listMyReviewed(ReviewSearchContext context);

    /**
    * findByGuidelineId
    * @param guidelineIds
    * @return
    */
    List<Review> findByGuidelineId(List<String> guidelineIds);
    default List<Review> findByGuidelineId(String guidelineId){
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
    default boolean saveByGuidelineId(String guidelineId, List<Review> list){
        return getSelf().saveByGuideline(new Guideline().setId(guidelineId),list);
    }

    /**
    * saveByGuideline
    * @param guideline
    * @param list
    * @return
    */
    boolean saveByGuideline(Guideline guideline, List<Review> list);

    /**
    * findByLibraryId
    * @param libraryIds
    * @return
    */
    List<Review> findByLibraryId(List<String> libraryIds);
    default List<Review> findByLibraryId(String libraryId){
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
    default boolean saveByLibraryId(String libraryId, List<Review> list){
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<Review> list);

    default List<Attention> getAttentions(Review et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(Review et) {
        return new ArrayList<>();
    }


    default ImportResult importData(String config, Boolean ignoreError, List<Review> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Review et=list.get(i);
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
    default Review getEntity() {
        return new Review();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ReviewSearchContext getSearchContext() {
        return new ReviewSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}