/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.filter.TestSuiteSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;

/**
 * 用例模块服务接口[TestSuiteService]
 *
 * @author generator
 */
public interface TestSuiteService extends IService<TestSuite> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default TestSuiteService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(TestSuite et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<TestSuite> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(TestSuite et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<TestSuite> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TestSuite().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(TestSuite et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<TestSuite> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TestSuite().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<TestSuite> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default TestSuite get(String key) {
        return getSelf().get(new TestSuite().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    TestSuite get(TestSuite et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<TestSuite> get(Collection<String> keys) {
        List<TestSuite> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TestSuite().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<TestSuite> get(List<TestSuite> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    TestSuite getDraft(TestSuite et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(TestSuite et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(TestSuite et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<TestSuite> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<TestSuite> fetchDefault(TestSuiteSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<TestSuite> listDefault(TestSuiteSearchContext context);

    /**
    * fetchCurTestSuite
    * 
    * @param context
    * @return
    */
    Page<TestSuite> fetchCurTestSuite(TestSuiteSearchContext context);

    /**
    * listCurTestSuite
    * 
    * @param context
    * @return
    */
    List<TestSuite> listCurTestSuite(TestSuiteSearchContext context);

    /**
    * fetchNoParent
    * 
    * @param context
    * @return
    */
    Page<TestSuite> fetchNoParent(TestSuiteSearchContext context);

    /**
    * listNoParent
    * 
    * @param context
    * @return
    */
    List<TestSuite> listNoParent(TestSuiteSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<TestSuite> fetchNormal(TestSuiteSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<TestSuite> listNormal(TestSuiteSearchContext context);

    /**
    * fetchRoot
    * 
    * @param context
    * @return
    */
    Page<TestSuite> fetchRoot(TestSuiteSearchContext context);

    /**
    * listRoot
    * 
    * @param context
    * @return
    */
    List<TestSuite> listRoot(TestSuiteSearchContext context);

    /**
    * findByLibraryId
    * @param libraryIds
    * @return
    */
    List<TestSuite> findByLibraryId(List<String> libraryIds);
    default List<TestSuite> findByLibraryId(String libraryId){
        return findByLibraryId(Arrays.asList(libraryId));
    }

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
    default boolean saveByLibraryId(String libraryId, List<TestSuite> list){
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<TestSuite> list);

    /**
    * findByPid
    * @param pids
    * @return
    */
    List<TestSuite> findByPid(List<String> pids);
    default List<TestSuite> findByPid(String pid){
        return findByPid(Arrays.asList(pid));
    }

    /**
    * removeByPid
    * @param pid
    * @return
    */
    boolean removeByPid(String pid);

    /**
    * resetByPid
    * @param pid
    * @return
    */
    boolean resetByPid(String pid);

    /**
    * saveByPid
    * @param pid
    * @param list
    * @return
    */
    default boolean saveByPid(String pid, List<TestSuite> list){
        return getSelf().saveByTestSuite(new TestSuite().setId(pid),list);
    }

    /**
    * saveByTestSuite
    * @param testSuite
    * @param list
    * @return
    */
    boolean saveByTestSuite(TestSuite testSuite, List<TestSuite> list);


    default ImportResult importData(String config, Boolean ignoreError, List<TestSuite> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            TestSuite et=list.get(i);
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
    default TestSuite getEntity() {
        return new TestSuite();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default TestSuiteSearchContext getSearchContext() {
        return new TestSuiteSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}