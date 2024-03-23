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
import cn.ibizlab.plm.core.projmgmt.domain.VersionCategory;
import cn.ibizlab.plm.core.projmgmt.filter.VersionCategorySearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 发布类别Mapper[VersionCategory]
 *
 * @author generator
 */
public interface VersionCategoryMapper extends BaseMapper<VersionCategory> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<VersionCategory> searchDefault(IPage<VersionCategory> page, @Param("ctx") VersionCategorySearchContext context, @Param("ew") Wrapper<VersionCategory> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<VersionCategory> listDefault(@Param("ctx") VersionCategorySearchContext context, @Param("ew") Wrapper<VersionCategory> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    VersionCategory selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    VersionCategory selectEntity(VersionCategory entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<VersionCategory> selectEntities(@Param("list") List<VersionCategory> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(VersionCategory entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) VersionCategory entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) VersionCategory entity, @Param("ew") Wrapper<VersionCategory> updateWrapper);

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
    int deleteEntities(@Param("list") List<VersionCategory> list);

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

    /**
     * 根据versionSectionId查询
     *
     * @param versionSectionIds
     * @return
     */
    List<VersionCategory> findByVersionSectionId(@Param("versionSectionIds") List<String> versionSectionIds);

}