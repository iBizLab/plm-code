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
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.core.wiki.filter.PageVersionSearchContext;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;

/**
 * 页面版本服务接口[PageVersionService]
 *
 * @author generator
 */
public interface PageVersionService extends IService<PageVersion> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default PageVersionService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    PageVersion get(PageVersion et);
    /**
     * 获取
     * @param key
     * @return
     */
    default PageVersion get(String key) {
        return getSelf().get(new PageVersion().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<PageVersion> getByIds(Collection<String> ids) {
        List<PageVersion> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new PageVersion().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<PageVersion> getByEntities(List<PageVersion> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    PageVersion getDraft(PageVersion et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(PageVersion et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(PageVersion et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<PageVersion> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(PageVersion et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<PageVersion> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(PageVersion et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<PageVersion> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new PageVersion().setId(key));
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
    boolean remove(PageVersion et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<PageVersion> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new PageVersion().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<PageVersion> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<PageVersion> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            PageVersion et=list.get(i);
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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<PageVersion> searchDefault(PageVersionSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<PageVersion> listDefault(PageVersionSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default PageVersion getEntity() {
        return new PageVersion();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default PageVersionSearchContext getSearchContext() {
        return new PageVersionSearchContext();
    }
    /**
     * selectRelByPageId
     * @param pageIds
     * @return
     */
    List<PageVersion> findByPageId(List<String> pageIds);
    default List<PageVersion> findByPageId(String pageId) {
        return findByPageId(Arrays.asList(pageId));
    }
    /**
     * removeRelByPageId
     * @param pageId
     * @return
     */
    boolean removeByPageId(String pageId);
    /**
     * resetRelByPageId
     * @param pageId
     * @return
     */
    boolean resetByPageId(String pageId);
    /**
     * saveRelByPageId
     * @param pageId
     * @param list
     * @return
     */
    default boolean saveByPageId(String pageId,List<PageVersion> list) {
        return getSelf().saveByPage(new ArticlePage().setId(pageId),list);
    }
    /**
    * saveRelByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage,List<PageVersion> list);


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