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
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.service.FavoriteService;
import cn.ibizlab.plm.core.base.filter.FavoriteSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Favorite] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractFavoriteResource {

    @Autowired
    public FavoriteService favoriteService;

    @Autowired
    @Lazy
    public FavoriteDTOMapping favoriteDtoMapping;

    @Autowired
    @Lazy
    public FavoriteFilterDTOMapping favoriteFilterDtoMapping;

    /**
    * 创建Create 收藏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<FavoriteDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"收藏" },  notes = "Favorite-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Favorite-Create-all') or hasPermission(this.favoriteDtoMapping.toDomain(#dto),'ibizplm-Favorite-Create')")
    @PostMapping("favorites")
    public ResponseEntity<ResponseWrapper<FavoriteDTO>> create
            (@Validated @RequestBody RequestWrapper<FavoriteDTO> dto) {
        ResponseWrapper<FavoriteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 收藏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<FavoriteDTO>
    */   
    public FavoriteDTO create
            (FavoriteDTO dto) {
        Favorite domain = favoriteDtoMapping.toDomain(dto);
        favoriteService.create(domain);
        Favorite rt = domain;
        return favoriteDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 收藏
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<FavoriteDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"收藏" },  notes = "Favorite-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Favorite-Update-all') or hasPermission(this.favoriteService.get(#id),'ibizplm-Favorite-Update')")
    @VersionCheck(entity = "favorite" , versionfield = "updateTime")
    @PutMapping("favorites/{id}")
    public ResponseEntity<ResponseWrapper<FavoriteDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<FavoriteDTO> dto) {
        ResponseWrapper<FavoriteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 收藏
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<FavoriteDTO>
    */   
    public FavoriteDTO updateById
            (String id, FavoriteDTO dto) {
        Favorite domain = favoriteDtoMapping.toDomain(dto);
        domain.setId(id);
        favoriteService.update(domain);
        Favorite rt = domain;
        return favoriteDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 收藏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<FavoriteDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"收藏" },  notes = "Favorite-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Favorite-Save-all') or hasPermission(this.favoriteDtoMapping.toDomain(#dto),'ibizplm-Favorite-Save')")
    @PostMapping("favorites/save")
    public ResponseEntity<ResponseWrapper<FavoriteDTO>> save
            (@Validated @RequestBody RequestWrapper<FavoriteDTO> dto) {
        ResponseWrapper<FavoriteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 收藏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<FavoriteDTO>
    */   
    public FavoriteDTO save
            (FavoriteDTO dto) {
        Favorite domain = favoriteDtoMapping.toDomain(dto);
        favoriteService.save(domain);
        Favorite rt = domain;
        return favoriteDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 收藏
    * 
    *
    * @param id id
    * @return ResponseEntity<FavoriteDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"收藏" },  notes = "Favorite-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Favorite-Get-all')  or hasPermission(this.favoriteDtoMapping.toDomain(returnObject.body),'ibizplm-Favorite-Get')")
    @GetMapping("favorites/{id}")
    public ResponseEntity<FavoriteDTO> getById
            (@PathVariable("id") String id) {
        Favorite rt = favoriteService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(favoriteDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 收藏
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"收藏" },  notes = "Favorite-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Favorite-Remove-all') or hasPermission(this.favoriteService.get(#id),'ibizplm-Favorite-Remove')")
    @DeleteMapping("favorites/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = favoriteService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 收藏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"收藏" },  notes = "Favorite-CheckKey ")
    @PostMapping("favorites/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody FavoriteDTO dto) {
        Favorite domain = favoriteDtoMapping.toDomain(dto);
        Integer rt = favoriteService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 收藏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<FavoriteDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"收藏" },  notes = "Favorite-GetDraft ")
    @GetMapping("favorites/get_draft")
    public ResponseEntity<FavoriteDTO> getDraft
            (@SpringQueryMap FavoriteDTO dto) {
        Favorite domain = favoriteDtoMapping.toDomain(dto);
        Favorite rt = favoriteService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(favoriteDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 收藏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<FavoriteDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"收藏" },  notes = "Favorite-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Favorite-fetch_default-all') or hasPermission(#dto,'ibizplm-Favorite-fetch_default')")
    @PostMapping("favorites/fetch_default")
    public ResponseEntity<List<FavoriteDTO>> fetchDefault
            (@Validated @RequestBody FavoriteFilterDTO dto) {
        FavoriteSearchContext context = favoriteFilterDtoMapping.toDomain(dto);
        Page<Favorite> domains = favoriteService.fetchDefault(context) ;
        List<FavoriteDTO> list = favoriteDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建收藏
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Favorite-Create-all')")
    @ApiOperation(value = "批量新建收藏", tags = {"收藏" },  notes = "批量新建收藏")
	@PostMapping("favorites/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<FavoriteDTO> dtos) {
        favoriteService.create(favoriteDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除收藏
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Favorite-Remove-all')")
    @ApiOperation(value = "批量删除收藏", tags = {"收藏" },  notes = "批量删除收藏")
	@DeleteMapping("favorites/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        favoriteService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新收藏
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Favorite-Update-all')")
    @ApiOperation(value = "批量更新收藏", tags = {"收藏" },  notes = "批量更新收藏")
	@PutMapping("favorites/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<FavoriteDTO> dtos) {
        favoriteService.update(favoriteDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存收藏
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Favorite-Save-all')")
    @ApiOperation(value = "批量保存收藏", tags = {"收藏" },  notes = "批量保存收藏")
	@PostMapping("favorites/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<FavoriteDTO> dtos) {
        favoriteService.save(favoriteDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入收藏
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Favorite-Save-all')")
    @ApiOperation(value = "批量导入收藏", tags = {"收藏" },  notes = "批量导入收藏")
	@PostMapping("favorites/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<FavoriteDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(favoriteService.importData(config,ignoreError,favoriteDtoMapping.toDomain(dtos)));
    }

}
