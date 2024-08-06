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
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.filter.CustomerSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 客户Mapper[Customer]
 *
 * @author generator
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Customer> searchDefault(IPage<Customer> page, @Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Customer> listDefault(@Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);

    /**
     * 数据集合comment_notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Customer> searchCommentNotifyAssignee(IPage<Customer> page, @Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);
    
    /**
     * 数据集合comment_notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Customer> listCommentNotifyAssignee(@Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);

    /**
     * 数据集合idea_notre_customer分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Customer> searchIdeaNotreCustomer(IPage<Customer> page, @Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);
    
    /**
     * 数据集合idea_notre_customer查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Customer> listIdeaNotreCustomer(@Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);

    /**
     * 数据集合idea_relation_customer分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Customer> searchIdeaRelationCustomer(IPage<Customer> page, @Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);
    
    /**
     * 数据集合idea_relation_customer查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Customer> listIdeaRelationCustomer(@Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Customer> searchNormal(IPage<Customer> page, @Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Customer> listNormal(@Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);

    /**
     * 数据集合notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Customer> searchNotifyAssignee(IPage<Customer> page, @Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);
    
    /**
     * 数据集合notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Customer> listNotifyAssignee(@Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);

    /**
    * 根据productId查询
    *
    * @param productIds
    * @return
    */
    List<Customer> findByProductId(@Param("productIds") List<String> productIds);

    /**
    * 根据assigneeId查询
    *
    * @param assigneeIds
    * @return
    */
    List<Customer> findByAssigneeId(@Param("assigneeIds") List<String> assigneeIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Customer> searchView(IPage<Customer> page, @Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Customer> listView(@Param("ctx") CustomerSearchContext context, @Param("ew") Wrapper<Customer> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Customer selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Customer selectEntity(Customer entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Customer> selectEntities(@Param("list") List<Customer> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Customer entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Customer entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Customer entity, @Param("ew") Wrapper<Customer> updateWrapper);

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
    int deleteEntities(@Param("list") List<Customer> list);

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