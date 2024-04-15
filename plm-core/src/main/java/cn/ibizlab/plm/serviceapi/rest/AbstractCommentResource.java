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
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.filter.CommentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('article_page',#principalId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("article_pages/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPrincipalId(principalId, item)));
        else
            rt.set(createByPrincipalId(principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('article_page',#principalId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("article_pages/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPrincipalIdAndId(principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('article_page',#principalId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("article_pages/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByPrincipalIdAndId(principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByPrincipalIdAndId(principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('article_page',#principalId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("article_pages/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPrincipalId(principalId, item)));
        else
            rt.set(saveByPrincipalId(principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('space',#spaceId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("spaces/{spaceId}/article_pages/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySpaceIdAndPrincipalId(spaceId, principalId, item)));
        else
            rt.set(createBySpaceIdAndPrincipalId(spaceId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('space',#spaceId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("spaces/{spaceId}/article_pages/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateBySpaceIdAndPrincipalIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySpaceIdAndPrincipalIdAndId(spaceId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySpaceIdAndPrincipalIdAndId(spaceId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('space',#spaceId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("spaces/{spaceId}/article_pages/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteBySpaceIdAndPrincipalIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteBySpaceIdAndPrincipalIdAndId(spaceId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteBySpaceIdAndPrincipalIdAndId(spaceId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('space',#spaceId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("spaces/{spaceId}/article_pages/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySpaceIdAndPrincipalId(spaceId, principalId, item)));
        else
            rt.set(saveBySpaceIdAndPrincipalId(spaceId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('test_case',#caseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByCaseIdAndPrincipalId(caseId, principalId, item)));
        else
            rt.set(createByCaseIdAndPrincipalId(caseId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('test_case',#caseId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateByCaseIdAndPrincipalIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByCaseIdAndPrincipalIdAndId(caseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByCaseIdAndPrincipalIdAndId(caseId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('test_case',#caseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteByCaseIdAndPrincipalIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByCaseIdAndPrincipalIdAndId(caseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByCaseIdAndPrincipalIdAndId(caseId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('test_case',#caseId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByCaseIdAndPrincipalId(caseId, principalId, item)));
        else
            rt.set(saveByCaseIdAndPrincipalId(caseId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndCaseIdAndPrincipalId(testLibraryId, caseId, principalId, item)));
        else
            rt.set(createByTestLibraryIdAndCaseIdAndPrincipalId(testLibraryId, caseId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('library',#testLibraryId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndCaseIdAndPrincipalIdAndId(testLibraryId, caseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndCaseIdAndPrincipalIdAndId(testLibraryId, caseId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTestLibraryIdAndCaseIdAndPrincipalIdAndId(testLibraryId, caseId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTestLibraryIdAndCaseIdAndPrincipalIdAndId(testLibraryId, caseId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndCaseIdAndPrincipalId(testLibraryId, caseId, principalId, item)));
        else
            rt.set(saveByTestLibraryIdAndCaseIdAndPrincipalId(testLibraryId, caseId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('test_plan',#planId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPlanIdAndPrincipalId(planId, principalId, item)));
        else
            rt.set(createByPlanIdAndPrincipalId(planId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('test_plan',#planId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("test_plans/{planId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateByPlanIdAndPrincipalIdAndId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPlanIdAndPrincipalIdAndId(planId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPlanIdAndPrincipalIdAndId(planId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('test_plan',#planId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteByPlanIdAndPrincipalIdAndId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByPlanIdAndPrincipalIdAndId(planId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByPlanIdAndPrincipalIdAndId(planId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('test_plan',#planId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPlanIdAndPrincipalId(planId, principalId, item)));
        else
            rt.set(saveByPlanIdAndPrincipalId(planId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryIdAndPlanIdAndPrincipalId(libraryId, planId, principalId, item)));
        else
            rt.set(createByLibraryIdAndPlanIdAndPrincipalId(libraryId, planId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('library',#libraryId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateByLibraryIdAndPlanIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndPlanIdAndPrincipalIdAndId(libraryId, planId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndPlanIdAndPrincipalIdAndId(libraryId, planId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteByLibraryIdAndPlanIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByLibraryIdAndPlanIdAndPrincipalIdAndId(libraryId, planId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByLibraryIdAndPlanIdAndPrincipalIdAndId(libraryId, planId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryIdAndPlanIdAndPrincipalId(libraryId, planId, principalId, item)));
        else
            rt.set(saveByLibraryIdAndPlanIdAndPrincipalId(libraryId, planId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('product',#productId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("products/{productId}/customers/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductIdAndPrincipalId(productId, principalId, item)));
        else
            rt.set(createByProductIdAndPrincipalId(productId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('product',#productId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("products/{productId}/customers/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateByProductIdAndPrincipalIdAndId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndPrincipalIdAndId(productId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndPrincipalIdAndId(productId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('product',#productId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("products/{productId}/customers/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteByProductIdAndPrincipalIdAndId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProductIdAndPrincipalIdAndId(productId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProductIdAndPrincipalIdAndId(productId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('product',#productId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("products/{productId}/customers/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductIdAndPrincipalId(productId, principalId, item)));
        else
            rt.set(saveByProductIdAndPrincipalId(productId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndPrincipalId(testLibraryId, principalId, item)));
        else
            rt.set(createByTestLibraryIdAndPrincipalId(testLibraryId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('library',#testLibraryId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateByTestLibraryIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndPrincipalIdAndId(testLibraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndPrincipalIdAndId(testLibraryId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteByTestLibraryIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTestLibraryIdAndPrincipalIdAndId(testLibraryId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTestLibraryIdAndPrincipalIdAndId(testLibraryId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndPrincipalId(testLibraryId, principalId, item)));
        else
            rt.set(saveByTestLibraryIdAndPrincipalId(testLibraryId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> createByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectIdAndPrincipalId(projectId, principalId, item)));
        else
            rt.set(createByProjectIdAndPrincipalId(projectId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission('project',#projectId,this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/work_items/{principalId}/comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateByProjectIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndPrincipalIdAndId(projectId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndPrincipalIdAndId(projectId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "delete", tags = {"评论" },  notes = "Comment-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-delete-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-delete')")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteByProjectIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProjectIdAndPrincipalIdAndId(projectId, principalId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProjectIdAndPrincipalIdAndId(projectId, principalId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> saveByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectIdAndPrincipalId(projectId, principalId, item)));
        else
            rt.set(saveByProjectIdAndPrincipalId(projectId, principalId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 获取Get 评论
    * 
    *
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('article_page',#principalId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("article_pages/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('article_page',#principalId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("article_pages/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeByPrincipalIdAndId
            (@PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("article_pages/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("article_pages/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftByPrincipalId
            (@PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('article_page',#principalId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("article_pages/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultByPrincipalId
            (@PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('space',#spaceId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("spaces/{spaceId}/article_pages/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getBySpaceIdAndPrincipalIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('space',#spaceId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("spaces/{spaceId}/article_pages/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeBySpaceIdAndPrincipalIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("spaces/{spaceId}/article_pages/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("spaces/{spaceId}/article_pages/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param spaceId spaceId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('space',#spaceId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("spaces/{spaceId}/article_pages/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultBySpaceIdAndPrincipalId
            (@PathVariable("spaceId") String spaceId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('test_case',#caseId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getByCaseIdAndPrincipalIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('test_case',#caseId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeByCaseIdAndPrincipalIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("test_cases/{caseId}/runs/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("test_cases/{caseId}/runs/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultByCaseIdAndPrincipalId
            (@PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('library',#testLibraryId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeByTestLibraryIdAndCaseIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultByTestLibraryIdAndCaseIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('test_plan',#planId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("test_plans/{planId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getByPlanIdAndPrincipalIdAndId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('test_plan',#planId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("test_plans/{planId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeByPlanIdAndPrincipalIdAndId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("test_plans/{planId}/runs/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("test_plans/{planId}/runs/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultByPlanIdAndPrincipalId
            (@PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('library',#libraryId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getByLibraryIdAndPlanIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('library',#libraryId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeByLibraryIdAndPlanIdAndPrincipalIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultByLibraryIdAndPlanIdAndPrincipalId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('product',#productId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("products/{productId}/customers/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getByProductIdAndPrincipalIdAndId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('product',#productId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("products/{productId}/customers/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeByProductIdAndPrincipalIdAndId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("products/{productId}/customers/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("products/{productId}/customers/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param productId productId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("products/{productId}/customers/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultByProductIdAndPrincipalId
            (@PathVariable("productId") String productId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('library',#testLibraryId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getByTestLibraryIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('library',#testLibraryId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeByTestLibraryIdAndPrincipalIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param testLibraryId testLibraryId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultByTestLibraryIdAndPrincipalId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission('project',#projectId,this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("projects/{projectId}/work_items/{principalId}/comments/{id}")
    public ResponseEntity<CommentDTO> getByProjectIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission('project',#projectId,this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("projects/{projectId}/work_items/{principalId}/comments/{id}")
    public ResponseEntity<Boolean> removeByProjectIdAndPrincipalIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments/check_key")
    public ResponseEntity<Integer> checkKeyByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("projects/{projectId}/work_items/{principalId}/comments/get_draft")
    public ResponseEntity<CommentDTO> getDraftByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setPrincipalId(principalId);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 评论
    * 
    *
    * @param projectId projectId
    * @param principalId principalId
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"评论" },  notes = "Comment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Comment-fetch_default')")
    @PostMapping("projects/{projectId}/work_items/{principalId}/comments/fetch_default")
    public ResponseEntity<List<CommentDTO>> fetchDefaultByProjectIdAndPrincipalId
            (@PathVariable("projectId") String projectId, @PathVariable("principalId") String principalId, @Validated @RequestBody CommentFilterDTO dto) {
        dto.setPrincipalIdEQ(principalId);
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchDefault(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


}
