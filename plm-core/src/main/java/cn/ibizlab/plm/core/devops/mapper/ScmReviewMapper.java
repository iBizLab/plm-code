/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.devops.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.devops.domain.ScmReview;
import cn.ibizlab.plm.core.devops.filter.ScmReviewSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 代码评审Mapper[ScmReview]
 *
 * @author generator
 */
public interface ScmReviewMapper extends BaseMapper<ScmReview> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ScmReview> searchDefault(IPage<ScmReview> page, @Param("ctx") ScmReviewSearchContext context, @Param("ew") Wrapper<ScmReview> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ScmReview> listDefault(@Param("ctx") ScmReviewSearchContext context, @Param("ew") Wrapper<ScmReview> wrapper);

    /**
    * 根据pullRequestId查询
    *
    * @param pullRequestIds
    * @return
    */
    List<ScmReview> findByPullRequestId(@Param("pullRequestIds") List<String> pullRequestIds);

    /**
    * 根据repositoryId查询
    *
    * @param repositoryIds
    * @return
    */
    List<ScmReview> findByRepositoryId(@Param("repositoryIds") List<String> repositoryIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ScmReview> searchView(IPage<ScmReview> page, @Param("ctx") ScmReviewSearchContext context, @Param("ew") Wrapper<ScmReview> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ScmReview> listView(@Param("ctx") ScmReviewSearchContext context, @Param("ew") Wrapper<ScmReview> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    ScmReview selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ScmReview selectEntity(ScmReview entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ScmReview> selectEntities(@Param("list") List<ScmReview> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(ScmReview entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) ScmReview entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) ScmReview entity, @Param("ew") Wrapper<ScmReview> updateWrapper);

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
    int deleteEntities(@Param("list") List<ScmReview> list);

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