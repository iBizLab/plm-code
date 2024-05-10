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
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"项目发布" },  notes = "Release-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Create-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Create')")
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
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Update-all') or hasPermission('project',#projectId,this.releaseService.get(#id),'ibizplm-Release-Update')")
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
    * delete_categories 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "delete_categories", tags = {"项目发布" },  notes = "Release-delete_categories ")
    @PostMapping("projects/{projectId}/releases/{id}/delete_categories")
    public ResponseEntity<ResponseWrapper<ReleaseDTO>> deleteCategoriesByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteCategoriesByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteCategoriesByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete_categories 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO deleteCategoriesByProjectIdAndId
            (String projectId, String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        Release rt = releaseService.deleteCategories(domain);
        return releaseDtoMapping.toDto(rt);
    }

    /**
    * plan_work_item 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "plan_work_item", tags = {"项目发布" },  notes = "Release-plan_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-plan_work_item-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-plan_work_item')")
    @PutMapping("projects/{projectId}/releases/{id}/plan_work_item")
    public ResponseEntity<ResponseWrapper<ReleaseDTO>> planWorkItemByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ReleaseDTO> dto) {
        ResponseWrapper<ReleaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planWorkItemByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planWorkItemByProjectIdAndId(projectId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * plan_work_item 项目发布
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ReleaseDTO>
    */   
    public ReleaseDTO planWorkItemByProjectIdAndId
            (String projectId, String id, ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setId(id);
        Release rt = releaseService.planWorkItem(domain);
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
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Save-all') or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(#dto),'ibizplm-Release-Save')")
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
    * @param projectId projectId
    * @param id id
    * @return ResponseEntity<ReleaseDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"项目发布" },  notes = "Release-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Get-all')  or hasPermission('project',#projectId,this.releaseDtoMapping.toDomain(returnObject.body),'ibizplm-Release-Get')")
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
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-Remove-all') or hasPermission('project',#projectId,this.releaseService.get(#id),'ibizplm-Release-Remove')")
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
    @PostMapping("projects/{projectId}/releases/check_key")
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
    @GetMapping("projects/{projectId}/releases/get_draft")
    public ResponseEntity<ReleaseDTO> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap ReleaseDTO dto) {
        Release domain = releaseDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        Release rt = releaseService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(releaseDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 项目发布
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<List<ReleaseDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"项目发布" },  notes = "Release-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Release-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-Release-fetch_default')")
    @PostMapping("projects/{projectId}/releases/fetch_default")
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


}
