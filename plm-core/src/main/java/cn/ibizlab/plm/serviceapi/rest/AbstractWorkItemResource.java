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
    public WorkItemAdvancedSearchDTOMapping workItemAdvancedSearchDtoMapping;

    @Autowired
    @Lazy
    public WorkItemAssigneeDTOMapping workItemAssigneeDtoMapping;

    @Autowired
    @Lazy
    public WorkItemChildDTOMapping workItemChildDtoMapping;

    @Autowired
    @Lazy
    public WorkItemDTOMapping workItemDtoMapping;

    @Autowired
    @Lazy
    public WorkItemFilterDTOMapping workItemFilterDtoMapping;

    @Autowired
    @Lazy
    public WorkItemUsuallyDTOMapping workItemUsuallyDtoMapping;

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
    * activate 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "activate", tags = {"工作项" },  notes = "WorkItem-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-activate-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-activate')")
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
    * 归档归档
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "archive", tags = {"工作项" },  notes = "WorkItem-archive 归档归档")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-archive-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-archive')")
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
    * archive 工作项
    * 归档归档
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
    * change_assignee 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "change_assignee", tags = {"工作项" },  notes = "WorkItem-change_assignee ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "change_parent", tags = {"工作项" },  notes = "WorkItem-change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-change_parent-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-change_parent')")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "change_state", tags = {"工作项" },  notes = "WorkItem-change_state ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "change_time", tags = {"工作项" },  notes = "WorkItem-change_time ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "child_del_relation", tags = {"工作项" },  notes = "WorkItem-child_del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-child_del_relation-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-child_del_relation')")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "choose_child", tags = {"工作项" },  notes = "WorkItem-choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-choose_child-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-choose_child')")
    @PutMapping("work_items/{id}/choose_child")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "copy", tags = {"工作项" },  notes = "WorkItem-copy ")
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
    * del_relation 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "del_relation", tags = {"工作项" },  notes = "WorkItem-del_relation ")
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
    * del_relation 工作项
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
    * delete 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "delete", tags = {"工作项" },  notes = "WorkItem-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-delete-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-delete')")
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
    * move_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "move_work_item", tags = {"工作项" },  notes = "WorkItem-move_work_item ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "others_relation_work_item", tags = {"工作项" },  notes = "WorkItem-others_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-others_relation_work_item-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-others_relation_work_item')")
    @PutMapping("work_items/{id}/others_relation_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> othersRelationWorkItemById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationWorkItemById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationWorkItemById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "plan_work_item", tags = {"工作项" },  notes = "WorkItem-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-plan_work_item-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-plan_work_item')")
    @PutMapping("work_items/{id}/plan_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> planWorkItemById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * recover 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "recover", tags = {"工作项" },  notes = "WorkItem-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-recover-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-recover')")
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
    * restore_version 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "restore_version", tags = {"工作项" },  notes = "WorkItem-restore_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-restore_version-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-restore_version')")
    @PostMapping("work_items/{id}/restore_version")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> restoreVersionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreVersionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreVersionById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * set_default_entry 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "set_default_entry", tags = {"工作项" },  notes = "WorkItem-set_default_entry ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "set_type_bug", tags = {"工作项" },  notes = "WorkItem-set_type_bug ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "shift_in_kanban", tags = {"工作项" },  notes = "WorkItem-shift_in_kanban ")
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
    * shift_in_sprint 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "shift_in_sprint", tags = {"工作项" },  notes = "WorkItem-shift_in_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_sprint-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_sprint')")
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
    * shift_in_version 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "shift_in_version", tags = {"工作项" },  notes = "WorkItem-shift_in_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_version-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_version')")
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
    * shift_in_version 工作项
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
    * work_item_re_counters 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "work_item_re_counters", tags = {"工作项" },  notes = "WorkItem-work_item_re_counters ")
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
    * work_item_test_plan_project 工作项
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "work_item_test_plan_project", tags = {"工作项" },  notes = "WorkItem-work_item_test_plan_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_test_plan_project-all') or hasPermission(this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_test_plan_project')")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"工作项" },  notes = "WorkItem-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Create-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Create')")
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
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Update-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Update')")
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
    * activate 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "activate", tags = {"工作项" },  notes = "WorkItem-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-activate-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-activate')")
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
    * 归档归档
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "archive", tags = {"工作项" },  notes = "WorkItem-archive 归档归档")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-archive-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-archive')")
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
    * archive 工作项
    * 归档归档
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
    * change_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "change_assignee", tags = {"工作项" },  notes = "WorkItem-change_assignee ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "change_parent", tags = {"工作项" },  notes = "WorkItem-change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-change_parent-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-change_parent')")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "change_state", tags = {"工作项" },  notes = "WorkItem-change_state ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "change_time", tags = {"工作项" },  notes = "WorkItem-change_time ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "child_del_relation", tags = {"工作项" },  notes = "WorkItem-child_del_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-child_del_relation-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-child_del_relation')")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "choose_child", tags = {"工作项" },  notes = "WorkItem-choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-choose_child-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-choose_child')")
    @PutMapping("projects/{projectId}/work_items/{id}/choose_child")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "copy", tags = {"工作项" },  notes = "WorkItem-copy ")
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
    * del_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "del_relation", tags = {"工作项" },  notes = "WorkItem-del_relation ")
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
    * del_relation 工作项
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
    * delete 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "delete", tags = {"工作项" },  notes = "WorkItem-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-delete-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-delete')")
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
    * move_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "move_work_item", tags = {"工作项" },  notes = "WorkItem-move_work_item ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "others_relation_work_item", tags = {"工作项" },  notes = "WorkItem-others_relation_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-others_relation_work_item-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-others_relation_work_item')")
    @PutMapping("projects/{projectId}/work_items/{id}/others_relation_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> othersRelationWorkItemByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationWorkItemByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationWorkItemByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "plan_work_item", tags = {"工作项" },  notes = "WorkItem-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-plan_work_item-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-plan_work_item')")
    @PutMapping("projects/{projectId}/work_items/{id}/plan_work_item")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> planWorkItemByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * recover 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "recover", tags = {"工作项" },  notes = "WorkItem-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-recover-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-recover')")
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
    * restore_version 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "restore_version", tags = {"工作项" },  notes = "WorkItem-restore_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-restore_version-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-restore_version')")
    @PostMapping("projects/{projectId}/work_items/{id}/restore_version")
    public ResponseEntity<ResponseWrapper<WorkItemDTO>> restoreVersionByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<WorkItemDTO> dto) {
        ResponseWrapper<WorkItemDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(restoreVersionByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(restoreVersionByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"工作项" },  notes = "WorkItem-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Save-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-Save')")
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
    * set_default_entry 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "set_default_entry", tags = {"工作项" },  notes = "WorkItem-set_default_entry ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "set_type_bug", tags = {"工作项" },  notes = "WorkItem-set_type_bug ")
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
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "shift_in_kanban", tags = {"工作项" },  notes = "WorkItem-shift_in_kanban ")
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
    * shift_in_sprint 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "shift_in_sprint", tags = {"工作项" },  notes = "WorkItem-shift_in_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_sprint-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_sprint')")
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
    * shift_in_version 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "shift_in_version", tags = {"工作项" },  notes = "WorkItem-shift_in_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-shift_in_version-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-shift_in_version')")
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
    * shift_in_version 工作项
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
    * work_item_re_counters 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "work_item_re_counters", tags = {"工作项" },  notes = "WorkItem-work_item_re_counters ")
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
    * work_item_test_plan_project 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "work_item_test_plan_project", tags = {"工作项" },  notes = "WorkItem-work_item_test_plan_project ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-work_item_test_plan_project-all') or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(#dto),'ibizplm-WorkItem-work_item_test_plan_project')")
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
    @PostMapping("work_items/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        Integer rt = workItemService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_attention 工作项
    * 
    *
    * @param id id
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "get_attention", tags = {"工作项" },  notes = "WorkItem-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_attention-all') or hasPermission(this.workItemService.get(#id),'ibizplm-WorkItem-get_attention')")
    @GetMapping("work_items/{id}/get_attention")
    public ResponseEntity<WorkItemDTO> getAttentionById
            (@PathVariable("id") String id) {
        WorkItem rt = workItemService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"工作项" },  notes = "WorkItem-GetDraft ")
    @GetMapping("work_items/get_draft")
    public ResponseEntity<WorkItemDTO> getDraft
            (@SpringQueryMap WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        WorkItem rt = workItemService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_advanced_search 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemAdvancedSearchDTO>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工作项" },  notes = "WorkItem-fetch_advanced_search ")
    @PostMapping("work_items/fetch_advanced_search")
    public ResponseEntity<List<WorkItemAdvancedSearchDTO>> fetchAdvancedSearch
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchAdvancedSearch(context) ;
        List<WorkItemAdvancedSearchDTO> list = workItemAdvancedSearchDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_archived 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工作项" },  notes = "WorkItem-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_archived-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_archived')")
    @PostMapping("work_items/fetch_archived")
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
    * 查询fetch_backlog_property_distribution 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_backlog_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_property_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_backlog_property_distribution')")
    @PostMapping("work_items/fetch_backlog_property_distribution")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchBacklogPropertyDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchBacklogPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_backlog_state_distribution 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_backlog_state_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_state_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_state_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_backlog_state_distribution')")
    @PostMapping("work_items/fetch_backlog_state_distribution")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchBacklogStateDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchBacklogStateDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_bug", tags = {"工作项" },  notes = "WorkItem-fetch_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bug-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_bug')")
    @PostMapping("work_items/fetch_bug")
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
    * 查询fetch_bug_state_group_grid 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_bug_state_group_grid", tags = {"工作项" },  notes = "WorkItem-fetch_bug_state_group_grid ")
    @PostMapping("work_items/fetch_bug_state_group_grid")
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
    * 查询fetch_change_parent 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_change_parent", tags = {"工作项" },  notes = "WorkItem-fetch_change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_change_parent-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_change_parent')")
    @PostMapping("work_items/fetch_change_parent")
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
    * 查询fetch_child 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemChildDTO>>
    */
    @ApiOperation(value = "查询fetch_child", tags = {"工作项" },  notes = "WorkItem-fetch_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_child-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_child')")
    @PostMapping("work_items/fetch_child")
    public ResponseEntity<List<WorkItemChildDTO>> fetchChild
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchChild(context) ;
        List<WorkItemChildDTO> list = workItemChildDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_choose_child 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_choose_child", tags = {"工作项" },  notes = "WorkItem-fetch_choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_child-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_choose_child')")
    @PostMapping("work_items/fetch_choose_child")
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
    * 查询fetch_comment_notify_assignee 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemAssigneeDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_comment_notify_assignee-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_comment_notify_assignee')")
    @PostMapping("work_items/fetch_comment_notify_assignee")
    public ResponseEntity<List<WorkItemAssigneeDTO>> fetchCommentNotifyAssignee
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommentNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_common 工作项
    * 未删除
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工作项" },  notes = "WorkItem-fetch_common 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_common-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_common')")
    @PostMapping("work_items/fetch_common")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchCommon
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommon(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_common_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_common_bug", tags = {"工作项" },  notes = "WorkItem-fetch_common_bug ")
    @PostMapping("work_items/fetch_common_bug")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchCommonBug
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommonBug(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作项" },  notes = "WorkItem-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_default-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_default')")
    @PostMapping("work_items/fetch_default")
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
    * 查询fetch_defect_property_distribution 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_defect_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_defect_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_defect_property_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_defect_property_distribution')")
    @PostMapping("work_items/fetch_defect_property_distribution")
    public ResponseEntity<List<WorkItemDTO>> fetchDefectPropertyDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchDefectPropertyDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_deleted 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工作项" },  notes = "WorkItem-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_deleted-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_deleted')")
    @PostMapping("work_items/fetch_deleted")
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
    * 查询fetch_idea_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_idea_relation_work_item ")
    @PostMapping("work_items/fetch_idea_relation_work_item")
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
    * 查询fetch_kanban_user_stat 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_kanban_user_stat", tags = {"工作项" },  notes = "WorkItem-fetch_kanban_user_stat ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_kanban_user_stat-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_kanban_user_stat')")
    @PostMapping("work_items/fetch_kanban_user_stat")
    public ResponseEntity<List<WorkItemDTO>> fetchKanbanUserStat
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchKanbanUserStat(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_milestone 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_milestone", tags = {"工作项" },  notes = "WorkItem-fetch_milestone ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_milestone-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_milestone')")
    @PostMapping("work_items/fetch_milestone")
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
    * 查询fetch_my_assignee 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee ")
    @PostMapping("work_items/fetch_my_assignee")
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
    * 查询fetch_my_assignee_count 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee_count ")
    @PostMapping("work_items/fetch_my_assignee_count")
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
    * 查询fetch_my_attention 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工作项" },  notes = "WorkItem-fetch_my_attention ")
    @PostMapping("work_items/fetch_my_attention")
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
    * 查询fetch_my_created 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工作项" },  notes = "WorkItem-fetch_my_created ")
    @PostMapping("work_items/fetch_my_created")
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
    * 查询fetch_my_filter 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"工作项" },  notes = "WorkItem-fetch_my_filter ")
    @PostMapping("work_items/fetch_my_filter")
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
    * 查询fetch_my_todo 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_todo", tags = {"工作项" },  notes = "WorkItem-fetch_my_todo ")
    @PostMapping("work_items/fetch_my_todo")
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
    * 查询fetch_no_bug_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_no_bug_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_no_bug_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_no_bug_work_item-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_no_bug_work_item')")
    @PostMapping("work_items/fetch_no_bug_work_item")
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
    * 查询fetch_normal 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工作项" },  notes = "WorkItem-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_normal-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_normal')")
    @PostMapping("work_items/fetch_normal")
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
    * 查询fetch_not_exsists_bug_relation 工作项
    * 仅缺陷
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_bug_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_bug_relation 仅缺陷")
    @PostMapping("work_items/fetch_not_exsists_bug_relation")
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
    * 查询fetch_not_exsists_relation 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_relation ")
    @PostMapping("work_items/fetch_not_exsists_relation")
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
    * 查询fetch_notbug_exsists_relation 工作项
    * 未关联且不为缺陷工作项
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_notbug_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_notbug_exsists_relation 未关联且不为缺陷工作项")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notbug_exsists_relation-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_notbug_exsists_relation')")
    @PostMapping("work_items/fetch_notbug_exsists_relation")
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
    * 查询fetch_notify_assignee 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemAssigneeDTO>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notify_assignee-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_notify_assignee')")
    @PostMapping("work_items/fetch_notify_assignee")
    public ResponseEntity<List<WorkItemAssigneeDTO>> fetchNotifyAssignee
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_overview_chart 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_overview_chart", tags = {"工作项" },  notes = "WorkItem-fetch_overview_chart ")
    @PostMapping("work_items/fetch_overview_chart")
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
    * 查询fetch_plan 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_plan", tags = {"工作项" },  notes = "WorkItem-fetch_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_plan-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_plan')")
    @PostMapping("work_items/fetch_plan")
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
    * 查询fetch_property_distribution 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_property_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_property_distribution')")
    @PostMapping("work_items/fetch_property_distribution")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchPropertyDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_recent_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_recent_work_item ")
    @PostMapping("work_items/fetch_recent_work_item")
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
    * 查询fetch_requirement 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_requirement", tags = {"工作项" },  notes = "WorkItem-fetch_requirement ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_requirement')")
    @PostMapping("work_items/fetch_requirement")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchRequirement
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRequirement(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_requirement_tree 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_requirement_tree", tags = {"工作项" },  notes = "WorkItem-fetch_requirement_tree ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement_tree-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_requirement_tree')")
    @PostMapping("work_items/fetch_requirement_tree")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchRequirementTree
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRequirementTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_resource_assignment 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_resource_assignment", tags = {"工作项" },  notes = "WorkItem-fetch_resource_assignment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_resource_assignment-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_resource_assignment')")
    @PostMapping("work_items/fetch_resource_assignment")
    public ResponseEntity<List<WorkItemDTO>> fetchResourceAssignment
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchResourceAssignment(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_run_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_run_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_run_relation_work_item ")
    @PostMapping("work_items/fetch_run_relation_work_item")
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
    * 查询fetch_sprint_user_stat 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_sprint_user_stat", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_user_stat ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_user_stat-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_sprint_user_stat')")
    @PostMapping("work_items/fetch_sprint_user_stat")
    public ResponseEntity<List<WorkItemDTO>> fetchSprintUserStat
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchSprintUserStat(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_temp_speed_report 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_temp_speed_report", tags = {"工作项" },  notes = "WorkItem-fetch_temp_speed_report ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_temp_speed_report-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_temp_speed_report')")
    @PostMapping("work_items/fetch_temp_speed_report")
    public ResponseEntity<List<WorkItemDTO>> fetchTempSpeedReport
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTempSpeedReport(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_test_case_relation_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_test_case_relation_bug", tags = {"工作项" },  notes = "WorkItem-fetch_test_case_relation_bug ")
    @PostMapping("work_items/fetch_test_case_relation_bug")
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
    * 查询fetch_test_case_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_test_case_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_test_case_relation_work_item ")
    @PostMapping("work_items/fetch_test_case_relation_work_item")
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
    * 查询fetch_test_plan_relation_bug 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_test_plan_relation_bug", tags = {"工作项" },  notes = "WorkItem-fetch_test_plan_relation_bug ")
    @PostMapping("work_items/fetch_test_plan_relation_bug")
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
    * 查询fetch_ticket_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_ticket_relation_work_item ")
    @PostMapping("work_items/fetch_ticket_relation_work_item")
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
    * 查询fetch_top 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_top", tags = {"工作项" },  notes = "WorkItem-fetch_top ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_top-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_top')")
    @PostMapping("work_items/fetch_top")
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
    * 查询fetch_tree_tile_grid_query 工作项
    * 未删除
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_tree_tile_grid_query", tags = {"工作项" },  notes = "WorkItem-fetch_tree_tile_grid_query 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_tree_tile_grid_query-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_tree_tile_grid_query')")
    @PostMapping("work_items/fetch_tree_tile_grid_query")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchTreeTileGridQuery
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTreeTileGridQuery(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_under_work 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_under_work", tags = {"工作项" },  notes = "WorkItem-fetch_under_work ")
    @PostMapping("work_items/fetch_under_work")
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
    * 查询fetch_work_item_distribution 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_work_item_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_work_item_distribution-all') or hasPermission(#dto,'ibizplm-WorkItem-fetch_work_item_distribution')")
    @PostMapping("work_items/fetch_work_item_distribution")
    public ResponseEntity<List<WorkItemDTO>> fetchWorkItemDistribution
            (@Validated @RequestBody WorkItemFilterDTO dto) {
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchWorkItemDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_relation_work_item 工作项
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_work_item_relation_work_item ")
    @PostMapping("work_items/fetch_work_item_relation_work_item")
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
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Get-all')  or hasPermission('project',#projectId,this.workItemDtoMapping.toDomain(returnObject.body),'ibizplm-WorkItem-Get')")
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
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-Remove-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-Remove')")
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
    @PostMapping("projects/{projectId}/work_items/check_key")
    public ResponseEntity<Integer> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Integer rt = workItemService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_attention 工作项
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<WorkItemDTO>
    */
    @ApiOperation(value = "get_attention", tags = {"工作项" },  notes = "WorkItem-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-get_attention-all') or hasPermission('project',#projectId,this.workItemService.get(#id),'ibizplm-WorkItem-get_attention')")
    @GetMapping("projects/{projectId}/work_items/{id}/get_attention")
    public ResponseEntity<WorkItemDTO> getAttentionByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        WorkItem rt = workItemService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
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
    @GetMapping("projects/{projectId}/work_items/get_draft")
    public ResponseEntity<WorkItemDTO> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap WorkItemDTO dto) {
        WorkItem domain = workItemDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        WorkItem rt = workItemService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(workItemDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_advanced_search 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemAdvancedSearchDTO>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"工作项" },  notes = "WorkItem-fetch_advanced_search ")
    @PostMapping("projects/{projectId}/work_items/fetch_advanced_search")
    public ResponseEntity<List<WorkItemAdvancedSearchDTO>> fetchAdvancedSearchByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchAdvancedSearch(context) ;
        List<WorkItemAdvancedSearchDTO> list = workItemAdvancedSearchDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_archived 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"工作项" },  notes = "WorkItem-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_archived-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_archived')")
    @PostMapping("projects/{projectId}/work_items/fetch_archived")
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
    * 查询fetch_backlog_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_backlog_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_backlog_property_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_backlog_property_distribution")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchBacklogPropertyDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchBacklogPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_backlog_state_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_backlog_state_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_backlog_state_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_backlog_state_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_backlog_state_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_backlog_state_distribution")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchBacklogStateDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchBacklogStateDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_bug", tags = {"工作项" },  notes = "WorkItem-fetch_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_bug-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_bug')")
    @PostMapping("projects/{projectId}/work_items/fetch_bug")
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
    * 查询fetch_bug_state_group_grid 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_bug_state_group_grid", tags = {"工作项" },  notes = "WorkItem-fetch_bug_state_group_grid ")
    @PostMapping("projects/{projectId}/work_items/fetch_bug_state_group_grid")
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
    * 查询fetch_change_parent 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_change_parent", tags = {"工作项" },  notes = "WorkItem-fetch_change_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_change_parent-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_change_parent')")
    @PostMapping("projects/{projectId}/work_items/fetch_change_parent")
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
    * 查询fetch_child 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemChildDTO>>
    */
    @ApiOperation(value = "查询fetch_child", tags = {"工作项" },  notes = "WorkItem-fetch_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_child-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_child')")
    @PostMapping("projects/{projectId}/work_items/fetch_child")
    public ResponseEntity<List<WorkItemChildDTO>> fetchChildByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchChild(context) ;
        List<WorkItemChildDTO> list = workItemChildDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_choose_child 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_choose_child", tags = {"工作项" },  notes = "WorkItem-fetch_choose_child ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_choose_child-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_choose_child')")
    @PostMapping("projects/{projectId}/work_items/fetch_choose_child")
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
    * 查询fetch_comment_notify_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemAssigneeDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_comment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_comment_notify_assignee-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_comment_notify_assignee')")
    @PostMapping("projects/{projectId}/work_items/fetch_comment_notify_assignee")
    public ResponseEntity<List<WorkItemAssigneeDTO>> fetchCommentNotifyAssigneeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommentNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_common 工作项
    * 未删除
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"工作项" },  notes = "WorkItem-fetch_common 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_common-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_common')")
    @PostMapping("projects/{projectId}/work_items/fetch_common")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchCommonByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommon(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_common_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_common_bug", tags = {"工作项" },  notes = "WorkItem-fetch_common_bug ")
    @PostMapping("projects/{projectId}/work_items/fetch_common_bug")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchCommonBugByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchCommonBug(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"工作项" },  notes = "WorkItem-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_default')")
    @PostMapping("projects/{projectId}/work_items/fetch_default")
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
    * 查询fetch_defect_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_defect_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_defect_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_defect_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_defect_property_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_defect_property_distribution")
    public ResponseEntity<List<WorkItemDTO>> fetchDefectPropertyDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchDefectPropertyDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_deleted 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"工作项" },  notes = "WorkItem-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_deleted-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_deleted')")
    @PostMapping("projects/{projectId}/work_items/fetch_deleted")
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
    * 查询fetch_idea_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_idea_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetch_idea_relation_work_item")
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
    * 查询fetch_kanban_user_stat 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_kanban_user_stat", tags = {"工作项" },  notes = "WorkItem-fetch_kanban_user_stat ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_kanban_user_stat-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_kanban_user_stat')")
    @PostMapping("projects/{projectId}/work_items/fetch_kanban_user_stat")
    public ResponseEntity<List<WorkItemDTO>> fetchKanbanUserStatByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchKanbanUserStat(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_milestone 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_milestone", tags = {"工作项" },  notes = "WorkItem-fetch_milestone ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_milestone-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_milestone')")
    @PostMapping("projects/{projectId}/work_items/fetch_milestone")
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
    * 查询fetch_my_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_assignee")
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
    * 查询fetch_my_assignee_count 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"工作项" },  notes = "WorkItem-fetch_my_assignee_count ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_assignee_count")
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
    * 查询fetch_my_attention 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"工作项" },  notes = "WorkItem-fetch_my_attention ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_attention")
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
    * 查询fetch_my_created 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"工作项" },  notes = "WorkItem-fetch_my_created ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_created")
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
    * 查询fetch_my_filter 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"工作项" },  notes = "WorkItem-fetch_my_filter ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_filter")
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
    * 查询fetch_my_todo 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_my_todo", tags = {"工作项" },  notes = "WorkItem-fetch_my_todo ")
    @PostMapping("projects/{projectId}/work_items/fetch_my_todo")
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
    * 查询fetch_no_bug_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_no_bug_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_no_bug_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_no_bug_work_item-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_no_bug_work_item')")
    @PostMapping("projects/{projectId}/work_items/fetch_no_bug_work_item")
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
    * 查询fetch_normal 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"工作项" },  notes = "WorkItem-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_normal-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_normal')")
    @PostMapping("projects/{projectId}/work_items/fetch_normal")
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
    * 查询fetch_not_exsists_bug_relation 工作项
    * 仅缺陷
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_bug_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_bug_relation 仅缺陷")
    @PostMapping("projects/{projectId}/work_items/fetch_not_exsists_bug_relation")
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
    * 查询fetch_not_exsists_relation 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_not_exsists_relation ")
    @PostMapping("projects/{projectId}/work_items/fetch_not_exsists_relation")
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
    * 查询fetch_notbug_exsists_relation 工作项
    * 未关联且不为缺陷工作项
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_notbug_exsists_relation", tags = {"工作项" },  notes = "WorkItem-fetch_notbug_exsists_relation 未关联且不为缺陷工作项")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notbug_exsists_relation-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_notbug_exsists_relation')")
    @PostMapping("projects/{projectId}/work_items/fetch_notbug_exsists_relation")
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
    * 查询fetch_notify_assignee 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemAssigneeDTO>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"工作项" },  notes = "WorkItem-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_notify_assignee-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_notify_assignee')")
    @PostMapping("projects/{projectId}/work_items/fetch_notify_assignee")
    public ResponseEntity<List<WorkItemAssigneeDTO>> fetchNotifyAssigneeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchNotifyAssignee(context) ;
        List<WorkItemAssigneeDTO> list = workItemAssigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_overview_chart 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_overview_chart", tags = {"工作项" },  notes = "WorkItem-fetch_overview_chart ")
    @PostMapping("projects/{projectId}/work_items/fetch_overview_chart")
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
    * 查询fetch_plan 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_plan", tags = {"工作项" },  notes = "WorkItem-fetch_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_plan-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_plan')")
    @PostMapping("projects/{projectId}/work_items/fetch_plan")
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
    * 查询fetch_property_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_property_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_property_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_property_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_property_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_property_distribution")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchPropertyDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchPropertyDistribution(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_recent_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_recent_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_recent_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetch_recent_work_item")
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
    * 查询fetch_requirement 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_requirement", tags = {"工作项" },  notes = "WorkItem-fetch_requirement ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_requirement')")
    @PostMapping("projects/{projectId}/work_items/fetch_requirement")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchRequirementByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRequirement(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_requirement_tree 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_requirement_tree", tags = {"工作项" },  notes = "WorkItem-fetch_requirement_tree ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_requirement_tree-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_requirement_tree')")
    @PostMapping("projects/{projectId}/work_items/fetch_requirement_tree")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchRequirementTreeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchRequirementTree(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_resource_assignment 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_resource_assignment", tags = {"工作项" },  notes = "WorkItem-fetch_resource_assignment ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_resource_assignment-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_resource_assignment')")
    @PostMapping("projects/{projectId}/work_items/fetch_resource_assignment")
    public ResponseEntity<List<WorkItemDTO>> fetchResourceAssignmentByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchResourceAssignment(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_run_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_run_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_run_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetch_run_relation_work_item")
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
    * 查询fetch_sprint_user_stat 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_sprint_user_stat", tags = {"工作项" },  notes = "WorkItem-fetch_sprint_user_stat ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_sprint_user_stat-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_sprint_user_stat')")
    @PostMapping("projects/{projectId}/work_items/fetch_sprint_user_stat")
    public ResponseEntity<List<WorkItemDTO>> fetchSprintUserStatByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchSprintUserStat(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_temp_speed_report 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_temp_speed_report", tags = {"工作项" },  notes = "WorkItem-fetch_temp_speed_report ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_temp_speed_report-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_temp_speed_report')")
    @PostMapping("projects/{projectId}/work_items/fetch_temp_speed_report")
    public ResponseEntity<List<WorkItemDTO>> fetchTempSpeedReportByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTempSpeedReport(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_test_case_relation_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_test_case_relation_bug", tags = {"工作项" },  notes = "WorkItem-fetch_test_case_relation_bug ")
    @PostMapping("projects/{projectId}/work_items/fetch_test_case_relation_bug")
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
    * 查询fetch_test_case_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_test_case_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_test_case_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetch_test_case_relation_work_item")
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
    * 查询fetch_test_plan_relation_bug 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_test_plan_relation_bug", tags = {"工作项" },  notes = "WorkItem-fetch_test_plan_relation_bug ")
    @PostMapping("projects/{projectId}/work_items/fetch_test_plan_relation_bug")
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
    * 查询fetch_ticket_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_ticket_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetch_ticket_relation_work_item")
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
    * 查询fetch_top 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_top", tags = {"工作项" },  notes = "WorkItem-fetch_top ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_top-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_top')")
    @PostMapping("projects/{projectId}/work_items/fetch_top")
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
    * 查询fetch_tree_tile_grid_query 工作项
    * 未删除
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemUsuallyDTO>>
    */
    @ApiOperation(value = "查询fetch_tree_tile_grid_query", tags = {"工作项" },  notes = "WorkItem-fetch_tree_tile_grid_query 未删除")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_tree_tile_grid_query-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_tree_tile_grid_query')")
    @PostMapping("projects/{projectId}/work_items/fetch_tree_tile_grid_query")
    public ResponseEntity<List<WorkItemUsuallyDTO>> fetchTreeTileGridQueryByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchTreeTileGridQuery(context) ;
        List<WorkItemUsuallyDTO> list = workItemUsuallyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_under_work 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_under_work", tags = {"工作项" },  notes = "WorkItem-fetch_under_work ")
    @PostMapping("projects/{projectId}/work_items/fetch_under_work")
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
    * 查询fetch_work_item_distribution 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_distribution", tags = {"工作项" },  notes = "WorkItem-fetch_work_item_distribution ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-WorkItem-fetch_work_item_distribution-all') or hasPermission('project',#projectId,#dto,'ibizplm-WorkItem-fetch_work_item_distribution')")
    @PostMapping("projects/{projectId}/work_items/fetch_work_item_distribution")
    public ResponseEntity<List<WorkItemDTO>> fetchWorkItemDistributionByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody WorkItemFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        WorkItemSearchContext context = workItemFilterDtoMapping.toDomain(dto);
        Page<WorkItem> domains = workItemService.searchWorkItemDistribution(context) ;
        List<WorkItemDTO> list = workItemDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_relation_work_item 工作项
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<WorkItemDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_work_item", tags = {"工作项" },  notes = "WorkItem-fetch_work_item_relation_work_item ")
    @PostMapping("projects/{projectId}/work_items/fetch_work_item_relation_work_item")
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
