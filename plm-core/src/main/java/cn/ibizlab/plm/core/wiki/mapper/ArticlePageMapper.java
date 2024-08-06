/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.wiki.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.filter.ArticlePageSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 页面Mapper[ArticlePage]
 *
 * @author generator
 */
public interface ArticlePageMapper extends BaseMapper<ArticlePage> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchDefault(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listDefault(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合advanced_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchAdvancedSearch(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合advanced_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listAdvancedSearch(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合all_shared_pages分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchAllSharedPages(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合all_shared_pages查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listAllSharedPages(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合baseline_choose_page分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchBaselineChoosePage(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合baseline_choose_page查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listBaselineChoosePage(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合choose_shared分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchChooseShared(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合choose_shared查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listChooseShared(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合draft_page分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchDraftPage(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合draft_page查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listDraftPage(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合home_page分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchHomePage(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合home_page查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listHomePage(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合is_deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchIsDeleted(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合is_deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listIsDeleted(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合my_favorite_page分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchMyFavoritePage(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合my_favorite_page查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listMyFavoritePage(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合no_parent_page分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchNoParentPage(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合no_parent_page查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listNoParentPage(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchNormal(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listNormal(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合only_page分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchOnlyPage(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合only_page查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listOnlyPage(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合shared_page分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchSharedPage(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合shared_page查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listSharedPage(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合shared_reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchSharedReader(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合shared_reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listSharedReader(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合shared_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchSharedSearch(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合shared_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listSharedSearch(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合shared_sub_pages分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchSharedSubPages(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合shared_sub_pages查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listSharedSubPages(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合shared_with_me分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchSharedWithMe(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合shared_with_me查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listSharedWithMe(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 数据集合shared_with_me_edit分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchSharedWithMeEdit(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合shared_with_me_edit查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listSharedWithMeEdit(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
    * 根据parentId查询
    *
    * @param parentIds
    * @return
    */
    List<ArticlePage> findByParentId(@Param("parentIds") List<String> parentIds);

    /**
    * 根据spaceId查询
    *
    * @param spaceIds
    * @return
    */
    List<ArticlePage> findBySpaceId(@Param("spaceIds") List<String> spaceIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ArticlePage> searchView(IPage<ArticlePage> page, @Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ArticlePage> listView(@Param("ctx") ArticlePageSearchContext context, @Param("ew") Wrapper<ArticlePage> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    ArticlePage selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ArticlePage selectEntity(ArticlePage entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ArticlePage> selectEntities(@Param("list") List<ArticlePage> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(ArticlePage entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) ArticlePage entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) ArticlePage entity, @Param("ew") Wrapper<ArticlePage> updateWrapper);

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
    int deleteEntities(@Param("list") List<ArticlePage> list);

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