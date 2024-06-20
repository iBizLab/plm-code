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
import cn.ibizlab.plm.core.base.domain.Activity;
import cn.ibizlab.plm.core.base.service.ActivityService;
import cn.ibizlab.plm.core.base.filter.ActivitySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Activity] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractActivityResource {

    @Autowired
    public ActivityService activityService;

    @Autowired
    @Lazy
    public ActivityDTOMapping activityDtoMapping;

    @Autowired
    @Lazy
    public ActivityFilterDTOMapping activityFilterDtoMapping;

    /**
    * 创建Create 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"活动" },  notes = "Activity-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activity-Create-all') or hasPermission(this.activityDtoMapping.toDomain(#dto),'ibizplm-Activity-Create')")
    @PostMapping("activities")
    public ResponseEntity<ResponseWrapper<ActivityDTO>> create
            (@Validated @RequestBody RequestWrapper<ActivityDTO> dto) {
        ResponseWrapper<ActivityDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */   
    public ActivityDTO create
            (ActivityDTO dto) {
        Activity domain = activityDtoMapping.toDomain(dto);
        activityService.create(domain);
        Activity rt = domain;
        return activityDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 活动
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"活动" },  notes = "Activity-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activity-Update-all') or hasPermission(this.activityService.get(#id),'ibizplm-Activity-Update')")
    @VersionCheck(entity = "activity" , versionfield = "updateTime")
    @PutMapping("activities/{id}")
    public ResponseEntity<ResponseWrapper<ActivityDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ActivityDTO> dto) {
        ResponseWrapper<ActivityDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 活动
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */   
    public ActivityDTO updateById
            (String id, ActivityDTO dto) {
        Activity domain = activityDtoMapping.toDomain(dto);
        domain.setId(id);
        activityService.update(domain);
        Activity rt = domain;
        return activityDtoMapping.toDto(rt);
    }

    /**
    * get_activity_obj_detail 活动
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */
    @ApiOperation(value = "get_activity_obj_detail", tags = {"活动" },  notes = "Activity-get_activity_obj_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activity-get_activity_obj_detail-all') or hasPermission(this.activityDtoMapping.toDomain(#dto),'ibizplm-Activity-get_activity_obj_detail')")
    @PutMapping("activities/{id}/get_activity_obj_detail")
    public ResponseEntity<ResponseWrapper<ActivityDTO>> getActivityObjDetailById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ActivityDTO> dto) {
        ResponseWrapper<ActivityDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(getActivityObjDetailById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(getActivityObjDetailById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_activity_obj_detail 活动
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */   
    public ActivityDTO getActivityObjDetailById
            (String id, ActivityDTO dto) {
        Activity domain = activityDtoMapping.toDomain(dto);
        domain.setId(id);
        Activity rt = activityService.getActivityObjDetail(domain);
        return activityDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"活动" },  notes = "Activity-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activity-Save-all') or hasPermission(this.activityDtoMapping.toDomain(#dto),'ibizplm-Activity-Save')")
    @PostMapping("activities/save")
    public ResponseEntity<ResponseWrapper<ActivityDTO>> save
            (@Validated @RequestBody RequestWrapper<ActivityDTO> dto) {
        ResponseWrapper<ActivityDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */   
    public ActivityDTO save
            (ActivityDTO dto) {
        Activity domain = activityDtoMapping.toDomain(dto);
        activityService.save(domain);
        Activity rt = domain;
        return activityDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 活动
    * 
    *
    * @param id id
    * @return ResponseEntity<ActivityDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"活动" },  notes = "Activity-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activity-Get-all')  or hasPermission(this.activityDtoMapping.toDomain(returnObject.body),'ibizplm-Activity-Get')")
    @GetMapping("activities/{id}")
    public ResponseEntity<ActivityDTO> getById
            (@PathVariable("id") String id) {
        Activity rt = activityService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(activityDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 活动
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"活动" },  notes = "Activity-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activity-Remove-all') or hasPermission(this.activityService.get(#id),'ibizplm-Activity-Remove')")
    @DeleteMapping("activities/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = activityService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"活动" },  notes = "Activity-CheckKey ")
    @PostMapping("activities/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ActivityDTO dto) {
        Activity domain = activityDtoMapping.toDomain(dto);
        Integer rt = activityService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ActivityDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"活动" },  notes = "Activity-GetDraft ")
    @GetMapping("activities/get_draft")
    public ResponseEntity<ActivityDTO> getDraft
            (@SpringQueryMap ActivityDTO dto) {
        Activity domain = activityDtoMapping.toDomain(dto);
        Activity rt = activityService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(activityDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_all 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ActivityDTO>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"活动" },  notes = "Activity-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activity-fetch_all-all') or hasPermission(#dto,'ibizplm-Activity-fetch_all')")
    @PostMapping("activities/fetch_all")
    public ResponseEntity<List<ActivityDTO>> fetchAll
            (@Validated @RequestBody ActivityFilterDTO dto) {
        ActivitySearchContext context = activityFilterDtoMapping.toDomain(dto);
        Page<Activity> domains = activityService.fetchAll(context) ;
        List<ActivityDTO> list = activityDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ActivityDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"活动" },  notes = "Activity-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activity-fetch_default-all') or hasPermission(#dto,'ibizplm-Activity-fetch_default')")
    @PostMapping("activities/fetch_default")
    public ResponseEntity<List<ActivityDTO>> fetchDefault
            (@Validated @RequestBody ActivityFilterDTO dto) {
        ActivitySearchContext context = activityFilterDtoMapping.toDomain(dto);
        Page<Activity> domains = activityService.fetchDefault(context) ;
        List<ActivityDTO> list = activityDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建活动
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activity-Create-all')")
    @ApiOperation(value = "批量新建活动", tags = {"活动" },  notes = "批量新建活动")
	@PostMapping("activities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ActivityDTO> dtos) {
        activityService.create(activityDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除活动
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activity-Remove-all')")
    @ApiOperation(value = "批量删除活动", tags = {"活动" },  notes = "批量删除活动")
	@DeleteMapping("activities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        activityService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新活动
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activity-Update-all')")
    @ApiOperation(value = "批量更新活动", tags = {"活动" },  notes = "批量更新活动")
	@PutMapping("activities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ActivityDTO> dtos) {
        activityService.update(activityDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存活动
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activity-Save-all')")
    @ApiOperation(value = "批量保存活动", tags = {"活动" },  notes = "批量保存活动")
	@PostMapping("activities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ActivityDTO> dtos) {
        activityService.save(activityDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入活动
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activity-Save-all')")
    @ApiOperation(value = "批量导入活动", tags = {"活动" },  notes = "批量导入活动")
	@PostMapping("activities/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ActivityDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(activityService.importData(config,ignoreError,activityDtoMapping.toDomain(dtos)));
    }

}
