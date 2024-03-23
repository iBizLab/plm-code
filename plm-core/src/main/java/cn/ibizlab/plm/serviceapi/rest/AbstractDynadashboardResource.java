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
import cn.ibizlab.plm.core.base.domain.Dynadashboard;
import cn.ibizlab.plm.core.base.service.DynadashboardService;
import cn.ibizlab.plm.core.base.filter.DynadashboardSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Dynadashboard] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDynadashboardResource {

    @Autowired
    public DynadashboardService dynadashboardService;

    @Autowired
    @Lazy
    public DynadashboardDTOMapping dynadashboardDtoMapping;

    @Autowired
    @Lazy
    public DynadashboardFilterDTOMapping dynadashboardFilterDtoMapping;

    /**
    * 创建Create 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynadashboardDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"动态数据看板" },  notes = "Dynadashboard-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Dynadashboard-Create-all') or hasPermission(this.dynadashboardDtoMapping.toDomain(#dto),'ibizplm-Dynadashboard-Create')")
    @PostMapping("dynadashboards")
    public ResponseEntity<ResponseWrapper<DynadashboardDTO>> create
            (@Validated @RequestBody RequestWrapper<DynadashboardDTO> dto) {
        ResponseWrapper<DynadashboardDTO> rt = new ResponseWrapper<>();
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
    * @return ResponseEntity<DynadashboardDTO>
    */   
    public DynadashboardDTO create
            (DynadashboardDTO dto) {
        Dynadashboard domain = dynadashboardDtoMapping.toDomain(dto);
        dynadashboardService.create(domain);
        Dynadashboard rt = domain;
        return dynadashboardDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynadashboardDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"动态数据看板" },  notes = "Dynadashboard-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Dynadashboard-Update-all') or hasPermission(this.dynadashboardService.get(#dynaDashboardId),'ibizplm-Dynadashboard-Update')")
    @VersionCheck(entity = "dynadashboard" , versionfield = "updateTime")
    @PutMapping("dynadashboards/{dynaDashboardId}")
    public ResponseEntity<ResponseWrapper<DynadashboardDTO>> updateByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynadashboardDTO> dto) {
        ResponseWrapper<DynadashboardDTO> rt = new ResponseWrapper<>();
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
    * @return ResponseEntity<DynadashboardDTO>
    */   
    public DynadashboardDTO updateByDynaDashboardId
            (String dynaDashboardId, DynadashboardDTO dto) {
        Dynadashboard domain = dynadashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        dynadashboardService.update(domain);
        Dynadashboard rt = domain;
        return dynadashboardDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynadashboardDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"动态数据看板" },  notes = "Dynadashboard-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Dynadashboard-Save-all') or hasPermission(this.dynadashboardDtoMapping.toDomain(#dto),'ibizplm-Dynadashboard-Save')")
    @PostMapping("dynadashboards/save")
    public ResponseEntity<ResponseWrapper<DynadashboardDTO>> save
            (@Validated @RequestBody RequestWrapper<DynadashboardDTO> dto) {
        ResponseWrapper<DynadashboardDTO> rt = new ResponseWrapper<>();
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
    * @return ResponseEntity<DynadashboardDTO>
    */   
    public DynadashboardDTO save
            (DynadashboardDTO dto) {
        Dynadashboard domain = dynadashboardDtoMapping.toDomain(dto);
        dynadashboardService.save(domain);
        Dynadashboard rt = domain;
        return dynadashboardDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @return ResponseEntity<DynadashboardDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"动态数据看板" },  notes = "Dynadashboard-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Dynadashboard-Get-all')  or hasPermission(this.dynadashboardDtoMapping.toDomain(returnObject.body),'ibizplm-Dynadashboard-Get')")
    @GetMapping("dynadashboards/{dynaDashboardId}")
    public ResponseEntity<DynadashboardDTO> getByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId) {
        Dynadashboard rt = dynadashboardService.get(dynaDashboardId);
        return ResponseEntity.status(HttpStatus.OK).body(dynadashboardDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"动态数据看板" },  notes = "Dynadashboard-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Dynadashboard-Remove-all') or hasPermission(this.dynadashboardService.get(#dynaDashboardId),'ibizplm-Dynadashboard-Remove')")
    @DeleteMapping("dynadashboards/{dynaDashboardId}")
    public ResponseEntity<Boolean> removeByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId) {
        Boolean rt = dynadashboardService.remove(dynaDashboardId);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"动态数据看板" },  notes = "Dynadashboard-CheckKey ")
    @PostMapping("dynadashboards/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody DynadashboardDTO dto) {
        Dynadashboard domain = dynadashboardDtoMapping.toDomain(dto);
        Integer rt = dynadashboardService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynadashboardDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"动态数据看板" },  notes = "Dynadashboard-GetDraft ")
    @GetMapping("dynadashboards/getdraft")
    public ResponseEntity<DynadashboardDTO> getDraft
            (@SpringQueryMap DynadashboardDTO dto) {
        Dynadashboard domain = dynadashboardDtoMapping.toDomain(dto);
        Dynadashboard rt = dynadashboardService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dynadashboardDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DynadashboardDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"动态数据看板" },  notes = "Dynadashboard-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Dynadashboard-FetchDefault-all') or hasPermission(#dto,'ibizplm-Dynadashboard-FetchDefault')")
    @PostMapping("dynadashboards/fetchdefault")
    public ResponseEntity<List<DynadashboardDTO>> fetchDefault
            (@Validated @RequestBody DynadashboardFilterDTO dto) {
        DynadashboardSearchContext context = dynadashboardFilterDtoMapping.toDomain(dto);
        Page<Dynadashboard> domains = dynadashboardService.searchDefault(context) ;
        List<DynadashboardDTO> list = dynadashboardDtoMapping.toDto(domains.getContent());
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
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Dynadashboard-Create-all')")
    @ApiOperation(value = "批量新建动态数据看板", tags = {"动态数据看板" },  notes = "批量新建动态数据看板")
	@PostMapping("dynadashboards/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DynadashboardDTO> dtos) {
        dynadashboardService.createBatch(dynadashboardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除动态数据看板
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Dynadashboard-Remove-all')")
    @ApiOperation(value = "批量删除动态数据看板", tags = {"动态数据看板" },  notes = "批量删除动态数据看板")
	@DeleteMapping("dynadashboards/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dynadashboardService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新动态数据看板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Dynadashboard-Update-all')")
    @ApiOperation(value = "批量更新动态数据看板", tags = {"动态数据看板" },  notes = "批量更新动态数据看板")
	@PutMapping("dynadashboards/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DynadashboardDTO> dtos) {
        dynadashboardService.updateBatch(dynadashboardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存动态数据看板
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Dynadashboard-Save-all')")
    @ApiOperation(value = "批量保存动态数据看板", tags = {"动态数据看板" },  notes = "批量保存动态数据看板")
	@PostMapping("dynadashboards/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DynadashboardDTO> dtos) {
        dynadashboardService.saveBatch(dynadashboardDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入动态数据看板
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Dynadashboard-Save-all')")
    @ApiOperation(value = "批量导入动态数据看板", tags = {"动态数据看板" },  notes = "批量导入动态数据看板")
	@PostMapping("dynadashboards/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DynadashboardDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(dynadashboardService.importData(config,ignoreError,dynadashboardDtoMapping.toDomain(dtos)));
    }

}
