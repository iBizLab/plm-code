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
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.service.DiscussPostService;
import cn.ibizlab.plm.core.team.filter.DiscussPostSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[DiscussPost] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDiscussPostResource {

    @Autowired
    public DiscussPostService discussPostService;

    @Autowired
    @Lazy
    public DiscussPostDTOMapping discussPostDtoMapping;

    @Autowired
    @Lazy
    public DiscussPostFilterDTOMapping discussPostFilterDtoMapping;

    /**
    * 创建Create 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"讨论" },  notes = "DiscussPost-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Create-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-Create')")
    @PostMapping("discuss_posts")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>create
            (@Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 讨论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO create
            (DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        discussPostService.create(domain);
        DiscussPost rt = domain;
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"讨论" },  notes = "DiscussPost-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Update-all') or hasPermission(this.discussPostService.get(#id),'ibizplm-DiscussPost-Update')")
    @VersionCheck(entity = "discusspost" , versionfield = "updateTime")
    @PutMapping("discuss_posts/{id}")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO updateById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        discussPostService.update(domain);
        DiscussPost rt = domain;
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * close 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "close", tags = {"讨论" },  notes = "DiscussPost-close ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-close-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-close')")
    @PostMapping("discuss_posts/{id}/close")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>closeById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(closeById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(closeById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * close 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO closeById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.close(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * del_comment 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "del_comment", tags = {"讨论" },  notes = "DiscussPost-del_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-del_comment-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-del_comment')")
    @PostMapping("discuss_posts/{id}/del_comment")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>delCommentById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delCommentById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delCommentById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * del_comment 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO delCommentById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.delComment(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * delete 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "delete", tags = {"讨论" },  notes = "DiscussPost-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-delete-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-delete')")
    @PostMapping("discuss_posts/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO deleteById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.delete(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * fill_addition 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "fill_addition", tags = {"讨论" },  notes = "DiscussPost-fill_addition ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fill_addition-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-fill_addition')")
    @PostMapping("discuss_posts/{id}/fill_addition")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>fillAdditionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillAdditionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillAdditionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_addition 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO fillAdditionById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.fillAddition(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * move 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "move", tags = {"讨论" },  notes = "DiscussPost-move ")
    @PostMapping("discuss_posts/{id}/move")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>moveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO moveById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.move(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * open 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "open", tags = {"讨论" },  notes = "DiscussPost-open ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-open-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-open')")
    @PostMapping("discuss_posts/{id}/open")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>openById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(openById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(openById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * open 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO openById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.open(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * recover 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "recover", tags = {"讨论" },  notes = "DiscussPost-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-recover-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-recover')")
    @PostMapping("discuss_posts/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO recoverById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.recover(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"讨论" },  notes = "DiscussPost-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Save-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-Save')")
    @PostMapping("discuss_posts/save")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>save
            (@Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 讨论
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO save
            (DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        discussPostService.save(domain);
        DiscussPost rt = domain;
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * send_comment 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "send_comment", tags = {"讨论" },  notes = "DiscussPost-send_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-send_comment-all') or hasPermission(this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-send_comment')")
    @PostMapping("discuss_posts/{id}/send_comment")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>sendCommentById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sendCommentById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sendCommentById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * send_comment 讨论
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO sendCommentById
            (String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.sendComment(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"讨论" },  notes = "DiscussPost-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Create-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-Create')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>createByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTopicId(topicId, item)));
        else
            rt.set(createByTopicId(topicId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO createByTopicId
            (String topicId, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setTopicId(topicId);
        discussPostService.create(domain);
        DiscussPost rt = domain;
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"讨论" },  notes = "DiscussPost-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Update-all') or hasPermission('discuss_topic',#topicId,this.discussPostService.get(#id),'ibizplm-DiscussPost-Update')")
    @VersionCheck(entity = "discusspost" , versionfield = "updateTime")
    @PutMapping("discuss_topics/{topicId}/discuss_posts/{id}")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>updateByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO updateByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        discussPostService.update(domain);
        DiscussPost rt = domain;
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * close 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "close", tags = {"讨论" },  notes = "DiscussPost-close ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-close-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-close')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{id}/close")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>closeByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(closeByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(closeByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * close 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO closeByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.close(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * del_comment 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "del_comment", tags = {"讨论" },  notes = "DiscussPost-del_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-del_comment-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-del_comment')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{id}/del_comment")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>delCommentByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delCommentByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delCommentByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * del_comment 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO delCommentByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.delComment(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * delete 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "delete", tags = {"讨论" },  notes = "DiscussPost-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-delete-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-delete')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>deleteByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO deleteByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.delete(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * fill_addition 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "fill_addition", tags = {"讨论" },  notes = "DiscussPost-fill_addition ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fill_addition-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-fill_addition')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{id}/fill_addition")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>fillAdditionByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillAdditionByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillAdditionByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_addition 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO fillAdditionByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.fillAddition(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * move 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "move", tags = {"讨论" },  notes = "DiscussPost-move ")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{id}/move")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>moveByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO moveByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.move(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * open 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "open", tags = {"讨论" },  notes = "DiscussPost-open ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-open-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-open')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{id}/open")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>openByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(openByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(openByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * open 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO openByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.open(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * recover 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "recover", tags = {"讨论" },  notes = "DiscussPost-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-recover-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-recover')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>recoverByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO recoverByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.recover(domain);
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"讨论" },  notes = "DiscussPost-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Save-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-Save')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/save")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>saveByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTopicId(topicId, item)));
        else
            rt.set(saveByTopicId(topicId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO saveByTopicId
            (String topicId, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setTopicId(topicId);
        discussPostService.save(domain);
        DiscussPost rt = domain;
        return discussPostDtoMapping.toDto(rt);
    }

    /**
    * send_comment 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "send_comment", tags = {"讨论" },  notes = "DiscussPost-send_comment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-send_comment-all') or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(#dto),'ibizplm-DiscussPost-send_comment')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/{id}/send_comment")
    public Mono<ResponseEntity<ResponseWrapper<DiscussPostDTO>>>sendCommentByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussPostDTO> dto) {
        ResponseWrapper<DiscussPostDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sendCommentByTopicIdAndId(topicId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sendCommentByTopicIdAndId(topicId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * send_comment 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussPostDTO>
    */   
    public DiscussPostDTO sendCommentByTopicIdAndId
            (String topicId, String id, DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussPost rt = discussPostService.sendComment(domain);
        return discussPostDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 讨论
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"讨论" },  notes = "DiscussPost-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Get-all')  or hasPermission(this.discussPostDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-DiscussPost-Get')")
    @GetMapping("discuss_posts/{id}")
    public Mono<ResponseEntity<DiscussPostDTO>> getById
            (@PathVariable("id") String id) {
        DiscussPost rt = discussPostService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussPostDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 讨论
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"讨论" },  notes = "DiscussPost-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Remove-all') or hasPermission(this.discussPostService.get(#id),'ibizplm-DiscussPost-Remove')")
    @DeleteMapping("discuss_posts/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = discussPostService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"讨论" },  notes = "DiscussPost-CheckKey ")
    @PostMapping("discuss_posts/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        CheckKeyStatus rt = discussPostService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 讨论
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"讨论" },  notes = "DiscussPost-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-get_attention-all') or hasPermission(this.discussPostService.get(#id),'ibizplm-DiscussPost-get_attention')")
    @GetMapping("discuss_posts/{id}/get_attention")
    public Mono<ResponseEntity<DiscussPostDTO>> getAttentionById
            (@PathVariable("id") String id) {
        DiscussPost rt = discussPostService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussPostDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"讨论" },  notes = "DiscussPost-GetDraft ")
    @GetMapping("discuss_posts/get_draft")
    public Mono<ResponseEntity<DiscussPostDTO>> getDraft
            (@SpringQueryMap DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        DiscussPost rt = discussPostService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussPostDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"讨论" },  notes = "DiscussPost-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_default-all') or hasPermission(#dto,'ibizplm-DiscussPost-fetch_default')")
    @PostMapping("discuss_posts/fetch_default")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchDefault
            (@Validated @RequestBody DiscussPostFilterDTO dto) {
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchDefault(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"讨论" },  notes = "DiscussPost-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_deleted-all') or hasPermission(#dto,'ibizplm-DiscussPost-fetch_deleted')")
    @PostMapping("discuss_posts/fetch_deleted")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchDeleted
            (@Validated @RequestBody DiscussPostFilterDTO dto) {
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchDeleted(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"讨论" },  notes = "DiscussPost-fetch_my_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_my_attention-all') or hasPermission(#dto,'ibizplm-DiscussPost-fetch_my_attention')")
    @PostMapping("discuss_posts/fetch_my_attention")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchMyAttention
            (@Validated @RequestBody DiscussPostFilterDTO dto) {
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchMyAttention(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_create 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_create", tags = {"讨论" },  notes = "DiscussPost-fetch_my_create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_my_create-all') or hasPermission(#dto,'ibizplm-DiscussPost-fetch_my_create')")
    @PostMapping("discuss_posts/fetch_my_create")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchMyCreate
            (@Validated @RequestBody DiscussPostFilterDTO dto) {
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchMyCreate(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_reply 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_reply", tags = {"讨论" },  notes = "DiscussPost-fetch_my_reply ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_my_reply-all') or hasPermission(#dto,'ibizplm-DiscussPost-fetch_my_reply')")
    @PostMapping("discuss_posts/fetch_my_reply")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchMyReply
            (@Validated @RequestBody DiscussPostFilterDTO dto) {
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchMyReply(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"讨论" },  notes = "DiscussPost-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_normal-all') or hasPermission(#dto,'ibizplm-DiscussPost-fetch_normal')")
    @PostMapping("discuss_posts/fetch_normal")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchNormal
            (@Validated @RequestBody DiscussPostFilterDTO dto) {
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchNormal(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 讨论
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"讨论" },  notes = "DiscussPost-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_reader-all') or hasPermission(#dto,'ibizplm-DiscussPost-fetch_reader')")
    @PostMapping("discuss_posts/fetch_reader")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchReader
            (@Validated @RequestBody DiscussPostFilterDTO dto) {
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchReader(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent 讨论
    * 最新讨论
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent", tags = {"讨论" },  notes = "DiscussPost-fetch_recent 最新讨论")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_recent-all') or hasPermission(#dto,'ibizplm-DiscussPost-fetch_recent')")
    @PostMapping("discuss_posts/fetch_recent")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchRecent
            (@Validated @RequestBody DiscussPostFilterDTO dto) {
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchRecent(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"讨论" },  notes = "DiscussPost-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Get-all')  or hasPermission('discuss_topic',#topicId,this.discussPostDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-DiscussPost-Get')")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/{id}")
    public Mono<ResponseEntity<DiscussPostDTO>> getByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
        DiscussPost rt = discussPostService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussPostDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"讨论" },  notes = "DiscussPost-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-Remove-all') or hasPermission('discuss_topic',#topicId,this.discussPostService.get(#id),'ibizplm-DiscussPost-Remove')")
    @DeleteMapping("discuss_topics/{topicId}/discuss_posts/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
        Boolean rt = discussPostService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"讨论" },  notes = "DiscussPost-CheckKey ")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setTopicId(topicId);
        CheckKeyStatus rt = discussPostService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 讨论
    * 
    *
    * @param topicId topicId
    * @param id id
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"讨论" },  notes = "DiscussPost-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-get_attention-all') or hasPermission('discuss_topic',#topicId,this.discussPostService.get(#id),'ibizplm-DiscussPost-get_attention')")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/{id}/get_attention")
    public Mono<ResponseEntity<DiscussPostDTO>> getAttentionByTopicIdAndId
            (@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
        DiscussPost rt = discussPostService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussPostDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussPostDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"讨论" },  notes = "DiscussPost-GetDraft ")
    @GetMapping("discuss_topics/{topicId}/discuss_posts/get_draft")
    public Mono<ResponseEntity<DiscussPostDTO>> getDraftByTopicId
            (@PathVariable("topicId") String topicId, @SpringQueryMap DiscussPostDTO dto) {
        DiscussPost domain = discussPostDtoMapping.toDomain(dto);
        domain.setTopicId(topicId);
        DiscussPost rt = discussPostService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussPostDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"讨论" },  notes = "DiscussPost-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_default-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussPost-fetch_default')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/fetch_default")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchDefaultByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostFilterDTO dto) {
        dto.setTopicIdEQ(topicId);
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchDefault(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"讨论" },  notes = "DiscussPost-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_deleted-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussPost-fetch_deleted')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/fetch_deleted")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchDeletedByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostFilterDTO dto) {
        dto.setTopicIdEQ(topicId);
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchDeleted(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"讨论" },  notes = "DiscussPost-fetch_my_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_my_attention-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussPost-fetch_my_attention')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/fetch_my_attention")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchMyAttentionByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostFilterDTO dto) {
        dto.setTopicIdEQ(topicId);
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchMyAttention(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_create 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_create", tags = {"讨论" },  notes = "DiscussPost-fetch_my_create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_my_create-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussPost-fetch_my_create')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/fetch_my_create")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchMyCreateByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostFilterDTO dto) {
        dto.setTopicIdEQ(topicId);
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchMyCreate(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_reply 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_reply", tags = {"讨论" },  notes = "DiscussPost-fetch_my_reply ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_my_reply-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussPost-fetch_my_reply')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/fetch_my_reply")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchMyReplyByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostFilterDTO dto) {
        dto.setTopicIdEQ(topicId);
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchMyReply(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"讨论" },  notes = "DiscussPost-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_normal-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussPost-fetch_normal')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/fetch_normal")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchNormalByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostFilterDTO dto) {
        dto.setTopicIdEQ(topicId);
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchNormal(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 讨论
    * 
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"讨论" },  notes = "DiscussPost-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_reader-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussPost-fetch_reader')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/fetch_reader")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchReaderByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostFilterDTO dto) {
        dto.setTopicIdEQ(topicId);
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchReader(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent 讨论
    * 最新讨论
    *
    * @param topicId topicId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussPostDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent", tags = {"讨论" },  notes = "DiscussPost-fetch_recent 最新讨论")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussPost-fetch_recent-all') or hasPermission('discuss_topic',#topicId,#dto,'ibizplm-DiscussPost-fetch_recent')")
    @PostMapping("discuss_topics/{topicId}/discuss_posts/fetch_recent")
    public Mono<ResponseEntity<List<DiscussPostDTO>>> fetchRecentByTopicId
            (@PathVariable("topicId") String topicId, @Validated @RequestBody DiscussPostFilterDTO dto) {
        dto.setTopicIdEQ(topicId);
        DiscussPostSearchContext context = discussPostFilterDtoMapping.toDomain(dto);
        Page<DiscussPost> domains = discussPostService.fetchRecent(context) ;
        List<DiscussPostDTO> list = discussPostDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建讨论
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussPost-Create-all')")
    @ApiOperation(value = "批量新建讨论", tags = {"讨论" },  notes = "批量新建讨论")
	@PostMapping("discuss_posts/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<DiscussPostDTO> dtos) {
        discussPostService.create(discussPostDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除讨论
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussPost-Remove-all')")
    @ApiOperation(value = "批量删除讨论", tags = {"讨论" },  notes = "批量删除讨论")
	@DeleteMapping("discuss_posts/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        discussPostService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新讨论
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussPost-Update-all')")
    @ApiOperation(value = "批量更新讨论", tags = {"讨论" },  notes = "批量更新讨论")
	@PutMapping("discuss_posts/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<DiscussPostDTO> dtos) {
        discussPostService.update(discussPostDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存讨论
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussPost-Save-all')")
    @ApiOperation(value = "批量保存讨论", tags = {"讨论" },  notes = "批量保存讨论")
	@PostMapping("discuss_posts/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<DiscussPostDTO> dtos) {
        discussPostService.save(discussPostDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入讨论
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussPost-Save-all')")
    @ApiOperation(value = "批量导入讨论", tags = {"讨论" },  notes = "批量导入讨论")
	@PostMapping("discuss_posts/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DiscussPostDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussPostService.importData(config,ignoreError,discussPostDtoMapping.toDomain(dtos))));
    }

}
