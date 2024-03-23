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
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.service.RunHistoryService;
import cn.ibizlab.plm.core.testmgmt.filter.RunHistorySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[RunHistory] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRunHistoryResource {

    @Autowired
    public RunHistoryService runHistoryService;

    @Autowired
    @Lazy
    public RunHistoryDTOMapping runHistoryDtoMapping;

    @Autowired
    @Lazy
    public RunHistoryFilterDTOMapping runHistoryFilterDtoMapping;

    /**
    * 创建Create 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行结果" },  notes = "RunHistory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Create-all') or hasPermission(this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Create')")
    @PostMapping("run_histories")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> create
            (@Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO create
            (RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        runHistoryService.create(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行结果" },  notes = "RunHistory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Update-all') or hasPermission(this.runHistoryService.get(#id),'ibizplm-RunHistory-Update')")
    @VersionCheck(entity = "runhistory" , versionfield = "updateTime")
    @PutMapping("run_histories/{id}")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO updateById
            (String id, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        runHistoryService.update(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行结果" },  notes = "RunHistory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Save-all') or hasPermission(this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Save')")
    @PostMapping("run_histories/save")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> save
            (@Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO save
            (RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        runHistoryService.save(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 执行结果
    * 
    *
    * @param id id
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行结果" },  notes = "RunHistory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Get-all')  or hasPermission(this.runHistoryDtoMapping.toDomain(returnObject.body),'ibizplm-RunHistory-Get')")
    @GetMapping("run_histories/{id}")
    public ResponseEntity<RunHistoryDTO> getById
            (@PathVariable("id") String id) {
        RunHistory rt = runHistoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行结果
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行结果" },  notes = "RunHistory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Remove-all') or hasPermission(this.runHistoryService.get(#id),'ibizplm-RunHistory-Remove')")
    @DeleteMapping("run_histories/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = runHistoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行结果" },  notes = "RunHistory-CheckKey ")
    @PostMapping("run_histories/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        Integer rt = runHistoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行结果" },  notes = "RunHistory-GetDraft ")
    @GetMapping("run_histories/getdraft")
    public ResponseEntity<RunHistoryDTO> getDraft
            (@SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        RunHistory rt = runHistoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * Run_history_get 执行结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "Run_history_get", tags = {"执行结果" },  notes = "RunHistory-Run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Run_history_get-all') or hasPermission(this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Run_history_get')")
    @GetMapping("run_histories/{id}/run_history_get")
    public ResponseEntity<RunHistoryDTO> runHistoryGetById
            (@PathVariable("id") String id, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        RunHistory rt = runHistoryService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"执行结果" },  notes = "RunHistory-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-FetchDefault-all') or hasPermission(#dto,'ibizplm-RunHistory-FetchDefault')")
    @PostMapping("run_histories/fetchdefault")
    public ResponseEntity<List<RunHistoryDTO>> fetchDefault
            (@Validated @RequestBody RunHistoryFilterDTO dto) {
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.searchDefault(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchThis 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询FetchThis", tags = {"执行结果" },  notes = "RunHistory-FetchThis ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-FetchThis-all') or hasPermission(#dto,'ibizplm-RunHistory-FetchThis')")
    @PostMapping("run_histories/fetchthis")
    public ResponseEntity<List<RunHistoryDTO>> fetchThis
            (@Validated @RequestBody RunHistoryFilterDTO dto) {
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.searchThis(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建执行结果
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Create-all')")
    @ApiOperation(value = "批量新建执行结果", tags = {"执行结果" },  notes = "批量新建执行结果")
	@PostMapping("run_histories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<RunHistoryDTO> dtos) {
        runHistoryService.createBatch(runHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除执行结果
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Remove-all')")
    @ApiOperation(value = "批量删除执行结果", tags = {"执行结果" },  notes = "批量删除执行结果")
	@DeleteMapping("run_histories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        runHistoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新执行结果
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Update-all')")
    @ApiOperation(value = "批量更新执行结果", tags = {"执行结果" },  notes = "批量更新执行结果")
	@PutMapping("run_histories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<RunHistoryDTO> dtos) {
        runHistoryService.updateBatch(runHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存执行结果
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Save-all')")
    @ApiOperation(value = "批量保存执行结果", tags = {"执行结果" },  notes = "批量保存执行结果")
	@PostMapping("run_histories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<RunHistoryDTO> dtos) {
        runHistoryService.saveBatch(runHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入执行结果
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Save-all')")
    @ApiOperation(value = "批量导入执行结果", tags = {"执行结果" },  notes = "批量导入执行结果")
	@PostMapping("run_histories/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RunHistoryDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(runHistoryService.importData(config,ignoreError,runHistoryDtoMapping.toDomain(dtos)));
    }

}
