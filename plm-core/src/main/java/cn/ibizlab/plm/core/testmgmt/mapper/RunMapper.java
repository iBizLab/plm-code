/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.filter.RunSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 执行用例Mapper[Run]
 *
 * @author generator
 */
public interface RunMapper extends BaseMapper<Run> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Run> searchDefault(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Run> listDefault(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合ImplementationResults分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchImplementationResults(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合ImplementationResults查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listImplementationResults(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合bi_detail分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Run> searchBiDetail(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合bi_detail查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Run> listBiDetail(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合bi_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Run> searchBiSearch(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合bi_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Run> listBiSearch(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合casePerson分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchCasePerson(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合casePerson查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listCasePerson(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合comment_notify_executor分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Run> searchCommentNotifyExecutor(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合comment_notify_executor查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Run> listCommentNotifyExecutor(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Run> searchNormal(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Run> listNormal(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合plan_run_history分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Run> searchPlanRunHistory(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合plan_run_history查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Run> listPlanRunHistory(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合priorityDistributions分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchPriorityDistributions(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合priorityDistributions查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listPriorityDistributions(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Run> searchReader(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Run> listReader(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
    * 根据caseId查询
    *
    * @param caseIds
    * @return
    */
    List<Run> findByCaseId(@Param("caseIds") List<String> caseIds);

    /**
    * 根据planId查询
    *
    * @param planIds
    * @return
    */
    List<Run> findByPlanId(@Param("planIds") List<String> planIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Run> searchView(IPage<Run> page, @Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Run> listView(@Param("ctx") RunSearchContext context, @Param("ew") Wrapper<Run> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Run selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Run selectEntity(Run entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Run> selectEntities(@Param("list") List<Run> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Run entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Run entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Run entity, @Param("ew") Wrapper<Run> updateWrapper);

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
    int deleteEntities(@Param("list") List<Run> list);

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