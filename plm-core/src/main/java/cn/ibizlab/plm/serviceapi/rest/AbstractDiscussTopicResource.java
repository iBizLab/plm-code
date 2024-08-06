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
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.team.service.DiscussTopicService;
import cn.ibizlab.plm.core.team.filter.DiscussTopicSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[DiscussTopic] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDiscussTopicResource {

    @Autowired
    public DiscussTopicService discussTopicService;

    @Autowired
    @Lazy
    public DiscussTopicDTOMapping discussTopicDtoMapping;

    @Autowired
    @Lazy
    public DiscussTopicFilterDTOMapping discussTopicFilterDtoMapping;

    /**
    * 创建Create 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"话题" },  notes = "DiscussTopic-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-Create-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-Create')")
    @PostMapping("discuss_topics")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>create
            (@Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 话题
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO create
            (DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        discussTopicService.create(domain);
        DiscussTopic rt = domain;
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"话题" },  notes = "DiscussTopic-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-Update-all') or hasPermission(this.discussTopicService.get(#id),'ibizplm-DiscussTopic-Update')")
    @VersionCheck(entity = "discusstopic" , versionfield = "updateTime")
    @PutMapping("discuss_topics/{id}")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO updateById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        discussTopicService.update(domain);
        DiscussTopic rt = domain;
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * activate 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "activate", tags = {"话题" },  notes = "DiscussTopic-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-activate-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-activate')")
    @PostMapping("discuss_topics/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * activate 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO activateById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussTopic rt = discussTopicService.activate(domain);
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * archive 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "archive", tags = {"话题" },  notes = "DiscussTopic-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-archive-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-archive')")
    @PostMapping("discuss_topics/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * archive 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO archiveById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussTopic rt = discussTopicService.archive(domain);
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * change_admin_role 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "change_admin_role", tags = {"话题" },  notes = "DiscussTopic-change_admin_role ")
    @PostMapping("discuss_topics/{id}/change_admin_role")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>changeAdminRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAdminRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAdminRoleById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_admin_role 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO changeAdminRoleById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussTopic rt = discussTopicService.changeAdminRole(domain);
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * delete 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "delete", tags = {"话题" },  notes = "DiscussTopic-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-delete-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-delete')")
    @PostMapping("discuss_topics/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO deleteById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussTopic rt = discussTopicService.delete(domain);
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * favorite 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "favorite", tags = {"话题" },  notes = "DiscussTopic-favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-favorite-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-favorite')")
    @PostMapping("discuss_topics/{id}/favorite")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * favorite 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO favoriteById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussTopic rt = discussTopicService.favorite(domain);
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * move_discuss_topic 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "move_discuss_topic", tags = {"话题" },  notes = "DiscussTopic-move_discuss_topic ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-move_discuss_topic-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-move_discuss_topic')")
    @PutMapping("discuss_topics/{id}/move_discuss_topic")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>moveDiscussTopicById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveDiscussTopicById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveDiscussTopicById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_discuss_topic 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO moveDiscussTopicById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussTopic rt = discussTopicService.moveDiscussTopic(domain);
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * recover 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "recover", tags = {"话题" },  notes = "DiscussTopic-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-recover-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-recover')")
    @PostMapping("discuss_topics/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO recoverById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussTopic rt = discussTopicService.recover(domain);
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"话题" },  notes = "DiscussTopic-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-Save-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-Save')")
    @PostMapping("discuss_topics/save")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>save
            (@Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 话题
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO save
            (DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        discussTopicService.save(domain);
        DiscussTopic rt = domain;
        return discussTopicDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "un_favorite", tags = {"话题" },  notes = "DiscussTopic-un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-un_favorite-all') or hasPermission(this.discussTopicDtoMapping.toDomain(#dto),'ibizplm-DiscussTopic-un_favorite')")
    @PostMapping("discuss_topics/{id}/un_favorite")
    public Mono<ResponseEntity<ResponseWrapper<DiscussTopicDTO>>>unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DiscussTopicDTO> dto) {
        ResponseWrapper<DiscussTopicDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * un_favorite 话题
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DiscussTopicDTO>
    */   
    public DiscussTopicDTO unFavoriteById
            (String id, DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        domain.setId(id);
        DiscussTopic rt = discussTopicService.unFavorite(domain);
        return discussTopicDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 话题
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"话题" },  notes = "DiscussTopic-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-Get-all')  or hasPermission(this.discussTopicDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-DiscussTopic-Get')")
    @GetMapping("discuss_topics/{id}")
    public Mono<ResponseEntity<DiscussTopicDTO>> getById
            (@PathVariable("id") String id) {
        DiscussTopic rt = discussTopicService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussTopicDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 话题
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"话题" },  notes = "DiscussTopic-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-Remove-all') or hasPermission(this.discussTopicService.get(#id),'ibizplm-DiscussTopic-Remove')")
    @DeleteMapping("discuss_topics/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = discussTopicService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"话题" },  notes = "DiscussTopic-CheckKey ")
    @PostMapping("discuss_topics/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        CheckKeyStatus rt = discussTopicService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DiscussTopicDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"话题" },  notes = "DiscussTopic-GetDraft ")
    @GetMapping("discuss_topics/get_draft")
    public Mono<ResponseEntity<DiscussTopicDTO>> getDraft
            (@SpringQueryMap DiscussTopicDTO dto) {
        DiscussTopic domain = discussTopicDtoMapping.toDomain(dto);
        DiscussTopic rt = discussTopicService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussTopicDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_admin 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"话题" },  notes = "DiscussTopic-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_admin-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_admin')")
    @PostMapping("discuss_topics/fetch_admin")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchAdmin
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchAdmin(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"话题" },  notes = "DiscussTopic-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_archived-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_archived')")
    @PostMapping("discuss_topics/fetch_archived")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchArchived
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchArchived(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived_main 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived_main", tags = {"话题" },  notes = "DiscussTopic-fetch_archived_main ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_archived_main-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_archived_main')")
    @PostMapping("discuss_topics/fetch_archived_main")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchArchivedMain
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchArchivedMain(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"话题" },  notes = "DiscussTopic-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_default-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_default')")
    @PostMapping("discuss_topics/fetch_default")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchDefault
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchDefault(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"话题" },  notes = "DiscussTopic-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_deleted-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_deleted')")
    @PostMapping("discuss_topics/fetch_deleted")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchDeleted
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchDeleted(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_favorite 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_favorite", tags = {"话题" },  notes = "DiscussTopic-fetch_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_favorite-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_favorite')")
    @PostMapping("discuss_topics/fetch_favorite")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchFavorite
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchFavorite(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_group 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_group", tags = {"话题" },  notes = "DiscussTopic-fetch_group ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_group-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_group')")
    @PostMapping("discuss_topics/fetch_group")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchGroup
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchGroup(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_main 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_main", tags = {"话题" },  notes = "DiscussTopic-fetch_main ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_main-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_main')")
    @PostMapping("discuss_topics/fetch_main")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchMain
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchMain(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"话题" },  notes = "DiscussTopic-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_normal-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_normal')")
    @PostMapping("discuss_topics/fetch_normal")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchNormal
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchNormal(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_quick_user 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_quick_user", tags = {"话题" },  notes = "DiscussTopic-fetch_quick_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_quick_user-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_quick_user')")
    @PostMapping("discuss_topics/fetch_quick_user")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchQuickUser
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchQuickUser(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"话题" },  notes = "DiscussTopic-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_reader-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_reader')")
    @PostMapping("discuss_topics/fetch_reader")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchReader
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchReader(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user 话题
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DiscussTopicDTO>>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"话题" },  notes = "DiscussTopic-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DiscussTopic-fetch_user-all') or hasPermission(#dto,'ibizplm-DiscussTopic-fetch_user')")
    @PostMapping("discuss_topics/fetch_user")
    public Mono<ResponseEntity<List<DiscussTopicDTO>>> fetchUser
            (@Validated @RequestBody DiscussTopicFilterDTO dto) {
        DiscussTopicSearchContext context = discussTopicFilterDtoMapping.toDomain(dto);
        Page<DiscussTopic> domains = discussTopicService.fetchUser(context) ;
        List<DiscussTopicDTO> list = discussTopicDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建话题
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussTopic-Create-all')")
    @ApiOperation(value = "批量新建话题", tags = {"话题" },  notes = "批量新建话题")
	@PostMapping("discuss_topics/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<DiscussTopicDTO> dtos) {
        discussTopicService.create(discussTopicDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除话题
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussTopic-Remove-all')")
    @ApiOperation(value = "批量删除话题", tags = {"话题" },  notes = "批量删除话题")
	@DeleteMapping("discuss_topics/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        discussTopicService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新话题
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussTopic-Update-all')")
    @ApiOperation(value = "批量更新话题", tags = {"话题" },  notes = "批量更新话题")
	@PutMapping("discuss_topics/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<DiscussTopicDTO> dtos) {
        discussTopicService.update(discussTopicDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存话题
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussTopic-Save-all')")
    @ApiOperation(value = "批量保存话题", tags = {"话题" },  notes = "批量保存话题")
	@PostMapping("discuss_topics/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<DiscussTopicDTO> dtos) {
        discussTopicService.save(discussTopicDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入话题
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DiscussTopic-Save-all')")
    @ApiOperation(value = "批量导入话题", tags = {"话题" },  notes = "批量导入话题")
	@PostMapping("discuss_topics/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DiscussTopicDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(discussTopicService.importData(config,ignoreError,discussTopicDtoMapping.toDomain(dtos))));
    }

}
