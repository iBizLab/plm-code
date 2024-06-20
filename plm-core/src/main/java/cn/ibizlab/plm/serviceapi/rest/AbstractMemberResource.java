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
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.service.MemberService;
import cn.ibizlab.plm.core.base.filter.MemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Member] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractMemberResource {

    @Autowired
    public MemberService memberService;

    @Autowired
    @Lazy
    public MemberDefGroupDTOMapping memberDefGroupDtoMapping;

    @Autowired
    @Lazy
    public MemberDTOMapping memberDtoMapping;

    @Autowired
    @Lazy
    public MemberFilterDTOMapping memberFilterDtoMapping;

    /**
    * 创建Create 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"成员" },  notes = "Member-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Create-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Create')")
    @PostMapping("members")
    public ResponseEntity<ResponseWrapper<MemberDTO>> create
            (@Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO create
            (MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        memberService.create(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"成员" },  notes = "Member-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Update-all') or hasPermission(this.memberService.get(#id),'ibizplm-Member-Update')")
    @VersionCheck(entity = "member" , versionfield = "updateTime")
    @PutMapping("members/{id}")
    public ResponseEntity<ResponseWrapper<MemberDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO updateById
            (String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        memberService.update(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }

    /**
    * change_role 成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "change_role", tags = {"成员" },  notes = "Member-change_role ")
    @PostMapping("members/{id}/change_role")
    public ResponseEntity<ResponseWrapper<MemberDTO>> changeRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_role 成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO changeRoleById
            (String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        Member rt = memberService.changeRole(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * create_member 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "create_member", tags = {"成员" },  notes = "Member-create_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-create_member-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-create_member')")
    @PostMapping("members/create_member")
    public ResponseEntity<ResponseWrapper<MemberDTO>> createMember
            (@Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createMember(item)));
        else
            rt.set(createMember(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * create_member 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO createMember
            (MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        Member rt = memberService.createMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"成员" },  notes = "Member-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Save-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Save')")
    @PostMapping("members/save")
    public ResponseEntity<ResponseWrapper<MemberDTO>> save
            (@Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO save
            (MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        memberService.save(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"成员" },  notes = "Member-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Create-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Create')")
    @PostMapping("groups/{ownerId}/members")
    public ResponseEntity<ResponseWrapper<MemberDTO>> createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO createByOwnerId
            (String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        memberService.create(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"成员" },  notes = "Member-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Update-all') or hasPermission('group',#ownerId,this.memberService.get(#id),'ibizplm-Member-Update')")
    @VersionCheck(entity = "member" , versionfield = "updateTime")
    @PutMapping("groups/{ownerId}/members/{id}")
    public ResponseEntity<ResponseWrapper<MemberDTO>> updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO updateByOwnerIdAndId
            (String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        memberService.update(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }

    /**
    * change_role 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "change_role", tags = {"成员" },  notes = "Member-change_role ")
    @PostMapping("groups/{ownerId}/members/{id}/change_role")
    public ResponseEntity<ResponseWrapper<MemberDTO>> changeRoleByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByOwnerIdAndId(ownerId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_role 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO changeRoleByOwnerIdAndId
            (String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        Member rt = memberService.changeRole(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * create_member 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "create_member", tags = {"成员" },  notes = "Member-create_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-create_member-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-create_member')")
    @PostMapping("groups/{ownerId}/members/create_member")
    public ResponseEntity<ResponseWrapper<MemberDTO>> createMemberByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createMemberByOwnerId(ownerId, item)));
        else
            rt.set(createMemberByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * create_member 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO createMemberByOwnerId
            (String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.createMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"成员" },  notes = "Member-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Save-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Save')")
    @PostMapping("groups/{ownerId}/members/save")
    public ResponseEntity<ResponseWrapper<MemberDTO>> saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO saveByOwnerId
            (String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        memberService.save(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 成员
    * 
    *
    * @param id id
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"成员" },  notes = "Member-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Get-all')  or hasPermission(this.memberDtoMapping.toDomain(returnObject.body),'ibizplm-Member-Get')")
    @GetMapping("members/{id}")
    public ResponseEntity<MemberDTO> getById
            (@PathVariable("id") String id) {
        Member rt = memberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 成员
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"成员" },  notes = "Member-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Remove-all') or hasPermission(this.memberService.get(#id),'ibizplm-Member-Remove')")
    @DeleteMapping("members/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = memberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"成员" },  notes = "Member-CheckKey ")
    @PostMapping("members/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        Integer rt = memberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"成员" },  notes = "Member-GetDraft ")
    @GetMapping("members/get_draft")
    public ResponseEntity<MemberDTO> getDraft
            (@SpringQueryMap MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        Member rt = memberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<MemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"成员" },  notes = "Member-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_default-all') or hasPermission(#dto,'ibizplm-Member-fetch_default')")
    @PostMapping("members/fetch_default")
    public ResponseEntity<List<MemberDTO>> fetchDefault
            (@Validated @RequestBody MemberFilterDTO dto) {
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchDefault(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_user_group_admin 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<MemberDefGroupDTO>>
    */
    @ApiOperation(value = "查询fetch_user_group_admin", tags = {"成员" },  notes = "Member-fetch_user_group_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_user_group_admin-all') or hasPermission(#dto,'ibizplm-Member-fetch_user_group_admin')")
    @PostMapping("members/fetch_user_group_admin")
    public ResponseEntity<List<MemberDefGroupDTO>> fetchUserGroupAdmin
            (@Validated @RequestBody MemberFilterDTO dto) {
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchUserGroupAdmin(context) ;
        List<MemberDefGroupDTO> list = memberDefGroupDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"成员" },  notes = "Member-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Get-all')  or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(returnObject.body),'ibizplm-Member-Get')")
    @GetMapping("groups/{ownerId}/members/{id}")
    public ResponseEntity<MemberDTO> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Member rt = memberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"成员" },  notes = "Member-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Remove-all') or hasPermission('group',#ownerId,this.memberService.get(#id),'ibizplm-Member-Remove')")
    @DeleteMapping("groups/{ownerId}/members/{id}")
    public ResponseEntity<Boolean> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = memberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"成员" },  notes = "Member-CheckKey ")
    @PostMapping("groups/{ownerId}/members/check_key")
    public ResponseEntity<Integer> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Integer rt = memberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"成员" },  notes = "Member-GetDraft ")
    @GetMapping("groups/{ownerId}/members/get_draft")
    public ResponseEntity<MemberDTO> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<List<MemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"成员" },  notes = "Member-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_default-all') or hasPermission('group',#ownerId,#dto,'ibizplm-Member-fetch_default')")
    @PostMapping("groups/{ownerId}/members/fetch_default")
    public ResponseEntity<List<MemberDTO>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchDefault(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_user_group_admin 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<List<MemberDefGroupDTO>>
    */
    @ApiOperation(value = "查询fetch_user_group_admin", tags = {"成员" },  notes = "Member-fetch_user_group_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_user_group_admin-all') or hasPermission('group',#ownerId,#dto,'ibizplm-Member-fetch_user_group_admin')")
    @PostMapping("groups/{ownerId}/members/fetch_user_group_admin")
    public ResponseEntity<List<MemberDefGroupDTO>> fetchUserGroupAdminByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchUserGroupAdmin(context) ;
        List<MemberDefGroupDTO> list = memberDefGroupDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Create-all')")
    @ApiOperation(value = "批量新建成员", tags = {"成员" },  notes = "批量新建成员")
	@PostMapping("members/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MemberDTO> dtos) {
        memberService.create(memberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除成员
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Remove-all')")
    @ApiOperation(value = "批量删除成员", tags = {"成员" },  notes = "批量删除成员")
	@DeleteMapping("members/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        memberService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Update-all')")
    @ApiOperation(value = "批量更新成员", tags = {"成员" },  notes = "批量更新成员")
	@PutMapping("members/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MemberDTO> dtos) {
        memberService.update(memberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Save-all')")
    @ApiOperation(value = "批量保存成员", tags = {"成员" },  notes = "批量保存成员")
	@PostMapping("members/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MemberDTO> dtos) {
        memberService.save(memberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Save-all')")
    @ApiOperation(value = "批量导入成员", tags = {"成员" },  notes = "批量导入成员")
	@PostMapping("members/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<MemberDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(memberService.importData(config,ignoreError,memberDtoMapping.toDomain(dtos)));
    }

}
