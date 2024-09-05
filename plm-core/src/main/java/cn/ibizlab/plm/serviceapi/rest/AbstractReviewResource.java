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
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.service.ReviewService;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

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
    public ReviewBiSearchGroupDTOMapping reviewBiSearchGroupDtoMapping;

    @Autowired
    @Lazy
    public ReviewDefGroupDTOMapping reviewDefGroupDtoMapping;

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
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评审" },  notes = "Review-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Create-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-Create')")
    @PostMapping("reviews")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>create
            (@Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评审
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO create
            (ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        reviewService.create(domain);
        Review rt = domain;
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评审" },  notes = "Review-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Update-all') or hasPermission(this.reviewService.get(#id),'ibizplm-Review-Update')")
    @VersionCheck(entity = "review" , versionfield = "updateTime")
    @PutMapping("reviews/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO updateById
            (String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewService.update(domain);
        Review rt = domain;
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * add_review_content 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "add_review_content", tags = {"评审" },  notes = "Review-add_review_content ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-add_review_content-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-add_review_content')")
    @PostMapping("reviews/{id}/add_review_content")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>addReviewContentById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addReviewContentById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addReviewContentById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_review_content 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO addReviewContentById
            (String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.addReviewContent(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * change_review_stage 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "change_review_stage", tags = {"评审" },  notes = "Review-change_review_stage ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-change_review_stage-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-change_review_stage')")
    @PostMapping("reviews/{id}/change_review_stage")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>changeReviewStageById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeReviewStageById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeReviewStageById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_review_stage 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO changeReviewStageById
            (String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.changeReviewStage(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * completed_review 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "completed_review", tags = {"评审" },  notes = "Review-completed_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-completed_review-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-completed_review')")
    @PutMapping("reviews/{id}/completed_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>completedReviewById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(completedReviewById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(completedReviewById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * completed_review 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO completedReviewById
            (String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.completedReview(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * fill_cureent_stage_info 评审
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "fill_cureent_stage_info", tags = {"评审" },  notes = "Review-fill_cureent_stage_info ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fill_cureent_stage_info-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-fill_cureent_stage_info')")
    @PostMapping("reviews/fill_cureent_stage_info")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>fillCureentStageInfo
            (@Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillCureentStageInfo(item)));
        else
            rt.set(fillCureentStageInfo(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_cureent_stage_info 评审
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO fillCureentStageInfo
            (ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        Review rt = reviewService.fillCureentStageInfo(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * fill_guideline 评审
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "fill_guideline", tags = {"评审" },  notes = "Review-fill_guideline ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fill_guideline-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-fill_guideline')")
    @PostMapping("reviews/fill_guideline")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>fillGuideline
            (@Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillGuideline(item)));
        else
            rt.set(fillGuideline(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_guideline 评审
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO fillGuideline
            (ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        Review rt = reviewService.fillGuideline(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * fill_stage_reviewer 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "fill_stage_reviewer", tags = {"评审" },  notes = "Review-fill_stage_reviewer ")
    @PostMapping("reviews/{id}/fill_stage_reviewer")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>fillStageReviewerById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillStageReviewerById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillStageReviewerById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_stage_reviewer 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO fillStageReviewerById
            (String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.fillStageReviewer(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * repeal_review 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "repeal_review", tags = {"评审" },  notes = "Review-repeal_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-repeal_review-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-repeal_review')")
    @PostMapping("reviews/{id}/repeal_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>repealReviewById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(repealReviewById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(repealReviewById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * repeal_review 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO repealReviewById
            (String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.repealReview(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评审" },  notes = "Review-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Save-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-Save')")
    @PostMapping("reviews/save")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>save
            (@Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评审
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO save
            (ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        reviewService.save(domain);
        Review rt = domain;
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * submit_review 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "submit_review", tags = {"评审" },  notes = "Review-submit_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-submit_review-all') or hasPermission(this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-submit_review')")
    @PostMapping("reviews/{id}/submit_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>submitReviewById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(submitReviewById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(submitReviewById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * submit_review 评审
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO submitReviewById
            (String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.submitReview(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评审" },  notes = "Review-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Create-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-Create')")
    @PostMapping("libraries/{libraryId}/reviews")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>createByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryId(libraryId, item)));
        else
            rt.set(createByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评审" },  notes = "Review-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Update-all') or hasPermission('library',#libraryId,this.reviewService.get(#id),'ibizplm-Review-Update')")
    @VersionCheck(entity = "review" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/reviews/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>updateByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * add_review_content 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "add_review_content", tags = {"评审" },  notes = "Review-add_review_content ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-add_review_content-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-add_review_content')")
    @PostMapping("libraries/{libraryId}/reviews/{id}/add_review_content")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>addReviewContentByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addReviewContentByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addReviewContentByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_review_content 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO addReviewContentByLibraryIdAndId
            (String libraryId, String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.addReviewContent(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * change_review_stage 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "change_review_stage", tags = {"评审" },  notes = "Review-change_review_stage ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-change_review_stage-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-change_review_stage')")
    @PostMapping("libraries/{libraryId}/reviews/{id}/change_review_stage")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>changeReviewStageByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeReviewStageByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeReviewStageByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_review_stage 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO changeReviewStageByLibraryIdAndId
            (String libraryId, String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.changeReviewStage(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * completed_review 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "completed_review", tags = {"评审" },  notes = "Review-completed_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-completed_review-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-completed_review')")
    @PutMapping("libraries/{libraryId}/reviews/{id}/completed_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>completedReviewByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(completedReviewByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(completedReviewByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * completed_review 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO completedReviewByLibraryIdAndId
            (String libraryId, String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.completedReview(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * fill_cureent_stage_info 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "fill_cureent_stage_info", tags = {"评审" },  notes = "Review-fill_cureent_stage_info ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fill_cureent_stage_info-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-fill_cureent_stage_info')")
    @PostMapping("libraries/{libraryId}/reviews/fill_cureent_stage_info")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>fillCureentStageInfoByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillCureentStageInfoByLibraryId(libraryId, item)));
        else
            rt.set(fillCureentStageInfoByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_cureent_stage_info 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO fillCureentStageInfoByLibraryId
            (String libraryId, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        Review rt = reviewService.fillCureentStageInfo(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * fill_guideline 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "fill_guideline", tags = {"评审" },  notes = "Review-fill_guideline ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fill_guideline-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-fill_guideline')")
    @PostMapping("libraries/{libraryId}/reviews/fill_guideline")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>fillGuidelineByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillGuidelineByLibraryId(libraryId, item)));
        else
            rt.set(fillGuidelineByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_guideline 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO fillGuidelineByLibraryId
            (String libraryId, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        Review rt = reviewService.fillGuideline(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * fill_stage_reviewer 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "fill_stage_reviewer", tags = {"评审" },  notes = "Review-fill_stage_reviewer ")
    @PostMapping("libraries/{libraryId}/reviews/{id}/fill_stage_reviewer")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>fillStageReviewerByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillStageReviewerByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillStageReviewerByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_stage_reviewer 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO fillStageReviewerByLibraryIdAndId
            (String libraryId, String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.fillStageReviewer(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * repeal_review 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "repeal_review", tags = {"评审" },  notes = "Review-repeal_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-repeal_review-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-repeal_review')")
    @PostMapping("libraries/{libraryId}/reviews/{id}/repeal_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>repealReviewByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(repealReviewByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(repealReviewByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * repeal_review 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewDTO>
    */   
    public ReviewDTO repealReviewByLibraryIdAndId
            (String libraryId, String id, ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setId(id);
        Review rt = reviewService.repealReview(domain);
        return reviewDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评审" },  notes = "Review-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Save-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-Save')")
    @PostMapping("libraries/{libraryId}/reviews/save")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>saveByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryId(libraryId, item)));
        else
            rt.set(saveByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "submit_review", tags = {"评审" },  notes = "Review-submit_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-submit_review-all') or hasPermission('library',#libraryId,this.reviewDtoMapping.toDomain(#dto),'ibizplm-Review-submit_review')")
    @PostMapping("libraries/{libraryId}/reviews/{id}/submit_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewDTO>>>submitReviewByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewDTO> dto) {
        ResponseWrapper<ReviewDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(submitReviewByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(submitReviewByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @param id id
    * @return Mono<ResponseEntity<ReviewDefGroupDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评审" },  notes = "Review-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Get-all')  or hasPermission(this.reviewDefGroupDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Review-Get')")
    @GetMapping("reviews/{id}")
    public Mono<ResponseEntity<ReviewDefGroupDTO>> getById
            (@PathVariable("id") String id) {
        Review rt = reviewService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewDefGroupDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评审
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审" },  notes = "Review-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Remove-all') or hasPermission(this.reviewService.get(#id),'ibizplm-Review-Remove')")
    @DeleteMapping("reviews/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = reviewService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评审
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审" },  notes = "Review-CheckKey ")
    @PostMapping("reviews/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        CheckKeyStatus rt = reviewService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 评审
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"评审" },  notes = "Review-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-get_attention-all') or hasPermission(this.reviewService.get(#id),'ibizplm-Review-get_attention')")
    @GetMapping("reviews/{id}/get_attention")
    public Mono<ResponseEntity<ReviewDTO>> getAttentionById
            (@PathVariable("id") String id) {
        Review rt = reviewService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 评审
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDefGroupDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审" },  notes = "Review-GetDraft ")
    @GetMapping("reviews/get_draft")
    public Mono<ResponseEntity<ReviewDefGroupDTO>> getDraft
            (@SpringQueryMap ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        Review rt = reviewService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewDefGroupDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_search 评审
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"评审" },  notes = "Review-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-Review-fetch_bi_search')")
    @PostMapping("reviews/fetch_bi_search")
    public Mono<ResponseEntity<List<ReviewBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody ReviewFilterDTO dto) {
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.fetchBiSearch(context) ;
        List<ReviewBiSearchGroupDTO> list = reviewBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 评审
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审" },  notes = "Review-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_default-all') or hasPermission(#dto,'ibizplm-Review-fetch_default')")
    @PostMapping("reviews/fetch_default")
    public Mono<ResponseEntity<List<ReviewDTO>>> fetchDefault
            (@Validated @RequestBody ReviewFilterDTO dto) {
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.fetchDefault(context) ;
        List<ReviewDTO> list = reviewDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 评审
    * 查询我关注的评审
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"评审" },  notes = "Review-fetch_my_attention 查询我关注的评审")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_my_attention-all') or hasPermission(#dto,'ibizplm-Review-fetch_my_attention')")
    @PostMapping("reviews/fetch_my_attention")
    public Mono<ResponseEntity<List<ReviewDTO>>> fetchMyAttention
            (@Validated @RequestBody ReviewFilterDTO dto) {
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.fetchMyAttention(context) ;
        List<ReviewDTO> list = reviewDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_reviewed 评审
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_reviewed", tags = {"评审" },  notes = "Review-fetch_my_reviewed ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_my_reviewed-all') or hasPermission(#dto,'ibizplm-Review-fetch_my_reviewed')")
    @PostMapping("reviews/fetch_my_reviewed")
    public Mono<ResponseEntity<List<ReviewDTO>>> fetchMyReviewed
            (@Validated @RequestBody ReviewFilterDTO dto) {
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.fetchMyReviewed(context) ;
        List<ReviewDTO> list = reviewDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return Mono<ResponseEntity<ReviewDefGroupDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评审" },  notes = "Review-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Get-all')  or hasPermission('library',#libraryId,this.reviewDefGroupDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Review-Get')")
    @GetMapping("libraries/{libraryId}/reviews/{id}")
    public Mono<ResponseEntity<ReviewDefGroupDTO>> getByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Review rt = reviewService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewDefGroupDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审" },  notes = "Review-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-Remove-all') or hasPermission('library',#libraryId,this.reviewService.get(#id),'ibizplm-Review-Remove')")
    @DeleteMapping("libraries/{libraryId}/reviews/{id}")
    public Mono<ResponseEntity<Boolean>> removeByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Boolean rt = reviewService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审" },  notes = "Review-CheckKey ")
    @PostMapping("libraries/{libraryId}/reviews/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        CheckKeyStatus rt = reviewService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 评审
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return Mono<ResponseEntity<ReviewDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"评审" },  notes = "Review-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-get_attention-all') or hasPermission('library',#libraryId,this.reviewService.get(#id),'ibizplm-Review-get_attention')")
    @GetMapping("libraries/{libraryId}/reviews/{id}/get_attention")
    public Mono<ResponseEntity<ReviewDTO>> getAttentionByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Review rt = reviewService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewDefGroupDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审" },  notes = "Review-GetDraft ")
    @GetMapping("libraries/{libraryId}/reviews/get_draft")
    public Mono<ResponseEntity<ReviewDefGroupDTO>> getDraftByLibraryId
            (@PathVariable("libraryId") String libraryId, @SpringQueryMap ReviewDTO dto) {
        Review domain = reviewDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        Review rt = reviewService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewDefGroupDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_search 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"评审" },  notes = "Review-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_bi_search-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Review-fetch_bi_search')")
    @PostMapping("libraries/{libraryId}/reviews/fetch_bi_search")
    public Mono<ResponseEntity<List<ReviewBiSearchGroupDTO>>> fetchBiSearchByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.fetchBiSearch(context) ;
        List<ReviewBiSearchGroupDTO> list = reviewBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审" },  notes = "Review-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Review-fetch_default')")
    @PostMapping("libraries/{libraryId}/reviews/fetch_default")
    public Mono<ResponseEntity<List<ReviewDTO>>> fetchDefaultByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.fetchDefault(context) ;
        List<ReviewDTO> list = reviewDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 评审
    * 查询我关注的评审
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"评审" },  notes = "Review-fetch_my_attention 查询我关注的评审")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_my_attention-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Review-fetch_my_attention')")
    @PostMapping("libraries/{libraryId}/reviews/fetch_my_attention")
    public Mono<ResponseEntity<List<ReviewDTO>>> fetchMyAttentionByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.fetchMyAttention(context) ;
        List<ReviewDTO> list = reviewDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_reviewed 评审
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_reviewed", tags = {"评审" },  notes = "Review-fetch_my_reviewed ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Review-fetch_my_reviewed-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Review-fetch_my_reviewed')")
    @PostMapping("libraries/{libraryId}/reviews/fetch_my_reviewed")
    public Mono<ResponseEntity<List<ReviewDTO>>> fetchMyReviewedByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody ReviewFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        ReviewSearchContext context = reviewFilterDtoMapping.toDomain(dto);
        Page<Review> domains = reviewService.fetchMyReviewed(context) ;
        List<ReviewDTO> list = reviewDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建评审
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Review-Create-all')")
    @ApiOperation(value = "批量新建评审", tags = {"评审" },  notes = "批量新建评审")
	@PostMapping("reviews/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ReviewDTO> dtos) {
        reviewService.create(reviewDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除评审
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Review-Remove-all')")
    @ApiOperation(value = "批量删除评审", tags = {"评审" },  notes = "批量删除评审")
	@DeleteMapping("reviews/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        reviewService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新评审
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Review-Update-all')")
    @ApiOperation(value = "批量更新评审", tags = {"评审" },  notes = "批量更新评审")
	@PutMapping("reviews/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ReviewDTO> dtos) {
        reviewService.update(reviewDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存评审
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Review-Save-all')")
    @ApiOperation(value = "批量保存评审", tags = {"评审" },  notes = "批量保存评审")
	@PostMapping("reviews/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ReviewDTO> dtos) {
        reviewService.save(reviewDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入评审
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Review-Save-all')")
    @ApiOperation(value = "批量导入评审", tags = {"评审" },  notes = "批量导入评审")
	@PostMapping("reviews/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ReviewDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewService.importData(config,ignoreError,reviewDtoMapping.toDomain(dtos))));
    }

}
