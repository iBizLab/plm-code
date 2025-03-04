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
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.filter.VersionSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 版本Mapper[Version]
 *
 * @author generator
 */
public interface VersionMapper extends BaseMapper<Version> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Version> searchDefault(IPage<Version> page, @Param("ctx") VersionSearchContext context, @Param("ew") Wrapper<Version> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Version> listDefault(@Param("ctx") VersionSearchContext context, @Param("ew") Wrapper<Version> wrapper);

    /**
     * 数据集合name_version分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Version> searchNameVersion(IPage<Version> page, @Param("ctx") VersionSearchContext context, @Param("ew") Wrapper<Version> wrapper);
    
    /**
     * 数据集合name_version查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Version> listNameVersion(@Param("ctx") VersionSearchContext context, @Param("ew") Wrapper<Version> wrapper);

    /**
     * 数据集合owner分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Version> searchOwner(IPage<Version> page, @Param("ctx") VersionSearchContext context, @Param("ew") Wrapper<Version> wrapper);
    
    /**
     * 数据集合owner查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Version> listOwner(@Param("ctx") VersionSearchContext context, @Param("ew") Wrapper<Version> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Version> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Version> searchView(IPage<Version> page, @Param("ctx") VersionSearchContext context, @Param("ew") Wrapper<Version> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Version> listView(@Param("ctx") VersionSearchContext context, @Param("ew") Wrapper<Version> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Version selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Version selectEntity(Version entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Version> selectEntities(@Param("list") List<Version> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Version entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Version entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Version entity, @Param("ew") Wrapper<Version> updateWrapper);

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
    int deleteEntities(@Param("list") List<Version> list);

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