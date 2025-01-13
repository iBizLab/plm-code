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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.core.prodmgmt.domain.Channel;
import cn.ibizlab.plm.core.prodmgmt.filter.ChannelSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.util.annotation.DEAction;

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
    boolean create(List<Channel> list);

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
    boolean update(List<Channel> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new Channel().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(Channel et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<Channel> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Channel().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<Channel> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default Channel get(String key) {
        return getSelf().get(new Channel().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    Channel get(Channel et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<Channel> get(Collection<String> keys) {
        List<Channel> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new Channel().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<Channel> get(List<Channel> entities);

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
    CheckKeyStatus checkKey(Channel et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(Channel et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<Channel> list);

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<Channel> fetchDefault(ChannelSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<Channel> listDefault(ChannelSearchContext context);

    /**
    * findByProductId
    * @param productIds
    * @return
    */
    List<Channel> findByProductId(List<String> productIds);
    default List<Channel> findByProductId(String productId){
        return findByProduct(new Product().setId(productId));
    }

    /**
    * findByProduct
    * @param product
    * @return
    */
    List<Channel> findByProduct(Product product);

    /**
    * removeByProductId
    * @param productId
    * @return
    */
    boolean removeByProductId(String productId);

    /**
    * resetByProductId
    * @param productId
    * @return
    */
    boolean resetByProductId(String productId);

    /**
    * saveByProductId
    * @param productId
    * @param list
    * @return
    */
    default boolean saveByProductId(String productId, List<Channel> list){
        return getSelf().saveByProduct(new Product().setId(productId),list);
    }

    /**
    * saveByProduct
    * @param product
    * @param list
    * @return
    */
    boolean saveByProduct(Product product, List<Channel> list);

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<Channel> fetchView(ChannelSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<Channel> listView(ChannelSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}