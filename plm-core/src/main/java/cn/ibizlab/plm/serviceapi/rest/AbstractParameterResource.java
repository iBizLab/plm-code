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
import cn.ibizlab.plm.core.base.domain.Parameter;
import cn.ibizlab.plm.core.base.service.ParameterService;
import cn.ibizlab.plm.core.base.filter.ParameterSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Parameter] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractParameterResource {

    @Autowired
    public ParameterService parameterService;

    @Autowired
    @Lazy
    public ParameterDTOMapping parameterDtoMapping;

    @Autowired
    @Lazy
    public ParameterFilterDTOMapping parameterFilterDtoMapping;

    /**
    * 创建Create 系统参数
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ParameterDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"系统参数" },  notes = "Parameter-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Parameter-Create-all') or hasPermission(this.parameterDtoMapping.toDomain(#dto),'ibizplm-Parameter-Create')")
    @PostMapping("parameters")
    public ResponseEntity<ResponseWrapper<ParameterDTO>> create
            (@Validated @RequestBody RequestWrapper<ParameterDTO> dto) {
        ResponseWrapper<ParameterDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 系统参数
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ParameterDTO>
    */   
    public ParameterDTO create
            (ParameterDTO dto) {
        Parameter domain = parameterDtoMapping.toDomain(dto);
        parameterService.create(domain);
        Parameter rt = domain;
        return parameterDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 系统参数
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ParameterDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"系统参数" },  notes = "Parameter-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Parameter-Update-all') or hasPermission(this.parameterService.get(#id),'ibizplm-Parameter-Update')")
    @VersionCheck(entity = "parameter" , versionfield = "updateTime")
    @PutMapping("parameters/{id}")
    public ResponseEntity<ResponseWrapper<ParameterDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ParameterDTO> dto) {
        ResponseWrapper<ParameterDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 系统参数
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ParameterDTO>
    */   
    public ParameterDTO updateById
            (String id, ParameterDTO dto) {
        Parameter domain = parameterDtoMapping.toDomain(dto);
        domain.setId(id);
        parameterService.update(domain);
        Parameter rt = domain;
        return parameterDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 系统参数
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ParameterDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"系统参数" },  notes = "Parameter-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Parameter-Save-all') or hasPermission(this.parameterDtoMapping.toDomain(#dto),'ibizplm-Parameter-Save')")
    @PostMapping("parameters/save")
    public ResponseEntity<ResponseWrapper<ParameterDTO>> save
            (@Validated @RequestBody RequestWrapper<ParameterDTO> dto) {
        ResponseWrapper<ParameterDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 系统参数
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ParameterDTO>
    */   
    public ParameterDTO save
            (ParameterDTO dto) {
        Parameter domain = parameterDtoMapping.toDomain(dto);
        parameterService.save(domain);
        Parameter rt = domain;
        return parameterDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 系统参数
    * 
    *
    * @param id id
    * @return ResponseEntity<ParameterDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"系统参数" },  notes = "Parameter-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Parameter-Get-all')  or hasPermission(this.parameterDtoMapping.toDomain(returnObject.body),'ibizplm-Parameter-Get')")
    @GetMapping("parameters/{id}")
    public ResponseEntity<ParameterDTO> getById
            (@PathVariable("id") String id) {
        Parameter rt = parameterService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(parameterDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 系统参数
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"系统参数" },  notes = "Parameter-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Parameter-Remove-all') or hasPermission(this.parameterService.get(#id),'ibizplm-Parameter-Remove')")
    @DeleteMapping("parameters/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = parameterService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 系统参数
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"系统参数" },  notes = "Parameter-CheckKey ")
    @PostMapping("parameters/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ParameterDTO dto) {
        Parameter domain = parameterDtoMapping.toDomain(dto);
        Integer rt = parameterService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 系统参数
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ParameterDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"系统参数" },  notes = "Parameter-GetDraft ")
    @GetMapping("parameters/get_draft")
    public ResponseEntity<ParameterDTO> getDraft
            (@SpringQueryMap ParameterDTO dto) {
        Parameter domain = parameterDtoMapping.toDomain(dto);
        Parameter rt = parameterService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(parameterDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 系统参数
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ParameterDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"系统参数" },  notes = "Parameter-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Parameter-fetch_default-all') or hasPermission(#dto,'ibizplm-Parameter-fetch_default')")
    @PostMapping("parameters/fetch_default")
    public ResponseEntity<List<ParameterDTO>> fetchDefault
            (@Validated @RequestBody ParameterFilterDTO dto) {
        ParameterSearchContext context = parameterFilterDtoMapping.toDomain(dto);
        Page<Parameter> domains = parameterService.fetchDefault(context) ;
        List<ParameterDTO> list = parameterDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建系统参数
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Parameter-Create-all')")
    @ApiOperation(value = "批量新建系统参数", tags = {"系统参数" },  notes = "批量新建系统参数")
	@PostMapping("parameters/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParameterDTO> dtos) {
        parameterService.create(parameterDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除系统参数
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Parameter-Remove-all')")
    @ApiOperation(value = "批量删除系统参数", tags = {"系统参数" },  notes = "批量删除系统参数")
	@DeleteMapping("parameters/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parameterService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新系统参数
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Parameter-Update-all')")
    @ApiOperation(value = "批量更新系统参数", tags = {"系统参数" },  notes = "批量更新系统参数")
	@PutMapping("parameters/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParameterDTO> dtos) {
        parameterService.update(parameterDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存系统参数
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Parameter-Save-all')")
    @ApiOperation(value = "批量保存系统参数", tags = {"系统参数" },  notes = "批量保存系统参数")
	@PostMapping("parameters/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParameterDTO> dtos) {
        parameterService.save(parameterDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入系统参数
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Parameter-Save-all')")
    @ApiOperation(value = "批量导入系统参数", tags = {"系统参数" },  notes = "批量导入系统参数")
	@PostMapping("parameters/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ParameterDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(parameterService.importData(config,ignoreError,parameterDtoMapping.toDomain(dtos)));
    }

}
