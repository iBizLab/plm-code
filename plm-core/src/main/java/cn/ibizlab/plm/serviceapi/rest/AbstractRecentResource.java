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
import cn.ibizlab.plm.core.base.domain.Recent;
import cn.ibizlab.plm.core.base.service.RecentService;
import cn.ibizlab.plm.core.base.filter.RecentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Recent] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRecentResource {

    @Autowired
    public RecentService recentService;

    @Autowired
    @Lazy
    public RecentDTOMapping recentDtoMapping;

    @Autowired
    @Lazy
    public RecentFilterDTOMapping recentFilterDtoMapping;

    /**
    * 创建Create 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RecentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"最近访问" },  notes = "Recent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Create-all') or hasPermission(this.recentDtoMapping.toDomain(#dto),'ibizplm-Recent-Create')")
    @PostMapping("recents")
    public Mono<ResponseEntity<ResponseWrapper<RecentDTO>>>create
            (@Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO create
            (RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        recentService.create(domain);
        Recent rt = domain;
        return recentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 最近访问
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<RecentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"最近访问" },  notes = "Recent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Update-all') or hasPermission(this.recentService.get(#id),'ibizplm-Recent-Update')")
    @VersionCheck(entity = "recent" , versionfield = "updateTime")
    @PutMapping("recents/{id}")
    public Mono<ResponseEntity<ResponseWrapper<RecentDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 最近访问
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO updateById
            (String id, RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        domain.setId(id);
        recentService.update(domain);
        Recent rt = domain;
        return recentDtoMapping.toDto(rt);
    }

    /**
    * my_charge_entry 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RecentDTO>>
    */
    @ApiOperation(value = "my_charge_entry", tags = {"最近访问" },  notes = "Recent-my_charge_entry ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-my_charge_entry-all') or hasPermission(this.recentDtoMapping.toDomain(#dto),'ibizplm-Recent-my_charge_entry')")
    @PostMapping("recents/my_charge_entry")
    public Mono<ResponseEntity<ResponseWrapper<RecentDTO>>>myChargeEntry
            (@Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(myChargeEntry(item)));
        else
            rt.set(myChargeEntry(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * my_charge_entry 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO myChargeEntry
            (RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        Recent rt = recentService.myChargeEntry(domain);
        return recentDtoMapping.toDto(rt);
    }

    /**
    * my_created_entry 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RecentDTO>>
    */
    @ApiOperation(value = "my_created_entry", tags = {"最近访问" },  notes = "Recent-my_created_entry ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-my_created_entry-all') or hasPermission(this.recentDtoMapping.toDomain(#dto),'ibizplm-Recent-my_created_entry')")
    @PostMapping("recents/my_created_entry")
    public Mono<ResponseEntity<ResponseWrapper<RecentDTO>>>myCreatedEntry
            (@Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(myCreatedEntry(item)));
        else
            rt.set(myCreatedEntry(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * my_created_entry 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO myCreatedEntry
            (RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        Recent rt = recentService.myCreatedEntry(domain);
        return recentDtoMapping.toDto(rt);
    }

    /**
    * my_summary 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RecentDTO>>
    */
    @ApiOperation(value = "my_summary", tags = {"最近访问" },  notes = "Recent-my_summary ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-my_summary-all') or hasPermission(this.recentDtoMapping.toDomain(#dto),'ibizplm-Recent-my_summary')")
    @PostMapping("recents/my_summary")
    public Mono<ResponseEntity<ResponseWrapper<RecentDTO>>>mySummary
            (@Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mySummary(item)));
        else
            rt.set(mySummary(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * my_summary 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO mySummary
            (RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        Recent rt = recentService.mySummary(domain);
        return recentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RecentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"最近访问" },  notes = "Recent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Save-all') or hasPermission(this.recentDtoMapping.toDomain(#dto),'ibizplm-Recent-Save')")
    @PostMapping("recents/save")
    public Mono<ResponseEntity<ResponseWrapper<RecentDTO>>>save
            (@Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO save
            (RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        recentService.save(domain);
        Recent rt = domain;
        return recentDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 最近访问
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<RecentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"最近访问" },  notes = "Recent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Get-all')  or hasPermission(this.recentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Recent-Get')")
    @GetMapping("recents/{id}")
    public Mono<ResponseEntity<RecentDTO>> getById
            (@PathVariable("id") String id) {
        Recent rt = recentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(recentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 最近访问
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"最近访问" },  notes = "Recent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Remove-all') or hasPermission(this.recentService.get(#id),'ibizplm-Recent-Remove')")
    @DeleteMapping("recents/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = recentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"最近访问" },  notes = "Recent-CheckKey ")
    @PostMapping("recents/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        CheckKeyStatus rt = recentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RecentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"最近访问" },  notes = "Recent-GetDraft ")
    @GetMapping("recents/get_draft")
    public Mono<ResponseEntity<RecentDTO>> getDraft
            (@SpringQueryMap RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        Recent rt = recentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(recentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"最近访问" },  notes = "Recent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-fetch_default-all') or hasPermission(#dto,'ibizplm-Recent-fetch_default')")
    @PostMapping("recents/fetch_default")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchDefault
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchDefault(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_access 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_access", tags = {"最近访问" },  notes = "Recent-fetch_recent_access ")
    @PostMapping("recents/fetch_recent_access")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentAccess
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentAccess(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_curproduct_ticket 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_curproduct_ticket", tags = {"最近访问" },  notes = "Recent-fetch_recent_curproduct_ticket ")
    @PostMapping("recents/fetch_recent_curproduct_ticket")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentCurproductTicket
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentCurproductTicket(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_curproject_child_work_item 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_curproject_child_work_item", tags = {"最近访问" },  notes = "Recent-fetch_recent_curproject_child_work_item ")
    @PostMapping("recents/fetch_recent_curproject_child_work_item")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentCurprojectChildWorkItem
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentCurprojectChildWorkItem(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_curproject_work_item 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_curproject_work_item", tags = {"最近访问" },  notes = "Recent-fetch_recent_curproject_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-fetch_recent_curproject_work_item-all') or hasPermission(#dto,'ibizplm-Recent-fetch_recent_curproject_work_item')")
    @PostMapping("recents/fetch_recent_curproject_work_item")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentCurprojectWorkItem
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentCurprojectWorkItem(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_idea 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_idea", tags = {"最近访问" },  notes = "Recent-fetch_recent_idea ")
    @PostMapping("recents/fetch_recent_idea")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentIdea
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentIdea(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_page 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_page", tags = {"最近访问" },  notes = "Recent-fetch_recent_page ")
    @PostMapping("recents/fetch_recent_page")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentPage
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentPage(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_project 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_project", tags = {"最近访问" },  notes = "Recent-fetch_recent_project ")
    @PostMapping("recents/fetch_recent_project")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentProject
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentProject(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_test_case 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_test_case", tags = {"最近访问" },  notes = "Recent-fetch_recent_test_case ")
    @PostMapping("recents/fetch_recent_test_case")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentTestCase
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentTestCase(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_test_case_index 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_test_case_index", tags = {"最近访问" },  notes = "Recent-fetch_recent_test_case_index ")
    @PostMapping("recents/fetch_recent_test_case_index")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentTestCaseIndex
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentTestCaseIndex(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_ticket 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_ticket", tags = {"最近访问" },  notes = "Recent-fetch_recent_ticket ")
    @PostMapping("recents/fetch_recent_ticket")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentTicket
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentTicket(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_use 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_use", tags = {"最近访问" },  notes = "Recent-fetch_recent_use ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-fetch_recent_use-all') or hasPermission(#dto,'ibizplm-Recent-fetch_recent_use')")
    @PostMapping("recents/fetch_recent_use")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentUse
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentUse(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_work_item 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item", tags = {"最近访问" },  notes = "Recent-fetch_recent_work_item ")
    @PostMapping("recents/fetch_recent_work_item")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentWorkItem
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentWorkItem(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_work_item_and_nobug 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item_and_nobug", tags = {"最近访问" },  notes = "Recent-fetch_recent_work_item_and_nobug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-fetch_recent_work_item_and_nobug-all') or hasPermission(#dto,'ibizplm-Recent-fetch_recent_work_item_and_nobug')")
    @PostMapping("recents/fetch_recent_work_item_and_nobug")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentWorkItemAndNobug
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentWorkItemAndNobug(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_work_item_bug 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item_bug", tags = {"最近访问" },  notes = "Recent-fetch_recent_work_item_bug ")
    @PostMapping("recents/fetch_recent_work_item_bug")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentWorkItemBug
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentWorkItemBug(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_work_item_dependency 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item_dependency", tags = {"最近访问" },  notes = "Recent-fetch_recent_work_item_dependency ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-fetch_recent_work_item_dependency-all') or hasPermission(#dto,'ibizplm-Recent-fetch_recent_work_item_dependency')")
    @PostMapping("recents/fetch_recent_work_item_dependency")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchRecentWorkItemDependency
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchRecentWorkItemDependency(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user 最近访问
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RecentDTO>>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"最近访问" },  notes = "Recent-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-fetch_user-all') or hasPermission(#dto,'ibizplm-Recent-fetch_user')")
    @PostMapping("recents/fetch_user")
    public Mono<ResponseEntity<List<RecentDTO>>> fetchUser
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.fetchUser(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建最近访问
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Create-all')")
    @ApiOperation(value = "批量新建最近访问", tags = {"最近访问" },  notes = "批量新建最近访问")
	@PostMapping("recents/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<RecentDTO> dtos) {
        recentService.create(recentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除最近访问
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Remove-all')")
    @ApiOperation(value = "批量删除最近访问", tags = {"最近访问" },  notes = "批量删除最近访问")
	@DeleteMapping("recents/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        recentService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新最近访问
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Update-all')")
    @ApiOperation(value = "批量更新最近访问", tags = {"最近访问" },  notes = "批量更新最近访问")
	@PutMapping("recents/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<RecentDTO> dtos) {
        recentService.update(recentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存最近访问
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Save-all')")
    @ApiOperation(value = "批量保存最近访问", tags = {"最近访问" },  notes = "批量保存最近访问")
	@PostMapping("recents/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<RecentDTO> dtos) {
        recentService.save(recentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入最近访问
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Save-all')")
    @ApiOperation(value = "批量导入最近访问", tags = {"最近访问" },  notes = "批量导入最近访问")
	@PostMapping("recents/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RecentDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(recentService.importData(config,ignoreError,recentDtoMapping.toDomain(dtos))));
    }

}
