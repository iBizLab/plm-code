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
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.service.ReleaseService;
import cn.ibizlab.plm.core.projmgmt.filter.ReleaseSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Release] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReleaseResource {

    @Autowired
    public ReleaseService releaseService;

    @Autowired
    @Lazy
    public ReleaseBiSearchGroupDTOMapping releaseBiSearchGroupDtoMapping;

    @Autowired
    @Lazy
    public ReleaseDTOMapping releaseDtoMapping;

    @Autowired
    @Lazy
    public ReleaseFilterDTOMapping releaseFilterDtoMapping;

    /**
    * 创建Create 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"项目发布" },  notes = "Release-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Create-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Create')")
    @PostMapping("releases")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>create
            (@Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO create
            (ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        releaseService.create(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目发布
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"项目发布" },  notes = "Release-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Update-all') or hasPermission(this.releaseService.get(#id),'ibizplm-Release-Update')")
    @VersionCheck(entity = "release" , versionfield = "updateTime")
    @PutMapping("releases/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 项目发布
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO updateById
            (String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        releaseService.update(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * change_draft 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "change_draft", tags = {"项目发布" },  notes = "Release-change_draft ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-change_draft-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-change_draft')")
    @PostMapping("releases/change_draft")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>changeDraft
            (@Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(changeDraft(item)));
        else
            rt.set(changeDraft(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_draft 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO changeDraft
            (ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        Release rt = releaseService.changeDraft(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * change_stage 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "change_stage", tags = {"项目发布" },  notes = "Release-change_stage ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-change_stage-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-change_stage')")
    @PostMapping("releases/change_stage")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>changeStage
            (@Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(changeStage(item)));
        else
            rt.set(changeStage(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_stage 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO changeStage
            (ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        Release rt = releaseService.changeStage(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * del_relation 项目发布
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "del_relation", tags = {"项目发布" },  notes = "Release-del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-del_relation-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-del_relation')")
    @PostMapping("releases/{id}/del_relation")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * del_relation 项目发布
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO delRelationById
            (String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        Release rt = releaseService.delRelation(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"项目发布" },  notes = "Release-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-delete_categories-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-delete_categories')")
    @PostMapping("releases/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>deleteCategories
            (@Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(deleteCategories(item)));
        else
            rt.set(deleteCategories(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO deleteCategories
            (ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        Release rt = releaseService.deleteCategories(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * plan_work_item 项目发布
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "plan_work_item", tags = {"项目发布" },  notes = "Release-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-plan_work_item-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-plan_work_item')")
    @PutMapping("releases/{id}/plan_work_item")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>planWorkItemById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_work_item 项目发布
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO planWorkItemById
            (String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        Release rt = releaseService.planWorkItem(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * release_relation_sprint 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "release_relation_sprint", tags = {"项目发布" },  notes = "Release-release_relation_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-release_relation_sprint-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-release_relation_sprint')")
    @PostMapping("releases/release_relation_sprint")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>releaseRelationSprint
            (@Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(releaseRelationSprint(item)));
        else
            rt.set(releaseRelationSprint(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * release_relation_sprint 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO releaseRelationSprint
            (ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        Release rt = releaseService.releaseRelationSprint(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"项目发布" },  notes = "Release-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Save-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Save')")
    @PostMapping("releases/save")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>save
            (@Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO save
            (ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        releaseService.save(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"项目发布" },  notes = "Release-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Create-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Create')")
    @PostMapping("projects/{projectId}/releases")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO createByProjectId
            (String projectId, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        releaseService.create(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"项目发布" },  notes = "Release-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Update-all') or hasPermission('project',#projectId,this.releaseService.get(#id),'ibizplm-Release-Update')")
    @VersionCheck(entity = "release" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/releases/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO updateByProjectIdAndId
            (String projectId, String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        releaseService.update(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * change_draft 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "change_draft", tags = {"项目发布" },  notes = "Release-change_draft ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-change_draft-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-change_draft')")
    @PostMapping("projects/{projectId}/releases/change_draft")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>changeDraftByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(changeDraftByProjectId(projectId, item)));
        else
            rt.set(changeDraftByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_draft 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO changeDraftByProjectId
            (String projectId, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Release rt = releaseService.changeDraft(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * change_stage 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "change_stage", tags = {"项目发布" },  notes = "Release-change_stage ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-change_stage-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-change_stage')")
    @PostMapping("projects/{projectId}/releases/change_stage")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>changeStageByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(changeStageByProjectId(projectId, item)));
        else
            rt.set(changeStageByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_stage 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO changeStageByProjectId
            (String projectId, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Release rt = releaseService.changeStage(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * del_relation 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "del_relation", tags = {"项目发布" },  notes = "Release-del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-del_relation-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-del_relation')")
    @PostMapping("projects/{projectId}/releases/{id}/del_relation")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>delRelationByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * del_relation 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO delRelationByProjectIdAndId
            (String projectId, String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        Release rt = releaseService.delRelation(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"项目发布" },  notes = "Release-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-delete_categories-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-delete_categories')")
    @PostMapping("projects/{projectId}/releases/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>deleteCategoriesByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(deleteCategoriesByProjectId(projectId, item)));
        else
            rt.set(deleteCategoriesByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO deleteCategoriesByProjectId
            (String projectId, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Release rt = releaseService.deleteCategories(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * plan_work_item 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "plan_work_item", tags = {"项目发布" },  notes = "Release-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-plan_work_item-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-plan_work_item')")
    @PutMapping("projects/{projectId}/releases/{id}/plan_work_item")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>planWorkItemByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_work_item 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO planWorkItemByProjectIdAndId
            (String projectId, String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        Release rt = releaseService.planWorkItem(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * release_relation_sprint 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "release_relation_sprint", tags = {"项目发布" },  notes = "Release-release_relation_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-release_relation_sprint-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-release_relation_sprint')")
    @PostMapping("projects/{projectId}/releases/release_relation_sprint")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>releaseRelationSprintByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(releaseRelationSprintByProjectId(projectId, item)));
        else
            rt.set(releaseRelationSprintByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * release_relation_sprint 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO releaseRelationSprintByProjectId
            (String projectId, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Release rt = releaseService.releaseRelationSprint(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"项目发布" },  notes = "Release-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Save-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Save')")
    @PostMapping("projects/{projectId}/releases/save")
    public Mono<ResponseEntity<ResponseWrapper<ReleaseDTO>>>saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO saveByProjectId
            (String projectId, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        releaseService.save(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 项目发布
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"项目发布" },  notes = "Release-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Get-all')  or hasPermission(this.releaseDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Release-Get')")
    @GetMapping("releases/{id}")
    public Mono<ResponseEntity<ReleaseDTO>> getById
            (@PathVariable("id") String id) {
        Release rt = releaseService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 项目发布
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目发布" },  notes = "Release-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Remove-all') or hasPermission(this.releaseService.get(#id),'ibizplm-Release-Remove')")
    @DeleteMapping("releases/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = releaseService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * cal_release_work_item_num 项目发布
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "cal_release_work_item_num", tags = {"项目发布" },  notes = "Release-cal_release_work_item_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-cal_release_work_item_num-all') or hasPermission(this.releaseService.get(#id),'ibizplm-Release-cal_release_work_item_num')")
    @GetMapping("releases/{id}/cal_release_work_item_num")
    public Mono<ResponseEntity<ReleaseDTO>> calReleaseWorkItemNumById
            (@PathVariable("id") String id) {
        Release rt = releaseService.calReleaseWorkItemNum(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt)));
    }

    /**
    * 校验CheckKey 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目发布" },  notes = "Release-CheckKey ")
    @PostMapping("releases/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        CheckKeyStatus rt = releaseService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目发布" },  notes = "Release-GetDraft ")
    @GetMapping("releases/get_draft")
    public Mono<ResponseEntity<ReleaseDTO>> getDraft
            (@SpringQueryMap ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        Release rt = releaseService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_detail 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"项目发布" },  notes = "Release-fetch_bi_detail ")
    @PostMapping("releases/fetch_bi_detail")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchBiDetail
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchBiDetail(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"项目发布" },  notes = "Release-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-Release-fetch_bi_search')")
    @PostMapping("releases/fetch_bi_search")
    public Mono<ResponseEntity<List<ReleaseBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchBiSearch(context) ;
        List<ReleaseBiSearchGroupDTO> list = releaseBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_relese_relation 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_relese_relation", tags = {"项目发布" },  notes = "Release-fetch_choose_relese_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_choose_relese_relation-all') or hasPermission(#dto,'ibizplm-Release-fetch_choose_relese_relation')")
    @PostMapping("releases/fetch_choose_relese_relation")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchChooseReleseRelation
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchChooseReleseRelation(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"项目发布" },  notes = "Release-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_default-all') or hasPermission(#dto,'ibizplm-Release-fetch_default')")
    @PostMapping("releases/fetch_default")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchDefault
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchDefault(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_published 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_published", tags = {"项目发布" },  notes = "Release-fetch_not_published ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_not_published-all') or hasPermission(#dto,'ibizplm-Release-fetch_not_published')")
    @PostMapping("releases/fetch_not_published")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchNotPublished
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchNotPublished(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_product_re_project_published 项目发布
    * 产品所关联项目中的已发布
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_product_re_project_published", tags = {"项目发布" },  notes = "Release-fetch_product_re_project_published 产品所关联项目中的已发布")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_product_re_project_published-all') or hasPermission(#dto,'ibizplm-Release-fetch_product_re_project_published')")
    @PostMapping("releases/fetch_product_re_project_published")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchProductReProjectPublished
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchProductReProjectPublished(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_published 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_published", tags = {"项目发布" },  notes = "Release-fetch_published ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_published-all') or hasPermission(#dto,'ibizplm-Release-fetch_published')")
    @PostMapping("releases/fetch_published")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchPublished
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchPublished(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"项目发布" },  notes = "Release-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_reader-all') or hasPermission(#dto,'ibizplm-Release-fetch_reader')")
    @PostMapping("releases/fetch_reader")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchReader
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchReader(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_relation 项目发布
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_relation", tags = {"项目发布" },  notes = "Release-fetch_sprint_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_sprint_relation-all') or hasPermission(#dto,'ibizplm-Release-fetch_sprint_relation')")
    @PostMapping("releases/fetch_sprint_relation")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchSprintRelation
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchSprintRelation(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"项目发布" },  notes = "Release-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Get-all')  or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Release-Get')")
    @GetMapping("projects/{projectId}/releases/{id}")
    public Mono<ResponseEntity<ReleaseDTO>> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Release rt = releaseService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目发布" },  notes = "Release-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Remove-all') or hasPermission('project',#projectId,this.releaseService.get(#id),'ibizplm-Release-Remove')")
    @DeleteMapping("projects/{projectId}/releases/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = releaseService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * cal_release_work_item_num 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "cal_release_work_item_num", tags = {"项目发布" },  notes = "Release-cal_release_work_item_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-cal_release_work_item_num-all') or hasPermission('project',#projectId,this.releaseService.get(#id),'ibizplm-Release-cal_release_work_item_num')")
    @GetMapping("projects/{projectId}/releases/{id}/cal_release_work_item_num")
    public Mono<ResponseEntity<ReleaseDTO>> calReleaseWorkItemNumByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Release rt = releaseService.calReleaseWorkItemNum(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt)));
    }

    /**
    * 校验CheckKey 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目发布" },  notes = "Release-CheckKey ")
    @PostMapping("projects/{projectId}/releases/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        CheckKeyStatus rt = releaseService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<ReleaseDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目发布" },  notes = "Release-GetDraft ")
    @GetMapping("projects/{projectId}/releases/get_draft")
    public Mono<ResponseEntity<ReleaseDTO>> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Release rt = releaseService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_detail 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"项目发布" },  notes = "Release-fetch_bi_detail ")
    @PostMapping("projects/{projectId}/releases/fetch_bi_detail")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchBiDetailByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchBiDetail(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"项目发布" },  notes = "Release-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_bi_search-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_bi_search')")
    @PostMapping("projects/{projectId}/releases/fetch_bi_search")
    public Mono<ResponseEntity<List<ReleaseBiSearchGroupDTO>>> fetchBiSearchByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchBiSearch(context) ;
        List<ReleaseBiSearchGroupDTO> list = releaseBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_relese_relation 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_relese_relation", tags = {"项目发布" },  notes = "Release-fetch_choose_relese_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_choose_relese_relation-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_choose_relese_relation')")
    @PostMapping("projects/{projectId}/releases/fetch_choose_relese_relation")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchChooseReleseRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchChooseReleseRelation(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"项目发布" },  notes = "Release-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_default')")
    @PostMapping("projects/{projectId}/releases/fetch_default")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchDefault(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_published 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_published", tags = {"项目发布" },  notes = "Release-fetch_not_published ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_not_published-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_not_published')")
    @PostMapping("projects/{projectId}/releases/fetch_not_published")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchNotPublishedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchNotPublished(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_product_re_project_published 项目发布
    * 产品所关联项目中的已发布
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_product_re_project_published", tags = {"项目发布" },  notes = "Release-fetch_product_re_project_published 产品所关联项目中的已发布")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_product_re_project_published-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_product_re_project_published')")
    @PostMapping("projects/{projectId}/releases/fetch_product_re_project_published")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchProductReProjectPublishedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchProductReProjectPublished(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_published 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_published", tags = {"项目发布" },  notes = "Release-fetch_published ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_published-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_published')")
    @PostMapping("projects/{projectId}/releases/fetch_published")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchPublishedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchPublished(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"项目发布" },  notes = "Release-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_reader-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_reader')")
    @PostMapping("projects/{projectId}/releases/fetch_reader")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchReaderByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchReader(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_relation 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReleaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_relation", tags = {"项目发布" },  notes = "Release-fetch_sprint_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_sprint_relation-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_sprint_relation')")
    @PostMapping("projects/{projectId}/releases/fetch_sprint_relation")
    public Mono<ResponseEntity<List<ReleaseDTO>>> fetchSprintRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.fetchSprintRelation(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建项目发布
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Create-all')")
    @ApiOperation(value = "批量新建项目发布", tags = {"项目发布" },  notes = "批量新建项目发布")
	@PostMapping("releases/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ReleaseDTO> dtos) {
        releaseService.create(releaseDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除项目发布
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Remove-all')")
    @ApiOperation(value = "批量删除项目发布", tags = {"项目发布" },  notes = "批量删除项目发布")
	@DeleteMapping("releases/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        releaseService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新项目发布
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Update-all')")
    @ApiOperation(value = "批量更新项目发布", tags = {"项目发布" },  notes = "批量更新项目发布")
	@PutMapping("releases/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ReleaseDTO> dtos) {
        releaseService.update(releaseDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存项目发布
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Save-all')")
    @ApiOperation(value = "批量保存项目发布", tags = {"项目发布" },  notes = "批量保存项目发布")
	@PostMapping("releases/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ReleaseDTO> dtos) {
        releaseService.save(releaseDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入项目发布
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Save-all')")
    @ApiOperation(value = "批量导入项目发布", tags = {"项目发布" },  notes = "批量导入项目发布")
	@PostMapping("releases/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ReleaseDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(releaseService.importData(config,ignoreError,releaseDtoMapping.toDomain(dtos))));
    }

}
