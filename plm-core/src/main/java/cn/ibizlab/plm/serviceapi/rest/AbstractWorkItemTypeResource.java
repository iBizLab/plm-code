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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemTypeService;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemTypeSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[WorkItemType] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkItemTypeResource {

    @Autowired
    public WorkItemTypeService workItemTypeService;

    @Autowired
    @Lazy
    public WorkItemTypeDTOMapping workItemTypeDtoMapping;

    @Autowired
    @Lazy
    public WorkItemTypeFilterDTOMapping workItemTypeFilterDtoMapping;

    /**
    * 创建Create 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemTypeDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项类型" },  notes = "WorkItemType-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-Create-all') or hasPermission(this.workItemTypeDtoMapping.toDomain(#dto),'ibizplm-WorkItemType-Create')")
    @PostMapping("work_item_types")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemTypeDTO>>>create
            (@Validated @RequestBody RequestWrapper<WorkItemTypeDTO> dto) {
        ResponseWrapper<WorkItemTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工作项类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemTypeDTO>
    */   
    public WorkItemTypeDTO create
            (WorkItemTypeDTO dto) {
        WorkItemType domain = workItemTypeDtoMapping.toDomain(dto);
        workItemTypeService.create(domain);
        WorkItemType rt = domain;
        return workItemTypeDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工作项类型
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemTypeDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工作项类型" },  notes = "WorkItemType-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-Update-all') or hasPermission(this.workItemTypeService.get(#id),'ibizplm-WorkItemType-Update')")
    @VersionCheck(entity = "workitemtype" , versionfield = "updateTime")
    @PutMapping("work_item_types/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemTypeDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemTypeDTO> dto) {
        ResponseWrapper<WorkItemTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工作项类型
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemTypeDTO>
    */   
    public WorkItemTypeDTO updateById
            (String id, WorkItemTypeDTO dto) {
        WorkItemType domain = workItemTypeDtoMapping.toDomain(dto);
        domain.setId(id);
        workItemTypeService.update(domain);
        WorkItemType rt = domain;
        return workItemTypeDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemTypeDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项类型" },  notes = "WorkItemType-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-Save-all') or hasPermission(this.workItemTypeDtoMapping.toDomain(#dto),'ibizplm-WorkItemType-Save')")
    @PostMapping("work_item_types/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemTypeDTO>>>save
            (@Validated @RequestBody RequestWrapper<WorkItemTypeDTO> dto) {
        ResponseWrapper<WorkItemTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工作项类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemTypeDTO>
    */   
    public WorkItemTypeDTO save
            (WorkItemTypeDTO dto) {
        WorkItemType domain = workItemTypeDtoMapping.toDomain(dto);
        workItemTypeService.save(domain);
        WorkItemType rt = domain;
        return workItemTypeDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工作项类型
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkItemTypeDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工作项类型" },  notes = "WorkItemType-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-Get-all')  or hasPermission(this.workItemTypeDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-WorkItemType-Get')")
    @GetMapping("work_item_types/{id}")
    public Mono<ResponseEntity<WorkItemTypeDTO>> getById
            (@PathVariable("id") String id) {
        WorkItemType rt = workItemTypeService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemTypeDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工作项类型
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作项类型" },  notes = "WorkItemType-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-Remove-all') or hasPermission(this.workItemTypeService.get(#id),'ibizplm-WorkItemType-Remove')")
    @DeleteMapping("work_item_types/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = workItemTypeService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作项类型" },  notes = "WorkItemType-CheckKey ")
    @PostMapping("work_item_types/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody WorkItemTypeDTO dto) {
        WorkItemType domain = workItemTypeDtoMapping.toDomain(dto);
        CheckKeyStatus rt = workItemTypeService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemTypeDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项类型" },  notes = "WorkItemType-GetDraft ")
    @GetMapping("work_item_types/get_draft")
    public Mono<ResponseEntity<WorkItemTypeDTO>> getDraft
            (@SpringQueryMap WorkItemTypeDTO dto) {
        WorkItemType domain = workItemTypeDtoMapping.toDomain(dto);
        WorkItemType rt = workItemTypeService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemTypeDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_choose_target_type 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemTypeDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_target_type", tags = {"工作项类型" },  notes = "WorkItemType-fetch_choose_target_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-fetch_choose_target_type-all') or hasPermission(#dto,'ibizplm-WorkItemType-fetch_choose_target_type')")
    @PostMapping("work_item_types/fetch_choose_target_type")
    public Mono<ResponseEntity<List<WorkItemTypeDTO>>> fetchChooseTargetType
            (@Validated @RequestBody WorkItemTypeFilterDTO dto) {
        WorkItemTypeSearchContext context = workItemTypeFilterDtoMapping.toDomain(dto);
        Page<WorkItemType> domains = workItemTypeService.fetchChooseTargetType(context) ;
        List<WorkItemTypeDTO> list = workItemTypeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_project_type 工作项类型
    * 数据上下文过滤，非瀑布项目
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemTypeDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_project_type", tags = {"工作项类型" },  notes = "WorkItemType-fetch_cur_project_type 数据上下文过滤，非瀑布项目")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-fetch_cur_project_type-all') or hasPermission(#dto,'ibizplm-WorkItemType-fetch_cur_project_type')")
    @PostMapping("work_item_types/fetch_cur_project_type")
    public Mono<ResponseEntity<List<WorkItemTypeDTO>>> fetchCurProjectType
            (@Validated @RequestBody WorkItemTypeFilterDTO dto) {
        WorkItemTypeSearchContext context = workItemTypeFilterDtoMapping.toDomain(dto);
        Page<WorkItemType> domains = workItemTypeService.fetchCurProjectType(context) ;
        List<WorkItemTypeDTO> list = workItemTypeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemTypeDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作项类型" },  notes = "WorkItemType-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-fetch_default-all') or hasPermission(#dto,'ibizplm-WorkItemType-fetch_default')")
    @PostMapping("work_item_types/fetch_default")
    public Mono<ResponseEntity<List<WorkItemTypeDTO>>> fetchDefault
            (@Validated @RequestBody WorkItemTypeFilterDTO dto) {
        WorkItemTypeSearchContext context = workItemTypeFilterDtoMapping.toDomain(dto);
        Page<WorkItemType> domains = workItemTypeService.fetchDefault(context) ;
        List<WorkItemTypeDTO> list = workItemTypeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_group_by_origin_state 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemTypeDTO>>>
    */
    @ApiOperation(value = "查询fetch_group_by_origin_state", tags = {"工作项类型" },  notes = "WorkItemType-fetch_group_by_origin_state ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-fetch_group_by_origin_state-all') or hasPermission(#dto,'ibizplm-WorkItemType-fetch_group_by_origin_state')")
    @PostMapping("work_item_types/fetch_group_by_origin_state")
    public Mono<ResponseEntity<List<WorkItemTypeDTO>>> fetchGroupByOriginState
            (@Validated @RequestBody WorkItemTypeFilterDTO dto) {
        WorkItemTypeSearchContext context = workItemTypeFilterDtoMapping.toDomain(dto);
        Page<WorkItemType> domains = workItemTypeService.fetchGroupByOriginState(context) ;
        List<WorkItemTypeDTO> list = workItemTypeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_project_work_item_type 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemTypeDTO>>>
    */
    @ApiOperation(value = "查询fetch_project_work_item_type", tags = {"工作项类型" },  notes = "WorkItemType-fetch_project_work_item_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemType-fetch_project_work_item_type-all') or hasPermission(#dto,'ibizplm-WorkItemType-fetch_project_work_item_type')")
    @PostMapping("work_item_types/fetch_project_work_item_type")
    public Mono<ResponseEntity<List<WorkItemTypeDTO>>> fetchProjectWorkItemType
            (@Validated @RequestBody WorkItemTypeFilterDTO dto) {
        WorkItemTypeSearchContext context = workItemTypeFilterDtoMapping.toDomain(dto);
        Page<WorkItemType> domains = workItemTypeService.fetchProjectWorkItemType(context) ;
        List<WorkItemTypeDTO> list = workItemTypeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_project_work_item_type_not_bug 工作项类型
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemTypeDTO>>>
    */
    @ApiOperation(value = "查询fetch_project_work_item_type_not_bug", tags = {"工作项类型" },  notes = "WorkItemType-fetch_project_work_item_type_not_bug ")
    @PostMapping("work_item_types/fetch_project_work_item_type_not_bug")
    public Mono<ResponseEntity<List<WorkItemTypeDTO>>> fetchProjectWorkItemTypeNotBug
            (@Validated @RequestBody WorkItemTypeFilterDTO dto) {
        WorkItemTypeSearchContext context = workItemTypeFilterDtoMapping.toDomain(dto);
        Page<WorkItemType> domains = workItemTypeService.fetchProjectWorkItemTypeNotBug(context) ;
        List<WorkItemTypeDTO> list = workItemTypeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建工作项类型
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemType-Create-all')")
    @ApiOperation(value = "批量新建工作项类型", tags = {"工作项类型" },  notes = "批量新建工作项类型")
	@PostMapping("work_item_types/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<WorkItemTypeDTO> dtos) {
        workItemTypeService.create(workItemTypeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除工作项类型
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemType-Remove-all')")
    @ApiOperation(value = "批量删除工作项类型", tags = {"工作项类型" },  notes = "批量删除工作项类型")
	@DeleteMapping("work_item_types/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        workItemTypeService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新工作项类型
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemType-Update-all')")
    @ApiOperation(value = "批量更新工作项类型", tags = {"工作项类型" },  notes = "批量更新工作项类型")
	@PutMapping("work_item_types/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<WorkItemTypeDTO> dtos) {
        workItemTypeService.update(workItemTypeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存工作项类型
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemType-Save-all')")
    @ApiOperation(value = "批量保存工作项类型", tags = {"工作项类型" },  notes = "批量保存工作项类型")
	@PostMapping("work_item_types/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<WorkItemTypeDTO> dtos) {
        workItemTypeService.save(workItemTypeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入工作项类型
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemType-Save-all')")
    @ApiOperation(value = "批量导入工作项类型", tags = {"工作项类型" },  notes = "批量导入工作项类型")
	@PostMapping("work_item_types/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<WorkItemTypeDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemTypeService.importData(config,ignoreError,workItemTypeDtoMapping.toDomain(dtos))));
    }

}
