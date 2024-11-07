/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.wiki.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.wiki.domain.SpaceMember;
import cn.ibizlab.plm.core.wiki.filter.SpaceMemberSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 空间成员Mapper[SpaceMember]
 *
 * @author generator
 */
public interface SpaceMemberMapper extends BaseMapper<SpaceMember> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SpaceMember> searchDefault(IPage<SpaceMember> page, @Param("ctx") SpaceMemberSearchContext context, @Param("ew") Wrapper<SpaceMember> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SpaceMember> listDefault(@Param("ctx") SpaceMemberSearchContext context, @Param("ew") Wrapper<SpaceMember> wrapper);

    /**
     * 数据集合cur_space分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SpaceMember> searchCurSpace(IPage<SpaceMember> page, @Param("ctx") SpaceMemberSearchContext context, @Param("ew") Wrapper<SpaceMember> wrapper);
    
    /**
     * 数据集合cur_space查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SpaceMember> listCurSpace(@Param("ctx") SpaceMemberSearchContext context, @Param("ew") Wrapper<SpaceMember> wrapper);

    /**
     * 数据集合no_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SpaceMember> searchNoAttention(IPage<SpaceMember> page, @Param("ctx") SpaceMemberSearchContext context, @Param("ew") Wrapper<SpaceMember> wrapper);
    
    /**
     * 数据集合no_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SpaceMember> listNoAttention(@Param("ctx") SpaceMemberSearchContext context, @Param("ew") Wrapper<SpaceMember> wrapper);

    /**
    * 根据spaceId查询
    *
    * @param spaceIds
    * @return
    */
    List<SpaceMember> findBySpaceId(@Param("spaceIds") List<String> spaceIds);

    /**
    * 根据userId查询
    *
    * @param userIds
    * @return
    */
    List<SpaceMember> findByUserId(@Param("userIds") List<String> userIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SpaceMember> searchView(IPage<SpaceMember> page, @Param("ctx") SpaceMemberSearchContext context, @Param("ew") Wrapper<SpaceMember> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SpaceMember> listView(@Param("ctx") SpaceMemberSearchContext context, @Param("ew") Wrapper<SpaceMember> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    SpaceMember selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    SpaceMember selectEntity(SpaceMember entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<SpaceMember> selectEntities(@Param("list") List<SpaceMember> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(SpaceMember entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) SpaceMember entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) SpaceMember entity, @Param("ew") Wrapper<SpaceMember> updateWrapper);

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
    int deleteEntities(@Param("list") List<SpaceMember> list);

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