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
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Ticket] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTicketResource {

    @Autowired
    public TicketService ticketService;

    @Autowired
    @Lazy
    public TicketAdvancedSearchDTOMapping ticketAdvancedSearchDtoMapping;

    @Autowired
    @Lazy
    public TicketAssigneeDTOMapping ticketAssigneeDtoMapping;

    @Autowired
    @Lazy
    public TicketDTOMapping ticketDtoMapping;

    @Autowired
    @Lazy
    public TicketFilterDTOMapping ticketFilterDtoMapping;

    /**
    * 创建Create 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工单" },  notes = "Ticket-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Create-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-Create')")
    @PostMapping("tickets")
    public ResponseEntity<ResponseWrapper<TicketDTO>> create
            (@Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO create
            (TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        ticketService.create(domain);
        Ticket rt = domain;
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"工单" },  notes = "Ticket-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Update-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-Update')")
    @VersionCheck(entity = "ticket" , versionfield = "updateTime")
    @PutMapping("tickets/{id}")
    public ResponseEntity<ResponseWrapper<TicketDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO updateById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        ticketService.update(domain);
        Ticket rt = domain;
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * activate 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "activate", tags = {"工单" },  notes = "Ticket-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-activate-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-activate')")
    @PostMapping("tickets/{id}/activate")
    public ResponseEntity<ResponseWrapper<TicketDTO>> activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * activate 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO activateById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.activate(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * allocate_person 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "allocate_person", tags = {"工单" },  notes = "Ticket-allocate_person ")
    @PostMapping("tickets/{id}/allocate_person")
    public ResponseEntity<ResponseWrapper<TicketDTO>> allocatePersonById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(allocatePersonById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(allocatePersonById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * allocate_person 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO allocatePersonById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.allocatePerson(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * archive 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "archive", tags = {"工单" },  notes = "Ticket-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-archive-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-archive')")
    @PostMapping("tickets/{id}/archive")
    public ResponseEntity<ResponseWrapper<TicketDTO>> archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * archive 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO archiveById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.archive(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * choose_tag 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "choose_tag", tags = {"工单" },  notes = "Ticket-choose_tag ")
    @PostMapping("tickets/{id}/choose_tag")
    public ResponseEntity<ResponseWrapper<TicketDTO>> chooseTagById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseTagById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseTagById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * choose_tag 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO chooseTagById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.chooseTag(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * customer_choose_ticket 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "customer_choose_ticket", tags = {"工单" },  notes = "Ticket-customer_choose_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-customer_choose_ticket-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-customer_choose_ticket')")
    @PutMapping("tickets/{id}/customer_choose_ticket")
    public ResponseEntity<ResponseWrapper<TicketDTO>> customerChooseTicketById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerChooseTicketById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerChooseTicketById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * customer_choose_ticket 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO customerChooseTicketById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.customerChooseTicket(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * customer_del_ticket 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "customer_del_ticket", tags = {"工单" },  notes = "Ticket-customer_del_ticket ")
    @PostMapping("tickets/{id}/customer_del_ticket")
    public ResponseEntity<ResponseWrapper<TicketDTO>> customerDelTicketById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerDelTicketById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerDelTicketById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * customer_del_ticket 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO customerDelTicketById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.customerDelTicket(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * del_relation 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "del_relation", tags = {"工单" },  notes = "Ticket-del_relation ")
    @PostMapping("tickets/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<TicketDTO>> delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_relation 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO delRelationById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.delRelation(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * delete 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "delete", tags = {"工单" },  notes = "Ticket-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-delete-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-delete')")
    @PostMapping("tickets/{id}/delete")
    public ResponseEntity<ResponseWrapper<TicketDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO deleteById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.delete(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * others_relation_ticket 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "others_relation_ticket", tags = {"工单" },  notes = "Ticket-others_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-others_relation_ticket-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-others_relation_ticket')")
    @PutMapping("tickets/{id}/others_relation_ticket")
    public ResponseEntity<ResponseWrapper<TicketDTO>> othersRelationTicketById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationTicketById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationTicketById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * others_relation_ticket 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO othersRelationTicketById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.othersRelationTicket(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * product_ticket_re_counters 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "product_ticket_re_counters", tags = {"工单" },  notes = "Ticket-product_ticket_re_counters ")
    @PostMapping("tickets/{id}/product_ticket_re_counters")
    public ResponseEntity<ResponseWrapper<TicketDTO>> productTicketReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productTicketReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productTicketReCountersById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * product_ticket_re_counters 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO productTicketReCountersById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.productTicketReCounters(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * recover 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "recover", tags = {"工单" },  notes = "Ticket-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-recover-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-recover')")
    @PostMapping("tickets/{id}/recover")
    public ResponseEntity<ResponseWrapper<TicketDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * recover 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO recoverById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.recover(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工单" },  notes = "Ticket-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Save-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-Save')")
    @PostMapping("tickets/save")
    public ResponseEntity<ResponseWrapper<TicketDTO>> save
            (@Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO save
            (TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        ticketService.save(domain);
        Ticket rt = domain;
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工单" },  notes = "Ticket-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Create-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-Create')")
    @PostMapping("products/{productId}/tickets")
    public ResponseEntity<ResponseWrapper<TicketDTO>> createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO createByProductId
            (String productId, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ticketService.create(domain);
        Ticket rt = domain;
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"工单" },  notes = "Ticket-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Update-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-Update')")
    @VersionCheck(entity = "ticket" , versionfield = "updateTime")
    @PutMapping("products/{productId}/tickets/{id}")
    public ResponseEntity<ResponseWrapper<TicketDTO>> updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO updateByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        ticketService.update(domain);
        Ticket rt = domain;
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * activate 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "activate", tags = {"工单" },  notes = "Ticket-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-activate-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-activate')")
    @PostMapping("products/{productId}/tickets/{id}/activate")
    public ResponseEntity<ResponseWrapper<TicketDTO>> activateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * activate 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO activateByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.activate(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * allocate_person 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "allocate_person", tags = {"工单" },  notes = "Ticket-allocate_person ")
    @PostMapping("products/{productId}/tickets/{id}/allocate_person")
    public ResponseEntity<ResponseWrapper<TicketDTO>> allocatePersonByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(allocatePersonByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(allocatePersonByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * allocate_person 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO allocatePersonByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.allocatePerson(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * archive 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "archive", tags = {"工单" },  notes = "Ticket-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-archive-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-archive')")
    @PostMapping("products/{productId}/tickets/{id}/archive")
    public ResponseEntity<ResponseWrapper<TicketDTO>> archiveByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * archive 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO archiveByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.archive(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * choose_tag 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "choose_tag", tags = {"工单" },  notes = "Ticket-choose_tag ")
    @PostMapping("products/{productId}/tickets/{id}/choose_tag")
    public ResponseEntity<ResponseWrapper<TicketDTO>> chooseTagByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseTagByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseTagByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * choose_tag 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO chooseTagByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.chooseTag(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * customer_choose_ticket 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "customer_choose_ticket", tags = {"工单" },  notes = "Ticket-customer_choose_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-customer_choose_ticket-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-customer_choose_ticket')")
    @PutMapping("products/{productId}/tickets/{id}/customer_choose_ticket")
    public ResponseEntity<ResponseWrapper<TicketDTO>> customerChooseTicketByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerChooseTicketByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerChooseTicketByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * customer_choose_ticket 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO customerChooseTicketByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.customerChooseTicket(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * customer_del_ticket 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "customer_del_ticket", tags = {"工单" },  notes = "Ticket-customer_del_ticket ")
    @PostMapping("products/{productId}/tickets/{id}/customer_del_ticket")
    public ResponseEntity<ResponseWrapper<TicketDTO>> customerDelTicketByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerDelTicketByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerDelTicketByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * customer_del_ticket 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO customerDelTicketByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.customerDelTicket(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * del_relation 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "del_relation", tags = {"工单" },  notes = "Ticket-del_relation ")
    @PostMapping("products/{productId}/tickets/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<TicketDTO>> delRelationByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_relation 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO delRelationByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.delRelation(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * delete 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "delete", tags = {"工单" },  notes = "Ticket-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-delete-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-delete')")
    @PostMapping("products/{productId}/tickets/{id}/delete")
    public ResponseEntity<ResponseWrapper<TicketDTO>> deleteByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO deleteByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.delete(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * others_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "others_relation_ticket", tags = {"工单" },  notes = "Ticket-others_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-others_relation_ticket-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-others_relation_ticket')")
    @PutMapping("products/{productId}/tickets/{id}/others_relation_ticket")
    public ResponseEntity<ResponseWrapper<TicketDTO>> othersRelationTicketByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationTicketByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationTicketByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * others_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO othersRelationTicketByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.othersRelationTicket(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * product_ticket_re_counters 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "product_ticket_re_counters", tags = {"工单" },  notes = "Ticket-product_ticket_re_counters ")
    @PostMapping("products/{productId}/tickets/{id}/product_ticket_re_counters")
    public ResponseEntity<ResponseWrapper<TicketDTO>> productTicketReCountersByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productTicketReCountersByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productTicketReCountersByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * product_ticket_re_counters 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO productTicketReCountersByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.productTicketReCounters(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * recover 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "recover", tags = {"工单" },  notes = "Ticket-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-recover-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-recover')")
    @PostMapping("products/{productId}/tickets/{id}/recover")
    public ResponseEntity<ResponseWrapper<TicketDTO>> recoverByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * recover 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO recoverByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.recover(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工单" },  notes = "Ticket-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Save-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-Save')")
    @PostMapping("products/{productId}/tickets/save")
    public ResponseEntity<ResponseWrapper<TicketDTO>> saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO saveByProductId
            (String productId, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ticketService.save(domain);
        Ticket rt = domain;
        return ticketDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工单
    * 
    *
    * @param id id
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"工单" },  notes = "Ticket-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Get-all')  or hasPermission(this.ticketDtoMapping.toDomain(returnObject.body),'ibizplm-Ticket-Get')")
    @GetMapping("tickets/{id}")
    public ResponseEntity<TicketDTO> getById
            (@PathVariable("id") String id) {
        Ticket rt = ticketService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 工单
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"工单" },  notes = "Ticket-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Remove-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-Remove')")
    @DeleteMapping("tickets/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = ticketService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工单" },  notes = "Ticket-CheckKey ")
    @PostMapping("tickets/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        Integer rt = ticketService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_attention 工单
    * 
    *
    * @param id id
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "get_attention", tags = {"工单" },  notes = "Ticket-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-get_attention-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-get_attention')")
    @GetMapping("tickets/{id}/get_attention")
    public ResponseEntity<TicketDTO> getAttentionById
            (@PathVariable("id") String id) {
        Ticket rt = ticketService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工单" },  notes = "Ticket-GetDraft ")
    @GetMapping("tickets/get_draft")
    public ResponseEntity<TicketDTO> getDraft
            (@SpringQueryMap TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        Ticket rt = ticketService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * get_product_member 工单
    * 
    *
    * @param id id
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "get_product_member", tags = {"工单" },  notes = "Ticket-get_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-get_product_member-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-get_product_member')")
    @GetMapping("tickets/{id}/get_product_member")
    public ResponseEntity<TicketDTO> getProductMemberById
            (@PathVariable("id") String id) {
        Ticket rt = ticketService.getProductMember(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * test_get_archived_info 工单
    * 
    *
    * @param id id
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "test_get_archived_info", tags = {"工单" },  notes = "Ticket-test_get_archived_info ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-test_get_archived_info-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-test_get_archived_info')")
    @GetMapping("tickets/{id}/test_get_archived_info")
    public ResponseEntity<TicketDTO> testGetArchivedInfoById
            (@PathVariable("id") String id) {
        Ticket rt = ticketService.testGetArchivedInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_advanced_search 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketAdvancedSearchDTO>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工单" },  notes = "Ticket-fetch_advanced_search ")
    @PostMapping("tickets/fetch_advanced_search")
    public ResponseEntity<List<TicketAdvancedSearchDTO>> fetchAdvancedSearch
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchAdvancedSearch(context) ;
        List<TicketAdvancedSearchDTO> list = ticketAdvancedSearchDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_archived 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工单" },  notes = "Ticket-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_archived-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_archived')")
    @PostMapping("tickets/fetch_archived")
    public ResponseEntity<List<TicketDTO>> fetchArchived
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchArchived(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_comment_notify_assignee 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketAssigneeDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工单" },  notes = "Ticket-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_comment_notify_assignee-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_comment_notify_assignee')")
    @PostMapping("tickets/fetch_comment_notify_assignee")
    public ResponseEntity<List<TicketAssigneeDTO>> fetchCommentNotifyAssignee
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchCommentNotifyAssignee(context) ;
        List<TicketAssigneeDTO> list = ticketAssigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_common 工单
    * 通用查询，非删除数据
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工单" },  notes = "Ticket-fetch_common 通用查询，非删除数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_common-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_common')")
    @PostMapping("tickets/fetch_common")
    public ResponseEntity<List<TicketDTO>> fetchCommon
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchCommon(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_customer_notre_ticket 工单
    * 查询未关联工单的数据；客户关联工单表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_customer_notre_ticket", tags = {"工单" },  notes = "Ticket-fetch_customer_notre_ticket 查询未关联工单的数据；客户关联工单表格调用")
    @PostMapping("tickets/fetch_customer_notre_ticket")
    public ResponseEntity<List<TicketDTO>> fetchCustomerNotreTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchCustomerNotreTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_customer_relation_ticket 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_customer_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_customer_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_customer_relation_ticket-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_customer_relation_ticket')")
    @PostMapping("tickets/fetch_customer_relation_ticket")
    public ResponseEntity<List<TicketDTO>> fetchCustomerRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchCustomerRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工单" },  notes = "Ticket-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_default-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_default')")
    @PostMapping("tickets/fetch_default")
    public ResponseEntity<List<TicketDTO>> fetchDefault
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchDefault(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_deleted 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工单" },  notes = "Ticket-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_deleted-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_deleted')")
    @PostMapping("tickets/fetch_deleted")
    public ResponseEntity<List<TicketDTO>> fetchDeleted
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchDeleted(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_idea_relation_ticket 工单
    * 产品关联工单表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_idea_relation_ticket 产品关联工单表格调用")
    @PostMapping("tickets/fetch_idea_relation_ticket")
    public ResponseEntity<List<TicketDTO>> fetchIdeaRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchIdeaRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_assign 工单
    * 首页我负责的工单表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assign", tags = {"工单" },  notes = "Ticket-fetch_my_assign 首页我负责的工单表格调用")
    @PostMapping("tickets/fetch_my_assign")
    public ResponseEntity<List<TicketDTO>> fetchMyAssign
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchMyAssign(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_assignee_count 工单
    * 首页我负责的工单表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工单" },  notes = "Ticket-fetch_my_assignee_count 首页我负责的工单表格调用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_my_assignee_count-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_my_assignee_count')")
    @PostMapping("tickets/fetch_my_assignee_count")
    public ResponseEntity<List<TicketDTO>> fetchMyAssigneeCount
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchMyAssigneeCount(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_attention 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工单" },  notes = "Ticket-fetch_my_attention ")
    @PostMapping("tickets/fetch_my_attention")
    public ResponseEntity<List<TicketDTO>> fetchMyAttention
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchMyAttention(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_created 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工单" },  notes = "Ticket-fetch_my_created ")
    @PostMapping("tickets/fetch_my_created")
    public ResponseEntity<List<TicketDTO>> fetchMyCreated
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchMyCreated(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 工单
    * 非归档，非删除数据
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工单" },  notes = "Ticket-fetch_normal 非归档，非删除数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_normal-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_normal')")
    @PostMapping("tickets/fetch_normal")
    public ResponseEntity<List<TicketDTO>> fetchNormal
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchNormal(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_not_exsists_relation 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工单" },  notes = "Ticket-fetch_not_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_not_exsists_relation-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_not_exsists_relation')")
    @PostMapping("tickets/fetch_not_exsists_relation")
    public ResponseEntity<List<TicketDTO>> fetchNotExsistsRelation
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchNotExsistsRelation(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_notify_assignee 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketAssigneeDTO>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工单" },  notes = "Ticket-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_notify_assignee-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_notify_assignee')")
    @PostMapping("tickets/fetch_notify_assignee")
    public ResponseEntity<List<TicketAssigneeDTO>> fetchNotifyAssignee
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchNotifyAssignee(context) ;
        List<TicketAssigneeDTO> list = ticketAssigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_recent_ticket 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_recent_ticket", tags = {"工单" },  notes = "Ticket-fetch_recent_ticket ")
    @PostMapping("tickets/fetch_recent_ticket")
    public ResponseEntity<List<TicketDTO>> fetchRecentTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchRecentTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_ticket_re_product_tag 工单
    * 当前标签下工单表格视图调用
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_re_product_tag", tags = {"工单" },  notes = "Ticket-fetch_ticket_re_product_tag 当前标签下工单表格视图调用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_ticket_re_product_tag-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_ticket_re_product_tag')")
    @PostMapping("tickets/fetch_ticket_re_product_tag")
    public ResponseEntity<List<TicketDTO>> fetchTicketReProductTag
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchTicketReProductTag(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_ticket_relation_ticket 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_ticket_relation_ticket ")
    @PostMapping("tickets/fetch_ticket_relation_ticket")
    public ResponseEntity<List<TicketDTO>> fetchTicketRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchTicketRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_relation_ticket 工单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_work_item_relation_ticket ")
    @PostMapping("tickets/fetch_work_item_relation_ticket")
    public ResponseEntity<List<TicketDTO>> fetchWorkItemRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchWorkItemRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"工单" },  notes = "Ticket-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Get-all')  or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(returnObject.body),'ibizplm-Ticket-Get')")
    @GetMapping("products/{productId}/tickets/{id}")
    public ResponseEntity<TicketDTO> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Ticket rt = ticketService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"工单" },  notes = "Ticket-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Remove-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-Remove')")
    @DeleteMapping("products/{productId}/tickets/{id}")
    public ResponseEntity<Boolean> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = ticketService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工单" },  notes = "Ticket-CheckKey ")
    @PostMapping("products/{productId}/tickets/check_key")
    public ResponseEntity<Integer> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Integer rt = ticketService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_attention 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "get_attention", tags = {"工单" },  notes = "Ticket-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-get_attention-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-get_attention')")
    @GetMapping("products/{productId}/tickets/{id}/get_attention")
    public ResponseEntity<TicketDTO> getAttentionByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Ticket rt = ticketService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工单" },  notes = "Ticket-GetDraft ")
    @GetMapping("products/{productId}/tickets/get_draft")
    public ResponseEntity<TicketDTO> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Ticket rt = ticketService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * get_product_member 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "get_product_member", tags = {"工单" },  notes = "Ticket-get_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-get_product_member-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-get_product_member')")
    @GetMapping("products/{productId}/tickets/{id}/get_product_member")
    public ResponseEntity<TicketDTO> getProductMemberByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Ticket rt = ticketService.getProductMember(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * test_get_archived_info 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<TicketDTO>
    */
    @ApiOperation(value = "test_get_archived_info", tags = {"工单" },  notes = "Ticket-test_get_archived_info ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-test_get_archived_info-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-test_get_archived_info')")
    @GetMapping("products/{productId}/tickets/{id}/test_get_archived_info")
    public ResponseEntity<TicketDTO> testGetArchivedInfoByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Ticket rt = ticketService.testGetArchivedInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_advanced_search 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketAdvancedSearchDTO>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工单" },  notes = "Ticket-fetch_advanced_search ")
    @PostMapping("products/{productId}/tickets/fetch_advanced_search")
    public ResponseEntity<List<TicketAdvancedSearchDTO>> fetchAdvancedSearchByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchAdvancedSearch(context) ;
        List<TicketAdvancedSearchDTO> list = ticketAdvancedSearchDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_archived 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工单" },  notes = "Ticket-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_archived-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_archived')")
    @PostMapping("products/{productId}/tickets/fetch_archived")
    public ResponseEntity<List<TicketDTO>> fetchArchivedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchArchived(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_comment_notify_assignee 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketAssigneeDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工单" },  notes = "Ticket-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_comment_notify_assignee-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_comment_notify_assignee')")
    @PostMapping("products/{productId}/tickets/fetch_comment_notify_assignee")
    public ResponseEntity<List<TicketAssigneeDTO>> fetchCommentNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchCommentNotifyAssignee(context) ;
        List<TicketAssigneeDTO> list = ticketAssigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_common 工单
    * 通用查询，非删除数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工单" },  notes = "Ticket-fetch_common 通用查询，非删除数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_common-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_common')")
    @PostMapping("products/{productId}/tickets/fetch_common")
    public ResponseEntity<List<TicketDTO>> fetchCommonByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchCommon(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_customer_notre_ticket 工单
    * 查询未关联工单的数据；客户关联工单表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_customer_notre_ticket", tags = {"工单" },  notes = "Ticket-fetch_customer_notre_ticket 查询未关联工单的数据；客户关联工单表格调用")
    @PostMapping("products/{productId}/tickets/fetch_customer_notre_ticket")
    public ResponseEntity<List<TicketDTO>> fetchCustomerNotreTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchCustomerNotreTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_customer_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_customer_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_customer_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_customer_relation_ticket-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_customer_relation_ticket')")
    @PostMapping("products/{productId}/tickets/fetch_customer_relation_ticket")
    public ResponseEntity<List<TicketDTO>> fetchCustomerRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchCustomerRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工单" },  notes = "Ticket-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_default')")
    @PostMapping("products/{productId}/tickets/fetch_default")
    public ResponseEntity<List<TicketDTO>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchDefault(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_deleted 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工单" },  notes = "Ticket-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_deleted-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_deleted')")
    @PostMapping("products/{productId}/tickets/fetch_deleted")
    public ResponseEntity<List<TicketDTO>> fetchDeletedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchDeleted(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_idea_relation_ticket 工单
    * 产品关联工单表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_idea_relation_ticket 产品关联工单表格调用")
    @PostMapping("products/{productId}/tickets/fetch_idea_relation_ticket")
    public ResponseEntity<List<TicketDTO>> fetchIdeaRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchIdeaRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_assign 工单
    * 首页我负责的工单表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assign", tags = {"工单" },  notes = "Ticket-fetch_my_assign 首页我负责的工单表格调用")
    @PostMapping("products/{productId}/tickets/fetch_my_assign")
    public ResponseEntity<List<TicketDTO>> fetchMyAssignByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchMyAssign(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_assignee_count 工单
    * 首页我负责的工单表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工单" },  notes = "Ticket-fetch_my_assignee_count 首页我负责的工单表格调用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_my_assignee_count-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_my_assignee_count')")
    @PostMapping("products/{productId}/tickets/fetch_my_assignee_count")
    public ResponseEntity<List<TicketDTO>> fetchMyAssigneeCountByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchMyAssigneeCount(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_attention 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工单" },  notes = "Ticket-fetch_my_attention ")
    @PostMapping("products/{productId}/tickets/fetch_my_attention")
    public ResponseEntity<List<TicketDTO>> fetchMyAttentionByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchMyAttention(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_created 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工单" },  notes = "Ticket-fetch_my_created ")
    @PostMapping("products/{productId}/tickets/fetch_my_created")
    public ResponseEntity<List<TicketDTO>> fetchMyCreatedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchMyCreated(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 工单
    * 非归档，非删除数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工单" },  notes = "Ticket-fetch_normal 非归档，非删除数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_normal-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_normal')")
    @PostMapping("products/{productId}/tickets/fetch_normal")
    public ResponseEntity<List<TicketDTO>> fetchNormalByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchNormal(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_not_exsists_relation 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工单" },  notes = "Ticket-fetch_not_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_not_exsists_relation-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_not_exsists_relation')")
    @PostMapping("products/{productId}/tickets/fetch_not_exsists_relation")
    public ResponseEntity<List<TicketDTO>> fetchNotExsistsRelationByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchNotExsistsRelation(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_notify_assignee 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketAssigneeDTO>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工单" },  notes = "Ticket-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_notify_assignee-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_notify_assignee')")
    @PostMapping("products/{productId}/tickets/fetch_notify_assignee")
    public ResponseEntity<List<TicketAssigneeDTO>> fetchNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchNotifyAssignee(context) ;
        List<TicketAssigneeDTO> list = ticketAssigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_recent_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_recent_ticket", tags = {"工单" },  notes = "Ticket-fetch_recent_ticket ")
    @PostMapping("products/{productId}/tickets/fetch_recent_ticket")
    public ResponseEntity<List<TicketDTO>> fetchRecentTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchRecentTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_ticket_re_product_tag 工单
    * 当前标签下工单表格视图调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_re_product_tag", tags = {"工单" },  notes = "Ticket-fetch_ticket_re_product_tag 当前标签下工单表格视图调用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_ticket_re_product_tag-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_ticket_re_product_tag')")
    @PostMapping("products/{productId}/tickets/fetch_ticket_re_product_tag")
    public ResponseEntity<List<TicketDTO>> fetchTicketReProductTagByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchTicketReProductTag(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_ticket_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_ticket_relation_ticket ")
    @PostMapping("products/{productId}/tickets/fetch_ticket_relation_ticket")
    public ResponseEntity<List<TicketDTO>> fetchTicketRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchTicketRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<TicketDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_work_item_relation_ticket ")
    @PostMapping("products/{productId}/tickets/fetch_work_item_relation_ticket")
    public ResponseEntity<List<TicketDTO>> fetchWorkItemRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.searchWorkItemRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建工单
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Create-all')")
    @ApiOperation(value = "批量新建工单", tags = {"工单" },  notes = "批量新建工单")
	@PostMapping("tickets/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TicketDTO> dtos) {
        ticketService.createBatch(ticketDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除工单
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Remove-all')")
    @ApiOperation(value = "批量删除工单", tags = {"工单" },  notes = "批量删除工单")
	@DeleteMapping("tickets/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ticketService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新工单
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Update-all')")
    @ApiOperation(value = "批量更新工单", tags = {"工单" },  notes = "批量更新工单")
	@PutMapping("tickets/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TicketDTO> dtos) {
        ticketService.updateBatch(ticketDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存工单
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Save-all')")
    @ApiOperation(value = "批量保存工单", tags = {"工单" },  notes = "批量保存工单")
	@PostMapping("tickets/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TicketDTO> dtos) {
        ticketService.saveBatch(ticketDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入工单
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Save-all')")
    @ApiOperation(value = "批量导入工单", tags = {"工单" },  notes = "批量导入工单")
	@PostMapping("tickets/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TicketDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(ticketService.importData(config,ignoreError,ticketDtoMapping.toDomain(dtos)));
    }

}
