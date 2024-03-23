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
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.core.wiki.service.PageVersionService;
import cn.ibizlab.plm.core.wiki.filter.PageVersionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[PageVersion] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPageVersionResource {

    @Autowired
    public PageVersionService pageVersionService;

    @Autowired
    @Lazy
    public PageVersionDTOMapping pageVersionDtoMapping;

    @Autowired
    @Lazy
    public PageVersionFilterDTOMapping pageVersionFilterDtoMapping;

    /**
    * 创建Create 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"页面版本" },  notes = "PageVersion-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Create-all') or hasPermission(this.pageVersionDtoMapping.toDomain(#dto),'ibizplm-PageVersion-Create')")
    @PostMapping("page_versions")
    public ResponseEntity<ResponseWrapper<PageVersionDTO>> create
            (@Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO create
            (PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        pageVersionService.create(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 页面版本
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"页面版本" },  notes = "PageVersion-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Update-all') or hasPermission(this.pageVersionService.get(#id),'ibizplm-PageVersion-Update')")
    @VersionCheck(entity = "pageversion" , versionfield = "updateTime")
    @PutMapping("page_versions/{id}")
    public ResponseEntity<ResponseWrapper<PageVersionDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 页面版本
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO updateById
            (String id, PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        domain.setId(id);
        pageVersionService.update(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"页面版本" },  notes = "PageVersion-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Save-all') or hasPermission(this.pageVersionDtoMapping.toDomain(#dto),'ibizplm-PageVersion-Save')")
    @PostMapping("page_versions/save")
    public ResponseEntity<ResponseWrapper<PageVersionDTO>> save
            (@Validated @RequestBody RequestWrapper<PageVersionDTO> dto) {
        ResponseWrapper<PageVersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */   
    public PageVersionDTO save
            (PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        pageVersionService.save(domain);
        PageVersion rt = domain;
        return pageVersionDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 页面版本
    * 
    *
    * @param id id
    * @return ResponseEntity<PageVersionDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"页面版本" },  notes = "PageVersion-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Get-all')  or hasPermission(this.pageVersionDtoMapping.toDomain(returnObject.body),'ibizplm-PageVersion-Get')")
    @GetMapping("page_versions/{id}")
    public ResponseEntity<PageVersionDTO> getById
            (@PathVariable("id") String id) {
        PageVersion rt = pageVersionService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(pageVersionDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 页面版本
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面版本" },  notes = "PageVersion-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-Remove-all') or hasPermission(this.pageVersionService.get(#id),'ibizplm-PageVersion-Remove')")
    @DeleteMapping("page_versions/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = pageVersionService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面版本" },  notes = "PageVersion-CheckKey ")
    @PostMapping("page_versions/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        Integer rt = pageVersionService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PageVersionDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面版本" },  notes = "PageVersion-GetDraft ")
    @GetMapping("page_versions/getdraft")
    public ResponseEntity<PageVersionDTO> getDraft
            (@SpringQueryMap PageVersionDTO dto) {
        PageVersion domain = pageVersionDtoMapping.toDomain(dto);
        PageVersion rt = pageVersionService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pageVersionDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 页面版本
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<PageVersionDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"页面版本" },  notes = "PageVersion-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-PageVersion-FetchDefault-all') or hasPermission(#dto,'ibizplm-PageVersion-FetchDefault')")
    @PostMapping("page_versions/fetchdefault")
    public ResponseEntity<List<PageVersionDTO>> fetchDefault
            (@Validated @RequestBody PageVersionFilterDTO dto) {
        PageVersionSearchContext context = pageVersionFilterDtoMapping.toDomain(dto);
        Page<PageVersion> domains = pageVersionService.searchDefault(context) ;
        List<PageVersionDTO> list = pageVersionDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建页面版本
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Create-all')")
    @ApiOperation(value = "批量新建页面版本", tags = {"页面版本" },  notes = "批量新建页面版本")
	@PostMapping("page_versions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PageVersionDTO> dtos) {
        pageVersionService.createBatch(pageVersionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除页面版本
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Remove-all')")
    @ApiOperation(value = "批量删除页面版本", tags = {"页面版本" },  notes = "批量删除页面版本")
	@DeleteMapping("page_versions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pageVersionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新页面版本
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Update-all')")
    @ApiOperation(value = "批量更新页面版本", tags = {"页面版本" },  notes = "批量更新页面版本")
	@PutMapping("page_versions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PageVersionDTO> dtos) {
        pageVersionService.updateBatch(pageVersionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存页面版本
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Save-all')")
    @ApiOperation(value = "批量保存页面版本", tags = {"页面版本" },  notes = "批量保存页面版本")
	@PostMapping("page_versions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PageVersionDTO> dtos) {
        pageVersionService.saveBatch(pageVersionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入页面版本
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-PageVersion-Save-all')")
    @ApiOperation(value = "批量导入页面版本", tags = {"页面版本" },  notes = "批量导入页面版本")
	@PostMapping("page_versions/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<PageVersionDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(pageVersionService.importData(config,ignoreError,pageVersionDtoMapping.toDomain(dtos)));
    }

}
