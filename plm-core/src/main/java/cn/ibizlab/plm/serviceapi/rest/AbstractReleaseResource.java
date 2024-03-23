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
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.service.ReleaseService;
import cn.ibizlab.plm.core.projmgmt.filter.ReleaseSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Release] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReleaseResource {

    @Autowired
    public ReleaseService releaseService;

    @Autowired
    @Lazy
    public ReleaseDTOMapping releaseDtoMapping;

    @Autowired
    @Lazy
    public ReleaseFilterDTOMapping releaseFilterDtoMapping;

    /**
    * 创建Create 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"项目发布" },  notes = "Release-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Create-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Create')")
    @PostMapping("releases")
    public ResponseEntity<ResponseWrapper<ReleaseDTO>> create
            (@Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO create
            (ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        releaseService.create(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目发布
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"项目发布" },  notes = "Release-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Update-all') or hasPermission(this.releaseService.get(#id),'ibizplm-Release-Update')")
    @VersionCheck(entity = "release" , versionfield = "updateTime")
    @PutMapping("releases/{id}")
    public ResponseEntity<ResponseWrapper<ReleaseDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 项目发布
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO updateById
            (String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        releaseService.update(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"项目发布" },  notes = "Release-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Save-all') or hasPermission(this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Save')")
    @PostMapping("releases/save")
    public ResponseEntity<ResponseWrapper<ReleaseDTO>> save
            (@Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO save
            (ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        releaseService.save(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"项目发布" },  notes = "Release-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Create-all') or hasPermission('Project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Create')")
    @PostMapping("projects/{projectId}/releases")
    public ResponseEntity<ResponseWrapper<ReleaseDTO>> createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO createByProjectId
            (String projectId, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        releaseService.create(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"项目发布" },  notes = "Release-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Update-all') or hasPermission('Project',#projectId,this.releaseService.get(#id),'ibizplm-Release-Update')")
    @VersionCheck(entity = "release" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/releases/{id}")
    public ResponseEntity<ResponseWrapper<ReleaseDTO>> updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO updateByProjectIdAndId
            (String projectId, String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        releaseService.update(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"项目发布" },  notes = "Release-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Save-all') or hasPermission('Project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Save')")
    @PostMapping("projects/{projectId}/releases/save")
    public ResponseEntity<ResponseWrapper<ReleaseDTO>> saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO saveByProjectId
            (String projectId, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        releaseService.save(domain);
        Release rt = domain;
        return releaseDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 项目发布
    * 
    *
    * @param id id
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"项目发布" },  notes = "Release-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Get-all')  or hasPermission(this.releaseDtoMapping.toDomain(returnObject.body),'ibizplm-Release-Get')")
    @GetMapping("releases/{id}")
    public ResponseEntity<ReleaseDTO> getById
            (@PathVariable("id") String id) {
        Release rt = releaseService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 项目发布
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目发布" },  notes = "Release-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Remove-all') or hasPermission(this.releaseService.get(#id),'ibizplm-Release-Remove')")
    @DeleteMapping("releases/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = releaseService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目发布" },  notes = "Release-CheckKey ")
    @PostMapping("releases/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        Integer rt = releaseService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目发布" },  notes = "Release-GetDraft ")
    @GetMapping("releases/getdraft")
    public ResponseEntity<ReleaseDTO> getDraft
            (@SpringQueryMap ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        Release rt = releaseService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 项目发布
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ReleaseDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"项目发布" },  notes = "Release-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-FetchDefault-all') or hasPermission(#dto,'ibizplm-Release-FetchDefault')")
    @PostMapping("releases/fetchdefault")
    public ResponseEntity<List<ReleaseDTO>> fetchDefault
            (@Validated @RequestBody ReleaseFilterDTO dto) {
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.searchDefault(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"项目发布" },  notes = "Release-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Get-all')  or hasPermission('Project',#projectId,this.releaseDtoMapping.toDomain(returnObject.body),'ibizplm-Release-Get')")
    @GetMapping("projects/{projectId}/releases/{id}")
    public ResponseEntity<ReleaseDTO> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Release rt = releaseService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"项目发布" },  notes = "Release-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Remove-all') or hasPermission('Project',#projectId,this.releaseService.get(#id),'ibizplm-Release-Remove')")
    @DeleteMapping("projects/{projectId}/releases/{id}")
    public ResponseEntity<Boolean> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = releaseService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"项目发布" },  notes = "Release-CheckKey ")
    @PostMapping("projects/{projectId}/releases/checkkey")
    public ResponseEntity<Integer> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Integer rt = releaseService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"项目发布" },  notes = "Release-GetDraft ")
    @GetMapping("projects/{projectId}/releases/getdraft")
    public ResponseEntity<ReleaseDTO> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Release rt = releaseService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<ReleaseDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"项目发布" },  notes = "Release-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-FetchDefault-all') or hasPermission('Project',#projectId,#dto,'ibizplm-Release-FetchDefault')")
    @PostMapping("projects/{projectId}/releases/fetchdefault")
    public ResponseEntity<List<ReleaseDTO>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody ReleaseFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        ReleaseSearchContext context = releaseFilterDtoMapping.toDomain(dto);
        Page<Release> domains = releaseService.searchDefault(context) ;
        List<ReleaseDTO> list = releaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建项目发布
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Create-all')")
    @ApiOperation(value = "批量新建项目发布", tags = {"项目发布" },  notes = "批量新建项目发布")
	@PostMapping("releases/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ReleaseDTO> dtos) {
        releaseService.createBatch(releaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除项目发布
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Remove-all')")
    @ApiOperation(value = "批量删除项目发布", tags = {"项目发布" },  notes = "批量删除项目发布")
	@DeleteMapping("releases/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        releaseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新项目发布
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Update-all')")
    @ApiOperation(value = "批量更新项目发布", tags = {"项目发布" },  notes = "批量更新项目发布")
	@PutMapping("releases/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ReleaseDTO> dtos) {
        releaseService.updateBatch(releaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存项目发布
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Save-all')")
    @ApiOperation(value = "批量保存项目发布", tags = {"项目发布" },  notes = "批量保存项目发布")
	@PostMapping("releases/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ReleaseDTO> dtos) {
        releaseService.saveBatch(releaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入项目发布
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Release-Save-all')")
    @ApiOperation(value = "批量导入项目发布", tags = {"项目发布" },  notes = "批量导入项目发布")
	@PostMapping("releases/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ReleaseDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(releaseService.importData(config,ignoreError,releaseDtoMapping.toDomain(dtos)));
    }

}
