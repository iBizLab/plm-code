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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.filter.CategorySearchContext;
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.wiki.domain.Space;

/**
 * 类别服务接口[CategoryService]
 *
 * @author generator
 */
public interface CategoryService extends IService<Category> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default CategoryService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Category et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Category> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Category et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Category> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Category().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Category et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Category> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Category().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Category> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Category get(String key) {
        return getSelf().get(new Category().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Category get(Category et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Category> get(Collection<String> keys) {
        List<Category> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Category().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Category> get(List<Category> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Category getDraft(Category et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Category et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Category et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Category> list);

    /**
    * deleteChildCategory
    * 
    * @param et
    * @return
    */
    default Category deleteChildCategory(Category et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Category> fetchDefault(CategorySearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Category> listDefault(CategorySearchContext context);

    /**
    * fetchCheckName
    * 
    * @param context
    * @return
    */
    Page<Category> fetchCheckName(CategorySearchContext context);

    /**
    * listCheckName
    * 
    * @param context
    * @return
    */
    List<Category> listCheckName(CategorySearchContext context);

    /**
    * fetchCommonCategories
    * 
    * @param context
    * @return
    */
    Page<Category> fetchCommonCategories(CategorySearchContext context);

    /**
    * listCommonCategories
    * 
    * @param context
    * @return
    */
    List<Category> listCommonCategories(CategorySearchContext context);

    /**
    * fetchCurProductIdeaCategory
    * 
    * @param context
    * @return
    */
    Page<Category> fetchCurProductIdeaCategory(CategorySearchContext context);

    /**
    * listCurProductIdeaCategory
    * 
    * @param context
    * @return
    */
    List<Category> listCurProductIdeaCategory(CategorySearchContext context);

    /**
    * fetchNoSection
    * 
    * @param context
    * @return
    */
    Page<Category> fetchNoSection(CategorySearchContext context);

    /**
    * listNoSection
    * 
    * @param context
    * @return
    */
    List<Category> listNoSection(CategorySearchContext context);

    /**
    * fetchProductIdeaCategory
    * 需求下子产品中父标识为空的模块
    * @param context
    * @return
    */
    Page<Category> fetchProductIdeaCategory(CategorySearchContext context);

    /**
    * listProductIdeaCategory
    * 需求下子产品中父标识为空的模块
    * @param context
    * @return
    */
    List<Category> listProductIdeaCategory(CategorySearchContext context);

    /**
    * fetchProductPlan
    * 
    * @param context
    * @return
    */
    Page<Category> fetchProductPlan(CategorySearchContext context);

    /**
    * listProductPlan
    * 
    * @param context
    * @return
    */
    List<Category> listProductPlan(CategorySearchContext context);

    /**
    * fetchSpaceCategory
    * 
    * @param context
    * @return
    */
    Page<Category> fetchSpaceCategory(CategorySearchContext context);

    /**
    * listSpaceCategory
    * 
    * @param context
    * @return
    */
    List<Category> listSpaceCategory(CategorySearchContext context);

    /**
    * fetchSpaceCategoryTop
    * 
    * @param context
    * @return
    */
    Page<Category> fetchSpaceCategoryTop(CategorySearchContext context);

    /**
    * listSpaceCategoryTop
    * 
    * @param context
    * @return
    */
    List<Category> listSpaceCategoryTop(CategorySearchContext context);

    /**
    * findByPid
    * @param pids
    * @return
    */
    List<Category> findByPid(List<String> pids);
    default List<Category> findByPid(String pid){
        return findByCategory(new Category().setId(pid));
    }

    /**
    * findByCategory
    * @param category
    * @return
    */
    List<Category> findByCategory(Category category);

    /**
    * removeByPid
    * @param pid
    * @return
    */
    boolean removeByPid(String pid);

    /**
    * resetByPid
    * @param pid
    * @return
    */
    boolean resetByPid(String pid);

    /**
    * saveByPid
    * @param pid
    * @param list
    * @return
    */
    default boolean saveByPid(String pid, List<Category> list){
        return getSelf().saveByCategory(new Category().setId(pid),list);
    }

    /**
    * saveByCategory
    * @param category
    * @param list
    * @return
    */
    boolean saveByCategory(Category category, List<Category> list);

    /**
    * findBySectionId
    * @param sectionIds
    * @return
    */
    List<Category> findBySectionId(List<String> sectionIds);
    default List<Category> findBySectionId(String sectionId){
        return findBySection(new Section().setId(sectionId));
    }

    /**
    * findBySection
    * @param section
    * @return
    */
    List<Category> findBySection(Section section);

    /**
    * removeBySectionId
    * @param sectionId
    * @return
    */
    boolean removeBySectionId(String sectionId);

    /**
    * resetBySectionId
    * @param sectionId
    * @return
    */
    boolean resetBySectionId(String sectionId);

    /**
    * saveBySectionId
    * @param sectionId
    * @param list
    * @return
    */
    default boolean saveBySectionId(String sectionId, List<Category> list){
        return getSelf().saveBySection(new Section().setId(sectionId),list);
    }

    /**
    * saveBySection
    * @param section
    * @param list
    * @return
    */
    boolean saveBySection(Section section, List<Category> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Category> fetchView(CategorySearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Category> listView(CategorySearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Category> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Category et=list.get(i);
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
    default Category getEntity() {
        return new Category();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default CategorySearchContext getSearchContext() {
        return new CategorySearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}