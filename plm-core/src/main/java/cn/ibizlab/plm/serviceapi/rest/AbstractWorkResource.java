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
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.service.WorkService;
import cn.ibizlab.plm.core.base.filter.WorkSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Work] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkResource {

    @Autowired
    public WorkService workService;

    @Autowired
    @Lazy
    public WorkDTOMapping workDtoMapping;

    @Autowired
    @Lazy
    public WorkFilterDTOMapping workFilterDtoMapping;

    /**
    * 创建Create 工作
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工作" },  notes = "Work-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Create-all') or hasPermission(this.workDtoMapping.toDomain(#dto),'ibizplm-Work-Create')")
    @PostMapping("works")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>create
            (@Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工作
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO create
            (WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        workService.create(domain);
        Work rt = domain;
        return workDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工作
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工作" },  notes = "Work-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Update-all') or hasPermission(this.workService.get(#id),'ibizplm-Work-Update')")
    @VersionCheck(entity = "work" , versionfield = "updateTime")
    @PutMapping("works/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工作
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO updateById
            (String id, WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        domain.setId(id);
        workService.update(domain);
        Work rt = domain;
        return workDtoMapping.toDto(rt);
    }

    /**
    * add_project 工作
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "add_project", tags = {"工作" },  notes = "Work-add_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-add_project-all') or hasPermission(this.workDtoMapping.toDomain(#dto),'ibizplm-Work-add_project')")
    @PostMapping("works/add_project")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>addProject
            (@Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addProject(item)));
        else
            rt.set(addProject(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_project 工作
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO addProject
            (WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        Work rt = workService.addProject(domain);
        return workDtoMapping.toDto(rt);
    }

    /**
    * add_project_portfolio 工作
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "add_project_portfolio", tags = {"工作" },  notes = "Work-add_project_portfolio ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-add_project_portfolio-all') or hasPermission(this.workDtoMapping.toDomain(#dto),'ibizplm-Work-add_project_portfolio')")
    @PostMapping("works/add_project_portfolio")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>addProjectPortfolio
            (@Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addProjectPortfolio(item)));
        else
            rt.set(addProjectPortfolio(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_project_portfolio 工作
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO addProjectPortfolio
            (WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        Work rt = workService.addProjectPortfolio(domain);
        return workDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工作
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工作" },  notes = "Work-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Save-all') or hasPermission(this.workDtoMapping.toDomain(#dto),'ibizplm-Work-Save')")
    @PostMapping("works/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>save
            (@Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工作
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO save
            (WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        workService.save(domain);
        Work rt = domain;
        return workDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工作" },  notes = "Work-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Create-all') or hasPermission('portfolio',#portfolioId,this.workDtoMapping.toDomain(#dto),'ibizplm-Work-Create')")
    @PostMapping("portfolios/{portfolioId}/works")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>createByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPortfolioId(portfolioId, item)));
        else
            rt.set(createByPortfolioId(portfolioId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO createByPortfolioId
            (String portfolioId, WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        workService.create(domain);
        Work rt = domain;
        return workDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工作" },  notes = "Work-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Update-all') or hasPermission('portfolio',#portfolioId,this.workService.get(#id),'ibizplm-Work-Update')")
    @VersionCheck(entity = "work" , versionfield = "updateTime")
    @PutMapping("portfolios/{portfolioId}/works/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>updateByPortfolioIdAndId
            (@PathVariable("portfolioId") String portfolioId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPortfolioIdAndId(portfolioId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPortfolioIdAndId(portfolioId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO updateByPortfolioIdAndId
            (String portfolioId, String id, WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        domain.setId(id);
        workService.update(domain);
        Work rt = domain;
        return workDtoMapping.toDto(rt);
    }

    /**
    * add_project 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "add_project", tags = {"工作" },  notes = "Work-add_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-add_project-all') or hasPermission('portfolio',#portfolioId,this.workDtoMapping.toDomain(#dto),'ibizplm-Work-add_project')")
    @PostMapping("portfolios/{portfolioId}/works/add_project")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>addProjectByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addProjectByPortfolioId(portfolioId, item)));
        else
            rt.set(addProjectByPortfolioId(portfolioId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_project 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO addProjectByPortfolioId
            (String portfolioId, WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        Work rt = workService.addProject(domain);
        return workDtoMapping.toDto(rt);
    }

    /**
    * add_project_portfolio 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "add_project_portfolio", tags = {"工作" },  notes = "Work-add_project_portfolio ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-add_project_portfolio-all') or hasPermission('portfolio',#portfolioId,this.workDtoMapping.toDomain(#dto),'ibizplm-Work-add_project_portfolio')")
    @PostMapping("portfolios/{portfolioId}/works/add_project_portfolio")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>addProjectPortfolioByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addProjectPortfolioByPortfolioId(portfolioId, item)));
        else
            rt.set(addProjectPortfolioByPortfolioId(portfolioId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_project_portfolio 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO addProjectPortfolioByPortfolioId
            (String portfolioId, WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        Work rt = workService.addProjectPortfolio(domain);
        return workDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工作" },  notes = "Work-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Save-all') or hasPermission('portfolio',#portfolioId,this.workDtoMapping.toDomain(#dto),'ibizplm-Work-Save')")
    @PostMapping("portfolios/{portfolioId}/works/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkDTO>>>saveByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody RequestWrapper<WorkDTO> dto) {
        ResponseWrapper<WorkDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPortfolioId(portfolioId, item)));
        else
            rt.set(saveByPortfolioId(portfolioId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<WorkDTO>
    */   
    public WorkDTO saveByPortfolioId
            (String portfolioId, WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        workService.save(domain);
        Work rt = domain;
        return workDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工作
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工作" },  notes = "Work-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Get-all')  or hasPermission(this.workDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Work-Get')")
    @GetMapping("works/{id}")
    public Mono<ResponseEntity<WorkDTO>> getById
            (@PathVariable("id") String id) {
        Work rt = workService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工作
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作" },  notes = "Work-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Remove-all') or hasPermission(this.workService.get(#id),'ibizplm-Work-Remove')")
    @DeleteMapping("works/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = workService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工作
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作" },  notes = "Work-CheckKey ")
    @PostMapping("works/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        CheckKeyStatus rt = workService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 工作
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作" },  notes = "Work-GetDraft ")
    @GetMapping("works/get_draft")
    public Mono<ResponseEntity<WorkDTO>> getDraft
            (@SpringQueryMap WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        Work rt = workService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 工作
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作" },  notes = "Work-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-fetch_default-all') or hasPermission(#dto,'ibizplm-Work-fetch_default')")
    @PostMapping("works/fetch_default")
    public Mono<ResponseEntity<List<WorkDTO>>> fetchDefault
            (@Validated @RequestBody WorkFilterDTO dto) {
        WorkSearchContext context = workFilterDtoMapping.toDomain(dto);
        Page<Work> domains = workService.fetchDefault(context) ;
        List<WorkDTO> list = workDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_item_set_owner 工作
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkDTO>>>
    */
    @ApiOperation(value = "查询fetch_item_set_owner", tags = {"工作" },  notes = "Work-fetch_item_set_owner ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-fetch_item_set_owner-all') or hasPermission(#dto,'ibizplm-Work-fetch_item_set_owner')")
    @PostMapping("works/fetch_item_set_owner")
    public Mono<ResponseEntity<List<WorkDTO>>> fetchItemSetOwner
            (@Validated @RequestBody WorkFilterDTO dto) {
        WorkSearchContext context = workFilterDtoMapping.toDomain(dto);
        Page<Work> domains = workService.fetchItemSetOwner(context) ;
        List<WorkDTO> list = workDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param id id
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工作" },  notes = "Work-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Get-all')  or hasPermission('portfolio',#portfolioId,this.workDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Work-Get')")
    @GetMapping("portfolios/{portfolioId}/works/{id}")
    public Mono<ResponseEntity<WorkDTO>> getByPortfolioIdAndId
            (@PathVariable("portfolioId") String portfolioId, @PathVariable("id") String id) {
        Work rt = workService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作" },  notes = "Work-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-Remove-all') or hasPermission('portfolio',#portfolioId,this.workService.get(#id),'ibizplm-Work-Remove')")
    @DeleteMapping("portfolios/{portfolioId}/works/{id}")
    public Mono<ResponseEntity<Boolean>> removeByPortfolioIdAndId
            (@PathVariable("portfolioId") String portfolioId, @PathVariable("id") String id) {
        Boolean rt = workService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作" },  notes = "Work-CheckKey ")
    @PostMapping("portfolios/{portfolioId}/works/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        CheckKeyStatus rt = workService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作" },  notes = "Work-GetDraft ")
    @GetMapping("portfolios/{portfolioId}/works/get_draft")
    public Mono<ResponseEntity<WorkDTO>> getDraftByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @SpringQueryMap WorkDTO dto) {
        Work domain = workDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        Work rt = workService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作" },  notes = "Work-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-fetch_default-all') or hasPermission('portfolio',#portfolioId,#dto,'ibizplm-Work-fetch_default')")
    @PostMapping("portfolios/{portfolioId}/works/fetch_default")
    public Mono<ResponseEntity<List<WorkDTO>>> fetchDefaultByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody WorkFilterDTO dto) {
        dto.setPortfolioIdEQ(portfolioId);
        WorkSearchContext context = workFilterDtoMapping.toDomain(dto);
        Page<Work> domains = workService.fetchDefault(context) ;
        List<WorkDTO> list = workDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_item_set_owner 工作
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkDTO>>>
    */
    @ApiOperation(value = "查询fetch_item_set_owner", tags = {"工作" },  notes = "Work-fetch_item_set_owner ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Work-fetch_item_set_owner-all') or hasPermission('portfolio',#portfolioId,#dto,'ibizplm-Work-fetch_item_set_owner')")
    @PostMapping("portfolios/{portfolioId}/works/fetch_item_set_owner")
    public Mono<ResponseEntity<List<WorkDTO>>> fetchItemSetOwnerByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody WorkFilterDTO dto) {
        dto.setPortfolioIdEQ(portfolioId);
        WorkSearchContext context = workFilterDtoMapping.toDomain(dto);
        Page<Work> domains = workService.fetchItemSetOwner(context) ;
        List<WorkDTO> list = workDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建工作
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Work-Create-all')")
    @ApiOperation(value = "批量新建工作", tags = {"工作" },  notes = "批量新建工作")
	@PostMapping("works/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<WorkDTO> dtos) {
        workService.create(workDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除工作
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Work-Remove-all')")
    @ApiOperation(value = "批量删除工作", tags = {"工作" },  notes = "批量删除工作")
	@DeleteMapping("works/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        workService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新工作
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Work-Update-all')")
    @ApiOperation(value = "批量更新工作", tags = {"工作" },  notes = "批量更新工作")
	@PutMapping("works/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<WorkDTO> dtos) {
        workService.update(workDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存工作
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Work-Save-all')")
    @ApiOperation(value = "批量保存工作", tags = {"工作" },  notes = "批量保存工作")
	@PostMapping("works/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<WorkDTO> dtos) {
        workService.save(workDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入工作
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Work-Save-all')")
    @ApiOperation(value = "批量导入工作", tags = {"工作" },  notes = "批量导入工作")
	@PostMapping("works/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<WorkDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(workService.importData(config,ignoreError,workDtoMapping.toDomain(dtos))));
    }

}
