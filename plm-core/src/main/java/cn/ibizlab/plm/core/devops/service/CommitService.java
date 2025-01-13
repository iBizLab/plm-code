/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.devops.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.devops.domain.Commit;
import cn.ibizlab.plm.core.devops.filter.CommitSearchContext;
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 代码提交服务接口[CommitService]
 *
 * @author generator
 */
public interface CommitService extends IService<Commit> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default CommitService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(Commit et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<Commit> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(Commit et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<Commit> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Commit().setSha(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Commit et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Commit> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Commit().setSha(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Commit> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Commit get(String key) {
        return getSelf().get(new Commit().setSha(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Commit get(Commit et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Commit> get(Collection<String> keys) {
        List<Commit> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Commit().setSha(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Commit> get(List<Commit> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    Commit getDraft(Commit et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(Commit et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Commit et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Commit> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Commit> fetchDefault(CommitSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Commit> listDefault(CommitSearchContext context);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Commit> fetchView(CommitSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Commit> listView(CommitSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<Commit> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Commit et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getMessage(),ex.getMessage());
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
    default Commit getEntity() {
        return new Commit();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default CommitSearchContext getSearchContext() {
        return new CommitSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}