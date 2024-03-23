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
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.service.WorkloadService;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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
    public WorkloadDTOMapping workloadDtoMapping;

    @Autowired
    @Lazy
    public WorkloadFilterDTOMapping workloadFilterDtoMapping;

    /**
    * 创建Create 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工时" },  notes = "Workload-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Create-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Create')")
    @PostMapping("workloads")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> create
            (@Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"工时" },  notes = "Workload-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Update-all') or hasPermission(this.workloadService.get(#id),'ibizplm-Workload-Update')")
    @VersionCheck(entity = "workload" , versionfield = "updateTime")
    @PutMapping("workloads/{id}")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Create_workload 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "Create_workload", tags = {"工时" },  notes = "Workload-Create_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Create_workload-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Create_workload')")
    @PostMapping("workloads/create_workload")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> createWorkload
            (@Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createWorkload(item)));
        else
            rt.set(createWorkload(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_workload 工时
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
    * 保存Save 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工时" },  notes = "Workload-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Save-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Save')")
    @PostMapping("workloads/save")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> save
            (@Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Update_workload 工时
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "Update_workload", tags = {"工时" },  notes = "Workload-Update_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Update_workload-all') or hasPermission(this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Update_workload')")
    @PutMapping("workloads/{id}/update_workload")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> updateWorkloadById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateWorkloadById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateWorkloadById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Update_workload 工时
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
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工时" },  notes = "Workload-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Create-all') or hasPermission('Workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Create')")
    @PostMapping("workload_types/{typeId}/workloads")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> createByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTypeId(typeId, item)));
        else
            rt.set(createByTypeId(typeId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"工时" },  notes = "Workload-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Update-all') or hasPermission('Workload_type',#typeId,this.workloadService.get(#id),'ibizplm-Workload-Update')")
    @VersionCheck(entity = "workload" , versionfield = "updateTime")
    @PutMapping("workload_types/{typeId}/workloads/{id}")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> updateByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTypeIdAndId(typeId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTypeIdAndId(typeId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Create_workload 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "Create_workload", tags = {"工时" },  notes = "Workload-Create_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Create_workload-all') or hasPermission('Workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Create_workload')")
    @PostMapping("workload_types/{typeId}/workloads/create_workload")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> createWorkloadByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createWorkloadByTypeId(typeId, item)));
        else
            rt.set(createWorkloadByTypeId(typeId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_workload 工时
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
    * 保存Save 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工时" },  notes = "Workload-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Save-all') or hasPermission('Workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Save')")
    @PostMapping("workload_types/{typeId}/workloads/save")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> saveByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTypeId(typeId, item)));
        else
            rt.set(saveByTypeId(typeId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Update_workload 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "Update_workload", tags = {"工时" },  notes = "Workload-Update_workload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Update_workload-all') or hasPermission('Workload_type',#typeId,this.workloadDtoMapping.toDomain(#dto),'ibizplm-Workload-Update_workload')")
    @PutMapping("workload_types/{typeId}/workloads/{id}/update_workload")
    public ResponseEntity<ResponseWrapper<WorkloadDTO>> updateWorkloadByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkloadDTO> dto) {
        ResponseWrapper<WorkloadDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateWorkloadByTypeIdAndId(typeId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateWorkloadByTypeIdAndId(typeId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Update_workload 工时
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
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"工时" },  notes = "Workload-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Get-all')  or hasPermission(this.workloadDtoMapping.toDomain(returnObject.body),'ibizplm-Workload-Get')")
    @GetMapping("workloads/{id}")
    public ResponseEntity<WorkloadDTO> getById
            (@PathVariable("id") String id) {
        Workload rt = workloadService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 工时
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"工时" },  notes = "Workload-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Remove-all') or hasPermission(this.workloadService.get(#id),'ibizplm-Workload-Remove')")
    @DeleteMapping("workloads/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = workloadService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工时" },  notes = "Workload-CheckKey ")
    @PostMapping("workloads/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        Integer rt = workloadService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工时" },  notes = "Workload-GetDraft ")
    @GetMapping("workloads/getdraft")
    public ResponseEntity<WorkloadDTO> getDraft
            (@SpringQueryMap WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        Workload rt = workloadService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt));
    }

    /**
    * Get_register_workload 工时
    * 修改实际工时表单获取数据行为
    *
    * @param id id
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "Get_register_workload", tags = {"工时" },  notes = "Workload-Get_register_workload 修改实际工时表单获取数据行为")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Get_register_workload-all') or hasPermission(this.workloadService.get(#id),'ibizplm-Workload-Get_register_workload')")
    @GetMapping("workloads/{id}/get_register_workload")
    public ResponseEntity<WorkloadDTO> getRegisterWorkloadById
            (@PathVariable("id") String id) {
        Workload rt = workloadService.getRegisterWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCalendar 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchCalendar", tags = {"工时" },  notes = "Workload-FetchCalendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchCalendar-all') or hasPermission(#dto,'ibizplm-Workload-FetchCalendar')")
    @PostMapping("workloads/fetchcalendar")
    public ResponseEntity<List<WorkloadDTO>> fetchCalendar
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"工时" },  notes = "Workload-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchDefault-all') or hasPermission(#dto,'ibizplm-Workload-FetchDefault')")
    @PostMapping("workloads/fetchdefault")
    public ResponseEntity<List<WorkloadDTO>> fetchDefault
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchDefault(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchLog 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchLog", tags = {"工时" },  notes = "Workload-FetchLog ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchLog-all') or hasPermission(#dto,'ibizplm-Workload-FetchLog')")
    @PostMapping("workloads/fetchlog")
    public ResponseEntity<List<WorkloadDTO>> fetchLog
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_calendar 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchMy_calendar", tags = {"工时" },  notes = "Workload-FetchMy_calendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchMy_calendar-all') or hasPermission(#dto,'ibizplm-Workload-FetchMy_calendar')")
    @PostMapping("workloads/fetchmy_calendar")
    public ResponseEntity<List<WorkloadDTO>> fetchMyCalendar
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchMyCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_log 工时
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchMy_log", tags = {"工时" },  notes = "Workload-FetchMy_log ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchMy_log-all') or hasPermission(#dto,'ibizplm-Workload-FetchMy_log')")
    @PostMapping("workloads/fetchmy_log")
    public ResponseEntity<List<WorkloadDTO>> fetchMyLog
            (@Validated @RequestBody WorkloadFilterDTO dto) {
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchMyLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"工时" },  notes = "Workload-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Get-all')  or hasPermission('Workload_type',#typeId,this.workloadDtoMapping.toDomain(returnObject.body),'ibizplm-Workload-Get')")
    @GetMapping("workload_types/{typeId}/workloads/{id}")
    public ResponseEntity<WorkloadDTO> getByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id) {
        Workload rt = workloadService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 工时
    * 
    *
    * @param typeId typeId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"工时" },  notes = "Workload-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Remove-all') or hasPermission('Workload_type',#typeId,this.workloadService.get(#id),'ibizplm-Workload-Remove')")
    @DeleteMapping("workload_types/{typeId}/workloads/{id}")
    public ResponseEntity<Boolean> removeByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id) {
        Boolean rt = workloadService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工时" },  notes = "Workload-CheckKey ")
    @PostMapping("workload_types/{typeId}/workloads/checkkey")
    public ResponseEntity<Integer> checkKeyByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setTypeId(typeId);
        Integer rt = workloadService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工时" },  notes = "Workload-GetDraft ")
    @GetMapping("workload_types/{typeId}/workloads/getdraft")
    public ResponseEntity<WorkloadDTO> getDraftByTypeId
            (@PathVariable("typeId") String typeId, @SpringQueryMap WorkloadDTO dto) {
        Workload domain = workloadDtoMapping.toDomain(dto);
        domain.setTypeId(typeId);
        Workload rt = workloadService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt));
    }

    /**
    * Get_register_workload 工时
    * 修改实际工时表单获取数据行为
    *
    * @param typeId typeId
    * @param id id
    * @return ResponseEntity<WorkloadDTO>
    */
    @ApiOperation(value = "Get_register_workload", tags = {"工时" },  notes = "Workload-Get_register_workload 修改实际工时表单获取数据行为")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-Get_register_workload-all') or hasPermission('Workload_type',#typeId,this.workloadService.get(#id),'ibizplm-Workload-Get_register_workload')")
    @GetMapping("workload_types/{typeId}/workloads/{id}/get_register_workload")
    public ResponseEntity<WorkloadDTO> getRegisterWorkloadByTypeIdAndId
            (@PathVariable("typeId") String typeId, @PathVariable("id") String id) {
        Workload rt = workloadService.getRegisterWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(workloadDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCalendar 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchCalendar", tags = {"工时" },  notes = "Workload-FetchCalendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchCalendar-all') or hasPermission('Workload_type',#typeId,#dto,'ibizplm-Workload-FetchCalendar')")
    @PostMapping("workload_types/{typeId}/workloads/fetchcalendar")
    public ResponseEntity<List<WorkloadDTO>> fetchCalendarByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"工时" },  notes = "Workload-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchDefault-all') or hasPermission('Workload_type',#typeId,#dto,'ibizplm-Workload-FetchDefault')")
    @PostMapping("workload_types/{typeId}/workloads/fetchdefault")
    public ResponseEntity<List<WorkloadDTO>> fetchDefaultByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchDefault(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchLog 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchLog", tags = {"工时" },  notes = "Workload-FetchLog ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchLog-all') or hasPermission('Workload_type',#typeId,#dto,'ibizplm-Workload-FetchLog')")
    @PostMapping("workload_types/{typeId}/workloads/fetchlog")
    public ResponseEntity<List<WorkloadDTO>> fetchLogByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_calendar 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchMy_calendar", tags = {"工时" },  notes = "Workload-FetchMy_calendar ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchMy_calendar-all') or hasPermission('Workload_type',#typeId,#dto,'ibizplm-Workload-FetchMy_calendar')")
    @PostMapping("workload_types/{typeId}/workloads/fetchmy_calendar")
    public ResponseEntity<List<WorkloadDTO>> fetchMyCalendarByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchMyCalendar(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_log 工时
    * 
    *
    * @param typeId typeId
    * @param dto dto
    * @return ResponseEntity<List<WorkloadDTO>>
    */
    @ApiOperation(value = "查询FetchMy_log", tags = {"工时" },  notes = "Workload-FetchMy_log ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Workload-FetchMy_log-all') or hasPermission('Workload_type',#typeId,#dto,'ibizplm-Workload-FetchMy_log')")
    @PostMapping("workload_types/{typeId}/workloads/fetchmy_log")
    public ResponseEntity<List<WorkloadDTO>> fetchMyLogByTypeId
            (@PathVariable("typeId") String typeId, @Validated @RequestBody WorkloadFilterDTO dto) {
        dto.setTypeIdEQ(typeId);
        WorkloadSearchContext context = workloadFilterDtoMapping.toDomain(dto);
        Page<Workload> domains = workloadService.searchMyLog(context) ;
        List<WorkloadDTO> list = workloadDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建工时
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Create-all')")
    @ApiOperation(value = "批量新建工时", tags = {"工时" },  notes = "批量新建工时")
	@PostMapping("workloads/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WorkloadDTO> dtos) {
        workloadService.createBatch(workloadDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除工时
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Remove-all')")
    @ApiOperation(value = "批量删除工时", tags = {"工时" },  notes = "批量删除工时")
	@DeleteMapping("workloads/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        workloadService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新工时
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Update-all')")
    @ApiOperation(value = "批量更新工时", tags = {"工时" },  notes = "批量更新工时")
	@PutMapping("workloads/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WorkloadDTO> dtos) {
        workloadService.updateBatch(workloadDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存工时
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Save-all')")
    @ApiOperation(value = "批量保存工时", tags = {"工时" },  notes = "批量保存工时")
	@PostMapping("workloads/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WorkloadDTO> dtos) {
        workloadService.saveBatch(workloadDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入工时
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Workload-Save-all')")
    @ApiOperation(value = "批量导入工时", tags = {"工时" },  notes = "批量导入工时")
	@PostMapping("workloads/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<WorkloadDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(workloadService.importData(config,ignoreError,workloadDtoMapping.toDomain(dtos)));
    }

}
