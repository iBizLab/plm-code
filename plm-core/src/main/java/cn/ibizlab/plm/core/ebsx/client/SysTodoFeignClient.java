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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ebsx.domain.SysTodo;
import cn.ibizlab.plm.core.ebsx.filter.SysTodoSearchContext;
import cn.ibizlab.plm.core.ebsx.service.SysTodoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
@FeignClient(value = "${ibiz.ref.service.ibizrtclient:ibizrtclient}", contextId = "systodo")
public interface SysTodoFeignClient  {
    @PostMapping("systodos/checkkey")
    Integer checkKey(@Validated @RequestBody SysTodo dto) ;

    @PostMapping("systodos")
    SysTodo create(@Validated @RequestBody SysTodo dto) ;

    @GetMapping("systodos/{todoId}")
    SysTodo getByTodoId(@PathVariable("todoId") String todoId) ;

    @GetMapping("systodos/getdraft")
    SysTodo getDraft(@SpringQueryMap SysTodo dto) ;

    @PostMapping("systodos/{todoId}/getlinkurl")
    SysTodo getLinkUrlByTodoId(@PathVariable("todoId") String todoId) ;

    @DeleteMapping("systodos/{todoId}")
    Boolean removeByTodoId(@PathVariable("todoId") String todoId) ;

    @PostMapping("systodos/save")
    SysTodo save(@Validated @RequestBody SysTodo dto) ;

    @PutMapping("systodos/{todoId}")
    SysTodo updateByTodoId(@PathVariable("todoId") String todoId, @Validated @RequestBody SysTodo dto) ;

    @PostMapping("systodos/fetchcuruser")
    Page<SysTodo> fetchCurUser(@Validated @RequestBody SysTodoSearchContext dto) ;

    @PostMapping("systodos/fetchdefault")
    Page<SysTodo> fetchDefault(@Validated @RequestBody SysTodoSearchContext dto) ;

    @PostMapping("systodos/batch")
    Boolean createBatch(@RequestBody List<SysTodo> domains);

    @PutMapping("systodos/batch")
    boolean updateBatch(@RequestBody List<SysTodo> domains);

    @PostMapping("systodos/savebatch")
    boolean saveBatch(@RequestBody List<SysTodo> domains);

    @PostMapping("systodos/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<SysTodo> domains);

    @DeleteMapping("systodos")
    boolean removeBatch(@RequestBody List<String> ids);

}