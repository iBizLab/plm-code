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
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.service.AddonService;
import cn.ibizlab.plm.core.base.filter.AddonSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Addon] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAddonResource {

    @Autowired
    public AddonService addonService;

    @Autowired
    @Lazy
    public AddonDTOMapping addonDtoMapping;

    @Autowired
    @Lazy
    public AddonFilterDTOMapping addonFilterDtoMapping;

    /**
    * 创建Create 组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"组件" },  notes = "Addon-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Create-all') or hasPermission(this.addonDtoMapping.toDomain(#dto),'ibizplm-Addon-Create')")
    @PostMapping("addons")
    public ResponseEntity<ResponseWrapper<AddonDTO>> create
            (@Validated @RequestBody RequestWrapper<AddonDTO> dto) {
        ResponseWrapper<AddonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */   
    public AddonDTO create
            (AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        addonService.create(domain);
        Addon rt = domain;
        return addonDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 组件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"组件" },  notes = "Addon-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Update-all') or hasPermission(this.addonService.get(#id),'ibizplm-Addon-Update')")
    @VersionCheck(entity = "addon" , versionfield = "updateTime")
    @PutMapping("addons/{id}")
    public ResponseEntity<ResponseWrapper<AddonDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonDTO> dto) {
        ResponseWrapper<AddonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 组件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */   
    public AddonDTO updateById
            (String id, AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        domain.setId(id);
        addonService.update(domain);
        Addon rt = domain;
        return addonDtoMapping.toDto(rt);
    }

    /**
    * addon_authority 组件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "addon_authority", tags = {"组件" },  notes = "Addon-addon_authority ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-addon_authority-all') or hasPermission(this.addonDtoMapping.toDomain(#dto),'ibizplm-Addon-addon_authority')")
    @PostMapping("addons/{id}/addon_authority")
    public ResponseEntity<ResponseWrapper<AddonDTO>> addonAuthorityById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonDTO> dto) {
        ResponseWrapper<AddonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addonAuthorityById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addonAuthorityById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * addon_authority 组件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */   
    public AddonDTO addonAuthorityById
            (String id, AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        domain.setId(id);
        Addon rt = addonService.addonAuthority(domain);
        return addonDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"组件" },  notes = "Addon-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Save-all') or hasPermission(this.addonDtoMapping.toDomain(#dto),'ibizplm-Addon-Save')")
    @PostMapping("addons/save")
    public ResponseEntity<ResponseWrapper<AddonDTO>> save
            (@Validated @RequestBody RequestWrapper<AddonDTO> dto) {
        ResponseWrapper<AddonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */   
    public AddonDTO save
            (AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        addonService.save(domain);
        Addon rt = domain;
        return addonDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"组件" },  notes = "Addon-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Create-all') or hasPermission('library',#ownerId,this.addonDtoMapping.toDomain(#dto),'ibizplm-Addon-Create')")
    @PostMapping("libraries/{ownerId}/addons")
    public ResponseEntity<ResponseWrapper<AddonDTO>> createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<AddonDTO> dto) {
        ResponseWrapper<AddonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */   
    public AddonDTO createByOwnerId
            (String ownerId, AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        addonService.create(domain);
        Addon rt = domain;
        return addonDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"组件" },  notes = "Addon-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Update-all') or hasPermission('library',#ownerId,this.addonService.get(#id),'ibizplm-Addon-Update')")
    @VersionCheck(entity = "addon" , versionfield = "updateTime")
    @PutMapping("libraries/{ownerId}/addons/{id}")
    public ResponseEntity<ResponseWrapper<AddonDTO>> updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonDTO> dto) {
        ResponseWrapper<AddonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */   
    public AddonDTO updateByOwnerIdAndId
            (String ownerId, String id, AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        domain.setId(id);
        addonService.update(domain);
        Addon rt = domain;
        return addonDtoMapping.toDto(rt);
    }

    /**
    * addon_authority 组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "addon_authority", tags = {"组件" },  notes = "Addon-addon_authority ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-addon_authority-all') or hasPermission('library',#ownerId,this.addonDtoMapping.toDomain(#dto),'ibizplm-Addon-addon_authority')")
    @PostMapping("libraries/{ownerId}/addons/{id}/addon_authority")
    public ResponseEntity<ResponseWrapper<AddonDTO>> addonAuthorityByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonDTO> dto) {
        ResponseWrapper<AddonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addonAuthorityByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addonAuthorityByOwnerIdAndId(ownerId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * addon_authority 组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */   
    public AddonDTO addonAuthorityByOwnerIdAndId
            (String ownerId, String id, AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        domain.setId(id);
        Addon rt = addonService.addonAuthority(domain);
        return addonDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"组件" },  notes = "Addon-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Save-all') or hasPermission('library',#ownerId,this.addonDtoMapping.toDomain(#dto),'ibizplm-Addon-Save')")
    @PostMapping("libraries/{ownerId}/addons/save")
    public ResponseEntity<ResponseWrapper<AddonDTO>> saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<AddonDTO> dto) {
        ResponseWrapper<AddonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */   
    public AddonDTO saveByOwnerId
            (String ownerId, AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        addonService.save(domain);
        Addon rt = domain;
        return addonDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 组件
    * 
    *
    * @param id id
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"组件" },  notes = "Addon-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Get-all')  or hasPermission(this.addonDtoMapping.toDomain(returnObject.body),'ibizplm-Addon-Get')")
    @GetMapping("addons/{id}")
    public ResponseEntity<AddonDTO> getById
            (@PathVariable("id") String id) {
        Addon rt = addonService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(addonDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 组件
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"组件" },  notes = "Addon-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Remove-all') or hasPermission(this.addonService.get(#id),'ibizplm-Addon-Remove')")
    @DeleteMapping("addons/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = addonService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"组件" },  notes = "Addon-CheckKey ")
    @PostMapping("addons/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        Integer rt = addonService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"组件" },  notes = "Addon-GetDraft ")
    @GetMapping("addons/get_draft")
    public ResponseEntity<AddonDTO> getDraft
            (@SpringQueryMap AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        Addon rt = addonService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(addonDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_cur_owner_sys 组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<AddonDTO>>
    */
    @ApiOperation(value = "查询fetch_cur_owner_sys", tags = {"组件" },  notes = "Addon-fetch_cur_owner_sys ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-fetch_cur_owner_sys-all') or hasPermission(#dto,'ibizplm-Addon-fetch_cur_owner_sys')")
    @PostMapping("addons/fetch_cur_owner_sys")
    public ResponseEntity<List<AddonDTO>> fetchCurOwnerSys
            (@Validated @RequestBody AddonFilterDTO dto) {
        AddonSearchContext context = addonFilterDtoMapping.toDomain(dto);
        Page<Addon> domains = addonService.fetchCurOwnerSys(context) ;
        List<AddonDTO> list = addonDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 组件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<AddonDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"组件" },  notes = "Addon-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-fetch_default-all') or hasPermission(#dto,'ibizplm-Addon-fetch_default')")
    @PostMapping("addons/fetch_default")
    public ResponseEntity<List<AddonDTO>> fetchDefault
            (@Validated @RequestBody AddonFilterDTO dto) {
        AddonSearchContext context = addonFilterDtoMapping.toDomain(dto);
        Page<Addon> domains = addonService.fetchDefault(context) ;
        List<AddonDTO> list = addonDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"组件" },  notes = "Addon-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Get-all')  or hasPermission('library',#ownerId,this.addonDtoMapping.toDomain(returnObject.body),'ibizplm-Addon-Get')")
    @GetMapping("libraries/{ownerId}/addons/{id}")
    public ResponseEntity<AddonDTO> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Addon rt = addonService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(addonDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 组件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"组件" },  notes = "Addon-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-Remove-all') or hasPermission('library',#ownerId,this.addonService.get(#id),'ibizplm-Addon-Remove')")
    @DeleteMapping("libraries/{ownerId}/addons/{id}")
    public ResponseEntity<Boolean> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = addonService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"组件" },  notes = "Addon-CheckKey ")
    @PostMapping("libraries/{ownerId}/addons/check_key")
    public ResponseEntity<Integer> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Integer rt = addonService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<AddonDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"组件" },  notes = "Addon-GetDraft ")
    @GetMapping("libraries/{ownerId}/addons/get_draft")
    public ResponseEntity<AddonDTO> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap AddonDTO dto) {
        Addon domain = addonDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Addon rt = addonService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(addonDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_cur_owner_sys 组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<List<AddonDTO>>
    */
    @ApiOperation(value = "查询fetch_cur_owner_sys", tags = {"组件" },  notes = "Addon-fetch_cur_owner_sys ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-fetch_cur_owner_sys-all') or hasPermission('library',#ownerId,#dto,'ibizplm-Addon-fetch_cur_owner_sys')")
    @PostMapping("libraries/{ownerId}/addons/fetch_cur_owner_sys")
    public ResponseEntity<List<AddonDTO>> fetchCurOwnerSysByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody AddonFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        AddonSearchContext context = addonFilterDtoMapping.toDomain(dto);
        Page<Addon> domains = addonService.fetchCurOwnerSys(context) ;
        List<AddonDTO> list = addonDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 组件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<List<AddonDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"组件" },  notes = "Addon-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Addon-fetch_default-all') or hasPermission('library',#ownerId,#dto,'ibizplm-Addon-fetch_default')")
    @PostMapping("libraries/{ownerId}/addons/fetch_default")
    public ResponseEntity<List<AddonDTO>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody AddonFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        AddonSearchContext context = addonFilterDtoMapping.toDomain(dto);
        Page<Addon> domains = addonService.fetchDefault(context) ;
        List<AddonDTO> list = addonDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建组件
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Addon-Create-all')")
    @ApiOperation(value = "批量新建组件", tags = {"组件" },  notes = "批量新建组件")
	@PostMapping("addons/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AddonDTO> dtos) {
        addonService.create(addonDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除组件
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Addon-Remove-all')")
    @ApiOperation(value = "批量删除组件", tags = {"组件" },  notes = "批量删除组件")
	@DeleteMapping("addons/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        addonService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新组件
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Addon-Update-all')")
    @ApiOperation(value = "批量更新组件", tags = {"组件" },  notes = "批量更新组件")
	@PutMapping("addons/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AddonDTO> dtos) {
        addonService.update(addonDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存组件
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Addon-Save-all')")
    @ApiOperation(value = "批量保存组件", tags = {"组件" },  notes = "批量保存组件")
	@PostMapping("addons/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AddonDTO> dtos) {
        addonService.save(addonDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入组件
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Addon-Save-all')")
    @ApiOperation(value = "批量导入组件", tags = {"组件" },  notes = "批量导入组件")
	@PostMapping("addons/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<AddonDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(addonService.importData(config,ignoreError,addonDtoMapping.toDomain(dtos)));
    }

}
