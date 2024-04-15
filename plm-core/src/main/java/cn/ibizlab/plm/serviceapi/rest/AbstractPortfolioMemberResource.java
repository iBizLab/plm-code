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
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.base.service.PortfolioMemberService;
import cn.ibizlab.plm.core.base.filter.PortfolioMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[PortfolioMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPortfolioMemberResource {

    @Autowired
    public PortfolioMemberService portfolioMemberService;

    @Autowired
    @Lazy
    public PortfolioMemberDTOMapping portfolioMemberDtoMapping;

    @Autowired
    @Lazy
    public PortfolioMemberFilterDTOMapping portfolioMemberFilterDtoMapping;

    /**
    * 创建Create 文件夹成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"文件夹成员" },  notes = "PortfolioMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Create-all') or hasPermission(this.portfolioMemberDtoMapping.toDomain(#dto),'ibizplm-PortfolioMember-Create')")
    @PostMapping("portfolio_members")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> create
            (@Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 文件夹成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO create
            (PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        portfolioMemberService.create(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 文件夹成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"文件夹成员" },  notes = "PortfolioMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Update-all') or hasPermission(this.portfolioMemberService.get(#id),'ibizplm-PortfolioMember-Update')")
    @VersionCheck(entity = "portfoliomember" , versionfield = "updateTime")
    @PutMapping("portfolio_members/{id}")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 文件夹成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO updateById
            (String id, PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        portfolioMemberService.update(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 文件夹成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"文件夹成员" },  notes = "PortfolioMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Save-all') or hasPermission(this.portfolioMemberDtoMapping.toDomain(#dto),'ibizplm-PortfolioMember-Save')")
    @PostMapping("portfolio_members/save")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> save
            (@Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 文件夹成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO save
            (PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        portfolioMemberService.save(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"文件夹成员" },  notes = "PortfolioMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Create-all') or hasPermission('portfolio',#portfolioId,this.portfolioMemberDtoMapping.toDomain(#dto),'ibizplm-PortfolioMember-Create')")
    @PostMapping("portfolios/{portfolioId}/portfolio_members")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> createByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPortfolioId(portfolioId, item)));
        else
            rt.set(createByPortfolioId(portfolioId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO createByPortfolioId
            (String portfolioId, PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        portfolioMemberService.create(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"文件夹成员" },  notes = "PortfolioMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Update-all') or hasPermission('portfolio',#portfolioId,this.portfolioMemberService.get(#id),'ibizplm-PortfolioMember-Update')")
    @VersionCheck(entity = "portfoliomember" , versionfield = "updateTime")
    @PutMapping("portfolios/{portfolioId}/portfolio_members/{id}")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> updateByPortfolioIdAndId
            (@PathVariable("portfolioId") String portfolioId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPortfolioIdAndId(portfolioId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPortfolioIdAndId(portfolioId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO updateByPortfolioIdAndId
            (String portfolioId, String id, PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        portfolioMemberService.update(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"文件夹成员" },  notes = "PortfolioMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Save-all') or hasPermission('portfolio',#portfolioId,this.portfolioMemberDtoMapping.toDomain(#dto),'ibizplm-PortfolioMember-Save')")
    @PostMapping("portfolios/{portfolioId}/portfolio_members/save")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> saveByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPortfolioId(portfolioId, item)));
        else
            rt.set(saveByPortfolioId(portfolioId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO saveByPortfolioId
            (String portfolioId, PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        portfolioMemberService.save(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 文件夹成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"文件夹成员" },  notes = "PortfolioMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Create-all') or hasPermission('user',#userId,this.portfolioMemberDtoMapping.toDomain(#dto),'ibizplm-PortfolioMember-Create')")
    @PostMapping("users/{userId}/portfolio_members")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> createByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByUserId(userId, item)));
        else
            rt.set(createByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 文件夹成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO createByUserId
            (String userId, PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        portfolioMemberService.create(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 文件夹成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"文件夹成员" },  notes = "PortfolioMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Update-all') or hasPermission('user',#userId,this.portfolioMemberService.get(#id),'ibizplm-PortfolioMember-Update')")
    @VersionCheck(entity = "portfoliomember" , versionfield = "updateTime")
    @PutMapping("users/{userId}/portfolio_members/{id}")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> updateByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByUserIdAndId(userId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 文件夹成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO updateByUserIdAndId
            (String userId, String id, PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        portfolioMemberService.update(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 文件夹成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"文件夹成员" },  notes = "PortfolioMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Save-all') or hasPermission('user',#userId,this.portfolioMemberDtoMapping.toDomain(#dto),'ibizplm-PortfolioMember-Save')")
    @PostMapping("users/{userId}/portfolio_members/save")
    public ResponseEntity<ResponseWrapper<PortfolioMemberDTO>> saveByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<PortfolioMemberDTO> dto) {
        ResponseWrapper<PortfolioMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByUserId(userId, item)));
        else
            rt.set(saveByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 文件夹成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */   
    public PortfolioMemberDTO saveByUserId
            (String userId, PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        portfolioMemberService.save(domain);
        PortfolioMember rt = domain;
        return portfolioMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 文件夹成员
    * 
    *
    * @param id id
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"文件夹成员" },  notes = "PortfolioMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Get-all')  or hasPermission(this.portfolioMemberDtoMapping.toDomain(returnObject.body),'ibizplm-PortfolioMember-Get')")
    @GetMapping("portfolio_members/{id}")
    public ResponseEntity<PortfolioMemberDTO> getById
            (@PathVariable("id") String id) {
        PortfolioMember rt = portfolioMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 文件夹成员
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"文件夹成员" },  notes = "PortfolioMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Remove-all') or hasPermission(this.portfolioMemberService.get(#id),'ibizplm-PortfolioMember-Remove')")
    @DeleteMapping("portfolio_members/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = portfolioMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 文件夹成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"文件夹成员" },  notes = "PortfolioMember-CheckKey ")
    @PostMapping("portfolio_members/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        Integer rt = portfolioMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 文件夹成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"文件夹成员" },  notes = "PortfolioMember-GetDraft ")
    @GetMapping("portfolio_members/get_draft")
    public ResponseEntity<PortfolioMemberDTO> getDraft
            (@SpringQueryMap PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        PortfolioMember rt = portfolioMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 文件夹成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PortfolioMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"文件夹成员" },  notes = "PortfolioMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-fetch_default-all') or hasPermission(#dto,'ibizplm-PortfolioMember-fetch_default')")
    @PostMapping("portfolio_members/fetch_default")
    public ResponseEntity<List<PortfolioMemberDTO>> fetchDefault
            (@Validated @RequestBody PortfolioMemberFilterDTO dto) {
        PortfolioMemberSearchContext context = portfolioMemberFilterDtoMapping.toDomain(dto);
        Page<PortfolioMember> domains = portfolioMemberService.searchDefault(context) ;
        List<PortfolioMemberDTO> list = portfolioMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param id id
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"文件夹成员" },  notes = "PortfolioMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Get-all')  or hasPermission('portfolio',#portfolioId,this.portfolioMemberDtoMapping.toDomain(returnObject.body),'ibizplm-PortfolioMember-Get')")
    @GetMapping("portfolios/{portfolioId}/portfolio_members/{id}")
    public ResponseEntity<PortfolioMemberDTO> getByPortfolioIdAndId
            (@PathVariable("portfolioId") String portfolioId, @PathVariable("id") String id) {
        PortfolioMember rt = portfolioMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"文件夹成员" },  notes = "PortfolioMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Remove-all') or hasPermission('portfolio',#portfolioId,this.portfolioMemberService.get(#id),'ibizplm-PortfolioMember-Remove')")
    @DeleteMapping("portfolios/{portfolioId}/portfolio_members/{id}")
    public ResponseEntity<Boolean> removeByPortfolioIdAndId
            (@PathVariable("portfolioId") String portfolioId, @PathVariable("id") String id) {
        Boolean rt = portfolioMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"文件夹成员" },  notes = "PortfolioMember-CheckKey ")
    @PostMapping("portfolios/{portfolioId}/portfolio_members/check_key")
    public ResponseEntity<Integer> checkKeyByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        Integer rt = portfolioMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"文件夹成员" },  notes = "PortfolioMember-GetDraft ")
    @GetMapping("portfolios/{portfolioId}/portfolio_members/get_draft")
    public ResponseEntity<PortfolioMemberDTO> getDraftByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @SpringQueryMap PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setPortfolioId(portfolioId);
        PortfolioMember rt = portfolioMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 文件夹成员
    * 
    *
    * @param portfolioId portfolioId
    * @param dto dto
    * @return ResponseEntity<List<PortfolioMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"文件夹成员" },  notes = "PortfolioMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-fetch_default-all') or hasPermission('portfolio',#portfolioId,#dto,'ibizplm-PortfolioMember-fetch_default')")
    @PostMapping("portfolios/{portfolioId}/portfolio_members/fetch_default")
    public ResponseEntity<List<PortfolioMemberDTO>> fetchDefaultByPortfolioId
            (@PathVariable("portfolioId") String portfolioId, @Validated @RequestBody PortfolioMemberFilterDTO dto) {
        dto.setPortfolioIdEQ(portfolioId);
        PortfolioMemberSearchContext context = portfolioMemberFilterDtoMapping.toDomain(dto);
        Page<PortfolioMember> domains = portfolioMemberService.searchDefault(context) ;
        List<PortfolioMemberDTO> list = portfolioMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 文件夹成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"文件夹成员" },  notes = "PortfolioMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Get-all')  or hasPermission('user',#userId,this.portfolioMemberDtoMapping.toDomain(returnObject.body),'ibizplm-PortfolioMember-Get')")
    @GetMapping("users/{userId}/portfolio_members/{id}")
    public ResponseEntity<PortfolioMemberDTO> getByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        PortfolioMember rt = portfolioMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 文件夹成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"文件夹成员" },  notes = "PortfolioMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-Remove-all') or hasPermission('user',#userId,this.portfolioMemberService.get(#id),'ibizplm-PortfolioMember-Remove')")
    @DeleteMapping("users/{userId}/portfolio_members/{id}")
    public ResponseEntity<Boolean> removeByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = portfolioMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 文件夹成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"文件夹成员" },  notes = "PortfolioMember-CheckKey ")
    @PostMapping("users/{userId}/portfolio_members/check_key")
    public ResponseEntity<Integer> checkKeyByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        Integer rt = portfolioMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 文件夹成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<PortfolioMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"文件夹成员" },  notes = "PortfolioMember-GetDraft ")
    @GetMapping("users/{userId}/portfolio_members/get_draft")
    public ResponseEntity<PortfolioMemberDTO> getDraftByUserId
            (@PathVariable("userId") String userId, @SpringQueryMap PortfolioMemberDTO dto) {
        PortfolioMember domain = portfolioMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        PortfolioMember rt = portfolioMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(portfolioMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 文件夹成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<PortfolioMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"文件夹成员" },  notes = "PortfolioMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PortfolioMember-fetch_default-all') or hasPermission('user',#userId,#dto,'ibizplm-PortfolioMember-fetch_default')")
    @PostMapping("users/{userId}/portfolio_members/fetch_default")
    public ResponseEntity<List<PortfolioMemberDTO>> fetchDefaultByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody PortfolioMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        PortfolioMemberSearchContext context = portfolioMemberFilterDtoMapping.toDomain(dto);
        Page<PortfolioMember> domains = portfolioMemberService.searchDefault(context) ;
        List<PortfolioMemberDTO> list = portfolioMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建文件夹成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PortfolioMember-Create-all')")
    @ApiOperation(value = "批量新建文件夹成员", tags = {"文件夹成员" },  notes = "批量新建文件夹成员")
	@PostMapping("portfolio_members/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PortfolioMemberDTO> dtos) {
        portfolioMemberService.createBatch(portfolioMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除文件夹成员
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PortfolioMember-Remove-all')")
    @ApiOperation(value = "批量删除文件夹成员", tags = {"文件夹成员" },  notes = "批量删除文件夹成员")
	@DeleteMapping("portfolio_members/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        portfolioMemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新文件夹成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PortfolioMember-Update-all')")
    @ApiOperation(value = "批量更新文件夹成员", tags = {"文件夹成员" },  notes = "批量更新文件夹成员")
	@PutMapping("portfolio_members/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PortfolioMemberDTO> dtos) {
        portfolioMemberService.updateBatch(portfolioMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存文件夹成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PortfolioMember-Save-all')")
    @ApiOperation(value = "批量保存文件夹成员", tags = {"文件夹成员" },  notes = "批量保存文件夹成员")
	@PostMapping("portfolio_members/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PortfolioMemberDTO> dtos) {
        portfolioMemberService.saveBatch(portfolioMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入文件夹成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PortfolioMember-Save-all')")
    @ApiOperation(value = "批量导入文件夹成员", tags = {"文件夹成员" },  notes = "批量导入文件夹成员")
	@PostMapping("portfolio_members/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<PortfolioMemberDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(portfolioMemberService.importData(config,ignoreError,portfolioMemberDtoMapping.toDomain(dtos)));
    }

}
