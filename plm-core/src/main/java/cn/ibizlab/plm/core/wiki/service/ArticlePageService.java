/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.wiki.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.filter.ArticlePageSearchContext;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.domain.SharedSpace;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 页面服务接口[ArticlePageService]
 *
 * @author generator
 */
public interface ArticlePageService extends IService<ArticlePage> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ArticlePageService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ArticlePage et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ArticlePage> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ArticlePage et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ArticlePage> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ArticlePage().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ArticlePage et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ArticlePage> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ArticlePage().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ArticlePage> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ArticlePage get(String key) {
        return getSelf().get(new ArticlePage().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ArticlePage get(ArticlePage et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ArticlePage> get(Collection<String> keys) {
        List<ArticlePage> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ArticlePage().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ArticlePage> get(List<ArticlePage> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ArticlePage getDraft(ArticlePage et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(ArticlePage et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ArticlePage et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ArticlePage> list);

    /**
    * checkAccessPassword
    * 
    * @param et
    * @return
    */
    default ArticlePage checkAccessPassword(ArticlePage et) {
        return et;
    }

    /**
    * checkShared
    * 
    * @param key
    * @return
    */
    default ArticlePage checkShared(String key) {
        return getSelf().checkShared(new ArticlePage().setId(key));
    }

    /**
    * closedShared
    * 
    * @param et
    * @return
    */
    default ArticlePage closedShared(ArticlePage et) {
        return et;
    }

    /**
    * commitVersion
    * 
    * @param et
    * @return
    */
    default ArticlePage commitVersion(ArticlePage et) {
        return et;
    }

    /**
    * copyPage
    * 
    * @param et
    * @return
    */
    default ArticlePage copyPage(ArticlePage et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default ArticlePage delete(ArticlePage et) {
        return et;
    }

    /**
    * exportToPdf
    * 
    * @param et
    * @return
    */
    default ArticlePage exportToPdf(ArticlePage et) {
        return et;
    }

    /**
    * favorite
    * 
    * @param et
    * @return
    */
    default ArticlePage favorite(ArticlePage et) {
        return et;
    }

    /**
    * getDraftPages
    * 
    * @param et
    * @return
    */
    default ArticlePage getDraftPages(ArticlePage et) {
        return et;
    }

    /**
    * lockPage
    * 
    * @param et
    * @return
    */
    default ArticlePage lockPage(ArticlePage et) {
        return et;
    }

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<ArticlePage> moveOrder(ArticlePage et) {
        return new ArrayList<>();
    }

    /**
    * movePage
    * 
    * @param et
    * @return
    */
    default ArticlePage movePage(ArticlePage et) {
        return et;
    }

    /**
    * nameVersionSave
    * 
    * @param et
    * @return
    */
    default ArticlePage nameVersionSave(ArticlePage et) {
        return et;
    }

    /**
    * newDraftFormStencil
    * 
    * @param et
    * @return
    */
    default ArticlePage newDraftFormStencil(ArticlePage et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default ArticlePage nothing(ArticlePage et) {
        return et;
    }

    /**
    * publishPage
    * 
    * @param et
    * @return
    */
    default ArticlePage publishPage(ArticlePage et) {
        return et;
    }

    /**
    * publishPageTest
    * 
    * @param et
    * @return
    */
    default ArticlePage publishPageTest(ArticlePage et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default ArticlePage recover(ArticlePage et) {
        return et;
    }

    /**
    * recoverVersion
    * 
    * @param et
    * @return
    */
    default ArticlePage recoverVersion(ArticlePage et) {
        return et;
    }

    /**
    * saveToStencil
    * 
    * @param et
    * @return
    */
    default ArticlePage saveToStencil(ArticlePage et) {
        return et;
    }

    /**
    * shared
    * 
    * @param key
    * @return
    */
    default ArticlePage shared(String key) {
        return getSelf().shared(new ArticlePage().setId(key));
    }

    /**
    * sharedSetting
    * 
    * @param et
    * @return
    */
    default ArticlePage sharedSetting(ArticlePage et) {
        return et;
    }

    /**
    * sharedUrl
    * 
    * @param et
    * @return
    */
    default ArticlePage sharedUrl(ArticlePage et) {
        return et;
    }

    /**
    * unFavorite
    * 
    * @param et
    * @return
    */
    default ArticlePage unFavorite(ArticlePage et) {
        return et;
    }

    /**
    * unlockPage
    * 
    * @param et
    * @return
    */
    default ArticlePage unlockPage(ArticlePage et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchDefault(ArticlePageSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listDefault(ArticlePageSearchContext context);

    /**
    * fetchAdvancedSearch
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchAdvancedSearch(ArticlePageSearchContext context);

    /**
    * listAdvancedSearch
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listAdvancedSearch(ArticlePageSearchContext context);

    /**
    * fetchAllSharedPages
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchAllSharedPages(ArticlePageSearchContext context);

    /**
    * listAllSharedPages
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listAllSharedPages(ArticlePageSearchContext context);

    /**
    * fetchBaselineChoosePage
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchBaselineChoosePage(ArticlePageSearchContext context);

    /**
    * listBaselineChoosePage
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listBaselineChoosePage(ArticlePageSearchContext context);

    /**
    * fetchChooseShared
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchChooseShared(ArticlePageSearchContext context);

    /**
    * listChooseShared
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listChooseShared(ArticlePageSearchContext context);

    /**
    * fetchDraftPage
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchDraftPage(ArticlePageSearchContext context);

    /**
    * listDraftPage
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listDraftPage(ArticlePageSearchContext context);

    /**
    * fetchHomePage
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchHomePage(ArticlePageSearchContext context);

    /**
    * listHomePage
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listHomePage(ArticlePageSearchContext context);

    /**
    * fetchIsDeleted
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchIsDeleted(ArticlePageSearchContext context);

    /**
    * listIsDeleted
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listIsDeleted(ArticlePageSearchContext context);

    /**
    * fetchMyFavoritePage
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchMyFavoritePage(ArticlePageSearchContext context);

    /**
    * listMyFavoritePage
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listMyFavoritePage(ArticlePageSearchContext context);

    /**
    * fetchMyFilter
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchMyFilter(ArticlePageSearchContext context);

    /**
    * listMyFilter
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listMyFilter(ArticlePageSearchContext context);

    /**
    * fetchNoParentPage
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchNoParentPage(ArticlePageSearchContext context);

    /**
    * listNoParentPage
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listNoParentPage(ArticlePageSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchNormal(ArticlePageSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listNormal(ArticlePageSearchContext context);

    /**
    * fetchOnlyPage
    * 只查询页面。不包含分组及草稿
    * @param context
    * @return
    */
    Page<ArticlePage> fetchOnlyPage(ArticlePageSearchContext context);

    /**
    * listOnlyPage
    * 只查询页面。不包含分组及草稿
    * @param context
    * @return
    */
    List<ArticlePage> listOnlyPage(ArticlePageSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchReader(ArticlePageSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listReader(ArticlePageSearchContext context);

    /**
    * fetchSharedPage
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchSharedPage(ArticlePageSearchContext context);

    /**
    * listSharedPage
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listSharedPage(ArticlePageSearchContext context);

    /**
    * fetchSharedReader
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchSharedReader(ArticlePageSearchContext context);

    /**
    * listSharedReader
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listSharedReader(ArticlePageSearchContext context);

    /**
    * fetchSharedSearch
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchSharedSearch(ArticlePageSearchContext context);

    /**
    * listSharedSearch
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listSharedSearch(ArticlePageSearchContext context);

    /**
    * fetchSharedSubPages
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchSharedSubPages(ArticlePageSearchContext context);

    /**
    * listSharedSubPages
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listSharedSubPages(ArticlePageSearchContext context);

    /**
    * fetchSharedWithMe
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchSharedWithMe(ArticlePageSearchContext context);

    /**
    * listSharedWithMe
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listSharedWithMe(ArticlePageSearchContext context);

    /**
    * fetchSharedWithMeEdit
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchSharedWithMeEdit(ArticlePageSearchContext context);

    /**
    * listSharedWithMeEdit
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listSharedWithMeEdit(ArticlePageSearchContext context);

    /**
    * findByParentId
    * @param parentIds
    * @return
    */
    List<ArticlePage> findByParentId(List<String> parentIds);
    default List<ArticlePage> findByParentId(String parentId){
        return findByPage(new ArticlePage().setId(parentId));
    }

    /**
    * findByPage
    * @param articlePage
    * @return
    */
    List<ArticlePage> findByPage(ArticlePage articlePage);

    /**
    * removeByParentId
    * @param parentId
    * @return
    */
    boolean removeByParentId(String parentId);

    /**
    * resetByParentId
    * @param parentId
    * @return
    */
    boolean resetByParentId(String parentId);

    /**
    * saveByParentId
    * @param parentId
    * @param list
    * @return
    */
    default boolean saveByParentId(String parentId, List<ArticlePage> list){
        return getSelf().saveByPage(new ArticlePage().setId(parentId),list);
    }

    /**
    * saveByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage, List<ArticlePage> list);

    /**
    * findBySpaceId
    * @param spaceIds
    * @return
    */
    List<ArticlePage> findBySpaceId(List<String> spaceIds);
    default List<ArticlePage> findBySpaceId(String spaceId){
        return findBySpace(new Space().setId(spaceId));
    }

    /**
    * findBySpace
    * @param space
    * @return
    */
    List<ArticlePage> findBySpace(Space space);

    /**
    * removeBySpaceId
    * @param spaceId
    * @return
    */
    boolean removeBySpaceId(String spaceId);

    /**
    * resetBySpaceId
    * @param spaceId
    * @return
    */
    boolean resetBySpaceId(String spaceId);

    /**
    * saveBySpaceId
    * @param spaceId
    * @param list
    * @return
    */
    default boolean saveBySpaceId(String spaceId, List<ArticlePage> list){
        return getSelf().saveBySpace(new Space().setId(spaceId),list);
    }

    /**
    * saveBySpace
    * @param space
    * @param list
    * @return
    */
    boolean saveBySpace(Space space, List<ArticlePage> list);

    /**
    * findBySharedSpacePage
    * @param sharedSpace
    * @return
    */
    List<ArticlePage> findBySharedSpacePage(SharedSpace sharedSpace);

    /**
    * saveBySharedSpacePage
    * @param sharedSpace
    * @param list
    * @return
    */
    boolean saveBySharedSpacePage(SharedSpace sharedSpace, List<ArticlePage> list);

    default List<Attention> getAttentions(ArticlePage et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(ArticlePage et) {
        return new ArrayList<>();
    }

    /**
    * checkShared
    * 
    * @param et
    * @return
    */
    default ArticlePage checkShared(ArticlePage et) {
        return et;
    }

    /**
    * shared
    * 
    * @param et
    * @return
    */
    default ArticlePage shared(ArticlePage et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ArticlePage> fetchView(ArticlePageSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ArticlePage> listView(ArticlePageSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<ArticlePage> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ArticlePage et=list.get(i);
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
    default ArticlePage getEntity() {
        return new ArticlePage();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ArticlePageSearchContext getSearchContext() {
        return new ArticlePageSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}