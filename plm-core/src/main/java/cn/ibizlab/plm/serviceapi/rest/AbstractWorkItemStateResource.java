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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemStateService;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemStateSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[WorkItemState] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkItemStateResource {

    @Autowired
    public WorkItemStateService workItemStateService;

    @Autowired
    @Lazy
    public WorkItemStateDTOMapping workItemStateDtoMapping;

    @Autowired
    @Lazy
    public WorkItemStateFilterDTOMapping workItemStateFilterDtoMapping;

    /**
    * 创建Create 工作项状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemStateDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项状态" },  notes = "WorkItemState-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemState-Create-all') or hasPermission(this.workItemStateDtoMapping.toDomain(#dto),'ibizplm-WorkItemState-Create')")
    @PostMapping("work_item_states")
    public ResponseEntity<ResponseWrapper<WorkItemStateDTO>> create
            (@Validated @RequestBody RequestWrapper<WorkItemStateDTO> dto) {
        ResponseWrapper<WorkItemStateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 工作项状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemStateDTO>
    */   
    public WorkItemStateDTO create
            (WorkItemStateDTO dto) {
        WorkItemState domain = workItemStateDtoMapping.toDomain(dto);
        workItemStateService.create(domain);
        WorkItemState rt = domain;
        return workItemStateDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工作项状态
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemStateDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"工作项状态" },  notes = "WorkItemState-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemState-Update-all') or hasPermission(this.workItemStateService.get(#id),'ibizplm-WorkItemState-Update')")
    @VersionCheck(entity = "workitemstate" , versionfield = "updateTime")
    @PutMapping("work_item_states/{id}")
    public ResponseEntity<ResponseWrapper<WorkItemStateDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemStateDTO> dto) {
        ResponseWrapper<WorkItemStateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 工作项状态
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemStateDTO>
    */   
    public WorkItemStateDTO updateById
            (String id, WorkItemStateDTO dto) {
        WorkItemState domain = workItemStateDtoMapping.toDomain(dto);
        domain.setId(id);
        workItemStateService.update(domain);
        WorkItemState rt = domain;
        return workItemStateDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工作项状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemStateDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项状态" },  notes = "WorkItemState-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemState-Save-all') or hasPermission(this.workItemStateDtoMapping.toDomain(#dto),'ibizplm-WorkItemState-Save')")
    @PostMapping("work_item_states/save")
    public ResponseEntity<ResponseWrapper<WorkItemStateDTO>> save
            (@Validated @RequestBody RequestWrapper<WorkItemStateDTO> dto) {
        ResponseWrapper<WorkItemStateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 工作项状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemStateDTO>
    */   
    public WorkItemStateDTO save
            (WorkItemStateDTO dto) {
        WorkItemState domain = workItemStateDtoMapping.toDomain(dto);
        workItemStateService.save(domain);
        WorkItemState rt = domain;
        return workItemStateDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工作项状态
    * 
    *
    * @param id id
    * @return ResponseEntity<WorkItemStateDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"工作项状态" },  notes = "WorkItemState-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemState-Get-all')  or hasPermission(this.workItemStateDtoMapping.toDomain(returnObject.body),'ibizplm-WorkItemState-Get')")
    @GetMapping("work_item_states/{id}")
    public ResponseEntity<WorkItemStateDTO> getById
            (@PathVariable("id") String id) {
        WorkItemState rt = workItemStateService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemStateDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 工作项状态
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作项状态" },  notes = "WorkItemState-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemState-Remove-all') or hasPermission(this.workItemStateService.get(#id),'ibizplm-WorkItemState-Remove')")
    @DeleteMapping("work_item_states/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = workItemStateService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 工作项状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作项状态" },  notes = "WorkItemState-CheckKey ")
    @PostMapping("work_item_states/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody WorkItemStateDTO dto) {
        WorkItemState domain = workItemStateDtoMapping.toDomain(dto);
        Integer rt = workItemStateService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 工作项状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemStateDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项状态" },  notes = "WorkItemState-GetDraft ")
    @GetMapping("work_item_states/get_draft")
    public ResponseEntity<WorkItemStateDTO> getDraft
            (@SpringQueryMap WorkItemStateDTO dto) {
        WorkItemState domain = workItemStateDtoMapping.toDomain(dto);
        WorkItemState rt = workItemStateService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(workItemStateDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 工作项状态
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemStateDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作项状态" },  notes = "WorkItemState-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItemState-fetch_default-all') or hasPermission(#dto,'ibizplm-WorkItemState-fetch_default')")
    @PostMapping("work_item_states/fetch_default")
    public ResponseEntity<List<WorkItemStateDTO>> fetchDefault
            (@Validated @RequestBody WorkItemStateFilterDTO dto) {
        WorkItemStateSearchContext context = workItemStateFilterDtoMapping.toDomain(dto);
        Page<WorkItemState> domains = workItemStateService.fetchDefault(context) ;
        List<WorkItemStateDTO> list = workItemStateDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建工作项状态
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemState-Create-all')")
    @ApiOperation(value = "批量新建工作项状态", tags = {"工作项状态" },  notes = "批量新建工作项状态")
	@PostMapping("work_item_states/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WorkItemStateDTO> dtos) {
        workItemStateService.create(workItemStateDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除工作项状态
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemState-Remove-all')")
    @ApiOperation(value = "批量删除工作项状态", tags = {"工作项状态" },  notes = "批量删除工作项状态")
	@DeleteMapping("work_item_states/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        workItemStateService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新工作项状态
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemState-Update-all')")
    @ApiOperation(value = "批量更新工作项状态", tags = {"工作项状态" },  notes = "批量更新工作项状态")
	@PutMapping("work_item_states/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WorkItemStateDTO> dtos) {
        workItemStateService.update(workItemStateDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存工作项状态
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemState-Save-all')")
    @ApiOperation(value = "批量保存工作项状态", tags = {"工作项状态" },  notes = "批量保存工作项状态")
	@PostMapping("work_item_states/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WorkItemStateDTO> dtos) {
        workItemStateService.save(workItemStateDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入工作项状态
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItemState-Save-all')")
    @ApiOperation(value = "批量导入工作项状态", tags = {"工作项状态" },  notes = "批量导入工作项状态")
	@PostMapping("work_item_states/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<WorkItemStateDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(workItemStateService.importData(config,ignoreError,workItemStateDtoMapping.toDomain(dtos)));
    }

}
