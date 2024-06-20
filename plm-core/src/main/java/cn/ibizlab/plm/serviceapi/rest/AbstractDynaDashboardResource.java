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
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.core.base.service.DynaDashboardService;
import cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[DynaDashboard] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDynaDashboardResource {

    @Autowired
    public DynaDashboardService dynaDashboardService;

    @Autowired
    @Lazy
    public DynaDashboardDTOMapping dynaDashboardDtoMapping;

    @Autowired
    @Lazy
    public DynaDashboardFilterDTOMapping dynaDashboardFilterDtoMapping;

    /**
    * 创建Create 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"动态数据看板" },  notes = "DynaDashboard-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Create-all') or hasPermission(this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-Create')")
    @PostMapping("dyna_dashboards")
    public ResponseEntity<ResponseWrapper<DynaDashboardDTO>> create
            (@Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO create
            (DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        dynaDashboardService.create(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"动态数据看板" },  notes = "DynaDashboard-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Update-all') or hasPermission(this.dynaDashboardService.get(#dynaDashboardId),'ibizplm-DynaDashboard-Update')")
    @VersionCheck(entity = "dynadashboard" , versionfield = "updateTime")
    @PutMapping("dyna_dashboards/{dynaDashboardId}")
    public ResponseEntity<ResponseWrapper<DynaDashboardDTO>> updateByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByDynaDashboardId(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByDynaDashboardId(dynaDashboardId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO updateByDynaDashboardId
            (String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        dynaDashboardService.update(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"动态数据看板" },  notes = "DynaDashboard-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Save-all') or hasPermission(this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-Save')")
    @PostMapping("dyna_dashboards/save")
    public ResponseEntity<ResponseWrapper<DynaDashboardDTO>> save
            (@Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO save
            (DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        dynaDashboardService.save(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @return ResponseEntity<DynaDashboardDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"动态数据看板" },  notes = "DynaDashboard-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Get-all')  or hasPermission(this.dynaDashboardDtoMapping.toDomain(returnObject.body),'ibizplm-DynaDashboard-Get')")
    @GetMapping("dyna_dashboards/{dynaDashboardId}")
    public ResponseEntity<DynaDashboardDTO> getByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId) {
        DynaDashboard rt = dynaDashboardService.get(dynaDashboardId);
        return ResponseEntity.status(HttpStatus.OK).body(dynaDashboardDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"动态数据看板" },  notes = "DynaDashboard-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Remove-all') or hasPermission(this.dynaDashboardService.get(#dynaDashboardId),'ibizplm-DynaDashboard-Remove')")
    @DeleteMapping("dyna_dashboards/{dynaDashboardId}")
    public ResponseEntity<Boolean> removeByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId) {
        Boolean rt = dynaDashboardService.remove(dynaDashboardId);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"动态数据看板" },  notes = "DynaDashboard-CheckKey ")
    @PostMapping("dyna_dashboards/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        Integer rt = dynaDashboardService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"动态数据看板" },  notes = "DynaDashboard-GetDraft ")
    @GetMapping("dyna_dashboards/get_draft")
    public ResponseEntity<DynaDashboardDTO> getDraft
            (@SpringQueryMap DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        DynaDashboard rt = dynaDashboardService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dynaDashboardDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DynaDashboardDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_default-all') or hasPermission(#dto,'ibizplm-DynaDashboard-fetch_default')")
    @PostMapping("dyna_dashboards/fetch_default")
    public ResponseEntity<List<DynaDashboardDTO>> fetchDefault
            (@Validated @RequestBody DynaDashboardFilterDTO dto) {
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchDefault(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建动态数据看板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Create-all')")
    @ApiOperation(value = "批量新建动态数据看板", tags = {"动态数据看板" },  notes = "批量新建动态数据看板")
	@PostMapping("dyna_dashboards/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DynaDashboardDTO> dtos) {
        dynaDashboardService.create(dynaDashboardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除动态数据看板
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Remove-all')")
    @ApiOperation(value = "批量删除动态数据看板", tags = {"动态数据看板" },  notes = "批量删除动态数据看板")
	@DeleteMapping("dyna_dashboards/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dynaDashboardService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新动态数据看板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Update-all')")
    @ApiOperation(value = "批量更新动态数据看板", tags = {"动态数据看板" },  notes = "批量更新动态数据看板")
	@PutMapping("dyna_dashboards/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DynaDashboardDTO> dtos) {
        dynaDashboardService.update(dynaDashboardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存动态数据看板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Save-all')")
    @ApiOperation(value = "批量保存动态数据看板", tags = {"动态数据看板" },  notes = "批量保存动态数据看板")
	@PostMapping("dyna_dashboards/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DynaDashboardDTO> dtos) {
        dynaDashboardService.save(dynaDashboardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入动态数据看板
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Save-all')")
    @ApiOperation(value = "批量导入动态数据看板", tags = {"动态数据看板" },  notes = "批量导入动态数据看板")
	@PostMapping("dyna_dashboards/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DynaDashboardDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(dynaDashboardService.importData(config,ignoreError,dynaDashboardDtoMapping.toDomain(dtos)));
    }

}
