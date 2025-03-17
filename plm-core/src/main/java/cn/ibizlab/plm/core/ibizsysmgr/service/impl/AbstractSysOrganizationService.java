/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.ibizsysmgr.client.SysOrganizationFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysOrganization;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysOrganizationSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysOrganizationService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[组织] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSysOrganizationService implements SysOrganizationService {

    @Autowired
    SysOrganizationFeignClient sysOrganizationFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysOrganization et) {
        SysOrganization rt = sysOrganizationFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<SysOrganization> list) {
        return sysOrganizationFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(SysOrganization et) {
        SysOrganization rt = sysOrganizationFeignClient.updateById(et.getId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<SysOrganization> list) {
        return sysOrganizationFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(SysOrganization et) {
        return sysOrganizationFeignClient.removeById(et.getId());
    }

    @Transactional
    public boolean remove(List<SysOrganization> entities) {
       return sysOrganizationFeignClient.removeBatch(entities.stream().map(e->e.getId()).collect(Collectors.toList()));
    }		

    public SysOrganization get(SysOrganization et) {
        return sysOrganizationFeignClient.getById(et.getId());
    }	

    public List<SysOrganization> get(List<SysOrganization> entities) {
        return null;
    }	
	
    public SysOrganization getDraft(SysOrganization et) {
        return sysOrganizationFeignClient.getDraft(et);
    }
	
    public CheckKeyStatus checkKey(SysOrganization et) {
         return sysOrganizationFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(SysOrganization et) {
       SysOrganization rt =  sysOrganizationFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<SysOrganization> list) {
        return sysOrganizationFeignClient.saveBatch(list);
    }
	
     public Page<SysOrganization> fetchDefault(SysOrganizationSearchContext context) {
        return sysOrganizationFeignClient.fetchDefault(context);
    }
	
    public List<SysOrganization> listDefault(SysOrganizationSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	
     public Page<SysOrganization> fetchNav(SysOrganizationSearchContext context) {
        return sysOrganizationFeignClient.fetchNav(context);
    }
	
    public List<SysOrganization> listNav(SysOrganizationSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchNav(context).getContent();
    }
	

}