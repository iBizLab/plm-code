/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaTemplateSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 需求模板Mapper[IdeaTemplate]
 *
 * @author generator
 */
public interface IdeaTemplateMapper extends BaseMapper<IdeaTemplate> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<IdeaTemplate> searchDefault(IPage<IdeaTemplate> page, @Param("ctx") IdeaTemplateSearchContext context, @Param("ew") Wrapper<IdeaTemplate> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<IdeaTemplate> listDefault(@Param("ctx") IdeaTemplateSearchContext context, @Param("ew") Wrapper<IdeaTemplate> wrapper);

    /**
    * 根据categoryId查询
    *
    * @param categoryIds
    * @return
    */
    List<IdeaTemplate> findByCategoryId(@Param("categoryIds") List<String> categoryIds);

    /**
    * 根据productId查询
    *
    * @param productIds
    * @return
    */
    List<IdeaTemplate> findByProductId(@Param("productIds") List<String> productIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    IdeaTemplate selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    IdeaTemplate selectEntity(IdeaTemplate entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<IdeaTemplate> selectEntities(@Param("list") List<IdeaTemplate> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(IdeaTemplate entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) IdeaTemplate entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) IdeaTemplate entity, @Param("ew") Wrapper<IdeaTemplate> updateWrapper);

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
    int deleteEntities(@Param("list") List<IdeaTemplate> list);

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