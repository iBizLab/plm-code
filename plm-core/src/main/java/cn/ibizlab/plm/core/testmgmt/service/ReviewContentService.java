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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewContentSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;

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
     * 获取
     * @param et
     * @return
     */
    ReviewContent get(ReviewContent et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ReviewContent get(String key) {
        return getSelf().get(new ReviewContent().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ReviewContent> getByIds(Collection<String> ids) {
        List<ReviewContent> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ReviewContent().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ReviewContent> getByEntities(List<ReviewContent> entities);

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
    Integer checkKey(ReviewContent et);

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
    boolean createBatch(List<ReviewContent> list);

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
    boolean updateBatch(List<ReviewContent> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ReviewContent et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ReviewContent> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ReviewContent().setId(key));
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
    boolean remove(ReviewContent et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ReviewContent> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ReviewContent().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ReviewContent> entities);

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
     * program_test_case
     * 
     * @param dto
     * @return
     */
    default ReviewContent programTestCase(ReviewContent dto) {
        return dto;
    }

    /**
     * review_content_total
     * 
     * @param dto
     * @return
     */
    default ReviewContent reviewContentTotal(ReviewContent dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<ReviewContent> searchDefault(ReviewContentSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ReviewContent> listDefault(ReviewContentSearchContext context);

    /**
     * searchall
     * 
     * @param context
     * @return
     */
    Page<ReviewContent> searchAll(ReviewContentSearchContext context);
    /**
     * listall
     * 
     * @param context
     * @return
     */
    List<ReviewContent> listAll(ReviewContentSearchContext context);

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
     * selectRelByPrincipalId
     * @param principalIds
     * @return
     */
    List<ReviewContent> findByPrincipalId(List<String> principalIds);
    default List<ReviewContent> findByPrincipalId(String principalId) {
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
     * saveRelByReview
     * @param review
     * @param list
     * @return
     */
    boolean saveByReview(Review review,List<ReviewContent> list);
    /**
     * saveRelByPrincipalId
     * @param principalId
     * @param list
     * @return
     */
    default boolean saveByPrincipalId(String principalId,List<ReviewContent> list) {
        return getSelf().saveByReview(new Review().setId(principalId),list);
    }

    /**
     * selectRelByTargetVersionId
     * @param targetVersionIds
     * @return
     */
    List<ReviewContent> findByTargetVersionId(List<String> targetVersionIds);
    default List<ReviewContent> findByTargetVersionId(String targetVersionId) {
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
    boolean saveByTargetVersion(Version version,List<ReviewContent> list);
    /**
     * saveRelByTargetVersionId
     * @param targetVersionId
     * @param list
     * @return
     */
    default boolean saveByTargetVersionId(String targetVersionId,List<ReviewContent> list) {
        return getSelf().saveByTargetVersion(new Version().setId(targetVersionId),list);
    }

    /**
     * selectRelByTargetId
     * @param targetIds
     * @return
     */
    List<ReviewContent> findByTargetId(List<String> targetIds);
    default List<ReviewContent> findByTargetId(String targetId) {
        return findByTargetId(Arrays.asList(targetId));
    }
    /**
     * removeRelByTargetId
     * @param targetId
     * @return
     */
    boolean removeByTargetId(String targetId);
    /**
     * resetRelByTargetId
     * @param targetId
     * @return
     */
    boolean resetByTargetId(String targetId);
    /**
     * saveRelByTestCase
     * @param testCase
     * @param list
     * @return
     */
    boolean saveByTestCase(TestCase testCase,List<ReviewContent> list);
    /**
     * saveRelByTargetId
     * @param targetId
     * @param list
     * @return
     */
    default boolean saveByTargetId(String targetId,List<ReviewContent> list) {
        return getSelf().saveByTestCase(new TestCase().setId(targetId),list);
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