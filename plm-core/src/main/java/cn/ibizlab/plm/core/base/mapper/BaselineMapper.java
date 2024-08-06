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
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.filter.BaselineSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 基线Mapper[Baseline]
 *
 * @author generator
 */
public interface BaselineMapper extends BaseMapper<Baseline> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Baseline> searchDefault(IPage<Baseline> page, @Param("ctx") BaselineSearchContext context, @Param("ew") Wrapper<Baseline> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Baseline> listDefault(@Param("ctx") BaselineSearchContext context, @Param("ew") Wrapper<Baseline> wrapper);

    /**
     * 数据集合baseline分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Baseline> searchBaseline(IPage<Baseline> page, @Param("ctx") BaselineSearchContext context, @Param("ew") Wrapper<Baseline> wrapper);
    
    /**
     * 数据集合baseline查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Baseline> listBaseline(@Param("ctx") BaselineSearchContext context, @Param("ew") Wrapper<Baseline> wrapper);

    /**
     * 数据集合snapshot分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Baseline> searchSnapshot(IPage<Baseline> page, @Param("ctx") BaselineSearchContext context, @Param("ew") Wrapper<Baseline> wrapper);
    
    /**
     * 数据集合snapshot查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Baseline> listSnapshot(@Param("ctx") BaselineSearchContext context, @Param("ew") Wrapper<Baseline> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Baseline> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Baseline> searchView(IPage<Baseline> page, @Param("ctx") BaselineSearchContext context, @Param("ew") Wrapper<Baseline> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Baseline> listView(@Param("ctx") BaselineSearchContext context, @Param("ew") Wrapper<Baseline> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Baseline selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Baseline selectEntity(Baseline entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Baseline> selectEntities(@Param("list") List<Baseline> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Baseline entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Baseline entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Baseline entity, @Param("ew") Wrapper<Baseline> updateWrapper);

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
    int deleteEntities(@Param("list") List<Baseline> list);

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