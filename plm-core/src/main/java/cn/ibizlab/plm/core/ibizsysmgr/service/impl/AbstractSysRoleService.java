/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.ibizsysmgr.client.SysRoleFeignClient;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysRole;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysRoleSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysRoleService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[系统角色] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSysRoleService implements SysRoleService {

    @Autowired
    SysRoleFeignClient sysRoleFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysRole et) {
        SysRole rt = sysRoleFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<SysRole> list) {
        return sysRoleFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(SysRole et) {
        SysRole rt = sysRoleFeignClient.updateById(et.getId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<SysRole> list) {
        return sysRoleFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(SysRole et) {
        return sysRoleFeignClient.removeById(et.getId());
    }

    @Transactional
    public boolean remove(List<SysRole> entities) {
       return sysRoleFeignClient.removeBatch(entities.stream().map(e->e.getId()).collect(Collectors.toList()));
    }		

    public SysRole get(SysRole et) {
        return sysRoleFeignClient.getById(et.getId());
    }	

    public List<SysRole> get(List<SysRole> entities) {
        return null;
    }	
	
    public SysRole getDraft(SysRole et) {
        return sysRoleFeignClient.getDraft(et);
    }
	
    public CheckKeyStatus checkKey(SysRole et) {
         return sysRoleFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(SysRole et) {
       SysRole rt =  sysRoleFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<SysRole> list) {
        return sysRoleFeignClient.saveBatch(list);
    }
	
     public Page<SysRole> fetchDefault(SysRoleSearchContext context) {
        return sysRoleFeignClient.fetchDefault(context);
    }
	
    public List<SysRole> listDefault(SysRoleSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	

}