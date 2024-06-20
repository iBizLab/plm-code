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
import cn.ibizlab.plm.core.prodmgmt.domain.TicketType;
import cn.ibizlab.plm.core.prodmgmt.service.TicketTypeService;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketTypeSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[TicketType] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTicketTypeResource {

    @Autowired
    public TicketTypeService ticketTypeService;

    @Autowired
    @Lazy
    public TicketTypeDTOMapping ticketTypeDtoMapping;

    @Autowired
    @Lazy
    public TicketTypeFilterDTOMapping ticketTypeFilterDtoMapping;

    /**
    * 创建Create 工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketTypeDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工单类型" },  notes = "TicketType-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TicketType-Create-all') or hasPermission(this.ticketTypeDtoMapping.toDomain(#dto),'ibizplm-TicketType-Create')")
    @PostMapping("ticket_types")
    public ResponseEntity<ResponseWrapper<TicketTypeDTO>> create
            (@Validated @RequestBody RequestWrapper<TicketTypeDTO> dto) {
        ResponseWrapper<TicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketTypeDTO>
    */   
    public TicketTypeDTO create
            (TicketTypeDTO dto) {
        TicketType domain = ticketTypeDtoMapping.toDomain(dto);
        ticketTypeService.create(domain);
        TicketType rt = domain;
        return ticketTypeDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工单类型
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketTypeDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"工单类型" },  notes = "TicketType-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TicketType-Update-all') or hasPermission(this.ticketTypeService.get(#id),'ibizplm-TicketType-Update')")
    @VersionCheck(entity = "tickettype" , versionfield = "updateTime")
    @PutMapping("ticket_types/{id}")
    public ResponseEntity<ResponseWrapper<TicketTypeDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketTypeDTO> dto) {
        ResponseWrapper<TicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 工单类型
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketTypeDTO>
    */   
    public TicketTypeDTO updateById
            (String id, TicketTypeDTO dto) {
        TicketType domain = ticketTypeDtoMapping.toDomain(dto);
        domain.setId(id);
        ticketTypeService.update(domain);
        TicketType rt = domain;
        return ticketTypeDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketTypeDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工单类型" },  notes = "TicketType-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TicketType-Save-all') or hasPermission(this.ticketTypeDtoMapping.toDomain(#dto),'ibizplm-TicketType-Save')")
    @PostMapping("ticket_types/save")
    public ResponseEntity<ResponseWrapper<TicketTypeDTO>> save
            (@Validated @RequestBody RequestWrapper<TicketTypeDTO> dto) {
        ResponseWrapper<TicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketTypeDTO>
    */   
    public TicketTypeDTO save
            (TicketTypeDTO dto) {
        TicketType domain = ticketTypeDtoMapping.toDomain(dto);
        ticketTypeService.save(domain);
        TicketType rt = domain;
        return ticketTypeDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工单类型
    * 
    *
    * @param id id
    * @return ResponseEntity<TicketTypeDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"工单类型" },  notes = "TicketType-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TicketType-Get-all')  or hasPermission(this.ticketTypeDtoMapping.toDomain(returnObject.body),'ibizplm-TicketType-Get')")
    @GetMapping("ticket_types/{id}")
    public ResponseEntity<TicketTypeDTO> getById
            (@PathVariable("id") String id) {
        TicketType rt = ticketTypeService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketTypeDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 工单类型
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"工单类型" },  notes = "TicketType-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TicketType-Remove-all') or hasPermission(this.ticketTypeService.get(#id),'ibizplm-TicketType-Remove')")
    @DeleteMapping("ticket_types/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = ticketTypeService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工单类型" },  notes = "TicketType-CheckKey ")
    @PostMapping("ticket_types/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody TicketTypeDTO dto) {
        TicketType domain = ticketTypeDtoMapping.toDomain(dto);
        Integer rt = ticketTypeService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_con_ticket 工单类型
    * 
    *
    * @param id id
    * @return ResponseEntity<TicketTypeDTO>
    */
    @ApiOperation(value = "get_con_ticket", tags = {"工单类型" },  notes = "TicketType-get_con_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TicketType-get_con_ticket-all') or hasPermission(this.ticketTypeService.get(#id),'ibizplm-TicketType-get_con_ticket')")
    @GetMapping("ticket_types/{id}/get_con_ticket")
    public ResponseEntity<TicketTypeDTO> getConTicketById
            (@PathVariable("id") String id) {
        TicketType rt = ticketTypeService.getConTicket(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketTypeDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketTypeDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工单类型" },  notes = "TicketType-GetDraft ")
    @GetMapping("ticket_types/get_draft")
    public ResponseEntity<TicketTypeDTO> getDraft
            (@SpringQueryMap TicketTypeDTO dto) {
        TicketType domain = ticketTypeDtoMapping.toDomain(dto);
        TicketType rt = ticketTypeService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ticketTypeDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketTypeDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工单类型" },  notes = "TicketType-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TicketType-fetch_default-all') or hasPermission(#dto,'ibizplm-TicketType-fetch_default')")
    @PostMapping("ticket_types/fetch_default")
    public ResponseEntity<List<TicketTypeDTO>> fetchDefault
            (@Validated @RequestBody TicketTypeFilterDTO dto) {
        TicketTypeSearchContext context = ticketTypeFilterDtoMapping.toDomain(dto);
        Page<TicketType> domains = ticketTypeService.fetchDefault(context) ;
        List<TicketTypeDTO> list = ticketTypeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_not_exists_ticket_type 工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketTypeDTO>>
    */
    @ApiOperation(value = "查询fetch_not_exists_ticket_type", tags = {"工单类型" },  notes = "TicketType-fetch_not_exists_ticket_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TicketType-fetch_not_exists_ticket_type-all') or hasPermission(#dto,'ibizplm-TicketType-fetch_not_exists_ticket_type')")
    @PostMapping("ticket_types/fetch_not_exists_ticket_type")
    public ResponseEntity<List<TicketTypeDTO>> fetchNotExistsTicketType
            (@Validated @RequestBody TicketTypeFilterDTO dto) {
        TicketTypeSearchContext context = ticketTypeFilterDtoMapping.toDomain(dto);
        Page<TicketType> domains = ticketTypeService.fetchNotExistsTicketType(context) ;
        List<TicketTypeDTO> list = ticketTypeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建工单类型
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TicketType-Create-all')")
    @ApiOperation(value = "批量新建工单类型", tags = {"工单类型" },  notes = "批量新建工单类型")
	@PostMapping("ticket_types/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TicketTypeDTO> dtos) {
        ticketTypeService.create(ticketTypeDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除工单类型
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TicketType-Remove-all')")
    @ApiOperation(value = "批量删除工单类型", tags = {"工单类型" },  notes = "批量删除工单类型")
	@DeleteMapping("ticket_types/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ticketTypeService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新工单类型
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TicketType-Update-all')")
    @ApiOperation(value = "批量更新工单类型", tags = {"工单类型" },  notes = "批量更新工单类型")
	@PutMapping("ticket_types/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TicketTypeDTO> dtos) {
        ticketTypeService.update(ticketTypeDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存工单类型
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TicketType-Save-all')")
    @ApiOperation(value = "批量保存工单类型", tags = {"工单类型" },  notes = "批量保存工单类型")
	@PostMapping("ticket_types/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TicketTypeDTO> dtos) {
        ticketTypeService.save(ticketTypeDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入工单类型
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TicketType-Save-all')")
    @ApiOperation(value = "批量导入工单类型", tags = {"工单类型" },  notes = "批量导入工单类型")
	@PostMapping("ticket_types/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TicketTypeDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(ticketTypeService.importData(config,ignoreError,ticketTypeDtoMapping.toDomain(dtos)));
    }

}
