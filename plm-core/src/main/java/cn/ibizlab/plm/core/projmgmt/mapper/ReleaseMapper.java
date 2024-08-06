/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.filter.ReleaseSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 项目发布Mapper[Release]
 *
 * @author generator
 */
public interface ReleaseMapper extends BaseMapper<Release> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Release> searchDefault(IPage<Release> page, @Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Release> listDefault(@Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);

    /**
     * 数据集合bi_detail分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Release> searchBiDetail(IPage<Release> page, @Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);
    
    /**
     * 数据集合bi_detail查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Release> listBiDetail(@Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);

    /**
     * 数据集合bi_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Release> searchBiSearch(IPage<Release> page, @Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);
    
    /**
     * 数据集合bi_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Release> listBiSearch(@Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);

    /**
     * 数据集合choose_relese_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Release> searchChooseReleseRelation(IPage<Release> page, @Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);
    
    /**
     * 数据集合choose_relese_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Release> listChooseReleseRelation(@Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);

    /**
     * 数据集合not_published分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Release> searchNotPublished(IPage<Release> page, @Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);
    
    /**
     * 数据集合not_published查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Release> listNotPublished(@Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Release> searchReader(IPage<Release> page, @Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Release> listReader(@Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);

    /**
     * 数据集合sprint_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Release> searchSprintRelation(IPage<Release> page, @Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);
    
    /**
     * 数据集合sprint_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Release> listSprintRelation(@Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);

    /**
    * 根据projectId查询
    *
    * @param projectIds
    * @return
    */
    List<Release> findByProjectId(@Param("projectIds") List<String> projectIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Release> searchView(IPage<Release> page, @Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Release> listView(@Param("ctx") ReleaseSearchContext context, @Param("ew") Wrapper<Release> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Release selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Release selectEntity(Release entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Release> selectEntities(@Param("list") List<Release> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Release entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Release entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Release entity, @Param("ew") Wrapper<Release> updateWrapper);

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
    int deleteEntities(@Param("list") List<Release> list);

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