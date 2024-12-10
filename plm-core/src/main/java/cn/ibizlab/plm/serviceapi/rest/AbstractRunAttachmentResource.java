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
import cn.ibizlab.plm.core.testmgmt.domain.RunAttachment;
import cn.ibizlab.plm.core.testmgmt.service.RunAttachmentService;
import cn.ibizlab.plm.core.testmgmt.filter.RunAttachmentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[RunAttachment] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRunAttachmentResource {

    @Autowired
    public RunAttachmentService runAttachmentService;

    @Autowired
    @Lazy
    public RunAttachmentDTOMapping runAttachmentDtoMapping;

    @Autowired
    @Lazy
    public RunAttachmentFilterDTOMapping runAttachmentFilterDtoMapping;

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例结果附件" },  notes = "RunAttachment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Create-all') or hasPermission(this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Create')")
    @PostMapping("run_attachments")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>create
            (@Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO create
            (RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        runAttachmentService.create(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例结果附件" },  notes = "RunAttachment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Update-all') or hasPermission(this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Update')")
    @VersionCheck(entity = "runattachment" , versionfield = "updateTime")
    @PutMapping("run_attachments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO updateById
            (String id, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setId(id);
        runAttachmentService.update(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例结果附件" },  notes = "RunAttachment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Save-all') or hasPermission(this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Save')")
    @PostMapping("run_attachments/save")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>save
            (@Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO save
            (RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        runAttachmentService.save(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例结果附件" },  notes = "RunAttachment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Create-all') or hasPermission('run',#ownerId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Create')")
    @PostMapping("runs/{ownerId}/run_attachments")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO createByOwnerId
            (String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.create(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例结果附件" },  notes = "RunAttachment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Update-all') or hasPermission('run',#ownerId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Update')")
    @VersionCheck(entity = "runattachment" , versionfield = "updateTime")
    @PutMapping("runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO updateByOwnerIdAndId
            (String ownerId, String id, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setId(id);
        runAttachmentService.update(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例结果附件" },  notes = "RunAttachment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Save-all') or hasPermission('run',#ownerId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Save')")
    @PostMapping("runs/{ownerId}/run_attachments/save")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO saveByOwnerId
            (String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.save(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例结果附件" },  notes = "RunAttachment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Create-all') or hasPermission('test_case',#caseId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Create')")
    @PostMapping("test_cases/{caseId}/runs/{ownerId}/run_attachments")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>createByCaseIdAndOwnerId
            (@PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByCaseIdAndOwnerId(caseId, ownerId, item)));
        else
            rt.set(createByCaseIdAndOwnerId(caseId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO createByCaseIdAndOwnerId
            (String caseId, String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.create(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例结果附件" },  notes = "RunAttachment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Update-all') or hasPermission('test_case',#caseId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Update')")
    @VersionCheck(entity = "runattachment" , versionfield = "updateTime")
    @PutMapping("test_cases/{caseId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>updateByCaseIdAndOwnerIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByCaseIdAndOwnerIdAndId(caseId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByCaseIdAndOwnerIdAndId(caseId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO updateByCaseIdAndOwnerIdAndId
            (String caseId, String ownerId, String id, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setId(id);
        runAttachmentService.update(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例结果附件" },  notes = "RunAttachment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Save-all') or hasPermission('test_case',#caseId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Save')")
    @PostMapping("test_cases/{caseId}/runs/{ownerId}/run_attachments/save")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>saveByCaseIdAndOwnerId
            (@PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByCaseIdAndOwnerId(caseId, ownerId, item)));
        else
            rt.set(saveByCaseIdAndOwnerId(caseId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO saveByCaseIdAndOwnerId
            (String caseId, String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.save(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例结果附件" },  notes = "RunAttachment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Create-all') or hasPermission('library',#testLibraryId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{ownerId}/run_attachments")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>createByTestLibraryIdAndCaseIdAndOwnerId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndCaseIdAndOwnerId(testLibraryId, caseId, ownerId, item)));
        else
            rt.set(createByTestLibraryIdAndCaseIdAndOwnerId(testLibraryId, caseId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO createByTestLibraryIdAndCaseIdAndOwnerId
            (String testLibraryId, String caseId, String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.create(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例结果附件" },  notes = "RunAttachment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Update-all') or hasPermission('library',#testLibraryId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Update')")
    @VersionCheck(entity = "runattachment" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>updateByTestLibraryIdAndCaseIdAndOwnerIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndCaseIdAndOwnerIdAndId(testLibraryId, caseId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndCaseIdAndOwnerIdAndId(testLibraryId, caseId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO updateByTestLibraryIdAndCaseIdAndOwnerIdAndId
            (String testLibraryId, String caseId, String ownerId, String id, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setId(id);
        runAttachmentService.update(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例结果附件" },  notes = "RunAttachment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Save-all') or hasPermission('library',#testLibraryId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{ownerId}/run_attachments/save")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>saveByTestLibraryIdAndCaseIdAndOwnerId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndCaseIdAndOwnerId(testLibraryId, caseId, ownerId, item)));
        else
            rt.set(saveByTestLibraryIdAndCaseIdAndOwnerId(testLibraryId, caseId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO saveByTestLibraryIdAndCaseIdAndOwnerId
            (String testLibraryId, String caseId, String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.save(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例结果附件" },  notes = "RunAttachment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Create-all') or hasPermission('test_plan',#planId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Create')")
    @PostMapping("test_plans/{planId}/runs/{ownerId}/run_attachments")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>createByPlanIdAndOwnerId
            (@PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPlanIdAndOwnerId(planId, ownerId, item)));
        else
            rt.set(createByPlanIdAndOwnerId(planId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO createByPlanIdAndOwnerId
            (String planId, String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.create(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例结果附件" },  notes = "RunAttachment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Update-all') or hasPermission('test_plan',#planId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Update')")
    @VersionCheck(entity = "runattachment" , versionfield = "updateTime")
    @PutMapping("test_plans/{planId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>updateByPlanIdAndOwnerIdAndId
            (@PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPlanIdAndOwnerIdAndId(planId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPlanIdAndOwnerIdAndId(planId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO updateByPlanIdAndOwnerIdAndId
            (String planId, String ownerId, String id, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setId(id);
        runAttachmentService.update(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例结果附件" },  notes = "RunAttachment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Save-all') or hasPermission('test_plan',#planId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Save')")
    @PostMapping("test_plans/{planId}/runs/{ownerId}/run_attachments/save")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>saveByPlanIdAndOwnerId
            (@PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPlanIdAndOwnerId(planId, ownerId, item)));
        else
            rt.set(saveByPlanIdAndOwnerId(planId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO saveByPlanIdAndOwnerId
            (String planId, String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.save(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例结果附件" },  notes = "RunAttachment-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Create-all') or hasPermission('library',#libraryId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Create')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{ownerId}/run_attachments")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>createByLibraryIdAndPlanIdAndOwnerId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryIdAndPlanIdAndOwnerId(libraryId, planId, ownerId, item)));
        else
            rt.set(createByLibraryIdAndPlanIdAndOwnerId(libraryId, planId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO createByLibraryIdAndPlanIdAndOwnerId
            (String libraryId, String planId, String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.create(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例结果附件" },  notes = "RunAttachment-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Update-all') or hasPermission('library',#libraryId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Update')")
    @VersionCheck(entity = "runattachment" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/test_plans/{planId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>updateByLibraryIdAndPlanIdAndOwnerIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndPlanIdAndOwnerIdAndId(libraryId, planId, ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndPlanIdAndOwnerIdAndId(libraryId, planId, ownerId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO updateByLibraryIdAndPlanIdAndOwnerIdAndId
            (String libraryId, String planId, String ownerId, String id, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setId(id);
        runAttachmentService.update(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例结果附件" },  notes = "RunAttachment-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Save-all') or hasPermission('library',#libraryId,this.runAttachmentDtoMapping.toDomain(#dto),'ibizplm-RunAttachment-Save')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{ownerId}/run_attachments/save")
    public Mono<ResponseEntity<ResponseWrapper<RunAttachmentDTO>>>saveByLibraryIdAndPlanIdAndOwnerId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<RunAttachmentDTO> dto) {
        ResponseWrapper<RunAttachmentDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryIdAndPlanIdAndOwnerId(libraryId, planId, ownerId, item)));
        else
            rt.set(saveByLibraryIdAndPlanIdAndOwnerId(libraryId, planId, ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<RunAttachmentDTO>
    */   
    public RunAttachmentDTO saveByLibraryIdAndPlanIdAndOwnerId
            (String libraryId, String planId, String ownerId, RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        runAttachmentService.save(domain);
        RunAttachment rt = domain;
        return runAttachmentDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 执行用例结果附件
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例结果附件" },  notes = "RunAttachment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Get-all')  or hasPermission(this.runAttachmentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-RunAttachment-Get')")
    @GetMapping("run_attachments/{id}")
    public Mono<ResponseEntity<RunAttachmentDTO>> getById
            (@PathVariable("id") String id) {
        RunAttachment rt = runAttachmentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 执行用例结果附件
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例结果附件" },  notes = "RunAttachment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Remove-all') or hasPermission(this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Remove')")
    @DeleteMapping("run_attachments/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = runAttachmentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例结果附件" },  notes = "RunAttachment-CheckKey ")
    @PostMapping("run_attachments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        CheckKeyStatus rt = runAttachmentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例结果附件" },  notes = "RunAttachment-GetDraft ")
    @GetMapping("run_attachments/get_draft")
    public Mono<ResponseEntity<RunAttachmentDTO>> getDraft
            (@SpringQueryMap RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        RunAttachment rt = runAttachmentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 执行用例结果附件
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<RunAttachmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例结果附件" },  notes = "RunAttachment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-fetch_default-all') or hasPermission(#dto,'ibizplm-RunAttachment-fetch_default')")
    @PostMapping("run_attachments/fetch_default")
    public Mono<ResponseEntity<List<RunAttachmentDTO>>> fetchDefault
            (@Validated @RequestBody RunAttachmentFilterDTO dto) {
        RunAttachmentSearchContext context = runAttachmentFilterDtoMapping.toDomain(dto);
        Page<RunAttachment> domains = runAttachmentService.fetchDefault(context) ;
        List<RunAttachmentDTO> list = runAttachmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例结果附件" },  notes = "RunAttachment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Get-all')  or hasPermission('run',#ownerId,this.runAttachmentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-RunAttachment-Get')")
    @GetMapping("runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<RunAttachmentDTO>> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        RunAttachment rt = runAttachmentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例结果附件" },  notes = "RunAttachment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Remove-all') or hasPermission('run',#ownerId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Remove')")
    @DeleteMapping("runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = runAttachmentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例结果附件" },  notes = "RunAttachment-CheckKey ")
    @PostMapping("runs/{ownerId}/run_attachments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = runAttachmentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例结果附件" },  notes = "RunAttachment-GetDraft ")
    @GetMapping("runs/{ownerId}/run_attachments/get_draft")
    public Mono<ResponseEntity<RunAttachmentDTO>> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        RunAttachment rt = runAttachmentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 执行用例结果附件
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<RunAttachmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例结果附件" },  notes = "RunAttachment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-fetch_default-all') or hasPermission('run',#ownerId,#dto,'ibizplm-RunAttachment-fetch_default')")
    @PostMapping("runs/{ownerId}/run_attachments/fetch_default")
    public Mono<ResponseEntity<List<RunAttachmentDTO>>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        RunAttachmentSearchContext context = runAttachmentFilterDtoMapping.toDomain(dto);
        Page<RunAttachment> domains = runAttachmentService.fetchDefault(context) ;
        List<RunAttachmentDTO> list = runAttachmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例结果附件" },  notes = "RunAttachment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Get-all')  or hasPermission('test_case',#caseId,this.runAttachmentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-RunAttachment-Get')")
    @GetMapping("test_cases/{caseId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<RunAttachmentDTO>> getByCaseIdAndOwnerIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        RunAttachment rt = runAttachmentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例结果附件" },  notes = "RunAttachment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Remove-all') or hasPermission('test_case',#caseId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Remove')")
    @DeleteMapping("test_cases/{caseId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByCaseIdAndOwnerIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = runAttachmentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例结果附件" },  notes = "RunAttachment-CheckKey ")
    @PostMapping("test_cases/{caseId}/runs/{ownerId}/run_attachments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByCaseIdAndOwnerId
            (@PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = runAttachmentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例结果附件" },  notes = "RunAttachment-GetDraft ")
    @GetMapping("test_cases/{caseId}/runs/{ownerId}/run_attachments/get_draft")
    public Mono<ResponseEntity<RunAttachmentDTO>> getDraftByCaseIdAndOwnerId
            (@PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @SpringQueryMap RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        RunAttachment rt = runAttachmentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 执行用例结果附件
    * 
    *
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<RunAttachmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例结果附件" },  notes = "RunAttachment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-fetch_default-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-RunAttachment-fetch_default')")
    @PostMapping("test_cases/{caseId}/runs/{ownerId}/run_attachments/fetch_default")
    public Mono<ResponseEntity<List<RunAttachmentDTO>>> fetchDefaultByCaseIdAndOwnerId
            (@PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        RunAttachmentSearchContext context = runAttachmentFilterDtoMapping.toDomain(dto);
        Page<RunAttachment> domains = runAttachmentService.fetchDefault(context) ;
        List<RunAttachmentDTO> list = runAttachmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例结果附件" },  notes = "RunAttachment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Get-all')  or hasPermission('library',#testLibraryId,this.runAttachmentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-RunAttachment-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<RunAttachmentDTO>> getByTestLibraryIdAndCaseIdAndOwnerIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        RunAttachment rt = runAttachmentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例结果附件" },  notes = "RunAttachment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Remove-all') or hasPermission('library',#testLibraryId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTestLibraryIdAndCaseIdAndOwnerIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = runAttachmentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例结果附件" },  notes = "RunAttachment-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{ownerId}/run_attachments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTestLibraryIdAndCaseIdAndOwnerId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = runAttachmentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例结果附件" },  notes = "RunAttachment-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{ownerId}/run_attachments/get_draft")
    public Mono<ResponseEntity<RunAttachmentDTO>> getDraftByTestLibraryIdAndCaseIdAndOwnerId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @SpringQueryMap RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        RunAttachment rt = runAttachmentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 执行用例结果附件
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<RunAttachmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例结果附件" },  notes = "RunAttachment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-RunAttachment-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{ownerId}/run_attachments/fetch_default")
    public Mono<ResponseEntity<List<RunAttachmentDTO>>> fetchDefaultByTestLibraryIdAndCaseIdAndOwnerId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        RunAttachmentSearchContext context = runAttachmentFilterDtoMapping.toDomain(dto);
        Page<RunAttachment> domains = runAttachmentService.fetchDefault(context) ;
        List<RunAttachmentDTO> list = runAttachmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例结果附件" },  notes = "RunAttachment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Get-all')  or hasPermission('test_plan',#planId,this.runAttachmentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-RunAttachment-Get')")
    @GetMapping("test_plans/{planId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<RunAttachmentDTO>> getByPlanIdAndOwnerIdAndId
            (@PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        RunAttachment rt = runAttachmentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例结果附件" },  notes = "RunAttachment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Remove-all') or hasPermission('test_plan',#planId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Remove')")
    @DeleteMapping("test_plans/{planId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByPlanIdAndOwnerIdAndId
            (@PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = runAttachmentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例结果附件" },  notes = "RunAttachment-CheckKey ")
    @PostMapping("test_plans/{planId}/runs/{ownerId}/run_attachments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByPlanIdAndOwnerId
            (@PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = runAttachmentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例结果附件" },  notes = "RunAttachment-GetDraft ")
    @GetMapping("test_plans/{planId}/runs/{ownerId}/run_attachments/get_draft")
    public Mono<ResponseEntity<RunAttachmentDTO>> getDraftByPlanIdAndOwnerId
            (@PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @SpringQueryMap RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        RunAttachment rt = runAttachmentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 执行用例结果附件
    * 
    *
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<RunAttachmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例结果附件" },  notes = "RunAttachment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-fetch_default-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-RunAttachment-fetch_default')")
    @PostMapping("test_plans/{planId}/runs/{ownerId}/run_attachments/fetch_default")
    public Mono<ResponseEntity<List<RunAttachmentDTO>>> fetchDefaultByPlanIdAndOwnerId
            (@PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        RunAttachmentSearchContext context = runAttachmentFilterDtoMapping.toDomain(dto);
        Page<RunAttachment> domains = runAttachmentService.fetchDefault(context) ;
        List<RunAttachmentDTO> list = runAttachmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例结果附件" },  notes = "RunAttachment-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Get-all')  or hasPermission('library',#libraryId,this.runAttachmentDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-RunAttachment-Get')")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<RunAttachmentDTO>> getByLibraryIdAndPlanIdAndOwnerIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        RunAttachment rt = runAttachmentService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例结果附件" },  notes = "RunAttachment-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-Remove-all') or hasPermission('library',#libraryId,this.runAttachmentService.get(#id),'ibizplm-RunAttachment-Remove')")
    @DeleteMapping("libraries/{libraryId}/test_plans/{planId}/runs/{ownerId}/run_attachments/{id}")
    public Mono<ResponseEntity<Boolean>> removeByLibraryIdAndPlanIdAndOwnerIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = runAttachmentService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例结果附件" },  notes = "RunAttachment-CheckKey ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{ownerId}/run_attachments/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByLibraryIdAndPlanIdAndOwnerId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = runAttachmentService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<RunAttachmentDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例结果附件" },  notes = "RunAttachment-GetDraft ")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{ownerId}/run_attachments/get_draft")
    public Mono<ResponseEntity<RunAttachmentDTO>> getDraftByLibraryIdAndPlanIdAndOwnerId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @SpringQueryMap RunAttachmentDTO dto) {
        RunAttachment domain = runAttachmentDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        RunAttachment rt = runAttachmentService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 执行用例结果附件
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<RunAttachmentDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例结果附件" },  notes = "RunAttachment-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunAttachment-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-RunAttachment-fetch_default')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{ownerId}/run_attachments/fetch_default")
    public Mono<ResponseEntity<List<RunAttachmentDTO>>> fetchDefaultByLibraryIdAndPlanIdAndOwnerId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("ownerId") String ownerId, @Validated @RequestBody RunAttachmentFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        RunAttachmentSearchContext context = runAttachmentFilterDtoMapping.toDomain(dto);
        Page<RunAttachment> domains = runAttachmentService.fetchDefault(context) ;
        List<RunAttachmentDTO> list = runAttachmentDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建执行用例结果附件
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Create-all')")
    @ApiOperation(value = "批量新建执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量新建执行用例结果附件")
	@PostMapping("run_attachments/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<RunAttachmentDTO> dtos) {
        runAttachmentService.create(runAttachmentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除执行用例结果附件
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Remove-all')")
    @ApiOperation(value = "批量删除执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量删除执行用例结果附件")
	@DeleteMapping("run_attachments/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        runAttachmentService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新执行用例结果附件
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Update-all')")
    @ApiOperation(value = "批量更新执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量更新执行用例结果附件")
	@PutMapping("run_attachments/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<RunAttachmentDTO> dtos) {
        runAttachmentService.update(runAttachmentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存执行用例结果附件
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Save-all')")
    @ApiOperation(value = "批量保存执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量保存执行用例结果附件")
	@PostMapping("run_attachments/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<RunAttachmentDTO> dtos) {
        runAttachmentService.save(runAttachmentDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入执行用例结果附件
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunAttachment-Save-all')")
    @ApiOperation(value = "批量导入执行用例结果附件", tags = {"执行用例结果附件" },  notes = "批量导入执行用例结果附件")
	@PostMapping("run_attachments/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RunAttachmentDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(runAttachmentService.importData(config,ignoreError,runAttachmentDtoMapping.toDomain(dtos))));
    }

}
