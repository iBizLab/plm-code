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
import cn.ibizlab.plm.core.base.domain.DynaAppmenu;
import cn.ibizlab.plm.core.base.service.DynaAppmenuService;
import cn.ibizlab.plm.core.base.filter.DynaAppmenuSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[DynaAppmenu] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDynaAppmenuResource {

    @Autowired
    public DynaAppmenuService dynaAppmenuService;

    @Autowired
    @Lazy
    public DynaAppmenuDTOMapping dynaAppmenuDtoMapping;

    @Autowired
    @Lazy
    public DynaAppmenuFilterDTOMapping dynaAppmenuFilterDtoMapping;

    /**
    * 创建Create 动态应用菜单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaAppmenuDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"动态应用菜单" },  notes = "DynaAppmenu-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaAppmenu-Create-all') or hasPermission(this.dynaAppmenuDtoMapping.toDomain(#dto),'ibizplm-DynaAppmenu-Create')")
    @PostMapping("dyna_appmenus")
    public ResponseEntity<ResponseWrapper<DynaAppmenuDTO>> create
            (@Validated @RequestBody RequestWrapper<DynaAppmenuDTO> dto) {
        ResponseWrapper<DynaAppmenuDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 动态应用菜单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaAppmenuDTO>
    */   
    public DynaAppmenuDTO create
            (DynaAppmenuDTO dto) {
        DynaAppmenu domain = dynaAppmenuDtoMapping.toDomain(dto);
        dynaAppmenuService.create(domain);
        DynaAppmenu rt = domain;
        return dynaAppmenuDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 动态应用菜单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DynaAppmenuDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"动态应用菜单" },  notes = "DynaAppmenu-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaAppmenu-Update-all') or hasPermission(this.dynaAppmenuService.get(#id),'ibizplm-DynaAppmenu-Update')")
    @VersionCheck(entity = "dynaappmenu" , versionfield = "updateTime")
    @PutMapping("dyna_appmenus/{id}")
    public ResponseEntity<ResponseWrapper<DynaAppmenuDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DynaAppmenuDTO> dto) {
        ResponseWrapper<DynaAppmenuDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 动态应用菜单
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DynaAppmenuDTO>
    */   
    public DynaAppmenuDTO updateById
            (String id, DynaAppmenuDTO dto) {
        DynaAppmenu domain = dynaAppmenuDtoMapping.toDomain(dto);
        domain.setId(id);
        dynaAppmenuService.update(domain);
        DynaAppmenu rt = domain;
        return dynaAppmenuDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 动态应用菜单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaAppmenuDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"动态应用菜单" },  notes = "DynaAppmenu-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaAppmenu-Save-all') or hasPermission(this.dynaAppmenuDtoMapping.toDomain(#dto),'ibizplm-DynaAppmenu-Save')")
    @PostMapping("dyna_appmenus/save")
    public ResponseEntity<ResponseWrapper<DynaAppmenuDTO>> save
            (@Validated @RequestBody RequestWrapper<DynaAppmenuDTO> dto) {
        ResponseWrapper<DynaAppmenuDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 动态应用菜单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaAppmenuDTO>
    */   
    public DynaAppmenuDTO save
            (DynaAppmenuDTO dto) {
        DynaAppmenu domain = dynaAppmenuDtoMapping.toDomain(dto);
        dynaAppmenuService.save(domain);
        DynaAppmenu rt = domain;
        return dynaAppmenuDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 动态应用菜单
    * 
    *
    * @param id id
    * @return ResponseEntity<DynaAppmenuDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"动态应用菜单" },  notes = "DynaAppmenu-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaAppmenu-Get-all')  or hasPermission(this.dynaAppmenuDtoMapping.toDomain(returnObject.body),'ibizplm-DynaAppmenu-Get')")
    @GetMapping("dyna_appmenus/{id}")
    public ResponseEntity<DynaAppmenuDTO> getById
            (@PathVariable("id") String id) {
        DynaAppmenu rt = dynaAppmenuService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(dynaAppmenuDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 动态应用菜单
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"动态应用菜单" },  notes = "DynaAppmenu-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaAppmenu-Remove-all') or hasPermission(this.dynaAppmenuService.get(#id),'ibizplm-DynaAppmenu-Remove')")
    @DeleteMapping("dyna_appmenus/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = dynaAppmenuService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 动态应用菜单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"动态应用菜单" },  notes = "DynaAppmenu-CheckKey ")
    @PostMapping("dyna_appmenus/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody DynaAppmenuDTO dto) {
        DynaAppmenu domain = dynaAppmenuDtoMapping.toDomain(dto);
        Integer rt = dynaAppmenuService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 动态应用菜单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaAppmenuDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"动态应用菜单" },  notes = "DynaAppmenu-GetDraft ")
    @GetMapping("dyna_appmenus/get_draft")
    public ResponseEntity<DynaAppmenuDTO> getDraft
            (@SpringQueryMap DynaAppmenuDTO dto) {
        DynaAppmenu domain = dynaAppmenuDtoMapping.toDomain(dto);
        DynaAppmenu rt = dynaAppmenuService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dynaAppmenuDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 动态应用菜单
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DynaAppmenuDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"动态应用菜单" },  notes = "DynaAppmenu-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaAppmenu-fetch_default-all') or hasPermission(#dto,'ibizplm-DynaAppmenu-fetch_default')")
    @PostMapping("dyna_appmenus/fetch_default")
    public ResponseEntity<List<DynaAppmenuDTO>> fetchDefault
            (@Validated @RequestBody DynaAppmenuFilterDTO dto) {
        DynaAppmenuSearchContext context = dynaAppmenuFilterDtoMapping.toDomain(dto);
        Page<DynaAppmenu> domains = dynaAppmenuService.fetchDefault(context) ;
        List<DynaAppmenuDTO> list = dynaAppmenuDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建动态应用菜单
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaAppmenu-Create-all')")
    @ApiOperation(value = "批量新建动态应用菜单", tags = {"动态应用菜单" },  notes = "批量新建动态应用菜单")
	@PostMapping("dyna_appmenus/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DynaAppmenuDTO> dtos) {
        dynaAppmenuService.create(dynaAppmenuDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除动态应用菜单
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaAppmenu-Remove-all')")
    @ApiOperation(value = "批量删除动态应用菜单", tags = {"动态应用菜单" },  notes = "批量删除动态应用菜单")
	@DeleteMapping("dyna_appmenus/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dynaAppmenuService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新动态应用菜单
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaAppmenu-Update-all')")
    @ApiOperation(value = "批量更新动态应用菜单", tags = {"动态应用菜单" },  notes = "批量更新动态应用菜单")
	@PutMapping("dyna_appmenus/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DynaAppmenuDTO> dtos) {
        dynaAppmenuService.update(dynaAppmenuDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存动态应用菜单
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaAppmenu-Save-all')")
    @ApiOperation(value = "批量保存动态应用菜单", tags = {"动态应用菜单" },  notes = "批量保存动态应用菜单")
	@PostMapping("dyna_appmenus/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DynaAppmenuDTO> dtos) {
        dynaAppmenuService.save(dynaAppmenuDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入动态应用菜单
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaAppmenu-Save-all')")
    @ApiOperation(value = "批量导入动态应用菜单", tags = {"动态应用菜单" },  notes = "批量导入动态应用菜单")
	@PostMapping("dyna_appmenus/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DynaAppmenuDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(dynaAppmenuService.importData(config,ignoreError,dynaAppmenuDtoMapping.toDomain(dtos)));
    }

}
