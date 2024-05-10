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
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.testmgmt.service.BaselineTestCaseService;
import cn.ibizlab.plm.core.testmgmt.filter.BaselineTestCaseSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[BaselineTestCase] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineTestCaseResource {

    @Autowired
    public BaselineTestCaseService baselineTestCaseService;

    @Autowired
    @Lazy
    public BaselineTestCaseDTOMapping baselineTestCaseDtoMapping;

    @Autowired
    @Lazy
    public BaselineTestCaseFilterDTOMapping baselineTestCaseFilterDtoMapping;

    /**
    * 创建Create 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"基线用例" },  notes = "BaselineTestCase-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineTestCase-Create-all') or hasPermission(this.baselineTestCaseDtoMapping.toDomain(#dto),'ibizplm-BaselineTestCase-Create')")
    @PostMapping("baseline_test_cases")
    public ResponseEntity<ResponseWrapper<BaselineTestCaseDTO>> create
            (@Validated @RequestBody RequestWrapper<BaselineTestCaseDTO> dto) {
        ResponseWrapper<BaselineTestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */   
    public BaselineTestCaseDTO create
            (BaselineTestCaseDTO dto) {
        BaselineTestCase domain = baselineTestCaseDtoMapping.toDomain(dto);
        baselineTestCaseService.create(domain);
        BaselineTestCase rt = domain;
        return baselineTestCaseDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 基线用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"基线用例" },  notes = "BaselineTestCase-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineTestCase-Update-all') or hasPermission(this.baselineTestCaseService.get(#id),'ibizplm-BaselineTestCase-Update')")
    @VersionCheck(entity = "baselinetestcase" , versionfield = "updateTime")
    @PutMapping("baseline_test_cases/{id}")
    public ResponseEntity<ResponseWrapper<BaselineTestCaseDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineTestCaseDTO> dto) {
        ResponseWrapper<BaselineTestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 基线用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */   
    public BaselineTestCaseDTO updateById
            (String id, BaselineTestCaseDTO dto) {
        BaselineTestCase domain = baselineTestCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        baselineTestCaseService.update(domain);
        BaselineTestCase rt = domain;
        return baselineTestCaseDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"基线用例" },  notes = "BaselineTestCase-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineTestCase-Save-all') or hasPermission(this.baselineTestCaseDtoMapping.toDomain(#dto),'ibizplm-BaselineTestCase-Save')")
    @PostMapping("baseline_test_cases/save")
    public ResponseEntity<ResponseWrapper<BaselineTestCaseDTO>> save
            (@Validated @RequestBody RequestWrapper<BaselineTestCaseDTO> dto) {
        ResponseWrapper<BaselineTestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */   
    public BaselineTestCaseDTO save
            (BaselineTestCaseDTO dto) {
        BaselineTestCase domain = baselineTestCaseDtoMapping.toDomain(dto);
        baselineTestCaseService.save(domain);
        BaselineTestCase rt = domain;
        return baselineTestCaseDtoMapping.toDto(rt);
    }

    /**
    * shift_in_baseline 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */
    @ApiOperation(value = "shift_in_baseline", tags = {"基线用例" },  notes = "BaselineTestCase-shift_in_baseline ")
    @PostMapping("baseline_test_cases/shift_in_baseline")
    public ResponseEntity<ResponseWrapper<BaselineTestCaseDTO>> shiftInBaseline
            (@Validated @RequestBody RequestWrapper<BaselineTestCaseDTO> dto) {
        ResponseWrapper<BaselineTestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftInBaseline(item)));
        else
            rt.set(shiftInBaseline(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * shift_in_baseline 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */   
    public BaselineTestCaseDTO shiftInBaseline
            (BaselineTestCaseDTO dto) {
        BaselineTestCase domain = baselineTestCaseDtoMapping.toDomain(dto);
        BaselineTestCase rt = baselineTestCaseService.shiftInBaseline(domain);
        return baselineTestCaseDtoMapping.toDto(rt);
    }

    /**
    * shift_out_baseline 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */
    @ApiOperation(value = "shift_out_baseline", tags = {"基线用例" },  notes = "BaselineTestCase-shift_out_baseline ")
    @PostMapping("baseline_test_cases/shift_out_baseline")
    public ResponseEntity<ResponseWrapper<BaselineTestCaseDTO>> shiftOutBaseline
            (@Validated @RequestBody RequestWrapper<BaselineTestCaseDTO> dto) {
        ResponseWrapper<BaselineTestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(shiftOutBaseline(item)));
        else
            rt.set(shiftOutBaseline(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * shift_out_baseline 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */   
    public BaselineTestCaseDTO shiftOutBaseline
            (BaselineTestCaseDTO dto) {
        BaselineTestCase domain = baselineTestCaseDtoMapping.toDomain(dto);
        BaselineTestCase rt = baselineTestCaseService.shiftOutBaseline(domain);
        return baselineTestCaseDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 基线用例
    * 
    *
    * @param id id
    * @return ResponseEntity<BaselineTestCaseDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"基线用例" },  notes = "BaselineTestCase-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineTestCase-Get-all')  or hasPermission(this.baselineTestCaseDtoMapping.toDomain(returnObject.body),'ibizplm-BaselineTestCase-Get')")
    @GetMapping("baseline_test_cases/{id}")
    public ResponseEntity<BaselineTestCaseDTO> getById
            (@PathVariable("id") String id) {
        BaselineTestCase rt = baselineTestCaseService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(baselineTestCaseDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 基线用例
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"基线用例" },  notes = "BaselineTestCase-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineTestCase-Remove-all') or hasPermission(this.baselineTestCaseService.get(#id),'ibizplm-BaselineTestCase-Remove')")
    @DeleteMapping("baseline_test_cases/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = baselineTestCaseService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"基线用例" },  notes = "BaselineTestCase-CheckKey ")
    @PostMapping("baseline_test_cases/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody BaselineTestCaseDTO dto) {
        BaselineTestCase domain = baselineTestCaseDtoMapping.toDomain(dto);
        Integer rt = baselineTestCaseService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineTestCaseDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"基线用例" },  notes = "BaselineTestCase-GetDraft ")
    @GetMapping("baseline_test_cases/get_draft")
    public ResponseEntity<BaselineTestCaseDTO> getDraft
            (@SpringQueryMap BaselineTestCaseDTO dto) {
        BaselineTestCase domain = baselineTestCaseDtoMapping.toDomain(dto);
        BaselineTestCase rt = baselineTestCaseService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(baselineTestCaseDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<BaselineTestCaseDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"基线用例" },  notes = "BaselineTestCase-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-BaselineTestCase-fetch_default-all') or hasPermission(#dto,'ibizplm-BaselineTestCase-fetch_default')")
    @PostMapping("baseline_test_cases/fetch_default")
    public ResponseEntity<List<BaselineTestCaseDTO>> fetchDefault
            (@Validated @RequestBody BaselineTestCaseFilterDTO dto) {
        BaselineTestCaseSearchContext context = baselineTestCaseFilterDtoMapping.toDomain(dto);
        Page<BaselineTestCase> domains = baselineTestCaseService.searchDefault(context) ;
        List<BaselineTestCaseDTO> list = baselineTestCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_fill_version_data 基线用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<BaselineTestCaseDTO>>
    */
    @ApiOperation(value = "查询fetch_fill_version_data", tags = {"基线用例" },  notes = "BaselineTestCase-fetch_fill_version_data ")
    @PostMapping("baseline_test_cases/fetch_fill_version_data")
    public ResponseEntity<List<BaselineTestCaseDTO>> fetchFillVersionData
            (@Validated @RequestBody BaselineTestCaseFilterDTO dto) {
        BaselineTestCaseSearchContext context = baselineTestCaseFilterDtoMapping.toDomain(dto);
        Page<BaselineTestCase> domains = baselineTestCaseService.searchFillVersionData(context) ;
        List<BaselineTestCaseDTO> list = baselineTestCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建基线用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineTestCase-Create-all')")
    @ApiOperation(value = "批量新建基线用例", tags = {"基线用例" },  notes = "批量新建基线用例")
	@PostMapping("baseline_test_cases/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<BaselineTestCaseDTO> dtos) {
        baselineTestCaseService.createBatch(baselineTestCaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除基线用例
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineTestCase-Remove-all')")
    @ApiOperation(value = "批量删除基线用例", tags = {"基线用例" },  notes = "批量删除基线用例")
	@DeleteMapping("baseline_test_cases/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        baselineTestCaseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新基线用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineTestCase-Update-all')")
    @ApiOperation(value = "批量更新基线用例", tags = {"基线用例" },  notes = "批量更新基线用例")
	@PutMapping("baseline_test_cases/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<BaselineTestCaseDTO> dtos) {
        baselineTestCaseService.updateBatch(baselineTestCaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存基线用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineTestCase-Save-all')")
    @ApiOperation(value = "批量保存基线用例", tags = {"基线用例" },  notes = "批量保存基线用例")
	@PostMapping("baseline_test_cases/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<BaselineTestCaseDTO> dtos) {
        baselineTestCaseService.saveBatch(baselineTestCaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入基线用例
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-BaselineTestCase-Save-all')")
    @ApiOperation(value = "批量导入基线用例", tags = {"基线用例" },  notes = "批量导入基线用例")
	@PostMapping("baseline_test_cases/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<BaselineTestCaseDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(baselineTestCaseService.importData(config,ignoreError,baselineTestCaseDtoMapping.toDomain(dtos)));
    }

}
