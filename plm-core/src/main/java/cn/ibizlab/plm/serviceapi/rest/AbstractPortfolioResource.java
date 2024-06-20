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
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.base.service.PortfolioService;
import cn.ibizlab.plm.core.base.filter.PortfolioSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Portfolio] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPortfolioResource {

    @Autowired
    public PortfolioService portfolioService;

    @Autowired
    @Lazy
    public PortfolioDTOMapping portfolioDtoMapping;

    @Autowired
    @Lazy
    public PortfolioFilterDTOMapping portfolioFilterDtoMapping;

    /**
    * 创建Create 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"文件夹" },  notes = "Portfolio-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Create-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-Create')")
    @PostMapping("portfolios")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> create
            (@Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO create
            (PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        portfolioService.create(domain);
        Portfolio rt = domain;
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"文件夹" },  notes = "Portfolio-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Update-all') or hasPermission(this.portfolioService.get(#id),'ibizplm-Portfolio-Update')")
    @VersionCheck(entity = "portfolio" , versionfield = "updateTime")
    @PutMapping("portfolios/{id}")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO updateById
            (String id, PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        domain.setId(id);
        portfolioService.update(domain);
        Portfolio rt = domain;
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * delete_project_set 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "delete_project_set", tags = {"文件夹" },  notes = "Portfolio-delete_project_set ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-delete_project_set-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-delete_project_set')")
    @PostMapping("portfolios/{id}/delete_project_set")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> deleteProjectSetById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteProjectSetById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteProjectSetById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete_project_set 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO deleteProjectSetById
            (String id, PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        domain.setId(id);
        Portfolio rt = portfolioService.deleteProjectSet(domain);
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * favorite 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "favorite", tags = {"文件夹" },  notes = "Portfolio-favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-favorite-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-favorite')")
    @PostMapping("portfolios/{id}/favorite")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * favorite 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO favoriteById
            (String id, PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        domain.setId(id);
        Portfolio rt = portfolioService.favorite(domain);
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * portfolio_index_addon_counter 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "portfolio_index_addon_counter", tags = {"文件夹" },  notes = "Portfolio-portfolio_index_addon_counter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-portfolio_index_addon_counter-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-portfolio_index_addon_counter')")
    @PostMapping("portfolios/{id}/portfolio_index_addon_counter")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> portfolioIndexAddonCounterById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(portfolioIndexAddonCounterById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(portfolioIndexAddonCounterById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * portfolio_index_addon_counter 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO portfolioIndexAddonCounterById
            (String id, PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        domain.setId(id);
        Portfolio rt = portfolioService.portfolioIndexAddonCounter(domain);
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * recover_project_set 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "recover_project_set", tags = {"文件夹" },  notes = "Portfolio-recover_project_set ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-recover_project_set-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-recover_project_set')")
    @PostMapping("portfolios/{id}/recover_project_set")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> recoverProjectSetById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverProjectSetById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverProjectSetById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * recover_project_set 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO recoverProjectSetById
            (String id, PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        domain.setId(id);
        Portfolio rt = portfolioService.recoverProjectSet(domain);
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * remove_from_project_set 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "remove_from_project_set", tags = {"文件夹" },  notes = "Portfolio-remove_from_project_set ")
    @PostMapping("portfolios/remove_from_project_set")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> removeFromProjectSet
            (@Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(removeFromProjectSet(item)));
        else
            rt.set(removeFromProjectSet(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * remove_from_project_set 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO removeFromProjectSet
            (PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        Portfolio rt = portfolioService.removeFromProjectSet(domain);
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * resource_setting 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "resource_setting", tags = {"文件夹" },  notes = "Portfolio-resource_setting ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-resource_setting-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-resource_setting')")
    @PostMapping("portfolios/resource_setting")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> resourceSetting
            (@Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(resourceSetting(item)));
        else
            rt.set(resourceSetting(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * resource_setting 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO resourceSetting
            (PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        Portfolio rt = portfolioService.resourceSetting(domain);
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"文件夹" },  notes = "Portfolio-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Save-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-Save')")
    @PostMapping("portfolios/save")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> save
            (@Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO save
            (PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        portfolioService.save(domain);
        Portfolio rt = domain;
        return portfolioDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "un_favorite", tags = {"文件夹" },  notes = "Portfolio-un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-un_favorite-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-un_favorite')")
    @PostMapping("portfolios/{id}/un_favorite")
    public ResponseEntity<ResponseWrapper<PortfolioDTO>> unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioDTO> dto) {
        ResponseWrapper<PortfolioDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * un_favorite 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */   
    public PortfolioDTO unFavoriteById
            (String id, PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        domain.setId(id);
        Portfolio rt = portfolioService.unFavorite(domain);
        return portfolioDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 文件夹
    * 
    *
    * @param id id
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"文件夹" },  notes = "Portfolio-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Get-all')  or hasPermission(this.portfolioDtoMapping.toDomain(returnObject.body),'ibizplm-Portfolio-Get')")
    @GetMapping("portfolios/{id}")
    public ResponseEntity<PortfolioDTO> getById
            (@PathVariable("id") String id) {
        Portfolio rt = portfolioService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 文件夹
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"文件夹" },  notes = "Portfolio-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Remove-all') or hasPermission(this.portfolioService.get(#id),'ibizplm-Portfolio-Remove')")
    @DeleteMapping("portfolios/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = portfolioService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"文件夹" },  notes = "Portfolio-CheckKey ")
    @PostMapping("portfolios/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        Integer rt = portfolioService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"文件夹" },  notes = "Portfolio-GetDraft ")
    @GetMapping("portfolios/get_draft")
    public ResponseEntity<PortfolioDTO> getDraft
            (@SpringQueryMap PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        Portfolio rt = portfolioService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_admin 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"文件夹" },  notes = "Portfolio-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_admin-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_admin')")
    @PostMapping("portfolios/fetch_admin")
    public ResponseEntity<List<PortfolioDTO>> fetchAdmin
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchAdmin(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_choose_project_portfolio 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_choose_project_portfolio", tags = {"文件夹" },  notes = "Portfolio-fetch_choose_project_portfolio ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_choose_project_portfolio-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_choose_project_portfolio')")
    @PostMapping("portfolios/fetch_choose_project_portfolio")
    public ResponseEntity<List<PortfolioDTO>> fetchChooseProjectPortfolio
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchChooseProjectPortfolio(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"文件夹" },  notes = "Portfolio-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_default-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_default')")
    @PostMapping("portfolios/fetch_default")
    public ResponseEntity<List<PortfolioDTO>> fetchDefault
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchDefault(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_favorite 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_favorite", tags = {"文件夹" },  notes = "Portfolio-fetch_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_favorite-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_favorite')")
    @PostMapping("portfolios/fetch_favorite")
    public ResponseEntity<List<PortfolioDTO>> fetchFavorite
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchFavorite(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_project_set_deleted 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_project_set_deleted", tags = {"文件夹" },  notes = "Portfolio-fetch_project_set_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_project_set_deleted-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_project_set_deleted')")
    @PostMapping("portfolios/fetch_project_set_deleted")
    public ResponseEntity<List<PortfolioDTO>> fetchProjectSetDeleted
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchProjectSetDeleted(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_project_set_going 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_project_set_going", tags = {"文件夹" },  notes = "Portfolio-fetch_project_set_going ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_project_set_going-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_project_set_going')")
    @PostMapping("portfolios/fetch_project_set_going")
    public ResponseEntity<List<PortfolioDTO>> fetchProjectSetGoing
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchProjectSetGoing(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_reader 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"文件夹" },  notes = "Portfolio-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_reader-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_reader')")
    @PostMapping("portfolios/fetch_reader")
    public ResponseEntity<List<PortfolioDTO>> fetchReader
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchReader(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_user 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"文件夹" },  notes = "Portfolio-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_user-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_user')")
    @PostMapping("portfolios/fetch_user")
    public ResponseEntity<List<PortfolioDTO>> fetchUser
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchUser(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_project_portfolio 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询fetch_work_project_portfolio", tags = {"文件夹" },  notes = "Portfolio-fetch_work_project_portfolio ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-fetch_work_project_portfolio-all') or hasPermission(#dto,'ibizplm-Portfolio-fetch_work_project_portfolio')")
    @PostMapping("portfolios/fetch_work_project_portfolio")
    public ResponseEntity<List<PortfolioDTO>> fetchWorkProjectPortfolio
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.fetchWorkProjectPortfolio(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建文件夹
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Portfolio-Create-all')")
    @ApiOperation(value = "批量新建文件夹", tags = {"文件夹" },  notes = "批量新建文件夹")
	@PostMapping("portfolios/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PortfolioDTO> dtos) {
        portfolioService.create(portfolioDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除文件夹
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Portfolio-Remove-all')")
    @ApiOperation(value = "批量删除文件夹", tags = {"文件夹" },  notes = "批量删除文件夹")
	@DeleteMapping("portfolios/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        portfolioService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新文件夹
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Portfolio-Update-all')")
    @ApiOperation(value = "批量更新文件夹", tags = {"文件夹" },  notes = "批量更新文件夹")
	@PutMapping("portfolios/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PortfolioDTO> dtos) {
        portfolioService.update(portfolioDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存文件夹
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Portfolio-Save-all')")
    @ApiOperation(value = "批量保存文件夹", tags = {"文件夹" },  notes = "批量保存文件夹")
	@PostMapping("portfolios/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PortfolioDTO> dtos) {
        portfolioService.save(portfolioDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入文件夹
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Portfolio-Save-all')")
    @ApiOperation(value = "批量导入文件夹", tags = {"文件夹" },  notes = "批量导入文件夹")
	@PostMapping("portfolios/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<PortfolioDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(portfolioService.importData(config,ignoreError,portfolioDtoMapping.toDomain(dtos)));
    }

}
