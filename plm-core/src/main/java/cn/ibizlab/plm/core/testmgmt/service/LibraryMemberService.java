/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.testmgmt.filter.LibraryMemberSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 测试库成员服务接口[LibraryMemberService]
 *
 * @author generator
 */
public interface LibraryMemberService extends IService<LibraryMember> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default LibraryMemberService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(LibraryMember et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<LibraryMember> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default LibraryMember createTemp(LibraryMember et) {
        return et;
    }

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(LibraryMember et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<LibraryMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new LibraryMember().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(LibraryMember et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<LibraryMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new LibraryMember().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<LibraryMember> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default LibraryMember get(String key) {
        return getSelf().get(new LibraryMember().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    LibraryMember get(LibraryMember et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<LibraryMember> get(Collection<String> keys) {
        List<LibraryMember> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new LibraryMember().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<LibraryMember> get(List<LibraryMember> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    LibraryMember getDraft(LibraryMember et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(LibraryMember et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(LibraryMember et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<LibraryMember> list);

    /**
    * changeRole
    * 
    * @param et
    * @return
    */
    default LibraryMember changeRole(LibraryMember et) {
        return et;
    }

    /**
    * createLibraryMember
    * 
    * @param et
    * @return
    */
    default LibraryMember createLibraryMember(LibraryMember et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default LibraryMember nothing(LibraryMember et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<LibraryMember> fetchDefault(LibraryMemberSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<LibraryMember> listDefault(LibraryMemberSearchContext context);

    /**
    * fetchCurLibraryMember
    * 
    * @param context
    * @return
    */
    Page<LibraryMember> fetchCurLibraryMember(LibraryMemberSearchContext context);

    /**
    * listCurLibraryMember
    * 
    * @param context
    * @return
    */
    List<LibraryMember> listCurLibraryMember(LibraryMemberSearchContext context);

    /**
    * fetchMobCurMember
    * 
    * @param context
    * @return
    */
    Page<LibraryMember> fetchMobCurMember(LibraryMemberSearchContext context);

    /**
    * listMobCurMember
    * 
    * @param context
    * @return
    */
    List<LibraryMember> listMobCurMember(LibraryMemberSearchContext context);

    /**
    * fetchNoAttention
    * 
    * @param context
    * @return
    */
    Page<LibraryMember> fetchNoAttention(LibraryMemberSearchContext context);

    /**
    * listNoAttention
    * 
    * @param context
    * @return
    */
    List<LibraryMember> listNoAttention(LibraryMemberSearchContext context);

    /**
    * findByLibraryId
    * @param libraryIds
    * @return
    */
    List<LibraryMember> findByLibraryId(List<String> libraryIds);
    default List<LibraryMember> findByLibraryId(String libraryId){
        return findByLibrary(new Library().setId(libraryId));
    }

    /**
    * findByLibrary
    * @param library
    * @return
    */
    List<LibraryMember> findByLibrary(Library library);

    /**
    * removeByLibraryId
    * @param libraryId
    * @return
    */
    boolean removeByLibraryId(String libraryId);

    /**
    * resetByLibraryId
    * @param libraryId
    * @return
    */
    boolean resetByLibraryId(String libraryId);

    /**
    * saveByLibraryId
    * @param libraryId
    * @param list
    * @return
    */
    default boolean saveByLibraryId(String libraryId, List<LibraryMember> list){
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<LibraryMember> list);

    /**
    * findByUserId
    * @param userIds
    * @return
    */
    List<LibraryMember> findByUserId(List<String> userIds);
    default List<LibraryMember> findByUserId(String userId){
        return findByUser(new User().setId(userId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<LibraryMember> findByUser(User user);

    /**
    * removeByUserId
    * @param userId
    * @return
    */
    boolean removeByUserId(String userId);

    /**
    * resetByUserId
    * @param userId
    * @return
    */
    boolean resetByUserId(String userId);

    /**
    * saveByUserId
    * @param userId
    * @param list
    * @return
    */
    default boolean saveByUserId(String userId, List<LibraryMember> list){
        return getSelf().saveByUser(new User().setId(userId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<LibraryMember> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<LibraryMember> fetchView(LibraryMemberSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<LibraryMember> listView(LibraryMemberSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<LibraryMember> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            LibraryMember et=list.get(i);
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
    default LibraryMember getEntity() {
        return new LibraryMember();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default LibraryMemberSearchContext getSearchContext() {
        return new LibraryMemberSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}