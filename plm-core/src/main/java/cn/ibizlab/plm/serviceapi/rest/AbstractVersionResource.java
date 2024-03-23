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
import cn.ibizlab.plm.core.projmgmt.domain.Version;
import cn.ibizlab.plm.core.projmgmt.service.VersionService;
import cn.ibizlab.plm.core.projmgmt.filter.VersionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Version] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractVersionResource {

    @Autowired
    public VersionService versionService;

    @Autowired
    @Lazy
    public VersionDTOMapping versionDtoMapping;

    @Autowired
    @Lazy
    public VersionFilterDTOMapping versionFilterDtoMapping;

    /**
    * 创建Create 版本（temp）
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"版本（temp）" },  notes = "Version-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Create-all') or hasPermission(this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Create')")
    @PostMapping("versions")
    public ResponseEntity<ResponseWrapper<VersionDTO>> create
            (@Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 版本（temp）
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO create
            (VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        versionService.create(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 版本（temp）
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"版本（temp）" },  notes = "Version-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Update-all') or hasPermission(this.versionService.get(#id),'ibizplm-Version-Update')")
    @VersionCheck(entity = "version" , versionfield = "updateTime")
    @PutMapping("versions/{id}")
    public ResponseEntity<ResponseWrapper<VersionDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 版本（temp）
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO updateById
            (String id, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setId(id);
        versionService.update(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 版本（temp）
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"版本（temp）" },  notes = "Version-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Save-all') or hasPermission(this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Save')")
    @PostMapping("versions/save")
    public ResponseEntity<ResponseWrapper<VersionDTO>> save
            (@Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 版本（temp）
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO save
            (VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        versionService.save(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"版本（temp）" },  notes = "Version-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Create-all') or hasPermission('Project',#projectId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Create')")
    @PostMapping("projects/{projectId}/versions")
    public ResponseEntity<ResponseWrapper<VersionDTO>> createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO createByProjectId
            (String projectId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        versionService.create(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"版本（temp）" },  notes = "Version-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Update-all') or hasPermission('Project',#projectId,this.versionService.get(#id),'ibizplm-Version-Update')")
    @VersionCheck(entity = "version" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/versions/{id}")
    public ResponseEntity<ResponseWrapper<VersionDTO>> updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO updateByProjectIdAndId
            (String projectId, String id, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setId(id);
        versionService.update(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"版本（temp）" },  notes = "Version-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Save-all') or hasPermission('Project',#projectId,this.versionDtoMapping.toDomain(#dto),'ibizplm-Version-Save')")
    @PostMapping("projects/{projectId}/versions/save")
    public ResponseEntity<ResponseWrapper<VersionDTO>> saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<VersionDTO> dto) {
        ResponseWrapper<VersionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */   
    public VersionDTO saveByProjectId
            (String projectId, VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        versionService.save(domain);
        Version rt = domain;
        return versionDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 版本（temp）
    * 
    *
    * @param id id
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"版本（temp）" },  notes = "Version-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Get-all')  or hasPermission(this.versionDtoMapping.toDomain(returnObject.body),'ibizplm-Version-Get')")
    @GetMapping("versions/{id}")
    public ResponseEntity<VersionDTO> getById
            (@PathVariable("id") String id) {
        Version rt = versionService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 版本（temp）
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"版本（temp）" },  notes = "Version-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Remove-all') or hasPermission(this.versionService.get(#id),'ibizplm-Version-Remove')")
    @DeleteMapping("versions/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = versionService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 版本（temp）
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"版本（temp）" },  notes = "Version-CheckKey ")
    @PostMapping("versions/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        Integer rt = versionService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 版本（temp）
    * 
    *
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"版本（temp）" },  notes = "Version-GetDraft ")
    @GetMapping("versions/getdraft")
    public ResponseEntity<VersionDTO> getDraft
            (@SpringQueryMap VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        Version rt = versionService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 版本（temp）
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<VersionDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"版本（temp）" },  notes = "Version-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-FetchDefault-all') or hasPermission(#dto,'ibizplm-Version-FetchDefault')")
    @PostMapping("versions/fetchdefault")
    public ResponseEntity<List<VersionDTO>> fetchDefault
            (@Validated @RequestBody VersionFilterDTO dto) {
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.searchDefault(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"版本（temp）" },  notes = "Version-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Get-all')  or hasPermission('Project',#projectId,this.versionDtoMapping.toDomain(returnObject.body),'ibizplm-Version-Get')")
    @GetMapping("projects/{projectId}/versions/{id}")
    public ResponseEntity<VersionDTO> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Version rt = versionService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"版本（temp）" },  notes = "Version-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-Remove-all') or hasPermission('Project',#projectId,this.versionService.get(#id),'ibizplm-Version-Remove')")
    @DeleteMapping("projects/{projectId}/versions/{id}")
    public ResponseEntity<Boolean> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = versionService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"版本（temp）" },  notes = "Version-CheckKey ")
    @PostMapping("projects/{projectId}/versions/checkkey")
    public ResponseEntity<Integer> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Integer rt = versionService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<VersionDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"版本（temp）" },  notes = "Version-GetDraft ")
    @GetMapping("projects/{projectId}/versions/getdraft")
    public ResponseEntity<VersionDTO> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap VersionDTO dto) {
        Version domain = versionDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Version rt = versionService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(versionDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 版本（temp）
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<VersionDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"版本（temp）" },  notes = "Version-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Version-FetchDefault-all') or hasPermission('Project',#projectId,#dto,'ibizplm-Version-FetchDefault')")
    @PostMapping("projects/{projectId}/versions/fetchdefault")
    public ResponseEntity<List<VersionDTO>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody VersionFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        VersionSearchContext context = versionFilterDtoMapping.toDomain(dto);
        Page<Version> domains = versionService.searchDefault(context) ;
        List<VersionDTO> list = versionDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建版本（temp）
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Create-all')")
    @ApiOperation(value = "批量新建版本（temp）", tags = {"版本（temp）" },  notes = "批量新建版本（temp）")
	@PostMapping("versions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VersionDTO> dtos) {
        versionService.createBatch(versionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除版本（temp）
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Remove-all')")
    @ApiOperation(value = "批量删除版本（temp）", tags = {"版本（temp）" },  notes = "批量删除版本（temp）")
	@DeleteMapping("versions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        versionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新版本（temp）
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Update-all')")
    @ApiOperation(value = "批量更新版本（temp）", tags = {"版本（temp）" },  notes = "批量更新版本（temp）")
	@PutMapping("versions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VersionDTO> dtos) {
        versionService.updateBatch(versionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存版本（temp）
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Save-all')")
    @ApiOperation(value = "批量保存版本（temp）", tags = {"版本（temp）" },  notes = "批量保存版本（temp）")
	@PostMapping("versions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VersionDTO> dtos) {
        versionService.saveBatch(versionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入版本（temp）
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Version-Save-all')")
    @ApiOperation(value = "批量导入版本（temp）", tags = {"版本（temp）" },  notes = "批量导入版本（temp）")
	@PostMapping("versions/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<VersionDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(versionService.importData(config,ignoreError,versionDtoMapping.toDomain(dtos)));
    }

}
