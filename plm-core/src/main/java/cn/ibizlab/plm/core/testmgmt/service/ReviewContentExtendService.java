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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewContentExtendSearchContext;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 评审内容扩展服务接口[ReviewContentExtendService]
 *
 * @author generator
 */
public interface ReviewContentExtendService extends IService<ReviewContentExtend> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ReviewContentExtendService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(ReviewContentExtend et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<ReviewContentExtend> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(ReviewContentExtend et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<ReviewContentExtend> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new ReviewContentExtend().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(ReviewContentExtend et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<ReviewContentExtend> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReviewContentExtend().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<ReviewContentExtend> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default ReviewContentExtend get(String key) {
        return getSelf().get(new ReviewContentExtend().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    ReviewContentExtend get(ReviewContentExtend et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<ReviewContentExtend> get(Collection<String> keys) {
        List<ReviewContentExtend> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new ReviewContentExtend().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<ReviewContentExtend> get(List<ReviewContentExtend> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    ReviewContentExtend getDraft(ReviewContentExtend et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(ReviewContentExtend et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(ReviewContentExtend et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<ReviewContentExtend> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<ReviewContentExtend> fetchDefault(ReviewContentExtendSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<ReviewContentExtend> listDefault(ReviewContentExtendSearchContext context);

    default List<ReviewResult> getStageResults(ReviewContentExtend et) {
        return new ArrayList<>();
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<ReviewContentExtend> fetchView(ReviewContentExtendSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<ReviewContentExtend> listView(ReviewContentExtendSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<ReviewContentExtend> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            ReviewContentExtend et=list.get(i);
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
    default ReviewContentExtend getEntity() {
        return new ReviewContentExtend();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default ReviewContentExtendSearchContext getSearchContext() {
        return new ReviewContentExtendSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}