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
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaTemplateService;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaTemplateSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[IdeaTemplate] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractIdeaTemplateResource {

    @Autowired
    public IdeaTemplateService ideaTemplateService;

    @Autowired
    @Lazy
    public IdeaTemplateDTOMapping ideaTemplateDtoMapping;

    @Autowired
    @Lazy
    public IdeaTemplateFilterDTOMapping ideaTemplateFilterDtoMapping;

    /**
    * 创建Create 需求模板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"需求模板" },  notes = "IdeaTemplate-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Create-all') or hasPermission(this.ideaTemplateDtoMapping.toDomain(#dto),'ibizplm-IdeaTemplate-Create')")
    @PostMapping("idea_templates")
    public Mono<ResponseEntity<ResponseWrapper<IdeaTemplateDTO>>>create
            (@Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO create
            (IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        ideaTemplateService.create(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 需求模板
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"需求模板" },  notes = "IdeaTemplate-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Update-all') or hasPermission(this.ideaTemplateService.get(#id),'ibizplm-IdeaTemplate-Update')")
    @VersionCheck(entity = "ideatemplate" , versionfield = "updateTime")
    @PutMapping("idea_templates/{id}")
    public Mono<ResponseEntity<ResponseWrapper<IdeaTemplateDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 需求模板
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO updateById
            (String id, IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        domain.setId(id);
        ideaTemplateService.update(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 需求模板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"需求模板" },  notes = "IdeaTemplate-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Save-all') or hasPermission(this.ideaTemplateDtoMapping.toDomain(#dto),'ibizplm-IdeaTemplate-Save')")
    @PostMapping("idea_templates/save")
    public Mono<ResponseEntity<ResponseWrapper<IdeaTemplateDTO>>>save
            (@Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO save
            (IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        ideaTemplateService.save(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 需求模板
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"需求模板" },  notes = "IdeaTemplate-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Create-all') or hasPermission('product',#productId,this.ideaTemplateDtoMapping.toDomain(#dto),'ibizplm-IdeaTemplate-Create')")
    @PostMapping("products/{productId}/idea_templates")
    public Mono<ResponseEntity<ResponseWrapper<IdeaTemplateDTO>>>createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 需求模板
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO createByProductId
            (String productId, IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ideaTemplateService.create(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 需求模板
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"需求模板" },  notes = "IdeaTemplate-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Update-all') or hasPermission('product',#productId,this.ideaTemplateService.get(#id),'ibizplm-IdeaTemplate-Update')")
    @VersionCheck(entity = "ideatemplate" , versionfield = "updateTime")
    @PutMapping("products/{productId}/idea_templates/{id}")
    public Mono<ResponseEntity<ResponseWrapper<IdeaTemplateDTO>>>updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 需求模板
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO updateByProductIdAndId
            (String productId, String id, IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        domain.setId(id);
        ideaTemplateService.update(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 需求模板
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"需求模板" },  notes = "IdeaTemplate-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Save-all') or hasPermission('product',#productId,this.ideaTemplateDtoMapping.toDomain(#dto),'ibizplm-IdeaTemplate-Save')")
    @PostMapping("products/{productId}/idea_templates/save")
    public Mono<ResponseEntity<ResponseWrapper<IdeaTemplateDTO>>>saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 需求模板
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO saveByProductId
            (String productId, IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ideaTemplateService.save(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 需求模板
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"需求模板" },  notes = "IdeaTemplate-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Get-all')  or hasPermission(this.ideaTemplateDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-IdeaTemplate-Get')")
    @GetMapping("idea_templates/{id}")
    public Mono<ResponseEntity<IdeaTemplateDTO>> getById
            (@PathVariable("id") String id) {
        IdeaTemplate rt = ideaTemplateService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaTemplateDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 需求模板
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"需求模板" },  notes = "IdeaTemplate-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Remove-all') or hasPermission(this.ideaTemplateService.get(#id),'ibizplm-IdeaTemplate-Remove')")
    @DeleteMapping("idea_templates/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = ideaTemplateService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 需求模板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"需求模板" },  notes = "IdeaTemplate-CheckKey ")
    @PostMapping("idea_templates/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        CheckKeyStatus rt = ideaTemplateService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 需求模板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"需求模板" },  notes = "IdeaTemplate-GetDraft ")
    @GetMapping("idea_templates/get_draft")
    public Mono<ResponseEntity<IdeaTemplateDTO>> getDraft
            (@SpringQueryMap IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        IdeaTemplate rt = ideaTemplateService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaTemplateDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 需求模板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaTemplateDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"需求模板" },  notes = "IdeaTemplate-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-fetch_default-all') or hasPermission(#dto,'ibizplm-IdeaTemplate-fetch_default')")
    @PostMapping("idea_templates/fetch_default")
    public Mono<ResponseEntity<List<IdeaTemplateDTO>>> fetchDefault
            (@Validated @RequestBody IdeaTemplateFilterDTO dto) {
        IdeaTemplateSearchContext context = ideaTemplateFilterDtoMapping.toDomain(dto);
        Page<IdeaTemplate> domains = ideaTemplateService.fetchDefault(context) ;
        List<IdeaTemplateDTO> list = ideaTemplateDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_global 需求模板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaTemplateDTO>>>
    */
    @ApiOperation(value = "查询fetch_global", tags = {"需求模板" },  notes = "IdeaTemplate-fetch_global ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-fetch_global-all') or hasPermission(#dto,'ibizplm-IdeaTemplate-fetch_global')")
    @PostMapping("idea_templates/fetch_global")
    public Mono<ResponseEntity<List<IdeaTemplateDTO>>> fetchGlobal
            (@Validated @RequestBody IdeaTemplateFilterDTO dto) {
        IdeaTemplateSearchContext context = ideaTemplateFilterDtoMapping.toDomain(dto);
        Page<IdeaTemplate> domains = ideaTemplateService.fetchGlobal(context) ;
        List<IdeaTemplateDTO> list = ideaTemplateDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 需求模板
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"需求模板" },  notes = "IdeaTemplate-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Get-all')  or hasPermission('product',#productId,this.ideaTemplateDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-IdeaTemplate-Get')")
    @GetMapping("products/{productId}/idea_templates/{id}")
    public Mono<ResponseEntity<IdeaTemplateDTO>> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        IdeaTemplate rt = ideaTemplateService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaTemplateDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 需求模板
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"需求模板" },  notes = "IdeaTemplate-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Remove-all') or hasPermission('product',#productId,this.ideaTemplateService.get(#id),'ibizplm-IdeaTemplate-Remove')")
    @DeleteMapping("products/{productId}/idea_templates/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = ideaTemplateService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 需求模板
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"需求模板" },  notes = "IdeaTemplate-CheckKey ")
    @PostMapping("products/{productId}/idea_templates/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        CheckKeyStatus rt = ideaTemplateService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 需求模板
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"需求模板" },  notes = "IdeaTemplate-GetDraft ")
    @GetMapping("products/{productId}/idea_templates/get_draft")
    public Mono<ResponseEntity<IdeaTemplateDTO>> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        IdeaTemplate rt = ideaTemplateService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaTemplateDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 需求模板
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaTemplateDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"需求模板" },  notes = "IdeaTemplate-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-IdeaTemplate-fetch_default')")
    @PostMapping("products/{productId}/idea_templates/fetch_default")
    public Mono<ResponseEntity<List<IdeaTemplateDTO>>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaTemplateFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaTemplateSearchContext context = ideaTemplateFilterDtoMapping.toDomain(dto);
        Page<IdeaTemplate> domains = ideaTemplateService.fetchDefault(context) ;
        List<IdeaTemplateDTO> list = ideaTemplateDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_global 需求模板
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaTemplateDTO>>>
    */
    @ApiOperation(value = "查询fetch_global", tags = {"需求模板" },  notes = "IdeaTemplate-fetch_global ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-fetch_global-all') or hasPermission('product',#productId,#dto,'ibizplm-IdeaTemplate-fetch_global')")
    @PostMapping("products/{productId}/idea_templates/fetch_global")
    public Mono<ResponseEntity<List<IdeaTemplateDTO>>> fetchGlobalByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaTemplateFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaTemplateSearchContext context = ideaTemplateFilterDtoMapping.toDomain(dto);
        Page<IdeaTemplate> domains = ideaTemplateService.fetchGlobal(context) ;
        List<IdeaTemplateDTO> list = ideaTemplateDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建需求模板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Create-all')")
    @ApiOperation(value = "批量新建需求模板", tags = {"需求模板" },  notes = "批量新建需求模板")
	@PostMapping("idea_templates/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<IdeaTemplateDTO> dtos) {
        ideaTemplateService.create(ideaTemplateDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除需求模板
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Remove-all')")
    @ApiOperation(value = "批量删除需求模板", tags = {"需求模板" },  notes = "批量删除需求模板")
	@DeleteMapping("idea_templates/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        ideaTemplateService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新需求模板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Update-all')")
    @ApiOperation(value = "批量更新需求模板", tags = {"需求模板" },  notes = "批量更新需求模板")
	@PutMapping("idea_templates/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<IdeaTemplateDTO> dtos) {
        ideaTemplateService.update(ideaTemplateDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存需求模板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Save-all')")
    @ApiOperation(value = "批量保存需求模板", tags = {"需求模板" },  notes = "批量保存需求模板")
	@PostMapping("idea_templates/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<IdeaTemplateDTO> dtos) {
        ideaTemplateService.save(ideaTemplateDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入需求模板
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Save-all')")
    @ApiOperation(value = "批量导入需求模板", tags = {"需求模板" },  notes = "批量导入需求模板")
	@PostMapping("idea_templates/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<IdeaTemplateDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaTemplateService.importData(config,ignoreError,ideaTemplateDtoMapping.toDomain(dtos))));
    }

}
