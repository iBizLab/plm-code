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
import cn.ibizlab.plm.core.prodmgmt.domain.TicketType;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketTypeSearchContext;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;

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
     * 获取
     * @param et
     * @return
     */
    TicketType get(TicketType et);
    /**
     * 获取
     * @param key
     * @return
     */
    default TicketType get(String key) {
        return getSelf().get(new TicketType().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<TicketType> getByIds(Collection<String> ids) {
        List<TicketType> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TicketType().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<TicketType> getByEntities(List<TicketType> entities);

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
    Integer checkKey(TicketType et);

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
    boolean createBatch(List<TicketType> list);

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
    boolean updateBatch(List<TicketType> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(TicketType et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<TicketType> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new TicketType().setId(key));
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
    boolean remove(TicketType et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<TicketType> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new TicketType().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<TicketType> entities);

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
     * get_con_ticket
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
     * @param dto
     * @return
     */
    default TicketType nothing(TicketType dto) {
        return dto;
    }

    /**
     * get_con_ticket
     * 
     * @param et
     * @return
     */
    default TicketType getConTicket(TicketType et) {
        return et;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<TicketType> searchDefault(TicketTypeSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<TicketType> listDefault(TicketTypeSearchContext context);

    /**
     * searchnot_exists_ticket_type
     * 
     * @param context
     * @return
     */
    Page<TicketType> searchNotExistsTicketType(TicketTypeSearchContext context);
    /**
     * listnot_exists_ticket_type
     * 
     * @param context
     * @return
     */
    List<TicketType> listNotExistsTicketType(TicketTypeSearchContext context);

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