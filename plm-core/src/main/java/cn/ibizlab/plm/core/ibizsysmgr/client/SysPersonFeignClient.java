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
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysPerson;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysPersonSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysPersonService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
@FeignClient(value = "${ibiz.ref.service.ibizsysmgr:ibizsysmgr}", contextId = "sysperson")
public interface SysPersonFeignClient  {
    @PostMapping("sys_people/checkkey")
    Integer checkKey(@Validated @RequestBody SysPerson dto) ;

    @PostMapping("sys_people")
    SysPerson create(@Validated @RequestBody SysPerson dto) ;

    @GetMapping("sys_people/{id}")
    SysPerson getById(@PathVariable("id") String id) ;

    @GetMapping("sys_people/getdraft")
    SysPerson getDraft(@SpringQueryMap SysPerson dto) ;

    @DeleteMapping("sys_people/{id}")
    Boolean removeById(@PathVariable("id") String id) ;

    @PostMapping("sys_people/save")
    SysPerson save(@Validated @RequestBody SysPerson dto) ;

    @PutMapping("sys_people/{id}")
    SysPerson updateById(@PathVariable("id") String id, @Validated @RequestBody SysPerson dto) ;

    @PostMapping("sys_people/fetchdefault")
    Page<SysPerson> fetchDefault(@Validated @RequestBody SysPersonSearchContext dto) ;

    @PostMapping("syspeople/batch")
    Boolean createBatch(@RequestBody List<SysPerson> domains);

    @PutMapping("syspeople/batch")
    boolean updateBatch(@RequestBody List<SysPerson> domains);

    @PostMapping("syspeople/savebatch")
    boolean saveBatch(@RequestBody List<SysPerson> domains);

    @PostMapping("syspeople/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<SysPerson> domains);

    @DeleteMapping("syspeople")
    boolean removeBatch(@RequestBody List<String> ids);

}