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
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Sprint] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintResource {

    @Autowired
    public SprintService sprintService;

    @Autowired
    @Lazy
    public SprintBiSearchGroupDTOMapping sprintBiSearchGroupDtoMapping;

    @Autowired
    @Lazy
    public SprintDTOMapping sprintDtoMapping;

    @Autowired
    @Lazy
    public SprintFilterDTOMapping sprintFilterDtoMapping;

    /**
    * 创建Create 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代" },  notes = "Sprint-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Create-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-Create')")
    @PostMapping("sprints")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>create
            (@Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO create
            (SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        sprintService.create(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代" },  notes = "Sprint-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Update-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-Update')")
    @VersionCheck(entity = "sprint" , versionfield = "updateTime")
    @PutMapping("sprints/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO updateById
            (String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintService.update(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * del_relation 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "del_relation", tags = {"迭代" },  notes = "Sprint-del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-del_relation-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-del_relation')")
    @PostMapping("sprints/{id}/del_relation")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * del_relation 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO delRelationById
            (String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.delRelation(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"迭代" },  notes = "Sprint-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-delete_categories-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-delete_categories')")
    @PostMapping("sprints/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>deleteCategories
            (@Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(deleteCategories(item)));
        else
            rt.set(deleteCategories(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO deleteCategories
            (SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        Sprint rt = sprintService.deleteCategories(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * end_sprint 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "end_sprint", tags = {"迭代" },  notes = "Sprint-end_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-end_sprint-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-end_sprint')")
    @PostMapping("sprints/{id}/end_sprint")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>endSprintById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endSprintById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endSprintById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * end_sprint 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO endSprintById
            (String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.endSprint(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代" },  notes = "Sprint-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Save-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-Save')")
    @PostMapping("sprints/save")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>save
            (@Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO save
            (SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        sprintService.save(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * sprint_relation_release 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "sprint_relation_release", tags = {"迭代" },  notes = "Sprint-sprint_relation_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-sprint_relation_release-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-sprint_relation_release')")
    @PostMapping("sprints/sprint_relation_release")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>sprintRelationRelease
            (@Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(sprintRelationRelease(item)));
        else
            rt.set(sprintRelationRelease(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * sprint_relation_release 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO sprintRelationRelease
            (SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        Sprint rt = sprintService.sprintRelationRelease(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * start_sprint 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "start_sprint", tags = {"迭代" },  notes = "Sprint-start_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-start_sprint-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-start_sprint')")
    @PostMapping("sprints/{id}/start_sprint")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>startSprintById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startSprintById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startSprintById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_sprint 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO startSprintById
            (String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.startSprint(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代" },  notes = "Sprint-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Create-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-Create')")
    @PostMapping("projects/{projectId}/sprints")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO createByProjectId
            (String projectId, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        sprintService.create(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代" },  notes = "Sprint-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Update-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-Update')")
    @VersionCheck(entity = "sprint" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/sprints/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO updateByProjectIdAndId
            (String projectId, String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintService.update(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * del_relation 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "del_relation", tags = {"迭代" },  notes = "Sprint-del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-del_relation-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-del_relation')")
    @PostMapping("projects/{projectId}/sprints/{id}/del_relation")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>delRelationByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * del_relation 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO delRelationByProjectIdAndId
            (String projectId, String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.delRelation(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"迭代" },  notes = "Sprint-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-delete_categories-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-delete_categories')")
    @PostMapping("projects/{projectId}/sprints/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>deleteCategoriesByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(deleteCategoriesByProjectId(projectId, item)));
        else
            rt.set(deleteCategoriesByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO deleteCategoriesByProjectId
            (String projectId, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Sprint rt = sprintService.deleteCategories(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * end_sprint 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "end_sprint", tags = {"迭代" },  notes = "Sprint-end_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-end_sprint-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-end_sprint')")
    @PostMapping("projects/{projectId}/sprints/{id}/end_sprint")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>endSprintByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endSprintByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endSprintByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * end_sprint 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO endSprintByProjectIdAndId
            (String projectId, String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.endSprint(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代" },  notes = "Sprint-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Save-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-Save')")
    @PostMapping("projects/{projectId}/sprints/save")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO saveByProjectId
            (String projectId, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        sprintService.save(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * sprint_relation_release 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "sprint_relation_release", tags = {"迭代" },  notes = "Sprint-sprint_relation_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-sprint_relation_release-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-sprint_relation_release')")
    @PostMapping("projects/{projectId}/sprints/sprint_relation_release")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>sprintRelationReleaseByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(sprintRelationReleaseByProjectId(projectId, item)));
        else
            rt.set(sprintRelationReleaseByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * sprint_relation_release 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO sprintRelationReleaseByProjectId
            (String projectId, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Sprint rt = sprintService.sprintRelationRelease(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * start_sprint 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "start_sprint", tags = {"迭代" },  notes = "Sprint-start_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-start_sprint-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-start_sprint')")
    @PostMapping("projects/{projectId}/sprints/{id}/start_sprint")
    public Mono<ResponseEntity<ResponseWrapper<SprintDTO>>>startSprintByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startSprintByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startSprintByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_sprint 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO startSprintByProjectIdAndId
            (String projectId, String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.startSprint(domain);
        return sprintDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 迭代
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代" },  notes = "Sprint-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Get-all')  or hasPermission(this.sprintDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Sprint-Get')")
    @GetMapping("sprints/{id}")
    public Mono<ResponseEntity<SprintDTO>> getById
            (@PathVariable("id") String id) {
        Sprint rt = sprintService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 迭代
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代" },  notes = "Sprint-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Remove-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-Remove')")
    @DeleteMapping("sprints/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = sprintService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * cal_sprint_work_item_num 迭代
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "cal_sprint_work_item_num", tags = {"迭代" },  notes = "Sprint-cal_sprint_work_item_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-cal_sprint_work_item_num-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-cal_sprint_work_item_num')")
    @GetMapping("sprints/{id}/cal_sprint_work_item_num")
    public Mono<ResponseEntity<SprintDTO>> calSprintWorkItemNumById
            (@PathVariable("id") String id) {
        Sprint rt = sprintService.calSprintWorkItemNum(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * 校验CheckKey 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代" },  notes = "Sprint-CheckKey ")
    @PostMapping("sprints/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        CheckKeyStatus rt = sprintService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代" },  notes = "Sprint-GetDraft ")
    @GetMapping("sprints/get_draft")
    public Mono<ResponseEntity<SprintDTO>> getDraft
            (@SpringQueryMap SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        Sprint rt = sprintService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * get_not_finish 迭代
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "get_not_finish", tags = {"迭代" },  notes = "Sprint-get_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-get_not_finish-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-get_not_finish')")
    @GetMapping("sprints/{id}/get_not_finish")
    public Mono<ResponseEntity<SprintDTO>> getNotFinishById
            (@PathVariable("id") String id) {
        Sprint rt = sprintService.getNotFinish(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * overview 迭代
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "overview", tags = {"迭代" },  notes = "Sprint-overview ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-overview-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-overview')")
    @GetMapping("sprints/{id}/overview")
    public Mono<ResponseEntity<SprintDTO>> overviewById
            (@PathVariable("id") String id) {
        Sprint rt = sprintService.overview(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"迭代" },  notes = "Sprint-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_all-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_all')")
    @PostMapping("sprints/fetch_all")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchAll
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchAll(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"迭代" },  notes = "Sprint-fetch_bi_detail ")
    @PostMapping("sprints/fetch_bi_detail")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchBiDetail
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchBiDetail(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"迭代" },  notes = "Sprint-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_bi_search')")
    @PostMapping("sprints/fetch_bi_search")
    public Mono<ResponseEntity<List<SprintBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchBiSearch(context) ;
        List<SprintBiSearchGroupDTO> list = sprintBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_move 迭代
    * 确认迭代完成时，选择移动至其他迭代
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_move", tags = {"迭代" },  notes = "Sprint-fetch_choose_move 确认迭代完成时，选择移动至其他迭代")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_choose_move-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_choose_move')")
    @PostMapping("sprints/fetch_choose_move")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchChooseMove
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchChooseMove(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_sprint_relation 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_sprint_relation", tags = {"迭代" },  notes = "Sprint-fetch_choose_sprint_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_choose_sprint_relation-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_choose_sprint_relation')")
    @PostMapping("sprints/fetch_choose_sprint_relation")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchChooseSprintRelation
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchChooseSprintRelation(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_sprint_not_finish 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_sprint_not_finish", tags = {"迭代" },  notes = "Sprint-fetch_cur_sprint_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_cur_sprint_not_finish-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_cur_sprint_not_finish')")
    @PostMapping("sprints/fetch_cur_sprint_not_finish")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchCurSprintNotFinish
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchCurSprintNotFinish(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"迭代" },  notes = "Sprint-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_default-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_default')")
    @PostMapping("sprints/fetch_default")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchDefault
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchDefault(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_finish 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_finish", tags = {"迭代" },  notes = "Sprint-fetch_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_not_finish-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_not_finish')")
    @PostMapping("sprints/fetch_not_finish")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchNotFinish
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchNotFinish(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"迭代" },  notes = "Sprint-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_reader-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_reader')")
    @PostMapping("sprints/fetch_reader")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchReader
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchReader(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_relation 迭代
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_relation", tags = {"迭代" },  notes = "Sprint-fetch_release_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_release_relation-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_release_relation')")
    @PostMapping("sprints/fetch_release_relation")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchReleaseRelation
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchReleaseRelation(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代" },  notes = "Sprint-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Get-all')  or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Sprint-Get')")
    @GetMapping("projects/{projectId}/sprints/{id}")
    public Mono<ResponseEntity<SprintDTO>> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Sprint rt = sprintService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代" },  notes = "Sprint-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Remove-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-Remove')")
    @DeleteMapping("projects/{projectId}/sprints/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = sprintService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * cal_sprint_work_item_num 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "cal_sprint_work_item_num", tags = {"迭代" },  notes = "Sprint-cal_sprint_work_item_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-cal_sprint_work_item_num-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-cal_sprint_work_item_num')")
    @GetMapping("projects/{projectId}/sprints/{id}/cal_sprint_work_item_num")
    public Mono<ResponseEntity<SprintDTO>> calSprintWorkItemNumByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Sprint rt = sprintService.calSprintWorkItemNum(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * 校验CheckKey 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代" },  notes = "Sprint-CheckKey ")
    @PostMapping("projects/{projectId}/sprints/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        CheckKeyStatus rt = sprintService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代" },  notes = "Sprint-GetDraft ")
    @GetMapping("projects/{projectId}/sprints/get_draft")
    public Mono<ResponseEntity<SprintDTO>> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Sprint rt = sprintService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * get_not_finish 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "get_not_finish", tags = {"迭代" },  notes = "Sprint-get_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-get_not_finish-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-get_not_finish')")
    @GetMapping("projects/{projectId}/sprints/{id}/get_not_finish")
    public Mono<ResponseEntity<SprintDTO>> getNotFinishByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Sprint rt = sprintService.getNotFinish(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * overview 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<SprintDTO>>
    */
    @ApiOperation(value = "overview", tags = {"迭代" },  notes = "Sprint-overview ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-overview-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-overview')")
    @GetMapping("projects/{projectId}/sprints/{id}/overview")
    public Mono<ResponseEntity<SprintDTO>> overviewByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Sprint rt = sprintService.overview(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"迭代" },  notes = "Sprint-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_all-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_all')")
    @PostMapping("projects/{projectId}/sprints/fetch_all")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchAllByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchAll(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"迭代" },  notes = "Sprint-fetch_bi_detail ")
    @PostMapping("projects/{projectId}/sprints/fetch_bi_detail")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchBiDetailByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchBiDetail(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"迭代" },  notes = "Sprint-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_bi_search-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_bi_search')")
    @PostMapping("projects/{projectId}/sprints/fetch_bi_search")
    public Mono<ResponseEntity<List<SprintBiSearchGroupDTO>>> fetchBiSearchByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchBiSearch(context) ;
        List<SprintBiSearchGroupDTO> list = sprintBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_move 迭代
    * 确认迭代完成时，选择移动至其他迭代
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_move", tags = {"迭代" },  notes = "Sprint-fetch_choose_move 确认迭代完成时，选择移动至其他迭代")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_choose_move-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_choose_move')")
    @PostMapping("projects/{projectId}/sprints/fetch_choose_move")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchChooseMoveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchChooseMove(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_sprint_relation 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_sprint_relation", tags = {"迭代" },  notes = "Sprint-fetch_choose_sprint_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_choose_sprint_relation-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_choose_sprint_relation')")
    @PostMapping("projects/{projectId}/sprints/fetch_choose_sprint_relation")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchChooseSprintRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchChooseSprintRelation(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_sprint_not_finish 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_sprint_not_finish", tags = {"迭代" },  notes = "Sprint-fetch_cur_sprint_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_cur_sprint_not_finish-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_cur_sprint_not_finish')")
    @PostMapping("projects/{projectId}/sprints/fetch_cur_sprint_not_finish")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchCurSprintNotFinishByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchCurSprintNotFinish(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"迭代" },  notes = "Sprint-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_default')")
    @PostMapping("projects/{projectId}/sprints/fetch_default")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchDefault(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_finish 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_finish", tags = {"迭代" },  notes = "Sprint-fetch_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_not_finish-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_not_finish')")
    @PostMapping("projects/{projectId}/sprints/fetch_not_finish")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchNotFinishByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchNotFinish(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"迭代" },  notes = "Sprint-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_reader-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_reader')")
    @PostMapping("projects/{projectId}/sprints/fetch_reader")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchReaderByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchReader(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_relation 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<SprintDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_relation", tags = {"迭代" },  notes = "Sprint-fetch_release_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_release_relation-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_release_relation')")
    @PostMapping("projects/{projectId}/sprints/fetch_release_relation")
    public Mono<ResponseEntity<List<SprintDTO>>> fetchReleaseRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchReleaseRelation(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建迭代
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Create-all')")
    @ApiOperation(value = "批量新建迭代", tags = {"迭代" },  notes = "批量新建迭代")
	@PostMapping("sprints/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<SprintDTO> dtos) {
        sprintService.create(sprintDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除迭代
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Remove-all')")
    @ApiOperation(value = "批量删除迭代", tags = {"迭代" },  notes = "批量删除迭代")
	@DeleteMapping("sprints/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        sprintService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新迭代
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Update-all')")
    @ApiOperation(value = "批量更新迭代", tags = {"迭代" },  notes = "批量更新迭代")
	@PutMapping("sprints/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<SprintDTO> dtos) {
        sprintService.update(sprintDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存迭代
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Save-all')")
    @ApiOperation(value = "批量保存迭代", tags = {"迭代" },  notes = "批量保存迭代")
	@PostMapping("sprints/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<SprintDTO> dtos) {
        sprintService.save(sprintDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入迭代
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Save-all')")
    @ApiOperation(value = "批量导入迭代", tags = {"迭代" },  notes = "批量导入迭代")
	@PostMapping("sprints/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SprintDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(sprintService.importData(config,ignoreError,sprintDtoMapping.toDomain(dtos))));
    }

}
