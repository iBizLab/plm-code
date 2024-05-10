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
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Review] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewResource {

    @Autowired
    public ReviewService reviewService;

    @Autowired
    @Lazy
    public ReviewDTOMapping reviewDtoMapping;

    @Autowired
    @Lazy
    public ReviewFilterDTOMapping reviewFilterDtoMapping;

    /**
    * 创建Create 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评审" },  notes = "Review-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Create-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-Create')")
    @PostMapping("libraries/{libraryId}/reviews")
    public ResponseEntity<ResponseWrapper<ReviewDTO>> createByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryId(libraryId, item)));
        else
            rt.set(createByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO createByLibraryId
            (String libraryId, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        reviewService.create(domain);
        Review rt = domain;
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评审" },  notes = "Review-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Update-all') or hasPermission('library',#libraryId,this.reviewService.get(#id),'ibizplm-Review-Update')")
    @VersionCheck(entity = "review" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/reviews/{id}")
    public ResponseEntity<ResponseWrapper<ReviewDTO>> updateByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndId(libraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO updateByLibraryIdAndId
            (String libraryId, String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewService.update(domain);
        Review rt = domain;
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评审" },  notes = "Review-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Save-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-Save')")
    @PostMapping("libraries/{libraryId}/reviews/save")
    public ResponseEntity<ResponseWrapper<ReviewDTO>> saveByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryId(libraryId, item)));
        else
            rt.set(saveByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO saveByLibraryId
            (String libraryId, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        reviewService.save(domain);
        Review rt = domain;
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * submit_review 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */
    @ApiOperation(value = "submit_review", tags = {"评审" },  notes = "Review-submit_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-submit_review-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-submit_review')")
    @PostMapping("libraries/{libraryId}/reviews/{id}/submit_review")
    public ResponseEntity<ResponseWrapper<ReviewDTO>> submitReviewByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(submitReviewByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(submitReviewByLibraryIdAndId(libraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * submit_review 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO submitReviewByLibraryIdAndId
            (String libraryId, String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.submitReview(domain);
        return reviewDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<ReviewDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评审" },  notes = "Review-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Get-all')  or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(returnObject.body),'ibizplm-Review-Get')")
    @GetMapping("libraries/{libraryId}/reviews/{id}")
    public ResponseEntity<ReviewDTO> getByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Review rt = reviewService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(reviewDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审" },  notes = "Review-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Remove-all') or hasPermission('library',#libraryId,this.reviewService.get(#id),'ibizplm-Review-Remove')")
    @DeleteMapping("libraries/{libraryId}/reviews/{id}")
    public ResponseEntity<Boolean> removeByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Boolean rt = reviewService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审" },  notes = "Review-CheckKey ")
    @PostMapping("libraries/{libraryId}/reviews/check_key")
    public ResponseEntity<Integer> checkKeyByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        Integer rt = reviewService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_attention 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<ReviewDTO>
    */
    @ApiOperation(value = "get_attention", tags = {"评审" },  notes = "Review-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-get_attention-all') or hasPermission('library',#libraryId,this.reviewService.get(#id),'ibizplm-Review-get_attention')")
    @GetMapping("libraries/{libraryId}/reviews/{id}/get_attention")
    public ResponseEntity<ReviewDTO> getAttentionByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Review rt = reviewService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(reviewDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审" },  notes = "Review-GetDraft ")
    @GetMapping("libraries/{libraryId}/reviews/get_draft")
    public ResponseEntity<ReviewDTO> getDraftByLibraryId
            (@PathVariable("libraryId") String libraryId, @SpringQueryMap ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        Review rt = reviewService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(reviewDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<ReviewDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审" },  notes = "Review-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Review-fetch_default')")
    @PostMapping("libraries/{libraryId}/reviews/fetch_default")
    public ResponseEntity<List<ReviewDTO>> fetchDefaultByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.searchDefault(context) ;
        List<ReviewDTO> list = reviewDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


}
