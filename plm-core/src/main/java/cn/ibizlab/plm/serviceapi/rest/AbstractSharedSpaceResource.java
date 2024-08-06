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
import cn.ibizlab.plm.core.wiki.domain.SharedSpace;
import cn.ibizlab.plm.core.wiki.service.SharedSpaceService;
import cn.ibizlab.plm.core.wiki.filter.SharedSpaceSearchContext;
import reactor.core.publisher.Mono;

/**
 * 实体[SharedSpace] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSharedSpaceResource {

    @Autowired
    public SharedSpaceService sharedSpaceService;

    @Autowired
    @Lazy
    public SharedSpaceDTOMapping sharedSpaceDtoMapping;

    @Autowired
    @Lazy
    public SharedSpaceFilterDTOMapping sharedSpaceFilterDtoMapping;

    /**
    * 创建Create 共享空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"共享空间" },  notes = "SharedSpace-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-Create-all')")
    @PostMapping("shared_spaces")
    public Mono<ResponseEntity<ResponseWrapper<SharedSpaceDTO>>>create
            (@Validated @RequestBody RequestWrapper<SharedSpaceDTO> dto) {
        ResponseWrapper<SharedSpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 共享空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SharedSpaceDTO>
    */   
    public SharedSpaceDTO create
            (SharedSpaceDTO dto) {
        SharedSpace domain = sharedSpaceDtoMapping.toDomain(dto);
        sharedSpaceService.create(domain);
        SharedSpace rt = domain;
        return sharedSpaceDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 共享空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"共享空间" },  notes = "SharedSpace-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-Update-all')")
    @PutMapping("shared_spaces/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SharedSpaceDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SharedSpaceDTO> dto) {
        ResponseWrapper<SharedSpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 共享空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SharedSpaceDTO>
    */   
    public SharedSpaceDTO updateById
            (String id, SharedSpaceDTO dto) {
        SharedSpace domain = sharedSpaceDtoMapping.toDomain(dto);
        domain.setId(id);
        sharedSpaceService.update(domain);
        SharedSpace rt = domain;
        return sharedSpaceDtoMapping.toDto(rt);
    }

    /**
    * check_access_password 共享空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "check_access_password", tags = {"共享空间" },  notes = "SharedSpace-check_access_password ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-check_access_password-all','ibizplm-SharedSpace-Get-all')")
    @PostMapping("shared_spaces/{id}/check_access_password")
    public Mono<ResponseEntity<ResponseWrapper<SharedSpaceDTO>>>checkAccessPasswordById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SharedSpaceDTO> dto) {
        ResponseWrapper<SharedSpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(checkAccessPasswordById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(checkAccessPasswordById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_access_password 共享空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SharedSpaceDTO>
    */   
    public SharedSpaceDTO checkAccessPasswordById
            (String id, SharedSpaceDTO dto) {
        SharedSpace domain = sharedSpaceDtoMapping.toDomain(dto);
        domain.setId(id);
        SharedSpace rt = sharedSpaceService.checkAccessPassword(domain);
        return sharedSpaceDtoMapping.toDto(rt);
    }

    /**
    * closed_shared 共享空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "closed_shared", tags = {"共享空间" },  notes = "SharedSpace-closed_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-closed_shared-all','ibizplm-SharedSpace-Get-all')")
    @PutMapping("shared_spaces/{id}/closed_shared")
    public Mono<ResponseEntity<ResponseWrapper<SharedSpaceDTO>>>closedSharedById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SharedSpaceDTO> dto) {
        ResponseWrapper<SharedSpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(closedSharedById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(closedSharedById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * closed_shared 共享空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SharedSpaceDTO>
    */   
    public SharedSpaceDTO closedSharedById
            (String id, SharedSpaceDTO dto) {
        SharedSpace domain = sharedSpaceDtoMapping.toDomain(dto);
        domain.setId(id);
        SharedSpace rt = sharedSpaceService.closedShared(domain);
        return sharedSpaceDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 共享空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"共享空间" },  notes = "SharedSpace-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-Save-all')")
    @PostMapping("shared_spaces/save")
    public Mono<ResponseEntity<ResponseWrapper<SharedSpaceDTO>>>save
            (@Validated @RequestBody RequestWrapper<SharedSpaceDTO> dto) {
        ResponseWrapper<SharedSpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 共享空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SharedSpaceDTO>
    */   
    public SharedSpaceDTO save
            (SharedSpaceDTO dto) {
        SharedSpace domain = sharedSpaceDtoMapping.toDomain(dto);
        sharedSpaceService.save(domain);
        SharedSpace rt = domain;
        return sharedSpaceDtoMapping.toDto(rt);
    }

    /**
    * shared_setting 共享空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "shared_setting", tags = {"共享空间" },  notes = "SharedSpace-shared_setting ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-shared_setting-all','ibizplm-SharedSpace-Get-all')")
    @PostMapping("shared_spaces/{id}/shared_setting")
    public Mono<ResponseEntity<ResponseWrapper<SharedSpaceDTO>>>sharedSettingById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SharedSpaceDTO> dto) {
        ResponseWrapper<SharedSpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sharedSettingById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sharedSettingById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shared_setting 共享空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SharedSpaceDTO>
    */   
    public SharedSpaceDTO sharedSettingById
            (String id, SharedSpaceDTO dto) {
        SharedSpace domain = sharedSpaceDtoMapping.toDomain(dto);
        domain.setId(id);
        SharedSpace rt = sharedSpaceService.sharedSetting(domain);
        return sharedSpaceDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 共享空间
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"共享空间" },  notes = "SharedSpace-Get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-Get-all')")
    @GetMapping("shared_spaces/{id}")
    public Mono<ResponseEntity<SharedSpaceDTO>> getById
            (@PathVariable("id") String id) {
        SharedSpace rt = sharedSpaceService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sharedSpaceDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 共享空间
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"共享空间" },  notes = "SharedSpace-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-Remove-all')")
    @DeleteMapping("shared_spaces/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = sharedSpaceService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 共享空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"共享空间" },  notes = "SharedSpace-CheckKey ")
    @PostMapping("shared_spaces/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody SharedSpaceDTO dto) {
        SharedSpace domain = sharedSpaceDtoMapping.toDomain(dto);
        CheckKeyStatus rt = sharedSpaceService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_shared 共享空间
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "check_shared", tags = {"共享空间" },  notes = "SharedSpace-check_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-check_shared-all','ibizplm-SharedSpace-Get-all')")
    @GetMapping("shared_spaces/{id}/check_shared")
    public Mono<ResponseEntity<SharedSpaceDTO>> checkSharedById
            (@PathVariable("id") String id) {
        SharedSpace rt = sharedSpaceService.checkShared(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sharedSpaceDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 共享空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"共享空间" },  notes = "SharedSpace-GetDraft ")
    @GetMapping("shared_spaces/get_draft")
    public Mono<ResponseEntity<SharedSpaceDTO>> getDraft
            (@SpringQueryMap SharedSpaceDTO dto) {
        SharedSpace domain = sharedSpaceDtoMapping.toDomain(dto);
        SharedSpace rt = sharedSpaceService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sharedSpaceDtoMapping.toDto(rt)));
    }

    /**
    * shared_space_info 共享空间
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<SharedSpaceDTO>>
    */
    @ApiOperation(value = "shared_space_info", tags = {"共享空间" },  notes = "SharedSpace-shared_space_info ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-shared_space_info-all','ibizplm-SharedSpace-Get-all')")
    @GetMapping("shared_spaces/{id}/shared_space_info")
    public Mono<ResponseEntity<SharedSpaceDTO>> sharedSpaceInfoById
            (@PathVariable("id") String id) {
        SharedSpace rt = sharedSpaceService.sharedSpaceInfo(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sharedSpaceDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_admin 共享空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SharedSpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"共享空间" },  notes = "SharedSpace-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-fetch_admin-all')")
    @PostMapping("shared_spaces/fetch_admin")
    public Mono<ResponseEntity<List<SharedSpaceDTO>>> fetchAdmin
            (@Validated @RequestBody SharedSpaceFilterDTO dto) {
        SharedSpaceSearchContext context = sharedSpaceFilterDtoMapping.toDomain(dto);
        Page<SharedSpace> domains = sharedSpaceService.fetchAdmin(context) ;
        List<SharedSpaceDTO> list = sharedSpaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 共享空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SharedSpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"共享空间" },  notes = "SharedSpace-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-fetch_default-all')")
    @PostMapping("shared_spaces/fetch_default")
    public Mono<ResponseEntity<List<SharedSpaceDTO>>> fetchDefault
            (@Validated @RequestBody SharedSpaceFilterDTO dto) {
        SharedSpaceSearchContext context = sharedSpaceFilterDtoMapping.toDomain(dto);
        Page<SharedSpace> domains = sharedSpaceService.fetchDefault(context) ;
        List<SharedSpaceDTO> list = sharedSpaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared 共享空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SharedSpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared", tags = {"共享空间" },  notes = "SharedSpace-fetch_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SharedSpace-fetch_shared-all')")
    @PostMapping("shared_spaces/fetch_shared")
    public Mono<ResponseEntity<List<SharedSpaceDTO>>> fetchShared
            (@Validated @RequestBody SharedSpaceFilterDTO dto) {
        SharedSpaceSearchContext context = sharedSpaceFilterDtoMapping.toDomain(dto);
        Page<SharedSpace> domains = sharedSpaceService.fetchShared(context) ;
        List<SharedSpaceDTO> list = sharedSpaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建共享空间
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SharedSpace-Create-all')")
    @ApiOperation(value = "批量新建共享空间", tags = {"共享空间" },  notes = "批量新建共享空间")
	@PostMapping("shared_spaces/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<SharedSpaceDTO> dtos) {
        sharedSpaceService.create(sharedSpaceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除共享空间
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SharedSpace-Remove-all')")
    @ApiOperation(value = "批量删除共享空间", tags = {"共享空间" },  notes = "批量删除共享空间")
	@DeleteMapping("shared_spaces/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        sharedSpaceService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新共享空间
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SharedSpace-Update-all')")
    @ApiOperation(value = "批量更新共享空间", tags = {"共享空间" },  notes = "批量更新共享空间")
	@PutMapping("shared_spaces/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<SharedSpaceDTO> dtos) {
        sharedSpaceService.update(sharedSpaceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存共享空间
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SharedSpace-Save-all')")
    @ApiOperation(value = "批量保存共享空间", tags = {"共享空间" },  notes = "批量保存共享空间")
	@PostMapping("shared_spaces/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<SharedSpaceDTO> dtos) {
        sharedSpaceService.save(sharedSpaceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入共享空间
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SharedSpace-Save-all')")
    @ApiOperation(value = "批量导入共享空间", tags = {"共享空间" },  notes = "批量导入共享空间")
	@PostMapping("shared_spaces/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SharedSpaceDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(sharedSpaceService.importData(config,ignoreError,sharedSpaceDtoMapping.toDomain(dtos))));
    }

}
