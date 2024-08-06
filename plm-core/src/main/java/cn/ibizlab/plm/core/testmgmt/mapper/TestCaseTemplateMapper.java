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
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseTemplateSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 用例模板Mapper[TestCaseTemplate]
 *
 * @author generator
 */
public interface TestCaseTemplateMapper extends BaseMapper<TestCaseTemplate> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCaseTemplate> searchDefault(IPage<TestCaseTemplate> page, @Param("ctx") TestCaseTemplateSearchContext context, @Param("ew") Wrapper<TestCaseTemplate> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCaseTemplate> listDefault(@Param("ctx") TestCaseTemplateSearchContext context, @Param("ew") Wrapper<TestCaseTemplate> wrapper);

    /**
    * 根据testLibraryId查询
    *
    * @param testLibraryIds
    * @return
    */
    List<TestCaseTemplate> findByTestLibraryId(@Param("testLibraryIds") List<String> testLibraryIds);

    /**
    * 根据suiteId查询
    *
    * @param suiteIds
    * @return
    */
    List<TestCaseTemplate> findBySuiteId(@Param("suiteIds") List<String> suiteIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<TestCaseTemplate> searchView(IPage<TestCaseTemplate> page, @Param("ctx") TestCaseTemplateSearchContext context, @Param("ew") Wrapper<TestCaseTemplate> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<TestCaseTemplate> listView(@Param("ctx") TestCaseTemplateSearchContext context, @Param("ew") Wrapper<TestCaseTemplate> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    TestCaseTemplate selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    TestCaseTemplate selectEntity(TestCaseTemplate entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<TestCaseTemplate> selectEntities(@Param("list") List<TestCaseTemplate> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(TestCaseTemplate entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) TestCaseTemplate entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) TestCaseTemplate entity, @Param("ew") Wrapper<TestCaseTemplate> updateWrapper);

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
    int deleteEntities(@Param("list") List<TestCaseTemplate> list);

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