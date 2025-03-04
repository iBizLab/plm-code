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
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.filter.FavoriteSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 收藏Mapper[Favorite]
 *
 * @author generator
 */
public interface FavoriteMapper extends BaseMapper<Favorite> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Favorite> searchDefault(IPage<Favorite> page, @Param("ctx") FavoriteSearchContext context, @Param("ew") Wrapper<Favorite> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Favorite> listDefault(@Param("ctx") FavoriteSearchContext context, @Param("ew") Wrapper<Favorite> wrapper);

    /**
     * 数据集合my_favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Favorite> searchMyFavorite(IPage<Favorite> page, @Param("ctx") FavoriteSearchContext context, @Param("ew") Wrapper<Favorite> wrapper);
    
    /**
     * 数据集合my_favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Favorite> listMyFavorite(@Param("ctx") FavoriteSearchContext context, @Param("ew") Wrapper<Favorite> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Favorite> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Favorite> searchView(IPage<Favorite> page, @Param("ctx") FavoriteSearchContext context, @Param("ew") Wrapper<Favorite> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Favorite> listView(@Param("ctx") FavoriteSearchContext context, @Param("ew") Wrapper<Favorite> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Favorite selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Favorite selectEntity(Favorite entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Favorite> selectEntities(@Param("list") List<Favorite> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Favorite entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Favorite entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Favorite entity, @Param("ew") Wrapper<Favorite> updateWrapper);

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
    int deleteEntities(@Param("list") List<Favorite> list);

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