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
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.base.filter.RelationSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Relation] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRelationResource {

    @Autowired
    public RelationService relationService;

    @Autowired
    @Lazy
    public RelationDTOMapping relationDtoMapping;

    @Autowired
    @Lazy
    public RelationFilterDTOMapping relationFilterDtoMapping;

    /**
    * 创建Create 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"关联" },  notes = "Relation-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Create-all') or hasPermission(this.relationDtoMapping.toDomain(#dto),'ibizplm-Relation-Create')")
    @PostMapping("relations")
    public ResponseEntity<ResponseWrapper<RelationDTO>> create
            (@Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO create
            (RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        relationService.create(domain);
        Relation rt = domain;
        return relationDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"关联" },  notes = "Relation-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Update-all') or hasPermission(this.relationService.get(#id),'ibizplm-Relation-Update')")
    @VersionCheck(entity = "relation" , versionfield = "updateTime")
    @PutMapping("relations/{id}")
    public ResponseEntity<ResponseWrapper<RelationDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO updateById
            (String id, RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        domain.setId(id);
        relationService.update(domain);
        Relation rt = domain;
        return relationDtoMapping.toDto(rt);
    }

    /**
    * del_relation 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "del_relation", tags = {"关联" },  notes = "Relation-del_relation ")
    @PostMapping("relations/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<RelationDTO>> delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * del_relation 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO delRelationById
            (String id, RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        domain.setId(id);
        Relation rt = relationService.delRelation(domain);
        return relationDtoMapping.toDto(rt);
    }

    /**
    * program_test_case 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "program_test_case", tags = {"关联" },  notes = "Relation-program_test_case ")
    @PostMapping("relations/{id}/program_test_case")
    public ResponseEntity<ResponseWrapper<RelationDTO>> programTestCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(programTestCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(programTestCaseById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * program_test_case 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO programTestCaseById
            (String id, RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        domain.setId(id);
        Relation rt = relationService.programTestCase(domain);
        return relationDtoMapping.toDto(rt);
    }

    /**
    * run_del_relation_bug 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "run_del_relation_bug", tags = {"关联" },  notes = "Relation-run_del_relation_bug ")
    @PostMapping("relations/{id}/run_del_relation_bug")
    public ResponseEntity<ResponseWrapper<RelationDTO>> runDelRelationBugById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(runDelRelationBugById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(runDelRelationBugById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * run_del_relation_bug 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO runDelRelationBugById
            (String id, RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        domain.setId(id);
        Relation rt = relationService.runDelRelationBug(domain);
        return relationDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"关联" },  notes = "Relation-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Save-all') or hasPermission(this.relationDtoMapping.toDomain(#dto),'ibizplm-Relation-Save')")
    @PostMapping("relations/save")
    public ResponseEntity<ResponseWrapper<RelationDTO>> save
            (@Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO save
            (RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        relationService.save(domain);
        Relation rt = domain;
        return relationDtoMapping.toDto(rt);
    }

    /**
    * test_case_del_relation_bug 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "test_case_del_relation_bug", tags = {"关联" },  notes = "Relation-test_case_del_relation_bug ")
    @PostMapping("relations/{id}/test_case_del_relation_bug")
    public ResponseEntity<ResponseWrapper<RelationDTO>> testCaseDelRelationBugById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(testCaseDelRelationBugById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(testCaseDelRelationBugById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * test_case_del_relation_bug 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO testCaseDelRelationBugById
            (String id, RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        domain.setId(id);
        Relation rt = relationService.testCaseDelRelationBug(domain);
        return relationDtoMapping.toDto(rt);
    }

    /**
    * work_item_del_relation_case 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "work_item_del_relation_case", tags = {"关联" },  notes = "Relation-work_item_del_relation_case ")
    @PostMapping("relations/{id}/work_item_del_relation_case")
    public ResponseEntity<ResponseWrapper<RelationDTO>> workItemDelRelationCaseById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<RelationDTO> dto) {
        ResponseWrapper<RelationDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(workItemDelRelationCaseById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(workItemDelRelationCaseById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * work_item_del_relation_case 关联
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */   
    public RelationDTO workItemDelRelationCaseById
            (String id, RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        domain.setId(id);
        Relation rt = relationService.workItemDelRelationCase(domain);
        return relationDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 关联
    * 
    *
    * @param id id
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"关联" },  notes = "Relation-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Get-all')  or hasPermission(this.relationDtoMapping.toDomain(returnObject.body),'ibizplm-Relation-Get')")
    @GetMapping("relations/{id}")
    public ResponseEntity<RelationDTO> getById
            (@PathVariable("id") String id) {
        Relation rt = relationService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(relationDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 关联
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"关联" },  notes = "Relation-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-Remove-all') or hasPermission(this.relationService.get(#id),'ibizplm-Relation-Remove')")
    @DeleteMapping("relations/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = relationService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"关联" },  notes = "Relation-CheckKey ")
    @PostMapping("relations/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        Integer rt = relationService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<RelationDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"关联" },  notes = "Relation-GetDraft ")
    @GetMapping("relations/get_draft")
    public ResponseEntity<RelationDTO> getDraft
            (@SpringQueryMap RelationDTO dto) {
        Relation domain = relationDtoMapping.toDomain(dto);
        Relation rt = relationService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(relationDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_all 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_all", tags = {"关联" },  notes = "Relation-fetch_all ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_all-all') or hasPermission(#dto,'ibizplm-Relation-fetch_all')")
    @PostMapping("relations/fetch_all")
    public ResponseEntity<List<RelationDTO>> fetchAll
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchAll(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"关联" },  notes = "Relation-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_default-all') or hasPermission(#dto,'ibizplm-Relation-fetch_default')")
    @PostMapping("relations/fetch_default")
    public ResponseEntity<List<RelationDTO>> fetchDefault
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchDefault(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_exists_run_relation_bug 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_exists_run_relation_bug", tags = {"关联" },  notes = "Relation-fetch_exists_run_relation_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_exists_run_relation_bug-all') or hasPermission(#dto,'ibizplm-Relation-fetch_exists_run_relation_bug')")
    @PostMapping("relations/fetch_exists_run_relation_bug")
    public ResponseEntity<List<RelationDTO>> fetchExistsRunRelationBug
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchExistsRunRelationBug(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_idea_re_customer 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_re_customer", tags = {"关联" },  notes = "Relation-fetch_idea_re_customer ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_idea_re_customer-all') or hasPermission(#dto,'ibizplm-Relation-fetch_idea_re_customer')")
    @PostMapping("relations/fetch_idea_re_customer")
    public ResponseEntity<List<RelationDTO>> fetchIdeaReCustomer
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchIdeaReCustomer(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_idea_re_idea 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_re_idea", tags = {"关联" },  notes = "Relation-fetch_idea_re_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_idea_re_idea-all') or hasPermission(#dto,'ibizplm-Relation-fetch_idea_re_idea')")
    @PostMapping("relations/fetch_idea_re_idea")
    public ResponseEntity<List<RelationDTO>> fetchIdeaReIdea
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchIdeaReIdea(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_idea_re_test_case 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_re_test_case", tags = {"关联" },  notes = "Relation-fetch_idea_re_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_idea_re_test_case-all') or hasPermission(#dto,'ibizplm-Relation-fetch_idea_re_test_case')")
    @PostMapping("relations/fetch_idea_re_test_case")
    public ResponseEntity<List<RelationDTO>> fetchIdeaReTestCase
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchIdeaReTestCase(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_idea_re_ticket 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_re_ticket", tags = {"关联" },  notes = "Relation-fetch_idea_re_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_idea_re_ticket-all') or hasPermission(#dto,'ibizplm-Relation-fetch_idea_re_ticket')")
    @PostMapping("relations/fetch_idea_re_ticket")
    public ResponseEntity<List<RelationDTO>> fetchIdeaReTicket
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchIdeaReTicket(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_idea_re_work_item 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_re_work_item", tags = {"关联" },  notes = "Relation-fetch_idea_re_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_idea_re_work_item-all') or hasPermission(#dto,'ibizplm-Relation-fetch_idea_re_work_item')")
    @PostMapping("relations/fetch_idea_re_work_item")
    public ResponseEntity<List<RelationDTO>> fetchIdeaReWorkItem
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchIdeaReWorkItem(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_idea_version_relation 关联
    * 主实体版本创建时，查询关联principal_type为需求的数据存入version_data
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_idea_version_relation", tags = {"关联" },  notes = "Relation-fetch_idea_version_relation 主实体版本创建时，查询关联principal_type为需求的数据存入version_data")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_idea_version_relation-all') or hasPermission(#dto,'ibizplm-Relation-fetch_idea_version_relation')")
    @PostMapping("relations/fetch_idea_version_relation")
    public ResponseEntity<List<RelationDTO>> fetchIdeaVersionRelation
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchIdeaVersionRelation(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_review_re_test_case 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_review_re_test_case", tags = {"关联" },  notes = "Relation-fetch_review_re_test_case ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_review_re_test_case-all') or hasPermission(#dto,'ibizplm-Relation-fetch_review_re_test_case')")
    @PostMapping("relations/fetch_review_re_test_case")
    public ResponseEntity<List<RelationDTO>> fetchReviewReTestCase
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchReviewReTestCase(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_run_re_bug 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_run_re_bug", tags = {"关联" },  notes = "Relation-fetch_run_re_bug ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_run_re_bug-all') or hasPermission(#dto,'ibizplm-Relation-fetch_run_re_bug')")
    @PostMapping("relations/fetch_run_re_bug")
    public ResponseEntity<List<RelationDTO>> fetchRunReBug
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchRunReBug(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_run_re_idea 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_run_re_idea", tags = {"关联" },  notes = "Relation-fetch_run_re_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_run_re_idea-all') or hasPermission(#dto,'ibizplm-Relation-fetch_run_re_idea')")
    @PostMapping("relations/fetch_run_re_idea")
    public ResponseEntity<List<RelationDTO>> fetchRunReIdea
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchRunReIdea(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_run_re_work_item 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_run_re_work_item", tags = {"关联" },  notes = "Relation-fetch_run_re_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_run_re_work_item-all') or hasPermission(#dto,'ibizplm-Relation-fetch_run_re_work_item')")
    @PostMapping("relations/fetch_run_re_work_item")
    public ResponseEntity<List<RelationDTO>> fetchRunReWorkItem
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchRunReWorkItem(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_test_case_re_bug 关联
    * 仅关联缺陷类型工作项
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_test_case_re_bug", tags = {"关联" },  notes = "Relation-fetch_test_case_re_bug 仅关联缺陷类型工作项")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_test_case_re_bug-all') or hasPermission(#dto,'ibizplm-Relation-fetch_test_case_re_bug')")
    @PostMapping("relations/fetch_test_case_re_bug")
    public ResponseEntity<List<RelationDTO>> fetchTestCaseReBug
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchTestCaseReBug(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_test_case_re_idea 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_test_case_re_idea", tags = {"关联" },  notes = "Relation-fetch_test_case_re_idea ")
    @PostMapping("relations/fetch_test_case_re_idea")
    public ResponseEntity<List<RelationDTO>> fetchTestCaseReIdea
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchTestCaseReIdea(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_test_case_re_work_item 关联
    * 排除了缺陷类型的工作项
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_test_case_re_work_item", tags = {"关联" },  notes = "Relation-fetch_test_case_re_work_item 排除了缺陷类型的工作项")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_test_case_re_work_item-all') or hasPermission(#dto,'ibizplm-Relation-fetch_test_case_re_work_item')")
    @PostMapping("relations/fetch_test_case_re_work_item")
    public ResponseEntity<List<RelationDTO>> fetchTestCaseReWorkItem
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchTestCaseReWorkItem(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_test_case_version_relation 关联
    * 主实体版本创建时，查询关联principal_type为用例的数据存入version_data
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_test_case_version_relation", tags = {"关联" },  notes = "Relation-fetch_test_case_version_relation 主实体版本创建时，查询关联principal_type为用例的数据存入version_data")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_test_case_version_relation-all') or hasPermission(#dto,'ibizplm-Relation-fetch_test_case_version_relation')")
    @PostMapping("relations/fetch_test_case_version_relation")
    public ResponseEntity<List<RelationDTO>> fetchTestCaseVersionRelation
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchTestCaseVersionRelation(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_ticket_re_idea 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_re_idea", tags = {"关联" },  notes = "Relation-fetch_ticket_re_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_ticket_re_idea-all') or hasPermission(#dto,'ibizplm-Relation-fetch_ticket_re_idea')")
    @PostMapping("relations/fetch_ticket_re_idea")
    public ResponseEntity<List<RelationDTO>> fetchTicketReIdea
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchTicketReIdea(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_ticket_re_self 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_re_self", tags = {"关联" },  notes = "Relation-fetch_ticket_re_self ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_ticket_re_self-all') or hasPermission(#dto,'ibizplm-Relation-fetch_ticket_re_self')")
    @PostMapping("relations/fetch_ticket_re_self")
    public ResponseEntity<List<RelationDTO>> fetchTicketReSelf
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchTicketReSelf(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_ticket_re_work_item 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_ticket_re_work_item", tags = {"关联" },  notes = "Relation-fetch_ticket_re_work_item ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_ticket_re_work_item-all') or hasPermission(#dto,'ibizplm-Relation-fetch_ticket_re_work_item')")
    @PostMapping("relations/fetch_ticket_re_work_item")
    public ResponseEntity<List<RelationDTO>> fetchTicketReWorkItem
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchTicketReWorkItem(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_relation_idea 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_idea", tags = {"关联" },  notes = "Relation-fetch_work_item_relation_idea ")
    @PostMapping("relations/fetch_work_item_relation_idea")
    public ResponseEntity<List<RelationDTO>> fetchWorkItemRelationIdea
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchWorkItemRelationIdea(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_relation_self 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_self", tags = {"关联" },  notes = "Relation-fetch_work_item_relation_self ")
    @PostMapping("relations/fetch_work_item_relation_self")
    public ResponseEntity<List<RelationDTO>> fetchWorkItemRelationSelf
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchWorkItemRelationSelf(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_relation_test_case 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_test_case", tags = {"关联" },  notes = "Relation-fetch_work_item_relation_test_case ")
    @PostMapping("relations/fetch_work_item_relation_test_case")
    public ResponseEntity<List<RelationDTO>> fetchWorkItemRelationTestCase
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchWorkItemRelationTestCase(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_relation_ticket 关联
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_relation_ticket", tags = {"关联" },  notes = "Relation-fetch_work_item_relation_ticket ")
    @PostMapping("relations/fetch_work_item_relation_ticket")
    public ResponseEntity<List<RelationDTO>> fetchWorkItemRelationTicket
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchWorkItemRelationTicket(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_work_item_version_relation 关联
    * 主实体版本创建时，查询关联principal_type为工作项的数据存入version_data
    *
    * @param dto dto
    * @return ResponseEntity<List<RelationDTO>>
    */
    @ApiOperation(value = "查询fetch_work_item_version_relation", tags = {"关联" },  notes = "Relation-fetch_work_item_version_relation 主实体版本创建时，查询关联principal_type为工作项的数据存入version_data")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Relation-fetch_work_item_version_relation-all') or hasPermission(#dto,'ibizplm-Relation-fetch_work_item_version_relation')")
    @PostMapping("relations/fetch_work_item_version_relation")
    public ResponseEntity<List<RelationDTO>> fetchWorkItemVersionRelation
            (@Validated @RequestBody RelationFilterDTO dto) {
        RelationSearchContext context = relationFilterDtoMapping.toDomain(dto);
        Page<Relation> domains = relationService.fetchWorkItemVersionRelation(context) ;
        List<RelationDTO> list = relationDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建关联
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Create-all')")
    @ApiOperation(value = "批量新建关联", tags = {"关联" },  notes = "批量新建关联")
	@PostMapping("relations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<RelationDTO> dtos) {
        relationService.create(relationDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除关联
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Remove-all')")
    @ApiOperation(value = "批量删除关联", tags = {"关联" },  notes = "批量删除关联")
	@DeleteMapping("relations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        relationService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新关联
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Update-all')")
    @ApiOperation(value = "批量更新关联", tags = {"关联" },  notes = "批量更新关联")
	@PutMapping("relations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<RelationDTO> dtos) {
        relationService.update(relationDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存关联
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Save-all')")
    @ApiOperation(value = "批量保存关联", tags = {"关联" },  notes = "批量保存关联")
	@PostMapping("relations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<RelationDTO> dtos) {
        relationService.save(relationDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入关联
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Relation-Save-all')")
    @ApiOperation(value = "批量导入关联", tags = {"关联" },  notes = "批量导入关联")
	@PostMapping("relations/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<RelationDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(relationService.importData(config,ignoreError,relationDtoMapping.toDomain(dtos)));
    }

}
