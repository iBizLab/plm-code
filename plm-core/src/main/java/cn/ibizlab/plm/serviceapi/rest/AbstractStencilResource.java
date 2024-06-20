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
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.core.wiki.service.StencilService;
import cn.ibizlab.plm.core.wiki.filter.StencilSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Stencil] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractStencilResource {

    @Autowired
    public StencilService stencilService;

    @Autowired
    @Lazy
    public StencilDTOMapping stencilDtoMapping;

    @Autowired
    @Lazy
    public StencilFilterDTOMapping stencilFilterDtoMapping;

    /**
    * 创建Create 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"页面模板" },  notes = "Stencil-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Create-all') or hasPermission(this.stencilDtoMapping.toDomain(#dto),'ibizplm-Stencil-Create')")
    @PostMapping("stencils")
    public ResponseEntity<ResponseWrapper<StencilDTO>> create
            (@Validated @RequestBody RequestWrapper<StencilDTO> dto) {
        ResponseWrapper<StencilDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */   
    public StencilDTO create
            (StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        stencilService.create(domain);
        Stencil rt = domain;
        return stencilDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 页面模板
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"页面模板" },  notes = "Stencil-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Update-all') or hasPermission(this.stencilService.get(#id),'ibizplm-Stencil-Update')")
    @VersionCheck(entity = "stencil" , versionfield = "updateTime")
    @PutMapping("stencils/{id}")
    public ResponseEntity<ResponseWrapper<StencilDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<StencilDTO> dto) {
        ResponseWrapper<StencilDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 页面模板
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */   
    public StencilDTO updateById
            (String id, StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        domain.setId(id);
        stencilService.update(domain);
        Stencil rt = domain;
        return stencilDtoMapping.toDto(rt);
    }

    /**
    * new_draft_form_stencil 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "new_draft_form_stencil", tags = {"页面模板" },  notes = "Stencil-new_draft_form_stencil ")
    @PostMapping("stencils/new_draft_form_stencil")
    public ResponseEntity<ResponseWrapper<StencilDTO>> newDraftFormStencil
            (@Validated @RequestBody RequestWrapper<StencilDTO> dto) {
        ResponseWrapper<StencilDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(newDraftFormStencil(item)));
        else
            rt.set(newDraftFormStencil(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * new_draft_form_stencil 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */   
    public StencilDTO newDraftFormStencil
            (StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        Stencil rt = stencilService.newDraftFormStencil(domain);
        return stencilDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"页面模板" },  notes = "Stencil-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Save-all') or hasPermission(this.stencilDtoMapping.toDomain(#dto),'ibizplm-Stencil-Save')")
    @PostMapping("stencils/save")
    public ResponseEntity<ResponseWrapper<StencilDTO>> save
            (@Validated @RequestBody RequestWrapper<StencilDTO> dto) {
        ResponseWrapper<StencilDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */   
    public StencilDTO save
            (StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        stencilService.save(domain);
        Stencil rt = domain;
        return stencilDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"页面模板" },  notes = "Stencil-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Create-all') or hasPermission('space',#spaceId,this.stencilDtoMapping.toDomain(#dto),'ibizplm-Stencil-Create')")
    @PostMapping("spaces/{spaceId}/stencils")
    public ResponseEntity<ResponseWrapper<StencilDTO>> createBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<StencilDTO> dto) {
        ResponseWrapper<StencilDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySpaceId(spaceId, item)));
        else
            rt.set(createBySpaceId(spaceId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */   
    public StencilDTO createBySpaceId
            (String spaceId, StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        stencilService.create(domain);
        Stencil rt = domain;
        return stencilDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"页面模板" },  notes = "Stencil-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Update-all') or hasPermission('space',#spaceId,this.stencilService.get(#id),'ibizplm-Stencil-Update')")
    @VersionCheck(entity = "stencil" , versionfield = "updateTime")
    @PutMapping("spaces/{spaceId}/stencils/{id}")
    public ResponseEntity<ResponseWrapper<StencilDTO>> updateBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<StencilDTO> dto) {
        ResponseWrapper<StencilDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */   
    public StencilDTO updateBySpaceIdAndId
            (String spaceId, String id, StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        domain.setId(id);
        stencilService.update(domain);
        Stencil rt = domain;
        return stencilDtoMapping.toDto(rt);
    }

    /**
    * new_draft_form_stencil 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "new_draft_form_stencil", tags = {"页面模板" },  notes = "Stencil-new_draft_form_stencil ")
    @PostMapping("spaces/{spaceId}/stencils/new_draft_form_stencil")
    public ResponseEntity<ResponseWrapper<StencilDTO>> newDraftFormStencilBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<StencilDTO> dto) {
        ResponseWrapper<StencilDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(newDraftFormStencilBySpaceId(spaceId, item)));
        else
            rt.set(newDraftFormStencilBySpaceId(spaceId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * new_draft_form_stencil 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */   
    public StencilDTO newDraftFormStencilBySpaceId
            (String spaceId, StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        Stencil rt = stencilService.newDraftFormStencil(domain);
        return stencilDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"页面模板" },  notes = "Stencil-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Save-all') or hasPermission('space',#spaceId,this.stencilDtoMapping.toDomain(#dto),'ibizplm-Stencil-Save')")
    @PostMapping("spaces/{spaceId}/stencils/save")
    public ResponseEntity<ResponseWrapper<StencilDTO>> saveBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<StencilDTO> dto) {
        ResponseWrapper<StencilDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySpaceId(spaceId, item)));
        else
            rt.set(saveBySpaceId(spaceId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */   
    public StencilDTO saveBySpaceId
            (String spaceId, StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        stencilService.save(domain);
        Stencil rt = domain;
        return stencilDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 页面模板
    * 
    *
    * @param id id
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"页面模板" },  notes = "Stencil-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Get-all')  or hasPermission(this.stencilDtoMapping.toDomain(returnObject.body),'ibizplm-Stencil-Get')")
    @GetMapping("stencils/{id}")
    public ResponseEntity<StencilDTO> getById
            (@PathVariable("id") String id) {
        Stencil rt = stencilService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(stencilDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 页面模板
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面模板" },  notes = "Stencil-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Remove-all') or hasPermission(this.stencilService.get(#id),'ibizplm-Stencil-Remove')")
    @DeleteMapping("stencils/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = stencilService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面模板" },  notes = "Stencil-CheckKey ")
    @PostMapping("stencils/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        Integer rt = stencilService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面模板" },  notes = "Stencil-GetDraft ")
    @GetMapping("stencils/get_draft")
    public ResponseEntity<StencilDTO> getDraft
            (@SpringQueryMap StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        Stencil rt = stencilService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(stencilDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<StencilDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面模板" },  notes = "Stencil-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-fetch_default-all') or hasPermission(#dto,'ibizplm-Stencil-fetch_default')")
    @PostMapping("stencils/fetch_default")
    public ResponseEntity<List<StencilDTO>> fetchDefault
            (@Validated @RequestBody StencilFilterDTO dto) {
        StencilSearchContext context = stencilFilterDtoMapping.toDomain(dto);
        Page<Stencil> domains = stencilService.fetchDefault(context) ;
        List<StencilDTO> list = stencilDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_no_space_stencil 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<StencilDTO>>
    */
    @ApiOperation(value = "查询fetch_no_space_stencil", tags = {"页面模板" },  notes = "Stencil-fetch_no_space_stencil ")
    @PostMapping("stencils/fetch_no_space_stencil")
    public ResponseEntity<List<StencilDTO>> fetchNoSpaceStencil
            (@Validated @RequestBody StencilFilterDTO dto) {
        StencilSearchContext context = stencilFilterDtoMapping.toDomain(dto);
        Page<Stencil> domains = stencilService.fetchNoSpaceStencil(context) ;
        List<StencilDTO> list = stencilDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_reader 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<StencilDTO>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"页面模板" },  notes = "Stencil-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-fetch_reader-all') or hasPermission(#dto,'ibizplm-Stencil-fetch_reader')")
    @PostMapping("stencils/fetch_reader")
    public ResponseEntity<List<StencilDTO>> fetchReader
            (@Validated @RequestBody StencilFilterDTO dto) {
        StencilSearchContext context = stencilFilterDtoMapping.toDomain(dto);
        Page<Stencil> domains = stencilService.fetchReader(context) ;
        List<StencilDTO> list = stencilDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_space_stencil 页面模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<StencilDTO>>
    */
    @ApiOperation(value = "查询fetch_space_stencil", tags = {"页面模板" },  notes = "Stencil-fetch_space_stencil ")
    @PostMapping("stencils/fetch_space_stencil")
    public ResponseEntity<List<StencilDTO>> fetchSpaceStencil
            (@Validated @RequestBody StencilFilterDTO dto) {
        StencilSearchContext context = stencilFilterDtoMapping.toDomain(dto);
        Page<Stencil> domains = stencilService.fetchSpaceStencil(context) ;
        List<StencilDTO> list = stencilDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"页面模板" },  notes = "Stencil-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Get-all')  or hasPermission('space',#spaceId,this.stencilDtoMapping.toDomain(returnObject.body),'ibizplm-Stencil-Get')")
    @GetMapping("spaces/{spaceId}/stencils/{id}")
    public ResponseEntity<StencilDTO> getBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        Stencil rt = stencilService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(stencilDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面模板" },  notes = "Stencil-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-Remove-all') or hasPermission('space',#spaceId,this.stencilService.get(#id),'ibizplm-Stencil-Remove')")
    @DeleteMapping("spaces/{spaceId}/stencils/{id}")
    public ResponseEntity<Boolean> removeBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        Boolean rt = stencilService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面模板" },  notes = "Stencil-CheckKey ")
    @PostMapping("spaces/{spaceId}/stencils/check_key")
    public ResponseEntity<Integer> checkKeyBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        Integer rt = stencilService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<StencilDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面模板" },  notes = "Stencil-GetDraft ")
    @GetMapping("spaces/{spaceId}/stencils/get_draft")
    public ResponseEntity<StencilDTO> getDraftBySpaceId
            (@PathVariable("spaceId") String spaceId, @SpringQueryMap StencilDTO dto) {
        Stencil domain = stencilDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        Stencil rt = stencilService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(stencilDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<StencilDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面模板" },  notes = "Stencil-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-fetch_default-all') or hasPermission('space',#spaceId,#dto,'ibizplm-Stencil-fetch_default')")
    @PostMapping("spaces/{spaceId}/stencils/fetch_default")
    public ResponseEntity<List<StencilDTO>> fetchDefaultBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody StencilFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        StencilSearchContext context = stencilFilterDtoMapping.toDomain(dto);
        Page<Stencil> domains = stencilService.fetchDefault(context) ;
        List<StencilDTO> list = stencilDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_no_space_stencil 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<StencilDTO>>
    */
    @ApiOperation(value = "查询fetch_no_space_stencil", tags = {"页面模板" },  notes = "Stencil-fetch_no_space_stencil ")
    @PostMapping("spaces/{spaceId}/stencils/fetch_no_space_stencil")
    public ResponseEntity<List<StencilDTO>> fetchNoSpaceStencilBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody StencilFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        StencilSearchContext context = stencilFilterDtoMapping.toDomain(dto);
        Page<Stencil> domains = stencilService.fetchNoSpaceStencil(context) ;
        List<StencilDTO> list = stencilDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_reader 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<StencilDTO>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"页面模板" },  notes = "Stencil-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stencil-fetch_reader-all') or hasPermission('space',#spaceId,#dto,'ibizplm-Stencil-fetch_reader')")
    @PostMapping("spaces/{spaceId}/stencils/fetch_reader")
    public ResponseEntity<List<StencilDTO>> fetchReaderBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody StencilFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        StencilSearchContext context = stencilFilterDtoMapping.toDomain(dto);
        Page<Stencil> domains = stencilService.fetchReader(context) ;
        List<StencilDTO> list = stencilDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_space_stencil 页面模板
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<StencilDTO>>
    */
    @ApiOperation(value = "查询fetch_space_stencil", tags = {"页面模板" },  notes = "Stencil-fetch_space_stencil ")
    @PostMapping("spaces/{spaceId}/stencils/fetch_space_stencil")
    public ResponseEntity<List<StencilDTO>> fetchSpaceStencilBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody StencilFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        StencilSearchContext context = stencilFilterDtoMapping.toDomain(dto);
        Page<Stencil> domains = stencilService.fetchSpaceStencil(context) ;
        List<StencilDTO> list = stencilDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建页面模板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stencil-Create-all')")
    @ApiOperation(value = "批量新建页面模板", tags = {"页面模板" },  notes = "批量新建页面模板")
	@PostMapping("stencils/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<StencilDTO> dtos) {
        stencilService.create(stencilDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除页面模板
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stencil-Remove-all')")
    @ApiOperation(value = "批量删除页面模板", tags = {"页面模板" },  notes = "批量删除页面模板")
	@DeleteMapping("stencils/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        stencilService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新页面模板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stencil-Update-all')")
    @ApiOperation(value = "批量更新页面模板", tags = {"页面模板" },  notes = "批量更新页面模板")
	@PutMapping("stencils/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<StencilDTO> dtos) {
        stencilService.update(stencilDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存页面模板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stencil-Save-all')")
    @ApiOperation(value = "批量保存页面模板", tags = {"页面模板" },  notes = "批量保存页面模板")
	@PostMapping("stencils/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<StencilDTO> dtos) {
        stencilService.save(stencilDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入页面模板
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stencil-Save-all')")
    @ApiOperation(value = "批量导入页面模板", tags = {"页面模板" },  notes = "批量导入页面模板")
	@PostMapping("stencils/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<StencilDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(stencilService.importData(config,ignoreError,stencilDtoMapping.toDomain(dtos)));
    }

}
