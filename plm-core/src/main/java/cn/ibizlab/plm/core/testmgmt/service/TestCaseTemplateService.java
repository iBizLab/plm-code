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
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseTemplateSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.domain.Step;

/**
 * 用例模板服务接口[TestCaseTemplateService]
 *
 * @author generator
 */
public interface TestCaseTemplateService extends IService<TestCaseTemplate> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default TestCaseTemplateService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(TestCaseTemplate et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<TestCaseTemplate> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(TestCaseTemplate et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<TestCaseTemplate> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TestCaseTemplate().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(TestCaseTemplate et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<TestCaseTemplate> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TestCaseTemplate().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<TestCaseTemplate> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default TestCaseTemplate get(String key) {
        return getSelf().get(new TestCaseTemplate().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    TestCaseTemplate get(TestCaseTemplate et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<TestCaseTemplate> get(Collection<String> keys) {
        List<TestCaseTemplate> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TestCaseTemplate().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<TestCaseTemplate> get(List<TestCaseTemplate> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    TestCaseTemplate getDraft(TestCaseTemplate et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(TestCaseTemplate et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(TestCaseTemplate et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<TestCaseTemplate> list);

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default TestCaseTemplate nothing(TestCaseTemplate et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<TestCaseTemplate> fetchDefault(TestCaseTemplateSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<TestCaseTemplate> listDefault(TestCaseTemplateSearchContext context);

    /**
    * findByTestLibraryId
    * @param testLibraryIds
    * @return
    */
    List<TestCaseTemplate> findByTestLibraryId(List<String> testLibraryIds);
    default List<TestCaseTemplate> findByTestLibraryId(String testLibraryId){
        return findByTestLibraryId(Arrays.asList(testLibraryId));
    }

    /**
    * removeByTestLibraryId
    * @param testLibraryId
    * @return
    */
    boolean removeByTestLibraryId(String testLibraryId);

    /**
    * resetByTestLibraryId
    * @param testLibraryId
    * @return
    */
    boolean resetByTestLibraryId(String testLibraryId);

    /**
    * saveByTestLibraryId
    * @param testLibraryId
    * @param list
    * @return
    */
    default boolean saveByTestLibraryId(String testLibraryId, List<TestCaseTemplate> list){
        return getSelf().saveByLibrary(new Library().setId(testLibraryId),list);
    }

    /**
    * saveByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library, List<TestCaseTemplate> list);

    /**
    * findBySuiteId
    * @param suiteIds
    * @return
    */
    List<TestCaseTemplate> findBySuiteId(List<String> suiteIds);
    default List<TestCaseTemplate> findBySuiteId(String suiteId){
        return findBySuiteId(Arrays.asList(suiteId));
    }

    /**
    * removeBySuiteId
    * @param suiteId
    * @return
    */
    boolean removeBySuiteId(String suiteId);

    /**
    * resetBySuiteId
    * @param suiteId
    * @return
    */
    boolean resetBySuiteId(String suiteId);

    /**
    * saveBySuiteId
    * @param suiteId
    * @param list
    * @return
    */
    default boolean saveBySuiteId(String suiteId, List<TestCaseTemplate> list){
        return getSelf().saveByTestSuite(new TestSuite().setId(suiteId),list);
    }

    /**
    * saveByTestSuite
    * @param testSuite
    * @param list
    * @return
    */
    boolean saveByTestSuite(TestSuite testSuite, List<TestCaseTemplate> list);


    default ImportResult importData(String config, Boolean ignoreError, List<TestCaseTemplate> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            TestCaseTemplate et=list.get(i);
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
    default TestCaseTemplate getEntity() {
        return new TestCaseTemplate();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default TestCaseTemplateSearchContext getSearchContext() {
        return new TestCaseTemplateSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}