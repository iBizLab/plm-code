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
import cn.ibizlab.plm.core.projmgmt.domain.TransitionHistory;
import cn.ibizlab.plm.core.projmgmt.service.TransitionHistoryService;
import cn.ibizlab.plm.core.projmgmt.filter.TransitionHistorySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[TransitionHistory] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTransitionHistoryResource {

    @Autowired
    public TransitionHistoryService transitionHistoryService;

    @Autowired
    @Lazy
    public TransitionHistoryDTOMapping transitionHistoryDtoMapping;

    @Autowired
    @Lazy
    public TransitionHistoryFilterDTOMapping transitionHistoryFilterDtoMapping;

    /**
    * 创建Create 流转记录
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TransitionHistoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"流转记录" },  notes = "TransitionHistory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TransitionHistory-Create-all') or hasPermission(this.transitionHistoryDtoMapping.toDomain(#dto),'ibizplm-TransitionHistory-Create')")
    @PostMapping("transition_histories")
    public ResponseEntity<ResponseWrapper<TransitionHistoryDTO>> create
            (@Validated @RequestBody RequestWrapper<TransitionHistoryDTO> dto) {
        ResponseWrapper<TransitionHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 流转记录
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TransitionHistoryDTO>
    */   
    public TransitionHistoryDTO create
            (TransitionHistoryDTO dto) {
        TransitionHistory domain = transitionHistoryDtoMapping.toDomain(dto);
        transitionHistoryService.create(domain);
        TransitionHistory rt = domain;
        return transitionHistoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 流转记录
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TransitionHistoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"流转记录" },  notes = "TransitionHistory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TransitionHistory-Update-all') or hasPermission(this.transitionHistoryService.get(#id),'ibizplm-TransitionHistory-Update')")
    @VersionCheck(entity = "transitionhistory" , versionfield = "updateTime")
    @PutMapping("transition_histories/{id}")
    public ResponseEntity<ResponseWrapper<TransitionHistoryDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TransitionHistoryDTO> dto) {
        ResponseWrapper<TransitionHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 流转记录
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TransitionHistoryDTO>
    */   
    public TransitionHistoryDTO updateById
            (String id, TransitionHistoryDTO dto) {
        TransitionHistory domain = transitionHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        transitionHistoryService.update(domain);
        TransitionHistory rt = domain;
        return transitionHistoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 流转记录
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TransitionHistoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"流转记录" },  notes = "TransitionHistory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TransitionHistory-Save-all') or hasPermission(this.transitionHistoryDtoMapping.toDomain(#dto),'ibizplm-TransitionHistory-Save')")
    @PostMapping("transition_histories/save")
    public ResponseEntity<ResponseWrapper<TransitionHistoryDTO>> save
            (@Validated @RequestBody RequestWrapper<TransitionHistoryDTO> dto) {
        ResponseWrapper<TransitionHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 流转记录
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TransitionHistoryDTO>
    */   
    public TransitionHistoryDTO save
            (TransitionHistoryDTO dto) {
        TransitionHistory domain = transitionHistoryDtoMapping.toDomain(dto);
        transitionHistoryService.save(domain);
        TransitionHistory rt = domain;
        return transitionHistoryDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 流转记录
    * 
    *
    * @param id id
    * @return ResponseEntity<TransitionHistoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"流转记录" },  notes = "TransitionHistory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TransitionHistory-Get-all')  or hasPermission(this.transitionHistoryDtoMapping.toDomain(returnObject.body),'ibizplm-TransitionHistory-Get')")
    @GetMapping("transition_histories/{id}")
    public ResponseEntity<TransitionHistoryDTO> getById
            (@PathVariable("id") String id) {
        TransitionHistory rt = transitionHistoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(transitionHistoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 流转记录
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"流转记录" },  notes = "TransitionHistory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TransitionHistory-Remove-all') or hasPermission(this.transitionHistoryService.get(#id),'ibizplm-TransitionHistory-Remove')")
    @DeleteMapping("transition_histories/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = transitionHistoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 流转记录
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"流转记录" },  notes = "TransitionHistory-CheckKey ")
    @PostMapping("transition_histories/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody TransitionHistoryDTO dto) {
        TransitionHistory domain = transitionHistoryDtoMapping.toDomain(dto);
        Integer rt = transitionHistoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 流转记录
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TransitionHistoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"流转记录" },  notes = "TransitionHistory-GetDraft ")
    @GetMapping("transition_histories/getdraft")
    public ResponseEntity<TransitionHistoryDTO> getDraft
            (@SpringQueryMap TransitionHistoryDTO dto) {
        TransitionHistory domain = transitionHistoryDtoMapping.toDomain(dto);
        TransitionHistory rt = transitionHistoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(transitionHistoryDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 流转记录
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TransitionHistoryDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"流转记录" },  notes = "TransitionHistory-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TransitionHistory-FetchDefault-all') or hasPermission(#dto,'ibizplm-TransitionHistory-FetchDefault')")
    @PostMapping("transition_histories/fetchdefault")
    public ResponseEntity<List<TransitionHistoryDTO>> fetchDefault
            (@Validated @RequestBody TransitionHistoryFilterDTO dto) {
        TransitionHistorySearchContext context = transitionHistoryFilterDtoMapping.toDomain(dto);
        Page<TransitionHistory> domains = transitionHistoryService.searchDefault(context) ;
        List<TransitionHistoryDTO> list = transitionHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建流转记录
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TransitionHistory-Create-all')")
    @ApiOperation(value = "批量新建流转记录", tags = {"流转记录" },  notes = "批量新建流转记录")
	@PostMapping("transition_histories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TransitionHistoryDTO> dtos) {
        transitionHistoryService.createBatch(transitionHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除流转记录
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TransitionHistory-Remove-all')")
    @ApiOperation(value = "批量删除流转记录", tags = {"流转记录" },  notes = "批量删除流转记录")
	@DeleteMapping("transition_histories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        transitionHistoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新流转记录
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TransitionHistory-Update-all')")
    @ApiOperation(value = "批量更新流转记录", tags = {"流转记录" },  notes = "批量更新流转记录")
	@PutMapping("transition_histories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TransitionHistoryDTO> dtos) {
        transitionHistoryService.updateBatch(transitionHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存流转记录
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TransitionHistory-Save-all')")
    @ApiOperation(value = "批量保存流转记录", tags = {"流转记录" },  notes = "批量保存流转记录")
	@PostMapping("transition_histories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TransitionHistoryDTO> dtos) {
        transitionHistoryService.saveBatch(transitionHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入流转记录
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TransitionHistory-Save-all')")
    @ApiOperation(value = "批量导入流转记录", tags = {"流转记录" },  notes = "批量导入流转记录")
	@PostMapping("transition_histories/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TransitionHistoryDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(transitionHistoryService.importData(config,ignoreError,transitionHistoryDtoMapping.toDomain(dtos)));
    }

}