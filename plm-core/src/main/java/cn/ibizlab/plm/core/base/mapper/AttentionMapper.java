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
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.filter.AttentionSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 关注Mapper[Attention]
 *
 * @author generator
 */
public interface AttentionMapper extends BaseMapper<Attention> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attention> searchDefault(IPage<Attention> page, @Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attention> listDefault(@Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);

    /**
     * 数据集合attention_by_ownerid分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attention> searchAttentionByOwnerid(IPage<Attention> page, @Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);
    
    /**
     * 数据集合attention_by_ownerid查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attention> listAttentionByOwnerid(@Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);

    /**
     * 数据集合comment_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attention> searchCommentAttention(IPage<Attention> page, @Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);
    
    /**
     * 数据集合comment_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attention> listCommentAttention(@Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);

    /**
     * 数据集合notify分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attention> searchNotify(IPage<Attention> page, @Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);
    
    /**
     * 数据集合notify查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attention> listNotify(@Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Attention> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attention> searchView(IPage<Attention> page, @Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attention> listView(@Param("ctx") AttentionSearchContext context, @Param("ew") Wrapper<Attention> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Attention selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Attention selectEntity(Attention entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Attention> selectEntities(@Param("list") List<Attention> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Attention entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Attention entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Attention entity, @Param("ew") Wrapper<Attention> updateWrapper);

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
    int deleteEntities(@Param("list") List<Attention> list);

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