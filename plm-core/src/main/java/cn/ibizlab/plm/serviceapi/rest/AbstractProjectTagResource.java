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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectTag;
import cn.ibizlab.plm.core.projmgmt.service.ProjectTagService;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectTagSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[ProjectTag] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectTagResource {

    @Autowired
    public ProjectTagService projectTagService;

    @Autowired
    @Lazy
    public ProjectTagDTOMapping projectTagDtoMapping;

    @Autowired
    @Lazy
    public ProjectTagFilterDTOMapping projectTagFilterDtoMapping;

    /**
    * 创建Create 项目标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectTagDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"项目标签" },  notes = "ProjectTag-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectTag-Create-all') or hasPermission(this.projectTagDtoMapping.toDomain(#dto),'ibizplm-ProjectTag-Create')")
    @PostMapping("project_tags")
    public Mono<ResponseEntity<ResponseWrapper<ProjectTagDTO>>>create
            (@Validated @RequestBody RequestWrapper<ProjectTagDTO> dto) {
        ResponseWrapper<ProjectTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 项目标签
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectTagDTO>
    */   
    public ProjectTagDTO create
            (ProjectTagDTO dto) {
        ProjectTag domain = projectTagDtoMapping.toDomain(dto);
        projectTagService.create(domain);
        ProjectTag rt = domain;
        return projectTagDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目标签
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectTagDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"项目标签" },  notes = "ProjectTag-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectTag-Update-all') or hasPermission(this.projectTagService.get(#id),'ibizplm-ProjectTag-Update')")
    @VersionCheck(entity = "projecttag" , versionfield = "updateTime")
    @PutMapping("project_tags/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProjectTagDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectTagDTO> dto) {
        ResponseWrapper<ProjectTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 项目标签
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectTagDTO>
    */   
    public ProjectTagDTO updateById
            (String id, ProjectTagDTO dto) {
        ProjectTag domain = projectTagDtoMapping.toDomain(dto);
        domain.setId(id);
        projectTagService.update(domain);
        ProjectTag rt = domain;
        return projectTagDtoMapping.toDto(rt);
    }

    /**
    * delete_tag 项目标签
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectTagDTO>>
    */
    @ApiOperation(value = "delete_tag", tags = {"项目标签" },  notes = "ProjectTag-delete_tag ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectTag-delete_tag-all') or hasPermission(this.projectTagDtoMapping.toDomain(#dto),'ibizplm-ProjectTag-delete_tag')")
    @PostMapping("project_tags/{id}/delete_tag")
    public Mono<ResponseEntity<ResponseWrapper<ProjectTagDTO>>>deleteTagById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectTagDTO> dto) {
        ResponseWrapper<ProjectTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteTagById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteTagById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_tag 项目标签
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectTagDTO>
    */   
    public ProjectTagDTO deleteTagById
            (String id, ProjectTagDTO dto) {
        ProjectTag domain = projectTagDtoMapping.toDomain(dto);
        domain.setId(id);
        ProjectTag rt = projectTagService.deleteTag(domain);
        return projectTagDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectTagDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"项目标签" },  notes = "ProjectTag-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectTag-Save-all') or hasPermission(this.projectTagDtoMapping.toDomain(#dto),'ibizplm-ProjectTag-Save')")
    @PostMapping("project_tags/save")
    public Mono<ResponseEntity<ResponseWrapper<ProjectTagDTO>>>save
            (@Validated @RequestBody RequestWrapper<ProjectTagDTO> dto) {
        ResponseWrapper<ProjectTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 项目标签
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectTagDTO>
    */   
    public ProjectTagDTO save
            (ProjectTagDTO dto) {
        ProjectTag domain = projectTagDtoMapping.toDomain(dto);
        projectTagService.save(domain);
        ProjectTag rt = domain;
        return projectTagDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 项目标签
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ProjectTagDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"项目标签" },  notes = "ProjectTag-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectTag-Get-all')  or hasPermission(this.projectTagDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProjectTag-Get')")
    @GetMapping("project_tags/{id}")
    public Mono<ResponseEntity<ProjectTagDTO>> getById
            (@PathVariable("id") String id) {
        ProjectTag rt = projectTagService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(projectTagDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 项目标签
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目标签" },  notes = "ProjectTag-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectTag-Remove-all') or hasPermission(this.projectTagService.get(#id),'ibizplm-ProjectTag-Remove')")
    @DeleteMapping("project_tags/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = projectTagService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 项目标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目标签" },  notes = "ProjectTag-CheckKey ")
    @PostMapping("project_tags/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ProjectTagDTO dto) {
        ProjectTag domain = projectTagDtoMapping.toDomain(dto);
        CheckKeyStatus rt = projectTagService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_con_project_tag 项目标签
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ProjectTagDTO>>
    */
    @ApiOperation(value = "get_con_project_tag", tags = {"项目标签" },  notes = "ProjectTag-get_con_project_tag ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectTag-get_con_project_tag-all') or hasPermission(this.projectTagService.get(#id),'ibizplm-ProjectTag-get_con_project_tag')")
    @GetMapping("project_tags/{id}/get_con_project_tag")
    public Mono<ResponseEntity<ProjectTagDTO>> getConProjectTagById
            (@PathVariable("id") String id) {
        ProjectTag rt = projectTagService.getConProjectTag(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(projectTagDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 项目标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectTagDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目标签" },  notes = "ProjectTag-GetDraft ")
    @GetMapping("project_tags/get_draft")
    public Mono<ResponseEntity<ProjectTagDTO>> getDraft
            (@SpringQueryMap ProjectTagDTO dto) {
        ProjectTag domain = projectTagDtoMapping.toDomain(dto);
        ProjectTag rt = projectTagService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(projectTagDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 项目标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProjectTagDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"项目标签" },  notes = "ProjectTag-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectTag-fetch_default-all') or hasPermission(#dto,'ibizplm-ProjectTag-fetch_default')")
    @PostMapping("project_tags/fetch_default")
    public Mono<ResponseEntity<List<ProjectTagDTO>>> fetchDefault
            (@Validated @RequestBody ProjectTagFilterDTO dto) {
        ProjectTagSearchContext context = projectTagFilterDtoMapping.toDomain(dto);
        Page<ProjectTag> domains = projectTagService.fetchDefault(context) ;
        List<ProjectTagDTO> list = projectTagDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建项目标签
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectTag-Create-all')")
    @ApiOperation(value = "批量新建项目标签", tags = {"项目标签" },  notes = "批量新建项目标签")
	@PostMapping("project_tags/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ProjectTagDTO> dtos) {
        projectTagService.create(projectTagDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除项目标签
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectTag-Remove-all')")
    @ApiOperation(value = "批量删除项目标签", tags = {"项目标签" },  notes = "批量删除项目标签")
	@DeleteMapping("project_tags/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        projectTagService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新项目标签
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectTag-Update-all')")
    @ApiOperation(value = "批量更新项目标签", tags = {"项目标签" },  notes = "批量更新项目标签")
	@PutMapping("project_tags/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ProjectTagDTO> dtos) {
        projectTagService.update(projectTagDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存项目标签
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectTag-Save-all')")
    @ApiOperation(value = "批量保存项目标签", tags = {"项目标签" },  notes = "批量保存项目标签")
	@PostMapping("project_tags/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ProjectTagDTO> dtos) {
        projectTagService.save(projectTagDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入项目标签
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectTag-Save-all')")
    @ApiOperation(value = "批量导入项目标签", tags = {"项目标签" },  notes = "批量导入项目标签")
	@PostMapping("project_tags/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProjectTagDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(projectTagService.importData(config,ignoreError,projectTagDtoMapping.toDomain(dtos))));
    }

}
