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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectState;
import cn.ibizlab.plm.core.projmgmt.service.ProjectStateService;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectStateSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[ProjectState] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectStateResource {

    @Autowired
    public ProjectStateService projectStateService;

    @Autowired
    @Lazy
    public ProjectStateDTOMapping projectStateDtoMapping;

    @Autowired
    @Lazy
    public ProjectStateFilterDTOMapping projectStateFilterDtoMapping;

    /**
    * 创建Create 项目状态
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectStateDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"项目状态" },  notes = "ProjectState-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectState-Create-all') or hasPermission(this.projectStateDtoMapping.toDomain(#dto),'ibizplm-ProjectState-Create')")
    @PostMapping("project_states")
    public Mono<ResponseEntity<ResponseWrapper<ProjectStateDTO>>>create
            (@Validated @RequestBody RequestWrapper<ProjectStateDTO> dto) {
        ResponseWrapper<ProjectStateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 项目状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectStateDTO>
    */   
    public ProjectStateDTO create
            (ProjectStateDTO dto) {
        ProjectState domain = projectStateDtoMapping.toDomain(dto);
        projectStateService.create(domain);
        ProjectState rt = domain;
        return projectStateDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目状态
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectStateDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"项目状态" },  notes = "ProjectState-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectState-Update-all') or hasPermission(this.projectStateService.get(#id),'ibizplm-ProjectState-Update')")
    @VersionCheck(entity = "projectstate" , versionfield = "updateTime")
    @PutMapping("project_states/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProjectStateDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectStateDTO> dto) {
        ResponseWrapper<ProjectStateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 项目状态
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProjectStateDTO>
    */   
    public ProjectStateDTO updateById
            (String id, ProjectStateDTO dto) {
        ProjectState domain = projectStateDtoMapping.toDomain(dto);
        domain.setId(id);
        projectStateService.update(domain);
        ProjectState rt = domain;
        return projectStateDtoMapping.toDto(rt);
    }

    /**
    * move_order 项目状态
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProjectStateDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"项目状态" },  notes = "ProjectState-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectState-move_order-all') or hasPermission(this.projectStateDtoMapping.toDomain(#dto),'ibizplm-ProjectState-move_order')")
    @PostMapping("project_states/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<ProjectStateDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProjectStateDTO> dto) {
        ResponseWrapper<List<ProjectStateDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 项目状态
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<ProjectStateDTO>>
    */   
    public List<ProjectStateDTO> moveOrderById
            (String id, ProjectStateDTO dto) {
        ProjectState domain = projectStateDtoMapping.toDomain(dto);
        domain.setId(id);
        List<ProjectState> rt = projectStateService.moveOrder(domain);
        return projectStateDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目状态
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectStateDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"项目状态" },  notes = "ProjectState-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectState-Save-all') or hasPermission(this.projectStateDtoMapping.toDomain(#dto),'ibizplm-ProjectState-Save')")
    @PostMapping("project_states/save")
    public Mono<ResponseEntity<ResponseWrapper<ProjectStateDTO>>>save
            (@Validated @RequestBody RequestWrapper<ProjectStateDTO> dto) {
        ResponseWrapper<ProjectStateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 项目状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProjectStateDTO>
    */   
    public ProjectStateDTO save
            (ProjectStateDTO dto) {
        ProjectState domain = projectStateDtoMapping.toDomain(dto);
        projectStateService.save(domain);
        ProjectState rt = domain;
        return projectStateDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 项目状态
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ProjectStateDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"项目状态" },  notes = "ProjectState-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectState-Get-all')  or hasPermission(this.projectStateDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProjectState-Get')")
    @GetMapping("project_states/{id}")
    public Mono<ResponseEntity<ProjectStateDTO>> getById
            (@PathVariable("id") String id) {
        ProjectState rt = projectStateService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(projectStateDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 项目状态
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目状态" },  notes = "ProjectState-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectState-Remove-all') or hasPermission(this.projectStateService.get(#id),'ibizplm-ProjectState-Remove')")
    @DeleteMapping("project_states/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = projectStateService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 项目状态
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目状态" },  notes = "ProjectState-CheckKey ")
    @PostMapping("project_states/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ProjectStateDTO dto) {
        ProjectState domain = projectStateDtoMapping.toDomain(dto);
        CheckKeyStatus rt = projectStateService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 项目状态
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProjectStateDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目状态" },  notes = "ProjectState-GetDraft ")
    @GetMapping("project_states/get_draft")
    public Mono<ResponseEntity<ProjectStateDTO>> getDraft
            (@SpringQueryMap ProjectStateDTO dto) {
        ProjectState domain = projectStateDtoMapping.toDomain(dto);
        ProjectState rt = projectStateService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(projectStateDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 项目状态
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProjectStateDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"项目状态" },  notes = "ProjectState-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProjectState-fetch_default-all') or hasPermission(#dto,'ibizplm-ProjectState-fetch_default')")
    @PostMapping("project_states/fetch_default")
    public Mono<ResponseEntity<List<ProjectStateDTO>>> fetchDefault
            (@Validated @RequestBody ProjectStateFilterDTO dto) {
        ProjectStateSearchContext context = projectStateFilterDtoMapping.toDomain(dto);
        Page<ProjectState> domains = projectStateService.fetchDefault(context) ;
        List<ProjectStateDTO> list = projectStateDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建项目状态
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectState-Create-all')")
    @ApiOperation(value = "批量新建项目状态", tags = {"项目状态" },  notes = "批量新建项目状态")
	@PostMapping("project_states/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ProjectStateDTO> dtos) {
        projectStateService.create(projectStateDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除项目状态
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectState-Remove-all')")
    @ApiOperation(value = "批量删除项目状态", tags = {"项目状态" },  notes = "批量删除项目状态")
	@DeleteMapping("project_states/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        projectStateService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新项目状态
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectState-Update-all')")
    @ApiOperation(value = "批量更新项目状态", tags = {"项目状态" },  notes = "批量更新项目状态")
	@PutMapping("project_states/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ProjectStateDTO> dtos) {
        projectStateService.update(projectStateDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存项目状态
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectState-Save-all')")
    @ApiOperation(value = "批量保存项目状态", tags = {"项目状态" },  notes = "批量保存项目状态")
	@PostMapping("project_states/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ProjectStateDTO> dtos) {
        projectStateService.save(projectStateDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入项目状态
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProjectState-Save-all')")
    @ApiOperation(value = "批量导入项目状态", tags = {"项目状态" },  notes = "批量导入项目状态")
	@PostMapping("project_states/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProjectStateDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(projectStateService.importData(config,ignoreError,projectStateDtoMapping.toDomain(dtos))));
    }

}
