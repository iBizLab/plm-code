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
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.filter.SectionSearchContext;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.domain.Group;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 分组服务接口[SectionService]
 *
 * @author generator
 */
public interface SectionService extends IService<Section> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SectionService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Section et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Section> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Section et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Section> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Section().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Section et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Section> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Section().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Section> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Section get(String key) {
        return getSelf().get(new Section().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Section get(Section et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Section> get(Collection<String> keys) {
        List<Section> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Section().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Section> get(List<Section> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Section getDraft(Section et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Section et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Section et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Section> list);

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<Section> moveOrder(Section et) {
        return new ArrayList<>();
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Section> fetchDefault(SectionSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Section> listDefault(SectionSearchContext context);

    /**
    * fetchThisProductSection
    * 
    * @param context
    * @return
    */
    Page<Section> fetchThisProductSection(SectionSearchContext context);

    /**
    * listThisProductSection
    * 
    * @param context
    * @return
    */
    List<Section> listThisProductSection(SectionSearchContext context);

    /**
    * fetchCheckName
    * 
    * @param context
    * @return
    */
    Page<Section> fetchCheckName(SectionSearchContext context);

    /**
    * listCheckName
    * 
    * @param context
    * @return
    */
    List<Section> listCheckName(SectionSearchContext context);

    /**
    * fetchIdeaSection
    * 
    * @param context
    * @return
    */
    Page<Section> fetchIdeaSection(SectionSearchContext context);

    /**
    * listIdeaSection
    * 
    * @param context
    * @return
    */
    List<Section> listIdeaSection(SectionSearchContext context);

    /**
    * fetchMySection
    * 
    * @param context
    * @return
    */
    Page<Section> fetchMySection(SectionSearchContext context);

    /**
    * listMySection
    * 
    * @param context
    * @return
    */
    List<Section> listMySection(SectionSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Section> fetchView(SectionSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Section> listView(SectionSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Section> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Section et=list.get(i);
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
    default Section getEntity() {
        return new Section();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default SectionSearchContext getSearchContext() {
        return new SectionSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}