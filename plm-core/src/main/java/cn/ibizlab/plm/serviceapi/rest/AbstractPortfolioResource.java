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
    * Delete_project_set 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "Delete_project_set", tags = {"文件夹" },  notes = "Portfolio-Delete_project_set ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Delete_project_set-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-Delete_project_set')")
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
    * Delete_project_set 文件夹
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
    * Favorite 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "Favorite", tags = {"文件夹" },  notes = "Portfolio-Favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Favorite-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-Favorite')")
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
    * Favorite 文件夹
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
    * Recover_project_set 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "Recover_project_set", tags = {"文件夹" },  notes = "Portfolio-Recover_project_set ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Recover_project_set-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-Recover_project_set')")
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
    * Recover_project_set 文件夹
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
    * Remove_from_project_set 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "Remove_from_project_set", tags = {"文件夹" },  notes = "Portfolio-Remove_from_project_set ")
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
    * Remove_from_project_set 文件夹
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
    * Un_favorite 文件夹
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioDTO>
    */
    @ApiOperation(value = "Un_favorite", tags = {"文件夹" },  notes = "Portfolio-Un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-Un_favorite-all') or hasPermission(this.portfolioDtoMapping.toDomain(#dto),'ibizplm-Portfolio-Un_favorite')")
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
    * Un_favorite 文件夹
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
    @PostMapping("portfolios/checkkey")
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
    @GetMapping("portfolios/getdraft")
    public ResponseEntity<PortfolioDTO> getDraft
            (@SpringQueryMap PortfolioDTO dto) {
        Portfolio domain = portfolioDtoMapping.toDomain(dto);
        Portfolio rt = portfolioService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchAdmin 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询FetchAdmin", tags = {"文件夹" },  notes = "Portfolio-FetchAdmin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-FetchAdmin-all') or hasPermission(#dto,'ibizplm-Portfolio-FetchAdmin')")
    @PostMapping("portfolios/fetchadmin")
    public ResponseEntity<List<PortfolioDTO>> fetchAdmin
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.searchAdmin(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchChoose_project_portfolio 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询FetchChoose_project_portfolio", tags = {"文件夹" },  notes = "Portfolio-FetchChoose_project_portfolio ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-FetchChoose_project_portfolio-all') or hasPermission(#dto,'ibizplm-Portfolio-FetchChoose_project_portfolio')")
    @PostMapping("portfolios/fetchchoose_project_portfolio")
    public ResponseEntity<List<PortfolioDTO>> fetchChooseProjectPortfolio
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.searchChooseProjectPortfolio(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"文件夹" },  notes = "Portfolio-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-FetchDefault-all') or hasPermission(#dto,'ibizplm-Portfolio-FetchDefault')")
    @PostMapping("portfolios/fetchdefault")
    public ResponseEntity<List<PortfolioDTO>> fetchDefault
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.searchDefault(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchFavorite 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询FetchFavorite", tags = {"文件夹" },  notes = "Portfolio-FetchFavorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-FetchFavorite-all') or hasPermission(#dto,'ibizplm-Portfolio-FetchFavorite')")
    @PostMapping("portfolios/fetchfavorite")
    public ResponseEntity<List<PortfolioDTO>> fetchFavorite
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.searchFavorite(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchProject_set_deleted 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询FetchProject_set_deleted", tags = {"文件夹" },  notes = "Portfolio-FetchProject_set_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-FetchProject_set_deleted-all') or hasPermission(#dto,'ibizplm-Portfolio-FetchProject_set_deleted')")
    @PostMapping("portfolios/fetchproject_set_deleted")
    public ResponseEntity<List<PortfolioDTO>> fetchProjectSetDeleted
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.searchProjectSetDeleted(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchProject_set_going 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询FetchProject_set_going", tags = {"文件夹" },  notes = "Portfolio-FetchProject_set_going ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-FetchProject_set_going-all') or hasPermission(#dto,'ibizplm-Portfolio-FetchProject_set_going')")
    @PostMapping("portfolios/fetchproject_set_going")
    public ResponseEntity<List<PortfolioDTO>> fetchProjectSetGoing
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.searchProjectSetGoing(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchUser 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询FetchUser", tags = {"文件夹" },  notes = "Portfolio-FetchUser ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-FetchUser-all') or hasPermission(#dto,'ibizplm-Portfolio-FetchUser')")
    @PostMapping("portfolios/fetchuser")
    public ResponseEntity<List<PortfolioDTO>> fetchUser
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.searchUser(context) ;
        List<PortfolioDTO> list = portfolioDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchWork_project_portfolio 文件夹
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioDTO>>
    */
    @ApiOperation(value = "查询FetchWork_project_portfolio", tags = {"文件夹" },  notes = "Portfolio-FetchWork_project_portfolio ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Portfolio-FetchWork_project_portfolio-all') or hasPermission(#dto,'ibizplm-Portfolio-FetchWork_project_portfolio')")
    @PostMapping("portfolios/fetchwork_project_portfolio")
    public ResponseEntity<List<PortfolioDTO>> fetchWorkProjectPortfolio
            (@Validated @RequestBody PortfolioFilterDTO dto) {
        PortfolioSearchContext context = portfolioFilterDtoMapping.toDomain(dto);
        Page<Portfolio> domains = portfolioService.searchWorkProjectPortfolio(context) ;
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
        portfolioService.createBatch(portfolioDtoMapping.toDomain(dtos));
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
        portfolioService.removeBatch(ids);
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
        portfolioService.updateBatch(portfolioDtoMapping.toDomain(dtos));
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
        portfolioService.saveBatch(portfolioDtoMapping.toDomain(dtos));
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
