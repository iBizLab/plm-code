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
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.service.BoardService;
import cn.ibizlab.plm.core.projmgmt.filter.BoardSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Board] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBoardResource {

    @Autowired
    public BoardService boardService;

    @Autowired
    @Lazy
    public BoardDTOMapping boardDtoMapping;

    @Autowired
    @Lazy
    public BoardFilterDTOMapping boardFilterDtoMapping;

    /**
    * 创建Create 看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"看板" },  notes = "Board-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Create-all') or hasPermission(this.boardDtoMapping.toDomain(#dto),'ibizplm-Board-Create')")
    @PostMapping("boards")
    public Mono<ResponseEntity<ResponseWrapper<BoardDTO>>>create
            (@Validated @RequestBody RequestWrapper<BoardDTO> dto) {
        ResponseWrapper<BoardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BoardDTO>
    */   
    public BoardDTO create
            (BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        boardService.create(domain);
        Board rt = domain;
        return boardDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 看板
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"看板" },  notes = "Board-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Update-all') or hasPermission(this.boardService.get(#id),'ibizplm-Board-Update')")
    @VersionCheck(entity = "board" , versionfield = "updateTime")
    @PutMapping("boards/{id}")
    public Mono<ResponseEntity<ResponseWrapper<BoardDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BoardDTO> dto) {
        ResponseWrapper<BoardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 看板
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BoardDTO>
    */   
    public BoardDTO updateById
            (String id, BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        domain.setId(id);
        boardService.update(domain);
        Board rt = domain;
        return boardDtoMapping.toDto(rt);
    }

    /**
    * check_board_is_deleted 看板
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "check_board_is_deleted", tags = {"看板" },  notes = "Board-check_board_is_deleted ")
    @PostMapping("boards/{id}/check_board_is_deleted")
    public Mono<ResponseEntity<ResponseWrapper<BoardDTO>>>checkBoardIsDeletedById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BoardDTO> dto) {
        ResponseWrapper<BoardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(checkBoardIsDeletedById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(checkBoardIsDeletedById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_board_is_deleted 看板
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BoardDTO>
    */   
    public BoardDTO checkBoardIsDeletedById
            (String id, BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        domain.setId(id);
        Board rt = boardService.checkBoardIsDeleted(domain);
        return boardDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"看板" },  notes = "Board-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Save-all') or hasPermission(this.boardDtoMapping.toDomain(#dto),'ibizplm-Board-Save')")
    @PostMapping("boards/save")
    public Mono<ResponseEntity<ResponseWrapper<BoardDTO>>>save
            (@Validated @RequestBody RequestWrapper<BoardDTO> dto) {
        ResponseWrapper<BoardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<BoardDTO>
    */   
    public BoardDTO save
            (BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        boardService.save(domain);
        Board rt = domain;
        return boardDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"看板" },  notes = "Board-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Create-all') or hasPermission('project',#projectId,this.boardDtoMapping.toDomain(#dto),'ibizplm-Board-Create')")
    @PostMapping("projects/{projectId}/boards")
    public Mono<ResponseEntity<ResponseWrapper<BoardDTO>>>createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<BoardDTO> dto) {
        ResponseWrapper<BoardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<BoardDTO>
    */   
    public BoardDTO createByProjectId
            (String projectId, BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        boardService.create(domain);
        Board rt = domain;
        return boardDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 看板
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"看板" },  notes = "Board-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Update-all') or hasPermission('project',#projectId,this.boardService.get(#id),'ibizplm-Board-Update')")
    @VersionCheck(entity = "board" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/boards/{id}")
    public Mono<ResponseEntity<ResponseWrapper<BoardDTO>>>updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BoardDTO> dto) {
        ResponseWrapper<BoardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 看板
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BoardDTO>
    */   
    public BoardDTO updateByProjectIdAndId
            (String projectId, String id, BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        domain.setId(id);
        boardService.update(domain);
        Board rt = domain;
        return boardDtoMapping.toDto(rt);
    }

    /**
    * check_board_is_deleted 看板
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "check_board_is_deleted", tags = {"看板" },  notes = "Board-check_board_is_deleted ")
    @PostMapping("projects/{projectId}/boards/{id}/check_board_is_deleted")
    public Mono<ResponseEntity<ResponseWrapper<BoardDTO>>>checkBoardIsDeletedByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<BoardDTO> dto) {
        ResponseWrapper<BoardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(checkBoardIsDeletedByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(checkBoardIsDeletedByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_board_is_deleted 看板
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<BoardDTO>
    */   
    public BoardDTO checkBoardIsDeletedByProjectIdAndId
            (String projectId, String id, BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        domain.setId(id);
        Board rt = boardService.checkBoardIsDeleted(domain);
        return boardDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"看板" },  notes = "Board-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Save-all') or hasPermission('project',#projectId,this.boardDtoMapping.toDomain(#dto),'ibizplm-Board-Save')")
    @PostMapping("projects/{projectId}/boards/save")
    public Mono<ResponseEntity<ResponseWrapper<BoardDTO>>>saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<BoardDTO> dto) {
        ResponseWrapper<BoardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<BoardDTO>
    */   
    public BoardDTO saveByProjectId
            (String projectId, BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        boardService.save(domain);
        Board rt = domain;
        return boardDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 看板
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"看板" },  notes = "Board-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Get-all')  or hasPermission(this.boardDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Board-Get')")
    @GetMapping("boards/{id}")
    public Mono<ResponseEntity<BoardDTO>> getById
            (@PathVariable("id") String id) {
        Board rt = boardService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(boardDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 看板
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"看板" },  notes = "Board-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Remove-all') or hasPermission(this.boardService.get(#id),'ibizplm-Board-Remove')")
    @DeleteMapping("boards/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = boardService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"看板" },  notes = "Board-CheckKey ")
    @PostMapping("boards/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        CheckKeyStatus rt = boardService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"看板" },  notes = "Board-GetDraft ")
    @GetMapping("boards/get_draft")
    public Mono<ResponseEntity<BoardDTO>> getDraft
            (@SpringQueryMap BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        Board rt = boardService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(boardDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_board_upload 看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<BoardDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_board_upload", tags = {"看板" },  notes = "Board-fetch_cur_board_upload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-fetch_cur_board_upload-all') or hasPermission(#dto,'ibizplm-Board-fetch_cur_board_upload')")
    @PostMapping("boards/fetch_cur_board_upload")
    public Mono<ResponseEntity<List<BoardDTO>>> fetchCurBoardUpload
            (@Validated @RequestBody BoardFilterDTO dto) {
        BoardSearchContext context = boardFilterDtoMapping.toDomain(dto);
        Page<Board> domains = boardService.fetchCurBoardUpload(context) ;
        List<BoardDTO> list = boardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_project_board 看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<BoardDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_project_board", tags = {"看板" },  notes = "Board-fetch_cur_project_board ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-fetch_cur_project_board-all') or hasPermission(#dto,'ibizplm-Board-fetch_cur_project_board')")
    @PostMapping("boards/fetch_cur_project_board")
    public Mono<ResponseEntity<List<BoardDTO>>> fetchCurProjectBoard
            (@Validated @RequestBody BoardFilterDTO dto) {
        BoardSearchContext context = boardFilterDtoMapping.toDomain(dto);
        Page<Board> domains = boardService.fetchCurProjectBoard(context) ;
        List<BoardDTO> list = boardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<BoardDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"看板" },  notes = "Board-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-fetch_default-all') or hasPermission(#dto,'ibizplm-Board-fetch_default')")
    @PostMapping("boards/fetch_default")
    public Mono<ResponseEntity<List<BoardDTO>>> fetchDefault
            (@Validated @RequestBody BoardFilterDTO dto) {
        BoardSearchContext context = boardFilterDtoMapping.toDomain(dto);
        Page<Board> domains = boardService.fetchDefault(context) ;
        List<BoardDTO> list = boardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<BoardDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"看板" },  notes = "Board-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-fetch_reader-all') or hasPermission(#dto,'ibizplm-Board-fetch_reader')")
    @PostMapping("boards/fetch_reader")
    public Mono<ResponseEntity<List<BoardDTO>>> fetchReader
            (@Validated @RequestBody BoardFilterDTO dto) {
        BoardSearchContext context = boardFilterDtoMapping.toDomain(dto);
        Page<Board> domains = boardService.fetchReader(context) ;
        List<BoardDTO> list = boardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 看板
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"看板" },  notes = "Board-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Get-all')  or hasPermission('project',#projectId,this.boardDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Board-Get')")
    @GetMapping("projects/{projectId}/boards/{id}")
    public Mono<ResponseEntity<BoardDTO>> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Board rt = boardService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(boardDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 看板
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"看板" },  notes = "Board-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-Remove-all') or hasPermission('project',#projectId,this.boardService.get(#id),'ibizplm-Board-Remove')")
    @DeleteMapping("projects/{projectId}/boards/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = boardService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"看板" },  notes = "Board-CheckKey ")
    @PostMapping("projects/{projectId}/boards/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        CheckKeyStatus rt = boardService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<BoardDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"看板" },  notes = "Board-GetDraft ")
    @GetMapping("projects/{projectId}/boards/get_draft")
    public Mono<ResponseEntity<BoardDTO>> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap BoardDTO dto) {
        Board domain = boardDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Board rt = boardService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(boardDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_board_upload 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BoardDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_board_upload", tags = {"看板" },  notes = "Board-fetch_cur_board_upload ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-fetch_cur_board_upload-all') or hasPermission('project',#projectId,#dto,'ibizplm-Board-fetch_cur_board_upload')")
    @PostMapping("projects/{projectId}/boards/fetch_cur_board_upload")
    public Mono<ResponseEntity<List<BoardDTO>>> fetchCurBoardUploadByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody BoardFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        BoardSearchContext context = boardFilterDtoMapping.toDomain(dto);
        Page<Board> domains = boardService.fetchCurBoardUpload(context) ;
        List<BoardDTO> list = boardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_project_board 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BoardDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_project_board", tags = {"看板" },  notes = "Board-fetch_cur_project_board ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-fetch_cur_project_board-all') or hasPermission('project',#projectId,#dto,'ibizplm-Board-fetch_cur_project_board')")
    @PostMapping("projects/{projectId}/boards/fetch_cur_project_board")
    public Mono<ResponseEntity<List<BoardDTO>>> fetchCurProjectBoardByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody BoardFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        BoardSearchContext context = boardFilterDtoMapping.toDomain(dto);
        Page<Board> domains = boardService.fetchCurProjectBoard(context) ;
        List<BoardDTO> list = boardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BoardDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"看板" },  notes = "Board-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Board-fetch_default')")
    @PostMapping("projects/{projectId}/boards/fetch_default")
    public Mono<ResponseEntity<List<BoardDTO>>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody BoardFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        BoardSearchContext context = boardFilterDtoMapping.toDomain(dto);
        Page<Board> domains = boardService.fetchDefault(context) ;
        List<BoardDTO> list = boardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 看板
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<BoardDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"看板" },  notes = "Board-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Board-fetch_reader-all') or hasPermission('project',#projectId,#dto,'ibizplm-Board-fetch_reader')")
    @PostMapping("projects/{projectId}/boards/fetch_reader")
    public Mono<ResponseEntity<List<BoardDTO>>> fetchReaderByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody BoardFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        BoardSearchContext context = boardFilterDtoMapping.toDomain(dto);
        Page<Board> domains = boardService.fetchReader(context) ;
        List<BoardDTO> list = boardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建看板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Board-Create-all')")
    @ApiOperation(value = "批量新建看板", tags = {"看板" },  notes = "批量新建看板")
	@PostMapping("boards/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<BoardDTO> dtos) {
        boardService.create(boardDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除看板
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Board-Remove-all')")
    @ApiOperation(value = "批量删除看板", tags = {"看板" },  notes = "批量删除看板")
	@DeleteMapping("boards/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        boardService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新看板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Board-Update-all')")
    @ApiOperation(value = "批量更新看板", tags = {"看板" },  notes = "批量更新看板")
	@PutMapping("boards/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<BoardDTO> dtos) {
        boardService.update(boardDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存看板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Board-Save-all')")
    @ApiOperation(value = "批量保存看板", tags = {"看板" },  notes = "批量保存看板")
	@PostMapping("boards/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<BoardDTO> dtos) {
        boardService.save(boardDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入看板
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Board-Save-all')")
    @ApiOperation(value = "批量导入看板", tags = {"看板" },  notes = "批量导入看板")
	@PostMapping("boards/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<BoardDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(boardService.importData(config,ignoreError,boardDtoMapping.toDomain(dtos))));
    }

}
