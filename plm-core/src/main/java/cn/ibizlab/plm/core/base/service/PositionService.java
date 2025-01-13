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
import cn.ibizlab.plm.core.base.domain.Position;
import cn.ibizlab.plm.core.base.filter.PositionSearchContext;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 职位服务接口[PositionService]
 *
 * @author generator
 */
public interface PositionService extends IService<Position> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default PositionService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Position et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Position> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Position et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Position> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Position().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Position et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Position> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Position().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Position> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Position get(String key) {
        return getSelf().get(new Position().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Position get(Position et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Position> get(Collection<String> keys) {
        List<Position> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Position().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Position> get(List<Position> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Position getDraft(Position et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Position et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Position et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Position> list);

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<Position> moveOrder(Position et) {
        return new ArrayList<>();
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Position> fetchDefault(PositionSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Position> listDefault(PositionSearchContext context);

    /**
    * fetchNoCategory
    * 
    * @param context
    * @return
    */
    Page<Position> fetchNoCategory(PositionSearchContext context);

    /**
    * listNoCategory
    * 
    * @param context
    * @return
    */
    List<Position> listNoCategory(PositionSearchContext context);

    /**
    * findByCategoryId
    * @param categoryIds
    * @return
    */
    List<Position> findByCategoryId(List<String> categoryIds);
    default List<Position> findByCategoryId(String categoryId){
        return findByCategory(new Category().setId(categoryId));
    }

    /**
    * findByCategory
    * @param category
    * @return
    */
    List<Position> findByCategory(Category category);

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
    default boolean saveByCategoryId(String categoryId, List<Position> list){
        return getSelf().saveByCategory(new Category().setId(categoryId),list);
    }

    /**
    * saveByCategory
    * @param category
    * @param list
    * @return
    */
    boolean saveByCategory(Category category, List<Position> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Position> fetchView(PositionSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Position> listView(PositionSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Position> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Position et=list.get(i);
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
    default Position getEntity() {
        return new Position();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default PositionSearchContext getSearchContext() {
        return new PositionSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}