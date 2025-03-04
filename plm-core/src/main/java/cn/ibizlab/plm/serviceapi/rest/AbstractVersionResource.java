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
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.service.VersionService;
import cn.ibizlab.plm.core.base.filter.VersionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Version] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractVersionResource {

    @Autowired
    public VersionService versionService;

    @Autowired
    @Lazy
    public VersionDTOMapping versionDtoMapping;

    @Autowired
    @Lazy
    public VersionFilterDTOMapping versionFilterDtoMapping;

    /**
    * 创建Create 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"版本" },  notes = "Version-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Create-all') or hasPermission(this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Create')")
    @PostMapping("versions")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>create
            (@Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO create
            (VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        versionService.create(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 版本
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"版本" },  notes = "Version-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Update-all') or hasPermission(this.versionService.get(#id),'ibizplm-Version-Update')")
    @VersionCheck(entity = "version" , versionfield = "updateTime")
    @PutMapping("versions/{id}")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 版本
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO updateById
            (String id, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setId(id);
        versionService.update(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * Commit 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "Commit", tags = {"版本" },  notes = "Version-Commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Commit-all') or hasPermission(this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Commit')")
    @PostMapping("versions/commit")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>commit
            (@Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(commit(item)));
        else
            rt.set(commit(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * Commit 版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO commit
            (VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        Version rt = versionService.commit(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * fix_commit 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "fix_commit", tags = {"版本" },  notes = "Version-fix_commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fix_commit-all') or hasPermission(this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-fix_commit')")
    @PostMapping("versions/fix_commit")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>fixCommit
            (@Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fixCommit(item)));
        else
            rt.set(fixCommit(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fix_commit 版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO fixCommit
            (VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        Version rt = versionService.fixCommit(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * Restore 版本
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "Restore", tags = {"版本" },  notes = "Version-Restore ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Restore-all') or hasPermission(this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Restore')")
    @PostMapping("versions/{id}/restore")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>restoreById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * Restore 版本
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO restoreById
            (String id, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setId(id);
        Version rt = versionService.restore(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"版本" },  notes = "Version-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Save-all') or hasPermission(this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Save')")
    @PostMapping("versions/save")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>save
            (@Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO save
            (VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        versionService.save(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"版本" },  notes = "Version-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Create-all') or hasPermission('work_item',#ownerId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Create')")
    @PostMapping("work_items/{ownerId}/versions")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO createByOwnerId
            (String ownerId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        versionService.create(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"版本" },  notes = "Version-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Update-all') or hasPermission('work_item',#ownerId,this.versionService.get(#id),'ibizplm-Version-Update')")
    @VersionCheck(entity = "version" , versionfield = "updateTime")
    @PutMapping("work_items/{ownerId}/versions/{id}")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO updateByOwnerIdAndId
            (String ownerId, String id, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setId(id);
        versionService.update(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * Commit 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "Commit", tags = {"版本" },  notes = "Version-Commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Commit-all') or hasPermission('work_item',#ownerId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Commit')")
    @PostMapping("work_items/{ownerId}/versions/commit")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>commitByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(commitByOwnerId(ownerId, item)));
        else
            rt.set(commitByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * Commit 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO commitByOwnerId
            (String ownerId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Version rt = versionService.commit(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * fix_commit 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "fix_commit", tags = {"版本" },  notes = "Version-fix_commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fix_commit-all') or hasPermission('work_item',#ownerId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-fix_commit')")
    @PostMapping("work_items/{ownerId}/versions/fix_commit")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>fixCommitByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fixCommitByOwnerId(ownerId, item)));
        else
            rt.set(fixCommitByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fix_commit 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO fixCommitByOwnerId
            (String ownerId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Version rt = versionService.fixCommit(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * Restore 版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "Restore", tags = {"版本" },  notes = "Version-Restore ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Restore-all') or hasPermission('work_item',#ownerId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Restore')")
    @PostMapping("work_items/{ownerId}/versions/{id}/restore")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>restoreByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * Restore 版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO restoreByOwnerIdAndId
            (String ownerId, String id, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setId(id);
        Version rt = versionService.restore(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"版本" },  notes = "Version-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Save-all') or hasPermission('work_item',#ownerId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Save')")
    @PostMapping("work_items/{ownerId}/versions/save")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO saveByOwnerId
            (String ownerId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        versionService.save(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"版本" },  notes = "Version-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Create-all') or hasPermission('project',#projectId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Create')")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>createByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectIdAndOwnerId(projectId, ownerId, item)));
        else
            rt.set(createByProjectIdAndOwnerId(projectId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO createByProjectIdAndOwnerId
            (String projectId, String ownerId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        versionService.create(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"版本" },  notes = "Version-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Update-all') or hasPermission('project',#projectId,this.versionService.get(#id),'ibizplm-Version-Update')")
    @VersionCheck(entity = "version" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/work_items/{ownerId}/versions/{id}")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>updateByProjectIdAndOwnerIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndOwnerIdAndId(projectId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndOwnerIdAndId(projectId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO updateByProjectIdAndOwnerIdAndId
            (String projectId, String ownerId, String id, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setId(id);
        versionService.update(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * Commit 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "Commit", tags = {"版本" },  notes = "Version-Commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Commit-all') or hasPermission('project',#projectId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Commit')")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions/commit")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>commitByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(commitByProjectIdAndOwnerId(projectId, ownerId, item)));
        else
            rt.set(commitByProjectIdAndOwnerId(projectId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * Commit 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO commitByProjectIdAndOwnerId
            (String projectId, String ownerId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Version rt = versionService.commit(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * fix_commit 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "fix_commit", tags = {"版本" },  notes = "Version-fix_commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fix_commit-all') or hasPermission('project',#projectId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-fix_commit')")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions/fix_commit")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>fixCommitByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fixCommitByProjectIdAndOwnerId(projectId, ownerId, item)));
        else
            rt.set(fixCommitByProjectIdAndOwnerId(projectId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fix_commit 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO fixCommitByProjectIdAndOwnerId
            (String projectId, String ownerId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Version rt = versionService.fixCommit(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * Restore 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "Restore", tags = {"版本" },  notes = "Version-Restore ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Restore-all') or hasPermission('project',#projectId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Restore')")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions/{id}/restore")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>restoreByProjectIdAndOwnerIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreByProjectIdAndOwnerIdAndId(projectId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreByProjectIdAndOwnerIdAndId(projectId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * Restore 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO restoreByProjectIdAndOwnerIdAndId
            (String projectId, String ownerId, String id, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setId(id);
        Version rt = versionService.restore(domain);
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"版本" },  notes = "Version-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Save-all') or hasPermission('project',#projectId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Save')")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions/save")
    public Mono<ResponseEntity<ResponseWrapper<VersionDTO>>>saveByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectIdAndOwnerId(projectId, ownerId, item)));
        else
            rt.set(saveByProjectIdAndOwnerId(projectId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO saveByProjectIdAndOwnerId
            (String projectId, String ownerId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        versionService.save(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 版本
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"版本" },  notes = "Version-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Get-all')  or hasPermission(this.versionDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Version-Get')")
    @GetMapping("versions/{id}")
    public Mono<ResponseEntity<VersionDTO>> getById
            (@PathVariable("id") String id) {
        Version rt = versionService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 版本
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"版本" },  notes = "Version-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Remove-all') or hasPermission(this.versionService.get(#id),'ibizplm-Version-Remove')")
    @DeleteMapping("versions/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = versionService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"版本" },  notes = "Version-CheckKey ")
    @PostMapping("versions/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        CheckKeyStatus rt = versionService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"版本" },  notes = "Version-GetDraft ")
    @GetMapping("versions/get_draft")
    public Mono<ResponseEntity<VersionDTO>> getDraft
            (@SpringQueryMap VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        Version rt = versionService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"版本" },  notes = "Version-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_default-all') or hasPermission(#dto,'ibizplm-Version-fetch_default')")
    @PostMapping("versions/fetch_default")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchDefault
            (@Validated @RequestBody VersionFilterDTO dto) {
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchDefault(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_name_version 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_name_version", tags = {"版本" },  notes = "Version-fetch_name_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_name_version-all') or hasPermission(#dto,'ibizplm-Version-fetch_name_version')")
    @PostMapping("versions/fetch_name_version")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchNameVersion
            (@Validated @RequestBody VersionFilterDTO dto) {
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchNameVersion(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_owner 版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_owner", tags = {"版本" },  notes = "Version-fetch_owner ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_owner-all') or hasPermission(#dto,'ibizplm-Version-fetch_owner')")
    @PostMapping("versions/fetch_owner")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchOwner
            (@Validated @RequestBody VersionFilterDTO dto) {
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchOwner(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"版本" },  notes = "Version-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Get-all')  or hasPermission('work_item',#ownerId,this.versionDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Version-Get')")
    @GetMapping("work_items/{ownerId}/versions/{id}")
    public Mono<ResponseEntity<VersionDTO>> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Version rt = versionService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"版本" },  notes = "Version-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Remove-all') or hasPermission('work_item',#ownerId,this.versionService.get(#id),'ibizplm-Version-Remove')")
    @DeleteMapping("work_items/{ownerId}/versions/{id}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = versionService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"版本" },  notes = "Version-CheckKey ")
    @PostMapping("work_items/{ownerId}/versions/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = versionService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"版本" },  notes = "Version-GetDraft ")
    @GetMapping("work_items/{ownerId}/versions/get_draft")
    public Mono<ResponseEntity<VersionDTO>> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Version rt = versionService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"版本" },  notes = "Version-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_default-all') or hasPermission('work_item',#ownerId,#dto,'ibizplm-Version-fetch_default')")
    @PostMapping("work_items/{ownerId}/versions/fetch_default")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody VersionFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchDefault(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_name_version 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_name_version", tags = {"版本" },  notes = "Version-fetch_name_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_name_version-all') or hasPermission('work_item',#ownerId,#dto,'ibizplm-Version-fetch_name_version')")
    @PostMapping("work_items/{ownerId}/versions/fetch_name_version")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchNameVersionByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody VersionFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchNameVersion(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_owner 版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_owner", tags = {"版本" },  notes = "Version-fetch_owner ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_owner-all') or hasPermission('work_item',#ownerId,#dto,'ibizplm-Version-fetch_owner')")
    @PostMapping("work_items/{ownerId}/versions/fetch_owner")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchOwnerByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody VersionFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchOwner(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"版本" },  notes = "Version-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Get-all')  or hasPermission('project',#projectId,this.versionDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Version-Get')")
    @GetMapping("projects/{projectId}/work_items/{ownerId}/versions/{id}")
    public Mono<ResponseEntity<VersionDTO>> getByProjectIdAndOwnerIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Version rt = versionService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"版本" },  notes = "Version-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Remove-all') or hasPermission('project',#projectId,this.versionService.get(#id),'ibizplm-Version-Remove')")
    @DeleteMapping("projects/{projectId}/work_items/{ownerId}/versions/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndOwnerIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = versionService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"版本" },  notes = "Version-CheckKey ")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = versionService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<VersionDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"版本" },  notes = "Version-GetDraft ")
    @GetMapping("projects/{projectId}/work_items/{ownerId}/versions/get_draft")
    public Mono<ResponseEntity<VersionDTO>> getDraftByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @SpringQueryMap VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Version rt = versionService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"版本" },  notes = "Version-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Version-fetch_default')")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions/fetch_default")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchDefaultByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody VersionFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchDefault(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_name_version 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_name_version", tags = {"版本" },  notes = "Version-fetch_name_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_name_version-all') or hasPermission('project',#projectId,#dto,'ibizplm-Version-fetch_name_version')")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions/fetch_name_version")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchNameVersionByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody VersionFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchNameVersion(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_owner 版本
    * 
    *
    * @param projectId projectId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<VersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_owner", tags = {"版本" },  notes = "Version-fetch_owner ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-fetch_owner-all') or hasPermission('project',#projectId,#dto,'ibizplm-Version-fetch_owner')")
    @PostMapping("projects/{projectId}/work_items/{ownerId}/versions/fetch_owner")
    public Mono<ResponseEntity<List<VersionDTO>>> fetchOwnerByProjectIdAndOwnerId
            (@PathVariable("projectId") String projectId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody VersionFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.fetchOwner(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建版本
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Create-all')")
    @ApiOperation(value = "批量新建版本", tags = {"版本" },  notes = "批量新建版本")
	@PostMapping("versions/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<VersionDTO> dtos) {
        versionService.create(versionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除版本
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Remove-all')")
    @ApiOperation(value = "批量删除版本", tags = {"版本" },  notes = "批量删除版本")
	@DeleteMapping("versions/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        versionService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新版本
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Update-all')")
    @ApiOperation(value = "批量更新版本", tags = {"版本" },  notes = "批量更新版本")
	@PutMapping("versions/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<VersionDTO> dtos) {
        versionService.update(versionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存版本
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Save-all')")
    @ApiOperation(value = "批量保存版本", tags = {"版本" },  notes = "批量保存版本")
	@PostMapping("versions/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<VersionDTO> dtos) {
        versionService.save(versionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入版本
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Save-all')")
    @ApiOperation(value = "批量导入版本", tags = {"版本" },  notes = "批量导入版本")
	@PostMapping("versions/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<VersionDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(versionService.importData(config,ignoreError,versionDtoMapping.toDomain(dtos))));
    }

}
