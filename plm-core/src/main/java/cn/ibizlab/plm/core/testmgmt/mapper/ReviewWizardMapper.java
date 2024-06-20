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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewWizardSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 评审向导Mapper[ReviewWizard]
 *
 * @author generator
 */
public interface ReviewWizardMapper extends BaseMapper<ReviewWizard> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ReviewWizard> searchDefault(IPage<ReviewWizard> page, @Param("ctx") ReviewWizardSearchContext context, @Param("ew") Wrapper<ReviewWizard> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ReviewWizard> listDefault(@Param("ctx") ReviewWizardSearchContext context, @Param("ew") Wrapper<ReviewWizard> wrapper);

    /**
    * 根据guidelineId查询
    *
    * @param guidelineIds
    * @return
    */
    List<ReviewWizard> findByGuidelineId(@Param("guidelineIds") List<String> guidelineIds);

    /**
    * 根据libraryId查询
    *
    * @param libraryIds
    * @return
    */
    List<ReviewWizard> findByLibraryId(@Param("libraryIds") List<String> libraryIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    ReviewWizard selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ReviewWizard selectEntity(ReviewWizard entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ReviewWizard> selectEntities(@Param("list") List<ReviewWizard> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(ReviewWizard entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) ReviewWizard entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) ReviewWizard entity, @Param("ew") Wrapper<ReviewWizard> updateWrapper);

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
    int deleteEntities(@Param("list") List<ReviewWizard> list);

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