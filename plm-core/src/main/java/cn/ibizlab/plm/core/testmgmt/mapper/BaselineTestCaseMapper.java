/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@MINHERIT}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.testmgmt.filter.BaselineTestCaseSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 基线用例Mapper[BaselineTestCase]
 *
 * @author generator
 */
public interface BaselineTestCaseMapper extends BaseMapper<BaselineTestCase> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<BaselineTestCase> searchDefault(IPage<BaselineTestCase> page, @Param("ctx") BaselineTestCaseSearchContext context, @Param("ew") Wrapper<BaselineTestCase> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<BaselineTestCase> listDefault(@Param("ctx") BaselineTestCaseSearchContext context, @Param("ew") Wrapper<BaselineTestCase> wrapper);

    /**
     * 数据集合fill_version_data分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<BaselineTestCase> searchFillVersionData(IPage<BaselineTestCase> page, @Param("ctx") BaselineTestCaseSearchContext context, @Param("ew") Wrapper<BaselineTestCase> wrapper);
    
    /**
     * 数据集合fill_version_data查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<BaselineTestCase> listFillVersionData(@Param("ctx") BaselineTestCaseSearchContext context, @Param("ew") Wrapper<BaselineTestCase> wrapper);

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    @Override
    BaselineTestCase selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    BaselineTestCase selectEntity(BaselineTestCase entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<BaselineTestCase> selectEntities(@Param("list") List<BaselineTestCase> list);

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
     * 根据principalId查询
     *
     * @param principalIds
     * @return
     */
    List<BaselineTestCase> findByPrincipalId(@Param("principalIds") List<String> principalIds);

    /**
     * 根据targetVersionId查询
     *
     * @param targetVersionIds
     * @return
     */
    List<BaselineTestCase> findByTargetVersionId(@Param("targetVersionIds") List<String> targetVersionIds);

}