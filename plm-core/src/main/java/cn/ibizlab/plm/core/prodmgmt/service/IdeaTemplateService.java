/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaTemplateSearchContext;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;

/**
 * 需求模板服务接口[IdeaTemplateService]
 *
 * @author generator
 */
public interface IdeaTemplateService extends IService<IdeaTemplate> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default IdeaTemplateService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(IdeaTemplate et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<IdeaTemplate> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(IdeaTemplate et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<IdeaTemplate> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new IdeaTemplate().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(IdeaTemplate et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<IdeaTemplate> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new IdeaTemplate().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<IdeaTemplate> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default IdeaTemplate get(String key) {
        return getSelf().get(new IdeaTemplate().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    IdeaTemplate get(IdeaTemplate et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<IdeaTemplate> get(Collection<String> keys) {
        List<IdeaTemplate> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new IdeaTemplate().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<IdeaTemplate> get(List<IdeaTemplate> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    IdeaTemplate getDraft(IdeaTemplate et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(IdeaTemplate et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(IdeaTemplate et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<IdeaTemplate> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<IdeaTemplate> fetchDefault(IdeaTemplateSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<IdeaTemplate> listDefault(IdeaTemplateSearchContext context);

    /**
    * findByCategoryId
    * @param categoryIds
    * @return
    */
    List<IdeaTemplate> findByCategoryId(List<String> categoryIds);
    default List<IdeaTemplate> findByCategoryId(String categoryId){
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
    default boolean saveByCategoryId(String categoryId, List<IdeaTemplate> list){
        return getSelf().saveByCategory(new Category().setId(categoryId),list);
    }

    /**
    * saveByCategory
    * @param category
    * @param list
    * @return
    */
    boolean saveByCategory(Category category, List<IdeaTemplate> list);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<IdeaTemplate> findByProductId(List<String> productIds);
    default List<IdeaTemplate> findByProductId(String productId){
        return findByProductId(Arrays.asList(productId));
    }

    /**
    * removeByProductId
    * @param productId
    * @return
    */
    boolean removeByProductId(String productId);

    /**
    * resetByProductId
    * @param productId
    * @return
    */
    boolean resetByProductId(String productId);

    /**
    * saveByProductId
    * @param productId
    * @param list
    * @return
    */
    default boolean saveByProductId(String productId, List<IdeaTemplate> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<IdeaTemplate> list);


    default ImportResult importData(String config, Boolean ignoreError, List<IdeaTemplate> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            IdeaTemplate et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getTitle(),ex.getMessage());
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
    default IdeaTemplate getEntity() {
        return new IdeaTemplate();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default IdeaTemplateSearchContext getSearchContext() {
        return new IdeaTemplateSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}