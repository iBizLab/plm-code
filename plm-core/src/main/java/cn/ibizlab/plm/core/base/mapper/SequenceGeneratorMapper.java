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
import cn.ibizlab.plm.core.base.domain.SequenceGenerator;
import cn.ibizlab.plm.core.base.filter.SequenceGeneratorSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 序列Mapper[SequenceGenerator]
 *
 * @author generator
 */
public interface SequenceGeneratorMapper extends BaseMapper<SequenceGenerator> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SequenceGenerator> searchDefault(IPage<SequenceGenerator> page, @Param("ctx") SequenceGeneratorSearchContext context, @Param("ew") Wrapper<SequenceGenerator> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SequenceGenerator> listDefault(@Param("ctx") SequenceGeneratorSearchContext context, @Param("ew") Wrapper<SequenceGenerator> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SequenceGenerator> searchView(IPage<SequenceGenerator> page, @Param("ctx") SequenceGeneratorSearchContext context, @Param("ew") Wrapper<SequenceGenerator> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SequenceGenerator> listView(@Param("ctx") SequenceGeneratorSearchContext context, @Param("ew") Wrapper<SequenceGenerator> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    SequenceGenerator selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    SequenceGenerator selectEntity(SequenceGenerator entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<SequenceGenerator> selectEntities(@Param("list") List<SequenceGenerator> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(SequenceGenerator entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) SequenceGenerator entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) SequenceGenerator entity, @Param("ew") Wrapper<SequenceGenerator> updateWrapper);

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
    int deleteEntities(@Param("list") List<SequenceGenerator> list);

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