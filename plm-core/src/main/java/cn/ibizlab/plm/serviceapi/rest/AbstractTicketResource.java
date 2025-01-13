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
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.service.TicketService;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

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
    public TicketBiSearchGroupDTOMapping ticketBiSearchGroupDtoMapping;

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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工单" },  notes = "Ticket-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Create-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-Create')")
    @PostMapping("tickets")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>create
            (@Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工单" },  notes = "Ticket-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Update-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-Update')")
    @VersionCheck(entity = "ticket" , versionfield = "updateTime")
    @PutMapping("tickets/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "activate", tags = {"工单" },  notes = "Ticket-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-activate-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-activate')")
    @PostMapping("tickets/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "allocate_person", tags = {"工单" },  notes = "Ticket-allocate_person ")
    @PostMapping("tickets/{id}/allocate_person")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>allocatePersonById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(allocatePersonById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(allocatePersonById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "archive", tags = {"工单" },  notes = "Ticket-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-archive-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-archive')")
    @PostMapping("tickets/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "choose_tag", tags = {"工单" },  notes = "Ticket-choose_tag ")
    @PostMapping("tickets/{id}/choose_tag")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>chooseTagById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseTagById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseTagById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "customer_choose_ticket", tags = {"工单" },  notes = "Ticket-customer_choose_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-customer_choose_ticket-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-customer_choose_ticket')")
    @PutMapping("tickets/{id}/customer_choose_ticket")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>customerChooseTicketById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerChooseTicketById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerChooseTicketById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "customer_del_ticket", tags = {"工单" },  notes = "Ticket-customer_del_ticket ")
    @PostMapping("tickets/{id}/customer_del_ticket")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>customerDelTicketById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerDelTicketById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerDelTicketById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * delete 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "delete", tags = {"工单" },  notes = "Ticket-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-delete-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-delete')")
    @PostMapping("tickets/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * mob_ticket_attention 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "mob_ticket_attention", tags = {"工单" },  notes = "Ticket-mob_ticket_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-mob_ticket_attention-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-mob_ticket_attention')")
    @PostMapping("tickets/{id}/mob_ticket_attention")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>mobTicketAttentionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(mobTicketAttentionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(mobTicketAttentionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_ticket_attention 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO mobTicketAttentionById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.mobTicketAttention(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * others_relation_ticket 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "others_relation_ticket", tags = {"工单" },  notes = "Ticket-others_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-others_relation_ticket-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-others_relation_ticket')")
    @PutMapping("tickets/{id}/others_relation_ticket")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>othersRelationTicketById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationTicketById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationTicketById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "product_ticket_re_counters", tags = {"工单" },  notes = "Ticket-product_ticket_re_counters ")
    @PostMapping("tickets/{id}/product_ticket_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>productTicketReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productTicketReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productTicketReCountersById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "recover", tags = {"工单" },  notes = "Ticket-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-recover-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-recover')")
    @PostMapping("tickets/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工单" },  notes = "Ticket-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Save-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-Save')")
    @PostMapping("tickets/save")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>save
            (@Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * ticket_readonly_recognize 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "ticket_readonly_recognize", tags = {"工单" },  notes = "Ticket-ticket_readonly_recognize ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-ticket_readonly_recognize-all') or hasPermission(this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-ticket_readonly_recognize')")
    @PostMapping("tickets/{id}/ticket_readonly_recognize")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>ticketReadonlyRecognizeById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ticketReadonlyRecognizeById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ticketReadonlyRecognizeById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * ticket_readonly_recognize 工单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO ticketReadonlyRecognizeById
            (String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.ticketReadonlyRecognize(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工单" },  notes = "Ticket-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Create-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-Create')")
    @PostMapping("products/{productId}/tickets")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工单" },  notes = "Ticket-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Update-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-Update')")
    @VersionCheck(entity = "ticket" , versionfield = "updateTime")
    @PutMapping("products/{productId}/tickets/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "activate", tags = {"工单" },  notes = "Ticket-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-activate-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-activate')")
    @PostMapping("products/{productId}/tickets/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>activateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "allocate_person", tags = {"工单" },  notes = "Ticket-allocate_person ")
    @PostMapping("products/{productId}/tickets/{id}/allocate_person")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>allocatePersonByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(allocatePersonByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(allocatePersonByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "archive", tags = {"工单" },  notes = "Ticket-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-archive-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-archive')")
    @PostMapping("products/{productId}/tickets/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>archiveByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "choose_tag", tags = {"工单" },  notes = "Ticket-choose_tag ")
    @PostMapping("products/{productId}/tickets/{id}/choose_tag")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>chooseTagByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseTagByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseTagByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "customer_choose_ticket", tags = {"工单" },  notes = "Ticket-customer_choose_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-customer_choose_ticket-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-customer_choose_ticket')")
    @PutMapping("products/{productId}/tickets/{id}/customer_choose_ticket")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>customerChooseTicketByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerChooseTicketByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerChooseTicketByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "customer_del_ticket", tags = {"工单" },  notes = "Ticket-customer_del_ticket ")
    @PostMapping("products/{productId}/tickets/{id}/customer_del_ticket")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>customerDelTicketByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerDelTicketByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerDelTicketByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * delete 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "delete", tags = {"工单" },  notes = "Ticket-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-delete-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-delete')")
    @PostMapping("products/{productId}/tickets/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>deleteByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * mob_ticket_attention 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "mob_ticket_attention", tags = {"工单" },  notes = "Ticket-mob_ticket_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-mob_ticket_attention-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-mob_ticket_attention')")
    @PostMapping("products/{productId}/tickets/{id}/mob_ticket_attention")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>mobTicketAttentionByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(mobTicketAttentionByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(mobTicketAttentionByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_ticket_attention 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO mobTicketAttentionByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.mobTicketAttention(domain);
        return ticketDtoMapping.toDto(rt);
    }

    /**
    * others_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "others_relation_ticket", tags = {"工单" },  notes = "Ticket-others_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-others_relation_ticket-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-others_relation_ticket')")
    @PutMapping("products/{productId}/tickets/{id}/others_relation_ticket")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>othersRelationTicketByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationTicketByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationTicketByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "product_ticket_re_counters", tags = {"工单" },  notes = "Ticket-product_ticket_re_counters ")
    @PostMapping("products/{productId}/tickets/{id}/product_ticket_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>productTicketReCountersByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productTicketReCountersByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productTicketReCountersByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "recover", tags = {"工单" },  notes = "Ticket-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-recover-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-recover')")
    @PostMapping("products/{productId}/tickets/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>recoverByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工单" },  notes = "Ticket-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Save-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-Save')")
    @PostMapping("products/{productId}/tickets/save")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * ticket_readonly_recognize 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "ticket_readonly_recognize", tags = {"工单" },  notes = "Ticket-ticket_readonly_recognize ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-ticket_readonly_recognize-all') or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(#dto),'ibizplm-Ticket-ticket_readonly_recognize')")
    @PostMapping("products/{productId}/tickets/{id}/ticket_readonly_recognize")
    public Mono<ResponseEntity<ResponseWrapper<TicketDTO>>>ticketReadonlyRecognizeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TicketDTO> dto) {
        ResponseWrapper<TicketDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ticketReadonlyRecognizeByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ticketReadonlyRecognizeByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * ticket_readonly_recognize 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TicketDTO>
    */   
    public TicketDTO ticketReadonlyRecognizeByProductIdAndId
            (String productId, String id, TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setId(id);
        Ticket rt = ticketService.ticketReadonlyRecognize(domain);
        return ticketDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工单
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工单" },  notes = "Ticket-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Get-all')  or hasPermission(this.ticketDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Ticket-Get')")
    @GetMapping("tickets/{id}")
    public Mono<ResponseEntity<TicketDTO>> getById
            (@PathVariable("id") String id) {
        Ticket rt = ticketService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工单
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工单" },  notes = "Ticket-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Remove-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-Remove')")
    @DeleteMapping("tickets/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = ticketService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工单" },  notes = "Ticket-CheckKey ")
    @PostMapping("tickets/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        CheckKeyStatus rt = ticketService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 工单
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"工单" },  notes = "Ticket-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-get_attention-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-get_attention')")
    @GetMapping("tickets/{id}/get_attention")
    public Mono<ResponseEntity<TicketDTO>> getAttentionById
            (@PathVariable("id") String id) {
        Ticket rt = ticketService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工单" },  notes = "Ticket-GetDraft ")
    @GetMapping("tickets/get_draft")
    public Mono<ResponseEntity<TicketDTO>> getDraft
            (@SpringQueryMap TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        Ticket rt = ticketService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt)));
    }

    /**
    * test_get_archived_info 工单
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "test_get_archived_info", tags = {"工单" },  notes = "Ticket-test_get_archived_info ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-test_get_archived_info-all') or hasPermission(this.ticketService.get(#id),'ibizplm-Ticket-test_get_archived_info')")
    @GetMapping("tickets/{id}/test_get_archived_info")
    public Mono<ResponseEntity<TicketDTO>> testGetArchivedInfoById
            (@PathVariable("id") String id) {
        Ticket rt = ticketService.testGetArchivedInfo(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_admin 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"工单" },  notes = "Ticket-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_admin-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_admin')")
    @PostMapping("tickets/fetch_admin")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchAdmin
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchAdmin(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_advanced_search 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketAdvancedSearchDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工单" },  notes = "Ticket-fetch_advanced_search ")
    @PostMapping("tickets/fetch_advanced_search")
    public Mono<ResponseEntity<List<TicketAdvancedSearchDTO>>> fetchAdvancedSearch
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchAdvancedSearch(context) ;
        List<TicketAdvancedSearchDTO> list = ticketAdvancedSearchDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工单" },  notes = "Ticket-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_archived-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_archived')")
    @PostMapping("tickets/fetch_archived")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchArchived
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchArchived(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工单" },  notes = "Ticket-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_bi_detail-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_bi_detail')")
    @PostMapping("tickets/fetch_bi_detail")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchBiDetail
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchBiDetail(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"工单" },  notes = "Ticket-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_bi_search')")
    @PostMapping("tickets/fetch_bi_search")
    public Mono<ResponseEntity<List<TicketBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchBiSearch(context) ;
        List<TicketBiSearchGroupDTO> list = ticketBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_assignee 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工单" },  notes = "Ticket-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_comment_notify_assignee-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_comment_notify_assignee')")
    @PostMapping("tickets/fetch_comment_notify_assignee")
    public Mono<ResponseEntity<List<TicketAssigneeDTO>>> fetchCommentNotifyAssignee
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCommentNotifyAssignee(context) ;
        List<TicketAssigneeDTO> list = ticketAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common 工单
    * 通用查询，非删除数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工单" },  notes = "Ticket-fetch_common 通用查询，非删除数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_common-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_common')")
    @PostMapping("tickets/fetch_common")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchCommon
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCommon(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_customer_notre_ticket 工单
    * 查询未关联工单的数据；客户关联工单表格调用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_customer_notre_ticket", tags = {"工单" },  notes = "Ticket-fetch_customer_notre_ticket 查询未关联工单的数据；客户关联工单表格调用")
    @PostMapping("tickets/fetch_customer_notre_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchCustomerNotreTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCustomerNotreTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_customer_relation_ticket 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_customer_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_customer_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_customer_relation_ticket-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_customer_relation_ticket')")
    @PostMapping("tickets/fetch_customer_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchCustomerRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCustomerRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_customer_user 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_customer_user", tags = {"工单" },  notes = "Ticket-fetch_customer_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_customer_user-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_customer_user')")
    @PostMapping("tickets/fetch_customer_user")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchCustomerUser
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCustomerUser(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工单" },  notes = "Ticket-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_default-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_default')")
    @PostMapping("tickets/fetch_default")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchDefault
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchDefault(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工单" },  notes = "Ticket-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_deleted-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_deleted')")
    @PostMapping("tickets/fetch_deleted")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchDeleted
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchDeleted(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_idea_relation_ticket 工单
    * 产品关联工单表格调用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_idea_relation_ticket 产品关联工单表格调用")
    @PostMapping("tickets/fetch_idea_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchIdeaRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchIdeaRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_mob_ticket_list 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_mob_ticket_list", tags = {"工单" },  notes = "Ticket-fetch_mob_ticket_list ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_mob_ticket_list-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_mob_ticket_list')")
    @PostMapping("tickets/fetch_mob_ticket_list")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMobTicketList
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMobTicketList(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assign 工单
    * 首页我负责的工单表格调用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assign", tags = {"工单" },  notes = "Ticket-fetch_my_assign 首页我负责的工单表格调用")
    @PostMapping("tickets/fetch_my_assign")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyAssign
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyAssign(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count 工单
    * 首页我负责的工单表格调用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工单" },  notes = "Ticket-fetch_my_assignee_count 首页我负责的工单表格调用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_my_assignee_count-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_my_assignee_count')")
    @PostMapping("tickets/fetch_my_assignee_count")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyAssigneeCount
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyAssigneeCount(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工单" },  notes = "Ticket-fetch_my_attention ")
    @PostMapping("tickets/fetch_my_attention")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyAttention
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyAttention(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工单" },  notes = "Ticket-fetch_my_created ")
    @PostMapping("tickets/fetch_my_created")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyCreated
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyCreated(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"工单" },  notes = "Ticket-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_my_filter-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_my_filter')")
    @PostMapping("tickets/fetch_my_filter")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyFilter
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyFilter(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_ticket 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_ticket", tags = {"工单" },  notes = "Ticket-fetch_my_summary_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_my_summary_ticket-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_my_summary_ticket')")
    @PostMapping("tickets/fetch_my_summary_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMySummaryTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMySummaryTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 工单
    * 非归档，非删除数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工单" },  notes = "Ticket-fetch_normal 非归档，非删除数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_normal-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_normal')")
    @PostMapping("tickets/fetch_normal")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchNormal
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchNormal(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工单" },  notes = "Ticket-fetch_not_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_not_exsists_relation-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_not_exsists_relation')")
    @PostMapping("tickets/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchNotExsistsRelation
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchNotExsistsRelation(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工单" },  notes = "Ticket-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_notify_assignee-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_notify_assignee')")
    @PostMapping("tickets/fetch_notify_assignee")
    public Mono<ResponseEntity<List<TicketAssigneeDTO>>> fetchNotifyAssignee
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchNotifyAssignee(context) ;
        List<TicketAssigneeDTO> list = ticketAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"工单" },  notes = "Ticket-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_reader-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_reader')")
    @PostMapping("tickets/fetch_reader")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchReader
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchReader(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_ticket 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_ticket", tags = {"工单" },  notes = "Ticket-fetch_recent_ticket ")
    @PostMapping("tickets/fetch_recent_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchRecentTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchRecentTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_relation_ticket 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_relation_ticket-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_relation_ticket')")
    @PostMapping("tickets/fetch_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_ticket_re_product_tag 工单
    * 当前标签下工单表格视图调用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_ticket_re_product_tag", tags = {"工单" },  notes = "Ticket-fetch_ticket_re_product_tag 当前标签下工单表格视图调用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_ticket_re_product_tag-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_ticket_re_product_tag')")
    @PostMapping("tickets/fetch_ticket_re_product_tag")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchTicketReProductTag
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchTicketReProductTag(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_ticket_relation_ticket 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_ticket_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_ticket_relation_ticket ")
    @PostMapping("tickets/fetch_ticket_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchTicketRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchTicketRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_ticket_state_pie_chart 工单
    * 工单状态饼图数据
在需求关联工单统计视图中使用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_ticket_state_pie_chart", tags = {"工单" },  notes = "Ticket-fetch_ticket_state_pie_chart 工单状态饼图数据 在需求关联工单统计视图中使用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_ticket_state_pie_chart-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_ticket_state_pie_chart')")
    @PostMapping("tickets/fetch_ticket_state_pie_chart")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchTicketStatePieChart
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchTicketStatePieChart(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"工单" },  notes = "Ticket-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_user-all') or hasPermission(#dto,'ibizplm-Ticket-fetch_user')")
    @PostMapping("tickets/fetch_user")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchUser
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchUser(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_relation_ticket 工单
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_work_item_relation_ticket ")
    @PostMapping("tickets/fetch_work_item_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchWorkItemRelationTicket
            (@Validated @RequestBody TicketFilterDTO dto) {
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchWorkItemRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工单" },  notes = "Ticket-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Get-all')  or hasPermission('product',#productId,this.ticketDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Ticket-Get')")
    @GetMapping("products/{productId}/tickets/{id}")
    public Mono<ResponseEntity<TicketDTO>> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Ticket rt = ticketService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工单" },  notes = "Ticket-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-Remove-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-Remove')")
    @DeleteMapping("products/{productId}/tickets/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = ticketService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工单" },  notes = "Ticket-CheckKey ")
    @PostMapping("products/{productId}/tickets/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        CheckKeyStatus rt = ticketService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"工单" },  notes = "Ticket-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-get_attention-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-get_attention')")
    @GetMapping("products/{productId}/tickets/{id}/get_attention")
    public Mono<ResponseEntity<TicketDTO>> getAttentionByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Ticket rt = ticketService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工单" },  notes = "Ticket-GetDraft ")
    @GetMapping("products/{productId}/tickets/get_draft")
    public Mono<ResponseEntity<TicketDTO>> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap TicketDTO dto) {
        Ticket domain = ticketDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Ticket rt = ticketService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt)));
    }

    /**
    * test_get_archived_info 工单
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<TicketDTO>>
    */
    @ApiOperation(value = "test_get_archived_info", tags = {"工单" },  notes = "Ticket-test_get_archived_info ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-test_get_archived_info-all') or hasPermission('product',#productId,this.ticketService.get(#id),'ibizplm-Ticket-test_get_archived_info')")
    @GetMapping("products/{productId}/tickets/{id}/test_get_archived_info")
    public Mono<ResponseEntity<TicketDTO>> testGetArchivedInfoByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Ticket rt = ticketService.testGetArchivedInfo(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_admin 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"工单" },  notes = "Ticket-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_admin-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_admin')")
    @PostMapping("products/{productId}/tickets/fetch_admin")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchAdminByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchAdmin(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_advanced_search 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketAdvancedSearchDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工单" },  notes = "Ticket-fetch_advanced_search ")
    @PostMapping("products/{productId}/tickets/fetch_advanced_search")
    public Mono<ResponseEntity<List<TicketAdvancedSearchDTO>>> fetchAdvancedSearchByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchAdvancedSearch(context) ;
        List<TicketAdvancedSearchDTO> list = ticketAdvancedSearchDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工单" },  notes = "Ticket-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_archived-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_archived')")
    @PostMapping("products/{productId}/tickets/fetch_archived")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchArchivedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchArchived(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工单" },  notes = "Ticket-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_bi_detail-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_bi_detail')")
    @PostMapping("products/{productId}/tickets/fetch_bi_detail")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchBiDetailByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchBiDetail(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"工单" },  notes = "Ticket-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_bi_search-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_bi_search')")
    @PostMapping("products/{productId}/tickets/fetch_bi_search")
    public Mono<ResponseEntity<List<TicketBiSearchGroupDTO>>> fetchBiSearchByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchBiSearch(context) ;
        List<TicketBiSearchGroupDTO> list = ticketBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_assignee 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工单" },  notes = "Ticket-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_comment_notify_assignee-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_comment_notify_assignee')")
    @PostMapping("products/{productId}/tickets/fetch_comment_notify_assignee")
    public Mono<ResponseEntity<List<TicketAssigneeDTO>>> fetchCommentNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCommentNotifyAssignee(context) ;
        List<TicketAssigneeDTO> list = ticketAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common 工单
    * 通用查询，非删除数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工单" },  notes = "Ticket-fetch_common 通用查询，非删除数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_common-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_common')")
    @PostMapping("products/{productId}/tickets/fetch_common")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchCommonByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCommon(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_customer_notre_ticket 工单
    * 查询未关联工单的数据；客户关联工单表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_customer_notre_ticket", tags = {"工单" },  notes = "Ticket-fetch_customer_notre_ticket 查询未关联工单的数据；客户关联工单表格调用")
    @PostMapping("products/{productId}/tickets/fetch_customer_notre_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchCustomerNotreTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCustomerNotreTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_customer_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_customer_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_customer_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_customer_relation_ticket-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_customer_relation_ticket')")
    @PostMapping("products/{productId}/tickets/fetch_customer_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchCustomerRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCustomerRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_customer_user 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_customer_user", tags = {"工单" },  notes = "Ticket-fetch_customer_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_customer_user-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_customer_user')")
    @PostMapping("products/{productId}/tickets/fetch_customer_user")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchCustomerUserByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchCustomerUser(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工单" },  notes = "Ticket-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_default')")
    @PostMapping("products/{productId}/tickets/fetch_default")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchDefault(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工单" },  notes = "Ticket-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_deleted-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_deleted')")
    @PostMapping("products/{productId}/tickets/fetch_deleted")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchDeletedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchDeleted(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_idea_relation_ticket 工单
    * 产品关联工单表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_idea_relation_ticket 产品关联工单表格调用")
    @PostMapping("products/{productId}/tickets/fetch_idea_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchIdeaRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchIdeaRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_mob_ticket_list 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_mob_ticket_list", tags = {"工单" },  notes = "Ticket-fetch_mob_ticket_list ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_mob_ticket_list-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_mob_ticket_list')")
    @PostMapping("products/{productId}/tickets/fetch_mob_ticket_list")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMobTicketListByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMobTicketList(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assign 工单
    * 首页我负责的工单表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assign", tags = {"工单" },  notes = "Ticket-fetch_my_assign 首页我负责的工单表格调用")
    @PostMapping("products/{productId}/tickets/fetch_my_assign")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyAssignByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyAssign(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count 工单
    * 首页我负责的工单表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工单" },  notes = "Ticket-fetch_my_assignee_count 首页我负责的工单表格调用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_my_assignee_count-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_my_assignee_count')")
    @PostMapping("products/{productId}/tickets/fetch_my_assignee_count")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyAssigneeCountByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyAssigneeCount(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工单" },  notes = "Ticket-fetch_my_attention ")
    @PostMapping("products/{productId}/tickets/fetch_my_attention")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyAttentionByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyAttention(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工单" },  notes = "Ticket-fetch_my_created ")
    @PostMapping("products/{productId}/tickets/fetch_my_created")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyCreatedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyCreated(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"工单" },  notes = "Ticket-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_my_filter-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_my_filter')")
    @PostMapping("products/{productId}/tickets/fetch_my_filter")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMyFilterByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMyFilter(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_ticket", tags = {"工单" },  notes = "Ticket-fetch_my_summary_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_my_summary_ticket-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_my_summary_ticket')")
    @PostMapping("products/{productId}/tickets/fetch_my_summary_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchMySummaryTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchMySummaryTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 工单
    * 非归档，非删除数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工单" },  notes = "Ticket-fetch_normal 非归档，非删除数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_normal-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_normal')")
    @PostMapping("products/{productId}/tickets/fetch_normal")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchNormalByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchNormal(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工单" },  notes = "Ticket-fetch_not_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_not_exsists_relation-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_not_exsists_relation')")
    @PostMapping("products/{productId}/tickets/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchNotExsistsRelationByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchNotExsistsRelation(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工单" },  notes = "Ticket-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_notify_assignee-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_notify_assignee')")
    @PostMapping("products/{productId}/tickets/fetch_notify_assignee")
    public Mono<ResponseEntity<List<TicketAssigneeDTO>>> fetchNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchNotifyAssignee(context) ;
        List<TicketAssigneeDTO> list = ticketAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"工单" },  notes = "Ticket-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_reader-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_reader')")
    @PostMapping("products/{productId}/tickets/fetch_reader")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchReaderByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchReader(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_ticket", tags = {"工单" },  notes = "Ticket-fetch_recent_ticket ")
    @PostMapping("products/{productId}/tickets/fetch_recent_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchRecentTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchRecentTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_relation_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_relation_ticket-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_relation_ticket')")
    @PostMapping("products/{productId}/tickets/fetch_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_ticket_re_product_tag 工单
    * 当前标签下工单表格视图调用
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_ticket_re_product_tag", tags = {"工单" },  notes = "Ticket-fetch_ticket_re_product_tag 当前标签下工单表格视图调用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_ticket_re_product_tag-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_ticket_re_product_tag')")
    @PostMapping("products/{productId}/tickets/fetch_ticket_re_product_tag")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchTicketReProductTagByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchTicketReProductTag(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_ticket_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_ticket_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_ticket_relation_ticket ")
    @PostMapping("products/{productId}/tickets/fetch_ticket_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchTicketRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchTicketRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_ticket_state_pie_chart 工单
    * 工单状态饼图数据
在需求关联工单统计视图中使用
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_ticket_state_pie_chart", tags = {"工单" },  notes = "Ticket-fetch_ticket_state_pie_chart 工单状态饼图数据 在需求关联工单统计视图中使用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_ticket_state_pie_chart-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_ticket_state_pie_chart')")
    @PostMapping("products/{productId}/tickets/fetch_ticket_state_pie_chart")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchTicketStatePieChartByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchTicketStatePieChart(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"工单" },  notes = "Ticket-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Ticket-fetch_user-all') or hasPermission('product',#productId,#dto,'ibizplm-Ticket-fetch_user')")
    @PostMapping("products/{productId}/tickets/fetch_user")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchUserByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchUser(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_relation_ticket 工单
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TicketDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_ticket", tags = {"工单" },  notes = "Ticket-fetch_work_item_relation_ticket ")
    @PostMapping("products/{productId}/tickets/fetch_work_item_relation_ticket")
    public Mono<ResponseEntity<List<TicketDTO>>> fetchWorkItemRelationTicketByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody TicketFilterDTO dto) {
        dto.setProductIdEQ(productId);
        TicketSearchContext context = ticketFilterDtoMapping.toDomain(dto);
        Page<Ticket> domains = ticketService.fetchWorkItemRelationTicket(context) ;
        List<TicketDTO> list = ticketDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建工单
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Create-all')")
    @ApiOperation(value = "批量新建工单", tags = {"工单" },  notes = "批量新建工单")
	@PostMapping("tickets/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<TicketDTO> dtos) {
        ticketService.create(ticketDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除工单
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Remove-all')")
    @ApiOperation(value = "批量删除工单", tags = {"工单" },  notes = "批量删除工单")
	@DeleteMapping("tickets/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        ticketService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新工单
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Update-all')")
    @ApiOperation(value = "批量更新工单", tags = {"工单" },  notes = "批量更新工单")
	@PutMapping("tickets/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<TicketDTO> dtos) {
        ticketService.update(ticketDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存工单
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Save-all')")
    @ApiOperation(value = "批量保存工单", tags = {"工单" },  notes = "批量保存工单")
	@PostMapping("tickets/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<TicketDTO> dtos) {
        ticketService.save(ticketDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入工单
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Ticket-Save-all')")
    @ApiOperation(value = "批量导入工单", tags = {"工单" },  notes = "批量导入工单")
	@PostMapping("tickets/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TicketDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(ticketService.importData(config,ignoreError,ticketDtoMapping.toDomain(dtos))));
    }

}
