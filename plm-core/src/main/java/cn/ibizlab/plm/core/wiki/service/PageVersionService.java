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
    boolean create(List<PageVersion> list);

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
    boolean update(List<PageVersion> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new PageVersion().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(PageVersion et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<PageVersion> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new PageVersion().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<PageVersion> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default PageVersion get(String key) {
        return getSelf().get(new PageVersion().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    PageVersion get(PageVersion et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<PageVersion> get(Collection<String> keys) {
        List<PageVersion> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new PageVersion().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<PageVersion> get(List<PageVersion> entities);

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
    CheckKeyStatus checkKey(PageVersion et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(PageVersion et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<PageVersion> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<PageVersion> fetchDefault(PageVersionSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<PageVersion> listDefault(PageVersionSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<PageVersion> findByOwnerId(List<String> ownerIds);
    default List<PageVersion> findByOwnerId(String ownerId){
        return findByPage(new ArticlePage().setId(ownerId));
    }

    /**
    * findByPage
    * @param articlePage
    * @return
    */
    List<PageVersion> findByPage(ArticlePage articlePage);

    /**
    * removeByOwnerId
    * @param ownerId
    * @return
    */
    boolean removeByOwnerId(String ownerId);

    /**
    * resetByOwnerId
    * @param ownerId
    * @return
    */
    boolean resetByOwnerId(String ownerId);

    /**
    * saveByOwnerId
    * @param ownerId
    * @param list
    * @return
    */
    default boolean saveByOwnerId(String ownerId, List<PageVersion> list){
        return getSelf().saveByPage(new ArticlePage().setId(ownerId),list);
    }

    /**
    * saveByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage, List<PageVersion> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<PageVersion> fetchView(PageVersionSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<PageVersion> listView(PageVersionSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}