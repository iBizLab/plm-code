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
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.filter.GuidelineSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 流程准则Mapper[Guideline]
 *
 * @author generator
 */
public interface GuidelineMapper extends BaseMapper<Guideline> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Guideline> searchDefault(IPage<Guideline> page, @Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Guideline> listDefault(@Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);

    /**
     * 数据集合base分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Guideline> searchBase(IPage<Guideline> page, @Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);
    
    /**
     * 数据集合base查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Guideline> listBase(@Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Guideline> searchNormal(IPage<Guideline> page, @Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Guideline> listNormal(@Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);

    /**
     * 数据集合under_library分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Guideline> searchUnderLibrary(IPage<Guideline> page, @Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);
    
    /**
     * 数据集合under_library查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Guideline> listUnderLibrary(@Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);

    /**
    * 根据scopeId查询
    *
    * @param scopeIds
    * @return
    */
    List<Guideline> findByScopeId(@Param("scopeIds") List<String> scopeIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Guideline> searchView(IPage<Guideline> page, @Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Guideline> listView(@Param("ctx") GuidelineSearchContext context, @Param("ew") Wrapper<Guideline> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Guideline selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Guideline selectEntity(Guideline entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Guideline> selectEntities(@Param("list") List<Guideline> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Guideline entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Guideline entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Guideline entity, @Param("ew") Wrapper<Guideline> updateWrapper);

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
    int deleteEntities(@Param("list") List<Guideline> list);

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