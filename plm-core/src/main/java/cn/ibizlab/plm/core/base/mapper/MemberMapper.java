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
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.filter.MemberSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 成员Mapper[Member]
 *
 * @author generator
 */
public interface MemberMapper extends BaseMapper<Member> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Member> searchDefault(IPage<Member> page, @Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Member> listDefault(@Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);

    /**
     * 数据集合no_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Member> searchNoAttention(IPage<Member> page, @Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);
    
    /**
     * 数据集合no_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Member> listNoAttention(@Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);

    /**
     * 数据集合shared_page_member分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Member> searchSharedPageMember(IPage<Member> page, @Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);
    
    /**
     * 数据集合shared_page_member查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Member> listSharedPageMember(@Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);

    /**
     * 数据集合user_group_admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Member> searchUserGroupAdmin(IPage<Member> page, @Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);
    
    /**
     * 数据集合user_group_admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Member> listUserGroupAdmin(@Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);

    /**
    * 根据positionId查询
    *
    * @param positionIds
    * @return
    */
    List<Member> findByPositionId(@Param("positionIds") List<String> positionIds);

    /**
    * 根据userId查询
    *
    * @param userIds
    * @return
    */
    List<Member> findByUserId(@Param("userIds") List<String> userIds);

    /**
    * 根据id查询
    *
    * @param ids
    * @return
    */
    List<Member> findById(@Param("ids") List<String> ids);

    /**
    * 根据ownerId查询
    *
    * @param ownerIds
    * @return
    */
    List<Member> findByOwnerId(@Param("ownerIds") List<String> ownerIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Member> searchView(IPage<Member> page, @Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Member> listView(@Param("ctx") MemberSearchContext context, @Param("ew") Wrapper<Member> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Member selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Member selectEntity(Member entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Member> selectEntities(@Param("list") List<Member> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Member entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Member entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Member entity, @Param("ew") Wrapper<Member> updateWrapper);

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
    int deleteEntities(@Param("list") List<Member> list);

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