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
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.service.SearchCommentService;
import cn.ibizlab.plm.core.base.filter.SearchCommentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[SearchComment] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSearchCommentResource {

    @Autowired
    public SearchCommentService searchCommentService;

    @Autowired
    @Lazy
    public SearchCommentDTOMapping searchCommentDtoMapping;

    @Autowired
    @Lazy
    public SearchCommentFilterDTOMapping searchCommentFilterDtoMapping;


    /**
    * 查询fetch_default 评论搜索
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SearchCommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论搜索" },  notes = "SearchComment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchComment-fetch_default-all') or hasPermission(#dto,'ibizplm-SearchComment-fetch_default')")
    @PostMapping("search_comments/fetch_default")
    public ResponseEntity<List<SearchCommentDTO>> fetchDefault
            (@Validated @RequestBody SearchCommentFilterDTO dto) {
        SearchCommentSearchContext context = searchCommentFilterDtoMapping.toDomain(dto);
        Page<SearchComment> domains = searchCommentService.searchDefault(context) ;
        List<SearchCommentDTO> list = searchCommentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_relation 评论搜索
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SearchCommentDTO>>
    */
    @ApiOperation(value = "查询fetch_relation", tags = {"评论搜索" },  notes = "SearchComment-fetch_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SearchComment-fetch_relation-all') or hasPermission(#dto,'ibizplm-SearchComment-fetch_relation')")
    @PostMapping("search_comments/fetch_relation")
    public ResponseEntity<List<SearchCommentDTO>> fetchRelation
            (@Validated @RequestBody SearchCommentFilterDTO dto) {
        SearchCommentSearchContext context = searchCommentFilterDtoMapping.toDomain(dto);
        Page<SearchComment> domains = searchCommentService.searchRelation(context) ;
        List<SearchCommentDTO> list = searchCommentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


}
