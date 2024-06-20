/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.insight.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.core.insight.filter.InsightMemberSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 效能成员Mapper[InsightMember]
 *
 * @author generator
 */
public interface InsightMemberMapper extends BaseMapper<InsightMember> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightMember> searchDefault(IPage<InsightMember> page, @Param("ctx") InsightMemberSearchContext context, @Param("ew") Wrapper<InsightMember> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightMember> listDefault(@Param("ctx") InsightMemberSearchContext context, @Param("ew") Wrapper<InsightMember> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<InsightMember> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
    * 根据userId查询
    *
    * @param userIds
    * @return
    */
    List<InsightMember> findByUserId(@Param("userIds") List<String> userIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    InsightMember selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    InsightMember selectEntity(InsightMember entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<InsightMember> selectEntities(@Param("list") List<InsightMember> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(InsightMember entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) InsightMember entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) InsightMember entity, @Param("ew") Wrapper<InsightMember> updateWrapper);

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
    int deleteEntities(@Param("list") List<InsightMember> list);

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