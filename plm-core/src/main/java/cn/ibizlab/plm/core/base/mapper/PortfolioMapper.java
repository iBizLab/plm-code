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
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.filter.PortfolioSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 文件夹Mapper[Portfolio]
 *
 * @author generator
 */
public interface PortfolioMapper extends BaseMapper<Portfolio> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchDefault(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listDefault(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合admin分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchAdmin(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合admin查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listAdmin(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合choose_project_portfolio分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchChooseProjectPortfolio(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合choose_project_portfolio查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listChooseProjectPortfolio(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合favorite分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchFavorite(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合favorite查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listFavorite(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合project_set_deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchProjectSetDeleted(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合project_set_deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listProjectSetDeleted(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合project_set_going分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchProjectSetGoing(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合project_set_going查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listProjectSetGoing(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchReader(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listReader(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合user分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchUser(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合user查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listUser(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合work_project_portfolio分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchWorkProjectPortfolio(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合work_project_portfolio查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listWorkProjectPortfolio(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Portfolio> searchView(IPage<Portfolio> page, @Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Portfolio> listView(@Param("ctx") PortfolioSearchContext context, @Param("ew") Wrapper<Portfolio> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    Portfolio selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    Portfolio selectEntity(Portfolio entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<Portfolio> selectEntities(@Param("list") List<Portfolio> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Portfolio entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) Portfolio entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) Portfolio entity, @Param("ew") Wrapper<Portfolio> updateWrapper);

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
    int deleteEntities(@Param("list") List<Portfolio> list);

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