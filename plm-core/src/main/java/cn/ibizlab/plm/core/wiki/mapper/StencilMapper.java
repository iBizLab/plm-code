/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.wiki.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.core.wiki.filter.StencilSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 页面模板Mapper[Stencil]
 *
 * @author generator
 */
public interface StencilMapper extends BaseMapper<Stencil> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stencil> searchDefault(IPage<Stencil> page, @Param("ctx") StencilSearchContext context, @Param("ew") Wrapper<Stencil> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stencil> listDefault(@Param("ctx") StencilSearchContext context, @Param("ew") Wrapper<Stencil> wrapper);

    /**
     * 数据集合no_space_stencil分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stencil> searchNoSpaceStencil(IPage<Stencil> page, @Param("ctx") StencilSearchContext context, @Param("ew") Wrapper<Stencil> wrapper);
    
    /**
     * 数据集合no_space_stencil查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stencil> listNoSpaceStencil(@Param("ctx") StencilSearchContext context, @Param("ew") Wrapper<Stencil> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stencil> searchReader(IPage<Stencil> page, @Param("ctx") StencilSearchContext context, @Param("ew") Wrapper<Stencil> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stencil> listReader(@Param("ctx") StencilSearchContext context, @Param("ew") Wrapper<Stencil> wrapper);

    /**
     * 数据集合space_stencil分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Stencil> searchSpaceStencil(IPage<Stencil> page, @Param("ctx") StencilSearchContext context, @Param("ew") Wrapper<Stencil> wrapper);
    
    /**
     * 数据集合space_stencil查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Stencil> listSpaceStencil(@Param("ctx") StencilSearchContext context, @Param("ew") Wrapper<Stencil> wrapper);

    /**
    * 根据spaceId查询
    *
    * @param spaceIds
    * @return
    */
    List<Stencil> findBySpaceId(@Param("spaceIds") List<String> spaceIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Stencil selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Stencil selectEntity(Stencil entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Stencil> selectEntities(@Param("list") List<Stencil> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Stencil entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Stencil entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Stencil entity, @Param("ew") Wrapper<Stencil> updateWrapper);

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
    int deleteEntities(@Param("list") List<Stencil> list);

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