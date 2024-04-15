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
import cn.ibizlab.plm.core.testmgmt.domain.RunAttachment;
import cn.ibizlab.plm.core.testmgmt.service.RunAttachmentService;
import cn.ibizlab.plm.core.testmgmt.filter.RunAttachmentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[RunAttachment] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRunAttachmentResource {

    @Autowired
    public RunAttachmentService runAttachmentService;

    @Autowired
    @Lazy
    public RunAttachmentDTOMapping runAttachmentDtoMapping;

    @Autowired
    @Lazy
    public RunAttachmentFilterDTOMapping runAttachmentFilterDtoMapping;

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例结果附件" },  notes = "RunAttachment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Create-all') or hasPermission(this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Create')")
    @PostMapping("run_attachments")
    public ResponseEntity<ResponseWrapper<RunAttachmentDTO>> create
            (@Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO create
            (RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        runAttachmentService.create(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例结果附件" },  notes = "RunAttachment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Update-all') or hasPermission(this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Update')")
    @VersionCheck(entity = "runattachment" , versionfield = "updateTime")
    @PutMapping("run_attachments/{id}")
    public ResponseEntity<ResponseWrapper<RunAttachmentDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO updateById
            (String id, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setId(id);
        runAttachmentService.update(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例结果附件" },  notes = "RunAttachment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Save-all') or hasPermission(this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Save')")
    @PostMapping("run_attachments/save")
    public ResponseEntity<ResponseWrapper<RunAttachmentDTO>> save
            (@Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO save
            (RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        runAttachmentService.save(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 执行用例结果附件
    * 
    *
    * @param id id
    * @return ResponseEntity<RunAttachmentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例结果附件" },  notes = "RunAttachment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Get-all')  or hasPermission(this.runAttachmentDtoMapping.toDomain(returnObject.body),'ibizplm-RunAttachment-Get')")
    @GetMapping("run_attachments/{id}")
    public ResponseEntity<RunAttachmentDTO> getById
            (@PathVariable("id") String id) {
        RunAttachment rt = runAttachmentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行用例结果附件
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例结果附件" },  notes = "RunAttachment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Remove-all') or hasPermission(this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Remove')")
    @DeleteMapping("run_attachments/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = runAttachmentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例结果附件" },  notes = "RunAttachment-CheckKey ")
    @PostMapping("run_attachments/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        Integer rt = runAttachmentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例结果附件" },  notes = "RunAttachment-GetDraft ")
    @GetMapping("run_attachments/get_draft")
    public ResponseEntity<RunAttachmentDTO> getDraft
            (@SpringQueryMap RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        RunAttachment rt = runAttachmentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunAttachmentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例结果附件" },  notes = "RunAttachment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-fetch_default-all') or hasPermission(#dto,'ibizplm-RunAttachment-fetch_default')")
    @PostMapping("run_attachments/fetch_default")
    public ResponseEntity<List<RunAttachmentDTO>> fetchDefault
            (@Validated @RequestBody RunAttachmentFilterDTO dto) {
        RunAttachmentSearchContext context = runAttachmentFilterDtoMapping.toDomain(dto);
        Page<RunAttachment> domains = runAttachmentService.searchDefault(context) ;
        List<RunAttachmentDTO> list = runAttachmentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建执行用例结果附件
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Create-all')")
    @ApiOperation(value = "批量新建执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量新建执行用例结果附件")
	@PostMapping("run_attachments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<RunAttachmentDTO> dtos) {
        runAttachmentService.createBatch(runAttachmentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除执行用例结果附件
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Remove-all')")
    @ApiOperation(value = "批量删除执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量删除执行用例结果附件")
	@DeleteMapping("run_attachments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        runAttachmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新执行用例结果附件
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Update-all')")
    @ApiOperation(value = "批量更新执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量更新执行用例结果附件")
	@PutMapping("run_attachments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<RunAttachmentDTO> dtos) {
        runAttachmentService.updateBatch(runAttachmentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存执行用例结果附件
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Save-all')")
    @ApiOperation(value = "批量保存执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量保存执行用例结果附件")
	@PostMapping("run_attachments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<RunAttachmentDTO> dtos) {
        runAttachmentService.saveBatch(runAttachmentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入执行用例结果附件
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Save-all')")
    @ApiOperation(value = "批量导入执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量导入执行用例结果附件")
	@PostMapping("run_attachments/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RunAttachmentDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(runAttachmentService.importData(config,ignoreError,runAttachmentDtoMapping.toDomain(dtos)));
    }

}
