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
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.filter.DiscussPostSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 讨论Mapper[DiscussPost]
 *
 * @author generator
 */
public interface DiscussPostMapper extends BaseMapper<DiscussPost> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchDefault(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listDefault(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 数据集合deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchDeleted(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listDeleted(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 数据集合mob_discuss_post_list分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchMobDiscussPostList(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合mob_discuss_post_list查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listMobDiscussPostList(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 数据集合my_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchMyAttention(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合my_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listMyAttention(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 数据集合my_create分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchMyCreate(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合my_create查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listMyCreate(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 数据集合my_reply分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchMyReply(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合my_reply查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listMyReply(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchNormal(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listNormal(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchReader(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listReader(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 数据集合recent分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchRecent(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合recent查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listRecent(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
    * 根据topicId查询
    *
    * @param topicIds
    * @return
    */
    List<DiscussPost> findByTopicId(@Param("topicIds") List<String> topicIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussPost> searchView(IPage<DiscussPost> page, @Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussPost> listView(@Param("ctx") DiscussPostSearchContext context, @Param("ew") Wrapper<DiscussPost> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    DiscussPost selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    DiscussPost selectEntity(DiscussPost entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<DiscussPost> selectEntities(@Param("list") List<DiscussPost> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(DiscussPost entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) DiscussPost entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) DiscussPost entity, @Param("ew") Wrapper<DiscussPost> updateWrapper);

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
    int deleteEntities(@Param("list") List<DiscussPost> list);

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