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
import cn.ibizlab.plm.core.ebsx.domain.SysEmployee;
import cn.ibizlab.plm.core.ebsx.filter.SysEmployeeSearchContext;
import cn.ibizlab.plm.core.ebsx.service.SysEmployeeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
@FeignClient(value = "${ibiz.ref.service.ibizrtclient:ibizrtclient}", contextId = "sysemployee")
public interface SysEmployeeFeignClient  {
    @PostMapping("sysemployees/{userId}/changepwd")
    SysEmployee changePwdByUserId(@PathVariable("userId") String userId, @Validated @RequestBody SysEmployee dto) ;

    @PostMapping("sysemployees/checkkey")
    CheckKeyStatus checkKey(@Validated @RequestBody SysEmployee dto) ;

    @PostMapping("sysemployees")
    SysEmployee create(@Validated @RequestBody SysEmployee dto) ;

    @GetMapping("sysemployees/{userId}")
    SysEmployee getByUserId(@PathVariable("userId") String userId) ;

    @GetMapping("sysemployees/getdraft")
    SysEmployee getDraft(@SpringQueryMap SysEmployee dto) ;

    @PostMapping("sysemployees/{userId}/initpwd")
    SysEmployee initPwdByUserId(@PathVariable("userId") String userId, @Validated @RequestBody SysEmployee dto) ;

    @DeleteMapping("sysemployees/{userId}")
    Boolean removeByUserId(@PathVariable("userId") String userId) ;

    @PostMapping("sysemployees/save")
    SysEmployee save(@Validated @RequestBody SysEmployee dto) ;

    @PutMapping("sysemployees/{userId}")
    SysEmployee updateByUserId(@PathVariable("userId") String userId, @Validated @RequestBody SysEmployee dto) ;

    @PostMapping("sysemployees/fetchdefault")
    Page<SysEmployee> fetchDefault(@Validated @RequestBody SysEmployeeSearchContext dto) ;

    @PostMapping("sysemployees/fetchuser")
    Page<SysEmployee> fetchUser(@Validated @RequestBody SysEmployeeSearchContext dto) ;

    @PostMapping("sysemployees/batch")
    Boolean createBatch(@RequestBody List<SysEmployee> domains);

    @PutMapping("sysemployees/batch")
    boolean updateBatch(@RequestBody List<SysEmployee> domains);

    @PostMapping("sysemployees/savebatch")
    boolean saveBatch(@RequestBody List<SysEmployee> domains);

    @PostMapping("sysemployees/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<SysEmployee> domains);

    @DeleteMapping("sysemployees")
    boolean removeBatch(@RequestBody List<String> ids);

}