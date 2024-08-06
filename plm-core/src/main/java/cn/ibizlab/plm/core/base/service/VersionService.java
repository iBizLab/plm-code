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
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.filter.VersionSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;

/**
 * 版本服务接口[VersionService]
 *
 * @author generator
 */
public interface VersionService extends IService<Version> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default VersionService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Version et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Version> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Version et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Version> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Version().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Version et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Version> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Version().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Version> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Version get(String key) {
        return getSelf().get(new Version().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Version get(Version et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Version> get(Collection<String> keys) {
        List<Version> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Version().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Version> get(List<Version> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Version getDraft(Version et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Version et);

    /**
    * commit
    * 
    * @param et
    * @return
    */
    default Version commit(Version et) {
        return et;
    }

    /**
    * restore
    * 
    * @param et
    * @return
    */
    default Version restore(Version et) {
        return et;
    }

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Version et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Version> list);

    /**
    * fixCommit
    * 
    * @param et
    * @return
    */
    default Version fixCommit(Version et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Version> fetchDefault(VersionSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Version> listDefault(VersionSearchContext context);

    /**
    * fetchNameVersion
    * 
    * @param context
    * @return
    */
    Page<Version> fetchNameVersion(VersionSearchContext context);

    /**
    * listNameVersion
    * 
    * @param context
    * @return
    */
    List<Version> listNameVersion(VersionSearchContext context);

    /**
    * fetchOwner
    * 
    * @param context
    * @return
    */
    Page<Version> fetchOwner(VersionSearchContext context);

    /**
    * listOwner
    * 
    * @param context
    * @return
    */
    List<Version> listOwner(VersionSearchContext context);

    /**
    * findByOwnerId
    * @param ownerIds
    * @return
    */
    List<Version> findByOwnerId(List<String> ownerIds);
    default List<Version> findByOwnerId(String ownerId){
        return findByIdea(new Idea().setId(ownerId));
    }

    /**
    * findByIdea
    * @param idea
    * @return
    */
    List<Version> findByIdea(Idea idea);

    /**
    * removeByOwnerId
    * @param ownerId
    * @return
    */
    boolean removeByOwnerId(String ownerId);

    /**
    * resetByOwnerId
    * @param ownerId
    * @return
    */
    boolean resetByOwnerId(String ownerId);

    /**
    * saveByOwnerId
    * @param ownerId
    * @param list
    * @return
    */
    default boolean saveByOwnerId(String ownerId, List<Version> list){
        return getSelf().saveByIdea(new Idea().setId(ownerId),list);
    }

    /**
    * saveByIdea
    * @param idea
    * @param list
    * @return
    */
    boolean saveByIdea(Idea idea, List<Version> list);

    /**
    * findByPage
    * @param articlePage
    * @return
    */
    List<Version> findByPage(ArticlePage articlePage);

    /**
    * saveByPage
    * @param articlePage
    * @param list
    * @return
    */
    boolean saveByPage(ArticlePage articlePage, List<Version> list);

    /**
    * findByTestCase
    * @param testCase
    * @return
    */
    List<Version> findByTestCase(TestCase testCase);

    /**
    * saveByTestCase
    * @param testCase
    * @param list
    * @return
    */
    boolean saveByTestCase(TestCase testCase, List<Version> list);

    /**
    * findByWorkItem
    * @param workItem
    * @return
    */
    List<Version> findByWorkItem(WorkItem workItem);

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<Version> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Version> fetchView(VersionSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Version> listView(VersionSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Version> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Version et=list.get(i);
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
    default Version getEntity() {
        return new Version();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default VersionSearchContext getSearchContext() {
        return new VersionSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}