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
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.filter.SearchAttachmentSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 附件搜索Mapper[SearchAttachment]
 *
 * @author generator
 */
public interface SearchAttachmentMapper extends BaseMapper<SearchAttachment> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SearchAttachment> searchDefault(IPage<SearchAttachment> page, @Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SearchAttachment> listDefault(@Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);

    /**
     * 数据集合cur_product分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SearchAttachment> searchCurProduct(IPage<SearchAttachment> page, @Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);
    
    /**
     * 数据集合cur_product查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SearchAttachment> listCurProduct(@Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);

    /**
     * 数据集合cur_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SearchAttachment> searchCurProject(IPage<SearchAttachment> page, @Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);
    
    /**
     * 数据集合cur_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SearchAttachment> listCurProject(@Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);

    /**
     * 数据集合relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SearchAttachment> searchRelation(IPage<SearchAttachment> page, @Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);
    
    /**
     * 数据集合relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SearchAttachment> listRelation(@Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<SearchAttachment> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<SearchAttachment> searchView(IPage<SearchAttachment> page, @Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<SearchAttachment> listView(@Param("ctx") SearchAttachmentSearchContext context, @Param("ew") Wrapper<SearchAttachment> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    SearchAttachment selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    SearchAttachment selectEntity(SearchAttachment entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<SearchAttachment> selectEntities(@Param("list") List<SearchAttachment> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(SearchAttachment entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) SearchAttachment entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) SearchAttachment entity, @Param("ew") Wrapper<SearchAttachment> updateWrapper);

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
    int deleteEntities(@Param("list") List<SearchAttachment> list);

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