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
import cn.ibizlab.plm.core.testmgmt.domain.CaseHistory;
import cn.ibizlab.plm.core.testmgmt.filter.CaseHistorySearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;

/**
 * 用例执行历史服务接口[CaseHistoryService]
 *
 * @author generator
 */
public interface CaseHistoryService extends IService<CaseHistory> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default CaseHistoryService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(CaseHistory et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<CaseHistory> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(CaseHistory et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<CaseHistory> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new CaseHistory().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(CaseHistory et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<CaseHistory> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new CaseHistory().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<CaseHistory> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default CaseHistory get(String key) {
        return getSelf().get(new CaseHistory().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    CaseHistory get(CaseHistory et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<CaseHistory> get(Collection<String> keys) {
        List<CaseHistory> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new CaseHistory().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<CaseHistory> get(List<CaseHistory> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    CaseHistory getDraft(CaseHistory et);

    /**
    * checkKey
    * @param et
    * @return
    */
    Integer checkKey(CaseHistory et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(CaseHistory et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<CaseHistory> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<CaseHistory> fetchDefault(CaseHistorySearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<CaseHistory> listDefault(CaseHistorySearchContext context);

    /**
    * findByCaseId
    * @param caseIds
    * @return
    */
    List<CaseHistory> findByCaseId(List<String> caseIds);
    default List<CaseHistory> findByCaseId(String caseId){
        return findByCaseId(Arrays.asList(caseId));
    }

    /**
    * removeByCaseId
    * @param caseId
    * @return
    */
    boolean removeByCaseId(String caseId);

    /**
    * resetByCaseId
    * @param caseId
    * @return
    */
    boolean resetByCaseId(String caseId);

    /**
    * saveByCaseId
    * @param caseId
    * @param list
    * @return
    */
    default boolean saveByCaseId(String caseId, List<CaseHistory> list){
        return getSelf().saveByTestCase(new TestCase().setId(caseId),list);
    }

    /**
    * saveByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase, List<CaseHistory> list);


    default ImportResult importData(String config, Boolean ignoreError, List<CaseHistory> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            CaseHistory et=list.get(i);
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
    default CaseHistory getEntity() {
        return new CaseHistory();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default CaseHistorySearchContext getSearchContext() {
        return new CaseHistorySearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}