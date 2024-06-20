/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.team.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.team.domain.KeyResult;
import cn.ibizlab.plm.core.team.filter.KeyResultSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 关键结果Mapper[KeyResult]
 *
 * @author generator
 */
public interface KeyResultMapper extends BaseMapper<KeyResult> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<KeyResult> searchDefault(IPage<KeyResult> page, @Param("ctx") KeyResultSearchContext context, @Param("ew") Wrapper<KeyResult> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<KeyResult> listDefault(@Param("ctx") KeyResultSearchContext context, @Param("ew") Wrapper<KeyResult> wrapper);

    /**
    * 根据objectiveId查询
    *
    * @param objectiveIds
    * @return
    */
    List<KeyResult> findByObjectiveId(@Param("objectiveIds") List<String> objectiveIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    KeyResult selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    KeyResult selectEntity(KeyResult entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<KeyResult> selectEntities(@Param("list") List<KeyResult> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(KeyResult entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) KeyResult entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) KeyResult entity, @Param("ew") Wrapper<KeyResult> updateWrapper);

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
    int deleteEntities(@Param("list") List<KeyResult> list);

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