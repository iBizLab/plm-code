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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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
    public WorkItemDTOMapping workItemDtoMapping;

    @Autowired
    @Lazy
    public WorkItemFilterDTOMapping workItemFilterDtoMapping;

    @Autowired
    @Lazy
    public WorkItemassigneeDTOMapping workItemassigneeDtoMapping;

    @Autowired
    @Lazy
    public WorkItemusuallyDTOMapping workItemusuallyDtoMapping;

    /**
    * 创建Create 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项" },  notes = "WorkItem-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Create-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Create')")
    @PostMapping("work_items")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> create
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"工作项" },  notes = "WorkItem-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Update-all') or hasPermission(this.workItemService.get(#id),'ibizplm-WorkItem-Update')")
    @VersionCheck(entity = "workitem" , versionfield = "updateTime")
    @PutMapping("work_items/{id}")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Activate 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Activate", tags = {"工作项" },  notes = "WorkItem-Activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Activate-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Activate')")
    @PostMapping("work_items/{id}/activate")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Activate 工作项
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
    * Archive 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Archive", tags = {"工作项" },  notes = "WorkItem-Archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Archive-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Archive')")
    @PostMapping("work_items/{id}/archive")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Archive 工作项
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
    * Change_assignee 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Change_assignee", tags = {"工作项" },  notes = "WorkItem-Change_assignee ")
    @PostMapping("work_items/{id}/change_assignee")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> changeAssigneeById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAssigneeById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAssigneeById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_assignee 工作项
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
    * Change_parent 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Change_parent", tags = {"工作项" },  notes = "WorkItem-Change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Change_parent-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Change_parent')")
    @PostMapping("work_items/{id}/change_parent")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> changeParentById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeParentById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeParentById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_parent 工作项
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
    * Change_state 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Change_state", tags = {"工作项" },  notes = "WorkItem-Change_state ")
    @PostMapping("work_items/{id}/change_state")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> changeStateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_state 工作项
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
    * Change_time 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Change_time", tags = {"工作项" },  notes = "WorkItem-Change_time ")
    @PostMapping("work_items/{id}/change_time")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> changeTimeById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeTimeById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeTimeById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_time 工作项
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
    * Child_del_relation 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Child_del_relation", tags = {"工作项" },  notes = "WorkItem-Child_del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Child_del_relation-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Child_del_relation')")
    @PostMapping("work_items/{id}/child_del_relation")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> childDelRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(childDelRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(childDelRelationById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Child_del_relation 工作项
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
    * Choose_child 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Choose_child", tags = {"工作项" },  notes = "WorkItem-Choose_child ")
    @PostMapping("work_items/{id}/choose_child")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> chooseChildById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseChildById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseChildById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Choose_child 工作项
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
    * Copy 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Copy", tags = {"工作项" },  notes = "WorkItem-Copy ")
    @PostMapping("work_items/{id}/copy")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> copyById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Copy 工作项
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
    * Del_relation 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"工作项" },  notes = "WorkItem-Del_relation ")
    @PostMapping("work_items/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO delRelationById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.delRelation(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * Delete 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Delete", tags = {"工作项" },  notes = "WorkItem-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Delete-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Delete')")
    @PostMapping("work_items/{id}/delete")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 工作项
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
    * Move_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Move_work_item", tags = {"工作项" },  notes = "WorkItem-Move_work_item ")
    @PostMapping("work_items/move_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> moveWorkItem
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(moveWorkItem(item)));
        else
            rt.set(moveWorkItem(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Move_work_item 工作项
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
    * Others_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Others_relation_work_item", tags = {"工作项" },  notes = "WorkItem-Others_relation_work_item ")
    @PostMapping("work_items/others_relation_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> othersRelationWorkItem
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(othersRelationWorkItem(item)));
        else
            rt.set(othersRelationWorkItem(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Others_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO othersRelationWorkItem
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.othersRelationWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * Plan_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Plan_work_item", tags = {"工作项" },  notes = "WorkItem-Plan_work_item ")
    @PostMapping("work_items/plan_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> planWorkItem
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(planWorkItem(item)));
        else
            rt.set(planWorkItem(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Plan_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO planWorkItem
            (WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.planWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * Recover 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Recover", tags = {"工作项" },  notes = "WorkItem-Recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Recover-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Recover')")
    @PostMapping("work_items/{id}/recover")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Recover 工作项
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
    * 保存Save 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项" },  notes = "WorkItem-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Save-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Save')")
    @PostMapping("work_items/save")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> save
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Set_default_entry 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Set_default_entry", tags = {"工作项" },  notes = "WorkItem-Set_default_entry ")
    @PostMapping("work_items/set_default_entry")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> setDefaultEntry
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setDefaultEntry(item)));
        else
            rt.set(setDefaultEntry(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_default_entry 工作项
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
    * Set_type_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Set_type_bug", tags = {"工作项" },  notes = "WorkItem-Set_type_bug ")
    @PostMapping("work_items/set_type_bug")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> setTypeBug
            (@Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setTypeBug(item)));
        else
            rt.set(setTypeBug(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_type_bug 工作项
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
    * Shift_in_kanban 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Shift_in_kanban", tags = {"工作项" },  notes = "WorkItem-Shift_in_kanban ")
    @PostMapping("work_items/{id}/shift_in_kanban")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> shiftInKanbanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInKanbanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInKanbanById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Shift_in_kanban 工作项
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
    * Shift_in_sprint 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Shift_in_sprint", tags = {"工作项" },  notes = "WorkItem-Shift_in_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Shift_in_sprint-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Shift_in_sprint')")
    @PostMapping("work_items/{id}/shift_in_sprint")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> shiftInSprintById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInSprintById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInSprintById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Shift_in_sprint 工作项
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
    * Shift_in_version 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Shift_in_version", tags = {"工作项" },  notes = "WorkItem-Shift_in_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Shift_in_version-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Shift_in_version')")
    @PostMapping("work_items/{id}/shift_in_version")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> shiftInVersionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInVersionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInVersionById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Shift_in_version 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInVersionById
            (String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInVersion(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * Work_item_re_counters 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Work_item_re_counters", tags = {"工作项" },  notes = "WorkItem-Work_item_re_counters ")
    @PostMapping("work_items/{id}/work_item_re_counters")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> workItemReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReCountersById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Work_item_re_counters 工作项
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
    * Work_item_test_plan_project 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Work_item_test_plan_project", tags = {"工作项" },  notes = "WorkItem-Work_item_test_plan_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Work_item_test_plan_project-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Work_item_test_plan_project')")
    @PostMapping("work_items/{id}/work_item_test_plan_project")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> workItemTestPlanProjectById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemTestPlanProjectById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemTestPlanProjectById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Work_item_test_plan_project 工作项
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项" },  notes = "WorkItem-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Create-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Create')")
    @PostMapping("projects/{projectId}/work_items")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"工作项" },  notes = "WorkItem-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Update-all') or hasPermission('Project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Update')")
    @VersionCheck(entity = "workitem" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/work_items/{id}")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Activate 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Activate", tags = {"工作项" },  notes = "WorkItem-Activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Activate-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Activate')")
    @PostMapping("projects/{projectId}/work_items/{id}/activate")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> activateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Activate 工作项
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
    * Archive 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Archive", tags = {"工作项" },  notes = "WorkItem-Archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Archive-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Archive')")
    @PostMapping("projects/{projectId}/work_items/{id}/archive")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> archiveByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Archive 工作项
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
    * Change_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Change_assignee", tags = {"工作项" },  notes = "WorkItem-Change_assignee ")
    @PostMapping("projects/{projectId}/work_items/{id}/change_assignee")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> changeAssigneeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeAssigneeByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeAssigneeByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_assignee 工作项
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
    * Change_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Change_parent", tags = {"工作项" },  notes = "WorkItem-Change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Change_parent-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Change_parent')")
    @PostMapping("projects/{projectId}/work_items/{id}/change_parent")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> changeParentByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeParentByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeParentByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_parent 工作项
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
    * Change_state 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Change_state", tags = {"工作项" },  notes = "WorkItem-Change_state ")
    @PostMapping("projects/{projectId}/work_items/{id}/change_state")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> changeStateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_state 工作项
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
    * Change_time 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Change_time", tags = {"工作项" },  notes = "WorkItem-Change_time ")
    @PostMapping("projects/{projectId}/work_items/{id}/change_time")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> changeTimeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeTimeByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeTimeByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_time 工作项
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
    * Child_del_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Child_del_relation", tags = {"工作项" },  notes = "WorkItem-Child_del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Child_del_relation-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Child_del_relation')")
    @PostMapping("projects/{projectId}/work_items/{id}/child_del_relation")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> childDelRelationByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(childDelRelationByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(childDelRelationByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Child_del_relation 工作项
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
    * Choose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Choose_child", tags = {"工作项" },  notes = "WorkItem-Choose_child ")
    @PostMapping("projects/{projectId}/work_items/{id}/choose_child")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> chooseChildByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(chooseChildByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(chooseChildByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Choose_child 工作项
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
    * Copy 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Copy", tags = {"工作项" },  notes = "WorkItem-Copy ")
    @PostMapping("projects/{projectId}/work_items/{id}/copy")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> copyByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Copy 工作项
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
    * Del_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"工作项" },  notes = "WorkItem-Del_relation ")
    @PostMapping("projects/{projectId}/work_items/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> delRelationByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO delRelationByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.delRelation(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * Delete 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Delete", tags = {"工作项" },  notes = "WorkItem-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Delete-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Delete')")
    @PostMapping("projects/{projectId}/work_items/{id}/delete")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> deleteByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 工作项
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
    * Move_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Move_work_item", tags = {"工作项" },  notes = "WorkItem-Move_work_item ")
    @PostMapping("projects/{projectId}/work_items/move_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> moveWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(moveWorkItemByProjectId(projectId, item)));
        else
            rt.set(moveWorkItemByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Move_work_item 工作项
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
    * Others_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Others_relation_work_item", tags = {"工作项" },  notes = "WorkItem-Others_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/others_relation_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> othersRelationWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(othersRelationWorkItemByProjectId(projectId, item)));
        else
            rt.set(othersRelationWorkItemByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Others_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO othersRelationWorkItemByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.othersRelationWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * Plan_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Plan_work_item", tags = {"工作项" },  notes = "WorkItem-Plan_work_item ")
    @PostMapping("projects/{projectId}/work_items/plan_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> planWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(planWorkItemByProjectId(projectId, item)));
        else
            rt.set(planWorkItemByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Plan_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO planWorkItemByProjectId
            (String projectId, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.planWorkItem(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * Recover 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Recover", tags = {"工作项" },  notes = "WorkItem-Recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Recover-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Recover')")
    @PostMapping("projects/{projectId}/work_items/{id}/recover")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> recoverByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Recover 工作项
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
    * 保存Save 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项" },  notes = "WorkItem-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Save-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Save')")
    @PostMapping("projects/{projectId}/work_items/save")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Set_default_entry 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Set_default_entry", tags = {"工作项" },  notes = "WorkItem-Set_default_entry ")
    @PostMapping("projects/{projectId}/work_items/set_default_entry")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> setDefaultEntryByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setDefaultEntryByProjectId(projectId, item)));
        else
            rt.set(setDefaultEntryByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_default_entry 工作项
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
    * Set_type_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Set_type_bug", tags = {"工作项" },  notes = "WorkItem-Set_type_bug ")
    @PostMapping("projects/{projectId}/work_items/set_type_bug")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> setTypeBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(setTypeBugByProjectId(projectId, item)));
        else
            rt.set(setTypeBugByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_type_bug 工作项
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
    * Shift_in_kanban 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Shift_in_kanban", tags = {"工作项" },  notes = "WorkItem-Shift_in_kanban ")
    @PostMapping("projects/{projectId}/work_items/{id}/shift_in_kanban")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> shiftInKanbanByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInKanbanByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInKanbanByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Shift_in_kanban 工作项
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
    * Shift_in_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Shift_in_sprint", tags = {"工作项" },  notes = "WorkItem-Shift_in_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Shift_in_sprint-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Shift_in_sprint')")
    @PostMapping("projects/{projectId}/work_items/{id}/shift_in_sprint")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> shiftInSprintByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInSprintByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInSprintByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Shift_in_sprint 工作项
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
    * Shift_in_version 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Shift_in_version", tags = {"工作项" },  notes = "WorkItem-Shift_in_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Shift_in_version-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Shift_in_version')")
    @PostMapping("projects/{projectId}/work_items/{id}/shift_in_version")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> shiftInVersionByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(shiftInVersionByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(shiftInVersionByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Shift_in_version 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */   
    public WorkItemDTO shiftInVersionByProjectIdAndId
            (String projectId, String id, WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setId(id);
        WorkItem rt = workItemService.shiftInVersion(domain);
        return workItemDtoMapping.toDto(rt);
    }

    /**
    * Work_item_re_counters 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Work_item_re_counters", tags = {"工作项" },  notes = "WorkItem-Work_item_re_counters ")
    @PostMapping("projects/{projectId}/work_items/{id}/work_item_re_counters")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> workItemReCountersByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemReCountersByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemReCountersByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Work_item_re_counters 工作项
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
    * Work_item_test_plan_project 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Work_item_test_plan_project", tags = {"工作项" },  notes = "WorkItem-Work_item_test_plan_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Work_item_test_plan_project-all') or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Work_item_test_plan_project')")
    @PostMapping("projects/{projectId}/work_items/{id}/work_item_test_plan_project")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> workItemTestPlanProjectByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemTestPlanProjectByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemTestPlanProjectByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Work_item_test_plan_project 工作项
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"工作项" },  notes = "WorkItem-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get-all')  or hasPermission(this.workItemDtoMapping.toDomain(returnObject.body),'ibizplm-WorkItem-Get')")
    @GetMapping("work_items/{id}")
    public ResponseEntity<WorkItemDTO> getById
            (@PathVariable("id") String id) {
        WorkItem rt = workItemService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 工作项
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作项" },  notes = "WorkItem-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Remove-all') or hasPermission(this.workItemService.get(#id),'ibizplm-WorkItem-Remove')")
    @DeleteMapping("work_items/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = workItemService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作项" },  notes = "WorkItem-CheckKey ")
    @PostMapping("work_items/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        Integer rt = workItemService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项" },  notes = "WorkItem-GetDraft ")
    @GetMapping("work_items/getdraft")
    public ResponseEntity<WorkItemDTO> getDraft
            (@SpringQueryMap WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * Get_actual_workload 工作项
    * 
    *
    * @param id id
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Get_actual_workload", tags = {"工作项" },  notes = "WorkItem-Get_actual_workload ")
    @GetMapping("work_items/{id}/get_actual_workload")
    public ResponseEntity<WorkItemDTO> getActualWorkloadById
            (@PathVariable("id") String id) {
        WorkItem rt = workItemService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * Get_attention 工作项
    * 
    *
    * @param id id
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Get_attention", tags = {"工作项" },  notes = "WorkItem-Get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get_attention-all') or hasPermission(this.workItemService.get(#id),'ibizplm-WorkItem-Get_attention')")
    @GetMapping("work_items/{id}/get_attention")
    public ResponseEntity<WorkItemDTO> getAttentionById
            (@PathVariable("id") String id) {
        WorkItem rt = workItemService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchArchived 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchArchived", tags = {"工作项" },  notes = "WorkItem-FetchArchived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchArchived-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchArchived')")
    @PostMapping("work_items/fetcharchived")
    public ResponseEntity<List<WorkItemDTO>> fetchArchived
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchArchived(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchBug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchBug", tags = {"工作项" },  notes = "WorkItem-FetchBug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchBug-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchBug')")
    @PostMapping("work_items/fetchbug")
    public ResponseEntity<List<WorkItemDTO>> fetchBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchBug_state_group_grid 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchBug_state_group_grid", tags = {"工作项" },  notes = "WorkItem-FetchBug_state_group_grid ")
    @PostMapping("work_items/fetchbug_state_group_grid")
    public ResponseEntity<List<WorkItemDTO>> fetchBugStateGroupGrid
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchBugStateGroupGrid(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchChange_parent 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchChange_parent", tags = {"工作项" },  notes = "WorkItem-FetchChange_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchChange_parent-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchChange_parent')")
    @PostMapping("work_items/fetchchange_parent")
    public ResponseEntity<List<WorkItemDTO>> fetchChangeParent
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchChangeParent(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchChoose_child 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchChoose_child", tags = {"工作项" },  notes = "WorkItem-FetchChoose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchChoose_child-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchChoose_child')")
    @PostMapping("work_items/fetchchoose_child")
    public ResponseEntity<List<WorkItemDTO>> fetchChooseChild
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchChooseChild(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchComment_notify_assignee 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchComment_notify_assignee", tags = {"工作项" },  notes = "WorkItem-FetchComment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchComment_notify_assignee-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchComment_notify_assignee')")
    @PostMapping("work_items/fetchcomment_notify_assignee")
    public ResponseEntity<List<WorkItemassigneeDTO>> fetchCommentNotifyAssignee
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommentNotifyAssignee(context) ;
        List<WorkItemassigneeDTO> list = workItemassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchCommon 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemusuallyDTO>>
    */
    @ApiOperation(value = "查询FetchCommon", tags = {"工作项" },  notes = "WorkItem-FetchCommon ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchCommon-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchCommon')")
    @PostMapping("work_items/fetchcommon")
    public ResponseEntity<List<WorkItemusuallyDTO>> fetchCommon
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommon(context) ;
        List<WorkItemusuallyDTO> list = workItemusuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchCommon_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemusuallyDTO>>
    */
    @ApiOperation(value = "查询FetchCommon_bug", tags = {"工作项" },  notes = "WorkItem-FetchCommon_bug ")
    @PostMapping("work_items/fetchcommon_bug")
    public ResponseEntity<List<WorkItemusuallyDTO>> fetchCommonBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommonBug(context) ;
        List<WorkItemusuallyDTO> list = workItemusuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"工作项" },  notes = "WorkItem-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchDefault-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchDefault')")
    @PostMapping("work_items/fetchdefault")
    public ResponseEntity<List<WorkItemDTO>> fetchDefault
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchDefault(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDeleted 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"工作项" },  notes = "WorkItem-FetchDeleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchDeleted-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchDeleted')")
    @PostMapping("work_items/fetchdeleted")
    public ResponseEntity<List<WorkItemDTO>> fetchDeleted
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchDeleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchIdea_relation_work_item ")
    @PostMapping("work_items/fetchidea_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchIdeaRelationWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchIdeaRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMilestone 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMilestone", tags = {"工作项" },  notes = "WorkItem-FetchMilestone ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchMilestone-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchMilestone')")
    @PostMapping("work_items/fetchmilestone")
    public ResponseEntity<List<WorkItemDTO>> fetchMilestone
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMilestone(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assignee 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assignee", tags = {"工作项" },  notes = "WorkItem-FetchMy_assignee ")
    @PostMapping("work_items/fetchmy_assignee")
    public ResponseEntity<List<WorkItemDTO>> fetchMyAssignee
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyAssignee(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assignee_count 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assignee_count", tags = {"工作项" },  notes = "WorkItem-FetchMy_assignee_count ")
    @PostMapping("work_items/fetchmy_assignee_count")
    public ResponseEntity<List<WorkItemDTO>> fetchMyAssigneeCount
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyAssigneeCount(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_attention 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_attention", tags = {"工作项" },  notes = "WorkItem-FetchMy_attention ")
    @PostMapping("work_items/fetchmy_attention")
    public ResponseEntity<List<WorkItemDTO>> fetchMyAttention
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyAttention(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_created 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_created", tags = {"工作项" },  notes = "WorkItem-FetchMy_created ")
    @PostMapping("work_items/fetchmy_created")
    public ResponseEntity<List<WorkItemDTO>> fetchMyCreated
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyCreated(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_filter 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_filter", tags = {"工作项" },  notes = "WorkItem-FetchMy_filter ")
    @PostMapping("work_items/fetchmy_filter")
    public ResponseEntity<List<WorkItemDTO>> fetchMyFilter
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyFilter(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_todo 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_todo", tags = {"工作项" },  notes = "WorkItem-FetchMy_todo ")
    @PostMapping("work_items/fetchmy_todo")
    public ResponseEntity<List<WorkItemDTO>> fetchMyTodo
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyTodo(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNo_bug_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNo_bug_work_item", tags = {"工作项" },  notes = "WorkItem-FetchNo_bug_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchNo_bug_work_item-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchNo_bug_work_item')")
    @PostMapping("work_items/fetchno_bug_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchNoBugWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNoBugWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"工作项" },  notes = "WorkItem-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchNormal-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchNormal')")
    @PostMapping("work_items/fetchnormal")
    public ResponseEntity<List<WorkItemDTO>> fetchNormal
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNormal(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_exsists_bug_relation 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNot_exsists_bug_relation", tags = {"工作项" },  notes = "WorkItem-FetchNot_exsists_bug_relation ")
    @PostMapping("work_items/fetchnot_exsists_bug_relation")
    public ResponseEntity<List<WorkItemDTO>> fetchNotExsistsBugRelation
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNotExsistsBugRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_exsists_relation 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNot_exsists_relation", tags = {"工作项" },  notes = "WorkItem-FetchNot_exsists_relation ")
    @PostMapping("work_items/fetchnot_exsists_relation")
    public ResponseEntity<List<WorkItemDTO>> fetchNotExsistsRelation
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNotExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNotbug_exsists_relation 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNotbug_exsists_relation", tags = {"工作项" },  notes = "WorkItem-FetchNotbug_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchNotbug_exsists_relation-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchNotbug_exsists_relation')")
    @PostMapping("work_items/fetchnotbug_exsists_relation")
    public ResponseEntity<List<WorkItemDTO>> fetchNotbugExsistsRelation
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNotbugExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchOverview_chart 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchOverview_chart", tags = {"工作项" },  notes = "WorkItem-FetchOverview_chart ")
    @PostMapping("work_items/fetchoverview_chart")
    public ResponseEntity<List<WorkItemDTO>> fetchOverviewChart
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchOverviewChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchPlan 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchPlan", tags = {"工作项" },  notes = "WorkItem-FetchPlan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchPlan-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchPlan')")
    @PostMapping("work_items/fetchplan")
    public ResponseEntity<List<WorkItemDTO>> fetchPlan
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchPlan(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchProperty_distribution 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchProperty_distribution", tags = {"工作项" },  notes = "WorkItem-FetchProperty_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchProperty_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchProperty_distribution')")
    @PostMapping("work_items/fetchproperty_distribution")
    public ResponseEntity<List<WorkItemDTO>> fetchPropertyDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchPropertyDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_work_item", tags = {"工作项" },  notes = "WorkItem-FetchRecent_work_item ")
    @PostMapping("work_items/fetchrecent_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchRecentWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRecentWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRequirement 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchRequirement", tags = {"工作项" },  notes = "WorkItem-FetchRequirement ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchRequirement-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchRequirement')")
    @PostMapping("work_items/fetchrequirement")
    public ResponseEntity<List<WorkItemDTO>> fetchRequirement
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRequirement(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRun_relation_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchRun_relation_bug", tags = {"工作项" },  notes = "WorkItem-FetchRun_relation_bug ")
    @PostMapping("work_items/fetchrun_relation_bug")
    public ResponseEntity<List<WorkItemDTO>> fetchRunRelationBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRunRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRun_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchRun_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchRun_relation_work_item ")
    @PostMapping("work_items/fetchrun_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchRunRelationWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRunRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTest_case_relation_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTest_case_relation_bug", tags = {"工作项" },  notes = "WorkItem-FetchTest_case_relation_bug ")
    @PostMapping("work_items/fetchtest_case_relation_bug")
    public ResponseEntity<List<WorkItemDTO>> fetchTestCaseRelationBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTestCaseRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTest_case_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTest_case_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchTest_case_relation_work_item ")
    @PostMapping("work_items/fetchtest_case_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchTestCaseRelationWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTestCaseRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTest_plan_relation_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTest_plan_relation_bug", tags = {"工作项" },  notes = "WorkItem-FetchTest_plan_relation_bug ")
    @PostMapping("work_items/fetchtest_plan_relation_bug")
    public ResponseEntity<List<WorkItemDTO>> fetchTestPlanRelationBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTestPlanRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTicket_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTicket_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchTicket_relation_work_item ")
    @PostMapping("work_items/fetchticket_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchTicketRelationWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTicketRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTop 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTop", tags = {"工作项" },  notes = "WorkItem-FetchTop ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchTop-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchTop')")
    @PostMapping("work_items/fetchtop")
    public ResponseEntity<List<WorkItemDTO>> fetchTop
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTop(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTree_grid 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTree_grid", tags = {"工作项" },  notes = "WorkItem-FetchTree_grid ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchTree_grid-all') or hasPermission(#dto,'ibizplm-WorkItem-FetchTree_grid')")
    @PostMapping("work_items/fetchtree_grid")
    public ResponseEntity<List<WorkItemDTO>> fetchTreeGrid
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTreeGrid(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchUnder_work 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchUnder_work", tags = {"工作项" },  notes = "WorkItem-FetchUnder_work ")
    @PostMapping("work_items/fetchunder_work")
    public ResponseEntity<List<WorkItemDTO>> fetchUnderWork
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchUnderWork(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchWork_item_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchWork_item_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchWork_item_relation_work_item ")
    @PostMapping("work_items/fetchwork_item_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchWorkItemRelationWorkItem
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchWorkItemRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"工作项" },  notes = "WorkItem-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get-all')  or hasPermission('Project',#projectId,this.workItemDtoMapping.toDomain(returnObject.body),'ibizplm-WorkItem-Get')")
    @GetMapping("projects/{projectId}/work_items/{id}")
    public ResponseEntity<WorkItemDTO> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"工作项" },  notes = "WorkItem-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Remove-all') or hasPermission('Project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Remove')")
    @DeleteMapping("projects/{projectId}/work_items/{id}")
    public ResponseEntity<Boolean> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = workItemService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"工作项" },  notes = "WorkItem-CheckKey ")
    @PostMapping("projects/{projectId}/work_items/checkkey")
    public ResponseEntity<Integer> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Integer rt = workItemService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项" },  notes = "WorkItem-GetDraft ")
    @GetMapping("projects/{projectId}/work_items/getdraft")
    public ResponseEntity<WorkItemDTO> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * Get_actual_workload 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Get_actual_workload", tags = {"工作项" },  notes = "WorkItem-Get_actual_workload ")
    @GetMapping("projects/{projectId}/work_items/{id}/get_actual_workload")
    public ResponseEntity<WorkItemDTO> getActualWorkloadByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * Get_attention 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "Get_attention", tags = {"工作项" },  notes = "WorkItem-Get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get_attention-all') or hasPermission('Project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Get_attention')")
    @GetMapping("projects/{projectId}/work_items/{id}/get_attention")
    public ResponseEntity<WorkItemDTO> getAttentionByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchArchived 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchArchived", tags = {"工作项" },  notes = "WorkItem-FetchArchived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchArchived-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchArchived')")
    @PostMapping("projects/{projectId}/work_items/fetcharchived")
    public ResponseEntity<List<WorkItemDTO>> fetchArchivedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchArchived(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchBug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchBug", tags = {"工作项" },  notes = "WorkItem-FetchBug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchBug-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchBug')")
    @PostMapping("projects/{projectId}/work_items/fetchbug")
    public ResponseEntity<List<WorkItemDTO>> fetchBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchBug_state_group_grid 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchBug_state_group_grid", tags = {"工作项" },  notes = "WorkItem-FetchBug_state_group_grid ")
    @PostMapping("projects/{projectId}/work_items/fetchbug_state_group_grid")
    public ResponseEntity<List<WorkItemDTO>> fetchBugStateGroupGridByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchBugStateGroupGrid(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchChange_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchChange_parent", tags = {"工作项" },  notes = "WorkItem-FetchChange_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchChange_parent-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchChange_parent')")
    @PostMapping("projects/{projectId}/work_items/fetchchange_parent")
    public ResponseEntity<List<WorkItemDTO>> fetchChangeParentByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchChangeParent(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchChoose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchChoose_child", tags = {"工作项" },  notes = "WorkItem-FetchChoose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchChoose_child-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchChoose_child')")
    @PostMapping("projects/{projectId}/work_items/fetchchoose_child")
    public ResponseEntity<List<WorkItemDTO>> fetchChooseChildByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchChooseChild(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchComment_notify_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchComment_notify_assignee", tags = {"工作项" },  notes = "WorkItem-FetchComment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchComment_notify_assignee-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchComment_notify_assignee')")
    @PostMapping("projects/{projectId}/work_items/fetchcomment_notify_assignee")
    public ResponseEntity<List<WorkItemassigneeDTO>> fetchCommentNotifyAssigneeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommentNotifyAssignee(context) ;
        List<WorkItemassigneeDTO> list = workItemassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchCommon 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemusuallyDTO>>
    */
    @ApiOperation(value = "查询FetchCommon", tags = {"工作项" },  notes = "WorkItem-FetchCommon ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchCommon-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchCommon')")
    @PostMapping("projects/{projectId}/work_items/fetchcommon")
    public ResponseEntity<List<WorkItemusuallyDTO>> fetchCommonByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommon(context) ;
        List<WorkItemusuallyDTO> list = workItemusuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchCommon_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemusuallyDTO>>
    */
    @ApiOperation(value = "查询FetchCommon_bug", tags = {"工作项" },  notes = "WorkItem-FetchCommon_bug ")
    @PostMapping("projects/{projectId}/work_items/fetchcommon_bug")
    public ResponseEntity<List<WorkItemusuallyDTO>> fetchCommonBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommonBug(context) ;
        List<WorkItemusuallyDTO> list = workItemusuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"工作项" },  notes = "WorkItem-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchDefault-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchDefault')")
    @PostMapping("projects/{projectId}/work_items/fetchdefault")
    public ResponseEntity<List<WorkItemDTO>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchDefault(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDeleted 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"工作项" },  notes = "WorkItem-FetchDeleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchDeleted-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchDeleted')")
    @PostMapping("projects/{projectId}/work_items/fetchdeleted")
    public ResponseEntity<List<WorkItemDTO>> fetchDeletedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchDeleted(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchIdea_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetchidea_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchIdeaRelationWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchIdeaRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMilestone 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMilestone", tags = {"工作项" },  notes = "WorkItem-FetchMilestone ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchMilestone-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchMilestone')")
    @PostMapping("projects/{projectId}/work_items/fetchmilestone")
    public ResponseEntity<List<WorkItemDTO>> fetchMilestoneByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMilestone(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assignee", tags = {"工作项" },  notes = "WorkItem-FetchMy_assignee ")
    @PostMapping("projects/{projectId}/work_items/fetchmy_assignee")
    public ResponseEntity<List<WorkItemDTO>> fetchMyAssigneeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyAssignee(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assignee_count 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assignee_count", tags = {"工作项" },  notes = "WorkItem-FetchMy_assignee_count ")
    @PostMapping("projects/{projectId}/work_items/fetchmy_assignee_count")
    public ResponseEntity<List<WorkItemDTO>> fetchMyAssigneeCountByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyAssigneeCount(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_attention 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_attention", tags = {"工作项" },  notes = "WorkItem-FetchMy_attention ")
    @PostMapping("projects/{projectId}/work_items/fetchmy_attention")
    public ResponseEntity<List<WorkItemDTO>> fetchMyAttentionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyAttention(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_created 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_created", tags = {"工作项" },  notes = "WorkItem-FetchMy_created ")
    @PostMapping("projects/{projectId}/work_items/fetchmy_created")
    public ResponseEntity<List<WorkItemDTO>> fetchMyCreatedByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyCreated(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_filter 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_filter", tags = {"工作项" },  notes = "WorkItem-FetchMy_filter ")
    @PostMapping("projects/{projectId}/work_items/fetchmy_filter")
    public ResponseEntity<List<WorkItemDTO>> fetchMyFilterByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyFilter(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_todo 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchMy_todo", tags = {"工作项" },  notes = "WorkItem-FetchMy_todo ")
    @PostMapping("projects/{projectId}/work_items/fetchmy_todo")
    public ResponseEntity<List<WorkItemDTO>> fetchMyTodoByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchMyTodo(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNo_bug_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNo_bug_work_item", tags = {"工作项" },  notes = "WorkItem-FetchNo_bug_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchNo_bug_work_item-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchNo_bug_work_item')")
    @PostMapping("projects/{projectId}/work_items/fetchno_bug_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchNoBugWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNoBugWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"工作项" },  notes = "WorkItem-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchNormal-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchNormal')")
    @PostMapping("projects/{projectId}/work_items/fetchnormal")
    public ResponseEntity<List<WorkItemDTO>> fetchNormalByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNormal(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_exsists_bug_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNot_exsists_bug_relation", tags = {"工作项" },  notes = "WorkItem-FetchNot_exsists_bug_relation ")
    @PostMapping("projects/{projectId}/work_items/fetchnot_exsists_bug_relation")
    public ResponseEntity<List<WorkItemDTO>> fetchNotExsistsBugRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNotExsistsBugRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_exsists_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNot_exsists_relation", tags = {"工作项" },  notes = "WorkItem-FetchNot_exsists_relation ")
    @PostMapping("projects/{projectId}/work_items/fetchnot_exsists_relation")
    public ResponseEntity<List<WorkItemDTO>> fetchNotExsistsRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNotExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNotbug_exsists_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchNotbug_exsists_relation", tags = {"工作项" },  notes = "WorkItem-FetchNotbug_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchNotbug_exsists_relation-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchNotbug_exsists_relation')")
    @PostMapping("projects/{projectId}/work_items/fetchnotbug_exsists_relation")
    public ResponseEntity<List<WorkItemDTO>> fetchNotbugExsistsRelationByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNotbugExsistsRelation(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchOverview_chart 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchOverview_chart", tags = {"工作项" },  notes = "WorkItem-FetchOverview_chart ")
    @PostMapping("projects/{projectId}/work_items/fetchoverview_chart")
    public ResponseEntity<List<WorkItemDTO>> fetchOverviewChartByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchOverviewChart(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchPlan 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchPlan", tags = {"工作项" },  notes = "WorkItem-FetchPlan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchPlan-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchPlan')")
    @PostMapping("projects/{projectId}/work_items/fetchplan")
    public ResponseEntity<List<WorkItemDTO>> fetchPlanByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchPlan(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchProperty_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchProperty_distribution", tags = {"工作项" },  notes = "WorkItem-FetchProperty_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchProperty_distribution-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchProperty_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetchproperty_distribution")
    public ResponseEntity<List<WorkItemDTO>> fetchPropertyDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchPropertyDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_work_item", tags = {"工作项" },  notes = "WorkItem-FetchRecent_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetchrecent_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchRecentWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRecentWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRequirement 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchRequirement", tags = {"工作项" },  notes = "WorkItem-FetchRequirement ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchRequirement-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchRequirement')")
    @PostMapping("projects/{projectId}/work_items/fetchrequirement")
    public ResponseEntity<List<WorkItemDTO>> fetchRequirementByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRequirement(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRun_relation_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchRun_relation_bug", tags = {"工作项" },  notes = "WorkItem-FetchRun_relation_bug ")
    @PostMapping("projects/{projectId}/work_items/fetchrun_relation_bug")
    public ResponseEntity<List<WorkItemDTO>> fetchRunRelationBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRunRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRun_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchRun_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchRun_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetchrun_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchRunRelationWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRunRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTest_case_relation_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTest_case_relation_bug", tags = {"工作项" },  notes = "WorkItem-FetchTest_case_relation_bug ")
    @PostMapping("projects/{projectId}/work_items/fetchtest_case_relation_bug")
    public ResponseEntity<List<WorkItemDTO>> fetchTestCaseRelationBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTestCaseRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTest_case_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTest_case_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchTest_case_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetchtest_case_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchTestCaseRelationWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTestCaseRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTest_plan_relation_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTest_plan_relation_bug", tags = {"工作项" },  notes = "WorkItem-FetchTest_plan_relation_bug ")
    @PostMapping("projects/{projectId}/work_items/fetchtest_plan_relation_bug")
    public ResponseEntity<List<WorkItemDTO>> fetchTestPlanRelationBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTestPlanRelationBug(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTicket_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTicket_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchTicket_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetchticket_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchTicketRelationWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTicketRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTop 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTop", tags = {"工作项" },  notes = "WorkItem-FetchTop ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchTop-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchTop')")
    @PostMapping("projects/{projectId}/work_items/fetchtop")
    public ResponseEntity<List<WorkItemDTO>> fetchTopByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTop(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTree_grid 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchTree_grid", tags = {"工作项" },  notes = "WorkItem-FetchTree_grid ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-FetchTree_grid-all') or hasPermission('Project',#projectId,#dto,'ibizplm-WorkItem-FetchTree_grid')")
    @PostMapping("projects/{projectId}/work_items/fetchtree_grid")
    public ResponseEntity<List<WorkItemDTO>> fetchTreeGridByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTreeGrid(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchUnder_work 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchUnder_work", tags = {"工作项" },  notes = "WorkItem-FetchUnder_work ")
    @PostMapping("projects/{projectId}/work_items/fetchunder_work")
    public ResponseEntity<List<WorkItemDTO>> fetchUnderWorkByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchUnderWork(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchWork_item_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询FetchWork_item_relation_work_item", tags = {"工作项" },  notes = "WorkItem-FetchWork_item_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetchwork_item_relation_work_item")
    public ResponseEntity<List<WorkItemDTO>> fetchWorkItemRelationWorkItemByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchWorkItemRelationWorkItem(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建工作项
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Create-all')")
    @ApiOperation(value = "批量新建工作项", tags = {"工作项" },  notes = "批量新建工作项")
	@PostMapping("work_items/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WorkItemDTO> dtos) {
        workItemService.createBatch(workItemDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除工作项
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Remove-all')")
    @ApiOperation(value = "批量删除工作项", tags = {"工作项" },  notes = "批量删除工作项")
	@DeleteMapping("work_items/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        workItemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新工作项
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Update-all')")
    @ApiOperation(value = "批量更新工作项", tags = {"工作项" },  notes = "批量更新工作项")
	@PutMapping("work_items/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WorkItemDTO> dtos) {
        workItemService.updateBatch(workItemDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存工作项
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Save-all')")
    @ApiOperation(value = "批量保存工作项", tags = {"工作项" },  notes = "批量保存工作项")
	@PostMapping("work_items/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WorkItemDTO> dtos) {
        workItemService.saveBatch(workItemDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入工作项
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-WorkItem-Save-all')")
    @ApiOperation(value = "批量导入工作项", tags = {"工作项" },  notes = "批量导入工作项")
	@PostMapping("work_items/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<WorkItemDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(workItemService.importData(config,ignoreError,workItemDtoMapping.toDomain(dtos)));
    }

}
