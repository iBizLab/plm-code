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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTicketTypeSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 产品工单类型Mapper[ProductTicketType]
 *
 * @author generator
 */
public interface ProductTicketTypeMapper extends BaseMapper<ProductTicketType> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductTicketType> searchDefault(IPage<ProductTicketType> page, @Param("ctx") ProductTicketTypeSearchContext context, @Param("ew") Wrapper<ProductTicketType> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductTicketType> listDefault(@Param("ctx") ProductTicketTypeSearchContext context, @Param("ew") Wrapper<ProductTicketType> wrapper);

    /**
    * 根据productId查询
    *
    * @param productIds
    * @return
    */
    List<ProductTicketType> findByProductId(@Param("productIds") List<String> productIds);

    /**
    * 根据ticketTypeId查询
    *
    * @param ticketTypeIds
    * @return
    */
    List<ProductTicketType> findByTicketTypeId(@Param("ticketTypeIds") List<String> ticketTypeIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductTicketType> searchView(IPage<ProductTicketType> page, @Param("ctx") ProductTicketTypeSearchContext context, @Param("ew") Wrapper<ProductTicketType> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductTicketType> listView(@Param("ctx") ProductTicketTypeSearchContext context, @Param("ew") Wrapper<ProductTicketType> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    ProductTicketType selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ProductTicketType selectEntity(ProductTicketType entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ProductTicketType> selectEntities(@Param("list") List<ProductTicketType> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(ProductTicketType entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) ProductTicketType entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) ProductTicketType entity, @Param("ew") Wrapper<ProductTicketType> updateWrapper);

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
    int deleteEntities(@Param("list") List<ProductTicketType> list);

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