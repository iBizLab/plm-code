/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.ebsx.domain.AppViewTheme;
import cn.ibizlab.plm.core.ebsx.filter.AppViewThemeSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 应用视图主题Mapper[AppViewTheme]
 *
 * @author generator
 */
@DS("db2")
public interface AppViewThemeMapper extends BaseMapper<AppViewTheme> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AppViewTheme> searchDefault(IPage<AppViewTheme> page, @Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AppViewTheme> listDefault(@Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);

    /**
     * 数据集合cur_system分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AppViewTheme> searchCurSystem(IPage<AppViewTheme> page, @Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);
    
    /**
     * 数据集合cur_system查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AppViewTheme> listCurSystem(@Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);

    /**
     * 数据集合cur_system_all分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AppViewTheme> searchCurSystemAll(IPage<AppViewTheme> page, @Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);
    
    /**
     * 数据集合cur_system_all查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AppViewTheme> listCurSystemAll(@Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);

    /**
     * 数据集合cur_user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AppViewTheme> searchCurUser(IPage<AppViewTheme> page, @Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);
    
    /**
     * 数据集合cur_user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AppViewTheme> listCurUser(@Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);

    /**
     * 数据集合cur_user_all分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AppViewTheme> searchCurUserAll(IPage<AppViewTheme> page, @Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);
    
    /**
     * 数据集合cur_user_all查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AppViewTheme> listCurUserAll(@Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);

    /**
     * 数据集合psmodel_sync分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AppViewTheme> searchPsmodelSync(IPage<AppViewTheme> page, @Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);
    
    /**
     * 数据集合psmodel_sync查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AppViewTheme> listPsmodelSync(@Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AppViewTheme> searchView(IPage<AppViewTheme> page, @Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AppViewTheme> listView(@Param("ctx") AppViewThemeSearchContext context, @Param("ew") Wrapper<AppViewTheme> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    AppViewTheme selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    AppViewTheme selectEntity(AppViewTheme entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<AppViewTheme> selectEntities(@Param("list") List<AppViewTheme> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(AppViewTheme entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) AppViewTheme entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) AppViewTheme entity, @Param("ew") Wrapper<AppViewTheme> updateWrapper);

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
    int deleteEntities(@Param("list") List<AppViewTheme> list);

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