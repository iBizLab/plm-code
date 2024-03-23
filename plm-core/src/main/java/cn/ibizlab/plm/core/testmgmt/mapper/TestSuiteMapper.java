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
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.filter.TestSuiteSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 用例模块Mapper[TestSuite]
 *
 * @author generator
 */
public interface TestSuiteMapper extends BaseMapper<TestSuite> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestSuite> searchDefault(IPage<TestSuite> page, @Param("ctx") TestSuiteSearchContext context, @Param("ew") Wrapper<TestSuite> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestSuite> listDefault(@Param("ctx") TestSuiteSearchContext context, @Param("ew") Wrapper<TestSuite> wrapper);

    /**
     * 数据集合No_parent分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestSuite> searchNoParent(IPage<TestSuite> page, @Param("ctx") TestSuiteSearchContext context, @Param("ew") Wrapper<TestSuite> wrapper);
    
    /**
     * 数据集合No_parent查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestSuite> listNoParent(@Param("ctx") TestSuiteSearchContext context, @Param("ew") Wrapper<TestSuite> wrapper);

    /**
     * 数据集合Normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestSuite> searchNormal(IPage<TestSuite> page, @Param("ctx") TestSuiteSearchContext context, @Param("ew") Wrapper<TestSuite> wrapper);
    
    /**
     * 数据集合Normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestSuite> listNormal(@Param("ctx") TestSuiteSearchContext context, @Param("ew") Wrapper<TestSuite> wrapper);

    /**
     * 数据集合Root分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestSuite> searchRoot(IPage<TestSuite> page, @Param("ctx") TestSuiteSearchContext context, @Param("ew") Wrapper<TestSuite> wrapper);
    
    /**
     * 数据集合Root查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestSuite> listRoot(@Param("ctx") TestSuiteSearchContext context, @Param("ew") Wrapper<TestSuite> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    TestSuite selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    TestSuite selectEntity(TestSuite entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<TestSuite> selectEntities(@Param("list") List<TestSuite> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(TestSuite entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) TestSuite entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) TestSuite entity, @Param("ew") Wrapper<TestSuite> updateWrapper);

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
    int deleteEntities(@Param("list") List<TestSuite> list);

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
     * 根据libraryId查询
     *
     * @param libraryIds
     * @return
     */
    List<TestSuite> findByLibraryId(@Param("libraryIds") List<String> libraryIds);

    /**
     * 根据pid查询
     *
     * @param pids
     * @return
     */
    List<TestSuite> findByPid(@Param("pids") List<String> pids);

}