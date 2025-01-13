/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.filter.BaselineSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 基线服务接口[BaselineService]
 *
 * @author generator
 */
public interface BaselineService extends IService<Baseline> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default BaselineService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Baseline et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Baseline> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Baseline et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Baseline> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Baseline().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Baseline et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Baseline> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Baseline().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Baseline> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Baseline get(String key) {
        return getSelf().get(new Baseline().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Baseline get(Baseline et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Baseline> get(Collection<String> keys) {
        List<Baseline> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Baseline().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Baseline> get(List<Baseline> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Baseline getDraft(Baseline et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Baseline et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Baseline et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Baseline> list);

    /**
    * deleteCategories
    * 
    * @param et
    * @return
    */
    default Baseline deleteCategories(Baseline et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Baseline nothing(Baseline et) {
        return et;
    }

    /**
    * planSnapshot
    * 
    * @param et
    * @return
    */
    default Baseline planSnapshot(Baseline et) {
        return et;
    }

    /**
    * setCompleteLibrary
    * 
    * @param et
    * @return
    */
    default Baseline setCompleteLibrary(Baseline et) {
        return et;
    }

    /**
    * setCompleteProduct
    * 
    * @param et
    * @return
    */
    default Baseline setCompleteProduct(Baseline et) {
        return et;
    }

    /**
    * setCompleteProject
    * 
    * @param et
    * @return
    */
    default Baseline setCompleteProject(Baseline et) {
        return et;
    }

    /**
    * setCompleteSpace
    * 
    * @param et
    * @return
    */
    default Baseline setCompleteSpace(Baseline et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Baseline> fetchDefault(BaselineSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Baseline> listDefault(BaselineSearchContext context);

    /**
    * fetchBaseline
    * 
    * @param context
    * @return
    */
    Page<Baseline> fetchBaseline(BaselineSearchContext context);

    /**
    * listBaseline
    * 
    * @param context
    * @return
    */
    List<Baseline> listBaseline(BaselineSearchContext context);

    /**
    * fetchSnapshot
    * 
    * @param context
    * @return
    */
    Page<Baseline> fetchSnapshot(BaselineSearchContext context);

    /**
    * listSnapshot
    * 
    * @param context
    * @return
    */
    List<Baseline> listSnapshot(BaselineSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Baseline> findByOwnerId(List<String> ownerIds);
    default List<Baseline> findByOwnerId(String ownerId){
        return findByLibrary(new Library().setId(ownerId));
    }

    /**
    * findByLibrary
    * @param library
    * @return
    */
    List<Baseline> findByLibrary(Library library);

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
    default boolean saveByOwnerId(String ownerId, List<Baseline> list){
        return getSelf().saveByLibrary(new Library().setId(ownerId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<Baseline> list);

    /**
    * findByProduct
    * @param product
    * @return
    */
    List<Baseline> findByProduct(Product product);

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<Baseline> list);

    /**
    * findByProject
    * @param project
    * @return
    */
    List<Baseline> findByProject(Project project);

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<Baseline> list);

    /**
    * findBySpace
    * @param space
    * @return
    */
    List<Baseline> findBySpace(Space space);

    /**
    * saveBySpace
    * @param space
    * @param list
    * @return
    */
    boolean saveBySpace(Space space, List<Baseline> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Baseline> fetchView(BaselineSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Baseline> listView(BaselineSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Baseline> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Baseline et=list.get(i);
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
    default Baseline getEntity() {
        return new Baseline();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default BaselineSearchContext getSearchContext() {
        return new BaselineSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}