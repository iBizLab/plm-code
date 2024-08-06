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
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.filter.SwimlaneSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 泳道Mapper[Swimlane]
 *
 * @author generator
 */
public interface SwimlaneMapper extends BaseMapper<Swimlane> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Swimlane> searchDefault(IPage<Swimlane> page, @Param("ctx") SwimlaneSearchContext context, @Param("ew") Wrapper<Swimlane> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Swimlane> listDefault(@Param("ctx") SwimlaneSearchContext context, @Param("ew") Wrapper<Swimlane> wrapper);

    /**
    * 根据boardId查询
    *
    * @param boardIds
    * @return
    */
    List<Swimlane> findByBoardId(@Param("boardIds") List<String> boardIds);

    /**
    * 根据projectId查询
    *
    * @param projectIds
    * @return
    */
    List<Swimlane> findByProjectId(@Param("projectIds") List<String> projectIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Swimlane> searchView(IPage<Swimlane> page, @Param("ctx") SwimlaneSearchContext context, @Param("ew") Wrapper<Swimlane> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Swimlane> listView(@Param("ctx") SwimlaneSearchContext context, @Param("ew") Wrapper<Swimlane> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Swimlane selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Swimlane selectEntity(Swimlane entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Swimlane> selectEntities(@Param("list") List<Swimlane> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Swimlane entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Swimlane entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Swimlane entity, @Param("ew") Wrapper<Swimlane> updateWrapper);

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
    int deleteEntities(@Param("list") List<Swimlane> list);

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