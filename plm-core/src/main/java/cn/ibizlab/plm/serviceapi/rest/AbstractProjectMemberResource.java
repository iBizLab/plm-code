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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.service.ProjectMemberService;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[ProjectMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectMemberResource {

    @Autowired
    public ProjectMemberService projectMemberService;

    @Autowired
    @Lazy
    public ProjectMemberDTOMapping projectMemberDtoMapping;

    @Autowired
    @Lazy
    public ProjectMemberFilterDTOMapping projectMemberFilterDtoMapping;

    /**
    * 创建Create 项目成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"项目成员" },  notes = "ProjectMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Create-all') or hasPermission(this.projectMemberDtoMapping.toDomain(#dto),'ibizplm-ProjectMember-Create')")
    @PostMapping("project_members")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> create
            (@Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 项目成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO create
            (ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        projectMemberService.create(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"项目成员" },  notes = "ProjectMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Update-all') or hasPermission(this.projectMemberService.get(#id),'ibizplm-ProjectMember-Update')")
    @VersionCheck(entity = "projectmember" , versionfield = "updateTime")
    @PutMapping("project_members/{id}")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 项目成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO updateById
            (String id, ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        projectMemberService.update(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"项目成员" },  notes = "ProjectMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Save-all') or hasPermission(this.projectMemberDtoMapping.toDomain(#dto),'ibizplm-ProjectMember-Save')")
    @PostMapping("project_members/save")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> save
            (@Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 项目成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO save
            (ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        projectMemberService.save(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 项目成员
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"项目成员" },  notes = "ProjectMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Create-all') or hasPermission('Project',#projectId,this.projectMemberDtoMapping.toDomain(#dto),'ibizplm-ProjectMember-Create')")
    @PostMapping("projects/{projectId}/project_members")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 项目成员
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO createByProjectId
            (String projectId, ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        projectMemberService.create(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目成员
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"项目成员" },  notes = "ProjectMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Update-all') or hasPermission('Project',#projectId,this.projectMemberService.get(#id),'ibizplm-ProjectMember-Update')")
    @VersionCheck(entity = "projectmember" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/project_members/{id}")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 项目成员
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO updateByProjectIdAndId
            (String projectId, String id, ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        projectMemberService.update(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目成员
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"项目成员" },  notes = "ProjectMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Save-all') or hasPermission('Project',#projectId,this.projectMemberDtoMapping.toDomain(#dto),'ibizplm-ProjectMember-Save')")
    @PostMapping("projects/{projectId}/project_members/save")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 项目成员
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO saveByProjectId
            (String projectId, ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        projectMemberService.save(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 项目成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"项目成员" },  notes = "ProjectMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Create-all') or hasPermission('User',#userId,this.projectMemberDtoMapping.toDomain(#dto),'ibizplm-ProjectMember-Create')")
    @PostMapping("users/{userId}/project_members")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> createByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByUserId(userId, item)));
        else
            rt.set(createByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 项目成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO createByUserId
            (String userId, ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        projectMemberService.create(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"项目成员" },  notes = "ProjectMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Update-all') or hasPermission('User',#userId,this.projectMemberService.get(#id),'ibizplm-ProjectMember-Update')")
    @VersionCheck(entity = "projectmember" , versionfield = "updateTime")
    @PutMapping("users/{userId}/project_members/{id}")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> updateByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByUserIdAndId(userId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 项目成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO updateByUserIdAndId
            (String userId, String id, ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        projectMemberService.update(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"项目成员" },  notes = "ProjectMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Save-all') or hasPermission('User',#userId,this.projectMemberDtoMapping.toDomain(#dto),'ibizplm-ProjectMember-Save')")
    @PostMapping("users/{userId}/project_members/save")
    public ResponseEntity<ResponseWrapper<ProjectMemberDTO>> saveByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProjectMemberDTO> dto) {
        ResponseWrapper<ProjectMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByUserId(userId, item)));
        else
            rt.set(saveByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 项目成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */   
    public ProjectMemberDTO saveByUserId
            (String userId, ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        projectMemberService.save(domain);
        ProjectMember rt = domain;
        return projectMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 项目成员
    * 
    *
    * @param id id
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"项目成员" },  notes = "ProjectMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Get-all')  or hasPermission(this.projectMemberDtoMapping.toDomain(returnObject.body),'ibizplm-ProjectMember-Get')")
    @GetMapping("project_members/{id}")
    public ResponseEntity<ProjectMemberDTO> getById
            (@PathVariable("id") String id) {
        ProjectMember rt = projectMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(projectMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 项目成员
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目成员" },  notes = "ProjectMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Remove-all') or hasPermission(this.projectMemberService.get(#id),'ibizplm-ProjectMember-Remove')")
    @DeleteMapping("project_members/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = projectMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 项目成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目成员" },  notes = "ProjectMember-CheckKey ")
    @PostMapping("project_members/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        Integer rt = projectMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 项目成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目成员" },  notes = "ProjectMember-GetDraft ")
    @GetMapping("project_members/getdraft")
    public ResponseEntity<ProjectMemberDTO> getDraft
            (@SpringQueryMap ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        ProjectMember rt = projectMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(projectMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_project 项目成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_project", tags = {"项目成员" },  notes = "ProjectMember-FetchCur_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-FetchCur_project-all') or hasPermission(#dto,'ibizplm-ProjectMember-FetchCur_project')")
    @PostMapping("project_members/fetchcur_project")
    public ResponseEntity<List<ProjectMemberDTO>> fetchCurProject
            (@Validated @RequestBody ProjectMemberFilterDTO dto) {
        ProjectMemberSearchContext context = projectMemberFilterDtoMapping.toDomain(dto);
        Page<ProjectMember> domains = projectMemberService.searchCurProject(context) ;
        List<ProjectMemberDTO> list = projectMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 项目成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProjectMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"项目成员" },  notes = "ProjectMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-FetchDefault-all') or hasPermission(#dto,'ibizplm-ProjectMember-FetchDefault')")
    @PostMapping("project_members/fetchdefault")
    public ResponseEntity<List<ProjectMemberDTO>> fetchDefault
            (@Validated @RequestBody ProjectMemberFilterDTO dto) {
        ProjectMemberSearchContext context = projectMemberFilterDtoMapping.toDomain(dto);
        Page<ProjectMember> domains = projectMemberService.searchDefault(context) ;
        List<ProjectMemberDTO> list = projectMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 项目成员
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"项目成员" },  notes = "ProjectMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Get-all')  or hasPermission('Project',#projectId,this.projectMemberDtoMapping.toDomain(returnObject.body),'ibizplm-ProjectMember-Get')")
    @GetMapping("projects/{projectId}/project_members/{id}")
    public ResponseEntity<ProjectMemberDTO> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        ProjectMember rt = projectMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(projectMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 项目成员
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目成员" },  notes = "ProjectMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Remove-all') or hasPermission('Project',#projectId,this.projectMemberService.get(#id),'ibizplm-ProjectMember-Remove')")
    @DeleteMapping("projects/{projectId}/project_members/{id}")
    public ResponseEntity<Boolean> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = projectMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 项目成员
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目成员" },  notes = "ProjectMember-CheckKey ")
    @PostMapping("projects/{projectId}/project_members/checkkey")
    public ResponseEntity<Integer> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Integer rt = projectMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 项目成员
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目成员" },  notes = "ProjectMember-GetDraft ")
    @GetMapping("projects/{projectId}/project_members/getdraft")
    public ResponseEntity<ProjectMemberDTO> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        ProjectMember rt = projectMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(projectMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_project 项目成员
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<ProjectMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_project", tags = {"项目成员" },  notes = "ProjectMember-FetchCur_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-FetchCur_project-all') or hasPermission('Project',#projectId,#dto,'ibizplm-ProjectMember-FetchCur_project')")
    @PostMapping("projects/{projectId}/project_members/fetchcur_project")
    public ResponseEntity<List<ProjectMemberDTO>> fetchCurProjectByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ProjectMemberFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ProjectMemberSearchContext context = projectMemberFilterDtoMapping.toDomain(dto);
        Page<ProjectMember> domains = projectMemberService.searchCurProject(context) ;
        List<ProjectMemberDTO> list = projectMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 项目成员
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<ProjectMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"项目成员" },  notes = "ProjectMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-FetchDefault-all') or hasPermission('Project',#projectId,#dto,'ibizplm-ProjectMember-FetchDefault')")
    @PostMapping("projects/{projectId}/project_members/fetchdefault")
    public ResponseEntity<List<ProjectMemberDTO>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ProjectMemberFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ProjectMemberSearchContext context = projectMemberFilterDtoMapping.toDomain(dto);
        Page<ProjectMember> domains = projectMemberService.searchDefault(context) ;
        List<ProjectMemberDTO> list = projectMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 项目成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"项目成员" },  notes = "ProjectMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Get-all')  or hasPermission('User',#userId,this.projectMemberDtoMapping.toDomain(returnObject.body),'ibizplm-ProjectMember-Get')")
    @GetMapping("users/{userId}/project_members/{id}")
    public ResponseEntity<ProjectMemberDTO> getByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        ProjectMember rt = projectMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(projectMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 项目成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目成员" },  notes = "ProjectMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-Remove-all') or hasPermission('User',#userId,this.projectMemberService.get(#id),'ibizplm-ProjectMember-Remove')")
    @DeleteMapping("users/{userId}/project_members/{id}")
    public ResponseEntity<Boolean> removeByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = projectMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 项目成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目成员" },  notes = "ProjectMember-CheckKey ")
    @PostMapping("users/{userId}/project_members/checkkey")
    public ResponseEntity<Integer> checkKeyByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        Integer rt = projectMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 项目成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProjectMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目成员" },  notes = "ProjectMember-GetDraft ")
    @GetMapping("users/{userId}/project_members/getdraft")
    public ResponseEntity<ProjectMemberDTO> getDraftByUserId
            (@PathVariable("userId") String userId, @SpringQueryMap ProjectMemberDTO dto) {
        ProjectMember domain = projectMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        ProjectMember rt = projectMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(projectMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_project 项目成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<ProjectMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_project", tags = {"项目成员" },  notes = "ProjectMember-FetchCur_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-FetchCur_project-all') or hasPermission('User',#userId,#dto,'ibizplm-ProjectMember-FetchCur_project')")
    @PostMapping("users/{userId}/project_members/fetchcur_project")
    public ResponseEntity<List<ProjectMemberDTO>> fetchCurProjectByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProjectMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProjectMemberSearchContext context = projectMemberFilterDtoMapping.toDomain(dto);
        Page<ProjectMember> domains = projectMemberService.searchCurProject(context) ;
        List<ProjectMemberDTO> list = projectMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 项目成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<ProjectMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"项目成员" },  notes = "ProjectMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectMember-FetchDefault-all') or hasPermission('User',#userId,#dto,'ibizplm-ProjectMember-FetchDefault')")
    @PostMapping("users/{userId}/project_members/fetchdefault")
    public ResponseEntity<List<ProjectMemberDTO>> fetchDefaultByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProjectMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProjectMemberSearchContext context = projectMemberFilterDtoMapping.toDomain(dto);
        Page<ProjectMember> domains = projectMemberService.searchDefault(context) ;
        List<ProjectMemberDTO> list = projectMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建项目成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectMember-Create-all')")
    @ApiOperation(value = "批量新建项目成员", tags = {"项目成员" },  notes = "批量新建项目成员")
	@PostMapping("project_members/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ProjectMemberDTO> dtos) {
        projectMemberService.createBatch(projectMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除项目成员
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectMember-Remove-all')")
    @ApiOperation(value = "批量删除项目成员", tags = {"项目成员" },  notes = "批量删除项目成员")
	@DeleteMapping("project_members/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        projectMemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新项目成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectMember-Update-all')")
    @ApiOperation(value = "批量更新项目成员", tags = {"项目成员" },  notes = "批量更新项目成员")
	@PutMapping("project_members/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ProjectMemberDTO> dtos) {
        projectMemberService.updateBatch(projectMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存项目成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectMember-Save-all')")
    @ApiOperation(value = "批量保存项目成员", tags = {"项目成员" },  notes = "批量保存项目成员")
	@PostMapping("project_members/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ProjectMemberDTO> dtos) {
        projectMemberService.saveBatch(projectMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入项目成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectMember-Save-all')")
    @ApiOperation(value = "批量导入项目成员", tags = {"项目成员" },  notes = "批量导入项目成员")
	@PostMapping("project_members/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProjectMemberDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(projectMemberService.importData(config,ignoreError,projectMemberDtoMapping.toDomain(dtos)));
    }

}
