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
     * 获取
     * @param et
     * @return
     */
    TestCaseTemplate get(TestCaseTemplate et);
    /**
     * 获取
     * @param key
     * @return
     */
    default TestCaseTemplate get(String key) {
        return getSelf().get(new TestCaseTemplate().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<TestCaseTemplate> getByIds(Collection<String> ids) {
        List<TestCaseTemplate> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TestCaseTemplate().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<TestCaseTemplate> getByEntities(List<TestCaseTemplate> entities);

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
    boolean createBatch(List<TestCaseTemplate> list);

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
    boolean updateBatch(List<TestCaseTemplate> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(TestCaseTemplate et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<TestCaseTemplate> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TestCaseTemplate().setId(key));
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
    boolean remove(TestCaseTemplate et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<TestCaseTemplate> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TestCaseTemplate().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<TestCaseTemplate> entities);

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
     * nothing
     * 
     * @param dto
     * @return
     */
    default TestCaseTemplate nothing(TestCaseTemplate dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<TestCaseTemplate> searchDefault(TestCaseTemplateSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<TestCaseTemplate> listDefault(TestCaseTemplateSearchContext context);

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
     * selectRelByTestLibraryId
     * @param testLibraryIds
     * @return
     */
    List<TestCaseTemplate> findByTestLibraryId(List<String> testLibraryIds);
    default List<TestCaseTemplate> findByTestLibraryId(String testLibraryId) {
        return findByTestLibraryId(Arrays.asList(testLibraryId));
    }
    /**
     * removeRelByTestLibraryId
     * @param testLibraryId
     * @return
     */
    boolean removeByTestLibraryId(String testLibraryId);
    /**
     * resetRelByTestLibraryId
     * @param testLibraryId
     * @return
     */
    boolean resetByTestLibraryId(String testLibraryId);
    /**
     * saveRelByTestLibraryId
     * @param testLibraryId
     * @param list
     * @return
     */
    default boolean saveByTestLibraryId(String testLibraryId,List<TestCaseTemplate> list) {
        return getSelf().saveByLibrary(new Library().setId(testLibraryId),list);
    }
    /**
    * saveRelByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library,List<TestCaseTemplate> list);

    /**
     * selectRelBySuiteId
     * @param suiteIds
     * @return
     */
    List<TestCaseTemplate> findBySuiteId(List<String> suiteIds);
    default List<TestCaseTemplate> findBySuiteId(String suiteId) {
        return findBySuiteId(Arrays.asList(suiteId));
    }
    /**
     * removeRelBySuiteId
     * @param suiteId
     * @return
     */
    boolean removeBySuiteId(String suiteId);
    /**
     * resetRelBySuiteId
     * @param suiteId
     * @return
     */
    boolean resetBySuiteId(String suiteId);
    /**
     * saveRelBySuiteId
     * @param suiteId
     * @param list
     * @return
     */
    default boolean saveBySuiteId(String suiteId,List<TestCaseTemplate> list) {
        return getSelf().saveByTestSuite(new TestSuite().setId(suiteId),list);
    }
    /**
    * saveRelByTestSuite
    * @param testSuite
    * @param list
    * @return
    */
    boolean saveByTestSuite(TestSuite testSuite,List<TestCaseTemplate> list);


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