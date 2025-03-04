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
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 工时Mapper[Workload]
 *
 * @author generator
 */
public interface WorkloadMapper extends BaseMapper<Workload> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchDefault(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listDefault(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合bi_detail分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchBiDetail(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合bi_detail查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listBiDetail(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合bi_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchBiSearch(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合bi_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listBiSearch(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合calendar分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchCalendar(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合calendar查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listCalendar(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合idea_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchIdeaWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合idea_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listIdeaWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合log分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchLog(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合log查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listLog(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合member_dimension分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMemberDimension(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合member_dimension查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMemberDimension(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合mob_calendar分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchMobCalendar(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合mob_calendar查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listMobCalendar(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合my_calendar分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyCalendar(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合my_calendar查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyCalendar(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合my_idea_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyIdeaWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合my_idea_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyIdeaWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合my_log分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyLog(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合my_log查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyLog(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合my_mob_log分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyMobLog(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合my_mob_log查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyMobLog(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合my_test_case_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyTestCaseWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合my_test_case_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyTestCaseWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合my_type_of分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyTypeOf(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合my_type_of查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyTypeOf(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合my_work_item_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyWorkItemWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合my_work_item_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyWorkItemWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合my_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchMyWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合my_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listMyWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合test_case_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchTestCaseWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合test_case_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listTestCaseWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合type_of分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchTypeOf(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合type_of查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listTypeOf(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合user_group_link分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchUserGroupLink(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合user_group_link查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listUserGroupLink(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合user_group_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchUserGroupWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合user_group_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listUserGroupWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 数据集合work_item_workload分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchWorkItemWorkload(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合work_item_workload查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listWorkItemWorkload(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
    * 根据typeId查询
    *
    * @param typeIds
    * @return
    */
    List<Workload> findByTypeId(@Param("typeIds") List<String> typeIds);

    /**
    * 根据principalId查询
    *
    * @param principalIds
    * @return
    */
    List<Workload> findByPrincipalId(@Param("principalIds") List<String> principalIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Workload> searchView(IPage<Workload> page, @Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Workload> listView(@Param("ctx") WorkloadSearchContext context, @Param("ew") Wrapper<Workload> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Workload selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Workload selectEntity(Workload entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Workload> selectEntities(@Param("list") List<Workload> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Workload entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Workload entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Workload entity, @Param("ew") Wrapper<Workload> updateWrapper);

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
    int deleteEntities(@Param("list") List<Workload> list);

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