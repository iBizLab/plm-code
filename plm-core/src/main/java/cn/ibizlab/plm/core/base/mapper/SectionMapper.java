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
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.filter.SectionSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 分组Mapper[Section]
 *
 * @author generator
 */
public interface SectionMapper extends BaseMapper<Section> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Section> searchDefault(IPage<Section> page, @Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Section> listDefault(@Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);

    /**
     * 数据集合This_product_section分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Section> searchThisProductSection(IPage<Section> page, @Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);
    
    /**
     * 数据集合This_product_section查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Section> listThisProductSection(@Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);

    /**
     * 数据集合check_name分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Section> searchCheckName(IPage<Section> page, @Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);
    
    /**
     * 数据集合check_name查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Section> listCheckName(@Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);

    /**
     * 数据集合idea_section分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Section> searchIdeaSection(IPage<Section> page, @Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);
    
    /**
     * 数据集合idea_section查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Section> listIdeaSection(@Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);

    /**
     * 数据集合my_section分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Section> searchMySection(IPage<Section> page, @Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);
    
    /**
     * 数据集合my_section查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Section> listMySection(@Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Section> searchView(IPage<Section> page, @Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Section> listView(@Param("ctx") SectionSearchContext context, @Param("ew") Wrapper<Section> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Section selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Section selectEntity(Section entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Section> selectEntities(@Param("list") List<Section> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Section entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Section entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Section entity, @Param("ew") Wrapper<Section> updateWrapper);

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
    int deleteEntities(@Param("list") List<Section> list);

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