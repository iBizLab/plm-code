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
import cn.ibizlab.plm.core.base.domain.DataSyncTask;
import cn.ibizlab.plm.core.base.filter.DataSyncTaskSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 数据同步任务Mapper[DataSyncTask]
 *
 * @author generator
 */
public interface DataSyncTaskMapper extends BaseMapper<DataSyncTask> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DataSyncTask> searchDefault(IPage<DataSyncTask> page, @Param("ctx") DataSyncTaskSearchContext context, @Param("ew") Wrapper<DataSyncTask> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DataSyncTask> listDefault(@Param("ctx") DataSyncTaskSearchContext context, @Param("ew") Wrapper<DataSyncTask> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DataSyncTask> searchView(IPage<DataSyncTask> page, @Param("ctx") DataSyncTaskSearchContext context, @Param("ew") Wrapper<DataSyncTask> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DataSyncTask> listView(@Param("ctx") DataSyncTaskSearchContext context, @Param("ew") Wrapper<DataSyncTask> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    DataSyncTask selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    DataSyncTask selectEntity(DataSyncTask entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<DataSyncTask> selectEntities(@Param("list") List<DataSyncTask> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(DataSyncTask entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) DataSyncTask entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) DataSyncTask entity, @Param("ew") Wrapper<DataSyncTask> updateWrapper);

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
    int deleteEntities(@Param("list") List<DataSyncTask> list);

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