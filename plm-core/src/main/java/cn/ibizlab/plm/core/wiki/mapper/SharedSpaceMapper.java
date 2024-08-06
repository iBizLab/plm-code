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
import cn.ibizlab.plm.core.wiki.domain.SharedSpace;
import cn.ibizlab.plm.core.wiki.filter.SharedSpaceSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 共享空间Mapper[SharedSpace]
 *
 * @author generator
 */
public interface SharedSpaceMapper extends BaseMapper<SharedSpace> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SharedSpace> searchDefault(IPage<SharedSpace> page, @Param("ctx") SharedSpaceSearchContext context, @Param("ew") Wrapper<SharedSpace> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SharedSpace> listDefault(@Param("ctx") SharedSpaceSearchContext context, @Param("ew") Wrapper<SharedSpace> wrapper);

    /**
     * 数据集合admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SharedSpace> searchAdmin(IPage<SharedSpace> page, @Param("ctx") SharedSpaceSearchContext context, @Param("ew") Wrapper<SharedSpace> wrapper);
    
    /**
     * 数据集合admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SharedSpace> listAdmin(@Param("ctx") SharedSpaceSearchContext context, @Param("ew") Wrapper<SharedSpace> wrapper);

    /**
     * 数据集合shared分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SharedSpace> searchShared(IPage<SharedSpace> page, @Param("ctx") SharedSpaceSearchContext context, @Param("ew") Wrapper<SharedSpace> wrapper);
    
    /**
     * 数据集合shared查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SharedSpace> listShared(@Param("ctx") SharedSpaceSearchContext context, @Param("ew") Wrapper<SharedSpace> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SharedSpace> searchView(IPage<SharedSpace> page, @Param("ctx") SharedSpaceSearchContext context, @Param("ew") Wrapper<SharedSpace> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SharedSpace> listView(@Param("ctx") SharedSpaceSearchContext context, @Param("ew") Wrapper<SharedSpace> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    SharedSpace selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    SharedSpace selectEntity(SharedSpace entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<SharedSpace> selectEntities(@Param("list") List<SharedSpace> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(SharedSpace entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) SharedSpace entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) SharedSpace entity, @Param("ew") Wrapper<SharedSpace> updateWrapper);

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
    int deleteEntities(@Param("list") List<SharedSpace> list);

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