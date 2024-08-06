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
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.service.SwimlaneService;
import cn.ibizlab.plm.core.projmgmt.filter.SwimlaneSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Swimlane] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSwimlaneResource {

    @Autowired
    public SwimlaneService swimlaneService;

    @Autowired
    @Lazy
    public SwimlaneDTOMapping swimlaneDtoMapping;

    @Autowired
    @Lazy
    public SwimlaneFilterDTOMapping swimlaneFilterDtoMapping;

    /**
    * 创建Create 泳道
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"泳道" },  notes = "Swimlane-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Create-all') or hasPermission(this.swimlaneDtoMapping.toDomain(#dto),'ibizplm-Swimlane-Create')")
    @PostMapping("swimlanes")
    public Mono<ResponseEntity<ResponseWrapper<SwimlaneDTO>>>create
            (@Validated @RequestBody RequestWrapper<SwimlaneDTO> dto) {
        ResponseWrapper<SwimlaneDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 泳道
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SwimlaneDTO>
    */   
    public SwimlaneDTO create
            (SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        swimlaneService.create(domain);
        Swimlane rt = domain;
        return swimlaneDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 泳道
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"泳道" },  notes = "Swimlane-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Update-all') or hasPermission(this.swimlaneService.get(#id),'ibizplm-Swimlane-Update')")
    @VersionCheck(entity = "swimlane" , versionfield = "updateTime")
    @PutMapping("swimlanes/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SwimlaneDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SwimlaneDTO> dto) {
        ResponseWrapper<SwimlaneDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 泳道
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SwimlaneDTO>
    */   
    public SwimlaneDTO updateById
            (String id, SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        domain.setId(id);
        swimlaneService.update(domain);
        Swimlane rt = domain;
        return swimlaneDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 泳道
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"泳道" },  notes = "Swimlane-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Save-all') or hasPermission(this.swimlaneDtoMapping.toDomain(#dto),'ibizplm-Swimlane-Save')")
    @PostMapping("swimlanes/save")
    public Mono<ResponseEntity<ResponseWrapper<SwimlaneDTO>>>save
            (@Validated @RequestBody RequestWrapper<SwimlaneDTO> dto) {
        ResponseWrapper<SwimlaneDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 泳道
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SwimlaneDTO>
    */   
    public SwimlaneDTO save
            (SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        swimlaneService.save(domain);
        Swimlane rt = domain;
        return swimlaneDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 泳道
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"泳道" },  notes = "Swimlane-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Create-all') or hasPermission('project',#projectId,this.swimlaneDtoMapping.toDomain(#dto),'ibizplm-Swimlane-Create')")
    @PostMapping("projects/{projectId}/swimlanes")
    public Mono<ResponseEntity<ResponseWrapper<SwimlaneDTO>>>createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<SwimlaneDTO> dto) {
        ResponseWrapper<SwimlaneDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 泳道
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SwimlaneDTO>
    */   
    public SwimlaneDTO createByProjectId
            (String projectId, SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        swimlaneService.create(domain);
        Swimlane rt = domain;
        return swimlaneDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 泳道
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"泳道" },  notes = "Swimlane-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Update-all') or hasPermission('project',#projectId,this.swimlaneService.get(#id),'ibizplm-Swimlane-Update')")
    @VersionCheck(entity = "swimlane" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/swimlanes/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SwimlaneDTO>>>updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SwimlaneDTO> dto) {
        ResponseWrapper<SwimlaneDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 泳道
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SwimlaneDTO>
    */   
    public SwimlaneDTO updateByProjectIdAndId
            (String projectId, String id, SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        domain.setId(id);
        swimlaneService.update(domain);
        Swimlane rt = domain;
        return swimlaneDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 泳道
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"泳道" },  notes = "Swimlane-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Save-all') or hasPermission('project',#projectId,this.swimlaneDtoMapping.toDomain(#dto),'ibizplm-Swimlane-Save')")
    @PostMapping("projects/{projectId}/swimlanes/save")
    public Mono<ResponseEntity<ResponseWrapper<SwimlaneDTO>>>saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<SwimlaneDTO> dto) {
        ResponseWrapper<SwimlaneDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 泳道
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SwimlaneDTO>
    */   
    public SwimlaneDTO saveByProjectId
            (String projectId, SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        swimlaneService.save(domain);
        Swimlane rt = domain;
        return swimlaneDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 泳道
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"泳道" },  notes = "Swimlane-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Get-all')  or hasPermission(this.swimlaneDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Swimlane-Get')")
    @GetMapping("swimlanes/{id}")
    public Mono<ResponseEntity<SwimlaneDTO>> getById
            (@PathVariable("id") String id) {
        Swimlane rt = swimlaneService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(swimlaneDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 泳道
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"泳道" },  notes = "Swimlane-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Remove-all') or hasPermission(this.swimlaneService.get(#id),'ibizplm-Swimlane-Remove')")
    @DeleteMapping("swimlanes/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = swimlaneService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 泳道
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"泳道" },  notes = "Swimlane-CheckKey ")
    @PostMapping("swimlanes/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        CheckKeyStatus rt = swimlaneService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 泳道
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"泳道" },  notes = "Swimlane-GetDraft ")
    @GetMapping("swimlanes/get_draft")
    public Mono<ResponseEntity<SwimlaneDTO>> getDraft
            (@SpringQueryMap SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        Swimlane rt = swimlaneService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(swimlaneDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 泳道
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SwimlaneDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"泳道" },  notes = "Swimlane-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-fetch_default-all') or hasPermission(#dto,'ibizplm-Swimlane-fetch_default')")
    @PostMapping("swimlanes/fetch_default")
    public Mono<ResponseEntity<List<SwimlaneDTO>>> fetchDefault
            (@Validated @RequestBody SwimlaneFilterDTO dto) {
        SwimlaneSearchContext context = swimlaneFilterDtoMapping.toDomain(dto);
        Page<Swimlane> domains = swimlaneService.fetchDefault(context) ;
        List<SwimlaneDTO> list = swimlaneDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 泳道
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"泳道" },  notes = "Swimlane-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Get-all')  or hasPermission('project',#projectId,this.swimlaneDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Swimlane-Get')")
    @GetMapping("projects/{projectId}/swimlanes/{id}")
    public Mono<ResponseEntity<SwimlaneDTO>> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Swimlane rt = swimlaneService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(swimlaneDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 泳道
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"泳道" },  notes = "Swimlane-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-Remove-all') or hasPermission('project',#projectId,this.swimlaneService.get(#id),'ibizplm-Swimlane-Remove')")
    @DeleteMapping("projects/{projectId}/swimlanes/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = swimlaneService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 泳道
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"泳道" },  notes = "Swimlane-CheckKey ")
    @PostMapping("projects/{projectId}/swimlanes/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        CheckKeyStatus rt = swimlaneService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 泳道
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<SwimlaneDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"泳道" },  notes = "Swimlane-GetDraft ")
    @GetMapping("projects/{projectId}/swimlanes/get_draft")
    public Mono<ResponseEntity<SwimlaneDTO>> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap SwimlaneDTO dto) {
        Swimlane domain = swimlaneDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Swimlane rt = swimlaneService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(swimlaneDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 泳道
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SwimlaneDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"泳道" },  notes = "Swimlane-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Swimlane-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Swimlane-fetch_default')")
    @PostMapping("projects/{projectId}/swimlanes/fetch_default")
    public Mono<ResponseEntity<List<SwimlaneDTO>>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SwimlaneFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SwimlaneSearchContext context = swimlaneFilterDtoMapping.toDomain(dto);
        Page<Swimlane> domains = swimlaneService.fetchDefault(context) ;
        List<SwimlaneDTO> list = swimlaneDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建泳道
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Swimlane-Create-all')")
    @ApiOperation(value = "批量新建泳道", tags = {"泳道" },  notes = "批量新建泳道")
	@PostMapping("swimlanes/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<SwimlaneDTO> dtos) {
        swimlaneService.create(swimlaneDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除泳道
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Swimlane-Remove-all')")
    @ApiOperation(value = "批量删除泳道", tags = {"泳道" },  notes = "批量删除泳道")
	@DeleteMapping("swimlanes/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        swimlaneService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新泳道
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Swimlane-Update-all')")
    @ApiOperation(value = "批量更新泳道", tags = {"泳道" },  notes = "批量更新泳道")
	@PutMapping("swimlanes/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<SwimlaneDTO> dtos) {
        swimlaneService.update(swimlaneDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存泳道
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Swimlane-Save-all')")
    @ApiOperation(value = "批量保存泳道", tags = {"泳道" },  notes = "批量保存泳道")
	@PostMapping("swimlanes/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<SwimlaneDTO> dtos) {
        swimlaneService.save(swimlaneDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入泳道
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Swimlane-Save-all')")
    @ApiOperation(value = "批量导入泳道", tags = {"泳道" },  notes = "批量导入泳道")
	@PostMapping("swimlanes/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SwimlaneDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(swimlaneService.importData(config,ignoreError,swimlaneDtoMapping.toDomain(dtos))));
    }

}
