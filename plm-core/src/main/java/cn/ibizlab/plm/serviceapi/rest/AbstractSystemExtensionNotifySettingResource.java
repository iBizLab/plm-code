/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/rest/Abstract{{apiEntities}}Resource.java.hbs
 */
package cn.ibizlab.plm.serviceapi.rest;

import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.ApiOperation;
import java.util.stream.IntStream;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.domain.RequestWrapper;
import cn.ibizlab.util.domain.ResponseWrapper;
import cn.ibizlab.plm.serviceapi.dto.*;
import cn.ibizlab.plm.serviceapi.mapping.*;
import cn.ibizlab.plm.core.extension.domain.SystemExtensionNotifySetting;
import cn.ibizlab.plm.core.extension.service.SystemExtensionNotifySettingService;
import cn.ibizlab.plm.core.extension.filter.SystemExtensionNotifySettingSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[SystemExtensionNotifySetting] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSystemExtensionNotifySettingResource {

    @Autowired
    public SystemExtensionNotifySettingService systemExtensionNotifySettingService;

    @Autowired
    @Lazy
    public SystemExtensionNotifySettingDTOMapping systemExtensionNotifySettingDtoMapping;

    @Autowired
    @Lazy
    public SystemExtensionNotifySettingFilterDTOMapping systemExtensionNotifySettingFilterDtoMapping;

    /**
    * 创建Create 通知设置
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SystemExtensionNotifySettingDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"通知设置" },  notes = "SystemExtensionNotifySetting-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SystemExtensionNotifySetting-Create-all') or hasPermission(this.systemExtensionNotifySettingDtoMapping.toDomain(#dto),'ibizplm-SystemExtensionNotifySetting-Create')")
    @PostMapping("system_extension_notify_settings")
    public ResponseEntity<ResponseWrapper<SystemExtensionNotifySettingDTO>> create
            (@Validated @RequestBody RequestWrapper<SystemExtensionNotifySettingDTO> dto) {
        ResponseWrapper<SystemExtensionNotifySettingDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 通知设置
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SystemExtensionNotifySettingDTO>
    */   
    public SystemExtensionNotifySettingDTO create
            (SystemExtensionNotifySettingDTO dto) {
        SystemExtensionNotifySetting domain = systemExtensionNotifySettingDtoMapping.toDomain(dto);
        systemExtensionNotifySettingService.create(domain);
        SystemExtensionNotifySetting rt = domain;
        return systemExtensionNotifySettingDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 通知设置
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SystemExtensionNotifySettingDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"通知设置" },  notes = "SystemExtensionNotifySetting-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SystemExtensionNotifySetting-Update-all') or hasPermission(this.systemExtensionNotifySettingService.get(#id),'ibizplm-SystemExtensionNotifySetting-Update')")
    @VersionCheck(entity = "systemextensionnotifysetting" , versionfield = "updateTime")
    @PutMapping("system_extension_notify_settings/{id}")
    public ResponseEntity<ResponseWrapper<SystemExtensionNotifySettingDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SystemExtensionNotifySettingDTO> dto) {
        ResponseWrapper<SystemExtensionNotifySettingDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 通知设置
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SystemExtensionNotifySettingDTO>
    */   
    public SystemExtensionNotifySettingDTO updateById
            (String id, SystemExtensionNotifySettingDTO dto) {
        SystemExtensionNotifySetting domain = systemExtensionNotifySettingDtoMapping.toDomain(dto);
        domain.setId(id);
        systemExtensionNotifySettingService.update(domain);
        SystemExtensionNotifySetting rt = domain;
        return systemExtensionNotifySettingDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 通知设置
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SystemExtensionNotifySettingDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"通知设置" },  notes = "SystemExtensionNotifySetting-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SystemExtensionNotifySetting-Save-all') or hasPermission(this.systemExtensionNotifySettingDtoMapping.toDomain(#dto),'ibizplm-SystemExtensionNotifySetting-Save')")
    @PostMapping("system_extension_notify_settings/save")
    public ResponseEntity<ResponseWrapper<SystemExtensionNotifySettingDTO>> save
            (@Validated @RequestBody RequestWrapper<SystemExtensionNotifySettingDTO> dto) {
        ResponseWrapper<SystemExtensionNotifySettingDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 通知设置
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SystemExtensionNotifySettingDTO>
    */   
    public SystemExtensionNotifySettingDTO save
            (SystemExtensionNotifySettingDTO dto) {
        SystemExtensionNotifySetting domain = systemExtensionNotifySettingDtoMapping.toDomain(dto);
        systemExtensionNotifySettingService.save(domain);
        SystemExtensionNotifySetting rt = domain;
        return systemExtensionNotifySettingDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 通知设置
    * 
    *
    * @param id id
    * @return ResponseEntity<SystemExtensionNotifySettingDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"通知设置" },  notes = "SystemExtensionNotifySetting-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SystemExtensionNotifySetting-Get-all')  or hasPermission(this.systemExtensionNotifySettingDtoMapping.toDomain(returnObject.body),'ibizplm-SystemExtensionNotifySetting-Get')")
    @GetMapping("system_extension_notify_settings/{id}")
    public ResponseEntity<SystemExtensionNotifySettingDTO> getById
            (@PathVariable("id") String id) {
        SystemExtensionNotifySetting rt = systemExtensionNotifySettingService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(systemExtensionNotifySettingDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 通知设置
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"通知设置" },  notes = "SystemExtensionNotifySetting-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SystemExtensionNotifySetting-Remove-all') or hasPermission(this.systemExtensionNotifySettingService.get(#id),'ibizplm-SystemExtensionNotifySetting-Remove')")
    @DeleteMapping("system_extension_notify_settings/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = systemExtensionNotifySettingService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 通知设置
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"通知设置" },  notes = "SystemExtensionNotifySetting-CheckKey ")
    @PostMapping("system_extension_notify_settings/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SystemExtensionNotifySettingDTO dto) {
        SystemExtensionNotifySetting domain = systemExtensionNotifySettingDtoMapping.toDomain(dto);
        Integer rt = systemExtensionNotifySettingService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 通知设置
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SystemExtensionNotifySettingDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"通知设置" },  notes = "SystemExtensionNotifySetting-GetDraft ")
    @GetMapping("system_extension_notify_settings/getdraft")
    public ResponseEntity<SystemExtensionNotifySettingDTO> getDraft
            (@SpringQueryMap SystemExtensionNotifySettingDTO dto) {
        SystemExtensionNotifySetting domain = systemExtensionNotifySettingDtoMapping.toDomain(dto);
        SystemExtensionNotifySetting rt = systemExtensionNotifySettingService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(systemExtensionNotifySettingDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 通知设置
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SystemExtensionNotifySettingDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"通知设置" },  notes = "SystemExtensionNotifySetting-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SystemExtensionNotifySetting-FetchDefault-all') or hasPermission(#dto,'ibizplm-SystemExtensionNotifySetting-FetchDefault')")
    @PostMapping("system_extension_notify_settings/fetchdefault")
    public ResponseEntity<List<SystemExtensionNotifySettingDTO>> fetchDefault
            (@Validated @RequestBody SystemExtensionNotifySettingFilterDTO dto) {
        SystemExtensionNotifySettingSearchContext context = systemExtensionNotifySettingFilterDtoMapping.toDomain(dto);
        Page<SystemExtensionNotifySetting> domains = systemExtensionNotifySettingService.searchDefault(context) ;
        List<SystemExtensionNotifySettingDTO> list = systemExtensionNotifySettingDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建通知设置
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SystemExtensionNotifySetting-Create-all')")
    @ApiOperation(value = "批量新建通知设置", tags = {"通知设置" },  notes = "批量新建通知设置")
	@PostMapping("system_extension_notify_settings/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SystemExtensionNotifySettingDTO> dtos) {
        systemExtensionNotifySettingService.createBatch(systemExtensionNotifySettingDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除通知设置
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SystemExtensionNotifySetting-Remove-all')")
    @ApiOperation(value = "批量删除通知设置", tags = {"通知设置" },  notes = "批量删除通知设置")
	@DeleteMapping("system_extension_notify_settings/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        systemExtensionNotifySettingService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新通知设置
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SystemExtensionNotifySetting-Update-all')")
    @ApiOperation(value = "批量更新通知设置", tags = {"通知设置" },  notes = "批量更新通知设置")
	@PutMapping("system_extension_notify_settings/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SystemExtensionNotifySettingDTO> dtos) {
        systemExtensionNotifySettingService.updateBatch(systemExtensionNotifySettingDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存通知设置
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SystemExtensionNotifySetting-Save-all')")
    @ApiOperation(value = "批量保存通知设置", tags = {"通知设置" },  notes = "批量保存通知设置")
	@PostMapping("system_extension_notify_settings/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SystemExtensionNotifySettingDTO> dtos) {
        systemExtensionNotifySettingService.saveBatch(systemExtensionNotifySettingDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入通知设置
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SystemExtensionNotifySetting-Save-all')")
    @ApiOperation(value = "批量导入通知设置", tags = {"通知设置" },  notes = "批量导入通知设置")
	@PostMapping("system_extension_notify_settings/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SystemExtensionNotifySettingDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(systemExtensionNotifySettingService.importData(config,ignoreError,systemExtensionNotifySettingDtoMapping.toDomain(dtos)));
    }

}
