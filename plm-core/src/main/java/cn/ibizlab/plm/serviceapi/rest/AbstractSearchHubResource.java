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
import cn.ibizlab.plm.core.ftr.domain.SearchHub;
import cn.ibizlab.plm.core.ftr.service.SearchHubService;
import cn.ibizlab.plm.core.ftr.filter.SearchHubSearchContext;

/**
 * 实体[SearchHub] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSearchHubResource {

    @Autowired
    public SearchHubService searchHubService;

    @Autowired
    @Lazy
    public SearchHubDTOMapping searchHubDtoMapping;

    @Autowired
    @Lazy
    public SearchHubFilterDTOMapping searchHubFilterDtoMapping;

    /**
    * 创建Create 检索中心
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SearchHubDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"检索中心" },  notes = "SearchHub-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchHub-Create-all')")
    @PostMapping("search_hubs")
    public ResponseEntity<ResponseWrapper<SearchHubDTO>> create
            (@Validated @RequestBody RequestWrapper<SearchHubDTO> dto) {
        ResponseWrapper<SearchHubDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 检索中心
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SearchHubDTO>
    */   
    public SearchHubDTO create
            (SearchHubDTO dto) {
        SearchHub domain = searchHubDtoMapping.toDomain(dto);
        searchHubService.create(domain);
        SearchHub rt = domain;
        return searchHubDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 检索中心
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SearchHubDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"检索中心" },  notes = "SearchHub-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchHub-Update-all')")
    @PutMapping("search_hubs/{id}")
    public ResponseEntity<ResponseWrapper<SearchHubDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SearchHubDTO> dto) {
        ResponseWrapper<SearchHubDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 检索中心
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SearchHubDTO>
    */   
    public SearchHubDTO updateById
            (String id, SearchHubDTO dto) {
        SearchHub domain = searchHubDtoMapping.toDomain(dto);
        domain.setId(id);
        searchHubService.update(domain);
        SearchHub rt = domain;
        return searchHubDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 检索中心
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SearchHubDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"检索中心" },  notes = "SearchHub-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchHub-Save-all')")
    @PostMapping("search_hubs/save")
    public ResponseEntity<ResponseWrapper<SearchHubDTO>> save
            (@Validated @RequestBody RequestWrapper<SearchHubDTO> dto) {
        ResponseWrapper<SearchHubDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 检索中心
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SearchHubDTO>
    */   
    public SearchHubDTO save
            (SearchHubDTO dto) {
        SearchHub domain = searchHubDtoMapping.toDomain(dto);
        searchHubService.save(domain);
        SearchHub rt = domain;
        return searchHubDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 检索中心
    * 
    *
    * @param id id
    * @return ResponseEntity<SearchHubDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"检索中心" },  notes = "SearchHub-Get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchHub-Get-all')")
    @GetMapping("search_hubs/{id}")
    public ResponseEntity<SearchHubDTO> getById
            (@PathVariable("id") String id) {
        SearchHub rt = searchHubService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(searchHubDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 检索中心
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"检索中心" },  notes = "SearchHub-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchHub-Remove-all')")
    @DeleteMapping("search_hubs/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = searchHubService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 检索中心
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"检索中心" },  notes = "SearchHub-CheckKey ")
    @PostMapping("search_hubs/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SearchHubDTO dto) {
        SearchHub domain = searchHubDtoMapping.toDomain(dto);
        Integer rt = searchHubService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 检索中心
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SearchHubDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"检索中心" },  notes = "SearchHub-GetDraft ")
    @GetMapping("search_hubs/getdraft")
    public ResponseEntity<SearchHubDTO> getDraft
            (@SpringQueryMap SearchHubDTO dto) {
        SearchHub domain = searchHubDtoMapping.toDomain(dto);
        SearchHub rt = searchHubService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(searchHubDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 检索中心
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SearchHubDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"检索中心" },  notes = "SearchHub-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchHub-FetchDefault-all')")
    @PostMapping("search_hubs/fetchdefault")
    public ResponseEntity<List<SearchHubDTO>> fetchDefault
            (@Validated @RequestBody SearchHubFilterDTO dto) {
        SearchHubSearchContext context = searchHubFilterDtoMapping.toDomain(dto);
        Page<SearchHub> domains = searchHubService.searchDefault(context) ;
        List<SearchHubDTO> list = searchHubDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建检索中心
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SearchHub-Create-all')")
    @ApiOperation(value = "批量新建检索中心", tags = {"检索中心" },  notes = "批量新建检索中心")
	@PostMapping("search_hubs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SearchHubDTO> dtos) {
        searchHubService.createBatch(searchHubDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除检索中心
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SearchHub-Remove-all')")
    @ApiOperation(value = "批量删除检索中心", tags = {"检索中心" },  notes = "批量删除检索中心")
	@DeleteMapping("search_hubs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        searchHubService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新检索中心
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SearchHub-Update-all')")
    @ApiOperation(value = "批量更新检索中心", tags = {"检索中心" },  notes = "批量更新检索中心")
	@PutMapping("search_hubs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SearchHubDTO> dtos) {
        searchHubService.updateBatch(searchHubDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存检索中心
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SearchHub-Save-all')")
    @ApiOperation(value = "批量保存检索中心", tags = {"检索中心" },  notes = "批量保存检索中心")
	@PostMapping("search_hubs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SearchHubDTO> dtos) {
        searchHubService.saveBatch(searchHubDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入检索中心
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SearchHub-Save-all')")
    @ApiOperation(value = "批量导入检索中心", tags = {"检索中心" },  notes = "批量导入检索中心")
	@PostMapping("search_hubs/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SearchHubDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(searchHubService.importData(config,ignoreError,searchHubDtoMapping.toDomain(dtos)));
    }

}
