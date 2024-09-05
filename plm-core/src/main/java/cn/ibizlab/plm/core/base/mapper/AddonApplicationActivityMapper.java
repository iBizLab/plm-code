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
import cn.ibizlab.plm.core.base.domain.AddonApplicationActivity;
import cn.ibizlab.plm.core.base.filter.AddonApplicationActivitySearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 应用插件活动Mapper[AddonApplicationActivity]
 *
 * @author generator
 */
public interface AddonApplicationActivityMapper extends BaseMapper<AddonApplicationActivity> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AddonApplicationActivity> searchDefault(IPage<AddonApplicationActivity> page, @Param("ctx") AddonApplicationActivitySearchContext context, @Param("ew") Wrapper<AddonApplicationActivity> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AddonApplicationActivity> listDefault(@Param("ctx") AddonApplicationActivitySearchContext context, @Param("ew") Wrapper<AddonApplicationActivity> wrapper);

    /**
    * 根据pid查询
    *
    * @param pids
    * @return
    */
    List<AddonApplicationActivity> findByPid(@Param("pids") List<String> pids);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<AddonApplicationActivity> searchView(IPage<AddonApplicationActivity> page, @Param("ctx") AddonApplicationActivitySearchContext context, @Param("ew") Wrapper<AddonApplicationActivity> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<AddonApplicationActivity> listView(@Param("ctx") AddonApplicationActivitySearchContext context, @Param("ew") Wrapper<AddonApplicationActivity> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    AddonApplicationActivity selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    AddonApplicationActivity selectEntity(AddonApplicationActivity entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<AddonApplicationActivity> selectEntities(@Param("list") List<AddonApplicationActivity> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(AddonApplicationActivity entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) AddonApplicationActivity entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) AddonApplicationActivity entity, @Param("ew") Wrapper<AddonApplicationActivity> updateWrapper);

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
    int deleteEntities(@Param("list") List<AddonApplicationActivity> list);

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