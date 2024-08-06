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
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.filter.RunHistorySearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 执行结果Mapper[RunHistory]
 *
 * @author generator
 */
public interface RunHistoryMapper extends BaseMapper<RunHistory> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<RunHistory> searchDefault(IPage<RunHistory> page, @Param("ctx") RunHistorySearchContext context, @Param("ew") Wrapper<RunHistory> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<RunHistory> listDefault(@Param("ctx") RunHistorySearchContext context, @Param("ew") Wrapper<RunHistory> wrapper);

    /**
     * 数据集合this分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<RunHistory> searchThis(IPage<RunHistory> page, @Param("ctx") RunHistorySearchContext context, @Param("ew") Wrapper<RunHistory> wrapper);
    
    /**
     * 数据集合this查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<RunHistory> listThis(@Param("ctx") RunHistorySearchContext context, @Param("ew") Wrapper<RunHistory> wrapper);

    /**
    * 根据runId查询
    *
    * @param runIds
    * @return
    */
    List<RunHistory> findByRunId(@Param("runIds") List<String> runIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<RunHistory> searchView(IPage<RunHistory> page, @Param("ctx") RunHistorySearchContext context, @Param("ew") Wrapper<RunHistory> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<RunHistory> listView(@Param("ctx") RunHistorySearchContext context, @Param("ew") Wrapper<RunHistory> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    RunHistory selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    RunHistory selectEntity(RunHistory entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<RunHistory> selectEntities(@Param("list") List<RunHistory> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(RunHistory entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) RunHistory entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) RunHistory entity, @Param("ew") Wrapper<RunHistory> updateWrapper);

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
    int deleteEntities(@Param("list") List<RunHistory> list);

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