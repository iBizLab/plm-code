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
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.service.WorkloadService;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Workload] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkloadResource {

    @Autowired
    public WorkloadService workloadService;

    @Autowired
    @Lazy
    public WorkloadBiSearchGroupDTOMapping workloadBiSearchGroupDtoMapping;

    @Autowired
    @Lazy
    public WorkloadDTOMapping workloadDtoMapping;

    @Autowired
    @Lazy
    public WorkloadFilterDTOMapping workloadFilterDtoMapping;

    /**
    * 创建Create 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工时" },  notes = "Workload-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Create-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Create')")
    @PostMapping("workloads")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>create
            (@Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO create
            (WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        workloadService.create(domain);
        Workload rt = domain;
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工时
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工时" },  notes = "Workload-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Update-all') or hasPermission(this.workloadService.get(#id),'ibizplm-Workload-Update')")
    @VersionCheck(entity = "workload" , versionfield = "updateTime")
    @PutMapping("workloads/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工时
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO updateById
            (String id, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setId(id);
        workloadService.update(domain);
        Workload rt = domain;
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * create_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "create_workload", tags = {"工时" },  notes = "Workload-create_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-create_workload-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-create_workload')")
    @PostMapping("workloads/create_workload")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>createWorkload
            (@Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createWorkload(item)));
        else
            rt.set(createWorkload(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_workload 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO createWorkload
            (WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        Workload rt = workloadService.createWorkload(domain);
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * fill_workload_data 工时
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "fill_workload_data", tags = {"工时" },  notes = "Workload-fill_workload_data ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fill_workload_data-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-fill_workload_data')")
    @PostMapping("workloads/{id}/fill_workload_data")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>fillWorkloadDataById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillWorkloadDataById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillWorkloadDataById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_workload_data 工时
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO fillWorkloadDataById
            (String id, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setId(id);
        Workload rt = workloadService.fillWorkloadData(domain);
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工时" },  notes = "Workload-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Save-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Save')")
    @PostMapping("workloads/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>save
            (@Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO save
            (WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        workloadService.save(domain);
        Workload rt = domain;
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * update_workload 工时
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "update_workload", tags = {"工时" },  notes = "Workload-update_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-update_workload-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-update_workload')")
    @PutMapping("workloads/{id}/update_workload")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>updateWorkloadById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateWorkloadById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateWorkloadById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * update_workload 工时
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO updateWorkloadById
            (String id, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setId(id);
        Workload rt = workloadService.updateWorkload(domain);
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工时" },  notes = "Workload-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Create-all') or hasPermission('workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Create')")
    @PostMapping("workload_types/{typeId}/workloads")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>createByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTypeId(typeId, item)));
        else
            rt.set(createByTypeId(typeId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO createByTypeId
            (String typeId, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setTypeId(typeId);
        workloadService.create(domain);
        Workload rt = domain;
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工时" },  notes = "Workload-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Update-all') or hasPermission('workload_type',#typeId,this.workloadService.get(#id),'ibizplm-Workload-Update')")
    @VersionCheck(entity = "workload" , versionfield = "updateTime")
    @PutMapping("workload_types/{typeId}/workloads/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>updateByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTypeIdAndId(typeId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTypeIdAndId(typeId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO updateByTypeIdAndId
            (String typeId, String id, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setId(id);
        workloadService.update(domain);
        Workload rt = domain;
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * create_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "create_workload", tags = {"工时" },  notes = "Workload-create_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-create_workload-all') or hasPermission('workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-create_workload')")
    @PostMapping("workload_types/{typeId}/workloads/create_workload")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>createWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createWorkloadByTypeId(typeId, item)));
        else
            rt.set(createWorkloadByTypeId(typeId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO createWorkloadByTypeId
            (String typeId, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setTypeId(typeId);
        Workload rt = workloadService.createWorkload(domain);
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * fill_workload_data 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "fill_workload_data", tags = {"工时" },  notes = "Workload-fill_workload_data ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fill_workload_data-all') or hasPermission('workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-fill_workload_data')")
    @PostMapping("workload_types/{typeId}/workloads/{id}/fill_workload_data")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>fillWorkloadDataByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillWorkloadDataByTypeIdAndId(typeId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillWorkloadDataByTypeIdAndId(typeId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_workload_data 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO fillWorkloadDataByTypeIdAndId
            (String typeId, String id, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setId(id);
        Workload rt = workloadService.fillWorkloadData(domain);
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工时" },  notes = "Workload-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Save-all') or hasPermission('workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Save')")
    @PostMapping("workload_types/{typeId}/workloads/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>saveByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTypeId(typeId, item)));
        else
            rt.set(saveByTypeId(typeId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO saveByTypeId
            (String typeId, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setTypeId(typeId);
        workloadService.save(domain);
        Workload rt = domain;
        return workloadDtoMapping.toDto(rt);
    }

    /**
    * update_workload 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "update_workload", tags = {"工时" },  notes = "Workload-update_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-update_workload-all') or hasPermission('workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-update_workload')")
    @PutMapping("workload_types/{typeId}/workloads/{id}/update_workload")
    public Mono<ResponseEntity<ResponseWrapper<WorkloadDTO>>>updateWorkloadByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateWorkloadByTypeIdAndId(typeId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateWorkloadByTypeIdAndId(typeId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * update_workload 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */   
    public WorkloadDTO updateWorkloadByTypeIdAndId
            (String typeId, String id, WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setId(id);
        Workload rt = workloadService.updateWorkload(domain);
        return workloadDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工时
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工时" },  notes = "Workload-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Get-all')  or hasPermission(this.workloadDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Workload-Get')")
    @GetMapping("workloads/{id}")
    public Mono<ResponseEntity<WorkloadDTO>> getById
            (@PathVariable("id") String id) {
        Workload rt = workloadService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工时
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工时" },  notes = "Workload-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Remove-all') or hasPermission(this.workloadService.get(#id),'ibizplm-Workload-Remove')")
    @DeleteMapping("workloads/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = workloadService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工时" },  notes = "Workload-CheckKey ")
    @PostMapping("workloads/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        CheckKeyStatus rt = workloadService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工时" },  notes = "Workload-GetDraft ")
    @GetMapping("workloads/get_draft")
    public Mono<ResponseEntity<WorkloadDTO>> getDraft
            (@SpringQueryMap WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        Workload rt = workloadService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt)));
    }

    /**
    * get_register_workload 工时
    * 修改实际工时表单获取数据行为
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "get_register_workload", tags = {"工时" },  notes = "Workload-get_register_workload 修改实际工时表单获取数据行为")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-get_register_workload-all') or hasPermission(this.workloadService.get(#id),'ibizplm-Workload-get_register_workload')")
    @GetMapping("workloads/{id}/get_register_workload")
    public Mono<ResponseEntity<WorkloadDTO>> getRegisterWorkloadById
            (@PathVariable("id") String id) {
        Workload rt = workloadService.getRegisterWorkload(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_detail 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工时" },  notes = "Workload-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_bi_detail-all') or hasPermission(#dto,'ibizplm-Workload-fetch_bi_detail')")
    @PostMapping("workloads/fetch_bi_detail")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchBiDetail
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchBiDetail(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"工时" },  notes = "Workload-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-Workload-fetch_bi_search')")
    @PostMapping("workloads/fetch_bi_search")
    public Mono<ResponseEntity<List<WorkloadBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchBiSearch(context) ;
        List<WorkloadBiSearchGroupDTO> list = workloadBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_calendar 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_calendar", tags = {"工时" },  notes = "Workload-fetch_calendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_calendar-all') or hasPermission(#dto,'ibizplm-Workload-fetch_calendar')")
    @PostMapping("workloads/fetch_calendar")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchCalendar
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工时" },  notes = "Workload-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_default-all') or hasPermission(#dto,'ibizplm-Workload-fetch_default')")
    @PostMapping("workloads/fetch_default")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchDefault
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchDefault(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_idea_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_workload", tags = {"工时" },  notes = "Workload-fetch_idea_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_idea_workload-all') or hasPermission(#dto,'ibizplm-Workload-fetch_idea_workload')")
    @PostMapping("workloads/fetch_idea_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchIdeaWorkload
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchIdeaWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_log 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_log", tags = {"工时" },  notes = "Workload-fetch_log ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_log-all') or hasPermission(#dto,'ibizplm-Workload-fetch_log')")
    @PostMapping("workloads/fetch_log")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchLog
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_member_dimension 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_member_dimension", tags = {"工时" },  notes = "Workload-fetch_member_dimension ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_member_dimension-all') or hasPermission(#dto,'ibizplm-Workload-fetch_member_dimension')")
    @PostMapping("workloads/fetch_member_dimension")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMemberDimension
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMemberDimension(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_mob_calendar 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_mob_calendar", tags = {"工时" },  notes = "Workload-fetch_mob_calendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_mob_calendar-all') or hasPermission(#dto,'ibizplm-Workload-fetch_mob_calendar')")
    @PostMapping("workloads/fetch_mob_calendar")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMobCalendar
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMobCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_calendar 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_calendar", tags = {"工时" },  notes = "Workload-fetch_my_calendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_calendar-all') or hasPermission(#dto,'ibizplm-Workload-fetch_my_calendar')")
    @PostMapping("workloads/fetch_my_calendar")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyCalendar
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_idea_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_idea_workload", tags = {"工时" },  notes = "Workload-fetch_my_idea_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_idea_workload-all') or hasPermission(#dto,'ibizplm-Workload-fetch_my_idea_workload')")
    @PostMapping("workloads/fetch_my_idea_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyIdeaWorkload
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyIdeaWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_log 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_log", tags = {"工时" },  notes = "Workload-fetch_my_log ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_log-all') or hasPermission(#dto,'ibizplm-Workload-fetch_my_log')")
    @PostMapping("workloads/fetch_my_log")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyLog
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_mob_log 工时
    * 移动端我的工时日志
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_mob_log", tags = {"工时" },  notes = "Workload-fetch_my_mob_log 移动端我的工时日志")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_mob_log-all') or hasPermission(#dto,'ibizplm-Workload-fetch_my_mob_log')")
    @PostMapping("workloads/fetch_my_mob_log")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyMobLog
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyMobLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_test_case_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_test_case_workload", tags = {"工时" },  notes = "Workload-fetch_my_test_case_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_test_case_workload-all') or hasPermission(#dto,'ibizplm-Workload-fetch_my_test_case_workload')")
    @PostMapping("workloads/fetch_my_test_case_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyTestCaseWorkload
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyTestCaseWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_type_of 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_type_of", tags = {"工时" },  notes = "Workload-fetch_my_type_of ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_type_of-all') or hasPermission(#dto,'ibizplm-Workload-fetch_my_type_of')")
    @PostMapping("workloads/fetch_my_type_of")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyTypeOf
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyTypeOf(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_work_item_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_work_item_workload", tags = {"工时" },  notes = "Workload-fetch_my_work_item_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_work_item_workload-all') or hasPermission(#dto,'ibizplm-Workload-fetch_my_work_item_workload')")
    @PostMapping("workloads/fetch_my_work_item_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyWorkItemWorkload
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyWorkItemWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_workload", tags = {"工时" },  notes = "Workload-fetch_my_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_workload-all') or hasPermission(#dto,'ibizplm-Workload-fetch_my_workload')")
    @PostMapping("workloads/fetch_my_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyWorkload
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_test_case_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_test_case_workload", tags = {"工时" },  notes = "Workload-fetch_test_case_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_test_case_workload-all') or hasPermission(#dto,'ibizplm-Workload-fetch_test_case_workload')")
    @PostMapping("workloads/fetch_test_case_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchTestCaseWorkload
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchTestCaseWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_type_of 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_type_of", tags = {"工时" },  notes = "Workload-fetch_type_of ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_type_of-all') or hasPermission(#dto,'ibizplm-Workload-fetch_type_of')")
    @PostMapping("workloads/fetch_type_of")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchTypeOf
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchTypeOf(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user_group_link 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_user_group_link", tags = {"工时" },  notes = "Workload-fetch_user_group_link ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_user_group_link-all') or hasPermission(#dto,'ibizplm-Workload-fetch_user_group_link')")
    @PostMapping("workloads/fetch_user_group_link")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchUserGroupLink
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchUserGroupLink(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user_group_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_user_group_workload", tags = {"工时" },  notes = "Workload-fetch_user_group_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_user_group_workload-all') or hasPermission(#dto,'ibizplm-Workload-fetch_user_group_workload')")
    @PostMapping("workloads/fetch_user_group_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchUserGroupWorkload
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchUserGroupWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_workload 工时
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_workload", tags = {"工时" },  notes = "Workload-fetch_work_item_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_work_item_workload-all') or hasPermission(#dto,'ibizplm-Workload-fetch_work_item_workload')")
    @PostMapping("workloads/fetch_work_item_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchWorkItemWorkload
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchWorkItemWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工时" },  notes = "Workload-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Get-all')  or hasPermission('workload_type',#typeId,this.workloadDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Workload-Get')")
    @GetMapping("workload_types/{typeId}/workloads/{id}")
    public Mono<ResponseEntity<WorkloadDTO>> getByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id) {
        Workload rt = workloadService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工时" },  notes = "Workload-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Remove-all') or hasPermission('workload_type',#typeId,this.workloadService.get(#id),'ibizplm-Workload-Remove')")
    @DeleteMapping("workload_types/{typeId}/workloads/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id) {
        Boolean rt = workloadService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工时" },  notes = "Workload-CheckKey ")
    @PostMapping("workload_types/{typeId}/workloads/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setTypeId(typeId);
        CheckKeyStatus rt = workloadService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工时" },  notes = "Workload-GetDraft ")
    @GetMapping("workload_types/{typeId}/workloads/get_draft")
    public Mono<ResponseEntity<WorkloadDTO>> getDraftByTypeId
            (@PathVariable("typeId") String typeId, @SpringQueryMap WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setTypeId(typeId);
        Workload rt = workloadService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt)));
    }

    /**
    * get_register_workload 工时
    * 修改实际工时表单获取数据行为
    *
    * @param typeId typeId
    * @param id id
    * @return Mono<ResponseEntity<WorkloadDTO>>
    */
    @ApiOperation(value = "get_register_workload", tags = {"工时" },  notes = "Workload-get_register_workload 修改实际工时表单获取数据行为")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-get_register_workload-all') or hasPermission('workload_type',#typeId,this.workloadService.get(#id),'ibizplm-Workload-get_register_workload')")
    @GetMapping("workload_types/{typeId}/workloads/{id}/get_register_workload")
    public Mono<ResponseEntity<WorkloadDTO>> getRegisterWorkloadByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id) {
        Workload rt = workloadService.getRegisterWorkload(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_detail 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工时" },  notes = "Workload-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_bi_detail-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_bi_detail')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_bi_detail")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchBiDetailByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchBiDetail(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"工时" },  notes = "Workload-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_bi_search-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_bi_search')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_bi_search")
    public Mono<ResponseEntity<List<WorkloadBiSearchGroupDTO>>> fetchBiSearchByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchBiSearch(context) ;
        List<WorkloadBiSearchGroupDTO> list = workloadBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_calendar 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_calendar", tags = {"工时" },  notes = "Workload-fetch_calendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_calendar-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_calendar')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_calendar")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchCalendarByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工时" },  notes = "Workload-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_default-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_default')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_default")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchDefaultByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchDefault(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_idea_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_workload", tags = {"工时" },  notes = "Workload-fetch_idea_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_idea_workload-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_idea_workload')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_idea_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchIdeaWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchIdeaWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_log 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_log", tags = {"工时" },  notes = "Workload-fetch_log ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_log-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_log')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_log")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchLogByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_member_dimension 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_member_dimension", tags = {"工时" },  notes = "Workload-fetch_member_dimension ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_member_dimension-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_member_dimension')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_member_dimension")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMemberDimensionByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMemberDimension(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_mob_calendar 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_mob_calendar", tags = {"工时" },  notes = "Workload-fetch_mob_calendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_mob_calendar-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_mob_calendar')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_mob_calendar")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMobCalendarByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMobCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_calendar 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_calendar", tags = {"工时" },  notes = "Workload-fetch_my_calendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_calendar-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_my_calendar')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_my_calendar")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyCalendarByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_idea_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_idea_workload", tags = {"工时" },  notes = "Workload-fetch_my_idea_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_idea_workload-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_my_idea_workload')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_my_idea_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyIdeaWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyIdeaWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_log 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_log", tags = {"工时" },  notes = "Workload-fetch_my_log ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_log-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_my_log')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_my_log")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyLogByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_mob_log 工时
    * 移动端我的工时日志
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_mob_log", tags = {"工时" },  notes = "Workload-fetch_my_mob_log 移动端我的工时日志")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_mob_log-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_my_mob_log')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_my_mob_log")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyMobLogByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyMobLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_test_case_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_test_case_workload", tags = {"工时" },  notes = "Workload-fetch_my_test_case_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_test_case_workload-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_my_test_case_workload')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_my_test_case_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyTestCaseWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyTestCaseWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_type_of 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_type_of", tags = {"工时" },  notes = "Workload-fetch_my_type_of ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_type_of-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_my_type_of')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_my_type_of")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyTypeOfByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyTypeOf(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_work_item_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_work_item_workload", tags = {"工时" },  notes = "Workload-fetch_my_work_item_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_work_item_workload-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_my_work_item_workload')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_my_work_item_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyWorkItemWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyWorkItemWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_workload", tags = {"工时" },  notes = "Workload-fetch_my_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_my_workload-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_my_workload')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_my_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchMyWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchMyWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_test_case_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_test_case_workload", tags = {"工时" },  notes = "Workload-fetch_test_case_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_test_case_workload-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_test_case_workload')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_test_case_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchTestCaseWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchTestCaseWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_type_of 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_type_of", tags = {"工时" },  notes = "Workload-fetch_type_of ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_type_of-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_type_of')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_type_of")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchTypeOfByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchTypeOf(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user_group_link 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_user_group_link", tags = {"工时" },  notes = "Workload-fetch_user_group_link ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_user_group_link-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_user_group_link')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_user_group_link")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchUserGroupLinkByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchUserGroupLink(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user_group_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_user_group_workload", tags = {"工时" },  notes = "Workload-fetch_user_group_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_user_group_workload-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_user_group_workload')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_user_group_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchUserGroupWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchUserGroupWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkloadDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_workload", tags = {"工时" },  notes = "Workload-fetch_work_item_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-fetch_work_item_workload-all') or hasPermission('workload_type',#typeId,#dto,'ibizplm-Workload-fetch_work_item_workload')")
    @PostMapping("workload_types/{typeId}/workloads/fetch_work_item_workload")
    public Mono<ResponseEntity<List<WorkloadDTO>>> fetchWorkItemWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.fetchWorkItemWorkload(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建工时
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Create-all')")
    @ApiOperation(value = "批量新建工时", tags = {"工时" },  notes = "批量新建工时")
	@PostMapping("workloads/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<WorkloadDTO> dtos) {
        workloadService.create(workloadDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除工时
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Remove-all')")
    @ApiOperation(value = "批量删除工时", tags = {"工时" },  notes = "批量删除工时")
	@DeleteMapping("workloads/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        workloadService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新工时
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Update-all')")
    @ApiOperation(value = "批量更新工时", tags = {"工时" },  notes = "批量更新工时")
	@PutMapping("workloads/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<WorkloadDTO> dtos) {
        workloadService.update(workloadDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存工时
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Save-all')")
    @ApiOperation(value = "批量保存工时", tags = {"工时" },  notes = "批量保存工时")
	@PostMapping("workloads/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<WorkloadDTO> dtos) {
        workloadService.save(workloadDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入工时
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Save-all')")
    @ApiOperation(value = "批量导入工时", tags = {"工时" },  notes = "批量导入工时")
	@PostMapping("workloads/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<WorkloadDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(workloadService.importData(config,ignoreError,workloadDtoMapping.toDomain(dtos))));
    }

}
