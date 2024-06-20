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
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.domain.Baseline;

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
    boolean create(List<Space> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default Space createTemp(Space et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default Space createTempMajor(Space et) {
        return et;
    }

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
    boolean update(List<Space> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default Space updateTemp(Space et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default Space updateTempMajor(Space et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Space().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Space et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Space> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Space().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Space> entities);

    /**
    * removeTemp
    * 
    * @param keys
    * @return
    */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
    * removeTempMajor
    * 
    * @param keys
    * @return
    */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
    * 获取
    * @param key
    * @return
    */
    default Space get(String key) {
        return getSelf().get(new Space().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Space get(Space et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Space> get(Collection<String> keys) {
        List<Space> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Space().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Space> get(List<Space> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default Space getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default Space getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    Space getDraft(Space et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default Space getDraftTemp(Space et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default Space getDraftTempMajor(Space et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(Space et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Space et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Space> list);

    /**
    * activate
    * 
    * @param et
    * @return
    */
    default Space activate(Space et) {
        return et;
    }

    /**
    * archive
    * 
    * @param et
    * @return
    */
    default Space archive(Space et) {
        return et;
    }

    /**
    * changeAdminRole
    * 
    * @param et
    * @return
    */
    default Space changeAdminRole(Space et) {
        return et;
    }

    /**
    * delRelation
    * 
    * @param et
    * @return
    */
    default Space delRelation(Space et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default Space delete(Space et) {
        return et;
    }

    /**
    * favorite
    * 
    * @param et
    * @return
    */
    default Space favorite(Space et) {
        return et;
    }

    /**
    * moveOutCategory
    * 
    * @param et
    * @return
    */
    default Space moveOutCategory(Space et) {
        return et;
    }

    /**
    * moveSpace
    * 
    * @param et
    * @return
    */
    default Space moveSpace(Space et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Space nothing(Space et) {
        return et;
    }

    /**
    * otherReSpace
    * 
    * @param et
    * @return
    */
    default Space otherReSpace(Space et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default Space recover(Space et) {
        return et;
    }

    /**
    * spaceIndexAddonCounter
    * 
    * @param et
    * @return
    */
    default Space spaceIndexAddonCounter(Space et) {
        return et;
    }

    /**
    * unFavorite
    * 
    * @param et
    * @return
    */
    default Space unFavorite(Space et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Space> fetchDefault(SpaceSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Space> listDefault(SpaceSearchContext context);

    /**
    * fetchAdmin
    * 
    * @param context
    * @return
    */
    Page<Space> fetchAdmin(SpaceSearchContext context);

    /**
    * listAdmin
    * 
    * @param context
    * @return
    */
    List<Space> listAdmin(SpaceSearchContext context);

    /**
    * fetchArchived
    * 
    * @param context
    * @return
    */
    Page<Space> fetchArchived(SpaceSearchContext context);

    /**
    * listArchived
    * 
    * @param context
    * @return
    */
    List<Space> listArchived(SpaceSearchContext context);

    /**
    * fetchCategorySpace
    * 
    * @param context
    * @return
    */
    Page<Space> fetchCategorySpace(SpaceSearchContext context);

    /**
    * listCategorySpace
    * 
    * @param context
    * @return
    */
    List<Space> listCategorySpace(SpaceSearchContext context);

    /**
    * fetchCurrent
    * 
    * @param context
    * @return
    */
    Page<Space> fetchCurrent(SpaceSearchContext context);

    /**
    * listCurrent
    * 
    * @param context
    * @return
    */
    List<Space> listCurrent(SpaceSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<Space> fetchDeleted(SpaceSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<Space> listDeleted(SpaceSearchContext context);

    /**
    * fetchFavorite
    * 
    * @param context
    * @return
    */
    Page<Space> fetchFavorite(SpaceSearchContext context);

    /**
    * listFavorite
    * 
    * @param context
    * @return
    */
    List<Space> listFavorite(SpaceSearchContext context);

    /**
    * fetchMain
    * 
    * @param context
    * @return
    */
    Page<Space> fetchMain(SpaceSearchContext context);

    /**
    * listMain
    * 
    * @param context
    * @return
    */
    List<Space> listMain(SpaceSearchContext context);

    /**
    * fetchNoCategorySpace
    * 
    * @param context
    * @return
    */
    Page<Space> fetchNoCategorySpace(SpaceSearchContext context);

    /**
    * listNoCategorySpace
    * 
    * @param context
    * @return
    */
    List<Space> listNoCategorySpace(SpaceSearchContext context);

    /**
    * fetchNoReSpace
    * 
    * @param context
    * @return
    */
    Page<Space> fetchNoReSpace(SpaceSearchContext context);

    /**
    * listNoReSpace
    * 
    * @param context
    * @return
    */
    List<Space> listNoReSpace(SpaceSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<Space> fetchNormal(SpaceSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<Space> listNormal(SpaceSearchContext context);

    /**
    * fetchOtherReSpace
    * 
    * @param context
    * @return
    */
    Page<Space> fetchOtherReSpace(SpaceSearchContext context);

    /**
    * listOtherReSpace
    * 
    * @param context
    * @return
    */
    List<Space> listOtherReSpace(SpaceSearchContext context);

    /**
    * fetchQuickUser
    * 
    * @param context
    * @return
    */
    Page<Space> fetchQuickUser(SpaceSearchContext context);

    /**
    * listQuickUser
    * 
    * @param context
    * @return
    */
    List<Space> listQuickUser(SpaceSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Space> fetchReader(SpaceSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Space> listReader(SpaceSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<Space> fetchUser(SpaceSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<Space> listUser(SpaceSearchContext context);

    /**
    * findByCategoryId
    * @param categoryIds
    * @return
    */
    List<Space> findByCategoryId(List<String> categoryIds);
    default List<Space> findByCategoryId(String categoryId){
        return findByCategoryId(Arrays.asList(categoryId));
    }

    /**
    * removeByCategoryId
    * @param categoryId
    * @return
    */
    boolean removeByCategoryId(String categoryId);

    /**
    * resetByCategoryId
    * @param categoryId
    * @return
    */
    boolean resetByCategoryId(String categoryId);

    /**
    * saveByCategoryId
    * @param categoryId
    * @param list
    * @return
    */
    default boolean saveByCategoryId(String categoryId, List<Space> list){
        return getSelf().saveByCategory(new Category().setId(categoryId),list);
    }

    /**
    * saveByCategory
    * @param category
    * @param list
    * @return
    */
    boolean saveByCategory(Category category, List<Space> list);

    default List<SpaceMember> getMembers(Space et) {
        return new ArrayList<>();
    }


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}