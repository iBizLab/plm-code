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
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.filter.AttachmentSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 附件Mapper[Attachment]
 *
 * @author generator
 */
public interface AttachmentMapper extends BaseMapper<Attachment> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attachment> searchDefault(IPage<Attachment> page, @Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attachment> listDefault(@Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);

    /**
     * 数据集合mob_work_item_attachment分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attachment> searchMobWorkItemAttachment(IPage<Attachment> page, @Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);
    
    /**
     * 数据集合mob_work_item_attachment查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attachment> listMobWorkItemAttachment(@Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);

    /**
     * 数据集合project_deliverable分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attachment> searchProjectDeliverable(IPage<Attachment> page, @Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);
    
    /**
     * 数据集合project_deliverable查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attachment> listProjectDeliverable(@Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);

    /**
     * 数据集合work_item_deliverable分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attachment> searchWorkItemDeliverable(IPage<Attachment> page, @Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);
    
    /**
     * 数据集合work_item_deliverable查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attachment> listWorkItemDeliverable(@Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Attachment> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Attachment> searchView(IPage<Attachment> page, @Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Attachment> listView(@Param("ctx") AttachmentSearchContext context, @Param("ew") Wrapper<Attachment> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Attachment selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Attachment selectEntity(Attachment entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Attachment> selectEntities(@Param("list") List<Attachment> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Attachment entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Attachment entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Attachment entity, @Param("ew") Wrapper<Attachment> updateWrapper);

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
    int deleteEntities(@Param("list") List<Attachment> list);

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