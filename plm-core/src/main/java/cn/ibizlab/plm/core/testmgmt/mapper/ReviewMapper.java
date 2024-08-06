/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 评审Mapper[Review]
 *
 * @author generator
 */
public interface ReviewMapper extends BaseMapper<Review> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Review> searchDefault(IPage<Review> page, @Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Review> listDefault(@Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);

    /**
     * 数据集合bi_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Review> searchBiSearch(IPage<Review> page, @Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);
    
    /**
     * 数据集合bi_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Review> listBiSearch(@Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);

    /**
     * 数据集合my_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Review> searchMyAttention(IPage<Review> page, @Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);
    
    /**
     * 数据集合my_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Review> listMyAttention(@Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);

    /**
     * 数据集合my_reviewed分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Review> searchMyReviewed(IPage<Review> page, @Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);
    
    /**
     * 数据集合my_reviewed查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Review> listMyReviewed(@Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);

    /**
    * 根据guidelineId查询
    *
    * @param guidelineIds
    * @return
    */
    List<Review> findByGuidelineId(@Param("guidelineIds") List<String> guidelineIds);

    /**
    * 根据libraryId查询
    *
    * @param libraryIds
    * @return
    */
    List<Review> findByLibraryId(@Param("libraryIds") List<String> libraryIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Review> searchView(IPage<Review> page, @Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Review> listView(@Param("ctx") ReviewSearchContext context, @Param("ew") Wrapper<Review> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Review selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Review selectEntity(Review entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Review> selectEntities(@Param("list") List<Review> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Review entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Review entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Review entity, @Param("ew") Wrapper<Review> updateWrapper);

    /**
     * 主键删除
     *
     * @param id
     * @return
     */
    @Override
    int deleteById(Serializable id);

    /**
     * 数据对象集合删除
     *
     * @param list
     * @return
     */
    int deleteEntities(@Param("list") List<Review> list);

    /**
     * 自定义查询SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Select("${sql}")
    List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义更新SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义插入SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义删除SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);
}