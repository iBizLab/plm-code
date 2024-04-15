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
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.base.filter.RelationSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Relation] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRelationResource {

    @Autowired
    public RelationService relationService;

    @Autowired
    @Lazy
    public RelationDTOMapping relationDtoMapping;

    @Autowired
    @Lazy
    public RelationFilterDTOMapping relationFilterDtoMapping;

    /**
    * 创建Create 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"关联" },  notes = "Relation-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Create-all') or hasPermission(this.relationDtoMapping.toDomain(#dto),'ibizplm-Relation-Create')")
    @PostMapping("relations")
    public ResponseEntity<ResponseWrapper<RelationDTO>> create
            (@Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO create
            (RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        relationService.create(domain);
        Relation rt = domain;
        return relationDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"关联" },  notes = "Relation-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Update-all') or hasPermission(this.relationService.get(#id),'ibizplm-Relation-Update')")
    @VersionCheck(entity = "relation" , versionfield = "updateTime")
    @PutMapping("relations/{id}")
    public ResponseEntity<ResponseWrapper<RelationDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO updateById
            (String id, RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        domain.setId(id);
        relationService.update(domain);
        Relation rt = domain;
        return relationDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"关联" },  notes = "Relation-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Save-all') or hasPermission(this.relationDtoMapping.toDomain(#dto),'ibizplm-Relation-Save')")
    @PostMapping("relations/save")
    public ResponseEntity<ResponseWrapper<RelationDTO>> save
            (@Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO save
            (RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        relationService.save(domain);
        Relation rt = domain;
        return relationDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 关联
    * 
    *
    * @param id id
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"关联" },  notes = "Relation-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Get-all')  or hasPermission(this.relationDtoMapping.toDomain(returnObject.body),'ibizplm-Relation-Get')")
    @GetMapping("relations/{id}")
    public ResponseEntity<RelationDTO> getById
            (@PathVariable("id") String id) {
        Relation rt = relationService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(relationDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 关联
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"关联" },  notes = "Relation-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Remove-all') or hasPermission(this.relationService.get(#id),'ibizplm-Relation-Remove')")
    @DeleteMapping("relations/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = relationService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"关联" },  notes = "Relation-CheckKey ")
    @PostMapping("relations/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        Integer rt = relationService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"关联" },  notes = "Relation-GetDraft ")
    @GetMapping("relations/get_draft")
    public ResponseEntity<RelationDTO> getDraft
            (@SpringQueryMap RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        Relation rt = relationService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(relationDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"关联" },  notes = "Relation-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_default-all') or hasPermission(#dto,'ibizplm-Relation-fetch_default')")
    @PostMapping("relations/fetch_default")
    public ResponseEntity<List<RelationDTO>> fetchDefault
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.searchDefault(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建关联
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Create-all')")
    @ApiOperation(value = "批量新建关联", tags = {"关联" },  notes = "批量新建关联")
	@PostMapping("relations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<RelationDTO> dtos) {
        relationService.createBatch(relationDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除关联
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Remove-all')")
    @ApiOperation(value = "批量删除关联", tags = {"关联" },  notes = "批量删除关联")
	@DeleteMapping("relations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        relationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新关联
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Update-all')")
    @ApiOperation(value = "批量更新关联", tags = {"关联" },  notes = "批量更新关联")
	@PutMapping("relations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<RelationDTO> dtos) {
        relationService.updateBatch(relationDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存关联
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Save-all')")
    @ApiOperation(value = "批量保存关联", tags = {"关联" },  notes = "批量保存关联")
	@PostMapping("relations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<RelationDTO> dtos) {
        relationService.saveBatch(relationDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入关联
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Save-all')")
    @ApiOperation(value = "批量导入关联", tags = {"关联" },  notes = "批量导入关联")
	@PostMapping("relations/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RelationDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(relationService.importData(config,ignoreError,relationDtoMapping.toDomain(dtos)));
    }

}
