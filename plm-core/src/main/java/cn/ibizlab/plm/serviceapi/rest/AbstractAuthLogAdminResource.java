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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.serviceapi.dto.*;
import cn.ibizlab.plm.serviceapi.mapping.*;
import cn.ibizlab.plm.core.ebsx.domain.AuthLogAdmin;
import cn.ibizlab.plm.core.ebsx.service.AuthLogAdminService;
import cn.ibizlab.plm.core.ebsx.filter.AuthLogAdminSearchContext;
import reactor.core.publisher.Mono;

/**
 * 实体[AuthLogAdmin] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAuthLogAdminResource {

    @Autowired
    public AuthLogAdminService authLogAdminService;

    @Autowired
    @Lazy
    public AuthLogAdminDTOMapping authLogAdminDtoMapping;

    @Autowired
    @Lazy
    public AuthLogAdminFilterDTOMapping authLogAdminFilterDtoMapping;

    /**
    * 创建Create 认证日志
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AuthLogAdminDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"认证日志" },  notes = "AuthLogAdmin-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AuthLogAdmin-Create-all')")
    @PostMapping("auth_log_admins")
    public Mono<ResponseEntity<ResponseWrapper<AuthLogAdminDTO>>>create
            (@Validated @RequestBody RequestWrapper<AuthLogAdminDTO> dto) {
        ResponseWrapper<AuthLogAdminDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 认证日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AuthLogAdminDTO>
    */   
    public AuthLogAdminDTO create
            (AuthLogAdminDTO dto) {
        AuthLogAdmin domain = authLogAdminDtoMapping.toDomain(dto);
        authLogAdminService.create(domain);
        AuthLogAdmin rt = domain;
        return authLogAdminDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 认证日志
    * 
    *
    * @param logId logId
    * @param dto dto
    * @return Mono<ResponseEntity<AuthLogAdminDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"认证日志" },  notes = "AuthLogAdmin-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AuthLogAdmin-Update-all')")
    @PutMapping("auth_log_admins/{logId}")
    public Mono<ResponseEntity<ResponseWrapper<AuthLogAdminDTO>>>updateByLogId
            (@PathVariable("logId") String logId, @Validated @RequestBody RequestWrapper<AuthLogAdminDTO> dto) {
        ResponseWrapper<AuthLogAdminDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = logId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLogId(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLogId(logId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 认证日志
    * 
    *
    * @param logId logId
    * @param dto dto
    * @return ResponseEntity<AuthLogAdminDTO>
    */   
    public AuthLogAdminDTO updateByLogId
            (String logId, AuthLogAdminDTO dto) {
        AuthLogAdmin domain = authLogAdminDtoMapping.toDomain(dto);
        domain.setLogId(logId);
        authLogAdminService.update(domain);
        AuthLogAdmin rt = domain;
        return authLogAdminDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 认证日志
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AuthLogAdminDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"认证日志" },  notes = "AuthLogAdmin-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AuthLogAdmin-Save-all')")
    @PostMapping("auth_log_admins/save")
    public Mono<ResponseEntity<ResponseWrapper<AuthLogAdminDTO>>>save
            (@Validated @RequestBody RequestWrapper<AuthLogAdminDTO> dto) {
        ResponseWrapper<AuthLogAdminDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 认证日志
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AuthLogAdminDTO>
    */   
    public AuthLogAdminDTO save
            (AuthLogAdminDTO dto) {
        AuthLogAdmin domain = authLogAdminDtoMapping.toDomain(dto);
        authLogAdminService.save(domain);
        AuthLogAdmin rt = domain;
        return authLogAdminDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 认证日志
    * 
    *
    * @param logId logId
    * @return Mono<ResponseEntity<AuthLogAdminDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"认证日志" },  notes = "AuthLogAdmin-Get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AuthLogAdmin-Get-all')")
    @GetMapping("auth_log_admins/{logId}")
    public Mono<ResponseEntity<AuthLogAdminDTO>> getByLogId
            (@PathVariable("logId") String logId) {
        AuthLogAdmin rt = authLogAdminService.get(logId);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(authLogAdminDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 认证日志
    * 
    *
    * @param logId logId
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"认证日志" },  notes = "AuthLogAdmin-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AuthLogAdmin-Remove-all')")
    @DeleteMapping("auth_log_admins/{logId}")
    public Mono<ResponseEntity<Boolean>> removeByLogId
            (@PathVariable("logId") String logId) {
        Boolean rt = authLogAdminService.remove(logId);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 认证日志
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"认证日志" },  notes = "AuthLogAdmin-CheckKey ")
    @PostMapping("auth_log_admins/checkkey")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody AuthLogAdminDTO dto) {
        AuthLogAdmin domain = authLogAdminDtoMapping.toDomain(dto);
        CheckKeyStatus rt = authLogAdminService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 认证日志
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AuthLogAdminDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"认证日志" },  notes = "AuthLogAdmin-GetDraft ")
    @GetMapping("auth_log_admins/getdraft")
    public Mono<ResponseEntity<AuthLogAdminDTO>> getDraft
            (@SpringQueryMap AuthLogAdminDTO dto) {
        AuthLogAdmin domain = authLogAdminDtoMapping.toDomain(dto);
        AuthLogAdmin rt = authLogAdminService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(authLogAdminDtoMapping.toDto(rt)));
    }

    /**
    * 查询FetchDefault 认证日志
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AuthLogAdminDTO>>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"认证日志" },  notes = "AuthLogAdmin-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AuthLogAdmin-FetchDefault-all')")
    @PostMapping("auth_log_admins/fetchdefault")
    public Mono<ResponseEntity<List<AuthLogAdminDTO>>> fetchDefault
            (@Validated @RequestBody AuthLogAdminFilterDTO dto) {
        AuthLogAdminSearchContext context = authLogAdminFilterDtoMapping.toDomain(dto);
        Page<AuthLogAdmin> domains = authLogAdminService.fetchDefault(context) ;
        List<AuthLogAdminDTO> list = authLogAdminDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询FetchDistinct_userid 认证日志
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AuthLogAdminDTO>>>
    */
    @ApiOperation(value = "查询FetchDistinct_userid", tags = {"认证日志" },  notes = "AuthLogAdmin-FetchDistinct_userid ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AuthLogAdmin-FetchDistinct_userid-all')")
    @PostMapping("auth_log_admins/fetchdistinct_userid")
    public Mono<ResponseEntity<List<AuthLogAdminDTO>>> fetchDistinctUserid
            (@Validated @RequestBody AuthLogAdminFilterDTO dto) {
        AuthLogAdminSearchContext context = authLogAdminFilterDtoMapping.toDomain(dto);
        Page<AuthLogAdmin> domains = authLogAdminService.fetchDistinctUserid(context) ;
        List<AuthLogAdminDTO> list = authLogAdminDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询FetchGroup_by_data 认证日志
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AuthLogAdminDTO>>>
    */
    @ApiOperation(value = "查询FetchGroup_by_data", tags = {"认证日志" },  notes = "AuthLogAdmin-FetchGroup_by_data ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AuthLogAdmin-FetchGroup_by_data-all')")
    @PostMapping("auth_log_admins/fetchgroup_by_data")
    public Mono<ResponseEntity<List<AuthLogAdminDTO>>> fetchGroupByData
            (@Validated @RequestBody AuthLogAdminFilterDTO dto) {
        AuthLogAdminSearchContext context = authLogAdminFilterDtoMapping.toDomain(dto);
        Page<AuthLogAdmin> domains = authLogAdminService.fetchGroupByData(context) ;
        List<AuthLogAdminDTO> list = authLogAdminDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建认证日志
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AuthLogAdmin-Create-all')")
    @ApiOperation(value = "批量新建认证日志", tags = {"认证日志" },  notes = "批量新建认证日志")
	@PostMapping("auth_log_admins/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<AuthLogAdminDTO> dtos) {
        authLogAdminService.create(authLogAdminDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除认证日志
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AuthLogAdmin-Remove-all')")
    @ApiOperation(value = "批量删除认证日志", tags = {"认证日志" },  notes = "批量删除认证日志")
	@DeleteMapping("auth_log_admins/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        authLogAdminService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新认证日志
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AuthLogAdmin-Update-all')")
    @ApiOperation(value = "批量更新认证日志", tags = {"认证日志" },  notes = "批量更新认证日志")
	@PutMapping("auth_log_admins/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<AuthLogAdminDTO> dtos) {
        authLogAdminService.update(authLogAdminDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存认证日志
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AuthLogAdmin-Save-all')")
    @ApiOperation(value = "批量保存认证日志", tags = {"认证日志" },  notes = "批量保存认证日志")
	@PostMapping("auth_log_admins/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<AuthLogAdminDTO> dtos) {
        authLogAdminService.save(authLogAdminDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入认证日志
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AuthLogAdmin-Save-all')")
    @ApiOperation(value = "批量导入认证日志", tags = {"认证日志" },  notes = "批量导入认证日志")
	@PostMapping("auth_log_admins/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<AuthLogAdminDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(authLogAdminService.importData(config,ignoreError,authLogAdminDtoMapping.toDomain(dtos))));
    }

}
