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
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.wiki.service.BaselinePageService;
import cn.ibizlab.plm.core.wiki.filter.BaselinePageSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[BaselinePage] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselinePageResource {

    @Autowired
    public BaselinePageService baselinePageService;

    @Autowired
    @Lazy
    public BaselinePageDTOMapping baselinePageDtoMapping;

    @Autowired
    @Lazy
    public BaselinePageFilterDTOMapping baselinePageFilterDtoMapping;

    /**
    * 创建Create 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"基线页面" },  notes = "BaselinePage-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Create-all') or hasPermission(this.baselinePageDtoMapping.toDomain(#dto),'ibizplm-BaselinePage-Create')")
    @PostMapping("baseline_pages")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> create
            (@Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO create
            (BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        baselinePageService.create(domain);
        BaselinePage rt = domain;
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 基线页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"基线页面" },  notes = "BaselinePage-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Update-all') or hasPermission(this.baselinePageService.get(#id),'ibizplm-BaselinePage-Update')")
    @VersionCheck(entity = "baselinepage" , versionfield = "updateTime")
    @PutMapping("baseline_pages/{id}")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 基线页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO updateById
            (String id, BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        domain.setId(id);
        baselinePageService.update(domain);
        BaselinePage rt = domain;
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"基线页面" },  notes = "BaselinePage-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Save-all') or hasPermission(this.baselinePageDtoMapping.toDomain(#dto),'ibizplm-BaselinePage-Save')")
    @PostMapping("baseline_pages/save")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> save
            (@Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO save
            (BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        baselinePageService.save(domain);
        BaselinePage rt = domain;
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * shift_in_baseline 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "shift_in_baseline", tags = {"基线页面" },  notes = "BaselinePage-shift_in_baseline ")
    @PostMapping("baseline_pages/shift_in_baseline")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> shiftInBaseline
            (@Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftInBaseline(item)));
        else
            rt.set(shiftInBaseline(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * shift_in_baseline 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO shiftInBaseline
            (BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        BaselinePage rt = baselinePageService.shiftInBaseline(domain);
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * shift_out_baseline 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "shift_out_baseline", tags = {"基线页面" },  notes = "BaselinePage-shift_out_baseline ")
    @PostMapping("baseline_pages/shift_out_baseline")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> shiftOutBaseline
            (@Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftOutBaseline(item)));
        else
            rt.set(shiftOutBaseline(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * shift_out_baseline 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO shiftOutBaseline
            (BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        BaselinePage rt = baselinePageService.shiftOutBaseline(domain);
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"基线页面" },  notes = "BaselinePage-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Create-all') or hasPermission('library',#ownerId,this.baselinePageDtoMapping.toDomain(#dto),'ibizplm-BaselinePage-Create')")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> createByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerIdAndPrincipalId(ownerId, principalId, item)));
        else
            rt.set(createByOwnerIdAndPrincipalId(ownerId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO createByOwnerIdAndPrincipalId
            (String ownerId, String principalId, BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        baselinePageService.create(domain);
        BaselinePage rt = domain;
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"基线页面" },  notes = "BaselinePage-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Update-all') or hasPermission('library',#ownerId,this.baselinePageService.get(#id),'ibizplm-BaselinePage-Update')")
    @VersionCheck(entity = "baselinepage" , versionfield = "updateTime")
    @PutMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/{id}")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> updateByOwnerIdAndPrincipalIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndPrincipalIdAndId(ownerId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndPrincipalIdAndId(ownerId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO updateByOwnerIdAndPrincipalIdAndId
            (String ownerId, String principalId, String id, BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        domain.setId(id);
        baselinePageService.update(domain);
        BaselinePage rt = domain;
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"基线页面" },  notes = "BaselinePage-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Save-all') or hasPermission('library',#ownerId,this.baselinePageDtoMapping.toDomain(#dto),'ibizplm-BaselinePage-Save')")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/save")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> saveByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerIdAndPrincipalId(ownerId, principalId, item)));
        else
            rt.set(saveByOwnerIdAndPrincipalId(ownerId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO saveByOwnerIdAndPrincipalId
            (String ownerId, String principalId, BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        baselinePageService.save(domain);
        BaselinePage rt = domain;
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * shift_in_baseline 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "shift_in_baseline", tags = {"基线页面" },  notes = "BaselinePage-shift_in_baseline ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/shift_in_baseline")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> shiftInBaselineByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftInBaselineByOwnerIdAndPrincipalId(ownerId, principalId, item)));
        else
            rt.set(shiftInBaselineByOwnerIdAndPrincipalId(ownerId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * shift_in_baseline 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO shiftInBaselineByOwnerIdAndPrincipalId
            (String ownerId, String principalId, BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        BaselinePage rt = baselinePageService.shiftInBaseline(domain);
        return baselinePageDtoMapping.toDto(rt);
    }

    /**
    * shift_out_baseline 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "shift_out_baseline", tags = {"基线页面" },  notes = "BaselinePage-shift_out_baseline ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/shift_out_baseline")
    public ResponseEntity<ResponseWrapper<BaselinePageDTO>> shiftOutBaselineByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<BaselinePageDTO> dto) {
        ResponseWrapper<BaselinePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftOutBaselineByOwnerIdAndPrincipalId(ownerId, principalId, item)));
        else
            rt.set(shiftOutBaselineByOwnerIdAndPrincipalId(ownerId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * shift_out_baseline 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */   
    public BaselinePageDTO shiftOutBaselineByOwnerIdAndPrincipalId
            (String ownerId, String principalId, BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        BaselinePage rt = baselinePageService.shiftOutBaseline(domain);
        return baselinePageDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 基线页面
    * 
    *
    * @param id id
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"基线页面" },  notes = "BaselinePage-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Get-all')  or hasPermission(this.baselinePageDtoMapping.toDomain(returnObject.body),'ibizplm-BaselinePage-Get')")
    @GetMapping("baseline_pages/{id}")
    public ResponseEntity<BaselinePageDTO> getById
            (@PathVariable("id") String id) {
        BaselinePage rt = baselinePageService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(baselinePageDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 基线页面
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"基线页面" },  notes = "BaselinePage-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Remove-all') or hasPermission(this.baselinePageService.get(#id),'ibizplm-BaselinePage-Remove')")
    @DeleteMapping("baseline_pages/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = baselinePageService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"基线页面" },  notes = "BaselinePage-CheckKey ")
    @PostMapping("baseline_pages/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        Integer rt = baselinePageService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"基线页面" },  notes = "BaselinePage-GetDraft ")
    @GetMapping("baseline_pages/get_draft")
    public ResponseEntity<BaselinePageDTO> getDraft
            (@SpringQueryMap BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        BaselinePage rt = baselinePageService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(baselinePageDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<BaselinePageDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"基线页面" },  notes = "BaselinePage-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-fetch_default-all') or hasPermission(#dto,'ibizplm-BaselinePage-fetch_default')")
    @PostMapping("baseline_pages/fetch_default")
    public ResponseEntity<List<BaselinePageDTO>> fetchDefault
            (@Validated @RequestBody BaselinePageFilterDTO dto) {
        BaselinePageSearchContext context = baselinePageFilterDtoMapping.toDomain(dto);
        Page<BaselinePage> domains = baselinePageService.fetchDefault(context) ;
        List<BaselinePageDTO> list = baselinePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_fill_version_data 基线页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<BaselinePageDTO>>
    */
    @ApiOperation(value = "查询fetch_fill_version_data", tags = {"基线页面" },  notes = "BaselinePage-fetch_fill_version_data ")
    @PostMapping("baseline_pages/fetch_fill_version_data")
    public ResponseEntity<List<BaselinePageDTO>> fetchFillVersionData
            (@Validated @RequestBody BaselinePageFilterDTO dto) {
        BaselinePageSearchContext context = baselinePageFilterDtoMapping.toDomain(dto);
        Page<BaselinePage> domains = baselinePageService.fetchFillVersionData(context) ;
        List<BaselinePageDTO> list = baselinePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"基线页面" },  notes = "BaselinePage-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Get-all')  or hasPermission('library',#ownerId,this.baselinePageDtoMapping.toDomain(returnObject.body),'ibizplm-BaselinePage-Get')")
    @GetMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/{id}")
    public ResponseEntity<BaselinePageDTO> getByOwnerIdAndPrincipalIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        BaselinePage rt = baselinePageService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(baselinePageDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"基线页面" },  notes = "BaselinePage-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-Remove-all') or hasPermission('library',#ownerId,this.baselinePageService.get(#id),'ibizplm-BaselinePage-Remove')")
    @DeleteMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/{id}")
    public ResponseEntity<Boolean> removeByOwnerIdAndPrincipalIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = baselinePageService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"基线页面" },  notes = "BaselinePage-CheckKey ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/check_key")
    public ResponseEntity<Integer> checkKeyByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = baselinePageService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<BaselinePageDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"基线页面" },  notes = "BaselinePage-GetDraft ")
    @GetMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/get_draft")
    public ResponseEntity<BaselinePageDTO> getDraftByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @SpringQueryMap BaselinePageDTO dto) {
        BaselinePage domain = baselinePageDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        BaselinePage rt = baselinePageService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(baselinePageDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<BaselinePageDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"基线页面" },  notes = "BaselinePage-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselinePage-fetch_default-all') or hasPermission('library',#ownerId,#dto,'ibizplm-BaselinePage-fetch_default')")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/fetch_default")
    public ResponseEntity<List<BaselinePageDTO>> fetchDefaultByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody BaselinePageFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        BaselinePageSearchContext context = baselinePageFilterDtoMapping.toDomain(dto);
        Page<BaselinePage> domains = baselinePageService.fetchDefault(context) ;
        List<BaselinePageDTO> list = baselinePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_fill_version_data 基线页面
    * 
    *
    * @param ownerId ownerId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<BaselinePageDTO>>
    */
    @ApiOperation(value = "查询fetch_fill_version_data", tags = {"基线页面" },  notes = "BaselinePage-fetch_fill_version_data ")
    @PostMapping("libraries/{ownerId}/baselines/{principalId}/baseline_pages/fetch_fill_version_data")
    public ResponseEntity<List<BaselinePageDTO>> fetchFillVersionDataByOwnerIdAndPrincipalId
            (@PathVariable("ownerId") String ownerId, @PathVariable("principalId") String principalId, @Validated @RequestBody BaselinePageFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        BaselinePageSearchContext context = baselinePageFilterDtoMapping.toDomain(dto);
        Page<BaselinePage> domains = baselinePageService.fetchFillVersionData(context) ;
        List<BaselinePageDTO> list = baselinePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建基线页面
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselinePage-Create-all')")
    @ApiOperation(value = "批量新建基线页面", tags = {"基线页面" },  notes = "批量新建基线页面")
	@PostMapping("baseline_pages/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<BaselinePageDTO> dtos) {
        baselinePageService.create(baselinePageDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除基线页面
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselinePage-Remove-all')")
    @ApiOperation(value = "批量删除基线页面", tags = {"基线页面" },  notes = "批量删除基线页面")
	@DeleteMapping("baseline_pages/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        baselinePageService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新基线页面
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselinePage-Update-all')")
    @ApiOperation(value = "批量更新基线页面", tags = {"基线页面" },  notes = "批量更新基线页面")
	@PutMapping("baseline_pages/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<BaselinePageDTO> dtos) {
        baselinePageService.update(baselinePageDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存基线页面
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselinePage-Save-all')")
    @ApiOperation(value = "批量保存基线页面", tags = {"基线页面" },  notes = "批量保存基线页面")
	@PostMapping("baseline_pages/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<BaselinePageDTO> dtos) {
        baselinePageService.save(baselinePageDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入基线页面
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselinePage-Save-all')")
    @ApiOperation(value = "批量导入基线页面", tags = {"基线页面" },  notes = "批量导入基线页面")
	@PostMapping("baseline_pages/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<BaselinePageDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(baselinePageService.importData(config,ignoreError,baselinePageDtoMapping.toDomain(dtos)));
    }

}
