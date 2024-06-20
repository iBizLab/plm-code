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
import cn.ibizlab.plm.core.base.domain.Insight;
import cn.ibizlab.plm.core.base.service.InsightService;
import cn.ibizlab.plm.core.base.filter.InsightSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Insight] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightResource {

    @Autowired
    public InsightService insightService;

    @Autowired
    @Lazy
    public InsightDTOMapping insightDtoMapping;

    @Autowired
    @Lazy
    public InsightFilterDTOMapping insightFilterDtoMapping;

    /**
    * 创建Create 洞察力
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"洞察力" },  notes = "Insight-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Insight-Create-all') or hasPermission(this.insightDtoMapping.toDomain(#dto),'ibizplm-Insight-Create')")
    @PostMapping("insights")
    public ResponseEntity<ResponseWrapper<InsightDTO>> create
            (@Validated @RequestBody RequestWrapper<InsightDTO> dto) {
        ResponseWrapper<InsightDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 洞察力
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightDTO>
    */   
    public InsightDTO create
            (InsightDTO dto) {
        Insight domain = insightDtoMapping.toDomain(dto);
        insightService.create(domain);
        Insight rt = domain;
        return insightDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 洞察力
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"洞察力" },  notes = "Insight-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Insight-Update-all') or hasPermission(this.insightService.get(#id),'ibizplm-Insight-Update')")
    @VersionCheck(entity = "insight" , versionfield = "updateTime")
    @PutMapping("insights/{id}")
    public ResponseEntity<ResponseWrapper<InsightDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightDTO> dto) {
        ResponseWrapper<InsightDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 洞察力
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightDTO>
    */   
    public InsightDTO updateById
            (String id, InsightDTO dto) {
        Insight domain = insightDtoMapping.toDomain(dto);
        domain.setId(id);
        insightService.update(domain);
        Insight rt = domain;
        return insightDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 洞察力
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"洞察力" },  notes = "Insight-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Insight-Save-all') or hasPermission(this.insightDtoMapping.toDomain(#dto),'ibizplm-Insight-Save')")
    @PostMapping("insights/save")
    public ResponseEntity<ResponseWrapper<InsightDTO>> save
            (@Validated @RequestBody RequestWrapper<InsightDTO> dto) {
        ResponseWrapper<InsightDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 洞察力
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightDTO>
    */   
    public InsightDTO save
            (InsightDTO dto) {
        Insight domain = insightDtoMapping.toDomain(dto);
        insightService.save(domain);
        Insight rt = domain;
        return insightDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 洞察力
    * 
    *
    * @param id id
    * @return ResponseEntity<InsightDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"洞察力" },  notes = "Insight-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Insight-Get-all')  or hasPermission(this.insightDtoMapping.toDomain(returnObject.body),'ibizplm-Insight-Get')")
    @GetMapping("insights/{id}")
    public ResponseEntity<InsightDTO> getById
            (@PathVariable("id") String id) {
        Insight rt = insightService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(insightDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 洞察力
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"洞察力" },  notes = "Insight-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Insight-Remove-all') or hasPermission(this.insightService.get(#id),'ibizplm-Insight-Remove')")
    @DeleteMapping("insights/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = insightService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 洞察力
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"洞察力" },  notes = "Insight-CheckKey ")
    @PostMapping("insights/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody InsightDTO dto) {
        Insight domain = insightDtoMapping.toDomain(dto);
        Integer rt = insightService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 洞察力
    * 
    *
    * @param dto dto
    * @return ResponseEntity<InsightDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"洞察力" },  notes = "Insight-GetDraft ")
    @GetMapping("insights/get_draft")
    public ResponseEntity<InsightDTO> getDraft
            (@SpringQueryMap InsightDTO dto) {
        Insight domain = insightDtoMapping.toDomain(dto);
        Insight rt = insightService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(insightDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 洞察力
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<InsightDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"洞察力" },  notes = "Insight-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Insight-fetch_default-all') or hasPermission(#dto,'ibizplm-Insight-fetch_default')")
    @PostMapping("insights/fetch_default")
    public ResponseEntity<List<InsightDTO>> fetchDefault
            (@Validated @RequestBody InsightFilterDTO dto) {
        InsightSearchContext context = insightFilterDtoMapping.toDomain(dto);
        Page<Insight> domains = insightService.fetchDefault(context) ;
        List<InsightDTO> list = insightDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建洞察力
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Insight-Create-all')")
    @ApiOperation(value = "批量新建洞察力", tags = {"洞察力" },  notes = "批量新建洞察力")
	@PostMapping("insights/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<InsightDTO> dtos) {
        insightService.create(insightDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除洞察力
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Insight-Remove-all')")
    @ApiOperation(value = "批量删除洞察力", tags = {"洞察力" },  notes = "批量删除洞察力")
	@DeleteMapping("insights/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        insightService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新洞察力
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Insight-Update-all')")
    @ApiOperation(value = "批量更新洞察力", tags = {"洞察力" },  notes = "批量更新洞察力")
	@PutMapping("insights/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<InsightDTO> dtos) {
        insightService.update(insightDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存洞察力
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Insight-Save-all')")
    @ApiOperation(value = "批量保存洞察力", tags = {"洞察力" },  notes = "批量保存洞察力")
	@PostMapping("insights/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<InsightDTO> dtos) {
        insightService.save(insightDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入洞察力
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Insight-Save-all')")
    @ApiOperation(value = "批量导入洞察力", tags = {"洞察力" },  notes = "批量导入洞察力")
	@PostMapping("insights/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<InsightDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(insightService.importData(config,ignoreError,insightDtoMapping.toDomain(dtos)));
    }

}
