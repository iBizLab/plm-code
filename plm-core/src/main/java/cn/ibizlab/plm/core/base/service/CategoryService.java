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
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.filter.CategorySearchContext;
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
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
     * 获取
     * @param et
     * @return
     */
    Category get(Category et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Category get(String key) {
        return getSelf().get(new Category().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Category> getByIds(Collection<String> ids) {
        List<Category> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Category().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Category> getByEntities(List<Category> entities);

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
    Integer checkKey(Category et);

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
    boolean createBatch(List<Category> list);

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
    boolean updateBatch(List<Category> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Category et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Category> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Category().setId(key));
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
    boolean remove(Category et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Category> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Category().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Category> entities);

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
     * Delete_child_category
     * 
     * @param dto
     * @return
     */
    default Category deleteChildCategory(Category dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Category> searchDefault(CategorySearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Category> listDefault(CategorySearchContext context);

    /**
     * searchNo_section
     * 
     * @param context
     * @return
     */
    Page<Category> searchNoSection(CategorySearchContext context);
    /**
     * listNo_section
     * 
     * @param context
     * @return
     */
    List<Category> listNoSection(CategorySearchContext context);

    /**
     * searchProduct_idea_category
     * 
     * @param context
     * @return
     */
    Page<Category> searchProductIdeaCategory(CategorySearchContext context);
    /**
     * listProduct_idea_category
     * 
     * @param context
     * @return
     */
    List<Category> listProductIdeaCategory(CategorySearchContext context);

    /**
     * searchProduct_plan
     * 
     * @param context
     * @return
     */
    Page<Category> searchProductPlan(CategorySearchContext context);
    /**
     * listProduct_plan
     * 
     * @param context
     * @return
     */
    List<Category> listProductPlan(CategorySearchContext context);

    /**
     * searchSpace_category
     * 
     * @param context
     * @return
     */
    Page<Category> searchSpaceCategory(CategorySearchContext context);
    /**
     * listSpace_category
     * 
     * @param context
     * @return
     */
    List<Category> listSpaceCategory(CategorySearchContext context);

    /**
     * searchSpace_category_top
     * 
     * @param context
     * @return
     */
    Page<Category> searchSpaceCategoryTop(CategorySearchContext context);
    /**
     * listSpace_category_top
     * 
     * @param context
     * @return
     */
    List<Category> listSpaceCategoryTop(CategorySearchContext context);

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
     * selectRelByPid
     * @param pids
     * @return
     */
    List<Category> findByPid(List<String> pids);
    default List<Category> findByPid(String pid) {
        return findByPid(Arrays.asList(pid));
    }
    /**
     * removeRelByPid
     * @param pid
     * @return
     */
    boolean removeByPid(String pid);
    /**
     * resetRelByPid
     * @param pid
     * @return
     */
    boolean resetByPid(String pid);
    /**
     * saveRelByPid
     * @param pid
     * @param list
     * @return
     */
    default boolean saveByPid(String pid,List<Category> list) {
        return getSelf().saveByCategory(new Category().setId(pid),list);
    }
    /**
    * saveRelByCategory
    * @param category
    * @param list
    * @return
    */
    boolean saveByCategory(Category category,List<Category> list);

    /**
     * selectRelBySectionId
     * @param sectionIds
     * @return
     */
    List<Category> findBySectionId(List<String> sectionIds);
    default List<Category> findBySectionId(String sectionId) {
        return findBySectionId(Arrays.asList(sectionId));
    }
    /**
     * removeRelBySectionId
     * @param sectionId
     * @return
     */
    boolean removeBySectionId(String sectionId);
    /**
     * resetRelBySectionId
     * @param sectionId
     * @return
     */
    boolean resetBySectionId(String sectionId);
    /**
     * saveRelBySectionId
     * @param sectionId
     * @param list
     * @return
     */
    default boolean saveBySectionId(String sectionId,List<Category> list) {
        return getSelf().saveBySection(new Section().setId(sectionId),list);
    }
    /**
    * saveRelBySection
    * @param section
    * @param list
    * @return
    */
    boolean saveBySection(Section section,List<Category> list);


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