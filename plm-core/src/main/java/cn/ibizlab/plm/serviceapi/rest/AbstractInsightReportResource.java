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
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.serviceapi.dto.*;
import cn.ibizlab.plm.serviceapi.mapping.*;
import cn.ibizlab.plm.core.insight.domain.InsightReport;
import cn.ibizlab.plm.core.insight.service.InsightReportService;
import cn.ibizlab.plm.core.insight.filter.InsightReportSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

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
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"效能报表" },  notes = "InsightReport-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Create-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-Create')")
    @PostMapping("insight_reports")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>create
            (@Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"效能报表" },  notes = "InsightReport-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Update-all') or hasPermission(this.insightReportService.get(#id),'ibizplm-InsightReport-Update')")
    @VersionCheck(entity = "insightreport" , versionfield = "updateTime")
    @PutMapping("insight_reports/{id}")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * copy_report 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "copy_report", tags = {"效能报表" },  notes = "InsightReport-copy_report ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-copy_report-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-copy_report')")
    @PostMapping("insight_reports/{id}/copy_report")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>copyReportById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyReportById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyReportById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy_report 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO copyReportById
            (String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightReport rt = insightReportService.copyReport(domain);
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"效能报表" },  notes = "InsightReport-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-delete_categories-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-delete_categories')")
    @PostMapping("insight_reports/{id}/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>deleteCategoriesById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteCategoriesById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteCategoriesById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"效能报表" },  notes = "InsightReport-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Save-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-Save')")
    @PostMapping("insight_reports/save")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>save
            (@Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * sync_model 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "sync_model", tags = {"效能报表" },  notes = "InsightReport-sync_model ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-sync_model-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-sync_model')")
    @PostMapping("insight_reports/{id}/sync_model")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>syncModelById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(syncModelById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(syncModelById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * sync_model 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO syncModelById
            (String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightReport rt = insightReportService.syncModel(domain);
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * use_cur_template 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "use_cur_template", tags = {"效能报表" },  notes = "InsightReport-use_cur_template ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-use_cur_template-all') or hasPermission(this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-use_cur_template')")
    @PostMapping("insight_reports/{id}/use_cur_template")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>useCurTemplateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(useCurTemplateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(useCurTemplateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * use_cur_template 效能报表
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO useCurTemplateById
            (String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightReport rt = insightReportService.useCurTemplate(domain);
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"效能报表" },  notes = "InsightReport-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Create-all') or hasPermission('insight_view',#viewId,this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-Create')")
    @PostMapping("insight_views/{viewId}/insight_reports")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>createByViewId
            (@PathVariable("viewId") String viewId, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByViewId(viewId, item)));
        else
            rt.set(createByViewId(viewId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO createByViewId
            (String viewId, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setViewId(viewId);
        insightReportService.create(domain);
        InsightReport rt = domain;
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"效能报表" },  notes = "InsightReport-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Update-all') or hasPermission('insight_view',#viewId,this.insightReportService.get(#id),'ibizplm-InsightReport-Update')")
    @VersionCheck(entity = "insightreport" , versionfield = "updateTime")
    @PutMapping("insight_views/{viewId}/insight_reports/{id}")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>updateByViewIdAndId
            (@PathVariable("viewId") String viewId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByViewIdAndId(viewId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByViewIdAndId(viewId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO updateByViewIdAndId
            (String viewId, String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        insightReportService.update(domain);
        InsightReport rt = domain;
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * copy_report 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "copy_report", tags = {"效能报表" },  notes = "InsightReport-copy_report ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-copy_report-all') or hasPermission('insight_view',#viewId,this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-copy_report')")
    @PostMapping("insight_views/{viewId}/insight_reports/{id}/copy_report")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>copyReportByViewIdAndId
            (@PathVariable("viewId") String viewId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyReportByViewIdAndId(viewId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyReportByViewIdAndId(viewId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy_report 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO copyReportByViewIdAndId
            (String viewId, String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightReport rt = insightReportService.copyReport(domain);
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"效能报表" },  notes = "InsightReport-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-delete_categories-all') or hasPermission('insight_view',#viewId,this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-delete_categories')")
    @PostMapping("insight_views/{viewId}/insight_reports/{id}/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>deleteCategoriesByViewIdAndId
            (@PathVariable("viewId") String viewId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteCategoriesByViewIdAndId(viewId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteCategoriesByViewIdAndId(viewId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO deleteCategoriesByViewIdAndId
            (String viewId, String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightReport rt = insightReportService.deleteCategories(domain);
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"效能报表" },  notes = "InsightReport-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Save-all') or hasPermission('insight_view',#viewId,this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-Save')")
    @PostMapping("insight_views/{viewId}/insight_reports/save")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>saveByViewId
            (@PathVariable("viewId") String viewId, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByViewId(viewId, item)));
        else
            rt.set(saveByViewId(viewId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO saveByViewId
            (String viewId, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setViewId(viewId);
        insightReportService.save(domain);
        InsightReport rt = domain;
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * sync_model 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "sync_model", tags = {"效能报表" },  notes = "InsightReport-sync_model ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-sync_model-all') or hasPermission('insight_view',#viewId,this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-sync_model')")
    @PostMapping("insight_views/{viewId}/insight_reports/{id}/sync_model")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>syncModelByViewIdAndId
            (@PathVariable("viewId") String viewId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(syncModelByViewIdAndId(viewId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(syncModelByViewIdAndId(viewId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * sync_model 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO syncModelByViewIdAndId
            (String viewId, String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightReport rt = insightReportService.syncModel(domain);
        return insightReportDtoMapping.toDto(rt);
    }

    /**
    * use_cur_template 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "use_cur_template", tags = {"效能报表" },  notes = "InsightReport-use_cur_template ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-use_cur_template-all') or hasPermission('insight_view',#viewId,this.insightReportDtoMapping.toDomain(#dto),'ibizplm-InsightReport-use_cur_template')")
    @PostMapping("insight_views/{viewId}/insight_reports/{id}/use_cur_template")
    public Mono<ResponseEntity<ResponseWrapper<InsightReportDTO>>>useCurTemplateByViewIdAndId
            (@PathVariable("viewId") String viewId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightReportDTO> dto) {
        ResponseWrapper<InsightReportDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(useCurTemplateByViewIdAndId(viewId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(useCurTemplateByViewIdAndId(viewId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * use_cur_template 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightReportDTO>
    */   
    public InsightReportDTO useCurTemplateByViewIdAndId
            (String viewId, String id, InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setId(id);
        InsightReport rt = insightReportService.useCurTemplate(domain);
        return insightReportDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 效能报表
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"效能报表" },  notes = "InsightReport-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Get-all')  or hasPermission(this.insightReportDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-InsightReport-Get')")
    @GetMapping("insight_reports/{id}")
    public Mono<ResponseEntity<InsightReportDTO>> getById
            (@PathVariable("id") String id) {
        InsightReport rt = insightReportService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightReportDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 效能报表
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"效能报表" },  notes = "InsightReport-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Remove-all') or hasPermission(this.insightReportService.get(#id),'ibizplm-InsightReport-Remove')")
    @DeleteMapping("insight_reports/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = insightReportService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 效能报表
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"效能报表" },  notes = "InsightReport-CheckKey ")
    @PostMapping("insight_reports/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        CheckKeyStatus rt = insightReportService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 效能报表
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"效能报表" },  notes = "InsightReport-GetDraft ")
    @GetMapping("insight_reports/get_draft")
    public Mono<ResponseEntity<InsightReportDTO>> getDraft
            (@SpringQueryMap InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        InsightReport rt = insightReportService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightReportDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 效能报表
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightReportDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"效能报表" },  notes = "InsightReport-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-fetch_default-all') or hasPermission(#dto,'ibizplm-InsightReport-fetch_default')")
    @PostMapping("insight_reports/fetch_default")
    public Mono<ResponseEntity<List<InsightReportDTO>>> fetchDefault
            (@Validated @RequestBody InsightReportFilterDTO dto) {
        InsightReportSearchContext context = insightReportFilterDtoMapping.toDomain(dto);
        Page<InsightReport> domains = insightReportService.fetchDefault(context) ;
        List<InsightReportDTO> list = insightReportDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_is_system 效能报表
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightReportDTO>>>
    */
    @ApiOperation(value = "查询fetch_is_system", tags = {"效能报表" },  notes = "InsightReport-fetch_is_system ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-fetch_is_system-all') or hasPermission(#dto,'ibizplm-InsightReport-fetch_is_system')")
    @PostMapping("insight_reports/fetch_is_system")
    public Mono<ResponseEntity<List<InsightReportDTO>>> fetchIsSystem
            (@Validated @RequestBody InsightReportFilterDTO dto) {
        InsightReportSearchContext context = insightReportFilterDtoMapping.toDomain(dto);
        Page<InsightReport> domains = insightReportService.fetchIsSystem(context) ;
        List<InsightReportDTO> list = insightReportDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 效能报表
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightReportDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"效能报表" },  notes = "InsightReport-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-fetch_normal-all') or hasPermission(#dto,'ibizplm-InsightReport-fetch_normal')")
    @PostMapping("insight_reports/fetch_normal")
    public Mono<ResponseEntity<List<InsightReportDTO>>> fetchNormal
            (@Validated @RequestBody InsightReportFilterDTO dto) {
        InsightReportSearchContext context = insightReportFilterDtoMapping.toDomain(dto);
        Page<InsightReport> domains = insightReportService.fetchNormal(context) ;
        List<InsightReportDTO> list = insightReportDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"效能报表" },  notes = "InsightReport-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Get-all')  or hasPermission('insight_view',#viewId,this.insightReportDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-InsightReport-Get')")
    @GetMapping("insight_views/{viewId}/insight_reports/{id}")
    public Mono<ResponseEntity<InsightReportDTO>> getByViewIdAndId
            (@PathVariable("viewId") String viewId, @PathVariable("id") String id) {
        InsightReport rt = insightReportService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightReportDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 效能报表
    * 
    *
    * @param viewId viewId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"效能报表" },  notes = "InsightReport-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-Remove-all') or hasPermission('insight_view',#viewId,this.insightReportService.get(#id),'ibizplm-InsightReport-Remove')")
    @DeleteMapping("insight_views/{viewId}/insight_reports/{id}")
    public Mono<ResponseEntity<Boolean>> removeByViewIdAndId
            (@PathVariable("viewId") String viewId, @PathVariable("id") String id) {
        Boolean rt = insightReportService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"效能报表" },  notes = "InsightReport-CheckKey ")
    @PostMapping("insight_views/{viewId}/insight_reports/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByViewId
            (@PathVariable("viewId") String viewId, @Validated @RequestBody InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setViewId(viewId);
        CheckKeyStatus rt = insightReportService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return Mono<ResponseEntity<InsightReportDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"效能报表" },  notes = "InsightReport-GetDraft ")
    @GetMapping("insight_views/{viewId}/insight_reports/get_draft")
    public Mono<ResponseEntity<InsightReportDTO>> getDraftByViewId
            (@PathVariable("viewId") String viewId, @SpringQueryMap InsightReportDTO dto) {
        InsightReport domain = insightReportDtoMapping.toDomain(dto);
        domain.setViewId(viewId);
        InsightReport rt = insightReportService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightReportDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightReportDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"效能报表" },  notes = "InsightReport-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-fetch_default-all') or hasPermission('insight_view',#viewId,#dto,'ibizplm-InsightReport-fetch_default')")
    @PostMapping("insight_views/{viewId}/insight_reports/fetch_default")
    public Mono<ResponseEntity<List<InsightReportDTO>>> fetchDefaultByViewId
            (@PathVariable("viewId") String viewId, @Validated @RequestBody InsightReportFilterDTO dto) {
        dto.setViewIdEQ(viewId);
        InsightReportSearchContext context = insightReportFilterDtoMapping.toDomain(dto);
        Page<InsightReport> domains = insightReportService.fetchDefault(context) ;
        List<InsightReportDTO> list = insightReportDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_is_system 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightReportDTO>>>
    */
    @ApiOperation(value = "查询fetch_is_system", tags = {"效能报表" },  notes = "InsightReport-fetch_is_system ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-fetch_is_system-all') or hasPermission('insight_view',#viewId,#dto,'ibizplm-InsightReport-fetch_is_system')")
    @PostMapping("insight_views/{viewId}/insight_reports/fetch_is_system")
    public Mono<ResponseEntity<List<InsightReportDTO>>> fetchIsSystemByViewId
            (@PathVariable("viewId") String viewId, @Validated @RequestBody InsightReportFilterDTO dto) {
        dto.setViewIdEQ(viewId);
        InsightReportSearchContext context = insightReportFilterDtoMapping.toDomain(dto);
        Page<InsightReport> domains = insightReportService.fetchIsSystem(context) ;
        List<InsightReportDTO> list = insightReportDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 效能报表
    * 
    *
    * @param viewId viewId
    * @param dto dto
    * @return Mono<ResponseEntity<List<InsightReportDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"效能报表" },  notes = "InsightReport-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightReport-fetch_normal-all') or hasPermission('insight_view',#viewId,#dto,'ibizplm-InsightReport-fetch_normal')")
    @PostMapping("insight_views/{viewId}/insight_reports/fetch_normal")
    public Mono<ResponseEntity<List<InsightReportDTO>>> fetchNormalByViewId
            (@PathVariable("viewId") String viewId, @Validated @RequestBody InsightReportFilterDTO dto) {
        dto.setViewIdEQ(viewId);
        InsightReportSearchContext context = insightReportFilterDtoMapping.toDomain(dto);
        Page<InsightReport> domains = insightReportService.fetchNormal(context) ;
        List<InsightReportDTO> list = insightReportDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建效能报表
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Create-all')")
    @ApiOperation(value = "批量新建效能报表", tags = {"效能报表" },  notes = "批量新建效能报表")
	@PostMapping("insight_reports/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<InsightReportDTO> dtos) {
        insightReportService.create(insightReportDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除效能报表
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Remove-all')")
    @ApiOperation(value = "批量删除效能报表", tags = {"效能报表" },  notes = "批量删除效能报表")
	@DeleteMapping("insight_reports/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        insightReportService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新效能报表
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Update-all')")
    @ApiOperation(value = "批量更新效能报表", tags = {"效能报表" },  notes = "批量更新效能报表")
	@PutMapping("insight_reports/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<InsightReportDTO> dtos) {
        insightReportService.update(insightReportDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存效能报表
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Save-all')")
    @ApiOperation(value = "批量保存效能报表", tags = {"效能报表" },  notes = "批量保存效能报表")
	@PostMapping("insight_reports/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<InsightReportDTO> dtos) {
        insightReportService.save(insightReportDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入效能报表
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-InsightReport-Save-all')")
    @ApiOperation(value = "批量导入效能报表", tags = {"效能报表" },  notes = "批量导入效能报表")
	@PostMapping("insight_reports/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<InsightReportDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(insightReportService.importData(config,ignoreError,insightReportDtoMapping.toDomain(dtos))));
    }

}
