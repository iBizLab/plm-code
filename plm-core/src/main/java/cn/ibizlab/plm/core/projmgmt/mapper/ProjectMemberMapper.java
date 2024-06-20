/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 项目成员Mapper[ProjectMember]
 *
 * @author generator
 */
public interface ProjectMemberMapper extends BaseMapper<ProjectMember> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProjectMember> searchDefault(IPage<ProjectMember> page, @Param("ctx") ProjectMemberSearchContext context, @Param("ew") Wrapper<ProjectMember> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProjectMember> listDefault(@Param("ctx") ProjectMemberSearchContext context, @Param("ew") Wrapper<ProjectMember> wrapper);

    /**
     * 数据集合cur_project分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<ProjectMember> searchCurProject(IPage<ProjectMember> page, @Param("ctx") ProjectMemberSearchContext context, @Param("ew") Wrapper<ProjectMember> wrapper);
    
    /**
     * 数据集合cur_project查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<ProjectMember> listCurProject(@Param("ctx") ProjectMemberSearchContext context, @Param("ew") Wrapper<ProjectMember> wrapper);

    /**
    * 根据projectId查询
    *
    * @param projectIds
    * @return
    */
    List<ProjectMember> findByProjectId(@Param("projectIds") List<String> projectIds);

    /**
    * 根据userId查询
    *
    * @param userIds
    * @return
    */
    List<ProjectMember> findByUserId(@Param("userIds") List<String> userIds);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    ProjectMember selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    ProjectMember selectEntity(ProjectMember entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<ProjectMember> selectEntities(@Param("list") List<ProjectMember> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(ProjectMember entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) ProjectMember entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) ProjectMember entity, @Param("ew") Wrapper<ProjectMember> updateWrapper);

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
    int deleteEntities(@Param("list") List<ProjectMember> list);

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