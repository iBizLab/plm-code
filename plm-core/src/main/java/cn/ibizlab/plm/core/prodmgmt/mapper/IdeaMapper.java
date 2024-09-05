/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 需求Mapper[Idea]
 *
 * @author generator
 */
public interface IdeaMapper extends BaseMapper<Idea> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchDefault(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listDefault(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合advanced_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchAdvancedSearch(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合advanced_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listAdvancedSearch(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchArchived(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listArchived(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合baseline_choose_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchBaselineChooseIdea(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合baseline_choose_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listBaselineChooseIdea(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合bi_detail分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchBiDetail(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合bi_detail查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listBiDetail(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合bi_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchBiSearch(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合bi_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listBiSearch(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合comment_notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchCommentNotifyAssignee(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合comment_notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listCommentNotifyAssignee(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合common分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchCommon(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合common查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listCommon(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchDeleted(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listDeleted(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合move_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchMoveIdea(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合move_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listMoveIdea(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合my_assign分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchMyAssign(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合my_assign查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listMyAssign(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合my_assignee_count分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchMyAssigneeCount(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合my_assignee_count查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listMyAssigneeCount(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合my_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchMyAttention(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合my_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listMyAttention(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合my_created分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchMyCreated(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合my_created查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listMyCreated(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合my_filter分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchMyFilter(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合my_filter查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listMyFilter(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchNormal(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listNormal(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合not_exsists_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchNotExsistsRelation(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合not_exsists_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listNotExsistsRelation(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchNotifyAssignee(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listNotifyAssignee(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合plan_relation_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchPlanRelationIdea(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合plan_relation_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listPlanRelationIdea(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchReader(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listReader(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 数据集合recent_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchRecentIdea(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合recent_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listRecentIdea(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
    * 根据categoryId查询
    *
    * @param categoryIds
    * @return
    */
    List<Idea> findByCategoryId(@Param("categoryIds") List<String> categoryIds);

    /**
    * 根据productId查询
    *
    * @param productIds
    * @return
    */
    List<Idea> findByProductId(@Param("productIds") List<String> productIds);

    /**
    * 根据assigneeId查询
    *
    * @param assigneeIds
    * @return
    */
    List<Idea> findByAssigneeId(@Param("assigneeIds") List<String> assigneeIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Idea> searchView(IPage<Idea> page, @Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Idea> listView(@Param("ctx") IdeaSearchContext context, @Param("ew") Wrapper<Idea> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Idea selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Idea selectEntity(Idea entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Idea> selectEntities(@Param("list") List<Idea> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Idea entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Idea entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Idea entity, @Param("ew") Wrapper<Idea> updateWrapper);

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
    int deleteEntities(@Param("list") List<Idea> list);

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