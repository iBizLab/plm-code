/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.insight.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.insight.domain.InsightReport;
import cn.ibizlab.plm.core.insight.filter.InsightReportSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 效能报表Mapper[InsightReport]
 *
 * @author generator
 */
public interface InsightReportMapper extends BaseMapper<InsightReport> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightReport> searchDefault(IPage<InsightReport> page, @Param("ctx") InsightReportSearchContext context, @Param("ew") Wrapper<InsightReport> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightReport> listDefault(@Param("ctx") InsightReportSearchContext context, @Param("ew") Wrapper<InsightReport> wrapper);

    /**
     * 数据集合is_system分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightReport> searchIsSystem(IPage<InsightReport> page, @Param("ctx") InsightReportSearchContext context, @Param("ew") Wrapper<InsightReport> wrapper);
    
    /**
     * 数据集合is_system查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightReport> listIsSystem(@Param("ctx") InsightReportSearchContext context, @Param("ew") Wrapper<InsightReport> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightReport> searchNormal(IPage<InsightReport> page, @Param("ctx") InsightReportSearchContext context, @Param("ew") Wrapper<InsightReport> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightReport> listNormal(@Param("ctx") InsightReportSearchContext context, @Param("ew") Wrapper<InsightReport> wrapper);

    /**
    * 根据viewId查询
    *
    * @param viewIds
    * @return
    */
    List<InsightReport> findByViewId(@Param("viewIds") List<String> viewIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightReport> searchView(IPage<InsightReport> page, @Param("ctx") InsightReportSearchContext context, @Param("ew") Wrapper<InsightReport> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightReport> listView(@Param("ctx") InsightReportSearchContext context, @Param("ew") Wrapper<InsightReport> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    InsightReport selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    InsightReport selectEntity(InsightReport entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<InsightReport> selectEntities(@Param("list") List<InsightReport> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(InsightReport entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) InsightReport entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) InsightReport entity, @Param("ew") Wrapper<InsightReport> updateWrapper);

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
    int deleteEntities(@Param("list") List<InsightReport> list);

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