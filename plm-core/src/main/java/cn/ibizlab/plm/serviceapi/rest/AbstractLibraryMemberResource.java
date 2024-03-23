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
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.testmgmt.service.LibraryMemberService;
import cn.ibizlab.plm.core.testmgmt.filter.LibraryMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[LibraryMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractLibraryMemberResource {

    @Autowired
    public LibraryMemberService libraryMemberService;

    @Autowired
    @Lazy
    public LibraryMemberDTOMapping libraryMemberDtoMapping;

    @Autowired
    @Lazy
    public LibraryMemberFilterDTOMapping libraryMemberFilterDtoMapping;

    /**
    * 创建Create 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"测试库成员" },  notes = "LibraryMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create-all') or hasPermission(this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create')")
    @PostMapping("library_members")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> create
            (@Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO create
            (LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        libraryMemberService.create(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 测试库成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"测试库成员" },  notes = "LibraryMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Update-all') or hasPermission(this.libraryMemberService.get(#id),'ibizplm-LibraryMember-Update')")
    @VersionCheck(entity = "librarymember" , versionfield = "updateTime")
    @PutMapping("library_members/{id}")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 测试库成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO updateById
            (String id, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        libraryMemberService.update(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_library_member 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "Create_library_member", tags = {"测试库成员" },  notes = "LibraryMember-Create_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create_library_member-all') or hasPermission(this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create_library_member')")
    @PostMapping("library_members/create_library_member")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> createLibraryMember
            (@Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createLibraryMember(item)));
        else
            rt.set(createLibraryMember(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_library_member 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO createLibraryMember
            (LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        LibraryMember rt = libraryMemberService.createLibraryMember(domain);
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_temp_admin 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "Create_temp_admin", tags = {"测试库成员" },  notes = "LibraryMember-Create_temp_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create_temp_admin-all') or hasPermission(this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create_temp_admin')")
    @PostMapping("library_members/create_temp_admin")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> createTempAdmin
            (@Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createTempAdmin(item)));
        else
            rt.set(createTempAdmin(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_temp_admin 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO createTempAdmin
            (LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        LibraryMember rt = libraryMemberService.createTempAdmin(domain);
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"测试库成员" },  notes = "LibraryMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Save-all') or hasPermission(this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Save')")
    @PostMapping("library_members/save")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> save
            (@Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO save
            (LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        libraryMemberService.save(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"测试库成员" },  notes = "LibraryMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create-all') or hasPermission('Library',#libraryId,this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create')")
    @PostMapping("libraries/{libraryId}/library_members")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> createByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryId(libraryId, item)));
        else
            rt.set(createByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO createByLibraryId
            (String libraryId, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        libraryMemberService.create(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"测试库成员" },  notes = "LibraryMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Update-all') or hasPermission('Library',#libraryId,this.libraryMemberService.get(#id),'ibizplm-LibraryMember-Update')")
    @VersionCheck(entity = "librarymember" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/library_members/{id}")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> updateByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndId(libraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO updateByLibraryIdAndId
            (String libraryId, String id, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        libraryMemberService.update(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_library_member 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "Create_library_member", tags = {"测试库成员" },  notes = "LibraryMember-Create_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create_library_member-all') or hasPermission('Library',#libraryId,this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create_library_member')")
    @PostMapping("libraries/{libraryId}/library_members/create_library_member")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> createLibraryMemberByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createLibraryMemberByLibraryId(libraryId, item)));
        else
            rt.set(createLibraryMemberByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_library_member 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO createLibraryMemberByLibraryId
            (String libraryId, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        LibraryMember rt = libraryMemberService.createLibraryMember(domain);
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_temp_admin 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "Create_temp_admin", tags = {"测试库成员" },  notes = "LibraryMember-Create_temp_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create_temp_admin-all') or hasPermission('Library',#libraryId,this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create_temp_admin')")
    @PostMapping("libraries/{libraryId}/library_members/create_temp_admin")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> createTempAdminByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createTempAdminByLibraryId(libraryId, item)));
        else
            rt.set(createTempAdminByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_temp_admin 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO createTempAdminByLibraryId
            (String libraryId, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        LibraryMember rt = libraryMemberService.createTempAdmin(domain);
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"测试库成员" },  notes = "LibraryMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Save-all') or hasPermission('Library',#libraryId,this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Save')")
    @PostMapping("libraries/{libraryId}/library_members/save")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> saveByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryId(libraryId, item)));
        else
            rt.set(saveByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO saveByLibraryId
            (String libraryId, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        libraryMemberService.save(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"测试库成员" },  notes = "LibraryMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create-all') or hasPermission('User',#userId,this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create')")
    @PostMapping("users/{userId}/library_members")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> createByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByUserId(userId, item)));
        else
            rt.set(createByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO createByUserId
            (String userId, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        libraryMemberService.create(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 测试库成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"测试库成员" },  notes = "LibraryMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Update-all') or hasPermission('User',#userId,this.libraryMemberService.get(#id),'ibizplm-LibraryMember-Update')")
    @VersionCheck(entity = "librarymember" , versionfield = "updateTime")
    @PutMapping("users/{userId}/library_members/{id}")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> updateByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByUserIdAndId(userId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 测试库成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO updateByUserIdAndId
            (String userId, String id, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        libraryMemberService.update(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_library_member 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "Create_library_member", tags = {"测试库成员" },  notes = "LibraryMember-Create_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create_library_member-all') or hasPermission('User',#userId,this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create_library_member')")
    @PostMapping("users/{userId}/library_members/create_library_member")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> createLibraryMemberByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createLibraryMemberByUserId(userId, item)));
        else
            rt.set(createLibraryMemberByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_library_member 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO createLibraryMemberByUserId
            (String userId, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        LibraryMember rt = libraryMemberService.createLibraryMember(domain);
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_temp_admin 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "Create_temp_admin", tags = {"测试库成员" },  notes = "LibraryMember-Create_temp_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Create_temp_admin-all') or hasPermission('User',#userId,this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Create_temp_admin')")
    @PostMapping("users/{userId}/library_members/create_temp_admin")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> createTempAdminByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createTempAdminByUserId(userId, item)));
        else
            rt.set(createTempAdminByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_temp_admin 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO createTempAdminByUserId
            (String userId, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        LibraryMember rt = libraryMemberService.createTempAdmin(domain);
        return libraryMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"测试库成员" },  notes = "LibraryMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Save-all') or hasPermission('User',#userId,this.libraryMemberDtoMapping.toDomain(#dto),'ibizplm-LibraryMember-Save')")
    @PostMapping("users/{userId}/library_members/save")
    public ResponseEntity<ResponseWrapper<LibraryMemberDTO>> saveByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<LibraryMemberDTO> dto) {
        ResponseWrapper<LibraryMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByUserId(userId, item)));
        else
            rt.set(saveByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */   
    public LibraryMemberDTO saveByUserId
            (String userId, LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        libraryMemberService.save(domain);
        LibraryMember rt = domain;
        return libraryMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 测试库成员
    * 
    *
    * @param id id
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"测试库成员" },  notes = "LibraryMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Get-all')  or hasPermission(this.libraryMemberDtoMapping.toDomain(returnObject.body),'ibizplm-LibraryMember-Get')")
    @GetMapping("library_members/{id}")
    public ResponseEntity<LibraryMemberDTO> getById
            (@PathVariable("id") String id) {
        LibraryMember rt = libraryMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(libraryMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 测试库成员
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试库成员" },  notes = "LibraryMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Remove-all') or hasPermission(this.libraryMemberService.get(#id),'ibizplm-LibraryMember-Remove')")
    @DeleteMapping("library_members/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = libraryMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试库成员" },  notes = "LibraryMember-CheckKey ")
    @PostMapping("library_members/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        Integer rt = libraryMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试库成员" },  notes = "LibraryMember-GetDraft ")
    @GetMapping("library_members/getdraft")
    public ResponseEntity<LibraryMemberDTO> getDraft
            (@SpringQueryMap LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        LibraryMember rt = libraryMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(libraryMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_library_member 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_library_member", tags = {"测试库成员" },  notes = "LibraryMember-FetchCur_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-FetchCur_library_member-all') or hasPermission(#dto,'ibizplm-LibraryMember-FetchCur_library_member')")
    @PostMapping("library_members/fetchcur_library_member")
    public ResponseEntity<List<LibraryMemberDTO>> fetchCurLibraryMember
            (@Validated @RequestBody LibraryMemberFilterDTO dto) {
        LibraryMemberSearchContext context = libraryMemberFilterDtoMapping.toDomain(dto);
        Page<LibraryMember> domains = libraryMemberService.searchCurLibraryMember(context) ;
        List<LibraryMemberDTO> list = libraryMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 测试库成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"测试库成员" },  notes = "LibraryMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-FetchDefault-all') or hasPermission(#dto,'ibizplm-LibraryMember-FetchDefault')")
    @PostMapping("library_members/fetchdefault")
    public ResponseEntity<List<LibraryMemberDTO>> fetchDefault
            (@Validated @RequestBody LibraryMemberFilterDTO dto) {
        LibraryMemberSearchContext context = libraryMemberFilterDtoMapping.toDomain(dto);
        Page<LibraryMember> domains = libraryMemberService.searchDefault(context) ;
        List<LibraryMemberDTO> list = libraryMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"测试库成员" },  notes = "LibraryMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Get-all')  or hasPermission('Library',#libraryId,this.libraryMemberDtoMapping.toDomain(returnObject.body),'ibizplm-LibraryMember-Get')")
    @GetMapping("libraries/{libraryId}/library_members/{id}")
    public ResponseEntity<LibraryMemberDTO> getByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        LibraryMember rt = libraryMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(libraryMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试库成员" },  notes = "LibraryMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Remove-all') or hasPermission('Library',#libraryId,this.libraryMemberService.get(#id),'ibizplm-LibraryMember-Remove')")
    @DeleteMapping("libraries/{libraryId}/library_members/{id}")
    public ResponseEntity<Boolean> removeByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Boolean rt = libraryMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试库成员" },  notes = "LibraryMember-CheckKey ")
    @PostMapping("libraries/{libraryId}/library_members/checkkey")
    public ResponseEntity<Integer> checkKeyByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        Integer rt = libraryMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试库成员" },  notes = "LibraryMember-GetDraft ")
    @GetMapping("libraries/{libraryId}/library_members/getdraft")
    public ResponseEntity<LibraryMemberDTO> getDraftByLibraryId
            (@PathVariable("libraryId") String libraryId, @SpringQueryMap LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        LibraryMember rt = libraryMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(libraryMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_library_member 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<LibraryMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_library_member", tags = {"测试库成员" },  notes = "LibraryMember-FetchCur_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-FetchCur_library_member-all') or hasPermission('Library',#libraryId,#dto,'ibizplm-LibraryMember-FetchCur_library_member')")
    @PostMapping("libraries/{libraryId}/library_members/fetchcur_library_member")
    public ResponseEntity<List<LibraryMemberDTO>> fetchCurLibraryMemberByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody LibraryMemberFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        LibraryMemberSearchContext context = libraryMemberFilterDtoMapping.toDomain(dto);
        Page<LibraryMember> domains = libraryMemberService.searchCurLibraryMember(context) ;
        List<LibraryMemberDTO> list = libraryMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 测试库成员
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<LibraryMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"测试库成员" },  notes = "LibraryMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-FetchDefault-all') or hasPermission('Library',#libraryId,#dto,'ibizplm-LibraryMember-FetchDefault')")
    @PostMapping("libraries/{libraryId}/library_members/fetchdefault")
    public ResponseEntity<List<LibraryMemberDTO>> fetchDefaultByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody LibraryMemberFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        LibraryMemberSearchContext context = libraryMemberFilterDtoMapping.toDomain(dto);
        Page<LibraryMember> domains = libraryMemberService.searchDefault(context) ;
        List<LibraryMemberDTO> list = libraryMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 测试库成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"测试库成员" },  notes = "LibraryMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Get-all')  or hasPermission('User',#userId,this.libraryMemberDtoMapping.toDomain(returnObject.body),'ibizplm-LibraryMember-Get')")
    @GetMapping("users/{userId}/library_members/{id}")
    public ResponseEntity<LibraryMemberDTO> getByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        LibraryMember rt = libraryMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(libraryMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 测试库成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试库成员" },  notes = "LibraryMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-Remove-all') or hasPermission('User',#userId,this.libraryMemberService.get(#id),'ibizplm-LibraryMember-Remove')")
    @DeleteMapping("users/{userId}/library_members/{id}")
    public ResponseEntity<Boolean> removeByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = libraryMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试库成员" },  notes = "LibraryMember-CheckKey ")
    @PostMapping("users/{userId}/library_members/checkkey")
    public ResponseEntity<Integer> checkKeyByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        Integer rt = libraryMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<LibraryMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试库成员" },  notes = "LibraryMember-GetDraft ")
    @GetMapping("users/{userId}/library_members/getdraft")
    public ResponseEntity<LibraryMemberDTO> getDraftByUserId
            (@PathVariable("userId") String userId, @SpringQueryMap LibraryMemberDTO dto) {
        LibraryMember domain = libraryMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        LibraryMember rt = libraryMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(libraryMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_library_member 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<LibraryMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_library_member", tags = {"测试库成员" },  notes = "LibraryMember-FetchCur_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-FetchCur_library_member-all') or hasPermission('User',#userId,#dto,'ibizplm-LibraryMember-FetchCur_library_member')")
    @PostMapping("users/{userId}/library_members/fetchcur_library_member")
    public ResponseEntity<List<LibraryMemberDTO>> fetchCurLibraryMemberByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody LibraryMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        LibraryMemberSearchContext context = libraryMemberFilterDtoMapping.toDomain(dto);
        Page<LibraryMember> domains = libraryMemberService.searchCurLibraryMember(context) ;
        List<LibraryMemberDTO> list = libraryMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 测试库成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<LibraryMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"测试库成员" },  notes = "LibraryMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-LibraryMember-FetchDefault-all') or hasPermission('User',#userId,#dto,'ibizplm-LibraryMember-FetchDefault')")
    @PostMapping("users/{userId}/library_members/fetchdefault")
    public ResponseEntity<List<LibraryMemberDTO>> fetchDefaultByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody LibraryMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        LibraryMemberSearchContext context = libraryMemberFilterDtoMapping.toDomain(dto);
        Page<LibraryMember> domains = libraryMemberService.searchDefault(context) ;
        List<LibraryMemberDTO> list = libraryMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建测试库成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-LibraryMember-Create-all')")
    @ApiOperation(value = "批量新建测试库成员", tags = {"测试库成员" },  notes = "批量新建测试库成员")
	@PostMapping("library_members/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<LibraryMemberDTO> dtos) {
        libraryMemberService.createBatch(libraryMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除测试库成员
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-LibraryMember-Remove-all')")
    @ApiOperation(value = "批量删除测试库成员", tags = {"测试库成员" },  notes = "批量删除测试库成员")
	@DeleteMapping("library_members/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        libraryMemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新测试库成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-LibraryMember-Update-all')")
    @ApiOperation(value = "批量更新测试库成员", tags = {"测试库成员" },  notes = "批量更新测试库成员")
	@PutMapping("library_members/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<LibraryMemberDTO> dtos) {
        libraryMemberService.updateBatch(libraryMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存测试库成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-LibraryMember-Save-all')")
    @ApiOperation(value = "批量保存测试库成员", tags = {"测试库成员" },  notes = "批量保存测试库成员")
	@PostMapping("library_members/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<LibraryMemberDTO> dtos) {
        libraryMemberService.saveBatch(libraryMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入测试库成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-LibraryMember-Save-all')")
    @ApiOperation(value = "批量导入测试库成员", tags = {"测试库成员" },  notes = "批量导入测试库成员")
	@PostMapping("library_members/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<LibraryMemberDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(libraryMemberService.importData(config,ignoreError,libraryMemberDtoMapping.toDomain(dtos)));
    }

}
