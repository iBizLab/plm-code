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
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysRole;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysRoleSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysRoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
@FeignClient(value = "${ibiz.ref.service.ibizsysmgr:ibizsysmgr}", contextId = "sysrole")
public interface SysRoleFeignClient  {
    @PostMapping("sys_roles/checkkey")
    CheckKeyStatus checkKey(@Validated @RequestBody SysRole dto) ;

    @PostMapping("sys_roles")
    SysRole create(@Validated @RequestBody SysRole dto) ;

    @GetMapping("sys_roles/{id}")
    SysRole getById(@PathVariable("id") String id) ;

    @GetMapping("sys_roles/getdraft")
    SysRole getDraft(@SpringQueryMap SysRole dto) ;

    @DeleteMapping("sys_roles/{id}")
    Boolean removeById(@PathVariable("id") String id) ;

    @PostMapping("sys_roles/save")
    SysRole save(@Validated @RequestBody SysRole dto) ;

    @PutMapping("sys_roles/{id}")
    SysRole updateById(@PathVariable("id") String id, @Validated @RequestBody SysRole dto) ;

    @PostMapping("sys_roles/fetchdefault")
    Page<SysRole> fetchDefault(@Validated @RequestBody SysRoleSearchContext dto) ;

    @PostMapping("sysroles/batch")
    Boolean createBatch(@RequestBody List<SysRole> domains);

    @PutMapping("sysroles/batch")
    boolean updateBatch(@RequestBody List<SysRole> domains);

    @PostMapping("sysroles/savebatch")
    boolean saveBatch(@RequestBody List<SysRole> domains);

    @PostMapping("sysroles/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<SysRole> domains);

    @DeleteMapping("sysroles")
    boolean removeBatch(@RequestBody List<String> ids);

}