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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.filter.LibrarySearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;

/**
 * 测试库服务接口[LibraryService]
 *
 * @author generator
 */
public interface LibraryService extends IService<Library> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default LibraryService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Library get(Library et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Library get(String key) {
        return getSelf().get(new Library().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Library> getByIds(Collection<String> ids) {
        List<Library> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Library().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Library> getByEntities(List<Library> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Library getDraft(Library et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Library et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Library et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Library> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Library et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Library> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Library et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Library> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Library().setId(key));
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
    boolean remove(Library et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Library> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Library().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Library> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Library> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Library et=list.get(i);
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
    default Library createTemp(Library dto) {
        return dto;
    }

    /**
     * CreateTempMajor
     * 
     * @param dto
     * @return
     */
    default Library createTempMajor(Library dto) {
        return dto;
    }

    /**
     * UpdateTemp
     * 
     * @param dto
     * @return
     */
    default Library updateTemp(Library dto) {
        return dto;
    }

    /**
     * UpdateTempMajor
     * 
     * @param dto
     * @return
     */
    default Library updateTempMajor(Library dto) {
        return dto;
    }

    /**
     * RemoveTemp
     * 
     * @param keys
     * @return
     */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
     * RemoveTempMajor
     * 
     * @param keys
     * @return
     */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
     * GetTemp
     * 
     * @param key
     * @return
     */
    default Library getTemp(String key) {
        return null;
    }

    /**
     * GetTempMajor
     * 
     * @param key
     * @return
     */
    default Library getTempMajor(String key) {
        return null;
    }

    /**
     * GetDraftTemp
     * 
     * @param dto
     * @return
     */
    default Library getDraftTemp(Library dto) {
        return dto;
    }

    /**
     * GetDraftTempMajor
     * 
     * @param dto
     * @return
     */
    default Library getDraftTempMajor(Library dto) {
        return dto;
    }

    /**
     * Activate
     * 
     * @param dto
     * @return
     */
    default Library activate(Library dto) {
        return dto;
    }

    /**
     * Archive
     * 
     * @param dto
     * @return
     */
    default Library archive(Library dto) {
        return dto;
    }

    /**
     * Delete
     * 
     * @param dto
     * @return
     */
    default Library delete(Library dto) {
        return dto;
    }

    /**
     * Favorite
     * 
     * @param dto
     * @return
     */
    default Library favorite(Library dto) {
        return dto;
    }

    /**
     * Recover
     * 
     * @param dto
     * @return
     */
    default Library recover(Library dto) {
        return dto;
    }

    /**
     * Un_favorite
     * 
     * @param dto
     * @return
     */
    default Library unFavorite(Library dto) {
        return dto;
    }

    /**
     * searchAdmin
     * 
     * @param context
     * @return
     */
    Page<Library> searchAdmin(LibrarySearchContext context);
    /**
     * listAdmin
     * 
     * @param context
     * @return
     */
    List<Library> listAdmin(LibrarySearchContext context);

    /**
     * searchArchived
     * 
     * @param context
     * @return
     */
    Page<Library> searchArchived(LibrarySearchContext context);
    /**
     * listArchived
     * 
     * @param context
     * @return
     */
    List<Library> listArchived(LibrarySearchContext context);

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<Library> searchDefault(LibrarySearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Library> listDefault(LibrarySearchContext context);

    /**
     * searchDeleted
     * 
     * @param context
     * @return
     */
    Page<Library> searchDeleted(LibrarySearchContext context);
    /**
     * listDeleted
     * 
     * @param context
     * @return
     */
    List<Library> listDeleted(LibrarySearchContext context);

    /**
     * searchFavorite
     * 
     * @param context
     * @return
     */
    Page<Library> searchFavorite(LibrarySearchContext context);
    /**
     * listFavorite
     * 
     * @param context
     * @return
     */
    List<Library> listFavorite(LibrarySearchContext context);

    /**
     * searchNormal
     * 
     * @param context
     * @return
     */
    Page<Library> searchNormal(LibrarySearchContext context);
    /**
     * listNormal
     * 
     * @param context
     * @return
     */
    List<Library> listNormal(LibrarySearchContext context);

    /**
     * searchProject_relation_library
     * 
     * @param context
     * @return
     */
    Page<Library> searchProjectRelationLibrary(LibrarySearchContext context);
    /**
     * listProject_relation_library
     * 
     * @param context
     * @return
     */
    List<Library> listProjectRelationLibrary(LibrarySearchContext context);

    /**
     * searchUser
     * 
     * @param context
     * @return
     */
    Page<Library> searchUser(LibrarySearchContext context);
    /**
     * listUser
     * 
     * @param context
     * @return
     */
    List<Library> listUser(LibrarySearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Library getEntity() {
        return new Library();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default LibrarySearchContext getSearchContext() {
        return new LibrarySearchContext();
    }
    default List<LibraryMember> getMembers(Library et) {
        return new ArrayList<>();
    }


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