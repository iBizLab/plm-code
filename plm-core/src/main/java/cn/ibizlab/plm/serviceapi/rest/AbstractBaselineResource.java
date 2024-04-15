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
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.base.filter.BaselineSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Baseline] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineResource {

    @Autowired
    public BaselineService baselineService;

    @Autowired
    @Lazy
    public BaselineDTOMapping baselineDtoMapping;

    @Autowired
    @Lazy
    public BaselineFilterDTOMapping baselineFilterDtoMapping;

    /**
    * 创建Create 基线
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"基线" },  notes = "Baseline-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Create-all') or hasPermission(this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-Create')")
    @PostMapping("baselines")
    public ResponseEntity<ResponseWrapper<BaselineDTO>> create
            (@Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 基线
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO create
            (BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        baselineService.create(domain);
        Baseline rt = domain;
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 基线
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"基线" },  notes = "Baseline-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Update-all') or hasPermission(this.baselineService.get(#id),'ibizplm-Baseline-Update')")
    @VersionCheck(entity = "baseline" , versionfield = "updateTime")
    @PutMapping("baselines/{id}")
    public ResponseEntity<ResponseWrapper<BaselineDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 基线
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO updateById
            (String id, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setId(id);
        baselineService.update(domain);
        Baseline rt = domain;
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 基线
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"基线" },  notes = "Baseline-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Save-all') or hasPermission(this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-Save')")
    @PostMapping("baselines/save")
    public ResponseEntity<ResponseWrapper<BaselineDTO>> save
            (@Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 基线
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO save
            (BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        baselineService.save(domain);
        Baseline rt = domain;
        return baselineDtoMapping.toDto(rt);
    }

    /**
    * set_complete 基线
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */
    @ApiOperation(value = "set_complete", tags = {"基线" },  notes = "Baseline-set_complete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-set_complete-all') or hasPermission(this.baselineDtoMapping.toDomain(#dto),'ibizplm-Baseline-set_complete')")
    @PostMapping("baselines/{id}/set_complete")
    public ResponseEntity<ResponseWrapper<BaselineDTO>> setCompleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BaselineDTO> dto) {
        ResponseWrapper<BaselineDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setCompleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setCompleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * set_complete 基线
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */   
    public BaselineDTO setCompleteById
            (String id, BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        domain.setId(id);
        Baseline rt = baselineService.setComplete(domain);
        return baselineDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 基线
    * 
    *
    * @param id id
    * @return ResponseEntity<BaselineDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"基线" },  notes = "Baseline-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Get-all')  or hasPermission(this.baselineDtoMapping.toDomain(returnObject.body),'ibizplm-Baseline-Get')")
    @GetMapping("baselines/{id}")
    public ResponseEntity<BaselineDTO> getById
            (@PathVariable("id") String id) {
        Baseline rt = baselineService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(baselineDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 基线
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"基线" },  notes = "Baseline-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-Remove-all') or hasPermission(this.baselineService.get(#id),'ibizplm-Baseline-Remove')")
    @DeleteMapping("baselines/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = baselineService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 基线
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"基线" },  notes = "Baseline-CheckKey ")
    @PostMapping("baselines/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        Integer rt = baselineService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 基线
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BaselineDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"基线" },  notes = "Baseline-GetDraft ")
    @GetMapping("baselines/get_draft")
    public ResponseEntity<BaselineDTO> getDraft
            (@SpringQueryMap BaselineDTO dto) {
        Baseline domain = baselineDtoMapping.toDomain(dto);
        Baseline rt = baselineService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(baselineDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 基线
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<BaselineDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"基线" },  notes = "Baseline-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Baseline-fetch_default-all') or hasPermission(#dto,'ibizplm-Baseline-fetch_default')")
    @PostMapping("baselines/fetch_default")
    public ResponseEntity<List<BaselineDTO>> fetchDefault
            (@Validated @RequestBody BaselineFilterDTO dto) {
        BaselineSearchContext context = baselineFilterDtoMapping.toDomain(dto);
        Page<Baseline> domains = baselineService.searchDefault(context) ;
        List<BaselineDTO> list = baselineDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建基线
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Baseline-Create-all')")
    @ApiOperation(value = "批量新建基线", tags = {"基线" },  notes = "批量新建基线")
	@PostMapping("baselines/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<BaselineDTO> dtos) {
        baselineService.createBatch(baselineDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除基线
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Baseline-Remove-all')")
    @ApiOperation(value = "批量删除基线", tags = {"基线" },  notes = "批量删除基线")
	@DeleteMapping("baselines/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        baselineService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新基线
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Baseline-Update-all')")
    @ApiOperation(value = "批量更新基线", tags = {"基线" },  notes = "批量更新基线")
	@PutMapping("baselines/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<BaselineDTO> dtos) {
        baselineService.updateBatch(baselineDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存基线
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Baseline-Save-all')")
    @ApiOperation(value = "批量保存基线", tags = {"基线" },  notes = "批量保存基线")
	@PostMapping("baselines/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<BaselineDTO> dtos) {
        baselineService.saveBatch(baselineDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入基线
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Baseline-Save-all')")
    @ApiOperation(value = "批量导入基线", tags = {"基线" },  notes = "批量导入基线")
	@PostMapping("baselines/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<BaselineDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(baselineService.importData(config,ignoreError,baselineDtoMapping.toDomain(dtos)));
    }

}
