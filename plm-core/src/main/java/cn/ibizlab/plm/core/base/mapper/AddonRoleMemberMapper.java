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
import cn.ibizlab.plm.core.base.domain.AddonRoleMember;
import cn.ibizlab.plm.core.base.filter.AddonRoleMemberSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 组件权限成员Mapper[AddonRoleMember]
 *
 * @author generator
 */
public interface AddonRoleMemberMapper extends BaseMapper<AddonRoleMember> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AddonRoleMember> searchDefault(IPage<AddonRoleMember> page, @Param("ctx") AddonRoleMemberSearchContext context, @Param("ew") Wrapper<AddonRoleMember> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AddonRoleMember> listDefault(@Param("ctx") AddonRoleMemberSearchContext context, @Param("ew") Wrapper<AddonRoleMember> wrapper);

    /**
    * 根据addonId查询
    *
    * @param addonIds
    * @return
    */
    List<AddonRoleMember> findByAddonId(@Param("addonIds") List<String> addonIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AddonRoleMember> searchView(IPage<AddonRoleMember> page, @Param("ctx") AddonRoleMemberSearchContext context, @Param("ew") Wrapper<AddonRoleMember> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AddonRoleMember> listView(@Param("ctx") AddonRoleMemberSearchContext context, @Param("ew") Wrapper<AddonRoleMember> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    AddonRoleMember selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    AddonRoleMember selectEntity(AddonRoleMember entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<AddonRoleMember> selectEntities(@Param("list") List<AddonRoleMember> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(AddonRoleMember entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) AddonRoleMember entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) AddonRoleMember entity, @Param("ew") Wrapper<AddonRoleMember> updateWrapper);

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
    int deleteEntities(@Param("list") List<AddonRoleMember> list);

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