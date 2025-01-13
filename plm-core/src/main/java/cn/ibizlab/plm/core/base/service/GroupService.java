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
import cn.ibizlab.plm.core.base.domain.Group;
import cn.ibizlab.plm.core.base.filter.GroupSearchContext;
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.util.annotation.DEAction;

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
    boolean create(List<Group> list);

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
    boolean update(List<Group> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Group().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Group et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Group> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Group().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Group> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Group get(String key) {
        return getSelf().get(new Group().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Group get(Group et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Group> get(Collection<String> keys) {
        List<Group> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Group().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Group> get(List<Group> entities);

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
    CheckKeyStatus checkKey(Group et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Group et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Group> list);

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<Group> moveOrder(Group et) {
        return new ArrayList<>();
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Group> fetchDefault(GroupSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Group> listDefault(GroupSearchContext context);

    /**
    * fetchNoSection
    * 
    * @param context
    * @return
    */
    Page<Group> fetchNoSection(GroupSearchContext context);

    /**
    * listNoSection
    * 
    * @param context
    * @return
    */
    List<Group> listNoSection(GroupSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Group> fetchReader(GroupSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Group> listReader(GroupSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<Group> fetchUser(GroupSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<Group> listUser(GroupSearchContext context);

    /**
    * fetchUserGroupAdmin
    * 
    * @param context
    * @return
    */
    Page<Group> fetchUserGroupAdmin(GroupSearchContext context);

    /**
    * listUserGroupAdmin
    * 
    * @param context
    * @return
    */
    List<Group> listUserGroupAdmin(GroupSearchContext context);

    /**
    * findBySectionId
    * @param sectionIds
    * @return
    */
    List<Group> findBySectionId(List<String> sectionIds);
    default List<Group> findBySectionId(String sectionId){
        return findBySection(new Section().setId(sectionId));
    }

    /**
    * findBySection
    * @param section
    * @return
    */
    List<Group> findBySection(Section section);

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
    default boolean saveBySectionId(String sectionId, List<Group> list){
        return getSelf().saveBySection(new Section().setId(sectionId),list);
    }

    /**
    * saveBySection
    * @param section
    * @param list
    * @return
    */
    boolean saveBySection(Section section, List<Group> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Group> fetchView(GroupSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Group> listView(GroupSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}