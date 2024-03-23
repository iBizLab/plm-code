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
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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
    public TestCaseDTOMapping testCaseDtoMapping;

    @Autowired
    @Lazy
    public TestCaseFilterDTOMapping testCaseFilterDtoMapping;

    @Autowired
    @Lazy
    public TestCasemaintenanceDTOMapping testCasemaintenanceDtoMapping;

    /**
    * 创建Create 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"用例" },  notes = "TestCase-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Create-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Create')")
    @PostMapping("test_cases")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> create
            (@Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"用例" },  notes = "TestCase-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Update-all') or hasPermission(this.testCaseService.get(#id),'ibizplm-TestCase-Update')")
    @VersionCheck(entity = "testcase" , versionfield = "updateTime")
    @PutMapping("test_cases/{id}")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Case_move_plan 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Case_move_plan", tags = {"用例" },  notes = "TestCase-Case_move_plan ")
    @PostMapping("test_cases/{id}/case_move_plan")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> caseMovePlanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(caseMovePlanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(caseMovePlanById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Case_move_plan 用例
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
    * Copy_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Copy_case", tags = {"用例" },  notes = "TestCase-Copy_case ")
    @PostMapping("test_cases/{id}/copy_case")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> copyCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyCaseById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Copy_case 用例
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
    * Del_relation 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"用例" },  notes = "TestCase-Del_relation ")
    @PostMapping("test_cases/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO delRelationById
            (String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.delRelation(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * Delete 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Delete", tags = {"用例" },  notes = "TestCase-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Delete-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Delete')")
    @PostMapping("test_cases/{id}/delete")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 用例
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
    * Move_case 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Move_case", tags = {"用例" },  notes = "TestCase-Move_case ")
    @PostMapping("test_cases/{id}/move_case")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> moveCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveCaseById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Move_case 用例
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
    * Others_relation_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Others_relation_case", tags = {"用例" },  notes = "TestCase-Others_relation_case ")
    @PostMapping("test_cases/others_relation_case")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> othersRelationCase
            (@Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(othersRelationCase(item)));
        else
            rt.set(othersRelationCase(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Others_relation_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO othersRelationCase
            (TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        TestCase rt = testCaseService.othersRelationCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * Recover 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Recover", tags = {"用例" },  notes = "TestCase-Recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Recover-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Recover')")
    @PostMapping("test_cases/{id}/recover")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Recover 用例
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
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"用例" },  notes = "TestCase-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Save-all') or hasPermission(this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Save')")
    @PostMapping("test_cases/save")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> save
            (@Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Set_level 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Set_level", tags = {"用例" },  notes = "TestCase-Set_level ")
    @PostMapping("test_cases/{id}/set_level")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> setLevelById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setLevelById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setLevelById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_level 用例
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
    * Set_maintenance 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Set_maintenance", tags = {"用例" },  notes = "TestCase-Set_maintenance ")
    @PostMapping("test_cases/{id}/set_maintenance")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> setMaintenanceById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setMaintenanceById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setMaintenanceById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_maintenance 用例
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
    * Set_state 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Set_state", tags = {"用例" },  notes = "TestCase-Set_state ")
    @PostMapping("test_cases/{id}/set_state")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> setStateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setStateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setStateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_state 用例
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
    * Test_case_re_counters 用例
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Test_case_re_counters", tags = {"用例" },  notes = "TestCase-Test_case_re_counters ")
    @PostMapping("test_cases/{id}/test_case_re_counters")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> testCaseReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(testCaseReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(testCaseReCountersById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Test_case_re_counters 用例
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
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"用例" },  notes = "TestCase-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Create-all') or hasPermission('Library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Create')")
    @PostMapping("libraries/{testLibraryId}/test_cases")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> createByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryId(testLibraryId, item)));
        else
            rt.set(createByTestLibraryId(testLibraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"用例" },  notes = "TestCase-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Update-all') or hasPermission('Library',#testLibraryId,this.testCaseService.get(#id),'ibizplm-TestCase-Update')")
    @VersionCheck(entity = "testcase" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_cases/{id}")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> updateByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Case_move_plan 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Case_move_plan", tags = {"用例" },  notes = "TestCase-Case_move_plan ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/case_move_plan")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> caseMovePlanByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(caseMovePlanByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(caseMovePlanByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Case_move_plan 用例
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
    * Copy_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Copy_case", tags = {"用例" },  notes = "TestCase-Copy_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/copy_case")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> copyCaseByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyCaseByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyCaseByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Copy_case 用例
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
    * Del_relation 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"用例" },  notes = "TestCase-Del_relation ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> delRelationByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO delRelationByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setId(id);
        TestCase rt = testCaseService.delRelation(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * Delete 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Delete", tags = {"用例" },  notes = "TestCase-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Delete-all') or hasPermission('Library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Delete')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/delete")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> deleteByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 用例
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
    * Move_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Move_case", tags = {"用例" },  notes = "TestCase-Move_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/move_case")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> moveCaseByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveCaseByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveCaseByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Move_case 用例
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
    * Others_relation_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Others_relation_case", tags = {"用例" },  notes = "TestCase-Others_relation_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/others_relation_case")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> othersRelationCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(othersRelationCaseByTestLibraryId(testLibraryId, item)));
        else
            rt.set(othersRelationCaseByTestLibraryId(testLibraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Others_relation_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */   
    public TestCaseDTO othersRelationCaseByTestLibraryId
            (String testLibraryId, TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        TestCase rt = testCaseService.othersRelationCase(domain);
        return testCaseDtoMapping.toDto(rt);
    }

    /**
    * Recover 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Recover", tags = {"用例" },  notes = "TestCase-Recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Recover-all') or hasPermission('Library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Recover')")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/recover")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> recoverByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Recover 用例
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
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"用例" },  notes = "TestCase-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Save-all') or hasPermission('Library',#testLibraryId,this.testCaseDtoMapping.toDomain(#dto),'ibizplm-TestCase-Save')")
    @PostMapping("libraries/{testLibraryId}/test_cases/save")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> saveByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryId(testLibraryId, item)));
        else
            rt.set(saveByTestLibraryId(testLibraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Set_level 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Set_level", tags = {"用例" },  notes = "TestCase-Set_level ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/set_level")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> setLevelByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setLevelByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setLevelByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_level 用例
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
    * Set_maintenance 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Set_maintenance", tags = {"用例" },  notes = "TestCase-Set_maintenance ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/set_maintenance")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> setMaintenanceByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setMaintenanceByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setMaintenanceByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_maintenance 用例
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
    * Set_state 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Set_state", tags = {"用例" },  notes = "TestCase-Set_state ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/set_state")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> setStateByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(setStateByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(setStateByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Set_state 用例
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
    * Test_case_re_counters 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Test_case_re_counters", tags = {"用例" },  notes = "TestCase-Test_case_re_counters ")
    @PostMapping("libraries/{testLibraryId}/test_cases/{id}/test_case_re_counters")
    public ResponseEntity<ResponseWrapper<TestCaseDTO>> testCaseReCountersByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseDTO> dto) {
        ResponseWrapper<TestCaseDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(testCaseReCountersByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(testCaseReCountersByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Test_case_re_counters 用例
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
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"用例" },  notes = "TestCase-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Get-all')  or hasPermission(this.testCaseDtoMapping.toDomain(returnObject.body),'ibizplm-TestCase-Get')")
    @GetMapping("test_cases/{id}")
    public ResponseEntity<TestCaseDTO> getById
            (@PathVariable("id") String id) {
        TestCase rt = testCaseService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 用例
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"用例" },  notes = "TestCase-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Remove-all') or hasPermission(this.testCaseService.get(#id),'ibizplm-TestCase-Remove')")
    @DeleteMapping("test_cases/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = testCaseService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"用例" },  notes = "TestCase-CheckKey ")
    @PostMapping("test_cases/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        Integer rt = testCaseService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"用例" },  notes = "TestCase-GetDraft ")
    @GetMapping("test_cases/getdraft")
    public ResponseEntity<TestCaseDTO> getDraft
            (@SpringQueryMap TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        TestCase rt = testCaseService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt));
    }

    /**
    * Get_actual_workload 用例
    * 
    *
    * @param id id
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Get_actual_workload", tags = {"用例" },  notes = "TestCase-Get_actual_workload ")
    @GetMapping("test_cases/{id}/get_actual_workload")
    public ResponseEntity<TestCaseDTO> getActualWorkloadById
            (@PathVariable("id") String id) {
        TestCase rt = testCaseService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt));
    }

    /**
    * Newest_run 用例
    * 
    *
    * @param id id
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Newest_run", tags = {"用例" },  notes = "TestCase-Newest_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Newest_run-all') or hasPermission(this.testCaseService.get(#id),'ibizplm-TestCase-Newest_run')")
    @GetMapping("test_cases/{id}/newest_run")
    public ResponseEntity<TestCaseDTO> newestRunById
            (@PathVariable("id") String id) {
        TestCase rt = testCaseService.newestRun(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchComment_notify_maintenance 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCasemaintenanceDTO>>
    */
    @ApiOperation(value = "查询FetchComment_notify_maintenance", tags = {"用例" },  notes = "TestCase-FetchComment_notify_maintenance ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchComment_notify_maintenance-all') or hasPermission(#dto,'ibizplm-TestCase-FetchComment_notify_maintenance')")
    @PostMapping("test_cases/fetchcomment_notify_maintenance")
    public ResponseEntity<List<TestCasemaintenanceDTO>> fetchCommentNotifyMaintenance
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchCommentNotifyMaintenance(context) ;
        List<TestCasemaintenanceDTO> list = testCasemaintenanceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"用例" },  notes = "TestCase-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchDefault-all') or hasPermission(#dto,'ibizplm-TestCase-FetchDefault')")
    @PostMapping("test_cases/fetchdefault")
    public ResponseEntity<List<TestCaseDTO>> fetchDefault
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchDefault(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDeleted 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"用例" },  notes = "TestCase-FetchDeleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchDeleted-all') or hasPermission(#dto,'ibizplm-TestCase-FetchDeleted')")
    @PostMapping("test_cases/fetchdeleted")
    public ResponseEntity<List<TestCaseDTO>> fetchDeleted
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchDeleted(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_relation_test_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_relation_test_case", tags = {"用例" },  notes = "TestCase-FetchIdea_relation_test_case ")
    @PostMapping("test_cases/fetchidea_relation_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchIdeaRelationTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchIdeaRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assign 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assign", tags = {"用例" },  notes = "TestCase-FetchMy_assign ")
    @PostMapping("test_cases/fetchmy_assign")
    public ResponseEntity<List<TestCaseDTO>> fetchMyAssign
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchMyAssign(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assignee_count_test_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assignee_count_test_case", tags = {"用例" },  notes = "TestCase-FetchMy_assignee_count_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchMy_assignee_count_test_case-all') or hasPermission(#dto,'ibizplm-TestCase-FetchMy_assignee_count_test_case')")
    @PostMapping("test_cases/fetchmy_assignee_count_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchMyAssigneeCountTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchMyAssigneeCountTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_attention 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchMy_attention", tags = {"用例" },  notes = "TestCase-FetchMy_attention ")
    @PostMapping("test_cases/fetchmy_attention")
    public ResponseEntity<List<TestCaseDTO>> fetchMyAttention
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchMyAttention(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_created 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchMy_created", tags = {"用例" },  notes = "TestCase-FetchMy_created ")
    @PostMapping("test_cases/fetchmy_created")
    public ResponseEntity<List<TestCaseDTO>> fetchMyCreated
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchMyCreated(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"用例" },  notes = "TestCase-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchNormal-all') or hasPermission(#dto,'ibizplm-TestCase-FetchNormal')")
    @PostMapping("test_cases/fetchnormal")
    public ResponseEntity<List<TestCaseDTO>> fetchNormal
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchNormal(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNosuite_test_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchNosuite_test_case", tags = {"用例" },  notes = "TestCase-FetchNosuite_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchNosuite_test_case-all') or hasPermission(#dto,'ibizplm-TestCase-FetchNosuite_test_case')")
    @PostMapping("test_cases/fetchnosuite_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchNosuiteTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchNosuiteTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_add_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchNot_add_case", tags = {"用例" },  notes = "TestCase-FetchNot_add_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchNot_add_case-all') or hasPermission(#dto,'ibizplm-TestCase-FetchNot_add_case')")
    @PostMapping("test_cases/fetchnot_add_case")
    public ResponseEntity<List<TestCaseDTO>> fetchNotAddCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchNotAddCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_exsists_relation 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchNot_exsists_relation", tags = {"用例" },  notes = "TestCase-FetchNot_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchNot_exsists_relation-all') or hasPermission(#dto,'ibizplm-TestCase-FetchNot_exsists_relation')")
    @PostMapping("test_cases/fetchnot_exsists_relation")
    public ResponseEntity<List<TestCaseDTO>> fetchNotExsistsRelation
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchNotExsistsRelation(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_test_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_test_case", tags = {"用例" },  notes = "TestCase-FetchRecent_test_case ")
    @PostMapping("test_cases/fetchrecent_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchRecentTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchRecentTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchSuites_test_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchSuites_test_case", tags = {"用例" },  notes = "TestCase-FetchSuites_test_case ")
    @PostMapping("test_cases/fetchsuites_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchSuitesTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchSuitesTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchWork_item_relation_test_case 用例
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchWork_item_relation_test_case", tags = {"用例" },  notes = "TestCase-FetchWork_item_relation_test_case ")
    @PostMapping("test_cases/fetchwork_item_relation_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchWorkItemRelationTestCase
            (@Validated @RequestBody TestCaseFilterDTO dto) {
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchWorkItemRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"用例" },  notes = "TestCase-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Get-all')  or hasPermission('Library',#testLibraryId,this.testCaseDtoMapping.toDomain(returnObject.body),'ibizplm-TestCase-Get')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{id}")
    public ResponseEntity<TestCaseDTO> getByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        TestCase rt = testCaseService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"用例" },  notes = "TestCase-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Remove-all') or hasPermission('Library',#testLibraryId,this.testCaseService.get(#id),'ibizplm-TestCase-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_cases/{id}")
    public ResponseEntity<Boolean> removeByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        Boolean rt = testCaseService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"用例" },  notes = "TestCase-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_cases/checkkey")
    public ResponseEntity<Integer> checkKeyByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        Integer rt = testCaseService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"用例" },  notes = "TestCase-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_cases/getdraft")
    public ResponseEntity<TestCaseDTO> getDraftByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @SpringQueryMap TestCaseDTO dto) {
        TestCase domain = testCaseDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        TestCase rt = testCaseService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt));
    }

    /**
    * Get_actual_workload 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Get_actual_workload", tags = {"用例" },  notes = "TestCase-Get_actual_workload ")
    @GetMapping("libraries/{testLibraryId}/test_cases/{id}/get_actual_workload")
    public ResponseEntity<TestCaseDTO> getActualWorkloadByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        TestCase rt = testCaseService.getActualWorkload(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt));
    }

    /**
    * Newest_run 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return ResponseEntity<TestCaseDTO>
    */
    @ApiOperation(value = "Newest_run", tags = {"用例" },  notes = "TestCase-Newest_run ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-Newest_run-all') or hasPermission('Library',#testLibraryId,this.testCaseService.get(#id),'ibizplm-TestCase-Newest_run')")
    @GetMapping("libraries/{testLibraryId}/test_cases/{id}/newest_run")
    public ResponseEntity<TestCaseDTO> newestRunByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        TestCase rt = testCaseService.newestRun(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchComment_notify_maintenance 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCasemaintenanceDTO>>
    */
    @ApiOperation(value = "查询FetchComment_notify_maintenance", tags = {"用例" },  notes = "TestCase-FetchComment_notify_maintenance ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchComment_notify_maintenance-all') or hasPermission('Library',#testLibraryId,#dto,'ibizplm-TestCase-FetchComment_notify_maintenance')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchcomment_notify_maintenance")
    public ResponseEntity<List<TestCasemaintenanceDTO>> fetchCommentNotifyMaintenanceByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchCommentNotifyMaintenance(context) ;
        List<TestCasemaintenanceDTO> list = testCasemaintenanceDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"用例" },  notes = "TestCase-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchDefault-all') or hasPermission('Library',#testLibraryId,#dto,'ibizplm-TestCase-FetchDefault')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchdefault")
    public ResponseEntity<List<TestCaseDTO>> fetchDefaultByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchDefault(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDeleted 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"用例" },  notes = "TestCase-FetchDeleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchDeleted-all') or hasPermission('Library',#testLibraryId,#dto,'ibizplm-TestCase-FetchDeleted')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchdeleted")
    public ResponseEntity<List<TestCaseDTO>> fetchDeletedByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchDeleted(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_relation_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_relation_test_case", tags = {"用例" },  notes = "TestCase-FetchIdea_relation_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchidea_relation_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchIdeaRelationTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchIdeaRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assign 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assign", tags = {"用例" },  notes = "TestCase-FetchMy_assign ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchmy_assign")
    public ResponseEntity<List<TestCaseDTO>> fetchMyAssignByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchMyAssign(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assignee_count_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assignee_count_test_case", tags = {"用例" },  notes = "TestCase-FetchMy_assignee_count_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchMy_assignee_count_test_case-all') or hasPermission('Library',#testLibraryId,#dto,'ibizplm-TestCase-FetchMy_assignee_count_test_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchmy_assignee_count_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchMyAssigneeCountTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchMyAssigneeCountTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_attention 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchMy_attention", tags = {"用例" },  notes = "TestCase-FetchMy_attention ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchmy_attention")
    public ResponseEntity<List<TestCaseDTO>> fetchMyAttentionByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchMyAttention(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_created 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchMy_created", tags = {"用例" },  notes = "TestCase-FetchMy_created ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchmy_created")
    public ResponseEntity<List<TestCaseDTO>> fetchMyCreatedByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchMyCreated(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"用例" },  notes = "TestCase-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchNormal-all') or hasPermission('Library',#testLibraryId,#dto,'ibizplm-TestCase-FetchNormal')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchnormal")
    public ResponseEntity<List<TestCaseDTO>> fetchNormalByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchNormal(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNosuite_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchNosuite_test_case", tags = {"用例" },  notes = "TestCase-FetchNosuite_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchNosuite_test_case-all') or hasPermission('Library',#testLibraryId,#dto,'ibizplm-TestCase-FetchNosuite_test_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchnosuite_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchNosuiteTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchNosuiteTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_add_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchNot_add_case", tags = {"用例" },  notes = "TestCase-FetchNot_add_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchNot_add_case-all') or hasPermission('Library',#testLibraryId,#dto,'ibizplm-TestCase-FetchNot_add_case')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchnot_add_case")
    public ResponseEntity<List<TestCaseDTO>> fetchNotAddCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchNotAddCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_exsists_relation 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchNot_exsists_relation", tags = {"用例" },  notes = "TestCase-FetchNot_exsists_relation ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCase-FetchNot_exsists_relation-all') or hasPermission('Library',#testLibraryId,#dto,'ibizplm-TestCase-FetchNot_exsists_relation')")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchnot_exsists_relation")
    public ResponseEntity<List<TestCaseDTO>> fetchNotExsistsRelationByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchNotExsistsRelation(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_test_case", tags = {"用例" },  notes = "TestCase-FetchRecent_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchrecent_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchRecentTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchRecentTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchSuites_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchSuites_test_case", tags = {"用例" },  notes = "TestCase-FetchSuites_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchsuites_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchSuitesTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchSuitesTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchWork_item_relation_test_case 用例
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseDTO>>
    */
    @ApiOperation(value = "查询FetchWork_item_relation_test_case", tags = {"用例" },  notes = "TestCase-FetchWork_item_relation_test_case ")
    @PostMapping("libraries/{testLibraryId}/test_cases/fetchwork_item_relation_test_case")
    public ResponseEntity<List<TestCaseDTO>> fetchWorkItemRelationTestCaseByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseSearchContext context = testCaseFilterDtoMapping.toDomain(dto);
        Page<TestCase> domains = testCaseService.searchWorkItemRelationTestCase(context) ;
        List<TestCaseDTO> list = testCaseDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Create-all')")
    @ApiOperation(value = "批量新建用例", tags = {"用例" },  notes = "批量新建用例")
	@PostMapping("test_cases/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TestCaseDTO> dtos) {
        testCaseService.createBatch(testCaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除用例
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Remove-all')")
    @ApiOperation(value = "批量删除用例", tags = {"用例" },  notes = "批量删除用例")
	@DeleteMapping("test_cases/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        testCaseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Update-all')")
    @ApiOperation(value = "批量更新用例", tags = {"用例" },  notes = "批量更新用例")
	@PutMapping("test_cases/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TestCaseDTO> dtos) {
        testCaseService.updateBatch(testCaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存用例
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Save-all')")
    @ApiOperation(value = "批量保存用例", tags = {"用例" },  notes = "批量保存用例")
	@PostMapping("test_cases/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TestCaseDTO> dtos) {
        testCaseService.saveBatch(testCaseDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入用例
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestCase-Save-all')")
    @ApiOperation(value = "批量导入用例", tags = {"用例" },  notes = "批量导入用例")
	@PostMapping("test_cases/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TestCaseDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(testCaseService.importData(config,ignoreError,testCaseDtoMapping.toDomain(dtos)));
    }

}
