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
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.projmgmt.service.BaselineWorkItemService;
import cn.ibizlab.plm.core.projmgmt.filter.BaselineWorkItemSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[BaselineWorkItem] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineWorkItemResource {

    @Autowired
    public BaselineWorkItemService baselineWorkItemService;

    @Autowired
    @Lazy
    public BaselineWorkItemDTOMapping baselineWorkItemDtoMapping;

    @Autowired
    @Lazy
    public BaselineWorkItemFilterDTOMapping baselineWorkItemFilterDtoMapping;

    /**
    * 创建Create 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"基线工作项" },  notes = "BaselineWorkItem-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineWorkItem-Create-all') or hasPermission(this.baselineWorkItemDtoMapping.toDomain(#dto),'ibizplm-BaselineWorkItem-Create')")
    @PostMapping("baseline_work_items")
    public ResponseEntity<ResponseWrapper<BaselineWorkItemDTO>> create
            (@Validated @RequestBody RequestWrapper<BaselineWorkItemDTO> dto) {
        ResponseWrapper<BaselineWorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */   
    public BaselineWorkItemDTO create
            (BaselineWorkItemDTO dto) {
        BaselineWorkItem domain = baselineWorkItemDtoMapping.toDomain(dto);
        baselineWorkItemService.create(domain);
        BaselineWorkItem rt = domain;
        return baselineWorkItemDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 基线工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"基线工作项" },  notes = "BaselineWorkItem-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineWorkItem-Update-all') or hasPermission(this.baselineWorkItemService.get(#id),'ibizplm-BaselineWorkItem-Update')")
    @VersionCheck(entity = "baselineworkitem" , versionfield = "updateTime")
    @PutMapping("baseline_work_items/{id}")
    public ResponseEntity<ResponseWrapper<BaselineWorkItemDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineWorkItemDTO> dto) {
        ResponseWrapper<BaselineWorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 基线工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */   
    public BaselineWorkItemDTO updateById
            (String id, BaselineWorkItemDTO dto) {
        BaselineWorkItem domain = baselineWorkItemDtoMapping.toDomain(dto);
        domain.setId(id);
        baselineWorkItemService.update(domain);
        BaselineWorkItem rt = domain;
        return baselineWorkItemDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"基线工作项" },  notes = "BaselineWorkItem-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineWorkItem-Save-all') or hasPermission(this.baselineWorkItemDtoMapping.toDomain(#dto),'ibizplm-BaselineWorkItem-Save')")
    @PostMapping("baseline_work_items/save")
    public ResponseEntity<ResponseWrapper<BaselineWorkItemDTO>> save
            (@Validated @RequestBody RequestWrapper<BaselineWorkItemDTO> dto) {
        ResponseWrapper<BaselineWorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */   
    public BaselineWorkItemDTO save
            (BaselineWorkItemDTO dto) {
        BaselineWorkItem domain = baselineWorkItemDtoMapping.toDomain(dto);
        baselineWorkItemService.save(domain);
        BaselineWorkItem rt = domain;
        return baselineWorkItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_baseline 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */
    @ApiOperation(value = "shift_in_baseline", tags = {"基线工作项" },  notes = "BaselineWorkItem-shift_in_baseline ")
    @PostMapping("baseline_work_items/shift_in_baseline")
    public ResponseEntity<ResponseWrapper<BaselineWorkItemDTO>> shiftInBaseline
            (@Validated @RequestBody RequestWrapper<BaselineWorkItemDTO> dto) {
        ResponseWrapper<BaselineWorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftInBaseline(item)));
        else
            rt.set(shiftInBaseline(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * shift_in_baseline 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */   
    public BaselineWorkItemDTO shiftInBaseline
            (BaselineWorkItemDTO dto) {
        BaselineWorkItem domain = baselineWorkItemDtoMapping.toDomain(dto);
        BaselineWorkItem rt = baselineWorkItemService.shiftInBaseline(domain);
        return baselineWorkItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_baseline 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */
    @ApiOperation(value = "shift_out_baseline", tags = {"基线工作项" },  notes = "BaselineWorkItem-shift_out_baseline ")
    @PostMapping("baseline_work_items/shift_out_baseline")
    public ResponseEntity<ResponseWrapper<BaselineWorkItemDTO>> shiftOutBaseline
            (@Validated @RequestBody RequestWrapper<BaselineWorkItemDTO> dto) {
        ResponseWrapper<BaselineWorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftOutBaseline(item)));
        else
            rt.set(shiftOutBaseline(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * shift_out_baseline 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */   
    public BaselineWorkItemDTO shiftOutBaseline
            (BaselineWorkItemDTO dto) {
        BaselineWorkItem domain = baselineWorkItemDtoMapping.toDomain(dto);
        BaselineWorkItem rt = baselineWorkItemService.shiftOutBaseline(domain);
        return baselineWorkItemDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 基线工作项
    * 
    *
    * @param id id
    * @return ResponseEntity<BaselineWorkItemDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"基线工作项" },  notes = "BaselineWorkItem-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineWorkItem-Get-all')  or hasPermission(this.baselineWorkItemDtoMapping.toDomain(returnObject.body),'ibizplm-BaselineWorkItem-Get')")
    @GetMapping("baseline_work_items/{id}")
    public ResponseEntity<BaselineWorkItemDTO> getById
            (@PathVariable("id") String id) {
        BaselineWorkItem rt = baselineWorkItemService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(baselineWorkItemDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 基线工作项
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"基线工作项" },  notes = "BaselineWorkItem-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineWorkItem-Remove-all') or hasPermission(this.baselineWorkItemService.get(#id),'ibizplm-BaselineWorkItem-Remove')")
    @DeleteMapping("baseline_work_items/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = baselineWorkItemService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"基线工作项" },  notes = "BaselineWorkItem-CheckKey ")
    @PostMapping("baseline_work_items/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody BaselineWorkItemDTO dto) {
        BaselineWorkItem domain = baselineWorkItemDtoMapping.toDomain(dto);
        Integer rt = baselineWorkItemService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineWorkItemDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"基线工作项" },  notes = "BaselineWorkItem-GetDraft ")
    @GetMapping("baseline_work_items/get_draft")
    public ResponseEntity<BaselineWorkItemDTO> getDraft
            (@SpringQueryMap BaselineWorkItemDTO dto) {
        BaselineWorkItem domain = baselineWorkItemDtoMapping.toDomain(dto);
        BaselineWorkItem rt = baselineWorkItemService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(baselineWorkItemDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<BaselineWorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"基线工作项" },  notes = "BaselineWorkItem-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineWorkItem-fetch_default-all') or hasPermission(#dto,'ibizplm-BaselineWorkItem-fetch_default')")
    @PostMapping("baseline_work_items/fetch_default")
    public ResponseEntity<List<BaselineWorkItemDTO>> fetchDefault
            (@Validated @RequestBody BaselineWorkItemFilterDTO dto) {
        BaselineWorkItemSearchContext context = baselineWorkItemFilterDtoMapping.toDomain(dto);
        Page<BaselineWorkItem> domains = baselineWorkItemService.searchDefault(context) ;
        List<BaselineWorkItemDTO> list = baselineWorkItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_fill_version_data 基线工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<BaselineWorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_fill_version_data", tags = {"基线工作项" },  notes = "BaselineWorkItem-fetch_fill_version_data ")
    @PostMapping("baseline_work_items/fetch_fill_version_data")
    public ResponseEntity<List<BaselineWorkItemDTO>> fetchFillVersionData
            (@Validated @RequestBody BaselineWorkItemFilterDTO dto) {
        BaselineWorkItemSearchContext context = baselineWorkItemFilterDtoMapping.toDomain(dto);
        Page<BaselineWorkItem> domains = baselineWorkItemService.searchFillVersionData(context) ;
        List<BaselineWorkItemDTO> list = baselineWorkItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建基线工作项
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineWorkItem-Create-all')")
    @ApiOperation(value = "批量新建基线工作项", tags = {"基线工作项" },  notes = "批量新建基线工作项")
	@PostMapping("baseline_work_items/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<BaselineWorkItemDTO> dtos) {
        baselineWorkItemService.createBatch(baselineWorkItemDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除基线工作项
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineWorkItem-Remove-all')")
    @ApiOperation(value = "批量删除基线工作项", tags = {"基线工作项" },  notes = "批量删除基线工作项")
	@DeleteMapping("baseline_work_items/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        baselineWorkItemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新基线工作项
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineWorkItem-Update-all')")
    @ApiOperation(value = "批量更新基线工作项", tags = {"基线工作项" },  notes = "批量更新基线工作项")
	@PutMapping("baseline_work_items/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<BaselineWorkItemDTO> dtos) {
        baselineWorkItemService.updateBatch(baselineWorkItemDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存基线工作项
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineWorkItem-Save-all')")
    @ApiOperation(value = "批量保存基线工作项", tags = {"基线工作项" },  notes = "批量保存基线工作项")
	@PostMapping("baseline_work_items/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<BaselineWorkItemDTO> dtos) {
        baselineWorkItemService.saveBatch(baselineWorkItemDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入基线工作项
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineWorkItem-Save-all')")
    @ApiOperation(value = "批量导入基线工作项", tags = {"基线工作项" },  notes = "批量导入基线工作项")
	@PostMapping("baseline_work_items/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<BaselineWorkItemDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(baselineWorkItemService.importData(config,ignoreError,baselineWorkItemDtoMapping.toDomain(dtos)));
    }

}
