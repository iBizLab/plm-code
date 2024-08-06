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
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.filter.CommentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Comment] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractCommentResource {

    @Autowired
    public CommentService commentService;

    @Autowired
    @Lazy
    public CommentDTOMapping commentDtoMapping;

    @Autowired
    @Lazy
    public CommentFilterDTOMapping commentFilterDtoMapping;

    /**
    * 创建Create 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('article_page',#principalId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("article_pages/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPrincipalId(principalId, item)));
        else
            rt.set(createByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByPrincipalId
            (String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('article_page',#principalId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("article_pages/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPrincipalIdAndId(principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByPrincipalIdAndId
            (String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('article_page',#principalId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("article_pages/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByPrincipalIdAndId(principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByPrincipalIdAndId
            (String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('article_page',#principalId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("article_pages/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPrincipalId(principalId, item)));
        else
            rt.set(saveByPrincipalId(principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByPrincipalId
            (String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('shared_space',#spaceId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySpaceIdAndPrincipalId(spaceId, principalId, item)));
        else
            rt.set(createBySpaceIdAndPrincipalId(spaceId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createBySpaceIdAndPrincipalId
            (String spaceId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('shared_space',#spaceId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateBySpaceIdAndPrincipalIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySpaceIdAndPrincipalIdAndId(spaceId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySpaceIdAndPrincipalIdAndId(spaceId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateBySpaceIdAndPrincipalIdAndId
            (String spaceId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('shared_space',#spaceId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteBySpaceIdAndPrincipalIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteBySpaceIdAndPrincipalIdAndId(spaceId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteBySpaceIdAndPrincipalIdAndId(spaceId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteBySpaceIdAndPrincipalIdAndId
            (String spaceId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('shared_space',#spaceId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySpaceIdAndPrincipalId(spaceId, principalId, item)));
        else
            rt.set(saveBySpaceIdAndPrincipalId(spaceId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveBySpaceIdAndPrincipalId
            (String spaceId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('test_case',#caseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByCaseIdAndPrincipalId(caseId, principalId, item)));
        else
            rt.set(createByCaseIdAndPrincipalId(caseId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByCaseIdAndPrincipalId
            (String caseId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('test_case',#caseId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByCaseIdAndPrincipalIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByCaseIdAndPrincipalIdAndId(caseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByCaseIdAndPrincipalIdAndId(caseId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByCaseIdAndPrincipalIdAndId
            (String caseId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('test_case',#caseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByCaseIdAndPrincipalIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByCaseIdAndPrincipalIdAndId(caseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByCaseIdAndPrincipalIdAndId(caseId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByCaseIdAndPrincipalIdAndId
            (String caseId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('test_case',#caseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByCaseIdAndPrincipalId(caseId, principalId, item)));
        else
            rt.set(saveByCaseIdAndPrincipalId(caseId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByCaseIdAndPrincipalId
            (String caseId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndCaseIdAndPrincipalId(testLibraryId, caseId, principalId, item)));
        else
            rt.set(createByTestLibraryIdAndCaseIdAndPrincipalId(testLibraryId, caseId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByTestLibraryIdAndCaseIdAndPrincipalId
            (String testLibraryId, String caseId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('library',#testLibraryId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndCaseIdAndPrincipalIdAndId(testLibraryId, caseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndCaseIdAndPrincipalIdAndId(testLibraryId, caseId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (String testLibraryId, String caseId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTestLibraryIdAndCaseIdAndPrincipalIdAndId(testLibraryId, caseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTestLibraryIdAndCaseIdAndPrincipalIdAndId(testLibraryId, caseId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (String testLibraryId, String caseId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndCaseIdAndPrincipalId(testLibraryId, caseId, principalId, item)));
        else
            rt.set(saveByTestLibraryIdAndCaseIdAndPrincipalId(testLibraryId, caseId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByTestLibraryIdAndCaseIdAndPrincipalId
            (String testLibraryId, String caseId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('test_plan',#planId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPlanIdAndPrincipalId(planId, principalId, item)));
        else
            rt.set(createByPlanIdAndPrincipalId(planId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByPlanIdAndPrincipalId
            (String planId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('test_plan',#planId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("test_plans/{planId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByPlanIdAndPrincipalIdAndId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPlanIdAndPrincipalIdAndId(planId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPlanIdAndPrincipalIdAndId(planId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByPlanIdAndPrincipalIdAndId
            (String planId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('test_plan',#planId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByPlanIdAndPrincipalIdAndId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByPlanIdAndPrincipalIdAndId(planId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByPlanIdAndPrincipalIdAndId(planId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByPlanIdAndPrincipalIdAndId
            (String planId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('test_plan',#planId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPlanIdAndPrincipalId(planId, principalId, item)));
        else
            rt.set(saveByPlanIdAndPrincipalId(planId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByPlanIdAndPrincipalId
            (String planId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryIdAndPlanIdAndPrincipalId(libraryId, planId, principalId, item)));
        else
            rt.set(createByLibraryIdAndPlanIdAndPrincipalId(libraryId, planId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByLibraryIdAndPlanIdAndPrincipalId
            (String libraryId, String planId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('library',#libraryId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByLibraryIdAndPlanIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndPlanIdAndPrincipalIdAndId(libraryId, planId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndPlanIdAndPrincipalIdAndId(libraryId, planId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByLibraryIdAndPlanIdAndPrincipalIdAndId
            (String libraryId, String planId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByLibraryIdAndPlanIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByLibraryIdAndPlanIdAndPrincipalIdAndId(libraryId, planId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByLibraryIdAndPlanIdAndPrincipalIdAndId(libraryId, planId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByLibraryIdAndPlanIdAndPrincipalIdAndId
            (String libraryId, String planId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryIdAndPlanIdAndPrincipalId(libraryId, planId, principalId, item)));
        else
            rt.set(saveByLibraryIdAndPlanIdAndPrincipalId(libraryId, planId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByLibraryIdAndPlanIdAndPrincipalId
            (String libraryId, String planId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('product',#productId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("products/{productId}/customers/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductIdAndPrincipalId(productId, principalId, item)));
        else
            rt.set(createByProductIdAndPrincipalId(productId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByProductIdAndPrincipalId
            (String productId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('product',#productId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("products/{productId}/customers/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByProductIdAndPrincipalIdAndId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndPrincipalIdAndId(productId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndPrincipalIdAndId(productId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByProductIdAndPrincipalIdAndId
            (String productId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('product',#productId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("products/{productId}/customers/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByProductIdAndPrincipalIdAndId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProductIdAndPrincipalIdAndId(productId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProductIdAndPrincipalIdAndId(productId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByProductIdAndPrincipalIdAndId
            (String productId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('product',#productId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("products/{productId}/customers/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductIdAndPrincipalId(productId, principalId, item)));
        else
            rt.set(saveByProductIdAndPrincipalId(productId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByProductIdAndPrincipalId
            (String productId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('discuss_topic',#topicId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByTopicIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTopicIdAndPrincipalId(topicId, principalId, item)));
        else
            rt.set(createByTopicIdAndPrincipalId(topicId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByTopicIdAndPrincipalId
            (String topicId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('discuss_topic',#topicId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByTopicIdAndPrincipalIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTopicIdAndPrincipalIdAndId(topicId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTopicIdAndPrincipalIdAndId(topicId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByTopicIdAndPrincipalIdAndId
            (String topicId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('discuss_topic',#topicId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByTopicIdAndPrincipalIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTopicIdAndPrincipalIdAndId(topicId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTopicIdAndPrincipalIdAndId(topicId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByTopicIdAndPrincipalIdAndId
            (String topicId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('discuss_topic',#topicId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByTopicIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTopicIdAndPrincipalId(topicId, principalId, item)));
        else
            rt.set(saveByTopicIdAndPrincipalId(topicId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByTopicIdAndPrincipalId
            (String topicId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('discuss_post',#postId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByPostIdAndPrincipalId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPostIdAndPrincipalId(postId, principalId, item)));
        else
            rt.set(createByPostIdAndPrincipalId(postId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByPostIdAndPrincipalId
            (String postId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('discuss_post',#postId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByPostIdAndPrincipalIdAndId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPostIdAndPrincipalIdAndId(postId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPostIdAndPrincipalIdAndId(postId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByPostIdAndPrincipalIdAndId
            (String postId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('discuss_post',#postId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByPostIdAndPrincipalIdAndId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByPostIdAndPrincipalIdAndId(postId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByPostIdAndPrincipalIdAndId(postId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByPostIdAndPrincipalIdAndId
            (String postId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('discuss_post',#postId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByPostIdAndPrincipalId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPostIdAndPrincipalId(postId, principalId, item)));
        else
            rt.set(saveByPostIdAndPrincipalId(postId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByPostIdAndPrincipalId
            (String postId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('discuss_topic',#topicId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByTopicIdAndPostIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTopicIdAndPostIdAndPrincipalId(topicId, postId, principalId, item)));
        else
            rt.set(createByTopicIdAndPostIdAndPrincipalId(topicId, postId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByTopicIdAndPostIdAndPrincipalId
            (String topicId, String postId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('discuss_topic',#topicId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByTopicIdAndPostIdAndPrincipalIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTopicIdAndPostIdAndPrincipalIdAndId(topicId, postId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTopicIdAndPostIdAndPrincipalIdAndId(topicId, postId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByTopicIdAndPostIdAndPrincipalIdAndId
            (String topicId, String postId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('discuss_topic',#topicId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByTopicIdAndPostIdAndPrincipalIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTopicIdAndPostIdAndPrincipalIdAndId(topicId, postId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTopicIdAndPostIdAndPrincipalIdAndId(topicId, postId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByTopicIdAndPostIdAndPrincipalIdAndId
            (String topicId, String postId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('discuss_topic',#topicId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByTopicIdAndPostIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTopicIdAndPostIdAndPrincipalId(topicId, postId, principalId, item)));
        else
            rt.set(saveByTopicIdAndPostIdAndPrincipalId(topicId, postId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByTopicIdAndPostIdAndPrincipalId
            (String topicId, String postId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(createByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByLibraryIdAndPrincipalId
            (String libraryId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('library',#libraryId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/reviews/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByLibraryIdAndPrincipalIdAndId
            (String libraryId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByLibraryIdAndPrincipalIdAndId(libraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByLibraryIdAndPrincipalIdAndId(libraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByLibraryIdAndPrincipalIdAndId
            (String libraryId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryIdAndPrincipalId(libraryId, principalId, item)));
        else
            rt.set(saveByLibraryIdAndPrincipalId(libraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByLibraryIdAndPrincipalId
            (String libraryId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndPrincipalId(testLibraryId, principalId, item)));
        else
            rt.set(createByTestLibraryIdAndPrincipalId(testLibraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByTestLibraryIdAndPrincipalId
            (String testLibraryId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('library',#testLibraryId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByTestLibraryIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndPrincipalIdAndId(testLibraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndPrincipalIdAndId(testLibraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByTestLibraryIdAndPrincipalIdAndId
            (String testLibraryId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByTestLibraryIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTestLibraryIdAndPrincipalIdAndId(testLibraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTestLibraryIdAndPrincipalIdAndId(testLibraryId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByTestLibraryIdAndPrincipalIdAndId
            (String testLibraryId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndPrincipalId(testLibraryId, principalId, item)));
        else
            rt.set(saveByTestLibraryIdAndPrincipalId(testLibraryId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByTestLibraryIdAndPrincipalId
            (String testLibraryId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectIdAndPrincipalId(projectId, principalId, item)));
        else
            rt.set(createByProjectIdAndPrincipalId(projectId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByProjectIdAndPrincipalId
            (String projectId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('project',#projectId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByProjectIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndPrincipalIdAndId(projectId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndPrincipalIdAndId(projectId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByProjectIdAndPrincipalIdAndId
            (String projectId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByProjectIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProjectIdAndPrincipalIdAndId(projectId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProjectIdAndPrincipalIdAndId(projectId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByProjectIdAndPrincipalIdAndId
            (String projectId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectIdAndPrincipalId(projectId, principalId, item)));
        else
            rt.set(saveByProjectIdAndPrincipalId(projectId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByProjectIdAndPrincipalId
            (String projectId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('release',#releaseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("releases/{releaseId}/work_items/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByReleaseIdAndPrincipalId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByReleaseIdAndPrincipalId(releaseId, principalId, item)));
        else
            rt.set(createByReleaseIdAndPrincipalId(releaseId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByReleaseIdAndPrincipalId
            (String releaseId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('release',#releaseId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("releases/{releaseId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByReleaseIdAndPrincipalIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByReleaseIdAndPrincipalIdAndId(releaseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByReleaseIdAndPrincipalIdAndId(releaseId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByReleaseIdAndPrincipalIdAndId
            (String releaseId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('release',#releaseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("releases/{releaseId}/work_items/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByReleaseIdAndPrincipalIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByReleaseIdAndPrincipalIdAndId(releaseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByReleaseIdAndPrincipalIdAndId(releaseId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByReleaseIdAndPrincipalIdAndId
            (String releaseId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('release',#releaseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("releases/{releaseId}/work_items/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByReleaseIdAndPrincipalId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByReleaseIdAndPrincipalId(releaseId, principalId, item)));
        else
            rt.set(saveByReleaseIdAndPrincipalId(releaseId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByReleaseIdAndPrincipalId
            (String releaseId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>createByProjectIdAndReleaseIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectIdAndReleaseIdAndPrincipalId(projectId, releaseId, principalId, item)));
        else
            rt.set(createByProjectIdAndReleaseIdAndPrincipalId(projectId, releaseId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO createByProjectIdAndReleaseIdAndPrincipalId
            (String projectId, String releaseId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('project',#projectId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>updateByProjectIdAndReleaseIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndReleaseIdAndPrincipalIdAndId(projectId, releaseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndReleaseIdAndPrincipalIdAndId(projectId, releaseId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateByProjectIdAndReleaseIdAndPrincipalIdAndId
            (String projectId, String releaseId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * delete 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>deleteByProjectIdAndReleaseIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProjectIdAndReleaseIdAndPrincipalIdAndId(projectId, releaseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProjectIdAndReleaseIdAndPrincipalIdAndId(projectId, releaseId, principalId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteByProjectIdAndReleaseIdAndPrincipalIdAndId
            (String projectId, String releaseId, String principalId, String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments/save")
    public Mono<ResponseEntity<ResponseWrapper<CommentDTO>>>saveByProjectIdAndReleaseIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectIdAndReleaseIdAndPrincipalId(projectId, releaseId, principalId, item)));
        else
            rt.set(saveByProjectIdAndReleaseIdAndPrincipalId(projectId, releaseId, principalId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO saveByProjectIdAndReleaseIdAndPrincipalId
            (String projectId, String releaseId, String principalId, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 评论
    * 
    *
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('article_page',#principalId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("article_pages/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('article_page',#principalId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("article_pages/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("article_pages/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("article_pages/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByPrincipalId
            (@PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('article_page',#principalId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("article_pages/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('shared_space',#spaceId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getBySpaceIdAndPrincipalIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('shared_space',#spaceId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeBySpaceIdAndPrincipalIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('test_case',#caseId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByCaseIdAndPrincipalIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('test_case',#caseId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByCaseIdAndPrincipalIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("test_cases/{caseId}/runs/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('library',#testLibraryId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('test_plan',#planId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("test_plans/{planId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByPlanIdAndPrincipalIdAndId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('test_plan',#planId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("test_plans/{planId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByPlanIdAndPrincipalIdAndId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("test_plans/{planId}/runs/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByLibraryIdAndPlanIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('library',#libraryId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByLibraryIdAndPlanIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('product',#productId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("products/{productId}/customers/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByProductIdAndPrincipalIdAndId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('product',#productId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("products/{productId}/customers/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProductIdAndPrincipalIdAndId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("products/{productId}/customers/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("products/{productId}/customers/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("products/{productId}/customers/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('discuss_topic',#topicId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByTopicIdAndPrincipalIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('discuss_topic',#topicId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTopicIdAndPrincipalIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTopicIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByTopicIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param topicId topicId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByTopicIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('discuss_post',#postId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByPostIdAndPrincipalIdAndId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('discuss_post',#postId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByPostIdAndPrincipalIdAndId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByPostIdAndPrincipalId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByPostIdAndPrincipalId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('discuss_post',#postId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByPostIdAndPrincipalId
            (@PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('discuss_topic',#topicId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByTopicIdAndPostIdAndPrincipalIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('discuss_topic',#topicId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTopicIdAndPostIdAndPrincipalIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTopicIdAndPostIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByTopicIdAndPostIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByTopicIdAndPostIdAndPrincipalId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("libraries/{libraryId}/reviews/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('library',#libraryId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("libraries/{libraryId}/reviews/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByLibraryIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("libraries/{libraryId}/reviews/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param libraryId libraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("libraries/{libraryId}/reviews/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByLibraryIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByTestLibraryIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('library',#testLibraryId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTestLibraryIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("projects/{projectId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByProjectIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('project',#projectId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("projects/{projectId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("projects/{projectId}/work_items/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('release',#releaseId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("releases/{releaseId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByReleaseIdAndPrincipalIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('release',#releaseId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("releases/{releaseId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByReleaseIdAndPrincipalIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("releases/{releaseId}/work_items/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByReleaseIdAndPrincipalId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("releases/{releaseId}/work_items/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByReleaseIdAndPrincipalId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('release',#releaseId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("releases/{releaseId}/work_items/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByReleaseIdAndPrincipalId
            (@PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Comment-Get')")
    @GetMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<CommentDTO>> getByProjectIdAndReleaseIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('project',#projectId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndReleaseIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectIdAndReleaseIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        CheckKeyStatus rt = commentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<CommentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments/get_draft")
    public Mono<ResponseEntity<CommentDTO>> getDraftByProjectIdAndReleaseIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param principalId principalId
    * @param dto dto
    * @return Mono<ResponseEntity<List<CommentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{principalId}/comments/fetch_default")
    public Mono<ResponseEntity<List<CommentDTO>>> fetchDefaultByProjectIdAndReleaseIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.fetchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


}
