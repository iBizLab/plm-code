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
import cn.ibizlab.plm.core.team.domain.UpdateRecord;
import cn.ibizlab.plm.core.team.filter.UpdateRecordSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 进展Mapper[UpdateRecord]
 *
 * @author generator
 */
public interface UpdateRecordMapper extends BaseMapper<UpdateRecord> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<UpdateRecord> searchDefault(IPage<UpdateRecord> page, @Param("ctx") UpdateRecordSearchContext context, @Param("ew") Wrapper<UpdateRecord> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<UpdateRecord> listDefault(@Param("ctx") UpdateRecordSearchContext context, @Param("ew") Wrapper<UpdateRecord> wrapper);

    /**
    * 根据keyResultId查询
    *
    * @param keyResultIds
    * @return
    */
    List<UpdateRecord> findByKeyResultId(@Param("keyResultIds") List<String> keyResultIds);

    /**
    * 根据objectiveId查询
    *
    * @param objectiveIds
    * @return
    */
    List<UpdateRecord> findByObjectiveId(@Param("objectiveIds") List<String> objectiveIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<UpdateRecord> searchView(IPage<UpdateRecord> page, @Param("ctx") UpdateRecordSearchContext context, @Param("ew") Wrapper<UpdateRecord> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<UpdateRecord> listView(@Param("ctx") UpdateRecordSearchContext context, @Param("ew") Wrapper<UpdateRecord> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    UpdateRecord selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    UpdateRecord selectEntity(UpdateRecord entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<UpdateRecord> selectEntities(@Param("list") List<UpdateRecord> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(UpdateRecord entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) UpdateRecord entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) UpdateRecord entity, @Param("ew") Wrapper<UpdateRecord> updateWrapper);

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
    int deleteEntities(@Param("list") List<UpdateRecord> list);

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