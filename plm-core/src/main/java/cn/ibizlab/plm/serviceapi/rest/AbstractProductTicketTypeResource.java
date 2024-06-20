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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.service.ProductTicketTypeService;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTicketTypeSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[ProductTicketType] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductTicketTypeResource {

    @Autowired
    public ProductTicketTypeService productTicketTypeService;

    @Autowired
    @Lazy
    public ProductTicketTypeDTOMapping productTicketTypeDtoMapping;

    @Autowired
    @Lazy
    public ProductTicketTypeFilterDTOMapping productTicketTypeFilterDtoMapping;

    /**
    * 创建Create 产品工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"产品工单类型" },  notes = "ProductTicketType-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Create-all') or hasPermission(this.productTicketTypeDtoMapping.toDomain(#dto),'ibizplm-ProductTicketType-Create')")
    @PostMapping("product_ticket_types")
    public ResponseEntity<ResponseWrapper<ProductTicketTypeDTO>> create
            (@Validated @RequestBody RequestWrapper<ProductTicketTypeDTO> dto) {
        ResponseWrapper<ProductTicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 产品工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */   
    public ProductTicketTypeDTO create
            (ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        productTicketTypeService.create(domain);
        ProductTicketType rt = domain;
        return productTicketTypeDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 产品工单类型
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"产品工单类型" },  notes = "ProductTicketType-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Update-all') or hasPermission(this.productTicketTypeService.get(#id),'ibizplm-ProductTicketType-Update')")
    @VersionCheck(entity = "producttickettype" , versionfield = "updateTime")
    @PutMapping("product_ticket_types/{id}")
    public ResponseEntity<ResponseWrapper<ProductTicketTypeDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductTicketTypeDTO> dto) {
        ResponseWrapper<ProductTicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 产品工单类型
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */   
    public ProductTicketTypeDTO updateById
            (String id, ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        domain.setId(id);
        productTicketTypeService.update(domain);
        ProductTicketType rt = domain;
        return productTicketTypeDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"产品工单类型" },  notes = "ProductTicketType-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Save-all') or hasPermission(this.productTicketTypeDtoMapping.toDomain(#dto),'ibizplm-ProductTicketType-Save')")
    @PostMapping("product_ticket_types/save")
    public ResponseEntity<ResponseWrapper<ProductTicketTypeDTO>> save
            (@Validated @RequestBody RequestWrapper<ProductTicketTypeDTO> dto) {
        ResponseWrapper<ProductTicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 产品工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */   
    public ProductTicketTypeDTO save
            (ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        productTicketTypeService.save(domain);
        ProductTicketType rt = domain;
        return productTicketTypeDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 产品工单类型
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"产品工单类型" },  notes = "ProductTicketType-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Create-all') or hasPermission('product',#productId,this.productTicketTypeDtoMapping.toDomain(#dto),'ibizplm-ProductTicketType-Create')")
    @PostMapping("products/{productId}/product_ticket_types")
    public ResponseEntity<ResponseWrapper<ProductTicketTypeDTO>> createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductTicketTypeDTO> dto) {
        ResponseWrapper<ProductTicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 产品工单类型
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */   
    public ProductTicketTypeDTO createByProductId
            (String productId, ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        productTicketTypeService.create(domain);
        ProductTicketType rt = domain;
        return productTicketTypeDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 产品工单类型
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"产品工单类型" },  notes = "ProductTicketType-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Update-all') or hasPermission('product',#productId,this.productTicketTypeService.get(#id),'ibizplm-ProductTicketType-Update')")
    @VersionCheck(entity = "producttickettype" , versionfield = "updateTime")
    @PutMapping("products/{productId}/product_ticket_types/{id}")
    public ResponseEntity<ResponseWrapper<ProductTicketTypeDTO>> updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductTicketTypeDTO> dto) {
        ResponseWrapper<ProductTicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 产品工单类型
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */   
    public ProductTicketTypeDTO updateByProductIdAndId
            (String productId, String id, ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        domain.setId(id);
        productTicketTypeService.update(domain);
        ProductTicketType rt = domain;
        return productTicketTypeDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品工单类型
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"产品工单类型" },  notes = "ProductTicketType-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Save-all') or hasPermission('product',#productId,this.productTicketTypeDtoMapping.toDomain(#dto),'ibizplm-ProductTicketType-Save')")
    @PostMapping("products/{productId}/product_ticket_types/save")
    public ResponseEntity<ResponseWrapper<ProductTicketTypeDTO>> saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductTicketTypeDTO> dto) {
        ResponseWrapper<ProductTicketTypeDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 产品工单类型
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */   
    public ProductTicketTypeDTO saveByProductId
            (String productId, ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        productTicketTypeService.save(domain);
        ProductTicketType rt = domain;
        return productTicketTypeDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 产品工单类型
    * 
    *
    * @param id id
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"产品工单类型" },  notes = "ProductTicketType-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Get-all')  or hasPermission(this.productTicketTypeDtoMapping.toDomain(returnObject.body),'ibizplm-ProductTicketType-Get')")
    @GetMapping("product_ticket_types/{id}")
    public ResponseEntity<ProductTicketTypeDTO> getById
            (@PathVariable("id") String id) {
        ProductTicketType rt = productTicketTypeService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(productTicketTypeDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 产品工单类型
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品工单类型" },  notes = "ProductTicketType-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Remove-all') or hasPermission(this.productTicketTypeService.get(#id),'ibizplm-ProductTicketType-Remove')")
    @DeleteMapping("product_ticket_types/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = productTicketTypeService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 产品工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品工单类型" },  notes = "ProductTicketType-CheckKey ")
    @PostMapping("product_ticket_types/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        Integer rt = productTicketTypeService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 产品工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品工单类型" },  notes = "ProductTicketType-GetDraft ")
    @GetMapping("product_ticket_types/get_draft")
    public ResponseEntity<ProductTicketTypeDTO> getDraft
            (@SpringQueryMap ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        ProductTicketType rt = productTicketTypeService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productTicketTypeDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 产品工单类型
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductTicketTypeDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品工单类型" },  notes = "ProductTicketType-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-fetch_default-all') or hasPermission(#dto,'ibizplm-ProductTicketType-fetch_default')")
    @PostMapping("product_ticket_types/fetch_default")
    public ResponseEntity<List<ProductTicketTypeDTO>> fetchDefault
            (@Validated @RequestBody ProductTicketTypeFilterDTO dto) {
        ProductTicketTypeSearchContext context = productTicketTypeFilterDtoMapping.toDomain(dto);
        Page<ProductTicketType> domains = productTicketTypeService.fetchDefault(context) ;
        List<ProductTicketTypeDTO> list = productTicketTypeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 产品工单类型
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"产品工单类型" },  notes = "ProductTicketType-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Get-all')  or hasPermission('product',#productId,this.productTicketTypeDtoMapping.toDomain(returnObject.body),'ibizplm-ProductTicketType-Get')")
    @GetMapping("products/{productId}/product_ticket_types/{id}")
    public ResponseEntity<ProductTicketTypeDTO> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        ProductTicketType rt = productTicketTypeService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(productTicketTypeDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 产品工单类型
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品工单类型" },  notes = "ProductTicketType-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-Remove-all') or hasPermission('product',#productId,this.productTicketTypeService.get(#id),'ibizplm-ProductTicketType-Remove')")
    @DeleteMapping("products/{productId}/product_ticket_types/{id}")
    public ResponseEntity<Boolean> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = productTicketTypeService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 产品工单类型
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品工单类型" },  notes = "ProductTicketType-CheckKey ")
    @PostMapping("products/{productId}/product_ticket_types/check_key")
    public ResponseEntity<Integer> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Integer rt = productTicketTypeService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 产品工单类型
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductTicketTypeDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品工单类型" },  notes = "ProductTicketType-GetDraft ")
    @GetMapping("products/{productId}/product_ticket_types/get_draft")
    public ResponseEntity<ProductTicketTypeDTO> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap ProductTicketTypeDTO dto) {
        ProductTicketType domain = productTicketTypeDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ProductTicketType rt = productTicketTypeService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productTicketTypeDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 产品工单类型
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<ProductTicketTypeDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品工单类型" },  notes = "ProductTicketType-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTicketType-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-ProductTicketType-fetch_default')")
    @PostMapping("products/{productId}/product_ticket_types/fetch_default")
    public ResponseEntity<List<ProductTicketTypeDTO>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductTicketTypeFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductTicketTypeSearchContext context = productTicketTypeFilterDtoMapping.toDomain(dto);
        Page<ProductTicketType> domains = productTicketTypeService.fetchDefault(context) ;
        List<ProductTicketTypeDTO> list = productTicketTypeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建产品工单类型
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTicketType-Create-all')")
    @ApiOperation(value = "批量新建产品工单类型", tags = {"产品工单类型" },  notes = "批量新建产品工单类型")
	@PostMapping("product_ticket_types/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ProductTicketTypeDTO> dtos) {
        productTicketTypeService.create(productTicketTypeDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除产品工单类型
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTicketType-Remove-all')")
    @ApiOperation(value = "批量删除产品工单类型", tags = {"产品工单类型" },  notes = "批量删除产品工单类型")
	@DeleteMapping("product_ticket_types/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        productTicketTypeService.remove(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新产品工单类型
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTicketType-Update-all')")
    @ApiOperation(value = "批量更新产品工单类型", tags = {"产品工单类型" },  notes = "批量更新产品工单类型")
	@PutMapping("product_ticket_types/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ProductTicketTypeDTO> dtos) {
        productTicketTypeService.update(productTicketTypeDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存产品工单类型
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTicketType-Save-all')")
    @ApiOperation(value = "批量保存产品工单类型", tags = {"产品工单类型" },  notes = "批量保存产品工单类型")
	@PostMapping("product_ticket_types/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ProductTicketTypeDTO> dtos) {
        productTicketTypeService.save(productTicketTypeDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入产品工单类型
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTicketType-Save-all')")
    @ApiOperation(value = "批量导入产品工单类型", tags = {"产品工单类型" },  notes = "批量导入产品工单类型")
	@PostMapping("product_ticket_types/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProductTicketTypeDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(productTicketTypeService.importData(config,ignoreError,productTicketTypeDtoMapping.toDomain(dtos)));
    }

}
