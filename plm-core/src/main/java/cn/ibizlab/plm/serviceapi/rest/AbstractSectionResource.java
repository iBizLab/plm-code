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
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.service.SectionService;
import cn.ibizlab.plm.core.base.filter.SectionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Section] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSectionResource {

    @Autowired
    public SectionService sectionService;

    @Autowired
    @Lazy
    public SectionDTOMapping sectionDtoMapping;

    @Autowired
    @Lazy
    public SectionFilterDTOMapping sectionFilterDtoMapping;

    /**
    * 创建Create 分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"分组" },  notes = "Section-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Section-Create-all') or hasPermission(this.sectionDtoMapping.toDomain(#dto),'ibizplm-Section-Create')")
    @PostMapping("sections")
    public ResponseEntity<ResponseWrapper<SectionDTO>> create
            (@Validated @RequestBody RequestWrapper<SectionDTO> dto) {
        ResponseWrapper<SectionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */   
    public SectionDTO create
            (SectionDTO dto) {
        Section domain = sectionDtoMapping.toDomain(dto);
        sectionService.create(domain);
        Section rt = domain;
        return sectionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 分组
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"分组" },  notes = "Section-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Section-Update-all') or hasPermission(this.sectionService.get(#id),'ibizplm-Section-Update')")
    @VersionCheck(entity = "section" , versionfield = "updateTime")
    @PutMapping("sections/{id}")
    public ResponseEntity<ResponseWrapper<SectionDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SectionDTO> dto) {
        ResponseWrapper<SectionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 分组
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */   
    public SectionDTO updateById
            (String id, SectionDTO dto) {
        Section domain = sectionDtoMapping.toDomain(dto);
        domain.setId(id);
        sectionService.update(domain);
        Section rt = domain;
        return sectionDtoMapping.toDto(rt);
    }

    /**
    * Delete_section 分组
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */
    @ApiOperation(value = "Delete_section", tags = {"分组" },  notes = "Section-Delete_section ")
    @PostMapping("sections/{id}/delete_section")
    public ResponseEntity<ResponseWrapper<SectionDTO>> deleteSectionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SectionDTO> dto) {
        ResponseWrapper<SectionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteSectionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteSectionById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete_section 分组
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */   
    public SectionDTO deleteSectionById
            (String id, SectionDTO dto) {
        Section domain = sectionDtoMapping.toDomain(dto);
        domain.setId(id);
        Section rt = sectionService.deleteSection(domain);
        return sectionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"分组" },  notes = "Section-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Section-Save-all') or hasPermission(this.sectionDtoMapping.toDomain(#dto),'ibizplm-Section-Save')")
    @PostMapping("sections/save")
    public ResponseEntity<ResponseWrapper<SectionDTO>> save
            (@Validated @RequestBody RequestWrapper<SectionDTO> dto) {
        ResponseWrapper<SectionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */   
    public SectionDTO save
            (SectionDTO dto) {
        Section domain = sectionDtoMapping.toDomain(dto);
        sectionService.save(domain);
        Section rt = domain;
        return sectionDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 分组
    * 
    *
    * @param id id
    * @return ResponseEntity<SectionDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"分组" },  notes = "Section-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Section-Get-all')  or hasPermission(this.sectionDtoMapping.toDomain(returnObject.body),'ibizplm-Section-Get')")
    @GetMapping("sections/{id}")
    public ResponseEntity<SectionDTO> getById
            (@PathVariable("id") String id) {
        Section rt = sectionService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(sectionDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 分组
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"分组" },  notes = "Section-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Section-Remove-all') or hasPermission(this.sectionService.get(#id),'ibizplm-Section-Remove')")
    @DeleteMapping("sections/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = sectionService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"分组" },  notes = "Section-CheckKey ")
    @PostMapping("sections/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SectionDTO dto) {
        Section domain = sectionDtoMapping.toDomain(dto);
        Integer rt = sectionService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SectionDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"分组" },  notes = "Section-GetDraft ")
    @GetMapping("sections/getdraft")
    public ResponseEntity<SectionDTO> getDraft
            (@SpringQueryMap SectionDTO dto) {
        Section domain = sectionDtoMapping.toDomain(dto);
        Section rt = sectionService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sectionDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SectionDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"分组" },  notes = "Section-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Section-FetchDefault-all') or hasPermission(#dto,'ibizplm-Section-FetchDefault')")
    @PostMapping("sections/fetchdefault")
    public ResponseEntity<List<SectionDTO>> fetchDefault
            (@Validated @RequestBody SectionFilterDTO dto) {
        SectionSearchContext context = sectionFilterDtoMapping.toDomain(dto);
        Page<Section> domains = sectionService.searchDefault(context) ;
        List<SectionDTO> list = sectionDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchThis_product_section 分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SectionDTO>>
    */
    @ApiOperation(value = "查询FetchThis_product_section", tags = {"分组" },  notes = "Section-FetchThis_product_section ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Section-FetchThis_product_section-all') or hasPermission(#dto,'ibizplm-Section-FetchThis_product_section')")
    @PostMapping("sections/fetchthis_product_section")
    public ResponseEntity<List<SectionDTO>> fetchThisProductSection
            (@Validated @RequestBody SectionFilterDTO dto) {
        SectionSearchContext context = sectionFilterDtoMapping.toDomain(dto);
        Page<Section> domains = sectionService.searchThisProductSection(context) ;
        List<SectionDTO> list = sectionDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建分组
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Section-Create-all')")
    @ApiOperation(value = "批量新建分组", tags = {"分组" },  notes = "批量新建分组")
	@PostMapping("sections/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SectionDTO> dtos) {
        sectionService.createBatch(sectionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除分组
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Section-Remove-all')")
    @ApiOperation(value = "批量删除分组", tags = {"分组" },  notes = "批量删除分组")
	@DeleteMapping("sections/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sectionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新分组
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Section-Update-all')")
    @ApiOperation(value = "批量更新分组", tags = {"分组" },  notes = "批量更新分组")
	@PutMapping("sections/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SectionDTO> dtos) {
        sectionService.updateBatch(sectionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存分组
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Section-Save-all')")
    @ApiOperation(value = "批量保存分组", tags = {"分组" },  notes = "批量保存分组")
	@PostMapping("sections/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SectionDTO> dtos) {
        sectionService.saveBatch(sectionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入分组
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Section-Save-all')")
    @ApiOperation(value = "批量导入分组", tags = {"分组" },  notes = "批量导入分组")
	@PostMapping("sections/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SectionDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(sectionService.importData(config,ignoreError,sectionDtoMapping.toDomain(dtos)));
    }

}