/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.ibizsysmgr.client.SysPersonFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysPerson;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysPersonSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysPersonService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[人员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSysPersonService implements SysPersonService {

    @Autowired
    SysPersonFeignClient sysPersonFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysPerson et) {
        SysPerson rt = sysPersonFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<SysPerson> list) {
        return sysPersonFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(SysPerson et) {
        SysPerson rt = sysPersonFeignClient.updateById(et.getId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<SysPerson> list) {
        return sysPersonFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(SysPerson et) {
        return sysPersonFeignClient.removeById(et.getId());
    }

    @Transactional
    public boolean remove(List<SysPerson> entities) {
       return sysPersonFeignClient.removeBatch(entities.stream().map(e->e.getId()).collect(Collectors.toList()));
    }		

    public SysPerson get(SysPerson et) {
        return sysPersonFeignClient.getById(et.getId());
    }	

    public List<SysPerson> get(List<SysPerson> entities) {
        return null;
    }	
	
    public SysPerson getDraft(SysPerson et) {
        return sysPersonFeignClient.getDraft(et);
    }
	
    public CheckKeyStatus checkKey(SysPerson et) {
         return sysPersonFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(SysPerson et) {
       SysPerson rt =  sysPersonFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<SysPerson> list) {
        return sysPersonFeignClient.saveBatch(list);
    }
	
     public Page<SysPerson> fetchDefault(SysPersonSearchContext context) {
        return sysPersonFeignClient.fetchDefault(context);
    }
	
    public List<SysPerson> listDefault(SysPersonSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	
     public Page<SysPerson> fetchUser(SysPersonSearchContext context) {
        return sysPersonFeignClient.fetchUser(context);
    }
	
    public List<SysPerson> listUser(SysPersonSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchUser(context).getContent();
    }
	

}