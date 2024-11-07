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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.filter.LibrarySearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
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
    boolean create(List<Library> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default Library createTemp(Library et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default Library createTempMajor(Library et) {
        return et;
    }

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
    boolean update(List<Library> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default Library updateTemp(Library et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default Library updateTempMajor(Library et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Library().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Library et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Library> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Library().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Library> entities);

    /**
    * removeTemp
    * 
    * @param keys
    * @return
    */
    default List<String> removeTemp(List<String> keys) {
        return keys;
    }

    /**
    * removeTempMajor
    * 
    * @param keys
    * @return
    */
    default List<String> removeTempMajor(List<String> keys) {
        return keys;
    }

    /**
    * 获取
    * @param key
    * @return
    */
    default Library get(String key) {
        return getSelf().get(new Library().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Library get(Library et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Library> get(Collection<String> keys) {
        List<Library> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Library().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Library> get(List<Library> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default Library getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default Library getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    Library getDraft(Library et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default Library getDraftTemp(Library et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default Library getDraftTempMajor(Library et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Library et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Library et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Library> list);

    /**
    * activate
    * 
    * @param et
    * @return
    */
    default Library activate(Library et) {
        return et;
    }

    /**
    * archive
    * 
    * @param et
    * @return
    */
    default Library archive(Library et) {
        return et;
    }

    /**
    * changeAdminRole
    * 
    * @param et
    * @return
    */
    default Library changeAdminRole(Library et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default Library delete(Library et) {
        return et;
    }

    /**
    * favorite
    * 
    * @param et
    * @return
    */
    default Library favorite(Library et) {
        return et;
    }

    /**
    * libraryIndexAddonCounter
    * 
    * @param et
    * @return
    */
    default Library libraryIndexAddonCounter(Library et) {
        return et;
    }

    /**
    * moveLibrary
    * 
    * @param et
    * @return
    */
    default Library moveLibrary(Library et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default Library nothing(Library et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default Library recover(Library et) {
        return et;
    }

    /**
    * unFavorite
    * 
    * @param et
    * @return
    */
    default Library unFavorite(Library et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Library> fetchDefault(LibrarySearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Library> listDefault(LibrarySearchContext context);

    /**
    * fetchAdmin
    * 
    * @param context
    * @return
    */
    Page<Library> fetchAdmin(LibrarySearchContext context);

    /**
    * listAdmin
    * 
    * @param context
    * @return
    */
    List<Library> listAdmin(LibrarySearchContext context);

    /**
    * fetchArchived
    * 
    * @param context
    * @return
    */
    Page<Library> fetchArchived(LibrarySearchContext context);

    /**
    * listArchived
    * 
    * @param context
    * @return
    */
    List<Library> listArchived(LibrarySearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<Library> fetchDeleted(LibrarySearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<Library> listDeleted(LibrarySearchContext context);

    /**
    * fetchFavorite
    * 
    * @param context
    * @return
    */
    Page<Library> fetchFavorite(LibrarySearchContext context);

    /**
    * listFavorite
    * 
    * @param context
    * @return
    */
    List<Library> listFavorite(LibrarySearchContext context);

    /**
    * fetchMain
    * 
    * @param context
    * @return
    */
    Page<Library> fetchMain(LibrarySearchContext context);

    /**
    * listMain
    * 
    * @param context
    * @return
    */
    List<Library> listMain(LibrarySearchContext context);

    /**
    * fetchMobMain
    * 
    * @param context
    * @return
    */
    Page<Library> fetchMobMain(LibrarySearchContext context);

    /**
    * listMobMain
    * 
    * @param context
    * @return
    */
    List<Library> listMobMain(LibrarySearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<Library> fetchNormal(LibrarySearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<Library> listNormal(LibrarySearchContext context);

    /**
    * fetchProjectRelationLibrary
    * 通过测试计划中进行关联项目展示测试库
    * @param context
    * @return
    */
    Page<Library> fetchProjectRelationLibrary(LibrarySearchContext context);

    /**
    * listProjectRelationLibrary
    * 通过测试计划中进行关联项目展示测试库
    * @param context
    * @return
    */
    List<Library> listProjectRelationLibrary(LibrarySearchContext context);

    /**
    * fetchQuickUser
    * 
    * @param context
    * @return
    */
    Page<Library> fetchQuickUser(LibrarySearchContext context);

    /**
    * listQuickUser
    * 
    * @param context
    * @return
    */
    List<Library> listQuickUser(LibrarySearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<Library> fetchReader(LibrarySearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<Library> listReader(LibrarySearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<Library> fetchUser(LibrarySearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<Library> listUser(LibrarySearchContext context);

    default List<LibraryMember> getMembers(Library et) {
        return new ArrayList<>();
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Library> fetchView(LibrarySearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Library> listView(LibrarySearchContext context);


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


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}