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
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.service.GuidelineService;
import cn.ibizlab.plm.core.testmgmt.filter.GuidelineSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Guideline] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractGuidelineResource {

    @Autowired
    public GuidelineService guidelineService;

    @Autowired
    @Lazy
    public GuidelineDefGroupDTOMapping guidelineDefGroupDtoMapping;

    @Autowired
    @Lazy
    public GuidelineDTOMapping guidelineDtoMapping;

    @Autowired
    @Lazy
    public GuidelineFilterDTOMapping guidelineFilterDtoMapping;

    /**
    * 创建Create 流程准则
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"流程准则" },  notes = "Guideline-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Create-all') or hasPermission(this.guidelineDtoMapping.toDomain(#dto),'ibizplm-Guideline-Create')")
    @PostMapping("guidelines")
    public Mono<ResponseEntity<ResponseWrapper<GuidelineDTO>>>create
            (@Validated @RequestBody RequestWrapper<GuidelineDTO> dto) {
        ResponseWrapper<GuidelineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 流程准则
    * 
    *
    * @param dto dto
    * @return ResponseEntity<GuidelineDTO>
    */   
    public GuidelineDTO create
            (GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        guidelineService.create(domain);
        Guideline rt = domain;
        return guidelineDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 流程准则
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"流程准则" },  notes = "Guideline-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Update-all') or hasPermission(this.guidelineService.get(#id),'ibizplm-Guideline-Update')")
    @VersionCheck(entity = "guideline" , versionfield = "updateTime")
    @PutMapping("guidelines/{id}")
    public Mono<ResponseEntity<ResponseWrapper<GuidelineDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<GuidelineDTO> dto) {
        ResponseWrapper<GuidelineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 流程准则
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<GuidelineDTO>
    */   
    public GuidelineDTO updateById
            (String id, GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        domain.setId(id);
        guidelineService.update(domain);
        Guideline rt = domain;
        return guidelineDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 流程准则
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"流程准则" },  notes = "Guideline-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Save-all') or hasPermission(this.guidelineDtoMapping.toDomain(#dto),'ibizplm-Guideline-Save')")
    @PostMapping("guidelines/save")
    public Mono<ResponseEntity<ResponseWrapper<GuidelineDTO>>>save
            (@Validated @RequestBody RequestWrapper<GuidelineDTO> dto) {
        ResponseWrapper<GuidelineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 流程准则
    * 
    *
    * @param dto dto
    * @return ResponseEntity<GuidelineDTO>
    */   
    public GuidelineDTO save
            (GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        guidelineService.save(domain);
        Guideline rt = domain;
        return guidelineDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"流程准则" },  notes = "Guideline-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Create-all') or hasPermission('library',#scopeId,this.guidelineDtoMapping.toDomain(#dto),'ibizplm-Guideline-Create')")
    @PostMapping("libraries/{scopeId}/guidelines")
    public Mono<ResponseEntity<ResponseWrapper<GuidelineDTO>>>createByScopeId
            (@PathVariable("scopeId") String scopeId, @Validated @RequestBody RequestWrapper<GuidelineDTO> dto) {
        ResponseWrapper<GuidelineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByScopeId(scopeId, item)));
        else
            rt.set(createByScopeId(scopeId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return ResponseEntity<GuidelineDTO>
    */   
    public GuidelineDTO createByScopeId
            (String scopeId, GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        domain.setScopeId(scopeId);
        guidelineService.create(domain);
        Guideline rt = domain;
        return guidelineDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"流程准则" },  notes = "Guideline-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Update-all') or hasPermission('library',#scopeId,this.guidelineService.get(#id),'ibizplm-Guideline-Update')")
    @VersionCheck(entity = "guideline" , versionfield = "updateTime")
    @PutMapping("libraries/{scopeId}/guidelines/{id}")
    public Mono<ResponseEntity<ResponseWrapper<GuidelineDTO>>>updateByScopeIdAndId
            (@PathVariable("scopeId") String scopeId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<GuidelineDTO> dto) {
        ResponseWrapper<GuidelineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByScopeIdAndId(scopeId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByScopeIdAndId(scopeId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<GuidelineDTO>
    */   
    public GuidelineDTO updateByScopeIdAndId
            (String scopeId, String id, GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        domain.setId(id);
        guidelineService.update(domain);
        Guideline rt = domain;
        return guidelineDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"流程准则" },  notes = "Guideline-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Save-all') or hasPermission('library',#scopeId,this.guidelineDtoMapping.toDomain(#dto),'ibizplm-Guideline-Save')")
    @PostMapping("libraries/{scopeId}/guidelines/save")
    public Mono<ResponseEntity<ResponseWrapper<GuidelineDTO>>>saveByScopeId
            (@PathVariable("scopeId") String scopeId, @Validated @RequestBody RequestWrapper<GuidelineDTO> dto) {
        ResponseWrapper<GuidelineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByScopeId(scopeId, item)));
        else
            rt.set(saveByScopeId(scopeId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return ResponseEntity<GuidelineDTO>
    */   
    public GuidelineDTO saveByScopeId
            (String scopeId, GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        domain.setScopeId(scopeId);
        guidelineService.save(domain);
        Guideline rt = domain;
        return guidelineDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 流程准则
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"流程准则" },  notes = "Guideline-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Get-all')  or hasPermission(this.guidelineDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Guideline-Get')")
    @GetMapping("guidelines/{id}")
    public Mono<ResponseEntity<GuidelineDTO>> getById
            (@PathVariable("id") String id) {
        Guideline rt = guidelineService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(guidelineDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 流程准则
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"流程准则" },  notes = "Guideline-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Remove-all') or hasPermission(this.guidelineService.get(#id),'ibizplm-Guideline-Remove')")
    @DeleteMapping("guidelines/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = guidelineService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 流程准则
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"流程准则" },  notes = "Guideline-CheckKey ")
    @PostMapping("guidelines/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        CheckKeyStatus rt = guidelineService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 流程准则
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"流程准则" },  notes = "Guideline-GetDraft ")
    @GetMapping("guidelines/get_draft")
    public Mono<ResponseEntity<GuidelineDTO>> getDraft
            (@SpringQueryMap GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        Guideline rt = guidelineService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(guidelineDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_base 流程准则
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<GuidelineDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_base", tags = {"流程准则" },  notes = "Guideline-fetch_base ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-fetch_base-all') or hasPermission(#dto,'ibizplm-Guideline-fetch_base')")
    @PostMapping("guidelines/fetch_base")
    public Mono<ResponseEntity<List<GuidelineDefGroupDTO>>> fetchBase
            (@Validated @RequestBody GuidelineFilterDTO dto) {
        GuidelineSearchContext context = guidelineFilterDtoMapping.toDomain(dto);
        Page<Guideline> domains = guidelineService.fetchBase(context) ;
        List<GuidelineDefGroupDTO> list = guidelineDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 流程准则
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<GuidelineDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"流程准则" },  notes = "Guideline-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-fetch_default-all') or hasPermission(#dto,'ibizplm-Guideline-fetch_default')")
    @PostMapping("guidelines/fetch_default")
    public Mono<ResponseEntity<List<GuidelineDefGroupDTO>>> fetchDefault
            (@Validated @RequestBody GuidelineFilterDTO dto) {
        GuidelineSearchContext context = guidelineFilterDtoMapping.toDomain(dto);
        Page<Guideline> domains = guidelineService.fetchDefault(context) ;
        List<GuidelineDefGroupDTO> list = guidelineDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 流程准则
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<GuidelineDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"流程准则" },  notes = "Guideline-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-fetch_normal-all') or hasPermission(#dto,'ibizplm-Guideline-fetch_normal')")
    @PostMapping("guidelines/fetch_normal")
    public Mono<ResponseEntity<List<GuidelineDTO>>> fetchNormal
            (@Validated @RequestBody GuidelineFilterDTO dto) {
        GuidelineSearchContext context = guidelineFilterDtoMapping.toDomain(dto);
        Page<Guideline> domains = guidelineService.fetchNormal(context) ;
        List<GuidelineDTO> list = guidelineDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_library 流程准则
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<GuidelineDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_library", tags = {"流程准则" },  notes = "Guideline-fetch_under_library ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-fetch_under_library-all') or hasPermission(#dto,'ibizplm-Guideline-fetch_under_library')")
    @PostMapping("guidelines/fetch_under_library")
    public Mono<ResponseEntity<List<GuidelineDefGroupDTO>>> fetchUnderLibrary
            (@Validated @RequestBody GuidelineFilterDTO dto) {
        GuidelineSearchContext context = guidelineFilterDtoMapping.toDomain(dto);
        Page<Guideline> domains = guidelineService.fetchUnderLibrary(context) ;
        List<GuidelineDefGroupDTO> list = guidelineDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param id id
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"流程准则" },  notes = "Guideline-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Get-all')  or hasPermission('library',#scopeId,this.guidelineDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Guideline-Get')")
    @GetMapping("libraries/{scopeId}/guidelines/{id}")
    public Mono<ResponseEntity<GuidelineDTO>> getByScopeIdAndId
            (@PathVariable("scopeId") String scopeId, @PathVariable("id") String id) {
        Guideline rt = guidelineService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(guidelineDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"流程准则" },  notes = "Guideline-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-Remove-all') or hasPermission('library',#scopeId,this.guidelineService.get(#id),'ibizplm-Guideline-Remove')")
    @DeleteMapping("libraries/{scopeId}/guidelines/{id}")
    public Mono<ResponseEntity<Boolean>> removeByScopeIdAndId
            (@PathVariable("scopeId") String scopeId, @PathVariable("id") String id) {
        Boolean rt = guidelineService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"流程准则" },  notes = "Guideline-CheckKey ")
    @PostMapping("libraries/{scopeId}/guidelines/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByScopeId
            (@PathVariable("scopeId") String scopeId, @Validated @RequestBody GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        domain.setScopeId(scopeId);
        CheckKeyStatus rt = guidelineService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return Mono<ResponseEntity<GuidelineDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"流程准则" },  notes = "Guideline-GetDraft ")
    @GetMapping("libraries/{scopeId}/guidelines/get_draft")
    public Mono<ResponseEntity<GuidelineDTO>> getDraftByScopeId
            (@PathVariable("scopeId") String scopeId, @SpringQueryMap GuidelineDTO dto) {
        Guideline domain = guidelineDtoMapping.toDomain(dto);
        domain.setScopeId(scopeId);
        Guideline rt = guidelineService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(guidelineDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_base 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<GuidelineDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_base", tags = {"流程准则" },  notes = "Guideline-fetch_base ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-fetch_base-all') or hasPermission('library',#scopeId,#dto,'ibizplm-Guideline-fetch_base')")
    @PostMapping("libraries/{scopeId}/guidelines/fetch_base")
    public Mono<ResponseEntity<List<GuidelineDefGroupDTO>>> fetchBaseByScopeId
            (@PathVariable("scopeId") String scopeId, @Validated @RequestBody GuidelineFilterDTO dto) {
        dto.setScopeIdEQ(scopeId);
        GuidelineSearchContext context = guidelineFilterDtoMapping.toDomain(dto);
        Page<Guideline> domains = guidelineService.fetchBase(context) ;
        List<GuidelineDefGroupDTO> list = guidelineDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<GuidelineDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"流程准则" },  notes = "Guideline-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-fetch_default-all') or hasPermission('library',#scopeId,#dto,'ibizplm-Guideline-fetch_default')")
    @PostMapping("libraries/{scopeId}/guidelines/fetch_default")
    public Mono<ResponseEntity<List<GuidelineDefGroupDTO>>> fetchDefaultByScopeId
            (@PathVariable("scopeId") String scopeId, @Validated @RequestBody GuidelineFilterDTO dto) {
        dto.setScopeIdEQ(scopeId);
        GuidelineSearchContext context = guidelineFilterDtoMapping.toDomain(dto);
        Page<Guideline> domains = guidelineService.fetchDefault(context) ;
        List<GuidelineDefGroupDTO> list = guidelineDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<GuidelineDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"流程准则" },  notes = "Guideline-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-fetch_normal-all') or hasPermission('library',#scopeId,#dto,'ibizplm-Guideline-fetch_normal')")
    @PostMapping("libraries/{scopeId}/guidelines/fetch_normal")
    public Mono<ResponseEntity<List<GuidelineDTO>>> fetchNormalByScopeId
            (@PathVariable("scopeId") String scopeId, @Validated @RequestBody GuidelineFilterDTO dto) {
        dto.setScopeIdEQ(scopeId);
        GuidelineSearchContext context = guidelineFilterDtoMapping.toDomain(dto);
        Page<Guideline> domains = guidelineService.fetchNormal(context) ;
        List<GuidelineDTO> list = guidelineDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_library 流程准则
    * 
    *
    * @param scopeId scopeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<GuidelineDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_library", tags = {"流程准则" },  notes = "Guideline-fetch_under_library ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Guideline-fetch_under_library-all') or hasPermission('library',#scopeId,#dto,'ibizplm-Guideline-fetch_under_library')")
    @PostMapping("libraries/{scopeId}/guidelines/fetch_under_library")
    public Mono<ResponseEntity<List<GuidelineDefGroupDTO>>> fetchUnderLibraryByScopeId
            (@PathVariable("scopeId") String scopeId, @Validated @RequestBody GuidelineFilterDTO dto) {
        dto.setScopeIdEQ(scopeId);
        GuidelineSearchContext context = guidelineFilterDtoMapping.toDomain(dto);
        Page<Guideline> domains = guidelineService.fetchUnderLibrary(context) ;
        List<GuidelineDefGroupDTO> list = guidelineDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建流程准则
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Guideline-Create-all')")
    @ApiOperation(value = "批量新建流程准则", tags = {"流程准则" },  notes = "批量新建流程准则")
	@PostMapping("guidelines/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<GuidelineDTO> dtos) {
        guidelineService.create(guidelineDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除流程准则
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Guideline-Remove-all')")
    @ApiOperation(value = "批量删除流程准则", tags = {"流程准则" },  notes = "批量删除流程准则")
	@DeleteMapping("guidelines/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        guidelineService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新流程准则
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Guideline-Update-all')")
    @ApiOperation(value = "批量更新流程准则", tags = {"流程准则" },  notes = "批量更新流程准则")
	@PutMapping("guidelines/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<GuidelineDTO> dtos) {
        guidelineService.update(guidelineDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存流程准则
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Guideline-Save-all')")
    @ApiOperation(value = "批量保存流程准则", tags = {"流程准则" },  notes = "批量保存流程准则")
	@PostMapping("guidelines/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<GuidelineDTO> dtos) {
        guidelineService.save(guidelineDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入流程准则
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Guideline-Save-all')")
    @ApiOperation(value = "批量导入流程准则", tags = {"流程准则" },  notes = "批量导入流程准则")
	@PostMapping("guidelines/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<GuidelineDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(guidelineService.importData(config,ignoreError,guidelineDtoMapping.toDomain(dtos))));
    }

}
