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
import cn.ibizlab.plm.core.devops.domain.PullRequest;
import cn.ibizlab.plm.core.devops.filter.PullRequestSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 拉取提交Mapper[PullRequest]
 *
 * @author generator
 */
public interface PullRequestMapper extends BaseMapper<PullRequest> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<PullRequest> searchDefault(IPage<PullRequest> page, @Param("ctx") PullRequestSearchContext context, @Param("ew") Wrapper<PullRequest> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<PullRequest> listDefault(@Param("ctx") PullRequestSearchContext context, @Param("ew") Wrapper<PullRequest> wrapper);

    /**
    * 根据repositoryId查询
    *
    * @param repositoryIds
    * @return
    */
    List<PullRequest> findByRepositoryId(@Param("repositoryIds") List<String> repositoryIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<PullRequest> searchView(IPage<PullRequest> page, @Param("ctx") PullRequestSearchContext context, @Param("ew") Wrapper<PullRequest> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<PullRequest> listView(@Param("ctx") PullRequestSearchContext context, @Param("ew") Wrapper<PullRequest> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    PullRequest selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    PullRequest selectEntity(PullRequest entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<PullRequest> selectEntities(@Param("list") List<PullRequest> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(PullRequest entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) PullRequest entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) PullRequest entity, @Param("ew") Wrapper<PullRequest> updateWrapper);

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
    int deleteEntities(@Param("list") List<PullRequest> list);

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