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
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.testmgmt.filter.TestPlanSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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
    public TestPlanDTOMapping testPlanDtoMapping;

    @Autowired
    @Lazy
    public TestPlanFilterDTOMapping testPlanFilterDtoMapping;

    /**
    * 创建Create 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"测试计划" },  notes = "TestPlan-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Create-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Create')")
    @PostMapping("test_plans")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> create
            (@Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"测试计划" },  notes = "TestPlan-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Update-all') or hasPermission(this.testPlanService.get(#id),'ibizplm-TestPlan-Update')")
    @VersionCheck(entity = "testplan" , versionfield = "updateTime")
    @PutMapping("test_plans/{id}")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * end_test_plan 测试计划
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "end_test_plan", tags = {"测试计划" },  notes = "TestPlan-end_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-end_test_plan-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-end_test_plan')")
    @PostMapping("test_plans/{id}/end_test_plan")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> endTestPlanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endTestPlanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endTestPlanById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"测试计划" },  notes = "TestPlan-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Save-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Save')")
    @PostMapping("test_plans/save")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> save
            (@Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "start_test_plan", tags = {"测试计划" },  notes = "TestPlan-start_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-start_test_plan-all') or hasPermission(this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-start_test_plan')")
    @PostMapping("test_plans/{id}/start_test_plan")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> startTestPlanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startTestPlanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startTestPlanById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"测试计划" },  notes = "TestPlan-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Create-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Create')")
    @PostMapping("libraries/{libraryId}/test_plans")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> createByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryId(libraryId, item)));
        else
            rt.set(createByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"测试计划" },  notes = "TestPlan-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Update-all') or hasPermission('library',#libraryId,this.testPlanService.get(#id),'ibizplm-TestPlan-Update')")
    @VersionCheck(entity = "testplan" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/test_plans/{id}")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> updateByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndId(libraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * end_test_plan 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "end_test_plan", tags = {"测试计划" },  notes = "TestPlan-end_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-end_test_plan-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-end_test_plan')")
    @PostMapping("libraries/{libraryId}/test_plans/{id}/end_test_plan")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> endTestPlanByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(endTestPlanByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(endTestPlanByLibraryIdAndId(libraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"测试计划" },  notes = "TestPlan-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Save-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-Save')")
    @PostMapping("libraries/{libraryId}/test_plans/save")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> saveByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryId(libraryId, item)));
        else
            rt.set(saveByLibraryId(libraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "start_test_plan", tags = {"测试计划" },  notes = "TestPlan-start_test_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-start_test_plan-all') or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(#dto),'ibizplm-TestPlan-start_test_plan')")
    @PostMapping("libraries/{libraryId}/test_plans/{id}/start_test_plan")
    public ResponseEntity<ResponseWrapper<TestPlanDTO>> startTestPlanByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestPlanDTO> dto) {
        ResponseWrapper<TestPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(startTestPlanByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(startTestPlanByLibraryIdAndId(libraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 获取Get 测试计划
    * 
    *
    * @param id id
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"测试计划" },  notes = "TestPlan-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Get-all')  or hasPermission(this.testPlanDtoMapping.toDomain(returnObject.body),'ibizplm-TestPlan-Get')")
    @GetMapping("test_plans/{id}")
    public ResponseEntity<TestPlanDTO> getById
            (@PathVariable("id") String id) {
        TestPlan rt = testPlanService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 测试计划
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试计划" },  notes = "TestPlan-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Remove-all') or hasPermission(this.testPlanService.get(#id),'ibizplm-TestPlan-Remove')")
    @DeleteMapping("test_plans/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = testPlanService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试计划" },  notes = "TestPlan-CheckKey ")
    @PostMapping("test_plans/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        Integer rt = testPlanService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试计划" },  notes = "TestPlan-GetDraft ")
    @GetMapping("test_plans/get_draft")
    public ResponseEntity<TestPlanDTO> getDraft
            (@SpringQueryMap TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        TestPlan rt = testPlanService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"测试计划" },  notes = "TestPlan-fetch_default ")
    @PostMapping("test_plans/fetch_default")
    public ResponseEntity<List<TestPlanDTO>> fetchDefault
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchDefault(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_assignee 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"测试计划" },  notes = "TestPlan-fetch_my_assignee ")
    @PostMapping("test_plans/fetch_my_assignee")
    public ResponseEntity<List<TestPlanDTO>> fetchMyAssignee
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchMyAssignee(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_in_progress 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_my_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_my_in_progress ")
    @PostMapping("test_plans/fetch_my_in_progress")
    public ResponseEntity<List<TestPlanDTO>> fetchMyInProgress
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchMyInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_participate 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_my_participate", tags = {"测试计划" },  notes = "TestPlan-fetch_my_participate ")
    @PostMapping("test_plans/fetch_my_participate")
    public ResponseEntity<List<TestPlanDTO>> fetchMyParticipate
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchMyParticipate(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_pending_and_in_progress 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_pending_and_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_pending_and_in_progress ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_pending_and_in_progress-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_pending_and_in_progress')")
    @PostMapping("test_plans/fetch_pending_and_in_progress")
    public ResponseEntity<List<TestPlanDTO>> fetchPendingAndInProgress
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchPendingAndInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_query_no_shift_in 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_query_no_shift_in", tags = {"测试计划" },  notes = "TestPlan-fetch_query_no_shift_in ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_query_no_shift_in-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_query_no_shift_in')")
    @PostMapping("test_plans/fetch_query_no_shift_in")
    public ResponseEntity<List<TestPlanDTO>> fetchQueryNoShiftIn
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchQueryNoShiftIn(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_un_join_plan 测试计划
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_un_join_plan", tags = {"测试计划" },  notes = "TestPlan-fetch_un_join_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_un_join_plan-all') or hasPermission(#dto,'ibizplm-TestPlan-fetch_un_join_plan')")
    @PostMapping("test_plans/fetch_un_join_plan")
    public ResponseEntity<List<TestPlanDTO>> fetchUnJoinPlan
            (@Validated @RequestBody TestPlanFilterDTO dto) {
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchUnJoinPlan(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"测试计划" },  notes = "TestPlan-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Get-all')  or hasPermission('library',#libraryId,this.testPlanDtoMapping.toDomain(returnObject.body),'ibizplm-TestPlan-Get')")
    @GetMapping("libraries/{libraryId}/test_plans/{id}")
    public ResponseEntity<TestPlanDTO> getByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        TestPlan rt = testPlanService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"测试计划" },  notes = "TestPlan-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-Remove-all') or hasPermission('library',#libraryId,this.testPlanService.get(#id),'ibizplm-TestPlan-Remove')")
    @DeleteMapping("libraries/{libraryId}/test_plans/{id}")
    public ResponseEntity<Boolean> removeByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Boolean rt = testPlanService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"测试计划" },  notes = "TestPlan-CheckKey ")
    @PostMapping("libraries/{libraryId}/test_plans/check_key")
    public ResponseEntity<Integer> checkKeyByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        Integer rt = testPlanService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<TestPlanDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"测试计划" },  notes = "TestPlan-GetDraft ")
    @GetMapping("libraries/{libraryId}/test_plans/get_draft")
    public ResponseEntity<TestPlanDTO> getDraftByLibraryId
            (@PathVariable("libraryId") String libraryId, @SpringQueryMap TestPlanDTO dto) {
        TestPlan domain = testPlanDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        TestPlan rt = testPlanService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(testPlanDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"测试计划" },  notes = "TestPlan-fetch_default ")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_default")
    public ResponseEntity<List<TestPlanDTO>> fetchDefaultByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchDefault(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_assignee 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_my_assignee", tags = {"测试计划" },  notes = "TestPlan-fetch_my_assignee ")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_my_assignee")
    public ResponseEntity<List<TestPlanDTO>> fetchMyAssigneeByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchMyAssignee(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_in_progress 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_my_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_my_in_progress ")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_my_in_progress")
    public ResponseEntity<List<TestPlanDTO>> fetchMyInProgressByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchMyInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_participate 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_my_participate", tags = {"测试计划" },  notes = "TestPlan-fetch_my_participate ")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_my_participate")
    public ResponseEntity<List<TestPlanDTO>> fetchMyParticipateByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchMyParticipate(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_pending_and_in_progress 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_pending_and_in_progress", tags = {"测试计划" },  notes = "TestPlan-fetch_pending_and_in_progress ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_pending_and_in_progress-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_pending_and_in_progress')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_pending_and_in_progress")
    public ResponseEntity<List<TestPlanDTO>> fetchPendingAndInProgressByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchPendingAndInProgress(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_query_no_shift_in 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_query_no_shift_in", tags = {"测试计划" },  notes = "TestPlan-fetch_query_no_shift_in ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_query_no_shift_in-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_query_no_shift_in')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_query_no_shift_in")
    public ResponseEntity<List<TestPlanDTO>> fetchQueryNoShiftInByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchQueryNoShiftIn(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_un_join_plan 测试计划
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<List<TestPlanDTO>>
    */
    @ApiOperation(value = "查询fetch_un_join_plan", tags = {"测试计划" },  notes = "TestPlan-fetch_un_join_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestPlan-fetch_un_join_plan-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestPlan-fetch_un_join_plan')")
    @PostMapping("libraries/{libraryId}/test_plans/fetch_un_join_plan")
    public ResponseEntity<List<TestPlanDTO>> fetchUnJoinPlanByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestPlanFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestPlanSearchContext context = testPlanFilterDtoMapping.toDomain(dto);
        Page<TestPlan> domains = testPlanService.searchUnJoinPlan(context) ;
        List<TestPlanDTO> list = testPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建测试计划
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Create-all')")
    @ApiOperation(value = "批量新建测试计划", tags = {"测试计划" },  notes = "批量新建测试计划")
	@PostMapping("test_plans/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TestPlanDTO> dtos) {
        testPlanService.createBatch(testPlanDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除测试计划
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Remove-all')")
    @ApiOperation(value = "批量删除测试计划", tags = {"测试计划" },  notes = "批量删除测试计划")
	@DeleteMapping("test_plans/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        testPlanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新测试计划
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Update-all')")
    @ApiOperation(value = "批量更新测试计划", tags = {"测试计划" },  notes = "批量更新测试计划")
	@PutMapping("test_plans/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TestPlanDTO> dtos) {
        testPlanService.updateBatch(testPlanDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存测试计划
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Save-all')")
    @ApiOperation(value = "批量保存测试计划", tags = {"测试计划" },  notes = "批量保存测试计划")
	@PostMapping("test_plans/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TestPlanDTO> dtos) {
        testPlanService.saveBatch(testPlanDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入测试计划
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestPlan-Save-all')")
    @ApiOperation(value = "批量导入测试计划", tags = {"测试计划" },  notes = "批量导入测试计划")
	@PostMapping("test_plans/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TestPlanDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(testPlanService.importData(config,ignoreError,testPlanDtoMapping.toDomain(dtos)));
    }

}
