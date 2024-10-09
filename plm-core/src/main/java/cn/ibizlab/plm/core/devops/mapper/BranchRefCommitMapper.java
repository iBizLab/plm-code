/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.devops.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;
import cn.ibizlab.plm.core.devops.filter.BranchRefCommitSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 分支提交关联Mapper[BranchRefCommit]
 *
 * @author generator
 */
public interface BranchRefCommitMapper extends BaseMapper<BranchRefCommit> {

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<BranchRefCommit> searchDefault(IPage<BranchRefCommit> page, @Param("ctx") BranchRefCommitSearchContext context, @Param("ew") Wrapper<BranchRefCommit> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<BranchRefCommit> listDefault(@Param("ctx") BranchRefCommitSearchContext context, @Param("ew") Wrapper<BranchRefCommit> wrapper);

    /**
    * 根据metaId查询
    *
    * @param metaIds
    * @return
    */
    List<BranchRefCommit> findByMetaId(@Param("metaIds") List<String> metaIds);

    /**
    * 根据sha查询
    *
    * @param shas
    * @return
    */
    List<BranchRefCommit> findBySha(@Param("shas") List<String> shas);

    /**
    * 根据repositoryId查询
    *
    * @param repositoryIds
    * @return
    */
    List<BranchRefCommit> findByRepositoryId(@Param("repositoryIds") List<String> repositoryIds);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<BranchRefCommit> searchView(IPage<BranchRefCommit> page, @Param("ctx") BranchRefCommitSearchContext context, @Param("ew") Wrapper<BranchRefCommit> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<BranchRefCommit> listView(@Param("ctx") BranchRefCommitSearchContext context, @Param("ew") Wrapper<BranchRefCommit> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    BranchRefCommit selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    BranchRefCommit selectEntity(BranchRefCommit entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<BranchRefCommit> selectEntities(@Param("list") List<BranchRefCommit> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(BranchRefCommit entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) BranchRefCommit entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) BranchRefCommit entity, @Param("ew") Wrapper<BranchRefCommit> updateWrapper);

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
    int deleteEntities(@Param("list") List<BranchRefCommit> list);

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