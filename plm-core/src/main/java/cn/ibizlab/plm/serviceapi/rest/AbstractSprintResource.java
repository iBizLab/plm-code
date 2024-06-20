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
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Sprint] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintResource {

    @Autowired
    public SprintService sprintService;

    @Autowired
    @Lazy
    public SprintDTOMapping sprintDtoMapping;

    @Autowired
    @Lazy
    public SprintFilterDTOMapping sprintFilterDtoMapping;

    /**
    * 创建Create 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代" },  notes = "Sprint-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Create-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-Create')")
    @PostMapping("sprints")
    public ResponseEntity<ResponseWrapper<SprintDTO>> create
            (@Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO create
            (SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        sprintService.create(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代" },  notes = "Sprint-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Update-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-Update')")
    @VersionCheck(entity = "sprint" , versionfield = "updateTime")
    @PutMapping("sprints/{id}")
    public ResponseEntity<ResponseWrapper<SprintDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO updateById
            (String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintService.update(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "delete_categories", tags = {"迭代" },  notes = "Sprint-delete_categories ")
    @PostMapping("sprints/{id}/delete_categories")
    public ResponseEntity<ResponseWrapper<SprintDTO>> deleteCategoriesById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteCategoriesById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteCategoriesById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete_categories 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO deleteCategoriesById
            (String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.deleteCategories(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * end_sprint 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "end_sprint", tags = {"迭代" },  notes = "Sprint-end_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-end_sprint-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-end_sprint')")
    @PostMapping("sprints/{id}/end_sprint")
    public ResponseEntity<ResponseWrapper<SprintDTO>> endSprintById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endSprintById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endSprintById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * end_sprint 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO endSprintById
            (String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.endSprint(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代" },  notes = "Sprint-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Save-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-Save')")
    @PostMapping("sprints/save")
    public ResponseEntity<ResponseWrapper<SprintDTO>> save
            (@Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO save
            (SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        sprintService.save(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * start_sprint 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "start_sprint", tags = {"迭代" },  notes = "Sprint-start_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-start_sprint-all') or hasPermission(this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-start_sprint')")
    @PostMapping("sprints/{id}/start_sprint")
    public ResponseEntity<ResponseWrapper<SprintDTO>> startSprintById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startSprintById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startSprintById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * start_sprint 迭代
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO startSprintById
            (String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.startSprint(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代" },  notes = "Sprint-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Create-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-Create')")
    @PostMapping("projects/{projectId}/sprints")
    public ResponseEntity<ResponseWrapper<SprintDTO>> createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO createByProjectId
            (String projectId, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        sprintService.create(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代" },  notes = "Sprint-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Update-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-Update')")
    @VersionCheck(entity = "sprint" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/sprints/{id}")
    public ResponseEntity<ResponseWrapper<SprintDTO>> updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO updateByProjectIdAndId
            (String projectId, String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintService.update(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "delete_categories", tags = {"迭代" },  notes = "Sprint-delete_categories ")
    @PostMapping("projects/{projectId}/sprints/{id}/delete_categories")
    public ResponseEntity<ResponseWrapper<SprintDTO>> deleteCategoriesByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteCategoriesByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteCategoriesByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete_categories 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO deleteCategoriesByProjectIdAndId
            (String projectId, String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.deleteCategories(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * end_sprint 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "end_sprint", tags = {"迭代" },  notes = "Sprint-end_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-end_sprint-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-end_sprint')")
    @PostMapping("projects/{projectId}/sprints/{id}/end_sprint")
    public ResponseEntity<ResponseWrapper<SprintDTO>> endSprintByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endSprintByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endSprintByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * end_sprint 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO endSprintByProjectIdAndId
            (String projectId, String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.endSprint(domain);
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代" },  notes = "Sprint-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Save-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-Save')")
    @PostMapping("projects/{projectId}/sprints/save")
    public ResponseEntity<ResponseWrapper<SprintDTO>> saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO saveByProjectId
            (String projectId, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        sprintService.save(domain);
        Sprint rt = domain;
        return sprintDtoMapping.toDto(rt);
    }

    /**
    * start_sprint 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "start_sprint", tags = {"迭代" },  notes = "Sprint-start_sprint ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-start_sprint-all') or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(#dto),'ibizplm-Sprint-start_sprint')")
    @PostMapping("projects/{projectId}/sprints/{id}/start_sprint")
    public ResponseEntity<ResponseWrapper<SprintDTO>> startSprintByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintDTO> dto) {
        ResponseWrapper<SprintDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startSprintByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startSprintByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * start_sprint 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */   
    public SprintDTO startSprintByProjectIdAndId
            (String projectId, String id, SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setId(id);
        Sprint rt = sprintService.startSprint(domain);
        return sprintDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 迭代
    * 
    *
    * @param id id
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代" },  notes = "Sprint-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Get-all')  or hasPermission(this.sprintDtoMapping.toDomain(returnObject.body),'ibizplm-Sprint-Get')")
    @GetMapping("sprints/{id}")
    public ResponseEntity<SprintDTO> getById
            (@PathVariable("id") String id) {
        Sprint rt = sprintService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 迭代
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代" },  notes = "Sprint-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Remove-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-Remove')")
    @DeleteMapping("sprints/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = sprintService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代" },  notes = "Sprint-CheckKey ")
    @PostMapping("sprints/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        Integer rt = sprintService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代" },  notes = "Sprint-GetDraft ")
    @GetMapping("sprints/get_draft")
    public ResponseEntity<SprintDTO> getDraft
            (@SpringQueryMap SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        Sprint rt = sprintService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt));
    }

    /**
    * get_not_finish 迭代
    * 
    *
    * @param id id
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "get_not_finish", tags = {"迭代" },  notes = "Sprint-get_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-get_not_finish-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-get_not_finish')")
    @GetMapping("sprints/{id}/get_not_finish")
    public ResponseEntity<SprintDTO> getNotFinishById
            (@PathVariable("id") String id) {
        Sprint rt = sprintService.getNotFinish(id);
        return ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt));
    }

    /**
    * overview_num 迭代
    * 
    *
    * @param id id
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "overview_num", tags = {"迭代" },  notes = "Sprint-overview_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-overview_num-all') or hasPermission(this.sprintService.get(#id),'ibizplm-Sprint-overview_num')")
    @GetMapping("sprints/{id}/overview_num")
    public ResponseEntity<SprintDTO> overviewNumById
            (@PathVariable("id") String id) {
        Sprint rt = sprintService.overviewNum(id);
        return ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_choose_move 迭代
    * 确认迭代完成时，选择移动至其他迭代
    *
    * @param dto dto
    * @return ResponseEntity<List<SprintDTO>>
    */
    @ApiOperation(value = "查询fetch_choose_move", tags = {"迭代" },  notes = "Sprint-fetch_choose_move 确认迭代完成时，选择移动至其他迭代")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_choose_move-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_choose_move')")
    @PostMapping("sprints/fetch_choose_move")
    public ResponseEntity<List<SprintDTO>> fetchChooseMove
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchChooseMove(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_cur_sprint_not_finish 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SprintDTO>>
    */
    @ApiOperation(value = "查询fetch_cur_sprint_not_finish", tags = {"迭代" },  notes = "Sprint-fetch_cur_sprint_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_cur_sprint_not_finish-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_cur_sprint_not_finish')")
    @PostMapping("sprints/fetch_cur_sprint_not_finish")
    public ResponseEntity<List<SprintDTO>> fetchCurSprintNotFinish
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchCurSprintNotFinish(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SprintDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"迭代" },  notes = "Sprint-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_default-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_default')")
    @PostMapping("sprints/fetch_default")
    public ResponseEntity<List<SprintDTO>> fetchDefault
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchDefault(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_not_finish 迭代
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SprintDTO>>
    */
    @ApiOperation(value = "查询fetch_not_finish", tags = {"迭代" },  notes = "Sprint-fetch_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_not_finish-all') or hasPermission(#dto,'ibizplm-Sprint-fetch_not_finish')")
    @PostMapping("sprints/fetch_not_finish")
    public ResponseEntity<List<SprintDTO>> fetchNotFinish
            (@Validated @RequestBody SprintFilterDTO dto) {
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchNotFinish(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代" },  notes = "Sprint-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Get-all')  or hasPermission('project',#projectId,this.sprintDtoMapping.toDomain(returnObject.body),'ibizplm-Sprint-Get')")
    @GetMapping("projects/{projectId}/sprints/{id}")
    public ResponseEntity<SprintDTO> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Sprint rt = sprintService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代" },  notes = "Sprint-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-Remove-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-Remove')")
    @DeleteMapping("projects/{projectId}/sprints/{id}")
    public ResponseEntity<Boolean> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = sprintService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代" },  notes = "Sprint-CheckKey ")
    @PostMapping("projects/{projectId}/sprints/check_key")
    public ResponseEntity<Integer> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Integer rt = sprintService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代" },  notes = "Sprint-GetDraft ")
    @GetMapping("projects/{projectId}/sprints/get_draft")
    public ResponseEntity<SprintDTO> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap SprintDTO dto) {
        Sprint domain = sprintDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Sprint rt = sprintService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt));
    }

    /**
    * get_not_finish 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "get_not_finish", tags = {"迭代" },  notes = "Sprint-get_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-get_not_finish-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-get_not_finish')")
    @GetMapping("projects/{projectId}/sprints/{id}/get_not_finish")
    public ResponseEntity<SprintDTO> getNotFinishByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Sprint rt = sprintService.getNotFinish(id);
        return ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt));
    }

    /**
    * overview_num 迭代
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<SprintDTO>
    */
    @ApiOperation(value = "overview_num", tags = {"迭代" },  notes = "Sprint-overview_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-overview_num-all') or hasPermission('project',#projectId,this.sprintService.get(#id),'ibizplm-Sprint-overview_num')")
    @GetMapping("projects/{projectId}/sprints/{id}/overview_num")
    public ResponseEntity<SprintDTO> overviewNumByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Sprint rt = sprintService.overviewNum(id);
        return ResponseEntity.status(HttpStatus.OK).body(sprintDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_choose_move 迭代
    * 确认迭代完成时，选择移动至其他迭代
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<SprintDTO>>
    */
    @ApiOperation(value = "查询fetch_choose_move", tags = {"迭代" },  notes = "Sprint-fetch_choose_move 确认迭代完成时，选择移动至其他迭代")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_choose_move-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_choose_move')")
    @PostMapping("projects/{projectId}/sprints/fetch_choose_move")
    public ResponseEntity<List<SprintDTO>> fetchChooseMoveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchChooseMove(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_cur_sprint_not_finish 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<SprintDTO>>
    */
    @ApiOperation(value = "查询fetch_cur_sprint_not_finish", tags = {"迭代" },  notes = "Sprint-fetch_cur_sprint_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_cur_sprint_not_finish-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_cur_sprint_not_finish')")
    @PostMapping("projects/{projectId}/sprints/fetch_cur_sprint_not_finish")
    public ResponseEntity<List<SprintDTO>> fetchCurSprintNotFinishByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchCurSprintNotFinish(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<SprintDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"迭代" },  notes = "Sprint-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_default')")
    @PostMapping("projects/{projectId}/sprints/fetch_default")
    public ResponseEntity<List<SprintDTO>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchDefault(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_not_finish 迭代
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<SprintDTO>>
    */
    @ApiOperation(value = "查询fetch_not_finish", tags = {"迭代" },  notes = "Sprint-fetch_not_finish ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Sprint-fetch_not_finish-all') or hasPermission('project',#projectId,#dto,'ibizplm-Sprint-fetch_not_finish')")
    @PostMapping("projects/{projectId}/sprints/fetch_not_finish")
    public ResponseEntity<List<SprintDTO>> fetchNotFinishByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody SprintFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        SprintSearchContext context = sprintFilterDtoMapping.toDomain(dto);
        Page<Sprint> domains = sprintService.fetchNotFinish(context) ;
        List<SprintDTO> list = sprintDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建迭代
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Create-all')")
    @ApiOperation(value = "批量新建迭代", tags = {"迭代" },  notes = "批量新建迭代")
	@PostMapping("sprints/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SprintDTO> dtos) {
        sprintService.create(sprintDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除迭代
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Remove-all')")
    @ApiOperation(value = "批量删除迭代", tags = {"迭代" },  notes = "批量删除迭代")
	@DeleteMapping("sprints/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sprintService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新迭代
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Update-all')")
    @ApiOperation(value = "批量更新迭代", tags = {"迭代" },  notes = "批量更新迭代")
	@PutMapping("sprints/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SprintDTO> dtos) {
        sprintService.update(sprintDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存迭代
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Save-all')")
    @ApiOperation(value = "批量保存迭代", tags = {"迭代" },  notes = "批量保存迭代")
	@PostMapping("sprints/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SprintDTO> dtos) {
        sprintService.save(sprintDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入迭代
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Sprint-Save-all')")
    @ApiOperation(value = "批量导入迭代", tags = {"迭代" },  notes = "批量导入迭代")
	@PostMapping("sprints/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SprintDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(sprintService.importData(config,ignoreError,sprintDtoMapping.toDomain(dtos)));
    }

}
