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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.serviceapi.dto.*;
import cn.ibizlab.plm.serviceapi.mapping.*;
import cn.ibizlab.plm.core.base.domain.DictionaryData;
import cn.ibizlab.plm.core.base.service.DictionaryDataService;
import cn.ibizlab.plm.core.base.filter.DictionaryDataSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[DictionaryData] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDictionaryDataResource {

    @Autowired
    public DictionaryDataService dictionaryDataService;

    @Autowired
    @Lazy
    public DictionaryDataDTOMapping dictionaryDataDtoMapping;

    @Autowired
    @Lazy
    public DictionaryDataFilterDTOMapping dictionaryDataFilterDtoMapping;

    /**
    * 创建Create 数据字典
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DictionaryDataDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"数据字典" },  notes = "DictionaryData-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-Create-all') or hasPermission(this.dictionaryDataDtoMapping.toDomain(#dto),'ibizplm-DictionaryData-Create')")
    @PostMapping("dictionary_data")
    public Mono<ResponseEntity<ResponseWrapper<DictionaryDataDTO>>>create
            (@Validated @RequestBody RequestWrapper<DictionaryDataDTO> dto) {
        ResponseWrapper<DictionaryDataDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 数据字典
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DictionaryDataDTO>
    */   
    public DictionaryDataDTO create
            (DictionaryDataDTO dto) {
        DictionaryData domain = dictionaryDataDtoMapping.toDomain(dto);
        dictionaryDataService.create(domain);
        DictionaryData rt = domain;
        return dictionaryDataDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 数据字典
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DictionaryDataDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"数据字典" },  notes = "DictionaryData-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-Update-all') or hasPermission(this.dictionaryDataService.get(#id),'ibizplm-DictionaryData-Update')")
    @VersionCheck(entity = "dictionarydata" , versionfield = "updateTime")
    @PutMapping("dictionary_data/{id}")
    public Mono<ResponseEntity<ResponseWrapper<DictionaryDataDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DictionaryDataDTO> dto) {
        ResponseWrapper<DictionaryDataDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 数据字典
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DictionaryDataDTO>
    */   
    public DictionaryDataDTO updateById
            (String id, DictionaryDataDTO dto) {
        DictionaryData domain = dictionaryDataDtoMapping.toDomain(dto);
        domain.setId(id);
        dictionaryDataService.update(domain);
        DictionaryData rt = domain;
        return dictionaryDataDtoMapping.toDto(rt);
    }

    /**
    * move_order 数据字典
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<DictionaryDataDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"数据字典" },  notes = "DictionaryData-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-move_order-all') or hasPermission(this.dictionaryDataDtoMapping.toDomain(#dto),'ibizplm-DictionaryData-move_order')")
    @PostMapping("dictionary_data/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<DictionaryDataDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DictionaryDataDTO> dto) {
        ResponseWrapper<List<DictionaryDataDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 数据字典
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<DictionaryDataDTO>>
    */   
    public List<DictionaryDataDTO> moveOrderById
            (String id, DictionaryDataDTO dto) {
        DictionaryData domain = dictionaryDataDtoMapping.toDomain(dto);
        domain.setId(id);
        List<DictionaryData> rt = dictionaryDataService.moveOrder(domain);
        return dictionaryDataDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 数据字典
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DictionaryDataDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"数据字典" },  notes = "DictionaryData-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-Save-all') or hasPermission(this.dictionaryDataDtoMapping.toDomain(#dto),'ibizplm-DictionaryData-Save')")
    @PostMapping("dictionary_data/save")
    public Mono<ResponseEntity<ResponseWrapper<DictionaryDataDTO>>>save
            (@Validated @RequestBody RequestWrapper<DictionaryDataDTO> dto) {
        ResponseWrapper<DictionaryDataDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 数据字典
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DictionaryDataDTO>
    */   
    public DictionaryDataDTO save
            (DictionaryDataDTO dto) {
        DictionaryData domain = dictionaryDataDtoMapping.toDomain(dto);
        dictionaryDataService.save(domain);
        DictionaryData rt = domain;
        return dictionaryDataDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 数据字典
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<DictionaryDataDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"数据字典" },  notes = "DictionaryData-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-Get-all')  or hasPermission(this.dictionaryDataDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-DictionaryData-Get')")
    @GetMapping("dictionary_data/{id}")
    public Mono<ResponseEntity<DictionaryDataDTO>> getById
            (@PathVariable("id") String id) {
        DictionaryData rt = dictionaryDataService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(dictionaryDataDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 数据字典
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"数据字典" },  notes = "DictionaryData-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-Remove-all') or hasPermission(this.dictionaryDataService.get(#id),'ibizplm-DictionaryData-Remove')")
    @DeleteMapping("dictionary_data/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = dictionaryDataService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 数据字典
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"数据字典" },  notes = "DictionaryData-CheckKey ")
    @PostMapping("dictionary_data/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody DictionaryDataDTO dto) {
        DictionaryData domain = dictionaryDataDtoMapping.toDomain(dto);
        CheckKeyStatus rt = dictionaryDataService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 数据字典
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DictionaryDataDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"数据字典" },  notes = "DictionaryData-GetDraft ")
    @GetMapping("dictionary_data/get_draft")
    public Mono<ResponseEntity<DictionaryDataDTO>> getDraft
            (@SpringQueryMap DictionaryDataDTO dto) {
        DictionaryData domain = dictionaryDataDtoMapping.toDomain(dto);
        DictionaryData rt = dictionaryDataService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(dictionaryDataDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 数据字典
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DictionaryDataDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"数据字典" },  notes = "DictionaryData-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-fetch_default-all') or hasPermission(#dto,'ibizplm-DictionaryData-fetch_default')")
    @PostMapping("dictionary_data/fetch_default")
    public Mono<ResponseEntity<List<DictionaryDataDTO>>> fetchDefault
            (@Validated @RequestBody DictionaryDataFilterDTO dto) {
        DictionaryDataSearchContext context = dictionaryDataFilterDtoMapping.toDomain(dto);
        Page<DictionaryData> domains = dictionaryDataService.fetchDefault(context) ;
        List<DictionaryDataDTO> list = dictionaryDataDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_idea_state 数据字典
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DictionaryDataDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_state", tags = {"数据字典" },  notes = "DictionaryData-fetch_idea_state ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-fetch_idea_state-all') or hasPermission(#dto,'ibizplm-DictionaryData-fetch_idea_state')")
    @PostMapping("dictionary_data/fetch_idea_state")
    public Mono<ResponseEntity<List<DictionaryDataDTO>>> fetchIdeaState
            (@Validated @RequestBody DictionaryDataFilterDTO dto) {
        DictionaryDataSearchContext context = dictionaryDataFilterDtoMapping.toDomain(dto);
        Page<DictionaryData> domains = dictionaryDataService.fetchIdeaState(context) ;
        List<DictionaryDataDTO> list = dictionaryDataDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_stage 数据字典
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DictionaryDataDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_stage", tags = {"数据字典" },  notes = "DictionaryData-fetch_release_stage ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-fetch_release_stage-all') or hasPermission(#dto,'ibizplm-DictionaryData-fetch_release_stage')")
    @PostMapping("dictionary_data/fetch_release_stage")
    public Mono<ResponseEntity<List<DictionaryDataDTO>>> fetchReleaseStage
            (@Validated @RequestBody DictionaryDataFilterDTO dto) {
        DictionaryDataSearchContext context = dictionaryDataFilterDtoMapping.toDomain(dto);
        Page<DictionaryData> domains = dictionaryDataService.fetchReleaseStage(context) ;
        List<DictionaryDataDTO> list = dictionaryDataDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_ticket_state 数据字典
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DictionaryDataDTO>>>
    */
    @ApiOperation(value = "查询fetch_ticket_state", tags = {"数据字典" },  notes = "DictionaryData-fetch_ticket_state ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DictionaryData-fetch_ticket_state-all') or hasPermission(#dto,'ibizplm-DictionaryData-fetch_ticket_state')")
    @PostMapping("dictionary_data/fetch_ticket_state")
    public Mono<ResponseEntity<List<DictionaryDataDTO>>> fetchTicketState
            (@Validated @RequestBody DictionaryDataFilterDTO dto) {
        DictionaryDataSearchContext context = dictionaryDataFilterDtoMapping.toDomain(dto);
        Page<DictionaryData> domains = dictionaryDataService.fetchTicketState(context) ;
        List<DictionaryDataDTO> list = dictionaryDataDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建数据字典
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DictionaryData-Create-all')")
    @ApiOperation(value = "批量新建数据字典", tags = {"数据字典" },  notes = "批量新建数据字典")
	@PostMapping("dictionary_data/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<DictionaryDataDTO> dtos) {
        dictionaryDataService.create(dictionaryDataDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除数据字典
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DictionaryData-Remove-all')")
    @ApiOperation(value = "批量删除数据字典", tags = {"数据字典" },  notes = "批量删除数据字典")
	@DeleteMapping("dictionary_data/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        dictionaryDataService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新数据字典
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DictionaryData-Update-all')")
    @ApiOperation(value = "批量更新数据字典", tags = {"数据字典" },  notes = "批量更新数据字典")
	@PutMapping("dictionary_data/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<DictionaryDataDTO> dtos) {
        dictionaryDataService.update(dictionaryDataDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存数据字典
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DictionaryData-Save-all')")
    @ApiOperation(value = "批量保存数据字典", tags = {"数据字典" },  notes = "批量保存数据字典")
	@PostMapping("dictionary_data/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<DictionaryDataDTO> dtos) {
        dictionaryDataService.save(dictionaryDataDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入数据字典
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DictionaryData-Save-all')")
    @ApiOperation(value = "批量导入数据字典", tags = {"数据字典" },  notes = "批量导入数据字典")
	@PostMapping("dictionary_data/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DictionaryDataDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(dictionaryDataService.importData(config,ignoreError,dictionaryDataDtoMapping.toDomain(dtos))));
    }

}
