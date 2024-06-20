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
import cn.ibizlab.plm.core.prodmgmt.domain.TicketType;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketTypeSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 工单类型Mapper[TicketType]
 *
 * @author generator
 */
public interface TicketTypeMapper extends BaseMapper<TicketType> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TicketType> searchDefault(IPage<TicketType> page, @Param("ctx") TicketTypeSearchContext context, @Param("ew") Wrapper<TicketType> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TicketType> listDefault(@Param("ctx") TicketTypeSearchContext context, @Param("ew") Wrapper<TicketType> wrapper);

    /**
     * 数据集合not_exists_ticket_type分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TicketType> searchNotExistsTicketType(IPage<TicketType> page, @Param("ctx") TicketTypeSearchContext context, @Param("ew") Wrapper<TicketType> wrapper);
    
    /**
     * 数据集合not_exists_ticket_type查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TicketType> listNotExistsTicketType(@Param("ctx") TicketTypeSearchContext context, @Param("ew") Wrapper<TicketType> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    TicketType selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    TicketType selectEntity(TicketType entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<TicketType> selectEntities(@Param("list") List<TicketType> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(TicketType entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) TicketType entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) TicketType entity, @Param("ew") Wrapper<TicketType> updateWrapper);

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
    int deleteEntities(@Param("list") List<TicketType> list);

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