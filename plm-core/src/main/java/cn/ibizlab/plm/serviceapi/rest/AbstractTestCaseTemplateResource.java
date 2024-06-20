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
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseTemplateService;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseTemplateSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[TestCaseTemplate] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTestCaseTemplateResource {

    @Autowired
    public TestCaseTemplateService testCaseTemplateService;

    @Autowired
    @Lazy
    public TestCaseTemplateDTOMapping testCaseTemplateDtoMapping;

    @Autowired
    @Lazy
    public TestCaseTemplateFilterDTOMapping testCaseTemplateFilterDtoMapping;

    /**
    * 创建Create 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseTemplateDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"用例模板" },  notes = "TestCaseTemplate-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCaseTemplate-Create-all') or hasPermission('library',#testLibraryId,this.testCaseTemplateDtoMapping.toDomain(#dto),'ibizplm-TestCaseTemplate-Create')")
    @PostMapping("libraries/{testLibraryId}/test_case_templates")
    public ResponseEntity<ResponseWrapper<TestCaseTemplateDTO>> createByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody RequestWrapper<TestCaseTemplateDTO> dto) {
        ResponseWrapper<TestCaseTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByTestLibraryId(testLibraryId, item)));
        else
            rt.set(createByTestLibraryId(testLibraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseTemplateDTO>
    */   
    public TestCaseTemplateDTO createByTestLibraryId
            (String testLibraryId, TestCaseTemplateDTO dto) {
        TestCaseTemplate domain = testCaseTemplateDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        testCaseTemplateService.create(domain);
        TestCaseTemplate rt = domain;
        return testCaseTemplateDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseTemplateDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"用例模板" },  notes = "TestCaseTemplate-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCaseTemplate-Update-all') or hasPermission('library',#testLibraryId,this.testCaseTemplateService.get(#id),'ibizplm-TestCaseTemplate-Update')")
    @VersionCheck(entity = "testcasetemplate" , versionfield = "updateTime")
    @PutMapping("libraries/{testLibraryId}/test_case_templates/{id}")
    public ResponseEntity<ResponseWrapper<TestCaseTemplateDTO>> updateByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<TestCaseTemplateDTO> dto) {
        ResponseWrapper<TestCaseTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByTestLibraryIdAndId(testLibraryId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByTestLibraryIdAndId(testLibraryId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<TestCaseTemplateDTO>
    */   
    public TestCaseTemplateDTO updateByTestLibraryIdAndId
            (String testLibraryId, String id, TestCaseTemplateDTO dto) {
        TestCaseTemplate domain = testCaseTemplateDtoMapping.toDomain(dto);
        domain.setId(id);
        testCaseTemplateService.update(domain);
        TestCaseTemplate rt = domain;
        return testCaseTemplateDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseTemplateDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"用例模板" },  notes = "TestCaseTemplate-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCaseTemplate-Save-all') or hasPermission('library',#testLibraryId,this.testCaseTemplateDtoMapping.toDomain(#dto),'ibizplm-TestCaseTemplate-Save')")
    @PostMapping("libraries/{testLibraryId}/test_case_templates/save")
    public ResponseEntity<ResponseWrapper<TestCaseTemplateDTO>> saveByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody RequestWrapper<TestCaseTemplateDTO> dto) {
        ResponseWrapper<TestCaseTemplateDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByTestLibraryId(testLibraryId, item)));
        else
            rt.set(saveByTestLibraryId(testLibraryId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseTemplateDTO>
    */   
    public TestCaseTemplateDTO saveByTestLibraryId
            (String testLibraryId, TestCaseTemplateDTO dto) {
        TestCaseTemplate domain = testCaseTemplateDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        testCaseTemplateService.save(domain);
        TestCaseTemplate rt = domain;
        return testCaseTemplateDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return ResponseEntity<TestCaseTemplateDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"用例模板" },  notes = "TestCaseTemplate-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCaseTemplate-Get-all')  or hasPermission('library',#testLibraryId,this.testCaseTemplateDtoMapping.toDomain(returnObject.body),'ibizplm-TestCaseTemplate-Get')")
    @GetMapping("libraries/{testLibraryId}/test_case_templates/{id}")
    public ResponseEntity<TestCaseTemplateDTO> getByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        TestCaseTemplate rt = testCaseTemplateService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseTemplateDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"用例模板" },  notes = "TestCaseTemplate-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCaseTemplate-Remove-all') or hasPermission('library',#testLibraryId,this.testCaseTemplateService.get(#id),'ibizplm-TestCaseTemplate-Remove')")
    @DeleteMapping("libraries/{testLibraryId}/test_case_templates/{id}")
    public ResponseEntity<Boolean> removeByTestLibraryIdAndId
            (@PathVariable("testLibraryId") String testLibraryId, @PathVariable("id") String id) {
        Boolean rt = testCaseTemplateService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"用例模板" },  notes = "TestCaseTemplate-CheckKey ")
    @PostMapping("libraries/{testLibraryId}/test_case_templates/check_key")
    public ResponseEntity<Integer> checkKeyByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseTemplateDTO dto) {
        TestCaseTemplate domain = testCaseTemplateDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        Integer rt = testCaseTemplateService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<TestCaseTemplateDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"用例模板" },  notes = "TestCaseTemplate-GetDraft ")
    @GetMapping("libraries/{testLibraryId}/test_case_templates/get_draft")
    public ResponseEntity<TestCaseTemplateDTO> getDraftByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @SpringQueryMap TestCaseTemplateDTO dto) {
        TestCaseTemplate domain = testCaseTemplateDtoMapping.toDomain(dto);
        domain.setTestLibraryId(testLibraryId);
        TestCaseTemplate rt = testCaseTemplateService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseTemplateDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 用例模板
    * 
    *
    * @param testLibraryId testLibraryId
    * @param dto dto
    * @return ResponseEntity<List<TestCaseTemplateDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"用例模板" },  notes = "TestCaseTemplate-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-TestCaseTemplate-fetch_default-all') or hasPermission('library',#testLibraryId,#dto,'ibizplm-TestCaseTemplate-fetch_default')")
    @PostMapping("libraries/{testLibraryId}/test_case_templates/fetch_default")
    public ResponseEntity<List<TestCaseTemplateDTO>> fetchDefaultByTestLibraryId
            (@PathVariable("testLibraryId") String testLibraryId, @Validated @RequestBody TestCaseTemplateFilterDTO dto) {
        dto.setTestLibraryIdEQ(testLibraryId);
        TestCaseTemplateSearchContext context = testCaseTemplateFilterDtoMapping.toDomain(dto);
        Page<TestCaseTemplate> domains = testCaseTemplateService.fetchDefault(context) ;
        List<TestCaseTemplateDTO> list = testCaseTemplateDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


}
