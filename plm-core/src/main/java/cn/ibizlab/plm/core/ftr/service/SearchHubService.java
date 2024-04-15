/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@NoSQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ftr.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.ftr.domain.SearchHub;
import cn.ibizlab.plm.core.ftr.filter.SearchHubSearchContext;

/**
 * 检索中心服务接口[SearchHubService]
 *
 * @author generator
 */
public interface SearchHubService {

    /**
     * 获取当前Service
     *
     * @return
     */
    default SearchHubService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    SearchHub get(SearchHub et);
    /**
     * 获取
     * @param key
     * @return
     */
    default SearchHub get(String key) {
        return getById(key);
    }
    default SearchHub getById(String key) {
        return null;
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<SearchHub> getByIds(Collection<String> ids) {
        List<SearchHub> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SearchHub().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<SearchHub> getByEntities(List<SearchHub> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    SearchHub getDraft(SearchHub et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(SearchHub et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(SearchHub et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<SearchHub> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(SearchHub et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<SearchHub> list);

    /**
     * 保存
     * @param et
     * @return
     */
    boolean save(SearchHub et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<SearchHub> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new SearchHub().setId(key));
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
    boolean remove(SearchHub et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<SearchHub> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new SearchHub().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<SearchHub> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<SearchHub> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            SearchHub et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getTitle(),ex.getMessage());
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
    Page<SearchHub> searchDefault(SearchHubSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<SearchHub> listDefault(SearchHubSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default SearchHub getEntity() {
        return new SearchHub();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default SearchHubSearchContext getSearchContext() {
        return new SearchHubSearchContext();
    }

}