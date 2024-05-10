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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.testmgmt.service.ReviewContentService;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewContentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评审内容" },  notes = "ReviewContent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Create-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Create')")
    @PostMapping("test_cases/{targetId}/review_contents")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> createByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTargetId(targetId, item)));
        else
            rt.set(createByTargetId(targetId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评审内容" },  notes = "ReviewContent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Update-all') or hasPermission('test_case',#targetId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Update')")
    @VersionCheck(entity = "reviewcontent" , versionfield = "updateTime")
    @PutMapping("test_cases/{targetId}/review_contents/{id}")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> updateByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTargetIdAndId(targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTargetIdAndId(targetId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * program_test_case 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "program_test_case", tags = {"评审内容" },  notes = "ReviewContent-program_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-program_test_case-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-program_test_case')")
    @PutMapping("test_cases/{targetId}/review_contents/{id}/program_test_case")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> programTestCaseByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseByTargetIdAndId(targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseByTargetIdAndId(targetId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "review_content_total", tags = {"评审内容" },  notes = "ReviewContent-review_content_total ")
    @PostMapping("test_cases/{targetId}/review_contents/review_content_total")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> reviewContentTotalByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(reviewContentTotalByTargetId(targetId, item)));
        else
            rt.set(reviewContentTotalByTargetId(targetId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评审内容" },  notes = "ReviewContent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Save-all') or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Save')")
    @PostMapping("test_cases/{targetId}/review_contents/save")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> saveByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTargetId(targetId, item)));
        else
            rt.set(saveByTargetId(targetId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 创建Create 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评审内容" },  notes = "ReviewContent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Create-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> createByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(createByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评审内容" },  notes = "ReviewContent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Update-all') or hasPermission('library',#testLibraryId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Update')")
    @VersionCheck(entity = "reviewcontent" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> updateByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * program_test_case 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "program_test_case", tags = {"评审内容" },  notes = "ReviewContent-program_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-program_test_case-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-program_test_case')")
    @PutMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}/program_test_case")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> programTestCaseByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseByTestLibraryIdAndTargetIdAndId(testLibraryId, targetId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "review_content_total", tags = {"评审内容" },  notes = "ReviewContent-review_content_total ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/review_content_total")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> reviewContentTotalByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(reviewContentTotalByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(reviewContentTotalByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评审内容" },  notes = "ReviewContent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Save-all') or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/save")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> saveByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndTargetId(testLibraryId, targetId, item)));
        else
            rt.set(saveByTestLibraryIdAndTargetId(testLibraryId, targetId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 创建Create 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评审内容" },  notes = "ReviewContent-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Create-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Create')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> createByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(createByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评审内容" },  notes = "ReviewContent-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Update-all') or hasPermission('library',#libraryId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Update')")
    @VersionCheck(entity = "reviewcontent" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> updateByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * program_test_case 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "program_test_case", tags = {"评审内容" },  notes = "ReviewContent-program_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-program_test_case-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-program_test_case')")
    @PutMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}/program_test_case")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> programTestCaseByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "review_content_total", tags = {"评审内容" },  notes = "ReviewContent-review_content_total ")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/review_content_total")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> reviewContentTotalByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(reviewContentTotalByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(reviewContentTotalByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评审内容" },  notes = "ReviewContent-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Save-all') or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(#dto),'ibizplm-ReviewContent-Save')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/save")
    public ResponseEntity<ResponseWrapper<ReviewContentDTO>> saveByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<ReviewContentDTO> dto) {
        ResponseWrapper<ReviewContentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(saveByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 获取Get 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评审内容" },  notes = "ReviewContent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Get-all')  or hasPermission('test_case',#targetId,this.reviewContentDtoMapping.toDomain(returnObject.body),'ibizplm-ReviewContent-Get')")
    @GetMapping("test_cases/{targetId}/review_contents/{id}")
    public ResponseEntity<ReviewContentDTO> getByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id) {
        ReviewContent rt = reviewContentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评审内容
    * 
    *
    * @param targetId targetId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审内容" },  notes = "ReviewContent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Remove-all') or hasPermission('test_case',#targetId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Remove')")
    @DeleteMapping("test_cases/{targetId}/review_contents/{id}")
    public ResponseEntity<Boolean> removeByTargetIdAndId
            (@PathVariable("targetId") String targetId, @PathVariable("id") String id) {
        Boolean rt = reviewContentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审内容" },  notes = "ReviewContent-CheckKey ")
    @PostMapping("test_cases/{targetId}/review_contents/check_key")
    public ResponseEntity<Integer> checkKeyByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        Integer rt = reviewContentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审内容" },  notes = "ReviewContent-GetDraft ")
    @GetMapping("test_cases/{targetId}/review_contents/get_draft")
    public ResponseEntity<ReviewContentDTO> getDraftByTargetId
            (@PathVariable("targetId") String targetId, @SpringQueryMap ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_all 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<List<ReviewContentDTO>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"评审内容" },  notes = "ReviewContent-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_all-all') or hasPermission('test_case',#targetId,#dto,'ibizplm-ReviewContent-fetch_all')")
    @PostMapping("test_cases/{targetId}/review_contents/fetch_all")
    public ResponseEntity<List<ReviewContentDTO>> fetchAllByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.searchAll(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 评审内容
    * 
    *
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<List<ReviewContentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审内容" },  notes = "ReviewContent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_default-all') or hasPermission('test_case',#targetId,#dto,'ibizplm-ReviewContent-fetch_default')")
    @PostMapping("test_cases/{targetId}/review_contents/fetch_default")
    public ResponseEntity<List<ReviewContentDTO>> fetchDefaultByTargetId
            (@PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.searchDefault(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评审内容" },  notes = "ReviewContent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Get-all')  or hasPermission('library',#testLibraryId,this.reviewContentDtoMapping.toDomain(returnObject.body),'ibizplm-ReviewContent-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}")
    public ResponseEntity<ReviewContentDTO> getByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id) {
        ReviewContent rt = reviewContentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审内容" },  notes = "ReviewContent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Remove-all') or hasPermission('library',#testLibraryId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/{id}")
    public ResponseEntity<Boolean> removeByTestLibraryIdAndTargetIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @PathVariable("id") String id) {
        Boolean rt = reviewContentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审内容" },  notes = "ReviewContent-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/check_key")
    public ResponseEntity<Integer> checkKeyByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        Integer rt = reviewContentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审内容" },  notes = "ReviewContent-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/get_draft")
    public ResponseEntity<ReviewContentDTO> getDraftByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @SpringQueryMap ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setTargetId(targetId);
        ReviewContent rt = reviewContentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_all 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<List<ReviewContentDTO>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"评审内容" },  notes = "ReviewContent-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_all-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-ReviewContent-fetch_all')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/fetch_all")
    public ResponseEntity<List<ReviewContentDTO>> fetchAllByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.searchAll(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 评审内容
    * 
    *
    * @param testLibraryId testLibraryId
    * @param targetId targetId
    * @param dto dto
    * @return ResponseEntity<List<ReviewContentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审内容" },  notes = "ReviewContent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-ReviewContent-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{targetId}/review_contents/fetch_default")
    public ResponseEntity<List<ReviewContentDTO>> fetchDefaultByTestLibraryIdAndTargetId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("targetId") String targetId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setTargetIdEQ(targetId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.searchDefault(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评审内容" },  notes = "ReviewContent-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Get-all')  or hasPermission('library',#libraryId,this.reviewContentDtoMapping.toDomain(returnObject.body),'ibizplm-ReviewContent-Get')")
    @GetMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}")
    public ResponseEntity<ReviewContentDTO> getByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        ReviewContent rt = reviewContentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评审内容" },  notes = "ReviewContent-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-Remove-all') or hasPermission('library',#libraryId,this.reviewContentService.get(#id),'ibizplm-ReviewContent-Remove')")
    @DeleteMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/{id}")
    public ResponseEntity<Boolean> removeByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = reviewContentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评审内容" },  notes = "ReviewContent-CheckKey ")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/check_key")
    public ResponseEntity<Integer> checkKeyByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = reviewContentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<ReviewContentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评审内容" },  notes = "ReviewContent-GetDraft ")
    @GetMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/get_draft")
    public ResponseEntity<ReviewContentDTO> getDraftByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @SpringQueryMap ReviewContentDTO dto) {
        ReviewContent domain = reviewContentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        ReviewContent rt = reviewContentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(reviewContentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_all 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<ReviewContentDTO>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"评审内容" },  notes = "ReviewContent-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_all-all') or hasPermission('library',#libraryId,#dto,'ibizplm-ReviewContent-fetch_all')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/fetch_all")
    public ResponseEntity<List<ReviewContentDTO>> fetchAllByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.searchAll(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 评审内容
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<ReviewContentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评审内容" },  notes = "ReviewContent-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ReviewContent-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-ReviewContent-fetch_default')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/review_contents/fetch_default")
    public ResponseEntity<List<ReviewContentDTO>> fetchDefaultByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody ReviewContentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        ReviewContentSearchContext context = reviewContentFilterDtoMapping.toDomain(dto);
        Page<ReviewContent> domains = reviewContentService.searchDefault(context) ;
        List<ReviewContentDTO> list = reviewContentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


}
