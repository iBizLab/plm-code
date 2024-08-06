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
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.team.filter.DiscussTopicSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 话题Mapper[DiscussTopic]
 *
 * @author generator
 */
public interface DiscussTopicMapper extends BaseMapper<DiscussTopic> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchDefault(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listDefault(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchAdmin(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listAdmin(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchArchived(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listArchived(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合archived_main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchArchivedMain(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合archived_main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listArchivedMain(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchDeleted(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listDeleted(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchFavorite(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listFavorite(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合group分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchGroup(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合group查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listGroup(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合main分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchMain(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合main查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listMain(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchNormal(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listNormal(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合quick_user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchQuickUser(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合quick_user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listQuickUser(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchReader(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listReader(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchUser(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listUser(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<DiscussTopic> searchView(IPage<DiscussTopic> page, @Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<DiscussTopic> listView(@Param("ctx") DiscussTopicSearchContext context, @Param("ew") Wrapper<DiscussTopic> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    DiscussTopic selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    DiscussTopic selectEntity(DiscussTopic entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<DiscussTopic> selectEntities(@Param("list") List<DiscussTopic> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(DiscussTopic entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) DiscussTopic entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) DiscussTopic entity, @Param("ew") Wrapper<DiscussTopic> updateWrapper);

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
    int deleteEntities(@Param("list") List<DiscussTopic> list);

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