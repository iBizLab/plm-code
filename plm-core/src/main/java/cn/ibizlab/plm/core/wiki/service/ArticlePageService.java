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
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.filter.ArticlePageSearchContext;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Attachment;

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
     * 获取
     * @param et
     * @return
     */
    ArticlePage get(ArticlePage et);
    /**
     * 获取
     * @param key
     * @return
     */
    default ArticlePage get(String key) {
        return getSelf().get(new ArticlePage().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<ArticlePage> getByIds(Collection<String> ids) {
        List<ArticlePage> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ArticlePage().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<ArticlePage> getByEntities(List<ArticlePage> entities);

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
    Integer checkKey(ArticlePage et);

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
    boolean createBatch(List<ArticlePage> list);

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
    boolean updateBatch(List<ArticlePage> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(ArticlePage et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<ArticlePage> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ArticlePage().setId(key));
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
    boolean remove(ArticlePage et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<ArticlePage> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new ArticlePage().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<ArticlePage> entities);

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
     * Delete
     * 
     * @param dto
     * @return
     */
    default ArticlePage delete(ArticlePage dto) {
        return dto;
    }

    /**
     * Favorite
     * 
     * @param dto
     * @return
     */
    default ArticlePage favorite(ArticlePage dto) {
        return dto;
    }

    /**
     * Get_form_stencil
     * 
     * @param dto
     * @return
     */
    default ArticlePage getFormStencil(ArticlePage dto) {
        return dto;
    }

    /**
     * Nothing
     * 
     * @param dto
     * @return
     */
    default ArticlePage nothing(ArticlePage dto) {
        return dto;
    }

    /**
     * Recover
     * 
     * @param dto
     * @return
     */
    default ArticlePage recover(ArticlePage dto) {
        return dto;
    }

    /**
     * Save_to_stencil
     * 
     * @param dto
     * @return
     */
    default ArticlePage saveToStencil(ArticlePage dto) {
        return dto;
    }

    /**
     * Un_favorite
     * 
     * @param dto
     * @return
     */
    default ArticlePage unFavorite(ArticlePage dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<ArticlePage> searchDefault(ArticlePageSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<ArticlePage> listDefault(ArticlePageSearchContext context);

    /**
     * searchHome_page
     * 
     * @param context
     * @return
     */
    Page<ArticlePage> searchHomePage(ArticlePageSearchContext context);
    /**
     * listHome_page
     * 
     * @param context
     * @return
     */
    List<ArticlePage> listHomePage(ArticlePageSearchContext context);

    /**
     * searchIs_deleted
     * 
     * @param context
     * @return
     */
    Page<ArticlePage> searchIsDeleted(ArticlePageSearchContext context);
    /**
     * listIs_deleted
     * 
     * @param context
     * @return
     */
    List<ArticlePage> listIsDeleted(ArticlePageSearchContext context);

    /**
     * searchMy_favorite_page
     * 
     * @param context
     * @return
     */
    Page<ArticlePage> searchMyFavoritePage(ArticlePageSearchContext context);
    /**
     * listMy_favorite_page
     * 
     * @param context
     * @return
     */
    List<ArticlePage> listMyFavoritePage(ArticlePageSearchContext context);

    /**
     * searchNo_parent_page
     * 
     * @param context
     * @return
     */
    Page<ArticlePage> searchNoParentPage(ArticlePageSearchContext context);
    /**
     * listNo_parent_page
     * 
     * @param context
     * @return
     */
    List<ArticlePage> listNoParentPage(ArticlePageSearchContext context);

    /**
     * searchNormal
     * 
     * @param context
     * @return
     */
    Page<ArticlePage> searchNormal(ArticlePageSearchContext context);
    /**
     * listNormal
     * 
     * @param context
     * @return
     */
    List<ArticlePage> listNormal(ArticlePageSearchContext context);

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
     * selectRelByParentId
     * @param parentIds
     * @return
     */
    List<ArticlePage> findByParentId(List<String> parentIds);
    default List<ArticlePage> findByParentId(String parentId) {
        return findByParentId(Arrays.asList(parentId));
    }
    /**
     * removeRelByParentId
     * @param parentId
     * @return
     */
    boolean removeByParentId(String parentId);
    /**
     * resetRelByParentId
     * @param parentId
     * @return
     */
    boolean resetByParentId(String parentId);
    /**
     * saveRelByParentId
     * @param parentId
     * @param list
     * @return
     */
    default boolean saveByParentId(String parentId,List<ArticlePage> list) {
        return getSelf().saveByPage(new ArticlePage().setId(parentId),list);
    }
    /**
    * saveRelByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage,List<ArticlePage> list);

    /**
     * selectRelBySpaceId
     * @param spaceIds
     * @return
     */
    List<ArticlePage> findBySpaceId(List<String> spaceIds);
    default List<ArticlePage> findBySpaceId(String spaceId) {
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
    default boolean saveBySpaceId(String spaceId,List<ArticlePage> list) {
        return getSelf().saveBySpace(new Space().setId(spaceId),list);
    }
    /**
    * saveRelBySpace
    * @param space
    * @param list
    * @return
    */
    boolean saveBySpace(Space space,List<ArticlePage> list);

    default List<Attention> getAttentions(ArticlePage et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(ArticlePage et) {
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