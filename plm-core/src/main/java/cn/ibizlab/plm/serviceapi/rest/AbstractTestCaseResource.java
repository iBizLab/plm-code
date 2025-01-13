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
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[TestCase] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTestCaseResource {

    @Autowired
    public TestCaseService testCaseService;

    @Autowired
    @Lazy
    public TestCaseBiSearchGroupDTOMapping testCaseBiSearchGroupDtoMapping;

    @Autowired
    @Lazy
    public TestCaseDTOMapping testCaseDtoMapping;

    @Autowired
    @Lazy
    public TestCaseFilterDTOMapping testCaseFilterDtoMapping;

    @Autowired
    @Lazy
    public TestCaseMaintenanceDTOMapping testCaseMaintenanceDtoMapping;

    /**
    * 创建Create 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"用例" },  notes = "TestCase-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Create-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Create')")
    @PostMapping("test_cases")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>create
            (@Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO create
            (TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        testCaseService.create(domain);
        TestCase rt = domain;
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"用例" },  notes = "TestCase-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Update-all') or hasPermission(this.testCaseService.get(#id),'ibizplm-TestCase-Update')")
    @VersionCheck(entity = "testcase" , versionfield = "updateTime")
    @PutMapping("test_cases/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO updateById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        testCaseService.update(domain);
        TestCase rt = domain;
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * case_move_plan 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "case_move_plan", tags = {"用例" },  notes = "TestCase-case_move_plan ")
    @PostMapping("test_cases/{id}/case_move_plan")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>caseMovePlanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(caseMovePlanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(caseMovePlanById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * case_move_plan 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO caseMovePlanById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.caseMovePlan(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * choose_case_template 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "choose_case_template", tags = {"用例" },  notes = "TestCase-choose_case_template ")
    @PostMapping("test_cases/choose_case_template")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>chooseCaseTemplate
            (@Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(chooseCaseTemplate(item)));
        else
            rt.set(chooseCaseTemplate(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_case_template 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO chooseCaseTemplate
            (TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        TestCase rt = testCaseService.chooseCaseTemplate(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * copy_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "copy_case", tags = {"用例" },  notes = "TestCase-copy_case ")
    @PostMapping("test_cases/{id}/copy_case")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>copyCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyCaseById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO copyCaseById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.copyCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * delete 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "delete", tags = {"用例" },  notes = "TestCase-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-delete-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-delete')")
    @PostMapping("test_cases/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO deleteById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.delete(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * finish_add_attention 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "finish_add_attention", tags = {"用例" },  notes = "TestCase-finish_add_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-finish_add_attention-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-finish_add_attention')")
    @PostMapping("test_cases/{id}/finish_add_attention")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>finishAddAttentionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(finishAddAttentionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(finishAddAttentionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * finish_add_attention 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO finishAddAttentionById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.finishAddAttention(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * move_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "move_case", tags = {"用例" },  notes = "TestCase-move_case ")
    @PostMapping("test_cases/{id}/move_case")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>moveCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveCaseById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO moveCaseById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.moveCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * others_relation_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "others_relation_case", tags = {"用例" },  notes = "TestCase-others_relation_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-others_relation_case-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-others_relation_case')")
    @PutMapping("test_cases/{id}/others_relation_case")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>othersRelationCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationCaseById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * others_relation_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO othersRelationCaseById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.othersRelationCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * program_test_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "program_test_case", tags = {"用例" },  notes = "TestCase-program_test_case ")
    @PostMapping("test_cases/{id}/program_test_case")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>programTestCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * program_test_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO programTestCaseById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.programTestCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * recover 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "recover", tags = {"用例" },  notes = "TestCase-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-recover-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-recover')")
    @PostMapping("test_cases/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO recoverById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.recover(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"用例" },  notes = "TestCase-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Save-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Save')")
    @PostMapping("test_cases/save")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>save
            (@Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO save
            (TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        testCaseService.save(domain);
        TestCase rt = domain;
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * set_level 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "set_level", tags = {"用例" },  notes = "TestCase-set_level ")
    @PostMapping("test_cases/{id}/set_level")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>setLevelById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setLevelById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setLevelById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_level 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO setLevelById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.setLevel(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * set_maintenance 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "set_maintenance", tags = {"用例" },  notes = "TestCase-set_maintenance ")
    @PostMapping("test_cases/{id}/set_maintenance")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>setMaintenanceById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setMaintenanceById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setMaintenanceById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_maintenance 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO setMaintenanceById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.setMaintenance(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * set_state 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "set_state", tags = {"用例" },  notes = "TestCase-set_state ")
    @PostMapping("test_cases/{id}/set_state")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>setStateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setStateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setStateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_state 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO setStateById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.setState(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * test_case_re_counters 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "test_case_re_counters", tags = {"用例" },  notes = "TestCase-test_case_re_counters ")
    @PostMapping("test_cases/{id}/test_case_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>testCaseReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(testCaseReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(testCaseReCountersById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * test_case_re_counters 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO testCaseReCountersById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.testCaseReCounters(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"用例" },  notes = "TestCase-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Create-all') or hasPermission('library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>createByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryId(testLibraryId, item)));
        else
            rt.set(createByTestLibraryId(testLibraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO createByTestLibraryId
            (String testLibraryId, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        testCaseService.create(domain);
        TestCase rt = domain;
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"用例" },  notes = "TestCase-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Update-all') or hasPermission('library',#testLibraryId,this.testCaseService.get(#id),'ibizplm-TestCase-Update')")
    @VersionCheck(entity = "testcase" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>updateByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO updateByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        testCaseService.update(domain);
        TestCase rt = domain;
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * case_move_plan 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "case_move_plan", tags = {"用例" },  notes = "TestCase-case_move_plan ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/case_move_plan")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>caseMovePlanByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(caseMovePlanByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(caseMovePlanByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * case_move_plan 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO caseMovePlanByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.caseMovePlan(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * choose_case_template 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "choose_case_template", tags = {"用例" },  notes = "TestCase-choose_case_template ")
    @PostMapping("libraries/{testLibraryId}/test_cases/choose_case_template")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>chooseCaseTemplateByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(chooseCaseTemplateByTestLibraryId(testLibraryId, item)));
        else
            rt.set(chooseCaseTemplateByTestLibraryId(testLibraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_case_template 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO chooseCaseTemplateByTestLibraryId
            (String testLibraryId, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        TestCase rt = testCaseService.chooseCaseTemplate(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * copy_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "copy_case", tags = {"用例" },  notes = "TestCase-copy_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/copy_case")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>copyCaseByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyCaseByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyCaseByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO copyCaseByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.copyCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * delete 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "delete", tags = {"用例" },  notes = "TestCase-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-delete-all') or hasPermission('library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-delete')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>deleteByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO deleteByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.delete(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * finish_add_attention 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "finish_add_attention", tags = {"用例" },  notes = "TestCase-finish_add_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-finish_add_attention-all') or hasPermission('library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-finish_add_attention')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/finish_add_attention")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>finishAddAttentionByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(finishAddAttentionByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(finishAddAttentionByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * finish_add_attention 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO finishAddAttentionByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.finishAddAttention(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * move_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "move_case", tags = {"用例" },  notes = "TestCase-move_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/move_case")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>moveCaseByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveCaseByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveCaseByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO moveCaseByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.moveCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * others_relation_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "others_relation_case", tags = {"用例" },  notes = "TestCase-others_relation_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-others_relation_case-all') or hasPermission('library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-others_relation_case')")
    @PutMapping("libraries/{testLibraryId}/test_cases/{id}/others_relation_case")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>othersRelationCaseByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationCaseByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationCaseByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * others_relation_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO othersRelationCaseByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.othersRelationCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * program_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "program_test_case", tags = {"用例" },  notes = "TestCase-program_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/program_test_case")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>programTestCaseByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * program_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO programTestCaseByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.programTestCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * recover 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "recover", tags = {"用例" },  notes = "TestCase-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-recover-all') or hasPermission('library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-recover')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>recoverByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO recoverByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.recover(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"用例" },  notes = "TestCase-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Save-all') or hasPermission('library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/save")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>saveByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryId(testLibraryId, item)));
        else
            rt.set(saveByTestLibraryId(testLibraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO saveByTestLibraryId
            (String testLibraryId, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        testCaseService.save(domain);
        TestCase rt = domain;
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * set_level 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "set_level", tags = {"用例" },  notes = "TestCase-set_level ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/set_level")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>setLevelByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setLevelByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setLevelByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_level 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO setLevelByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.setLevel(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * set_maintenance 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "set_maintenance", tags = {"用例" },  notes = "TestCase-set_maintenance ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/set_maintenance")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>setMaintenanceByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setMaintenanceByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setMaintenanceByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_maintenance 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO setMaintenanceByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.setMaintenance(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * set_state 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "set_state", tags = {"用例" },  notes = "TestCase-set_state ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/set_state")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>setStateByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setStateByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setStateByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * set_state 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO setStateByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.setState(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * test_case_re_counters 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "test_case_re_counters", tags = {"用例" },  notes = "TestCase-test_case_re_counters ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/test_case_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<TestCaseDTO>>>testCaseReCountersByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(testCaseReCountersByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(testCaseReCountersByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * test_case_re_counters 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO testCaseReCountersByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.testCaseReCounters(domain);
        return testCaseDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 用例
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"用例" },  notes = "TestCase-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Get-all')  or hasPermission(this.testCaseDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-TestCase-Get')")
    @GetMapping("test_cases/{id}")
    public Mono<ResponseEntity<TestCaseDTO>> getById
            (@PathVariable("id") String id) {
        TestCase rt = testCaseService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 用例
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"用例" },  notes = "TestCase-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Remove-all') or hasPermission(this.testCaseService.get(#id),'ibizplm-TestCase-Remove')")
    @DeleteMapping("test_cases/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = testCaseService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"用例" },  notes = "TestCase-CheckKey ")
    @PostMapping("test_cases/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        CheckKeyStatus rt = testCaseService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 用例
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"用例" },  notes = "TestCase-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-get_attention-all') or hasPermission(this.testCaseService.get(#id),'ibizplm-TestCase-get_attention')")
    @GetMapping("test_cases/{id}/get_attention")
    public Mono<ResponseEntity<TestCaseDTO>> getAttentionById
            (@PathVariable("id") String id) {
        TestCase rt = testCaseService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * get_baseline_name 用例
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "get_baseline_name", tags = {"用例" },  notes = "TestCase-get_baseline_name ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-get_baseline_name-all') or hasPermission(this.testCaseService.get(#id),'ibizplm-TestCase-get_baseline_name')")
    @GetMapping("test_cases/{id}/get_baseline_name")
    public Mono<ResponseEntity<TestCaseDTO>> getBaselineNameById
            (@PathVariable("id") String id) {
        TestCase rt = testCaseService.getBaselineName(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"用例" },  notes = "TestCase-GetDraft ")
    @GetMapping("test_cases/get_draft")
    public Mono<ResponseEntity<TestCaseDTO>> getDraft
            (@SpringQueryMap TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        TestCase rt = testCaseService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * newest_run 用例
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "newest_run", tags = {"用例" },  notes = "TestCase-newest_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-newest_run-all') or hasPermission(this.testCaseService.get(#id),'ibizplm-TestCase-newest_run')")
    @GetMapping("test_cases/{id}/newest_run")
    public Mono<ResponseEntity<TestCaseDTO>> newestRunById
            (@PathVariable("id") String id) {
        TestCase rt = testCaseService.newestRun(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_advanced_search 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"用例" },  notes = "TestCase-fetch_advanced_search ")
    @PostMapping("test_cases/fetch_advanced_search")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchAdvancedSearch
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchAdvancedSearch(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_assessment_result 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_assessment_result", tags = {"用例" },  notes = "TestCase-fetch_assessment_result ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_assessment_result-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_assessment_result')")
    @PostMapping("test_cases/fetch_assessment_result")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchAssessmentResult
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchAssessmentResult(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_case 用例
    * 基线选择用例
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_case", tags = {"用例" },  notes = "TestCase-fetch_baseline_choose_case 基线选择用例")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_baseline_choose_case-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_baseline_choose_case')")
    @PostMapping("test_cases/fetch_baseline_choose_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchBaselineChooseCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchBaselineChooseCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"用例" },  notes = "TestCase-fetch_bi_detail ")
    @PostMapping("test_cases/fetch_bi_detail")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchBiDetail
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchBiDetail(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"用例" },  notes = "TestCase-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_bi_search')")
    @PostMapping("test_cases/fetch_bi_search")
    public Mono<ResponseEntity<List<TestCaseBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchBiSearch(context) ;
        List<TestCaseBiSearchGroupDTO> list = testCaseBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_case_person 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_case_person", tags = {"用例" },  notes = "TestCase-fetch_case_person ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_case_person-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_case_person')")
    @PostMapping("test_cases/fetch_case_person")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchCasePerson
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchCasePerson(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_case_type 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_case_type", tags = {"用例" },  notes = "TestCase-fetch_case_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_case_type-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_case_type')")
    @PostMapping("test_cases/fetch_case_type")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchCaseType
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchCaseType(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_maintenance 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseMaintenanceDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_maintenance", tags = {"用例" },  notes = "TestCase-fetch_comment_notify_maintenance ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_comment_notify_maintenance-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_comment_notify_maintenance')")
    @PostMapping("test_cases/fetch_comment_notify_maintenance")
    public Mono<ResponseEntity<List<TestCaseMaintenanceDTO>>> fetchCommentNotifyMaintenance
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchCommentNotifyMaintenance(context) ;
        List<TestCaseMaintenanceDTO> list = testCaseMaintenanceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_daily_tendencies 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_daily_tendencies", tags = {"用例" },  notes = "TestCase-fetch_daily_tendencies ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_daily_tendencies-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_daily_tendencies')")
    @PostMapping("test_cases/fetch_daily_tendencies")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchDailyTendencies
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchDailyTendencies(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"用例" },  notes = "TestCase-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_default-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_default')")
    @PostMapping("test_cases/fetch_default")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchDefault
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchDefault(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_degree_importance 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_degree_importance", tags = {"用例" },  notes = "TestCase-fetch_degree_importance ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_degree_importance-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_degree_importance')")
    @PostMapping("test_cases/fetch_degree_importance")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchDegreeImportance
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchDegreeImportance(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"用例" },  notes = "TestCase-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_deleted-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_deleted')")
    @PostMapping("test_cases/fetch_deleted")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchDeleted
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchDeleted(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_everyday_test 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_everyday_test", tags = {"用例" },  notes = "TestCase-fetch_everyday_test ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_everyday_test-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_everyday_test')")
    @PostMapping("test_cases/fetch_everyday_test")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchEverydayTest
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchEverydayTest(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_idea_relation_test_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_test_case", tags = {"用例" },  notes = "TestCase-fetch_idea_relation_test_case ")
    @PostMapping("test_cases/fetch_idea_relation_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchIdeaRelationTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchIdeaRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_implementation_results 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_implementation_results", tags = {"用例" },  notes = "TestCase-fetch_implementation_results ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_implementation_results-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_implementation_results')")
    @PostMapping("test_cases/fetch_implementation_results")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchImplementationResults
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchImplementationResults(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assign 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assign", tags = {"用例" },  notes = "TestCase-fetch_my_assign ")
    @PostMapping("test_cases/fetch_my_assign")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyAssign
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyAssign(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count_test_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count_test_case", tags = {"用例" },  notes = "TestCase-fetch_my_assignee_count_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_my_assignee_count_test_case-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_my_assignee_count_test_case')")
    @PostMapping("test_cases/fetch_my_assignee_count_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyAssigneeCountTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyAssigneeCountTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"用例" },  notes = "TestCase-fetch_my_attention ")
    @PostMapping("test_cases/fetch_my_attention")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyAttention
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyAttention(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"用例" },  notes = "TestCase-fetch_my_created ")
    @PostMapping("test_cases/fetch_my_created")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyCreated
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyCreated(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"用例" },  notes = "TestCase-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_my_filter-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_my_filter')")
    @PostMapping("test_cases/fetch_my_filter")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyFilter
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyFilter(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_case", tags = {"用例" },  notes = "TestCase-fetch_my_summary_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_my_summary_case-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_my_summary_case')")
    @PostMapping("test_cases/fetch_my_summary_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMySummaryCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMySummaryCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"用例" },  notes = "TestCase-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_normal-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_normal')")
    @PostMapping("test_cases/fetch_normal")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNormal
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNormal(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_nosuite_test_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_nosuite_test_case", tags = {"用例" },  notes = "TestCase-fetch_nosuite_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_nosuite_test_case-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_nosuite_test_case')")
    @PostMapping("test_cases/fetch_nosuite_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNosuiteTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNosuiteTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_add_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_add_case", tags = {"用例" },  notes = "TestCase-fetch_not_add_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_not_add_case-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_not_add_case')")
    @PostMapping("test_cases/fetch_not_add_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNotAddCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNotAddCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"用例" },  notes = "TestCase-fetch_not_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_not_exsists_relation-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_not_exsists_relation')")
    @PostMapping("test_cases/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNotExsistsRelation
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNotExsistsRelation(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"用例" },  notes = "TestCase-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_notify_assignee-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_notify_assignee')")
    @PostMapping("test_cases/fetch_notify_assignee")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNotifyAssignee
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNotifyAssignee(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_person_distributions 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_person_distributions", tags = {"用例" },  notes = "TestCase-fetch_person_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_person_distributions-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_person_distributions')")
    @PostMapping("test_cases/fetch_person_distributions")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchPersonDistributions
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchPersonDistributions(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_priority_distributions 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_priority_distributions", tags = {"用例" },  notes = "TestCase-fetch_priority_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_priority_distributions-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_priority_distributions')")
    @PostMapping("test_cases/fetch_priority_distributions")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchPriorityDistributions
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchPriorityDistributions(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"用例" },  notes = "TestCase-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_reader-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_reader')")
    @PostMapping("test_cases/fetch_reader")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchReader
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchReader(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_test_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_test_case", tags = {"用例" },  notes = "TestCase-fetch_recent_test_case ")
    @PostMapping("test_cases/fetch_recent_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchRecentTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchRecentTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_relation_test_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_relation_test_case", tags = {"用例" },  notes = "TestCase-fetch_relation_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_relation_test_case-all') or hasPermission(#dto,'ibizplm-TestCase-fetch_relation_test_case')")
    @PostMapping("test_cases/fetch_relation_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchRelationTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_suites_test_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_suites_test_case", tags = {"用例" },  notes = "TestCase-fetch_suites_test_case ")
    @PostMapping("test_cases/fetch_suites_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchSuitesTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchSuitesTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_relation_test_case 用例
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_test_case", tags = {"用例" },  notes = "TestCase-fetch_work_item_relation_test_case ")
    @PostMapping("test_cases/fetch_work_item_relation_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchWorkItemRelationTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchWorkItemRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"用例" },  notes = "TestCase-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Get-all')  or hasPermission('library',#testLibraryId,this.testCaseDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-TestCase-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{id}")
    public Mono<ResponseEntity<TestCaseDTO>> getByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        TestCase rt = testCaseService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"用例" },  notes = "TestCase-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Remove-all') or hasPermission('library',#testLibraryId,this.testCaseService.get(#id),'ibizplm-TestCase-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{id}")
    public Mono<ResponseEntity<Boolean>> removeByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        Boolean rt = testCaseService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"用例" },  notes = "TestCase-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        CheckKeyStatus rt = testCaseService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"用例" },  notes = "TestCase-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-get_attention-all') or hasPermission('library',#testLibraryId,this.testCaseService.get(#id),'ibizplm-TestCase-get_attention')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{id}/get_attention")
    public Mono<ResponseEntity<TestCaseDTO>> getAttentionByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        TestCase rt = testCaseService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * get_baseline_name 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "get_baseline_name", tags = {"用例" },  notes = "TestCase-get_baseline_name ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-get_baseline_name-all') or hasPermission('library',#testLibraryId,this.testCaseService.get(#id),'ibizplm-TestCase-get_baseline_name')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{id}/get_baseline_name")
    public Mono<ResponseEntity<TestCaseDTO>> getBaselineNameByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        TestCase rt = testCaseService.getBaselineName(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"用例" },  notes = "TestCase-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/get_draft")
    public Mono<ResponseEntity<TestCaseDTO>> getDraftByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @SpringQueryMap TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        TestCase rt = testCaseService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * newest_run 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return Mono<ResponseEntity<TestCaseDTO>>
    */
    @ApiOperation(value = "newest_run", tags = {"用例" },  notes = "TestCase-newest_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-newest_run-all') or hasPermission('library',#testLibraryId,this.testCaseService.get(#id),'ibizplm-TestCase-newest_run')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{id}/newest_run")
    public Mono<ResponseEntity<TestCaseDTO>> newestRunByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        TestCase rt = testCaseService.newestRun(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_advanced_search 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"用例" },  notes = "TestCase-fetch_advanced_search ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_advanced_search")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchAdvancedSearchByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchAdvancedSearch(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_assessment_result 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_assessment_result", tags = {"用例" },  notes = "TestCase-fetch_assessment_result ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_assessment_result-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_assessment_result')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_assessment_result")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchAssessmentResultByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchAssessmentResult(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_case 用例
    * 基线选择用例
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_case", tags = {"用例" },  notes = "TestCase-fetch_baseline_choose_case 基线选择用例")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_baseline_choose_case-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_baseline_choose_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_baseline_choose_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchBaselineChooseCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchBaselineChooseCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"用例" },  notes = "TestCase-fetch_bi_detail ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_bi_detail")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchBiDetailByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchBiDetail(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"用例" },  notes = "TestCase-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_bi_search-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_bi_search')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_bi_search")
    public Mono<ResponseEntity<List<TestCaseBiSearchGroupDTO>>> fetchBiSearchByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchBiSearch(context) ;
        List<TestCaseBiSearchGroupDTO> list = testCaseBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_case_person 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_case_person", tags = {"用例" },  notes = "TestCase-fetch_case_person ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_case_person-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_case_person')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_case_person")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchCasePersonByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchCasePerson(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_case_type 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_case_type", tags = {"用例" },  notes = "TestCase-fetch_case_type ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_case_type-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_case_type')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_case_type")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchCaseTypeByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchCaseType(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_maintenance 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseMaintenanceDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_maintenance", tags = {"用例" },  notes = "TestCase-fetch_comment_notify_maintenance ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_comment_notify_maintenance-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_comment_notify_maintenance')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_comment_notify_maintenance")
    public Mono<ResponseEntity<List<TestCaseMaintenanceDTO>>> fetchCommentNotifyMaintenanceByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchCommentNotifyMaintenance(context) ;
        List<TestCaseMaintenanceDTO> list = testCaseMaintenanceDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_daily_tendencies 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_daily_tendencies", tags = {"用例" },  notes = "TestCase-fetch_daily_tendencies ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_daily_tendencies-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_daily_tendencies')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_daily_tendencies")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchDailyTendenciesByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchDailyTendencies(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"用例" },  notes = "TestCase-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_default")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchDefaultByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchDefault(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_degree_importance 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_degree_importance", tags = {"用例" },  notes = "TestCase-fetch_degree_importance ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_degree_importance-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_degree_importance')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_degree_importance")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchDegreeImportanceByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchDegreeImportance(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"用例" },  notes = "TestCase-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_deleted-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_deleted')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_deleted")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchDeletedByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchDeleted(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_everyday_test 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_everyday_test", tags = {"用例" },  notes = "TestCase-fetch_everyday_test ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_everyday_test-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_everyday_test')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_everyday_test")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchEverydayTestByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchEverydayTest(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_idea_relation_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_idea_relation_test_case", tags = {"用例" },  notes = "TestCase-fetch_idea_relation_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_idea_relation_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchIdeaRelationTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchIdeaRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_implementation_results 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_implementation_results", tags = {"用例" },  notes = "TestCase-fetch_implementation_results ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_implementation_results-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_implementation_results')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_implementation_results")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchImplementationResultsByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchImplementationResults(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assign 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assign", tags = {"用例" },  notes = "TestCase-fetch_my_assign ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_my_assign")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyAssignByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyAssign(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count_test_case", tags = {"用例" },  notes = "TestCase-fetch_my_assignee_count_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_my_assignee_count_test_case-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_my_assignee_count_test_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_my_assignee_count_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyAssigneeCountTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyAssigneeCountTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"用例" },  notes = "TestCase-fetch_my_attention ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_my_attention")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyAttentionByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyAttention(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"用例" },  notes = "TestCase-fetch_my_created ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_my_created")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyCreatedByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyCreated(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"用例" },  notes = "TestCase-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_my_filter-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_my_filter')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_my_filter")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMyFilterByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMyFilter(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_case", tags = {"用例" },  notes = "TestCase-fetch_my_summary_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_my_summary_case-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_my_summary_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_my_summary_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchMySummaryCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchMySummaryCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"用例" },  notes = "TestCase-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_normal-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_normal')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_normal")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNormalByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNormal(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_nosuite_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_nosuite_test_case", tags = {"用例" },  notes = "TestCase-fetch_nosuite_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_nosuite_test_case-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_nosuite_test_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_nosuite_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNosuiteTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNosuiteTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_add_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_add_case", tags = {"用例" },  notes = "TestCase-fetch_not_add_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_not_add_case-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_not_add_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_not_add_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNotAddCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNotAddCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"用例" },  notes = "TestCase-fetch_not_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_not_exsists_relation-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_not_exsists_relation')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNotExsistsRelationByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNotExsistsRelation(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"用例" },  notes = "TestCase-fetch_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_notify_assignee-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_notify_assignee')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_notify_assignee")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchNotifyAssigneeByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchNotifyAssignee(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_person_distributions 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_person_distributions", tags = {"用例" },  notes = "TestCase-fetch_person_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_person_distributions-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_person_distributions')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_person_distributions")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchPersonDistributionsByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchPersonDistributions(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_priority_distributions 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_priority_distributions", tags = {"用例" },  notes = "TestCase-fetch_priority_distributions ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_priority_distributions-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_priority_distributions')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_priority_distributions")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchPriorityDistributionsByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchPriorityDistributions(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"用例" },  notes = "TestCase-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_reader-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_reader')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_reader")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchReaderByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchReader(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_test_case", tags = {"用例" },  notes = "TestCase-fetch_recent_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_recent_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchRecentTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchRecentTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_relation_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_relation_test_case", tags = {"用例" },  notes = "TestCase-fetch_relation_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-fetch_relation_test_case-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCase-fetch_relation_test_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_relation_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchRelationTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_suites_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_suites_test_case", tags = {"用例" },  notes = "TestCase-fetch_suites_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_suites_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchSuitesTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchSuitesTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_work_item_relation_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestCaseDTO>>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_test_case", tags = {"用例" },  notes = "TestCase-fetch_work_item_relation_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetch_work_item_relation_test_case")
    public Mono<ResponseEntity<List<TestCaseDTO>>> fetchWorkItemRelationTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.fetchWorkItemRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建用例
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Create-all')")
    @ApiOperation(value = "批量新建用例", tags = {"用例" },  notes = "批量新建用例")
	@PostMapping("test_cases/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<TestCaseDTO> dtos) {
        testCaseService.create(testCaseDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除用例
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Remove-all')")
    @ApiOperation(value = "批量删除用例", tags = {"用例" },  notes = "批量删除用例")
	@DeleteMapping("test_cases/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        testCaseService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新用例
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Update-all')")
    @ApiOperation(value = "批量更新用例", tags = {"用例" },  notes = "批量更新用例")
	@PutMapping("test_cases/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<TestCaseDTO> dtos) {
        testCaseService.update(testCaseDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存用例
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Save-all')")
    @ApiOperation(value = "批量保存用例", tags = {"用例" },  notes = "批量保存用例")
	@PostMapping("test_cases/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<TestCaseDTO> dtos) {
        testCaseService.save(testCaseDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入用例
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Save-all')")
    @ApiOperation(value = "批量导入用例", tags = {"用例" },  notes = "批量导入用例")
	@PostMapping("test_cases/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TestCaseDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(testCaseService.importData(config,ignoreError,testCaseDtoMapping.toDomain(dtos))));
    }

}
