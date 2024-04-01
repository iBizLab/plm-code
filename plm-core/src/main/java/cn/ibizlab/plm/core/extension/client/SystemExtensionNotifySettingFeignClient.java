/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/client/{{clientEntities}}FeignClient.java.hbs
 */
package cn.ibizlab.plm.core.extension.client;

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
import cn.ibizlab.plm.core.extension.domain.SystemExtensionNotifySetting;
import cn.ibizlab.plm.core.extension.filter.SystemExtensionNotifySettingSearchContext;
import cn.ibizlab.plm.core.extension.service.SystemExtensionNotifySettingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author generator
 */
@FeignClient(value = "${ibiz.ref.service.extension:extension}", contextId = "systemextensionnotifysetting")
public interface SystemExtensionNotifySettingFeignClient  {
    @PostMapping("system_extension_notify_settings/check_key")
    Integer checkKey(@Validated @RequestBody SystemExtensionNotifySetting dto) ;

    @PostMapping("system_extension_notify_settings")
    SystemExtensionNotifySetting create(@Validated @RequestBody SystemExtensionNotifySetting dto) ;

    @GetMapping("system_extension_notify_settings/{id}")
    SystemExtensionNotifySetting getById(@PathVariable("id") String id) ;

    @GetMapping("system_extension_notify_settings/get_draft")
    SystemExtensionNotifySetting getDraft(@SpringQueryMap SystemExtensionNotifySetting dto) ;

    @DeleteMapping("system_extension_notify_settings/{id}")
    Boolean removeById(@PathVariable("id") String id) ;

    @PostMapping("system_extension_notify_settings/save")
    SystemExtensionNotifySetting save(@Validated @RequestBody SystemExtensionNotifySetting dto) ;

    @PutMapping("system_extension_notify_settings/{id}")
    SystemExtensionNotifySetting updateById(@PathVariable("id") String id, @Validated @RequestBody SystemExtensionNotifySetting dto) ;

    @PostMapping("system_extension_notify_settings/fetch_cur_user")
    Page<SystemExtensionNotifySetting> fetchCurUser(@Validated @RequestBody SystemExtensionNotifySettingSearchContext dto) ;

    @PostMapping("system_extension_notify_settings/fetch_default")
    Page<SystemExtensionNotifySetting> fetchDefault(@Validated @RequestBody SystemExtensionNotifySettingSearchContext dto) ;

    @PostMapping("systemextensionnotifysettings/batch")
    Boolean createBatch(@RequestBody List<SystemExtensionNotifySetting> domains);

    @PutMapping("systemextensionnotifysettings/batch")
    boolean updateBatch(@RequestBody List<SystemExtensionNotifySetting> domains);

    @PostMapping("systemextensionnotifysettings/savebatch")
    boolean saveBatch(@RequestBody List<SystemExtensionNotifySetting> domains);

    @PostMapping("systemextensionnotifysettings/import")
    Map importData(@RequestParam(value = "config") String config ,@RequestBody List<SystemExtensionNotifySetting> domains);

    @DeleteMapping("systemextensionnotifysettings")
    boolean removeBatch(@RequestBody List<String> ids);

}