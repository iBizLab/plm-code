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
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.core.insight.service.InsightMemberService;
import cn.ibizlab.plm.core.insight.filter.InsightMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[InsightMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightMemberResource {

    @Autowired
    public InsightMemberService insightMemberService;

    @Autowired
    @Lazy
    public InsightMemberDTOMapping insightMemberDtoMapping;

    @Autowired
    @Lazy
    public InsightMemberFilterDTOMapping insightMemberFilterDtoMapping;

    /**
    * 创建Create 效能成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"效能成员" },  notes = "InsightMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Create-all') or hasPermission(this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-Create')")
    @PostMapping("insight_members")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>create
            (@Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 效能成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO create
            (InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        insightMemberService.create(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 效能成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"效能成员" },  notes = "InsightMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Update-all') or hasPermission(this.insightMemberService.get(#id),'ibizplm-InsightMember-Update')")
    @VersionCheck(entity = "insightmember" , versionfield = "updateTime")
    @PutMapping("insight_members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 效能成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO updateById
            (String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        insightMemberService.update(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 效能成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"效能成员" },  notes = "InsightMember-change_role ")
    @PostMapping("insight_members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>changeRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 效能成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO changeRoleById
            (String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightMember rt = insightMemberService.changeRole(domain);
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * choose_position 效能成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "choose_position", tags = {"效能成员" },  notes = "InsightMember-choose_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-choose_position-all') or hasPermission(this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-choose_position')")
    @PostMapping("insight_members/{id}/choose_position")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>choosePositionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(choosePositionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(choosePositionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_position 效能成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO choosePositionById
            (String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightMember rt = insightMemberService.choosePosition(domain);
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 效能成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"效能成员" },  notes = "InsightMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Save-all') or hasPermission(this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-Save')")
    @PostMapping("insight_members/save")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>save
            (@Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 效能成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO save
            (InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        insightMemberService.save(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"效能成员" },  notes = "InsightMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Create-all') or hasPermission('insight_view',#ownerId,this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-Create')")
    @PostMapping("insight_views/{ownerId}/insight_members")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO createByOwnerId
            (String ownerId, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        insightMemberService.create(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"效能成员" },  notes = "InsightMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Update-all') or hasPermission('insight_view',#ownerId,this.insightMemberService.get(#id),'ibizplm-InsightMember-Update')")
    @VersionCheck(entity = "insightmember" , versionfield = "updateTime")
    @PutMapping("insight_views/{ownerId}/insight_members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO updateByOwnerIdAndId
            (String ownerId, String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        insightMemberService.update(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"效能成员" },  notes = "InsightMember-change_role ")
    @PostMapping("insight_views/{ownerId}/insight_members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>changeRoleByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO changeRoleByOwnerIdAndId
            (String ownerId, String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightMember rt = insightMemberService.changeRole(domain);
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * choose_position 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "choose_position", tags = {"效能成员" },  notes = "InsightMember-choose_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-choose_position-all') or hasPermission('insight_view',#ownerId,this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-choose_position')")
    @PostMapping("insight_views/{ownerId}/insight_members/{id}/choose_position")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>choosePositionByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(choosePositionByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(choosePositionByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_position 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO choosePositionByOwnerIdAndId
            (String ownerId, String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightMember rt = insightMemberService.choosePosition(domain);
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"效能成员" },  notes = "InsightMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Save-all') or hasPermission('insight_view',#ownerId,this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-Save')")
    @PostMapping("insight_views/{ownerId}/insight_members/save")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO saveByOwnerId
            (String ownerId, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        insightMemberService.save(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 效能成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"效能成员" },  notes = "InsightMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Create-all') or hasPermission('user',#userId,this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-Create')")
    @PostMapping("users/{userId}/insight_members")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>createByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByUserId(userId, item)));
        else
            rt.set(createByUserId(userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 效能成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO createByUserId
            (String userId, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        insightMemberService.create(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 效能成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"效能成员" },  notes = "InsightMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Update-all') or hasPermission('user',#userId,this.insightMemberService.get(#id),'ibizplm-InsightMember-Update')")
    @VersionCheck(entity = "insightmember" , versionfield = "updateTime")
    @PutMapping("users/{userId}/insight_members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>updateByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByUserIdAndId(userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 效能成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO updateByUserIdAndId
            (String userId, String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        insightMemberService.update(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 效能成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"效能成员" },  notes = "InsightMember-change_role ")
    @PostMapping("users/{userId}/insight_members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>changeRoleByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByUserIdAndId(userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 效能成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO changeRoleByUserIdAndId
            (String userId, String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightMember rt = insightMemberService.changeRole(domain);
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * choose_position 效能成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "choose_position", tags = {"效能成员" },  notes = "InsightMember-choose_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-choose_position-all') or hasPermission('user',#userId,this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-choose_position')")
    @PostMapping("users/{userId}/insight_members/{id}/choose_position")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>choosePositionByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(choosePositionByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(choosePositionByUserIdAndId(userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_position 效能成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO choosePositionByUserIdAndId
            (String userId, String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightMember rt = insightMemberService.choosePosition(domain);
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 效能成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"效能成员" },  notes = "InsightMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Save-all') or hasPermission('user',#userId,this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-Save')")
    @PostMapping("users/{userId}/insight_members/save")
    public Mono<ResponseEntity<ResponseWrapper<InsightMemberDTO>>>saveByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByUserId(userId, item)));
        else
            rt.set(saveByUserId(userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 效能成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO saveByUserId
            (String userId, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        insightMemberService.save(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 效能成员
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"效能成员" },  notes = "InsightMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Get-all')  or hasPermission(this.insightMemberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-InsightMember-Get')")
    @GetMapping("insight_members/{id}")
    public Mono<ResponseEntity<InsightMemberDTO>> getById
            (@PathVariable("id") String id) {
        InsightMember rt = insightMemberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightMemberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 效能成员
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"效能成员" },  notes = "InsightMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Remove-all') or hasPermission(this.insightMemberService.get(#id),'ibizplm-InsightMember-Remove')")
    @DeleteMapping("insight_members/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = insightMemberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 效能成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"效能成员" },  notes = "InsightMember-CheckKey ")
    @PostMapping("insight_members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        CheckKeyStatus rt = insightMemberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 效能成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"效能成员" },  notes = "InsightMember-GetDraft ")
    @GetMapping("insight_members/get_draft")
    public Mono<ResponseEntity<InsightMemberDTO>> getDraft
            (@SpringQueryMap InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        InsightMember rt = insightMemberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightMemberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 效能成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"效能成员" },  notes = "InsightMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-fetch_default-all') or hasPermission(#dto,'ibizplm-InsightMember-fetch_default')")
    @PostMapping("insight_members/fetch_default")
    public Mono<ResponseEntity<List<InsightMemberDTO>>> fetchDefault
            (@Validated @RequestBody InsightMemberFilterDTO dto) {
        InsightMemberSearchContext context = insightMemberFilterDtoMapping.toDomain(dto);
        Page<InsightMember> domains = insightMemberService.fetchDefault(context) ;
        List<InsightMemberDTO> list = insightMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"效能成员" },  notes = "InsightMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Get-all')  or hasPermission('insight_view',#ownerId,this.insightMemberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-InsightMember-Get')")
    @GetMapping("insight_views/{ownerId}/insight_members/{id}")
    public Mono<ResponseEntity<InsightMemberDTO>> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        InsightMember rt = insightMemberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightMemberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"效能成员" },  notes = "InsightMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Remove-all') or hasPermission('insight_view',#ownerId,this.insightMemberService.get(#id),'ibizplm-InsightMember-Remove')")
    @DeleteMapping("insight_views/{ownerId}/insight_members/{id}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = insightMemberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"效能成员" },  notes = "InsightMember-CheckKey ")
    @PostMapping("insight_views/{ownerId}/insight_members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = insightMemberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"效能成员" },  notes = "InsightMember-GetDraft ")
    @GetMapping("insight_views/{ownerId}/insight_members/get_draft")
    public Mono<ResponseEntity<InsightMemberDTO>> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        InsightMember rt = insightMemberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightMemberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"效能成员" },  notes = "InsightMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-fetch_default-all') or hasPermission('insight_view',#ownerId,#dto,'ibizplm-InsightMember-fetch_default')")
    @PostMapping("insight_views/{ownerId}/insight_members/fetch_default")
    public Mono<ResponseEntity<List<InsightMemberDTO>>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody InsightMemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        InsightMemberSearchContext context = insightMemberFilterDtoMapping.toDomain(dto);
        Page<InsightMember> domains = insightMemberService.fetchDefault(context) ;
        List<InsightMemberDTO> list = insightMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 效能成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"效能成员" },  notes = "InsightMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Get-all')  or hasPermission('user',#userId,this.insightMemberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-InsightMember-Get')")
    @GetMapping("users/{userId}/insight_members/{id}")
    public Mono<ResponseEntity<InsightMemberDTO>> getByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        InsightMember rt = insightMemberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightMemberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 效能成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"效能成员" },  notes = "InsightMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Remove-all') or hasPermission('user',#userId,this.insightMemberService.get(#id),'ibizplm-InsightMember-Remove')")
    @DeleteMapping("users/{userId}/insight_members/{id}")
    public Mono<ResponseEntity<Boolean>> removeByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = insightMemberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 效能成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"效能成员" },  notes = "InsightMember-CheckKey ")
    @PostMapping("users/{userId}/insight_members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        CheckKeyStatus rt = insightMemberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 效能成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightMemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"效能成员" },  notes = "InsightMember-GetDraft ")
    @GetMapping("users/{userId}/insight_members/get_draft")
    public Mono<ResponseEntity<InsightMemberDTO>> getDraftByUserId
            (@PathVariable("userId") String userId, @SpringQueryMap InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        InsightMember rt = insightMemberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightMemberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 效能成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"效能成员" },  notes = "InsightMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-fetch_default-all') or hasPermission('user',#userId,#dto,'ibizplm-InsightMember-fetch_default')")
    @PostMapping("users/{userId}/insight_members/fetch_default")
    public Mono<ResponseEntity<List<InsightMemberDTO>>> fetchDefaultByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody InsightMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        InsightMemberSearchContext context = insightMemberFilterDtoMapping.toDomain(dto);
        Page<InsightMember> domains = insightMemberService.fetchDefault(context) ;
        List<InsightMemberDTO> list = insightMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建效能成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightMember-Create-all')")
    @ApiOperation(value = "批量新建效能成员", tags = {"效能成员" },  notes = "批量新建效能成员")
	@PostMapping("insight_members/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<InsightMemberDTO> dtos) {
        insightMemberService.create(insightMemberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除效能成员
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightMember-Remove-all')")
    @ApiOperation(value = "批量删除效能成员", tags = {"效能成员" },  notes = "批量删除效能成员")
	@DeleteMapping("insight_members/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        insightMemberService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新效能成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightMember-Update-all')")
    @ApiOperation(value = "批量更新效能成员", tags = {"效能成员" },  notes = "批量更新效能成员")
	@PutMapping("insight_members/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<InsightMemberDTO> dtos) {
        insightMemberService.update(insightMemberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存效能成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightMember-Save-all')")
    @ApiOperation(value = "批量保存效能成员", tags = {"效能成员" },  notes = "批量保存效能成员")
	@PostMapping("insight_members/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<InsightMemberDTO> dtos) {
        insightMemberService.save(insightMemberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入效能成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightMember-Save-all')")
    @ApiOperation(value = "批量导入效能成员", tags = {"效能成员" },  notes = "批量导入效能成员")
	@PostMapping("insight_members/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<InsightMemberDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightMemberService.importData(config,ignoreError,insightMemberDtoMapping.toDomain(dtos))));
    }

}
