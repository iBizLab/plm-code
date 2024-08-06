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
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.projmgmt.service.StageService;
import cn.ibizlab.plm.core.projmgmt.filter.StageSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Stage] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractStageResource {

    @Autowired
    public StageService stageService;

    @Autowired
    @Lazy
    public StageDTOMapping stageDtoMapping;

    @Autowired
    @Lazy
    public StageFilterDTOMapping stageFilterDtoMapping;

    /**
    * 创建Create 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<StageDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"发布阶段" },  notes = "Stage-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-Create-all') or hasPermission(this.stageDtoMapping.toDomain(#dto),'ibizplm-Stage-Create')")
    @PostMapping("stages")
    public Mono<ResponseEntity<ResponseWrapper<StageDTO>>>create
            (@Validated @RequestBody RequestWrapper<StageDTO> dto) {
        ResponseWrapper<StageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 发布阶段
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StageDTO>
    */   
    public StageDTO create
            (StageDTO dto) {
        Stage domain = stageDtoMapping.toDomain(dto);
        stageService.create(domain);
        Stage rt = domain;
        return stageDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 发布阶段
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<StageDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"发布阶段" },  notes = "Stage-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-Update-all') or hasPermission(this.stageService.get(#id),'ibizplm-Stage-Update')")
    @VersionCheck(entity = "stage" , versionfield = "updateTime")
    @PutMapping("stages/{id}")
    public Mono<ResponseEntity<ResponseWrapper<StageDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<StageDTO> dto) {
        ResponseWrapper<StageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 发布阶段
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<StageDTO>
    */   
    public StageDTO updateById
            (String id, StageDTO dto) {
        Stage domain = stageDtoMapping.toDomain(dto);
        domain.setId(id);
        stageService.update(domain);
        Stage rt = domain;
        return stageDtoMapping.toDto(rt);
    }

    /**
    * add_predefined 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<StageDTO>>
    */
    @ApiOperation(value = "add_predefined", tags = {"发布阶段" },  notes = "Stage-add_predefined ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-add_predefined-all') or hasPermission(this.stageDtoMapping.toDomain(#dto),'ibizplm-Stage-add_predefined')")
    @PostMapping("stages/add_predefined")
    public Mono<ResponseEntity<ResponseWrapper<StageDTO>>>addPredefined
            (@Validated @RequestBody RequestWrapper<StageDTO> dto) {
        ResponseWrapper<StageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(addPredefined(item)));
        else
            rt.set(addPredefined(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * add_predefined 发布阶段
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StageDTO>
    */   
    public StageDTO addPredefined
            (StageDTO dto) {
        Stage domain = stageDtoMapping.toDomain(dto);
        Stage rt = stageService.addPredefined(domain);
        return stageDtoMapping.toDto(rt);
    }

    /**
    * del 发布阶段
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<StageDTO>>
    */
    @ApiOperation(value = "del", tags = {"发布阶段" },  notes = "Stage-del ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-del-all') or hasPermission(this.stageDtoMapping.toDomain(#dto),'ibizplm-Stage-del')")
    @PostMapping("stages/{id}/del")
    public Mono<ResponseEntity<ResponseWrapper<StageDTO>>>delById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<StageDTO> dto) {
        ResponseWrapper<StageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * del 发布阶段
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<StageDTO>
    */   
    public StageDTO delById
            (String id, StageDTO dto) {
        Stage domain = stageDtoMapping.toDomain(dto);
        domain.setId(id);
        Stage rt = stageService.del(domain);
        return stageDtoMapping.toDto(rt);
    }

    /**
    * move_order 发布阶段
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<StageDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"发布阶段" },  notes = "Stage-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-move_order-all') or hasPermission(this.stageDtoMapping.toDomain(#dto),'ibizplm-Stage-move_order')")
    @PostMapping("stages/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<StageDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<StageDTO> dto) {
        ResponseWrapper<List<StageDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 发布阶段
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<StageDTO>>
    */   
    public List<StageDTO> moveOrderById
            (String id, StageDTO dto) {
        Stage domain = stageDtoMapping.toDomain(dto);
        domain.setId(id);
        List<Stage> rt = stageService.moveOrder(domain);
        return stageDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<StageDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"发布阶段" },  notes = "Stage-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-Save-all') or hasPermission(this.stageDtoMapping.toDomain(#dto),'ibizplm-Stage-Save')")
    @PostMapping("stages/save")
    public Mono<ResponseEntity<ResponseWrapper<StageDTO>>>save
            (@Validated @RequestBody RequestWrapper<StageDTO> dto) {
        ResponseWrapper<StageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 发布阶段
    * 
    *
    * @param dto dto
    * @return ResponseEntity<StageDTO>
    */   
    public StageDTO save
            (StageDTO dto) {
        Stage domain = stageDtoMapping.toDomain(dto);
        stageService.save(domain);
        Stage rt = domain;
        return stageDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 发布阶段
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<StageDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"发布阶段" },  notes = "Stage-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-Get-all')  or hasPermission(this.stageDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Stage-Get')")
    @GetMapping("stages/{id}")
    public Mono<ResponseEntity<StageDTO>> getById
            (@PathVariable("id") String id) {
        Stage rt = stageService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(stageDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 发布阶段
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"发布阶段" },  notes = "Stage-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-Remove-all') or hasPermission(this.stageService.get(#id),'ibizplm-Stage-Remove')")
    @DeleteMapping("stages/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = stageService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"发布阶段" },  notes = "Stage-CheckKey ")
    @PostMapping("stages/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody StageDTO dto) {
        Stage domain = stageDtoMapping.toDomain(dto);
        CheckKeyStatus rt = stageService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<StageDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"发布阶段" },  notes = "Stage-GetDraft ")
    @GetMapping("stages/get_draft")
    public Mono<ResponseEntity<StageDTO>> getDraft
            (@SpringQueryMap StageDTO dto) {
        Stage domain = stageDtoMapping.toDomain(dto);
        Stage rt = stageService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(stageDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_owner_sys 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<StageDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_owner_sys", tags = {"发布阶段" },  notes = "Stage-fetch_cur_owner_sys ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-fetch_cur_owner_sys-all') or hasPermission(#dto,'ibizplm-Stage-fetch_cur_owner_sys')")
    @PostMapping("stages/fetch_cur_owner_sys")
    public Mono<ResponseEntity<List<StageDTO>>> fetchCurOwnerSys
            (@Validated @RequestBody StageFilterDTO dto) {
        StageSearchContext context = stageFilterDtoMapping.toDomain(dto);
        Page<Stage> domains = stageService.fetchCurOwnerSys(context) ;
        List<StageDTO> list = stageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_project 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<StageDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_project", tags = {"发布阶段" },  notes = "Stage-fetch_cur_project ")
    @PostMapping("stages/fetch_cur_project")
    public Mono<ResponseEntity<List<StageDTO>>> fetchCurProject
            (@Validated @RequestBody StageFilterDTO dto) {
        StageSearchContext context = stageFilterDtoMapping.toDomain(dto);
        Page<Stage> domains = stageService.fetchCurProject(context) ;
        List<StageDTO> list = stageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_stage 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<StageDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_stage", tags = {"发布阶段" },  notes = "Stage-fetch_cur_stage ")
    @PostMapping("stages/fetch_cur_stage")
    public Mono<ResponseEntity<List<StageDTO>>> fetchCurStage
            (@Validated @RequestBody StageFilterDTO dto) {
        StageSearchContext context = stageFilterDtoMapping.toDomain(dto);
        Page<Stage> domains = stageService.fetchCurStage(context) ;
        List<StageDTO> list = stageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<StageDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"发布阶段" },  notes = "Stage-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-fetch_default-all') or hasPermission(#dto,'ibizplm-Stage-fetch_default')")
    @PostMapping("stages/fetch_default")
    public Mono<ResponseEntity<List<StageDTO>>> fetchDefault
            (@Validated @RequestBody StageFilterDTO dto) {
        StageSearchContext context = stageFilterDtoMapping.toDomain(dto);
        Page<Stage> domains = stageService.fetchDefault(context) ;
        List<StageDTO> list = stageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_owner 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<StageDTO>>>
    */
    @ApiOperation(value = "查询fetch_owner", tags = {"发布阶段" },  notes = "Stage-fetch_owner ")
    @PostMapping("stages/fetch_owner")
    public Mono<ResponseEntity<List<StageDTO>>> fetchOwner
            (@Validated @RequestBody StageFilterDTO dto) {
        StageSearchContext context = stageFilterDtoMapping.toDomain(dto);
        Page<Stage> domains = stageService.fetchOwner(context) ;
        List<StageDTO> list = stageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_system 发布阶段
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<StageDTO>>>
    */
    @ApiOperation(value = "查询fetch_system", tags = {"发布阶段" },  notes = "Stage-fetch_system ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Stage-fetch_system-all') or hasPermission(#dto,'ibizplm-Stage-fetch_system')")
    @PostMapping("stages/fetch_system")
    public Mono<ResponseEntity<List<StageDTO>>> fetchSystem
            (@Validated @RequestBody StageFilterDTO dto) {
        StageSearchContext context = stageFilterDtoMapping.toDomain(dto);
        Page<Stage> domains = stageService.fetchSystem(context) ;
        List<StageDTO> list = stageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建发布阶段
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stage-Create-all')")
    @ApiOperation(value = "批量新建发布阶段", tags = {"发布阶段" },  notes = "批量新建发布阶段")
	@PostMapping("stages/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<StageDTO> dtos) {
        stageService.create(stageDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除发布阶段
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stage-Remove-all')")
    @ApiOperation(value = "批量删除发布阶段", tags = {"发布阶段" },  notes = "批量删除发布阶段")
	@DeleteMapping("stages/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        stageService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新发布阶段
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stage-Update-all')")
    @ApiOperation(value = "批量更新发布阶段", tags = {"发布阶段" },  notes = "批量更新发布阶段")
	@PutMapping("stages/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<StageDTO> dtos) {
        stageService.update(stageDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存发布阶段
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stage-Save-all')")
    @ApiOperation(value = "批量保存发布阶段", tags = {"发布阶段" },  notes = "批量保存发布阶段")
	@PostMapping("stages/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<StageDTO> dtos) {
        stageService.save(stageDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入发布阶段
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Stage-Save-all')")
    @ApiOperation(value = "批量导入发布阶段", tags = {"发布阶段" },  notes = "批量导入发布阶段")
	@PostMapping("stages/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<StageDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(stageService.importData(config,ignoreError,stageDtoMapping.toDomain(dtos))));
    }

}
