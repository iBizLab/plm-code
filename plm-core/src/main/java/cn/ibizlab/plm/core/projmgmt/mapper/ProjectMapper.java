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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 项目Mapper[Project]
 *
 * @author generator
 */
public interface ProjectMapper extends BaseMapper<Project> {

    /**
     * 数据集合Admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchAdmin(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listAdmin(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchArchived(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listArchived(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Choose_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchChooseProject(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Choose_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listChooseProject(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Current分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchCurrent(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Current查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listCurrent(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchDefault(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listDefault(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchDeleted(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listDeleted(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchFavorite(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listFavorite(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchNormal(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listNormal(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchReader(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listReader(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Same_type分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchSameType(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Same_type查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listSameType(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Under_project_portfolio分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchUnderProjectPortfolio(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Under_project_portfolio查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listUnderProjectPortfolio(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合User分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchUser(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合User查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listUser(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合Work_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchWorkProject(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合Work_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listWorkProject(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Project selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Project selectEntity(Project entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Project> selectEntities(@Param("list") List<Project> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Project entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Project entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Project entity, @Param("ew") Wrapper<Project> updateWrapper);

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
    int deleteEntities(@Param("list") List<Project> list);

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