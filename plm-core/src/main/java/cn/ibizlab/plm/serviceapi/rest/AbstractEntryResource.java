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
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.service.EntryService;
import cn.ibizlab.plm.core.projmgmt.filter.EntrySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Entry] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractEntryResource {

    @Autowired
    public EntryService entryService;

    @Autowired
    @Lazy
    public EntryDTOMapping entryDtoMapping;

    @Autowired
    @Lazy
    public EntryFilterDTOMapping entryFilterDtoMapping;

    /**
    * 创建Create 看板栏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"看板栏" },  notes = "Entry-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Create-all') or hasPermission(this.entryDtoMapping.toDomain(#dto),'ibizplm-Entry-Create')")
    @PostMapping("entries")
    public ResponseEntity<ResponseWrapper<EntryDTO>> create
            (@Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 看板栏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO create
            (EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        entryService.create(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 看板栏
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"看板栏" },  notes = "Entry-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Update-all') or hasPermission(this.entryService.get(#id),'ibizplm-Entry-Update')")
    @VersionCheck(entity = "entry" , versionfield = "updateTime")
    @PutMapping("entries/{id}")
    public ResponseEntity<ResponseWrapper<EntryDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 看板栏
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO updateById
            (String id, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setId(id);
        entryService.update(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 看板栏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"看板栏" },  notes = "Entry-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Save-all') or hasPermission(this.entryDtoMapping.toDomain(#dto),'ibizplm-Entry-Save')")
    @PostMapping("entries/save")
    public ResponseEntity<ResponseWrapper<EntryDTO>> save
            (@Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 看板栏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO save
            (EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        entryService.save(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 看板栏
    * 
    *
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"看板栏" },  notes = "Entry-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Create-all') or hasPermission('board',#boardId,this.entryDtoMapping.toDomain(#dto),'ibizplm-Entry-Create')")
    @PostMapping("boards/{boardId}/entries")
    public ResponseEntity<ResponseWrapper<EntryDTO>> createByBoardId
            (@PathVariable("boardId") String boardId, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByBoardId(boardId, item)));
        else
            rt.set(createByBoardId(boardId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 看板栏
    * 
    *
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO createByBoardId
            (String boardId, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setBoardId(boardId);
        entryService.create(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 看板栏
    * 
    *
    * @param boardId boardId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"看板栏" },  notes = "Entry-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Update-all') or hasPermission('board',#boardId,this.entryService.get(#id),'ibizplm-Entry-Update')")
    @VersionCheck(entity = "entry" , versionfield = "updateTime")
    @PutMapping("boards/{boardId}/entries/{id}")
    public ResponseEntity<ResponseWrapper<EntryDTO>> updateByBoardIdAndId
            (@PathVariable("boardId") String boardId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByBoardIdAndId(boardId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByBoardIdAndId(boardId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 看板栏
    * 
    *
    * @param boardId boardId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO updateByBoardIdAndId
            (String boardId, String id, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setId(id);
        entryService.update(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 看板栏
    * 
    *
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"看板栏" },  notes = "Entry-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Save-all') or hasPermission('board',#boardId,this.entryDtoMapping.toDomain(#dto),'ibizplm-Entry-Save')")
    @PostMapping("boards/{boardId}/entries/save")
    public ResponseEntity<ResponseWrapper<EntryDTO>> saveByBoardId
            (@PathVariable("boardId") String boardId, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByBoardId(boardId, item)));
        else
            rt.set(saveByBoardId(boardId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 看板栏
    * 
    *
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO saveByBoardId
            (String boardId, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setBoardId(boardId);
        entryService.save(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"看板栏" },  notes = "Entry-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Create-all') or hasPermission('project',#projectId,this.entryDtoMapping.toDomain(#dto),'ibizplm-Entry-Create')")
    @PostMapping("projects/{projectId}/boards/{boardId}/entries")
    public ResponseEntity<ResponseWrapper<EntryDTO>> createByProjectIdAndBoardId
            (@PathVariable("projectId") String projectId, @PathVariable("boardId") String boardId, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectIdAndBoardId(projectId, boardId, item)));
        else
            rt.set(createByProjectIdAndBoardId(projectId, boardId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO createByProjectIdAndBoardId
            (String projectId, String boardId, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setBoardId(boardId);
        entryService.create(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"看板栏" },  notes = "Entry-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Update-all') or hasPermission('project',#projectId,this.entryService.get(#id),'ibizplm-Entry-Update')")
    @VersionCheck(entity = "entry" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/boards/{boardId}/entries/{id}")
    public ResponseEntity<ResponseWrapper<EntryDTO>> updateByProjectIdAndBoardIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("boardId") String boardId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndBoardIdAndId(projectId, boardId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndBoardIdAndId(projectId, boardId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO updateByProjectIdAndBoardIdAndId
            (String projectId, String boardId, String id, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setId(id);
        entryService.update(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"看板栏" },  notes = "Entry-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Save-all') or hasPermission('project',#projectId,this.entryDtoMapping.toDomain(#dto),'ibizplm-Entry-Save')")
    @PostMapping("projects/{projectId}/boards/{boardId}/entries/save")
    public ResponseEntity<ResponseWrapper<EntryDTO>> saveByProjectIdAndBoardId
            (@PathVariable("projectId") String projectId, @PathVariable("boardId") String boardId, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectIdAndBoardId(projectId, boardId, item)));
        else
            rt.set(saveByProjectIdAndBoardId(projectId, boardId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO saveByProjectIdAndBoardId
            (String projectId, String boardId, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setBoardId(boardId);
        entryService.save(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 看板栏
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"看板栏" },  notes = "Entry-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Create-all') or hasPermission('project',#projectId,this.entryDtoMapping.toDomain(#dto),'ibizplm-Entry-Create')")
    @PostMapping("projects/{projectId}/entries")
    public ResponseEntity<ResponseWrapper<EntryDTO>> createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 看板栏
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO createByProjectId
            (String projectId, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        entryService.create(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 看板栏
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"看板栏" },  notes = "Entry-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Update-all') or hasPermission('project',#projectId,this.entryService.get(#id),'ibizplm-Entry-Update')")
    @VersionCheck(entity = "entry" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/entries/{id}")
    public ResponseEntity<ResponseWrapper<EntryDTO>> updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 看板栏
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO updateByProjectIdAndId
            (String projectId, String id, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setId(id);
        entryService.update(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 看板栏
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"看板栏" },  notes = "Entry-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Save-all') or hasPermission('project',#projectId,this.entryDtoMapping.toDomain(#dto),'ibizplm-Entry-Save')")
    @PostMapping("projects/{projectId}/entries/save")
    public ResponseEntity<ResponseWrapper<EntryDTO>> saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<EntryDTO> dto) {
        ResponseWrapper<EntryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 看板栏
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */   
    public EntryDTO saveByProjectId
            (String projectId, EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        entryService.save(domain);
        Entry rt = domain;
        return entryDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 看板栏
    * 
    *
    * @param id id
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"看板栏" },  notes = "Entry-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Get-all')  or hasPermission(this.entryDtoMapping.toDomain(returnObject.body),'ibizplm-Entry-Get')")
    @GetMapping("entries/{id}")
    public ResponseEntity<EntryDTO> getById
            (@PathVariable("id") String id) {
        Entry rt = entryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(entryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 看板栏
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"看板栏" },  notes = "Entry-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Remove-all') or hasPermission(this.entryService.get(#id),'ibizplm-Entry-Remove')")
    @DeleteMapping("entries/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = entryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 看板栏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"看板栏" },  notes = "Entry-CheckKey ")
    @PostMapping("entries/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        Integer rt = entryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 看板栏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"看板栏" },  notes = "Entry-GetDraft ")
    @GetMapping("entries/get_draft")
    public ResponseEntity<EntryDTO> getDraft
            (@SpringQueryMap EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        Entry rt = entryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(entryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 看板栏
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<EntryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"看板栏" },  notes = "Entry-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-fetch_default-all') or hasPermission(#dto,'ibizplm-Entry-fetch_default')")
    @PostMapping("entries/fetch_default")
    public ResponseEntity<List<EntryDTO>> fetchDefault
            (@Validated @RequestBody EntryFilterDTO dto) {
        EntrySearchContext context = entryFilterDtoMapping.toDomain(dto);
        Page<Entry> domains = entryService.searchDefault(context) ;
        List<EntryDTO> list = entryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 看板栏
    * 
    *
    * @param boardId boardId
    * @param id id
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"看板栏" },  notes = "Entry-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Get-all')  or hasPermission('board',#boardId,this.entryDtoMapping.toDomain(returnObject.body),'ibizplm-Entry-Get')")
    @GetMapping("boards/{boardId}/entries/{id}")
    public ResponseEntity<EntryDTO> getByBoardIdAndId
            (@PathVariable("boardId") String boardId, @PathVariable("id") String id) {
        Entry rt = entryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(entryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 看板栏
    * 
    *
    * @param boardId boardId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"看板栏" },  notes = "Entry-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Remove-all') or hasPermission('board',#boardId,this.entryService.get(#id),'ibizplm-Entry-Remove')")
    @DeleteMapping("boards/{boardId}/entries/{id}")
    public ResponseEntity<Boolean> removeByBoardIdAndId
            (@PathVariable("boardId") String boardId, @PathVariable("id") String id) {
        Boolean rt = entryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 看板栏
    * 
    *
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"看板栏" },  notes = "Entry-CheckKey ")
    @PostMapping("boards/{boardId}/entries/check_key")
    public ResponseEntity<Integer> checkKeyByBoardId
            (@PathVariable("boardId") String boardId, @Validated @RequestBody EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setBoardId(boardId);
        Integer rt = entryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 看板栏
    * 
    *
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"看板栏" },  notes = "Entry-GetDraft ")
    @GetMapping("boards/{boardId}/entries/get_draft")
    public ResponseEntity<EntryDTO> getDraftByBoardId
            (@PathVariable("boardId") String boardId, @SpringQueryMap EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setBoardId(boardId);
        Entry rt = entryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(entryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 看板栏
    * 
    *
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<List<EntryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"看板栏" },  notes = "Entry-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-fetch_default-all') or hasPermission('board',#boardId,#dto,'ibizplm-Entry-fetch_default')")
    @PostMapping("boards/{boardId}/entries/fetch_default")
    public ResponseEntity<List<EntryDTO>> fetchDefaultByBoardId
            (@PathVariable("boardId") String boardId, @Validated @RequestBody EntryFilterDTO dto) {
        dto.setBoardIdEQ(boardId);
        EntrySearchContext context = entryFilterDtoMapping.toDomain(dto);
        Page<Entry> domains = entryService.searchDefault(context) ;
        List<EntryDTO> list = entryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param id id
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"看板栏" },  notes = "Entry-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Get-all')  or hasPermission('project',#projectId,this.entryDtoMapping.toDomain(returnObject.body),'ibizplm-Entry-Get')")
    @GetMapping("projects/{projectId}/boards/{boardId}/entries/{id}")
    public ResponseEntity<EntryDTO> getByProjectIdAndBoardIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("boardId") String boardId, @PathVariable("id") String id) {
        Entry rt = entryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(entryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"看板栏" },  notes = "Entry-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Remove-all') or hasPermission('project',#projectId,this.entryService.get(#id),'ibizplm-Entry-Remove')")
    @DeleteMapping("projects/{projectId}/boards/{boardId}/entries/{id}")
    public ResponseEntity<Boolean> removeByProjectIdAndBoardIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("boardId") String boardId, @PathVariable("id") String id) {
        Boolean rt = entryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"看板栏" },  notes = "Entry-CheckKey ")
    @PostMapping("projects/{projectId}/boards/{boardId}/entries/check_key")
    public ResponseEntity<Integer> checkKeyByProjectIdAndBoardId
            (@PathVariable("projectId") String projectId, @PathVariable("boardId") String boardId, @Validated @RequestBody EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setBoardId(boardId);
        Integer rt = entryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"看板栏" },  notes = "Entry-GetDraft ")
    @GetMapping("projects/{projectId}/boards/{boardId}/entries/get_draft")
    public ResponseEntity<EntryDTO> getDraftByProjectIdAndBoardId
            (@PathVariable("projectId") String projectId, @PathVariable("boardId") String boardId, @SpringQueryMap EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setBoardId(boardId);
        Entry rt = entryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(entryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 看板栏
    * 
    *
    * @param projectId projectId
    * @param boardId boardId
    * @param dto dto
    * @return ResponseEntity<List<EntryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"看板栏" },  notes = "Entry-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Entry-fetch_default')")
    @PostMapping("projects/{projectId}/boards/{boardId}/entries/fetch_default")
    public ResponseEntity<List<EntryDTO>> fetchDefaultByProjectIdAndBoardId
            (@PathVariable("projectId") String projectId, @PathVariable("boardId") String boardId, @Validated @RequestBody EntryFilterDTO dto) {
        dto.setBoardIdEQ(boardId);
        EntrySearchContext context = entryFilterDtoMapping.toDomain(dto);
        Page<Entry> domains = entryService.searchDefault(context) ;
        List<EntryDTO> list = entryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 看板栏
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"看板栏" },  notes = "Entry-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Get-all')  or hasPermission('project',#projectId,this.entryDtoMapping.toDomain(returnObject.body),'ibizplm-Entry-Get')")
    @GetMapping("projects/{projectId}/entries/{id}")
    public ResponseEntity<EntryDTO> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Entry rt = entryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(entryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 看板栏
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"看板栏" },  notes = "Entry-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-Remove-all') or hasPermission('project',#projectId,this.entryService.get(#id),'ibizplm-Entry-Remove')")
    @DeleteMapping("projects/{projectId}/entries/{id}")
    public ResponseEntity<Boolean> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = entryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 看板栏
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"看板栏" },  notes = "Entry-CheckKey ")
    @PostMapping("projects/{projectId}/entries/check_key")
    public ResponseEntity<Integer> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Integer rt = entryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 看板栏
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<EntryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"看板栏" },  notes = "Entry-GetDraft ")
    @GetMapping("projects/{projectId}/entries/get_draft")
    public ResponseEntity<EntryDTO> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap EntryDTO dto) {
        Entry domain = entryDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Entry rt = entryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(entryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 看板栏
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<EntryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"看板栏" },  notes = "Entry-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Entry-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Entry-fetch_default')")
    @PostMapping("projects/{projectId}/entries/fetch_default")
    public ResponseEntity<List<EntryDTO>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody EntryFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        EntrySearchContext context = entryFilterDtoMapping.toDomain(dto);
        Page<Entry> domains = entryService.searchDefault(context) ;
        List<EntryDTO> list = entryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建看板栏
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Entry-Create-all')")
    @ApiOperation(value = "批量新建看板栏", tags = {"看板栏" },  notes = "批量新建看板栏")
	@PostMapping("entries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<EntryDTO> dtos) {
        entryService.createBatch(entryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除看板栏
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Entry-Remove-all')")
    @ApiOperation(value = "批量删除看板栏", tags = {"看板栏" },  notes = "批量删除看板栏")
	@DeleteMapping("entries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        entryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新看板栏
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Entry-Update-all')")
    @ApiOperation(value = "批量更新看板栏", tags = {"看板栏" },  notes = "批量更新看板栏")
	@PutMapping("entries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<EntryDTO> dtos) {
        entryService.updateBatch(entryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存看板栏
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Entry-Save-all')")
    @ApiOperation(value = "批量保存看板栏", tags = {"看板栏" },  notes = "批量保存看板栏")
	@PostMapping("entries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<EntryDTO> dtos) {
        entryService.saveBatch(entryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入看板栏
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Entry-Save-all')")
    @ApiOperation(value = "批量导入看板栏", tags = {"看板栏" },  notes = "批量导入看板栏")
	@PostMapping("entries/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<EntryDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(entryService.importData(config,ignoreError,entryDtoMapping.toDomain(dtos)));
    }

}
