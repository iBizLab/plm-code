/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.service;

import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.prodmgmt.domain.Channel;
import cn.ibizlab.plm.core.prodmgmt.filter.ChannelSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;

/**
 * 工单渠道服务接口[ChannelService]
 *
 * @author generator
 */
public interface ChannelService extends IService<Channel> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default ChannelService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Channel get(Channel et);
    /**
     * 获取
     * @param key
     * @return
     */
    default Channel get(String key) {
        return getSelf().get(new Channel().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<Channel> getByIds(Collection<String> ids) {
        List<Channel> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Channel().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<Channel> getByEntities(List<Channel> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    Channel getDraft(Channel et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(Channel et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(Channel et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<Channel> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(Channel et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<Channel> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(Channel et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<Channel> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Channel().setId(key));
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
    boolean remove(Channel et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<Channel> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new Channel().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<Channel> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<Channel> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            Channel et=list.get(i);
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
    Page<Channel> searchDefault(ChannelSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<Channel> listDefault(ChannelSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default Channel getEntity() {
        return new Channel();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default ChannelSearchContext getSearchContext() {
        return new ChannelSearchContext();
    }
    /**
     * selectRelByProductId
     * @param productIds
     * @return
     */
    List<Channel> findByProductId(List<String> productIds);
    default List<Channel> findByProductId(String productId) {
        return findByProductId(Arrays.asList(productId));
    }
    /**
     * removeRelByProductId
     * @param productId
     * @return
     */
    boolean removeByProductId(String productId);
    /**
     * resetRelByProductId
     * @param productId
     * @return
     */
    boolean resetByProductId(String productId);
    /**
     * saveRelByProductId
     * @param productId
     * @param list
     * @return
     */
    default boolean saveByProductId(String productId,List<Channel> list) {
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }
    /**
    * saveRelByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product,List<Channel> list);


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