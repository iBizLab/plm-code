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
import cn.ibizlab.plm.core.base.domain.DictionaryData;
import cn.ibizlab.plm.core.base.filter.DictionaryDataSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 数据字典Mapper[DictionaryData]
 *
 * @author generator
 */
public interface DictionaryDataMapper extends BaseMapper<DictionaryData> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DictionaryData> searchDefault(IPage<DictionaryData> page, @Param("ctx") DictionaryDataSearchContext context, @Param("ew") Wrapper<DictionaryData> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DictionaryData> listDefault(@Param("ctx") DictionaryDataSearchContext context, @Param("ew") Wrapper<DictionaryData> wrapper);

    /**
     * 数据集合idea_state分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DictionaryData> searchIdeaState(IPage<DictionaryData> page, @Param("ctx") DictionaryDataSearchContext context, @Param("ew") Wrapper<DictionaryData> wrapper);
    
    /**
     * 数据集合idea_state查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DictionaryData> listIdeaState(@Param("ctx") DictionaryDataSearchContext context, @Param("ew") Wrapper<DictionaryData> wrapper);

    /**
     * 数据集合release_stage分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DictionaryData> searchReleaseStage(IPage<DictionaryData> page, @Param("ctx") DictionaryDataSearchContext context, @Param("ew") Wrapper<DictionaryData> wrapper);
    
    /**
     * 数据集合release_stage查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DictionaryData> listReleaseStage(@Param("ctx") DictionaryDataSearchContext context, @Param("ew") Wrapper<DictionaryData> wrapper);

    /**
     * 数据集合ticket_state分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DictionaryData> searchTicketState(IPage<DictionaryData> page, @Param("ctx") DictionaryDataSearchContext context, @Param("ew") Wrapper<DictionaryData> wrapper);
    
    /**
     * 数据集合ticket_state查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DictionaryData> listTicketState(@Param("ctx") DictionaryDataSearchContext context, @Param("ew") Wrapper<DictionaryData> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    DictionaryData selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    DictionaryData selectEntity(DictionaryData entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<DictionaryData> selectEntities(@Param("list") List<DictionaryData> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(DictionaryData entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) DictionaryData entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) DictionaryData entity, @Param("ew") Wrapper<DictionaryData> updateWrapper);

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
    int deleteEntities(@Param("list") List<DictionaryData> list);

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