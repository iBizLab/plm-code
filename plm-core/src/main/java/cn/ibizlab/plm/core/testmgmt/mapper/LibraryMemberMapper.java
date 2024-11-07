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
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.testmgmt.filter.LibraryMemberSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 测试库成员Mapper[LibraryMember]
 *
 * @author generator
 */
public interface LibraryMemberMapper extends BaseMapper<LibraryMember> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<LibraryMember> searchDefault(IPage<LibraryMember> page, @Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<LibraryMember> listDefault(@Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);

    /**
     * 数据集合cur_library_member分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<LibraryMember> searchCurLibraryMember(IPage<LibraryMember> page, @Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);
    
    /**
     * 数据集合cur_library_member查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<LibraryMember> listCurLibraryMember(@Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);

    /**
     * 数据集合mob_cur_member分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<LibraryMember> searchMobCurMember(IPage<LibraryMember> page, @Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);
    
    /**
     * 数据集合mob_cur_member查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<LibraryMember> listMobCurMember(@Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);

    /**
     * 数据集合no_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<LibraryMember> searchNoAttention(IPage<LibraryMember> page, @Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);
    
    /**
     * 数据集合no_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<LibraryMember> listNoAttention(@Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);

    /**
    * 根据libraryId查询
    *
    * @param libraryIds
    * @return
    */
    List<LibraryMember> findByLibraryId(@Param("libraryIds") List<String> libraryIds);

    /**
    * 根据userId查询
    *
    * @param userIds
    * @return
    */
    List<LibraryMember> findByUserId(@Param("userIds") List<String> userIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<LibraryMember> searchView(IPage<LibraryMember> page, @Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<LibraryMember> listView(@Param("ctx") LibraryMemberSearchContext context, @Param("ew") Wrapper<LibraryMember> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    LibraryMember selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    LibraryMember selectEntity(LibraryMember entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<LibraryMember> selectEntities(@Param("list") List<LibraryMember> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(LibraryMember entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) LibraryMember entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) LibraryMember entity, @Param("ew") Wrapper<LibraryMember> updateWrapper);

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
    int deleteEntities(@Param("list") List<LibraryMember> list);

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