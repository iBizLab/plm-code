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
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.service.RunService;
import cn.ibizlab.plm.core.testmgmt.filter.RunSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Run] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRunResource {

    @Autowired
    public RunService runService;

    @Autowired
    @Lazy
    public RunDTOMapping runDtoMapping;

    @Autowired
    @Lazy
    public RunExecutorDTOMapping runExecutorDtoMapping;

    @Autowired
    @Lazy
    public RunFilterDTOMapping runFilterDtoMapping;

    /**
    * 创建Create 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例" },  notes = "Run-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Create-all') or hasPermission(this.runDtoMapping.toDomain(#dto),'ibizplm-Run-Create')")
    @PostMapping("runs")
    public ResponseEntity<ResponseWrapper<RunDTO>> create
            (@Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO create
            (RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        runService.create(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例" },  notes = "Run-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Update-all') or hasPermission(this.runService.get(#id),'ibizplm-Run-Update')")
    @VersionCheck(entity = "run" , versionfield = "updateTime")
    @PutMapping("runs/{id}")
    public ResponseEntity<ResponseWrapper<RunDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO updateById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        runService.update(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "add_plan_run", tags = {"执行用例" },  notes = "Run-add_plan_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-add_plan_run-all') or hasPermission(this.runDtoMapping.toDomain(#dto),'ibizplm-Run-add_plan_run')")
    @PostMapping("runs/{id}/add_plan_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> addPlanRunById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addPlanRunById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addPlanRunById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO addPlanRunById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.addPlanRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "batch_save_run_history", tags = {"执行用例" },  notes = "Run-batch_save_run_history ")
    @PostMapping("runs/{id}/batch_save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> batchSaveRunHistoryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(batchSaveRunHistoryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(batchSaveRunHistoryById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO batchSaveRunHistoryById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.batchSaveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "fill_library_member", tags = {"执行用例" },  notes = "Run-fill_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fill_library_member-all') or hasPermission(this.runDtoMapping.toDomain(#dto),'ibizplm-Run-fill_library_member')")
    @PostMapping("runs/{id}/fill_library_member")
    public ResponseEntity<ResponseWrapper<RunDTO>> fillLibraryMemberById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillLibraryMemberById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillLibraryMemberById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO fillLibraryMemberById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.fillLibraryMember(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "other_relation_run", tags = {"执行用例" },  notes = "Run-other_relation_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-other_relation_run-all') or hasPermission(this.runDtoMapping.toDomain(#dto),'ibizplm-Run-other_relation_run')")
    @PutMapping("runs/{id}/other_relation_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> otherRelationRunById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherRelationRunById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherRelationRunById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO otherRelationRunById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.otherRelationRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "program_plan", tags = {"执行用例" },  notes = "Run-program_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-program_plan-all') or hasPermission(this.runDtoMapping.toDomain(#dto),'ibizplm-Run-program_plan')")
    @PostMapping("runs/program_plan")
    public ResponseEntity<ResponseWrapper<RunDTO>> programPlan
            (@Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(programPlan(item)));
        else
            rt.set(programPlan(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO programPlan
            (RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        Run rt = runService.programPlan(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "reset_not_test", tags = {"执行用例" },  notes = "Run-reset_not_test ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-reset_not_test-all') or hasPermission(this.runDtoMapping.toDomain(#dto),'ibizplm-Run-reset_not_test')")
    @PostMapping("runs/{id}/reset_not_test")
    public ResponseEntity<ResponseWrapper<RunDTO>> resetNotTestById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(resetNotTestById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(resetNotTestById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO resetNotTestById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.resetNotTest(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_re_counters", tags = {"执行用例" },  notes = "Run-run_re_counters ")
    @PostMapping("runs/{id}/run_re_counters")
    public ResponseEntity<ResponseWrapper<RunDTO>> runReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(runReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(runReCountersById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO runReCountersById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.runReCounters(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例" },  notes = "Run-Save ")
    @PostMapping("runs/save")
    public ResponseEntity<ResponseWrapper<RunDTO>> save
            (@Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO save
            (RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        runService.save(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "save_run_history", tags = {"执行用例" },  notes = "Run-save_run_history ")
    @PostMapping("runs/{id}/save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveRunHistoryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveRunHistoryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveRunHistoryById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveRunHistoryById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.saveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "set_executor", tags = {"执行用例" },  notes = "Run-set_executor ")
    @PostMapping("runs/{id}/set_executor")
    public ResponseEntity<ResponseWrapper<RunDTO>> setExecutorById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setExecutorById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setExecutorById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO setExecutorById
            (String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.setExecutor(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例" },  notes = "Run-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Create-all') or hasPermission('test_case',#caseId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-Create')")
    @PostMapping("test_cases/{caseId}/runs")
    public ResponseEntity<ResponseWrapper<RunDTO>> createByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByCaseId(caseId, item)));
        else
            rt.set(createByCaseId(caseId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO createByCaseId
            (String caseId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        runService.create(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例" },  notes = "Run-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Update-all') or hasPermission('test_case',#caseId,this.runService.get(#id),'ibizplm-Run-Update')")
    @VersionCheck(entity = "run" , versionfield = "updateTime")
    @PutMapping("test_cases/{caseId}/runs/{id}")
    public ResponseEntity<ResponseWrapper<RunDTO>> updateByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO updateByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        runService.update(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "add_plan_run", tags = {"执行用例" },  notes = "Run-add_plan_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-add_plan_run-all') or hasPermission('test_case',#caseId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-add_plan_run')")
    @PostMapping("test_cases/{caseId}/runs/{id}/add_plan_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> addPlanRunByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addPlanRunByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addPlanRunByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO addPlanRunByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.addPlanRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "batch_save_run_history", tags = {"执行用例" },  notes = "Run-batch_save_run_history ")
    @PostMapping("test_cases/{caseId}/runs/{id}/batch_save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> batchSaveRunHistoryByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(batchSaveRunHistoryByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(batchSaveRunHistoryByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO batchSaveRunHistoryByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.batchSaveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "fill_library_member", tags = {"执行用例" },  notes = "Run-fill_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fill_library_member-all') or hasPermission('test_case',#caseId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-fill_library_member')")
    @PostMapping("test_cases/{caseId}/runs/{id}/fill_library_member")
    public ResponseEntity<ResponseWrapper<RunDTO>> fillLibraryMemberByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillLibraryMemberByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillLibraryMemberByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO fillLibraryMemberByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.fillLibraryMember(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "other_relation_run", tags = {"执行用例" },  notes = "Run-other_relation_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-other_relation_run-all') or hasPermission('test_case',#caseId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-other_relation_run')")
    @PutMapping("test_cases/{caseId}/runs/{id}/other_relation_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> otherRelationRunByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherRelationRunByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherRelationRunByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO otherRelationRunByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.otherRelationRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "program_plan", tags = {"执行用例" },  notes = "Run-program_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-program_plan-all') or hasPermission('test_case',#caseId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-program_plan')")
    @PostMapping("test_cases/{caseId}/runs/program_plan")
    public ResponseEntity<ResponseWrapper<RunDTO>> programPlanByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(programPlanByCaseId(caseId, item)));
        else
            rt.set(programPlanByCaseId(caseId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO programPlanByCaseId
            (String caseId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        Run rt = runService.programPlan(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "reset_not_test", tags = {"执行用例" },  notes = "Run-reset_not_test ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-reset_not_test-all') or hasPermission('test_case',#caseId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-reset_not_test')")
    @PostMapping("test_cases/{caseId}/runs/{id}/reset_not_test")
    public ResponseEntity<ResponseWrapper<RunDTO>> resetNotTestByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(resetNotTestByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(resetNotTestByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO resetNotTestByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.resetNotTest(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_re_counters", tags = {"执行用例" },  notes = "Run-run_re_counters ")
    @PostMapping("test_cases/{caseId}/runs/{id}/run_re_counters")
    public ResponseEntity<ResponseWrapper<RunDTO>> runReCountersByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(runReCountersByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(runReCountersByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO runReCountersByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.runReCounters(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例" },  notes = "Run-Save ")
    @PostMapping("test_cases/{caseId}/runs/save")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByCaseId(caseId, item)));
        else
            rt.set(saveByCaseId(caseId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveByCaseId
            (String caseId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        runService.save(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "save_run_history", tags = {"执行用例" },  notes = "Run-save_run_history ")
    @PostMapping("test_cases/{caseId}/runs/{id}/save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveRunHistoryByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveRunHistoryByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveRunHistoryByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveRunHistoryByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.saveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "set_executor", tags = {"执行用例" },  notes = "Run-set_executor ")
    @PostMapping("test_cases/{caseId}/runs/{id}/set_executor")
    public ResponseEntity<ResponseWrapper<RunDTO>> setExecutorByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setExecutorByCaseIdAndId(caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setExecutorByCaseIdAndId(caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO setExecutorByCaseIdAndId
            (String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.setExecutor(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例" },  notes = "Run-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Create-all') or hasPermission('library',#testLibraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs")
    public ResponseEntity<ResponseWrapper<RunDTO>> createByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryIdAndCaseId(testLibraryId, caseId, item)));
        else
            rt.set(createByTestLibraryIdAndCaseId(testLibraryId, caseId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO createByTestLibraryIdAndCaseId
            (String testLibraryId, String caseId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        runService.create(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例" },  notes = "Run-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Update-all') or hasPermission('library',#testLibraryId,this.runService.get(#id),'ibizplm-Run-Update')")
    @VersionCheck(entity = "run" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}")
    public ResponseEntity<ResponseWrapper<RunDTO>> updateByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO updateByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        runService.update(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "add_plan_run", tags = {"执行用例" },  notes = "Run-add_plan_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-add_plan_run-all') or hasPermission('library',#testLibraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-add_plan_run')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/add_plan_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> addPlanRunByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addPlanRunByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addPlanRunByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO addPlanRunByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.addPlanRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "batch_save_run_history", tags = {"执行用例" },  notes = "Run-batch_save_run_history ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/batch_save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> batchSaveRunHistoryByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(batchSaveRunHistoryByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(batchSaveRunHistoryByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO batchSaveRunHistoryByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.batchSaveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "fill_library_member", tags = {"执行用例" },  notes = "Run-fill_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fill_library_member-all') or hasPermission('library',#testLibraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-fill_library_member')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/fill_library_member")
    public ResponseEntity<ResponseWrapper<RunDTO>> fillLibraryMemberByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillLibraryMemberByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillLibraryMemberByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO fillLibraryMemberByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.fillLibraryMember(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "other_relation_run", tags = {"执行用例" },  notes = "Run-other_relation_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-other_relation_run-all') or hasPermission('library',#testLibraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-other_relation_run')")
    @PutMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/other_relation_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> otherRelationRunByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherRelationRunByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherRelationRunByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO otherRelationRunByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.otherRelationRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "program_plan", tags = {"执行用例" },  notes = "Run-program_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-program_plan-all') or hasPermission('library',#testLibraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-program_plan')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/program_plan")
    public ResponseEntity<ResponseWrapper<RunDTO>> programPlanByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(programPlanByTestLibraryIdAndCaseId(testLibraryId, caseId, item)));
        else
            rt.set(programPlanByTestLibraryIdAndCaseId(testLibraryId, caseId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO programPlanByTestLibraryIdAndCaseId
            (String testLibraryId, String caseId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        Run rt = runService.programPlan(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "reset_not_test", tags = {"执行用例" },  notes = "Run-reset_not_test ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-reset_not_test-all') or hasPermission('library',#testLibraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-reset_not_test')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/reset_not_test")
    public ResponseEntity<ResponseWrapper<RunDTO>> resetNotTestByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(resetNotTestByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(resetNotTestByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO resetNotTestByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.resetNotTest(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_re_counters", tags = {"执行用例" },  notes = "Run-run_re_counters ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/run_re_counters")
    public ResponseEntity<ResponseWrapper<RunDTO>> runReCountersByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(runReCountersByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(runReCountersByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO runReCountersByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.runReCounters(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例" },  notes = "Run-Save ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/save")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryIdAndCaseId(testLibraryId, caseId, item)));
        else
            rt.set(saveByTestLibraryIdAndCaseId(testLibraryId, caseId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveByTestLibraryIdAndCaseId
            (String testLibraryId, String caseId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        runService.save(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "save_run_history", tags = {"执行用例" },  notes = "Run-save_run_history ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveRunHistoryByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveRunHistoryByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveRunHistoryByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveRunHistoryByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.saveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "set_executor", tags = {"执行用例" },  notes = "Run-set_executor ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/set_executor")
    public ResponseEntity<ResponseWrapper<RunDTO>> setExecutorByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setExecutorByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setExecutorByTestLibraryIdAndCaseIdAndId(testLibraryId, caseId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO setExecutorByTestLibraryIdAndCaseIdAndId
            (String testLibraryId, String caseId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.setExecutor(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例" },  notes = "Run-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Create-all') or hasPermission('test_plan',#planId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-Create')")
    @PostMapping("test_plans/{planId}/runs")
    public ResponseEntity<ResponseWrapper<RunDTO>> createByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByPlanId(planId, item)));
        else
            rt.set(createByPlanId(planId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO createByPlanId
            (String planId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        runService.create(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例" },  notes = "Run-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Update-all') or hasPermission('test_plan',#planId,this.runService.get(#id),'ibizplm-Run-Update')")
    @VersionCheck(entity = "run" , versionfield = "updateTime")
    @PutMapping("test_plans/{planId}/runs/{id}")
    public ResponseEntity<ResponseWrapper<RunDTO>> updateByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO updateByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        runService.update(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "add_plan_run", tags = {"执行用例" },  notes = "Run-add_plan_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-add_plan_run-all') or hasPermission('test_plan',#planId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-add_plan_run')")
    @PostMapping("test_plans/{planId}/runs/{id}/add_plan_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> addPlanRunByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addPlanRunByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addPlanRunByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO addPlanRunByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.addPlanRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "batch_save_run_history", tags = {"执行用例" },  notes = "Run-batch_save_run_history ")
    @PostMapping("test_plans/{planId}/runs/{id}/batch_save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> batchSaveRunHistoryByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(batchSaveRunHistoryByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(batchSaveRunHistoryByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO batchSaveRunHistoryByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.batchSaveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "fill_library_member", tags = {"执行用例" },  notes = "Run-fill_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fill_library_member-all') or hasPermission('test_plan',#planId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-fill_library_member')")
    @PostMapping("test_plans/{planId}/runs/{id}/fill_library_member")
    public ResponseEntity<ResponseWrapper<RunDTO>> fillLibraryMemberByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillLibraryMemberByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillLibraryMemberByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO fillLibraryMemberByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.fillLibraryMember(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "other_relation_run", tags = {"执行用例" },  notes = "Run-other_relation_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-other_relation_run-all') or hasPermission('test_plan',#planId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-other_relation_run')")
    @PutMapping("test_plans/{planId}/runs/{id}/other_relation_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> otherRelationRunByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherRelationRunByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherRelationRunByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO otherRelationRunByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.otherRelationRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "program_plan", tags = {"执行用例" },  notes = "Run-program_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-program_plan-all') or hasPermission('test_plan',#planId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-program_plan')")
    @PostMapping("test_plans/{planId}/runs/program_plan")
    public ResponseEntity<ResponseWrapper<RunDTO>> programPlanByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(programPlanByPlanId(planId, item)));
        else
            rt.set(programPlanByPlanId(planId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO programPlanByPlanId
            (String planId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        Run rt = runService.programPlan(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "reset_not_test", tags = {"执行用例" },  notes = "Run-reset_not_test ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-reset_not_test-all') or hasPermission('test_plan',#planId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-reset_not_test')")
    @PostMapping("test_plans/{planId}/runs/{id}/reset_not_test")
    public ResponseEntity<ResponseWrapper<RunDTO>> resetNotTestByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(resetNotTestByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(resetNotTestByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO resetNotTestByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.resetNotTest(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_re_counters", tags = {"执行用例" },  notes = "Run-run_re_counters ")
    @PostMapping("test_plans/{planId}/runs/{id}/run_re_counters")
    public ResponseEntity<ResponseWrapper<RunDTO>> runReCountersByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(runReCountersByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(runReCountersByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO runReCountersByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.runReCounters(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例" },  notes = "Run-Save ")
    @PostMapping("test_plans/{planId}/runs/save")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByPlanId(planId, item)));
        else
            rt.set(saveByPlanId(planId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveByPlanId
            (String planId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        runService.save(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "save_run_history", tags = {"执行用例" },  notes = "Run-save_run_history ")
    @PostMapping("test_plans/{planId}/runs/{id}/save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveRunHistoryByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveRunHistoryByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveRunHistoryByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveRunHistoryByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.saveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "set_executor", tags = {"执行用例" },  notes = "Run-set_executor ")
    @PostMapping("test_plans/{planId}/runs/{id}/set_executor")
    public ResponseEntity<ResponseWrapper<RunDTO>> setExecutorByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setExecutorByPlanIdAndId(planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setExecutorByPlanIdAndId(planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO setExecutorByPlanIdAndId
            (String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.setExecutor(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"执行用例" },  notes = "Run-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Create-all') or hasPermission('library',#libraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-Create')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs")
    public ResponseEntity<ResponseWrapper<RunDTO>> createByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryIdAndPlanId(libraryId, planId, item)));
        else
            rt.set(createByLibraryIdAndPlanId(libraryId, planId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO createByLibraryIdAndPlanId
            (String libraryId, String planId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        runService.create(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"执行用例" },  notes = "Run-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Update-all') or hasPermission('library',#libraryId,this.runService.get(#id),'ibizplm-Run-Update')")
    @VersionCheck(entity = "run" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}")
    public ResponseEntity<ResponseWrapper<RunDTO>> updateByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO updateByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        runService.update(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "add_plan_run", tags = {"执行用例" },  notes = "Run-add_plan_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-add_plan_run-all') or hasPermission('library',#libraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-add_plan_run')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/add_plan_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> addPlanRunByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addPlanRunByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addPlanRunByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * add_plan_run 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO addPlanRunByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.addPlanRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "batch_save_run_history", tags = {"执行用例" },  notes = "Run-batch_save_run_history ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/batch_save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> batchSaveRunHistoryByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(batchSaveRunHistoryByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(batchSaveRunHistoryByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * batch_save_run_history 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO batchSaveRunHistoryByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.batchSaveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "fill_library_member", tags = {"执行用例" },  notes = "Run-fill_library_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fill_library_member-all') or hasPermission('library',#libraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-fill_library_member')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/fill_library_member")
    public ResponseEntity<ResponseWrapper<RunDTO>> fillLibraryMemberByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillLibraryMemberByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillLibraryMemberByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * fill_library_member 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO fillLibraryMemberByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.fillLibraryMember(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "other_relation_run", tags = {"执行用例" },  notes = "Run-other_relation_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-other_relation_run-all') or hasPermission('library',#libraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-other_relation_run')")
    @PutMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/other_relation_run")
    public ResponseEntity<ResponseWrapper<RunDTO>> otherRelationRunByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherRelationRunByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherRelationRunByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * other_relation_run 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO otherRelationRunByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.otherRelationRun(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "program_plan", tags = {"执行用例" },  notes = "Run-program_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-program_plan-all') or hasPermission('library',#libraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-program_plan')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/program_plan")
    public ResponseEntity<ResponseWrapper<RunDTO>> programPlanByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(programPlanByLibraryIdAndPlanId(libraryId, planId, item)));
        else
            rt.set(programPlanByLibraryIdAndPlanId(libraryId, planId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * program_plan 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO programPlanByLibraryIdAndPlanId
            (String libraryId, String planId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        Run rt = runService.programPlan(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "reset_not_test", tags = {"执行用例" },  notes = "Run-reset_not_test ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-reset_not_test-all') or hasPermission('library',#libraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-reset_not_test')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/reset_not_test")
    public ResponseEntity<ResponseWrapper<RunDTO>> resetNotTestByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(resetNotTestByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(resetNotTestByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * reset_not_test 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO resetNotTestByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.resetNotTest(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_re_counters", tags = {"执行用例" },  notes = "Run-run_re_counters ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/run_re_counters")
    public ResponseEntity<ResponseWrapper<RunDTO>> runReCountersByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(runReCountersByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(runReCountersByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * run_re_counters 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO runReCountersByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.runReCounters(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"执行用例" },  notes = "Run-Save ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/save")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryIdAndPlanId(libraryId, planId, item)));
        else
            rt.set(saveByLibraryIdAndPlanId(libraryId, planId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveByLibraryIdAndPlanId
            (String libraryId, String planId, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        runService.save(domain);
        Run rt = domain;
        return runDtoMapping.toDto(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "save_run_history", tags = {"执行用例" },  notes = "Run-save_run_history ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/save_run_history")
    public ResponseEntity<ResponseWrapper<RunDTO>> saveRunHistoryByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveRunHistoryByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveRunHistoryByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * save_run_history 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO saveRunHistoryByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.saveRunHistory(domain);
        return runDtoMapping.toDto(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "set_executor", tags = {"执行用例" },  notes = "Run-set_executor ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/set_executor")
    public ResponseEntity<ResponseWrapper<RunDTO>> setExecutorByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RunDTO> dto) {
        ResponseWrapper<RunDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setExecutorByLibraryIdAndPlanIdAndId(libraryId, planId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setExecutorByLibraryIdAndPlanIdAndId(libraryId, planId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * set_executor 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */   
    public RunDTO setExecutorByLibraryIdAndPlanIdAndId
            (String libraryId, String planId, String id, RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setId(id);
        Run rt = runService.setExecutor(domain);
        return runDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 执行用例
    * 
    *
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例" },  notes = "Run-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Get-all')  or hasPermission(this.runDtoMapping.toDomain(returnObject.body),'ibizplm-Run-Get')")
    @GetMapping("runs/{id}")
    public ResponseEntity<RunDTO> getById
            (@PathVariable("id") String id) {
        Run rt = runService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行用例
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例" },  notes = "Run-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Remove-all') or hasPermission(this.runService.get(#id),'ibizplm-Run-Remove')")
    @DeleteMapping("runs/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = runService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例" },  notes = "Run-CheckKey ")
    @PostMapping("runs/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        Integer rt = runService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_actual_workload 执行用例
    * 
    *
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "get_actual_workload", tags = {"执行用例" },  notes = "Run-get_actual_workload ")
    @GetMapping("runs/{id}/get_actual_workload")
    public ResponseEntity<RunDTO> getActualWorkloadById
            (@PathVariable("id") String id) {
        Run rt = runService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例" },  notes = "Run-GetDraft ")
    @GetMapping("runs/get_draft")
    public ResponseEntity<RunDTO> getDraft
            (@SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        Run rt = runService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行用例" },  notes = "Run-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-run_history_get-all') or hasPermission(this.runDtoMapping.toDomain(#dto),'ibizplm-Run-run_history_get')")
    @GetMapping("runs/run_history_get")
    public ResponseEntity<RunDTO> runHistoryGet
            (@SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        Run rt = runService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * this_run_details 执行用例
    * 
    *
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "this_run_details", tags = {"执行用例" },  notes = "Run-this_run_details ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-this_run_details-all') or hasPermission(this.runService.get(#id),'ibizplm-Run-this_run_details')")
    @GetMapping("runs/{id}/this_run_details")
    public ResponseEntity<RunDTO> thisRunDetailsById
            (@PathVariable("id") String id) {
        Run rt = runService.thisRunDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_case_person 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_case_person", tags = {"执行用例" },  notes = "Run-fetch_case_person ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_case_person-all') or hasPermission(#dto,'ibizplm-Run-fetch_case_person')")
    @PostMapping("runs/fetch_case_person")
    public ResponseEntity<List<RunDTO>> fetchCasePerson
            (@Validated @RequestBody RunFilterDTO dto) {
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCasePerson(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_comment_notify_executor 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunExecutorDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_executor", tags = {"执行用例" },  notes = "Run-fetch_comment_notify_executor ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_comment_notify_executor-all') or hasPermission(#dto,'ibizplm-Run-fetch_comment_notify_executor')")
    @PostMapping("runs/fetch_comment_notify_executor")
    public ResponseEntity<List<RunExecutorDTO>> fetchCommentNotifyExecutor
            (@Validated @RequestBody RunFilterDTO dto) {
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCommentNotifyExecutor(context) ;
        List<RunExecutorDTO> list = runExecutorDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例" },  notes = "Run-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_default-all') or hasPermission(#dto,'ibizplm-Run-fetch_default')")
    @PostMapping("runs/fetch_default")
    public ResponseEntity<List<RunDTO>> fetchDefault
            (@Validated @RequestBody RunFilterDTO dto) {
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchDefault(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_implementation_results 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_implementation_results", tags = {"执行用例" },  notes = "Run-fetch_implementation_results ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_implementation_results-all') or hasPermission(#dto,'ibizplm-Run-fetch_implementation_results')")
    @PostMapping("runs/fetch_implementation_results")
    public ResponseEntity<List<RunDTO>> fetchImplementationResults
            (@Validated @RequestBody RunFilterDTO dto) {
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchImplementationResults(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"执行用例" },  notes = "Run-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_normal-all') or hasPermission(#dto,'ibizplm-Run-fetch_normal')")
    @PostMapping("runs/fetch_normal")
    public ResponseEntity<List<RunDTO>> fetchNormal
            (@Validated @RequestBody RunFilterDTO dto) {
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchNormal(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_priority_distributions 执行用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_priority_distributions", tags = {"执行用例" },  notes = "Run-fetch_priority_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_priority_distributions-all') or hasPermission(#dto,'ibizplm-Run-fetch_priority_distributions')")
    @PostMapping("runs/fetch_priority_distributions")
    public ResponseEntity<List<RunDTO>> fetchPriorityDistributions
            (@Validated @RequestBody RunFilterDTO dto) {
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchPriorityDistributions(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例" },  notes = "Run-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Get-all')  or hasPermission('test_case',#caseId,this.runDtoMapping.toDomain(returnObject.body),'ibizplm-Run-Get')")
    @GetMapping("test_cases/{caseId}/runs/{id}")
    public ResponseEntity<RunDTO> getByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id) {
        Run rt = runService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例" },  notes = "Run-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Remove-all') or hasPermission('test_case',#caseId,this.runService.get(#id),'ibizplm-Run-Remove')")
    @DeleteMapping("test_cases/{caseId}/runs/{id}")
    public ResponseEntity<Boolean> removeByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id) {
        Boolean rt = runService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例" },  notes = "Run-CheckKey ")
    @PostMapping("test_cases/{caseId}/runs/check_key")
    public ResponseEntity<Integer> checkKeyByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        Integer rt = runService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_actual_workload 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "get_actual_workload", tags = {"执行用例" },  notes = "Run-get_actual_workload ")
    @GetMapping("test_cases/{caseId}/runs/{id}/get_actual_workload")
    public ResponseEntity<RunDTO> getActualWorkloadByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id) {
        Run rt = runService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例" },  notes = "Run-GetDraft ")
    @GetMapping("test_cases/{caseId}/runs/get_draft")
    public ResponseEntity<RunDTO> getDraftByCaseId
            (@PathVariable("caseId") String caseId, @SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        Run rt = runService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行用例" },  notes = "Run-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-run_history_get-all') or hasPermission('test_case',#caseId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-run_history_get')")
    @GetMapping("test_cases/{caseId}/runs/run_history_get")
    public ResponseEntity<RunDTO> runHistoryGetByCaseId
            (@PathVariable("caseId") String caseId, @SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        Run rt = runService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * this_run_details 执行用例
    * 
    *
    * @param caseId caseId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "this_run_details", tags = {"执行用例" },  notes = "Run-this_run_details ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-this_run_details-all') or hasPermission('test_case',#caseId,this.runService.get(#id),'ibizplm-Run-this_run_details')")
    @GetMapping("test_cases/{caseId}/runs/{id}/this_run_details")
    public ResponseEntity<RunDTO> thisRunDetailsByCaseIdAndId
            (@PathVariable("caseId") String caseId, @PathVariable("id") String id) {
        Run rt = runService.thisRunDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_case_person 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_case_person", tags = {"执行用例" },  notes = "Run-fetch_case_person ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_case_person-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-Run-fetch_case_person')")
    @PostMapping("test_cases/{caseId}/runs/fetch_case_person")
    public ResponseEntity<List<RunDTO>> fetchCasePersonByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCasePerson(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_comment_notify_executor 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunExecutorDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_executor", tags = {"执行用例" },  notes = "Run-fetch_comment_notify_executor ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_comment_notify_executor-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-Run-fetch_comment_notify_executor')")
    @PostMapping("test_cases/{caseId}/runs/fetch_comment_notify_executor")
    public ResponseEntity<List<RunExecutorDTO>> fetchCommentNotifyExecutorByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCommentNotifyExecutor(context) ;
        List<RunExecutorDTO> list = runExecutorDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例" },  notes = "Run-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_default-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-Run-fetch_default')")
    @PostMapping("test_cases/{caseId}/runs/fetch_default")
    public ResponseEntity<List<RunDTO>> fetchDefaultByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchDefault(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_implementation_results 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_implementation_results", tags = {"执行用例" },  notes = "Run-fetch_implementation_results ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_implementation_results-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-Run-fetch_implementation_results')")
    @PostMapping("test_cases/{caseId}/runs/fetch_implementation_results")
    public ResponseEntity<List<RunDTO>> fetchImplementationResultsByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchImplementationResults(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"执行用例" },  notes = "Run-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_normal-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-Run-fetch_normal')")
    @PostMapping("test_cases/{caseId}/runs/fetch_normal")
    public ResponseEntity<List<RunDTO>> fetchNormalByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchNormal(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_priority_distributions 执行用例
    * 
    *
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_priority_distributions", tags = {"执行用例" },  notes = "Run-fetch_priority_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_priority_distributions-all') or hasPermission('test_case',#caseId,#dto,'ibizplm-Run-fetch_priority_distributions')")
    @PostMapping("test_cases/{caseId}/runs/fetch_priority_distributions")
    public ResponseEntity<List<RunDTO>> fetchPriorityDistributionsByCaseId
            (@PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchPriorityDistributions(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例" },  notes = "Run-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Get-all')  or hasPermission('library',#testLibraryId,this.runDtoMapping.toDomain(returnObject.body),'ibizplm-Run-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}")
    public ResponseEntity<RunDTO> getByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id) {
        Run rt = runService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例" },  notes = "Run-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Remove-all') or hasPermission('library',#testLibraryId,this.runService.get(#id),'ibizplm-Run-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}")
    public ResponseEntity<Boolean> removeByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id) {
        Boolean rt = runService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例" },  notes = "Run-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/check_key")
    public ResponseEntity<Integer> checkKeyByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        Integer rt = runService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_actual_workload 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "get_actual_workload", tags = {"执行用例" },  notes = "Run-get_actual_workload ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/get_actual_workload")
    public ResponseEntity<RunDTO> getActualWorkloadByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id) {
        Run rt = runService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例" },  notes = "Run-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/get_draft")
    public ResponseEntity<RunDTO> getDraftByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        Run rt = runService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行用例" },  notes = "Run-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-run_history_get-all') or hasPermission('library',#testLibraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-run_history_get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/run_history_get")
    public ResponseEntity<RunDTO> runHistoryGetByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setCaseId(caseId);
        Run rt = runService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * this_run_details 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "this_run_details", tags = {"执行用例" },  notes = "Run-this_run_details ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-this_run_details-all') or hasPermission('library',#testLibraryId,this.runService.get(#id),'ibizplm-Run-this_run_details')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/{id}/this_run_details")
    public ResponseEntity<RunDTO> thisRunDetailsByTestLibraryIdAndCaseIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @PathVariable("id") String id) {
        Run rt = runService.thisRunDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_case_person 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_case_person", tags = {"执行用例" },  notes = "Run-fetch_case_person ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_case_person-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Run-fetch_case_person')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/fetch_case_person")
    public ResponseEntity<List<RunDTO>> fetchCasePersonByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCasePerson(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_comment_notify_executor 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunExecutorDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_executor", tags = {"执行用例" },  notes = "Run-fetch_comment_notify_executor ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_comment_notify_executor-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Run-fetch_comment_notify_executor')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/fetch_comment_notify_executor")
    public ResponseEntity<List<RunExecutorDTO>> fetchCommentNotifyExecutorByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCommentNotifyExecutor(context) ;
        List<RunExecutorDTO> list = runExecutorDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例" },  notes = "Run-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Run-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/fetch_default")
    public ResponseEntity<List<RunDTO>> fetchDefaultByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchDefault(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_implementation_results 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_implementation_results", tags = {"执行用例" },  notes = "Run-fetch_implementation_results ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_implementation_results-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Run-fetch_implementation_results')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/fetch_implementation_results")
    public ResponseEntity<List<RunDTO>> fetchImplementationResultsByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchImplementationResults(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"执行用例" },  notes = "Run-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_normal-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Run-fetch_normal')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/fetch_normal")
    public ResponseEntity<List<RunDTO>> fetchNormalByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchNormal(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_priority_distributions 执行用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param caseId caseId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_priority_distributions", tags = {"执行用例" },  notes = "Run-fetch_priority_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_priority_distributions-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-Run-fetch_priority_distributions')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{caseId}/runs/fetch_priority_distributions")
    public ResponseEntity<List<RunDTO>> fetchPriorityDistributionsByTestLibraryIdAndCaseId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("caseId") String caseId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setCaseIdEQ(caseId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchPriorityDistributions(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例" },  notes = "Run-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Get-all')  or hasPermission('test_plan',#planId,this.runDtoMapping.toDomain(returnObject.body),'ibizplm-Run-Get')")
    @GetMapping("test_plans/{planId}/runs/{id}")
    public ResponseEntity<RunDTO> getByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id) {
        Run rt = runService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例" },  notes = "Run-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Remove-all') or hasPermission('test_plan',#planId,this.runService.get(#id),'ibizplm-Run-Remove')")
    @DeleteMapping("test_plans/{planId}/runs/{id}")
    public ResponseEntity<Boolean> removeByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id) {
        Boolean rt = runService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例" },  notes = "Run-CheckKey ")
    @PostMapping("test_plans/{planId}/runs/check_key")
    public ResponseEntity<Integer> checkKeyByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        Integer rt = runService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_actual_workload 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "get_actual_workload", tags = {"执行用例" },  notes = "Run-get_actual_workload ")
    @GetMapping("test_plans/{planId}/runs/{id}/get_actual_workload")
    public ResponseEntity<RunDTO> getActualWorkloadByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id) {
        Run rt = runService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例" },  notes = "Run-GetDraft ")
    @GetMapping("test_plans/{planId}/runs/get_draft")
    public ResponseEntity<RunDTO> getDraftByPlanId
            (@PathVariable("planId") String planId, @SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        Run rt = runService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行用例" },  notes = "Run-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-run_history_get-all') or hasPermission('test_plan',#planId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-run_history_get')")
    @GetMapping("test_plans/{planId}/runs/run_history_get")
    public ResponseEntity<RunDTO> runHistoryGetByPlanId
            (@PathVariable("planId") String planId, @SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        Run rt = runService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * this_run_details 执行用例
    * 
    *
    * @param planId planId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "this_run_details", tags = {"执行用例" },  notes = "Run-this_run_details ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-this_run_details-all') or hasPermission('test_plan',#planId,this.runService.get(#id),'ibizplm-Run-this_run_details')")
    @GetMapping("test_plans/{planId}/runs/{id}/this_run_details")
    public ResponseEntity<RunDTO> thisRunDetailsByPlanIdAndId
            (@PathVariable("planId") String planId, @PathVariable("id") String id) {
        Run rt = runService.thisRunDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_case_person 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_case_person", tags = {"执行用例" },  notes = "Run-fetch_case_person ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_case_person-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-Run-fetch_case_person')")
    @PostMapping("test_plans/{planId}/runs/fetch_case_person")
    public ResponseEntity<List<RunDTO>> fetchCasePersonByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCasePerson(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_comment_notify_executor 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunExecutorDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_executor", tags = {"执行用例" },  notes = "Run-fetch_comment_notify_executor ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_comment_notify_executor-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-Run-fetch_comment_notify_executor')")
    @PostMapping("test_plans/{planId}/runs/fetch_comment_notify_executor")
    public ResponseEntity<List<RunExecutorDTO>> fetchCommentNotifyExecutorByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCommentNotifyExecutor(context) ;
        List<RunExecutorDTO> list = runExecutorDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例" },  notes = "Run-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_default-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-Run-fetch_default')")
    @PostMapping("test_plans/{planId}/runs/fetch_default")
    public ResponseEntity<List<RunDTO>> fetchDefaultByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchDefault(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_implementation_results 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_implementation_results", tags = {"执行用例" },  notes = "Run-fetch_implementation_results ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_implementation_results-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-Run-fetch_implementation_results')")
    @PostMapping("test_plans/{planId}/runs/fetch_implementation_results")
    public ResponseEntity<List<RunDTO>> fetchImplementationResultsByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchImplementationResults(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"执行用例" },  notes = "Run-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_normal-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-Run-fetch_normal')")
    @PostMapping("test_plans/{planId}/runs/fetch_normal")
    public ResponseEntity<List<RunDTO>> fetchNormalByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchNormal(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_priority_distributions 执行用例
    * 
    *
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_priority_distributions", tags = {"执行用例" },  notes = "Run-fetch_priority_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_priority_distributions-all') or hasPermission('test_plan',#planId,#dto,'ibizplm-Run-fetch_priority_distributions')")
    @PostMapping("test_plans/{planId}/runs/fetch_priority_distributions")
    public ResponseEntity<List<RunDTO>> fetchPriorityDistributionsByPlanId
            (@PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchPriorityDistributions(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"执行用例" },  notes = "Run-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Get-all')  or hasPermission('library',#libraryId,this.runDtoMapping.toDomain(returnObject.body),'ibizplm-Run-Get')")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}")
    public ResponseEntity<RunDTO> getByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id) {
        Run rt = runService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"执行用例" },  notes = "Run-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-Remove-all') or hasPermission('library',#libraryId,this.runService.get(#id),'ibizplm-Run-Remove')")
    @DeleteMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}")
    public ResponseEntity<Boolean> removeByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id) {
        Boolean rt = runService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"执行用例" },  notes = "Run-CheckKey ")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/check_key")
    public ResponseEntity<Integer> checkKeyByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        Integer rt = runService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * get_actual_workload 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "get_actual_workload", tags = {"执行用例" },  notes = "Run-get_actual_workload ")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/get_actual_workload")
    public ResponseEntity<RunDTO> getActualWorkloadByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id) {
        Run rt = runService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 草稿GetDraft 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"执行用例" },  notes = "Run-GetDraft ")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/get_draft")
    public ResponseEntity<RunDTO> getDraftByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        Run rt = runService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * run_history_get 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "run_history_get", tags = {"执行用例" },  notes = "Run-run_history_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-run_history_get-all') or hasPermission('library',#libraryId,this.runDtoMapping.toDomain(#dto),'ibizplm-Run-run_history_get')")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/run_history_get")
    public ResponseEntity<RunDTO> runHistoryGetByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @SpringQueryMap RunDTO dto) {
        Run domain = runDtoMapping.toDomain(dto);
        domain.setPlanId(planId);
        Run rt = runService.runHistoryGet(domain);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * this_run_details 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param id id
    * @return ResponseEntity<RunDTO>
    */
    @ApiOperation(value = "this_run_details", tags = {"执行用例" },  notes = "Run-this_run_details ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-this_run_details-all') or hasPermission('library',#libraryId,this.runService.get(#id),'ibizplm-Run-this_run_details')")
    @GetMapping("libraries/{libraryId}/test_plans/{planId}/runs/{id}/this_run_details")
    public ResponseEntity<RunDTO> thisRunDetailsByLibraryIdAndPlanIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @PathVariable("id") String id) {
        Run rt = runService.thisRunDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(runDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_case_person 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_case_person", tags = {"执行用例" },  notes = "Run-fetch_case_person ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_case_person-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Run-fetch_case_person')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/fetch_case_person")
    public ResponseEntity<List<RunDTO>> fetchCasePersonByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCasePerson(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_comment_notify_executor 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunExecutorDTO>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_executor", tags = {"执行用例" },  notes = "Run-fetch_comment_notify_executor ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_comment_notify_executor-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Run-fetch_comment_notify_executor')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/fetch_comment_notify_executor")
    public ResponseEntity<List<RunExecutorDTO>> fetchCommentNotifyExecutorByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchCommentNotifyExecutor(context) ;
        List<RunExecutorDTO> list = runExecutorDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"执行用例" },  notes = "Run-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Run-fetch_default')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/fetch_default")
    public ResponseEntity<List<RunDTO>> fetchDefaultByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchDefault(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_implementation_results 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_implementation_results", tags = {"执行用例" },  notes = "Run-fetch_implementation_results ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_implementation_results-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Run-fetch_implementation_results')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/fetch_implementation_results")
    public ResponseEntity<List<RunDTO>> fetchImplementationResultsByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchImplementationResults(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"执行用例" },  notes = "Run-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_normal-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Run-fetch_normal')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/fetch_normal")
    public ResponseEntity<List<RunDTO>> fetchNormalByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchNormal(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_priority_distributions 执行用例
    * 
    *
    * @param libraryId libraryId
    * @param planId planId
    * @param dto dto
    * @return ResponseEntity<List<RunDTO>>
    */
    @ApiOperation(value = "查询fetch_priority_distributions", tags = {"执行用例" },  notes = "Run-fetch_priority_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Run-fetch_priority_distributions-all') or hasPermission('library',#libraryId,#dto,'ibizplm-Run-fetch_priority_distributions')")
    @PostMapping("libraries/{libraryId}/test_plans/{planId}/runs/fetch_priority_distributions")
    public ResponseEntity<List<RunDTO>> fetchPriorityDistributionsByLibraryIdAndPlanId
            (@PathVariable("libraryId") String libraryId, @PathVariable("planId") String planId, @Validated @RequestBody RunFilterDTO dto) {
        dto.setPlanIdEQ(planId);
        RunSearchContext context = runFilterDtoMapping.toDomain(dto);
        Page<Run> domains = runService.searchPriorityDistributions(context) ;
        List<RunDTO> list = runDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建执行用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Run-Create-all')")
    @ApiOperation(value = "批量新建执行用例", tags = {"执行用例" },  notes = "批量新建执行用例")
	@PostMapping("runs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<RunDTO> dtos) {
        runService.createBatch(runDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除执行用例
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Run-Remove-all')")
    @ApiOperation(value = "批量删除执行用例", tags = {"执行用例" },  notes = "批量删除执行用例")
	@DeleteMapping("runs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        runService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新执行用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Run-Update-all')")
    @ApiOperation(value = "批量更新执行用例", tags = {"执行用例" },  notes = "批量更新执行用例")
	@PutMapping("runs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<RunDTO> dtos) {
        runService.updateBatch(runDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存执行用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Run-Save-all')")
    @ApiOperation(value = "批量保存执行用例", tags = {"执行用例" },  notes = "批量保存执行用例")
	@PostMapping("runs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<RunDTO> dtos) {
        runService.saveBatch(runDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入执行用例
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Run-Save-all')")
    @ApiOperation(value = "批量导入执行用例", tags = {"执行用例" },  notes = "批量导入执行用例")
	@PostMapping("runs/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RunDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(runService.importData(config,ignoreError,runDtoMapping.toDomain(dtos)));
    }

}
