/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.base.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 动态数据看板Mapper[DynaDashboard]
 *
 * @author generator
 */
public interface DynaDashboardMapper extends BaseMapper<DynaDashboard> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DynaDashboard> searchDefault(IPage<DynaDashboard> page, @Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DynaDashboard> listDefault(@Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);

    /**
     * 数据集合example_chart分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DynaDashboard> searchExampleChart(IPage<DynaDashboard> page, @Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);
    
    /**
     * 数据集合example_chart查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DynaDashboard> listExampleChart(@Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);

    /**
     * 数据集合is_system分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DynaDashboard> searchIsSystem(IPage<DynaDashboard> page, @Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);
    
    /**
     * 数据集合is_system查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DynaDashboard> listIsSystem(@Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);

    /**
     * 数据集合my_dashboard分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DynaDashboard> searchMyDashboard(IPage<DynaDashboard> page, @Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);
    
    /**
     * 数据集合my_dashboard查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DynaDashboard> listMyDashboard(@Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DynaDashboard> searchNormal(IPage<DynaDashboard> page, @Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DynaDashboard> listNormal(@Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<DynaDashboard> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DynaDashboard> searchView(IPage<DynaDashboard> page, @Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DynaDashboard> listView(@Param("ctx") DynaDashboardSearchContext context, @Param("ew") Wrapper<DynaDashboard> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    DynaDashboard selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    DynaDashboard selectEntity(DynaDashboard entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<DynaDashboard> selectEntities(@Param("list") List<DynaDashboard> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(DynaDashboard entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) DynaDashboard entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) DynaDashboard entity, @Param("ew") Wrapper<DynaDashboard> updateWrapper);

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
    int deleteEntities(@Param("list") List<DynaDashboard> list);

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