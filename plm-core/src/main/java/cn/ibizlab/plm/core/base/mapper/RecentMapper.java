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
import cn.ibizlab.plm.core.base.domain.Recent;
import cn.ibizlab.plm.core.base.filter.RecentSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 最近访问Mapper[Recent]
 *
 * @author generator
 */
public interface RecentMapper extends BaseMapper<Recent> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchDefault(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listDefault(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_access分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentAccess(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_access查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentAccess(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_curproduct_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentCurproductTicket(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_curproduct_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentCurproductTicket(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_curproject_child_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentCurprojectChildWorkItem(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_curproject_child_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentCurprojectChildWorkItem(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_curproject_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentCurprojectWorkItem(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_curproject_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentCurprojectWorkItem(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_idea分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentIdea(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_idea查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentIdea(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_page分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentPage(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_page查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentPage(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentProject(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentProject(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_test_case分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentTestCase(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_test_case查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentTestCase(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_test_case_index分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentTestCaseIndex(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_test_case_index查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentTestCaseIndex(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_ticket分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentTicket(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_ticket查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentTicket(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_use分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentUse(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_use查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentUse(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentWorkItem(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentWorkItem(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_work_item_and_nobug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentWorkItemAndNobug(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_work_item_and_nobug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentWorkItemAndNobug(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 数据集合Recent_work_item_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Recent> searchRecentWorkItemBug(IPage<Recent> page, @Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);
    
    /**
     * 数据集合Recent_work_item_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Recent> listRecentWorkItemBug(@Param("ctx") RecentSearchContext context, @Param("ew") Wrapper<Recent> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Recent selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Recent selectEntity(Recent entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Recent> selectEntities(@Param("list") List<Recent> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Recent entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Recent entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Recent entity, @Param("ew") Wrapper<Recent> updateWrapper);

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
    int deleteEntities(@Param("list") List<Recent> list);

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

    /**
     * 根据ownerId查询
     *
     * @param ownerIds
     * @return
     */
    List<Recent> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

}