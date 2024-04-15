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
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.service.SearchAttachmentService;
import cn.ibizlab.plm.core.base.filter.SearchAttachmentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[SearchAttachment] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSearchAttachmentResource {

    @Autowired
    public SearchAttachmentService searchAttachmentService;

    @Autowired
    @Lazy
    public SearchAttachmentDTOMapping searchAttachmentDtoMapping;

    @Autowired
    @Lazy
    public SearchAttachmentFilterDTOMapping searchAttachmentFilterDtoMapping;


    /**
    * 查询fetch_default 附件搜索
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SearchAttachmentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"附件搜索" },  notes = "SearchAttachment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchAttachment-fetch_default-all') or hasPermission(#dto,'ibizplm-SearchAttachment-fetch_default')")
    @PostMapping("search_attachments/fetch_default")
    public ResponseEntity<List<SearchAttachmentDTO>> fetchDefault
            (@Validated @RequestBody SearchAttachmentFilterDTO dto) {
        SearchAttachmentSearchContext context = searchAttachmentFilterDtoMapping.toDomain(dto);
        Page<SearchAttachment> domains = searchAttachmentService.searchDefault(context) ;
        List<SearchAttachmentDTO> list = searchAttachmentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_relation 附件搜索
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SearchAttachmentDTO>>
    */
    @ApiOperation(value = "查询fetch_relation", tags = {"附件搜索" },  notes = "SearchAttachment-fetch_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchAttachment-fetch_relation-all') or hasPermission(#dto,'ibizplm-SearchAttachment-fetch_relation')")
    @PostMapping("search_attachments/fetch_relation")
    public ResponseEntity<List<SearchAttachmentDTO>> fetchRelation
            (@Validated @RequestBody SearchAttachmentFilterDTO dto) {
        SearchAttachmentSearchContext context = searchAttachmentFilterDtoMapping.toDomain(dto);
        Page<SearchAttachment> domains = searchAttachmentService.searchRelation(context) ;
        List<SearchAttachmentDTO> list = searchAttachmentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


}
