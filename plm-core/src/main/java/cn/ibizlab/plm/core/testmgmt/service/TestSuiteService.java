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
     * 获取
     * @param et
     * @return
     */
    TestSuite get(TestSuite et);
    /**
     * 获取
     * @param key
     * @return
     */
    default TestSuite get(String key) {
        return getSelf().get(new TestSuite().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<TestSuite> getByIds(Collection<String> ids) {
        List<TestSuite> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TestSuite().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<TestSuite> getByEntities(List<TestSuite> entities);

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
    boolean createBatch(List<TestSuite> list);

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
    boolean updateBatch(List<TestSuite> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(TestSuite et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<TestSuite> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TestSuite().setId(key));
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
    boolean remove(TestSuite et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<TestSuite> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TestSuite().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<TestSuite> entities);

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
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<TestSuite> searchDefault(TestSuiteSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<TestSuite> listDefault(TestSuiteSearchContext context);

    /**
     * searchNo_parent
     * 
     * @param context
     * @return
     */
    Page<TestSuite> searchNoParent(TestSuiteSearchContext context);
    /**
     * listNo_parent
     * 
     * @param context
     * @return
     */
    List<TestSuite> listNoParent(TestSuiteSearchContext context);

    /**
     * searchNormal
     * 
     * @param context
     * @return
     */
    Page<TestSuite> searchNormal(TestSuiteSearchContext context);
    /**
     * listNormal
     * 
     * @param context
     * @return
     */
    List<TestSuite> listNormal(TestSuiteSearchContext context);

    /**
     * searchRoot
     * 
     * @param context
     * @return
     */
    Page<TestSuite> searchRoot(TestSuiteSearchContext context);
    /**
     * listRoot
     * 
     * @param context
     * @return
     */
    List<TestSuite> listRoot(TestSuiteSearchContext context);

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
     * selectRelByLibraryId
     * @param libraryIds
     * @return
     */
    List<TestSuite> findByLibraryId(List<String> libraryIds);
    default List<TestSuite> findByLibraryId(String libraryId) {
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
    default boolean saveByLibraryId(String libraryId,List<TestSuite> list) {
        return getSelf().saveByLibrary(new Library().setId(libraryId),list);
    }
    /**
    * saveRelByLibrary
    * @param library
    * @param list
    * @return
    */
    boolean saveByLibrary(Library library,List<TestSuite> list);

    /**
     * selectRelByPid
     * @param pids
     * @return
     */
    List<TestSuite> findByPid(List<String> pids);
    default List<TestSuite> findByPid(String pid) {
        return findByPid(Arrays.asList(pid));
    }
    /**
     * removeRelByPid
     * @param pid
     * @return
     */
    boolean removeByPid(String pid);
    /**
     * resetRelByPid
     * @param pid
     * @return
     */
    boolean resetByPid(String pid);
    /**
     * saveRelByPid
     * @param pid
     * @param list
     * @return
     */
    default boolean saveByPid(String pid,List<TestSuite> list) {
        return getSelf().saveByTestSuite(new TestSuite().setId(pid),list);
    }
    /**
    * saveRelByTestSuite
    * @param testSuite
    * @param list
    * @return
    */
    boolean saveByTestSuite(TestSuite testSuite,List<TestSuite> list);


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