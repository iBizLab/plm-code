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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTag;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTagSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 产品标签Mapper[ProductTag]
 *
 * @author generator
 */
public interface ProductTagMapper extends BaseMapper<ProductTag> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductTag> searchDefault(IPage<ProductTag> page, @Param("ctx") ProductTagSearchContext context, @Param("ew") Wrapper<ProductTag> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductTag> listDefault(@Param("ctx") ProductTagSearchContext context, @Param("ew") Wrapper<ProductTag> wrapper);

    /**
     * 数据集合cur_product_tag分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductTag> searchCurProductTag(IPage<ProductTag> page, @Param("ctx") ProductTagSearchContext context, @Param("ew") Wrapper<ProductTag> wrapper);
    
    /**
     * 数据集合cur_product_tag查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductTag> listCurProductTag(@Param("ctx") ProductTagSearchContext context, @Param("ew") Wrapper<ProductTag> wrapper);

    /**
    * 根据productId查询
    *
    * @param productIds
    * @return
    */
    List<ProductTag> findByProductId(@Param("productIds") List<String> productIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductTag> searchView(IPage<ProductTag> page, @Param("ctx") ProductTagSearchContext context, @Param("ew") Wrapper<ProductTag> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductTag> listView(@Param("ctx") ProductTagSearchContext context, @Param("ew") Wrapper<ProductTag> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    ProductTag selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ProductTag selectEntity(ProductTag entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ProductTag> selectEntities(@Param("list") List<ProductTag> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(ProductTag entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) ProductTag entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) ProductTag entity, @Param("ew") Wrapper<ProductTag> updateWrapper);

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
    int deleteEntities(@Param("list") List<ProductTag> list);

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