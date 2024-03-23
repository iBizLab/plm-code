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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.service.ProductPlanService;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductPlanSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"排期" },  notes = "ProductPlan-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Create-all') or hasPermission(this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-Create')")
    @PostMapping("product_plans")
    public ResponseEntity<ResponseWrapper<ProductPlanDTO>> create
            (@Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 排期
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO create
            (ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        productPlanService.create(domain);
        ProductPlan rt = domain;
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 排期
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"排期" },  notes = "ProductPlan-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Update-all') or hasPermission(this.productPlanService.get(#id),'ibizplm-ProductPlan-Update')")
    @VersionCheck(entity = "productplan" , versionfield = "updateTime")
    @PutMapping("product_plans/{id}")
    public ResponseEntity<ResponseWrapper<ProductPlanDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 排期
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO updateById
            (String id, ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        productPlanService.update(domain);
        ProductPlan rt = domain;
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * Delete 排期
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "Delete", tags = {"排期" },  notes = "ProductPlan-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Delete-all') or hasPermission(this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-Delete')")
    @PostMapping("product_plans/{id}/delete")
    public ResponseEntity<ResponseWrapper<ProductPlanDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 排期
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO deleteById
            (String id, ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductPlan rt = productPlanService.delete(domain);
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 排期
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"排期" },  notes = "ProductPlan-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Save-all') or hasPermission(this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-Save')")
    @PostMapping("product_plans/save")
    public ResponseEntity<ResponseWrapper<ProductPlanDTO>> save
            (@Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 排期
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */   
    public ProductPlanDTO save
            (ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        productPlanService.save(domain);
        ProductPlan rt = domain;
        return productPlanDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"排期" },  notes = "ProductPlan-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Create-all') or hasPermission('Product',#productId,this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-Create')")
    @PostMapping("products/{productId}/product_plans")
    public ResponseEntity<ResponseWrapper<ProductPlanDTO>> createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"排期" },  notes = "ProductPlan-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Update-all') or hasPermission('Product',#productId,this.productPlanService.get(#id),'ibizplm-ProductPlan-Update')")
    @VersionCheck(entity = "productplan" , versionfield = "updateTime")
    @PutMapping("products/{productId}/product_plans/{id}")
    public ResponseEntity<ResponseWrapper<ProductPlanDTO>> updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * Delete 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "Delete", tags = {"排期" },  notes = "ProductPlan-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Delete-all') or hasPermission('Product',#productId,this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-Delete')")
    @PostMapping("products/{productId}/product_plans/{id}/delete")
    public ResponseEntity<ResponseWrapper<ProductPlanDTO>> deleteByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete 排期
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
    * 保存Save 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"排期" },  notes = "ProductPlan-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Save-all') or hasPermission('Product',#productId,this.productPlanDtoMapping.toDomain(#dto),'ibizplm-ProductPlan-Save')")
    @PostMapping("products/{productId}/product_plans/save")
    public ResponseEntity<ResponseWrapper<ProductPlanDTO>> saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductPlanDTO> dto) {
        ResponseWrapper<ProductPlanDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @param id id
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"排期" },  notes = "ProductPlan-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Get-all')  or hasPermission(this.productPlanDtoMapping.toDomain(returnObject.body),'ibizplm-ProductPlan-Get')")
    @GetMapping("product_plans/{id}")
    public ResponseEntity<ProductPlanDTO> getById
            (@PathVariable("id") String id) {
        ProductPlan rt = productPlanService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(productPlanDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 排期
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"排期" },  notes = "ProductPlan-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Remove-all') or hasPermission(this.productPlanService.get(#id),'ibizplm-ProductPlan-Remove')")
    @DeleteMapping("product_plans/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = productPlanService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 排期
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"排期" },  notes = "ProductPlan-CheckKey ")
    @PostMapping("product_plans/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        Integer rt = productPlanService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 排期
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"排期" },  notes = "ProductPlan-GetDraft ")
    @GetMapping("product_plans/getdraft")
    public ResponseEntity<ProductPlanDTO> getDraft
            (@SpringQueryMap ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        ProductPlan rt = productPlanService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productPlanDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 排期
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductPlanDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"排期" },  notes = "ProductPlan-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-FetchDefault-all') or hasPermission(#dto,'ibizplm-ProductPlan-FetchDefault')")
    @PostMapping("product_plans/fetchdefault")
    public ResponseEntity<List<ProductPlanDTO>> fetchDefault
            (@Validated @RequestBody ProductPlanFilterDTO dto) {
        ProductPlanSearchContext context = productPlanFilterDtoMapping.toDomain(dto);
        Page<ProductPlan> domains = productPlanService.searchDefault(context) ;
        List<ProductPlanDTO> list = productPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 排期
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductPlanDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"排期" },  notes = "ProductPlan-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-FetchNormal-all') or hasPermission(#dto,'ibizplm-ProductPlan-FetchNormal')")
    @PostMapping("product_plans/fetchnormal")
    public ResponseEntity<List<ProductPlanDTO>> fetchNormal
            (@Validated @RequestBody ProductPlanFilterDTO dto) {
        ProductPlanSearchContext context = productPlanFilterDtoMapping.toDomain(dto);
        Page<ProductPlan> domains = productPlanService.searchNormal(context) ;
        List<ProductPlanDTO> list = productPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"排期" },  notes = "ProductPlan-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Get-all')  or hasPermission('Product',#productId,this.productPlanDtoMapping.toDomain(returnObject.body),'ibizplm-ProductPlan-Get')")
    @GetMapping("products/{productId}/product_plans/{id}")
    public ResponseEntity<ProductPlanDTO> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        ProductPlan rt = productPlanService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(productPlanDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 排期
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"排期" },  notes = "ProductPlan-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-Remove-all') or hasPermission('Product',#productId,this.productPlanService.get(#id),'ibizplm-ProductPlan-Remove')")
    @DeleteMapping("products/{productId}/product_plans/{id}")
    public ResponseEntity<Boolean> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = productPlanService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"排期" },  notes = "ProductPlan-CheckKey ")
    @PostMapping("products/{productId}/product_plans/checkkey")
    public ResponseEntity<Integer> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Integer rt = productPlanService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductPlanDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"排期" },  notes = "ProductPlan-GetDraft ")
    @GetMapping("products/{productId}/product_plans/getdraft")
    public ResponseEntity<ProductPlanDTO> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap ProductPlanDTO dto) {
        ProductPlan domain = productPlanDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ProductPlan rt = productPlanService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productPlanDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<ProductPlanDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"排期" },  notes = "ProductPlan-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-FetchDefault-all') or hasPermission('Product',#productId,#dto,'ibizplm-ProductPlan-FetchDefault')")
    @PostMapping("products/{productId}/product_plans/fetchdefault")
    public ResponseEntity<List<ProductPlanDTO>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductPlanFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductPlanSearchContext context = productPlanFilterDtoMapping.toDomain(dto);
        Page<ProductPlan> domains = productPlanService.searchDefault(context) ;
        List<ProductPlanDTO> list = productPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 排期
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<ProductPlanDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"排期" },  notes = "ProductPlan-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductPlan-FetchNormal-all') or hasPermission('Product',#productId,#dto,'ibizplm-ProductPlan-FetchNormal')")
    @PostMapping("products/{productId}/product_plans/fetchnormal")
    public ResponseEntity<List<ProductPlanDTO>> fetchNormalByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductPlanFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductPlanSearchContext context = productPlanFilterDtoMapping.toDomain(dto);
        Page<ProductPlan> domains = productPlanService.searchNormal(context) ;
        List<ProductPlanDTO> list = productPlanDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建排期
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductPlan-Create-all')")
    @ApiOperation(value = "批量新建排期", tags = {"排期" },  notes = "批量新建排期")
	@PostMapping("product_plans/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ProductPlanDTO> dtos) {
        productPlanService.createBatch(productPlanDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除排期
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductPlan-Remove-all')")
    @ApiOperation(value = "批量删除排期", tags = {"排期" },  notes = "批量删除排期")
	@DeleteMapping("product_plans/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        productPlanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新排期
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductPlan-Update-all')")
    @ApiOperation(value = "批量更新排期", tags = {"排期" },  notes = "批量更新排期")
	@PutMapping("product_plans/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ProductPlanDTO> dtos) {
        productPlanService.updateBatch(productPlanDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存排期
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductPlan-Save-all')")
    @ApiOperation(value = "批量保存排期", tags = {"排期" },  notes = "批量保存排期")
	@PostMapping("product_plans/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ProductPlanDTO> dtos) {
        productPlanService.saveBatch(productPlanDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入排期
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductPlan-Save-all')")
    @ApiOperation(value = "批量导入排期", tags = {"排期" },  notes = "批量导入排期")
	@PostMapping("product_plans/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProductPlanDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(productPlanService.importData(config,ignoreError,productPlanDtoMapping.toDomain(dtos)));
    }

}
