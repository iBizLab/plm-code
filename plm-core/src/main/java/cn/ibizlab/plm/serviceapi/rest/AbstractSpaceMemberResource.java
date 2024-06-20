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
import cn.ibizlab.plm.core.wiki.domain.SpaceMember;
import cn.ibizlab.plm.core.wiki.service.SpaceMemberService;
import cn.ibizlab.plm.core.wiki.filter.SpaceMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[SpaceMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSpaceMemberResource {

    @Autowired
    public SpaceMemberService spaceMemberService;

    @Autowired
    @Lazy
    public SpaceMemberDTOMapping spaceMemberDtoMapping;

    @Autowired
    @Lazy
    public SpaceMemberFilterDTOMapping spaceMemberFilterDtoMapping;

    /**
    * 创建Create 空间成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"空间成员" },  notes = "SpaceMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Create-all') or hasPermission(this.spaceMemberDtoMapping.toDomain(#dto),'ibizplm-SpaceMember-Create')")
    @PostMapping("space_members")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> create
            (@Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 空间成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO create
            (SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        spaceMemberService.create(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 空间成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"空间成员" },  notes = "SpaceMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Update-all') or hasPermission(this.spaceMemberService.get(#id),'ibizplm-SpaceMember-Update')")
    @VersionCheck(entity = "spacemember" , versionfield = "updateTime")
    @PutMapping("space_members/{id}")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 空间成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO updateById
            (String id, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        spaceMemberService.update(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 空间成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "change_role", tags = {"空间成员" },  notes = "SpaceMember-change_role ")
    @PostMapping("space_members/{id}/change_role")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> changeRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_role 空间成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO changeRoleById
            (String id, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        SpaceMember rt = spaceMemberService.changeRole(domain);
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 空间成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"空间成员" },  notes = "SpaceMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Save-all') or hasPermission(this.spaceMemberDtoMapping.toDomain(#dto),'ibizplm-SpaceMember-Save')")
    @PostMapping("space_members/save")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> save
            (@Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 空间成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO save
            (SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        spaceMemberService.save(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"空间成员" },  notes = "SpaceMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Create-all') or hasPermission('space',#spaceId,this.spaceMemberDtoMapping.toDomain(#dto),'ibizplm-SpaceMember-Create')")
    @PostMapping("spaces/{spaceId}/space_members")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> createBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySpaceId(spaceId, item)));
        else
            rt.set(createBySpaceId(spaceId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO createBySpaceId
            (String spaceId, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        spaceMemberService.create(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"空间成员" },  notes = "SpaceMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Update-all') or hasPermission('space',#spaceId,this.spaceMemberService.get(#id),'ibizplm-SpaceMember-Update')")
    @VersionCheck(entity = "spacemember" , versionfield = "updateTime")
    @PutMapping("spaces/{spaceId}/space_members/{id}")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> updateBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO updateBySpaceIdAndId
            (String spaceId, String id, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        spaceMemberService.update(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "change_role", tags = {"空间成员" },  notes = "SpaceMember-change_role ")
    @PostMapping("spaces/{spaceId}/space_members/{id}/change_role")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> changeRoleBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_role 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO changeRoleBySpaceIdAndId
            (String spaceId, String id, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        SpaceMember rt = spaceMemberService.changeRole(domain);
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"空间成员" },  notes = "SpaceMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Save-all') or hasPermission('space',#spaceId,this.spaceMemberDtoMapping.toDomain(#dto),'ibizplm-SpaceMember-Save')")
    @PostMapping("spaces/{spaceId}/space_members/save")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> saveBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySpaceId(spaceId, item)));
        else
            rt.set(saveBySpaceId(spaceId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO saveBySpaceId
            (String spaceId, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        spaceMemberService.save(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 空间成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"空间成员" },  notes = "SpaceMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Create-all') or hasPermission('user',#userId,this.spaceMemberDtoMapping.toDomain(#dto),'ibizplm-SpaceMember-Create')")
    @PostMapping("users/{userId}/space_members")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> createByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByUserId(userId, item)));
        else
            rt.set(createByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 空间成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO createByUserId
            (String userId, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        spaceMemberService.create(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 空间成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"空间成员" },  notes = "SpaceMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Update-all') or hasPermission('user',#userId,this.spaceMemberService.get(#id),'ibizplm-SpaceMember-Update')")
    @VersionCheck(entity = "spacemember" , versionfield = "updateTime")
    @PutMapping("users/{userId}/space_members/{id}")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> updateByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByUserIdAndId(userId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 空间成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO updateByUserIdAndId
            (String userId, String id, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        spaceMemberService.update(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 空间成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "change_role", tags = {"空间成员" },  notes = "SpaceMember-change_role ")
    @PostMapping("users/{userId}/space_members/{id}/change_role")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> changeRoleByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByUserIdAndId(userId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_role 空间成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO changeRoleByUserIdAndId
            (String userId, String id, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        SpaceMember rt = spaceMemberService.changeRole(domain);
        return spaceMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 空间成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"空间成员" },  notes = "SpaceMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Save-all') or hasPermission('user',#userId,this.spaceMemberDtoMapping.toDomain(#dto),'ibizplm-SpaceMember-Save')")
    @PostMapping("users/{userId}/space_members/save")
    public ResponseEntity<ResponseWrapper<SpaceMemberDTO>> saveByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<SpaceMemberDTO> dto) {
        ResponseWrapper<SpaceMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByUserId(userId, item)));
        else
            rt.set(saveByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 空间成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */   
    public SpaceMemberDTO saveByUserId
            (String userId, SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        spaceMemberService.save(domain);
        SpaceMember rt = domain;
        return spaceMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 空间成员
    * 
    *
    * @param id id
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"空间成员" },  notes = "SpaceMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Get-all')  or hasPermission(this.spaceMemberDtoMapping.toDomain(returnObject.body),'ibizplm-SpaceMember-Get')")
    @GetMapping("space_members/{id}")
    public ResponseEntity<SpaceMemberDTO> getById
            (@PathVariable("id") String id) {
        SpaceMember rt = spaceMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(spaceMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 空间成员
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"空间成员" },  notes = "SpaceMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Remove-all') or hasPermission(this.spaceMemberService.get(#id),'ibizplm-SpaceMember-Remove')")
    @DeleteMapping("space_members/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = spaceMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 空间成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"空间成员" },  notes = "SpaceMember-CheckKey ")
    @PostMapping("space_members/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        Integer rt = spaceMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 空间成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"空间成员" },  notes = "SpaceMember-GetDraft ")
    @GetMapping("space_members/get_draft")
    public ResponseEntity<SpaceMemberDTO> getDraft
            (@SpringQueryMap SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        SpaceMember rt = spaceMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(spaceMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_cur_space 空间成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_cur_space", tags = {"空间成员" },  notes = "SpaceMember-fetch_cur_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-fetch_cur_space-all') or hasPermission(#dto,'ibizplm-SpaceMember-fetch_cur_space')")
    @PostMapping("space_members/fetch_cur_space")
    public ResponseEntity<List<SpaceMemberDTO>> fetchCurSpace
            (@Validated @RequestBody SpaceMemberFilterDTO dto) {
        SpaceMemberSearchContext context = spaceMemberFilterDtoMapping.toDomain(dto);
        Page<SpaceMember> domains = spaceMemberService.fetchCurSpace(context) ;
        List<SpaceMemberDTO> list = spaceMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 空间成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"空间成员" },  notes = "SpaceMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-fetch_default-all') or hasPermission(#dto,'ibizplm-SpaceMember-fetch_default')")
    @PostMapping("space_members/fetch_default")
    public ResponseEntity<List<SpaceMemberDTO>> fetchDefault
            (@Validated @RequestBody SpaceMemberFilterDTO dto) {
        SpaceMemberSearchContext context = spaceMemberFilterDtoMapping.toDomain(dto);
        Page<SpaceMember> domains = spaceMemberService.fetchDefault(context) ;
        List<SpaceMemberDTO> list = spaceMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"空间成员" },  notes = "SpaceMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Get-all')  or hasPermission('space',#spaceId,this.spaceMemberDtoMapping.toDomain(returnObject.body),'ibizplm-SpaceMember-Get')")
    @GetMapping("spaces/{spaceId}/space_members/{id}")
    public ResponseEntity<SpaceMemberDTO> getBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        SpaceMember rt = spaceMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(spaceMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"空间成员" },  notes = "SpaceMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Remove-all') or hasPermission('space',#spaceId,this.spaceMemberService.get(#id),'ibizplm-SpaceMember-Remove')")
    @DeleteMapping("spaces/{spaceId}/space_members/{id}")
    public ResponseEntity<Boolean> removeBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        Boolean rt = spaceMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"空间成员" },  notes = "SpaceMember-CheckKey ")
    @PostMapping("spaces/{spaceId}/space_members/check_key")
    public ResponseEntity<Integer> checkKeyBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        Integer rt = spaceMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"空间成员" },  notes = "SpaceMember-GetDraft ")
    @GetMapping("spaces/{spaceId}/space_members/get_draft")
    public ResponseEntity<SpaceMemberDTO> getDraftBySpaceId
            (@PathVariable("spaceId") String spaceId, @SpringQueryMap SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        SpaceMember rt = spaceMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(spaceMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_cur_space 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<SpaceMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_cur_space", tags = {"空间成员" },  notes = "SpaceMember-fetch_cur_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-fetch_cur_space-all') or hasPermission('space',#spaceId,#dto,'ibizplm-SpaceMember-fetch_cur_space')")
    @PostMapping("spaces/{spaceId}/space_members/fetch_cur_space")
    public ResponseEntity<List<SpaceMemberDTO>> fetchCurSpaceBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody SpaceMemberFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        SpaceMemberSearchContext context = spaceMemberFilterDtoMapping.toDomain(dto);
        Page<SpaceMember> domains = spaceMemberService.fetchCurSpace(context) ;
        List<SpaceMemberDTO> list = spaceMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 空间成员
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<SpaceMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"空间成员" },  notes = "SpaceMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-fetch_default-all') or hasPermission('space',#spaceId,#dto,'ibizplm-SpaceMember-fetch_default')")
    @PostMapping("spaces/{spaceId}/space_members/fetch_default")
    public ResponseEntity<List<SpaceMemberDTO>> fetchDefaultBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody SpaceMemberFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        SpaceMemberSearchContext context = spaceMemberFilterDtoMapping.toDomain(dto);
        Page<SpaceMember> domains = spaceMemberService.fetchDefault(context) ;
        List<SpaceMemberDTO> list = spaceMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 空间成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"空间成员" },  notes = "SpaceMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Get-all')  or hasPermission('user',#userId,this.spaceMemberDtoMapping.toDomain(returnObject.body),'ibizplm-SpaceMember-Get')")
    @GetMapping("users/{userId}/space_members/{id}")
    public ResponseEntity<SpaceMemberDTO> getByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        SpaceMember rt = spaceMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(spaceMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 空间成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"空间成员" },  notes = "SpaceMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-Remove-all') or hasPermission('user',#userId,this.spaceMemberService.get(#id),'ibizplm-SpaceMember-Remove')")
    @DeleteMapping("users/{userId}/space_members/{id}")
    public ResponseEntity<Boolean> removeByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = spaceMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 空间成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"空间成员" },  notes = "SpaceMember-CheckKey ")
    @PostMapping("users/{userId}/space_members/check_key")
    public ResponseEntity<Integer> checkKeyByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        Integer rt = spaceMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 空间成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<SpaceMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"空间成员" },  notes = "SpaceMember-GetDraft ")
    @GetMapping("users/{userId}/space_members/get_draft")
    public ResponseEntity<SpaceMemberDTO> getDraftByUserId
            (@PathVariable("userId") String userId, @SpringQueryMap SpaceMemberDTO dto) {
        SpaceMember domain = spaceMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        SpaceMember rt = spaceMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(spaceMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_cur_space 空间成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<SpaceMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_cur_space", tags = {"空间成员" },  notes = "SpaceMember-fetch_cur_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-fetch_cur_space-all') or hasPermission('user',#userId,#dto,'ibizplm-SpaceMember-fetch_cur_space')")
    @PostMapping("users/{userId}/space_members/fetch_cur_space")
    public ResponseEntity<List<SpaceMemberDTO>> fetchCurSpaceByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody SpaceMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        SpaceMemberSearchContext context = spaceMemberFilterDtoMapping.toDomain(dto);
        Page<SpaceMember> domains = spaceMemberService.fetchCurSpace(context) ;
        List<SpaceMemberDTO> list = spaceMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 空间成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<SpaceMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"空间成员" },  notes = "SpaceMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SpaceMember-fetch_default-all') or hasPermission('user',#userId,#dto,'ibizplm-SpaceMember-fetch_default')")
    @PostMapping("users/{userId}/space_members/fetch_default")
    public ResponseEntity<List<SpaceMemberDTO>> fetchDefaultByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody SpaceMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        SpaceMemberSearchContext context = spaceMemberFilterDtoMapping.toDomain(dto);
        Page<SpaceMember> domains = spaceMemberService.fetchDefault(context) ;
        List<SpaceMemberDTO> list = spaceMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建空间成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SpaceMember-Create-all')")
    @ApiOperation(value = "批量新建空间成员", tags = {"空间成员" },  notes = "批量新建空间成员")
	@PostMapping("space_members/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SpaceMemberDTO> dtos) {
        spaceMemberService.create(spaceMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除空间成员
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SpaceMember-Remove-all')")
    @ApiOperation(value = "批量删除空间成员", tags = {"空间成员" },  notes = "批量删除空间成员")
	@DeleteMapping("space_members/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        spaceMemberService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新空间成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SpaceMember-Update-all')")
    @ApiOperation(value = "批量更新空间成员", tags = {"空间成员" },  notes = "批量更新空间成员")
	@PutMapping("space_members/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SpaceMemberDTO> dtos) {
        spaceMemberService.update(spaceMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存空间成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SpaceMember-Save-all')")
    @ApiOperation(value = "批量保存空间成员", tags = {"空间成员" },  notes = "批量保存空间成员")
	@PostMapping("space_members/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SpaceMemberDTO> dtos) {
        spaceMemberService.save(spaceMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入空间成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SpaceMember-Save-all')")
    @ApiOperation(value = "批量导入空间成员", tags = {"空间成员" },  notes = "批量导入空间成员")
	@PostMapping("space_members/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SpaceMemberDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(spaceMemberService.importData(config,ignoreError,spaceMemberDtoMapping.toDomain(dtos)));
    }

}
