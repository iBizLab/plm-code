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
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"评论" },  notes = "Comment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Create-all') or hasPermission(this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Create')")
    @PostMapping("comments")
    public ResponseEntity<ResponseWrapper<CommentDTO>> create
            (@Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 评论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO create
            (CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        commentService.create(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"评论" },  notes = "Comment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Update-all') or hasPermission(this.commentService.get(#id),'ibizplm-Comment-Update')")
    @VersionCheck(entity = "comment" , versionfield = "updateTime")
    @PutMapping("comments/{id}")
    public ResponseEntity<ResponseWrapper<CommentDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 评论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO updateById
            (String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        commentService.update(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }

    /**
    * Delete 评论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "Delete", tags = {"评论" },  notes = "Comment-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Delete-all') or hasPermission(this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Delete')")
    @PostMapping("comments/{id}/delete")
    public ResponseEntity<ResponseWrapper<CommentDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 评论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO deleteById
            (String id, CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        domain.setId(id);
        Comment rt = commentService.delete(domain);
        return commentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"评论" },  notes = "Comment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Save-all') or hasPermission(this.commentDtoMapping.toDomain(#dto),'ibizplm-Comment-Save')")
    @PostMapping("comments/save")
    public ResponseEntity<ResponseWrapper<CommentDTO>> save
            (@Validated @RequestBody RequestWrapper<CommentDTO> dto) {
        ResponseWrapper<CommentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 评论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */   
    public CommentDTO save
            (CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        commentService.save(domain);
        Comment rt = domain;
        return commentDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 评论
    * 
    *
    * @param id id
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"评论" },  notes = "Comment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Get-all')  or hasPermission(this.commentDtoMapping.toDomain(returnObject.body),'ibizplm-Comment-Get')")
    @GetMapping("comments/{id}")
    public ResponseEntity<CommentDTO> getById
            (@PathVariable("id") String id) {
        Comment rt = commentService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 评论
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"评论" },  notes = "Comment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-Remove-all') or hasPermission(this.commentService.get(#id),'ibizplm-Comment-Remove')")
    @DeleteMapping("comments/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = commentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 评论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"评论" },  notes = "Comment-CheckKey ")
    @PostMapping("comments/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        Integer rt = commentService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 评论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CommentDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"评论" },  notes = "Comment-GetDraft ")
    @GetMapping("comments/getdraft")
    public ResponseEntity<CommentDTO> getDraft
            (@SpringQueryMap CommentDTO dto) {
        Comment domain = commentDtoMapping.toDomain(dto);
        Comment rt = commentService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchAdvanced_search 评论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询FetchAdvanced_search", tags = {"评论" },  notes = "Comment-FetchAdvanced_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-FetchAdvanced_search-all') or hasPermission(#dto,'ibizplm-Comment-FetchAdvanced_search')")
    @PostMapping("comments/fetchadvanced_search")
    public ResponseEntity<List<CommentDTO>> fetchAdvancedSearch
            (@Validated @RequestBody CommentFilterDTO dto) {
        CommentSearchContext context = commentFilterDtoMapping.toDomain(dto);
        Page<Comment> domains = commentService.searchAdvancedSearch(context) ;
        List<CommentDTO> list = commentDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 评论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CommentDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"评论" },  notes = "Comment-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Comment-FetchDefault-all') or hasPermission(#dto,'ibizplm-Comment-FetchDefault')")
    @PostMapping("comments/fetchdefault")
    public ResponseEntity<List<CommentDTO>> fetchDefault
            (@Validated @RequestBody CommentFilterDTO dto) {
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
    * 批量新建评论
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Comment-Create-all')")
    @ApiOperation(value = "批量新建评论", tags = {"评论" },  notes = "批量新建评论")
	@PostMapping("comments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<CommentDTO> dtos) {
        commentService.createBatch(commentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除评论
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Comment-Remove-all')")
    @ApiOperation(value = "批量删除评论", tags = {"评论" },  notes = "批量删除评论")
	@DeleteMapping("comments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        commentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新评论
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Comment-Update-all')")
    @ApiOperation(value = "批量更新评论", tags = {"评论" },  notes = "批量更新评论")
	@PutMapping("comments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<CommentDTO> dtos) {
        commentService.updateBatch(commentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存评论
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Comment-Save-all')")
    @ApiOperation(value = "批量保存评论", tags = {"评论" },  notes = "批量保存评论")
	@PostMapping("comments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<CommentDTO> dtos) {
        commentService.saveBatch(commentDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入评论
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Comment-Save-all')")
    @ApiOperation(value = "批量导入评论", tags = {"评论" },  notes = "批量导入评论")
	@PostMapping("comments/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<CommentDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(commentService.importData(config,ignoreError,commentDtoMapping.toDomain(dtos)));
    }

}
