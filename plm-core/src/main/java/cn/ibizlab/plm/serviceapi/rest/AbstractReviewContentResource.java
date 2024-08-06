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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentService;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewContentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[ReviewContent] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReviewContentResource {

    @Autowired
    public ReviewContentService reviewContentService;

    @Autowired
    @Lazy
    public ReviewContentDTOMapping reviewContentDtoMapping;

    @Autowired
    @Lazy
    public ReviewContentFilterDTOMapping reviewContentFilterDtoMapping;

    /**
    * 创建Create 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评审内容" },  notes = "ReviewContent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Create-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Create')")
    @PostMapping("review_contents")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>create
            (@Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO create
            (ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        reviewContentService.create(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评审内容" },  notes = "ReviewContent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Update-all') or hasPermission(this.reviewContentService.get(#id),'ibizplm-ReviewContent-Update')")
    @VersionCheck(entity = "reviewcontent" , versionfield = "updateTime")
    @PutMapping("review_contents/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO updateById
            (String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewContentService.update(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "add_review_content", tags = {"评审内容" },  notes = "ReviewContent-add_review_content ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-add_review_content-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-add_review_content')")
    @PostMapping("review_contents/{id}/add_review_content")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>addReviewContentById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addReviewContentById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addReviewContentById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO addReviewContentById
            (String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.addReviewContent(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "complete_review", tags = {"评审内容" },  notes = "ReviewContent-complete_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-complete_review-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-complete_review')")
    @PostMapping("review_contents/complete_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>completeReview
            (@Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(completeReview(item)));
        else
            rt.set(completeReview(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO completeReview
            (ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        ReviewContent rt = reviewContentService.completeReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "nothing", tags = {"评审内容" },  notes = "ReviewContent-nothing ")
    @PostMapping("review_contents/{id}/nothing")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>nothingById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(nothingById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(nothingById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO nothingById
            (String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.nothing(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "program_test_case", tags = {"评审内容" },  notes = "ReviewContent-program_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-program_test_case-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-program_test_case')")
    @PutMapping("review_contents/{id}/program_test_case")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>programTestCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO programTestCaseById
            (String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.programTestCase(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "review_content_total", tags = {"评审内容" },  notes = "ReviewContent-review_content_total ")
    @PostMapping("review_contents/review_content_total")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>reviewContentTotal
            (@Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(reviewContentTotal(item)));
        else
            rt.set(reviewContentTotal(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO reviewContentTotal
            (ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        ReviewContent rt = reviewContentService.reviewContentTotal(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评审内容" },  notes = "ReviewContent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Save-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Save')")
    @PostMapping("review_contents/save")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>save
            (@Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO save
            (ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        reviewContentService.save(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result", tags = {"评审内容" },  notes = "ReviewContent-set_review_result ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result')")
    @PostMapping("review_contents/{id}/set_review_result")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setReviewResultById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setReviewResultById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultById
            (String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.setReviewResult(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result_all", tags = {"评审内容" },  notes = "ReviewContent-set_review_result_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result_all-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result_all')")
    @PostMapping("review_contents/set_review_result_all")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultAll
            (@Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setReviewResultAll(item)));
        else
            rt.set(setReviewResultAll(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultAll
            (ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        ReviewContent rt = reviewContentService.setReviewResultAll(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "start_review", tags = {"评审内容" },  notes = "ReviewContent-start_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-start_review-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-start_review')")
    @PostMapping("review_contents/start_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>startReview
            (@Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(startReview(item)));
        else
            rt.set(startReview(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO startReview
            (ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        ReviewContent rt = reviewContentService.startReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "submit_review", tags = {"评审内容" },  notes = "ReviewContent-submit_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-submit_review-all') or hasPermission(this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-submit_review')")
    @PostMapping("review_contents/submit_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>submitReview
            (@Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(submitReview(item)));
        else
            rt.set(submitReview(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO submitReview
            (ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        ReviewContent rt = reviewContentService.submitReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评审内容" },  notes = "ReviewContent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Create-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Create')")
    @PostMapping("reviews/{principalId}/review_contents")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>createByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPrincipalId(principalId, item)));
        else
            rt.set(createByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO createByPrincipalId
            (String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        reviewContentService.create(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评审内容" },  notes = "ReviewContent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Update-all') or hasPermission('review',#principalId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Update')")
    @VersionCheck(entity = "reviewcontent" , versionfield = "updateTime")
    @PutMapping("reviews/{principalId}/review_contents/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>updateByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPrincipalIdAndId(principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO updateByPrincipalIdAndId
            (String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewContentService.update(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "add_review_content", tags = {"评审内容" },  notes = "ReviewContent-add_review_content ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-add_review_content-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-add_review_content')")
    @PostMapping("reviews/{principalId}/review_contents/{id}/add_review_content")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>addReviewContentByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addReviewContentByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addReviewContentByPrincipalIdAndId(principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO addReviewContentByPrincipalIdAndId
            (String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.addReviewContent(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "complete_review", tags = {"评审内容" },  notes = "ReviewContent-complete_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-complete_review-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-complete_review')")
    @PostMapping("reviews/{principalId}/review_contents/complete_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>completeReviewByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(completeReviewByPrincipalId(principalId, item)));
        else
            rt.set(completeReviewByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO completeReviewByPrincipalId
            (String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.completeReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "nothing", tags = {"评审内容" },  notes = "ReviewContent-nothing ")
    @PostMapping("reviews/{principalId}/review_contents/{id}/nothing")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>nothingByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(nothingByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(nothingByPrincipalIdAndId(principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO nothingByPrincipalIdAndId
            (String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.nothing(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "program_test_case", tags = {"评审内容" },  notes = "ReviewContent-program_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-program_test_case-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-program_test_case')")
    @PutMapping("reviews/{principalId}/review_contents/{id}/program_test_case")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>programTestCaseByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseByPrincipalIdAndId(principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO programTestCaseByPrincipalIdAndId
            (String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.programTestCase(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "review_content_total", tags = {"评审内容" },  notes = "ReviewContent-review_content_total ")
    @PostMapping("reviews/{principalId}/review_contents/review_content_total")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>reviewContentTotalByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(reviewContentTotalByPrincipalId(principalId, item)));
        else
            rt.set(reviewContentTotalByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO reviewContentTotalByPrincipalId
            (String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.reviewContentTotal(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评审内容" },  notes = "ReviewContent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Save-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Save')")
    @PostMapping("reviews/{principalId}/review_contents/save")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>saveByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPrincipalId(principalId, item)));
        else
            rt.set(saveByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO saveByPrincipalId
            (String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        reviewContentService.save(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result", tags = {"评审内容" },  notes = "ReviewContent-set_review_result ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result')")
    @PostMapping("reviews/{principalId}/review_contents/{id}/set_review_result")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setReviewResultByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setReviewResultByPrincipalIdAndId(principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultByPrincipalIdAndId
            (String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.setReviewResult(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result_all", tags = {"评审内容" },  notes = "ReviewContent-set_review_result_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result_all-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result_all')")
    @PostMapping("reviews/{principalId}/review_contents/set_review_result_all")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultAllByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setReviewResultAllByPrincipalId(principalId, item)));
        else
            rt.set(setReviewResultAllByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultAllByPrincipalId
            (String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.setReviewResultAll(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "start_review", tags = {"评审内容" },  notes = "ReviewContent-start_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-start_review-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-start_review')")
    @PostMapping("reviews/{principalId}/review_contents/start_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>startReviewByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(startReviewByPrincipalId(principalId, item)));
        else
            rt.set(startReviewByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO startReviewByPrincipalId
            (String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.startReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "submit_review", tags = {"评审内容" },  notes = "ReviewContent-submit_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-submit_review-all') or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-submit_review')")
    @PostMapping("reviews/{principalId}/review_contents/submit_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>submitReviewByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(submitReviewByPrincipalId(principalId, item)));
        else
            rt.set(submitReviewByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO submitReviewByPrincipalId
            (String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.submitReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评审内容" },  notes = "ReviewContent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Create-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Create')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>createByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(createByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO createByLibraryIdAndPrincipalId
            (String libraryId, String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        reviewContentService.create(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评审内容" },  notes = "ReviewContent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Update-all') or hasPermission('library',#libraryId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Update')")
    @VersionCheck(entity = "reviewcontent" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>updateByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO updateByLibraryIdAndPrincipalIdAndId
            (String libraryId, String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewContentService.update(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "add_review_content", tags = {"评审内容" },  notes = "ReviewContent-add_review_content ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-add_review_content-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-add_review_content')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}/add_review_content")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>addReviewContentByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addReviewContentByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addReviewContentByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO addReviewContentByLibraryIdAndPrincipalIdAndId
            (String libraryId, String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.addReviewContent(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "complete_review", tags = {"评审内容" },  notes = "ReviewContent-complete_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-complete_review-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-complete_review')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/complete_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>completeReviewByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(completeReviewByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(completeReviewByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO completeReviewByLibraryIdAndPrincipalId
            (String libraryId, String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.completeReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "nothing", tags = {"评审内容" },  notes = "ReviewContent-nothing ")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}/nothing")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>nothingByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(nothingByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(nothingByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO nothingByLibraryIdAndPrincipalIdAndId
            (String libraryId, String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.nothing(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "program_test_case", tags = {"评审内容" },  notes = "ReviewContent-program_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-program_test_case-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-program_test_case')")
    @PutMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}/program_test_case")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>programTestCaseByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO programTestCaseByLibraryIdAndPrincipalIdAndId
            (String libraryId, String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.programTestCase(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "review_content_total", tags = {"评审内容" },  notes = "ReviewContent-review_content_total ")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/review_content_total")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>reviewContentTotalByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(reviewContentTotalByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(reviewContentTotalByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO reviewContentTotalByLibraryIdAndPrincipalId
            (String libraryId, String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.reviewContentTotal(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评审内容" },  notes = "ReviewContent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Save-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Save')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/save")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>saveByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(saveByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO saveByLibraryIdAndPrincipalId
            (String libraryId, String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        reviewContentService.save(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result", tags = {"评审内容" },  notes = "ReviewContent-set_review_result ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}/set_review_result")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setReviewResultByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setReviewResultByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultByLibraryIdAndPrincipalIdAndId
            (String libraryId, String principalId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.setReviewResult(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result_all", tags = {"评审内容" },  notes = "ReviewContent-set_review_result_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result_all-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result_all')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/set_review_result_all")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultAllByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setReviewResultAllByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(setReviewResultAllByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultAllByLibraryIdAndPrincipalId
            (String libraryId, String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.setReviewResultAll(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "start_review", tags = {"评审内容" },  notes = "ReviewContent-start_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-start_review-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-start_review')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/start_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>startReviewByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(startReviewByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(startReviewByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO startReviewByLibraryIdAndPrincipalId
            (String libraryId, String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.startReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "submit_review", tags = {"评审内容" },  notes = "ReviewContent-submit_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-submit_review-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-submit_review')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/submit_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>submitReviewByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(submitReviewByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(submitReviewByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO submitReviewByLibraryIdAndPrincipalId
            (String libraryId, String principalId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.submitReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评审内容" },  notes = "ReviewContent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Create-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Create')")
    @PostMapping("test_cases/{targetId}/review_contents")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>createByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTargetId(targetId, item)));
        else
            rt.set(createByTargetId(targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO createByTargetId
            (String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        reviewContentService.create(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评审内容" },  notes = "ReviewContent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Update-all') or hasPermission('test_case',#targetId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Update')")
    @VersionCheck(entity = "reviewcontent" , versionfield = "updateTime")
    @PutMapping("test_cases/{targetId}/review_contents/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>updateByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTargetIdAndId(targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTargetIdAndId(targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO updateByTargetIdAndId
            (String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewContentService.update(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "add_review_content", tags = {"评审内容" },  notes = "ReviewContent-add_review_content ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-add_review_content-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-add_review_content')")
    @PostMapping("test_cases/{targetId}/review_contents/{id}/add_review_content")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>addReviewContentByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addReviewContentByTargetIdAndId(targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addReviewContentByTargetIdAndId(targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO addReviewContentByTargetIdAndId
            (String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.addReviewContent(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "complete_review", tags = {"评审内容" },  notes = "ReviewContent-complete_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-complete_review-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-complete_review')")
    @PostMapping("test_cases/{targetId}/review_contents/complete_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>completeReviewByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(completeReviewByTargetId(targetId, item)));
        else
            rt.set(completeReviewByTargetId(targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO completeReviewByTargetId
            (String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.completeReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "nothing", tags = {"评审内容" },  notes = "ReviewContent-nothing ")
    @PostMapping("test_cases/{targetId}/review_contents/{id}/nothing")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>nothingByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(nothingByTargetIdAndId(targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(nothingByTargetIdAndId(targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO nothingByTargetIdAndId
            (String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.nothing(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "program_test_case", tags = {"评审内容" },  notes = "ReviewContent-program_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-program_test_case-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-program_test_case')")
    @PutMapping("test_cases/{targetId}/review_contents/{id}/program_test_case")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>programTestCaseByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseByTargetIdAndId(targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseByTargetIdAndId(targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO programTestCaseByTargetIdAndId
            (String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.programTestCase(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "review_content_total", tags = {"评审内容" },  notes = "ReviewContent-review_content_total ")
    @PostMapping("test_cases/{targetId}/review_contents/review_content_total")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>reviewContentTotalByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(reviewContentTotalByTargetId(targetId, item)));
        else
            rt.set(reviewContentTotalByTargetId(targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO reviewContentTotalByTargetId
            (String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.reviewContentTotal(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评审内容" },  notes = "ReviewContent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Save-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Save')")
    @PostMapping("test_cases/{targetId}/review_contents/save")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>saveByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTargetId(targetId, item)));
        else
            rt.set(saveByTargetId(targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO saveByTargetId
            (String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        reviewContentService.save(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result", tags = {"评审内容" },  notes = "ReviewContent-set_review_result ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result')")
    @PostMapping("test_cases/{targetId}/review_contents/{id}/set_review_result")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setReviewResultByTargetIdAndId(targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setReviewResultByTargetIdAndId(targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultByTargetIdAndId
            (String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.setReviewResult(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result_all", tags = {"评审内容" },  notes = "ReviewContent-set_review_result_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result_all-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result_all')")
    @PostMapping("test_cases/{targetId}/review_contents/set_review_result_all")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultAllByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setReviewResultAllByTargetId(targetId, item)));
        else
            rt.set(setReviewResultAllByTargetId(targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultAllByTargetId
            (String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.setReviewResultAll(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "start_review", tags = {"评审内容" },  notes = "ReviewContent-start_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-start_review-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-start_review')")
    @PostMapping("test_cases/{targetId}/review_contents/start_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>startReviewByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(startReviewByTargetId(targetId, item)));
        else
            rt.set(startReviewByTargetId(targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO startReviewByTargetId
            (String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.startReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "submit_review", tags = {"评审内容" },  notes = "ReviewContent-submit_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-submit_review-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-submit_review')")
    @PostMapping("test_cases/{targetId}/review_contents/submit_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>submitReviewByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(submitReviewByTargetId(targetId, item)));
        else
            rt.set(submitReviewByTargetId(targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO submitReviewByTargetId
            (String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.submitReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评审内容" },  notes = "ReviewContent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Create-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>createByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(createByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO createByTestLibraryIdAndTargetId
            (String testLibraryId, String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        reviewContentService.create(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评审内容" },  notes = "ReviewContent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Update-all') or hasPermission('library',#testLibraryId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Update')")
    @VersionCheck(entity = "reviewcontent" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>updateByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO updateByTestLibraryIdAndTargetIdAndId
            (String testLibraryId, String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        reviewContentService.update(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "add_review_content", tags = {"评审内容" },  notes = "ReviewContent-add_review_content ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-add_review_content-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-add_review_content')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}/add_review_content")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>addReviewContentByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addReviewContentByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addReviewContentByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_review_content 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO addReviewContentByTestLibraryIdAndTargetIdAndId
            (String testLibraryId, String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.addReviewContent(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "complete_review", tags = {"评审内容" },  notes = "ReviewContent-complete_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-complete_review-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-complete_review')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/complete_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>completeReviewByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(completeReviewByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(completeReviewByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * complete_review 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO completeReviewByTestLibraryIdAndTargetId
            (String testLibraryId, String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.completeReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "nothing", tags = {"评审内容" },  notes = "ReviewContent-nothing ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}/nothing")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>nothingByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(nothingByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(nothingByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * nothing 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO nothingByTestLibraryIdAndTargetIdAndId
            (String testLibraryId, String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.nothing(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "program_test_case", tags = {"评审内容" },  notes = "ReviewContent-program_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-program_test_case-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-program_test_case')")
    @PutMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}/program_test_case")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>programTestCaseByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * program_test_case 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO programTestCaseByTestLibraryIdAndTargetIdAndId
            (String testLibraryId, String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.programTestCase(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "review_content_total", tags = {"评审内容" },  notes = "ReviewContent-review_content_total ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/review_content_total")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>reviewContentTotalByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(reviewContentTotalByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(reviewContentTotalByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * review_content_total 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO reviewContentTotalByTestLibraryIdAndTargetId
            (String testLibraryId, String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.reviewContentTotal(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评审内容" },  notes = "ReviewContent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Save-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/save")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>saveByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(saveByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO saveByTestLibraryIdAndTargetId
            (String testLibraryId, String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        reviewContentService.save(domain);
        ReviewContent rt = domain;
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result", tags = {"评审内容" },  notes = "ReviewContent-set_review_result ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}/set_review_result")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setReviewResultByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setReviewResultByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultByTestLibraryIdAndTargetIdAndId
            (String testLibraryId, String targetId, String id, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setId(id);
        ReviewContent rt = reviewContentService.setReviewResult(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "set_review_result_all", tags = {"评审内容" },  notes = "ReviewContent-set_review_result_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-set_review_result_all-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-set_review_result_all')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/set_review_result_all")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>setReviewResultAllByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setReviewResultAllByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(setReviewResultAllByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_review_result_all 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO setReviewResultAllByTestLibraryIdAndTargetId
            (String testLibraryId, String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.setReviewResultAll(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "start_review", tags = {"评审内容" },  notes = "ReviewContent-start_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-start_review-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-start_review')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/start_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>startReviewByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(startReviewByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(startReviewByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_review 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO startReviewByTestLibraryIdAndTargetId
            (String testLibraryId, String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.startReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "submit_review", tags = {"评审内容" },  notes = "ReviewContent-submit_review ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-submit_review-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-submit_review')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/submit_review")
    public Mono<ResponseEntity<ResponseWrapper<ReviewContentDTO>>>submitReviewByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(submitReviewByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(submitReviewByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * submit_review 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */   
    public ReviewContentDTO submitReviewByTestLibraryIdAndTargetId
            (String testLibraryId, String targetId, ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.submitReview(domain);
        return reviewContentDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 评审内容
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评审内容" },  notes = "ReviewContent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Get-all')  or hasPermission(this.reviewContentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ReviewContent-Get')")
    @GetMapping("review_contents/{id}")
    public Mono<ResponseEntity<ReviewContentDTO>> getById
            (@PathVariable("id") String id) {
        ReviewContent rt = reviewContentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评审内容
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审内容" },  notes = "ReviewContent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Remove-all') or hasPermission(this.reviewContentService.get(#id),'ibizplm-ReviewContent-Remove')")
    @DeleteMapping("review_contents/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = reviewContentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审内容" },  notes = "ReviewContent-CheckKey ")
    @PostMapping("review_contents/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        CheckKeyStatus rt = reviewContentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审内容" },  notes = "ReviewContent-GetDraft ")
    @GetMapping("review_contents/get_draft")
    public Mono<ResponseEntity<ReviewContentDTO>> getDraft
            (@SpringQueryMap ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        ReviewContent rt = reviewContentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"评审内容" },  notes = "ReviewContent-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_all-all') or hasPermission(#dto,'ibizplm-ReviewContent-fetch_all')")
    @PostMapping("review_contents/fetch_all")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchAll
            (@Validated @RequestBody ReviewContentFilterDTO dto) {
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchAll(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审内容" },  notes = "ReviewContent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_default-all') or hasPermission(#dto,'ibizplm-ReviewContent-fetch_default')")
    @PostMapping("review_contents/fetch_default")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchDefault
            (@Validated @RequestBody ReviewContentFilterDTO dto) {
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchDefault(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_history_list 评审内容
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_history_list", tags = {"评审内容" },  notes = "ReviewContent-fetch_history_list ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_history_list-all') or hasPermission(#dto,'ibizplm-ReviewContent-fetch_history_list')")
    @PostMapping("review_contents/fetch_history_list")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchHistoryList
            (@Validated @RequestBody ReviewContentFilterDTO dto) {
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchHistoryList(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评审内容" },  notes = "ReviewContent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Get-all')  or hasPermission('review',#principalId,this.reviewContentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ReviewContent-Get')")
    @GetMapping("reviews/{principalId}/review_contents/{id}")
    public Mono<ResponseEntity<ReviewContentDTO>> getByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        ReviewContent rt = reviewContentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评审内容
    * 
    *
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审内容" },  notes = "ReviewContent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Remove-all') or hasPermission('review',#principalId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Remove')")
    @DeleteMapping("reviews/{principalId}/review_contents/{id}")
    public Mono<ResponseEntity<Boolean>> removeByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = reviewContentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审内容" },  notes = "ReviewContent-CheckKey ")
    @PostMapping("reviews/{principalId}/review_contents/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = reviewContentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审内容" },  notes = "ReviewContent-GetDraft ")
    @GetMapping("reviews/{principalId}/review_contents/get_draft")
    public Mono<ResponseEntity<ReviewContentDTO>> getDraftByPrincipalId
            (@PathVariable("principalId") String principalId, @SpringQueryMap ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"评审内容" },  notes = "ReviewContent-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_all-all') or hasPermission('review',#principalId,#dto,'ibizplm-ReviewContent-fetch_all')")
    @PostMapping("reviews/{principalId}/review_contents/fetch_all")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchAllByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchAll(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审内容" },  notes = "ReviewContent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_default-all') or hasPermission('review',#principalId,#dto,'ibizplm-ReviewContent-fetch_default')")
    @PostMapping("reviews/{principalId}/review_contents/fetch_default")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchDefaultByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchDefault(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_history_list 评审内容
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_history_list", tags = {"评审内容" },  notes = "ReviewContent-fetch_history_list ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_history_list-all') or hasPermission('review',#principalId,#dto,'ibizplm-ReviewContent-fetch_history_list')")
    @PostMapping("reviews/{principalId}/review_contents/fetch_history_list")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchHistoryListByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchHistoryList(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评审内容" },  notes = "ReviewContent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Get-all')  or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ReviewContent-Get')")
    @GetMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}")
    public Mono<ResponseEntity<ReviewContentDTO>> getByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        ReviewContent rt = reviewContentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审内容" },  notes = "ReviewContent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Remove-all') or hasPermission('library',#libraryId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Remove')")
    @DeleteMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}")
    public Mono<ResponseEntity<Boolean>> removeByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = reviewContentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审内容" },  notes = "ReviewContent-CheckKey ")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = reviewContentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审内容" },  notes = "ReviewContent-GetDraft ")
    @GetMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/get_draft")
    public Mono<ResponseEntity<ReviewContentDTO>> getDraftByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @SpringQueryMap ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"评审内容" },  notes = "ReviewContent-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_all-all') or hasPermission('library',#libraryId,#dto,'ibizplm-ReviewContent-fetch_all')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/fetch_all")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchAllByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchAll(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审内容" },  notes = "ReviewContent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-ReviewContent-fetch_default')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/fetch_default")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchDefaultByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchDefault(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_history_list 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_history_list", tags = {"评审内容" },  notes = "ReviewContent-fetch_history_list ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_history_list-all') or hasPermission('library',#libraryId,#dto,'ibizplm-ReviewContent-fetch_history_list')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/fetch_history_list")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchHistoryListByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchHistoryList(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评审内容" },  notes = "ReviewContent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Get-all')  or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ReviewContent-Get')")
    @GetMapping("test_cases/{targetId}/review_contents/{id}")
    public Mono<ResponseEntity<ReviewContentDTO>> getByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id) {
        ReviewContent rt = reviewContentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审内容" },  notes = "ReviewContent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Remove-all') or hasPermission('test_case',#targetId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Remove')")
    @DeleteMapping("test_cases/{targetId}/review_contents/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id) {
        Boolean rt = reviewContentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审内容" },  notes = "ReviewContent-CheckKey ")
    @PostMapping("test_cases/{targetId}/review_contents/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        CheckKeyStatus rt = reviewContentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审内容" },  notes = "ReviewContent-GetDraft ")
    @GetMapping("test_cases/{targetId}/review_contents/get_draft")
    public Mono<ResponseEntity<ReviewContentDTO>> getDraftByTargetId
            (@PathVariable("targetId") String targetId, @SpringQueryMap ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"评审内容" },  notes = "ReviewContent-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_all-all') or hasPermission('test_case',#targetId,#dto,'ibizplm-ReviewContent-fetch_all')")
    @PostMapping("test_cases/{targetId}/review_contents/fetch_all")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchAllByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchAll(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审内容" },  notes = "ReviewContent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_default-all') or hasPermission('test_case',#targetId,#dto,'ibizplm-ReviewContent-fetch_default')")
    @PostMapping("test_cases/{targetId}/review_contents/fetch_default")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchDefaultByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchDefault(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_history_list 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_history_list", tags = {"评审内容" },  notes = "ReviewContent-fetch_history_list ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_history_list-all') or hasPermission('test_case',#targetId,#dto,'ibizplm-ReviewContent-fetch_history_list')")
    @PostMapping("test_cases/{targetId}/review_contents/fetch_history_list")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchHistoryListByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchHistoryList(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评审内容" },  notes = "ReviewContent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Get-all')  or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ReviewContent-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}")
    public Mono<ResponseEntity<ReviewContentDTO>> getByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id) {
        ReviewContent rt = reviewContentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审内容" },  notes = "ReviewContent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Remove-all') or hasPermission('library',#testLibraryId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id) {
        Boolean rt = reviewContentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审内容" },  notes = "ReviewContent-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        CheckKeyStatus rt = reviewContentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<ReviewContentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审内容" },  notes = "ReviewContent-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/get_draft")
    public Mono<ResponseEntity<ReviewContentDTO>> getDraftByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @SpringQueryMap ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_all 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"评审内容" },  notes = "ReviewContent-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_all-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-ReviewContent-fetch_all')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/fetch_all")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchAllByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchAll(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审内容" },  notes = "ReviewContent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-ReviewContent-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/fetch_default")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchDefaultByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchDefault(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_history_list 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ReviewContentDTO>>>
    */
    @ApiOperation(value = "查询fetch_history_list", tags = {"评审内容" },  notes = "ReviewContent-fetch_history_list ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_history_list-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-ReviewContent-fetch_history_list')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/fetch_history_list")
    public Mono<ResponseEntity<List<ReviewContentDTO>>> fetchHistoryListByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.fetchHistoryList(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建评审内容
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewContent-Create-all')")
    @ApiOperation(value = "批量新建评审内容", tags = {"评审内容" },  notes = "批量新建评审内容")
	@PostMapping("review_contents/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ReviewContentDTO> dtos) {
        reviewContentService.create(reviewContentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除评审内容
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewContent-Remove-all')")
    @ApiOperation(value = "批量删除评审内容", tags = {"评审内容" },  notes = "批量删除评审内容")
	@DeleteMapping("review_contents/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        reviewContentService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新评审内容
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewContent-Update-all')")
    @ApiOperation(value = "批量更新评审内容", tags = {"评审内容" },  notes = "批量更新评审内容")
	@PutMapping("review_contents/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ReviewContentDTO> dtos) {
        reviewContentService.update(reviewContentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存评审内容
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewContent-Save-all')")
    @ApiOperation(value = "批量保存评审内容", tags = {"评审内容" },  notes = "批量保存评审内容")
	@PostMapping("review_contents/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ReviewContentDTO> dtos) {
        reviewContentService.save(reviewContentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入评审内容
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ReviewContent-Save-all')")
    @ApiOperation(value = "批量导入评审内容", tags = {"评审内容" },  notes = "批量导入评审内容")
	@PostMapping("review_contents/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ReviewContentDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(reviewContentService.importData(config,ignoreError,reviewContentDtoMapping.toDomain(dtos))));
    }

}
