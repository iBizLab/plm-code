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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.filter.LibrarySearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 测试库Mapper[Library]
 *
 * @author generator
 */
public interface LibraryMapper extends BaseMapper<Library> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchDefault(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listDefault(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchAdmin(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listAdmin(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchArchived(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listArchived(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchDeleted(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listDeleted(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchFavorite(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listFavorite(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchMain(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listMain(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合mob_main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchMobMain(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合mob_main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listMobMain(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchNormal(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listNormal(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合project_relation_library分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchProjectRelationLibrary(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合project_relation_library查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listProjectRelationLibrary(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合quick_user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchQuickUser(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合quick_user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listQuickUser(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchReader(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listReader(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchUser(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listUser(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Library> searchView(IPage<Library> page, @Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Library> listView(@Param("ctx") LibrarySearchContext context, @Param("ew") Wrapper<Library> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Library selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Library selectEntity(Library entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Library> selectEntities(@Param("list") List<Library> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Library entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Library entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Library entity, @Param("ew") Wrapper<Library> updateWrapper);

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
    int deleteEntities(@Param("list") List<Library> list);

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