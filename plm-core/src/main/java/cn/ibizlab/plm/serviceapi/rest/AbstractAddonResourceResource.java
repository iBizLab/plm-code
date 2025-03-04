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
import cn.ibizlab.plm.core.base.domain.AddonResource;
import cn.ibizlab.plm.core.base.service.AddonResourceService;
import cn.ibizlab.plm.core.base.filter.AddonResourceSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[AddonResource] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAddonResourceResource {

    @Autowired
    public AddonResourceService addonResourceService;

    @Autowired
    @Lazy
    public AddonResourceDTOMapping addonResourceDtoMapping;

    @Autowired
    @Lazy
    public AddonResourceFilterDTOMapping addonResourceFilterDtoMapping;

    /**
    * 创建Create 资源组件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"资源组件" },  notes = "AddonResource-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Create-all') or hasPermission(this.addonResourceDtoMapping.toDomain(#dto),'ibizplm-AddonResource-Create')")
    @PostMapping("addon_resources")
    public Mono<ResponseEntity<ResponseWrapper<AddonResourceDTO>>>create
            (@Validated @RequestBody RequestWrapper<AddonResourceDTO> dto) {
        ResponseWrapper<AddonResourceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 资源组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonResourceDTO>
    */   
    public AddonResourceDTO create
            (AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        addonResourceService.create(domain);
        AddonResource rt = domain;
        return addonResourceDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 资源组件
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"资源组件" },  notes = "AddonResource-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Update-all') or hasPermission(this.addonResourceService.get(#id),'ibizplm-AddonResource-Update')")
    @VersionCheck(entity = "addonresource" , versionfield = "updateTime")
    @PutMapping("addon_resources/{id}")
    public Mono<ResponseEntity<ResponseWrapper<AddonResourceDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonResourceDTO> dto) {
        ResponseWrapper<AddonResourceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 资源组件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonResourceDTO>
    */   
    public AddonResourceDTO updateById
            (String id, AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        domain.setId(id);
        addonResourceService.update(domain);
        AddonResource rt = domain;
        return addonResourceDtoMapping.toDto(rt);
    }

    /**
    * check_resource_is_deleted 资源组件
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "check_resource_is_deleted", tags = {"资源组件" },  notes = "AddonResource-check_resource_is_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-check_resource_is_deleted-all') or hasPermission(this.addonResourceDtoMapping.toDomain(#dto),'ibizplm-AddonResource-check_resource_is_deleted')")
    @PostMapping("addon_resources/{id}/check_resource_is_deleted")
    public Mono<ResponseEntity<ResponseWrapper<AddonResourceDTO>>>checkResourceIsDeletedById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonResourceDTO> dto) {
        ResponseWrapper<AddonResourceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(checkResourceIsDeletedById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(checkResourceIsDeletedById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_resource_is_deleted 资源组件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonResourceDTO>
    */   
    public AddonResourceDTO checkResourceIsDeletedById
            (String id, AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        domain.setId(id);
        AddonResource rt = addonResourceService.checkResourceIsDeleted(domain);
        return addonResourceDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 资源组件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"资源组件" },  notes = "AddonResource-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Save-all') or hasPermission(this.addonResourceDtoMapping.toDomain(#dto),'ibizplm-AddonResource-Save')")
    @PostMapping("addon_resources/save")
    public Mono<ResponseEntity<ResponseWrapper<AddonResourceDTO>>>save
            (@Validated @RequestBody RequestWrapper<AddonResourceDTO> dto) {
        ResponseWrapper<AddonResourceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 资源组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonResourceDTO>
    */   
    public AddonResourceDTO save
            (AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        addonResourceService.save(domain);
        AddonResource rt = domain;
        return addonResourceDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"资源组件" },  notes = "AddonResource-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Create-all') or hasPermission('project',#ownerId,this.addonResourceDtoMapping.toDomain(#dto),'ibizplm-AddonResource-Create')")
    @PostMapping("projects/{ownerId}/addon_resources")
    public Mono<ResponseEntity<ResponseWrapper<AddonResourceDTO>>>createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<AddonResourceDTO> dto) {
        ResponseWrapper<AddonResourceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<AddonResourceDTO>
    */   
    public AddonResourceDTO createByOwnerId
            (String ownerId, AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        addonResourceService.create(domain);
        AddonResource rt = domain;
        return addonResourceDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"资源组件" },  notes = "AddonResource-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Update-all') or hasPermission('project',#ownerId,this.addonResourceService.get(#id),'ibizplm-AddonResource-Update')")
    @VersionCheck(entity = "addonresource" , versionfield = "updateTime")
    @PutMapping("projects/{ownerId}/addon_resources/{id}")
    public Mono<ResponseEntity<ResponseWrapper<AddonResourceDTO>>>updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonResourceDTO> dto) {
        ResponseWrapper<AddonResourceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonResourceDTO>
    */   
    public AddonResourceDTO updateByOwnerIdAndId
            (String ownerId, String id, AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        domain.setId(id);
        addonResourceService.update(domain);
        AddonResource rt = domain;
        return addonResourceDtoMapping.toDto(rt);
    }

    /**
    * check_resource_is_deleted 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "check_resource_is_deleted", tags = {"资源组件" },  notes = "AddonResource-check_resource_is_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-check_resource_is_deleted-all') or hasPermission('project',#ownerId,this.addonResourceDtoMapping.toDomain(#dto),'ibizplm-AddonResource-check_resource_is_deleted')")
    @PostMapping("projects/{ownerId}/addon_resources/{id}/check_resource_is_deleted")
    public Mono<ResponseEntity<ResponseWrapper<AddonResourceDTO>>>checkResourceIsDeletedByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonResourceDTO> dto) {
        ResponseWrapper<AddonResourceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(checkResourceIsDeletedByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(checkResourceIsDeletedByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_resource_is_deleted 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonResourceDTO>
    */   
    public AddonResourceDTO checkResourceIsDeletedByOwnerIdAndId
            (String ownerId, String id, AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        domain.setId(id);
        AddonResource rt = addonResourceService.checkResourceIsDeleted(domain);
        return addonResourceDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"资源组件" },  notes = "AddonResource-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Save-all') or hasPermission('project',#ownerId,this.addonResourceDtoMapping.toDomain(#dto),'ibizplm-AddonResource-Save')")
    @PostMapping("projects/{ownerId}/addon_resources/save")
    public Mono<ResponseEntity<ResponseWrapper<AddonResourceDTO>>>saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<AddonResourceDTO> dto) {
        ResponseWrapper<AddonResourceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<AddonResourceDTO>
    */   
    public AddonResourceDTO saveByOwnerId
            (String ownerId, AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        addonResourceService.save(domain);
        AddonResource rt = domain;
        return addonResourceDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 资源组件
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"资源组件" },  notes = "AddonResource-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Get-all')  or hasPermission(this.addonResourceDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-AddonResource-Get')")
    @GetMapping("addon_resources/{id}")
    public Mono<ResponseEntity<AddonResourceDTO>> getById
            (@PathVariable("id") String id) {
        AddonResource rt = addonResourceService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(addonResourceDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 资源组件
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"资源组件" },  notes = "AddonResource-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Remove-all') or hasPermission(this.addonResourceService.get(#id),'ibizplm-AddonResource-Remove')")
    @DeleteMapping("addon_resources/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = addonResourceService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 资源组件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"资源组件" },  notes = "AddonResource-CheckKey ")
    @PostMapping("addon_resources/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        CheckKeyStatus rt = addonResourceService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 资源组件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"资源组件" },  notes = "AddonResource-GetDraft ")
    @GetMapping("addon_resources/get_draft")
    public Mono<ResponseEntity<AddonResourceDTO>> getDraft
            (@SpringQueryMap AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        AddonResource rt = addonResourceService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(addonResourceDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 资源组件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AddonResourceDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"资源组件" },  notes = "AddonResource-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-fetch_all-all') or hasPermission(#dto,'ibizplm-AddonResource-fetch_all')")
    @PostMapping("addon_resources/fetch_all")
    public Mono<ResponseEntity<List<AddonResourceDTO>>> fetchAll
            (@Validated @RequestBody AddonResourceFilterDTO dto) {
        AddonResourceSearchContext context = addonResourceFilterDtoMapping.toDomain(dto);
        Page<AddonResource> domains = addonResourceService.fetchAll(context) ;
        List<AddonResourceDTO> list = addonResourceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 资源组件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AddonResourceDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"资源组件" },  notes = "AddonResource-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-fetch_default-all') or hasPermission(#dto,'ibizplm-AddonResource-fetch_default')")
    @PostMapping("addon_resources/fetch_default")
    public Mono<ResponseEntity<List<AddonResourceDTO>>> fetchDefault
            (@Validated @RequestBody AddonResourceFilterDTO dto) {
        AddonResourceSearchContext context = addonResourceFilterDtoMapping.toDomain(dto);
        Page<AddonResource> domains = addonResourceService.fetchDefault(context) ;
        List<AddonResourceDTO> list = addonResourceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"资源组件" },  notes = "AddonResource-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Get-all')  or hasPermission('project',#ownerId,this.addonResourceDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-AddonResource-Get')")
    @GetMapping("projects/{ownerId}/addon_resources/{id}")
    public Mono<ResponseEntity<AddonResourceDTO>> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        AddonResource rt = addonResourceService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(addonResourceDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"资源组件" },  notes = "AddonResource-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-Remove-all') or hasPermission('project',#ownerId,this.addonResourceService.get(#id),'ibizplm-AddonResource-Remove')")
    @DeleteMapping("projects/{ownerId}/addon_resources/{id}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = addonResourceService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"资源组件" },  notes = "AddonResource-CheckKey ")
    @PostMapping("projects/{ownerId}/addon_resources/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = addonResourceService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<AddonResourceDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"资源组件" },  notes = "AddonResource-GetDraft ")
    @GetMapping("projects/{ownerId}/addon_resources/get_draft")
    public Mono<ResponseEntity<AddonResourceDTO>> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap AddonResourceDTO dto) {
        AddonResource domain = addonResourceDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        AddonResource rt = addonResourceService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(addonResourceDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<AddonResourceDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"资源组件" },  notes = "AddonResource-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-fetch_all-all') or hasPermission('project',#ownerId,#dto,'ibizplm-AddonResource-fetch_all')")
    @PostMapping("projects/{ownerId}/addon_resources/fetch_all")
    public Mono<ResponseEntity<List<AddonResourceDTO>>> fetchAllByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody AddonResourceFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        AddonResourceSearchContext context = addonResourceFilterDtoMapping.toDomain(dto);
        Page<AddonResource> domains = addonResourceService.fetchAll(context) ;
        List<AddonResourceDTO> list = addonResourceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 资源组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<AddonResourceDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"资源组件" },  notes = "AddonResource-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonResource-fetch_default-all') or hasPermission('project',#ownerId,#dto,'ibizplm-AddonResource-fetch_default')")
    @PostMapping("projects/{ownerId}/addon_resources/fetch_default")
    public Mono<ResponseEntity<List<AddonResourceDTO>>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody AddonResourceFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        AddonResourceSearchContext context = addonResourceFilterDtoMapping.toDomain(dto);
        Page<AddonResource> domains = addonResourceService.fetchDefault(context) ;
        List<AddonResourceDTO> list = addonResourceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建资源组件
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonResource-Create-all')")
    @ApiOperation(value = "批量新建资源组件", tags = {"资源组件" },  notes = "批量新建资源组件")
	@PostMapping("addon_resources/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<AddonResourceDTO> dtos) {
        addonResourceService.create(addonResourceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除资源组件
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonResource-Remove-all')")
    @ApiOperation(value = "批量删除资源组件", tags = {"资源组件" },  notes = "批量删除资源组件")
	@DeleteMapping("addon_resources/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        addonResourceService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新资源组件
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonResource-Update-all')")
    @ApiOperation(value = "批量更新资源组件", tags = {"资源组件" },  notes = "批量更新资源组件")
	@PutMapping("addon_resources/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<AddonResourceDTO> dtos) {
        addonResourceService.update(addonResourceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存资源组件
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonResource-Save-all')")
    @ApiOperation(value = "批量保存资源组件", tags = {"资源组件" },  notes = "批量保存资源组件")
	@PostMapping("addon_resources/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<AddonResourceDTO> dtos) {
        addonResourceService.save(addonResourceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入资源组件
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonResource-Save-all')")
    @ApiOperation(value = "批量导入资源组件", tags = {"资源组件" },  notes = "批量导入资源组件")
	@PostMapping("addon_resources/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<AddonResourceDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(addonResourceService.importData(config,ignoreError,addonResourceDtoMapping.toDomain(dtos))));
    }

}
