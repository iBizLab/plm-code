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
import cn.ibizlab.plm.core.base.domain.Group;
import cn.ibizlab.plm.core.base.filter.GroupSearchContext;
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.domain.Member;

/**
 * 团队服务接口[GroupService]
 *
 * @author generator
 */
public interface GroupService extends IService<Group> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default GroupService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Group get(Group et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Group get(String key) {
        return getSelf().get(new Group().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Group> getByIds(Collection<String> ids) {
        List<Group> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Group().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Group> getByEntities(List<Group> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Group getDraft(Group et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Group et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Group et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Group> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Group et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Group> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Group et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Group> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Group().setId(key));
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
    boolean remove(Group et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Group> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Group().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Group> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Group> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Group et=list.get(i);
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
    Page<Group> searchDefault(GroupSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Group> listDefault(GroupSearchContext context);

    /**
     * searchno_section
     * 
     * @param context
     * @return
     */
    Page<Group> searchNoSection(GroupSearchContext context);
    /**
     * listno_section
     * 
     * @param context
     * @return
     */
    List<Group> listNoSection(GroupSearchContext context);

    /**
     * searchuser_group_admin
     * 
     * @param context
     * @return
     */
    Page<Group> searchUserGroupAdmin(GroupSearchContext context);
    /**
     * listuser_group_admin
     * 
     * @param context
     * @return
     */
    List<Group> listUserGroupAdmin(GroupSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Group getEntity() {
        return new Group();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default GroupSearchContext getSearchContext() {
        return new GroupSearchContext();
    }
    /**
     * selectRelBySectionId
     * @param sectionIds
     * @return
     */
    List<Group> findBySectionId(List<String> sectionIds);
    default List<Group> findBySectionId(String sectionId) {
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
    default boolean saveBySectionId(String sectionId,List<Group> list) {
        return getSelf().saveBySection(new Section().setId(sectionId),list);
    }
    /**
    * saveRelBySection
    * @param section
    * @param list
    * @return
    */
    boolean saveBySection(Section section,List<Group> list);


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