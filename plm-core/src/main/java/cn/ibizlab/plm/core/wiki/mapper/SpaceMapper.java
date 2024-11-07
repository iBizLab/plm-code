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
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.filter.SpaceSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 空间Mapper[Space]
 *
 * @author generator
 */
public interface SpaceMapper extends BaseMapper<Space> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchDefault(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listDefault(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchAdmin(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listAdmin(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchArchived(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listArchived(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合category_space分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchCategorySpace(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合category_space查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listCategorySpace(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合current分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchCurrent(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合current查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listCurrent(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchDeleted(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listDeleted(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchFavorite(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listFavorite(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchMain(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listMain(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合mob_main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchMobMain(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合mob_main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listMobMain(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合no_category_space分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchNoCategorySpace(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合no_category_space查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listNoCategorySpace(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合no_re_space分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchNoReSpace(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合no_re_space查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listNoReSpace(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchNormal(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listNormal(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合other_re_space分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchOtherReSpace(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合other_re_space查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listOtherReSpace(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合quick_user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchQuickUser(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合quick_user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listQuickUser(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchReader(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listReader(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 数据集合user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchUser(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listUser(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
    * 根据categoryId查询
    *
    * @param categoryIds
    * @return
    */
    List<Space> findByCategoryId(@Param("categoryIds") List<String> categoryIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Space> searchView(IPage<Space> page, @Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Space> listView(@Param("ctx") SpaceSearchContext context, @Param("ew") Wrapper<Space> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Space selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Space selectEntity(Space entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Space> selectEntities(@Param("list") List<Space> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Space entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Space entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Space entity, @Param("ew") Wrapper<Space> updateWrapper);

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
    int deleteEntities(@Param("list") List<Space> list);

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