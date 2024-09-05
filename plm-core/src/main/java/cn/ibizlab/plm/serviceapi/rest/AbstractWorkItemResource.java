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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[WorkItem] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkItemResource {

    @Autowired
    public WorkItemService workItemService;

    @Autowired
    @Lazy
    public WorkItemAssigneeDTOMapping workItemAssigneeDtoMapping;

    @Autowired
    @Lazy
    public WorkItemBaselineChooseDTOMapping workItemBaselineChooseDtoMapping;

    @Autowired
    @Lazy
    public WorkItemBiSearchGroupDTOMapping workItemBiSearchGroupDtoMapping;

    @Autowired
    @Lazy
    public WorkItemChildDTOMapping workItemChildDtoMapping;

    @Autowired
    @Lazy
    public WorkItemCreatePlanSnapshotDTOMapping workItemCreatePlanSnapshotDtoMapping;

    @Autowired
    @Lazy
    public WorkItemDTOMapping workItemDtoMapping;

    @Autowired
    @Lazy
    public WorkItemFilterDTOMapping workItemFilterDtoMapping;

    @Autowired
    @Lazy
    public WorkItemResourceAssignmentDTOMapping workItemResourceAssignmentDtoMapping;

    @Autowired
    @Lazy
    public WorkItemUsuallyDTOMapping workItemUsuallyDtoMapping;

    @Autowired
    @Lazy
    public WorkItemWorkItemTypeIdDTOMapping workItemWorkItemTypeIdDtoMapping;

    /**
    * 创建Create 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项" },  notes = "WorkItem-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Create-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Create')")
    @PostMapping("work_items")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>create
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO create
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        workItemService.create(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工作项" },  notes = "WorkItem-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Update-all') or hasPermission(this.workItemService.get(#id),'ibizplm-WorkItem-Update')")
    @VersionCheck(entity = "workitem" , versionfield = "updateTime")
    @PutMapping("work_items/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO updateById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        workItemService.update(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * activate 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "activate", tags = {"工作项" },  notes = "WorkItem-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-activate-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-activate')")
    @PostMapping("work_items/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * activate 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO activateById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.activate(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * archive 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "archive", tags = {"工作项" },  notes = "WorkItem-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-archive-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-archive')")
    @PostMapping("work_items/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * archive 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO archiveById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.archive(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * board_move_position 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "board_move_position", tags = {"工作项" },  notes = "WorkItem-board_move_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-board_move_position-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-board_move_position')")
    @PostMapping("work_items/{id}/board_move_position")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkItemDTO>>>>boardMovePositionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<List<WorkItemDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(boardMovePositionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(boardMovePositionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * board_move_position 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */   
    public List<WorkItemDTO> boardMovePositionById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkItem> rt = workItemService.boardMovePosition(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_assignee 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_assignee", tags = {"工作项" },  notes = "WorkItem-change_assignee ")
    @PostMapping("work_items/{id}/change_assignee")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeAssigneeById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAssigneeById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAssigneeById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_assignee 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeAssigneeById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeAssignee(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_parent 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_parent", tags = {"工作项" },  notes = "WorkItem-change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-change_parent-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-change_parent')")
    @PostMapping("work_items/{id}/change_parent")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeParentById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeParentById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeParentById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_parent 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeParentById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeParent(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_state 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_state", tags = {"工作项" },  notes = "WorkItem-change_state ")
    @PostMapping("work_items/{id}/change_state")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeStateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_state 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeStateById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeState(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_time 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_time", tags = {"工作项" },  notes = "WorkItem-change_time ")
    @PostMapping("work_items/{id}/change_time")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeTimeById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeTimeById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeTimeById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_time 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeTimeById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeTime(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * child_del_relation 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "child_del_relation", tags = {"工作项" },  notes = "WorkItem-child_del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-child_del_relation-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-child_del_relation')")
    @PostMapping("work_items/{id}/child_del_relation")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>childDelRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(childDelRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(childDelRelationById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * child_del_relation 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO childDelRelationById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.childDelRelation(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * choose_child 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "choose_child", tags = {"工作项" },  notes = "WorkItem-choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-choose_child-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-choose_child')")
    @PutMapping("work_items/{id}/choose_child")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>chooseChildById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseChildById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseChildById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_child 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO chooseChildById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.chooseChild(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * copy 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "copy", tags = {"工作项" },  notes = "WorkItem-copy ")
    @PostMapping("work_items/{id}/copy")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>copyById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO copyById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.copy(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * create_plan_snapshot 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "create_plan_snapshot", tags = {"工作项" },  notes = "WorkItem-create_plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-create_plan_snapshot-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-create_plan_snapshot')")
    @PostMapping("work_items/create_plan_snapshot")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>createPlanSnapshot
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createPlanSnapshot(item)));
        else
            rt.set(createPlanSnapshot(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_plan_snapshot 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO createPlanSnapshot
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.createPlanSnapshot(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * delete 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "delete", tags = {"工作项" },  notes = "WorkItem-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-delete-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-delete')")
    @PostMapping("work_items/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO deleteById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.delete(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * fill_type_of_state 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fill_type_of_state", tags = {"工作项" },  notes = "WorkItem-fill_type_of_state ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fill_type_of_state-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fill_type_of_state')")
    @PostMapping("work_items/fill_type_of_state")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fillTypeOfState
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillTypeOfState(item)));
        else
            rt.set(fillTypeOfState(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_type_of_state 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fillTypeOfState
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.fillTypeOfState(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * fix_commit 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fix_commit", tags = {"工作项" },  notes = "WorkItem-fix_commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fix_commit-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fix_commit')")
    @PostMapping("work_items/{id}/fix_commit")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fixCommitById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fixCommitById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fixCommitById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fix_commit 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fixCommitById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.fixCommit(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * move_order 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"工作项" },  notes = "WorkItem-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-move_order-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-move_order')")
    @PostMapping("work_items/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkItemDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<List<WorkItemDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */   
    public List<WorkItemDTO> moveOrderById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkItem> rt = workItemService.moveOrder(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * move_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "move_work_item", tags = {"工作项" },  notes = "WorkItem-move_work_item ")
    @PostMapping("work_items/move_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>moveWorkItem
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(moveWorkItem(item)));
        else
            rt.set(moveWorkItem(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO moveWorkItem
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.moveWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * others_relation_work_item 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "others_relation_work_item", tags = {"工作项" },  notes = "WorkItem-others_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-others_relation_work_item-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-others_relation_work_item')")
    @PutMapping("work_items/{id}/others_relation_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>othersRelationWorkItemById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationWorkItemById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationWorkItemById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * others_relation_work_item 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO othersRelationWorkItemById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.othersRelationWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * plan_work_item 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "plan_work_item", tags = {"工作项" },  notes = "WorkItem-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-plan_work_item-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-plan_work_item')")
    @PutMapping("work_items/{id}/plan_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>planWorkItemById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_work_item 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO planWorkItemById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.planWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * project_resource_setting 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "project_resource_setting", tags = {"工作项" },  notes = "WorkItem-project_resource_setting ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-project_resource_setting-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-project_resource_setting')")
    @PostMapping("work_items/project_resource_setting")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>projectResourceSetting
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(projectResourceSetting(item)));
        else
            rt.set(projectResourceSetting(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * project_resource_setting 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO projectResourceSetting
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.projectResourceSetting(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * recover 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "recover", tags = {"工作项" },  notes = "WorkItem-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-recover-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-recover')")
    @PostMapping("work_items/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO recoverById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.recover(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * resource_member_setting 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "resource_member_setting", tags = {"工作项" },  notes = "WorkItem-resource_member_setting ")
    @PostMapping("work_items/resource_member_setting")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>resourceMemberSetting
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(resourceMemberSetting(item)));
        else
            rt.set(resourceMemberSetting(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * resource_member_setting 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO resourceMemberSetting
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.resourceMemberSetting(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * restore_version 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "restore_version", tags = {"工作项" },  notes = "WorkItem-restore_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-restore_version-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-restore_version')")
    @PostMapping("work_items/{id}/restore_version")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>restoreVersionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreVersionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreVersionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * restore_version 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO restoreVersionById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.restoreVersion(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项" },  notes = "WorkItem-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Save-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Save')")
    @PostMapping("work_items/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>save
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO save
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        workItemService.save(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * set_default_entry 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "set_default_entry", tags = {"工作项" },  notes = "WorkItem-set_default_entry ")
    @PostMapping("work_items/set_default_entry")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>setDefaultEntry
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setDefaultEntry(item)));
        else
            rt.set(setDefaultEntry(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_default_entry 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO setDefaultEntry
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.setDefaultEntry(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * set_type_bug 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "set_type_bug", tags = {"工作项" },  notes = "WorkItem-set_type_bug ")
    @PostMapping("work_items/set_type_bug")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>setTypeBug
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setTypeBug(item)));
        else
            rt.set(setTypeBug(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_type_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO setTypeBug
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.setTypeBug(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_kanban 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_kanban", tags = {"工作项" },  notes = "WorkItem-shift_in_kanban ")
    @PostMapping("work_items/{id}/shift_in_kanban")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInKanbanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInKanbanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInKanbanById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_kanban 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInKanbanById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInKanban(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_release 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_release", tags = {"工作项" },  notes = "WorkItem-shift_in_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_release-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_release')")
    @PostMapping("work_items/{id}/shift_in_release")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInReleaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInReleaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInReleaseById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_release 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInReleaseById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInRelease(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_sprint 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_sprint", tags = {"工作项" },  notes = "WorkItem-shift_in_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_sprint-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_sprint')")
    @PostMapping("work_items/{id}/shift_in_sprint")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInSprintById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInSprintById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInSprintById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_sprint 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInSprintById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInSprint(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_release 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_out_release", tags = {"工作项" },  notes = "WorkItem-shift_out_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_out_release-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_out_release')")
    @PostMapping("work_items/{id}/shift_out_release")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftOutReleaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftOutReleaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftOutReleaseById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_release 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftOutReleaseById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftOutRelease(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_sprint 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_out_sprint", tags = {"工作项" },  notes = "WorkItem-shift_out_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_out_sprint-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_out_sprint')")
    @PostMapping("work_items/{id}/shift_out_sprint")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftOutSprintById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftOutSprintById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftOutSprintById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_sprint 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftOutSprintById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftOutSprint(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_re_counters 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_re_counters", tags = {"工作项" },  notes = "WorkItem-work_item_re_counters ")
    @PostMapping("work_items/{id}/work_item_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReCountersById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_re_counters 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemReCountersById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemReCounters(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_readonly_recognize 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_readonly_recognize", tags = {"工作项" },  notes = "WorkItem-work_item_readonly_recognize ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_readonly_recognize-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_readonly_recognize')")
    @PostMapping("work_items/{id}/work_item_readonly_recognize")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemReadonlyRecognizeById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReadonlyRecognizeById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReadonlyRecognizeById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_readonly_recognize 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemReadonlyRecognizeById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemReadonlyRecognize(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_test_plan_project 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_test_plan_project", tags = {"工作项" },  notes = "WorkItem-work_item_test_plan_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_test_plan_project-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_test_plan_project')")
    @PostMapping("work_items/{id}/work_item_test_plan_project")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemTestPlanProjectById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemTestPlanProjectById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemTestPlanProjectById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_test_plan_project 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemTestPlanProjectById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemTestPlanProject(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项" },  notes = "WorkItem-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Create-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Create')")
    @PostMapping("projects/{projectId}/work_items")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO createByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        workItemService.create(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工作项" },  notes = "WorkItem-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Update-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Update')")
    @VersionCheck(entity = "workitem" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/work_items/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO updateByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        workItemService.update(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * activate 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "activate", tags = {"工作项" },  notes = "WorkItem-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-activate-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-activate')")
    @PostMapping("projects/{projectId}/work_items/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>activateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * activate 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO activateByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.activate(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * archive 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "archive", tags = {"工作项" },  notes = "WorkItem-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-archive-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-archive')")
    @PostMapping("projects/{projectId}/work_items/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>archiveByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * archive 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO archiveByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.archive(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * board_move_position 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "board_move_position", tags = {"工作项" },  notes = "WorkItem-board_move_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-board_move_position-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-board_move_position')")
    @PostMapping("projects/{projectId}/work_items/{id}/board_move_position")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkItemDTO>>>>boardMovePositionByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<List<WorkItemDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(boardMovePositionByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(boardMovePositionByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * board_move_position 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */   
    public List<WorkItemDTO> boardMovePositionByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkItem> rt = workItemService.boardMovePosition(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_assignee", tags = {"工作项" },  notes = "WorkItem-change_assignee ")
    @PostMapping("projects/{projectId}/work_items/{id}/change_assignee")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeAssigneeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAssigneeByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAssigneeByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeAssigneeByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeAssignee(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_parent", tags = {"工作项" },  notes = "WorkItem-change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-change_parent-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-change_parent')")
    @PostMapping("projects/{projectId}/work_items/{id}/change_parent")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeParentByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeParentByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeParentByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeParentByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeParent(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_state 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_state", tags = {"工作项" },  notes = "WorkItem-change_state ")
    @PostMapping("projects/{projectId}/work_items/{id}/change_state")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeStateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_state 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeStateByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeState(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_time 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_time", tags = {"工作项" },  notes = "WorkItem-change_time ")
    @PostMapping("projects/{projectId}/work_items/{id}/change_time")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeTimeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeTimeByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeTimeByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_time 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeTimeByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeTime(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * child_del_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "child_del_relation", tags = {"工作项" },  notes = "WorkItem-child_del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-child_del_relation-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-child_del_relation')")
    @PostMapping("projects/{projectId}/work_items/{id}/child_del_relation")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>childDelRelationByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(childDelRelationByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(childDelRelationByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * child_del_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO childDelRelationByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.childDelRelation(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * choose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "choose_child", tags = {"工作项" },  notes = "WorkItem-choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-choose_child-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-choose_child')")
    @PutMapping("projects/{projectId}/work_items/{id}/choose_child")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>chooseChildByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseChildByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseChildByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO chooseChildByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.chooseChild(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * copy 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "copy", tags = {"工作项" },  notes = "WorkItem-copy ")
    @PostMapping("projects/{projectId}/work_items/{id}/copy")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>copyByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO copyByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.copy(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * create_plan_snapshot 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "create_plan_snapshot", tags = {"工作项" },  notes = "WorkItem-create_plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-create_plan_snapshot-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-create_plan_snapshot')")
    @PostMapping("projects/{projectId}/work_items/create_plan_snapshot")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>createPlanSnapshotByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createPlanSnapshotByProjectId(projectId, item)));
        else
            rt.set(createPlanSnapshotByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_plan_snapshot 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO createPlanSnapshotByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.createPlanSnapshot(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * delete 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "delete", tags = {"工作项" },  notes = "WorkItem-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-delete-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-delete')")
    @PostMapping("projects/{projectId}/work_items/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>deleteByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO deleteByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.delete(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * fill_type_of_state 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fill_type_of_state", tags = {"工作项" },  notes = "WorkItem-fill_type_of_state ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fill_type_of_state-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fill_type_of_state')")
    @PostMapping("projects/{projectId}/work_items/fill_type_of_state")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fillTypeOfStateByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillTypeOfStateByProjectId(projectId, item)));
        else
            rt.set(fillTypeOfStateByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_type_of_state 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fillTypeOfStateByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.fillTypeOfState(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * fix_commit 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fix_commit", tags = {"工作项" },  notes = "WorkItem-fix_commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fix_commit-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fix_commit')")
    @PostMapping("projects/{projectId}/work_items/{id}/fix_commit")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fixCommitByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fixCommitByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fixCommitByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fix_commit 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fixCommitByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.fixCommit(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * move_order 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"工作项" },  notes = "WorkItem-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-move_order-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-move_order')")
    @PostMapping("projects/{projectId}/work_items/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkItemDTO>>>>moveOrderByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<List<WorkItemDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */   
    public List<WorkItemDTO> moveOrderByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkItem> rt = workItemService.moveOrder(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * move_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "move_work_item", tags = {"工作项" },  notes = "WorkItem-move_work_item ")
    @PostMapping("projects/{projectId}/work_items/move_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>moveWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(moveWorkItemByProjectId(projectId, item)));
        else
            rt.set(moveWorkItemByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO moveWorkItemByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.moveWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * others_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "others_relation_work_item", tags = {"工作项" },  notes = "WorkItem-others_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-others_relation_work_item-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-others_relation_work_item')")
    @PutMapping("projects/{projectId}/work_items/{id}/others_relation_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>othersRelationWorkItemByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationWorkItemByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationWorkItemByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * others_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO othersRelationWorkItemByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.othersRelationWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * plan_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "plan_work_item", tags = {"工作项" },  notes = "WorkItem-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-plan_work_item-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-plan_work_item')")
    @PutMapping("projects/{projectId}/work_items/{id}/plan_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>planWorkItemByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO planWorkItemByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.planWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * project_resource_setting 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "project_resource_setting", tags = {"工作项" },  notes = "WorkItem-project_resource_setting ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-project_resource_setting-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-project_resource_setting')")
    @PostMapping("projects/{projectId}/work_items/project_resource_setting")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>projectResourceSettingByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(projectResourceSettingByProjectId(projectId, item)));
        else
            rt.set(projectResourceSettingByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * project_resource_setting 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO projectResourceSettingByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.projectResourceSetting(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * recover 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "recover", tags = {"工作项" },  notes = "WorkItem-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-recover-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-recover')")
    @PostMapping("projects/{projectId}/work_items/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>recoverByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO recoverByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.recover(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * resource_member_setting 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "resource_member_setting", tags = {"工作项" },  notes = "WorkItem-resource_member_setting ")
    @PostMapping("projects/{projectId}/work_items/resource_member_setting")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>resourceMemberSettingByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(resourceMemberSettingByProjectId(projectId, item)));
        else
            rt.set(resourceMemberSettingByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * resource_member_setting 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO resourceMemberSettingByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.resourceMemberSetting(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * restore_version 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "restore_version", tags = {"工作项" },  notes = "WorkItem-restore_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-restore_version-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-restore_version')")
    @PostMapping("projects/{projectId}/work_items/{id}/restore_version")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>restoreVersionByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreVersionByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreVersionByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * restore_version 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO restoreVersionByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.restoreVersion(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项" },  notes = "WorkItem-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Save-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Save')")
    @PostMapping("projects/{projectId}/work_items/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO saveByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        workItemService.save(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * set_default_entry 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "set_default_entry", tags = {"工作项" },  notes = "WorkItem-set_default_entry ")
    @PostMapping("projects/{projectId}/work_items/set_default_entry")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>setDefaultEntryByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setDefaultEntryByProjectId(projectId, item)));
        else
            rt.set(setDefaultEntryByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_default_entry 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO setDefaultEntryByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.setDefaultEntry(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * set_type_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "set_type_bug", tags = {"工作项" },  notes = "WorkItem-set_type_bug ")
    @PostMapping("projects/{projectId}/work_items/set_type_bug")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>setTypeBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setTypeBugByProjectId(projectId, item)));
        else
            rt.set(setTypeBugByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_type_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO setTypeBugByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.setTypeBug(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_kanban 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_kanban", tags = {"工作项" },  notes = "WorkItem-shift_in_kanban ")
    @PostMapping("projects/{projectId}/work_items/{id}/shift_in_kanban")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInKanbanByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInKanbanByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInKanbanByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_kanban 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInKanbanByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInKanban(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_release 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_release", tags = {"工作项" },  notes = "WorkItem-shift_in_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_release-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_release')")
    @PostMapping("projects/{projectId}/work_items/{id}/shift_in_release")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInReleaseByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInReleaseByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInReleaseByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_release 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInReleaseByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInRelease(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_sprint", tags = {"工作项" },  notes = "WorkItem-shift_in_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_sprint-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_sprint')")
    @PostMapping("projects/{projectId}/work_items/{id}/shift_in_sprint")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInSprintByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInSprintByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInSprintByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInSprintByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInSprint(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_release 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_out_release", tags = {"工作项" },  notes = "WorkItem-shift_out_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_out_release-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_out_release')")
    @PostMapping("projects/{projectId}/work_items/{id}/shift_out_release")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftOutReleaseByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftOutReleaseByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftOutReleaseByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_release 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftOutReleaseByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftOutRelease(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_out_sprint", tags = {"工作项" },  notes = "WorkItem-shift_out_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_out_sprint-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_out_sprint')")
    @PostMapping("projects/{projectId}/work_items/{id}/shift_out_sprint")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftOutSprintByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftOutSprintByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftOutSprintByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftOutSprintByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftOutSprint(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_re_counters 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_re_counters", tags = {"工作项" },  notes = "WorkItem-work_item_re_counters ")
    @PostMapping("projects/{projectId}/work_items/{id}/work_item_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemReCountersByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReCountersByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReCountersByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_re_counters 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemReCountersByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemReCounters(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_readonly_recognize 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_readonly_recognize", tags = {"工作项" },  notes = "WorkItem-work_item_readonly_recognize ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_readonly_recognize-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_readonly_recognize')")
    @PostMapping("projects/{projectId}/work_items/{id}/work_item_readonly_recognize")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemReadonlyRecognizeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReadonlyRecognizeByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReadonlyRecognizeByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_readonly_recognize 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemReadonlyRecognizeByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemReadonlyRecognize(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_test_plan_project 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_test_plan_project", tags = {"工作项" },  notes = "WorkItem-work_item_test_plan_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_test_plan_project-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_test_plan_project')")
    @PostMapping("projects/{projectId}/work_items/{id}/work_item_test_plan_project")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemTestPlanProjectByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemTestPlanProjectByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemTestPlanProjectByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_test_plan_project 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemTestPlanProjectByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemTestPlanProject(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项" },  notes = "WorkItem-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Create-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Create')")
    @PostMapping("releases/{releaseId}/work_items")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>createByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByReleaseId(releaseId, item)));
        else
            rt.set(createByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO createByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        workItemService.create(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工作项" },  notes = "WorkItem-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Update-all') or hasPermission('release',#releaseId,this.workItemService.get(#id),'ibizplm-WorkItem-Update')")
    @VersionCheck(entity = "workitem" , versionfield = "updateTime")
    @PutMapping("releases/{releaseId}/work_items/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>updateByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO updateByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        workItemService.update(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * activate 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "activate", tags = {"工作项" },  notes = "WorkItem-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-activate-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-activate')")
    @PostMapping("releases/{releaseId}/work_items/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>activateByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * activate 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO activateByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.activate(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * archive 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "archive", tags = {"工作项" },  notes = "WorkItem-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-archive-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-archive')")
    @PostMapping("releases/{releaseId}/work_items/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>archiveByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * archive 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO archiveByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.archive(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * board_move_position 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "board_move_position", tags = {"工作项" },  notes = "WorkItem-board_move_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-board_move_position-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-board_move_position')")
    @PostMapping("releases/{releaseId}/work_items/{id}/board_move_position")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkItemDTO>>>>boardMovePositionByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<List<WorkItemDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(boardMovePositionByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(boardMovePositionByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * board_move_position 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */   
    public List<WorkItemDTO> boardMovePositionByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkItem> rt = workItemService.boardMovePosition(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_assignee 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_assignee", tags = {"工作项" },  notes = "WorkItem-change_assignee ")
    @PostMapping("releases/{releaseId}/work_items/{id}/change_assignee")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeAssigneeByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAssigneeByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAssigneeByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_assignee 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeAssigneeByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeAssignee(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_parent 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_parent", tags = {"工作项" },  notes = "WorkItem-change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-change_parent-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-change_parent')")
    @PostMapping("releases/{releaseId}/work_items/{id}/change_parent")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeParentByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeParentByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeParentByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_parent 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeParentByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeParent(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_state 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_state", tags = {"工作项" },  notes = "WorkItem-change_state ")
    @PostMapping("releases/{releaseId}/work_items/{id}/change_state")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeStateByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_state 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeStateByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeState(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_time 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_time", tags = {"工作项" },  notes = "WorkItem-change_time ")
    @PostMapping("releases/{releaseId}/work_items/{id}/change_time")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeTimeByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeTimeByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeTimeByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_time 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeTimeByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeTime(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * child_del_relation 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "child_del_relation", tags = {"工作项" },  notes = "WorkItem-child_del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-child_del_relation-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-child_del_relation')")
    @PostMapping("releases/{releaseId}/work_items/{id}/child_del_relation")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>childDelRelationByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(childDelRelationByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(childDelRelationByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * child_del_relation 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO childDelRelationByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.childDelRelation(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * choose_child 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "choose_child", tags = {"工作项" },  notes = "WorkItem-choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-choose_child-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-choose_child')")
    @PutMapping("releases/{releaseId}/work_items/{id}/choose_child")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>chooseChildByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseChildByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseChildByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_child 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO chooseChildByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.chooseChild(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * copy 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "copy", tags = {"工作项" },  notes = "WorkItem-copy ")
    @PostMapping("releases/{releaseId}/work_items/{id}/copy")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>copyByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO copyByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.copy(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * create_plan_snapshot 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "create_plan_snapshot", tags = {"工作项" },  notes = "WorkItem-create_plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-create_plan_snapshot-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-create_plan_snapshot')")
    @PostMapping("releases/{releaseId}/work_items/create_plan_snapshot")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>createPlanSnapshotByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createPlanSnapshotByReleaseId(releaseId, item)));
        else
            rt.set(createPlanSnapshotByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_plan_snapshot 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO createPlanSnapshotByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.createPlanSnapshot(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * delete 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "delete", tags = {"工作项" },  notes = "WorkItem-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-delete-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-delete')")
    @PostMapping("releases/{releaseId}/work_items/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>deleteByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO deleteByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.delete(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * fill_type_of_state 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fill_type_of_state", tags = {"工作项" },  notes = "WorkItem-fill_type_of_state ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fill_type_of_state-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fill_type_of_state')")
    @PostMapping("releases/{releaseId}/work_items/fill_type_of_state")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fillTypeOfStateByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillTypeOfStateByReleaseId(releaseId, item)));
        else
            rt.set(fillTypeOfStateByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_type_of_state 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fillTypeOfStateByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.fillTypeOfState(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * fix_commit 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fix_commit", tags = {"工作项" },  notes = "WorkItem-fix_commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fix_commit-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fix_commit')")
    @PostMapping("releases/{releaseId}/work_items/{id}/fix_commit")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fixCommitByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fixCommitByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fixCommitByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fix_commit 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fixCommitByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.fixCommit(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * move_order 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"工作项" },  notes = "WorkItem-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-move_order-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-move_order')")
    @PostMapping("releases/{releaseId}/work_items/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkItemDTO>>>>moveOrderByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<List<WorkItemDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */   
    public List<WorkItemDTO> moveOrderByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkItem> rt = workItemService.moveOrder(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * move_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "move_work_item", tags = {"工作项" },  notes = "WorkItem-move_work_item ")
    @PostMapping("releases/{releaseId}/work_items/move_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>moveWorkItemByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(moveWorkItemByReleaseId(releaseId, item)));
        else
            rt.set(moveWorkItemByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO moveWorkItemByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.moveWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * others_relation_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "others_relation_work_item", tags = {"工作项" },  notes = "WorkItem-others_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-others_relation_work_item-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-others_relation_work_item')")
    @PutMapping("releases/{releaseId}/work_items/{id}/others_relation_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>othersRelationWorkItemByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationWorkItemByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationWorkItemByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * others_relation_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO othersRelationWorkItemByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.othersRelationWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * plan_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "plan_work_item", tags = {"工作项" },  notes = "WorkItem-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-plan_work_item-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-plan_work_item')")
    @PutMapping("releases/{releaseId}/work_items/{id}/plan_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>planWorkItemByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO planWorkItemByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.planWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * project_resource_setting 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "project_resource_setting", tags = {"工作项" },  notes = "WorkItem-project_resource_setting ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-project_resource_setting-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-project_resource_setting')")
    @PostMapping("releases/{releaseId}/work_items/project_resource_setting")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>projectResourceSettingByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(projectResourceSettingByReleaseId(releaseId, item)));
        else
            rt.set(projectResourceSettingByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * project_resource_setting 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO projectResourceSettingByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.projectResourceSetting(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * recover 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "recover", tags = {"工作项" },  notes = "WorkItem-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-recover-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-recover')")
    @PostMapping("releases/{releaseId}/work_items/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>recoverByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO recoverByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.recover(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * resource_member_setting 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "resource_member_setting", tags = {"工作项" },  notes = "WorkItem-resource_member_setting ")
    @PostMapping("releases/{releaseId}/work_items/resource_member_setting")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>resourceMemberSettingByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(resourceMemberSettingByReleaseId(releaseId, item)));
        else
            rt.set(resourceMemberSettingByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * resource_member_setting 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO resourceMemberSettingByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.resourceMemberSetting(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * restore_version 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "restore_version", tags = {"工作项" },  notes = "WorkItem-restore_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-restore_version-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-restore_version')")
    @PostMapping("releases/{releaseId}/work_items/{id}/restore_version")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>restoreVersionByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreVersionByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreVersionByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * restore_version 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO restoreVersionByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.restoreVersion(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项" },  notes = "WorkItem-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Save-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Save')")
    @PostMapping("releases/{releaseId}/work_items/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>saveByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByReleaseId(releaseId, item)));
        else
            rt.set(saveByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO saveByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        workItemService.save(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * set_default_entry 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "set_default_entry", tags = {"工作项" },  notes = "WorkItem-set_default_entry ")
    @PostMapping("releases/{releaseId}/work_items/set_default_entry")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>setDefaultEntryByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setDefaultEntryByReleaseId(releaseId, item)));
        else
            rt.set(setDefaultEntryByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_default_entry 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO setDefaultEntryByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.setDefaultEntry(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * set_type_bug 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "set_type_bug", tags = {"工作项" },  notes = "WorkItem-set_type_bug ")
    @PostMapping("releases/{releaseId}/work_items/set_type_bug")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>setTypeBugByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setTypeBugByReleaseId(releaseId, item)));
        else
            rt.set(setTypeBugByReleaseId(releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_type_bug 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO setTypeBugByReleaseId
            (String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.setTypeBug(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_kanban 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_kanban", tags = {"工作项" },  notes = "WorkItem-shift_in_kanban ")
    @PostMapping("releases/{releaseId}/work_items/{id}/shift_in_kanban")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInKanbanByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInKanbanByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInKanbanByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_kanban 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInKanbanByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInKanban(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_release 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_release", tags = {"工作项" },  notes = "WorkItem-shift_in_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_release-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_release')")
    @PostMapping("releases/{releaseId}/work_items/{id}/shift_in_release")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInReleaseByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInReleaseByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInReleaseByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_release 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInReleaseByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInRelease(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_sprint 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_sprint", tags = {"工作项" },  notes = "WorkItem-shift_in_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_sprint-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_sprint')")
    @PostMapping("releases/{releaseId}/work_items/{id}/shift_in_sprint")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInSprintByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInSprintByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInSprintByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_sprint 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInSprintByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInSprint(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_release 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_out_release", tags = {"工作项" },  notes = "WorkItem-shift_out_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_out_release-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_out_release')")
    @PostMapping("releases/{releaseId}/work_items/{id}/shift_out_release")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftOutReleaseByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftOutReleaseByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftOutReleaseByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_release 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftOutReleaseByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftOutRelease(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_sprint 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_out_sprint", tags = {"工作项" },  notes = "WorkItem-shift_out_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_out_sprint-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_out_sprint')")
    @PostMapping("releases/{releaseId}/work_items/{id}/shift_out_sprint")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftOutSprintByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftOutSprintByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftOutSprintByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_sprint 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftOutSprintByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftOutSprint(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_re_counters 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_re_counters", tags = {"工作项" },  notes = "WorkItem-work_item_re_counters ")
    @PostMapping("releases/{releaseId}/work_items/{id}/work_item_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemReCountersByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReCountersByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReCountersByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_re_counters 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemReCountersByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemReCounters(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_readonly_recognize 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_readonly_recognize", tags = {"工作项" },  notes = "WorkItem-work_item_readonly_recognize ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_readonly_recognize-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_readonly_recognize')")
    @PostMapping("releases/{releaseId}/work_items/{id}/work_item_readonly_recognize")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemReadonlyRecognizeByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReadonlyRecognizeByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReadonlyRecognizeByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_readonly_recognize 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemReadonlyRecognizeByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemReadonlyRecognize(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_test_plan_project 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_test_plan_project", tags = {"工作项" },  notes = "WorkItem-work_item_test_plan_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_test_plan_project-all') or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_test_plan_project')")
    @PostMapping("releases/{releaseId}/work_items/{id}/work_item_test_plan_project")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemTestPlanProjectByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemTestPlanProjectByReleaseIdAndId(releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemTestPlanProjectByReleaseIdAndId(releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_test_plan_project 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemTestPlanProjectByReleaseIdAndId
            (String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemTestPlanProject(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项" },  notes = "WorkItem-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Create-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Create')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>createByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(createByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO createByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        workItemService.create(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"工作项" },  notes = "WorkItem-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Update-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Update')")
    @VersionCheck(entity = "workitem" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>updateByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO updateByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        workItemService.update(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * activate 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "activate", tags = {"工作项" },  notes = "WorkItem-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-activate-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-activate')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>activateByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * activate 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO activateByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.activate(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * archive 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "archive", tags = {"工作项" },  notes = "WorkItem-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-archive-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-archive')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>archiveByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * archive 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO archiveByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.archive(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * board_move_position 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "board_move_position", tags = {"工作项" },  notes = "WorkItem-board_move_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-board_move_position-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-board_move_position')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/board_move_position")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkItemDTO>>>>boardMovePositionByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<List<WorkItemDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(boardMovePositionByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(boardMovePositionByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * board_move_position 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */   
    public List<WorkItemDTO> boardMovePositionByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkItem> rt = workItemService.boardMovePosition(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_assignee", tags = {"工作项" },  notes = "WorkItem-change_assignee ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/change_assignee")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeAssigneeByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAssigneeByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAssigneeByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeAssigneeByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeAssignee(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_parent", tags = {"工作项" },  notes = "WorkItem-change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-change_parent-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-change_parent')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/change_parent")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeParentByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeParentByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeParentByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeParentByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeParent(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_state 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_state", tags = {"工作项" },  notes = "WorkItem-change_state ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/change_state")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeStateByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_state 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeStateByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeState(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * change_time 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "change_time", tags = {"工作项" },  notes = "WorkItem-change_time ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/change_time")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>changeTimeByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeTimeByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeTimeByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_time 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO changeTimeByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.changeTime(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * child_del_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "child_del_relation", tags = {"工作项" },  notes = "WorkItem-child_del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-child_del_relation-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-child_del_relation')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/child_del_relation")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>childDelRelationByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(childDelRelationByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(childDelRelationByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * child_del_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO childDelRelationByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.childDelRelation(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * choose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "choose_child", tags = {"工作项" },  notes = "WorkItem-choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-choose_child-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-choose_child')")
    @PutMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/choose_child")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>chooseChildByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseChildByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseChildByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO chooseChildByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.chooseChild(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * copy 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "copy", tags = {"工作项" },  notes = "WorkItem-copy ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/copy")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>copyByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO copyByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.copy(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * create_plan_snapshot 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "create_plan_snapshot", tags = {"工作项" },  notes = "WorkItem-create_plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-create_plan_snapshot-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-create_plan_snapshot')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/create_plan_snapshot")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>createPlanSnapshotByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createPlanSnapshotByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(createPlanSnapshotByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_plan_snapshot 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO createPlanSnapshotByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.createPlanSnapshot(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * delete 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "delete", tags = {"工作项" },  notes = "WorkItem-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-delete-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-delete')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>deleteByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO deleteByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.delete(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * fill_type_of_state 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fill_type_of_state", tags = {"工作项" },  notes = "WorkItem-fill_type_of_state ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fill_type_of_state-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fill_type_of_state')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fill_type_of_state")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fillTypeOfStateByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillTypeOfStateByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(fillTypeOfStateByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_type_of_state 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fillTypeOfStateByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.fillTypeOfState(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * fix_commit 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fix_commit", tags = {"工作项" },  notes = "WorkItem-fix_commit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fix_commit-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fix_commit')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/fix_commit")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fixCommitByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fixCommitByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fixCommitByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fix_commit 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fixCommitByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.fixCommit(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * move_order 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"工作项" },  notes = "WorkItem-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-move_order-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-move_order')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<WorkItemDTO>>>>moveOrderByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<List<WorkItemDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */   
    public List<WorkItemDTO> moveOrderByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        List<WorkItem> rt = workItemService.moveOrder(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * move_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "move_work_item", tags = {"工作项" },  notes = "WorkItem-move_work_item ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/move_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>moveWorkItemByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(moveWorkItemByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(moveWorkItemByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO moveWorkItemByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.moveWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * others_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "others_relation_work_item", tags = {"工作项" },  notes = "WorkItem-others_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-others_relation_work_item-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-others_relation_work_item')")
    @PutMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/others_relation_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>othersRelationWorkItemByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationWorkItemByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationWorkItemByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * others_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO othersRelationWorkItemByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.othersRelationWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * plan_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "plan_work_item", tags = {"工作项" },  notes = "WorkItem-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-plan_work_item-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-plan_work_item')")
    @PutMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/plan_work_item")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>planWorkItemByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO planWorkItemByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.planWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * project_resource_setting 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "project_resource_setting", tags = {"工作项" },  notes = "WorkItem-project_resource_setting ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-project_resource_setting-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-project_resource_setting')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/project_resource_setting")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>projectResourceSettingByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(projectResourceSettingByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(projectResourceSettingByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * project_resource_setting 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO projectResourceSettingByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.projectResourceSetting(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * recover 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "recover", tags = {"工作项" },  notes = "WorkItem-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-recover-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-recover')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>recoverByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO recoverByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.recover(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * resource_member_setting 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "resource_member_setting", tags = {"工作项" },  notes = "WorkItem-resource_member_setting ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/resource_member_setting")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>resourceMemberSettingByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(resourceMemberSettingByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(resourceMemberSettingByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * resource_member_setting 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO resourceMemberSettingByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.resourceMemberSetting(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * restore_version 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "restore_version", tags = {"工作项" },  notes = "WorkItem-restore_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-restore_version-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-restore_version')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/restore_version")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>restoreVersionByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreVersionByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreVersionByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * restore_version 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO restoreVersionByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.restoreVersion(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项" },  notes = "WorkItem-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Save-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Save')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/save")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>saveByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(saveByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO saveByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        workItemService.save(domain);
        WorkItem rt = domain;
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * set_default_entry 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "set_default_entry", tags = {"工作项" },  notes = "WorkItem-set_default_entry ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/set_default_entry")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>setDefaultEntryByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setDefaultEntryByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(setDefaultEntryByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_default_entry 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO setDefaultEntryByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.setDefaultEntry(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * set_type_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "set_type_bug", tags = {"工作项" },  notes = "WorkItem-set_type_bug ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/set_type_bug")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>setTypeBugByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setTypeBugByProjectIdAndReleaseId(projectId, releaseId, item)));
        else
            rt.set(setTypeBugByProjectIdAndReleaseId(projectId, releaseId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_type_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO setTypeBugByProjectIdAndReleaseId
            (String projectId, String releaseId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.setTypeBug(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_kanban 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_kanban", tags = {"工作项" },  notes = "WorkItem-shift_in_kanban ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/shift_in_kanban")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInKanbanByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInKanbanByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInKanbanByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_kanban 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInKanbanByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInKanban(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_release 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_release", tags = {"工作项" },  notes = "WorkItem-shift_in_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_release-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_release')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/shift_in_release")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInReleaseByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInReleaseByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInReleaseByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_release 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInReleaseByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInRelease(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_in_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_in_sprint", tags = {"工作项" },  notes = "WorkItem-shift_in_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_sprint-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_sprint')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/shift_in_sprint")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftInSprintByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInSprintByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInSprintByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_in_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInSprintByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInSprint(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_release 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_out_release", tags = {"工作项" },  notes = "WorkItem-shift_out_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_out_release-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_out_release')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/shift_out_release")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftOutReleaseByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftOutReleaseByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftOutReleaseByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_release 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftOutReleaseByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftOutRelease(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * shift_out_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "shift_out_sprint", tags = {"工作项" },  notes = "WorkItem-shift_out_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_out_sprint-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_out_sprint')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/shift_out_sprint")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>shiftOutSprintByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftOutSprintByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftOutSprintByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shift_out_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftOutSprintByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftOutSprint(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_re_counters 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_re_counters", tags = {"工作项" },  notes = "WorkItem-work_item_re_counters ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/work_item_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemReCountersByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReCountersByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReCountersByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_re_counters 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemReCountersByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemReCounters(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_readonly_recognize 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_readonly_recognize", tags = {"工作项" },  notes = "WorkItem-work_item_readonly_recognize ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_readonly_recognize-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_readonly_recognize')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/work_item_readonly_recognize")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemReadonlyRecognizeByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReadonlyRecognizeByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReadonlyRecognizeByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_readonly_recognize 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemReadonlyRecognizeByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemReadonlyRecognize(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * work_item_test_plan_project 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_test_plan_project", tags = {"工作项" },  notes = "WorkItem-work_item_test_plan_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_test_plan_project-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_test_plan_project')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/work_item_test_plan_project")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>workItemTestPlanProjectByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemTestPlanProjectByProjectIdAndReleaseIdAndId(projectId, releaseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemTestPlanProjectByProjectIdAndReleaseIdAndId(projectId, releaseId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * work_item_test_plan_project 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO workItemTestPlanProjectByProjectIdAndReleaseIdAndId
            (String projectId, String releaseId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.workItemTestPlanProject(domain);
        return workItemDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 工作项
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工作项" },  notes = "WorkItem-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get-all')  or hasPermission(this.workItemDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-WorkItem-Get')")
    @GetMapping("work_items/{id}")
    public Mono<ResponseEntity<WorkItemDTO>> getById
            (@PathVariable("id") String id) {
        WorkItem rt = workItemService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工作项
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作项" },  notes = "WorkItem-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Remove-all') or hasPermission(this.workItemService.get(#id),'ibizplm-WorkItem-Remove')")
    @DeleteMapping("work_items/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = workItemService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作项" },  notes = "WorkItem-CheckKey ")
    @PostMapping("work_items/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        CheckKeyStatus rt = workItemService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 工作项
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"工作项" },  notes = "WorkItem-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_attention-all') or hasPermission(this.workItemService.get(#id),'ibizplm-WorkItem-get_attention')")
    @GetMapping("work_items/{id}/get_attention")
    public Mono<ResponseEntity<WorkItemDTO>> getAttentionById
            (@PathVariable("id") String id) {
        WorkItem rt = workItemService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * get_baseline_name 工作项
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "get_baseline_name", tags = {"工作项" },  notes = "WorkItem-get_baseline_name ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_baseline_name-all') or hasPermission(this.workItemService.get(#id),'ibizplm-WorkItem-get_baseline_name')")
    @GetMapping("work_items/{id}/get_baseline_name")
    public Mono<ResponseEntity<WorkItemDTO>> getBaselineNameById
            (@PathVariable("id") String id) {
        WorkItem rt = workItemService.getBaselineName(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项" },  notes = "WorkItem-GetDraft ")
    @GetMapping("work_items/get_draft")
    public Mono<ResponseEntity<WorkItemDTO>> getDraft
            (@SpringQueryMap WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * work_item_type_id 工作项
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_type_id", tags = {"工作项" },  notes = "WorkItem-work_item_type_id ")
    @GetMapping("work_items/{id}/work_item_type_id")
    public Mono<ResponseEntity<WorkItemDTO>> workItemTypeIdById
            (@PathVariable("id") String id) {
        WorkItem rt = workItemService.workItemTypeId(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_advanced_search 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工作项" },  notes = "WorkItem-fetch_advanced_search ")
    @PostMapping("work_items/fetch_advanced_search")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchAdvancedSearch
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchAdvancedSearch(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工作项" },  notes = "WorkItem-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_archived-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_archived')")
    @PostMapping("work_items/fetch_archived")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchArchived
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchArchived(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_backlog_property_distribution 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_backlog_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_property_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_backlog_property_distribution')")
    @PostMapping("work_items/fetch_backlog_property_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchBacklogPropertyDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBacklogPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_backlog_state_distribution 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_backlog_state_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_state_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_state_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_backlog_state_distribution')")
    @PostMapping("work_items/fetch_backlog_state_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchBacklogStateDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBacklogStateDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemBaselineChooseDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_baseline_choose_work_item ")
    @PostMapping("work_items/fetch_baseline_choose_work_item")
    public Mono<ResponseEntity<List<WorkItemBaselineChooseDTO>>> fetchBaselineChooseWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBaselineChooseWorkItem(context) ;
        List<WorkItemBaselineChooseDTO> list = workItemBaselineChooseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工作项" },  notes = "WorkItem-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_detail-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_bi_detail')")
    @PostMapping("work_items/fetch_bi_detail")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBiDetail
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiDetail(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"工作项" },  notes = "WorkItem-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_bi_search')")
    @PostMapping("work_items/fetch_bi_search")
    public Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiSearch(context) ;
        List<WorkItemBiSearchGroupDTO> list = workItemBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bug 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bug", tags = {"工作项" },  notes = "WorkItem-fetch_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bug-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_bug')")
    @PostMapping("work_items/fetch_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bug_state_group_grid 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bug_state_group_grid", tags = {"工作项" },  notes = "WorkItem-fetch_bug_state_group_grid ")
    @PostMapping("work_items/fetch_bug_state_group_grid")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBugStateGroupGrid
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBugStateGroupGrid(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_change_parent 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_change_parent", tags = {"工作项" },  notes = "WorkItem-fetch_change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_change_parent-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_change_parent')")
    @PostMapping("work_items/fetch_change_parent")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChangeParent
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChangeParent(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_child 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemChildDTO>>>
    */
    @ApiOperation(value = "查询fetch_child", tags = {"工作项" },  notes = "WorkItem-fetch_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_child-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_child')")
    @PostMapping("work_items/fetch_child")
    public Mono<ResponseEntity<List<WorkItemChildDTO>>> fetchChild
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChild(context) ;
        List<WorkItemChildDTO> list = workItemChildDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_child 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_child", tags = {"工作项" },  notes = "WorkItem-fetch_choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_child-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_choose_child')")
    @PostMapping("work_items/fetch_choose_child")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseChild
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseChild(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_dependency 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_dependency", tags = {"工作项" },  notes = "WorkItem-fetch_choose_dependency ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_dependency-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_choose_dependency')")
    @PostMapping("work_items/fetch_choose_dependency")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseDependency
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseDependency(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_assignee 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_comment_notify_assignee-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_comment_notify_assignee')")
    @PostMapping("work_items/fetch_comment_notify_assignee")
    public Mono<ResponseEntity<List<WorkItemAssigneeDTO>>> fetchCommentNotifyAssignee
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommentNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common 工作项
    * 未删除
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工作项" },  notes = "WorkItem-fetch_common 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_common-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_common')")
    @PostMapping("work_items/fetch_common")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchCommon
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommon(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common_bug 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_common_bug", tags = {"工作项" },  notes = "WorkItem-fetch_common_bug ")
    @PostMapping("work_items/fetch_common_bug")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchCommonBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommonBug(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作项" },  notes = "WorkItem-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_default-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_default')")
    @PostMapping("work_items/fetch_default")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDefault
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDefault(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_defect_property_distribution 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_defect_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_defect_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_defect_property_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_defect_property_distribution')")
    @PostMapping("work_items/fetch_defect_property_distribution")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDefectPropertyDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDefectPropertyDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工作项" },  notes = "WorkItem-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_deleted-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_deleted')")
    @PostMapping("work_items/fetch_deleted")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDeleted
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDeleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_kanban_user_stat 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_kanban_user_stat", tags = {"工作项" },  notes = "WorkItem-fetch_kanban_user_stat ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_kanban_user_stat-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_kanban_user_stat')")
    @PostMapping("work_items/fetch_kanban_user_stat")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchKanbanUserStat
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchKanbanUserStat(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_milestone 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_milestone", tags = {"工作项" },  notes = "WorkItem-fetch_milestone ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_milestone-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_milestone')")
    @PostMapping("work_items/fetch_milestone")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMilestone
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMilestone(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_move_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_move_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_move_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_move_work_item-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_move_work_item')")
    @PostMapping("work_items/fetch_move_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMoveWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMoveWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee ")
    @PostMapping("work_items/fetch_my_assignee")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAssignee
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAssignee(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee_count ")
    @PostMapping("work_items/fetch_my_assignee_count")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAssigneeCount
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAssigneeCount(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工作项" },  notes = "WorkItem-fetch_my_attention ")
    @PostMapping("work_items/fetch_my_attention")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAttention
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAttention(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工作项" },  notes = "WorkItem-fetch_my_created ")
    @PostMapping("work_items/fetch_my_created")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyCreated
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyCreated(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"工作项" },  notes = "WorkItem-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_filter-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_my_filter')")
    @PostMapping("work_items/fetch_my_filter")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyFilter
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyFilter(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_todo 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_todo", tags = {"工作项" },  notes = "WorkItem-fetch_my_todo ")
    @PostMapping("work_items/fetch_my_todo")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyTodo
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyTodo(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_bug_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_bug_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_no_bug_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_no_bug_work_item-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_no_bug_work_item')")
    @PostMapping("work_items/fetch_no_bug_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNoBugWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNoBugWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工作项" },  notes = "WorkItem-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_normal-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_normal')")
    @PostMapping("work_items/fetch_normal")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNormal
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNormal(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_bug_relation 工作项
    * 仅缺陷
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_bug_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_bug_relation 仅缺陷")
    @PostMapping("work_items/fetch_not_exsists_bug_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotExsistsBugRelation
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotExsistsBugRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_relation ")
    @PostMapping("work_items/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotExsistsRelation
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notbug_exsists_relation 工作项
    * 未关联且不为缺陷工作项
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_notbug_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_notbug_exsists_relation 未关联且不为缺陷工作项")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notbug_exsists_relation-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_notbug_exsists_relation')")
    @PostMapping("work_items/fetch_notbug_exsists_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotbugExsistsRelation
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotbugExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notify_assignee-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_notify_assignee')")
    @PostMapping("work_items/fetch_notify_assignee")
    public Mono<ResponseEntity<List<WorkItemAssigneeDTO>>> fetchNotifyAssignee
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_overview_chart 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_overview_chart", tags = {"工作项" },  notes = "WorkItem-fetch_overview_chart ")
    @PostMapping("work_items/fetch_overview_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchOverviewChart
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchOverviewChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_plan_snapshot 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemCreatePlanSnapshotDTO>>>
    */
    @ApiOperation(value = "查询fetch_plan_snapshot", tags = {"工作项" },  notes = "WorkItem-fetch_plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_plan_snapshot-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_plan_snapshot')")
    @PostMapping("work_items/fetch_plan_snapshot")
    public Mono<ResponseEntity<List<WorkItemCreatePlanSnapshotDTO>>> fetchPlanSnapshot
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchPlanSnapshot(context) ;
        List<WorkItemCreatePlanSnapshotDTO> list = workItemCreatePlanSnapshotDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_project_resource 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_project_resource", tags = {"工作项" },  notes = "WorkItem-fetch_project_resource ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_project_resource-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_project_resource')")
    @PostMapping("work_items/fetch_project_resource")
    public Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>> fetchProjectResource
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchProjectResource(context) ;
        List<WorkItemResourceAssignmentDTO> list = workItemResourceAssignmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_property_distribution 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_property_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_property_distribution')")
    @PostMapping("work_items/fetch_property_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchPropertyDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"工作项" },  notes = "WorkItem-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_reader-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_reader')")
    @PostMapping("work_items/fetch_reader")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReader
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReader(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_recent_work_item ")
    @PostMapping("work_items/fetch_recent_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchRecentWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRecentWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_release", tags = {"工作项" },  notes = "WorkItem-fetch_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_release')")
    @PostMapping("work_items/fetch_release")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRelease
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRelease(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_plan 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_plan", tags = {"工作项" },  notes = "WorkItem-fetch_release_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release_plan-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_release_plan')")
    @PostMapping("work_items/fetch_release_plan")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReleasePlan
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReleasePlan(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_work_item_chart 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_work_item_chart", tags = {"工作项" },  notes = "WorkItem-fetch_release_work_item_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release_work_item_chart-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_release_work_item_chart')")
    @PostMapping("work_items/fetch_release_work_item_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReleaseWorkItemChart
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReleaseWorkItemChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_requirement 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_requirement", tags = {"工作项" },  notes = "WorkItem-fetch_requirement ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_requirement')")
    @PostMapping("work_items/fetch_requirement")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRequirement
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRequirement(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_requirement_tree 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_requirement_tree", tags = {"工作项" },  notes = "WorkItem-fetch_requirement_tree ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement_tree-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_requirement_tree')")
    @PostMapping("work_items/fetch_requirement_tree")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRequirementTree
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRequirementTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_resource 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_resource", tags = {"工作项" },  notes = "WorkItem-fetch_resource ")
    @PostMapping("work_items/fetch_resource")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchResource
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchResource(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_seven_days 工作项
    * 工作项完成趋势逻辑中使用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_seven_days", tags = {"工作项" },  notes = "WorkItem-fetch_seven_days 工作项完成趋势逻辑中使用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_seven_days-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_seven_days')")
    @PostMapping("work_items/fetch_seven_days")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSevenDays
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSevenDays(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_completed 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_completed", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_completed ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_completed-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_sprint_completed')")
    @PostMapping("work_items/fetch_sprint_completed")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSprintCompleted
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSprintCompleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_work_item_chart 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_work_item_chart", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_work_item_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_work_item_chart-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_sprint_work_item_chart')")
    @PostMapping("work_items/fetch_sprint_work_item_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSprintWorkItemChart
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSprintWorkItemChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_test_plan_relation_bug 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_test_plan_relation_bug", tags = {"工作项" },  notes = "WorkItem-fetch_test_plan_relation_bug ")
    @PostMapping("work_items/fetch_test_plan_relation_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchTestPlanRelationBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTestPlanRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_top 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_top", tags = {"工作项" },  notes = "WorkItem-fetch_top ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_top-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_top')")
    @PostMapping("work_items/fetch_top")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchTop
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTop(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_tree 工作项
    * 未删除
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_tree", tags = {"工作项" },  notes = "WorkItem-fetch_tree 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_tree-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_tree')")
    @PostMapping("work_items/fetch_tree")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchTree
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_work 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_work", tags = {"工作项" },  notes = "WorkItem-fetch_under_work ")
    @PostMapping("work_items/fetch_under_work")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchUnderWork
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchUnderWork(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_work_resource 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_work_resource", tags = {"工作项" },  notes = "WorkItem-fetch_under_work_resource ")
    @PostMapping("work_items/fetch_under_work_resource")
    public Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>> fetchUnderWorkResource
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchUnderWorkResource(context) ;
        List<WorkItemResourceAssignmentDTO> list = workItemResourceAssignmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_type 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemWorkItemTypeIdDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_type", tags = {"工作项" },  notes = "WorkItem-fetch_work_item_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_work_item_type-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_work_item_type')")
    @PostMapping("work_items/fetch_work_item_type")
    public Mono<ResponseEntity<List<WorkItemWorkItemTypeIdDTO>>> fetchWorkItemType
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchWorkItemType(context) ;
        List<WorkItemWorkItemTypeIdDTO> list = workItemWorkItemTypeIdDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工作项" },  notes = "WorkItem-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get-all')  or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-WorkItem-Get')")
    @GetMapping("projects/{projectId}/work_items/{id}")
    public Mono<ResponseEntity<WorkItemDTO>> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作项" },  notes = "WorkItem-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Remove-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Remove')")
    @DeleteMapping("projects/{projectId}/work_items/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = workItemService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作项" },  notes = "WorkItem-CheckKey ")
    @PostMapping("projects/{projectId}/work_items/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        CheckKeyStatus rt = workItemService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"工作项" },  notes = "WorkItem-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_attention-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-get_attention')")
    @GetMapping("projects/{projectId}/work_items/{id}/get_attention")
    public Mono<ResponseEntity<WorkItemDTO>> getAttentionByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * get_baseline_name 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "get_baseline_name", tags = {"工作项" },  notes = "WorkItem-get_baseline_name ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_baseline_name-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-get_baseline_name')")
    @GetMapping("projects/{projectId}/work_items/{id}/get_baseline_name")
    public Mono<ResponseEntity<WorkItemDTO>> getBaselineNameByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getBaselineName(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项" },  notes = "WorkItem-GetDraft ")
    @GetMapping("projects/{projectId}/work_items/get_draft")
    public Mono<ResponseEntity<WorkItemDTO>> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * work_item_type_id 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_type_id", tags = {"工作项" },  notes = "WorkItem-work_item_type_id ")
    @GetMapping("projects/{projectId}/work_items/{id}/work_item_type_id")
    public Mono<ResponseEntity<WorkItemDTO>> workItemTypeIdByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.workItemTypeId(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_advanced_search 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工作项" },  notes = "WorkItem-fetch_advanced_search ")
    @PostMapping("projects/{projectId}/work_items/fetch_advanced_search")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchAdvancedSearchByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchAdvancedSearch(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工作项" },  notes = "WorkItem-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_archived-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_archived')")
    @PostMapping("projects/{projectId}/work_items/fetch_archived")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchArchivedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchArchived(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_backlog_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_backlog_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_backlog_property_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_backlog_property_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchBacklogPropertyDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBacklogPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_backlog_state_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_backlog_state_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_state_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_state_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_backlog_state_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_backlog_state_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchBacklogStateDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBacklogStateDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemBaselineChooseDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_baseline_choose_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetch_baseline_choose_work_item")
    public Mono<ResponseEntity<List<WorkItemBaselineChooseDTO>>> fetchBaselineChooseWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBaselineChooseWorkItem(context) ;
        List<WorkItemBaselineChooseDTO> list = workItemBaselineChooseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工作项" },  notes = "WorkItem-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_detail-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_bi_detail')")
    @PostMapping("projects/{projectId}/work_items/fetch_bi_detail")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBiDetailByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiDetail(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"工作项" },  notes = "WorkItem-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_search-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_bi_search')")
    @PostMapping("projects/{projectId}/work_items/fetch_bi_search")
    public Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>> fetchBiSearchByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiSearch(context) ;
        List<WorkItemBiSearchGroupDTO> list = workItemBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bug", tags = {"工作项" },  notes = "WorkItem-fetch_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bug-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_bug')")
    @PostMapping("projects/{projectId}/work_items/fetch_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bug_state_group_grid 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bug_state_group_grid", tags = {"工作项" },  notes = "WorkItem-fetch_bug_state_group_grid ")
    @PostMapping("projects/{projectId}/work_items/fetch_bug_state_group_grid")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBugStateGroupGridByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBugStateGroupGrid(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_change_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_change_parent", tags = {"工作项" },  notes = "WorkItem-fetch_change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_change_parent-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_change_parent')")
    @PostMapping("projects/{projectId}/work_items/fetch_change_parent")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChangeParentByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChangeParent(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_child 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemChildDTO>>>
    */
    @ApiOperation(value = "查询fetch_child", tags = {"工作项" },  notes = "WorkItem-fetch_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_child-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_child')")
    @PostMapping("projects/{projectId}/work_items/fetch_child")
    public Mono<ResponseEntity<List<WorkItemChildDTO>>> fetchChildByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChild(context) ;
        List<WorkItemChildDTO> list = workItemChildDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_child", tags = {"工作项" },  notes = "WorkItem-fetch_choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_child-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_choose_child')")
    @PostMapping("projects/{projectId}/work_items/fetch_choose_child")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseChildByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseChild(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_dependency 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_dependency", tags = {"工作项" },  notes = "WorkItem-fetch_choose_dependency ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_dependency-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_choose_dependency')")
    @PostMapping("projects/{projectId}/work_items/fetch_choose_dependency")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseDependencyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseDependency(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_comment_notify_assignee-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_comment_notify_assignee')")
    @PostMapping("projects/{projectId}/work_items/fetch_comment_notify_assignee")
    public Mono<ResponseEntity<List<WorkItemAssigneeDTO>>> fetchCommentNotifyAssigneeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommentNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common 工作项
    * 未删除
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工作项" },  notes = "WorkItem-fetch_common 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_common-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_common')")
    @PostMapping("projects/{projectId}/work_items/fetch_common")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchCommonByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommon(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_common_bug", tags = {"工作项" },  notes = "WorkItem-fetch_common_bug ")
    @PostMapping("projects/{projectId}/work_items/fetch_common_bug")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchCommonBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommonBug(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作项" },  notes = "WorkItem-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_default')")
    @PostMapping("projects/{projectId}/work_items/fetch_default")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDefault(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_defect_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_defect_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_defect_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_defect_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_defect_property_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_defect_property_distribution")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDefectPropertyDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDefectPropertyDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工作项" },  notes = "WorkItem-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_deleted-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_deleted')")
    @PostMapping("projects/{projectId}/work_items/fetch_deleted")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDeletedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDeleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_kanban_user_stat 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_kanban_user_stat", tags = {"工作项" },  notes = "WorkItem-fetch_kanban_user_stat ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_kanban_user_stat-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_kanban_user_stat')")
    @PostMapping("projects/{projectId}/work_items/fetch_kanban_user_stat")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchKanbanUserStatByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchKanbanUserStat(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_milestone 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_milestone", tags = {"工作项" },  notes = "WorkItem-fetch_milestone ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_milestone-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_milestone')")
    @PostMapping("projects/{projectId}/work_items/fetch_milestone")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMilestoneByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMilestone(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_move_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_move_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_move_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_move_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_move_work_item')")
    @PostMapping("projects/{projectId}/work_items/fetch_move_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMoveWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMoveWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_assignee")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAssigneeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAssignee(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee_count ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_assignee_count")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAssigneeCountByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAssigneeCount(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工作项" },  notes = "WorkItem-fetch_my_attention ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_attention")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAttentionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAttention(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工作项" },  notes = "WorkItem-fetch_my_created ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_created")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyCreatedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyCreated(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"工作项" },  notes = "WorkItem-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_filter-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_my_filter')")
    @PostMapping("projects/{projectId}/work_items/fetch_my_filter")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyFilterByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyFilter(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_todo 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_todo", tags = {"工作项" },  notes = "WorkItem-fetch_my_todo ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_todo")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyTodoByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyTodo(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_bug_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_bug_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_no_bug_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_no_bug_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_no_bug_work_item')")
    @PostMapping("projects/{projectId}/work_items/fetch_no_bug_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNoBugWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNoBugWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工作项" },  notes = "WorkItem-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_normal-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_normal')")
    @PostMapping("projects/{projectId}/work_items/fetch_normal")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNormalByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNormal(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_bug_relation 工作项
    * 仅缺陷
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_bug_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_bug_relation 仅缺陷")
    @PostMapping("projects/{projectId}/work_items/fetch_not_exsists_bug_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotExsistsBugRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotExsistsBugRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_relation ")
    @PostMapping("projects/{projectId}/work_items/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotExsistsRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notbug_exsists_relation 工作项
    * 未关联且不为缺陷工作项
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_notbug_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_notbug_exsists_relation 未关联且不为缺陷工作项")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notbug_exsists_relation-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_notbug_exsists_relation')")
    @PostMapping("projects/{projectId}/work_items/fetch_notbug_exsists_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotbugExsistsRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotbugExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notify_assignee-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_notify_assignee')")
    @PostMapping("projects/{projectId}/work_items/fetch_notify_assignee")
    public Mono<ResponseEntity<List<WorkItemAssigneeDTO>>> fetchNotifyAssigneeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_overview_chart 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_overview_chart", tags = {"工作项" },  notes = "WorkItem-fetch_overview_chart ")
    @PostMapping("projects/{projectId}/work_items/fetch_overview_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchOverviewChartByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchOverviewChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_plan_snapshot 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemCreatePlanSnapshotDTO>>>
    */
    @ApiOperation(value = "查询fetch_plan_snapshot", tags = {"工作项" },  notes = "WorkItem-fetch_plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_plan_snapshot-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_plan_snapshot')")
    @PostMapping("projects/{projectId}/work_items/fetch_plan_snapshot")
    public Mono<ResponseEntity<List<WorkItemCreatePlanSnapshotDTO>>> fetchPlanSnapshotByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchPlanSnapshot(context) ;
        List<WorkItemCreatePlanSnapshotDTO> list = workItemCreatePlanSnapshotDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_project_resource 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_project_resource", tags = {"工作项" },  notes = "WorkItem-fetch_project_resource ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_project_resource-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_project_resource')")
    @PostMapping("projects/{projectId}/work_items/fetch_project_resource")
    public Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>> fetchProjectResourceByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchProjectResource(context) ;
        List<WorkItemResourceAssignmentDTO> list = workItemResourceAssignmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_property_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_property_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchPropertyDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"工作项" },  notes = "WorkItem-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_reader-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_reader')")
    @PostMapping("projects/{projectId}/work_items/fetch_reader")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReaderByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReader(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_recent_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetch_recent_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchRecentWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRecentWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_release", tags = {"工作项" },  notes = "WorkItem-fetch_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_release')")
    @PostMapping("projects/{projectId}/work_items/fetch_release")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchReleaseByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRelease(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_plan 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_plan", tags = {"工作项" },  notes = "WorkItem-fetch_release_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release_plan-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_release_plan')")
    @PostMapping("projects/{projectId}/work_items/fetch_release_plan")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReleasePlanByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReleasePlan(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_work_item_chart 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_work_item_chart", tags = {"工作项" },  notes = "WorkItem-fetch_release_work_item_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release_work_item_chart-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_release_work_item_chart')")
    @PostMapping("projects/{projectId}/work_items/fetch_release_work_item_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReleaseWorkItemChartByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReleaseWorkItemChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_requirement 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_requirement", tags = {"工作项" },  notes = "WorkItem-fetch_requirement ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_requirement')")
    @PostMapping("projects/{projectId}/work_items/fetch_requirement")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRequirementByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRequirement(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_requirement_tree 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_requirement_tree", tags = {"工作项" },  notes = "WorkItem-fetch_requirement_tree ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement_tree-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_requirement_tree')")
    @PostMapping("projects/{projectId}/work_items/fetch_requirement_tree")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRequirementTreeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRequirementTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_resource 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_resource", tags = {"工作项" },  notes = "WorkItem-fetch_resource ")
    @PostMapping("projects/{projectId}/work_items/fetch_resource")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchResourceByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchResource(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_seven_days 工作项
    * 工作项完成趋势逻辑中使用
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_seven_days", tags = {"工作项" },  notes = "WorkItem-fetch_seven_days 工作项完成趋势逻辑中使用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_seven_days-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_seven_days')")
    @PostMapping("projects/{projectId}/work_items/fetch_seven_days")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSevenDaysByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSevenDays(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_completed 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_completed", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_completed ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_completed-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_sprint_completed')")
    @PostMapping("projects/{projectId}/work_items/fetch_sprint_completed")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSprintCompletedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSprintCompleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_work_item_chart 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_work_item_chart", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_work_item_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_work_item_chart-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_sprint_work_item_chart')")
    @PostMapping("projects/{projectId}/work_items/fetch_sprint_work_item_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSprintWorkItemChartByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSprintWorkItemChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_test_plan_relation_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_test_plan_relation_bug", tags = {"工作项" },  notes = "WorkItem-fetch_test_plan_relation_bug ")
    @PostMapping("projects/{projectId}/work_items/fetch_test_plan_relation_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchTestPlanRelationBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTestPlanRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_top 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_top", tags = {"工作项" },  notes = "WorkItem-fetch_top ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_top-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_top')")
    @PostMapping("projects/{projectId}/work_items/fetch_top")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchTopByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTop(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_tree 工作项
    * 未删除
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_tree", tags = {"工作项" },  notes = "WorkItem-fetch_tree 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_tree-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_tree')")
    @PostMapping("projects/{projectId}/work_items/fetch_tree")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchTreeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_work 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_work", tags = {"工作项" },  notes = "WorkItem-fetch_under_work ")
    @PostMapping("projects/{projectId}/work_items/fetch_under_work")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchUnderWorkByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchUnderWork(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_work_resource 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_work_resource", tags = {"工作项" },  notes = "WorkItem-fetch_under_work_resource ")
    @PostMapping("projects/{projectId}/work_items/fetch_under_work_resource")
    public Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>> fetchUnderWorkResourceByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchUnderWorkResource(context) ;
        List<WorkItemResourceAssignmentDTO> list = workItemResourceAssignmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_type 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemWorkItemTypeIdDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_type", tags = {"工作项" },  notes = "WorkItem-fetch_work_item_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_work_item_type-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_work_item_type')")
    @PostMapping("projects/{projectId}/work_items/fetch_work_item_type")
    public Mono<ResponseEntity<List<WorkItemWorkItemTypeIdDTO>>> fetchWorkItemTypeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchWorkItemType(context) ;
        List<WorkItemWorkItemTypeIdDTO> list = workItemWorkItemTypeIdDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工作项" },  notes = "WorkItem-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get-all')  or hasPermission('release',#releaseId,this.workItemDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-WorkItem-Get')")
    @GetMapping("releases/{releaseId}/work_items/{id}")
    public Mono<ResponseEntity<WorkItemDTO>> getByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作项" },  notes = "WorkItem-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Remove-all') or hasPermission('release',#releaseId,this.workItemService.get(#id),'ibizplm-WorkItem-Remove')")
    @DeleteMapping("releases/{releaseId}/work_items/{id}")
    public Mono<ResponseEntity<Boolean>> removeByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        Boolean rt = workItemService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作项" },  notes = "WorkItem-CheckKey ")
    @PostMapping("releases/{releaseId}/work_items/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        CheckKeyStatus rt = workItemService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"工作项" },  notes = "WorkItem-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_attention-all') or hasPermission('release',#releaseId,this.workItemService.get(#id),'ibizplm-WorkItem-get_attention')")
    @GetMapping("releases/{releaseId}/work_items/{id}/get_attention")
    public Mono<ResponseEntity<WorkItemDTO>> getAttentionByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * get_baseline_name 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "get_baseline_name", tags = {"工作项" },  notes = "WorkItem-get_baseline_name ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_baseline_name-all') or hasPermission('release',#releaseId,this.workItemService.get(#id),'ibizplm-WorkItem-get_baseline_name')")
    @GetMapping("releases/{releaseId}/work_items/{id}/get_baseline_name")
    public Mono<ResponseEntity<WorkItemDTO>> getBaselineNameByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getBaselineName(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项" },  notes = "WorkItem-GetDraft ")
    @GetMapping("releases/{releaseId}/work_items/get_draft")
    public Mono<ResponseEntity<WorkItemDTO>> getDraftByReleaseId
            (@PathVariable("releaseId") String releaseId, @SpringQueryMap WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * work_item_type_id 工作项
    * 
    *
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_type_id", tags = {"工作项" },  notes = "WorkItem-work_item_type_id ")
    @GetMapping("releases/{releaseId}/work_items/{id}/work_item_type_id")
    public Mono<ResponseEntity<WorkItemDTO>> workItemTypeIdByReleaseIdAndId
            (@PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.workItemTypeId(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_advanced_search 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工作项" },  notes = "WorkItem-fetch_advanced_search ")
    @PostMapping("releases/{releaseId}/work_items/fetch_advanced_search")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchAdvancedSearchByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchAdvancedSearch(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工作项" },  notes = "WorkItem-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_archived-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_archived')")
    @PostMapping("releases/{releaseId}/work_items/fetch_archived")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchArchivedByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchArchived(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_backlog_property_distribution 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_backlog_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_property_distribution-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_backlog_property_distribution')")
    @PostMapping("releases/{releaseId}/work_items/fetch_backlog_property_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchBacklogPropertyDistributionByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBacklogPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_backlog_state_distribution 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_backlog_state_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_state_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_state_distribution-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_backlog_state_distribution')")
    @PostMapping("releases/{releaseId}/work_items/fetch_backlog_state_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchBacklogStateDistributionByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBacklogStateDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemBaselineChooseDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_baseline_choose_work_item ")
    @PostMapping("releases/{releaseId}/work_items/fetch_baseline_choose_work_item")
    public Mono<ResponseEntity<List<WorkItemBaselineChooseDTO>>> fetchBaselineChooseWorkItemByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBaselineChooseWorkItem(context) ;
        List<WorkItemBaselineChooseDTO> list = workItemBaselineChooseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工作项" },  notes = "WorkItem-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_detail-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_bi_detail')")
    @PostMapping("releases/{releaseId}/work_items/fetch_bi_detail")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBiDetailByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiDetail(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"工作项" },  notes = "WorkItem-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_search-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_bi_search')")
    @PostMapping("releases/{releaseId}/work_items/fetch_bi_search")
    public Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>> fetchBiSearchByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiSearch(context) ;
        List<WorkItemBiSearchGroupDTO> list = workItemBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bug 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bug", tags = {"工作项" },  notes = "WorkItem-fetch_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bug-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_bug')")
    @PostMapping("releases/{releaseId}/work_items/fetch_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBugByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bug_state_group_grid 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bug_state_group_grid", tags = {"工作项" },  notes = "WorkItem-fetch_bug_state_group_grid ")
    @PostMapping("releases/{releaseId}/work_items/fetch_bug_state_group_grid")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBugStateGroupGridByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBugStateGroupGrid(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_change_parent 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_change_parent", tags = {"工作项" },  notes = "WorkItem-fetch_change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_change_parent-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_change_parent')")
    @PostMapping("releases/{releaseId}/work_items/fetch_change_parent")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChangeParentByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChangeParent(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_child 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemChildDTO>>>
    */
    @ApiOperation(value = "查询fetch_child", tags = {"工作项" },  notes = "WorkItem-fetch_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_child-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_child')")
    @PostMapping("releases/{releaseId}/work_items/fetch_child")
    public Mono<ResponseEntity<List<WorkItemChildDTO>>> fetchChildByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChild(context) ;
        List<WorkItemChildDTO> list = workItemChildDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_child 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_child", tags = {"工作项" },  notes = "WorkItem-fetch_choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_child-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_choose_child')")
    @PostMapping("releases/{releaseId}/work_items/fetch_choose_child")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseChildByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseChild(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_dependency 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_dependency", tags = {"工作项" },  notes = "WorkItem-fetch_choose_dependency ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_dependency-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_choose_dependency')")
    @PostMapping("releases/{releaseId}/work_items/fetch_choose_dependency")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseDependencyByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseDependency(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_assignee 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_comment_notify_assignee-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_comment_notify_assignee')")
    @PostMapping("releases/{releaseId}/work_items/fetch_comment_notify_assignee")
    public Mono<ResponseEntity<List<WorkItemAssigneeDTO>>> fetchCommentNotifyAssigneeByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommentNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common 工作项
    * 未删除
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工作项" },  notes = "WorkItem-fetch_common 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_common-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_common')")
    @PostMapping("releases/{releaseId}/work_items/fetch_common")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchCommonByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommon(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common_bug 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_common_bug", tags = {"工作项" },  notes = "WorkItem-fetch_common_bug ")
    @PostMapping("releases/{releaseId}/work_items/fetch_common_bug")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchCommonBugByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommonBug(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作项" },  notes = "WorkItem-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_default-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_default')")
    @PostMapping("releases/{releaseId}/work_items/fetch_default")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDefaultByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDefault(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_defect_property_distribution 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_defect_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_defect_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_defect_property_distribution-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_defect_property_distribution')")
    @PostMapping("releases/{releaseId}/work_items/fetch_defect_property_distribution")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDefectPropertyDistributionByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDefectPropertyDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工作项" },  notes = "WorkItem-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_deleted-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_deleted')")
    @PostMapping("releases/{releaseId}/work_items/fetch_deleted")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDeletedByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDeleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_kanban_user_stat 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_kanban_user_stat", tags = {"工作项" },  notes = "WorkItem-fetch_kanban_user_stat ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_kanban_user_stat-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_kanban_user_stat')")
    @PostMapping("releases/{releaseId}/work_items/fetch_kanban_user_stat")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchKanbanUserStatByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchKanbanUserStat(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_milestone 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_milestone", tags = {"工作项" },  notes = "WorkItem-fetch_milestone ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_milestone-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_milestone')")
    @PostMapping("releases/{releaseId}/work_items/fetch_milestone")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMilestoneByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMilestone(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_move_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_move_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_move_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_move_work_item-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_move_work_item')")
    @PostMapping("releases/{releaseId}/work_items/fetch_move_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMoveWorkItemByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMoveWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee ")
    @PostMapping("releases/{releaseId}/work_items/fetch_my_assignee")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAssigneeByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAssignee(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee_count ")
    @PostMapping("releases/{releaseId}/work_items/fetch_my_assignee_count")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAssigneeCountByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAssigneeCount(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工作项" },  notes = "WorkItem-fetch_my_attention ")
    @PostMapping("releases/{releaseId}/work_items/fetch_my_attention")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAttentionByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAttention(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工作项" },  notes = "WorkItem-fetch_my_created ")
    @PostMapping("releases/{releaseId}/work_items/fetch_my_created")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyCreatedByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyCreated(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"工作项" },  notes = "WorkItem-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_filter-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_my_filter')")
    @PostMapping("releases/{releaseId}/work_items/fetch_my_filter")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyFilterByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyFilter(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_todo 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_todo", tags = {"工作项" },  notes = "WorkItem-fetch_my_todo ")
    @PostMapping("releases/{releaseId}/work_items/fetch_my_todo")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyTodoByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyTodo(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_bug_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_bug_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_no_bug_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_no_bug_work_item-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_no_bug_work_item')")
    @PostMapping("releases/{releaseId}/work_items/fetch_no_bug_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNoBugWorkItemByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNoBugWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工作项" },  notes = "WorkItem-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_normal-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_normal')")
    @PostMapping("releases/{releaseId}/work_items/fetch_normal")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNormalByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNormal(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_bug_relation 工作项
    * 仅缺陷
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_bug_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_bug_relation 仅缺陷")
    @PostMapping("releases/{releaseId}/work_items/fetch_not_exsists_bug_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotExsistsBugRelationByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotExsistsBugRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_relation ")
    @PostMapping("releases/{releaseId}/work_items/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotExsistsRelationByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notbug_exsists_relation 工作项
    * 未关联且不为缺陷工作项
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_notbug_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_notbug_exsists_relation 未关联且不为缺陷工作项")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notbug_exsists_relation-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_notbug_exsists_relation')")
    @PostMapping("releases/{releaseId}/work_items/fetch_notbug_exsists_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotbugExsistsRelationByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotbugExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notify_assignee-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_notify_assignee')")
    @PostMapping("releases/{releaseId}/work_items/fetch_notify_assignee")
    public Mono<ResponseEntity<List<WorkItemAssigneeDTO>>> fetchNotifyAssigneeByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_overview_chart 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_overview_chart", tags = {"工作项" },  notes = "WorkItem-fetch_overview_chart ")
    @PostMapping("releases/{releaseId}/work_items/fetch_overview_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchOverviewChartByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchOverviewChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_plan_snapshot 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemCreatePlanSnapshotDTO>>>
    */
    @ApiOperation(value = "查询fetch_plan_snapshot", tags = {"工作项" },  notes = "WorkItem-fetch_plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_plan_snapshot-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_plan_snapshot')")
    @PostMapping("releases/{releaseId}/work_items/fetch_plan_snapshot")
    public Mono<ResponseEntity<List<WorkItemCreatePlanSnapshotDTO>>> fetchPlanSnapshotByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchPlanSnapshot(context) ;
        List<WorkItemCreatePlanSnapshotDTO> list = workItemCreatePlanSnapshotDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_project_resource 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_project_resource", tags = {"工作项" },  notes = "WorkItem-fetch_project_resource ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_project_resource-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_project_resource')")
    @PostMapping("releases/{releaseId}/work_items/fetch_project_resource")
    public Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>> fetchProjectResourceByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchProjectResource(context) ;
        List<WorkItemResourceAssignmentDTO> list = workItemResourceAssignmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_property_distribution 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_property_distribution-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_property_distribution')")
    @PostMapping("releases/{releaseId}/work_items/fetch_property_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchPropertyDistributionByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"工作项" },  notes = "WorkItem-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_reader-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_reader')")
    @PostMapping("releases/{releaseId}/work_items/fetch_reader")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReaderByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReader(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_work_item 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_recent_work_item ")
    @PostMapping("releases/{releaseId}/work_items/fetch_recent_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchRecentWorkItemByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRecentWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_release", tags = {"工作项" },  notes = "WorkItem-fetch_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_release')")
    @PostMapping("releases/{releaseId}/work_items/fetch_release")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchReleaseByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRelease(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_plan 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_plan", tags = {"工作项" },  notes = "WorkItem-fetch_release_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release_plan-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_release_plan')")
    @PostMapping("releases/{releaseId}/work_items/fetch_release_plan")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReleasePlanByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReleasePlan(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_work_item_chart 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_work_item_chart", tags = {"工作项" },  notes = "WorkItem-fetch_release_work_item_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release_work_item_chart-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_release_work_item_chart')")
    @PostMapping("releases/{releaseId}/work_items/fetch_release_work_item_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReleaseWorkItemChartByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReleaseWorkItemChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_requirement 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_requirement", tags = {"工作项" },  notes = "WorkItem-fetch_requirement ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_requirement')")
    @PostMapping("releases/{releaseId}/work_items/fetch_requirement")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRequirementByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRequirement(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_requirement_tree 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_requirement_tree", tags = {"工作项" },  notes = "WorkItem-fetch_requirement_tree ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement_tree-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_requirement_tree')")
    @PostMapping("releases/{releaseId}/work_items/fetch_requirement_tree")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRequirementTreeByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRequirementTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_resource 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_resource", tags = {"工作项" },  notes = "WorkItem-fetch_resource ")
    @PostMapping("releases/{releaseId}/work_items/fetch_resource")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchResourceByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchResource(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_seven_days 工作项
    * 工作项完成趋势逻辑中使用
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_seven_days", tags = {"工作项" },  notes = "WorkItem-fetch_seven_days 工作项完成趋势逻辑中使用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_seven_days-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_seven_days')")
    @PostMapping("releases/{releaseId}/work_items/fetch_seven_days")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSevenDaysByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSevenDays(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_completed 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_completed", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_completed ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_completed-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_sprint_completed')")
    @PostMapping("releases/{releaseId}/work_items/fetch_sprint_completed")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSprintCompletedByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSprintCompleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_work_item_chart 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_work_item_chart", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_work_item_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_work_item_chart-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_sprint_work_item_chart')")
    @PostMapping("releases/{releaseId}/work_items/fetch_sprint_work_item_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSprintWorkItemChartByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSprintWorkItemChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_test_plan_relation_bug 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_test_plan_relation_bug", tags = {"工作项" },  notes = "WorkItem-fetch_test_plan_relation_bug ")
    @PostMapping("releases/{releaseId}/work_items/fetch_test_plan_relation_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchTestPlanRelationBugByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTestPlanRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_top 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_top", tags = {"工作项" },  notes = "WorkItem-fetch_top ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_top-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_top')")
    @PostMapping("releases/{releaseId}/work_items/fetch_top")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchTopByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTop(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_tree 工作项
    * 未删除
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_tree", tags = {"工作项" },  notes = "WorkItem-fetch_tree 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_tree-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_tree')")
    @PostMapping("releases/{releaseId}/work_items/fetch_tree")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchTreeByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_work 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_work", tags = {"工作项" },  notes = "WorkItem-fetch_under_work ")
    @PostMapping("releases/{releaseId}/work_items/fetch_under_work")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchUnderWorkByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchUnderWork(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_work_resource 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_work_resource", tags = {"工作项" },  notes = "WorkItem-fetch_under_work_resource ")
    @PostMapping("releases/{releaseId}/work_items/fetch_under_work_resource")
    public Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>> fetchUnderWorkResourceByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchUnderWorkResource(context) ;
        List<WorkItemResourceAssignmentDTO> list = workItemResourceAssignmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_type 工作项
    * 
    *
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemWorkItemTypeIdDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_type", tags = {"工作项" },  notes = "WorkItem-fetch_work_item_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_work_item_type-all') or hasPermission('release',#releaseId,#dto,'ibizplm-WorkItem-fetch_work_item_type')")
    @PostMapping("releases/{releaseId}/work_items/fetch_work_item_type")
    public Mono<ResponseEntity<List<WorkItemWorkItemTypeIdDTO>>> fetchWorkItemTypeByReleaseId
            (@PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchWorkItemType(context) ;
        List<WorkItemWorkItemTypeIdDTO> list = workItemWorkItemTypeIdDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"工作项" },  notes = "WorkItem-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get-all')  or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-WorkItem-Get')")
    @GetMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}")
    public Mono<ResponseEntity<WorkItemDTO>> getByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作项" },  notes = "WorkItem-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Remove-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Remove')")
    @DeleteMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        Boolean rt = workItemService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作项" },  notes = "WorkItem-CheckKey ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        CheckKeyStatus rt = workItemService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"工作项" },  notes = "WorkItem-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_attention-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-get_attention')")
    @GetMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/get_attention")
    public Mono<ResponseEntity<WorkItemDTO>> getAttentionByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * get_baseline_name 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "get_baseline_name", tags = {"工作项" },  notes = "WorkItem-get_baseline_name ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_baseline_name-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-get_baseline_name')")
    @GetMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/get_baseline_name")
    public Mono<ResponseEntity<WorkItemDTO>> getBaselineNameByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getBaselineName(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项" },  notes = "WorkItem-GetDraft ")
    @GetMapping("projects/{projectId}/releases/{releaseId}/work_items/get_draft")
    public Mono<ResponseEntity<WorkItemDTO>> getDraftByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @SpringQueryMap WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setReleaseId(releaseId);
        WorkItem rt = workItemService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * work_item_type_id 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param id id
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "work_item_type_id", tags = {"工作项" },  notes = "WorkItem-work_item_type_id ")
    @GetMapping("projects/{projectId}/releases/{releaseId}/work_items/{id}/work_item_type_id")
    public Mono<ResponseEntity<WorkItemDTO>> workItemTypeIdByProjectIdAndReleaseIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.workItemTypeId(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_advanced_search 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工作项" },  notes = "WorkItem-fetch_advanced_search ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_advanced_search")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchAdvancedSearchByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchAdvancedSearch(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工作项" },  notes = "WorkItem-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_archived-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_archived')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_archived")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchArchivedByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchArchived(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_backlog_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_backlog_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_backlog_property_distribution')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_backlog_property_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchBacklogPropertyDistributionByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBacklogPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_backlog_state_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_backlog_state_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_state_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_state_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_backlog_state_distribution')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_backlog_state_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchBacklogStateDistributionByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBacklogStateDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemBaselineChooseDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_baseline_choose_work_item ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_baseline_choose_work_item")
    public Mono<ResponseEntity<List<WorkItemBaselineChooseDTO>>> fetchBaselineChooseWorkItemByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBaselineChooseWorkItem(context) ;
        List<WorkItemBaselineChooseDTO> list = workItemBaselineChooseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工作项" },  notes = "WorkItem-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_detail-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_bi_detail')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_bi_detail")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBiDetailByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiDetail(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"工作项" },  notes = "WorkItem-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_search-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_bi_search')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_bi_search")
    public Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>> fetchBiSearchByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiSearch(context) ;
        List<WorkItemBiSearchGroupDTO> list = workItemBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bug", tags = {"工作项" },  notes = "WorkItem-fetch_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bug-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_bug')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBugByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bug_state_group_grid 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_bug_state_group_grid", tags = {"工作项" },  notes = "WorkItem-fetch_bug_state_group_grid ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_bug_state_group_grid")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchBugStateGroupGridByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBugStateGroupGrid(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_change_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_change_parent", tags = {"工作项" },  notes = "WorkItem-fetch_change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_change_parent-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_change_parent')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_change_parent")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChangeParentByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChangeParent(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_child 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemChildDTO>>>
    */
    @ApiOperation(value = "查询fetch_child", tags = {"工作项" },  notes = "WorkItem-fetch_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_child-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_child')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_child")
    public Mono<ResponseEntity<List<WorkItemChildDTO>>> fetchChildByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChild(context) ;
        List<WorkItemChildDTO> list = workItemChildDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_child", tags = {"工作项" },  notes = "WorkItem-fetch_choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_child-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_choose_child')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_choose_child")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseChildByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseChild(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_dependency 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_dependency", tags = {"工作项" },  notes = "WorkItem-fetch_choose_dependency ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_dependency-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_choose_dependency')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_choose_dependency")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseDependencyByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseDependency(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_comment_notify_assignee-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_comment_notify_assignee')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_comment_notify_assignee")
    public Mono<ResponseEntity<List<WorkItemAssigneeDTO>>> fetchCommentNotifyAssigneeByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommentNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common 工作项
    * 未删除
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工作项" },  notes = "WorkItem-fetch_common 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_common-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_common')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_common")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchCommonByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommon(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_common_bug", tags = {"工作项" },  notes = "WorkItem-fetch_common_bug ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_common_bug")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchCommonBugByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchCommonBug(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作项" },  notes = "WorkItem-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_default')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_default")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDefaultByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDefault(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_defect_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_defect_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_defect_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_defect_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_defect_property_distribution')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_defect_property_distribution")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDefectPropertyDistributionByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDefectPropertyDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工作项" },  notes = "WorkItem-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_deleted-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_deleted')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_deleted")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchDeletedByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchDeleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_kanban_user_stat 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_kanban_user_stat", tags = {"工作项" },  notes = "WorkItem-fetch_kanban_user_stat ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_kanban_user_stat-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_kanban_user_stat')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_kanban_user_stat")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchKanbanUserStatByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchKanbanUserStat(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_milestone 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_milestone", tags = {"工作项" },  notes = "WorkItem-fetch_milestone ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_milestone-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_milestone')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_milestone")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMilestoneByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMilestone(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_move_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_move_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_move_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_move_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_move_work_item')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_move_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMoveWorkItemByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMoveWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_my_assignee")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAssigneeByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAssignee(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee_count ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_my_assignee_count")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAssigneeCountByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAssigneeCount(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工作项" },  notes = "WorkItem-fetch_my_attention ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_my_attention")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyAttentionByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyAttention(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工作项" },  notes = "WorkItem-fetch_my_created ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_my_created")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyCreatedByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyCreated(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"工作项" },  notes = "WorkItem-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_filter-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_my_filter')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_my_filter")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyFilterByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyFilter(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_todo 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_todo", tags = {"工作项" },  notes = "WorkItem-fetch_my_todo ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_my_todo")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMyTodoByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMyTodo(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_bug_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_bug_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_no_bug_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_no_bug_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_no_bug_work_item')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_no_bug_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNoBugWorkItemByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNoBugWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工作项" },  notes = "WorkItem-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_normal-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_normal')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_normal")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNormalByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNormal(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_bug_relation 工作项
    * 仅缺陷
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_bug_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_bug_relation 仅缺陷")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_not_exsists_bug_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotExsistsBugRelationByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotExsistsBugRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_relation ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotExsistsRelationByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notbug_exsists_relation 工作项
    * 未关联且不为缺陷工作项
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_notbug_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_notbug_exsists_relation 未关联且不为缺陷工作项")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notbug_exsists_relation-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_notbug_exsists_relation')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_notbug_exsists_relation")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchNotbugExsistsRelationByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotbugExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notify_assignee-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_notify_assignee')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_notify_assignee")
    public Mono<ResponseEntity<List<WorkItemAssigneeDTO>>> fetchNotifyAssigneeByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_overview_chart 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_overview_chart", tags = {"工作项" },  notes = "WorkItem-fetch_overview_chart ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_overview_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchOverviewChartByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchOverviewChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_plan_snapshot 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemCreatePlanSnapshotDTO>>>
    */
    @ApiOperation(value = "查询fetch_plan_snapshot", tags = {"工作项" },  notes = "WorkItem-fetch_plan_snapshot ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_plan_snapshot-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_plan_snapshot')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_plan_snapshot")
    public Mono<ResponseEntity<List<WorkItemCreatePlanSnapshotDTO>>> fetchPlanSnapshotByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchPlanSnapshot(context) ;
        List<WorkItemCreatePlanSnapshotDTO> list = workItemCreatePlanSnapshotDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_project_resource 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_project_resource", tags = {"工作项" },  notes = "WorkItem-fetch_project_resource ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_project_resource-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_project_resource')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_project_resource")
    public Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>> fetchProjectResourceByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchProjectResource(context) ;
        List<WorkItemResourceAssignmentDTO> list = workItemResourceAssignmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_property_distribution')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_property_distribution")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchPropertyDistributionByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"工作项" },  notes = "WorkItem-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_reader-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_reader')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_reader")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReaderByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReader(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_recent_work_item ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_recent_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchRecentWorkItemByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRecentWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_release", tags = {"工作项" },  notes = "WorkItem-fetch_release ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_release')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_release")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchReleaseByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRelease(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_plan 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_plan", tags = {"工作项" },  notes = "WorkItem-fetch_release_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release_plan-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_release_plan')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_release_plan")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReleasePlanByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReleasePlan(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_release_work_item_chart 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_release_work_item_chart", tags = {"工作项" },  notes = "WorkItem-fetch_release_work_item_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_release_work_item_chart-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_release_work_item_chart')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_release_work_item_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchReleaseWorkItemChartByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchReleaseWorkItemChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_requirement 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_requirement", tags = {"工作项" },  notes = "WorkItem-fetch_requirement ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_requirement')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_requirement")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRequirementByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRequirement(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_requirement_tree 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_requirement_tree", tags = {"工作项" },  notes = "WorkItem-fetch_requirement_tree ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement_tree-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_requirement_tree')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_requirement_tree")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchRequirementTreeByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRequirementTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_resource 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_resource", tags = {"工作项" },  notes = "WorkItem-fetch_resource ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_resource")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchResourceByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchResource(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_seven_days 工作项
    * 工作项完成趋势逻辑中使用
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_seven_days", tags = {"工作项" },  notes = "WorkItem-fetch_seven_days 工作项完成趋势逻辑中使用")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_seven_days-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_seven_days')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_seven_days")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSevenDaysByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSevenDays(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_completed 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_completed", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_completed ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_completed-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_sprint_completed')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_sprint_completed")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSprintCompletedByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSprintCompleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_sprint_work_item_chart 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_sprint_work_item_chart", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_work_item_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_work_item_chart-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_sprint_work_item_chart')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_sprint_work_item_chart")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchSprintWorkItemChartByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchSprintWorkItemChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_test_plan_relation_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_test_plan_relation_bug", tags = {"工作项" },  notes = "WorkItem-fetch_test_plan_relation_bug ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_test_plan_relation_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchTestPlanRelationBugByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTestPlanRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_top 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_top", tags = {"工作项" },  notes = "WorkItem-fetch_top ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_top-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_top')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_top")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchTopByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTop(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_tree 工作项
    * 未删除
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_tree", tags = {"工作项" },  notes = "WorkItem-fetch_tree 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_tree-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_tree')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_tree")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchTreeByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_work 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_work", tags = {"工作项" },  notes = "WorkItem-fetch_under_work ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_under_work")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchUnderWorkByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchUnderWork(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_under_work_resource 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_under_work_resource", tags = {"工作项" },  notes = "WorkItem-fetch_under_work_resource ")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_under_work_resource")
    public Mono<ResponseEntity<List<WorkItemResourceAssignmentDTO>>> fetchUnderWorkResourceByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchUnderWorkResource(context) ;
        List<WorkItemResourceAssignmentDTO> list = workItemResourceAssignmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_type 工作项
    * 
    *
    * @param projectId projectId
    * @param releaseId releaseId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemWorkItemTypeIdDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_type", tags = {"工作项" },  notes = "WorkItem-fetch_work_item_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_work_item_type-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_work_item_type')")
    @PostMapping("projects/{projectId}/releases/{releaseId}/work_items/fetch_work_item_type")
    public Mono<ResponseEntity<List<WorkItemWorkItemTypeIdDTO>>> fetchWorkItemTypeByProjectIdAndReleaseId
            (@PathVariable("projectId") String projectId, @PathVariable("releaseId") String releaseId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setReleaseIdEQ(releaseId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchWorkItemType(context) ;
        List<WorkItemWorkItemTypeIdDTO> list = workItemWorkItemTypeIdDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建工作项
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Create-all')")
    @ApiOperation(value = "批量新建工作项", tags = {"工作项" },  notes = "批量新建工作项")
	@PostMapping("work_items/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<WorkItemDTO> dtos) {
        workItemService.create(workItemDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除工作项
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Remove-all')")
    @ApiOperation(value = "批量删除工作项", tags = {"工作项" },  notes = "批量删除工作项")
	@DeleteMapping("work_items/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        workItemService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新工作项
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Update-all')")
    @ApiOperation(value = "批量更新工作项", tags = {"工作项" },  notes = "批量更新工作项")
	@PutMapping("work_items/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<WorkItemDTO> dtos) {
        workItemService.update(workItemDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存工作项
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Save-all')")
    @ApiOperation(value = "批量保存工作项", tags = {"工作项" },  notes = "批量保存工作项")
	@PostMapping("work_items/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<WorkItemDTO> dtos) {
        workItemService.save(workItemDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入工作项
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Save-all')")
    @ApiOperation(value = "批量导入工作项", tags = {"工作项" },  notes = "批量导入工作项")
	@PostMapping("work_items/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<WorkItemDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(workItemService.importData(config,ignoreError,workItemDtoMapping.toDomain(dtos))));
    }

}
