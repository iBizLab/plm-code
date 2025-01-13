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
import cn.ibizlab.plm.core.prodmgmt.domain.TicketType;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketTypeSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.util.annotation.DEAction;

/**
 * 工单类型服务接口[TicketTypeService]
 *
 * @author generator
 */
public interface TicketTypeService extends IService<TicketType> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default TicketTypeService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
    * 创建
    * @param et
    * @return
    */
    boolean create(TicketType et);

    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean create(List<TicketType> list);

    /**
    * 更新
    * @param et
    * @return
    */
    boolean update(TicketType et);

    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean update(List<TicketType> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TicketType().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(TicketType et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<TicketType> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TicketType().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<TicketType> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default TicketType get(String key) {
        return getSelf().get(new TicketType().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    TicketType get(TicketType et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<TicketType> get(Collection<String> keys) {
        List<TicketType> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new TicketType().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<TicketType> get(List<TicketType> entities);

    /**
    * 草稿
    * @param et
    * @return
    */
    TicketType getDraft(TicketType et);

    /**
    * checkKey
    * @param et
    * @return
    */
    CheckKeyStatus checkKey(TicketType et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(TicketType et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<TicketType> list);

    /**
    * getConTicket
    * 
    * @param key
    * @return
    */
    default TicketType getConTicket(String key) {
        return getSelf().getConTicket(new TicketType().setId(key));
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default TicketType nothing(TicketType et) {
        return et;
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<TicketType> fetchDefault(TicketTypeSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<TicketType> listDefault(TicketTypeSearchContext context);

    /**
    * fetchNotExistsTicketType
    * 
    * @param context
    * @return
    */
    Page<TicketType> fetchNotExistsTicketType(TicketTypeSearchContext context);

    /**
    * listNotExistsTicketType
    * 
    * @param context
    * @return
    */
    List<TicketType> listNotExistsTicketType(TicketTypeSearchContext context);

    /**
    * getConTicket
    * 
    * @param et
    * @return
    */
    default TicketType getConTicket(TicketType et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<TicketType> fetchView(TicketTypeSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<TicketType> listView(TicketTypeSearchContext context);


    default ImportResult importData(String config, Boolean ignoreError, List<TicketType> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            TicketType et=list.get(i);
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
    default TicketType getEntity() {
        return new TicketType();
    }

    /**
     * 创建搜索对象
     * @return
     */
    default TicketTypeSearchContext getSearchContext() {
        return new TicketTypeSearchContext();
    }


    /**
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}