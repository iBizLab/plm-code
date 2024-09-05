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
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.service.TestSuiteService;
import cn.ibizlab.plm.core.testmgmt.filter.TestSuiteSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[TestSuite] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTestSuiteResource {

    @Autowired
    public TestSuiteService testSuiteService;

    @Autowired
    @Lazy
    public TestSuiteDTOMapping testSuiteDtoMapping;

    @Autowired
    @Lazy
    public TestSuiteFilterDTOMapping testSuiteFilterDtoMapping;

    /**
    * 创建Create 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"用例模块" },  notes = "TestSuite-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Create-all') or hasPermission(this.testSuiteDtoMapping.toDomain(#dto),'ibizplm-TestSuite-Create')")
    @PostMapping("test_suites")
    public Mono<ResponseEntity<ResponseWrapper<TestSuiteDTO>>>create
            (@Validated @RequestBody RequestWrapper<TestSuiteDTO> dto) {
        ResponseWrapper<TestSuiteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 用例模块
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestSuiteDTO>
    */   
    public TestSuiteDTO create
            (TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        testSuiteService.create(domain);
        TestSuite rt = domain;
        return testSuiteDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 用例模块
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"用例模块" },  notes = "TestSuite-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Update-all') or hasPermission(this.testSuiteService.get(#id),'ibizplm-TestSuite-Update')")
    @VersionCheck(entity = "testsuite" , versionfield = "updateTime")
    @PutMapping("test_suites/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TestSuiteDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestSuiteDTO> dto) {
        ResponseWrapper<TestSuiteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 用例模块
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestSuiteDTO>
    */   
    public TestSuiteDTO updateById
            (String id, TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        domain.setId(id);
        testSuiteService.update(domain);
        TestSuite rt = domain;
        return testSuiteDtoMapping.toDto(rt);
    }

    /**
    * move_order 用例模块
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"用例模块" },  notes = "TestSuite-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-move_order-all') or hasPermission(this.testSuiteDtoMapping.toDomain(#dto),'ibizplm-TestSuite-move_order')")
    @PostMapping("test_suites/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<TestSuiteDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestSuiteDTO> dto) {
        ResponseWrapper<List<TestSuiteDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 用例模块
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<TestSuiteDTO>>
    */   
    public List<TestSuiteDTO> moveOrderById
            (String id, TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        domain.setId(id);
        List<TestSuite> rt = testSuiteService.moveOrder(domain);
        return testSuiteDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"用例模块" },  notes = "TestSuite-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Save-all') or hasPermission(this.testSuiteDtoMapping.toDomain(#dto),'ibizplm-TestSuite-Save')")
    @PostMapping("test_suites/save")
    public Mono<ResponseEntity<ResponseWrapper<TestSuiteDTO>>>save
            (@Validated @RequestBody RequestWrapper<TestSuiteDTO> dto) {
        ResponseWrapper<TestSuiteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 用例模块
    * 
    *
    * @param dto dto
    * @return ResponseEntity<TestSuiteDTO>
    */   
    public TestSuiteDTO save
            (TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        testSuiteService.save(domain);
        TestSuite rt = domain;
        return testSuiteDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"用例模块" },  notes = "TestSuite-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Create-all') or hasPermission('library',#libraryId,this.testSuiteDtoMapping.toDomain(#dto),'ibizplm-TestSuite-Create')")
    @PostMapping("libraries/{libraryId}/test_suites")
    public Mono<ResponseEntity<ResponseWrapper<TestSuiteDTO>>>createByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<TestSuiteDTO> dto) {
        ResponseWrapper<TestSuiteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByLibraryId(libraryId, item)));
        else
            rt.set(createByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<TestSuiteDTO>
    */   
    public TestSuiteDTO createByLibraryId
            (String libraryId, TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        testSuiteService.create(domain);
        TestSuite rt = domain;
        return testSuiteDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"用例模块" },  notes = "TestSuite-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Update-all') or hasPermission('library',#libraryId,this.testSuiteService.get(#id),'ibizplm-TestSuite-Update')")
    @VersionCheck(entity = "testsuite" , versionfield = "updateTime")
    @PutMapping("libraries/{libraryId}/test_suites/{id}")
    public Mono<ResponseEntity<ResponseWrapper<TestSuiteDTO>>>updateByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestSuiteDTO> dto) {
        ResponseWrapper<TestSuiteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestSuiteDTO>
    */   
    public TestSuiteDTO updateByLibraryIdAndId
            (String libraryId, String id, TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        domain.setId(id);
        testSuiteService.update(domain);
        TestSuite rt = domain;
        return testSuiteDtoMapping.toDto(rt);
    }

    /**
    * move_order 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"用例模块" },  notes = "TestSuite-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-move_order-all') or hasPermission('library',#libraryId,this.testSuiteDtoMapping.toDomain(#dto),'ibizplm-TestSuite-move_order')")
    @PostMapping("libraries/{libraryId}/test_suites/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<TestSuiteDTO>>>>moveOrderByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestSuiteDTO> dto) {
        ResponseWrapper<List<TestSuiteDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderByLibraryIdAndId(libraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderByLibraryIdAndId(libraryId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<TestSuiteDTO>>
    */   
    public List<TestSuiteDTO> moveOrderByLibraryIdAndId
            (String libraryId, String id, TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        domain.setId(id);
        List<TestSuite> rt = testSuiteService.moveOrder(domain);
        return testSuiteDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"用例模块" },  notes = "TestSuite-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Save-all') or hasPermission('library',#libraryId,this.testSuiteDtoMapping.toDomain(#dto),'ibizplm-TestSuite-Save')")
    @PostMapping("libraries/{libraryId}/test_suites/save")
    public Mono<ResponseEntity<ResponseWrapper<TestSuiteDTO>>>saveByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody RequestWrapper<TestSuiteDTO> dto) {
        ResponseWrapper<TestSuiteDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByLibraryId(libraryId, item)));
        else
            rt.set(saveByLibraryId(libraryId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return ResponseEntity<TestSuiteDTO>
    */   
    public TestSuiteDTO saveByLibraryId
            (String libraryId, TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        testSuiteService.save(domain);
        TestSuite rt = domain;
        return testSuiteDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 用例模块
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"用例模块" },  notes = "TestSuite-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Get-all')  or hasPermission(this.testSuiteDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-TestSuite-Get')")
    @GetMapping("test_suites/{id}")
    public Mono<ResponseEntity<TestSuiteDTO>> getById
            (@PathVariable("id") String id) {
        TestSuite rt = testSuiteService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testSuiteDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 用例模块
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"用例模块" },  notes = "TestSuite-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Remove-all') or hasPermission(this.testSuiteService.get(#id),'ibizplm-TestSuite-Remove')")
    @DeleteMapping("test_suites/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = testSuiteService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"用例模块" },  notes = "TestSuite-CheckKey ")
    @PostMapping("test_suites/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        CheckKeyStatus rt = testSuiteService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"用例模块" },  notes = "TestSuite-GetDraft ")
    @GetMapping("test_suites/get_draft")
    public Mono<ResponseEntity<TestSuiteDTO>> getDraft
            (@SpringQueryMap TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        TestSuite rt = testSuiteService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testSuiteDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_test_suite 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_test_suite", tags = {"用例模块" },  notes = "TestSuite-fetch_cur_test_suite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_cur_test_suite-all') or hasPermission(#dto,'ibizplm-TestSuite-fetch_cur_test_suite')")
    @PostMapping("test_suites/fetch_cur_test_suite")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchCurTestSuite
            (@Validated @RequestBody TestSuiteFilterDTO dto) {
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchCurTestSuite(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"用例模块" },  notes = "TestSuite-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_default-all') or hasPermission(#dto,'ibizplm-TestSuite-fetch_default')")
    @PostMapping("test_suites/fetch_default")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchDefault
            (@Validated @RequestBody TestSuiteFilterDTO dto) {
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchDefault(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_parent 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_parent", tags = {"用例模块" },  notes = "TestSuite-fetch_no_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_no_parent-all') or hasPermission(#dto,'ibizplm-TestSuite-fetch_no_parent')")
    @PostMapping("test_suites/fetch_no_parent")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchNoParent
            (@Validated @RequestBody TestSuiteFilterDTO dto) {
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchNoParent(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"用例模块" },  notes = "TestSuite-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_normal-all') or hasPermission(#dto,'ibizplm-TestSuite-fetch_normal')")
    @PostMapping("test_suites/fetch_normal")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchNormal
            (@Validated @RequestBody TestSuiteFilterDTO dto) {
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchNormal(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_root 用例模块
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_root", tags = {"用例模块" },  notes = "TestSuite-fetch_root ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_root-all') or hasPermission(#dto,'ibizplm-TestSuite-fetch_root')")
    @PostMapping("test_suites/fetch_root")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchRoot
            (@Validated @RequestBody TestSuiteFilterDTO dto) {
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchRoot(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"用例模块" },  notes = "TestSuite-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Get-all')  or hasPermission('library',#libraryId,this.testSuiteDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-TestSuite-Get')")
    @GetMapping("libraries/{libraryId}/test_suites/{id}")
    public Mono<ResponseEntity<TestSuiteDTO>> getByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        TestSuite rt = testSuiteService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testSuiteDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"用例模块" },  notes = "TestSuite-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-Remove-all') or hasPermission('library',#libraryId,this.testSuiteService.get(#id),'ibizplm-TestSuite-Remove')")
    @DeleteMapping("libraries/{libraryId}/test_suites/{id}")
    public Mono<ResponseEntity<Boolean>> removeByLibraryIdAndId
            (@PathVariable("libraryId") String libraryId, @PathVariable("id") String id) {
        Boolean rt = testSuiteService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"用例模块" },  notes = "TestSuite-CheckKey ")
    @PostMapping("libraries/{libraryId}/test_suites/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        CheckKeyStatus rt = testSuiteService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<TestSuiteDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"用例模块" },  notes = "TestSuite-GetDraft ")
    @GetMapping("libraries/{libraryId}/test_suites/get_draft")
    public Mono<ResponseEntity<TestSuiteDTO>> getDraftByLibraryId
            (@PathVariable("libraryId") String libraryId, @SpringQueryMap TestSuiteDTO dto) {
        TestSuite domain = testSuiteDtoMapping.toDomain(dto);
        domain.setLibraryId(libraryId);
        TestSuite rt = testSuiteService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(testSuiteDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_test_suite 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_test_suite", tags = {"用例模块" },  notes = "TestSuite-fetch_cur_test_suite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_cur_test_suite-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestSuite-fetch_cur_test_suite')")
    @PostMapping("libraries/{libraryId}/test_suites/fetch_cur_test_suite")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchCurTestSuiteByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestSuiteFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchCurTestSuite(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"用例模块" },  notes = "TestSuite-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_default-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestSuite-fetch_default')")
    @PostMapping("libraries/{libraryId}/test_suites/fetch_default")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchDefaultByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestSuiteFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchDefault(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_parent 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_parent", tags = {"用例模块" },  notes = "TestSuite-fetch_no_parent ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_no_parent-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestSuite-fetch_no_parent')")
    @PostMapping("libraries/{libraryId}/test_suites/fetch_no_parent")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchNoParentByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestSuiteFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchNoParent(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"用例模块" },  notes = "TestSuite-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_normal-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestSuite-fetch_normal')")
    @PostMapping("libraries/{libraryId}/test_suites/fetch_normal")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchNormalByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestSuiteFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchNormal(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_root 用例模块
    * 
    *
    * @param libraryId libraryId
    * @param dto dto
    * @return Mono<ResponseEntity<List<TestSuiteDTO>>>
    */
    @ApiOperation(value = "查询fetch_root", tags = {"用例模块" },  notes = "TestSuite-fetch_root ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestSuite-fetch_root-all') or hasPermission('library',#libraryId,#dto,'ibizplm-TestSuite-fetch_root')")
    @PostMapping("libraries/{libraryId}/test_suites/fetch_root")
    public Mono<ResponseEntity<List<TestSuiteDTO>>> fetchRootByLibraryId
            (@PathVariable("libraryId") String libraryId, @Validated @RequestBody TestSuiteFilterDTO dto) {
        dto.setLibraryIdEQ(libraryId);
        TestSuiteSearchContext context = testSuiteFilterDtoMapping.toDomain(dto);
        Page<TestSuite> domains = testSuiteService.fetchRoot(context) ;
        List<TestSuiteDTO> list = testSuiteDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建用例模块
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestSuite-Create-all')")
    @ApiOperation(value = "批量新建用例模块", tags = {"用例模块" },  notes = "批量新建用例模块")
	@PostMapping("test_suites/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<TestSuiteDTO> dtos) {
        testSuiteService.create(testSuiteDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除用例模块
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestSuite-Remove-all')")
    @ApiOperation(value = "批量删除用例模块", tags = {"用例模块" },  notes = "批量删除用例模块")
	@DeleteMapping("test_suites/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        testSuiteService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新用例模块
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestSuite-Update-all')")
    @ApiOperation(value = "批量更新用例模块", tags = {"用例模块" },  notes = "批量更新用例模块")
	@PutMapping("test_suites/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<TestSuiteDTO> dtos) {
        testSuiteService.update(testSuiteDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存用例模块
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestSuite-Save-all')")
    @ApiOperation(value = "批量保存用例模块", tags = {"用例模块" },  notes = "批量保存用例模块")
	@PostMapping("test_suites/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<TestSuiteDTO> dtos) {
        testSuiteService.save(testSuiteDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入用例模块
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-TestSuite-Save-all')")
    @ApiOperation(value = "批量导入用例模块", tags = {"用例模块" },  notes = "批量导入用例模块")
	@PostMapping("test_suites/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<TestSuiteDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(testSuiteService.importData(config,ignoreError,testSuiteDtoMapping.toDomain(dtos))));
    }

}
