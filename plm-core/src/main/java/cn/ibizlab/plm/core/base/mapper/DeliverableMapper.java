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
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.base.filter.DeliverableSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 交付物Mapper[Deliverable]
 *
 * @author generator
 */
public interface DeliverableMapper extends BaseMapper<Deliverable> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Deliverable> searchDefault(IPage<Deliverable> page, @Param("ctx") DeliverableSearchContext context, @Param("ew") Wrapper<Deliverable> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Deliverable> listDefault(@Param("ctx") DeliverableSearchContext context, @Param("ew") Wrapper<Deliverable> wrapper);

    /**
     * 数据集合project_deliverable分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Deliverable> searchProjectDeliverable(IPage<Deliverable> page, @Param("ctx") DeliverableSearchContext context, @Param("ew") Wrapper<Deliverable> wrapper);
    
    /**
     * 数据集合project_deliverable查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Deliverable> listProjectDeliverable(@Param("ctx") DeliverableSearchContext context, @Param("ew") Wrapper<Deliverable> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Deliverable> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Deliverable> searchView(IPage<Deliverable> page, @Param("ctx") DeliverableSearchContext context, @Param("ew") Wrapper<Deliverable> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Deliverable> listView(@Param("ctx") DeliverableSearchContext context, @Param("ew") Wrapper<Deliverable> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Deliverable selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Deliverable selectEntity(Deliverable entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Deliverable> selectEntities(@Param("list") List<Deliverable> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Deliverable entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Deliverable entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Deliverable entity, @Param("ew") Wrapper<Deliverable> updateWrapper);

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
    int deleteEntities(@Param("list") List<Deliverable> list);

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