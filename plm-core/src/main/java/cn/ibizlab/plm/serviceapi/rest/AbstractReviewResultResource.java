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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.core.testmgmt.service.ReviewResultService;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewResultSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[ReviewResult] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewResultResource {

    @Autowired
    public ReviewResultService reviewResultService;

    @Autowired
    @Lazy
    public ReviewResultDTOMapping reviewResultDtoMapping;

    @Autowired
    @Lazy
    public ReviewResultFilterDTOMapping reviewResultFilterDtoMapping;

    /**
    * 创建Create 评审结果
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewResultDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评审结果" },  notes = "ReviewResult-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewResult-Create-all') or hasPermission(this.reviewResultDtoMapping.toDomain(#dto),'ibizplm-ReviewResult-Create')")
    @PostMapping("review_results")
    public Mono<ResponseEntity<ResponseWrapper<ReviewResultDTO>>>create
            (@Validated @RequestBody RequestWrapper<ReviewResultDTO> dto) {
        ResponseWrapper<ReviewResultDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评审结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewResultDTO>
    */   
    public ReviewResultDTO create
            (ReviewResultDTO dto) {
        ReviewResult domain = reviewResultDtoMapping.toDomain(dto);
        reviewResultService.create(domain);
        ReviewResult rt = domain;
        return reviewResultDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewResultDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评审结果" },  notes = "ReviewResult-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewResult-Update-all') or hasPermission(this.reviewResultService.get(#id),'ibizplm-ReviewResult-Update')")
    @VersionCheck(entity = "reviewresult" , versionfield = "updateTime")
    @PutMapping("review_results/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReviewResultDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewResultDTO> dto) {
        ResponseWrapper<ReviewResultDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评审结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewResultDTO>
    */   
    public ReviewResultDTO updateById
            (String id, ReviewResultDTO dto) {
        ReviewResult domain = reviewResultDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewResultService.update(domain);
        ReviewResult rt = domain;
        return reviewResultDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审结果
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewResultDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评审结果" },  notes = "ReviewResult-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewResult-Save-all') or hasPermission(this.reviewResultDtoMapping.toDomain(#dto),'ibizplm-ReviewResult-Save')")
    @PostMapping("review_results/save")
    public Mono<ResponseEntity<ResponseWrapper<ReviewResultDTO>>>save
            (@Validated @RequestBody RequestWrapper<ReviewResultDTO> dto) {
        ResponseWrapper<ReviewResultDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评审结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewResultDTO>
    */   
    public ReviewResultDTO save
            (ReviewResultDTO dto) {
        ReviewResult domain = reviewResultDtoMapping.toDomain(dto);
        reviewResultService.save(domain);
        ReviewResult rt = domain;
        return reviewResultDtoMapping.toDto(rt);
    }

    /**
    * set_result 评审结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewResultDTO>>
    */
    @ApiOperation(value = "set_result", tags = {"评审结果" },  notes = "ReviewResult-set_result ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewResult-set_result-all') or hasPermission(this.reviewResultDtoMapping.toDomain(#dto),'ibizplm-ReviewResult-set_result')")
    @PostMapping("review_results/{id}/set_result")
    public Mono<ResponseEntity<ResponseWrapper<ReviewResultDTO>>>setResultById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewResultDTO> dto) {
        ResponseWrapper<ReviewResultDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setResultById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setResultById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_result 评审结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewResultDTO>
    */   
    public ReviewResultDTO setResultById
            (String id, ReviewResultDTO dto) {
        ReviewResult domain = reviewResultDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewResult rt = reviewResultService.setResult(domain);
        return reviewResultDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 评审结果
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ReviewResultDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评审结果" },  notes = "ReviewResult-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewResult-Get-all')  or hasPermission(this.reviewResultDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ReviewResult-Get')")
    @GetMapping("review_results/{id}")
    public Mono<ResponseEntity<ReviewResultDTO>> getById
            (@PathVariable("id") String id) {
        ReviewResult rt = reviewResultService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewResultDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评审结果
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审结果" },  notes = "ReviewResult-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewResult-Remove-all') or hasPermission(this.reviewResultService.get(#id),'ibizplm-ReviewResult-Remove')")
    @DeleteMapping("review_results/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = reviewResultService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评审结果
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审结果" },  notes = "ReviewResult-CheckKey ")
    @PostMapping("review_results/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ReviewResultDTO dto) {
        ReviewResult domain = reviewResultDtoMapping.toDomain(dto);
        CheckKeyStatus rt = reviewResultService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评审结果
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewResultDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审结果" },  notes = "ReviewResult-GetDraft ")
    @GetMapping("review_results/get_draft")
    public Mono<ResponseEntity<ReviewResultDTO>> getDraft
            (@SpringQueryMap ReviewResultDTO dto) {
        ReviewResult domain = reviewResultDtoMapping.toDomain(dto);
        ReviewResult rt = reviewResultService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewResultDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评审结果
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewResultDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审结果" },  notes = "ReviewResult-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewResult-fetch_default-all') or hasPermission(#dto,'ibizplm-ReviewResult-fetch_default')")
    @PostMapping("review_results/fetch_default")
    public Mono<ResponseEntity<List<ReviewResultDTO>>> fetchDefault
            (@Validated @RequestBody ReviewResultFilterDTO dto) {
        ReviewResultSearchContext context = reviewResultFilterDtoMapping.toDomain(dto);
        Page<ReviewResult> domains = reviewResultService.fetchDefault(context) ;
        List<ReviewResultDTO> list = reviewResultDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建评审结果
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewResult-Create-all')")
    @ApiOperation(value = "批量新建评审结果", tags = {"评审结果" },  notes = "批量新建评审结果")
	@PostMapping("review_results/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ReviewResultDTO> dtos) {
        reviewResultService.create(reviewResultDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除评审结果
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewResult-Remove-all')")
    @ApiOperation(value = "批量删除评审结果", tags = {"评审结果" },  notes = "批量删除评审结果")
	@DeleteMapping("review_results/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        reviewResultService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新评审结果
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewResult-Update-all')")
    @ApiOperation(value = "批量更新评审结果", tags = {"评审结果" },  notes = "批量更新评审结果")
	@PutMapping("review_results/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ReviewResultDTO> dtos) {
        reviewResultService.update(reviewResultDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存评审结果
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewResult-Save-all')")
    @ApiOperation(value = "批量保存评审结果", tags = {"评审结果" },  notes = "批量保存评审结果")
	@PostMapping("review_results/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ReviewResultDTO> dtos) {
        reviewResultService.save(reviewResultDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入评审结果
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewResult-Save-all')")
    @ApiOperation(value = "批量导入评审结果", tags = {"评审结果" },  notes = "批量导入评审结果")
	@PostMapping("review_results/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ReviewResultDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewResultService.importData(config,ignoreError,reviewResultDtoMapping.toDomain(dtos))));
    }

}
