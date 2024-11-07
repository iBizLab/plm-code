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
import cn.ibizlab.plm.core.ebsx.domain.AppViewTheme;
import cn.ibizlab.plm.core.ebsx.service.AppViewThemeService;
import cn.ibizlab.plm.core.ebsx.filter.AppViewThemeSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[AppViewTheme] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAppViewThemeResource {

    @Autowired
    public AppViewThemeService appViewThemeService;

    @Autowired
    @Lazy
    public AppViewThemeDTOMapping appViewThemeDtoMapping;

    @Autowired
    @Lazy
    public AppViewThemeFilterDTOMapping appViewThemeFilterDtoMapping;

    /**
    * 创建Create 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AppViewThemeDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"应用视图主题" },  notes = "AppViewTheme-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-Create-all') or hasPermission(this.appViewThemeDtoMapping.toDomain(#dto),'ibizplm-AppViewTheme-Create')")
    @PostMapping("app_view_themes")
    public Mono<ResponseEntity<ResponseWrapper<AppViewThemeDTO>>>create
            (@Validated @RequestBody RequestWrapper<AppViewThemeDTO> dto) {
        ResponseWrapper<AppViewThemeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 应用视图主题
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AppViewThemeDTO>
    */   
    public AppViewThemeDTO create
            (AppViewThemeDTO dto) {
        AppViewTheme domain = appViewThemeDtoMapping.toDomain(dto);
        appViewThemeService.create(domain);
        AppViewTheme rt = domain;
        return appViewThemeDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 应用视图主题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<AppViewThemeDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"应用视图主题" },  notes = "AppViewTheme-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-Update-all') or hasPermission(this.appViewThemeService.get(#id),'ibizplm-AppViewTheme-Update')")
    @VersionCheck(entity = "appviewtheme" , versionfield = "updateTime")
    @PutMapping("app_view_themes/{id}")
    public Mono<ResponseEntity<ResponseWrapper<AppViewThemeDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AppViewThemeDTO> dto) {
        ResponseWrapper<AppViewThemeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 应用视图主题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AppViewThemeDTO>
    */   
    public AppViewThemeDTO updateById
            (String id, AppViewThemeDTO dto) {
        AppViewTheme domain = appViewThemeDtoMapping.toDomain(dto);
        domain.setId(id);
        appViewThemeService.update(domain);
        AppViewTheme rt = domain;
        return appViewThemeDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AppViewThemeDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"应用视图主题" },  notes = "AppViewTheme-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-Save-all') or hasPermission(this.appViewThemeDtoMapping.toDomain(#dto),'ibizplm-AppViewTheme-Save')")
    @PostMapping("app_view_themes/save")
    public Mono<ResponseEntity<ResponseWrapper<AppViewThemeDTO>>>save
            (@Validated @RequestBody RequestWrapper<AppViewThemeDTO> dto) {
        ResponseWrapper<AppViewThemeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 应用视图主题
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AppViewThemeDTO>
    */   
    public AppViewThemeDTO save
            (AppViewThemeDTO dto) {
        AppViewTheme domain = appViewThemeDtoMapping.toDomain(dto);
        appViewThemeService.save(domain);
        AppViewTheme rt = domain;
        return appViewThemeDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 应用视图主题
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<AppViewThemeDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"应用视图主题" },  notes = "AppViewTheme-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-Get-all')  or hasPermission(this.appViewThemeDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-AppViewTheme-Get')")
    @GetMapping("app_view_themes/{id}")
    public Mono<ResponseEntity<AppViewThemeDTO>> getById
            (@PathVariable("id") String id) {
        AppViewTheme rt = appViewThemeService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(appViewThemeDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 应用视图主题
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"应用视图主题" },  notes = "AppViewTheme-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-Remove-all') or hasPermission(this.appViewThemeService.get(#id),'ibizplm-AppViewTheme-Remove')")
    @DeleteMapping("app_view_themes/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = appViewThemeService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"应用视图主题" },  notes = "AppViewTheme-CheckKey ")
    @PostMapping("app_view_themes/checkkey")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody AppViewThemeDTO dto) {
        AppViewTheme domain = appViewThemeDtoMapping.toDomain(dto);
        CheckKeyStatus rt = appViewThemeService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<AppViewThemeDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"应用视图主题" },  notes = "AppViewTheme-GetDraft ")
    @GetMapping("app_view_themes/getdraft")
    public Mono<ResponseEntity<AppViewThemeDTO>> getDraft
            (@SpringQueryMap AppViewThemeDTO dto) {
        AppViewTheme domain = appViewThemeDtoMapping.toDomain(dto);
        AppViewTheme rt = appViewThemeService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(appViewThemeDtoMapping.toDto(rt)));
    }

    /**
    * 查询FetchCur_system 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AppViewThemeDTO>>>
    */
    @ApiOperation(value = "查询FetchCur_system", tags = {"应用视图主题" },  notes = "AppViewTheme-FetchCur_system ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-FetchCur_system-all') or hasPermission(#dto,'ibizplm-AppViewTheme-FetchCur_system')")
    @PostMapping("app_view_themes/fetchcur_system")
    public Mono<ResponseEntity<List<AppViewThemeDTO>>> fetchCurSystem
            (@Validated @RequestBody AppViewThemeFilterDTO dto) {
        AppViewThemeSearchContext context = appViewThemeFilterDtoMapping.toDomain(dto);
        Page<AppViewTheme> domains = appViewThemeService.fetchCurSystem(context) ;
        List<AppViewThemeDTO> list = appViewThemeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询FetchCur_system_all 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AppViewThemeDTO>>>
    */
    @ApiOperation(value = "查询FetchCur_system_all", tags = {"应用视图主题" },  notes = "AppViewTheme-FetchCur_system_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-FetchCur_system_all-all') or hasPermission(#dto,'ibizplm-AppViewTheme-FetchCur_system_all')")
    @PostMapping("app_view_themes/fetchcur_system_all")
    public Mono<ResponseEntity<List<AppViewThemeDTO>>> fetchCurSystemAll
            (@Validated @RequestBody AppViewThemeFilterDTO dto) {
        AppViewThemeSearchContext context = appViewThemeFilterDtoMapping.toDomain(dto);
        Page<AppViewTheme> domains = appViewThemeService.fetchCurSystemAll(context) ;
        List<AppViewThemeDTO> list = appViewThemeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询FetchCur_user 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AppViewThemeDTO>>>
    */
    @ApiOperation(value = "查询FetchCur_user", tags = {"应用视图主题" },  notes = "AppViewTheme-FetchCur_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-FetchCur_user-all') or hasPermission(#dto,'ibizplm-AppViewTheme-FetchCur_user')")
    @PostMapping("app_view_themes/fetchcur_user")
    public Mono<ResponseEntity<List<AppViewThemeDTO>>> fetchCurUser
            (@Validated @RequestBody AppViewThemeFilterDTO dto) {
        AppViewThemeSearchContext context = appViewThemeFilterDtoMapping.toDomain(dto);
        Page<AppViewTheme> domains = appViewThemeService.fetchCurUser(context) ;
        List<AppViewThemeDTO> list = appViewThemeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询FetchCur_user_all 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AppViewThemeDTO>>>
    */
    @ApiOperation(value = "查询FetchCur_user_all", tags = {"应用视图主题" },  notes = "AppViewTheme-FetchCur_user_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-FetchCur_user_all-all') or hasPermission(#dto,'ibizplm-AppViewTheme-FetchCur_user_all')")
    @PostMapping("app_view_themes/fetchcur_user_all")
    public Mono<ResponseEntity<List<AppViewThemeDTO>>> fetchCurUserAll
            (@Validated @RequestBody AppViewThemeFilterDTO dto) {
        AppViewThemeSearchContext context = appViewThemeFilterDtoMapping.toDomain(dto);
        Page<AppViewTheme> domains = appViewThemeService.fetchCurUserAll(context) ;
        List<AppViewThemeDTO> list = appViewThemeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询FetchDefault 应用视图主题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AppViewThemeDTO>>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"应用视图主题" },  notes = "AppViewTheme-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-FetchDefault-all') or hasPermission(#dto,'ibizplm-AppViewTheme-FetchDefault')")
    @PostMapping("app_view_themes/fetchdefault")
    public Mono<ResponseEntity<List<AppViewThemeDTO>>> fetchDefault
            (@Validated @RequestBody AppViewThemeFilterDTO dto) {
        AppViewThemeSearchContext context = appViewThemeFilterDtoMapping.toDomain(dto);
        Page<AppViewTheme> domains = appViewThemeService.fetchDefault(context) ;
        List<AppViewThemeDTO> list = appViewThemeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询FetchPsmodel_sync 应用视图主题
    * 用于定义实体数据关系界面组同步的数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<AppViewThemeDTO>>>
    */
    @ApiOperation(value = "查询FetchPsmodel_sync", tags = {"应用视图主题" },  notes = "AppViewTheme-FetchPsmodel_sync 用于定义实体数据关系界面组同步的数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-AppViewTheme-FetchPsmodel_sync-all') or hasPermission(#dto,'ibizplm-AppViewTheme-FetchPsmodel_sync')")
    @PostMapping("app_view_themes/fetchpsmodel_sync")
    public Mono<ResponseEntity<List<AppViewThemeDTO>>> fetchPsmodelSync
            (@Validated @RequestBody AppViewThemeFilterDTO dto) {
        AppViewThemeSearchContext context = appViewThemeFilterDtoMapping.toDomain(dto);
        Page<AppViewTheme> domains = appViewThemeService.fetchPsmodelSync(context) ;
        List<AppViewThemeDTO> list = appViewThemeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建应用视图主题
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AppViewTheme-Create-all')")
    @ApiOperation(value = "批量新建应用视图主题", tags = {"应用视图主题" },  notes = "批量新建应用视图主题")
	@PostMapping("app_view_themes/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<AppViewThemeDTO> dtos) {
        appViewThemeService.create(appViewThemeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除应用视图主题
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AppViewTheme-Remove-all')")
    @ApiOperation(value = "批量删除应用视图主题", tags = {"应用视图主题" },  notes = "批量删除应用视图主题")
	@DeleteMapping("app_view_themes/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        appViewThemeService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新应用视图主题
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AppViewTheme-Update-all')")
    @ApiOperation(value = "批量更新应用视图主题", tags = {"应用视图主题" },  notes = "批量更新应用视图主题")
	@PutMapping("app_view_themes/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<AppViewThemeDTO> dtos) {
        appViewThemeService.update(appViewThemeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存应用视图主题
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AppViewTheme-Save-all')")
    @ApiOperation(value = "批量保存应用视图主题", tags = {"应用视图主题" },  notes = "批量保存应用视图主题")
	@PostMapping("app_view_themes/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<AppViewThemeDTO> dtos) {
        appViewThemeService.save(appViewThemeDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入应用视图主题
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-AppViewTheme-Save-all')")
    @ApiOperation(value = "批量导入应用视图主题", tags = {"应用视图主题" },  notes = "批量导入应用视图主题")
	@PostMapping("app_view_themes/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<AppViewThemeDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(appViewThemeService.importData(config,ignoreError,appViewThemeDtoMapping.toDomain(dtos))));
    }

}
