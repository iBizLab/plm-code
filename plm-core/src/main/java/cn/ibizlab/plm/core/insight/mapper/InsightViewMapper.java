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
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.insight.filter.InsightViewSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 效能视图Mapper[InsightView]
 *
 * @author generator
 */
public interface InsightViewMapper extends BaseMapper<InsightView> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightView> searchDefault(IPage<InsightView> page, @Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightView> listDefault(@Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);

    /**
     * 数据集合admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightView> searchAdmin(IPage<InsightView> page, @Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);
    
    /**
     * 数据集合admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightView> listAdmin(@Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);

    /**
     * 数据集合favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightView> searchFavorite(IPage<InsightView> page, @Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);
    
    /**
     * 数据集合favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightView> listFavorite(@Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);

    /**
     * 数据集合main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightView> searchMain(IPage<InsightView> page, @Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);
    
    /**
     * 数据集合main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightView> listMain(@Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightView> searchNormal(IPage<InsightView> page, @Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightView> listNormal(@Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightView> searchReader(IPage<InsightView> page, @Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightView> listReader(@Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);

    /**
     * 数据集合user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<InsightView> searchUser(IPage<InsightView> page, @Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);
    
    /**
     * 数据集合user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<InsightView> listUser(@Param("ctx") InsightViewSearchContext context, @Param("ew") Wrapper<InsightView> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    InsightView selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    InsightView selectEntity(InsightView entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<InsightView> selectEntities(@Param("list") List<InsightView> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(InsightView entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) InsightView entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) InsightView entity, @Param("ew") Wrapper<InsightView> updateWrapper);

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
    int deleteEntities(@Param("list") List<InsightView> list);

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