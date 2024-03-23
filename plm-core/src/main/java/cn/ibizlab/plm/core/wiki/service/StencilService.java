/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.core.wiki.filter.StencilSearchContext;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.base.domain.Attachment;

/**
 * 页面模板服务接口[StencilService]
 *
 * @author generator
 */
public interface StencilService extends IService<Stencil> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default StencilService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Stencil get(Stencil et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Stencil get(String key) {
        return getSelf().get(new Stencil().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Stencil> getByIds(Collection<String> ids) {
        List<Stencil> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Stencil().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Stencil> getByEntities(List<Stencil> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Stencil getDraft(Stencil et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Stencil et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Stencil et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Stencil> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Stencil et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Stencil> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Stencil et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Stencil> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Stencil().setId(key));
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
    boolean remove(Stencil et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Stencil> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Stencil().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Stencil> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Stencil> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Stencil et=list.get(i);
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
     * Nothing
     * 
     * @param dto
     * @return
     */
    default Stencil nothing(Stencil dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Stencil> searchDefault(StencilSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Stencil> listDefault(StencilSearchContext context);

    /**
     * searchNo_space_stencil
     * 
     * @param context
     * @return
     */
    Page<Stencil> searchNoSpaceStencil(StencilSearchContext context);
    /**
     * listNo_space_stencil
     * 
     * @param context
     * @return
     */
    List<Stencil> listNoSpaceStencil(StencilSearchContext context);

    /**
     * searchSpace_stencil
     * 
     * @param context
     * @return
     */
    Page<Stencil> searchSpaceStencil(StencilSearchContext context);
    /**
     * listSpace_stencil
     * 
     * @param context
     * @return
     */
    List<Stencil> listSpaceStencil(StencilSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Stencil getEntity() {
        return new Stencil();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default StencilSearchContext getSearchContext() {
        return new StencilSearchContext();
    }
    /**
     * selectRelBySpaceId
     * @param spaceIds
     * @return
     */
    List<Stencil> findBySpaceId(List<String> spaceIds);
    default List<Stencil> findBySpaceId(String spaceId) {
        return findBySpaceId(Arrays.asList(spaceId));
    }
    /**
     * removeRelBySpaceId
     * @param spaceId
     * @return
     */
    boolean removeBySpaceId(String spaceId);
    /**
     * resetRelBySpaceId
     * @param spaceId
     * @return
     */
    boolean resetBySpaceId(String spaceId);
    /**
     * saveRelBySpaceId
     * @param spaceId
     * @param list
     * @return
     */
    default boolean saveBySpaceId(String spaceId,List<Stencil> list) {
        return getSelf().saveBySpace(new Space().setId(spaceId),list);
    }
    /**
    * saveRelBySpace
    * @param space
    * @param list
    * @return
    */
    boolean saveBySpace(Space space,List<Stencil> list);

    default List<Attachment> getAttachments(Stencil et) {
        return new ArrayList<>();
    }


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