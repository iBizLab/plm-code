/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.filter.VersionSearchContext;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 版本服务接口[VersionService]
 *
 * @author generator
 */
public interface VersionService extends IService<Version> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default VersionService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Version get(Version et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Version get(String key) {
        return getSelf().get(new Version().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Version> getByIds(Collection<String> ids) {
        List<Version> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Version().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Version> getByEntities(List<Version> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Version getDraft(Version et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Version et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Version et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Version> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Version et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Version> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Version et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Version> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Version().setId(key));
    }
    /**
     * 根据keys批量删除
     * @param keys
     * @return
     */
    default boolean remove(List<String> keys) {
        return removeBatch(keys);
    }
    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Version et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Version> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Version().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Version> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Version> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Version et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getName(),ex.getMessage());
                if(!ignoreError)
                    break;
            }
        }
        return rt;
    }

    /**
     * Commit
     * 
     * @param dto
     * @return
     */
    default Version commit(Version dto) {
        return dto;
    }

    /**
     * Restore
     * 
     * @param dto
     * @return
     */
    default Version restore(Version dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Version> searchDefault(VersionSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Version> listDefault(VersionSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Version getEntity() {
        return new Version();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default VersionSearchContext getSearchContext() {
        return new VersionSearchContext();
    }
    /**
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<Version> findByOwnerId(List<String> ownerIds);
    default List<Version> findByOwnerId(String ownerId) {
        return findByOwnerId(Arrays.asList(ownerId));
    }
    /**
     * removeRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean removeByOwnerId(String ownerId);
    /**
     * resetRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean resetByOwnerId(String ownerId);
    /**
     * saveRelByOwnerId
     * @param ownerId
     * @param list
     * @return
     */
    default boolean saveByOwnerId(String ownerId,List<Version> list) {
        return getSelf().saveByPage(new ArticlePage().setId(ownerId),list);
    }
    /**
    * saveRelByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage,List<Version> list);

    /**
    * saveRelByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem,List<Version> list);


    /**
     * 自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    List<JSONObject> select(String sql, Map<String,Object> param);

    /**
     * 自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    boolean execute(String sql, Map<String,Object> param);

}