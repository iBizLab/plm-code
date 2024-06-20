/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@MINHERIT}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.wiki.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.wiki.filter.BaselinePageSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 基线页面Mapper[BaselinePage]
 *
 * @author generator
 */
public interface BaselinePageMapper extends BaseMapper<BaselinePage> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<BaselinePage> searchDefault(IPage<BaselinePage> page, @Param("ctx") BaselinePageSearchContext context, @Param("ew") Wrapper<BaselinePage> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<BaselinePage> listDefault(@Param("ctx") BaselinePageSearchContext context, @Param("ew") Wrapper<BaselinePage> wrapper);

    /**
     * 数据集合fill_version_data分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<BaselinePage> searchFillVersionData(IPage<BaselinePage> page, @Param("ctx") BaselinePageSearchContext context, @Param("ew") Wrapper<BaselinePage> wrapper);
    
    /**
     * 数据集合fill_version_data查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<BaselinePage> listFillVersionData(@Param("ctx") BaselinePageSearchContext context, @Param("ew") Wrapper<BaselinePage> wrapper);

    /**
    * 根据principalId查询
    *
    * @param principalIds
    * @return
    */
    List<BaselinePage> findByPrincipalId(@Param("principalIds") List<String> principalIds);

    /**
    * 根据targetVersionId查询
    *
    * @param targetVersionIds
    * @return
    */
    List<BaselinePage> findByTargetVersionId(@Param("targetVersionIds") List<String> targetVersionIds);

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    @Override
    BaselinePage selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    BaselinePage selectEntity(BaselinePage entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<BaselinePage> selectEntities(@Param("list") List<BaselinePage> list);

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