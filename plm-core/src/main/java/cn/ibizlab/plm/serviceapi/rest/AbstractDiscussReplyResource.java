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
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.team.service.DiscussReplyService;
import cn.ibizlab.plm.core.team.filter.DiscussReplySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[DiscussReply] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDiscussReplyResource {

    @Autowired
    public DiscussReplyService discussReplyService;

    @Autowired
    @Lazy
    public DiscussReplyDTOMapping discussReplyDtoMapping;

    @Autowired
    @Lazy
    public DiscussReplyFilterDTOMapping discussReplyFilterDtoMapping;

    /**
    * 创建Create 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"讨论回复" },  notes = "DiscussReply-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Create-all') or hasPermission(this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-Create')")
    @PostMapping("discuss_replies")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> create
            (@Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO create
            (DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        discussReplyService.create(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 讨论回复
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"讨论回复" },  notes = "DiscussReply-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Update-all') or hasPermission(this.discussReplyService.get(#id),'ibizplm-DiscussReply-Update')")
    @VersionCheck(entity = "discussreply" , versionfield = "updateTime")
    @PutMapping("discuss_replies/{id}")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 讨论回复
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO updateById
            (String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        discussReplyService.update(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * add_reply 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "add_reply", tags = {"讨论回复" },  notes = "DiscussReply-add_reply ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-add_reply-all') or hasPermission(this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-add_reply')")
    @PostMapping("discuss_replies/add_reply")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> addReply
            (@Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addReply(item)));
        else
            rt.set(addReply(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * add_reply 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO addReply
            (DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        DiscussReply rt = discussReplyService.addReply(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * del_comment 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "del_comment", tags = {"讨论回复" },  notes = "DiscussReply-del_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-del_comment-all') or hasPermission(this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-del_comment')")
    @PostMapping("discuss_replies/del_comment")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> delComment
            (@Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(delComment(item)));
        else
            rt.set(delComment(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_comment 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO delComment
            (DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        DiscussReply rt = discussReplyService.delComment(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * del_reply 讨论回复
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "del_reply", tags = {"讨论回复" },  notes = "DiscussReply-del_reply ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-del_reply-all') or hasPermission(this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-del_reply')")
    @PostMapping("discuss_replies/{id}/del_reply")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> delReplyById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delReplyById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delReplyById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_reply 讨论回复
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO delReplyById
            (String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussReply rt = discussReplyService.delReply(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"讨论回复" },  notes = "DiscussReply-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Save-all') or hasPermission(this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-Save')")
    @PostMapping("discuss_replies/save")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> save
            (@Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO save
            (DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        discussReplyService.save(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * send_comment 讨论回复
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "send_comment", tags = {"讨论回复" },  notes = "DiscussReply-send_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-send_comment-all') or hasPermission(this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-send_comment')")
    @PostMapping("discuss_replies/{id}/send_comment")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> sendCommentById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sendCommentById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sendCommentById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * send_comment 讨论回复
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO sendCommentById
            (String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussReply rt = discussReplyService.sendComment(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"讨论回复" },  notes = "DiscussReply-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Create-all') or hasPermission('discuss_post',#postId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-Create')")
    @PostMapping("discuss_posts/{postId}/discuss_replies")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> createByPostId
            (@PathVariable("postId") String postId, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPostId(postId, item)));
        else
            rt.set(createByPostId(postId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO createByPostId
            (String postId, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        discussReplyService.create(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 讨论回复
    * 
    *
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"讨论回复" },  notes = "DiscussReply-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Update-all') or hasPermission('discuss_post',#postId,this.discussReplyService.get(#id),'ibizplm-DiscussReply-Update')")
    @VersionCheck(entity = "discussreply" , versionfield = "updateTime")
    @PutMapping("discuss_posts/{postId}/discuss_replies/{id}")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> updateByPostIdAndId
            (@PathVariable("postId") String postId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPostIdAndId(postId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPostIdAndId(postId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 讨论回复
    * 
    *
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO updateByPostIdAndId
            (String postId, String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        discussReplyService.update(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * add_reply 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "add_reply", tags = {"讨论回复" },  notes = "DiscussReply-add_reply ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-add_reply-all') or hasPermission('discuss_post',#postId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-add_reply')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/add_reply")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> addReplyByPostId
            (@PathVariable("postId") String postId, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addReplyByPostId(postId, item)));
        else
            rt.set(addReplyByPostId(postId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * add_reply 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO addReplyByPostId
            (String postId, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        DiscussReply rt = discussReplyService.addReply(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * del_comment 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "del_comment", tags = {"讨论回复" },  notes = "DiscussReply-del_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-del_comment-all') or hasPermission('discuss_post',#postId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-del_comment')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/del_comment")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> delCommentByPostId
            (@PathVariable("postId") String postId, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(delCommentByPostId(postId, item)));
        else
            rt.set(delCommentByPostId(postId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_comment 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO delCommentByPostId
            (String postId, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        DiscussReply rt = discussReplyService.delComment(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * del_reply 讨论回复
    * 
    *
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "del_reply", tags = {"讨论回复" },  notes = "DiscussReply-del_reply ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-del_reply-all') or hasPermission('discuss_post',#postId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-del_reply')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/{id}/del_reply")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> delReplyByPostIdAndId
            (@PathVariable("postId") String postId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delReplyByPostIdAndId(postId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delReplyByPostIdAndId(postId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_reply 讨论回复
    * 
    *
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO delReplyByPostIdAndId
            (String postId, String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussReply rt = discussReplyService.delReply(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"讨论回复" },  notes = "DiscussReply-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Save-all') or hasPermission('discuss_post',#postId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-Save')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/save")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> saveByPostId
            (@PathVariable("postId") String postId, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPostId(postId, item)));
        else
            rt.set(saveByPostId(postId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO saveByPostId
            (String postId, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        discussReplyService.save(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * send_comment 讨论回复
    * 
    *
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "send_comment", tags = {"讨论回复" },  notes = "DiscussReply-send_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-send_comment-all') or hasPermission('discuss_post',#postId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-send_comment')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/{id}/send_comment")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> sendCommentByPostIdAndId
            (@PathVariable("postId") String postId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sendCommentByPostIdAndId(postId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sendCommentByPostIdAndId(postId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * send_comment 讨论回复
    * 
    *
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO sendCommentByPostIdAndId
            (String postId, String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussReply rt = discussReplyService.sendComment(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"讨论回复" },  notes = "DiscussReply-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Create-all') or hasPermission('discuss_topic',#topicId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-Create')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> createByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTopicIdAndPostId(topicId, postId, item)));
        else
            rt.set(createByTopicIdAndPostId(topicId, postId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO createByTopicIdAndPostId
            (String topicId, String postId, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        discussReplyService.create(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"讨论回复" },  notes = "DiscussReply-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Update-all') or hasPermission('discuss_topic',#topicId,this.discussReplyService.get(#id),'ibizplm-DiscussReply-Update')")
    @VersionCheck(entity = "discussreply" , versionfield = "updateTime")
    @PutMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{id}")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> updateByTopicIdAndPostIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTopicIdAndPostIdAndId(topicId, postId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTopicIdAndPostIdAndId(topicId, postId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO updateByTopicIdAndPostIdAndId
            (String topicId, String postId, String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        discussReplyService.update(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * add_reply 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "add_reply", tags = {"讨论回复" },  notes = "DiscussReply-add_reply ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-add_reply-all') or hasPermission('discuss_topic',#topicId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-add_reply')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/add_reply")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> addReplyByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addReplyByTopicIdAndPostId(topicId, postId, item)));
        else
            rt.set(addReplyByTopicIdAndPostId(topicId, postId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * add_reply 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO addReplyByTopicIdAndPostId
            (String topicId, String postId, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        DiscussReply rt = discussReplyService.addReply(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * del_comment 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "del_comment", tags = {"讨论回复" },  notes = "DiscussReply-del_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-del_comment-all') or hasPermission('discuss_topic',#topicId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-del_comment')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/del_comment")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> delCommentByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(delCommentByTopicIdAndPostId(topicId, postId, item)));
        else
            rt.set(delCommentByTopicIdAndPostId(topicId, postId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_comment 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO delCommentByTopicIdAndPostId
            (String topicId, String postId, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        DiscussReply rt = discussReplyService.delComment(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * del_reply 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "del_reply", tags = {"讨论回复" },  notes = "DiscussReply-del_reply ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-del_reply-all') or hasPermission('discuss_topic',#topicId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-del_reply')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{id}/del_reply")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> delReplyByTopicIdAndPostIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delReplyByTopicIdAndPostIdAndId(topicId, postId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delReplyByTopicIdAndPostIdAndId(topicId, postId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_reply 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO delReplyByTopicIdAndPostIdAndId
            (String topicId, String postId, String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussReply rt = discussReplyService.delReply(domain);
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"讨论回复" },  notes = "DiscussReply-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Save-all') or hasPermission('discuss_topic',#topicId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-Save')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/save")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> saveByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTopicIdAndPostId(topicId, postId, item)));
        else
            rt.set(saveByTopicIdAndPostId(topicId, postId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO saveByTopicIdAndPostId
            (String topicId, String postId, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        discussReplyService.save(domain);
        DiscussReply rt = domain;
        return discussReplyDtoMapping.toDto(rt);
    }

    /**
    * send_comment 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "send_comment", tags = {"讨论回复" },  notes = "DiscussReply-send_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-send_comment-all') or hasPermission('discuss_topic',#topicId,this.discussReplyDtoMapping.toDomain(#dto),'ibizplm-DiscussReply-send_comment')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{id}/send_comment")
    public ResponseEntity<ResponseWrapper<DiscussReplyDTO>> sendCommentByTopicIdAndPostIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussReplyDTO> dto) {
        ResponseWrapper<DiscussReplyDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sendCommentByTopicIdAndPostIdAndId(topicId, postId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sendCommentByTopicIdAndPostIdAndId(topicId, postId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * send_comment 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */   
    public DiscussReplyDTO sendCommentByTopicIdAndPostIdAndId
            (String topicId, String postId, String id, DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussReply rt = discussReplyService.sendComment(domain);
        return discussReplyDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 讨论回复
    * 
    *
    * @param id id
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"讨论回复" },  notes = "DiscussReply-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Get-all')  or hasPermission(this.discussReplyDtoMapping.toDomain(returnObject.body),'ibizplm-DiscussReply-Get')")
    @GetMapping("discuss_replies/{id}")
    public ResponseEntity<DiscussReplyDTO> getById
            (@PathVariable("id") String id) {
        DiscussReply rt = discussReplyService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(discussReplyDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 讨论回复
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"讨论回复" },  notes = "DiscussReply-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Remove-all') or hasPermission(this.discussReplyService.get(#id),'ibizplm-DiscussReply-Remove')")
    @DeleteMapping("discuss_replies/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = discussReplyService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"讨论回复" },  notes = "DiscussReply-CheckKey ")
    @PostMapping("discuss_replies/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        Integer rt = discussReplyService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"讨论回复" },  notes = "DiscussReply-GetDraft ")
    @GetMapping("discuss_replies/get_draft")
    public ResponseEntity<DiscussReplyDTO> getDraft
            (@SpringQueryMap DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        DiscussReply rt = discussReplyService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(discussReplyDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"讨论回复" },  notes = "DiscussReply-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-fetch_default-all') or hasPermission(#dto,'ibizplm-DiscussReply-fetch_default')")
    @PostMapping("discuss_replies/fetch_default")
    public ResponseEntity<List<DiscussReplyDTO>> fetchDefault
            (@Validated @RequestBody DiscussReplyFilterDTO dto) {
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchDefault(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_reply 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_my_reply", tags = {"讨论回复" },  notes = "DiscussReply-fetch_my_reply ")
    @PostMapping("discuss_replies/fetch_my_reply")
    public ResponseEntity<List<DiscussReplyDTO>> fetchMyReply
            (@Validated @RequestBody DiscussReplyFilterDTO dto) {
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchMyReply(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_recent 讨论回复
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_recent", tags = {"讨论回复" },  notes = "DiscussReply-fetch_recent ")
    @PostMapping("discuss_replies/fetch_recent")
    public ResponseEntity<List<DiscussReplyDTO>> fetchRecent
            (@Validated @RequestBody DiscussReplyFilterDTO dto) {
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchRecent(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 讨论回复
    * 
    *
    * @param postId postId
    * @param id id
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"讨论回复" },  notes = "DiscussReply-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Get-all')  or hasPermission('discuss_post',#postId,this.discussReplyDtoMapping.toDomain(returnObject.body),'ibizplm-DiscussReply-Get')")
    @GetMapping("discuss_posts/{postId}/discuss_replies/{id}")
    public ResponseEntity<DiscussReplyDTO> getByPostIdAndId
            (@PathVariable("postId") String postId, @PathVariable("id") String id) {
        DiscussReply rt = discussReplyService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(discussReplyDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 讨论回复
    * 
    *
    * @param postId postId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"讨论回复" },  notes = "DiscussReply-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Remove-all') or hasPermission('discuss_post',#postId,this.discussReplyService.get(#id),'ibizplm-DiscussReply-Remove')")
    @DeleteMapping("discuss_posts/{postId}/discuss_replies/{id}")
    public ResponseEntity<Boolean> removeByPostIdAndId
            (@PathVariable("postId") String postId, @PathVariable("id") String id) {
        Boolean rt = discussReplyService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"讨论回复" },  notes = "DiscussReply-CheckKey ")
    @PostMapping("discuss_posts/{postId}/discuss_replies/check_key")
    public ResponseEntity<Integer> checkKeyByPostId
            (@PathVariable("postId") String postId, @Validated @RequestBody DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        Integer rt = discussReplyService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"讨论回复" },  notes = "DiscussReply-GetDraft ")
    @GetMapping("discuss_posts/{postId}/discuss_replies/get_draft")
    public ResponseEntity<DiscussReplyDTO> getDraftByPostId
            (@PathVariable("postId") String postId, @SpringQueryMap DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        DiscussReply rt = discussReplyService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(discussReplyDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"讨论回复" },  notes = "DiscussReply-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-fetch_default-all') or hasPermission('discuss_post',#postId,#dto,'ibizplm-DiscussReply-fetch_default')")
    @PostMapping("discuss_posts/{postId}/discuss_replies/fetch_default")
    public ResponseEntity<List<DiscussReplyDTO>> fetchDefaultByPostId
            (@PathVariable("postId") String postId, @Validated @RequestBody DiscussReplyFilterDTO dto) {
        dto.setPostIdEQ(postId);
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchDefault(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_reply 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_my_reply", tags = {"讨论回复" },  notes = "DiscussReply-fetch_my_reply ")
    @PostMapping("discuss_posts/{postId}/discuss_replies/fetch_my_reply")
    public ResponseEntity<List<DiscussReplyDTO>> fetchMyReplyByPostId
            (@PathVariable("postId") String postId, @Validated @RequestBody DiscussReplyFilterDTO dto) {
        dto.setPostIdEQ(postId);
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchMyReply(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_recent 讨论回复
    * 
    *
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_recent", tags = {"讨论回复" },  notes = "DiscussReply-fetch_recent ")
    @PostMapping("discuss_posts/{postId}/discuss_replies/fetch_recent")
    public ResponseEntity<List<DiscussReplyDTO>> fetchRecentByPostId
            (@PathVariable("postId") String postId, @Validated @RequestBody DiscussReplyFilterDTO dto) {
        dto.setPostIdEQ(postId);
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchRecent(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param id id
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"讨论回复" },  notes = "DiscussReply-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Get-all')  or hasPermission('discuss_topic',#topicId,this.discussReplyDtoMapping.toDomain(returnObject.body),'ibizplm-DiscussReply-Get')")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{id}")
    public ResponseEntity<DiscussReplyDTO> getByTopicIdAndPostIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("id") String id) {
        DiscussReply rt = discussReplyService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(discussReplyDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"讨论回复" },  notes = "DiscussReply-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-Remove-all') or hasPermission('discuss_topic',#topicId,this.discussReplyService.get(#id),'ibizplm-DiscussReply-Remove')")
    @DeleteMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/{id}")
    public ResponseEntity<Boolean> removeByTopicIdAndPostIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @PathVariable("id") String id) {
        Boolean rt = discussReplyService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"讨论回复" },  notes = "DiscussReply-CheckKey ")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/check_key")
    public ResponseEntity<Integer> checkKeyByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @Validated @RequestBody DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        Integer rt = discussReplyService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<DiscussReplyDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"讨论回复" },  notes = "DiscussReply-GetDraft ")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/get_draft")
    public ResponseEntity<DiscussReplyDTO> getDraftByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @SpringQueryMap DiscussReplyDTO dto) {
        DiscussReply domain = discussReplyDtoMapping.toDomain(dto);
        domain.setPostId(postId);
        DiscussReply rt = discussReplyService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(discussReplyDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"讨论回复" },  notes = "DiscussReply-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussReply-fetch_default-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussReply-fetch_default')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/fetch_default")
    public ResponseEntity<List<DiscussReplyDTO>> fetchDefaultByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @Validated @RequestBody DiscussReplyFilterDTO dto) {
        dto.setPostIdEQ(postId);
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchDefault(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_reply 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_my_reply", tags = {"讨论回复" },  notes = "DiscussReply-fetch_my_reply ")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/fetch_my_reply")
    public ResponseEntity<List<DiscussReplyDTO>> fetchMyReplyByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @Validated @RequestBody DiscussReplyFilterDTO dto) {
        dto.setPostIdEQ(postId);
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchMyReply(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_recent 讨论回复
    * 
    *
    * @param topicId topicId
    * @param postId postId
    * @param dto dto
    * @return ResponseEntity<List<DiscussReplyDTO>>
    */
    @ApiOperation(value = "查询fetch_recent", tags = {"讨论回复" },  notes = "DiscussReply-fetch_recent ")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{postId}/discuss_replies/fetch_recent")
    public ResponseEntity<List<DiscussReplyDTO>> fetchRecentByTopicIdAndPostId
            (@PathVariable("topicId") String topicId, @PathVariable("postId") String postId, @Validated @RequestBody DiscussReplyFilterDTO dto) {
        dto.setPostIdEQ(postId);
        DiscussReplySearchContext context = discussReplyFilterDtoMapping.toDomain(dto);
        Page<DiscussReply> domains = discussReplyService.fetchRecent(context) ;
        List<DiscussReplyDTO> list = discussReplyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建讨论回复
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussReply-Create-all')")
    @ApiOperation(value = "批量新建讨论回复", tags = {"讨论回复" },  notes = "批量新建讨论回复")
	@PostMapping("discuss_replies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DiscussReplyDTO> dtos) {
        discussReplyService.create(discussReplyDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除讨论回复
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussReply-Remove-all')")
    @ApiOperation(value = "批量删除讨论回复", tags = {"讨论回复" },  notes = "批量删除讨论回复")
	@DeleteMapping("discuss_replies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        discussReplyService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新讨论回复
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussReply-Update-all')")
    @ApiOperation(value = "批量更新讨论回复", tags = {"讨论回复" },  notes = "批量更新讨论回复")
	@PutMapping("discuss_replies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DiscussReplyDTO> dtos) {
        discussReplyService.update(discussReplyDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存讨论回复
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussReply-Save-all')")
    @ApiOperation(value = "批量保存讨论回复", tags = {"讨论回复" },  notes = "批量保存讨论回复")
	@PostMapping("discuss_replies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DiscussReplyDTO> dtos) {
        discussReplyService.save(discussReplyDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入讨论回复
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussReply-Save-all')")
    @ApiOperation(value = "批量导入讨论回复", tags = {"讨论回复" },  notes = "批量导入讨论回复")
	@PostMapping("discuss_replies/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DiscussReplyDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(discussReplyService.importData(config,ignoreError,discussReplyDtoMapping.toDomain(dtos)));
    }

}
