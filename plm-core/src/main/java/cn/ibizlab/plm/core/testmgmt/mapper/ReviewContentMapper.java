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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewContentSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 评审内容Mapper[ReviewContent]
 *
 * @author generator
 */
public interface ReviewContentMapper extends BaseMapper<ReviewContent> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ReviewContent> searchDefault(IPage<ReviewContent> page, @Param("ctx") ReviewContentSearchContext context, @Param("ew") Wrapper<ReviewContent> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ReviewContent> listDefault(@Param("ctx") ReviewContentSearchContext context, @Param("ew") Wrapper<ReviewContent> wrapper);

    /**
     * 数据集合all分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ReviewContent> searchAll(IPage<ReviewContent> page, @Param("ctx") ReviewContentSearchContext context, @Param("ew") Wrapper<ReviewContent> wrapper);
    
    /**
     * 数据集合all查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ReviewContent> listAll(@Param("ctx") ReviewContentSearchContext context, @Param("ew") Wrapper<ReviewContent> wrapper);

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    @Override
    ReviewContent selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ReviewContent selectEntity(ReviewContent entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ReviewContent> selectEntities(@Param("list") List<ReviewContent> list);

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
    List<ReviewContent> findByPrincipalId(@Param("principalIds") List<String> principalIds);

    /**
     * 根据targetVersionId查询
     *
     * @param targetVersionIds
     * @return
     */
    List<ReviewContent> findByTargetVersionId(@Param("targetVersionIds") List<String> targetVersionIds);

    /**
     * 根据targetId查询
     *
     * @param targetIds
     * @return
     */
    List<ReviewContent> findByTargetId(@Param("targetIds") List<String> targetIds);

}