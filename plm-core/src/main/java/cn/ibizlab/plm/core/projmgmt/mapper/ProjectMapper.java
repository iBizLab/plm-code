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
     * 数据集合admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchAdmin(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listAdmin(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchArchived(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listArchived(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合bi_detail分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchBiDetail(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合bi_detail查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listBiDetail(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合bi_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchBiSearch(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合bi_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listBiSearch(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合choose_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchChooseProject(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合choose_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listChooseProject(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合current分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchCurrent(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合current查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listCurrent(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchDeleted(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listDeleted(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchFavorite(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listFavorite(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchMain(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listMain(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合mob_main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchMobMain(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合mob_main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listMobMain(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合no_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchNoRelation(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合no_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listNoRelation(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchNormal(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listNormal(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合product_re_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchProductReProject(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合product_re_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listProductReProject(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合quick_user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchQuickUser(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合quick_user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listQuickUser(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchReader(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listReader(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合same_type分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchSameType(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合same_type查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listSameType(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合under_project_portfolio分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchUnderProjectPortfolio(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合under_project_portfolio查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listUnderProjectPortfolio(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchUser(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listUser(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
     * 数据集合work_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchWorkProject(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合work_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listWorkProject(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

    /**
    * 根据state查询
    *
    * @param states
    * @return
    */
    List<Project> findByState(@Param("states") List<String> states);

    /**
    * 根据id查询
    *
    * @param ids
    * @return
    */
    List<Project> findById(@Param("ids") List<String> ids);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Project> searchView(IPage<Project> page, @Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Project> listView(@Param("ctx") ProjectSearchContext context, @Param("ew") Wrapper<Project> wrapper);

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