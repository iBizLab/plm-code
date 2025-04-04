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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewContentSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;

/**
 * 评审内容服务接口[ReviewContentService]
 *
 * @author generator
 */
public interface ReviewContentService extends IService<ReviewContent> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ReviewContentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ReviewContent et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ReviewContent> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ReviewContent et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ReviewContent> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ReviewContent().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ReviewContent et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ReviewContent> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReviewContent().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ReviewContent> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ReviewContent get(String key) {
        return getSelf().get(new ReviewContent().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ReviewContent get(ReviewContent et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ReviewContent> get(Collection<String> keys) {
        List<ReviewContent> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReviewContent().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ReviewContent> get(List<ReviewContent> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ReviewContent getDraft(ReviewContent et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(ReviewContent et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ReviewContent et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ReviewContent> list);

    /**
    * addReviewContent
    * 
    * @param et
    * @return
    */
    default ReviewContent addReviewContent(ReviewContent et) {
        return et;
    }

    /**
    * completeReview
    * 
    * @param et
    * @return
    */
    default ReviewContent completeReview(ReviewContent et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default ReviewContent nothing(ReviewContent et) {
        return et;
    }

    /**
    * programTestCase
    * 
    * @param et
    * @return
    */
    default ReviewContent programTestCase(ReviewContent et) {
        return et;
    }

    /**
    * reviewContentTotal
    * 
    * @param et
    * @return
    */
    default ReviewContent reviewContentTotal(ReviewContent et) {
        return et;
    }

    /**
    * setReviewResult
    * 
    * @param et
    * @return
    */
    default ReviewContent setReviewResult(ReviewContent et) {
        return et;
    }

    /**
    * setReviewResultAll
    * 
    * @param et
    * @return
    */
    default ReviewContent setReviewResultAll(ReviewContent et) {
        return et;
    }

    /**
    * startReview
    * 
    * @param et
    * @return
    */
    default ReviewContent startReview(ReviewContent et) {
        return et;
    }

    /**
    * submitReview
    * 
    * @param et
    * @return
    */
    default ReviewContent submitReview(ReviewContent et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ReviewContent> fetchDefault(ReviewContentSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ReviewContent> listDefault(ReviewContentSearchContext context);

    /**
    * fetchAll
    * 
    * @param context
    * @return
    */
    Page<ReviewContent> fetchAll(ReviewContentSearchContext context);

    /**
    * listAll
    * 
    * @param context
    * @return
    */
    List<ReviewContent> listAll(ReviewContentSearchContext context);

    /**
    * fetchHistoryList
    * 
    * @param context
    * @return
    */
    Page<ReviewContent> fetchHistoryList(ReviewContentSearchContext context);

    /**
    * listHistoryList
    * 
    * @param context
    * @return
    */
    List<ReviewContent> listHistoryList(ReviewContentSearchContext context);

    /**
    * findByPrincipalId
    * @param principalIds
    * @return
    */
    List<ReviewContent> findByPrincipalId(List<String> principalIds);
    default List<ReviewContent> findByPrincipalId(String principalId){
        return findByReview(new Review().setId(principalId));
    }
	
    /**
    * findByReview
    * @param review
    * @return
    */
    List<ReviewContent> findByReview(Review review);	

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
    default boolean saveByPrincipalId(String principalId, List<ReviewContent> list){
        return getSelf().saveByReview(new Review().setId(principalId),list);
    }

    /**
    * saveByReview
    * @param review
    * @param list
    * @return
    */
    boolean saveByReview(Review review, List<ReviewContent> list);

    /**
    * findByReviewWizard
    * @param reviewWizard
    * @return
    */
    List<ReviewContent> findByReviewWizard(ReviewWizard reviewWizard);	

    /**
    * saveByReviewWizard
    * @param reviewWizard
    * @param list
    * @return
    */
    boolean saveByReviewWizard(ReviewWizard reviewWizard, List<ReviewContent> list);

    /**
    * findByTargetVersionId
    * @param targetVersionIds
    * @return
    */
    List<ReviewContent> findByTargetVersionId(List<String> targetVersionIds);
    default List<ReviewContent> findByTargetVersionId(String targetVersionId){
        return findByTargetVersion(new Version().setId(targetVersionId));
    }
	
    /**
    * findByTargetVersion
    * @param version
    * @return
    */
    List<ReviewContent> findByTargetVersion(Version version);	

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
    default boolean saveByTargetVersionId(String targetVersionId, List<ReviewContent> list){
        return getSelf().saveByTargetVersion(new Version().setId(targetVersionId),list);
    }

    /**
    * saveByTargetVersion
    * @param version
    * @param list
    * @return
    */
    boolean saveByTargetVersion(Version version, List<ReviewContent> list);

    /**
    * findByTargetId
    * @param targetIds
    * @return
    */
    List<ReviewContent> findByTargetId(List<String> targetIds);
    default List<ReviewContent> findByTargetId(String targetId){
        return findByTestCase(new TestCase().setId(targetId));
    }
	
    /**
    * findByTestCase
    * @param testCase
    * @return
    */
    List<ReviewContent> findByTestCase(TestCase testCase);	

    /**
    * removeByTargetId
    * @param targetId
    * @return
    */
    boolean removeByTargetId(String targetId);

    /**
    * resetByTargetId
    * @param targetId
    * @return
    */
    boolean resetByTargetId(String targetId);

    /**
    * saveByTargetId
    * @param targetId
    * @param list
    * @return
    */
    default boolean saveByTargetId(String targetId, List<ReviewContent> list){
        return getSelf().saveByTestCase(new TestCase().setId(targetId),list);
    }

    /**
    * saveByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase, List<ReviewContent> list);


    default ImportResult importData(String config, Boolean ignoreError, List<ReviewContent> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ReviewContent et=list.get(i);
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
    default ReviewContent getEntity() {
        return new ReviewContent();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ReviewContentSearchContext getSearchContext() {
        return new ReviewContentSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}