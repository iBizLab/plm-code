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
import cn.ibizlab.plm.core.insight.domain.InsightReport;
import cn.ibizlab.plm.core.insight.service.InsightReportService;
import cn.ibizlab.plm.core.insight.filter.InsightReportSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[InsightReport] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightReportResource {

    @Autowired
    public InsightReportService insightReportService;

    @Autowired
    @Lazy
    public InsightReportDTOMapping insightReportDtoMapping;

    @Autowired
    @Lazy
    public InsightReportFilterDTOMapping insightReportFilterDtoMapping;

    /**
    * 创建Create 效能报表
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"效能报表" },  notes = "InsightReport-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Create-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-Create')")
    @PostMapping("insight_reports")
    public ResponseEntity<ResponseWrapper<InsightReportDTO>> create
            (@Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 效能报表
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO create
            (InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        insightReportService.create(domain);
        InsightReport rt = domain;
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"效能报表" },  notes = "InsightReport-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Update-all') or hasPermission(this.insightReportService.get(#id),'ibizplm-InsightReport-Update')")
    @VersionCheck(entity = "insightreport" , versionfield = "updateTime")
    @PutMapping("insight_reports/{id}")
    public ResponseEntity<ResponseWrapper<InsightReportDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO updateById
            (String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        insightReportService.update(domain);
        InsightReport rt = domain;
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */
    @ApiOperation(value = "delete_categories", tags = {"效能报表" },  notes = "InsightReport-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-delete_categories-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-delete_categories')")
    @PostMapping("insight_reports/{id}/delete_categories")
    public ResponseEntity<ResponseWrapper<InsightReportDTO>> deleteCategoriesById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteCategoriesById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteCategoriesById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete_categories 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO deleteCategoriesById
            (String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightReport rt = insightReportService.deleteCategories(domain);
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 效能报表
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"效能报表" },  notes = "InsightReport-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Save-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-Save')")
    @PostMapping("insight_reports/save")
    public ResponseEntity<ResponseWrapper<InsightReportDTO>> save
            (@Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 效能报表
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO save
            (InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        insightReportService.save(domain);
        InsightReport rt = domain;
        return insightReportDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 效能报表
    * 
    *
    * @param id id
    * @return ResponseEntity<InsightReportDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"效能报表" },  notes = "InsightReport-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Get-all')  or hasPermission(this.insightReportDtoMapping.toDomain(returnObject.body),'ibizplm-InsightReport-Get')")
    @GetMapping("insight_reports/{id}")
    public ResponseEntity<InsightReportDTO> getById
            (@PathVariable("id") String id) {
        InsightReport rt = insightReportService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(insightReportDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 效能报表
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"效能报表" },  notes = "InsightReport-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Remove-all') or hasPermission(this.insightReportService.get(#id),'ibizplm-InsightReport-Remove')")
    @DeleteMapping("insight_reports/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = insightReportService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 效能报表
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"效能报表" },  notes = "InsightReport-CheckKey ")
    @PostMapping("insight_reports/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        Integer rt = insightReportService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 效能报表
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"效能报表" },  notes = "InsightReport-GetDraft ")
    @GetMapping("insight_reports/get_draft")
    public ResponseEntity<InsightReportDTO> getDraft
            (@SpringQueryMap InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        InsightReport rt = insightReportService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(insightReportDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 效能报表
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightReportDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"效能报表" },  notes = "InsightReport-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-fetch_default-all') or hasPermission(#dto,'ibizplm-InsightReport-fetch_default')")
    @PostMapping("insight_reports/fetch_default")
    public ResponseEntity<List<InsightReportDTO>> fetchDefault
            (@Validated @RequestBody InsightReportFilterDTO dto) {
        InsightReportSearchContext context = insightReportFilterDtoMapping.toDomain(dto);
        Page<InsightReport> domains = insightReportService.fetchDefault(context) ;
        List<InsightReportDTO> list = insightReportDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建效能报表
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Create-all')")
    @ApiOperation(value = "批量新建效能报表", tags = {"效能报表" },  notes = "批量新建效能报表")
	@PostMapping("insight_reports/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<InsightReportDTO> dtos) {
        insightReportService.create(insightReportDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除效能报表
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Remove-all')")
    @ApiOperation(value = "批量删除效能报表", tags = {"效能报表" },  notes = "批量删除效能报表")
	@DeleteMapping("insight_reports/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        insightReportService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新效能报表
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Update-all')")
    @ApiOperation(value = "批量更新效能报表", tags = {"效能报表" },  notes = "批量更新效能报表")
	@PutMapping("insight_reports/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<InsightReportDTO> dtos) {
        insightReportService.update(insightReportDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存效能报表
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Save-all')")
    @ApiOperation(value = "批量保存效能报表", tags = {"效能报表" },  notes = "批量保存效能报表")
	@PostMapping("insight_reports/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<InsightReportDTO> dtos) {
        insightReportService.save(insightReportDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入效能报表
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Save-all')")
    @ApiOperation(value = "批量导入效能报表", tags = {"效能报表" },  notes = "批量导入效能报表")
	@PostMapping("insight_reports/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<InsightReportDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(insightReportService.importData(config,ignoreError,insightReportDtoMapping.toDomain(dtos)));
    }

}
