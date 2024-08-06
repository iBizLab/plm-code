/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service.impl;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.ebsx.client.SysEmployeeFeignClient;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ebsx.domain.SysEmployee;
import cn.ibizlab.plm.core.ebsx.filter.SysEmployeeSearchContext;
import cn.ibizlab.plm.core.ebsx.service.SysEmployeeService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[人员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSysEmployeeService implements SysEmployeeService {

    @Autowired
    SysEmployeeFeignClient sysEmployeeFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysEmployee et) {
        SysEmployee rt = sysEmployeeFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<SysEmployee> list) {
        return sysEmployeeFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(SysEmployee et) {
        SysEmployee rt = sysEmployeeFeignClient.updateByUserId(et.getUserId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<SysEmployee> list) {
        return sysEmployeeFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(SysEmployee et) {
        return sysEmployeeFeignClient.removeByUserId(et.getUserId());
    }

    @Transactional
    public boolean remove(List<SysEmployee> entities) {
       return sysEmployeeFeignClient.removeBatch(entities.stream().map(e->e.getUserId()).collect(Collectors.toList()));
    }		

    public SysEmployee get(SysEmployee et) {
        return sysEmployeeFeignClient.getByUserId(et.getUserId());
    }	

    public List<SysEmployee> get(List<SysEmployee> entities) {
        return null;
    }	
	
    public SysEmployee getDraft(SysEmployee et) {
        return sysEmployeeFeignClient.getDraft(et);
    }
	
    public CheckKeyStatus checkKey(SysEmployee et) {
         return sysEmployeeFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(SysEmployee et) {
       SysEmployee rt =  sysEmployeeFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<SysEmployee> list) {
        return sysEmployeeFeignClient.saveBatch(list);
    }
	
     public Page<SysEmployee> fetchDefault(SysEmployeeSearchContext context) {
        return sysEmployeeFeignClient.fetchDefault(context);
    }
	
    public List<SysEmployee> listDefault(SysEmployeeSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	
     public Page<SysEmployee> fetchUser(SysEmployeeSearchContext context) {
        return sysEmployeeFeignClient.fetchUser(context);
    }
	
    public List<SysEmployee> listUser(SysEmployeeSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchUser(context).getContent();
    }
	

}