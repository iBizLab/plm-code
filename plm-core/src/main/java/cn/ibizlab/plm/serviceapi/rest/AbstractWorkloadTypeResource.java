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
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.core.base.service.WorkloadTypeService;
import cn.ibizlab.plm.core.base.filter.WorkloadTypeSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[WorkloadType] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkloadTypeResource {

    @Autowired
    public WorkloadTypeService workloadTypeService;

    @Autowired
    @Lazy
    public WorkloadTypeDTOMapping workloadTypeDtoMapping;

    @Autowired
    @Lazy
    public WorkloadTypeFilterDTOMapping workloadTypeFilterDtoMapping;

    /**
    * 创建Create 工时类别
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadTypeDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工时类别" },  notes = "WorkloadType-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkloadType-Create-all') or hasPermission(this.workloadTypeDtoMapping.toDomain(#dto),'ibizplm-WorkloadType-Create')")
    @PostMapping("workload_types")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadTypeDTO>>>create
            (@Validated @RequestBody RequestWrapper<WorkloadTypeDTO> dto) {
        ResponseWrapper<WorkloadTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工时类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadTypeDTO>
    */   
    public WorkloadTypeDTO create
            (WorkloadTypeDTO dto) {
        WorkloadType domain = workloadTypeDtoMapping.toDomain(dto);
        workloadTypeService.create(domain);
        WorkloadType rt = domain;
        return workloadTypeDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工时类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadTypeDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工时类别" },  notes = "WorkloadType-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkloadType-Update-all') or hasPermission(this.workloadTypeService.get(#id),'ibizplm-WorkloadType-Update')")
    @VersionCheck(entity = "workloadtype" , versionfield = "updateTime")
    @PutMapping("workload_types/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadTypeDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadTypeDTO> dto) {
        ResponseWrapper<WorkloadTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工时类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadTypeDTO>
    */   
    public WorkloadTypeDTO updateById
            (String id, WorkloadTypeDTO dto) {
        WorkloadType domain = workloadTypeDtoMapping.toDomain(dto);
        domain.setId(id);
        workloadTypeService.update(domain);
        WorkloadType rt = domain;
        return workloadTypeDtoMapping.toDto(rt);
    }

    /**
    * move_order 工时类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadTypeDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"工时类别" },  notes = "WorkloadType-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkloadType-move_order-all') or hasPermission(this.workloadTypeDtoMapping.toDomain(#dto),'ibizplm-WorkloadType-move_order')")
    @PostMapping("workload_types/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkloadTypeDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadTypeDTO> dto) {
        ResponseWrapper<List<WorkloadTypeDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 工时类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkloadTypeDTO>>
    */   
    public List<WorkloadTypeDTO> moveOrderById
            (String id, WorkloadTypeDTO dto) {
        WorkloadType domain = workloadTypeDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkloadType> rt = workloadTypeService.moveOrder(domain);
        return workloadTypeDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工时类别
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadTypeDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工时类别" },  notes = "WorkloadType-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkloadType-Save-all') or hasPermission(this.workloadTypeDtoMapping.toDomain(#dto),'ibizplm-WorkloadType-Save')")
    @PostMapping("workload_types/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadTypeDTO>>>save
            (@Validated @RequestBody RequestWrapper<WorkloadTypeDTO> dto) {
        ResponseWrapper<WorkloadTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工时类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadTypeDTO>
    */   
    public WorkloadTypeDTO save
            (WorkloadTypeDTO dto) {
        WorkloadType domain = workloadTypeDtoMapping.toDomain(dto);
        workloadTypeService.save(domain);
        WorkloadType rt = domain;
        return workloadTypeDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工时类别
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkloadTypeDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工时类别" },  notes = "WorkloadType-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkloadType-Get-all')  or hasPermission(this.workloadTypeDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-WorkloadType-Get')")
    @GetMapping("workload_types/{id}")
    public Mono<ResponseEntity<WorkloadTypeDTO>> getById
            (@PathVariable("id") String id) {
        WorkloadType rt = workloadTypeService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadTypeDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工时类别
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工时类别" },  notes = "WorkloadType-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkloadType-Remove-all') or hasPermission(this.workloadTypeService.get(#id),'ibizplm-WorkloadType-Remove')")
    @DeleteMapping("workload_types/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = workloadTypeService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工时类别
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工时类别" },  notes = "WorkloadType-CheckKey ")
    @PostMapping("workload_types/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody WorkloadTypeDTO dto) {
        WorkloadType domain = workloadTypeDtoMapping.toDomain(dto);
        CheckKeyStatus rt = workloadTypeService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 工时类别
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadTypeDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工时类别" },  notes = "WorkloadType-GetDraft ")
    @GetMapping("workload_types/get_draft")
    public Mono<ResponseEntity<WorkloadTypeDTO>> getDraft
            (@SpringQueryMap WorkloadTypeDTO dto) {
        WorkloadType domain = workloadTypeDtoMapping.toDomain(dto);
        WorkloadType rt = workloadTypeService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadTypeDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 工时类别
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadTypeDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工时类别" },  notes = "WorkloadType-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkloadType-fetch_default-all') or hasPermission(#dto,'ibizplm-WorkloadType-fetch_default')")
    @PostMapping("workload_types/fetch_default")
    public Mono<ResponseEntity<List<WorkloadTypeDTO>>> fetchDefault
            (@Validated @RequestBody WorkloadTypeFilterDTO dto) {
        WorkloadTypeSearchContext context = workloadTypeFilterDtoMapping.toDomain(dto);
        Page<WorkloadType> domains = workloadTypeService.fetchDefault(context) ;
        List<WorkloadTypeDTO> list = workloadTypeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建工时类别
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkloadType-Create-all')")
    @ApiOperation(value = "批量新建工时类别", tags = {"工时类别" },  notes = "批量新建工时类别")
	@PostMapping("workload_types/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<WorkloadTypeDTO> dtos) {
        workloadTypeService.create(workloadTypeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除工时类别
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkloadType-Remove-all')")
    @ApiOperation(value = "批量删除工时类别", tags = {"工时类别" },  notes = "批量删除工时类别")
	@DeleteMapping("workload_types/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        workloadTypeService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新工时类别
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkloadType-Update-all')")
    @ApiOperation(value = "批量更新工时类别", tags = {"工时类别" },  notes = "批量更新工时类别")
	@PutMapping("workload_types/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<WorkloadTypeDTO> dtos) {
        workloadTypeService.update(workloadTypeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存工时类别
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkloadType-Save-all')")
    @ApiOperation(value = "批量保存工时类别", tags = {"工时类别" },  notes = "批量保存工时类别")
	@PostMapping("workload_types/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<WorkloadTypeDTO> dtos) {
        workloadTypeService.save(workloadTypeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入工时类别
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkloadType-Save-all')")
    @ApiOperation(value = "批量导入工时类别", tags = {"工时类别" },  notes = "批量导入工时类别")
	@PostMapping("workload_types/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<WorkloadTypeDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadTypeService.importData(config,ignoreError,workloadTypeDtoMapping.toDomain(dtos))));
    }

}
