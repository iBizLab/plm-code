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
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 迭代Mapper[Sprint]
 *
 * @author generator
 */
public interface SprintMapper extends BaseMapper<Sprint> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Sprint> searchDefault(IPage<Sprint> page, @Param("ctx") SprintSearchContext context, @Param("ew") Wrapper<Sprint> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Sprint> listDefault(@Param("ctx") SprintSearchContext context, @Param("ew") Wrapper<Sprint> wrapper);

    /**
     * 数据集合choose_move分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Sprint> searchChooseMove(IPage<Sprint> page, @Param("ctx") SprintSearchContext context, @Param("ew") Wrapper<Sprint> wrapper);
    
    /**
     * 数据集合choose_move查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Sprint> listChooseMove(@Param("ctx") SprintSearchContext context, @Param("ew") Wrapper<Sprint> wrapper);

    /**
     * 数据集合not_finish分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Sprint> searchNotFinish(IPage<Sprint> page, @Param("ctx") SprintSearchContext context, @Param("ew") Wrapper<Sprint> wrapper);
    
    /**
     * 数据集合not_finish查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Sprint> listNotFinish(@Param("ctx") SprintSearchContext context, @Param("ew") Wrapper<Sprint> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Sprint selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Sprint selectEntity(Sprint entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Sprint> selectEntities(@Param("list") List<Sprint> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Sprint entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Sprint entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Sprint entity, @Param("ew") Wrapper<Sprint> updateWrapper);

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
    int deleteEntities(@Param("list") List<Sprint> list);

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
     * 根据projectId查询
     *
     * @param projectIds
     * @return
     */
    List<Sprint> findByProjectId(@Param("projectIds") List<String> projectIds);

    /**
     * 根据pid查询
     *
     * @param pids
     * @return
     */
    List<Sprint> findByPid(@Param("pids") List<String> pids);

}