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
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.base.service.DeliverableService;
import cn.ibizlab.plm.core.base.filter.DeliverableSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Deliverable] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDeliverableResource {

    @Autowired
    public DeliverableService deliverableService;

    @Autowired
    @Lazy
    public DeliverableDTOMapping deliverableDtoMapping;

    @Autowired
    @Lazy
    public DeliverableFilterDTOMapping deliverableFilterDtoMapping;

    /**
    * 创建Create 交付物
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DeliverableDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"交付物" },  notes = "Deliverable-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Deliverable-Create-all') or hasPermission(this.deliverableDtoMapping.toDomain(#dto),'ibizplm-Deliverable-Create')")
    @PostMapping("deliverables")
    public ResponseEntity<ResponseWrapper<DeliverableDTO>> create
            (@Validated @RequestBody RequestWrapper<DeliverableDTO> dto) {
        ResponseWrapper<DeliverableDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 交付物
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DeliverableDTO>
    */   
    public DeliverableDTO create
            (DeliverableDTO dto) {
        Deliverable domain = deliverableDtoMapping.toDomain(dto);
        deliverableService.create(domain);
        Deliverable rt = domain;
        return deliverableDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 交付物
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DeliverableDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"交付物" },  notes = "Deliverable-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Deliverable-Update-all') or hasPermission(this.deliverableService.get(#id),'ibizplm-Deliverable-Update')")
    @VersionCheck(entity = "deliverable" , versionfield = "updateTime")
    @PutMapping("deliverables/{id}")
    public ResponseEntity<ResponseWrapper<DeliverableDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<DeliverableDTO> dto) {
        ResponseWrapper<DeliverableDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 交付物
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<DeliverableDTO>
    */   
    public DeliverableDTO updateById
            (String id, DeliverableDTO dto) {
        Deliverable domain = deliverableDtoMapping.toDomain(dto);
        domain.setId(id);
        deliverableService.update(domain);
        Deliverable rt = domain;
        return deliverableDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 交付物
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DeliverableDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"交付物" },  notes = "Deliverable-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Deliverable-Save-all') or hasPermission(this.deliverableDtoMapping.toDomain(#dto),'ibizplm-Deliverable-Save')")
    @PostMapping("deliverables/save")
    public ResponseEntity<ResponseWrapper<DeliverableDTO>> save
            (@Validated @RequestBody RequestWrapper<DeliverableDTO> dto) {
        ResponseWrapper<DeliverableDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 交付物
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DeliverableDTO>
    */   
    public DeliverableDTO save
            (DeliverableDTO dto) {
        Deliverable domain = deliverableDtoMapping.toDomain(dto);
        deliverableService.save(domain);
        Deliverable rt = domain;
        return deliverableDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 交付物
    * 
    *
    * @param id id
    * @return ResponseEntity<DeliverableDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"交付物" },  notes = "Deliverable-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Deliverable-Get-all')  or hasPermission(this.deliverableDtoMapping.toDomain(returnObject.body),'ibizplm-Deliverable-Get')")
    @GetMapping("deliverables/{id}")
    public ResponseEntity<DeliverableDTO> getById
            (@PathVariable("id") String id) {
        Deliverable rt = deliverableService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(deliverableDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 交付物
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"交付物" },  notes = "Deliverable-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Deliverable-Remove-all') or hasPermission(this.deliverableService.get(#id),'ibizplm-Deliverable-Remove')")
    @DeleteMapping("deliverables/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = deliverableService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 交付物
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"交付物" },  notes = "Deliverable-CheckKey ")
    @PostMapping("deliverables/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody DeliverableDTO dto) {
        Deliverable domain = deliverableDtoMapping.toDomain(dto);
        Integer rt = deliverableService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 交付物
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DeliverableDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"交付物" },  notes = "Deliverable-GetDraft ")
    @GetMapping("deliverables/getdraft")
    public ResponseEntity<DeliverableDTO> getDraft
            (@SpringQueryMap DeliverableDTO dto) {
        Deliverable domain = deliverableDtoMapping.toDomain(dto);
        Deliverable rt = deliverableService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(deliverableDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 交付物
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DeliverableDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"交付物" },  notes = "Deliverable-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Deliverable-FetchDefault-all') or hasPermission(#dto,'ibizplm-Deliverable-FetchDefault')")
    @PostMapping("deliverables/fetchdefault")
    public ResponseEntity<List<DeliverableDTO>> fetchDefault
            (@Validated @RequestBody DeliverableFilterDTO dto) {
        DeliverableSearchContext context = deliverableFilterDtoMapping.toDomain(dto);
        Page<Deliverable> domains = deliverableService.searchDefault(context) ;
        List<DeliverableDTO> list = deliverableDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchProject_deliverable 交付物
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<DeliverableDTO>>
    */
    @ApiOperation(value = "查询FetchProject_deliverable", tags = {"交付物" },  notes = "Deliverable-FetchProject_deliverable ")
    @PostMapping("deliverables/fetchproject_deliverable")
    public ResponseEntity<List<DeliverableDTO>> fetchProjectDeliverable
            (@Validated @RequestBody DeliverableFilterDTO dto) {
        DeliverableSearchContext context = deliverableFilterDtoMapping.toDomain(dto);
        Page<Deliverable> domains = deliverableService.searchProjectDeliverable(context) ;
        List<DeliverableDTO> list = deliverableDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建交付物
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Deliverable-Create-all')")
    @ApiOperation(value = "批量新建交付物", tags = {"交付物" },  notes = "批量新建交付物")
	@PostMapping("deliverables/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DeliverableDTO> dtos) {
        deliverableService.createBatch(deliverableDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除交付物
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Deliverable-Remove-all')")
    @ApiOperation(value = "批量删除交付物", tags = {"交付物" },  notes = "批量删除交付物")
	@DeleteMapping("deliverables/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        deliverableService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新交付物
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Deliverable-Update-all')")
    @ApiOperation(value = "批量更新交付物", tags = {"交付物" },  notes = "批量更新交付物")
	@PutMapping("deliverables/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DeliverableDTO> dtos) {
        deliverableService.updateBatch(deliverableDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存交付物
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Deliverable-Save-all')")
    @ApiOperation(value = "批量保存交付物", tags = {"交付物" },  notes = "批量保存交付物")
	@PostMapping("deliverables/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DeliverableDTO> dtos) {
        deliverableService.saveBatch(deliverableDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入交付物
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Deliverable-Save-all')")
    @ApiOperation(value = "批量导入交付物", tags = {"交付物" },  notes = "批量导入交付物")
	@PostMapping("deliverables/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DeliverableDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(deliverableService.importData(config,ignoreError,deliverableDtoMapping.toDomain(dtos)));
    }

}