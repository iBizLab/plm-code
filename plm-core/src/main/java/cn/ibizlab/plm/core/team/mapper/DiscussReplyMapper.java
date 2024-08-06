/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.team.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.team.filter.DiscussReplySearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 讨论回复Mapper[DiscussReply]
 *
 * @author generator
 */
public interface DiscussReplyMapper extends BaseMapper<DiscussReply> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussReply> searchDefault(IPage<DiscussReply> page, @Param("ctx") DiscussReplySearchContext context, @Param("ew") Wrapper<DiscussReply> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussReply> listDefault(@Param("ctx") DiscussReplySearchContext context, @Param("ew") Wrapper<DiscussReply> wrapper);

    /**
     * 数据集合my_reply分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussReply> searchMyReply(IPage<DiscussReply> page, @Param("ctx") DiscussReplySearchContext context, @Param("ew") Wrapper<DiscussReply> wrapper);
    
    /**
     * 数据集合my_reply查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussReply> listMyReply(@Param("ctx") DiscussReplySearchContext context, @Param("ew") Wrapper<DiscussReply> wrapper);

    /**
     * 数据集合recent分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussReply> searchRecent(IPage<DiscussReply> page, @Param("ctx") DiscussReplySearchContext context, @Param("ew") Wrapper<DiscussReply> wrapper);
    
    /**
     * 数据集合recent查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussReply> listRecent(@Param("ctx") DiscussReplySearchContext context, @Param("ew") Wrapper<DiscussReply> wrapper);

    /**
    * 根据postId查询
    *
    * @param postIds
    * @return
    */
    List<DiscussReply> findByPostId(@Param("postIds") List<String> postIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussReply> searchView(IPage<DiscussReply> page, @Param("ctx") DiscussReplySearchContext context, @Param("ew") Wrapper<DiscussReply> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussReply> listView(@Param("ctx") DiscussReplySearchContext context, @Param("ew") Wrapper<DiscussReply> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    DiscussReply selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    DiscussReply selectEntity(DiscussReply entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<DiscussReply> selectEntities(@Param("list") List<DiscussReply> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(DiscussReply entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) DiscussReply entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) DiscussReply entity, @Param("ew") Wrapper<DiscussReply> updateWrapper);

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
    int deleteEntities(@Param("list") List<DiscussReply> list);

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