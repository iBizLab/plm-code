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
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.filter.SpaceSearchContext;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.domain.SpaceMember;
import cn.ibizlab.plm.core.wiki.domain.Stencil;

/**
 * 空间服务接口[SpaceService]
 *
 * @author generator
 */
public interface SpaceService extends IService<Space> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SpaceService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Space get(Space et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Space get(String key) {
        return getSelf().get(new Space().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Space> getByIds(Collection<String> ids) {
        List<Space> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Space().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Space> getByEntities(List<Space> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Space getDraft(Space et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Space et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Space et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Space> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Space et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Space> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Space et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Space> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Space().setId(key));
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
    boolean remove(Space et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Space> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Space().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Space> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Space> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Space et=list.get(i);
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
     * CreateTemp
     * 
     * @param dto
     * @return
     */
    default Space createTemp(Space dto) {
        return dto;
    }

    /**
     * CreateTempMajor
     * 
     * @param dto
     * @return
     */
    default Space createTempMajor(Space dto) {
        return dto;
    }

    /**
     * UpdateTemp
     * 
     * @param dto
     * @return
     */
    default Space updateTemp(Space dto) {
        return dto;
    }

    /**
     * UpdateTempMajor
     * 
     * @param dto
     * @return
     */
    default Space updateTempMajor(Space dto) {
        return dto;
    }

    /**
     * RemoveTemp
     * 
     * @param keys
     * @return
     */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
     * RemoveTempMajor
     * 
     * @param keys
     * @return
     */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
     * GetTemp
     * 
     * @param key
     * @return
     */
    default Space getTemp(String key) {
        return null;
    }

    /**
     * GetTempMajor
     * 
     * @param key
     * @return
     */
    default Space getTempMajor(String key) {
        return null;
    }

    /**
     * GetDraftTemp
     * 
     * @param dto
     * @return
     */
    default Space getDraftTemp(Space dto) {
        return dto;
    }

    /**
     * GetDraftTempMajor
     * 
     * @param dto
     * @return
     */
    default Space getDraftTempMajor(Space dto) {
        return dto;
    }

    /**
     * Activate
     * 
     * @param dto
     * @return
     */
    default Space activate(Space dto) {
        return dto;
    }

    /**
     * Add_space
     * 
     * @param dto
     * @return
     */
    default Space addSpace(Space dto) {
        return dto;
    }

    /**
     * Archive
     * 
     * @param dto
     * @return
     */
    default Space archive(Space dto) {
        return dto;
    }

    /**
     * Del_relation
     * 
     * @param dto
     * @return
     */
    default Space delRelation(Space dto) {
        return dto;
    }

    /**
     * Delete
     * 
     * @param dto
     * @return
     */
    default Space delete(Space dto) {
        return dto;
    }

    /**
     * Favorite
     * 
     * @param dto
     * @return
     */
    default Space favorite(Space dto) {
        return dto;
    }

    /**
     * Move_out_category
     * 
     * @param dto
     * @return
     */
    default Space moveOutCategory(Space dto) {
        return dto;
    }

    /**
     * Nothing
     * 
     * @param dto
     * @return
     */
    default Space nothing(Space dto) {
        return dto;
    }

    /**
     * Other_re_space
     * 
     * @param dto
     * @return
     */
    default Space otherReSpace(Space dto) {
        return dto;
    }

    /**
     * Recover
     * 
     * @param dto
     * @return
     */
    default Space recover(Space dto) {
        return dto;
    }

    /**
     * Un_favorite
     * 
     * @param dto
     * @return
     */
    default Space unFavorite(Space dto) {
        return dto;
    }

    /**
     * searchAdmin
     * 
     * @param context
     * @return
     */
    Page<Space> searchAdmin(SpaceSearchContext context);
    /**
     * listAdmin
     * 
     * @param context
     * @return
     */
    List<Space> listAdmin(SpaceSearchContext context);

    /**
     * searchArchived
     * 
     * @param context
     * @return
     */
    Page<Space> searchArchived(SpaceSearchContext context);
    /**
     * listArchived
     * 
     * @param context
     * @return
     */
    List<Space> listArchived(SpaceSearchContext context);

    /**
     * searchCategory_space
     * 
     * @param context
     * @return
     */
    Page<Space> searchCategorySpace(SpaceSearchContext context);
    /**
     * listCategory_space
     * 
     * @param context
     * @return
     */
    List<Space> listCategorySpace(SpaceSearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Space> searchDefault(SpaceSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Space> listDefault(SpaceSearchContext context);

    /**
     * searchDeleted
     * 
     * @param context
     * @return
     */
    Page<Space> searchDeleted(SpaceSearchContext context);
    /**
     * listDeleted
     * 
     * @param context
     * @return
     */
    List<Space> listDeleted(SpaceSearchContext context);

    /**
     * searchFavorite
     * 
     * @param context
     * @return
     */
    Page<Space> searchFavorite(SpaceSearchContext context);
    /**
     * listFavorite
     * 
     * @param context
     * @return
     */
    List<Space> listFavorite(SpaceSearchContext context);

    /**
     * searchNo_category_space
     * 
     * @param context
     * @return
     */
    Page<Space> searchNoCategorySpace(SpaceSearchContext context);
    /**
     * listNo_category_space
     * 
     * @param context
     * @return
     */
    List<Space> listNoCategorySpace(SpaceSearchContext context);

    /**
     * searchNo_re_space
     * 
     * @param context
     * @return
     */
    Page<Space> searchNoReSpace(SpaceSearchContext context);
    /**
     * listNo_re_space
     * 
     * @param context
     * @return
     */
    List<Space> listNoReSpace(SpaceSearchContext context);

    /**
     * searchNormal
     * 
     * @param context
     * @return
     */
    Page<Space> searchNormal(SpaceSearchContext context);
    /**
     * listNormal
     * 
     * @param context
     * @return
     */
    List<Space> listNormal(SpaceSearchContext context);

    /**
     * searchOther_re_space
     * 
     * @param context
     * @return
     */
    Page<Space> searchOtherReSpace(SpaceSearchContext context);
    /**
     * listOther_re_space
     * 
     * @param context
     * @return
     */
    List<Space> listOtherReSpace(SpaceSearchContext context);

    /**
     * searchUser
     * 
     * @param context
     * @return
     */
    Page<Space> searchUser(SpaceSearchContext context);
    /**
     * listUser
     * 
     * @param context
     * @return
     */
    List<Space> listUser(SpaceSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Space getEntity() {
        return new Space();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default SpaceSearchContext getSearchContext() {
        return new SpaceSearchContext();
    }
    /**
     * selectRelByCategoryId
     * @param categoryIds
     * @return
     */
    List<Space> findByCategoryId(List<String> categoryIds);
    default List<Space> findByCategoryId(String categoryId) {
        return findByCategoryId(Arrays.asList(categoryId));
    }
    /**
     * removeRelByCategoryId
     * @param categoryId
     * @return
     */
    boolean removeByCategoryId(String categoryId);
    /**
     * resetRelByCategoryId
     * @param categoryId
     * @return
     */
    boolean resetByCategoryId(String categoryId);
    /**
     * saveRelByCategoryId
     * @param categoryId
     * @param list
     * @return
     */
    default boolean saveByCategoryId(String categoryId,List<Space> list) {
        return getSelf().saveByCategory(new Category().setId(categoryId),list);
    }
    /**
    * saveRelByCategory
    * @param category
    * @param list
    * @return
    */
    boolean saveByCategory(Category category,List<Space> list);

    default List<SpaceMember> getMembers(Space et) {
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