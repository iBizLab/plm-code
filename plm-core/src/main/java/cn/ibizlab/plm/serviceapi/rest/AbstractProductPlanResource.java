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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.service.ProductPlanService;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductPlanSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[ProductPlan] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductPlanResource {

    @Autowired
    public ProductPlanService productPlanService;

    @Autowired
    @Lazy
    public ProductPlanDTOMapping productPlanDtoMapping;

    @Autowired
    @Lazy
    public ProductPlanFilterDTOMapping productPlanFilterDtoMapping;

    /**
    * 创建Create 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductPlanDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"排期" },  notes = "ProductPlan-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Create-all') or hasPermission('product',#productId,this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-Create')")
    @PostMapping("products/{productId}/product_plans")
    public Mono<ResponseEntity<ResponseWrapper<ProductPlanDTO>>>createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO createByProductId
            (String productId, ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        productPlanService.create(domain);
        ProductPlan rt = domain;
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductPlanDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"排期" },  notes = "ProductPlan-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Update-all') or hasPermission('product',#productId,this.productPlanService.get(#id),'ibizplm-ProductPlan-Update')")
    @VersionCheck(entity = "productplan" , versionfield = "updateTime")
    @PutMapping("products/{productId}/product_plans/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProductPlanDTO>>>updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO updateByProductIdAndId
            (String productId, String id, ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        productPlanService.update(domain);
        ProductPlan rt = domain;
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * delete 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductPlanDTO>>
    */
    @ApiOperation(value = "delete", tags = {"排期" },  notes = "ProductPlan-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-delete-all') or hasPermission('product',#productId,this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-delete')")
    @PostMapping("products/{productId}/product_plans/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<ProductPlanDTO>>>deleteByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO deleteByProductIdAndId
            (String productId, String id, ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductPlan rt = productPlanService.delete(domain);
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * delete_categories 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductPlanDTO>>
    */
    @ApiOperation(value = "delete_categories", tags = {"排期" },  notes = "ProductPlan-delete_categories ")
    @PostMapping("products/{productId}/product_plans/{id}/delete_categories")
    public Mono<ResponseEntity<ResponseWrapper<ProductPlanDTO>>>deleteCategoriesByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteCategoriesByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteCategoriesByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_categories 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO deleteCategoriesByProductIdAndId
            (String productId, String id, ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductPlan rt = productPlanService.deleteCategories(domain);
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * product_plan_relation_idea 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductPlanDTO>>
    */
    @ApiOperation(value = "product_plan_relation_idea", tags = {"排期" },  notes = "ProductPlan-product_plan_relation_idea ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-product_plan_relation_idea-all') or hasPermission('product',#productId,this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-product_plan_relation_idea')")
    @PutMapping("products/{productId}/product_plans/{id}/product_plan_relation_idea")
    public Mono<ResponseEntity<ResponseWrapper<ProductPlanDTO>>>productPlanRelationIdeaByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productPlanRelationIdeaByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productPlanRelationIdeaByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * product_plan_relation_idea 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO productPlanRelationIdeaByProductIdAndId
            (String productId, String id, ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductPlan rt = productPlanService.productPlanRelationIdea(domain);
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductPlanDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"排期" },  notes = "ProductPlan-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Save-all') or hasPermission('product',#productId,this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-Save')")
    @PostMapping("products/{productId}/product_plans/save")
    public Mono<ResponseEntity<ResponseWrapper<ProductPlanDTO>>>saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO saveByProductId
            (String productId, ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        productPlanService.save(domain);
        ProductPlan rt = domain;
        return productPlanDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<ProductPlanDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"排期" },  notes = "ProductPlan-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Get-all')  or hasPermission('product',#productId,this.productPlanDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProductPlan-Get')")
    @GetMapping("products/{productId}/product_plans/{id}")
    public Mono<ResponseEntity<ProductPlanDTO>> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        ProductPlan rt = productPlanService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productPlanDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"排期" },  notes = "ProductPlan-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Remove-all') or hasPermission('product',#productId,this.productPlanService.get(#id),'ibizplm-ProductPlan-Remove')")
    @DeleteMapping("products/{productId}/product_plans/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = productPlanService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"排期" },  notes = "ProductPlan-CheckKey ")
    @PostMapping("products/{productId}/product_plans/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        CheckKeyStatus rt = productPlanService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductPlanDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"排期" },  notes = "ProductPlan-GetDraft ")
    @GetMapping("products/{productId}/product_plans/get_draft")
    public Mono<ResponseEntity<ProductPlanDTO>> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ProductPlan rt = productPlanService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productPlanDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"排期" },  notes = "ProductPlan-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-ProductPlan-fetch_default')")
    @PostMapping("products/{productId}/product_plans/fetch_default")
    public Mono<ResponseEntity<List<ProductPlanDTO>>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductPlanFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductPlanSearchContext context = productPlanFilterDtoMapping.toDomain(dto);
        Page<ProductPlan> domains = productPlanService.fetchDefault(context) ;
        List<ProductPlanDTO> list = productPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductPlanDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"排期" },  notes = "ProductPlan-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-fetch_normal-all') or hasPermission('product',#productId,#dto,'ibizplm-ProductPlan-fetch_normal')")
    @PostMapping("products/{productId}/product_plans/fetch_normal")
    public Mono<ResponseEntity<List<ProductPlanDTO>>> fetchNormalByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductPlanFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductPlanSearchContext context = productPlanFilterDtoMapping.toDomain(dto);
        Page<ProductPlan> domains = productPlanService.fetchNormal(context) ;
        List<ProductPlanDTO> list = productPlanDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


}
