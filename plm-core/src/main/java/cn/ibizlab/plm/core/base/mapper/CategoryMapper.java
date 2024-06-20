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
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.filter.CategorySearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 类别Mapper[Category]
 *
 * @author generator
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Category> searchDefault(IPage<Category> page, @Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Category> listDefault(@Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);

    /**
     * 数据集合check_name分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Category> searchCheckName(IPage<Category> page, @Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);
    
    /**
     * 数据集合check_name查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Category> listCheckName(@Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);

    /**
     * 数据集合common_categories分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Category> searchCommonCategories(IPage<Category> page, @Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);
    
    /**
     * 数据集合common_categories查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Category> listCommonCategories(@Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);

    /**
     * 数据集合no_section分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Category> searchNoSection(IPage<Category> page, @Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);
    
    /**
     * 数据集合no_section查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Category> listNoSection(@Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);

    /**
     * 数据集合product_idea_category分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Category> searchProductIdeaCategory(IPage<Category> page, @Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);
    
    /**
     * 数据集合product_idea_category查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Category> listProductIdeaCategory(@Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);

    /**
     * 数据集合product_plan分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Category> searchProductPlan(IPage<Category> page, @Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);
    
    /**
     * 数据集合product_plan查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Category> listProductPlan(@Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);

    /**
     * 数据集合space_category分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Category> searchSpaceCategory(IPage<Category> page, @Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);
    
    /**
     * 数据集合space_category查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Category> listSpaceCategory(@Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);

    /**
     * 数据集合space_category_top分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Category> searchSpaceCategoryTop(IPage<Category> page, @Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);
    
    /**
     * 数据集合space_category_top查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Category> listSpaceCategoryTop(@Param("ctx") CategorySearchContext context, @Param("ew") Wrapper<Category> wrapper);

    /**
    * 根据pid查询
    *
    * @param pids
    * @return
    */
    List<Category> findByPid(@Param("pids") List<String> pids);

    /**
    * 根据sectionId查询
    *
    * @param sectionIds
    * @return
    */
    List<Category> findBySectionId(@Param("sectionIds") List<String> sectionIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Category selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Category selectEntity(Category entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Category> selectEntities(@Param("list") List<Category> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Category entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Category entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Category entity, @Param("ew") Wrapper<Category> updateWrapper);

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
    int deleteEntities(@Param("list") List<Category> list);

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