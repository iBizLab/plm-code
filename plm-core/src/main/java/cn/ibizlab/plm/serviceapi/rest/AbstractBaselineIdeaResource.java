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
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.prodmgmt.service.BaselineIdeaService;
import cn.ibizlab.plm.core.prodmgmt.filter.BaselineIdeaSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[BaselineIdea] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineIdeaResource {

    @Autowired
    public BaselineIdeaService baselineIdeaService;

    @Autowired
    @Lazy
    public BaselineIdeaDTOMapping baselineIdeaDtoMapping;

    @Autowired
    @Lazy
    public BaselineIdeaFilterDTOMapping baselineIdeaFilterDtoMapping;

    /**
    * 创建Create 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"基线需求" },  notes = "BaselineIdea-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Create-all') or hasPermission(this.baselineIdeaDtoMapping.toDomain(#dto),'ibizplm-BaselineIdea-Create')")
    @PostMapping("baseline_ideas")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>create
            (@Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 基线需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO create
            (BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        baselineIdeaService.create(domain);
        BaselineIdea rt = domain;
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 基线需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"基线需求" },  notes = "BaselineIdea-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Update-all') or hasPermission(this.baselineIdeaService.get(#id),'ibizplm-BaselineIdea-Update')")
    @VersionCheck(entity = "baselineidea" , versionfield = "updateTime")
    @PutMapping("baseline_ideas/{id}")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 基线需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO updateById
            (String id, BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        domain.setId(id);
        baselineIdeaService.update(domain);
        BaselineIdea rt = domain;
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"基线需求" },  notes = "BaselineIdea-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Save-all') or hasPermission(this.baselineIdeaDtoMapping.toDomain(#dto),'ibizplm-BaselineIdea-Save')")
    @PostMapping("baseline_ideas/save")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>save
            (@Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 基线需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO save
            (BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        baselineIdeaService.save(domain);
        BaselineIdea rt = domain;
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * shift_in_baseline 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "shift_in_baseline", tags = {"基线需求" },  notes = "BaselineIdea-shift_in_baseline ")
    @PostMapping("baseline_ideas/shift_in_baseline")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>shiftInBaseline
            (@Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftInBaseline(item)));
        else
            rt.set(shiftInBaseline(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_baseline 基线需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO shiftInBaseline
            (BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        BaselineIdea rt = baselineIdeaService.shiftInBaseline(domain);
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * shift_out_baseline 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "shift_out_baseline", tags = {"基线需求" },  notes = "BaselineIdea-shift_out_baseline ")
    @PostMapping("baseline_ideas/shift_out_baseline")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>shiftOutBaseline
            (@Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftOutBaseline(item)));
        else
            rt.set(shiftOutBaseline(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_baseline 基线需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO shiftOutBaseline
            (BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        BaselineIdea rt = baselineIdeaService.shiftOutBaseline(domain);
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"基线需求" },  notes = "BaselineIdea-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Create-all') or hasPermission('library',#ownerId,this.baselineIdeaDtoMapping.toDomain(#dto),'ibizplm-BaselineIdea-Create')")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>createByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerIdAndPrincipalId(ownerId, principalId, item)));
        else
            rt.set(createByOwnerIdAndPrincipalId(ownerId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO createByOwnerIdAndPrincipalId
            (String ownerId, String principalId, BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        baselineIdeaService.create(domain);
        BaselineIdea rt = domain;
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"基线需求" },  notes = "BaselineIdea-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Update-all') or hasPermission('library',#ownerId,this.baselineIdeaService.get(#id),'ibizplm-BaselineIdea-Update')")
    @VersionCheck(entity = "baselineidea" , versionfield = "updateTime")
    @PutMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/{id}")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>updateByOwnerIdAndPrincipalIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndPrincipalIdAndId(ownerId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndPrincipalIdAndId(ownerId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO updateByOwnerIdAndPrincipalIdAndId
            (String ownerId, String principalId, String id, BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        domain.setId(id);
        baselineIdeaService.update(domain);
        BaselineIdea rt = domain;
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"基线需求" },  notes = "BaselineIdea-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Save-all') or hasPermission('library',#ownerId,this.baselineIdeaDtoMapping.toDomain(#dto),'ibizplm-BaselineIdea-Save')")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/save")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>saveByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerIdAndPrincipalId(ownerId, principalId, item)));
        else
            rt.set(saveByOwnerIdAndPrincipalId(ownerId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO saveByOwnerIdAndPrincipalId
            (String ownerId, String principalId, BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        baselineIdeaService.save(domain);
        BaselineIdea rt = domain;
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * shift_in_baseline 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "shift_in_baseline", tags = {"基线需求" },  notes = "BaselineIdea-shift_in_baseline ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/shift_in_baseline")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>shiftInBaselineByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftInBaselineByOwnerIdAndPrincipalId(ownerId, principalId, item)));
        else
            rt.set(shiftInBaselineByOwnerIdAndPrincipalId(ownerId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_baseline 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO shiftInBaselineByOwnerIdAndPrincipalId
            (String ownerId, String principalId, BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        BaselineIdea rt = baselineIdeaService.shiftInBaseline(domain);
        return baselineIdeaDtoMapping.toDto(rt);
    }

    /**
    * shift_out_baseline 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "shift_out_baseline", tags = {"基线需求" },  notes = "BaselineIdea-shift_out_baseline ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/shift_out_baseline")
    public Mono<ResponseEntity<ResponseWrapper<BaselineIdeaDTO>>>shiftOutBaselineByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<BaselineIdeaDTO> dto) {
        ResponseWrapper<BaselineIdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftOutBaselineByOwnerIdAndPrincipalId(ownerId, principalId, item)));
        else
            rt.set(shiftOutBaselineByOwnerIdAndPrincipalId(ownerId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_baseline 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselineIdeaDTO>
    */   
    public BaselineIdeaDTO shiftOutBaselineByOwnerIdAndPrincipalId
            (String ownerId, String principalId, BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        BaselineIdea rt = baselineIdeaService.shiftOutBaseline(domain);
        return baselineIdeaDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 基线需求
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"基线需求" },  notes = "BaselineIdea-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Get-all')  or hasPermission(this.baselineIdeaDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-BaselineIdea-Get')")
    @GetMapping("baseline_ideas/{id}")
    public Mono<ResponseEntity<BaselineIdeaDTO>> getById
            (@PathVariable("id") String id) {
        BaselineIdea rt = baselineIdeaService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(baselineIdeaDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 基线需求
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"基线需求" },  notes = "BaselineIdea-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Remove-all') or hasPermission(this.baselineIdeaService.get(#id),'ibizplm-BaselineIdea-Remove')")
    @DeleteMapping("baseline_ideas/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = baselineIdeaService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"基线需求" },  notes = "BaselineIdea-CheckKey ")
    @PostMapping("baseline_ideas/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        CheckKeyStatus rt = baselineIdeaService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"基线需求" },  notes = "BaselineIdea-GetDraft ")
    @GetMapping("baseline_ideas/get_draft")
    public Mono<ResponseEntity<BaselineIdeaDTO>> getDraft
            (@SpringQueryMap BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        BaselineIdea rt = baselineIdeaService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(baselineIdeaDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_baseline_relation_version 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineIdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_relation_version", tags = {"基线需求" },  notes = "BaselineIdea-fetch_baseline_relation_version ")
    @PostMapping("baseline_ideas/fetch_baseline_relation_version")
    public Mono<ResponseEntity<List<BaselineIdeaDTO>>> fetchBaselineRelationVersion
            (@Validated @RequestBody BaselineIdeaFilterDTO dto) {
        BaselineIdeaSearchContext context = baselineIdeaFilterDtoMapping.toDomain(dto);
        Page<BaselineIdea> domains = baselineIdeaService.fetchBaselineRelationVersion(context) ;
        List<BaselineIdeaDTO> list = baselineIdeaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineIdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"基线需求" },  notes = "BaselineIdea-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-fetch_default-all') or hasPermission(#dto,'ibizplm-BaselineIdea-fetch_default')")
    @PostMapping("baseline_ideas/fetch_default")
    public Mono<ResponseEntity<List<BaselineIdeaDTO>>> fetchDefault
            (@Validated @RequestBody BaselineIdeaFilterDTO dto) {
        BaselineIdeaSearchContext context = baselineIdeaFilterDtoMapping.toDomain(dto);
        Page<BaselineIdea> domains = baselineIdeaService.fetchDefault(context) ;
        List<BaselineIdeaDTO> list = baselineIdeaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_fill_version_data 基线需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineIdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_fill_version_data", tags = {"基线需求" },  notes = "BaselineIdea-fetch_fill_version_data ")
    @PostMapping("baseline_ideas/fetch_fill_version_data")
    public Mono<ResponseEntity<List<BaselineIdeaDTO>>> fetchFillVersionData
            (@Validated @RequestBody BaselineIdeaFilterDTO dto) {
        BaselineIdeaSearchContext context = baselineIdeaFilterDtoMapping.toDomain(dto);
        Page<BaselineIdea> domains = baselineIdeaService.fetchFillVersionData(context) ;
        List<BaselineIdeaDTO> list = baselineIdeaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"基线需求" },  notes = "BaselineIdea-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Get-all')  or hasPermission('library',#ownerId,this.baselineIdeaDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-BaselineIdea-Get')")
    @GetMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/{id}")
    public Mono<ResponseEntity<BaselineIdeaDTO>> getByOwnerIdAndPrincipalIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        BaselineIdea rt = baselineIdeaService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(baselineIdeaDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"基线需求" },  notes = "BaselineIdea-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-Remove-all') or hasPermission('library',#ownerId,this.baselineIdeaService.get(#id),'ibizplm-BaselineIdea-Remove')")
    @DeleteMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/{id}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndPrincipalIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = baselineIdeaService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"基线需求" },  notes = "BaselineIdea-CheckKey ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = baselineIdeaService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineIdeaDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"基线需求" },  notes = "BaselineIdea-GetDraft ")
    @GetMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/get_draft")
    public Mono<ResponseEntity<BaselineIdeaDTO>> getDraftByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @SpringQueryMap BaselineIdeaDTO dto) {
        BaselineIdea domain = baselineIdeaDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        BaselineIdea rt = baselineIdeaService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(baselineIdeaDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_baseline_relation_version 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineIdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_relation_version", tags = {"基线需求" },  notes = "BaselineIdea-fetch_baseline_relation_version ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/fetch_baseline_relation_version")
    public Mono<ResponseEntity<List<BaselineIdeaDTO>>> fetchBaselineRelationVersionByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody BaselineIdeaFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        BaselineIdeaSearchContext context = baselineIdeaFilterDtoMapping.toDomain(dto);
        Page<BaselineIdea> domains = baselineIdeaService.fetchBaselineRelationVersion(context) ;
        List<BaselineIdeaDTO> list = baselineIdeaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineIdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"基线需求" },  notes = "BaselineIdea-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineIdea-fetch_default-all') or hasPermission('library',#ownerId,#dto,'ibizplm-BaselineIdea-fetch_default')")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/fetch_default")
    public Mono<ResponseEntity<List<BaselineIdeaDTO>>> fetchDefaultByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody BaselineIdeaFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        BaselineIdeaSearchContext context = baselineIdeaFilterDtoMapping.toDomain(dto);
        Page<BaselineIdea> domains = baselineIdeaService.fetchDefault(context) ;
        List<BaselineIdeaDTO> list = baselineIdeaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_fill_version_data 基线需求
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineIdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_fill_version_data", tags = {"基线需求" },  notes = "BaselineIdea-fetch_fill_version_data ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_ideas/fetch_fill_version_data")
    public Mono<ResponseEntity<List<BaselineIdeaDTO>>> fetchFillVersionDataByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody BaselineIdeaFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        BaselineIdeaSearchContext context = baselineIdeaFilterDtoMapping.toDomain(dto);
        Page<BaselineIdea> domains = baselineIdeaService.fetchFillVersionData(context) ;
        List<BaselineIdeaDTO> list = baselineIdeaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建基线需求
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineIdea-Create-all')")
    @ApiOperation(value = "批量新建基线需求", tags = {"基线需求" },  notes = "批量新建基线需求")
	@PostMapping("baseline_ideas/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<BaselineIdeaDTO> dtos) {
        baselineIdeaService.create(baselineIdeaDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除基线需求
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineIdea-Remove-all')")
    @ApiOperation(value = "批量删除基线需求", tags = {"基线需求" },  notes = "批量删除基线需求")
	@DeleteMapping("baseline_ideas/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        baselineIdeaService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新基线需求
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineIdea-Update-all')")
    @ApiOperation(value = "批量更新基线需求", tags = {"基线需求" },  notes = "批量更新基线需求")
	@PutMapping("baseline_ideas/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<BaselineIdeaDTO> dtos) {
        baselineIdeaService.update(baselineIdeaDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存基线需求
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineIdea-Save-all')")
    @ApiOperation(value = "批量保存基线需求", tags = {"基线需求" },  notes = "批量保存基线需求")
	@PostMapping("baseline_ideas/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<BaselineIdeaDTO> dtos) {
        baselineIdeaService.save(baselineIdeaDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入基线需求
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineIdea-Save-all')")
    @ApiOperation(value = "批量导入基线需求", tags = {"基线需求" },  notes = "批量导入基线需求")
	@PostMapping("baseline_ideas/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<BaselineIdeaDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(baselineIdeaService.importData(config,ignoreError,baselineIdeaDtoMapping.toDomain(dtos))));
    }

}
