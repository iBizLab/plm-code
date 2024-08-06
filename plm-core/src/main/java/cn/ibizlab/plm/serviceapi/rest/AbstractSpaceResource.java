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
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.wiki.service.SpaceService;
import cn.ibizlab.plm.core.wiki.filter.SpaceSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

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
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"空间" },  notes = "Space-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Create-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Create')")
    @PostMapping("spaces")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>create
            (@Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"空间" },  notes = "Space-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Update-all') or hasPermission(this.spaceService.get(#id),'ibizplm-Space-Update')")
    @VersionCheck(entity = "space" , versionfield = "updateTime")
    @PutMapping("spaces/{id}")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * activate 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "activate", tags = {"空间" },  notes = "Space-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-activate-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-activate')")
    @PostMapping("spaces/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * activate 空间
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
    * archive 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "archive", tags = {"空间" },  notes = "Space-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-archive-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-archive')")
    @PostMapping("spaces/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * archive 空间
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
    * change_admin_role 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "change_admin_role", tags = {"空间" },  notes = "Space-change_admin_role ")
    @PostMapping("spaces/{id}/change_admin_role")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>changeAdminRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAdminRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAdminRoleById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_admin_role 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO changeAdminRoleById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.changeAdminRole(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * del_relation 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "del_relation", tags = {"空间" },  notes = "Space-del_relation ")
    @PostMapping("spaces/{id}/del_relation")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * del_relation 空间
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
    * delete 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "delete", tags = {"空间" },  notes = "Space-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-delete-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-delete')")
    @PostMapping("spaces/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 空间
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
    * favorite 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "favorite", tags = {"空间" },  notes = "Space-favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-favorite-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-favorite')")
    @PostMapping("spaces/{id}/favorite")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * favorite 空间
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
    * move_out_category 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "move_out_category", tags = {"空间" },  notes = "Space-move_out_category ")
    @PostMapping("spaces/{id}/move_out_category")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>moveOutCategoryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOutCategoryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOutCategoryById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_out_category 空间
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
    * move_space 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "move_space", tags = {"空间" },  notes = "Space-move_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-move_space-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-move_space')")
    @PostMapping("spaces/{id}/move_space")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>moveSpaceById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveSpaceById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveSpaceById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_space 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO moveSpaceById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.moveSpace(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * open_shared 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "open_shared", tags = {"空间" },  notes = "Space-open_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-open_shared-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-open_shared')")
    @PostMapping("spaces/{id}/open_shared")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>openSharedById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(openSharedById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(openSharedById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * open_shared 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO openSharedById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.openShared(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * other_re_space 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "other_re_space", tags = {"空间" },  notes = "Space-other_re_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-other_re_space-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-other_re_space')")
    @PutMapping("spaces/{id}/other_re_space")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>otherReSpaceById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherReSpaceById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherReSpaceById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * other_re_space 空间
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
    * recognize_cur_user_role 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "recognize_cur_user_role", tags = {"空间" },  notes = "Space-recognize_cur_user_role ")
    @PostMapping("spaces/{id}/recognize_cur_user_role")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>recognizeCurUserRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recognizeCurUserRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recognizeCurUserRoleById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recognize_cur_user_role 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO recognizeCurUserRoleById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.recognizeCurUserRole(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * recover 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "recover", tags = {"空间" },  notes = "Space-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-recover-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-recover')")
    @PostMapping("spaces/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 空间
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
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"空间" },  notes = "Space-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Save-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-Save')")
    @PostMapping("spaces/save")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>save
            (@Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * space_index_addon_counter 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "space_index_addon_counter", tags = {"空间" },  notes = "Space-space_index_addon_counter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-space_index_addon_counter-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-space_index_addon_counter')")
    @PostMapping("spaces/{id}/space_index_addon_counter")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>spaceIndexAddonCounterById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(spaceIndexAddonCounterById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(spaceIndexAddonCounterById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * space_index_addon_counter 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SpaceDTO>
    */   
    public SpaceDTO spaceIndexAddonCounterById
            (String id, SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        domain.setId(id);
        Space rt = spaceService.spaceIndexAddonCounter(domain);
        return spaceDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 空间
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "un_favorite", tags = {"空间" },  notes = "Space-un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-un_favorite-all') or hasPermission(this.spaceDtoMapping.toDomain(#dto),'ibizplm-Space-un_favorite')")
    @PostMapping("spaces/{id}/un_favorite")
    public Mono<ResponseEntity<ResponseWrapper<SpaceDTO>>>unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SpaceDTO> dto) {
        ResponseWrapper<SpaceDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * un_favorite 空间
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
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"空间" },  notes = "Space-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Get-all')  or hasPermission(this.spaceDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Space-Get')")
    @GetMapping("spaces/{id}")
    public Mono<ResponseEntity<SpaceDTO>> getById
            (@PathVariable("id") String id) {
        Space rt = spaceService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(spaceDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 空间
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"空间" },  notes = "Space-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-Remove-all') or hasPermission(this.spaceService.get(#id),'ibizplm-Space-Remove')")
    @DeleteMapping("spaces/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = spaceService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"空间" },  notes = "Space-CheckKey ")
    @PostMapping("spaces/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        CheckKeyStatus rt = spaceService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<SpaceDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"空间" },  notes = "Space-GetDraft ")
    @GetMapping("spaces/get_draft")
    public Mono<ResponseEntity<SpaceDTO>> getDraft
            (@SpringQueryMap SpaceDTO dto) {
        Space domain = spaceDtoMapping.toDomain(dto);
        Space rt = spaceService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(spaceDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_admin 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"空间" },  notes = "Space-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_admin-all') or hasPermission(#dto,'ibizplm-Space-fetch_admin')")
    @PostMapping("spaces/fetch_admin")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchAdmin
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchAdmin(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"空间" },  notes = "Space-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_archived-all') or hasPermission(#dto,'ibizplm-Space-fetch_archived')")
    @PostMapping("spaces/fetch_archived")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchArchived
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchArchived(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_category_space 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_category_space", tags = {"空间" },  notes = "Space-fetch_category_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_category_space-all') or hasPermission(#dto,'ibizplm-Space-fetch_category_space')")
    @PostMapping("spaces/fetch_category_space")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchCategorySpace
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchCategorySpace(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_current 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_current", tags = {"空间" },  notes = "Space-fetch_current ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_current-all') or hasPermission(#dto,'ibizplm-Space-fetch_current')")
    @PostMapping("spaces/fetch_current")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchCurrent
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchCurrent(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"空间" },  notes = "Space-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_default-all') or hasPermission(#dto,'ibizplm-Space-fetch_default')")
    @PostMapping("spaces/fetch_default")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchDefault
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchDefault(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"空间" },  notes = "Space-fetch_deleted ")
    @PostMapping("spaces/fetch_deleted")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchDeleted
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchDeleted(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_favorite 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_favorite", tags = {"空间" },  notes = "Space-fetch_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_favorite-all') or hasPermission(#dto,'ibizplm-Space-fetch_favorite')")
    @PostMapping("spaces/fetch_favorite")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchFavorite
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchFavorite(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_main 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_main", tags = {"空间" },  notes = "Space-fetch_main ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_main-all') or hasPermission(#dto,'ibizplm-Space-fetch_main')")
    @PostMapping("spaces/fetch_main")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchMain
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchMain(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_category_space 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_category_space", tags = {"空间" },  notes = "Space-fetch_no_category_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_no_category_space-all') or hasPermission(#dto,'ibizplm-Space-fetch_no_category_space')")
    @PostMapping("spaces/fetch_no_category_space")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchNoCategorySpace
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchNoCategorySpace(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_re_space 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_re_space", tags = {"空间" },  notes = "Space-fetch_no_re_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_no_re_space-all') or hasPermission(#dto,'ibizplm-Space-fetch_no_re_space')")
    @PostMapping("spaces/fetch_no_re_space")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchNoReSpace
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchNoReSpace(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"空间" },  notes = "Space-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_normal-all') or hasPermission(#dto,'ibizplm-Space-fetch_normal')")
    @PostMapping("spaces/fetch_normal")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchNormal
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchNormal(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_other_re_space 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_other_re_space", tags = {"空间" },  notes = "Space-fetch_other_re_space ")
    @PostMapping("spaces/fetch_other_re_space")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchOtherReSpace
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchOtherReSpace(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_quick_user 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_quick_user", tags = {"空间" },  notes = "Space-fetch_quick_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_quick_user-all') or hasPermission(#dto,'ibizplm-Space-fetch_quick_user')")
    @PostMapping("spaces/fetch_quick_user")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchQuickUser
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchQuickUser(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"空间" },  notes = "Space-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_reader-all') or hasPermission(#dto,'ibizplm-Space-fetch_reader')")
    @PostMapping("spaces/fetch_reader")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchReader
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchReader(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user 空间
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<SpaceDTO>>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"空间" },  notes = "Space-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Space-fetch_user-all') or hasPermission(#dto,'ibizplm-Space-fetch_user')")
    @PostMapping("spaces/fetch_user")
    public Mono<ResponseEntity<List<SpaceDTO>>> fetchUser
            (@Validated @RequestBody SpaceFilterDTO dto) {
        SpaceSearchContext context = spaceFilterDtoMapping.toDomain(dto);
        Page<Space> domains = spaceService.fetchUser(context) ;
        List<SpaceDTO> list = spaceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建空间
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Create-all')")
    @ApiOperation(value = "批量新建空间", tags = {"空间" },  notes = "批量新建空间")
	@PostMapping("spaces/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<SpaceDTO> dtos) {
        spaceService.create(spaceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除空间
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Remove-all')")
    @ApiOperation(value = "批量删除空间", tags = {"空间" },  notes = "批量删除空间")
	@DeleteMapping("spaces/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        spaceService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新空间
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Update-all')")
    @ApiOperation(value = "批量更新空间", tags = {"空间" },  notes = "批量更新空间")
	@PutMapping("spaces/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<SpaceDTO> dtos) {
        spaceService.update(spaceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存空间
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Save-all')")
    @ApiOperation(value = "批量保存空间", tags = {"空间" },  notes = "批量保存空间")
	@PostMapping("spaces/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<SpaceDTO> dtos) {
        spaceService.save(spaceDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入空间
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Space-Save-all')")
    @ApiOperation(value = "批量导入空间", tags = {"空间" },  notes = "批量导入空间")
	@PostMapping("spaces/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SpaceDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(spaceService.importData(config,ignoreError,spaceDtoMapping.toDomain(dtos))));
    }

}
