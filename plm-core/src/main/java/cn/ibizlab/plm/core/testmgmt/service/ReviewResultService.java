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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewResultSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;

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
     * 获取
     * @param et
     * @return
     */
    ReviewResult get(ReviewResult et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ReviewResult get(String key) {
        return getSelf().get(new ReviewResult().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ReviewResult> getByIds(Collection<String> ids) {
        List<ReviewResult> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ReviewResult().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ReviewResult> getByEntities(List<ReviewResult> entities);

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
    Integer checkKey(ReviewResult et);

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
    boolean createBatch(List<ReviewResult> list);

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
    boolean updateBatch(List<ReviewResult> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ReviewResult et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ReviewResult> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ReviewResult().setId(key));
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
    boolean remove(ReviewResult et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ReviewResult> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ReviewResult().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ReviewResult> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<ReviewResult> searchDefault(ReviewResultSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ReviewResult> listDefault(ReviewResultSearchContext context);

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
     * selectRelByContentId
     * @param contentIds
     * @return
     */
    List<ReviewResult> findByContentId(List<String> contentIds);
    default List<ReviewResult> findByContentId(String contentId) {
        return findByContentId(Arrays.asList(contentId));
    }
    /**
     * removeRelByContentId
     * @param contentId
     * @return
     */
    boolean removeByContentId(String contentId);
    /**
     * resetRelByContentId
     * @param contentId
     * @return
     */
    boolean resetByContentId(String contentId);
    /**
     * saveRelByContentId
     * @param contentId
     * @param list
     * @return
     */
    default boolean saveByContentId(String contentId,List<ReviewResult> list) {
        return getSelf().saveByReviewContentExtend(new ReviewContentExtend().setId(contentId),list);
    }
    /**
    * saveRelByReviewContentExtend
    * @param reviewContentExtend
    * @param list
    * @return
    */
    boolean saveByReviewContentExtend(ReviewContentExtend reviewContentExtend,List<ReviewResult> list);


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