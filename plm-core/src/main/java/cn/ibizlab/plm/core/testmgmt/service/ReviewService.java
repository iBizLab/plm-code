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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.base.domain.Attention;
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
     * 获取
     * @param et
     * @return
     */
    Review get(Review et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Review get(String key) {
        return getSelf().get(new Review().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Review> getByIds(Collection<String> ids) {
        List<Review> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Review().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Review> getByEntities(List<Review> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Review getDraft(Review et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Review et);

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
    boolean createBatch(List<Review> list);

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
    boolean updateBatch(List<Review> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Review et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Review> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Review().setId(key));
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
    boolean remove(Review et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Review> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Review().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Review> entities);

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
     * CreateTemp
     * 
     * @param dto
     * @return
     */
    default Review createTemp(Review dto) {
        return dto;
    }

    /**
     * CreateTempMajor
     * 
     * @param dto
     * @return
     */
    default Review createTempMajor(Review dto) {
        return dto;
    }

    /**
     * UpdateTemp
     * 
     * @param dto
     * @return
     */
    default Review updateTemp(Review dto) {
        return dto;
    }

    /**
     * UpdateTempMajor
     * 
     * @param dto
     * @return
     */
    default Review updateTempMajor(Review dto) {
        return dto;
    }

    /**
     * RemoveTemp
     * 
     * @param keys
     * @return
     */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
     * RemoveTempMajor
     * 
     * @param keys
     * @return
     */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
     * GetTemp
     * 
     * @param key
     * @return
     */
    default Review getTemp(String key) {
        return null;
    }

    /**
     * GetTempMajor
     * 
     * @param key
     * @return
     */
    default Review getTempMajor(String key) {
        return null;
    }

    /**
     * GetDraftTemp
     * 
     * @param dto
     * @return
     */
    default Review getDraftTemp(Review dto) {
        return dto;
    }

    /**
     * GetDraftTempMajor
     * 
     * @param dto
     * @return
     */
    default Review getDraftTempMajor(Review dto) {
        return dto;
    }

    /**
     * get_attention
     * 
     * @param key
     * @return
     */
    default Review getAttention(String key) {
        return null;
    }

    /**
     * submit_review
     * 
     * @param dto
     * @return
     */
    default Review submitReview(Review dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Review> searchDefault(ReviewSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Review> listDefault(ReviewSearchContext context);

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
     * selectRelByLibraryId
     * @param libraryIds
     * @return
     */
    List<Review> findByLibraryId(List<String> libraryIds);
    default List<Review> findByLibraryId(String libraryId) {
        return findByLibraryId(Arrays.asList(libraryId));
    }
    /**
     * removeRelByLibraryId
     * @param libraryId
     * @return
     */
    boolean removeByLibraryId(String libraryId);
    /**
     * resetRelByLibraryId
     * @param libraryId
     * @return
     */
    boolean resetByLibraryId(String libraryId);
    /**
     * saveRelByLibraryId
     * @param libraryId
     * @param list
     * @return
     */
    default boolean saveByLibraryId(String libraryId,List<Review> list) {
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }
    /**
    * saveRelByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library,List<Review> list);

    default List<Attention> getAttentions(Review et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(Review et) {
        return new ArrayList<>();
    }

    default List<ReviewContent> getContents(Review et) {
        return new ArrayList<>();
    }

    /**
     * 流程事件
     * @param eventType
     * @param et
     * @return
     */
    default boolean onFlowEvent(String eventType,Review et) {
        return true;
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