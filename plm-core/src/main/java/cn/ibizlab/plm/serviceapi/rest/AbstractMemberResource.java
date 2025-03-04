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
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.service.MemberService;
import cn.ibizlab.plm.core.base.filter.MemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

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
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"成员" },  notes = "Member-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Create-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Create')")
    @PostMapping("members")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>create
            (@Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"成员" },  notes = "Member-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Update-all') or hasPermission(this.memberService.get(#id),'ibizplm-Member-Update')")
    @VersionCheck(entity = "member" , versionfield = "updateTime")
    @PutMapping("members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * add_member_position 成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "add_member_position", tags = {"成员" },  notes = "Member-add_member_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-add_member_position-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-add_member_position')")
    @PostMapping("members/{id}/add_member_position")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>addMemberPositionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addMemberPositionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addMemberPositionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_member_position 成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO addMemberPositionById
            (String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        Member rt = memberService.addMemberPosition(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * add_shared_page_member 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "add_shared_page_member", tags = {"成员" },  notes = "Member-add_shared_page_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-add_shared_page_member-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-add_shared_page_member')")
    @PostMapping("members/add_shared_page_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>addSharedPageMember
            (@Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addSharedPageMember(item)));
        else
            rt.set(addSharedPageMember(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_shared_page_member 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO addSharedPageMember
            (MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        Member rt = memberService.addSharedPageMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * change_role 成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"成员" },  notes = "Member-change_role ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-change_role-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-change_role')")
    @PostMapping("members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>changeRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "create_member", tags = {"成员" },  notes = "Member-create_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-create_member-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-create_member')")
    @PostMapping("members/create_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>createMember
            (@Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createMember(item)));
        else
            rt.set(createMember(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * mob_add_shared_member 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "mob_add_shared_member", tags = {"成员" },  notes = "Member-mob_add_shared_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-mob_add_shared_member-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-mob_add_shared_member')")
    @PostMapping("members/mob_add_shared_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>mobAddSharedMember
            (@Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mobAddSharedMember(item)));
        else
            rt.set(mobAddSharedMember(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_add_shared_member 成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO mobAddSharedMember
            (MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        Member rt = memberService.mobAddSharedMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"成员" },  notes = "Member-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Save-all') or hasPermission(this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Save')")
    @PostMapping("members/save")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>save
            (@Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"成员" },  notes = "Member-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Create-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Create')")
    @PostMapping("groups/{ownerId}/members")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"成员" },  notes = "Member-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Update-all') or hasPermission('group',#ownerId,this.memberService.get(#id),'ibizplm-Member-Update')")
    @VersionCheck(entity = "member" , versionfield = "updateTime")
    @PutMapping("groups/{ownerId}/members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * add_member_position 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "add_member_position", tags = {"成员" },  notes = "Member-add_member_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-add_member_position-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-add_member_position')")
    @PostMapping("groups/{ownerId}/members/{id}/add_member_position")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>addMemberPositionByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addMemberPositionByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addMemberPositionByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_member_position 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO addMemberPositionByOwnerIdAndId
            (String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        Member rt = memberService.addMemberPosition(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * add_shared_page_member 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "add_shared_page_member", tags = {"成员" },  notes = "Member-add_shared_page_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-add_shared_page_member-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-add_shared_page_member')")
    @PostMapping("groups/{ownerId}/members/add_shared_page_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>addSharedPageMemberByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addSharedPageMemberByOwnerId(ownerId, item)));
        else
            rt.set(addSharedPageMemberByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_shared_page_member 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO addSharedPageMemberByOwnerId
            (String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.addSharedPageMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * change_role 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"成员" },  notes = "Member-change_role ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-change_role-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-change_role')")
    @PostMapping("groups/{ownerId}/members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>changeRoleByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "create_member", tags = {"成员" },  notes = "Member-create_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-create_member-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-create_member')")
    @PostMapping("groups/{ownerId}/members/create_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>createMemberByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createMemberByOwnerId(ownerId, item)));
        else
            rt.set(createMemberByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * mob_add_shared_member 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "mob_add_shared_member", tags = {"成员" },  notes = "Member-mob_add_shared_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-mob_add_shared_member-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-mob_add_shared_member')")
    @PostMapping("groups/{ownerId}/members/mob_add_shared_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>mobAddSharedMemberByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mobAddSharedMemberByOwnerId(ownerId, item)));
        else
            rt.set(mobAddSharedMemberByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_add_shared_member 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO mobAddSharedMemberByOwnerId
            (String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.mobAddSharedMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"成员" },  notes = "Member-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Save-all') or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Save')")
    @PostMapping("groups/{ownerId}/members/save")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * 创建Create 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"成员" },  notes = "Member-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Create-all') or hasPermission('section',#sectionId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Create')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>createBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySectionIdAndOwnerId(sectionId, ownerId, item)));
        else
            rt.set(createBySectionIdAndOwnerId(sectionId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO createBySectionIdAndOwnerId
            (String sectionId, String ownerId, MemberDTO dto) {
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
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"成员" },  notes = "Member-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Update-all') or hasPermission('section',#sectionId,this.memberService.get(#id),'ibizplm-Member-Update')")
    @VersionCheck(entity = "member" , versionfield = "updateTime")
    @PutMapping("sections/{sectionId}/groups/{ownerId}/members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>updateBySectionIdAndOwnerIdAndId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySectionIdAndOwnerIdAndId(sectionId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySectionIdAndOwnerIdAndId(sectionId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO updateBySectionIdAndOwnerIdAndId
            (String sectionId, String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        memberService.update(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }

    /**
    * add_member_position 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "add_member_position", tags = {"成员" },  notes = "Member-add_member_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-add_member_position-all') or hasPermission('section',#sectionId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-add_member_position')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/{id}/add_member_position")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>addMemberPositionBySectionIdAndOwnerIdAndId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addMemberPositionBySectionIdAndOwnerIdAndId(sectionId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addMemberPositionBySectionIdAndOwnerIdAndId(sectionId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_member_position 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO addMemberPositionBySectionIdAndOwnerIdAndId
            (String sectionId, String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        Member rt = memberService.addMemberPosition(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * add_shared_page_member 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "add_shared_page_member", tags = {"成员" },  notes = "Member-add_shared_page_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-add_shared_page_member-all') or hasPermission('section',#sectionId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-add_shared_page_member')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/add_shared_page_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>addSharedPageMemberBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addSharedPageMemberBySectionIdAndOwnerId(sectionId, ownerId, item)));
        else
            rt.set(addSharedPageMemberBySectionIdAndOwnerId(sectionId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_shared_page_member 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO addSharedPageMemberBySectionIdAndOwnerId
            (String sectionId, String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.addSharedPageMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * change_role 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"成员" },  notes = "Member-change_role ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-change_role-all') or hasPermission('section',#sectionId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-change_role')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>changeRoleBySectionIdAndOwnerIdAndId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleBySectionIdAndOwnerIdAndId(sectionId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleBySectionIdAndOwnerIdAndId(sectionId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO changeRoleBySectionIdAndOwnerIdAndId
            (String sectionId, String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        Member rt = memberService.changeRole(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * create_member 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "create_member", tags = {"成员" },  notes = "Member-create_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-create_member-all') or hasPermission('section',#sectionId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-create_member')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/create_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>createMemberBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createMemberBySectionIdAndOwnerId(sectionId, ownerId, item)));
        else
            rt.set(createMemberBySectionIdAndOwnerId(sectionId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_member 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO createMemberBySectionIdAndOwnerId
            (String sectionId, String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.createMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * mob_add_shared_member 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "mob_add_shared_member", tags = {"成员" },  notes = "Member-mob_add_shared_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-mob_add_shared_member-all') or hasPermission('section',#sectionId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-mob_add_shared_member')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/mob_add_shared_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>mobAddSharedMemberBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mobAddSharedMemberBySectionIdAndOwnerId(sectionId, ownerId, item)));
        else
            rt.set(mobAddSharedMemberBySectionIdAndOwnerId(sectionId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_add_shared_member 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO mobAddSharedMemberBySectionIdAndOwnerId
            (String sectionId, String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.mobAddSharedMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"成员" },  notes = "Member-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Save-all') or hasPermission('section',#sectionId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Save')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/save")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>saveBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySectionIdAndOwnerId(sectionId, ownerId, item)));
        else
            rt.set(saveBySectionIdAndOwnerId(sectionId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO saveBySectionIdAndOwnerId
            (String sectionId, String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        memberService.save(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"成员" },  notes = "Member-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Create-all') or hasPermission('shared_space',#spaceId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Create')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>createBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySpaceIdAndOwnerId(spaceId, ownerId, item)));
        else
            rt.set(createBySpaceIdAndOwnerId(spaceId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO createBySpaceIdAndOwnerId
            (String spaceId, String ownerId, MemberDTO dto) {
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
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"成员" },  notes = "Member-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Update-all') or hasPermission('shared_space',#spaceId,this.memberService.get(#id),'ibizplm-Member-Update')")
    @VersionCheck(entity = "member" , versionfield = "updateTime")
    @PutMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>updateBySpaceIdAndOwnerIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySpaceIdAndOwnerIdAndId(spaceId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySpaceIdAndOwnerIdAndId(spaceId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO updateBySpaceIdAndOwnerIdAndId
            (String spaceId, String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        memberService.update(domain);
        Member rt = domain;
        return memberDtoMapping.toDto(rt);
    }

    /**
    * add_member_position 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "add_member_position", tags = {"成员" },  notes = "Member-add_member_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-add_member_position-all') or hasPermission('shared_space',#spaceId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-add_member_position')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/{id}/add_member_position")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>addMemberPositionBySpaceIdAndOwnerIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addMemberPositionBySpaceIdAndOwnerIdAndId(spaceId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addMemberPositionBySpaceIdAndOwnerIdAndId(spaceId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_member_position 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO addMemberPositionBySpaceIdAndOwnerIdAndId
            (String spaceId, String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        Member rt = memberService.addMemberPosition(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * add_shared_page_member 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "add_shared_page_member", tags = {"成员" },  notes = "Member-add_shared_page_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-add_shared_page_member-all') or hasPermission('shared_space',#spaceId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-add_shared_page_member')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/add_shared_page_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>addSharedPageMemberBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addSharedPageMemberBySpaceIdAndOwnerId(spaceId, ownerId, item)));
        else
            rt.set(addSharedPageMemberBySpaceIdAndOwnerId(spaceId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_shared_page_member 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO addSharedPageMemberBySpaceIdAndOwnerId
            (String spaceId, String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.addSharedPageMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * change_role 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"成员" },  notes = "Member-change_role ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-change_role-all') or hasPermission('shared_space',#spaceId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-change_role')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>changeRoleBySpaceIdAndOwnerIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleBySpaceIdAndOwnerIdAndId(spaceId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleBySpaceIdAndOwnerIdAndId(spaceId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO changeRoleBySpaceIdAndOwnerIdAndId
            (String spaceId, String ownerId, String id, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setId(id);
        Member rt = memberService.changeRole(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * create_member 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "create_member", tags = {"成员" },  notes = "Member-create_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-create_member-all') or hasPermission('shared_space',#spaceId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-create_member')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/create_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>createMemberBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createMemberBySpaceIdAndOwnerId(spaceId, ownerId, item)));
        else
            rt.set(createMemberBySpaceIdAndOwnerId(spaceId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_member 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO createMemberBySpaceIdAndOwnerId
            (String spaceId, String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.createMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * mob_add_shared_member 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "mob_add_shared_member", tags = {"成员" },  notes = "Member-mob_add_shared_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-mob_add_shared_member-all') or hasPermission('shared_space',#spaceId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-mob_add_shared_member')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/mob_add_shared_member")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>mobAddSharedMemberBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mobAddSharedMemberBySpaceIdAndOwnerId(spaceId, ownerId, item)));
        else
            rt.set(mobAddSharedMemberBySpaceIdAndOwnerId(spaceId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_add_shared_member 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO mobAddSharedMemberBySpaceIdAndOwnerId
            (String spaceId, String ownerId, MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.mobAddSharedMember(domain);
        return memberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"成员" },  notes = "Member-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Save-all') or hasPermission('shared_space',#spaceId,this.memberDtoMapping.toDomain(#dto),'ibizplm-Member-Save')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/save")
    public Mono<ResponseEntity<ResponseWrapper<MemberDTO>>>saveBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<MemberDTO> dto) {
        ResponseWrapper<MemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySpaceIdAndOwnerId(spaceId, ownerId, item)));
        else
            rt.set(saveBySpaceIdAndOwnerId(spaceId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<MemberDTO>
    */   
    public MemberDTO saveBySpaceIdAndOwnerId
            (String spaceId, String ownerId, MemberDTO dto) {
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
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"成员" },  notes = "Member-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Get-all')  or hasPermission(this.memberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Member-Get')")
    @GetMapping("members/{id}")
    public Mono<ResponseEntity<MemberDTO>> getById
            (@PathVariable("id") String id) {
        Member rt = memberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 成员
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"成员" },  notes = "Member-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Remove-all') or hasPermission(this.memberService.get(#id),'ibizplm-Member-Remove')")
    @DeleteMapping("members/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = memberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"成员" },  notes = "Member-CheckKey ")
    @PostMapping("members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        CheckKeyStatus rt = memberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"成员" },  notes = "Member-GetDraft ")
    @GetMapping("members/get_draft")
    public Mono<ResponseEntity<MemberDTO>> getDraft
            (@SpringQueryMap MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        Member rt = memberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"成员" },  notes = "Member-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_default-all') or hasPermission(#dto,'ibizplm-Member-fetch_default')")
    @PostMapping("members/fetch_default")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchDefault
            (@Validated @RequestBody MemberFilterDTO dto) {
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchDefault(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_attention 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_attention", tags = {"成员" },  notes = "Member-fetch_no_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_no_attention-all') or hasPermission(#dto,'ibizplm-Member-fetch_no_attention')")
    @PostMapping("members/fetch_no_attention")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchNoAttention
            (@Validated @RequestBody MemberFilterDTO dto) {
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchNoAttention(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_page_member 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_page_member", tags = {"成员" },  notes = "Member-fetch_shared_page_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_shared_page_member-all') or hasPermission(#dto,'ibizplm-Member-fetch_shared_page_member')")
    @PostMapping("members/fetch_shared_page_member")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchSharedPageMember
            (@Validated @RequestBody MemberFilterDTO dto) {
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchSharedPageMember(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user_group_admin 成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_user_group_admin", tags = {"成员" },  notes = "Member-fetch_user_group_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_user_group_admin-all') or hasPermission(#dto,'ibizplm-Member-fetch_user_group_admin')")
    @PostMapping("members/fetch_user_group_admin")
    public Mono<ResponseEntity<List<MemberDefGroupDTO>>> fetchUserGroupAdmin
            (@Validated @RequestBody MemberFilterDTO dto) {
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchUserGroupAdmin(context) ;
        List<MemberDefGroupDTO> list = memberDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"成员" },  notes = "Member-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Get-all')  or hasPermission('group',#ownerId,this.memberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Member-Get')")
    @GetMapping("groups/{ownerId}/members/{id}")
    public Mono<ResponseEntity<MemberDTO>> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Member rt = memberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"成员" },  notes = "Member-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Remove-all') or hasPermission('group',#ownerId,this.memberService.get(#id),'ibizplm-Member-Remove')")
    @DeleteMapping("groups/{ownerId}/members/{id}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = memberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"成员" },  notes = "Member-CheckKey ")
    @PostMapping("groups/{ownerId}/members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = memberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"成员" },  notes = "Member-GetDraft ")
    @GetMapping("groups/{ownerId}/members/get_draft")
    public Mono<ResponseEntity<MemberDTO>> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"成员" },  notes = "Member-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_default-all') or hasPermission('group',#ownerId,#dto,'ibizplm-Member-fetch_default')")
    @PostMapping("groups/{ownerId}/members/fetch_default")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchDefault(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_attention 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_attention", tags = {"成员" },  notes = "Member-fetch_no_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_no_attention-all') or hasPermission('group',#ownerId,#dto,'ibizplm-Member-fetch_no_attention')")
    @PostMapping("groups/{ownerId}/members/fetch_no_attention")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchNoAttentionByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchNoAttention(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_page_member 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_page_member", tags = {"成员" },  notes = "Member-fetch_shared_page_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_shared_page_member-all') or hasPermission('group',#ownerId,#dto,'ibizplm-Member-fetch_shared_page_member')")
    @PostMapping("groups/{ownerId}/members/fetch_shared_page_member")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchSharedPageMemberByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchSharedPageMember(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user_group_admin 成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_user_group_admin", tags = {"成员" },  notes = "Member-fetch_user_group_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_user_group_admin-all') or hasPermission('group',#ownerId,#dto,'ibizplm-Member-fetch_user_group_admin')")
    @PostMapping("groups/{ownerId}/members/fetch_user_group_admin")
    public Mono<ResponseEntity<List<MemberDefGroupDTO>>> fetchUserGroupAdminByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchUserGroupAdmin(context) ;
        List<MemberDefGroupDTO> list = memberDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"成员" },  notes = "Member-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Get-all')  or hasPermission('section',#sectionId,this.memberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Member-Get')")
    @GetMapping("sections/{sectionId}/groups/{ownerId}/members/{id}")
    public Mono<ResponseEntity<MemberDTO>> getBySectionIdAndOwnerIdAndId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Member rt = memberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"成员" },  notes = "Member-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Remove-all') or hasPermission('section',#sectionId,this.memberService.get(#id),'ibizplm-Member-Remove')")
    @DeleteMapping("sections/{sectionId}/groups/{ownerId}/members/{id}")
    public Mono<ResponseEntity<Boolean>> removeBySectionIdAndOwnerIdAndId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = memberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"成员" },  notes = "Member-CheckKey ")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = memberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"成员" },  notes = "Member-GetDraft ")
    @GetMapping("sections/{sectionId}/groups/{ownerId}/members/get_draft")
    public Mono<ResponseEntity<MemberDTO>> getDraftBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @SpringQueryMap MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"成员" },  notes = "Member-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_default-all') or hasPermission('section',#sectionId,#dto,'ibizplm-Member-fetch_default')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/fetch_default")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchDefaultBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchDefault(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_attention 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_attention", tags = {"成员" },  notes = "Member-fetch_no_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_no_attention-all') or hasPermission('section',#sectionId,#dto,'ibizplm-Member-fetch_no_attention')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/fetch_no_attention")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchNoAttentionBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchNoAttention(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_page_member 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_page_member", tags = {"成员" },  notes = "Member-fetch_shared_page_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_shared_page_member-all') or hasPermission('section',#sectionId,#dto,'ibizplm-Member-fetch_shared_page_member')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/fetch_shared_page_member")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchSharedPageMemberBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchSharedPageMember(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user_group_admin 成员
    * 
    *
    * @param sectionId sectionId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_user_group_admin", tags = {"成员" },  notes = "Member-fetch_user_group_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_user_group_admin-all') or hasPermission('section',#sectionId,#dto,'ibizplm-Member-fetch_user_group_admin')")
    @PostMapping("sections/{sectionId}/groups/{ownerId}/members/fetch_user_group_admin")
    public Mono<ResponseEntity<List<MemberDefGroupDTO>>> fetchUserGroupAdminBySectionIdAndOwnerId
            (@PathVariable("sectionId") String sectionId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchUserGroupAdmin(context) ;
        List<MemberDefGroupDTO> list = memberDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"成员" },  notes = "Member-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Get-all')  or hasPermission('shared_space',#spaceId,this.memberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Member-Get')")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/{id}")
    public Mono<ResponseEntity<MemberDTO>> getBySpaceIdAndOwnerIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Member rt = memberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"成员" },  notes = "Member-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-Remove-all') or hasPermission('shared_space',#spaceId,this.memberService.get(#id),'ibizplm-Member-Remove')")
    @DeleteMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/{id}")
    public Mono<ResponseEntity<Boolean>> removeBySpaceIdAndOwnerIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = memberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"成员" },  notes = "Member-CheckKey ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = memberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<MemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"成员" },  notes = "Member-GetDraft ")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/get_draft")
    public Mono<ResponseEntity<MemberDTO>> getDraftBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @SpringQueryMap MemberDTO dto) {
        Member domain = memberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Member rt = memberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"成员" },  notes = "Member-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_default-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-Member-fetch_default')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/fetch_default")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchDefaultBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchDefault(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_attention 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_attention", tags = {"成员" },  notes = "Member-fetch_no_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_no_attention-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-Member-fetch_no_attention')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/fetch_no_attention")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchNoAttentionBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchNoAttention(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_page_member 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_page_member", tags = {"成员" },  notes = "Member-fetch_shared_page_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_shared_page_member-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-Member-fetch_shared_page_member')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/fetch_shared_page_member")
    public Mono<ResponseEntity<List<MemberDTO>>> fetchSharedPageMemberBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchSharedPageMember(context) ;
        List<MemberDTO> list = memberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user_group_admin 成员
    * 
    *
    * @param spaceId spaceId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<MemberDefGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_user_group_admin", tags = {"成员" },  notes = "Member-fetch_user_group_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Member-fetch_user_group_admin-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-Member-fetch_user_group_admin')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{ownerId}/members/fetch_user_group_admin")
    public Mono<ResponseEntity<List<MemberDefGroupDTO>>> fetchUserGroupAdminBySpaceIdAndOwnerId
            (@PathVariable("spaceId") String spaceId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody MemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        MemberSearchContext context = memberFilterDtoMapping.toDomain(dto);
        Page<Member> domains = memberService.fetchUserGroupAdmin(context) ;
        List<MemberDefGroupDTO> list = memberDefGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Create-all')")
    @ApiOperation(value = "批量新建成员", tags = {"成员" },  notes = "批量新建成员")
	@PostMapping("members/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<MemberDTO> dtos) {
        memberService.create(memberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除成员
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Remove-all')")
    @ApiOperation(value = "批量删除成员", tags = {"成员" },  notes = "批量删除成员")
	@DeleteMapping("members/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        memberService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Update-all')")
    @ApiOperation(value = "批量更新成员", tags = {"成员" },  notes = "批量更新成员")
	@PutMapping("members/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<MemberDTO> dtos) {
        memberService.update(memberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Save-all')")
    @ApiOperation(value = "批量保存成员", tags = {"成员" },  notes = "批量保存成员")
	@PostMapping("members/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<MemberDTO> dtos) {
        memberService.save(memberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Member-Save-all')")
    @ApiOperation(value = "批量导入成员", tags = {"成员" },  notes = "批量导入成员")
	@PostMapping("members/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<MemberDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(memberService.importData(config,ignoreError,memberDtoMapping.toDomain(dtos))));
    }

}
