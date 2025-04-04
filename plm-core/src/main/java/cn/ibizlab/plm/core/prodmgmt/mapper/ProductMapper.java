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
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 产品Mapper[Product]
 *
 * @author generator
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchDefault(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listDefault(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchAdmin(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listAdmin(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchArchived(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listArchived(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合cur_product分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchCurProduct(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合cur_product查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listCurProduct(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合customer_user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchCustomerUser(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合customer_user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listCustomerUser(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchDeleted(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listDeleted(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchFavorite(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listFavorite(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchMain(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listMain(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合mob_main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchMobMain(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合mob_main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listMobMain(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合no_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchNoRelation(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合no_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listNoRelation(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchNormal(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listNormal(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合quick_user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchQuickUser(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合quick_user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listQuickUser(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchReader(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listReader(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchUser(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listUser(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Product> searchView(IPage<Product> page, @Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Product> listView(@Param("ctx") ProductSearchContext context, @Param("ew") Wrapper<Product> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Product selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Product selectEntity(Product entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Product> selectEntities(@Param("list") List<Product> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Product entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Product entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Product entity, @Param("ew") Wrapper<Product> updateWrapper);

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
    int deleteEntities(@Param("list") List<Product> list);

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