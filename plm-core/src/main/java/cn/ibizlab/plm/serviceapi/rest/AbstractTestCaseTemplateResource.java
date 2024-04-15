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



}
