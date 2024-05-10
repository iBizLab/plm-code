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
import cn.ibizlab.plm.core.base.domain.Group;
import cn.ibizlab.plm.core.base.filter.GroupSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 团队Mapper[Group]
 *
 * @author generator
 */
public interface GroupMapper extends BaseMapper<Group> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Group> searchDefault(IPage<Group> page, @Param("ctx") GroupSearchContext context, @Param("ew") Wrapper<Group> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Group> listDefault(@Param("ctx") GroupSearchContext context, @Param("ew") Wrapper<Group> wrapper);

    /**
     * 数据集合no_section分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Group> searchNoSection(IPage<Group> page, @Param("ctx") GroupSearchContext context, @Param("ew") Wrapper<Group> wrapper);
    
    /**
     * 数据集合no_section查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Group> listNoSection(@Param("ctx") GroupSearchContext context, @Param("ew") Wrapper<Group> wrapper);

    /**
     * 数据集合user_group_admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Group> searchUserGroupAdmin(IPage<Group> page, @Param("ctx") GroupSearchContext context, @Param("ew") Wrapper<Group> wrapper);
    
    /**
     * 数据集合user_group_admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Group> listUserGroupAdmin(@Param("ctx") GroupSearchContext context, @Param("ew") Wrapper<Group> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Group selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Group selectEntity(Group entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Group> selectEntities(@Param("list") List<Group> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Group entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Group entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Group entity, @Param("ew") Wrapper<Group> updateWrapper);

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
    int deleteEntities(@Param("list") List<Group> list);

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

    /**
     * 根据sectionId查询
     *
     * @param sectionIds
     * @return
     */
    List<Group> findBySectionId(@Param("sectionIds") List<String> sectionIds);

}