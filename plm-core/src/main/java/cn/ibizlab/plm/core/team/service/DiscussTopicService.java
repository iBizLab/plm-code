/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.team.filter.DiscussTopicSearchContext;
import cn.ibizlab.plm.core.team.domain.DiscussMember;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 话题服务接口[DiscussTopicService]
 *
 * @author generator
 */
public interface DiscussTopicService extends IService<DiscussTopic> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default DiscussTopicService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(DiscussTopic et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<DiscussTopic> list);

    /**
    * createTemp
    * 
    * @param et
    * @return
    */
    default DiscussTopic createTemp(DiscussTopic et) {
        return et;
    }

    /**
    * createTempMajor
    * 
    * @param et
    * @return
    */
    default DiscussTopic createTempMajor(DiscussTopic et) {
        return et;
    }

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(DiscussTopic et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<DiscussTopic> list);

    /**
    * updateTemp
    * 
    * @param et
    * @return
    */
    default DiscussTopic updateTemp(DiscussTopic et) {
        return et;
    }

    /**
    * updateTempMajor
    * 
    * @param et
    * @return
    */
    default DiscussTopic updateTempMajor(DiscussTopic et) {
        return et;
    }

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new DiscussTopic().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(DiscussTopic et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<DiscussTopic> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DiscussTopic().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<DiscussTopic> entities);

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
    default DiscussTopic get(String key) {
        return getSelf().get(new DiscussTopic().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    DiscussTopic get(DiscussTopic et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<DiscussTopic> get(Collection<String> keys) {
        List<DiscussTopic> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new DiscussTopic().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<DiscussTopic> get(List<DiscussTopic> entities);

    /**
    * getTemp
    * 
    * @param key
    * @return
    */
    default DiscussTopic getTemp(String key) {
        return null;
    }

    /**
    * getTempMajor
    * 
    * @param key
    * @return
    */
    default DiscussTopic getTempMajor(String key) {
        return null;
    }

    /**
    * 草稿
    * @param et
    * @return
    */
    DiscussTopic getDraft(DiscussTopic et);

    /**
    * getDraftTemp
    * 
    * @param et
    * @return
    */
    default DiscussTopic getDraftTemp(DiscussTopic et) {
        return et;
    }

    /**
    * getDraftTempMajor
    * 
    * @param et
    * @return
    */
    default DiscussTopic getDraftTempMajor(DiscussTopic et) {
        return et;
    }

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(DiscussTopic et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(DiscussTopic et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<DiscussTopic> list);

    /**
    * activate
    * 
    * @param et
    * @return
    */
    default DiscussTopic activate(DiscussTopic et) {
        return et;
    }

    /**
    * archive
    * 
    * @param et
    * @return
    */
    default DiscussTopic archive(DiscussTopic et) {
        return et;
    }

    /**
    * changeAdminRole
    * 
    * @param et
    * @return
    */
    default DiscussTopic changeAdminRole(DiscussTopic et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default DiscussTopic delete(DiscussTopic et) {
        return et;
    }

    /**
    * favorite
    * 
    * @param et
    * @return
    */
    default DiscussTopic favorite(DiscussTopic et) {
        return et;
    }

    /**
    * mobChangeAdminRole
    * 
    * @param et
    * @return
    */
    default DiscussTopic mobChangeAdminRole(DiscussTopic et) {
        return et;
    }

    /**
    * moveDiscussTopic
    * 
    * @param et
    * @return
    */
    default DiscussTopic moveDiscussTopic(DiscussTopic et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default DiscussTopic nothing(DiscussTopic et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default DiscussTopic recover(DiscussTopic et) {
        return et;
    }

    /**
    * unFavorite
    * 
    * @param et
    * @return
    */
    default DiscussTopic unFavorite(DiscussTopic et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchDefault(DiscussTopicSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listDefault(DiscussTopicSearchContext context);

    /**
    * fetchAdmin
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchAdmin(DiscussTopicSearchContext context);

    /**
    * listAdmin
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listAdmin(DiscussTopicSearchContext context);

    /**
    * fetchArchived
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchArchived(DiscussTopicSearchContext context);

    /**
    * listArchived
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listArchived(DiscussTopicSearchContext context);

    /**
    * fetchArchivedMain
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchArchivedMain(DiscussTopicSearchContext context);

    /**
    * listArchivedMain
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listArchivedMain(DiscussTopicSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchDeleted(DiscussTopicSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listDeleted(DiscussTopicSearchContext context);

    /**
    * fetchFavorite
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchFavorite(DiscussTopicSearchContext context);

    /**
    * listFavorite
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listFavorite(DiscussTopicSearchContext context);

    /**
    * fetchGroup
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchGroup(DiscussTopicSearchContext context);

    /**
    * listGroup
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listGroup(DiscussTopicSearchContext context);

    /**
    * fetchMain
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchMain(DiscussTopicSearchContext context);

    /**
    * listMain
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listMain(DiscussTopicSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchNormal(DiscussTopicSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listNormal(DiscussTopicSearchContext context);

    /**
    * fetchOssMain
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchOssMain(DiscussTopicSearchContext context);

    /**
    * listOssMain
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listOssMain(DiscussTopicSearchContext context);

    /**
    * fetchQuickUser
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchQuickUser(DiscussTopicSearchContext context);

    /**
    * listQuickUser
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listQuickUser(DiscussTopicSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchReader(DiscussTopicSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listReader(DiscussTopicSearchContext context);

    /**
    * fetchUser
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchUser(DiscussTopicSearchContext context);

    /**
    * listUser
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listUser(DiscussTopicSearchContext context);

    default List<DiscussMember> getMembers(DiscussTopic et) {
        return new ArrayList<>();
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<DiscussTopic> fetchView(DiscussTopicSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<DiscussTopic> listView(DiscussTopicSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<DiscussTopic> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            DiscussTopic et=list.get(i);
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
    default DiscussTopic getEntity() {
        return new DiscussTopic();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default DiscussTopicSearchContext getSearchContext() {
        return new DiscussTopicSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}