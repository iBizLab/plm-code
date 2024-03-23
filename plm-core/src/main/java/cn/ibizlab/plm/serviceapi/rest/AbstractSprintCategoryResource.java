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
import cn.ibizlab.plm.core.projmgmt.domain.SprintCategory;
import cn.ibizlab.plm.core.projmgmt.service.SprintCategoryService;
import cn.ibizlab.plm.core.projmgmt.filter.SprintCategorySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[SprintCategory] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintCategoryResource {

    @Autowired
    public SprintCategoryService sprintCategoryService;

    @Autowired
    @Lazy
    public SprintCategoryDTOMapping sprintCategoryDtoMapping;

    @Autowired
    @Lazy
    public SprintCategoryFilterDTOMapping sprintCategoryFilterDtoMapping;

    /**
    * 创建Create 迭代类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintCategoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代类别" },  notes = "SprintCategory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintCategory-Create-all') or hasPermission(this.sprintCategoryDtoMapping.toDomain(#dto),'ibizplm-SprintCategory-Create')")
    @PostMapping("sprint_categories")
    public ResponseEntity<ResponseWrapper<SprintCategoryDTO>> create
            (@Validated @RequestBody RequestWrapper<SprintCategoryDTO> dto) {
        ResponseWrapper<SprintCategoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 迭代类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintCategoryDTO>
    */   
    public SprintCategoryDTO create
            (SprintCategoryDTO dto) {
        SprintCategory domain = sprintCategoryDtoMapping.toDomain(dto);
        sprintCategoryService.create(domain);
        SprintCategory rt = domain;
        return sprintCategoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintCategoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代类别" },  notes = "SprintCategory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintCategory-Update-all') or hasPermission(this.sprintCategoryService.get(#id),'ibizplm-SprintCategory-Update')")
    @VersionCheck(entity = "sprintcategory" , versionfield = "updateTime")
    @PutMapping("sprint_categories/{id}")
    public ResponseEntity<ResponseWrapper<SprintCategoryDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintCategoryDTO> dto) {
        ResponseWrapper<SprintCategoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 迭代类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintCategoryDTO>
    */   
    public SprintCategoryDTO updateById
            (String id, SprintCategoryDTO dto) {
        SprintCategory domain = sprintCategoryDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintCategoryService.update(domain);
        SprintCategory rt = domain;
        return sprintCategoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintCategoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代类别" },  notes = "SprintCategory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintCategory-Save-all') or hasPermission(this.sprintCategoryDtoMapping.toDomain(#dto),'ibizplm-SprintCategory-Save')")
    @PostMapping("sprint_categories/save")
    public ResponseEntity<ResponseWrapper<SprintCategoryDTO>> save
            (@Validated @RequestBody RequestWrapper<SprintCategoryDTO> dto) {
        ResponseWrapper<SprintCategoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 迭代类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintCategoryDTO>
    */   
    public SprintCategoryDTO save
            (SprintCategoryDTO dto) {
        SprintCategory domain = sprintCategoryDtoMapping.toDomain(dto);
        sprintCategoryService.save(domain);
        SprintCategory rt = domain;
        return sprintCategoryDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 迭代类别
    * 
    *
    * @param id id
    * @return ResponseEntity<SprintCategoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代类别" },  notes = "SprintCategory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintCategory-Get-all')  or hasPermission(this.sprintCategoryDtoMapping.toDomain(returnObject.body),'ibizplm-SprintCategory-Get')")
    @GetMapping("sprint_categories/{id}")
    public ResponseEntity<SprintCategoryDTO> getById
            (@PathVariable("id") String id) {
        SprintCategory rt = sprintCategoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(sprintCategoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 迭代类别
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代类别" },  notes = "SprintCategory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintCategory-Remove-all') or hasPermission(this.sprintCategoryService.get(#id),'ibizplm-SprintCategory-Remove')")
    @DeleteMapping("sprint_categories/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = sprintCategoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 迭代类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代类别" },  notes = "SprintCategory-CheckKey ")
    @PostMapping("sprint_categories/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SprintCategoryDTO dto) {
        SprintCategory domain = sprintCategoryDtoMapping.toDomain(dto);
        Integer rt = sprintCategoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 迭代类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintCategoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代类别" },  notes = "SprintCategory-GetDraft ")
    @GetMapping("sprint_categories/getdraft")
    public ResponseEntity<SprintCategoryDTO> getDraft
            (@SpringQueryMap SprintCategoryDTO dto) {
        SprintCategory domain = sprintCategoryDtoMapping.toDomain(dto);
        SprintCategory rt = sprintCategoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sprintCategoryDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 迭代类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SprintCategoryDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"迭代类别" },  notes = "SprintCategory-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintCategory-FetchDefault-all') or hasPermission(#dto,'ibizplm-SprintCategory-FetchDefault')")
    @PostMapping("sprint_categories/fetchdefault")
    public ResponseEntity<List<SprintCategoryDTO>> fetchDefault
            (@Validated @RequestBody SprintCategoryFilterDTO dto) {
        SprintCategorySearchContext context = sprintCategoryFilterDtoMapping.toDomain(dto);
        Page<SprintCategory> domains = sprintCategoryService.searchDefault(context) ;
        List<SprintCategoryDTO> list = sprintCategoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建迭代类别
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintCategory-Create-all')")
    @ApiOperation(value = "批量新建迭代类别", tags = {"迭代类别" },  notes = "批量新建迭代类别")
	@PostMapping("sprint_categories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SprintCategoryDTO> dtos) {
        sprintCategoryService.createBatch(sprintCategoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除迭代类别
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintCategory-Remove-all')")
    @ApiOperation(value = "批量删除迭代类别", tags = {"迭代类别" },  notes = "批量删除迭代类别")
	@DeleteMapping("sprint_categories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sprintCategoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新迭代类别
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintCategory-Update-all')")
    @ApiOperation(value = "批量更新迭代类别", tags = {"迭代类别" },  notes = "批量更新迭代类别")
	@PutMapping("sprint_categories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SprintCategoryDTO> dtos) {
        sprintCategoryService.updateBatch(sprintCategoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存迭代类别
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintCategory-Save-all')")
    @ApiOperation(value = "批量保存迭代类别", tags = {"迭代类别" },  notes = "批量保存迭代类别")
	@PostMapping("sprint_categories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SprintCategoryDTO> dtos) {
        sprintCategoryService.saveBatch(sprintCategoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入迭代类别
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintCategory-Save-all')")
    @ApiOperation(value = "批量导入迭代类别", tags = {"迭代类别" },  notes = "批量导入迭代类别")
	@PostMapping("sprint_categories/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SprintCategoryDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(sprintCategoryService.importData(config,ignoreError,sprintCategoryDtoMapping.toDomain(dtos)));
    }

}
