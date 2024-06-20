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
import cn.ibizlab.plm.core.team.domain.DiscussMember;
import cn.ibizlab.plm.core.team.service.DiscussMemberService;
import cn.ibizlab.plm.core.team.filter.DiscussMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[DiscussMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDiscussMemberResource {

    @Autowired
    public DiscussMemberService discussMemberService;

    @Autowired
    @Lazy
    public DiscussMemberDTOMapping discussMemberDtoMapping;

    @Autowired
    @Lazy
    public DiscussMemberFilterDTOMapping discussMemberFilterDtoMapping;

    /**
    * 创建Create 协作成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"协作成员" },  notes = "DiscussMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Create-all') or hasPermission(this.discussMemberDtoMapping.toDomain(#dto),'ibizplm-DiscussMember-Create')")
    @PostMapping("discuss_members")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> create
            (@Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 协作成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO create
            (DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        discussMemberService.create(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 协作成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"协作成员" },  notes = "DiscussMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Update-all') or hasPermission(this.discussMemberService.get(#id),'ibizplm-DiscussMember-Update')")
    @VersionCheck(entity = "discussmember" , versionfield = "updateTime")
    @PutMapping("discuss_members/{id}")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 协作成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO updateById
            (String id, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        discussMemberService.update(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 协作成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "change_role", tags = {"协作成员" },  notes = "DiscussMember-change_role ")
    @PostMapping("discuss_members/{id}/change_role")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> changeRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_role 协作成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO changeRoleById
            (String id, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussMember rt = discussMemberService.changeRole(domain);
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 协作成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"协作成员" },  notes = "DiscussMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Save-all') or hasPermission(this.discussMemberDtoMapping.toDomain(#dto),'ibizplm-DiscussMember-Save')")
    @PostMapping("discuss_members/save")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> save
            (@Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 协作成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO save
            (DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        discussMemberService.save(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"协作成员" },  notes = "DiscussMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Create-all') or hasPermission('discuss_topic',#ownerId,this.discussMemberDtoMapping.toDomain(#dto),'ibizplm-DiscussMember-Create')")
    @PostMapping("discuss_topics/{ownerId}/discuss_members")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO createByOwnerId
            (String ownerId, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        discussMemberService.create(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"协作成员" },  notes = "DiscussMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Update-all') or hasPermission('discuss_topic',#ownerId,this.discussMemberService.get(#id),'ibizplm-DiscussMember-Update')")
    @VersionCheck(entity = "discussmember" , versionfield = "updateTime")
    @PutMapping("discuss_topics/{ownerId}/discuss_members/{id}")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO updateByOwnerIdAndId
            (String ownerId, String id, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        discussMemberService.update(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "change_role", tags = {"协作成员" },  notes = "DiscussMember-change_role ")
    @PostMapping("discuss_topics/{ownerId}/discuss_members/{id}/change_role")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> changeRoleByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByOwnerIdAndId(ownerId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_role 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO changeRoleByOwnerIdAndId
            (String ownerId, String id, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussMember rt = discussMemberService.changeRole(domain);
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"协作成员" },  notes = "DiscussMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Save-all') or hasPermission('discuss_topic',#ownerId,this.discussMemberDtoMapping.toDomain(#dto),'ibizplm-DiscussMember-Save')")
    @PostMapping("discuss_topics/{ownerId}/discuss_members/save")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO saveByOwnerId
            (String ownerId, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        discussMemberService.save(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 协作成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"协作成员" },  notes = "DiscussMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Create-all') or hasPermission('user',#userId,this.discussMemberDtoMapping.toDomain(#dto),'ibizplm-DiscussMember-Create')")
    @PostMapping("users/{userId}/discuss_members")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> createByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByUserId(userId, item)));
        else
            rt.set(createByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 协作成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO createByUserId
            (String userId, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        discussMemberService.create(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 协作成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"协作成员" },  notes = "DiscussMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Update-all') or hasPermission('user',#userId,this.discussMemberService.get(#id),'ibizplm-DiscussMember-Update')")
    @VersionCheck(entity = "discussmember" , versionfield = "updateTime")
    @PutMapping("users/{userId}/discuss_members/{id}")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> updateByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByUserIdAndId(userId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 协作成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO updateByUserIdAndId
            (String userId, String id, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        discussMemberService.update(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 协作成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "change_role", tags = {"协作成员" },  notes = "DiscussMember-change_role ")
    @PostMapping("users/{userId}/discuss_members/{id}/change_role")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> changeRoleByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByUserIdAndId(userId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_role 协作成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO changeRoleByUserIdAndId
            (String userId, String id, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussMember rt = discussMemberService.changeRole(domain);
        return discussMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 协作成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"协作成员" },  notes = "DiscussMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Save-all') or hasPermission('user',#userId,this.discussMemberDtoMapping.toDomain(#dto),'ibizplm-DiscussMember-Save')")
    @PostMapping("users/{userId}/discuss_members/save")
    public ResponseEntity<ResponseWrapper<DiscussMemberDTO>> saveByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<DiscussMemberDTO> dto) {
        ResponseWrapper<DiscussMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByUserId(userId, item)));
        else
            rt.set(saveByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 协作成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */   
    public DiscussMemberDTO saveByUserId
            (String userId, DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        discussMemberService.save(domain);
        DiscussMember rt = domain;
        return discussMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 协作成员
    * 
    *
    * @param id id
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"协作成员" },  notes = "DiscussMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Get-all')  or hasPermission(this.discussMemberDtoMapping.toDomain(returnObject.body),'ibizplm-DiscussMember-Get')")
    @GetMapping("discuss_members/{id}")
    public ResponseEntity<DiscussMemberDTO> getById
            (@PathVariable("id") String id) {
        DiscussMember rt = discussMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(discussMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 协作成员
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"协作成员" },  notes = "DiscussMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Remove-all') or hasPermission(this.discussMemberService.get(#id),'ibizplm-DiscussMember-Remove')")
    @DeleteMapping("discuss_members/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = discussMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 协作成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"协作成员" },  notes = "DiscussMember-CheckKey ")
    @PostMapping("discuss_members/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        Integer rt = discussMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 协作成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"协作成员" },  notes = "DiscussMember-GetDraft ")
    @GetMapping("discuss_members/get_draft")
    public ResponseEntity<DiscussMemberDTO> getDraft
            (@SpringQueryMap DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        DiscussMember rt = discussMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(discussMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 协作成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DiscussMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"协作成员" },  notes = "DiscussMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-fetch_default-all') or hasPermission(#dto,'ibizplm-DiscussMember-fetch_default')")
    @PostMapping("discuss_members/fetch_default")
    public ResponseEntity<List<DiscussMemberDTO>> fetchDefault
            (@Validated @RequestBody DiscussMemberFilterDTO dto) {
        DiscussMemberSearchContext context = discussMemberFilterDtoMapping.toDomain(dto);
        Page<DiscussMember> domains = discussMemberService.fetchDefault(context) ;
        List<DiscussMemberDTO> list = discussMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"协作成员" },  notes = "DiscussMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Get-all')  or hasPermission('discuss_topic',#ownerId,this.discussMemberDtoMapping.toDomain(returnObject.body),'ibizplm-DiscussMember-Get')")
    @GetMapping("discuss_topics/{ownerId}/discuss_members/{id}")
    public ResponseEntity<DiscussMemberDTO> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        DiscussMember rt = discussMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(discussMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"协作成员" },  notes = "DiscussMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Remove-all') or hasPermission('discuss_topic',#ownerId,this.discussMemberService.get(#id),'ibizplm-DiscussMember-Remove')")
    @DeleteMapping("discuss_topics/{ownerId}/discuss_members/{id}")
    public ResponseEntity<Boolean> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = discussMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"协作成员" },  notes = "DiscussMember-CheckKey ")
    @PostMapping("discuss_topics/{ownerId}/discuss_members/check_key")
    public ResponseEntity<Integer> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Integer rt = discussMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"协作成员" },  notes = "DiscussMember-GetDraft ")
    @GetMapping("discuss_topics/{ownerId}/discuss_members/get_draft")
    public ResponseEntity<DiscussMemberDTO> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        DiscussMember rt = discussMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(discussMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 协作成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<List<DiscussMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"协作成员" },  notes = "DiscussMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-fetch_default-all') or hasPermission('discuss_topic',#ownerId,#dto,'ibizplm-DiscussMember-fetch_default')")
    @PostMapping("discuss_topics/{ownerId}/discuss_members/fetch_default")
    public ResponseEntity<List<DiscussMemberDTO>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody DiscussMemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        DiscussMemberSearchContext context = discussMemberFilterDtoMapping.toDomain(dto);
        Page<DiscussMember> domains = discussMemberService.fetchDefault(context) ;
        List<DiscussMemberDTO> list = discussMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 协作成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"协作成员" },  notes = "DiscussMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Get-all')  or hasPermission('user',#userId,this.discussMemberDtoMapping.toDomain(returnObject.body),'ibizplm-DiscussMember-Get')")
    @GetMapping("users/{userId}/discuss_members/{id}")
    public ResponseEntity<DiscussMemberDTO> getByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        DiscussMember rt = discussMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(discussMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 协作成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"协作成员" },  notes = "DiscussMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-Remove-all') or hasPermission('user',#userId,this.discussMemberService.get(#id),'ibizplm-DiscussMember-Remove')")
    @DeleteMapping("users/{userId}/discuss_members/{id}")
    public ResponseEntity<Boolean> removeByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = discussMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 协作成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"协作成员" },  notes = "DiscussMember-CheckKey ")
    @PostMapping("users/{userId}/discuss_members/check_key")
    public ResponseEntity<Integer> checkKeyByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        Integer rt = discussMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 协作成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<DiscussMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"协作成员" },  notes = "DiscussMember-GetDraft ")
    @GetMapping("users/{userId}/discuss_members/get_draft")
    public ResponseEntity<DiscussMemberDTO> getDraftByUserId
            (@PathVariable("userId") String userId, @SpringQueryMap DiscussMemberDTO dto) {
        DiscussMember domain = discussMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        DiscussMember rt = discussMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(discussMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 协作成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<DiscussMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"协作成员" },  notes = "DiscussMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussMember-fetch_default-all') or hasPermission('user',#userId,#dto,'ibizplm-DiscussMember-fetch_default')")
    @PostMapping("users/{userId}/discuss_members/fetch_default")
    public ResponseEntity<List<DiscussMemberDTO>> fetchDefaultByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody DiscussMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        DiscussMemberSearchContext context = discussMemberFilterDtoMapping.toDomain(dto);
        Page<DiscussMember> domains = discussMemberService.fetchDefault(context) ;
        List<DiscussMemberDTO> list = discussMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建协作成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussMember-Create-all')")
    @ApiOperation(value = "批量新建协作成员", tags = {"协作成员" },  notes = "批量新建协作成员")
	@PostMapping("discuss_members/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DiscussMemberDTO> dtos) {
        discussMemberService.create(discussMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除协作成员
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussMember-Remove-all')")
    @ApiOperation(value = "批量删除协作成员", tags = {"协作成员" },  notes = "批量删除协作成员")
	@DeleteMapping("discuss_members/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        discussMemberService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新协作成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussMember-Update-all')")
    @ApiOperation(value = "批量更新协作成员", tags = {"协作成员" },  notes = "批量更新协作成员")
	@PutMapping("discuss_members/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DiscussMemberDTO> dtos) {
        discussMemberService.update(discussMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存协作成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussMember-Save-all')")
    @ApiOperation(value = "批量保存协作成员", tags = {"协作成员" },  notes = "批量保存协作成员")
	@PostMapping("discuss_members/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DiscussMemberDTO> dtos) {
        discussMemberService.save(discussMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入协作成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussMember-Save-all')")
    @ApiOperation(value = "批量导入协作成员", tags = {"协作成员" },  notes = "批量导入协作成员")
	@PostMapping("discuss_members/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DiscussMemberDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(discussMemberService.importData(config,ignoreError,discussMemberDtoMapping.toDomain(dtos)));
    }

}
