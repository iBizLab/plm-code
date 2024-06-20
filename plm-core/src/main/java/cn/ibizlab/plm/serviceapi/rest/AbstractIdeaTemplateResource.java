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
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaTemplateService;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaTemplateSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[IdeaTemplate] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractIdeaTemplateResource {

    @Autowired
    public IdeaTemplateService ideaTemplateService;

    @Autowired
    @Lazy
    public IdeaTemplateDTOMapping ideaTemplateDtoMapping;

    @Autowired
    @Lazy
    public IdeaTemplateFilterDTOMapping ideaTemplateFilterDtoMapping;

    /**
    * 创建Create 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"需求模板" },  notes = "IdeaTemplate-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Create-all') or hasPermission(this.ideaTemplateDtoMapping.toDomain(#dto),'ibizplm-IdeaTemplate-Create')")
    @PostMapping("idea_templates")
    public ResponseEntity<ResponseWrapper<IdeaTemplateDTO>> create
            (@Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO create
            (IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        ideaTemplateService.create(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 需求模板
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"需求模板" },  notes = "IdeaTemplate-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Update-all') or hasPermission(this.ideaTemplateService.get(#id),'ibizplm-IdeaTemplate-Update')")
    @VersionCheck(entity = "ideatemplate" , versionfield = "updateTime")
    @PutMapping("idea_templates/{id}")
    public ResponseEntity<ResponseWrapper<IdeaTemplateDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 需求模板
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO updateById
            (String id, IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        domain.setId(id);
        ideaTemplateService.update(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"需求模板" },  notes = "IdeaTemplate-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Save-all') or hasPermission(this.ideaTemplateDtoMapping.toDomain(#dto),'ibizplm-IdeaTemplate-Save')")
    @PostMapping("idea_templates/save")
    public ResponseEntity<ResponseWrapper<IdeaTemplateDTO>> save
            (@Validated @RequestBody RequestWrapper<IdeaTemplateDTO> dto) {
        ResponseWrapper<IdeaTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */   
    public IdeaTemplateDTO save
            (IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        ideaTemplateService.save(domain);
        IdeaTemplate rt = domain;
        return ideaTemplateDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 需求模板
    * 
    *
    * @param id id
    * @return ResponseEntity<IdeaTemplateDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"需求模板" },  notes = "IdeaTemplate-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Get-all')  or hasPermission(this.ideaTemplateDtoMapping.toDomain(returnObject.body),'ibizplm-IdeaTemplate-Get')")
    @GetMapping("idea_templates/{id}")
    public ResponseEntity<IdeaTemplateDTO> getById
            (@PathVariable("id") String id) {
        IdeaTemplate rt = ideaTemplateService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(ideaTemplateDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 需求模板
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"需求模板" },  notes = "IdeaTemplate-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-Remove-all') or hasPermission(this.ideaTemplateService.get(#id),'ibizplm-IdeaTemplate-Remove')")
    @DeleteMapping("idea_templates/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = ideaTemplateService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"需求模板" },  notes = "IdeaTemplate-CheckKey ")
    @PostMapping("idea_templates/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        Integer rt = ideaTemplateService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaTemplateDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"需求模板" },  notes = "IdeaTemplate-GetDraft ")
    @GetMapping("idea_templates/get_draft")
    public ResponseEntity<IdeaTemplateDTO> getDraft
            (@SpringQueryMap IdeaTemplateDTO dto) {
        IdeaTemplate domain = ideaTemplateDtoMapping.toDomain(dto);
        IdeaTemplate rt = ideaTemplateService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ideaTemplateDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 需求模板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaTemplateDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"需求模板" },  notes = "IdeaTemplate-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-IdeaTemplate-fetch_default-all') or hasPermission(#dto,'ibizplm-IdeaTemplate-fetch_default')")
    @PostMapping("idea_templates/fetch_default")
    public ResponseEntity<List<IdeaTemplateDTO>> fetchDefault
            (@Validated @RequestBody IdeaTemplateFilterDTO dto) {
        IdeaTemplateSearchContext context = ideaTemplateFilterDtoMapping.toDomain(dto);
        Page<IdeaTemplate> domains = ideaTemplateService.fetchDefault(context) ;
        List<IdeaTemplateDTO> list = ideaTemplateDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建需求模板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Create-all')")
    @ApiOperation(value = "批量新建需求模板", tags = {"需求模板" },  notes = "批量新建需求模板")
	@PostMapping("idea_templates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IdeaTemplateDTO> dtos) {
        ideaTemplateService.create(ideaTemplateDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除需求模板
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Remove-all')")
    @ApiOperation(value = "批量删除需求模板", tags = {"需求模板" },  notes = "批量删除需求模板")
	@DeleteMapping("idea_templates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ideaTemplateService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新需求模板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Update-all')")
    @ApiOperation(value = "批量更新需求模板", tags = {"需求模板" },  notes = "批量更新需求模板")
	@PutMapping("idea_templates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IdeaTemplateDTO> dtos) {
        ideaTemplateService.update(ideaTemplateDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存需求模板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Save-all')")
    @ApiOperation(value = "批量保存需求模板", tags = {"需求模板" },  notes = "批量保存需求模板")
	@PostMapping("idea_templates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IdeaTemplateDTO> dtos) {
        ideaTemplateService.save(ideaTemplateDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入需求模板
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-IdeaTemplate-Save-all')")
    @ApiOperation(value = "批量导入需求模板", tags = {"需求模板" },  notes = "批量导入需求模板")
	@PostMapping("idea_templates/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<IdeaTemplateDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(ideaTemplateService.importData(config,ignoreError,ideaTemplateDtoMapping.toDomain(dtos)));
    }

}
