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
import cn.ibizlab.plm.core.base.domain.Activitiy;
import cn.ibizlab.plm.core.base.service.ActivitiyService;
import cn.ibizlab.plm.core.base.filter.ActivitiySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Activitiy] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractActivitiyResource {

    @Autowired
    public ActivitiyService activitiyService;

    @Autowired
    @Lazy
    public ActivitiyDTOMapping activitiyDtoMapping;

    @Autowired
    @Lazy
    public ActivitiyFilterDTOMapping activitiyFilterDtoMapping;

    /**
    * 创建Create 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ActivitiyDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"活动" },  notes = "Activitiy-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activitiy-Create-all') or hasPermission(this.activitiyDtoMapping.toDomain(#dto),'ibizplm-Activitiy-Create')")
    @PostMapping("activitiys")
    public ResponseEntity<ResponseWrapper<ActivitiyDTO>> create
            (@Validated @RequestBody RequestWrapper<ActivitiyDTO> dto) {
        ResponseWrapper<ActivitiyDTO> rt = new ResponseWrapper<>();
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
    * @return ResponseEntity<ActivitiyDTO>
    */   
    public ActivitiyDTO create
            (ActivitiyDTO dto) {
        Activitiy domain = activitiyDtoMapping.toDomain(dto);
        activitiyService.create(domain);
        Activitiy rt = domain;
        return activitiyDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 活动
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ActivitiyDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"活动" },  notes = "Activitiy-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activitiy-Update-all') or hasPermission(this.activitiyService.get(#id),'ibizplm-Activitiy-Update')")
    @VersionCheck(entity = "activitiy" , versionfield = "updateTime")
    @PutMapping("activitiys/{id}")
    public ResponseEntity<ResponseWrapper<ActivitiyDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ActivitiyDTO> dto) {
        ResponseWrapper<ActivitiyDTO> rt = new ResponseWrapper<>();
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
    * @return ResponseEntity<ActivitiyDTO>
    */   
    public ActivitiyDTO updateById
            (String id, ActivitiyDTO dto) {
        Activitiy domain = activitiyDtoMapping.toDomain(dto);
        domain.setId(id);
        activitiyService.update(domain);
        Activitiy rt = domain;
        return activitiyDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ActivitiyDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"活动" },  notes = "Activitiy-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activitiy-Save-all') or hasPermission(this.activitiyDtoMapping.toDomain(#dto),'ibizplm-Activitiy-Save')")
    @PostMapping("activitiys/save")
    public ResponseEntity<ResponseWrapper<ActivitiyDTO>> save
            (@Validated @RequestBody RequestWrapper<ActivitiyDTO> dto) {
        ResponseWrapper<ActivitiyDTO> rt = new ResponseWrapper<>();
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
    * @return ResponseEntity<ActivitiyDTO>
    */   
    public ActivitiyDTO save
            (ActivitiyDTO dto) {
        Activitiy domain = activitiyDtoMapping.toDomain(dto);
        activitiyService.save(domain);
        Activitiy rt = domain;
        return activitiyDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 活动
    * 
    *
    * @param id id
    * @return ResponseEntity<ActivitiyDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"活动" },  notes = "Activitiy-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activitiy-Get-all')  or hasPermission(this.activitiyDtoMapping.toDomain(returnObject.body),'ibizplm-Activitiy-Get')")
    @GetMapping("activitiys/{id}")
    public ResponseEntity<ActivitiyDTO> getById
            (@PathVariable("id") String id) {
        Activitiy rt = activitiyService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(activitiyDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 活动
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"活动" },  notes = "Activitiy-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activitiy-Remove-all') or hasPermission(this.activitiyService.get(#id),'ibizplm-Activitiy-Remove')")
    @DeleteMapping("activitiys/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = activitiyService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"活动" },  notes = "Activitiy-CheckKey ")
    @PostMapping("activitiys/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ActivitiyDTO dto) {
        Activitiy domain = activitiyDtoMapping.toDomain(dto);
        Integer rt = activitiyService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ActivitiyDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"活动" },  notes = "Activitiy-GetDraft ")
    @GetMapping("activitiys/getdraft")
    public ResponseEntity<ActivitiyDTO> getDraft
            (@SpringQueryMap ActivitiyDTO dto) {
        Activitiy domain = activitiyDtoMapping.toDomain(dto);
        Activitiy rt = activitiyService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(activitiyDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchALL 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ActivitiyDTO>>
    */
    @ApiOperation(value = "查询FetchALL", tags = {"活动" },  notes = "Activitiy-FetchALL ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activitiy-FetchALL-all') or hasPermission(#dto,'ibizplm-Activitiy-FetchALL')")
    @PostMapping("activitiys/fetchall")
    public ResponseEntity<List<ActivitiyDTO>> fetchAll
            (@Validated @RequestBody ActivitiyFilterDTO dto) {
        ActivitiySearchContext context = activitiyFilterDtoMapping.toDomain(dto);
        Page<Activitiy> domains = activitiyService.searchAll(context) ;
        List<ActivitiyDTO> list = activitiyDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 活动
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ActivitiyDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"活动" },  notes = "Activitiy-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Activitiy-FetchDefault-all') or hasPermission(#dto,'ibizplm-Activitiy-FetchDefault')")
    @PostMapping("activitiys/fetchdefault")
    public ResponseEntity<List<ActivitiyDTO>> fetchDefault
            (@Validated @RequestBody ActivitiyFilterDTO dto) {
        ActivitiySearchContext context = activitiyFilterDtoMapping.toDomain(dto);
        Page<Activitiy> domains = activitiyService.searchDefault(context) ;
        List<ActivitiyDTO> list = activitiyDtoMapping.toDto(domains.getContent());
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
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activitiy-Create-all')")
    @ApiOperation(value = "批量新建活动", tags = {"活动" },  notes = "批量新建活动")
	@PostMapping("activitiys/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ActivitiyDTO> dtos) {
        activitiyService.createBatch(activitiyDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除活动
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activitiy-Remove-all')")
    @ApiOperation(value = "批量删除活动", tags = {"活动" },  notes = "批量删除活动")
	@DeleteMapping("activitiys/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        activitiyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新活动
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activitiy-Update-all')")
    @ApiOperation(value = "批量更新活动", tags = {"活动" },  notes = "批量更新活动")
	@PutMapping("activitiys/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ActivitiyDTO> dtos) {
        activitiyService.updateBatch(activitiyDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存活动
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activitiy-Save-all')")
    @ApiOperation(value = "批量保存活动", tags = {"活动" },  notes = "批量保存活动")
	@PostMapping("activitiys/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ActivitiyDTO> dtos) {
        activitiyService.saveBatch(activitiyDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入活动
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Activitiy-Save-all')")
    @ApiOperation(value = "批量导入活动", tags = {"活动" },  notes = "批量导入活动")
	@PostMapping("activitiys/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ActivitiyDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(activitiyService.importData(config,ignoreError,activitiyDtoMapping.toDomain(dtos)));
    }

}
