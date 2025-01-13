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
    * count_my_todo 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "count_my_todo", tags = {"工作项" },  notes = "WorkItem-count_my_todo ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-count_my_todo-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-count_my_todo')")
    @PostMapping("work_items/count_my_todo")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>countMyTodo
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(countMyTodo(item)));
        else
            rt.set(countMyTodo(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * count_my_todo 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO countMyTodo
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.countMyTodo(domain);
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
    * custom_draft 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "custom_draft", tags = {"工作项" },  notes = "WorkItem-custom_draft ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-custom_draft-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-custom_draft')")
    @PostMapping("work_items/custom_draft")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>customDraft
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(customDraft(item)));
        else
            rt.set(customDraft(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * custom_draft 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO customDraft
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.customDraft(domain);
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
    * fill_not_completed_num 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fill_not_completed_num", tags = {"工作项" },  notes = "WorkItem-fill_not_completed_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fill_not_completed_num-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fill_not_completed_num')")
    @PostMapping("work_items/fill_not_completed_num")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fillNotCompletedNum
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillNotCompletedNum(item)));
        else
            rt.set(fillNotCompletedNum(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_not_completed_num 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fillNotCompletedNum
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.fillNotCompletedNum(domain);
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
    * count_my_todo 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "count_my_todo", tags = {"工作项" },  notes = "WorkItem-count_my_todo ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-count_my_todo-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-count_my_todo')")
    @PostMapping("projects/{projectId}/work_items/count_my_todo")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>countMyTodoByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(countMyTodoByProjectId(projectId, item)));
        else
            rt.set(countMyTodoByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * count_my_todo 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO countMyTodoByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.countMyTodo(domain);
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
    * custom_draft 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "custom_draft", tags = {"工作项" },  notes = "WorkItem-custom_draft ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-custom_draft-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-custom_draft')")
    @PostMapping("projects/{projectId}/work_items/custom_draft")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>customDraftByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(customDraftByProjectId(projectId, item)));
        else
            rt.set(customDraftByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * custom_draft 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO customDraftByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.customDraft(domain);
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
    * fill_not_completed_num 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<WorkItemDTO>>
    */
    @ApiOperation(value = "fill_not_completed_num", tags = {"工作项" },  notes = "WorkItem-fill_not_completed_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fill_not_completed_num-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-fill_not_completed_num')")
    @PostMapping("projects/{projectId}/work_items/fill_not_completed_num")
    public Mono<ResponseEntity<ResponseWrapper<WorkItemDTO>>>fillNotCompletedNumByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(fillNotCompletedNumByProjectId(projectId, item)));
        else
            rt.set(fillNotCompletedNumByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_not_completed_num 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO fillNotCompletedNumByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.fillNotCompletedNum(domain);
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
    * @return Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工作项" },  notes = "WorkItem-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_detail-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_bi_detail')")
    @PostMapping("work_items/fetch_bi_detail")
    public Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>> fetchBiDetail
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiDetail(context) ;
        List<WorkItemBiSearchGroupDTO> list = workItemBiSearchGroupDtoMapping.toDto(domains.getContent());
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
    * 查询fetch_choose 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose", tags = {"工作项" },  notes = "WorkItem-fetch_choose ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_choose')")
    @PostMapping("work_items/fetch_choose")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChoose
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChoose(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
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
    * 查询fetch_choose_parent_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_parent_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_choose_parent_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_parent_work_item-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_choose_parent_work_item')")
    @PostMapping("work_items/fetch_choose_parent_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseParentWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseParentWorkItem(context) ;
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
    * 查询fetch_idea_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_idea_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_idea_relation_work_item-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_idea_relation_work_item')")
    @PostMapping("work_items/fetch_idea_relation_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchIdeaRelationWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchIdeaRelationWorkItem(context) ;
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
    * 查询fetch_my_summary_bug 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_bug", tags = {"工作项" },  notes = "WorkItem-fetch_my_summary_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_summary_bug-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_my_summary_bug')")
    @PostMapping("work_items/fetch_my_summary_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMySummaryBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMySummaryBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_other 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_other", tags = {"工作项" },  notes = "WorkItem-fetch_my_summary_other ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_summary_other-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_my_summary_other')")
    @PostMapping("work_items/fetch_my_summary_other")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMySummaryOther
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMySummaryOther(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_task 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_task", tags = {"工作项" },  notes = "WorkItem-fetch_my_summary_task ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_summary_task-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_my_summary_task')")
    @PostMapping("work_items/fetch_my_summary_task")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMySummaryTask
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMySummaryTask(context) ;
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
    * 查询fetch_no_completed 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_completed", tags = {"工作项" },  notes = "WorkItem-fetch_no_completed ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_no_completed-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_no_completed')")
    @PostMapping("work_items/fetch_no_completed")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchNoCompleted
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNoCompleted(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
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
    * 查询fetch_overdue_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_overdue_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_overdue_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_overdue_work_item-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_overdue_work_item')")
    @PostMapping("work_items/fetch_overdue_work_item")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchOverdueWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchOverdueWorkItem(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
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
    * 查询fetch_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_relation_work_item-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_relation_work_item')")
    @PostMapping("work_items/fetch_relation_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchRelationWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRelationWorkItem(context) ;
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
    * @return Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"工作项" },  notes = "WorkItem-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bi_detail-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_bi_detail')")
    @PostMapping("projects/{projectId}/work_items/fetch_bi_detail")
    public Mono<ResponseEntity<List<WorkItemBiSearchGroupDTO>>> fetchBiDetailByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchBiDetail(context) ;
        List<WorkItemBiSearchGroupDTO> list = workItemBiSearchGroupDtoMapping.toDto(domains.getContent());
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
    * 查询fetch_choose 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose", tags = {"工作项" },  notes = "WorkItem-fetch_choose ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_choose')")
    @PostMapping("projects/{projectId}/work_items/fetch_choose")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChoose(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
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
    * 查询fetch_choose_parent_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_parent_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_choose_parent_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_parent_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_choose_parent_work_item')")
    @PostMapping("projects/{projectId}/work_items/fetch_choose_parent_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchChooseParentWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchChooseParentWorkItem(context) ;
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
    * 查询fetch_idea_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_idea_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_idea_relation_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_idea_relation_work_item')")
    @PostMapping("projects/{projectId}/work_items/fetch_idea_relation_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchIdeaRelationWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchIdeaRelationWorkItem(context) ;
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
    * 查询fetch_my_summary_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_bug", tags = {"工作项" },  notes = "WorkItem-fetch_my_summary_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_summary_bug-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_my_summary_bug')")
    @PostMapping("projects/{projectId}/work_items/fetch_my_summary_bug")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMySummaryBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMySummaryBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_other 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_other", tags = {"工作项" },  notes = "WorkItem-fetch_my_summary_other ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_summary_other-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_my_summary_other')")
    @PostMapping("projects/{projectId}/work_items/fetch_my_summary_other")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMySummaryOtherByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMySummaryOther(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_task 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_task", tags = {"工作项" },  notes = "WorkItem-fetch_my_summary_task ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_my_summary_task-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_my_summary_task')")
    @PostMapping("projects/{projectId}/work_items/fetch_my_summary_task")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchMySummaryTaskByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchMySummaryTask(context) ;
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
    * 查询fetch_no_completed 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_completed", tags = {"工作项" },  notes = "WorkItem-fetch_no_completed ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_no_completed-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_no_completed')")
    @PostMapping("projects/{projectId}/work_items/fetch_no_completed")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchNoCompletedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchNoCompleted(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
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
    * 查询fetch_overdue_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemUsuallyDTO>>>
    */
    @ApiOperation(value = "查询fetch_overdue_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_overdue_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_overdue_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_overdue_work_item')")
    @PostMapping("projects/{projectId}/work_items/fetch_overdue_work_item")
    public Mono<ResponseEntity<List<WorkItemUsuallyDTO>>> fetchOverdueWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchOverdueWorkItem(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
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
    * 查询fetch_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<WorkItemDTO>>>
    */
    @ApiOperation(value = "查询fetch_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_relation_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_relation_work_item')")
    @PostMapping("projects/{projectId}/work_items/fetch_relation_work_item")
    public Mono<ResponseEntity<List<WorkItemDTO>>> fetchRelationWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.fetchRelationWorkItem(context) ;
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
