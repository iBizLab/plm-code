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
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Idea] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractIdeaResource {

    @Autowired
    public IdeaService ideaService;

    @Autowired
    @Lazy
    public IdeaAdvancedSearchDTOMapping ideaAdvancedSearchDtoMapping;

    @Autowired
    @Lazy
    public IdeaAssigneeDTOMapping ideaAssigneeDtoMapping;

    @Autowired
    @Lazy
    public IdeaBiSearchGroupDTOMapping ideaBiSearchGroupDtoMapping;

    @Autowired
    @Lazy
    public IdeaDefGroupCommonDTOMapping ideaDefGroupCommonDtoMapping;

    @Autowired
    @Lazy
    public IdeaDTOMapping ideaDtoMapping;

    @Autowired
    @Lazy
    public IdeaFilterDTOMapping ideaFilterDtoMapping;

    /**
    * 创建Create 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"需求" },  notes = "Idea-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Create-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Create')")
    @PostMapping("ideas")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>create
            (@Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO create
            (IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        ideaService.create(domain);
        Idea rt = domain;
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"需求" },  notes = "Idea-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Update-all') or hasPermission(this.ideaService.get(#id),'ibizplm-Idea-Update')")
    @VersionCheck(entity = "idea" , versionfield = "updateTime")
    @PutMapping("ideas/{id}")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO updateById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        ideaService.update(domain);
        Idea rt = domain;
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * activate 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "activate", tags = {"需求" },  notes = "Idea-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-activate-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-activate')")
    @PostMapping("ideas/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * activate 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO activateById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.activate(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * archive 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "archive", tags = {"需求" },  notes = "Idea-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-archive-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-archive')")
    @PostMapping("ideas/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * archive 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO archiveById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.archive(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * change_state 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "change_state", tags = {"需求" },  notes = "Idea-change_state ")
    @PostMapping("ideas/{id}/change_state")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>changeStateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_state 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO changeStateById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.changeState(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * choose_case_template 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "choose_case_template", tags = {"需求" },  notes = "Idea-choose_case_template ")
    @PostMapping("ideas/choose_case_template")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>chooseCaseTemplate
            (@Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(chooseCaseTemplate(item)));
        else
            rt.set(chooseCaseTemplate(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_case_template 需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO chooseCaseTemplate
            (IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        Idea rt = ideaService.chooseCaseTemplate(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * delete 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "delete", tags = {"需求" },  notes = "Idea-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-delete-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-delete')")
    @PostMapping("ideas/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO deleteById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.delete(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * get_customer_score 需求
    * 获取客户分数数据
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDefGroupCommonDTO>>
    */
    @ApiOperation(value = "get_customer_score", tags = {"需求" },  notes = "Idea-get_customer_score 获取客户分数数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-get_customer_score-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-get_customer_score')")
    @PostMapping("ideas/{id}/get_customer_score")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDefGroupCommonDTO>>>getCustomerScoreById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDefGroupCommonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(getCustomerScoreById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(getCustomerScoreById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_customer_score 需求
    * 获取客户分数数据
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDefGroupCommonDTO>
    */   
    public IdeaDefGroupCommonDTO getCustomerScoreById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.getCustomerScore(domain);
        return ideaDefGroupCommonDtoMapping.toDto(rt);
    }

    /**
    * idea_category 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_category", tags = {"需求" },  notes = "Idea-idea_category ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-idea_category-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-idea_category')")
    @PostMapping("ideas/{id}/idea_category")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaCategoryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaCategoryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaCategoryById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_category 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaCategoryById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaCategory(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * idea_copy 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_copy", tags = {"需求" },  notes = "Idea-idea_copy ")
    @PostMapping("ideas/{id}/idea_copy")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaCopyById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaCopyById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaCopyById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_copy 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaCopyById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaCopy(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * idea_move 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_move", tags = {"需求" },  notes = "Idea-idea_move ")
    @PostMapping("ideas/{id}/idea_move")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaMoveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaMoveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaMoveById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_move 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaMoveById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaMove(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * idea_re_plan 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_re_plan", tags = {"需求" },  notes = "Idea-idea_re_plan ")
    @PostMapping("ideas/{id}/idea_re_plan")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaRePlanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaRePlanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaRePlanById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_re_plan 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaRePlanById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaRePlan(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * idea_readonly_recognize 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_readonly_recognize", tags = {"需求" },  notes = "Idea-idea_readonly_recognize ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-idea_readonly_recognize-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-idea_readonly_recognize')")
    @PostMapping("ideas/{id}/idea_readonly_recognize")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaReadonlyRecognizeById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaReadonlyRecognizeById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaReadonlyRecognizeById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_readonly_recognize 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaReadonlyRecognizeById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaReadonlyRecognize(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * mob_idea_attention 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "mob_idea_attention", tags = {"需求" },  notes = "Idea-mob_idea_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-mob_idea_attention-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-mob_idea_attention')")
    @PostMapping("ideas/{id}/mob_idea_attention")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>mobIdeaAttentionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(mobIdeaAttentionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(mobIdeaAttentionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_idea_attention 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO mobIdeaAttentionById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.mobIdeaAttention(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * move_order 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"需求" },  notes = "Idea-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-move_order-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-move_order')")
    @PostMapping("ideas/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<IdeaDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<List<IdeaDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */   
    public List<IdeaDTO> moveOrderById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        List<Idea> rt = ideaService.moveOrder(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * others_relation_idea 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "others_relation_idea", tags = {"需求" },  notes = "Idea-others_relation_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-others_relation_idea-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-others_relation_idea')")
    @PutMapping("ideas/{id}/others_relation_idea")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>othersRelationIdeaById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationIdeaById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationIdeaById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * others_relation_idea 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO othersRelationIdeaById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.othersRelationIdea(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * plan_delete_idea 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "plan_delete_idea", tags = {"需求" },  notes = "Idea-plan_delete_idea ")
    @PostMapping("ideas/{id}/plan_delete_idea")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>planDeleteIdeaById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planDeleteIdeaById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planDeleteIdeaById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_delete_idea 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO planDeleteIdeaById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.planDeleteIdea(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * product_idea_re_counters 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "product_idea_re_counters", tags = {"需求" },  notes = "Idea-product_idea_re_counters ")
    @PostMapping("ideas/{id}/product_idea_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>productIdeaReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productIdeaReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productIdeaReCountersById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * product_idea_re_counters 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO productIdeaReCountersById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.productIdeaReCounters(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * recover 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "recover", tags = {"需求" },  notes = "Idea-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-recover-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-recover')")
    @PostMapping("ideas/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO recoverById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.recover(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"需求" },  notes = "Idea-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Save-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Save')")
    @PostMapping("ideas/save")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>save
            (@Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO save
            (IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        ideaService.save(domain);
        Idea rt = domain;
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * update_idea_progress 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "update_idea_progress", tags = {"需求" },  notes = "Idea-update_idea_progress ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-update_idea_progress-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-update_idea_progress')")
    @PutMapping("ideas/{id}/update_idea_progress")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>updateIdeaProgressById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateIdeaProgressById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateIdeaProgressById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * update_idea_progress 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO updateIdeaProgressById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.updateIdeaProgress(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"需求" },  notes = "Idea-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Create-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Create')")
    @PostMapping("products/{productId}/ideas")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO createByProductId
            (String productId, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ideaService.create(domain);
        Idea rt = domain;
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"需求" },  notes = "Idea-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Update-all') or hasPermission('product',#productId,this.ideaService.get(#id),'ibizplm-Idea-Update')")
    @VersionCheck(entity = "idea" , versionfield = "updateTime")
    @PutMapping("products/{productId}/ideas/{id}")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO updateByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        ideaService.update(domain);
        Idea rt = domain;
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * activate 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "activate", tags = {"需求" },  notes = "Idea-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-activate-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-activate')")
    @PostMapping("products/{productId}/ideas/{id}/activate")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>activateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * activate 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO activateByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.activate(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * archive 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "archive", tags = {"需求" },  notes = "Idea-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-archive-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-archive')")
    @PostMapping("products/{productId}/ideas/{id}/archive")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>archiveByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * archive 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO archiveByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.archive(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * change_state 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "change_state", tags = {"需求" },  notes = "Idea-change_state ")
    @PostMapping("products/{productId}/ideas/{id}/change_state")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>changeStateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_state 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO changeStateByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.changeState(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * choose_case_template 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "choose_case_template", tags = {"需求" },  notes = "Idea-choose_case_template ")
    @PostMapping("products/{productId}/ideas/choose_case_template")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>chooseCaseTemplateByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(chooseCaseTemplateByProductId(productId, item)));
        else
            rt.set(chooseCaseTemplateByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * choose_case_template 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO chooseCaseTemplateByProductId
            (String productId, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Idea rt = ideaService.chooseCaseTemplate(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * delete 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "delete", tags = {"需求" },  notes = "Idea-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-delete-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-delete')")
    @PostMapping("products/{productId}/ideas/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>deleteByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO deleteByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.delete(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * get_customer_score 需求
    * 获取客户分数数据
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDefGroupCommonDTO>>
    */
    @ApiOperation(value = "get_customer_score", tags = {"需求" },  notes = "Idea-get_customer_score 获取客户分数数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-get_customer_score-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-get_customer_score')")
    @PostMapping("products/{productId}/ideas/{id}/get_customer_score")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDefGroupCommonDTO>>>getCustomerScoreByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDefGroupCommonDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(getCustomerScoreByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(getCustomerScoreByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_customer_score 需求
    * 获取客户分数数据
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDefGroupCommonDTO>
    */   
    public IdeaDefGroupCommonDTO getCustomerScoreByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.getCustomerScore(domain);
        return ideaDefGroupCommonDtoMapping.toDto(rt);
    }

    /**
    * idea_category 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_category", tags = {"需求" },  notes = "Idea-idea_category ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-idea_category-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-idea_category')")
    @PostMapping("products/{productId}/ideas/{id}/idea_category")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaCategoryByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaCategoryByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaCategoryByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_category 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaCategoryByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaCategory(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * idea_copy 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_copy", tags = {"需求" },  notes = "Idea-idea_copy ")
    @PostMapping("products/{productId}/ideas/{id}/idea_copy")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaCopyByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaCopyByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaCopyByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_copy 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaCopyByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaCopy(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * idea_move 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_move", tags = {"需求" },  notes = "Idea-idea_move ")
    @PostMapping("products/{productId}/ideas/{id}/idea_move")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaMoveByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaMoveByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaMoveByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_move 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaMoveByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaMove(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * idea_re_plan 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_re_plan", tags = {"需求" },  notes = "Idea-idea_re_plan ")
    @PostMapping("products/{productId}/ideas/{id}/idea_re_plan")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaRePlanByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaRePlanByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaRePlanByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_re_plan 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaRePlanByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaRePlan(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * idea_readonly_recognize 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "idea_readonly_recognize", tags = {"需求" },  notes = "Idea-idea_readonly_recognize ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-idea_readonly_recognize-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-idea_readonly_recognize')")
    @PostMapping("products/{productId}/ideas/{id}/idea_readonly_recognize")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>ideaReadonlyRecognizeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaReadonlyRecognizeByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaReadonlyRecognizeByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * idea_readonly_recognize 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO ideaReadonlyRecognizeByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.ideaReadonlyRecognize(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * mob_idea_attention 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "mob_idea_attention", tags = {"需求" },  notes = "Idea-mob_idea_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-mob_idea_attention-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-mob_idea_attention')")
    @PostMapping("products/{productId}/ideas/{id}/mob_idea_attention")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>mobIdeaAttentionByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(mobIdeaAttentionByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(mobIdeaAttentionByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_idea_attention 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO mobIdeaAttentionByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.mobIdeaAttention(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * move_order 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"需求" },  notes = "Idea-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-move_order-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-move_order')")
    @PostMapping("products/{productId}/ideas/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<IdeaDTO>>>>moveOrderByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<List<IdeaDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */   
    public List<IdeaDTO> moveOrderByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        List<Idea> rt = ideaService.moveOrder(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * others_relation_idea 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "others_relation_idea", tags = {"需求" },  notes = "Idea-others_relation_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-others_relation_idea-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-others_relation_idea')")
    @PutMapping("products/{productId}/ideas/{id}/others_relation_idea")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>othersRelationIdeaByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationIdeaByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationIdeaByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * others_relation_idea 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO othersRelationIdeaByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.othersRelationIdea(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * plan_delete_idea 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "plan_delete_idea", tags = {"需求" },  notes = "Idea-plan_delete_idea ")
    @PostMapping("products/{productId}/ideas/{id}/plan_delete_idea")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>planDeleteIdeaByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planDeleteIdeaByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planDeleteIdeaByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * plan_delete_idea 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO planDeleteIdeaByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.planDeleteIdea(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * product_idea_re_counters 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "product_idea_re_counters", tags = {"需求" },  notes = "Idea-product_idea_re_counters ")
    @PostMapping("products/{productId}/ideas/{id}/product_idea_re_counters")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>productIdeaReCountersByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productIdeaReCountersByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productIdeaReCountersByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * product_idea_re_counters 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO productIdeaReCountersByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.productIdeaReCounters(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * recover 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "recover", tags = {"需求" },  notes = "Idea-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-recover-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-recover')")
    @PostMapping("products/{productId}/ideas/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>recoverByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO recoverByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.recover(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"需求" },  notes = "Idea-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Save-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Save')")
    @PostMapping("products/{productId}/ideas/save")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO saveByProductId
            (String productId, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ideaService.save(domain);
        Idea rt = domain;
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * update_idea_progress 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "update_idea_progress", tags = {"需求" },  notes = "Idea-update_idea_progress ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-update_idea_progress-all') or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-update_idea_progress')")
    @PutMapping("products/{productId}/ideas/{id}/update_idea_progress")
    public Mono<ResponseEntity<ResponseWrapper<IdeaDTO>>>updateIdeaProgressByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateIdeaProgressByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateIdeaProgressByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * update_idea_progress 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO updateIdeaProgressByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.updateIdeaProgress(domain);
        return ideaDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 需求
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"需求" },  notes = "Idea-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Get-all')  or hasPermission(this.ideaDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Idea-Get')")
    @GetMapping("ideas/{id}")
    public Mono<ResponseEntity<IdeaDTO>> getById
            (@PathVariable("id") String id) {
        Idea rt = ideaService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 需求
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"需求" },  notes = "Idea-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Remove-all') or hasPermission(this.ideaService.get(#id),'ibizplm-Idea-Remove')")
    @DeleteMapping("ideas/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = ideaService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"需求" },  notes = "Idea-CheckKey ")
    @PostMapping("ideas/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        CheckKeyStatus rt = ideaService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 需求
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"需求" },  notes = "Idea-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-get_attention-all') or hasPermission(this.ideaService.get(#id),'ibizplm-Idea-get_attention')")
    @GetMapping("ideas/{id}/get_attention")
    public Mono<ResponseEntity<IdeaDTO>> getAttentionById
            (@PathVariable("id") String id) {
        Idea rt = ideaService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * get_baseline_name 需求
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "get_baseline_name", tags = {"需求" },  notes = "Idea-get_baseline_name ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-get_baseline_name-all') or hasPermission(this.ideaService.get(#id),'ibizplm-Idea-get_baseline_name')")
    @GetMapping("ideas/{id}/get_baseline_name")
    public Mono<ResponseEntity<IdeaDTO>> getBaselineNameById
            (@PathVariable("id") String id) {
        Idea rt = ideaService.getBaselineName(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"需求" },  notes = "Idea-GetDraft ")
    @GetMapping("ideas/get_draft")
    public Mono<ResponseEntity<IdeaDTO>> getDraft
            (@SpringQueryMap IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        Idea rt = ideaService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * get_ticket_num 需求
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "get_ticket_num", tags = {"需求" },  notes = "Idea-get_ticket_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-get_ticket_num-all') or hasPermission(this.ideaService.get(#id),'ibizplm-Idea-get_ticket_num')")
    @PostMapping("ideas/{id}/get_ticket_num")
    public Mono<ResponseEntity<IdeaDTO>> getTicketNumById
            (@PathVariable("id") String id) {
        Idea rt = ideaService.getTicketNum(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_admin 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"需求" },  notes = "Idea-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_admin-all') or hasPermission(#dto,'ibizplm-Idea-fetch_admin')")
    @PostMapping("ideas/fetch_admin")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchAdmin
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchAdmin(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_advanced_search 需求
    * 指定属性组；查询未删除的需求数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaAdvancedSearchDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"需求" },  notes = "Idea-fetch_advanced_search 指定属性组；查询未删除的需求数据")
    @PostMapping("ideas/fetch_advanced_search")
    public Mono<ResponseEntity<List<IdeaAdvancedSearchDTO>>> fetchAdvancedSearch
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchAdvancedSearch(context) ;
        List<IdeaAdvancedSearchDTO> list = ideaAdvancedSearchDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 需求
    * 查询已归档且未删除的需求数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"需求" },  notes = "Idea-fetch_archived 查询已归档且未删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_archived-all') or hasPermission(#dto,'ibizplm-Idea-fetch_archived')")
    @PostMapping("ideas/fetch_archived")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchArchived
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchArchived(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_idea 需求
    * 基线选择需求
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_idea", tags = {"需求" },  notes = "Idea-fetch_baseline_choose_idea 基线选择需求")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_baseline_choose_idea-all') or hasPermission(#dto,'ibizplm-Idea-fetch_baseline_choose_idea')")
    @PostMapping("ideas/fetch_baseline_choose_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchBaselineChooseIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchBaselineChooseIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"需求" },  notes = "Idea-fetch_bi_detail ")
    @PostMapping("ideas/fetch_bi_detail")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchBiDetail
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchBiDetail(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"需求" },  notes = "Idea-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_bi_search-all') or hasPermission(#dto,'ibizplm-Idea-fetch_bi_search')")
    @PostMapping("ideas/fetch_bi_search")
    public Mono<ResponseEntity<List<IdeaBiSearchGroupDTO>>> fetchBiSearch
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchBiSearch(context) ;
        List<IdeaBiSearchGroupDTO> list = ideaBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_assignee 需求
    * 查询指定属性组；评论负责人
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"需求" },  notes = "Idea-fetch_comment_notify_assignee 查询指定属性组；评论负责人")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_comment_notify_assignee-all') or hasPermission(#dto,'ibizplm-Idea-fetch_comment_notify_assignee')")
    @PostMapping("ideas/fetch_comment_notify_assignee")
    public Mono<ResponseEntity<List<IdeaAssigneeDTO>>> fetchCommentNotifyAssignee
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchCommentNotifyAssignee(context) ;
        List<IdeaAssigneeDTO> list = ideaAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common 需求
    * 状态非删除，如果上下文传递了类别参数，显示该类别下数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"需求" },  notes = "Idea-fetch_common 状态非删除，如果上下文传递了类别参数，显示该类别下数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_common-all') or hasPermission(#dto,'ibizplm-Idea-fetch_common')")
    @PostMapping("ideas/fetch_common")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchCommon
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchCommon(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_customer_user 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_customer_user", tags = {"需求" },  notes = "Idea-fetch_customer_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_customer_user-all') or hasPermission(#dto,'ibizplm-Idea-fetch_customer_user')")
    @PostMapping("ideas/fetch_customer_user")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchCustomerUser
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchCustomerUser(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 需求
    * 默认普通数据查询
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"需求" },  notes = "Idea-fetch_default 默认普通数据查询")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_default-all') or hasPermission(#dto,'ibizplm-Idea-fetch_default')")
    @PostMapping("ideas/fetch_default")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchDefault
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchDefault(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 需求
    * 查询已删除的需求数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"需求" },  notes = "Idea-fetch_deleted 查询已删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_deleted-all') or hasPermission(#dto,'ibizplm-Idea-fetch_deleted')")
    @PostMapping("ideas/fetch_deleted")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchDeleted
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchDeleted(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_mob_not_archived 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_mob_not_archived", tags = {"需求" },  notes = "Idea-fetch_mob_not_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_mob_not_archived-all') or hasPermission(#dto,'ibizplm-Idea-fetch_mob_not_archived')")
    @PostMapping("ideas/fetch_mob_not_archived")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMobNotArchived
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMobNotArchived(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_move_idea 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_move_idea", tags = {"需求" },  notes = "Idea-fetch_move_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_move_idea-all') or hasPermission(#dto,'ibizplm-Idea-fetch_move_idea')")
    @PostMapping("ideas/fetch_move_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMoveIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMoveIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assign 需求
    * 非归档数据，且负责人为当前登录人的数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assign", tags = {"需求" },  notes = "Idea-fetch_my_assign 非归档数据，且负责人为当前登录人的数据")
    @PostMapping("ideas/fetch_my_assign")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyAssign
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyAssign(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count 需求
    * 非归档数据，且负责人为当前登录人的数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"需求" },  notes = "Idea-fetch_my_assignee_count 非归档数据，且负责人为当前登录人的数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_my_assignee_count-all') or hasPermission(#dto,'ibizplm-Idea-fetch_my_assignee_count')")
    @PostMapping("ideas/fetch_my_assignee_count")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyAssigneeCount
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyAssigneeCount(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 需求
    * 查询我关注的需求（未归档、未删除）
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"需求" },  notes = "Idea-fetch_my_attention 查询我关注的需求（未归档、未删除）")
    @PostMapping("ideas/fetch_my_attention")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyAttention
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyAttention(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 需求
    * 首页我创建的需求表格调用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"需求" },  notes = "Idea-fetch_my_created 首页我创建的需求表格调用")
    @PostMapping("ideas/fetch_my_created")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyCreated
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyCreated(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"需求" },  notes = "Idea-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_my_filter-all') or hasPermission(#dto,'ibizplm-Idea-fetch_my_filter')")
    @PostMapping("ideas/fetch_my_filter")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyFilter
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyFilter(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_idea 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_idea", tags = {"需求" },  notes = "Idea-fetch_my_summary_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_my_summary_idea-all') or hasPermission(#dto,'ibizplm-Idea-fetch_my_summary_idea')")
    @PostMapping("ideas/fetch_my_summary_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMySummaryIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMySummaryIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 需求
    * 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"需求" },  notes = "Idea-fetch_normal 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_normal-all') or hasPermission(#dto,'ibizplm-Idea-fetch_normal')")
    @PostMapping("ideas/fetch_normal")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchNormal
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchNormal(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 需求
    * 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"需求" },  notes = "Idea-fetch_not_exsists_relation 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_not_exsists_relation-all') or hasPermission(#dto,'ibizplm-Idea-fetch_not_exsists_relation')")
    @PostMapping("ideas/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchNotExsistsRelation
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchNotExsistsRelation(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 需求
    * 查询指定属性组（负责人相关）
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"需求" },  notes = "Idea-fetch_notify_assignee 查询指定属性组（负责人相关）")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_notify_assignee-all') or hasPermission(#dto,'ibizplm-Idea-fetch_notify_assignee')")
    @PostMapping("ideas/fetch_notify_assignee")
    public Mono<ResponseEntity<List<IdeaAssigneeDTO>>> fetchNotifyAssignee
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchNotifyAssignee(context) ;
        List<IdeaAssigneeDTO> list = ideaAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_plan_relation_idea 需求
    * 计划关联需求表格调用
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_plan_relation_idea", tags = {"需求" },  notes = "Idea-fetch_plan_relation_idea 计划关联需求表格调用")
    @PostMapping("ideas/fetch_plan_relation_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchPlanRelationIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchPlanRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"需求" },  notes = "Idea-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_reader-all') or hasPermission(#dto,'ibizplm-Idea-fetch_reader')")
    @PostMapping("ideas/fetch_reader")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchReader
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchReader(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_idea 需求
    * 最近浏览的且未关联当前主体且非归档非删除的数据
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_idea", tags = {"需求" },  notes = "Idea-fetch_recent_idea 最近浏览的且未关联当前主体且非归档非删除的数据")
    @PostMapping("ideas/fetch_recent_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchRecentIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchRecentIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_relation_idea 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_relation_idea", tags = {"需求" },  notes = "Idea-fetch_relation_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_relation_idea-all') or hasPermission(#dto,'ibizplm-Idea-fetch_relation_idea')")
    @PostMapping("ideas/fetch_relation_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchRelationIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user 需求
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"需求" },  notes = "Idea-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_user-all') or hasPermission(#dto,'ibizplm-Idea-fetch_user')")
    @PostMapping("ideas/fetch_user")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchUser
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchUser(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"需求" },  notes = "Idea-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Get-all')  or hasPermission('product',#productId,this.ideaDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Idea-Get')")
    @GetMapping("products/{productId}/ideas/{id}")
    public Mono<ResponseEntity<IdeaDTO>> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Idea rt = ideaService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"需求" },  notes = "Idea-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Remove-all') or hasPermission('product',#productId,this.ideaService.get(#id),'ibizplm-Idea-Remove')")
    @DeleteMapping("products/{productId}/ideas/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = ideaService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"需求" },  notes = "Idea-CheckKey ")
    @PostMapping("products/{productId}/ideas/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        CheckKeyStatus rt = ideaService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_attention 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "get_attention", tags = {"需求" },  notes = "Idea-get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-get_attention-all') or hasPermission('product',#productId,this.ideaService.get(#id),'ibizplm-Idea-get_attention')")
    @GetMapping("products/{productId}/ideas/{id}/get_attention")
    public Mono<ResponseEntity<IdeaDTO>> getAttentionByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Idea rt = ideaService.getAttention(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * get_baseline_name 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "get_baseline_name", tags = {"需求" },  notes = "Idea-get_baseline_name ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-get_baseline_name-all') or hasPermission('product',#productId,this.ideaService.get(#id),'ibizplm-Idea-get_baseline_name')")
    @GetMapping("products/{productId}/ideas/{id}/get_baseline_name")
    public Mono<ResponseEntity<IdeaDTO>> getBaselineNameByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Idea rt = ideaService.getBaselineName(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"需求" },  notes = "Idea-GetDraft ")
    @GetMapping("products/{productId}/ideas/get_draft")
    public Mono<ResponseEntity<IdeaDTO>> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Idea rt = ideaService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * get_ticket_num 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<IdeaDTO>>
    */
    @ApiOperation(value = "get_ticket_num", tags = {"需求" },  notes = "Idea-get_ticket_num ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-get_ticket_num-all') or hasPermission('product',#productId,this.ideaService.get(#id),'ibizplm-Idea-get_ticket_num')")
    @PostMapping("products/{productId}/ideas/{id}/get_ticket_num")
    public Mono<ResponseEntity<IdeaDTO>> getTicketNumByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Idea rt = ideaService.getTicketNum(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_admin 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"需求" },  notes = "Idea-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_admin-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_admin')")
    @PostMapping("products/{productId}/ideas/fetch_admin")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchAdminByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchAdmin(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_advanced_search 需求
    * 指定属性组；查询未删除的需求数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaAdvancedSearchDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"需求" },  notes = "Idea-fetch_advanced_search 指定属性组；查询未删除的需求数据")
    @PostMapping("products/{productId}/ideas/fetch_advanced_search")
    public Mono<ResponseEntity<List<IdeaAdvancedSearchDTO>>> fetchAdvancedSearchByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchAdvancedSearch(context) ;
        List<IdeaAdvancedSearchDTO> list = ideaAdvancedSearchDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_archived 需求
    * 查询已归档且未删除的需求数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"需求" },  notes = "Idea-fetch_archived 查询已归档且未删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_archived-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_archived')")
    @PostMapping("products/{productId}/ideas/fetch_archived")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchArchivedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchArchived(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_idea 需求
    * 基线选择需求
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_idea", tags = {"需求" },  notes = "Idea-fetch_baseline_choose_idea 基线选择需求")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_baseline_choose_idea-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_baseline_choose_idea')")
    @PostMapping("products/{productId}/ideas/fetch_baseline_choose_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchBaselineChooseIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchBaselineChooseIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_detail 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_detail", tags = {"需求" },  notes = "Idea-fetch_bi_detail ")
    @PostMapping("products/{productId}/ideas/fetch_bi_detail")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchBiDetailByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchBiDetail(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_bi_search 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaBiSearchGroupDTO>>>
    */
    @ApiOperation(value = "查询fetch_bi_search", tags = {"需求" },  notes = "Idea-fetch_bi_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_bi_search-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_bi_search')")
    @PostMapping("products/{productId}/ideas/fetch_bi_search")
    public Mono<ResponseEntity<List<IdeaBiSearchGroupDTO>>> fetchBiSearchByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchBiSearch(context) ;
        List<IdeaBiSearchGroupDTO> list = ideaBiSearchGroupDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_comment_notify_assignee 需求
    * 查询指定属性组；评论负责人
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_comment_notify_assignee", tags = {"需求" },  notes = "Idea-fetch_comment_notify_assignee 查询指定属性组；评论负责人")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_comment_notify_assignee-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_comment_notify_assignee')")
    @PostMapping("products/{productId}/ideas/fetch_comment_notify_assignee")
    public Mono<ResponseEntity<List<IdeaAssigneeDTO>>> fetchCommentNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchCommentNotifyAssignee(context) ;
        List<IdeaAssigneeDTO> list = ideaAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_common 需求
    * 状态非删除，如果上下文传递了类别参数，显示该类别下数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_common", tags = {"需求" },  notes = "Idea-fetch_common 状态非删除，如果上下文传递了类别参数，显示该类别下数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_common-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_common')")
    @PostMapping("products/{productId}/ideas/fetch_common")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchCommonByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchCommon(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_customer_user 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_customer_user", tags = {"需求" },  notes = "Idea-fetch_customer_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_customer_user-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_customer_user')")
    @PostMapping("products/{productId}/ideas/fetch_customer_user")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchCustomerUserByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchCustomerUser(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 需求
    * 默认普通数据查询
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"需求" },  notes = "Idea-fetch_default 默认普通数据查询")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_default')")
    @PostMapping("products/{productId}/ideas/fetch_default")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchDefault(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_deleted 需求
    * 查询已删除的需求数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"需求" },  notes = "Idea-fetch_deleted 查询已删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_deleted-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_deleted')")
    @PostMapping("products/{productId}/ideas/fetch_deleted")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchDeletedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchDeleted(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_mob_not_archived 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_mob_not_archived", tags = {"需求" },  notes = "Idea-fetch_mob_not_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_mob_not_archived-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_mob_not_archived')")
    @PostMapping("products/{productId}/ideas/fetch_mob_not_archived")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMobNotArchivedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMobNotArchived(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_move_idea 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_move_idea", tags = {"需求" },  notes = "Idea-fetch_move_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_move_idea-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_move_idea')")
    @PostMapping("products/{productId}/ideas/fetch_move_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMoveIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMoveIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assign 需求
    * 非归档数据，且负责人为当前登录人的数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assign", tags = {"需求" },  notes = "Idea-fetch_my_assign 非归档数据，且负责人为当前登录人的数据")
    @PostMapping("products/{productId}/ideas/fetch_my_assign")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyAssignByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyAssign(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_assignee_count 需求
    * 非归档数据，且负责人为当前登录人的数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_assignee_count", tags = {"需求" },  notes = "Idea-fetch_my_assignee_count 非归档数据，且负责人为当前登录人的数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_my_assignee_count-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_my_assignee_count')")
    @PostMapping("products/{productId}/ideas/fetch_my_assignee_count")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyAssigneeCountByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyAssigneeCount(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_attention 需求
    * 查询我关注的需求（未归档、未删除）
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_attention", tags = {"需求" },  notes = "Idea-fetch_my_attention 查询我关注的需求（未归档、未删除）")
    @PostMapping("products/{productId}/ideas/fetch_my_attention")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyAttentionByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyAttention(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_created 需求
    * 首页我创建的需求表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_created", tags = {"需求" },  notes = "Idea-fetch_my_created 首页我创建的需求表格调用")
    @PostMapping("products/{productId}/ideas/fetch_my_created")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyCreatedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyCreated(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"需求" },  notes = "Idea-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_my_filter-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_my_filter')")
    @PostMapping("products/{productId}/ideas/fetch_my_filter")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMyFilterByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMyFilter(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_summary_idea 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_summary_idea", tags = {"需求" },  notes = "Idea-fetch_my_summary_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_my_summary_idea-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_my_summary_idea')")
    @PostMapping("products/{productId}/ideas/fetch_my_summary_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchMySummaryIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchMySummaryIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 需求
    * 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"需求" },  notes = "Idea-fetch_normal 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_normal-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_normal')")
    @PostMapping("products/{productId}/ideas/fetch_normal")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchNormalByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchNormal(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_not_exsists_relation 需求
    * 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_not_exsists_relation", tags = {"需求" },  notes = "Idea-fetch_not_exsists_relation 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_not_exsists_relation-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_not_exsists_relation')")
    @PostMapping("products/{productId}/ideas/fetch_not_exsists_relation")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchNotExsistsRelationByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchNotExsistsRelation(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_notify_assignee 需求
    * 查询指定属性组（负责人相关）
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaAssigneeDTO>>>
    */
    @ApiOperation(value = "查询fetch_notify_assignee", tags = {"需求" },  notes = "Idea-fetch_notify_assignee 查询指定属性组（负责人相关）")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_notify_assignee-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_notify_assignee')")
    @PostMapping("products/{productId}/ideas/fetch_notify_assignee")
    public Mono<ResponseEntity<List<IdeaAssigneeDTO>>> fetchNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchNotifyAssignee(context) ;
        List<IdeaAssigneeDTO> list = ideaAssigneeDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_plan_relation_idea 需求
    * 计划关联需求表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_plan_relation_idea", tags = {"需求" },  notes = "Idea-fetch_plan_relation_idea 计划关联需求表格调用")
    @PostMapping("products/{productId}/ideas/fetch_plan_relation_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchPlanRelationIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchPlanRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"需求" },  notes = "Idea-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_reader-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_reader')")
    @PostMapping("products/{productId}/ideas/fetch_reader")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchReaderByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchReader(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_recent_idea 需求
    * 最近浏览的且未关联当前主体且非归档非删除的数据
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_recent_idea", tags = {"需求" },  notes = "Idea-fetch_recent_idea 最近浏览的且未关联当前主体且非归档非删除的数据")
    @PostMapping("products/{productId}/ideas/fetch_recent_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchRecentIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchRecentIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_relation_idea 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_relation_idea", tags = {"需求" },  notes = "Idea-fetch_relation_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_relation_idea-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_relation_idea')")
    @PostMapping("products/{productId}/ideas/fetch_relation_idea")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchRelationIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_user 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<IdeaDTO>>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"需求" },  notes = "Idea-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-fetch_user-all') or hasPermission('product',#productId,#dto,'ibizplm-Idea-fetch_user')")
    @PostMapping("products/{productId}/ideas/fetch_user")
    public Mono<ResponseEntity<List<IdeaDTO>>> fetchUserByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.fetchUser(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建需求
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Create-all')")
    @ApiOperation(value = "批量新建需求", tags = {"需求" },  notes = "批量新建需求")
	@PostMapping("ideas/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<IdeaDTO> dtos) {
        ideaService.create(ideaDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除需求
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Remove-all')")
    @ApiOperation(value = "批量删除需求", tags = {"需求" },  notes = "批量删除需求")
	@DeleteMapping("ideas/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        ideaService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新需求
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Update-all')")
    @ApiOperation(value = "批量更新需求", tags = {"需求" },  notes = "批量更新需求")
	@PutMapping("ideas/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<IdeaDTO> dtos) {
        ideaService.update(ideaDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存需求
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Save-all')")
    @ApiOperation(value = "批量保存需求", tags = {"需求" },  notes = "批量保存需求")
	@PostMapping("ideas/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<IdeaDTO> dtos) {
        ideaService.save(ideaDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入需求
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Save-all')")
    @ApiOperation(value = "批量导入需求", tags = {"需求" },  notes = "批量导入需求")
	@PostMapping("ideas/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<IdeaDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(ideaService.importData(config,ignoreError,ideaDtoMapping.toDomain(dtos))));
    }

}
