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
import cn.ibizlab.plm.core.base.domain.ExtendLog;
import cn.ibizlab.plm.core.base.service.ExtendLogService;
import cn.ibizlab.plm.core.base.filter.ExtendLogSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[ExtendLog] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractExtendLogResource {

    @Autowired
    public ExtendLogService extendLogService;

    @Autowired
    @Lazy
    public ExtendLogDTOMapping extendLogDtoMapping;

    @Autowired
    @Lazy
    public ExtendLogFilterDTOMapping extendLogFilterDtoMapping;

    /**
    * 创建Create 扩展日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ExtendLogDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"扩展日志" },  notes = "ExtendLog-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ExtendLog-Create-all') or hasPermission(this.extendLogDtoMapping.toDomain(#dto),'ibizplm-ExtendLog-Create')")
    @PostMapping("extend_logs")
    public ResponseEntity<ResponseWrapper<ExtendLogDTO>> create
            (@Validated @RequestBody RequestWrapper<ExtendLogDTO> dto) {
        ResponseWrapper<ExtendLogDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 扩展日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ExtendLogDTO>
    */   
    public ExtendLogDTO create
            (ExtendLogDTO dto) {
        ExtendLog domain = extendLogDtoMapping.toDomain(dto);
        extendLogService.create(domain);
        ExtendLog rt = domain;
        return extendLogDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 扩展日志
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ExtendLogDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"扩展日志" },  notes = "ExtendLog-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ExtendLog-Update-all') or hasPermission(this.extendLogService.get(#id),'ibizplm-ExtendLog-Update')")
    @VersionCheck(entity = "extendlog" , versionfield = "updateTime")
    @PutMapping("extend_logs/{id}")
    public ResponseEntity<ResponseWrapper<ExtendLogDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ExtendLogDTO> dto) {
        ResponseWrapper<ExtendLogDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 扩展日志
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ExtendLogDTO>
    */   
    public ExtendLogDTO updateById
            (String id, ExtendLogDTO dto) {
        ExtendLog domain = extendLogDtoMapping.toDomain(dto);
        domain.setId(id);
        extendLogService.update(domain);
        ExtendLog rt = domain;
        return extendLogDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 扩展日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ExtendLogDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"扩展日志" },  notes = "ExtendLog-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ExtendLog-Save-all') or hasPermission(this.extendLogDtoMapping.toDomain(#dto),'ibizplm-ExtendLog-Save')")
    @PostMapping("extend_logs/save")
    public ResponseEntity<ResponseWrapper<ExtendLogDTO>> save
            (@Validated @RequestBody RequestWrapper<ExtendLogDTO> dto) {
        ResponseWrapper<ExtendLogDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 扩展日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ExtendLogDTO>
    */   
    public ExtendLogDTO save
            (ExtendLogDTO dto) {
        ExtendLog domain = extendLogDtoMapping.toDomain(dto);
        extendLogService.save(domain);
        ExtendLog rt = domain;
        return extendLogDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 扩展日志
    * 
    *
    * @param id id
    * @return ResponseEntity<ExtendLogDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"扩展日志" },  notes = "ExtendLog-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ExtendLog-Get-all')  or hasPermission(this.extendLogDtoMapping.toDomain(returnObject.body),'ibizplm-ExtendLog-Get')")
    @GetMapping("extend_logs/{id}")
    public ResponseEntity<ExtendLogDTO> getById
            (@PathVariable("id") String id) {
        ExtendLog rt = extendLogService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(extendLogDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 扩展日志
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"扩展日志" },  notes = "ExtendLog-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ExtendLog-Remove-all') or hasPermission(this.extendLogService.get(#id),'ibizplm-ExtendLog-Remove')")
    @DeleteMapping("extend_logs/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = extendLogService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 扩展日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"扩展日志" },  notes = "ExtendLog-CheckKey ")
    @PostMapping("extend_logs/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ExtendLogDTO dto) {
        ExtendLog domain = extendLogDtoMapping.toDomain(dto);
        Integer rt = extendLogService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 扩展日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ExtendLogDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"扩展日志" },  notes = "ExtendLog-GetDraft ")
    @GetMapping("extend_logs/get_draft")
    public ResponseEntity<ExtendLogDTO> getDraft
            (@SpringQueryMap ExtendLogDTO dto) {
        ExtendLog domain = extendLogDtoMapping.toDomain(dto);
        ExtendLog rt = extendLogService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(extendLogDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 扩展日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ExtendLogDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"扩展日志" },  notes = "ExtendLog-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ExtendLog-fetch_default-all') or hasPermission(#dto,'ibizplm-ExtendLog-fetch_default')")
    @PostMapping("extend_logs/fetch_default")
    public ResponseEntity<List<ExtendLogDTO>> fetchDefault
            (@Validated @RequestBody ExtendLogFilterDTO dto) {
        ExtendLogSearchContext context = extendLogFilterDtoMapping.toDomain(dto);
        Page<ExtendLog> domains = extendLogService.searchDefault(context) ;
        List<ExtendLogDTO> list = extendLogDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_execution_statistics 扩展日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ExtendLogDTO>>
    */
    @ApiOperation(value = "查询fetch_execution_statistics", tags = {"扩展日志" },  notes = "ExtendLog-fetch_execution_statistics ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ExtendLog-fetch_execution_statistics-all') or hasPermission(#dto,'ibizplm-ExtendLog-fetch_execution_statistics')")
    @PostMapping("extend_logs/fetch_execution_statistics")
    public ResponseEntity<List<ExtendLogDTO>> fetchExecutionStatistics
            (@Validated @RequestBody ExtendLogFilterDTO dto) {
        ExtendLogSearchContext context = extendLogFilterDtoMapping.toDomain(dto);
        Page<ExtendLog> domains = extendLogService.searchExecutionStatistics(context) ;
        List<ExtendLogDTO> list = extendLogDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建扩展日志
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ExtendLog-Create-all')")
    @ApiOperation(value = "批量新建扩展日志", tags = {"扩展日志" },  notes = "批量新建扩展日志")
	@PostMapping("extend_logs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ExtendLogDTO> dtos) {
        extendLogService.createBatch(extendLogDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除扩展日志
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ExtendLog-Remove-all')")
    @ApiOperation(value = "批量删除扩展日志", tags = {"扩展日志" },  notes = "批量删除扩展日志")
	@DeleteMapping("extend_logs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        extendLogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新扩展日志
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ExtendLog-Update-all')")
    @ApiOperation(value = "批量更新扩展日志", tags = {"扩展日志" },  notes = "批量更新扩展日志")
	@PutMapping("extend_logs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ExtendLogDTO> dtos) {
        extendLogService.updateBatch(extendLogDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存扩展日志
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ExtendLog-Save-all')")
    @ApiOperation(value = "批量保存扩展日志", tags = {"扩展日志" },  notes = "批量保存扩展日志")
	@PostMapping("extend_logs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ExtendLogDTO> dtos) {
        extendLogService.saveBatch(extendLogDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入扩展日志
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ExtendLog-Save-all')")
    @ApiOperation(value = "批量导入扩展日志", tags = {"扩展日志" },  notes = "批量导入扩展日志")
	@PostMapping("extend_logs/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ExtendLogDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(extendLogService.importData(config,ignoreError,extendLogDtoMapping.toDomain(dtos)));
    }

}
