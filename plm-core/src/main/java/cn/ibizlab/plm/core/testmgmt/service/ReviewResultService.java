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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewResultSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 评审结果服务接口[ReviewResultService]
 *
 * @author generator
 */
public interface ReviewResultService extends IService<ReviewResult> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ReviewResultService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ReviewResult et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ReviewResult> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ReviewResult et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ReviewResult> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ReviewResult().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ReviewResult et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ReviewResult> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReviewResult().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ReviewResult> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ReviewResult get(String key) {
        return getSelf().get(new ReviewResult().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ReviewResult get(ReviewResult et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ReviewResult> get(Collection<String> keys) {
        List<ReviewResult> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReviewResult().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ReviewResult> get(List<ReviewResult> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ReviewResult getDraft(ReviewResult et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(ReviewResult et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ReviewResult et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ReviewResult> list);

    /**
    * setResult
    * 
    * @param et
    * @return
    */
    default ReviewResult setResult(ReviewResult et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ReviewResult> fetchDefault(ReviewResultSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ReviewResult> listDefault(ReviewResultSearchContext context);

    /**
    * findByContentId
    * @param contentIds
    * @return
    */
    List<ReviewResult> findByContentId(List<String> contentIds);
    default List<ReviewResult> findByContentId(String contentId){
        return findByReviewContentExtend(new ReviewContentExtend().setId(contentId));
    }

    /**
    * findByReviewContentExtend
    * @param reviewContentExtend
    * @return
    */
    List<ReviewResult> findByReviewContentExtend(ReviewContentExtend reviewContentExtend);

    /**
    * removeByContentId
    * @param contentId
    * @return
    */
    boolean removeByContentId(String contentId);

    /**
    * resetByContentId
    * @param contentId
    * @return
    */
    boolean resetByContentId(String contentId);

    /**
    * saveByContentId
    * @param contentId
    * @param list
    * @return
    */
    default boolean saveByContentId(String contentId, List<ReviewResult> list){
        return getSelf().saveByReviewContentExtend(new ReviewContentExtend().setId(contentId),list);
    }

    /**
    * saveByReviewContentExtend
    * @param reviewContentExtend
    * @param list
    * @return
    */
    boolean saveByReviewContentExtend(ReviewContentExtend reviewContentExtend, List<ReviewResult> list);

    /**
    * findByReviewContent
    * @param reviewContent
    * @return
    */
    List<ReviewResult> findByReviewContent(ReviewContent reviewContent);

    /**
    * saveByReviewContent
    * @param reviewContent
    * @param list
    * @return
    */
    boolean saveByReviewContent(ReviewContent reviewContent, List<ReviewResult> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ReviewResult> fetchView(ReviewResultSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ReviewResult> listView(ReviewResultSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<ReviewResult> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ReviewResult et=list.get(i);
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
    default ReviewResult getEntity() {
        return new ReviewResult();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ReviewResultSearchContext getSearchContext() {
        return new ReviewResultSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}