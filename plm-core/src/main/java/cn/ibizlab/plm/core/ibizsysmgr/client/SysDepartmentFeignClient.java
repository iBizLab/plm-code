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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysDepartment;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysDepartmentSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysDepartmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
@FeignClient(value = "${ibiz.ref.service.ibizsysmgr:ibizsysmgr}", contextId = "sysdepartment")
public interface SysDepartmentFeignClient  {
    @PostMapping("sys_departments/checkkey")
    Integer checkKey(@Validated @RequestBody SysDepartment dto) ;

    @PostMapping("sys_departments")
    SysDepartment create(@Validated @RequestBody SysDepartment dto) ;

    @GetMapping("sys_departments/{id}")
    SysDepartment getById(@PathVariable("id") String id) ;

    @GetMapping("sys_departments/getdraft")
    SysDepartment getDraft(@SpringQueryMap SysDepartment dto) ;

    @DeleteMapping("sys_departments/{id}")
    Boolean removeById(@PathVariable("id") String id) ;

    @PostMapping("sys_departments/save")
    SysDepartment save(@Validated @RequestBody SysDepartment dto) ;

    @PutMapping("sys_departments/{id}")
    SysDepartment updateById(@PathVariable("id") String id, @Validated @RequestBody SysDepartment dto) ;

    @PostMapping("sys_departments/fetchdefault")
    Page<SysDepartment> fetchDefault(@Validated @RequestBody SysDepartmentSearchContext dto) ;

    @PostMapping("sysdepartments/batch")
    Boolean createBatch(@RequestBody List<SysDepartment> domains);

    @PutMapping("sysdepartments/batch")
    boolean updateBatch(@RequestBody List<SysDepartment> domains);

    @PostMapping("sysdepartments/savebatch")
    boolean saveBatch(@RequestBody List<SysDepartment> domains);

    @PostMapping("sysdepartments/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<SysDepartment> domains);

    @DeleteMapping("sysdepartments")
    boolean removeBatch(@RequestBody List<String> ids);

}