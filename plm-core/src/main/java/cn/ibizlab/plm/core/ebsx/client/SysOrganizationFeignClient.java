/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/client/{{clientEntities}}FeignClient.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.client;

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
import cn.ibizlab.plm.core.ebsx.domain.SysOrganization;
import cn.ibizlab.plm.core.ebsx.filter.SysOrganizationSearchContext;
import cn.ibizlab.plm.core.ebsx.service.SysOrganizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
//@FeignClient(value = "${ibiz.ref.service.ibizrtclient:ibizrtclient}", contextId = "sysorganization")
public interface SysOrganizationFeignClient  {
    @PostMapping("sysorganizations/checkkey")
    CheckKeyStatus checkKey(@Validated @RequestBody SysOrganization dto) ;

    @PostMapping("sysorganizations")
    SysOrganization create(@Validated @RequestBody SysOrganization dto) ;

    @GetMapping("sysorganizations/{orgId}")
    SysOrganization getByOrgId(@PathVariable("orgId") String orgId) ;

    @GetMapping("sysorganizations/getdraft")
    SysOrganization getDraft(@SpringQueryMap SysOrganization dto) ;

    @DeleteMapping("sysorganizations/{orgId}")
    Boolean removeByOrgId(@PathVariable("orgId") String orgId) ;

    @PostMapping("sysorganizations/{orgId}/save")
    SysOrganization saveByOrgId(@PathVariable("orgId") String orgId, @Validated @RequestBody SysOrganization dto) ;

    @PutMapping("sysorganizations/{orgId}")
    SysOrganization updateByOrgId(@PathVariable("orgId") String orgId, @Validated @RequestBody SysOrganization dto) ;

    @PostMapping("sysorganizations/fetchdefault")
    Page<SysOrganization> fetchDefault(@Validated @RequestBody SysOrganizationSearchContext dto) ;

    @PostMapping("sysorganizations/batch")
    Boolean createBatch(@RequestBody List<SysOrganization> domains);

    @PutMapping("sysorganizations/batch")
    boolean updateBatch(@RequestBody List<SysOrganization> domains);

    @PostMapping("sysorganizations/savebatch")
    boolean saveBatch(@RequestBody List<SysOrganization> domains);

    @PostMapping("sysorganizations/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<SysOrganization> domains);

    @DeleteMapping("sysorganizations")
    boolean removeBatch(@RequestBody List<String> ids);

}