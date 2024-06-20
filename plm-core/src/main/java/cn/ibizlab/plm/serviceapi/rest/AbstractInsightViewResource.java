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
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.insight.service.InsightViewService;
import cn.ibizlab.plm.core.insight.filter.InsightViewSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[InsightView] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightViewResource {

    @Autowired
    public InsightViewService insightViewService;

    @Autowired
    @Lazy
    public InsightViewDTOMapping insightViewDtoMapping;

    @Autowired
    @Lazy
    public InsightViewFilterDTOMapping insightViewFilterDtoMapping;

    /**
    * 创建Create 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"效能视图" },  notes = "InsightView-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-Create-all') or hasPermission(this.insightViewDtoMapping.toDomain(#dto),'ibizplm-InsightView-Create')")
    @PostMapping("insight_views")
    public ResponseEntity<ResponseWrapper<InsightViewDTO>> create
            (@Validated @RequestBody RequestWrapper<InsightViewDTO> dto) {
        ResponseWrapper<InsightViewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */   
    public InsightViewDTO create
            (InsightViewDTO dto) {
        InsightView domain = insightViewDtoMapping.toDomain(dto);
        insightViewService.create(domain);
        InsightView rt = domain;
        return insightViewDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 效能视图
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"效能视图" },  notes = "InsightView-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-Update-all') or hasPermission(this.insightViewService.get(#id),'ibizplm-InsightView-Update')")
    @VersionCheck(entity = "insightview" , versionfield = "updateTime")
    @PutMapping("insight_views/{id}")
    public ResponseEntity<ResponseWrapper<InsightViewDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightViewDTO> dto) {
        ResponseWrapper<InsightViewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 效能视图
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */   
    public InsightViewDTO updateById
            (String id, InsightViewDTO dto) {
        InsightView domain = insightViewDtoMapping.toDomain(dto);
        domain.setId(id);
        insightViewService.update(domain);
        InsightView rt = domain;
        return insightViewDtoMapping.toDto(rt);
    }

    /**
    * favorite 效能视图
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */
    @ApiOperation(value = "favorite", tags = {"效能视图" },  notes = "InsightView-favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-favorite-all') or hasPermission(this.insightViewDtoMapping.toDomain(#dto),'ibizplm-InsightView-favorite')")
    @PostMapping("insight_views/{id}/favorite")
    public ResponseEntity<ResponseWrapper<InsightViewDTO>> favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightViewDTO> dto) {
        ResponseWrapper<InsightViewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * favorite 效能视图
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */   
    public InsightViewDTO favoriteById
            (String id, InsightViewDTO dto) {
        InsightView domain = insightViewDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightView rt = insightViewService.favorite(domain);
        return insightViewDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"效能视图" },  notes = "InsightView-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-Save-all') or hasPermission(this.insightViewDtoMapping.toDomain(#dto),'ibizplm-InsightView-Save')")
    @PostMapping("insight_views/save")
    public ResponseEntity<ResponseWrapper<InsightViewDTO>> save
            (@Validated @RequestBody RequestWrapper<InsightViewDTO> dto) {
        ResponseWrapper<InsightViewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */   
    public InsightViewDTO save
            (InsightViewDTO dto) {
        InsightView domain = insightViewDtoMapping.toDomain(dto);
        insightViewService.save(domain);
        InsightView rt = domain;
        return insightViewDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 效能视图
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */
    @ApiOperation(value = "un_favorite", tags = {"效能视图" },  notes = "InsightView-un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-un_favorite-all') or hasPermission(this.insightViewDtoMapping.toDomain(#dto),'ibizplm-InsightView-un_favorite')")
    @PostMapping("insight_views/{id}/un_favorite")
    public ResponseEntity<ResponseWrapper<InsightViewDTO>> unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightViewDTO> dto) {
        ResponseWrapper<InsightViewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * un_favorite 效能视图
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */   
    public InsightViewDTO unFavoriteById
            (String id, InsightViewDTO dto) {
        InsightView domain = insightViewDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightView rt = insightViewService.unFavorite(domain);
        return insightViewDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 效能视图
    * 
    *
    * @param id id
    * @return ResponseEntity<InsightViewDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"效能视图" },  notes = "InsightView-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-Get-all')  or hasPermission(this.insightViewDtoMapping.toDomain(returnObject.body),'ibizplm-InsightView-Get')")
    @GetMapping("insight_views/{id}")
    public ResponseEntity<InsightViewDTO> getById
            (@PathVariable("id") String id) {
        InsightView rt = insightViewService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(insightViewDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 效能视图
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"效能视图" },  notes = "InsightView-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-Remove-all') or hasPermission(this.insightViewService.get(#id),'ibizplm-InsightView-Remove')")
    @DeleteMapping("insight_views/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = insightViewService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"效能视图" },  notes = "InsightView-CheckKey ")
    @PostMapping("insight_views/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody InsightViewDTO dto) {
        InsightView domain = insightViewDtoMapping.toDomain(dto);
        Integer rt = insightViewService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightViewDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"效能视图" },  notes = "InsightView-GetDraft ")
    @GetMapping("insight_views/get_draft")
    public ResponseEntity<InsightViewDTO> getDraft
            (@SpringQueryMap InsightViewDTO dto) {
        InsightView domain = insightViewDtoMapping.toDomain(dto);
        InsightView rt = insightViewService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(insightViewDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_admin 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightViewDTO>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"效能视图" },  notes = "InsightView-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-fetch_admin-all') or hasPermission(#dto,'ibizplm-InsightView-fetch_admin')")
    @PostMapping("insight_views/fetch_admin")
    public ResponseEntity<List<InsightViewDTO>> fetchAdmin
            (@Validated @RequestBody InsightViewFilterDTO dto) {
        InsightViewSearchContext context = insightViewFilterDtoMapping.toDomain(dto);
        Page<InsightView> domains = insightViewService.fetchAdmin(context) ;
        List<InsightViewDTO> list = insightViewDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightViewDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"效能视图" },  notes = "InsightView-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-fetch_default-all') or hasPermission(#dto,'ibizplm-InsightView-fetch_default')")
    @PostMapping("insight_views/fetch_default")
    public ResponseEntity<List<InsightViewDTO>> fetchDefault
            (@Validated @RequestBody InsightViewFilterDTO dto) {
        InsightViewSearchContext context = insightViewFilterDtoMapping.toDomain(dto);
        Page<InsightView> domains = insightViewService.fetchDefault(context) ;
        List<InsightViewDTO> list = insightViewDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_favorite 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightViewDTO>>
    */
    @ApiOperation(value = "查询fetch_favorite", tags = {"效能视图" },  notes = "InsightView-fetch_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-fetch_favorite-all') or hasPermission(#dto,'ibizplm-InsightView-fetch_favorite')")
    @PostMapping("insight_views/fetch_favorite")
    public ResponseEntity<List<InsightViewDTO>> fetchFavorite
            (@Validated @RequestBody InsightViewFilterDTO dto) {
        InsightViewSearchContext context = insightViewFilterDtoMapping.toDomain(dto);
        Page<InsightView> domains = insightViewService.fetchFavorite(context) ;
        List<InsightViewDTO> list = insightViewDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_main 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightViewDTO>>
    */
    @ApiOperation(value = "查询fetch_main", tags = {"效能视图" },  notes = "InsightView-fetch_main ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-fetch_main-all') or hasPermission(#dto,'ibizplm-InsightView-fetch_main')")
    @PostMapping("insight_views/fetch_main")
    public ResponseEntity<List<InsightViewDTO>> fetchMain
            (@Validated @RequestBody InsightViewFilterDTO dto) {
        InsightViewSearchContext context = insightViewFilterDtoMapping.toDomain(dto);
        Page<InsightView> domains = insightViewService.fetchMain(context) ;
        List<InsightViewDTO> list = insightViewDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 效能视图
    * 正常状态
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightViewDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"效能视图" },  notes = "InsightView-fetch_normal 正常状态")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-fetch_normal-all') or hasPermission(#dto,'ibizplm-InsightView-fetch_normal')")
    @PostMapping("insight_views/fetch_normal")
    public ResponseEntity<List<InsightViewDTO>> fetchNormal
            (@Validated @RequestBody InsightViewFilterDTO dto) {
        InsightViewSearchContext context = insightViewFilterDtoMapping.toDomain(dto);
        Page<InsightView> domains = insightViewService.fetchNormal(context) ;
        List<InsightViewDTO> list = insightViewDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_reader 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightViewDTO>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"效能视图" },  notes = "InsightView-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-fetch_reader-all') or hasPermission(#dto,'ibizplm-InsightView-fetch_reader')")
    @PostMapping("insight_views/fetch_reader")
    public ResponseEntity<List<InsightViewDTO>> fetchReader
            (@Validated @RequestBody InsightViewFilterDTO dto) {
        InsightViewSearchContext context = insightViewFilterDtoMapping.toDomain(dto);
        Page<InsightView> domains = insightViewService.fetchReader(context) ;
        List<InsightViewDTO> list = insightViewDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_user 效能视图
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightViewDTO>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"效能视图" },  notes = "InsightView-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightView-fetch_user-all') or hasPermission(#dto,'ibizplm-InsightView-fetch_user')")
    @PostMapping("insight_views/fetch_user")
    public ResponseEntity<List<InsightViewDTO>> fetchUser
            (@Validated @RequestBody InsightViewFilterDTO dto) {
        InsightViewSearchContext context = insightViewFilterDtoMapping.toDomain(dto);
        Page<InsightView> domains = insightViewService.fetchUser(context) ;
        List<InsightViewDTO> list = insightViewDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建效能视图
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightView-Create-all')")
    @ApiOperation(value = "批量新建效能视图", tags = {"效能视图" },  notes = "批量新建效能视图")
	@PostMapping("insight_views/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<InsightViewDTO> dtos) {
        insightViewService.create(insightViewDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除效能视图
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightView-Remove-all')")
    @ApiOperation(value = "批量删除效能视图", tags = {"效能视图" },  notes = "批量删除效能视图")
	@DeleteMapping("insight_views/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        insightViewService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新效能视图
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightView-Update-all')")
    @ApiOperation(value = "批量更新效能视图", tags = {"效能视图" },  notes = "批量更新效能视图")
	@PutMapping("insight_views/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<InsightViewDTO> dtos) {
        insightViewService.update(insightViewDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存效能视图
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightView-Save-all')")
    @ApiOperation(value = "批量保存效能视图", tags = {"效能视图" },  notes = "批量保存效能视图")
	@PostMapping("insight_views/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<InsightViewDTO> dtos) {
        insightViewService.save(insightViewDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入效能视图
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightView-Save-all')")
    @ApiOperation(value = "批量导入效能视图", tags = {"效能视图" },  notes = "批量导入效能视图")
	@PostMapping("insight_views/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<InsightViewDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(insightViewService.importData(config,ignoreError,insightViewDtoMapping.toDomain(dtos)));
    }

}
