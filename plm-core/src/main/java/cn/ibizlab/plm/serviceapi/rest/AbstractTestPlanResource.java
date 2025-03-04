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
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.testmgmt.filter.TestPlanSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[TestPlan] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTestPlanResource {

    @Autowired
    public TestPlanService testPlanService;

    @Autowired
    @Lazy
    public TestPlanBiSearchGroupDTOMapping testPlanBiSearchGroupDtoMapping;

    @Autowired
    @Lazy
    public TestPlanDTOMapping testPlanDtoMapping;

    @Autowired
    @Lazy
    public TestPlanFilterDTOMapping testPlanFilterDtoMapping;

    /**
    * 创建Create 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"测试计划" },  notes = "TestPlan-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Create-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Create')")
    @PostMapping("test_plans")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>create
            (@Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO create
            (TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        testPlanService.create(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 测试计划
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"测试计划" },  notes = "TestPlan-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Update-all') or hasPermission(this.testPlanService.get(#id),'ibizplm-TestPlan-Update')")
    @VersionCheck(entity = "testplan" , versionfield = "updateTime")
    @PutMapping("test_plans/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 测试计划
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO updateById
            (String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        testPlanService.update(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"测试计划" },  notes = "TestPlan-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-delete_categories-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-delete_categories')")
    @PostMapping("test_plans/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>deleteCategories
            (@Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(deleteCategories(item)));
        else
            rt.set(deleteCategories(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO deleteCategories
            (TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        TestPlan rt = testPlanService.deleteCategories(domain);
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * end_test_plan 测试计划
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "end_test_plan", tags = {"测试计划" },  notes = "TestPlan-end_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-end_test_plan-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-end_test_plan')")
    @PostMapping("test_plans/{id}/end_test_plan")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>endTestPlanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endTestPlanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endTestPlanById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * end_test_plan 测试计划
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO endTestPlanById
            (String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        TestPlan rt = testPlanService.endTestPlan(domain);
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"测试计划" },  notes = "TestPlan-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Save-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Save')")
    @PostMapping("test_plans/save")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>save
            (@Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO save
            (TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        testPlanService.save(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * start_test_plan 测试计划
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "start_test_plan", tags = {"测试计划" },  notes = "TestPlan-start_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-start_test_plan-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-start_test_plan')")
    @PostMapping("test_plans/{id}/start_test_plan")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>startTestPlanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startTestPlanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startTestPlanById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_test_plan 测试计划
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO startTestPlanById
            (String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        TestPlan rt = testPlanService.startTestPlan(domain);
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"测试计划" },  notes = "TestPlan-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Create-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Create')")
    @PostMapping("libraries/{libraryId}/test_plans")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>createByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryId(libraryId, item)));
        else
            rt.set(createByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO createByLibraryId
            (String libraryId, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        testPlanService.create(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"测试计划" },  notes = "TestPlan-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Update-all') or hasPermission('library',#libraryId,this.testPlanService.get(#id),'ibizplm-TestPlan-Update')")
    @VersionCheck(entity = "testplan" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/test_plans/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>updateByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO updateByLibraryIdAndId
            (String libraryId, String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        testPlanService.update(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"测试计划" },  notes = "TestPlan-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-delete_categories-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-delete_categories')")
    @PostMapping("libraries/{libraryId}/test_plans/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>deleteCategoriesByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(deleteCategoriesByLibraryId(libraryId, item)));
        else
            rt.set(deleteCategoriesByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO deleteCategoriesByLibraryId
            (String libraryId, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        TestPlan rt = testPlanService.deleteCategories(domain);
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * end_test_plan 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "end_test_plan", tags = {"测试计划" },  notes = "TestPlan-end_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-end_test_plan-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-end_test_plan')")
    @PostMapping("libraries/{libraryId}/test_plans/{id}/end_test_plan")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>endTestPlanByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endTestPlanByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endTestPlanByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * end_test_plan 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO endTestPlanByLibraryIdAndId
            (String libraryId, String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        TestPlan rt = testPlanService.endTestPlan(domain);
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"测试计划" },  notes = "TestPlan-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Save-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Save')")
    @PostMapping("libraries/{libraryId}/test_plans/save")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>saveByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryId(libraryId, item)));
        else
            rt.set(saveByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO saveByLibraryId
            (String libraryId, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        testPlanService.save(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * start_test_plan 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "start_test_plan", tags = {"测试计划" },  notes = "TestPlan-start_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-start_test_plan-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-start_test_plan')")
    @PostMapping("libraries/{libraryId}/test_plans/{id}/start_test_plan")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>startTestPlanByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startTestPlanByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startTestPlanByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_test_plan 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO startTestPlanByLibraryIdAndId
            (String libraryId, String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        TestPlan rt = testPlanService.startTestPlan(domain);
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"测试计划" },  notes = "TestPlan-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Create-all') or hasPermission('project',#projectId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Create')")
    @PostMapping("projects/{projectId}/test_plans")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>createByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProjectId(projectId, item)));
        else
            rt.set(createByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO createByProjectId
            (String projectId, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        testPlanService.create(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"测试计划" },  notes = "TestPlan-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Update-all') or hasPermission('project',#projectId,this.testPlanService.get(#id),'ibizplm-TestPlan-Update')")
    @VersionCheck(entity = "testplan" , versionfield = "updateTime")
    @PutMapping("projects/{projectId}/test_plans/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>updateByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO updateByProjectIdAndId
            (String projectId, String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        testPlanService.update(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"测试计划" },  notes = "TestPlan-delete_categories ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-delete_categories-all') or hasPermission('project',#projectId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-delete_categories')")
    @PostMapping("projects/{projectId}/test_plans/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>deleteCategoriesByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(deleteCategoriesByProjectId(projectId, item)));
        else
            rt.set(deleteCategoriesByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO deleteCategoriesByProjectId
            (String projectId, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        TestPlan rt = testPlanService.deleteCategories(domain);
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * end_test_plan 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "end_test_plan", tags = {"测试计划" },  notes = "TestPlan-end_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-end_test_plan-all') or hasPermission('project',#projectId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-end_test_plan')")
    @PostMapping("projects/{projectId}/test_plans/{id}/end_test_plan")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>endTestPlanByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endTestPlanByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endTestPlanByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * end_test_plan 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO endTestPlanByProjectIdAndId
            (String projectId, String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        TestPlan rt = testPlanService.endTestPlan(domain);
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"测试计划" },  notes = "TestPlan-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Save-all') or hasPermission('project',#projectId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Save')")
    @PostMapping("projects/{projectId}/test_plans/save")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>saveByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProjectId(projectId, item)));
        else
            rt.set(saveByProjectId(projectId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO saveByProjectId
            (String projectId, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        testPlanService.save(domain);
        TestPlan rt = domain;
        return testPlanDtoMapping.toDto(rt);
    }

    /**
    * start_test_plan 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "start_test_plan", tags = {"测试计划" },  notes = "TestPlan-start_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-start_test_plan-all') or hasPermission('project',#projectId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-start_test_plan')")
    @PostMapping("projects/{projectId}/test_plans/{id}/start_test_plan")
    public Mono<ResponseEntity<ResponseWrapper<TestPlanDTO>>>startTestPlanByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startTestPlanByProjectIdAndId(projectId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startTestPlanByProjectIdAndId(projectId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * start_test_plan 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */   
    public TestPlanDTO startTestPlanByProjectIdAndId
            (String projectId, String id, TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        TestPlan rt = testPlanService.startTestPlan(domain);
        return testPlanDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 测试计划
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"测试计划" },  notes = "TestPlan-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Get-all')  or hasPermission(this.testPlanDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-TestPlan-Get')")
    @GetMapping("test_plans/{id}")
    public Mono<ResponseEntity<TestPlanDTO>> getById
            (@PathVariable("id") String id) {
        TestPlan rt = testPlanService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 测试计划
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试计划" },  notes = "TestPlan-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Remove-all') or hasPermission(this.testPlanService.get(#id),'ibizplm-TestPlan-Remove')")
    @DeleteMapping("test_plans/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = testPlanService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试计划" },  notes = "TestPlan-CheckKey ")
    @PostMapping("test_plans/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        CheckKeyStatus rt = testPlanService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试计划" },  notes = "TestPlan-GetDraft ")
    @GetMapping("test_plans/get_draft")
    public Mono<ResponseEntity<TestPlanDTO>> getDraft
            (@SpringQueryMap TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        TestPlan rt = testPlanService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * test_plan_report_survey 测试计划
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "test_plan_report_survey", tags = {"测试计划" },  notes = "TestPlan-test_plan_report_survey ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-test_plan_report_survey-all') or hasPermission(this.testPlanService.get(#id),'ibizplm-TestPlan-test_plan_report_survey')")
    @GetMapping("test_plans/{id}/test_plan_report_survey")
    public Mono<ResponseEntity<TestPlanDTO>> testPlanReportSurveyById
            (@PathVariable("id") String id) {
        TestPlan rt = testPlanService.testPlanReportSurvey(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_detail 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"测试计划" },  notes = "TestPlan-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_bi_detail-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_bi_detail')")
    @PostMapping("test_plans/fetch_bi_detail")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchBiDetail
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchBiDetail(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"测试计划" },  notes = "TestPlan-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_bi_search')")
    @PostMapping("test_plans/fetch_bi_search")
    public Mono<ResponseEntity<List<TestPlanBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchBiSearch(context) ;
        List<TestPlanBiSearchGroupDTO> list = testPlanBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_project 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_project", tags = {"测试计划" },  notes = "TestPlan-fetch_cur_project ")
    @PostMapping("test_plans/fetch_cur_project")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchCurProject
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchCurProject(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"测试计划" },  notes = "TestPlan-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_default-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_default')")
    @PostMapping("test_plans/fetch_default")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchDefault
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchDefault(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"测试计划" },  notes = "TestPlan-fetch_my_assignee ")
    @PostMapping("test_plans/fetch_my_assignee")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyAssignee
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyAssignee(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_in_progress 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_my_in_progress ")
    @PostMapping("test_plans/fetch_my_in_progress")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyInProgress
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_participate 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_participate", tags = {"测试计划" },  notes = "TestPlan-fetch_my_participate ")
    @PostMapping("test_plans/fetch_my_participate")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyParticipate
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyParticipate(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_pending_and_in_progress 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_pending_and_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_pending_and_in_progress ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_pending_and_in_progress-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_pending_and_in_progress')")
    @PostMapping("test_plans/fetch_pending_and_in_progress")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchPendingAndInProgress
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchPendingAndInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_query_no_shift_in 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_query_no_shift_in", tags = {"测试计划" },  notes = "TestPlan-fetch_query_no_shift_in ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_query_no_shift_in-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_query_no_shift_in')")
    @PostMapping("test_plans/fetch_query_no_shift_in")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchQueryNoShiftIn
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchQueryNoShiftIn(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_un_join_plan 测试计划
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_un_join_plan", tags = {"测试计划" },  notes = "TestPlan-fetch_un_join_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_un_join_plan-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_un_join_plan')")
    @PostMapping("test_plans/fetch_un_join_plan")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchUnJoinPlan
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchUnJoinPlan(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"测试计划" },  notes = "TestPlan-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Get-all')  or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-TestPlan-Get')")
    @GetMapping("libraries/{libraryId}/test_plans/{id}")
    public Mono<ResponseEntity<TestPlanDTO>> getByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        TestPlan rt = testPlanService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试计划" },  notes = "TestPlan-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Remove-all') or hasPermission('library',#libraryId,this.testPlanService.get(#id),'ibizplm-TestPlan-Remove')")
    @DeleteMapping("libraries/{libraryId}/test_plans/{id}")
    public Mono<ResponseEntity<Boolean>> removeByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Boolean rt = testPlanService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试计划" },  notes = "TestPlan-CheckKey ")
    @PostMapping("libraries/{libraryId}/test_plans/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        CheckKeyStatus rt = testPlanService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试计划" },  notes = "TestPlan-GetDraft ")
    @GetMapping("libraries/{libraryId}/test_plans/get_draft")
    public Mono<ResponseEntity<TestPlanDTO>> getDraftByLibraryId
            (@PathVariable("libraryId") String libraryId, @SpringQueryMap TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        TestPlan rt = testPlanService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * test_plan_report_survey 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "test_plan_report_survey", tags = {"测试计划" },  notes = "TestPlan-test_plan_report_survey ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-test_plan_report_survey-all') or hasPermission('library',#libraryId,this.testPlanService.get(#id),'ibizplm-TestPlan-test_plan_report_survey')")
    @GetMapping("libraries/{libraryId}/test_plans/{id}/test_plan_report_survey")
    public Mono<ResponseEntity<TestPlanDTO>> testPlanReportSurveyByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        TestPlan rt = testPlanService.testPlanReportSurvey(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_detail 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"测试计划" },  notes = "TestPlan-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_bi_detail-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_bi_detail')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_bi_detail")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchBiDetailByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchBiDetail(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"测试计划" },  notes = "TestPlan-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_bi_search-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_bi_search')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_bi_search")
    public Mono<ResponseEntity<List<TestPlanBiSearchGroupDTO>>> fetchBiSearchByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchBiSearch(context) ;
        List<TestPlanBiSearchGroupDTO> list = testPlanBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_project 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_project", tags = {"测试计划" },  notes = "TestPlan-fetch_cur_project ")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_cur_project")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchCurProjectByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchCurProject(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"测试计划" },  notes = "TestPlan-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_default')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_default")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchDefaultByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchDefault(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"测试计划" },  notes = "TestPlan-fetch_my_assignee ")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_my_assignee")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyAssigneeByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyAssignee(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_in_progress 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_my_in_progress ")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_my_in_progress")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyInProgressByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_participate 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_participate", tags = {"测试计划" },  notes = "TestPlan-fetch_my_participate ")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_my_participate")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyParticipateByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyParticipate(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_pending_and_in_progress 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_pending_and_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_pending_and_in_progress ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_pending_and_in_progress-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_pending_and_in_progress')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_pending_and_in_progress")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchPendingAndInProgressByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchPendingAndInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_query_no_shift_in 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_query_no_shift_in", tags = {"测试计划" },  notes = "TestPlan-fetch_query_no_shift_in ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_query_no_shift_in-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_query_no_shift_in')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_query_no_shift_in")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchQueryNoShiftInByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchQueryNoShiftIn(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_un_join_plan 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_un_join_plan", tags = {"测试计划" },  notes = "TestPlan-fetch_un_join_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_un_join_plan-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_un_join_plan')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_un_join_plan")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchUnJoinPlanByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchUnJoinPlan(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"测试计划" },  notes = "TestPlan-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Get-all')  or hasPermission('project',#projectId,this.testPlanDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-TestPlan-Get')")
    @GetMapping("projects/{projectId}/test_plans/{id}")
    public Mono<ResponseEntity<TestPlanDTO>> getByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        TestPlan rt = testPlanService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试计划" },  notes = "TestPlan-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Remove-all') or hasPermission('project',#projectId,this.testPlanService.get(#id),'ibizplm-TestPlan-Remove')")
    @DeleteMapping("projects/{projectId}/test_plans/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        Boolean rt = testPlanService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试计划" },  notes = "TestPlan-CheckKey ")
    @PostMapping("projects/{projectId}/test_plans/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        CheckKeyStatus rt = testPlanService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试计划" },  notes = "TestPlan-GetDraft ")
    @GetMapping("projects/{projectId}/test_plans/get_draft")
    public Mono<ResponseEntity<TestPlanDTO>> getDraftByProjectId
            (@PathVariable("projectId") String projectId, @SpringQueryMap TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setProjectId(projectId);
        TestPlan rt = testPlanService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * test_plan_report_survey 测试计划
    * 
    *
    * @param projectId projectId
    * @param id id
    * @return Mono<ResponseEntity<TestPlanDTO>>
    */
    @ApiOperation(value = "test_plan_report_survey", tags = {"测试计划" },  notes = "TestPlan-test_plan_report_survey ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-test_plan_report_survey-all') or hasPermission('project',#projectId,this.testPlanService.get(#id),'ibizplm-TestPlan-test_plan_report_survey')")
    @GetMapping("projects/{projectId}/test_plans/{id}/test_plan_report_survey")
    public Mono<ResponseEntity<TestPlanDTO>> testPlanReportSurveyByProjectIdAndId
            (@PathVariable("projectId") String projectId, @PathVariable("id") String id) {
        TestPlan rt = testPlanService.testPlanReportSurvey(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_bi_detail 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"测试计划" },  notes = "TestPlan-fetch_bi_detail ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_bi_detail-all') or hasPermission('project',#projectId,#dto,'ibizplm-TestPlan-fetch_bi_detail')")
    @PostMapping("projects/{projectId}/test_plans/fetch_bi_detail")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchBiDetailByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchBiDetail(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"测试计划" },  notes = "TestPlan-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_bi_search-all') or hasPermission('project',#projectId,#dto,'ibizplm-TestPlan-fetch_bi_search')")
    @PostMapping("projects/{projectId}/test_plans/fetch_bi_search")
    public Mono<ResponseEntity<List<TestPlanBiSearchGroupDTO>>> fetchBiSearchByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchBiSearch(context) ;
        List<TestPlanBiSearchGroupDTO> list = testPlanBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_cur_project 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_project", tags = {"测试计划" },  notes = "TestPlan-fetch_cur_project ")
    @PostMapping("projects/{projectId}/test_plans/fetch_cur_project")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchCurProjectByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchCurProject(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"测试计划" },  notes = "TestPlan-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_default-all') or hasPermission('project',#projectId,#dto,'ibizplm-TestPlan-fetch_default')")
    @PostMapping("projects/{projectId}/test_plans/fetch_default")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchDefaultByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchDefault(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"测试计划" },  notes = "TestPlan-fetch_my_assignee ")
    @PostMapping("projects/{projectId}/test_plans/fetch_my_assignee")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyAssigneeByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyAssignee(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_in_progress 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_my_in_progress ")
    @PostMapping("projects/{projectId}/test_plans/fetch_my_in_progress")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyInProgressByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_participate 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_participate", tags = {"测试计划" },  notes = "TestPlan-fetch_my_participate ")
    @PostMapping("projects/{projectId}/test_plans/fetch_my_participate")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchMyParticipateByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchMyParticipate(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_pending_and_in_progress 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_pending_and_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_pending_and_in_progress ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_pending_and_in_progress-all') or hasPermission('project',#projectId,#dto,'ibizplm-TestPlan-fetch_pending_and_in_progress')")
    @PostMapping("projects/{projectId}/test_plans/fetch_pending_and_in_progress")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchPendingAndInProgressByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchPendingAndInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_query_no_shift_in 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_query_no_shift_in", tags = {"测试计划" },  notes = "TestPlan-fetch_query_no_shift_in ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_query_no_shift_in-all') or hasPermission('project',#projectId,#dto,'ibizplm-TestPlan-fetch_query_no_shift_in')")
    @PostMapping("projects/{projectId}/test_plans/fetch_query_no_shift_in")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchQueryNoShiftInByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchQueryNoShiftIn(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_un_join_plan 测试计划
    * 
    *
    * @param projectId projectId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_un_join_plan", tags = {"测试计划" },  notes = "TestPlan-fetch_un_join_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_un_join_plan-all') or hasPermission('project',#projectId,#dto,'ibizplm-TestPlan-fetch_un_join_plan')")
    @PostMapping("projects/{projectId}/test_plans/fetch_un_join_plan")
    public Mono<ResponseEntity<List<TestPlanDTO>>> fetchUnJoinPlanByProjectId
            (@PathVariable("projectId") String projectId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setProjectIdEQ(projectId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.fetchUnJoinPlan(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建测试计划
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Create-all')")
    @ApiOperation(value = "批量新建测试计划", tags = {"测试计划" },  notes = "批量新建测试计划")
	@PostMapping("test_plans/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<TestPlanDTO> dtos) {
        testPlanService.create(testPlanDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除测试计划
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Remove-all')")
    @ApiOperation(value = "批量删除测试计划", tags = {"测试计划" },  notes = "批量删除测试计划")
	@DeleteMapping("test_plans/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        testPlanService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新测试计划
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Update-all')")
    @ApiOperation(value = "批量更新测试计划", tags = {"测试计划" },  notes = "批量更新测试计划")
	@PutMapping("test_plans/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<TestPlanDTO> dtos) {
        testPlanService.update(testPlanDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存测试计划
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Save-all')")
    @ApiOperation(value = "批量保存测试计划", tags = {"测试计划" },  notes = "批量保存测试计划")
	@PostMapping("test_plans/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<TestPlanDTO> dtos) {
        testPlanService.save(testPlanDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入测试计划
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Save-all')")
    @ApiOperation(value = "批量导入测试计划", tags = {"测试计划" },  notes = "批量导入测试计划")
	@PostMapping("test_plans/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TestPlanDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(testPlanService.importData(config,ignoreError,testPlanDtoMapping.toDomain(dtos))));
    }

}
