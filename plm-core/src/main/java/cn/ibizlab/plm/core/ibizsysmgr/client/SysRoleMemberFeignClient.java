/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/client/{{clientEntities}}FeignClient.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.client;

import java.io.Serializable;
import java.util.*;
import lombok.extern.slf4j.Slf4j;

import cn.ibizlab.util.security.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Value;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysRoleMember;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysRoleMemberSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysRoleMemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
@FeignClient(value = "${ibiz.ref.service.ibizsysmgr:ibizsysmgr}", contextId = "sysrolemember")
public interface SysRoleMemberFeignClient  {
    @PostMapping("sys_role_members/checkkey")
    CheckKeyStatus checkKey(@Validated @RequestBody SysRoleMember dto) ;

    @PostMapping("sys_role_members")
    SysRoleMember create(@Validated @RequestBody SysRoleMember dto) ;

    @GetMapping("sys_role_members/{id}")
    SysRoleMember getById(@PathVariable("id") String id) ;

    @GetMapping("sys_role_members/getdraft")
    SysRoleMember getDraft(@SpringQueryMap SysRoleMember dto) ;

    @DeleteMapping("sys_role_members/{id}")
    Boolean removeById(@PathVariable("id") String id) ;

    @PostMapping("sys_role_members/save")
    SysRoleMember save(@Validated @RequestBody SysRoleMember dto) ;

    @PutMapping("sys_role_members/{id}")
    SysRoleMember updateById(@PathVariable("id") String id, @Validated @RequestBody SysRoleMember dto) ;

    @PostMapping("sys_role_members/fetchdefault")
    Page<SysRoleMember> fetchDefault(@Validated @RequestBody SysRoleMemberSearchContext dto) ;

    @PostMapping("sysrolemembers/batch")
    Boolean createBatch(@RequestBody List<SysRoleMember> domains);

    @PutMapping("sysrolemembers/batch")
    boolean updateBatch(@RequestBody List<SysRoleMember> domains);

    @PostMapping("sysrolemembers/savebatch")
    boolean saveBatch(@RequestBody List<SysRoleMember> domains);

    @PostMapping("sysrolemembers/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<SysRoleMember> domains);

    @DeleteMapping("sysrolemembers")
    boolean removeBatch(@RequestBody List<String> ids);

}