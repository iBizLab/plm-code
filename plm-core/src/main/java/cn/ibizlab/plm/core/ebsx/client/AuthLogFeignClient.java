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
import cn.ibizlab.plm.core.ebsx.domain.AuthLog;
import cn.ibizlab.plm.core.ebsx.filter.AuthLogSearchContext;
import cn.ibizlab.plm.core.ebsx.service.AuthLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
@FeignClient(value = "${ibiz.ref.service.ibizrtclient:ibizrtclient}", contextId = "authlog")
public interface AuthLogFeignClient  {
    @PostMapping("authlogs/checkkey")
    Integer checkKey(@Validated @RequestBody AuthLog dto) ;

    @PostMapping("authlogs")
    AuthLog create(@Validated @RequestBody AuthLog dto) ;

    @GetMapping("authlogs/{logId}")
    AuthLog getByLogId(@PathVariable("logId") String logId) ;

    @GetMapping("authlogs/getdraft")
    AuthLog getDraft(@SpringQueryMap AuthLog dto) ;

    @DeleteMapping("authlogs/{logId}")
    Boolean removeByLogId(@PathVariable("logId") String logId) ;

    @PostMapping("authlogs/save")
    AuthLog save(@Validated @RequestBody AuthLog dto) ;

    @PutMapping("authlogs/{logId}")
    AuthLog updateByLogId(@PathVariable("logId") String logId, @Validated @RequestBody AuthLog dto) ;

    @PostMapping("authlogs/fetchcuruser")
    Page<AuthLog> fetchCurUser(@Validated @RequestBody AuthLogSearchContext dto) ;

    @PostMapping("authlogs/fetchdefault")
    Page<AuthLog> fetchDefault(@Validated @RequestBody AuthLogSearchContext dto) ;

    @PostMapping("authlogs/batch")
    Boolean createBatch(@RequestBody List<AuthLog> domains);

    @PutMapping("authlogs/batch")
    boolean updateBatch(@RequestBody List<AuthLog> domains);

    @PostMapping("authlogs/savebatch")
    boolean saveBatch(@RequestBody List<AuthLog> domains);

    @PostMapping("authlogs/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<AuthLog> domains);

    @DeleteMapping("authlogs")
    boolean removeBatch(@RequestBody List<String> ids);

}