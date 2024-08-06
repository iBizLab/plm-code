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
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.base.filter.PortfolioMemberSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 文件夹成员Mapper[PortfolioMember]
 *
 * @author generator
 */
public interface PortfolioMemberMapper extends BaseMapper<PortfolioMember> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<PortfolioMember> searchDefault(IPage<PortfolioMember> page, @Param("ctx") PortfolioMemberSearchContext context, @Param("ew") Wrapper<PortfolioMember> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<PortfolioMember> listDefault(@Param("ctx") PortfolioMemberSearchContext context, @Param("ew") Wrapper<PortfolioMember> wrapper);

    /**
     * 数据集合cur_project_set分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<PortfolioMember> searchCurProjectSet(IPage<PortfolioMember> page, @Param("ctx") PortfolioMemberSearchContext context, @Param("ew") Wrapper<PortfolioMember> wrapper);
    
    /**
     * 数据集合cur_project_set查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<PortfolioMember> listCurProjectSet(@Param("ctx") PortfolioMemberSearchContext context, @Param("ew") Wrapper<PortfolioMember> wrapper);

    /**
    * 根据portfolioId查询
    *
    * @param portfolioIds
    * @return
    */
    List<PortfolioMember> findByPortfolioId(@Param("portfolioIds") List<String> portfolioIds);

    /**
    * 根据userId查询
    *
    * @param userIds
    * @return
    */
    List<PortfolioMember> findByUserId(@Param("userIds") List<String> userIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<PortfolioMember> searchView(IPage<PortfolioMember> page, @Param("ctx") PortfolioMemberSearchContext context, @Param("ew") Wrapper<PortfolioMember> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<PortfolioMember> listView(@Param("ctx") PortfolioMemberSearchContext context, @Param("ew") Wrapper<PortfolioMember> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    PortfolioMember selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    PortfolioMember selectEntity(PortfolioMember entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<PortfolioMember> selectEntities(@Param("list") List<PortfolioMember> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(PortfolioMember entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) PortfolioMember entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) PortfolioMember entity, @Param("ew") Wrapper<PortfolioMember> updateWrapper);

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
    int deleteEntities(@Param("list") List<PortfolioMember> list);

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