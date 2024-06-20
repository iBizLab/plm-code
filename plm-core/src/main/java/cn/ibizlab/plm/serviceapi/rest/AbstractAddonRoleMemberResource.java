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
import cn.ibizlab.plm.core.base.domain.AddonRoleMember;
import cn.ibizlab.plm.core.base.service.AddonRoleMemberService;
import cn.ibizlab.plm.core.base.filter.AddonRoleMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[AddonRoleMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAddonRoleMemberResource {

    @Autowired
    public AddonRoleMemberService addonRoleMemberService;

    @Autowired
    @Lazy
    public AddonRoleMemberDTOMapping addonRoleMemberDtoMapping;

    @Autowired
    @Lazy
    public AddonRoleMemberFilterDTOMapping addonRoleMemberFilterDtoMapping;

    /**
    * 创建Create 组件权限成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"组件权限成员" },  notes = "AddonRoleMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Create-all') or hasPermission(this.addonRoleMemberDtoMapping.toDomain(#dto),'ibizplm-AddonRoleMember-Create')")
    @PostMapping("addon_role_members")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> create
            (@Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 组件权限成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO create
            (AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        addonRoleMemberService.create(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 组件权限成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"组件权限成员" },  notes = "AddonRoleMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Update-all') or hasPermission(this.addonRoleMemberService.get(#id),'ibizplm-AddonRoleMember-Update')")
    @VersionCheck(entity = "addonrolemember" , versionfield = "updateTime")
    @PutMapping("addon_role_members/{id}")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 组件权限成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO updateById
            (String id, AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        addonRoleMemberService.update(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 组件权限成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"组件权限成员" },  notes = "AddonRoleMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Save-all') or hasPermission(this.addonRoleMemberDtoMapping.toDomain(#dto),'ibizplm-AddonRoleMember-Save')")
    @PostMapping("addon_role_members/save")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> save
            (@Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 组件权限成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO save
            (AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        addonRoleMemberService.save(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"组件权限成员" },  notes = "AddonRoleMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Create-all') or hasPermission('addon',#addonId,this.addonRoleMemberDtoMapping.toDomain(#dto),'ibizplm-AddonRoleMember-Create')")
    @PostMapping("addons/{addonId}/addon_role_members")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> createByAddonId
            (@PathVariable("addonId") String addonId, @Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByAddonId(addonId, item)));
        else
            rt.set(createByAddonId(addonId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO createByAddonId
            (String addonId, AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setAddonId(addonId);
        addonRoleMemberService.create(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"组件权限成员" },  notes = "AddonRoleMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Update-all') or hasPermission('addon',#addonId,this.addonRoleMemberService.get(#id),'ibizplm-AddonRoleMember-Update')")
    @VersionCheck(entity = "addonrolemember" , versionfield = "updateTime")
    @PutMapping("addons/{addonId}/addon_role_members/{id}")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> updateByAddonIdAndId
            (@PathVariable("addonId") String addonId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByAddonIdAndId(addonId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByAddonIdAndId(addonId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO updateByAddonIdAndId
            (String addonId, String id, AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        addonRoleMemberService.update(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"组件权限成员" },  notes = "AddonRoleMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Save-all') or hasPermission('addon',#addonId,this.addonRoleMemberDtoMapping.toDomain(#dto),'ibizplm-AddonRoleMember-Save')")
    @PostMapping("addons/{addonId}/addon_role_members/save")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> saveByAddonId
            (@PathVariable("addonId") String addonId, @Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByAddonId(addonId, item)));
        else
            rt.set(saveByAddonId(addonId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO saveByAddonId
            (String addonId, AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setAddonId(addonId);
        addonRoleMemberService.save(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"组件权限成员" },  notes = "AddonRoleMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Create-all') or hasPermission('library',#ownerId,this.addonRoleMemberDtoMapping.toDomain(#dto),'ibizplm-AddonRoleMember-Create')")
    @PostMapping("libraries/{ownerId}/addons/{addonId}/addon_role_members")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> createByOwnerIdAndAddonId
            (@PathVariable("ownerId") String ownerId, @PathVariable("addonId") String addonId, @Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerIdAndAddonId(ownerId, addonId, item)));
        else
            rt.set(createByOwnerIdAndAddonId(ownerId, addonId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO createByOwnerIdAndAddonId
            (String ownerId, String addonId, AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setAddonId(addonId);
        addonRoleMemberService.create(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"组件权限成员" },  notes = "AddonRoleMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Update-all') or hasPermission('library',#ownerId,this.addonRoleMemberService.get(#id),'ibizplm-AddonRoleMember-Update')")
    @VersionCheck(entity = "addonrolemember" , versionfield = "updateTime")
    @PutMapping("libraries/{ownerId}/addons/{addonId}/addon_role_members/{id}")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> updateByOwnerIdAndAddonIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("addonId") String addonId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndAddonIdAndId(ownerId, addonId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndAddonIdAndId(ownerId, addonId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO updateByOwnerIdAndAddonIdAndId
            (String ownerId, String addonId, String id, AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        addonRoleMemberService.update(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"组件权限成员" },  notes = "AddonRoleMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Save-all') or hasPermission('library',#ownerId,this.addonRoleMemberDtoMapping.toDomain(#dto),'ibizplm-AddonRoleMember-Save')")
    @PostMapping("libraries/{ownerId}/addons/{addonId}/addon_role_members/save")
    public ResponseEntity<ResponseWrapper<AddonRoleMemberDTO>> saveByOwnerIdAndAddonId
            (@PathVariable("ownerId") String ownerId, @PathVariable("addonId") String addonId, @Validated @RequestBody RequestWrapper<AddonRoleMemberDTO> dto) {
        ResponseWrapper<AddonRoleMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerIdAndAddonId(ownerId, addonId, item)));
        else
            rt.set(saveByOwnerIdAndAddonId(ownerId, addonId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */   
    public AddonRoleMemberDTO saveByOwnerIdAndAddonId
            (String ownerId, String addonId, AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setAddonId(addonId);
        addonRoleMemberService.save(domain);
        AddonRoleMember rt = domain;
        return addonRoleMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 组件权限成员
    * 
    *
    * @param id id
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"组件权限成员" },  notes = "AddonRoleMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Get-all')  or hasPermission(this.addonRoleMemberDtoMapping.toDomain(returnObject.body),'ibizplm-AddonRoleMember-Get')")
    @GetMapping("addon_role_members/{id}")
    public ResponseEntity<AddonRoleMemberDTO> getById
            (@PathVariable("id") String id) {
        AddonRoleMember rt = addonRoleMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(addonRoleMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 组件权限成员
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"组件权限成员" },  notes = "AddonRoleMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Remove-all') or hasPermission(this.addonRoleMemberService.get(#id),'ibizplm-AddonRoleMember-Remove')")
    @DeleteMapping("addon_role_members/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = addonRoleMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 组件权限成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"组件权限成员" },  notes = "AddonRoleMember-CheckKey ")
    @PostMapping("addon_role_members/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        Integer rt = addonRoleMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 组件权限成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"组件权限成员" },  notes = "AddonRoleMember-GetDraft ")
    @GetMapping("addon_role_members/get_draft")
    public ResponseEntity<AddonRoleMemberDTO> getDraft
            (@SpringQueryMap AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        AddonRoleMember rt = addonRoleMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(addonRoleMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 组件权限成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<AddonRoleMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"组件权限成员" },  notes = "AddonRoleMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-fetch_default-all') or hasPermission(#dto,'ibizplm-AddonRoleMember-fetch_default')")
    @PostMapping("addon_role_members/fetch_default")
    public ResponseEntity<List<AddonRoleMemberDTO>> fetchDefault
            (@Validated @RequestBody AddonRoleMemberFilterDTO dto) {
        AddonRoleMemberSearchContext context = addonRoleMemberFilterDtoMapping.toDomain(dto);
        Page<AddonRoleMember> domains = addonRoleMemberService.fetchDefault(context) ;
        List<AddonRoleMemberDTO> list = addonRoleMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param id id
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"组件权限成员" },  notes = "AddonRoleMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Get-all')  or hasPermission('addon',#addonId,this.addonRoleMemberDtoMapping.toDomain(returnObject.body),'ibizplm-AddonRoleMember-Get')")
    @GetMapping("addons/{addonId}/addon_role_members/{id}")
    public ResponseEntity<AddonRoleMemberDTO> getByAddonIdAndId
            (@PathVariable("addonId") String addonId, @PathVariable("id") String id) {
        AddonRoleMember rt = addonRoleMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(addonRoleMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"组件权限成员" },  notes = "AddonRoleMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Remove-all') or hasPermission('addon',#addonId,this.addonRoleMemberService.get(#id),'ibizplm-AddonRoleMember-Remove')")
    @DeleteMapping("addons/{addonId}/addon_role_members/{id}")
    public ResponseEntity<Boolean> removeByAddonIdAndId
            (@PathVariable("addonId") String addonId, @PathVariable("id") String id) {
        Boolean rt = addonRoleMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"组件权限成员" },  notes = "AddonRoleMember-CheckKey ")
    @PostMapping("addons/{addonId}/addon_role_members/check_key")
    public ResponseEntity<Integer> checkKeyByAddonId
            (@PathVariable("addonId") String addonId, @Validated @RequestBody AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setAddonId(addonId);
        Integer rt = addonRoleMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"组件权限成员" },  notes = "AddonRoleMember-GetDraft ")
    @GetMapping("addons/{addonId}/addon_role_members/get_draft")
    public ResponseEntity<AddonRoleMemberDTO> getDraftByAddonId
            (@PathVariable("addonId") String addonId, @SpringQueryMap AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setAddonId(addonId);
        AddonRoleMember rt = addonRoleMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(addonRoleMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 组件权限成员
    * 
    *
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<List<AddonRoleMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"组件权限成员" },  notes = "AddonRoleMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-fetch_default-all') or hasPermission('addon',#addonId,#dto,'ibizplm-AddonRoleMember-fetch_default')")
    @PostMapping("addons/{addonId}/addon_role_members/fetch_default")
    public ResponseEntity<List<AddonRoleMemberDTO>> fetchDefaultByAddonId
            (@PathVariable("addonId") String addonId, @Validated @RequestBody AddonRoleMemberFilterDTO dto) {
        dto.setAddonIdEQ(addonId);
        AddonRoleMemberSearchContext context = addonRoleMemberFilterDtoMapping.toDomain(dto);
        Page<AddonRoleMember> domains = addonRoleMemberService.fetchDefault(context) ;
        List<AddonRoleMemberDTO> list = addonRoleMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param id id
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"组件权限成员" },  notes = "AddonRoleMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Get-all')  or hasPermission('library',#ownerId,this.addonRoleMemberDtoMapping.toDomain(returnObject.body),'ibizplm-AddonRoleMember-Get')")
    @GetMapping("libraries/{ownerId}/addons/{addonId}/addon_role_members/{id}")
    public ResponseEntity<AddonRoleMemberDTO> getByOwnerIdAndAddonIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("addonId") String addonId, @PathVariable("id") String id) {
        AddonRoleMember rt = addonRoleMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(addonRoleMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"组件权限成员" },  notes = "AddonRoleMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-Remove-all') or hasPermission('library',#ownerId,this.addonRoleMemberService.get(#id),'ibizplm-AddonRoleMember-Remove')")
    @DeleteMapping("libraries/{ownerId}/addons/{addonId}/addon_role_members/{id}")
    public ResponseEntity<Boolean> removeByOwnerIdAndAddonIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("addonId") String addonId, @PathVariable("id") String id) {
        Boolean rt = addonRoleMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"组件权限成员" },  notes = "AddonRoleMember-CheckKey ")
    @PostMapping("libraries/{ownerId}/addons/{addonId}/addon_role_members/check_key")
    public ResponseEntity<Integer> checkKeyByOwnerIdAndAddonId
            (@PathVariable("ownerId") String ownerId, @PathVariable("addonId") String addonId, @Validated @RequestBody AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setAddonId(addonId);
        Integer rt = addonRoleMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<AddonRoleMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"组件权限成员" },  notes = "AddonRoleMember-GetDraft ")
    @GetMapping("libraries/{ownerId}/addons/{addonId}/addon_role_members/get_draft")
    public ResponseEntity<AddonRoleMemberDTO> getDraftByOwnerIdAndAddonId
            (@PathVariable("ownerId") String ownerId, @PathVariable("addonId") String addonId, @SpringQueryMap AddonRoleMemberDTO dto) {
        AddonRoleMember domain = addonRoleMemberDtoMapping.toDomain(dto);
        domain.setAddonId(addonId);
        AddonRoleMember rt = addonRoleMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(addonRoleMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 组件权限成员
    * 
    *
    * @param ownerId ownerId
    * @param addonId addonId
    * @param dto dto
    * @return ResponseEntity<List<AddonRoleMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"组件权限成员" },  notes = "AddonRoleMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AddonRoleMember-fetch_default-all') or hasPermission('library',#ownerId,#dto,'ibizplm-AddonRoleMember-fetch_default')")
    @PostMapping("libraries/{ownerId}/addons/{addonId}/addon_role_members/fetch_default")
    public ResponseEntity<List<AddonRoleMemberDTO>> fetchDefaultByOwnerIdAndAddonId
            (@PathVariable("ownerId") String ownerId, @PathVariable("addonId") String addonId, @Validated @RequestBody AddonRoleMemberFilterDTO dto) {
        dto.setAddonIdEQ(addonId);
        AddonRoleMemberSearchContext context = addonRoleMemberFilterDtoMapping.toDomain(dto);
        Page<AddonRoleMember> domains = addonRoleMemberService.fetchDefault(context) ;
        List<AddonRoleMemberDTO> list = addonRoleMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建组件权限成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonRoleMember-Create-all')")
    @ApiOperation(value = "批量新建组件权限成员", tags = {"组件权限成员" },  notes = "批量新建组件权限成员")
	@PostMapping("addon_role_members/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AddonRoleMemberDTO> dtos) {
        addonRoleMemberService.create(addonRoleMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除组件权限成员
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonRoleMember-Remove-all')")
    @ApiOperation(value = "批量删除组件权限成员", tags = {"组件权限成员" },  notes = "批量删除组件权限成员")
	@DeleteMapping("addon_role_members/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        addonRoleMemberService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新组件权限成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonRoleMember-Update-all')")
    @ApiOperation(value = "批量更新组件权限成员", tags = {"组件权限成员" },  notes = "批量更新组件权限成员")
	@PutMapping("addon_role_members/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AddonRoleMemberDTO> dtos) {
        addonRoleMemberService.update(addonRoleMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存组件权限成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonRoleMember-Save-all')")
    @ApiOperation(value = "批量保存组件权限成员", tags = {"组件权限成员" },  notes = "批量保存组件权限成员")
	@PostMapping("addon_role_members/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AddonRoleMemberDTO> dtos) {
        addonRoleMemberService.save(addonRoleMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入组件权限成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AddonRoleMember-Save-all')")
    @ApiOperation(value = "批量导入组件权限成员", tags = {"组件权限成员" },  notes = "批量导入组件权限成员")
	@PostMapping("addon_role_members/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<AddonRoleMemberDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(addonRoleMemberService.importData(config,ignoreError,addonRoleMemberDtoMapping.toDomain(dtos)));
    }

}
