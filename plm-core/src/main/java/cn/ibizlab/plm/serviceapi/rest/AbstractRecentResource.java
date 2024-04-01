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
import cn.ibizlab.plm.core.base.domain.Recent;
import cn.ibizlab.plm.core.base.service.RecentService;
import cn.ibizlab.plm.core.base.filter.RecentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Recent] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRecentResource {

    @Autowired
    public RecentService recentService;

    @Autowired
    @Lazy
    public RecentDTOMapping recentDtoMapping;

    @Autowired
    @Lazy
    public RecentFilterDTOMapping recentFilterDtoMapping;

    /**
    * 创建Create 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"最近访问" },  notes = "Recent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Create-all') or hasPermission(this.recentDtoMapping.toDomain(#dto),'ibizplm-Recent-Create')")
    @PostMapping("recents")
    public ResponseEntity<ResponseWrapper<RecentDTO>> create
            (@Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO create
            (RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        recentService.create(domain);
        Recent rt = domain;
        return recentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 最近访问
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"最近访问" },  notes = "Recent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Update-all') or hasPermission(this.recentService.get(#id),'ibizplm-Recent-Update')")
    @VersionCheck(entity = "recent" , versionfield = "updateTime")
    @PutMapping("recents/{id}")
    public ResponseEntity<ResponseWrapper<RecentDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 最近访问
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO updateById
            (String id, RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        domain.setId(id);
        recentService.update(domain);
        Recent rt = domain;
        return recentDtoMapping.toDto(rt);
    }

    /**
    * My_charge_entry 最近访问
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */
    @ApiOperation(value = "My_charge_entry", tags = {"最近访问" },  notes = "Recent-My_charge_entry ")
    @PostMapping("recents/{id}/my_charge_entry")
    public ResponseEntity<ResponseWrapper<RecentDTO>> myChargeEntryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(myChargeEntryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(myChargeEntryById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * My_charge_entry 最近访问
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO myChargeEntryById
            (String id, RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        domain.setId(id);
        Recent rt = recentService.myChargeEntry(domain);
        return recentDtoMapping.toDto(rt);
    }

    /**
    * My_created_entry 最近访问
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */
    @ApiOperation(value = "My_created_entry", tags = {"最近访问" },  notes = "Recent-My_created_entry ")
    @PostMapping("recents/{id}/my_created_entry")
    public ResponseEntity<ResponseWrapper<RecentDTO>> myCreatedEntryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(myCreatedEntryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(myCreatedEntryById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * My_created_entry 最近访问
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO myCreatedEntryById
            (String id, RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        domain.setId(id);
        Recent rt = recentService.myCreatedEntry(domain);
        return recentDtoMapping.toDto(rt);
    }

    /**
    * Recent_clean 最近访问
    * 每天定时清理最近访问数据，每人每个访问类型数据只保留100条
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */
    @ApiOperation(value = "Recent_clean", tags = {"最近访问" },  notes = "Recent-Recent_clean 每天定时清理最近访问数据，每人每个访问类型数据只保留100条")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Recent_clean-all') or hasPermission(this.recentDtoMapping.toDomain(#dto),'ibizplm-Recent-Recent_clean')")
    @PostMapping("recents/{id}/recent_clean")
    public ResponseEntity<ResponseWrapper<RecentDTO>> recentCleanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recentCleanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recentCleanById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Recent_clean 最近访问
    * 每天定时清理最近访问数据，每人每个访问类型数据只保留100条
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO recentCleanById
            (String id, RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        domain.setId(id);
        Recent rt = recentService.recentClean(domain);
        return recentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"最近访问" },  notes = "Recent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Save-all') or hasPermission(this.recentDtoMapping.toDomain(#dto),'ibizplm-Recent-Save')")
    @PostMapping("recents/save")
    public ResponseEntity<ResponseWrapper<RecentDTO>> save
            (@Validated @RequestBody RequestWrapper<RecentDTO> dto) {
        ResponseWrapper<RecentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */   
    public RecentDTO save
            (RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        recentService.save(domain);
        Recent rt = domain;
        return recentDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 最近访问
    * 
    *
    * @param id id
    * @return ResponseEntity<RecentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"最近访问" },  notes = "Recent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Get-all')  or hasPermission(this.recentDtoMapping.toDomain(returnObject.body),'ibizplm-Recent-Get')")
    @GetMapping("recents/{id}")
    public ResponseEntity<RecentDTO> getById
            (@PathVariable("id") String id) {
        Recent rt = recentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(recentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 最近访问
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"最近访问" },  notes = "Recent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-Remove-all') or hasPermission(this.recentService.get(#id),'ibizplm-Recent-Remove')")
    @DeleteMapping("recents/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = recentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"最近访问" },  notes = "Recent-CheckKey ")
    @PostMapping("recents/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        Integer rt = recentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RecentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"最近访问" },  notes = "Recent-GetDraft ")
    @GetMapping("recents/getdraft")
    public ResponseEntity<RecentDTO> getDraft
            (@SpringQueryMap RecentDTO dto) {
        Recent domain = recentDtoMapping.toDomain(dto);
        Recent rt = recentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(recentDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"最近访问" },  notes = "Recent-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-FetchDefault-all') or hasPermission(#dto,'ibizplm-Recent-FetchDefault')")
    @PostMapping("recents/fetchdefault")
    public ResponseEntity<List<RecentDTO>> fetchDefault
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchDefault(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_access 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_access", tags = {"最近访问" },  notes = "Recent-FetchRecent_access ")
    @PostMapping("recents/fetchrecent_access")
    public ResponseEntity<List<RecentDTO>> fetchRecentAccess
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentAccess(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_curproduct_ticket 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_curproduct_ticket", tags = {"最近访问" },  notes = "Recent-FetchRecent_curproduct_ticket ")
    @PostMapping("recents/fetchrecent_curproduct_ticket")
    public ResponseEntity<List<RecentDTO>> fetchRecentCurproductTicket
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentCurproductTicket(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_curproject_child_work_item 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_curproject_child_work_item", tags = {"最近访问" },  notes = "Recent-FetchRecent_curproject_child_work_item ")
    @PostMapping("recents/fetchrecent_curproject_child_work_item")
    public ResponseEntity<List<RecentDTO>> fetchRecentCurprojectChildWorkItem
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentCurprojectChildWorkItem(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_curproject_work_item 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_curproject_work_item", tags = {"最近访问" },  notes = "Recent-FetchRecent_curproject_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-FetchRecent_curproject_work_item-all') or hasPermission(#dto,'ibizplm-Recent-FetchRecent_curproject_work_item')")
    @PostMapping("recents/fetchrecent_curproject_work_item")
    public ResponseEntity<List<RecentDTO>> fetchRecentCurprojectWorkItem
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentCurprojectWorkItem(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_idea 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_idea", tags = {"最近访问" },  notes = "Recent-FetchRecent_idea ")
    @PostMapping("recents/fetchrecent_idea")
    public ResponseEntity<List<RecentDTO>> fetchRecentIdea
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentIdea(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_page 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_page", tags = {"最近访问" },  notes = "Recent-FetchRecent_page ")
    @PostMapping("recents/fetchrecent_page")
    public ResponseEntity<List<RecentDTO>> fetchRecentPage
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentPage(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_project 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_project", tags = {"最近访问" },  notes = "Recent-FetchRecent_project ")
    @PostMapping("recents/fetchrecent_project")
    public ResponseEntity<List<RecentDTO>> fetchRecentProject
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentProject(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_test_case 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_test_case", tags = {"最近访问" },  notes = "Recent-FetchRecent_test_case ")
    @PostMapping("recents/fetchrecent_test_case")
    public ResponseEntity<List<RecentDTO>> fetchRecentTestCase
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentTestCase(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_test_case_index 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_test_case_index", tags = {"最近访问" },  notes = "Recent-FetchRecent_test_case_index ")
    @PostMapping("recents/fetchrecent_test_case_index")
    public ResponseEntity<List<RecentDTO>> fetchRecentTestCaseIndex
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentTestCaseIndex(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_ticket 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_ticket", tags = {"最近访问" },  notes = "Recent-FetchRecent_ticket ")
    @PostMapping("recents/fetchrecent_ticket")
    public ResponseEntity<List<RecentDTO>> fetchRecentTicket
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentTicket(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_use 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_use", tags = {"最近访问" },  notes = "Recent-FetchRecent_use ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-FetchRecent_use-all') or hasPermission(#dto,'ibizplm-Recent-FetchRecent_use')")
    @PostMapping("recents/fetchrecent_use")
    public ResponseEntity<List<RecentDTO>> fetchRecentUse
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentUse(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_work_item 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_work_item", tags = {"最近访问" },  notes = "Recent-FetchRecent_work_item ")
    @PostMapping("recents/fetchrecent_work_item")
    public ResponseEntity<List<RecentDTO>> fetchRecentWorkItem
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentWorkItem(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_work_item_and_nobug 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_work_item_and_nobug", tags = {"最近访问" },  notes = "Recent-FetchRecent_work_item_and_nobug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Recent-FetchRecent_work_item_and_nobug-all') or hasPermission(#dto,'ibizplm-Recent-FetchRecent_work_item_and_nobug')")
    @PostMapping("recents/fetchrecent_work_item_and_nobug")
    public ResponseEntity<List<RecentDTO>> fetchRecentWorkItemAndNobug
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentWorkItemAndNobug(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_work_item_bug 最近访问
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RecentDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_work_item_bug", tags = {"最近访问" },  notes = "Recent-FetchRecent_work_item_bug ")
    @PostMapping("recents/fetchrecent_work_item_bug")
    public ResponseEntity<List<RecentDTO>> fetchRecentWorkItemBug
            (@Validated @RequestBody RecentFilterDTO dto) {
        RecentSearchContext context = recentFilterDtoMapping.toDomain(dto);
        Page<Recent> domains = recentService.searchRecentWorkItemBug(context) ;
        List<RecentDTO> list = recentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建最近访问
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Create-all')")
    @ApiOperation(value = "批量新建最近访问", tags = {"最近访问" },  notes = "批量新建最近访问")
	@PostMapping("recents/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<RecentDTO> dtos) {
        recentService.createBatch(recentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除最近访问
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Remove-all')")
    @ApiOperation(value = "批量删除最近访问", tags = {"最近访问" },  notes = "批量删除最近访问")
	@DeleteMapping("recents/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        recentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新最近访问
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Update-all')")
    @ApiOperation(value = "批量更新最近访问", tags = {"最近访问" },  notes = "批量更新最近访问")
	@PutMapping("recents/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<RecentDTO> dtos) {
        recentService.updateBatch(recentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存最近访问
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Save-all')")
    @ApiOperation(value = "批量保存最近访问", tags = {"最近访问" },  notes = "批量保存最近访问")
	@PostMapping("recents/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<RecentDTO> dtos) {
        recentService.saveBatch(recentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入最近访问
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Recent-Save-all')")
    @ApiOperation(value = "批量导入最近访问", tags = {"最近访问" },  notes = "批量导入最近访问")
	@PostMapping("recents/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RecentDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(recentService.importData(config,ignoreError,recentDtoMapping.toDomain(dtos)));
    }

}
