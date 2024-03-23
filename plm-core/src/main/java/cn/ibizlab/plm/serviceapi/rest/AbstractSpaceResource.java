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
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.service.SpaceService;
import cn.ibizlab.plm.core.wiki.filter.SpaceSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Space] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSpaceResource {

    @Autowired
    public SpaceService spaceService;

    @Autowired
    @Lazy
    public SpaceDTOMapping spaceDtoMapping;

    @Autowired
    @Lazy
    public SpaceFilterDTOMapping spaceFilterDtoMapping;

    /**
    * 创建Create 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"空间" },  notes = "Space-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Create-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Create')")
    @PostMapping("spaces")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> create
            (@Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO create
            (SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        spaceService.create(domain);
        Space rt = domain;
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"空间" },  notes = "Space-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Update-all') or hasPermission(this.spaceService.get(#id),'ibizplm-Space-Update')")
    @VersionCheck(entity = "space" , versionfield = "updateTime")
    @PutMapping("spaces/{id}")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO updateById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        spaceService.update(domain);
        Space rt = domain;
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Activate 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Activate", tags = {"空间" },  notes = "Space-Activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Activate-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Activate')")
    @PostMapping("spaces/{id}/activate")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Activate 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO activateById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.activate(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Add_space 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Add_space", tags = {"空间" },  notes = "Space-Add_space ")
    @PostMapping("spaces/{id}/add_space")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> addSpaceById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addSpaceById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addSpaceById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Add_space 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO addSpaceById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.addSpace(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Archive 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Archive", tags = {"空间" },  notes = "Space-Archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Archive-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Archive')")
    @PostMapping("spaces/{id}/archive")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Archive 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO archiveById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.archive(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Del_relation 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"空间" },  notes = "Space-Del_relation ")
    @PostMapping("spaces/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO delRelationById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.delRelation(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Delete 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Delete", tags = {"空间" },  notes = "Space-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Delete-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Delete')")
    @PostMapping("spaces/{id}/delete")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO deleteById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.delete(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Favorite 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Favorite", tags = {"空间" },  notes = "Space-Favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Favorite-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Favorite')")
    @PostMapping("spaces/{id}/favorite")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Favorite 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO favoriteById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.favorite(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Move_out_category 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Move_out_category", tags = {"空间" },  notes = "Space-Move_out_category ")
    @PostMapping("spaces/{id}/move_out_category")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> moveOutCategoryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOutCategoryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOutCategoryById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Move_out_category 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO moveOutCategoryById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.moveOutCategory(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Other_re_space 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Other_re_space", tags = {"空间" },  notes = "Space-Other_re_space ")
    @PostMapping("spaces/{id}/other_re_space")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> otherReSpaceById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherReSpaceById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherReSpaceById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Other_re_space 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO otherReSpaceById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.otherReSpace(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Recover 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Recover", tags = {"空间" },  notes = "Space-Recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Recover-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Recover')")
    @PostMapping("spaces/{id}/recover")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Recover 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO recoverById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.recover(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"空间" },  notes = "Space-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Save-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Save')")
    @PostMapping("spaces/save")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> save
            (@Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO save
            (SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        spaceService.save(domain);
        Space rt = domain;
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * Un_favorite 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "Un_favorite", tags = {"空间" },  notes = "Space-Un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Un_favorite-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Un_favorite')")
    @PostMapping("spaces/{id}/un_favorite")
    public ResponseEntity<ResponseWrapper<SpaceDTO>> unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Un_favorite 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO unFavoriteById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.unFavorite(domain);
        return spaceDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 空间
    * 
    *
    * @param id id
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"空间" },  notes = "Space-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Get-all')  or hasPermission(this.spaceDtoMapping.toDomain(returnObject.body),'ibizplm-Space-Get')")
    @GetMapping("spaces/{id}")
    public ResponseEntity<SpaceDTO> getById
            (@PathVariable("id") String id) {
        Space rt = spaceService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(spaceDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 空间
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"空间" },  notes = "Space-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Remove-all') or hasPermission(this.spaceService.get(#id),'ibizplm-Space-Remove')")
    @DeleteMapping("spaces/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = spaceService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"空间" },  notes = "Space-CheckKey ")
    @PostMapping("spaces/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        Integer rt = spaceService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"空间" },  notes = "Space-GetDraft ")
    @GetMapping("spaces/getdraft")
    public ResponseEntity<SpaceDTO> getDraft
            (@SpringQueryMap SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        Space rt = spaceService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(spaceDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchAdmin 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchAdmin", tags = {"空间" },  notes = "Space-FetchAdmin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-FetchAdmin-all') or hasPermission(#dto,'ibizplm-Space-FetchAdmin')")
    @PostMapping("spaces/fetchadmin")
    public ResponseEntity<List<SpaceDTO>> fetchAdmin
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchAdmin(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchArchived 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchArchived", tags = {"空间" },  notes = "Space-FetchArchived ")
    @PostMapping("spaces/fetcharchived")
    public ResponseEntity<List<SpaceDTO>> fetchArchived
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchArchived(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchCategory_space 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchCategory_space", tags = {"空间" },  notes = "Space-FetchCategory_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-FetchCategory_space-all') or hasPermission(#dto,'ibizplm-Space-FetchCategory_space')")
    @PostMapping("spaces/fetchcategory_space")
    public ResponseEntity<List<SpaceDTO>> fetchCategorySpace
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchCategorySpace(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"空间" },  notes = "Space-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-FetchDefault-all') or hasPermission(#dto,'ibizplm-Space-FetchDefault')")
    @PostMapping("spaces/fetchdefault")
    public ResponseEntity<List<SpaceDTO>> fetchDefault
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchDefault(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDeleted 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"空间" },  notes = "Space-FetchDeleted ")
    @PostMapping("spaces/fetchdeleted")
    public ResponseEntity<List<SpaceDTO>> fetchDeleted
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchDeleted(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchFavorite 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchFavorite", tags = {"空间" },  notes = "Space-FetchFavorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-FetchFavorite-all') or hasPermission(#dto,'ibizplm-Space-FetchFavorite')")
    @PostMapping("spaces/fetchfavorite")
    public ResponseEntity<List<SpaceDTO>> fetchFavorite
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchFavorite(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNo_category_space 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchNo_category_space", tags = {"空间" },  notes = "Space-FetchNo_category_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-FetchNo_category_space-all') or hasPermission(#dto,'ibizplm-Space-FetchNo_category_space')")
    @PostMapping("spaces/fetchno_category_space")
    public ResponseEntity<List<SpaceDTO>> fetchNoCategorySpace
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchNoCategorySpace(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNo_re_space 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchNo_re_space", tags = {"空间" },  notes = "Space-FetchNo_re_space ")
    @PostMapping("spaces/fetchno_re_space")
    public ResponseEntity<List<SpaceDTO>> fetchNoReSpace
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchNoReSpace(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"空间" },  notes = "Space-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-FetchNormal-all') or hasPermission(#dto,'ibizplm-Space-FetchNormal')")
    @PostMapping("spaces/fetchnormal")
    public ResponseEntity<List<SpaceDTO>> fetchNormal
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchNormal(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchOther_re_space 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchOther_re_space", tags = {"空间" },  notes = "Space-FetchOther_re_space ")
    @PostMapping("spaces/fetchother_re_space")
    public ResponseEntity<List<SpaceDTO>> fetchOtherReSpace
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchOtherReSpace(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchUser 空间
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SpaceDTO>>
    */
    @ApiOperation(value = "查询FetchUser", tags = {"空间" },  notes = "Space-FetchUser ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-FetchUser-all') or hasPermission(#dto,'ibizplm-Space-FetchUser')")
    @PostMapping("spaces/fetchuser")
    public ResponseEntity<List<SpaceDTO>> fetchUser
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.searchUser(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建空间
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Create-all')")
    @ApiOperation(value = "批量新建空间", tags = {"空间" },  notes = "批量新建空间")
	@PostMapping("spaces/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SpaceDTO> dtos) {
        spaceService.createBatch(spaceDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除空间
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Remove-all')")
    @ApiOperation(value = "批量删除空间", tags = {"空间" },  notes = "批量删除空间")
	@DeleteMapping("spaces/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        spaceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新空间
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Update-all')")
    @ApiOperation(value = "批量更新空间", tags = {"空间" },  notes = "批量更新空间")
	@PutMapping("spaces/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SpaceDTO> dtos) {
        spaceService.updateBatch(spaceDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存空间
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Save-all')")
    @ApiOperation(value = "批量保存空间", tags = {"空间" },  notes = "批量保存空间")
	@PostMapping("spaces/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SpaceDTO> dtos) {
        spaceService.saveBatch(spaceDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入空间
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Save-all')")
    @ApiOperation(value = "批量导入空间", tags = {"空间" },  notes = "批量导入空间")
	@PostMapping("spaces/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SpaceDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(spaceService.importData(config,ignoreError,spaceDtoMapping.toDomain(dtos)));
    }

}
