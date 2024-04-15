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
import cn.ibizlab.plm.serviceapi.dto.*;
import cn.ibizlab.plm.serviceapi.mapping.*;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Project] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectResource {

    @Autowired
    public ProjectService projectService;

    @Autowired
    @Lazy
    public ProjectDTOMapping projectDtoMapping;

    @Autowired
    @Lazy
    public ProjectFilterDTOMapping projectFilterDtoMapping;

    @Autowired
    @Lazy
    public ProjectRedirctDefGroupDTOMapping projectRedirctDefGroupDtoMapping;

    /**
    * 创建Create 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"项目" },  notes = "Project-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-Create-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-Create')")
    @PostMapping("projects")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> create
            (@Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO create
            (ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        projectService.create(domain);
        Project rt = domain;
        return projectDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"项目" },  notes = "Project-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-Update-all') or hasPermission(this.projectService.get(#id),'ibizplm-Project-Update')")
    @VersionCheck(entity = "project" , versionfield = "updateTime")
    @PutMapping("projects/{id}")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO updateById
            (String id, ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        domain.setId(id);
        projectService.update(domain);
        Project rt = domain;
        return projectDtoMapping.toDto(rt);
    }

    /**
    * activate 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "activate", tags = {"项目" },  notes = "Project-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-activate-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-activate')")
    @PostMapping("projects/{id}/activate")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * activate 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO activateById
            (String id, ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        domain.setId(id);
        Project rt = projectService.activate(domain);
        return projectDtoMapping.toDto(rt);
    }

    /**
    * archive 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "archive", tags = {"项目" },  notes = "Project-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-archive-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-archive')")
    @PostMapping("projects/{id}/archive")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * archive 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO archiveById
            (String id, ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        domain.setId(id);
        Project rt = projectService.archive(domain);
        return projectDtoMapping.toDto(rt);
    }

    /**
    * delete 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "delete", tags = {"项目" },  notes = "Project-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-delete-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-delete')")
    @PostMapping("projects/{id}/delete")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO deleteById
            (String id, ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        domain.setId(id);
        Project rt = projectService.delete(domain);
        return projectDtoMapping.toDto(rt);
    }

    /**
    * favorite 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "favorite", tags = {"项目" },  notes = "Project-favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-favorite-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-favorite')")
    @PostMapping("projects/{id}/favorite")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * favorite 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO favoriteById
            (String id, ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        domain.setId(id);
        Project rt = projectService.favorite(domain);
        return projectDtoMapping.toDto(rt);
    }

    /**
    * other_re_space 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "other_re_space", tags = {"项目" },  notes = "Project-other_re_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-other_re_space-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-other_re_space')")
    @PutMapping("projects/{id}/other_re_space")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> otherReSpaceById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherReSpaceById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherReSpaceById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * other_re_space 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO otherReSpaceById
            (String id, ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        domain.setId(id);
        Project rt = projectService.otherReSpace(domain);
        return projectDtoMapping.toDto(rt);
    }

    /**
    * recover 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "recover", tags = {"项目" },  notes = "Project-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-recover-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-recover')")
    @PostMapping("projects/{id}/recover")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * recover 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO recoverById
            (String id, ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        domain.setId(id);
        Project rt = projectService.recover(domain);
        return projectDtoMapping.toDto(rt);
    }

    /**
    * remove_from_project_set 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "remove_from_project_set", tags = {"项目" },  notes = "Project-remove_from_project_set ")
    @PostMapping("projects/remove_from_project_set")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> removeFromProjectSet
            (@Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(removeFromProjectSet(item)));
        else
            rt.set(removeFromProjectSet(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * remove_from_project_set 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO removeFromProjectSet
            (ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        Project rt = projectService.removeFromProjectSet(domain);
        return projectDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"项目" },  notes = "Project-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-Save-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-Save')")
    @PostMapping("projects/save")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> save
            (@Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO save
            (ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        projectService.save(domain);
        Project rt = domain;
        return projectDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "un_favorite", tags = {"项目" },  notes = "Project-un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-un_favorite-all') or hasPermission(this.projectDtoMapping.toDomain(#dto),'ibizplm-Project-un_favorite')")
    @PostMapping("projects/{id}/un_favorite")
    public ResponseEntity<ResponseWrapper<ProjectDTO>> unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectDTO> dto) {
        ResponseWrapper<ProjectDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * un_favorite 项目
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */   
    public ProjectDTO unFavoriteById
            (String id, ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        domain.setId(id);
        Project rt = projectService.unFavorite(domain);
        return projectDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 项目
    * 
    *
    * @param id id
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"项目" },  notes = "Project-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-Get-all')  or hasPermission(this.projectDtoMapping.toDomain(returnObject.body),'ibizplm-Project-Get')")
    @GetMapping("projects/{id}")
    public ResponseEntity<ProjectDTO> getById
            (@PathVariable("id") String id) {
        Project rt = projectService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(projectDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 项目
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目" },  notes = "Project-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-Remove-all') or hasPermission(this.projectService.get(#id),'ibizplm-Project-Remove')")
    @DeleteMapping("projects/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = projectService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目" },  notes = "Project-CheckKey ")
    @PostMapping("projects/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        Integer rt = projectService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目" },  notes = "Project-GetDraft ")
    @GetMapping("projects/get_draft")
    public ResponseEntity<ProjectDTO> getDraft
            (@SpringQueryMap ProjectDTO dto) {
        Project domain = projectDtoMapping.toDomain(dto);
        Project rt = projectService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(projectDtoMapping.toDto(rt));
    }

    /**
    * get_major_data 项目
    * 
    *
    * @param id id
    * @return ResponseEntity<ProjectRedirctDefGroupDTO>
    */
    @ApiOperation(value = "get_major_data", tags = {"项目" },  notes = "Project-get_major_data ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-get_major_data-all') or hasPermission(this.projectService.get(#id),'ibizplm-Project-get_major_data')")
    @GetMapping("projects/{id}/get_major_data")
    public ResponseEntity<ProjectRedirctDefGroupDTO> getMajorDataById
            (@PathVariable("id") String id) {
        Project rt = projectService.getMajorData(id);
        return ResponseEntity.status(HttpStatus.OK).body(projectRedirctDefGroupDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_admin 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"项目" },  notes = "Project-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_admin-all') or hasPermission(#dto,'ibizplm-Project-fetch_admin')")
    @PostMapping("projects/fetch_admin")
    public ResponseEntity<List<ProjectDTO>> fetchAdmin
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchAdmin(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_archived 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"项目" },  notes = "Project-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_archived-all') or hasPermission(#dto,'ibizplm-Project-fetch_archived')")
    @PostMapping("projects/fetch_archived")
    public ResponseEntity<List<ProjectDTO>> fetchArchived
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchArchived(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_choose_project 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_choose_project", tags = {"项目" },  notes = "Project-fetch_choose_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_choose_project-all') or hasPermission(#dto,'ibizplm-Project-fetch_choose_project')")
    @PostMapping("projects/fetch_choose_project")
    public ResponseEntity<List<ProjectDTO>> fetchChooseProject
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchChooseProject(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_current 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_current", tags = {"项目" },  notes = "Project-fetch_current ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_current-all') or hasPermission(#dto,'ibizplm-Project-fetch_current')")
    @PostMapping("projects/fetch_current")
    public ResponseEntity<List<ProjectDTO>> fetchCurrent
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchCurrent(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"项目" },  notes = "Project-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_default-all') or hasPermission(#dto,'ibizplm-Project-fetch_default')")
    @PostMapping("projects/fetch_default")
    public ResponseEntity<List<ProjectDTO>> fetchDefault
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchDefault(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_deleted 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"项目" },  notes = "Project-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_deleted-all') or hasPermission(#dto,'ibizplm-Project-fetch_deleted')")
    @PostMapping("projects/fetch_deleted")
    public ResponseEntity<List<ProjectDTO>> fetchDeleted
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchDeleted(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_favorite 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_favorite", tags = {"项目" },  notes = "Project-fetch_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_favorite-all') or hasPermission(#dto,'ibizplm-Project-fetch_favorite')")
    @PostMapping("projects/fetch_favorite")
    public ResponseEntity<List<ProjectDTO>> fetchFavorite
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchFavorite(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"项目" },  notes = "Project-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_normal-all') or hasPermission(#dto,'ibizplm-Project-fetch_normal')")
    @PostMapping("projects/fetch_normal")
    public ResponseEntity<List<ProjectDTO>> fetchNormal
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchNormal(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_reader 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"项目" },  notes = "Project-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_reader-all') or hasPermission(#dto,'ibizplm-Project-fetch_reader')")
    @PostMapping("projects/fetch_reader")
    public ResponseEntity<List<ProjectDTO>> fetchReader
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchReader(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_same_type 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_same_type", tags = {"项目" },  notes = "Project-fetch_same_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_same_type-all') or hasPermission(#dto,'ibizplm-Project-fetch_same_type')")
    @PostMapping("projects/fetch_same_type")
    public ResponseEntity<List<ProjectDTO>> fetchSameType
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchSameType(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_under_project_portfolio 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_under_project_portfolio", tags = {"项目" },  notes = "Project-fetch_under_project_portfolio ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_under_project_portfolio-all') or hasPermission(#dto,'ibizplm-Project-fetch_under_project_portfolio')")
    @PostMapping("projects/fetch_under_project_portfolio")
    public ResponseEntity<List<ProjectDTO>> fetchUnderProjectPortfolio
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchUnderProjectPortfolio(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_user 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"项目" },  notes = "Project-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_user-all') or hasPermission(#dto,'ibizplm-Project-fetch_user')")
    @PostMapping("projects/fetch_user")
    public ResponseEntity<List<ProjectDTO>> fetchUser
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchUser(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_project 项目
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectDTO>>
    */
    @ApiOperation(value = "查询fetch_work_project", tags = {"项目" },  notes = "Project-fetch_work_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Project-fetch_work_project-all') or hasPermission(#dto,'ibizplm-Project-fetch_work_project')")
    @PostMapping("projects/fetch_work_project")
    public ResponseEntity<List<ProjectDTO>> fetchWorkProject
            (@Validated @RequestBody ProjectFilterDTO dto) {
        ProjectSearchContext context = projectFilterDtoMapping.toDomain(dto);
        Page<Project> domains = projectService.searchWorkProject(context) ;
        List<ProjectDTO> list = projectDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建项目
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Project-Create-all')")
    @ApiOperation(value = "批量新建项目", tags = {"项目" },  notes = "批量新建项目")
	@PostMapping("projects/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ProjectDTO> dtos) {
        projectService.createBatch(projectDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除项目
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Project-Remove-all')")
    @ApiOperation(value = "批量删除项目", tags = {"项目" },  notes = "批量删除项目")
	@DeleteMapping("projects/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        projectService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新项目
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Project-Update-all')")
    @ApiOperation(value = "批量更新项目", tags = {"项目" },  notes = "批量更新项目")
	@PutMapping("projects/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ProjectDTO> dtos) {
        projectService.updateBatch(projectDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存项目
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Project-Save-all')")
    @ApiOperation(value = "批量保存项目", tags = {"项目" },  notes = "批量保存项目")
	@PostMapping("projects/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ProjectDTO> dtos) {
        projectService.saveBatch(projectDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入项目
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Project-Save-all')")
    @ApiOperation(value = "批量导入项目", tags = {"项目" },  notes = "批量导入项目")
	@PostMapping("projects/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProjectDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(projectService.importData(config,ignoreError,projectDtoMapping.toDomain(dtos)));
    }

}
