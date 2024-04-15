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
import cn.ibizlab.plm.core.testmgmt.domain.RunAttachment;
import cn.ibizlab.plm.core.testmgmt.filter.RunAttachmentSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.Run;

/**
 * 执行用例结果附件服务接口[RunAttachmentService]
 *
 * @author generator
 */
public interface RunAttachmentService extends IService<RunAttachment> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default RunAttachmentService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    RunAttachment get(RunAttachment et);
    /**
     * 获取
     * @param key
     * @return
     */
    default RunAttachment get(String key) {
        return getSelf().get(new RunAttachment().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<RunAttachment> getByIds(Collection<String> ids) {
        List<RunAttachment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new RunAttachment().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<RunAttachment> getByEntities(List<RunAttachment> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    RunAttachment getDraft(RunAttachment et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(RunAttachment et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(RunAttachment et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<RunAttachment> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(RunAttachment et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<RunAttachment> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(RunAttachment et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<RunAttachment> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new RunAttachment().setId(key));
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
    boolean remove(RunAttachment et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<RunAttachment> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new RunAttachment().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<RunAttachment> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<RunAttachment> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            RunAttachment et=list.get(i);
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
    Page<RunAttachment> searchDefault(RunAttachmentSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<RunAttachment> listDefault(RunAttachmentSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default RunAttachment getEntity() {
        return new RunAttachment();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default RunAttachmentSearchContext getSearchContext() {
        return new RunAttachmentSearchContext();
    }
    /**
     * selectRelByOwnerId
     * @param ownerIds
     * @return
     */
    List<RunAttachment> findByOwnerId(List<String> ownerIds);
    default List<RunAttachment> findByOwnerId(String ownerId) {
        return findByOwnerId(Arrays.asList(ownerId));
    }
    /**
     * removeRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean removeByOwnerId(String ownerId);
    /**
     * resetRelByOwnerId
     * @param ownerId
     * @return
     */
    boolean resetByOwnerId(String ownerId);
    /**
     * saveRelByOwnerId
     * @param ownerId
     * @param list
     * @return
     */
    default boolean saveByOwnerId(String ownerId,List<RunAttachment> list) {
        return getSelf().saveByRunAttachment(new Run().setId(ownerId),list);
    }
    /**
    * saveRelByRunAttachment
    * @param run
    * @param list
    * @return
    */
    boolean saveByRunAttachment(Run run,List<RunAttachment> list);


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