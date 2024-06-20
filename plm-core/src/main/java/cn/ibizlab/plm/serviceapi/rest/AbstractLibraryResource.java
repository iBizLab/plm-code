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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.testmgmt.filter.LibrarySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Library] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractLibraryResource {

    @Autowired
    public LibraryService libraryService;

    @Autowired
    @Lazy
    public LibraryDTOMapping libraryDtoMapping;

    @Autowired
    @Lazy
    public LibraryFilterDTOMapping libraryFilterDtoMapping;

    /**
    * 创建Create 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"测试库" },  notes = "Library-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Create-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-Create')")
    @PostMapping("libraries")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> create
            (@Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO create
            (LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        libraryService.create(domain);
        Library rt = domain;
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"测试库" },  notes = "Library-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Update-all') or hasPermission(this.libraryService.get(#id),'ibizplm-Library-Update')")
    @VersionCheck(entity = "library" , versionfield = "updateTime")
    @PutMapping("libraries/{id}")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO updateById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        libraryService.update(domain);
        Library rt = domain;
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * activate 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "activate", tags = {"测试库" },  notes = "Library-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-activate-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-activate')")
    @PostMapping("libraries/{id}/activate")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * activate 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO activateById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.activate(domain);
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * archive 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "archive", tags = {"测试库" },  notes = "Library-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-archive-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-archive')")
    @PostMapping("libraries/{id}/archive")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * archive 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO archiveById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.archive(domain);
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * change_admin_role 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "change_admin_role", tags = {"测试库" },  notes = "Library-change_admin_role ")
    @PostMapping("libraries/{id}/change_admin_role")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> changeAdminRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAdminRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAdminRoleById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * change_admin_role 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO changeAdminRoleById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.changeAdminRole(domain);
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * delete 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "delete", tags = {"测试库" },  notes = "Library-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-delete-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-delete')")
    @PostMapping("libraries/{id}/delete")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO deleteById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.delete(domain);
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * favorite 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "favorite", tags = {"测试库" },  notes = "Library-favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-favorite-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-favorite')")
    @PostMapping("libraries/{id}/favorite")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * favorite 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO favoriteById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.favorite(domain);
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * library_index_addon_counter 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "library_index_addon_counter", tags = {"测试库" },  notes = "Library-library_index_addon_counter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-library_index_addon_counter-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-library_index_addon_counter')")
    @PostMapping("libraries/{id}/library_index_addon_counter")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> libraryIndexAddonCounterById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(libraryIndexAddonCounterById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(libraryIndexAddonCounterById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * library_index_addon_counter 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO libraryIndexAddonCounterById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.libraryIndexAddonCounter(domain);
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * move_library 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "move_library", tags = {"测试库" },  notes = "Library-move_library ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-move_library-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-move_library')")
    @PutMapping("libraries/{id}/move_library")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> moveLibraryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveLibraryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveLibraryById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * move_library 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO moveLibraryById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.moveLibrary(domain);
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * recover 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "recover", tags = {"测试库" },  notes = "Library-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-recover-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-recover')")
    @PostMapping("libraries/{id}/recover")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * recover 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO recoverById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.recover(domain);
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"测试库" },  notes = "Library-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Save-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-Save')")
    @PostMapping("libraries/save")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> save
            (@Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO save
            (LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        libraryService.save(domain);
        Library rt = domain;
        return libraryDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "un_favorite", tags = {"测试库" },  notes = "Library-un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-un_favorite-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-un_favorite')")
    @PostMapping("libraries/{id}/un_favorite")
    public ResponseEntity<ResponseWrapper<LibraryDTO>> unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<LibraryDTO> dto) {
        ResponseWrapper<LibraryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * un_favorite 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */   
    public LibraryDTO unFavoriteById
            (String id, LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        domain.setId(id);
        Library rt = libraryService.unFavorite(domain);
        return libraryDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 测试库
    * 
    *
    * @param id id
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"测试库" },  notes = "Library-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Get-all')  or hasPermission(this.libraryDtoMapping.toDomain(returnObject.body),'ibizplm-Library-Get')")
    @GetMapping("libraries/{id}")
    public ResponseEntity<LibraryDTO> getById
            (@PathVariable("id") String id) {
        Library rt = libraryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(libraryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 测试库
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试库" },  notes = "Library-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Remove-all') or hasPermission(this.libraryService.get(#id),'ibizplm-Library-Remove')")
    @DeleteMapping("libraries/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = libraryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试库" },  notes = "Library-CheckKey ")
    @PostMapping("libraries/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        Integer rt = libraryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试库" },  notes = "Library-GetDraft ")
    @GetMapping("libraries/get_draft")
    public ResponseEntity<LibraryDTO> getDraft
            (@SpringQueryMap LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        Library rt = libraryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(libraryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_admin 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"测试库" },  notes = "Library-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_admin-all') or hasPermission(#dto,'ibizplm-Library-fetch_admin')")
    @PostMapping("libraries/fetch_admin")
    public ResponseEntity<List<LibraryDTO>> fetchAdmin
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchAdmin(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_archived 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"测试库" },  notes = "Library-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_archived-all') or hasPermission(#dto,'ibizplm-Library-fetch_archived')")
    @PostMapping("libraries/fetch_archived")
    public ResponseEntity<List<LibraryDTO>> fetchArchived
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchArchived(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"测试库" },  notes = "Library-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_default-all') or hasPermission(#dto,'ibizplm-Library-fetch_default')")
    @PostMapping("libraries/fetch_default")
    public ResponseEntity<List<LibraryDTO>> fetchDefault
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchDefault(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_deleted 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"测试库" },  notes = "Library-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_deleted-all') or hasPermission(#dto,'ibizplm-Library-fetch_deleted')")
    @PostMapping("libraries/fetch_deleted")
    public ResponseEntity<List<LibraryDTO>> fetchDeleted
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchDeleted(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_favorite 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_favorite", tags = {"测试库" },  notes = "Library-fetch_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_favorite-all') or hasPermission(#dto,'ibizplm-Library-fetch_favorite')")
    @PostMapping("libraries/fetch_favorite")
    public ResponseEntity<List<LibraryDTO>> fetchFavorite
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchFavorite(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_main 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_main", tags = {"测试库" },  notes = "Library-fetch_main ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_main-all') or hasPermission(#dto,'ibizplm-Library-fetch_main')")
    @PostMapping("libraries/fetch_main")
    public ResponseEntity<List<LibraryDTO>> fetchMain
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchMain(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"测试库" },  notes = "Library-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_normal-all') or hasPermission(#dto,'ibizplm-Library-fetch_normal')")
    @PostMapping("libraries/fetch_normal")
    public ResponseEntity<List<LibraryDTO>> fetchNormal
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchNormal(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_project_relation_library 测试库
    * 通过测试计划中进行关联项目展示测试库
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_project_relation_library", tags = {"测试库" },  notes = "Library-fetch_project_relation_library 通过测试计划中进行关联项目展示测试库")
    @PostMapping("libraries/fetch_project_relation_library")
    public ResponseEntity<List<LibraryDTO>> fetchProjectRelationLibrary
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchProjectRelationLibrary(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_quick_user 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_quick_user", tags = {"测试库" },  notes = "Library-fetch_quick_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_quick_user-all') or hasPermission(#dto,'ibizplm-Library-fetch_quick_user')")
    @PostMapping("libraries/fetch_quick_user")
    public ResponseEntity<List<LibraryDTO>> fetchQuickUser
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchQuickUser(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_reader 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"测试库" },  notes = "Library-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_reader-all') or hasPermission(#dto,'ibizplm-Library-fetch_reader')")
    @PostMapping("libraries/fetch_reader")
    public ResponseEntity<List<LibraryDTO>> fetchReader
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchReader(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_user 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"测试库" },  notes = "Library-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-fetch_user-all') or hasPermission(#dto,'ibizplm-Library-fetch_user')")
    @PostMapping("libraries/fetch_user")
    public ResponseEntity<List<LibraryDTO>> fetchUser
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.fetchUser(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建测试库
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Library-Create-all')")
    @ApiOperation(value = "批量新建测试库", tags = {"测试库" },  notes = "批量新建测试库")
	@PostMapping("libraries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<LibraryDTO> dtos) {
        libraryService.create(libraryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除测试库
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Library-Remove-all')")
    @ApiOperation(value = "批量删除测试库", tags = {"测试库" },  notes = "批量删除测试库")
	@DeleteMapping("libraries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        libraryService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新测试库
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Library-Update-all')")
    @ApiOperation(value = "批量更新测试库", tags = {"测试库" },  notes = "批量更新测试库")
	@PutMapping("libraries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<LibraryDTO> dtos) {
        libraryService.update(libraryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存测试库
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Library-Save-all')")
    @ApiOperation(value = "批量保存测试库", tags = {"测试库" },  notes = "批量保存测试库")
	@PostMapping("libraries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<LibraryDTO> dtos) {
        libraryService.save(libraryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入测试库
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Library-Save-all')")
    @ApiOperation(value = "批量导入测试库", tags = {"测试库" },  notes = "批量导入测试库")
	@PostMapping("libraries/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<LibraryDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(libraryService.importData(config,ignoreError,libraryDtoMapping.toDomain(dtos)));
    }

}
