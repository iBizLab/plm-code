/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.ibizsysmgr.client.SysRoleMemberFeignClient;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysRoleMember;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysRoleMemberSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysRoleMemberService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[系统角色成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSysRoleMemberService implements SysRoleMemberService {

    @Autowired
    SysRoleMemberFeignClient sysRoleMemberFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysRoleMember et) {
        SysRoleMember rt = sysRoleMemberFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<SysRoleMember> list) {
        return sysRoleMemberFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(SysRoleMember et) {
        SysRoleMember rt = sysRoleMemberFeignClient.updateById(et.getId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<SysRoleMember> list) {
        return sysRoleMemberFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(SysRoleMember et) {
        return sysRoleMemberFeignClient.removeById(et.getId());
    }

    @Transactional
    public boolean remove(List<SysRoleMember> entities) {
       return sysRoleMemberFeignClient.removeBatch(entities.stream().map(e->e.getId()).collect(Collectors.toList()));
    }		

    public SysRoleMember get(SysRoleMember et) {
        return sysRoleMemberFeignClient.getById(et.getId());
    }	

    public List<SysRoleMember> get(List<SysRoleMember> entities) {
        return null;
    }	
	
    public SysRoleMember getDraft(SysRoleMember et) {
        return sysRoleMemberFeignClient.getDraft(et);
    }
	
    public CheckKeyStatus checkKey(SysRoleMember et) {
         return sysRoleMemberFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(SysRoleMember et) {
       SysRoleMember rt =  sysRoleMemberFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<SysRoleMember> list) {
        return sysRoleMemberFeignClient.saveBatch(list);
    }
	
     public Page<SysRoleMember> fetchDefault(SysRoleMemberSearchContext context) {
        return sysRoleMemberFeignClient.fetchDefault(context);
    }
	
    public List<SysRoleMember> listDefault(SysRoleMemberSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	

}