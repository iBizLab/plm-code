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
import cn.ibizlab.plm.core.projmgmt.domain.SprintSection;
import cn.ibizlab.plm.core.projmgmt.service.SprintSectionService;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSectionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[SprintSection] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintSectionResource {

    @Autowired
    public SprintSectionService sprintSectionService;

    @Autowired
    @Lazy
    public SprintSectionDTOMapping sprintSectionDtoMapping;

    @Autowired
    @Lazy
    public SprintSectionFilterDTOMapping sprintSectionFilterDtoMapping;

    /**
    * 创建Create 迭代分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintSectionDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"迭代分组" },  notes = "SprintSection-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintSection-Create-all') or hasPermission(this.sprintSectionDtoMapping.toDomain(#dto),'ibizplm-SprintSection-Create')")
    @PostMapping("sprint_sections")
    public ResponseEntity<ResponseWrapper<SprintSectionDTO>> create
            (@Validated @RequestBody RequestWrapper<SprintSectionDTO> dto) {
        ResponseWrapper<SprintSectionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 迭代分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintSectionDTO>
    */   
    public SprintSectionDTO create
            (SprintSectionDTO dto) {
        SprintSection domain = sprintSectionDtoMapping.toDomain(dto);
        sprintSectionService.create(domain);
        SprintSection rt = domain;
        return sprintSectionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 迭代分组
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintSectionDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"迭代分组" },  notes = "SprintSection-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintSection-Update-all') or hasPermission(this.sprintSectionService.get(#id),'ibizplm-SprintSection-Update')")
    @VersionCheck(entity = "sprintsection" , versionfield = "updateTime")
    @PutMapping("sprint_sections/{id}")
    public ResponseEntity<ResponseWrapper<SprintSectionDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<SprintSectionDTO> dto) {
        ResponseWrapper<SprintSectionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 迭代分组
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<SprintSectionDTO>
    */   
    public SprintSectionDTO updateById
            (String id, SprintSectionDTO dto) {
        SprintSection domain = sprintSectionDtoMapping.toDomain(dto);
        domain.setId(id);
        sprintSectionService.update(domain);
        SprintSection rt = domain;
        return sprintSectionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 迭代分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintSectionDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"迭代分组" },  notes = "SprintSection-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintSection-Save-all') or hasPermission(this.sprintSectionDtoMapping.toDomain(#dto),'ibizplm-SprintSection-Save')")
    @PostMapping("sprint_sections/save")
    public ResponseEntity<ResponseWrapper<SprintSectionDTO>> save
            (@Validated @RequestBody RequestWrapper<SprintSectionDTO> dto) {
        ResponseWrapper<SprintSectionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 迭代分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintSectionDTO>
    */   
    public SprintSectionDTO save
            (SprintSectionDTO dto) {
        SprintSection domain = sprintSectionDtoMapping.toDomain(dto);
        sprintSectionService.save(domain);
        SprintSection rt = domain;
        return sprintSectionDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 迭代分组
    * 
    *
    * @param id id
    * @return ResponseEntity<SprintSectionDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"迭代分组" },  notes = "SprintSection-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintSection-Get-all')  or hasPermission(this.sprintSectionDtoMapping.toDomain(returnObject.body),'ibizplm-SprintSection-Get')")
    @GetMapping("sprint_sections/{id}")
    public ResponseEntity<SprintSectionDTO> getById
            (@PathVariable("id") String id) {
        SprintSection rt = sprintSectionService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(sprintSectionDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 迭代分组
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"迭代分组" },  notes = "SprintSection-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintSection-Remove-all') or hasPermission(this.sprintSectionService.get(#id),'ibizplm-SprintSection-Remove')")
    @DeleteMapping("sprint_sections/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = sprintSectionService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 迭代分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"迭代分组" },  notes = "SprintSection-CheckKey ")
    @PostMapping("sprint_sections/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody SprintSectionDTO dto) {
        SprintSection domain = sprintSectionDtoMapping.toDomain(dto);
        Integer rt = sprintSectionService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 迭代分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<SprintSectionDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"迭代分组" },  notes = "SprintSection-GetDraft ")
    @GetMapping("sprint_sections/getdraft")
    public ResponseEntity<SprintSectionDTO> getDraft
            (@SpringQueryMap SprintSectionDTO dto) {
        SprintSection domain = sprintSectionDtoMapping.toDomain(dto);
        SprintSection rt = sprintSectionService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sprintSectionDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 迭代分组
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<SprintSectionDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"迭代分组" },  notes = "SprintSection-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-SprintSection-FetchDefault-all') or hasPermission(#dto,'ibizplm-SprintSection-FetchDefault')")
    @PostMapping("sprint_sections/fetchdefault")
    public ResponseEntity<List<SprintSectionDTO>> fetchDefault
            (@Validated @RequestBody SprintSectionFilterDTO dto) {
        SprintSectionSearchContext context = sprintSectionFilterDtoMapping.toDomain(dto);
        Page<SprintSection> domains = sprintSectionService.searchDefault(context) ;
        List<SprintSectionDTO> list = sprintSectionDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建迭代分组
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintSection-Create-all')")
    @ApiOperation(value = "批量新建迭代分组", tags = {"迭代分组" },  notes = "批量新建迭代分组")
	@PostMapping("sprint_sections/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SprintSectionDTO> dtos) {
        sprintSectionService.createBatch(sprintSectionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除迭代分组
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintSection-Remove-all')")
    @ApiOperation(value = "批量删除迭代分组", tags = {"迭代分组" },  notes = "批量删除迭代分组")
	@DeleteMapping("sprint_sections/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sprintSectionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新迭代分组
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintSection-Update-all')")
    @ApiOperation(value = "批量更新迭代分组", tags = {"迭代分组" },  notes = "批量更新迭代分组")
	@PutMapping("sprint_sections/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SprintSectionDTO> dtos) {
        sprintSectionService.updateBatch(sprintSectionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存迭代分组
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintSection-Save-all')")
    @ApiOperation(value = "批量保存迭代分组", tags = {"迭代分组" },  notes = "批量保存迭代分组")
	@PostMapping("sprint_sections/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SprintSectionDTO> dtos) {
        sprintSectionService.saveBatch(sprintSectionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入迭代分组
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-SprintSection-Save-all')")
    @ApiOperation(value = "批量导入迭代分组", tags = {"迭代分组" },  notes = "批量导入迭代分组")
	@PostMapping("sprint_sections/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<SprintSectionDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(sprintSectionService.importData(config,ignoreError,sprintSectionDtoMapping.toDomain(dtos)));
    }

}
