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
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.core.wiki.service.PageVersionService;
import cn.ibizlab.plm.core.wiki.filter.PageVersionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[PageVersion] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPageVersionResource {

    @Autowired
    public PageVersionService pageVersionService;

    @Autowired
    @Lazy
    public PageVersionDTOMapping pageVersionDtoMapping;

    @Autowired
    @Lazy
    public PageVersionFilterDTOMapping pageVersionFilterDtoMapping;

    /**
    * 创建Create 页面版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"页面版本" },  notes = "PageVersion-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Create-all') or hasPermission(this.pageVersionDtoMapping.toDomain(#dto),'ibizplm-PageVersion-Create')")
    @PostMapping("page_versions")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>create
            (@Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO create
            (PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        pageVersionService.create(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 页面版本
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"页面版本" },  notes = "PageVersion-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Update-all') or hasPermission(this.pageVersionService.get(#id),'ibizplm-PageVersion-Update')")
    @VersionCheck(entity = "pageversion" , versionfield = "updateTime")
    @PutMapping("page_versions/{id}")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 页面版本
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO updateById
            (String id, PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setId(id);
        pageVersionService.update(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 页面版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"页面版本" },  notes = "PageVersion-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Save-all') or hasPermission(this.pageVersionDtoMapping.toDomain(#dto),'ibizplm-PageVersion-Save')")
    @PostMapping("page_versions/save")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>save
            (@Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO save
            (PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        pageVersionService.save(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"页面版本" },  notes = "PageVersion-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Create-all') or hasPermission('article_page',#ownerId,this.pageVersionDtoMapping.toDomain(#dto),'ibizplm-PageVersion-Create')")
    @PostMapping("article_pages/{ownerId}/page_versions")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO createByOwnerId
            (String ownerId, PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        pageVersionService.create(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"页面版本" },  notes = "PageVersion-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Update-all') or hasPermission('article_page',#ownerId,this.pageVersionService.get(#id),'ibizplm-PageVersion-Update')")
    @VersionCheck(entity = "pageversion" , versionfield = "updateTime")
    @PutMapping("article_pages/{ownerId}/page_versions/{id}")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO updateByOwnerIdAndId
            (String ownerId, String id, PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setId(id);
        pageVersionService.update(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"页面版本" },  notes = "PageVersion-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Save-all') or hasPermission('article_page',#ownerId,this.pageVersionDtoMapping.toDomain(#dto),'ibizplm-PageVersion-Save')")
    @PostMapping("article_pages/{ownerId}/page_versions/save")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO saveByOwnerId
            (String ownerId, PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        pageVersionService.save(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"页面版本" },  notes = "PageVersion-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Create-all') or hasPermission('shared_space',#spaceId,this.pageVersionDtoMapping.toDomain(#dto),'ibizplm-PageVersion-Create')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/page_versions")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>createBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySpaceIdAndOwnerId(spaceId, ownerId, item)));
        else
            rt.set(createBySpaceIdAndOwnerId(spaceId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO createBySpaceIdAndOwnerId
            (String spaceId, String ownerId, PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        pageVersionService.create(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"页面版本" },  notes = "PageVersion-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Update-all') or hasPermission('shared_space',#spaceId,this.pageVersionService.get(#id),'ibizplm-PageVersion-Update')")
    @VersionCheck(entity = "pageversion" , versionfield = "updateTime")
    @PutMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/page_versions/{id}")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>updateBySpaceIdAndOwnerIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySpaceIdAndOwnerIdAndId(spaceId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySpaceIdAndOwnerIdAndId(spaceId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO updateBySpaceIdAndOwnerIdAndId
            (String spaceId, String ownerId, String id, PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setId(id);
        pageVersionService.update(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"页面版本" },  notes = "PageVersion-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Save-all') or hasPermission('shared_space',#spaceId,this.pageVersionDtoMapping.toDomain(#dto),'ibizplm-PageVersion-Save')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/page_versions/save")
    public Mono<ResponseEntity<ResponseWrapper<PageVersionDTO>>>saveBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySpaceIdAndOwnerId(spaceId, ownerId, item)));
        else
            rt.set(saveBySpaceIdAndOwnerId(spaceId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO saveBySpaceIdAndOwnerId
            (String spaceId, String ownerId, PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        pageVersionService.save(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 页面版本
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"页面版本" },  notes = "PageVersion-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Get-all')  or hasPermission(this.pageVersionDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-PageVersion-Get')")
    @GetMapping("page_versions/{id}")
    public Mono<ResponseEntity<PageVersionDTO>> getById
            (@PathVariable("id") String id) {
        PageVersion rt = pageVersionService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(pageVersionDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 页面版本
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面版本" },  notes = "PageVersion-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Remove-all') or hasPermission(this.pageVersionService.get(#id),'ibizplm-PageVersion-Remove')")
    @DeleteMapping("page_versions/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = pageVersionService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 页面版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面版本" },  notes = "PageVersion-CheckKey ")
    @PostMapping("page_versions/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        CheckKeyStatus rt = pageVersionService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 页面版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面版本" },  notes = "PageVersion-GetDraft ")
    @GetMapping("page_versions/get_draft")
    public Mono<ResponseEntity<PageVersionDTO>> getDraft
            (@SpringQueryMap PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        PageVersion rt = pageVersionService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(pageVersionDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 页面版本
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<PageVersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面版本" },  notes = "PageVersion-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-fetch_default-all') or hasPermission(#dto,'ibizplm-PageVersion-fetch_default')")
    @PostMapping("page_versions/fetch_default")
    public Mono<ResponseEntity<List<PageVersionDTO>>> fetchDefault
            (@Validated @RequestBody PageVersionFilterDTO dto) {
        PageVersionSearchContext context = pageVersionFilterDtoMapping.toDomain(dto);
        Page<PageVersion> domains = pageVersionService.fetchDefault(context) ;
        List<PageVersionDTO> list = pageVersionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"页面版本" },  notes = "PageVersion-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Get-all')  or hasPermission('article_page',#ownerId,this.pageVersionDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-PageVersion-Get')")
    @GetMapping("article_pages/{ownerId}/page_versions/{id}")
    public Mono<ResponseEntity<PageVersionDTO>> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        PageVersion rt = pageVersionService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(pageVersionDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面版本" },  notes = "PageVersion-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Remove-all') or hasPermission('article_page',#ownerId,this.pageVersionService.get(#id),'ibizplm-PageVersion-Remove')")
    @DeleteMapping("article_pages/{ownerId}/page_versions/{id}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = pageVersionService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面版本" },  notes = "PageVersion-CheckKey ")
    @PostMapping("article_pages/{ownerId}/page_versions/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = pageVersionService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面版本" },  notes = "PageVersion-GetDraft ")
    @GetMapping("article_pages/{ownerId}/page_versions/get_draft")
    public Mono<ResponseEntity<PageVersionDTO>> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        PageVersion rt = pageVersionService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(pageVersionDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 页面版本
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<PageVersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面版本" },  notes = "PageVersion-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-fetch_default-all') or hasPermission('article_page',#ownerId,#dto,'ibizplm-PageVersion-fetch_default')")
    @PostMapping("article_pages/{ownerId}/page_versions/fetch_default")
    public Mono<ResponseEntity<List<PageVersionDTO>>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody PageVersionFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        PageVersionSearchContext context = pageVersionFilterDtoMapping.toDomain(dto);
        Page<PageVersion> domains = pageVersionService.fetchDefault(context) ;
        List<PageVersionDTO> list = pageVersionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"页面版本" },  notes = "PageVersion-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Get-all')  or hasPermission('shared_space',#spaceId,this.pageVersionDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-PageVersion-Get')")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/page_versions/{id}")
    public Mono<ResponseEntity<PageVersionDTO>> getBySpaceIdAndOwnerIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        PageVersion rt = pageVersionService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(pageVersionDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面版本" },  notes = "PageVersion-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Remove-all') or hasPermission('shared_space',#spaceId,this.pageVersionService.get(#id),'ibizplm-PageVersion-Remove')")
    @DeleteMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/page_versions/{id}")
    public Mono<ResponseEntity<Boolean>> removeBySpaceIdAndOwnerIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = pageVersionService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面版本" },  notes = "PageVersion-CheckKey ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/page_versions/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = pageVersionService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<PageVersionDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面版本" },  notes = "PageVersion-GetDraft ")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/page_versions/get_draft")
    public Mono<ResponseEntity<PageVersionDTO>> getDraftBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @SpringQueryMap PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        PageVersion rt = pageVersionService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(pageVersionDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 页面版本
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<PageVersionDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面版本" },  notes = "PageVersion-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-fetch_default-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-PageVersion-fetch_default')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/page_versions/fetch_default")
    public Mono<ResponseEntity<List<PageVersionDTO>>> fetchDefaultBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody PageVersionFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        PageVersionSearchContext context = pageVersionFilterDtoMapping.toDomain(dto);
        Page<PageVersion> domains = pageVersionService.fetchDefault(context) ;
        List<PageVersionDTO> list = pageVersionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建页面版本
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Create-all')")
    @ApiOperation(value = "批量新建页面版本", tags = {"页面版本" },  notes = "批量新建页面版本")
	@PostMapping("page_versions/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<PageVersionDTO> dtos) {
        pageVersionService.create(pageVersionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除页面版本
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Remove-all')")
    @ApiOperation(value = "批量删除页面版本", tags = {"页面版本" },  notes = "批量删除页面版本")
	@DeleteMapping("page_versions/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        pageVersionService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新页面版本
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Update-all')")
    @ApiOperation(value = "批量更新页面版本", tags = {"页面版本" },  notes = "批量更新页面版本")
	@PutMapping("page_versions/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<PageVersionDTO> dtos) {
        pageVersionService.update(pageVersionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存页面版本
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Save-all')")
    @ApiOperation(value = "批量保存页面版本", tags = {"页面版本" },  notes = "批量保存页面版本")
	@PostMapping("page_versions/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<PageVersionDTO> dtos) {
        pageVersionService.save(pageVersionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入页面版本
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Save-all')")
    @ApiOperation(value = "批量导入页面版本", tags = {"页面版本" },  notes = "批量导入页面版本")
	@PostMapping("page_versions/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<PageVersionDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(pageVersionService.importData(config,ignoreError,pageVersionDtoMapping.toDomain(dtos))));
    }

}
