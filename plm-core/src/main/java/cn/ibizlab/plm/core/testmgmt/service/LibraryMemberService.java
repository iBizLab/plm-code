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
     * 获取
     * @param et
     * @return
     */
    LibraryMember get(LibraryMember et);
    /**
     * 获取
     * @param key
     * @return
     */
    default LibraryMember get(String key) {
        return getSelf().get(new LibraryMember().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<LibraryMember> getByIds(Collection<String> ids) {
        List<LibraryMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new LibraryMember().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<LibraryMember> getByEntities(List<LibraryMember> entities);

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
    Integer checkKey(LibraryMember et);

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
    boolean createBatch(List<LibraryMember> list);

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
    boolean updateBatch(List<LibraryMember> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(LibraryMember et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<LibraryMember> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new LibraryMember().setId(key));
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
    boolean remove(LibraryMember et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<LibraryMember> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new LibraryMember().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<LibraryMember> entities);

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
     * CreateTemp
     * 
     * @param dto
     * @return
     */
    default LibraryMember createTemp(LibraryMember dto) {
        return dto;
    }

    /**
     * create_library_member
     * 
     * @param dto
     * @return
     */
    default LibraryMember createLibraryMember(LibraryMember dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<LibraryMember> searchDefault(LibraryMemberSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<LibraryMember> listDefault(LibraryMemberSearchContext context);

    /**
     * searchcur_library_member
     * 
     * @param context
     * @return
     */
    Page<LibraryMember> searchCurLibraryMember(LibraryMemberSearchContext context);
    /**
     * listcur_library_member
     * 
     * @param context
     * @return
     */
    List<LibraryMember> listCurLibraryMember(LibraryMemberSearchContext context);

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
     * selectRelByLibraryId
     * @param libraryIds
     * @return
     */
    List<LibraryMember> findByLibraryId(List<String> libraryIds);
    default List<LibraryMember> findByLibraryId(String libraryId) {
        return findByLibraryId(Arrays.asList(libraryId));
    }
    /**
     * removeRelByLibraryId
     * @param libraryId
     * @return
     */
    boolean removeByLibraryId(String libraryId);
    /**
     * resetRelByLibraryId
     * @param libraryId
     * @return
     */
    boolean resetByLibraryId(String libraryId);
    /**
     * saveRelByLibraryId
     * @param libraryId
     * @param list
     * @return
     */
    default boolean saveByLibraryId(String libraryId,List<LibraryMember> list) {
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }
    /**
    * saveRelByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library,List<LibraryMember> list);

    /**
     * selectRelByUserId
     * @param userIds
     * @return
     */
    List<LibraryMember> findByUserId(List<String> userIds);
    default List<LibraryMember> findByUserId(String userId) {
        return findByUserId(Arrays.asList(userId));
    }
    /**
     * removeRelByUserId
     * @param userId
     * @return
     */
    boolean removeByUserId(String userId);
    /**
     * resetRelByUserId
     * @param userId
     * @return
     */
    boolean resetByUserId(String userId);
    /**
     * saveRelByUserId
     * @param userId
     * @param list
     * @return
     */
    default boolean saveByUserId(String userId,List<LibraryMember> list) {
        return getSelf().saveByUser(new User().setId(userId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<LibraryMember> list);


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