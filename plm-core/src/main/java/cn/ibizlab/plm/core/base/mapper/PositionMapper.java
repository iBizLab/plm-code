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
import cn.ibizlab.plm.core.base.domain.Position;
import cn.ibizlab.plm.core.base.filter.PositionSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 职位Mapper[Position]
 *
 * @author generator
 */
public interface PositionMapper extends BaseMapper<Position> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Position> searchDefault(IPage<Position> page, @Param("ctx") PositionSearchContext context, @Param("ew") Wrapper<Position> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Position> listDefault(@Param("ctx") PositionSearchContext context, @Param("ew") Wrapper<Position> wrapper);

    /**
     * 数据集合no_category分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Position> searchNoCategory(IPage<Position> page, @Param("ctx") PositionSearchContext context, @Param("ew") Wrapper<Position> wrapper);
    
    /**
     * 数据集合no_category查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Position> listNoCategory(@Param("ctx") PositionSearchContext context, @Param("ew") Wrapper<Position> wrapper);

    /**
    * 根据categoryId查询
    *
    * @param categoryIds
    * @return
    */
    List<Position> findByCategoryId(@Param("categoryIds") List<String> categoryIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Position> searchView(IPage<Position> page, @Param("ctx") PositionSearchContext context, @Param("ew") Wrapper<Position> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Position> listView(@Param("ctx") PositionSearchContext context, @Param("ew") Wrapper<Position> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Position selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Position selectEntity(Position entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Position> selectEntities(@Param("list") List<Position> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Position entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Position entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Position entity, @Param("ew") Wrapper<Position> updateWrapper);

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
    int deleteEntities(@Param("list") List<Position> list);

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