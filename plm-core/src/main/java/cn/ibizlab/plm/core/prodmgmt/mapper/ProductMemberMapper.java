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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductMemberSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 产品成员Mapper[ProductMember]
 *
 * @author generator
 */
public interface ProductMemberMapper extends BaseMapper<ProductMember> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductMember> searchDefault(IPage<ProductMember> page, @Param("ctx") ProductMemberSearchContext context, @Param("ew") Wrapper<ProductMember> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductMember> listDefault(@Param("ctx") ProductMemberSearchContext context, @Param("ew") Wrapper<ProductMember> wrapper);

    /**
     * 数据集合cur_product分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProductMember> searchCurProduct(IPage<ProductMember> page, @Param("ctx") ProductMemberSearchContext context, @Param("ew") Wrapper<ProductMember> wrapper);
    
    /**
     * 数据集合cur_product查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProductMember> listCurProduct(@Param("ctx") ProductMemberSearchContext context, @Param("ew") Wrapper<ProductMember> wrapper);

    /**
    * 根据productId查询
    *
    * @param productIds
    * @return
    */
    List<ProductMember> findByProductId(@Param("productIds") List<String> productIds);

    /**
    * 根据userId查询
    *
    * @param userIds
    * @return
    */
    List<ProductMember> findByUserId(@Param("userIds") List<String> userIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    ProductMember selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ProductMember selectEntity(ProductMember entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ProductMember> selectEntities(@Param("list") List<ProductMember> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(ProductMember entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) ProductMember entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) ProductMember entity, @Param("ew") Wrapper<ProductMember> updateWrapper);

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
    int deleteEntities(@Param("list") List<ProductMember> list);

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