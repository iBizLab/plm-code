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
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.projmgmt.filter.StageSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 发布阶段Mapper[Stage]
 *
 * @author generator
 */
public interface StageMapper extends BaseMapper<Stage> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stage> searchDefault(IPage<Stage> page, @Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stage> listDefault(@Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);

    /**
     * 数据集合cur_owner_sys分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stage> searchCurOwnerSys(IPage<Stage> page, @Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);
    
    /**
     * 数据集合cur_owner_sys查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stage> listCurOwnerSys(@Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);

    /**
     * 数据集合cur_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stage> searchCurProject(IPage<Stage> page, @Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);
    
    /**
     * 数据集合cur_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stage> listCurProject(@Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);

    /**
     * 数据集合cur_stage分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stage> searchCurStage(IPage<Stage> page, @Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);
    
    /**
     * 数据集合cur_stage查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stage> listCurStage(@Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);

    /**
     * 数据集合owner分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stage> searchOwner(IPage<Stage> page, @Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);
    
    /**
     * 数据集合owner查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stage> listOwner(@Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);

    /**
     * 数据集合system分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stage> searchSystem(IPage<Stage> page, @Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);
    
    /**
     * 数据集合system查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stage> listSystem(@Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);

    /**
    * 根据releaseId查询
    *
    * @param releaseIds
    * @return
    */
    List<Stage> findByReleaseId(@Param("releaseIds") List<String> releaseIds);

    /**
    * 根据pid查询
    *
    * @param pids
    * @return
    */
    List<Stage> findByPid(@Param("pids") List<String> pids);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stage> searchView(IPage<Stage> page, @Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stage> listView(@Param("ctx") StageSearchContext context, @Param("ew") Wrapper<Stage> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Stage selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Stage selectEntity(Stage entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Stage> selectEntities(@Param("list") List<Stage> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Stage entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Stage entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Stage entity, @Param("ew") Wrapper<Stage> updateWrapper);

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
    int deleteEntities(@Param("list") List<Stage> list);

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