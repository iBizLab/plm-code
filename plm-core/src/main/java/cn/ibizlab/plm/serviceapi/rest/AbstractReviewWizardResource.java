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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.testmgmt.service.ReviewWizardService;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewWizardSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[ReviewWizard] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewWizardResource {

    @Autowired
    public ReviewWizardService reviewWizardService;

    @Autowired
    @Lazy
    public ReviewWizardDTOMapping reviewWizardDtoMapping;

    @Autowired
    @Lazy
    public ReviewWizardFilterDTOMapping reviewWizardFilterDtoMapping;

    /**
    * 创建Create 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评审向导" },  notes = "ReviewWizard-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Create-all') or hasPermission(this.reviewWizardDtoMapping.toDomain(#dto),'ibizplm-ReviewWizard-Create')")
    @PostMapping("review_wizards")
    public ResponseEntity<ResponseWrapper<ReviewWizardDTO>> create
            (@Validated @RequestBody RequestWrapper<ReviewWizardDTO> dto) {
        ResponseWrapper<ReviewWizardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */   
    public ReviewWizardDTO create
            (ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        reviewWizardService.create(domain);
        ReviewWizard rt = domain;
        return reviewWizardDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审向导
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评审向导" },  notes = "ReviewWizard-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Update-all') or hasPermission(this.reviewWizardService.get(#id),'ibizplm-ReviewWizard-Update')")
    @VersionCheck(entity = "reviewwizard" , versionfield = "updateTime")
    @PutMapping("review_wizards/{id}")
    public ResponseEntity<ResponseWrapper<ReviewWizardDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewWizardDTO> dto) {
        ResponseWrapper<ReviewWizardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 评审向导
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */   
    public ReviewWizardDTO updateById
            (String id, ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewWizardService.update(domain);
        ReviewWizard rt = domain;
        return reviewWizardDtoMapping.toDto(rt);
    }

    /**
    * fill_guideline 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "fill_guideline", tags = {"评审向导" },  notes = "ReviewWizard-fill_guideline ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-fill_guideline-all') or hasPermission(this.reviewWizardDtoMapping.toDomain(#dto),'ibizplm-ReviewWizard-fill_guideline')")
    @PostMapping("review_wizards/fill_guideline")
    public ResponseEntity<ResponseWrapper<ReviewWizardDTO>> fillGuideline
            (@Validated @RequestBody RequestWrapper<ReviewWizardDTO> dto) {
        ResponseWrapper<ReviewWizardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillGuideline(item)));
        else
            rt.set(fillGuideline(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * fill_guideline 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */   
    public ReviewWizardDTO fillGuideline
            (ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        ReviewWizard rt = reviewWizardService.fillGuideline(domain);
        return reviewWizardDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评审向导" },  notes = "ReviewWizard-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Save-all') or hasPermission(this.reviewWizardDtoMapping.toDomain(#dto),'ibizplm-ReviewWizard-Save')")
    @PostMapping("review_wizards/save")
    public ResponseEntity<ResponseWrapper<ReviewWizardDTO>> save
            (@Validated @RequestBody RequestWrapper<ReviewWizardDTO> dto) {
        ResponseWrapper<ReviewWizardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */   
    public ReviewWizardDTO save
            (ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        reviewWizardService.save(domain);
        ReviewWizard rt = domain;
        return reviewWizardDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评审向导" },  notes = "ReviewWizard-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Create-all') or hasPermission('library',#libraryId,this.reviewWizardDtoMapping.toDomain(#dto),'ibizplm-ReviewWizard-Create')")
    @PostMapping("libraries/{libraryId}/review_wizards")
    public ResponseEntity<ResponseWrapper<ReviewWizardDTO>> createByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewWizardDTO> dto) {
        ResponseWrapper<ReviewWizardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryId(libraryId, item)));
        else
            rt.set(createByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */   
    public ReviewWizardDTO createByLibraryId
            (String libraryId, ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        reviewWizardService.create(domain);
        ReviewWizard rt = domain;
        return reviewWizardDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评审向导" },  notes = "ReviewWizard-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Update-all') or hasPermission('library',#libraryId,this.reviewWizardService.get(#id),'ibizplm-ReviewWizard-Update')")
    @VersionCheck(entity = "reviewwizard" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/review_wizards/{id}")
    public ResponseEntity<ResponseWrapper<ReviewWizardDTO>> updateByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewWizardDTO> dto) {
        ResponseWrapper<ReviewWizardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndId(libraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */   
    public ReviewWizardDTO updateByLibraryIdAndId
            (String libraryId, String id, ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewWizardService.update(domain);
        ReviewWizard rt = domain;
        return reviewWizardDtoMapping.toDto(rt);
    }

    /**
    * fill_guideline 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "fill_guideline", tags = {"评审向导" },  notes = "ReviewWizard-fill_guideline ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-fill_guideline-all') or hasPermission('library',#libraryId,this.reviewWizardDtoMapping.toDomain(#dto),'ibizplm-ReviewWizard-fill_guideline')")
    @PostMapping("libraries/{libraryId}/review_wizards/fill_guideline")
    public ResponseEntity<ResponseWrapper<ReviewWizardDTO>> fillGuidelineByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewWizardDTO> dto) {
        ResponseWrapper<ReviewWizardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillGuidelineByLibraryId(libraryId, item)));
        else
            rt.set(fillGuidelineByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * fill_guideline 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */   
    public ReviewWizardDTO fillGuidelineByLibraryId
            (String libraryId, ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        ReviewWizard rt = reviewWizardService.fillGuideline(domain);
        return reviewWizardDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评审向导" },  notes = "ReviewWizard-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Save-all') or hasPermission('library',#libraryId,this.reviewWizardDtoMapping.toDomain(#dto),'ibizplm-ReviewWizard-Save')")
    @PostMapping("libraries/{libraryId}/review_wizards/save")
    public ResponseEntity<ResponseWrapper<ReviewWizardDTO>> saveByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewWizardDTO> dto) {
        ResponseWrapper<ReviewWizardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryId(libraryId, item)));
        else
            rt.set(saveByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */   
    public ReviewWizardDTO saveByLibraryId
            (String libraryId, ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        reviewWizardService.save(domain);
        ReviewWizard rt = domain;
        return reviewWizardDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 评审向导
    * 
    *
    * @param id id
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评审向导" },  notes = "ReviewWizard-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Get-all')  or hasPermission(this.reviewWizardDtoMapping.toDomain(returnObject.body),'ibizplm-ReviewWizard-Get')")
    @GetMapping("review_wizards/{id}")
    public ResponseEntity<ReviewWizardDTO> getById
            (@PathVariable("id") String id) {
        ReviewWizard rt = reviewWizardService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(reviewWizardDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评审向导
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审向导" },  notes = "ReviewWizard-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Remove-all') or hasPermission(this.reviewWizardService.get(#id),'ibizplm-ReviewWizard-Remove')")
    @DeleteMapping("review_wizards/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = reviewWizardService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审向导" },  notes = "ReviewWizard-CheckKey ")
    @PostMapping("review_wizards/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        Integer rt = reviewWizardService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审向导" },  notes = "ReviewWizard-GetDraft ")
    @GetMapping("review_wizards/get_draft")
    public ResponseEntity<ReviewWizardDTO> getDraft
            (@SpringQueryMap ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        ReviewWizard rt = reviewWizardService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(reviewWizardDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评审向导
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ReviewWizardDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审向导" },  notes = "ReviewWizard-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-fetch_default-all') or hasPermission(#dto,'ibizplm-ReviewWizard-fetch_default')")
    @PostMapping("review_wizards/fetch_default")
    public ResponseEntity<List<ReviewWizardDTO>> fetchDefault
            (@Validated @RequestBody ReviewWizardFilterDTO dto) {
        ReviewWizardSearchContext context = reviewWizardFilterDtoMapping.toDomain(dto);
        Page<ReviewWizard> domains = reviewWizardService.fetchDefault(context) ;
        List<ReviewWizardDTO> list = reviewWizardDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评审向导" },  notes = "ReviewWizard-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Get-all')  or hasPermission('library',#libraryId,this.reviewWizardDtoMapping.toDomain(returnObject.body),'ibizplm-ReviewWizard-Get')")
    @GetMapping("libraries/{libraryId}/review_wizards/{id}")
    public ResponseEntity<ReviewWizardDTO> getByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        ReviewWizard rt = reviewWizardService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(reviewWizardDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审向导" },  notes = "ReviewWizard-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-Remove-all') or hasPermission('library',#libraryId,this.reviewWizardService.get(#id),'ibizplm-ReviewWizard-Remove')")
    @DeleteMapping("libraries/{libraryId}/review_wizards/{id}")
    public ResponseEntity<Boolean> removeByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Boolean rt = reviewWizardService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审向导" },  notes = "ReviewWizard-CheckKey ")
    @PostMapping("libraries/{libraryId}/review_wizards/check_key")
    public ResponseEntity<Integer> checkKeyByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        Integer rt = reviewWizardService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewWizardDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审向导" },  notes = "ReviewWizard-GetDraft ")
    @GetMapping("libraries/{libraryId}/review_wizards/get_draft")
    public ResponseEntity<ReviewWizardDTO> getDraftByLibraryId
            (@PathVariable("libraryId") String libraryId, @SpringQueryMap ReviewWizardDTO dto) {
        ReviewWizard domain = reviewWizardDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        ReviewWizard rt = reviewWizardService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(reviewWizardDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评审向导
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<ReviewWizardDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审向导" },  notes = "ReviewWizard-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewWizard-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-ReviewWizard-fetch_default')")
    @PostMapping("libraries/{libraryId}/review_wizards/fetch_default")
    public ResponseEntity<List<ReviewWizardDTO>> fetchDefaultByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewWizardFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        ReviewWizardSearchContext context = reviewWizardFilterDtoMapping.toDomain(dto);
        Page<ReviewWizard> domains = reviewWizardService.fetchDefault(context) ;
        List<ReviewWizardDTO> list = reviewWizardDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建评审向导
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewWizard-Create-all')")
    @ApiOperation(value = "批量新建评审向导", tags = {"评审向导" },  notes = "批量新建评审向导")
	@PostMapping("review_wizards/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ReviewWizardDTO> dtos) {
        reviewWizardService.create(reviewWizardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除评审向导
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewWizard-Remove-all')")
    @ApiOperation(value = "批量删除评审向导", tags = {"评审向导" },  notes = "批量删除评审向导")
	@DeleteMapping("review_wizards/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        reviewWizardService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新评审向导
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewWizard-Update-all')")
    @ApiOperation(value = "批量更新评审向导", tags = {"评审向导" },  notes = "批量更新评审向导")
	@PutMapping("review_wizards/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ReviewWizardDTO> dtos) {
        reviewWizardService.update(reviewWizardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存评审向导
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewWizard-Save-all')")
    @ApiOperation(value = "批量保存评审向导", tags = {"评审向导" },  notes = "批量保存评审向导")
	@PostMapping("review_wizards/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ReviewWizardDTO> dtos) {
        reviewWizardService.save(reviewWizardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入评审向导
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewWizard-Save-all')")
    @ApiOperation(value = "批量导入评审向导", tags = {"评审向导" },  notes = "批量导入评审向导")
	@PostMapping("review_wizards/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ReviewWizardDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(reviewWizardService.importData(config,ignoreError,reviewWizardDtoMapping.toDomain(dtos)));
    }

}
