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
import cn.ibizlab.plm.core.ebsx.domain.SysTodo;
import cn.ibizlab.plm.core.ebsx.service.SysTodoService;
import cn.ibizlab.plm.core.ebsx.filter.SysTodoSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[SysTodo] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSysTodoResource {

    @Autowired
    public SysTodoService sysTodoService;

    @Autowired
    @Lazy
    public SysTodoDTOMapping sysTodoDtoMapping;

    @Autowired
    @Lazy
    public SysTodoFilterDTOMapping sysTodoFilterDtoMapping;

    /**
    * 创建Create 待办
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SysTodoDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"待办" },  notes = "SysTodo-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SysTodo-Create-all') or hasPermission(this.sysTodoDtoMapping.toDomain(#dto),'ibizplm-SysTodo-Create')")
    @PostMapping("systodos")
    public ResponseEntity<ResponseWrapper<SysTodoDTO>> create
            (@Validated @RequestBody RequestWrapper<SysTodoDTO> dto) {
        ResponseWrapper<SysTodoDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 待办
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SysTodoDTO>
    */   
    public SysTodoDTO create
            (SysTodoDTO dto) {
        SysTodo domain = sysTodoDtoMapping.toDomain(dto);
        sysTodoService.create(domain);
        SysTodo rt = domain;
        return sysTodoDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 待办
    * 
    *
    * @param todoId todoId
    * @param dto dto
    * @return ResponseEntity<SysTodoDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"待办" },  notes = "SysTodo-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SysTodo-Update-all') or hasPermission(this.sysTodoService.get(#todoId),'ibizplm-SysTodo-Update')")
    @VersionCheck(entity = "systodo" , versionfield = "updateDate")
    @PutMapping("systodos/{todoId}")
    public ResponseEntity<ResponseWrapper<SysTodoDTO>> updateByTodoId
            (@PathVariable("todoId") String todoId, @Validated @RequestBody RequestWrapper<SysTodoDTO> dto) {
        ResponseWrapper<SysTodoDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = todoId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTodoId(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTodoId(todoId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 待办
    * 
    *
    * @param todoId todoId
    * @param dto dto
    * @return ResponseEntity<SysTodoDTO>
    */   
    public SysTodoDTO updateByTodoId
            (String todoId, SysTodoDTO dto) {
        SysTodo domain = sysTodoDtoMapping.toDomain(dto);
        domain.setTodoId(todoId);
        sysTodoService.update(domain);
        SysTodo rt = domain;
        return sysTodoDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 待办
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SysTodoDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"待办" },  notes = "SysTodo-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SysTodo-Save-all') or hasPermission(this.sysTodoDtoMapping.toDomain(#dto),'ibizplm-SysTodo-Save')")
    @PostMapping("systodos/save")
    public ResponseEntity<ResponseWrapper<SysTodoDTO>> save
            (@Validated @RequestBody RequestWrapper<SysTodoDTO> dto) {
        ResponseWrapper<SysTodoDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 待办
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SysTodoDTO>
    */   
    public SysTodoDTO save
            (SysTodoDTO dto) {
        SysTodo domain = sysTodoDtoMapping.toDomain(dto);
        sysTodoService.save(domain);
        SysTodo rt = domain;
        return sysTodoDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 待办
    * 
    *
    * @param todoId todoId
    * @return ResponseEntity<SysTodoDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"待办" },  notes = "SysTodo-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SysTodo-Get-all')  or hasPermission(this.sysTodoDtoMapping.toDomain(returnObject.body),'ibizplm-SysTodo-Get')")
    @GetMapping("systodos/{todoId}")
    public ResponseEntity<SysTodoDTO> getByTodoId
            (@PathVariable("todoId") String todoId) {
        SysTodo rt = sysTodoService.get(todoId);
        return ResponseEntity.status(HttpStatus.OK).body(sysTodoDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 待办
    * 
    *
    * @param todoId todoId
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"待办" },  notes = "SysTodo-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SysTodo-Remove-all') or hasPermission(this.sysTodoService.get(#todoId),'ibizplm-SysTodo-Remove')")
    @DeleteMapping("systodos/{todoId}")
    public ResponseEntity<Boolean> removeByTodoId
            (@PathVariable("todoId") String todoId) {
        Boolean rt = sysTodoService.remove(todoId);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 待办
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"待办" },  notes = "SysTodo-CheckKey ")
    @PostMapping("systodos/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SysTodoDTO dto) {
        SysTodo domain = sysTodoDtoMapping.toDomain(dto);
        Integer rt = sysTodoService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 待办
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SysTodoDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"待办" },  notes = "SysTodo-GetDraft ")
    @GetMapping("systodos/getdraft")
    public ResponseEntity<SysTodoDTO> getDraft
            (@SpringQueryMap SysTodoDTO dto) {
        SysTodo domain = sysTodoDtoMapping.toDomain(dto);
        SysTodo rt = sysTodoService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysTodoDtoMapping.toDto(rt));
    }

    /**
    * GetLinkUrl 待办
    * 
    *
    * @param todoId todoId
    * @return ResponseEntity<SysTodoDTO>
    */
    @ApiOperation(value = "GetLinkUrl", tags = {"待办" },  notes = "SysTodo-GetLinkUrl ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SysTodo-GetLinkUrl-all') or hasPermission(this.sysTodoService.get(#todoId),'ibizplm-SysTodo-GetLinkUrl')")
    @PostMapping("systodos/{todoId}/getlinkurl")
    public ResponseEntity<SysTodoDTO> getLinkUrlByTodoId
            (@PathVariable("todoId") String todoId) {
        SysTodo rt = sysTodoService.getLinkUrl(todoId);
        return ResponseEntity.status(HttpStatus.OK).body(sysTodoDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCurUser 待办
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SysTodoDTO>>
    */
    @ApiOperation(value = "查询FetchCurUser", tags = {"待办" },  notes = "SysTodo-FetchCurUser ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SysTodo-FetchCurUser-all') or hasPermission(#dto,'ibizplm-SysTodo-FetchCurUser')")
    @PostMapping("systodos/fetchcuruser")
    public ResponseEntity<List<SysTodoDTO>> fetchCurUser
            (@Validated @RequestBody SysTodoFilterDTO dto) {
        SysTodoSearchContext context = sysTodoFilterDtoMapping.toDomain(dto);
        Page<SysTodo> domains = sysTodoService.searchCurUser(context) ;
        List<SysTodoDTO> list = sysTodoDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 待办
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SysTodoDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"待办" },  notes = "SysTodo-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SysTodo-FetchDefault-all') or hasPermission(#dto,'ibizplm-SysTodo-FetchDefault')")
    @PostMapping("systodos/fetchdefault")
    public ResponseEntity<List<SysTodoDTO>> fetchDefault
            (@Validated @RequestBody SysTodoFilterDTO dto) {
        SysTodoSearchContext context = sysTodoFilterDtoMapping.toDomain(dto);
        Page<SysTodo> domains = sysTodoService.searchDefault(context) ;
        List<SysTodoDTO> list = sysTodoDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建待办
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SysTodo-Create-all')")
    @ApiOperation(value = "批量新建待办", tags = {"待办" },  notes = "批量新建待办")
	@PostMapping("systodos/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysTodoDTO> dtos) {
        sysTodoService.createBatch(sysTodoDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除待办
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SysTodo-Remove-all')")
    @ApiOperation(value = "批量删除待办", tags = {"待办" },  notes = "批量删除待办")
	@DeleteMapping("systodos/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysTodoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新待办
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SysTodo-Update-all')")
    @ApiOperation(value = "批量更新待办", tags = {"待办" },  notes = "批量更新待办")
	@PutMapping("systodos/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysTodoDTO> dtos) {
        sysTodoService.updateBatch(sysTodoDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存待办
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SysTodo-Save-all')")
    @ApiOperation(value = "批量保存待办", tags = {"待办" },  notes = "批量保存待办")
	@PostMapping("systodos/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysTodoDTO> dtos) {
        sysTodoService.saveBatch(sysTodoDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入待办
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SysTodo-Save-all')")
    @ApiOperation(value = "批量导入待办", tags = {"待办" },  notes = "批量导入待办")
	@PostMapping("systodos/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SysTodoDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysTodoService.importData(config,ignoreError,sysTodoDtoMapping.toDomain(dtos)));
    }

}
