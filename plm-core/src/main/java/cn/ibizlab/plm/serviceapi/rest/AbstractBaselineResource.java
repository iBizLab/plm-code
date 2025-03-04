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
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.base.filter.BaselineSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Baseline] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineResource {

    @Autowired
    public BaselineService baselineService;

    @Autowired
    @Lazy
    public BaselineDTOMapping baselineDtoMapping;

    @Autowired
    @Lazy
    public BaselineFilterDTOMapping baselineFilterDtoMapping;

    /**
    * 创建Create 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"基线" },  notes = "Baseline-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Create-all') or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-Create')")
    @PostMapping("libraries/{ownerId}/baselines")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO createByOwnerId
            (String ownerId, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        baselineService.create(domain);
        Baseline rt = domain;
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"基线" },  notes = "Baseline-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Update-all') or hasPermission('library',#ownerId,this.baselineService.get(#id),'ibizplm-Baseline-Update')")
    @VersionCheck(entity = "baseline" , versionfield = "updateTime")
    @PutMapping("libraries/{ownerId}/baselines/{id}")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO updateByOwnerIdAndId
            (String ownerId, String id, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setId(id);
        baselineService.update(domain);
        Baseline rt = domain;
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"基线" },  notes = "Baseline-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-delete_categories-all') or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-delete_categories')")
    @PostMapping("libraries/{ownerId}/baselines/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>deleteCategoriesByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(deleteCategoriesByOwnerId(ownerId, item)));
        else
            rt.set(deleteCategoriesByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO deleteCategoriesByOwnerId
            (String ownerId, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Baseline rt = baselineService.deleteCategories(domain);
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * plan_snapshot 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "plan_snapshot", tags = {"基线" },  notes = "Baseline-plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-plan_snapshot-all') or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-plan_snapshot')")
    @PostMapping("libraries/{ownerId}/baselines/plan_snapshot")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>planSnapshotByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(planSnapshotByOwnerId(ownerId, item)));
        else
            rt.set(planSnapshotByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_snapshot 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO planSnapshotByOwnerId
            (String ownerId, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Baseline rt = baselineService.planSnapshot(domain);
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"基线" },  notes = "Baseline-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Save-all') or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-Save')")
    @PostMapping("libraries/{ownerId}/baselines/save")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO saveByOwnerId
            (String ownerId, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        baselineService.save(domain);
        Baseline rt = domain;
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * set_complete_library 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "set_complete_library", tags = {"基线" },  notes = "Baseline-set_complete_library ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-set_complete_library-all') or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-set_complete_library')")
    @PostMapping("libraries/{ownerId}/baselines/{id}/set_complete_library")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>setCompleteLibraryByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setCompleteLibraryByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setCompleteLibraryByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_complete_library 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO setCompleteLibraryByOwnerIdAndId
            (String ownerId, String id, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setId(id);
        Baseline rt = baselineService.setCompleteLibrary(domain);
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * set_complete_product 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "set_complete_product", tags = {"基线" },  notes = "Baseline-set_complete_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-set_complete_product-all') or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-set_complete_product')")
    @PostMapping("libraries/{ownerId}/baselines/{id}/set_complete_product")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>setCompleteProductByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setCompleteProductByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setCompleteProductByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_complete_product 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO setCompleteProductByOwnerIdAndId
            (String ownerId, String id, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setId(id);
        Baseline rt = baselineService.setCompleteProduct(domain);
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * set_complete_project 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "set_complete_project", tags = {"基线" },  notes = "Baseline-set_complete_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-set_complete_project-all') or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-set_complete_project')")
    @PostMapping("libraries/{ownerId}/baselines/{id}/set_complete_project")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>setCompleteProjectByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setCompleteProjectByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setCompleteProjectByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_complete_project 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO setCompleteProjectByOwnerIdAndId
            (String ownerId, String id, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setId(id);
        Baseline rt = baselineService.setCompleteProject(domain);
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * set_complete_space 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "set_complete_space", tags = {"基线" },  notes = "Baseline-set_complete_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-set_complete_space-all') or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-set_complete_space')")
    @PostMapping("libraries/{ownerId}/baselines/{id}/set_complete_space")
    public Mono<ResponseEntity<ResponseWrapper<BaselineDTO>>>setCompleteSpaceByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setCompleteSpaceByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setCompleteSpaceByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_complete_space 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO setCompleteSpaceByOwnerIdAndId
            (String ownerId, String id, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setId(id);
        Baseline rt = baselineService.setCompleteSpace(domain);
        return baselineDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"基线" },  notes = "Baseline-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Get-all')  or hasPermission('library',#ownerId,this.baselineDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Baseline-Get')")
    @GetMapping("libraries/{ownerId}/baselines/{id}")
    public Mono<ResponseEntity<BaselineDTO>> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Baseline rt = baselineService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(baselineDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 基线
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"基线" },  notes = "Baseline-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Remove-all') or hasPermission('library',#ownerId,this.baselineService.get(#id),'ibizplm-Baseline-Remove')")
    @DeleteMapping("libraries/{ownerId}/baselines/{id}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = baselineService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"基线" },  notes = "Baseline-CheckKey ")
    @PostMapping("libraries/{ownerId}/baselines/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = baselineService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<BaselineDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"基线" },  notes = "Baseline-GetDraft ")
    @GetMapping("libraries/{ownerId}/baselines/get_draft")
    public Mono<ResponseEntity<BaselineDTO>> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Baseline rt = baselineService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(baselineDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_baseline 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline", tags = {"基线" },  notes = "Baseline-fetch_baseline ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-fetch_baseline-all') or hasPermission('library',#ownerId,#dto,'ibizplm-Baseline-fetch_baseline')")
    @PostMapping("libraries/{ownerId}/baselines/fetch_baseline")
    public Mono<ResponseEntity<List<BaselineDTO>>> fetchBaselineByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody BaselineFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        BaselineSearchContext context = baselineFilterDtoMapping.toDomain(dto);
        Page<Baseline> domains = baselineService.fetchBaseline(context) ;
        List<BaselineDTO> list = baselineDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"基线" },  notes = "Baseline-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-fetch_default-all') or hasPermission('library',#ownerId,#dto,'ibizplm-Baseline-fetch_default')")
    @PostMapping("libraries/{ownerId}/baselines/fetch_default")
    public Mono<ResponseEntity<List<BaselineDTO>>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody BaselineFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        BaselineSearchContext context = baselineFilterDtoMapping.toDomain(dto);
        Page<Baseline> domains = baselineService.fetchDefault(context) ;
        List<BaselineDTO> list = baselineDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_snapshot 基线
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BaselineDTO>>>
    */
    @ApiOperation(value = "查询fetch_snapshot", tags = {"基线" },  notes = "Baseline-fetch_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-fetch_snapshot-all') or hasPermission('library',#ownerId,#dto,'ibizplm-Baseline-fetch_snapshot')")
    @PostMapping("libraries/{ownerId}/baselines/fetch_snapshot")
    public Mono<ResponseEntity<List<BaselineDTO>>> fetchSnapshotByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody BaselineFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        BaselineSearchContext context = baselineFilterDtoMapping.toDomain(dto);
        Page<Baseline> domains = baselineService.fetchSnapshot(context) ;
        List<BaselineDTO> list = baselineDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


}
