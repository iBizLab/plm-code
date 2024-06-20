/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.ebsx.client.SysTodoFeignClient;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ebsx.domain.SysTodo;
import cn.ibizlab.plm.core.ebsx.filter.SysTodoSearchContext;
import cn.ibizlab.plm.core.ebsx.service.SysTodoService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[待办] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSysTodoService implements SysTodoService {

    @Autowired
    SysTodoFeignClient sysTodoFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysTodo et) {
        SysTodo rt = sysTodoFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<SysTodo> list) {
        return sysTodoFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(SysTodo et) {
        SysTodo rt = sysTodoFeignClient.updateByTodoId(et.getTodoId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<SysTodo> list) {
        return sysTodoFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(SysTodo et) {
        return sysTodoFeignClient.removeByTodoId(et.getTodoId());
    }

    @Transactional
    public boolean remove(List<SysTodo> entities) {
       return sysTodoFeignClient.removeBatch(entities.stream().map(e->e.getTodoId()).collect(Collectors.toList()));
    }		

    public SysTodo get(SysTodo et) {
        return sysTodoFeignClient.getByTodoId(et.getTodoId());
    }	

    public List<SysTodo> get(List<SysTodo> entities) {
        return null;
    }	
	
    public SysTodo getDraft(SysTodo et) {
        return sysTodoFeignClient.getDraft(et);
    }
	
    public Integer checkKey(SysTodo et) {
         return sysTodoFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(SysTodo et) {
       SysTodo rt =  sysTodoFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<SysTodo> list) {
        return sysTodoFeignClient.saveBatch(list);
    }
	
     public Page<SysTodo> fetchCurUser(SysTodoSearchContext context) {
        return sysTodoFeignClient.fetchCurUser(context);
    }
	
    public List<SysTodo> listCurUser(SysTodoSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchCurUser(context).getContent();
    }
	
     public Page<SysTodo> fetchDefault(SysTodoSearchContext context) {
        return sysTodoFeignClient.fetchDefault(context);
    }
	
    public List<SysTodo> listDefault(SysTodoSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	

}