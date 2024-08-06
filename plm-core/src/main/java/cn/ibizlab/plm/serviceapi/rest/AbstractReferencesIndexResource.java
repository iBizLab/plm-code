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
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import cn.ibizlab.plm.core.base.service.ReferencesIndexService;
import cn.ibizlab.plm.core.base.filter.ReferencesIndexSearchContext;
import reactor.core.publisher.Mono;

/**
 * 实体[ReferencesIndex] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReferencesIndexResource {

    @Autowired
    public ReferencesIndexService referencesIndexService;

    @Autowired
    @Lazy
    public ReferencesIndexDTOMapping referencesIndexDtoMapping;

    @Autowired
    @Lazy
    public ReferencesIndexFilterDTOMapping referencesIndexFilterDtoMapping;

    /**
    * 创建Create 引用索引
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReferencesIndexDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"引用索引" },  notes = "ReferencesIndex-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReferencesIndex-Create-all')")
    @PostMapping("references_indices")
    public Mono<ResponseEntity<ResponseWrapper<ReferencesIndexDTO>>>create
            (@Validated @RequestBody RequestWrapper<ReferencesIndexDTO> dto) {
        ResponseWrapper<ReferencesIndexDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 引用索引
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReferencesIndexDTO>
    */   
    public ReferencesIndexDTO create
            (ReferencesIndexDTO dto) {
        ReferencesIndex domain = referencesIndexDtoMapping.toDomain(dto);
        referencesIndexService.create(domain);
        ReferencesIndex rt = domain;
        return referencesIndexDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 引用索引
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReferencesIndexDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"引用索引" },  notes = "ReferencesIndex-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReferencesIndex-Update-all')")
    @PutMapping("references_indices/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReferencesIndexDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReferencesIndexDTO> dto) {
        ResponseWrapper<ReferencesIndexDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 引用索引
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReferencesIndexDTO>
    */   
    public ReferencesIndexDTO updateById
            (String id, ReferencesIndexDTO dto) {
        ReferencesIndex domain = referencesIndexDtoMapping.toDomain(dto);
        domain.setId(id);
        referencesIndexService.update(domain);
        ReferencesIndex rt = domain;
        return referencesIndexDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 引用索引
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReferencesIndexDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"引用索引" },  notes = "ReferencesIndex-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReferencesIndex-Save-all')")
    @PostMapping("references_indices/save")
    public Mono<ResponseEntity<ResponseWrapper<ReferencesIndexDTO>>>save
            (@Validated @RequestBody RequestWrapper<ReferencesIndexDTO> dto) {
        ResponseWrapper<ReferencesIndexDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 引用索引
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReferencesIndexDTO>
    */   
    public ReferencesIndexDTO save
            (ReferencesIndexDTO dto) {
        ReferencesIndex domain = referencesIndexDtoMapping.toDomain(dto);
        referencesIndexService.save(domain);
        ReferencesIndex rt = domain;
        return referencesIndexDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 引用索引
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ReferencesIndexDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"引用索引" },  notes = "ReferencesIndex-Get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReferencesIndex-Get-all')")
    @GetMapping("references_indices/{id}")
    public Mono<ResponseEntity<ReferencesIndexDTO>> getById
            (@PathVariable("id") String id) {
        ReferencesIndex rt = referencesIndexService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(referencesIndexDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 引用索引
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"引用索引" },  notes = "ReferencesIndex-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReferencesIndex-Remove-all')")
    @DeleteMapping("references_indices/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = referencesIndexService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 引用索引
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"引用索引" },  notes = "ReferencesIndex-CheckKey ")
    @PostMapping("references_indices/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ReferencesIndexDTO dto) {
        ReferencesIndex domain = referencesIndexDtoMapping.toDomain(dto);
        CheckKeyStatus rt = referencesIndexService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 引用索引
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReferencesIndexDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"引用索引" },  notes = "ReferencesIndex-GetDraft ")
    @GetMapping("references_indices/get_draft")
    public Mono<ResponseEntity<ReferencesIndexDTO>> getDraft
            (@SpringQueryMap ReferencesIndexDTO dto) {
        ReferencesIndex domain = referencesIndexDtoMapping.toDomain(dto);
        ReferencesIndex rt = referencesIndexService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(referencesIndexDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 引用索引
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReferencesIndexDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"引用索引" },  notes = "ReferencesIndex-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReferencesIndex-fetch_default-all')")
    @PostMapping("references_indices/fetch_default")
    public Mono<ResponseEntity<List<ReferencesIndexDTO>>> fetchDefault
            (@Validated @RequestBody ReferencesIndexFilterDTO dto) {
        ReferencesIndexSearchContext context = referencesIndexFilterDtoMapping.toDomain(dto);
        Page<ReferencesIndex> domains = referencesIndexService.fetchDefault(context) ;
        List<ReferencesIndexDTO> list = referencesIndexDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建引用索引
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReferencesIndex-Create-all')")
    @ApiOperation(value = "批量新建引用索引", tags = {"引用索引" },  notes = "批量新建引用索引")
	@PostMapping("references_indices/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ReferencesIndexDTO> dtos) {
        referencesIndexService.create(referencesIndexDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除引用索引
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReferencesIndex-Remove-all')")
    @ApiOperation(value = "批量删除引用索引", tags = {"引用索引" },  notes = "批量删除引用索引")
	@DeleteMapping("references_indices/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        referencesIndexService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新引用索引
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReferencesIndex-Update-all')")
    @ApiOperation(value = "批量更新引用索引", tags = {"引用索引" },  notes = "批量更新引用索引")
	@PutMapping("references_indices/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ReferencesIndexDTO> dtos) {
        referencesIndexService.update(referencesIndexDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存引用索引
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReferencesIndex-Save-all')")
    @ApiOperation(value = "批量保存引用索引", tags = {"引用索引" },  notes = "批量保存引用索引")
	@PostMapping("references_indices/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ReferencesIndexDTO> dtos) {
        referencesIndexService.save(referencesIndexDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入引用索引
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReferencesIndex-Save-all')")
    @ApiOperation(value = "批量导入引用索引", tags = {"引用索引" },  notes = "批量导入引用索引")
	@PostMapping("references_indices/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ReferencesIndexDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(referencesIndexService.importData(config,ignoreError,referencesIndexDtoMapping.toDomain(dtos))));
    }

}
