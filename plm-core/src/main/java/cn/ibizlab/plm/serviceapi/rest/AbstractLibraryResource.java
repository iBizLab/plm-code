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
    * Activate 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "Activate", tags = {"测试库" },  notes = "Library-Activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Activate-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-Activate')")
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
    * Activate 测试库
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
    * Archive 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "Archive", tags = {"测试库" },  notes = "Library-Archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Archive-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-Archive')")
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
    * Archive 测试库
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
    * Delete 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "Delete", tags = {"测试库" },  notes = "Library-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Delete-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-Delete')")
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
    * Delete 测试库
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
    * Favorite 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "Favorite", tags = {"测试库" },  notes = "Library-Favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Favorite-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-Favorite')")
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
    * Favorite 测试库
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
    * Recover 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "Recover", tags = {"测试库" },  notes = "Library-Recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Recover-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-Recover')")
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
    * Recover 测试库
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
    * Un_favorite 测试库
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<LibraryDTO>
    */
    @ApiOperation(value = "Un_favorite", tags = {"测试库" },  notes = "Library-Un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-Un_favorite-all') or hasPermission(this.libraryDtoMapping.toDomain(#dto),'ibizplm-Library-Un_favorite')")
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
    * Un_favorite 测试库
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
    @PostMapping("libraries/checkkey")
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
    @GetMapping("libraries/getdraft")
    public ResponseEntity<LibraryDTO> getDraft
            (@SpringQueryMap LibraryDTO dto) {
        Library domain = libraryDtoMapping.toDomain(dto);
        Library rt = libraryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(libraryDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchAdmin 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchAdmin", tags = {"测试库" },  notes = "Library-FetchAdmin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-FetchAdmin-all') or hasPermission(#dto,'ibizplm-Library-FetchAdmin')")
    @PostMapping("libraries/fetchadmin")
    public ResponseEntity<List<LibraryDTO>> fetchAdmin
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchAdmin(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchArchived 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchArchived", tags = {"测试库" },  notes = "Library-FetchArchived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-FetchArchived-all') or hasPermission(#dto,'ibizplm-Library-FetchArchived')")
    @PostMapping("libraries/fetcharchived")
    public ResponseEntity<List<LibraryDTO>> fetchArchived
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchArchived(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"测试库" },  notes = "Library-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-FetchDefault-all') or hasPermission(#dto,'ibizplm-Library-FetchDefault')")
    @PostMapping("libraries/fetchdefault")
    public ResponseEntity<List<LibraryDTO>> fetchDefault
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchDefault(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDeleted 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"测试库" },  notes = "Library-FetchDeleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-FetchDeleted-all') or hasPermission(#dto,'ibizplm-Library-FetchDeleted')")
    @PostMapping("libraries/fetchdeleted")
    public ResponseEntity<List<LibraryDTO>> fetchDeleted
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchDeleted(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchFavorite 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchFavorite", tags = {"测试库" },  notes = "Library-FetchFavorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-FetchFavorite-all') or hasPermission(#dto,'ibizplm-Library-FetchFavorite')")
    @PostMapping("libraries/fetchfavorite")
    public ResponseEntity<List<LibraryDTO>> fetchFavorite
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchFavorite(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"测试库" },  notes = "Library-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-FetchNormal-all') or hasPermission(#dto,'ibizplm-Library-FetchNormal')")
    @PostMapping("libraries/fetchnormal")
    public ResponseEntity<List<LibraryDTO>> fetchNormal
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchNormal(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchProject_relation_library 测试库
    * 通过测试计划中进行关联项目展示测试库
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchProject_relation_library", tags = {"测试库" },  notes = "Library-FetchProject_relation_library 通过测试计划中进行关联项目展示测试库")
    @PostMapping("libraries/fetchproject_relation_library")
    public ResponseEntity<List<LibraryDTO>> fetchProjectRelationLibrary
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchProjectRelationLibrary(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchReader 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchReader", tags = {"测试库" },  notes = "Library-FetchReader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-FetchReader-all') or hasPermission(#dto,'ibizplm-Library-FetchReader')")
    @PostMapping("libraries/fetchreader")
    public ResponseEntity<List<LibraryDTO>> fetchReader
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchReader(context) ;
        List<LibraryDTO> list = libraryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchUser 测试库
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<LibraryDTO>>
    */
    @ApiOperation(value = "查询FetchUser", tags = {"测试库" },  notes = "Library-FetchUser ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Library-FetchUser-all') or hasPermission(#dto,'ibizplm-Library-FetchUser')")
    @PostMapping("libraries/fetchuser")
    public ResponseEntity<List<LibraryDTO>> fetchUser
            (@Validated @RequestBody LibraryFilterDTO dto) {
        LibrarySearchContext context = libraryFilterDtoMapping.toDomain(dto);
        Page<Library> domains = libraryService.searchUser(context) ;
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
        libraryService.createBatch(libraryDtoMapping.toDomain(dtos));
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
        libraryService.removeBatch(ids);
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
        libraryService.updateBatch(libraryDtoMapping.toDomain(dtos));
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
        libraryService.saveBatch(libraryDtoMapping.toDomain(dtos));
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
