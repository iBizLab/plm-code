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
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
import cn.ibizlab.plm.core.projmgmt.service.SprintAlterationService;
import cn.ibizlab.plm.core.projmgmt.filter.SprintAlterationSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[SprintAlteration] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintAlterationResource {

    @Autowired
    public SprintAlterationService sprintAlterationService;

    @Autowired
    @Lazy
    public SprintAlterationDTOMapping sprintAlterationDtoMapping;

    @Autowired
    @Lazy
    public SprintAlterationFilterDTOMapping sprintAlterationFilterDtoMapping;

    /**
    * 创建Create 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代变更" },  notes = "SprintAlteration-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Create-all') or hasPermission('sprint',#sprintId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-Create')")
    @PostMapping("sprints/{sprintId}/sprint_alterations")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>createBySprintId
            (@PathVariable("sprintId") String sprintId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySprintId(sprintId, item)));
        else
            rt.set(createBySprintId(sprintId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO createBySprintId
            (String sprintId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        sprintAlterationService.create(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代变更" },  notes = "SprintAlteration-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Update-all') or hasPermission('sprint',#sprintId,this.sprintAlterationService.get(#id),'ibizplm-SprintAlteration-Update')")
    @VersionCheck(entity = "sprintalteration" , versionfield = "updateTime")
    @PutMapping("sprints/{sprintId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>updateBySprintIdAndId
            (@PathVariable("sprintId") String sprintId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySprintIdAndId(sprintId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySprintIdAndId(sprintId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO updateBySprintIdAndId
            (String sprintId, String id, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintAlterationService.update(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * rep_change 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "rep_change", tags = {"迭代变更" },  notes = "SprintAlteration-rep_change ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-rep_change-all') or hasPermission('sprint',#sprintId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-rep_change')")
    @PostMapping("sprints/{sprintId}/sprint_alterations/rep_change")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>repChangeBySprintId
            (@PathVariable("sprintId") String sprintId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(repChangeBySprintId(sprintId, item)));
        else
            rt.set(repChangeBySprintId(sprintId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * rep_change 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO repChangeBySprintId
            (String sprintId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        SprintAlteration rt = sprintAlterationService.repChange(domain);
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代变更" },  notes = "SprintAlteration-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Save-all') or hasPermission('sprint',#sprintId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-Save')")
    @PostMapping("sprints/{sprintId}/sprint_alterations/save")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>saveBySprintId
            (@PathVariable("sprintId") String sprintId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySprintId(sprintId, item)));
        else
            rt.set(saveBySprintId(sprintId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO saveBySprintId
            (String sprintId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        sprintAlterationService.save(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代变更" },  notes = "SprintAlteration-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Create-all') or hasPermission('project',#projectId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-Create')")
    @PostMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>createByProjectIdAndSprintId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectIdAndSprintId(projectId, sprintId, item)));
        else
            rt.set(createByProjectIdAndSprintId(projectId, sprintId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO createByProjectIdAndSprintId
            (String projectId, String sprintId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        sprintAlterationService.create(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代变更" },  notes = "SprintAlteration-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Update-all') or hasPermission('project',#projectId,this.sprintAlterationService.get(#id),'ibizplm-SprintAlteration-Update')")
    @VersionCheck(entity = "sprintalteration" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>updateByProjectIdAndSprintIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndSprintIdAndId(projectId, sprintId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndSprintIdAndId(projectId, sprintId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO updateByProjectIdAndSprintIdAndId
            (String projectId, String sprintId, String id, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintAlterationService.update(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * rep_change 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "rep_change", tags = {"迭代变更" },  notes = "SprintAlteration-rep_change ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-rep_change-all') or hasPermission('project',#projectId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-rep_change')")
    @PostMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/rep_change")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>repChangeByProjectIdAndSprintId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(repChangeByProjectIdAndSprintId(projectId, sprintId, item)));
        else
            rt.set(repChangeByProjectIdAndSprintId(projectId, sprintId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * rep_change 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO repChangeByProjectIdAndSprintId
            (String projectId, String sprintId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        SprintAlteration rt = sprintAlterationService.repChange(domain);
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代变更" },  notes = "SprintAlteration-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Save-all') or hasPermission('project',#projectId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-Save')")
    @PostMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/save")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>saveByProjectIdAndSprintId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectIdAndSprintId(projectId, sprintId, item)));
        else
            rt.set(saveByProjectIdAndSprintId(projectId, sprintId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO saveByProjectIdAndSprintId
            (String projectId, String sprintId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        sprintAlterationService.save(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代变更" },  notes = "SprintAlteration-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Create-all') or hasPermission('work_item',#workItemId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-Create')")
    @PostMapping("work_items/{workItemId}/sprint_alterations")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>createByWorkItemId
            (@PathVariable("workItemId") String workItemId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByWorkItemId(workItemId, item)));
        else
            rt.set(createByWorkItemId(workItemId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO createByWorkItemId
            (String workItemId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        sprintAlterationService.create(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代变更" },  notes = "SprintAlteration-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Update-all') or hasPermission('work_item',#workItemId,this.sprintAlterationService.get(#id),'ibizplm-SprintAlteration-Update')")
    @VersionCheck(entity = "sprintalteration" , versionfield = "updateTime")
    @PutMapping("work_items/{workItemId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>updateByWorkItemIdAndId
            (@PathVariable("workItemId") String workItemId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByWorkItemIdAndId(workItemId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByWorkItemIdAndId(workItemId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO updateByWorkItemIdAndId
            (String workItemId, String id, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintAlterationService.update(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * rep_change 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "rep_change", tags = {"迭代变更" },  notes = "SprintAlteration-rep_change ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-rep_change-all') or hasPermission('work_item',#workItemId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-rep_change')")
    @PostMapping("work_items/{workItemId}/sprint_alterations/rep_change")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>repChangeByWorkItemId
            (@PathVariable("workItemId") String workItemId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(repChangeByWorkItemId(workItemId, item)));
        else
            rt.set(repChangeByWorkItemId(workItemId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * rep_change 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO repChangeByWorkItemId
            (String workItemId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        SprintAlteration rt = sprintAlterationService.repChange(domain);
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代变更" },  notes = "SprintAlteration-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Save-all') or hasPermission('work_item',#workItemId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-Save')")
    @PostMapping("work_items/{workItemId}/sprint_alterations/save")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>saveByWorkItemId
            (@PathVariable("workItemId") String workItemId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByWorkItemId(workItemId, item)));
        else
            rt.set(saveByWorkItemId(workItemId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO saveByWorkItemId
            (String workItemId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        sprintAlterationService.save(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代变更" },  notes = "SprintAlteration-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Create-all') or hasPermission('project',#projectId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-Create')")
    @PostMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>createByProjectIdAndWorkItemId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectIdAndWorkItemId(projectId, workItemId, item)));
        else
            rt.set(createByProjectIdAndWorkItemId(projectId, workItemId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO createByProjectIdAndWorkItemId
            (String projectId, String workItemId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        sprintAlterationService.create(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代变更" },  notes = "SprintAlteration-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Update-all') or hasPermission('project',#projectId,this.sprintAlterationService.get(#id),'ibizplm-SprintAlteration-Update')")
    @VersionCheck(entity = "sprintalteration" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>updateByProjectIdAndWorkItemIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndWorkItemIdAndId(projectId, workItemId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndWorkItemIdAndId(projectId, workItemId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO updateByProjectIdAndWorkItemIdAndId
            (String projectId, String workItemId, String id, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintAlterationService.update(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * rep_change 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "rep_change", tags = {"迭代变更" },  notes = "SprintAlteration-rep_change ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-rep_change-all') or hasPermission('project',#projectId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-rep_change')")
    @PostMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/rep_change")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>repChangeByProjectIdAndWorkItemId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(repChangeByProjectIdAndWorkItemId(projectId, workItemId, item)));
        else
            rt.set(repChangeByProjectIdAndWorkItemId(projectId, workItemId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * rep_change 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO repChangeByProjectIdAndWorkItemId
            (String projectId, String workItemId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        SprintAlteration rt = sprintAlterationService.repChange(domain);
        return sprintAlterationDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代变更" },  notes = "SprintAlteration-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Save-all') or hasPermission('project',#projectId,this.sprintAlterationDtoMapping.toDomain(#dto),'ibizplm-SprintAlteration-Save')")
    @PostMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/save")
    public Mono<ResponseEntity<ResponseWrapper<SprintAlterationDTO>>>saveByProjectIdAndWorkItemId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @Validated @RequestBody RequestWrapper<SprintAlterationDTO> dto) {
        ResponseWrapper<SprintAlterationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectIdAndWorkItemId(projectId, workItemId, item)));
        else
            rt.set(saveByProjectIdAndWorkItemId(projectId, workItemId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return ResponseEntity<SprintAlterationDTO>
    */   
    public SprintAlterationDTO saveByProjectIdAndWorkItemId
            (String projectId, String workItemId, SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        sprintAlterationService.save(domain);
        SprintAlteration rt = domain;
        return sprintAlterationDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param id id
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代变更" },  notes = "SprintAlteration-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Get-all')  or hasPermission('sprint',#sprintId,this.sprintAlterationDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-SprintAlteration-Get')")
    @GetMapping("sprints/{sprintId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<SprintAlterationDTO>> getBySprintIdAndId
            (@PathVariable("sprintId") String sprintId, @PathVariable("id") String id) {
        SprintAlteration rt = sprintAlterationService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintAlterationDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代变更" },  notes = "SprintAlteration-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Remove-all') or hasPermission('sprint',#sprintId,this.sprintAlterationService.get(#id),'ibizplm-SprintAlteration-Remove')")
    @DeleteMapping("sprints/{sprintId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<Boolean>> removeBySprintIdAndId
            (@PathVariable("sprintId") String sprintId, @PathVariable("id") String id) {
        Boolean rt = sprintAlterationService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代变更" },  notes = "SprintAlteration-CheckKey ")
    @PostMapping("sprints/{sprintId}/sprint_alterations/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyBySprintId
            (@PathVariable("sprintId") String sprintId, @Validated @RequestBody SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        CheckKeyStatus rt = sprintAlterationService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代变更" },  notes = "SprintAlteration-GetDraft ")
    @GetMapping("sprints/{sprintId}/sprint_alterations/get_draft")
    public Mono<ResponseEntity<SprintAlterationDTO>> getDraftBySprintId
            (@PathVariable("sprintId") String sprintId, @SpringQueryMap SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        SprintAlteration rt = sprintAlterationService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintAlterationDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_change 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintAlterationDTO>>>
    */
    @ApiOperation(value = "查询fetch_change", tags = {"迭代变更" },  notes = "SprintAlteration-fetch_change ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-fetch_change-all') or hasPermission('sprint',#sprintId,#dto,'ibizplm-SprintAlteration-fetch_change')")
    @PostMapping("sprints/{sprintId}/sprint_alterations/fetch_change")
    public Mono<ResponseEntity<List<SprintAlterationDTO>>> fetchChangeBySprintId
            (@PathVariable("sprintId") String sprintId, @Validated @RequestBody SprintAlterationFilterDTO dto) {
        dto.setSprintIdEQ(sprintId);
        SprintAlterationSearchContext context = sprintAlterationFilterDtoMapping.toDomain(dto);
        Page<SprintAlteration> domains = sprintAlterationService.fetchChange(context) ;
        List<SprintAlterationDTO> list = sprintAlterationDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 迭代变更
    * 
    *
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintAlterationDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"迭代变更" },  notes = "SprintAlteration-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-fetch_default-all') or hasPermission('sprint',#sprintId,#dto,'ibizplm-SprintAlteration-fetch_default')")
    @PostMapping("sprints/{sprintId}/sprint_alterations/fetch_default")
    public Mono<ResponseEntity<List<SprintAlterationDTO>>> fetchDefaultBySprintId
            (@PathVariable("sprintId") String sprintId, @Validated @RequestBody SprintAlterationFilterDTO dto) {
        dto.setSprintIdEQ(sprintId);
        SprintAlterationSearchContext context = sprintAlterationFilterDtoMapping.toDomain(dto);
        Page<SprintAlteration> domains = sprintAlterationService.fetchDefault(context) ;
        List<SprintAlterationDTO> list = sprintAlterationDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param id id
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代变更" },  notes = "SprintAlteration-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Get-all')  or hasPermission('project',#projectId,this.sprintAlterationDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-SprintAlteration-Get')")
    @GetMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<SprintAlterationDTO>> getByProjectIdAndSprintIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @PathVariable("id") String id) {
        SprintAlteration rt = sprintAlterationService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintAlterationDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代变更" },  notes = "SprintAlteration-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Remove-all') or hasPermission('project',#projectId,this.sprintAlterationService.get(#id),'ibizplm-SprintAlteration-Remove')")
    @DeleteMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndSprintIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @PathVariable("id") String id) {
        Boolean rt = sprintAlterationService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代变更" },  notes = "SprintAlteration-CheckKey ")
    @PostMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectIdAndSprintId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @Validated @RequestBody SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        CheckKeyStatus rt = sprintAlterationService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代变更" },  notes = "SprintAlteration-GetDraft ")
    @GetMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/get_draft")
    public Mono<ResponseEntity<SprintAlterationDTO>> getDraftByProjectIdAndSprintId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @SpringQueryMap SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setSprintId(sprintId);
        SprintAlteration rt = sprintAlterationService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintAlterationDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_change 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintAlterationDTO>>>
    */
    @ApiOperation(value = "查询fetch_change", tags = {"迭代变更" },  notes = "SprintAlteration-fetch_change ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-fetch_change-all') or hasPermission('project',#projectId,#dto,'ibizplm-SprintAlteration-fetch_change')")
    @PostMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/fetch_change")
    public Mono<ResponseEntity<List<SprintAlterationDTO>>> fetchChangeByProjectIdAndSprintId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @Validated @RequestBody SprintAlterationFilterDTO dto) {
        dto.setSprintIdEQ(sprintId);
        SprintAlterationSearchContext context = sprintAlterationFilterDtoMapping.toDomain(dto);
        Page<SprintAlteration> domains = sprintAlterationService.fetchChange(context) ;
        List<SprintAlterationDTO> list = sprintAlterationDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 迭代变更
    * 
    *
    * @param projectId projectId
    * @param sprintId sprintId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintAlterationDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"迭代变更" },  notes = "SprintAlteration-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-SprintAlteration-fetch_default')")
    @PostMapping("projects/{projectId}/sprints/{sprintId}/sprint_alterations/fetch_default")
    public Mono<ResponseEntity<List<SprintAlterationDTO>>> fetchDefaultByProjectIdAndSprintId
            (@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, @Validated @RequestBody SprintAlterationFilterDTO dto) {
        dto.setSprintIdEQ(sprintId);
        SprintAlterationSearchContext context = sprintAlterationFilterDtoMapping.toDomain(dto);
        Page<SprintAlteration> domains = sprintAlterationService.fetchDefault(context) ;
        List<SprintAlterationDTO> list = sprintAlterationDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param id id
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代变更" },  notes = "SprintAlteration-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Get-all')  or hasPermission('work_item',#workItemId,this.sprintAlterationDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-SprintAlteration-Get')")
    @GetMapping("work_items/{workItemId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<SprintAlterationDTO>> getByWorkItemIdAndId
            (@PathVariable("workItemId") String workItemId, @PathVariable("id") String id) {
        SprintAlteration rt = sprintAlterationService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintAlterationDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代变更" },  notes = "SprintAlteration-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Remove-all') or hasPermission('work_item',#workItemId,this.sprintAlterationService.get(#id),'ibizplm-SprintAlteration-Remove')")
    @DeleteMapping("work_items/{workItemId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<Boolean>> removeByWorkItemIdAndId
            (@PathVariable("workItemId") String workItemId, @PathVariable("id") String id) {
        Boolean rt = sprintAlterationService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代变更" },  notes = "SprintAlteration-CheckKey ")
    @PostMapping("work_items/{workItemId}/sprint_alterations/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByWorkItemId
            (@PathVariable("workItemId") String workItemId, @Validated @RequestBody SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        CheckKeyStatus rt = sprintAlterationService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代变更" },  notes = "SprintAlteration-GetDraft ")
    @GetMapping("work_items/{workItemId}/sprint_alterations/get_draft")
    public Mono<ResponseEntity<SprintAlterationDTO>> getDraftByWorkItemId
            (@PathVariable("workItemId") String workItemId, @SpringQueryMap SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        SprintAlteration rt = sprintAlterationService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintAlterationDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_change 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintAlterationDTO>>>
    */
    @ApiOperation(value = "查询fetch_change", tags = {"迭代变更" },  notes = "SprintAlteration-fetch_change ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-fetch_change-all') or hasPermission('work_item',#workItemId,#dto,'ibizplm-SprintAlteration-fetch_change')")
    @PostMapping("work_items/{workItemId}/sprint_alterations/fetch_change")
    public Mono<ResponseEntity<List<SprintAlterationDTO>>> fetchChangeByWorkItemId
            (@PathVariable("workItemId") String workItemId, @Validated @RequestBody SprintAlterationFilterDTO dto) {
        dto.setWorkItemIdEQ(workItemId);
        SprintAlterationSearchContext context = sprintAlterationFilterDtoMapping.toDomain(dto);
        Page<SprintAlteration> domains = sprintAlterationService.fetchChange(context) ;
        List<SprintAlterationDTO> list = sprintAlterationDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 迭代变更
    * 
    *
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintAlterationDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"迭代变更" },  notes = "SprintAlteration-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-fetch_default-all') or hasPermission('work_item',#workItemId,#dto,'ibizplm-SprintAlteration-fetch_default')")
    @PostMapping("work_items/{workItemId}/sprint_alterations/fetch_default")
    public Mono<ResponseEntity<List<SprintAlterationDTO>>> fetchDefaultByWorkItemId
            (@PathVariable("workItemId") String workItemId, @Validated @RequestBody SprintAlterationFilterDTO dto) {
        dto.setWorkItemIdEQ(workItemId);
        SprintAlterationSearchContext context = sprintAlterationFilterDtoMapping.toDomain(dto);
        Page<SprintAlteration> domains = sprintAlterationService.fetchDefault(context) ;
        List<SprintAlterationDTO> list = sprintAlterationDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param id id
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代变更" },  notes = "SprintAlteration-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Get-all')  or hasPermission('project',#projectId,this.sprintAlterationDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-SprintAlteration-Get')")
    @GetMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<SprintAlterationDTO>> getByProjectIdAndWorkItemIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @PathVariable("id") String id) {
        SprintAlteration rt = sprintAlterationService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintAlterationDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代变更" },  notes = "SprintAlteration-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-Remove-all') or hasPermission('project',#projectId,this.sprintAlterationService.get(#id),'ibizplm-SprintAlteration-Remove')")
    @DeleteMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndWorkItemIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @PathVariable("id") String id) {
        Boolean rt = sprintAlterationService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代变更" },  notes = "SprintAlteration-CheckKey ")
    @PostMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectIdAndWorkItemId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @Validated @RequestBody SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        CheckKeyStatus rt = sprintAlterationService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintAlterationDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代变更" },  notes = "SprintAlteration-GetDraft ")
    @GetMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/get_draft")
    public Mono<ResponseEntity<SprintAlterationDTO>> getDraftByProjectIdAndWorkItemId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @SpringQueryMap SprintAlterationDTO dto) {
        SprintAlteration domain = sprintAlterationDtoMapping.toDomain(dto);
        domain.setWorkItemId(workItemId);
        SprintAlteration rt = sprintAlterationService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintAlterationDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_change 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintAlterationDTO>>>
    */
    @ApiOperation(value = "查询fetch_change", tags = {"迭代变更" },  notes = "SprintAlteration-fetch_change ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-fetch_change-all') or hasPermission('project',#projectId,#dto,'ibizplm-SprintAlteration-fetch_change')")
    @PostMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/fetch_change")
    public Mono<ResponseEntity<List<SprintAlterationDTO>>> fetchChangeByProjectIdAndWorkItemId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @Validated @RequestBody SprintAlterationFilterDTO dto) {
        dto.setWorkItemIdEQ(workItemId);
        SprintAlterationSearchContext context = sprintAlterationFilterDtoMapping.toDomain(dto);
        Page<SprintAlteration> domains = sprintAlterationService.fetchChange(context) ;
        List<SprintAlterationDTO> list = sprintAlterationDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 迭代变更
    * 
    *
    * @param projectId projectId
    * @param workItemId workItemId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintAlterationDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"迭代变更" },  notes = "SprintAlteration-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintAlteration-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-SprintAlteration-fetch_default')")
    @PostMapping("projects/{projectId}/work_items/{workItemId}/sprint_alterations/fetch_default")
    public Mono<ResponseEntity<List<SprintAlterationDTO>>> fetchDefaultByProjectIdAndWorkItemId
            (@PathVariable("projectId") String projectId, @PathVariable("workItemId") String workItemId, @Validated @RequestBody SprintAlterationFilterDTO dto) {
        dto.setWorkItemIdEQ(workItemId);
        SprintAlterationSearchContext context = sprintAlterationFilterDtoMapping.toDomain(dto);
        Page<SprintAlteration> domains = sprintAlterationService.fetchDefault(context) ;
        List<SprintAlterationDTO> list = sprintAlterationDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


}
