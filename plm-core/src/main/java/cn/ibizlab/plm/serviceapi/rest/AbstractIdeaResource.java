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
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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
    public IdeaDTOMapping ideaDtoMapping;

    @Autowired
    @Lazy
    public IdeaFilterDTOMapping ideaFilterDtoMapping;

    @Autowired
    @Lazy
    public Ideaadvanced_searchDTOMapping ideaadvancedSearchDtoMapping;

    @Autowired
    @Lazy
    public IdeaassigneeDTOMapping ideaassigneeDtoMapping;

    /**
    * 创建Create 需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"需求" },  notes = "Idea-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Create-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Create')")
    @PostMapping("ideas")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> create
            (@Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"需求" },  notes = "Idea-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Update-all') or hasPermission(this.ideaService.get(#id),'ibizplm-Idea-Update')")
    @VersionCheck(entity = "idea" , versionfield = "updateTime")
    @PutMapping("ideas/{id}")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Activate 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Activate", tags = {"需求" },  notes = "Idea-Activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Activate-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Activate')")
    @PostMapping("ideas/{id}/activate")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Activate 需求
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
    * Archive 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Archive", tags = {"需求" },  notes = "Idea-Archive ")
    @PostMapping("ideas/{id}/archive")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Archive 需求
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
    * Change_state 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Change_state", tags = {"需求" },  notes = "Idea-Change_state ")
    @PostMapping("ideas/{id}/change_state")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> changeStateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_state 需求
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
    * Del_relation 需求
    * 取消关联，删除相应的正反向关联数据
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"需求" },  notes = "Idea-Del_relation 取消关联，删除相应的正反向关联数据")
    @PostMapping("ideas/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 需求
    * 取消关联，删除相应的正反向关联数据
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO delRelationById
            (String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.delRelation(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * Delete 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Delete", tags = {"需求" },  notes = "Idea-Delete ")
    @PostMapping("ideas/{id}/delete")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 需求
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
    * Idea_category 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Idea_category", tags = {"需求" },  notes = "Idea-Idea_category ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Idea_category-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Idea_category')")
    @PostMapping("ideas/{id}/idea_category")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> ideaCategoryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaCategoryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaCategoryById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Idea_category 需求
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
    * Idea_copy 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Idea_copy", tags = {"需求" },  notes = "Idea-Idea_copy ")
    @PostMapping("ideas/{id}/idea_copy")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> ideaCopyById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaCopyById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaCopyById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Idea_copy 需求
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
    * Idea_move 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Idea_move", tags = {"需求" },  notes = "Idea-Idea_move ")
    @PostMapping("ideas/{id}/idea_move")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> ideaMoveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaMoveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaMoveById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Idea_move 需求
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
    * Idea_re_plan 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Idea_re_plan", tags = {"需求" },  notes = "Idea-Idea_re_plan ")
    @PostMapping("ideas/{id}/idea_re_plan")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> ideaRePlanById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaRePlanById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaRePlanById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Idea_re_plan 需求
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
    * Others_relation_idea 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Others_relation_idea", tags = {"需求" },  notes = "Idea-Others_relation_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Others_relation_idea-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Others_relation_idea')")
    @PutMapping("ideas/{id}/others_relation_idea")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> othersRelationIdeaById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationIdeaById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationIdeaById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Others_relation_idea 需求
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
    * Plan_delete_idea 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Plan_delete_idea", tags = {"需求" },  notes = "Idea-Plan_delete_idea ")
    @PostMapping("ideas/{id}/plan_delete_idea")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> planDeleteIdeaById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planDeleteIdeaById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planDeleteIdeaById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Plan_delete_idea 需求
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
    * Product_idea_re_counters 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Product_idea_re_counters", tags = {"需求" },  notes = "Idea-Product_idea_re_counters ")
    @PostMapping("ideas/{id}/product_idea_re_counters")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> productIdeaReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productIdeaReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productIdeaReCountersById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Product_idea_re_counters 需求
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
    * Recover 需求
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Recover", tags = {"需求" },  notes = "Idea-Recover ")
    @PostMapping("ideas/{id}/recover")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Recover 需求
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
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"需求" },  notes = "Idea-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Save-all') or hasPermission(this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Save')")
    @PostMapping("ideas/save")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> save
            (@Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 创建Create 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"需求" },  notes = "Idea-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Create-all') or hasPermission('Product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Create')")
    @PostMapping("products/{productId}/ideas")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"需求" },  notes = "Idea-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Update-all') or hasPermission('Product',#productId,this.ideaService.get(#id),'ibizplm-Idea-Update')")
    @VersionCheck(entity = "idea" , versionfield = "updateTime")
    @PutMapping("products/{productId}/ideas/{id}")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Activate 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Activate", tags = {"需求" },  notes = "Idea-Activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Activate-all') or hasPermission('Product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Activate')")
    @PostMapping("products/{productId}/ideas/{id}/activate")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> activateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Activate 需求
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
    * Archive 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Archive", tags = {"需求" },  notes = "Idea-Archive ")
    @PostMapping("products/{productId}/ideas/{id}/archive")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> archiveByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Archive 需求
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
    * Change_state 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Change_state", tags = {"需求" },  notes = "Idea-Change_state ")
    @PostMapping("products/{productId}/ideas/{id}/change_state")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> changeStateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeStateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeStateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Change_state 需求
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
    * Del_relation 需求
    * 取消关联，删除相应的正反向关联数据
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"需求" },  notes = "Idea-Del_relation 取消关联，删除相应的正反向关联数据")
    @PostMapping("products/{productId}/ideas/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> delRelationByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 需求
    * 取消关联，删除相应的正反向关联数据
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */   
    public IdeaDTO delRelationByProductIdAndId
            (String productId, String id, IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setId(id);
        Idea rt = ideaService.delRelation(domain);
        return ideaDtoMapping.toDto(rt);
    }

    /**
    * Delete 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Delete", tags = {"需求" },  notes = "Idea-Delete ")
    @PostMapping("products/{productId}/ideas/{id}/delete")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> deleteByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 需求
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
    * Idea_category 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Idea_category", tags = {"需求" },  notes = "Idea-Idea_category ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Idea_category-all') or hasPermission('Product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Idea_category')")
    @PostMapping("products/{productId}/ideas/{id}/idea_category")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> ideaCategoryByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaCategoryByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaCategoryByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Idea_category 需求
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
    * Idea_copy 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Idea_copy", tags = {"需求" },  notes = "Idea-Idea_copy ")
    @PostMapping("products/{productId}/ideas/{id}/idea_copy")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> ideaCopyByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaCopyByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaCopyByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Idea_copy 需求
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
    * Idea_move 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Idea_move", tags = {"需求" },  notes = "Idea-Idea_move ")
    @PostMapping("products/{productId}/ideas/{id}/idea_move")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> ideaMoveByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaMoveByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaMoveByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Idea_move 需求
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
    * Idea_re_plan 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Idea_re_plan", tags = {"需求" },  notes = "Idea-Idea_re_plan ")
    @PostMapping("products/{productId}/ideas/{id}/idea_re_plan")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> ideaRePlanByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(ideaRePlanByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(ideaRePlanByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Idea_re_plan 需求
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
    * Others_relation_idea 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Others_relation_idea", tags = {"需求" },  notes = "Idea-Others_relation_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Others_relation_idea-all') or hasPermission('Product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Others_relation_idea')")
    @PutMapping("products/{productId}/ideas/{id}/others_relation_idea")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> othersRelationIdeaByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationIdeaByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationIdeaByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Others_relation_idea 需求
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
    * Plan_delete_idea 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Plan_delete_idea", tags = {"需求" },  notes = "Idea-Plan_delete_idea ")
    @PostMapping("products/{productId}/ideas/{id}/plan_delete_idea")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> planDeleteIdeaByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(planDeleteIdeaByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(planDeleteIdeaByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Plan_delete_idea 需求
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
    * Product_idea_re_counters 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Product_idea_re_counters", tags = {"需求" },  notes = "Idea-Product_idea_re_counters ")
    @PostMapping("products/{productId}/ideas/{id}/product_idea_re_counters")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> productIdeaReCountersByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productIdeaReCountersByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productIdeaReCountersByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Product_idea_re_counters 需求
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
    * Recover 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Recover", tags = {"需求" },  notes = "Idea-Recover ")
    @PostMapping("products/{productId}/ideas/{id}/recover")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> recoverByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Recover 需求
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
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"需求" },  notes = "Idea-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Save-all') or hasPermission('Product',#productId,this.ideaDtoMapping.toDomain(#dto),'ibizplm-Idea-Save')")
    @PostMapping("products/{productId}/ideas/save")
    public ResponseEntity<ResponseWrapper<IdeaDTO>> saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<IdeaDTO> dto) {
        ResponseWrapper<IdeaDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 获取Get 需求
    * 
    *
    * @param id id
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"需求" },  notes = "Idea-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Get-all')  or hasPermission(this.ideaDtoMapping.toDomain(returnObject.body),'ibizplm-Idea-Get')")
    @GetMapping("ideas/{id}")
    public ResponseEntity<IdeaDTO> getById
            (@PathVariable("id") String id) {
        Idea rt = ideaService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 需求
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"需求" },  notes = "Idea-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Remove-all') or hasPermission(this.ideaService.get(#id),'ibizplm-Idea-Remove')")
    @DeleteMapping("ideas/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = ideaService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"需求" },  notes = "Idea-CheckKey ")
    @PostMapping("ideas/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        Integer rt = ideaService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 需求
    * 
    *
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"需求" },  notes = "Idea-GetDraft ")
    @GetMapping("ideas/getdraft")
    public ResponseEntity<IdeaDTO> getDraft
            (@SpringQueryMap IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        Idea rt = ideaService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt));
    }

    /**
    * Get_attention 需求
    * 
    *
    * @param id id
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Get_attention", tags = {"需求" },  notes = "Idea-Get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Get_attention-all') or hasPermission(this.ideaService.get(#id),'ibizplm-Idea-Get_attention')")
    @GetMapping("ideas/{id}/get_attention")
    public ResponseEntity<IdeaDTO> getAttentionById
            (@PathVariable("id") String id) {
        Idea rt = ideaService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchAdvanced_search 需求
    * 指定属性组；查询未删除的需求数据
    *
    * @param dto dto
    * @return ResponseEntity<List<Ideaadvanced_searchDTO>>
    */
    @ApiOperation(value = "查询FetchAdvanced_search", tags = {"需求" },  notes = "Idea-FetchAdvanced_search 指定属性组；查询未删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchAdvanced_search-all') or hasPermission(#dto,'ibizplm-Idea-FetchAdvanced_search')")
    @PostMapping("ideas/fetchadvanced_search")
    public ResponseEntity<List<Ideaadvanced_searchDTO>> fetchAdvancedSearch
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchAdvancedSearch(context) ;
        List<Ideaadvanced_searchDTO> list = ideaadvancedSearchDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchArchived 需求
    * 查询已归档且未删除的需求数据
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchArchived", tags = {"需求" },  notes = "Idea-FetchArchived 查询已归档且未删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchArchived-all') or hasPermission(#dto,'ibizplm-Idea-FetchArchived')")
    @PostMapping("ideas/fetcharchived")
    public ResponseEntity<List<IdeaDTO>> fetchArchived
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchArchived(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchComment_notify_assignee 需求
    * 查询指定属性组；评论负责人
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchComment_notify_assignee", tags = {"需求" },  notes = "Idea-FetchComment_notify_assignee 查询指定属性组；评论负责人")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchComment_notify_assignee-all') or hasPermission(#dto,'ibizplm-Idea-FetchComment_notify_assignee')")
    @PostMapping("ideas/fetchcomment_notify_assignee")
    public ResponseEntity<List<IdeaassigneeDTO>> fetchCommentNotifyAssignee
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchCommentNotifyAssignee(context) ;
        List<IdeaassigneeDTO> list = ideaassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchCommon 需求
    * 状态非删除，如果上下文传递了类别参数，显示该类别下数据
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchCommon", tags = {"需求" },  notes = "Idea-FetchCommon 状态非删除，如果上下文传递了类别参数，显示该类别下数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchCommon-all') or hasPermission(#dto,'ibizplm-Idea-FetchCommon')")
    @PostMapping("ideas/fetchcommon")
    public ResponseEntity<List<IdeaDTO>> fetchCommon
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchCommon(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 需求
    * 默认普通数据查询
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"需求" },  notes = "Idea-FetchDefault 默认普通数据查询")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchDefault-all') or hasPermission(#dto,'ibizplm-Idea-FetchDefault')")
    @PostMapping("ideas/fetchdefault")
    public ResponseEntity<List<IdeaDTO>> fetchDefault
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchDefault(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDeleted 需求
    * 查询已删除的需求数据
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"需求" },  notes = "Idea-FetchDeleted 查询已删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchDeleted-all') or hasPermission(#dto,'ibizplm-Idea-FetchDeleted')")
    @PostMapping("ideas/fetchdeleted")
    public ResponseEntity<List<IdeaDTO>> fetchDeleted
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchDeleted(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_relation_idea 需求
    * 需求关联需求表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_relation_idea", tags = {"需求" },  notes = "Idea-FetchIdea_relation_idea 需求关联需求表格调用")
    @PostMapping("ideas/fetchidea_relation_idea")
    public ResponseEntity<List<IdeaDTO>> fetchIdeaRelationIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchIdeaRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assign 需求
    * 非归档数据，且负责人为当前登录人的数据
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assign", tags = {"需求" },  notes = "Idea-FetchMy_assign 非归档数据，且负责人为当前登录人的数据")
    @PostMapping("ideas/fetchmy_assign")
    public ResponseEntity<List<IdeaDTO>> fetchMyAssign
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchMyAssign(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assignee_count 需求
    * 非归档数据，且负责人为当前登录人的数据
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assignee_count", tags = {"需求" },  notes = "Idea-FetchMy_assignee_count 非归档数据，且负责人为当前登录人的数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchMy_assignee_count-all') or hasPermission(#dto,'ibizplm-Idea-FetchMy_assignee_count')")
    @PostMapping("ideas/fetchmy_assignee_count")
    public ResponseEntity<List<IdeaDTO>> fetchMyAssigneeCount
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchMyAssigneeCount(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_attention 需求
    * 查询我关注的需求（未归档、未删除）
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchMy_attention", tags = {"需求" },  notes = "Idea-FetchMy_attention 查询我关注的需求（未归档、未删除）")
    @PostMapping("ideas/fetchmy_attention")
    public ResponseEntity<List<IdeaDTO>> fetchMyAttention
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchMyAttention(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_created 需求
    * 首页我创建的需求表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchMy_created", tags = {"需求" },  notes = "Idea-FetchMy_created 首页我创建的需求表格调用")
    @PostMapping("ideas/fetchmy_created")
    public ResponseEntity<List<IdeaDTO>> fetchMyCreated
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchMyCreated(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 需求
    * 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"需求" },  notes = "Idea-FetchNormal 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchNormal-all') or hasPermission(#dto,'ibizplm-Idea-FetchNormal')")
    @PostMapping("ideas/fetchnormal")
    public ResponseEntity<List<IdeaDTO>> fetchNormal
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchNormal(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_exsists_relation 需求
    * 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchNot_exsists_relation", tags = {"需求" },  notes = "Idea-FetchNot_exsists_relation 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchNot_exsists_relation-all') or hasPermission(#dto,'ibizplm-Idea-FetchNot_exsists_relation')")
    @PostMapping("ideas/fetchnot_exsists_relation")
    public ResponseEntity<List<IdeaDTO>> fetchNotExsistsRelation
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchNotExsistsRelation(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNotify_assignee 需求
    * 查询指定属性组（负责人相关）
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchNotify_assignee", tags = {"需求" },  notes = "Idea-FetchNotify_assignee 查询指定属性组（负责人相关）")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchNotify_assignee-all') or hasPermission(#dto,'ibizplm-Idea-FetchNotify_assignee')")
    @PostMapping("ideas/fetchnotify_assignee")
    public ResponseEntity<List<IdeaassigneeDTO>> fetchNotifyAssignee
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchNotifyAssignee(context) ;
        List<IdeaassigneeDTO> list = ideaassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchPlan_relation_idea 需求
    * 计划关联需求表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchPlan_relation_idea", tags = {"需求" },  notes = "Idea-FetchPlan_relation_idea 计划关联需求表格调用")
    @PostMapping("ideas/fetchplan_relation_idea")
    public ResponseEntity<List<IdeaDTO>> fetchPlanRelationIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchPlanRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_idea 需求
    * 最近浏览的且未关联当前主体且非归档非删除的数据
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_idea", tags = {"需求" },  notes = "Idea-FetchRecent_idea 最近浏览的且未关联当前主体且非归档非删除的数据")
    @PostMapping("ideas/fetchrecent_idea")
    public ResponseEntity<List<IdeaDTO>> fetchRecentIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchRecentIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTest_case_relation 需求
    * 测试用例关联需求表格调用；
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchTest_case_relation", tags = {"需求" },  notes = "Idea-FetchTest_case_relation 测试用例关联需求表格调用；")
    @PostMapping("ideas/fetchtest_case_relation")
    public ResponseEntity<List<IdeaDTO>> fetchTestCaseRelation
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchTestCaseRelation(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTicket_relation_idea 需求
    * 工单关联需求表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchTicket_relation_idea", tags = {"需求" },  notes = "Idea-FetchTicket_relation_idea 工单关联需求表格调用")
    @PostMapping("ideas/fetchticket_relation_idea")
    public ResponseEntity<List<IdeaDTO>> fetchTicketRelationIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchTicketRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchWork_item_relation_idea 需求
    * 工作项关联需求表格调用
    *
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchWork_item_relation_idea", tags = {"需求" },  notes = "Idea-FetchWork_item_relation_idea 工作项关联需求表格调用")
    @PostMapping("ideas/fetchwork_item_relation_idea")
    public ResponseEntity<List<IdeaDTO>> fetchWorkItemRelationIdea
            (@Validated @RequestBody IdeaFilterDTO dto) {
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchWorkItemRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"需求" },  notes = "Idea-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Get-all')  or hasPermission('Product',#productId,this.ideaDtoMapping.toDomain(returnObject.body),'ibizplm-Idea-Get')")
    @GetMapping("products/{productId}/ideas/{id}")
    public ResponseEntity<IdeaDTO> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Idea rt = ideaService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"需求" },  notes = "Idea-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Remove-all') or hasPermission('Product',#productId,this.ideaService.get(#id),'ibizplm-Idea-Remove')")
    @DeleteMapping("products/{productId}/ideas/{id}")
    public ResponseEntity<Boolean> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = ideaService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"需求" },  notes = "Idea-CheckKey ")
    @PostMapping("products/{productId}/ideas/checkkey")
    public ResponseEntity<Integer> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Integer rt = ideaService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 需求
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"需求" },  notes = "Idea-GetDraft ")
    @GetMapping("products/{productId}/ideas/getdraft")
    public ResponseEntity<IdeaDTO> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap IdeaDTO dto) {
        Idea domain = ideaDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Idea rt = ideaService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt));
    }

    /**
    * Get_attention 需求
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<IdeaDTO>
    */
    @ApiOperation(value = "Get_attention", tags = {"需求" },  notes = "Idea-Get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-Get_attention-all') or hasPermission('Product',#productId,this.ideaService.get(#id),'ibizplm-Idea-Get_attention')")
    @GetMapping("products/{productId}/ideas/{id}/get_attention")
    public ResponseEntity<IdeaDTO> getAttentionByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Idea rt = ideaService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(ideaDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchAdvanced_search 需求
    * 指定属性组；查询未删除的需求数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<Ideaadvanced_searchDTO>>
    */
    @ApiOperation(value = "查询FetchAdvanced_search", tags = {"需求" },  notes = "Idea-FetchAdvanced_search 指定属性组；查询未删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchAdvanced_search-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchAdvanced_search')")
    @PostMapping("products/{productId}/ideas/fetchadvanced_search")
    public ResponseEntity<List<Ideaadvanced_searchDTO>> fetchAdvancedSearchByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchAdvancedSearch(context) ;
        List<Ideaadvanced_searchDTO> list = ideaadvancedSearchDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchArchived 需求
    * 查询已归档且未删除的需求数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchArchived", tags = {"需求" },  notes = "Idea-FetchArchived 查询已归档且未删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchArchived-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchArchived')")
    @PostMapping("products/{productId}/ideas/fetcharchived")
    public ResponseEntity<List<IdeaDTO>> fetchArchivedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchArchived(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchComment_notify_assignee 需求
    * 查询指定属性组；评论负责人
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchComment_notify_assignee", tags = {"需求" },  notes = "Idea-FetchComment_notify_assignee 查询指定属性组；评论负责人")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchComment_notify_assignee-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchComment_notify_assignee')")
    @PostMapping("products/{productId}/ideas/fetchcomment_notify_assignee")
    public ResponseEntity<List<IdeaassigneeDTO>> fetchCommentNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchCommentNotifyAssignee(context) ;
        List<IdeaassigneeDTO> list = ideaassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchCommon 需求
    * 状态非删除，如果上下文传递了类别参数，显示该类别下数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchCommon", tags = {"需求" },  notes = "Idea-FetchCommon 状态非删除，如果上下文传递了类别参数，显示该类别下数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchCommon-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchCommon')")
    @PostMapping("products/{productId}/ideas/fetchcommon")
    public ResponseEntity<List<IdeaDTO>> fetchCommonByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchCommon(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 需求
    * 默认普通数据查询
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"需求" },  notes = "Idea-FetchDefault 默认普通数据查询")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchDefault-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchDefault')")
    @PostMapping("products/{productId}/ideas/fetchdefault")
    public ResponseEntity<List<IdeaDTO>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchDefault(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDeleted 需求
    * 查询已删除的需求数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"需求" },  notes = "Idea-FetchDeleted 查询已删除的需求数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchDeleted-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchDeleted')")
    @PostMapping("products/{productId}/ideas/fetchdeleted")
    public ResponseEntity<List<IdeaDTO>> fetchDeletedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchDeleted(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_relation_idea 需求
    * 需求关联需求表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_relation_idea", tags = {"需求" },  notes = "Idea-FetchIdea_relation_idea 需求关联需求表格调用")
    @PostMapping("products/{productId}/ideas/fetchidea_relation_idea")
    public ResponseEntity<List<IdeaDTO>> fetchIdeaRelationIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchIdeaRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assign 需求
    * 非归档数据，且负责人为当前登录人的数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assign", tags = {"需求" },  notes = "Idea-FetchMy_assign 非归档数据，且负责人为当前登录人的数据")
    @PostMapping("products/{productId}/ideas/fetchmy_assign")
    public ResponseEntity<List<IdeaDTO>> fetchMyAssignByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchMyAssign(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_assignee_count 需求
    * 非归档数据，且负责人为当前登录人的数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchMy_assignee_count", tags = {"需求" },  notes = "Idea-FetchMy_assignee_count 非归档数据，且负责人为当前登录人的数据")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchMy_assignee_count-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchMy_assignee_count')")
    @PostMapping("products/{productId}/ideas/fetchmy_assignee_count")
    public ResponseEntity<List<IdeaDTO>> fetchMyAssigneeCountByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchMyAssigneeCount(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_attention 需求
    * 查询我关注的需求（未归档、未删除）
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchMy_attention", tags = {"需求" },  notes = "Idea-FetchMy_attention 查询我关注的需求（未归档、未删除）")
    @PostMapping("products/{productId}/ideas/fetchmy_attention")
    public ResponseEntity<List<IdeaDTO>> fetchMyAttentionByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchMyAttention(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchMy_created 需求
    * 首页我创建的需求表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchMy_created", tags = {"需求" },  notes = "Idea-FetchMy_created 首页我创建的需求表格调用")
    @PostMapping("products/{productId}/ideas/fetchmy_created")
    public ResponseEntity<List<IdeaDTO>> fetchMyCreatedByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchMyCreated(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 需求
    * 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"需求" },  notes = "Idea-FetchNormal 状态非删除，如果上下文传递了子产品参数，查询当前子产品下的需求")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchNormal-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchNormal')")
    @PostMapping("products/{productId}/ideas/fetchnormal")
    public ResponseEntity<List<IdeaDTO>> fetchNormalByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchNormal(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNot_exsists_relation 需求
    * 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchNot_exsists_relation", tags = {"需求" },  notes = "Idea-FetchNot_exsists_relation 多项选择视图中右侧表格的数据来源；查询了未与当前主体关联的数据。")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchNot_exsists_relation-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchNot_exsists_relation')")
    @PostMapping("products/{productId}/ideas/fetchnot_exsists_relation")
    public ResponseEntity<List<IdeaDTO>> fetchNotExsistsRelationByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchNotExsistsRelation(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNotify_assignee 需求
    * 查询指定属性组（负责人相关）
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchNotify_assignee", tags = {"需求" },  notes = "Idea-FetchNotify_assignee 查询指定属性组（负责人相关）")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Idea-FetchNotify_assignee-all') or hasPermission('Product',#productId,#dto,'ibizplm-Idea-FetchNotify_assignee')")
    @PostMapping("products/{productId}/ideas/fetchnotify_assignee")
    public ResponseEntity<List<IdeaassigneeDTO>> fetchNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchNotifyAssignee(context) ;
        List<IdeaassigneeDTO> list = ideaassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchPlan_relation_idea 需求
    * 计划关联需求表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchPlan_relation_idea", tags = {"需求" },  notes = "Idea-FetchPlan_relation_idea 计划关联需求表格调用")
    @PostMapping("products/{productId}/ideas/fetchplan_relation_idea")
    public ResponseEntity<List<IdeaDTO>> fetchPlanRelationIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchPlanRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchRecent_idea 需求
    * 最近浏览的且未关联当前主体且非归档非删除的数据
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchRecent_idea", tags = {"需求" },  notes = "Idea-FetchRecent_idea 最近浏览的且未关联当前主体且非归档非删除的数据")
    @PostMapping("products/{productId}/ideas/fetchrecent_idea")
    public ResponseEntity<List<IdeaDTO>> fetchRecentIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchRecentIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTest_case_relation 需求
    * 测试用例关联需求表格调用；
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchTest_case_relation", tags = {"需求" },  notes = "Idea-FetchTest_case_relation 测试用例关联需求表格调用；")
    @PostMapping("products/{productId}/ideas/fetchtest_case_relation")
    public ResponseEntity<List<IdeaDTO>> fetchTestCaseRelationByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchTestCaseRelation(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchTicket_relation_idea 需求
    * 工单关联需求表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchTicket_relation_idea", tags = {"需求" },  notes = "Idea-FetchTicket_relation_idea 工单关联需求表格调用")
    @PostMapping("products/{productId}/ideas/fetchticket_relation_idea")
    public ResponseEntity<List<IdeaDTO>> fetchTicketRelationIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchTicketRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchWork_item_relation_idea 需求
    * 工作项关联需求表格调用
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<IdeaDTO>>
    */
    @ApiOperation(value = "查询FetchWork_item_relation_idea", tags = {"需求" },  notes = "Idea-FetchWork_item_relation_idea 工作项关联需求表格调用")
    @PostMapping("products/{productId}/ideas/fetchwork_item_relation_idea")
    public ResponseEntity<List<IdeaDTO>> fetchWorkItemRelationIdeaByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody IdeaFilterDTO dto) {
        dto.setProductIdEQ(productId);
        IdeaSearchContext context = ideaFilterDtoMapping.toDomain(dto);
        Page<Idea> domains = ideaService.searchWorkItemRelationIdea(context) ;
        List<IdeaDTO> list = ideaDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建需求
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Create-all')")
    @ApiOperation(value = "批量新建需求", tags = {"需求" },  notes = "批量新建需求")
	@PostMapping("ideas/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IdeaDTO> dtos) {
        ideaService.createBatch(ideaDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除需求
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Remove-all')")
    @ApiOperation(value = "批量删除需求", tags = {"需求" },  notes = "批量删除需求")
	@DeleteMapping("ideas/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ideaService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新需求
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Update-all')")
    @ApiOperation(value = "批量更新需求", tags = {"需求" },  notes = "批量更新需求")
	@PutMapping("ideas/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IdeaDTO> dtos) {
        ideaService.updateBatch(ideaDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存需求
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Save-all')")
    @ApiOperation(value = "批量保存需求", tags = {"需求" },  notes = "批量保存需求")
	@PostMapping("ideas/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IdeaDTO> dtos) {
        ideaService.saveBatch(ideaDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入需求
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Idea-Save-all')")
    @ApiOperation(value = "批量导入需求", tags = {"需求" },  notes = "批量导入需求")
	@PostMapping("ideas/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<IdeaDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(ideaService.importData(config,ignoreError,ideaDtoMapping.toDomain(dtos)));
    }

}
