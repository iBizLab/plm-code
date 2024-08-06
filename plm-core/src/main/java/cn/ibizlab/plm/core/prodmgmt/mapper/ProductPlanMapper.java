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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductPlanSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 排期Mapper[ProductPlan]
 *
 * @author generator
 */
public interface ProductPlanMapper extends BaseMapper<ProductPlan> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductPlan> searchDefault(IPage<ProductPlan> page, @Param("ctx") ProductPlanSearchContext context, @Param("ew") Wrapper<ProductPlan> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductPlan> listDefault(@Param("ctx") ProductPlanSearchContext context, @Param("ew") Wrapper<ProductPlan> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductPlan> searchNormal(IPage<ProductPlan> page, @Param("ctx") ProductPlanSearchContext context, @Param("ew") Wrapper<ProductPlan> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductPlan> listNormal(@Param("ctx") ProductPlanSearchContext context, @Param("ew") Wrapper<ProductPlan> wrapper);

    /**
    * 根据productId查询
    *
    * @param productIds
    * @return
    */
    List<ProductPlan> findByProductId(@Param("productIds") List<String> productIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductPlan> searchView(IPage<ProductPlan> page, @Param("ctx") ProductPlanSearchContext context, @Param("ew") Wrapper<ProductPlan> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductPlan> listView(@Param("ctx") ProductPlanSearchContext context, @Param("ew") Wrapper<ProductPlan> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    ProductPlan selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ProductPlan selectEntity(ProductPlan entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ProductPlan> selectEntities(@Param("list") List<ProductPlan> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(ProductPlan entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) ProductPlan entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) ProductPlan entity, @Param("ew") Wrapper<ProductPlan> updateWrapper);

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
    int deleteEntities(@Param("list") List<ProductPlan> list);

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