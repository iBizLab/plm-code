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
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.filter.AddonSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 组件Mapper[Addon]
 *
 * @author generator
 */
public interface AddonMapper extends BaseMapper<Addon> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Addon> searchDefault(IPage<Addon> page, @Param("ctx") AddonSearchContext context, @Param("ew") Wrapper<Addon> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Addon> listDefault(@Param("ctx") AddonSearchContext context, @Param("ew") Wrapper<Addon> wrapper);

    /**
     * 数据集合cur_owner_sys分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Addon> searchCurOwnerSys(IPage<Addon> page, @Param("ctx") AddonSearchContext context, @Param("ew") Wrapper<Addon> wrapper);
    
    /**
     * 数据集合cur_owner_sys查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Addon> listCurOwnerSys(@Param("ctx") AddonSearchContext context, @Param("ew") Wrapper<Addon> wrapper);

    /**
     * 数据集合psmodel_sync分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Addon> searchPsmodelSync(IPage<Addon> page, @Param("ctx") AddonSearchContext context, @Param("ew") Wrapper<Addon> wrapper);
    
    /**
     * 数据集合psmodel_sync查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Addon> listPsmodelSync(@Param("ctx") AddonSearchContext context, @Param("ew") Wrapper<Addon> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Addon> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Addon selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Addon selectEntity(Addon entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Addon> selectEntities(@Param("list") List<Addon> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Addon entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Addon entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Addon entity, @Param("ew") Wrapper<Addon> updateWrapper);

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
    int deleteEntities(@Param("list") List<Addon> list);

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