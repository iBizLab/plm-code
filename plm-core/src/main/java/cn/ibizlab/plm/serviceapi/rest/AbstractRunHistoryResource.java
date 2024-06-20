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
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.service.RunHistoryService;
import cn.ibizlab.plm.core.testmgmt.filter.RunHistorySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[RunHistory] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRunHistoryResource {

    @Autowired
    public RunHistoryService runHistoryService;

    @Autowired
    @Lazy
    public RunHistoryDTOMapping runHistoryDtoMapping;

    @Autowired
    @Lazy
    public RunHistoryFilterDTOMapping runHistoryFilterDtoMapping;

    /**
    * 创建Create 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行结果" },  notes = "RunHistory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Create-all') or hasPermission(this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Create')")
    @PostMapping("run_histories")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> create
            (@Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO create
            (RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        runHistoryService.create(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行结果" },  notes = "RunHistory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Update-all') or hasPermission(this.runHistoryService.get(#id),'ibizplm-RunHistory-Update')")
    @VersionCheck(entity = "runhistory" , versionfield = "updateTime")
    @PutMapping("run_histories/{id}")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO updateById
            (String id, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        runHistoryService.update(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行结果" },  notes = "RunHistory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Save-all') or hasPermission(this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Save')")
    @PostMapping("run_histories/save")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> save
            (@Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO save
            (RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        runHistoryService.save(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行结果" },  notes = "RunHistory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Create-all') or hasPermission('run',#runId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Create')")
    @PostMapping("runs/{runId}/run_histories")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> createByRunId
            (@PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByRunId(runId, item)));
        else
            rt.set(createByRunId(runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO createByRunId
            (String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.create(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行结果" },  notes = "RunHistory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Update-all') or hasPermission('run',#runId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Update')")
    @VersionCheck(entity = "runhistory" , versionfield = "updateTime")
    @PutMapping("runs/{runId}/run_histories/{id}")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> updateByRunIdAndId
            (@PathVariable("runId") String runId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByRunIdAndId(runId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByRunIdAndId(runId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO updateByRunIdAndId
            (String runId, String id, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        runHistoryService.update(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行结果" },  notes = "RunHistory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Save-all') or hasPermission('run',#runId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Save')")
    @PostMapping("runs/{runId}/run_histories/save")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> saveByRunId
            (@PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByRunId(runId, item)));
        else
            rt.set(saveByRunId(runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO saveByRunId
            (String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.save(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行结果" },  notes = "RunHistory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Create-all') or hasPermission('test_case',#caseId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Create')")
    @PostMapping("test_cases/{caseId}/runs/{runId}/run_histories")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> createByCaseIdAndRunId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByCaseIdAndRunId(caseId, runId, item)));
        else
            rt.set(createByCaseIdAndRunId(caseId, runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO createByCaseIdAndRunId
            (String caseId, String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.create(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行结果" },  notes = "RunHistory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Update-all') or hasPermission('test_case',#caseId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Update')")
    @VersionCheck(entity = "runhistory" , versionfield = "updateTime")
    @PutMapping("test_cases/{caseId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> updateByCaseIdAndRunIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByCaseIdAndRunIdAndId(caseId, runId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByCaseIdAndRunIdAndId(caseId, runId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO updateByCaseIdAndRunIdAndId
            (String caseId, String runId, String id, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        runHistoryService.update(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行结果" },  notes = "RunHistory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Save-all') or hasPermission('test_case',#caseId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Save')")
    @PostMapping("test_cases/{caseId}/runs/{runId}/run_histories/save")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> saveByCaseIdAndRunId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByCaseIdAndRunId(caseId, runId, item)));
        else
            rt.set(saveByCaseIdAndRunId(caseId, runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO saveByCaseIdAndRunId
            (String caseId, String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.save(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行结果" },  notes = "RunHistory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Create-all') or hasPermission('library',#testLibraryId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> createByTestLibraryIdAndCaseIdAndRunId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndCaseIdAndRunId(testLibraryId, caseId, runId, item)));
        else
            rt.set(createByTestLibraryIdAndCaseIdAndRunId(testLibraryId, caseId, runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO createByTestLibraryIdAndCaseIdAndRunId
            (String testLibraryId, String caseId, String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.create(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行结果" },  notes = "RunHistory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Update-all') or hasPermission('library',#testLibraryId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Update')")
    @VersionCheck(entity = "runhistory" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> updateByTestLibraryIdAndCaseIdAndRunIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndCaseIdAndRunIdAndId(testLibraryId, caseId, runId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndCaseIdAndRunIdAndId(testLibraryId, caseId, runId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO updateByTestLibraryIdAndCaseIdAndRunIdAndId
            (String testLibraryId, String caseId, String runId, String id, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        runHistoryService.update(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行结果" },  notes = "RunHistory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Save-all') or hasPermission('library',#testLibraryId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/save")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> saveByTestLibraryIdAndCaseIdAndRunId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndCaseIdAndRunId(testLibraryId, caseId, runId, item)));
        else
            rt.set(saveByTestLibraryIdAndCaseIdAndRunId(testLibraryId, caseId, runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO saveByTestLibraryIdAndCaseIdAndRunId
            (String testLibraryId, String caseId, String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.save(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行结果" },  notes = "RunHistory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Create-all') or hasPermission('test_plan',#planId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Create')")
    @PostMapping("test_plans/{planId}/runs/{runId}/run_histories")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> createByPlanIdAndRunId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPlanIdAndRunId(planId, runId, item)));
        else
            rt.set(createByPlanIdAndRunId(planId, runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO createByPlanIdAndRunId
            (String planId, String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.create(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行结果" },  notes = "RunHistory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Update-all') or hasPermission('test_plan',#planId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Update')")
    @VersionCheck(entity = "runhistory" , versionfield = "updateTime")
    @PutMapping("test_plans/{planId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> updateByPlanIdAndRunIdAndId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPlanIdAndRunIdAndId(planId, runId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPlanIdAndRunIdAndId(planId, runId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO updateByPlanIdAndRunIdAndId
            (String planId, String runId, String id, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        runHistoryService.update(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行结果" },  notes = "RunHistory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Save-all') or hasPermission('test_plan',#planId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Save')")
    @PostMapping("test_plans/{planId}/runs/{runId}/run_histories/save")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> saveByPlanIdAndRunId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPlanIdAndRunId(planId, runId, item)));
        else
            rt.set(saveByPlanIdAndRunId(planId, runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO saveByPlanIdAndRunId
            (String planId, String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.save(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行结果" },  notes = "RunHistory-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Create-all') or hasPermission('library',#libraryId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Create')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> createByLibraryIdAndPlanIdAndRunId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryIdAndPlanIdAndRunId(libraryId, planId, runId, item)));
        else
            rt.set(createByLibraryIdAndPlanIdAndRunId(libraryId, planId, runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO createByLibraryIdAndPlanIdAndRunId
            (String libraryId, String planId, String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.create(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行结果" },  notes = "RunHistory-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Update-all') or hasPermission('library',#libraryId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Update')")
    @VersionCheck(entity = "runhistory" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> updateByLibraryIdAndPlanIdAndRunIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndPlanIdAndRunIdAndId(libraryId, planId, runId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndPlanIdAndRunIdAndId(libraryId, planId, runId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO updateByLibraryIdAndPlanIdAndRunIdAndId
            (String libraryId, String planId, String runId, String id, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        runHistoryService.update(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行结果" },  notes = "RunHistory-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Save-all') or hasPermission('library',#libraryId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-Save')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/save")
    public ResponseEntity<ResponseWrapper<RunHistoryDTO>> saveByLibraryIdAndPlanIdAndRunId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RequestWrapper<RunHistoryDTO> dto) {
        ResponseWrapper<RunHistoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryIdAndPlanIdAndRunId(libraryId, planId, runId, item)));
        else
            rt.set(saveByLibraryIdAndPlanIdAndRunId(libraryId, planId, runId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */   
    public RunHistoryDTO saveByLibraryIdAndPlanIdAndRunId
            (String libraryId, String planId, String runId, RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        runHistoryService.save(domain);
        RunHistory rt = domain;
        return runHistoryDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 执行结果
    * 
    *
    * @param id id
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行结果" },  notes = "RunHistory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Get-all')  or hasPermission(this.runHistoryDtoMapping.toDomain(returnObject.body),'ibizplm-RunHistory-Get')")
    @GetMapping("run_histories/{id}")
    public ResponseEntity<RunHistoryDTO> getById
            (@PathVariable("id") String id) {
        RunHistory rt = runHistoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行结果
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行结果" },  notes = "RunHistory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Remove-all') or hasPermission(this.runHistoryService.get(#id),'ibizplm-RunHistory-Remove')")
    @DeleteMapping("run_histories/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = runHistoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行结果" },  notes = "RunHistory-CheckKey ")
    @PostMapping("run_histories/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        Integer rt = runHistoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行结果" },  notes = "RunHistory-GetDraft ")
    @GetMapping("run_histories/get_draft")
    public ResponseEntity<RunHistoryDTO> getDraft
            (@SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        RunHistory rt = runHistoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行结果
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行结果" },  notes = "RunHistory-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-run_history_get-all') or hasPermission(this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-run_history_get')")
    @GetMapping("run_histories/{id}/run_history_get")
    public ResponseEntity<RunHistoryDTO> runHistoryGetById
            (@PathVariable("id") String id, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        RunHistory rt = runHistoryService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行结果" },  notes = "RunHistory-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_default-all') or hasPermission(#dto,'ibizplm-RunHistory-fetch_default')")
    @PostMapping("run_histories/fetch_default")
    public ResponseEntity<List<RunHistoryDTO>> fetchDefault
            (@Validated @RequestBody RunHistoryFilterDTO dto) {
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchDefault(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_this 执行结果
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_this", tags = {"执行结果" },  notes = "RunHistory-fetch_this ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_this-all') or hasPermission(#dto,'ibizplm-RunHistory-fetch_this')")
    @PostMapping("run_histories/fetch_this")
    public ResponseEntity<List<RunHistoryDTO>> fetchThis
            (@Validated @RequestBody RunHistoryFilterDTO dto) {
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchThis(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行结果
    * 
    *
    * @param runId runId
    * @param id id
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行结果" },  notes = "RunHistory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Get-all')  or hasPermission('run',#runId,this.runHistoryDtoMapping.toDomain(returnObject.body),'ibizplm-RunHistory-Get')")
    @GetMapping("runs/{runId}/run_histories/{id}")
    public ResponseEntity<RunHistoryDTO> getByRunIdAndId
            (@PathVariable("runId") String runId, @PathVariable("id") String id) {
        RunHistory rt = runHistoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行结果
    * 
    *
    * @param runId runId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行结果" },  notes = "RunHistory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Remove-all') or hasPermission('run',#runId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Remove')")
    @DeleteMapping("runs/{runId}/run_histories/{id}")
    public ResponseEntity<Boolean> removeByRunIdAndId
            (@PathVariable("runId") String runId, @PathVariable("id") String id) {
        Boolean rt = runHistoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行结果
    * 
    *
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行结果" },  notes = "RunHistory-CheckKey ")
    @PostMapping("runs/{runId}/run_histories/check_key")
    public ResponseEntity<Integer> checkKeyByRunId
            (@PathVariable("runId") String runId, @Validated @RequestBody RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        Integer rt = runHistoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 执行结果
    * 
    *
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行结果" },  notes = "RunHistory-GetDraft ")
    @GetMapping("runs/{runId}/run_histories/get_draft")
    public ResponseEntity<RunHistoryDTO> getDraftByRunId
            (@PathVariable("runId") String runId, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        RunHistory rt = runHistoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行结果
    * 
    *
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行结果" },  notes = "RunHistory-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-run_history_get-all') or hasPermission('run',#runId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-run_history_get')")
    @GetMapping("runs/{runId}/run_histories/{id}/run_history_get")
    public ResponseEntity<RunHistoryDTO> runHistoryGetByRunIdAndId
            (@PathVariable("runId") String runId, @PathVariable("id") String id, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        RunHistory rt = runHistoryService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 执行结果
    * 
    *
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行结果" },  notes = "RunHistory-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_default-all') or hasPermission('run',#runId,#dto,'ibizplm-RunHistory-fetch_default')")
    @PostMapping("runs/{runId}/run_histories/fetch_default")
    public ResponseEntity<List<RunHistoryDTO>> fetchDefaultByRunId
            (@PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchDefault(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_this 执行结果
    * 
    *
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_this", tags = {"执行结果" },  notes = "RunHistory-fetch_this ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_this-all') or hasPermission('run',#runId,#dto,'ibizplm-RunHistory-fetch_this')")
    @PostMapping("runs/{runId}/run_histories/fetch_this")
    public ResponseEntity<List<RunHistoryDTO>> fetchThisByRunId
            (@PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchThis(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行结果" },  notes = "RunHistory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Get-all')  or hasPermission('test_case',#caseId,this.runHistoryDtoMapping.toDomain(returnObject.body),'ibizplm-RunHistory-Get')")
    @GetMapping("test_cases/{caseId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<RunHistoryDTO> getByCaseIdAndRunIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @PathVariable("id") String id) {
        RunHistory rt = runHistoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行结果" },  notes = "RunHistory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Remove-all') or hasPermission('test_case',#caseId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Remove')")
    @DeleteMapping("test_cases/{caseId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<Boolean> removeByCaseIdAndRunIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @PathVariable("id") String id) {
        Boolean rt = runHistoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行结果" },  notes = "RunHistory-CheckKey ")
    @PostMapping("test_cases/{caseId}/runs/{runId}/run_histories/check_key")
    public ResponseEntity<Integer> checkKeyByCaseIdAndRunId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        Integer rt = runHistoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行结果" },  notes = "RunHistory-GetDraft ")
    @GetMapping("test_cases/{caseId}/runs/{runId}/run_histories/get_draft")
    public ResponseEntity<RunHistoryDTO> getDraftByCaseIdAndRunId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        RunHistory rt = runHistoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行结果" },  notes = "RunHistory-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-run_history_get-all') or hasPermission('test_case',#caseId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-run_history_get')")
    @GetMapping("test_cases/{caseId}/runs/{runId}/run_histories/{id}/run_history_get")
    public ResponseEntity<RunHistoryDTO> runHistoryGetByCaseIdAndRunIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @PathVariable("id") String id, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        RunHistory rt = runHistoryService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行结果" },  notes = "RunHistory-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_default-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-RunHistory-fetch_default')")
    @PostMapping("test_cases/{caseId}/runs/{runId}/run_histories/fetch_default")
    public ResponseEntity<List<RunHistoryDTO>> fetchDefaultByCaseIdAndRunId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchDefault(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_this 执行结果
    * 
    *
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_this", tags = {"执行结果" },  notes = "RunHistory-fetch_this ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_this-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-RunHistory-fetch_this')")
    @PostMapping("test_cases/{caseId}/runs/{runId}/run_histories/fetch_this")
    public ResponseEntity<List<RunHistoryDTO>> fetchThisByCaseIdAndRunId
            (@PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchThis(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行结果" },  notes = "RunHistory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Get-all')  or hasPermission('library',#testLibraryId,this.runHistoryDtoMapping.toDomain(returnObject.body),'ibizplm-RunHistory-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<RunHistoryDTO> getByTestLibraryIdAndCaseIdAndRunIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @PathVariable("id") String id) {
        RunHistory rt = runHistoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行结果" },  notes = "RunHistory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Remove-all') or hasPermission('library',#testLibraryId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<Boolean> removeByTestLibraryIdAndCaseIdAndRunIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @PathVariable("id") String id) {
        Boolean rt = runHistoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行结果" },  notes = "RunHistory-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/check_key")
    public ResponseEntity<Integer> checkKeyByTestLibraryIdAndCaseIdAndRunId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        Integer rt = runHistoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行结果" },  notes = "RunHistory-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/get_draft")
    public ResponseEntity<RunHistoryDTO> getDraftByTestLibraryIdAndCaseIdAndRunId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        RunHistory rt = runHistoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行结果" },  notes = "RunHistory-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-run_history_get-all') or hasPermission('library',#testLibraryId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-run_history_get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/{id}/run_history_get")
    public ResponseEntity<RunHistoryDTO> runHistoryGetByTestLibraryIdAndCaseIdAndRunIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @PathVariable("id") String id, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        RunHistory rt = runHistoryService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行结果" },  notes = "RunHistory-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-RunHistory-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/fetch_default")
    public ResponseEntity<List<RunHistoryDTO>> fetchDefaultByTestLibraryIdAndCaseIdAndRunId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchDefault(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_this 执行结果
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_this", tags = {"执行结果" },  notes = "RunHistory-fetch_this ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_this-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-RunHistory-fetch_this')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{runId}/run_histories/fetch_this")
    public ResponseEntity<List<RunHistoryDTO>> fetchThisByTestLibraryIdAndCaseIdAndRunId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchThis(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param id id
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行结果" },  notes = "RunHistory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Get-all')  or hasPermission('test_plan',#planId,this.runHistoryDtoMapping.toDomain(returnObject.body),'ibizplm-RunHistory-Get')")
    @GetMapping("test_plans/{planId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<RunHistoryDTO> getByPlanIdAndRunIdAndId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @PathVariable("id") String id) {
        RunHistory rt = runHistoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行结果" },  notes = "RunHistory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Remove-all') or hasPermission('test_plan',#planId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Remove')")
    @DeleteMapping("test_plans/{planId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<Boolean> removeByPlanIdAndRunIdAndId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @PathVariable("id") String id) {
        Boolean rt = runHistoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行结果" },  notes = "RunHistory-CheckKey ")
    @PostMapping("test_plans/{planId}/runs/{runId}/run_histories/check_key")
    public ResponseEntity<Integer> checkKeyByPlanIdAndRunId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        Integer rt = runHistoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行结果" },  notes = "RunHistory-GetDraft ")
    @GetMapping("test_plans/{planId}/runs/{runId}/run_histories/get_draft")
    public ResponseEntity<RunHistoryDTO> getDraftByPlanIdAndRunId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        RunHistory rt = runHistoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行结果" },  notes = "RunHistory-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-run_history_get-all') or hasPermission('test_plan',#planId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-run_history_get')")
    @GetMapping("test_plans/{planId}/runs/{runId}/run_histories/{id}/run_history_get")
    public ResponseEntity<RunHistoryDTO> runHistoryGetByPlanIdAndRunIdAndId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @PathVariable("id") String id, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        RunHistory rt = runHistoryService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行结果" },  notes = "RunHistory-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_default-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-RunHistory-fetch_default')")
    @PostMapping("test_plans/{planId}/runs/{runId}/run_histories/fetch_default")
    public ResponseEntity<List<RunHistoryDTO>> fetchDefaultByPlanIdAndRunId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchDefault(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_this 执行结果
    * 
    *
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_this", tags = {"执行结果" },  notes = "RunHistory-fetch_this ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_this-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-RunHistory-fetch_this')")
    @PostMapping("test_plans/{planId}/runs/{runId}/run_histories/fetch_this")
    public ResponseEntity<List<RunHistoryDTO>> fetchThisByPlanIdAndRunId
            (@PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchThis(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param id id
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行结果" },  notes = "RunHistory-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Get-all')  or hasPermission('library',#libraryId,this.runHistoryDtoMapping.toDomain(returnObject.body),'ibizplm-RunHistory-Get')")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<RunHistoryDTO> getByLibraryIdAndPlanIdAndRunIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @PathVariable("id") String id) {
        RunHistory rt = runHistoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行结果" },  notes = "RunHistory-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-Remove-all') or hasPermission('library',#libraryId,this.runHistoryService.get(#id),'ibizplm-RunHistory-Remove')")
    @DeleteMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/{id}")
    public ResponseEntity<Boolean> removeByLibraryIdAndPlanIdAndRunIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @PathVariable("id") String id) {
        Boolean rt = runHistoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行结果" },  notes = "RunHistory-CheckKey ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/check_key")
    public ResponseEntity<Integer> checkKeyByLibraryIdAndPlanIdAndRunId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        Integer rt = runHistoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行结果" },  notes = "RunHistory-GetDraft ")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/get_draft")
    public ResponseEntity<RunHistoryDTO> getDraftByLibraryIdAndPlanIdAndRunId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setRunId(runId);
        RunHistory rt = runHistoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunHistoryDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行结果" },  notes = "RunHistory-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-run_history_get-all') or hasPermission('library',#libraryId,this.runHistoryDtoMapping.toDomain(#dto),'ibizplm-RunHistory-run_history_get')")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/{id}/run_history_get")
    public ResponseEntity<RunHistoryDTO> runHistoryGetByLibraryIdAndPlanIdAndRunIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @PathVariable("id") String id, @SpringQueryMap RunHistoryDTO dto) {
        RunHistory domain = runHistoryDtoMapping.toDomain(dto);
        domain.setId(id);
        RunHistory rt = runHistoryService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runHistoryDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行结果" },  notes = "RunHistory-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-RunHistory-fetch_default')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/fetch_default")
    public ResponseEntity<List<RunHistoryDTO>> fetchDefaultByLibraryIdAndPlanIdAndRunId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchDefault(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_this 执行结果
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param runId runId
    * @param dto dto
    * @return ResponseEntity<List<RunHistoryDTO>>
    */
    @ApiOperation(value = "查询fetch_this", tags = {"执行结果" },  notes = "RunHistory-fetch_this ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-RunHistory-fetch_this-all') or hasPermission('library',#libraryId,#dto,'ibizplm-RunHistory-fetch_this')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{runId}/run_histories/fetch_this")
    public ResponseEntity<List<RunHistoryDTO>> fetchThisByLibraryIdAndPlanIdAndRunId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("runId") String runId, @Validated @RequestBody RunHistoryFilterDTO dto) {
        dto.setRunIdEQ(runId);
        RunHistorySearchContext context = runHistoryFilterDtoMapping.toDomain(dto);
        Page<RunHistory> domains = runHistoryService.fetchThis(context) ;
        List<RunHistoryDTO> list = runHistoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建执行结果
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Create-all')")
    @ApiOperation(value = "批量新建执行结果", tags = {"执行结果" },  notes = "批量新建执行结果")
	@PostMapping("run_histories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<RunHistoryDTO> dtos) {
        runHistoryService.create(runHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除执行结果
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Remove-all')")
    @ApiOperation(value = "批量删除执行结果", tags = {"执行结果" },  notes = "批量删除执行结果")
	@DeleteMapping("run_histories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        runHistoryService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新执行结果
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Update-all')")
    @ApiOperation(value = "批量更新执行结果", tags = {"执行结果" },  notes = "批量更新执行结果")
	@PutMapping("run_histories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<RunHistoryDTO> dtos) {
        runHistoryService.update(runHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存执行结果
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Save-all')")
    @ApiOperation(value = "批量保存执行结果", tags = {"执行结果" },  notes = "批量保存执行结果")
	@PostMapping("run_histories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<RunHistoryDTO> dtos) {
        runHistoryService.save(runHistoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入执行结果
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-RunHistory-Save-all')")
    @ApiOperation(value = "批量导入执行结果", tags = {"执行结果" },  notes = "批量导入执行结果")
	@PostMapping("run_histories/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RunHistoryDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(runHistoryService.importData(config,ignoreError,runHistoryDtoMapping.toDomain(dtos)));
    }

}
