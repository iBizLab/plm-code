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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTag;
import cn.ibizlab.plm.core.prodmgmt.service.ProductTagService;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTagSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[ProductTag] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductTagResource {

    @Autowired
    public ProductTagService productTagService;

    @Autowired
    @Lazy
    public ProductTagDTOMapping productTagDtoMapping;

    @Autowired
    @Lazy
    public ProductTagFilterDTOMapping productTagFilterDtoMapping;

    /**
    * 创建Create 产品标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"产品标签" },  notes = "ProductTag-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Create-all') or hasPermission(this.productTagDtoMapping.toDomain(#dto),'ibizplm-ProductTag-Create')")
    @PostMapping("product_tags")
    public Mono<ResponseEntity<ResponseWrapper<ProductTagDTO>>>create
            (@Validated @RequestBody RequestWrapper<ProductTagDTO> dto) {
        ResponseWrapper<ProductTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 产品标签
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductTagDTO>
    */   
    public ProductTagDTO create
            (ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        productTagService.create(domain);
        ProductTag rt = domain;
        return productTagDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 产品标签
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"产品标签" },  notes = "ProductTag-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Update-all') or hasPermission(this.productTagService.get(#id),'ibizplm-ProductTag-Update')")
    @VersionCheck(entity = "producttag" , versionfield = "updateTime")
    @PutMapping("product_tags/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProductTagDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductTagDTO> dto) {
        ResponseWrapper<ProductTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 产品标签
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductTagDTO>
    */   
    public ProductTagDTO updateById
            (String id, ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        domain.setId(id);
        productTagService.update(domain);
        ProductTag rt = domain;
        return productTagDtoMapping.toDto(rt);
    }

    /**
    * delete_tag 产品标签
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "delete_tag", tags = {"产品标签" },  notes = "ProductTag-delete_tag ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-delete_tag-all') or hasPermission(this.productTagDtoMapping.toDomain(#dto),'ibizplm-ProductTag-delete_tag')")
    @PostMapping("product_tags/{id}/delete_tag")
    public Mono<ResponseEntity<ResponseWrapper<ProductTagDTO>>>deleteTagById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductTagDTO> dto) {
        ResponseWrapper<ProductTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteTagById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteTagById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_tag 产品标签
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductTagDTO>
    */   
    public ProductTagDTO deleteTagById
            (String id, ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductTag rt = productTagService.deleteTag(domain);
        return productTagDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"产品标签" },  notes = "ProductTag-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Save-all') or hasPermission(this.productTagDtoMapping.toDomain(#dto),'ibizplm-ProductTag-Save')")
    @PostMapping("product_tags/save")
    public Mono<ResponseEntity<ResponseWrapper<ProductTagDTO>>>save
            (@Validated @RequestBody RequestWrapper<ProductTagDTO> dto) {
        ResponseWrapper<ProductTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 产品标签
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductTagDTO>
    */   
    public ProductTagDTO save
            (ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        productTagService.save(domain);
        ProductTag rt = domain;
        return productTagDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 产品标签
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"产品标签" },  notes = "ProductTag-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Create-all') or hasPermission('product',#productId,this.productTagDtoMapping.toDomain(#dto),'ibizplm-ProductTag-Create')")
    @PostMapping("products/{productId}/product_tags")
    public Mono<ResponseEntity<ResponseWrapper<ProductTagDTO>>>createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductTagDTO> dto) {
        ResponseWrapper<ProductTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 产品标签
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductTagDTO>
    */   
    public ProductTagDTO createByProductId
            (String productId, ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        productTagService.create(domain);
        ProductTag rt = domain;
        return productTagDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 产品标签
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"产品标签" },  notes = "ProductTag-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Update-all') or hasPermission('product',#productId,this.productTagService.get(#id),'ibizplm-ProductTag-Update')")
    @VersionCheck(entity = "producttag" , versionfield = "updateTime")
    @PutMapping("products/{productId}/product_tags/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProductTagDTO>>>updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductTagDTO> dto) {
        ResponseWrapper<ProductTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 产品标签
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductTagDTO>
    */   
    public ProductTagDTO updateByProductIdAndId
            (String productId, String id, ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        domain.setId(id);
        productTagService.update(domain);
        ProductTag rt = domain;
        return productTagDtoMapping.toDto(rt);
    }

    /**
    * delete_tag 产品标签
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "delete_tag", tags = {"产品标签" },  notes = "ProductTag-delete_tag ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-delete_tag-all') or hasPermission('product',#productId,this.productTagDtoMapping.toDomain(#dto),'ibizplm-ProductTag-delete_tag')")
    @PostMapping("products/{productId}/product_tags/{id}/delete_tag")
    public Mono<ResponseEntity<ResponseWrapper<ProductTagDTO>>>deleteTagByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductTagDTO> dto) {
        ResponseWrapper<ProductTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteTagByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteTagByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete_tag 产品标签
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductTagDTO>
    */   
    public ProductTagDTO deleteTagByProductIdAndId
            (String productId, String id, ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductTag rt = productTagService.deleteTag(domain);
        return productTagDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品标签
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"产品标签" },  notes = "ProductTag-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Save-all') or hasPermission('product',#productId,this.productTagDtoMapping.toDomain(#dto),'ibizplm-ProductTag-Save')")
    @PostMapping("products/{productId}/product_tags/save")
    public Mono<ResponseEntity<ResponseWrapper<ProductTagDTO>>>saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductTagDTO> dto) {
        ResponseWrapper<ProductTagDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 产品标签
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductTagDTO>
    */   
    public ProductTagDTO saveByProductId
            (String productId, ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        productTagService.save(domain);
        ProductTag rt = domain;
        return productTagDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 产品标签
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"产品标签" },  notes = "ProductTag-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Get-all')  or hasPermission(this.productTagDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProductTag-Get')")
    @GetMapping("product_tags/{id}")
    public Mono<ResponseEntity<ProductTagDTO>> getById
            (@PathVariable("id") String id) {
        ProductTag rt = productTagService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productTagDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 产品标签
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品标签" },  notes = "ProductTag-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Remove-all') or hasPermission(this.productTagService.get(#id),'ibizplm-ProductTag-Remove')")
    @DeleteMapping("product_tags/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = productTagService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 产品标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品标签" },  notes = "ProductTag-CheckKey ")
    @PostMapping("product_tags/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        CheckKeyStatus rt = productTagService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_con_product_tag 产品标签
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "get_con_product_tag", tags = {"产品标签" },  notes = "ProductTag-get_con_product_tag ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-get_con_product_tag-all') or hasPermission(this.productTagService.get(#id),'ibizplm-ProductTag-get_con_product_tag')")
    @GetMapping("product_tags/{id}/get_con_product_tag")
    public Mono<ResponseEntity<ProductTagDTO>> getConProductTagById
            (@PathVariable("id") String id) {
        ProductTag rt = productTagService.getConProductTag(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productTagDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 产品标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品标签" },  notes = "ProductTag-GetDraft ")
    @GetMapping("product_tags/get_draft")
    public Mono<ResponseEntity<ProductTagDTO>> getDraft
            (@SpringQueryMap ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        ProductTag rt = productTagService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productTagDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_product_tag 产品标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductTagDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_product_tag", tags = {"产品标签" },  notes = "ProductTag-fetch_cur_product_tag ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-fetch_cur_product_tag-all') or hasPermission(#dto,'ibizplm-ProductTag-fetch_cur_product_tag')")
    @PostMapping("product_tags/fetch_cur_product_tag")
    public Mono<ResponseEntity<List<ProductTagDTO>>> fetchCurProductTag
            (@Validated @RequestBody ProductTagFilterDTO dto) {
        ProductTagSearchContext context = productTagFilterDtoMapping.toDomain(dto);
        Page<ProductTag> domains = productTagService.fetchCurProductTag(context) ;
        List<ProductTagDTO> list = productTagDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 产品标签
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductTagDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品标签" },  notes = "ProductTag-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-fetch_default-all') or hasPermission(#dto,'ibizplm-ProductTag-fetch_default')")
    @PostMapping("product_tags/fetch_default")
    public Mono<ResponseEntity<List<ProductTagDTO>>> fetchDefault
            (@Validated @RequestBody ProductTagFilterDTO dto) {
        ProductTagSearchContext context = productTagFilterDtoMapping.toDomain(dto);
        Page<ProductTag> domains = productTagService.fetchDefault(context) ;
        List<ProductTagDTO> list = productTagDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 产品标签
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"产品标签" },  notes = "ProductTag-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Get-all')  or hasPermission('product',#productId,this.productTagDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProductTag-Get')")
    @GetMapping("products/{productId}/product_tags/{id}")
    public Mono<ResponseEntity<ProductTagDTO>> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        ProductTag rt = productTagService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productTagDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 产品标签
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品标签" },  notes = "ProductTag-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-Remove-all') or hasPermission('product',#productId,this.productTagService.get(#id),'ibizplm-ProductTag-Remove')")
    @DeleteMapping("products/{productId}/product_tags/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = productTagService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 产品标签
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品标签" },  notes = "ProductTag-CheckKey ")
    @PostMapping("products/{productId}/product_tags/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        CheckKeyStatus rt = productTagService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * get_con_product_tag 产品标签
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "get_con_product_tag", tags = {"产品标签" },  notes = "ProductTag-get_con_product_tag ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-get_con_product_tag-all') or hasPermission('product',#productId,this.productTagService.get(#id),'ibizplm-ProductTag-get_con_product_tag')")
    @GetMapping("products/{productId}/product_tags/{id}/get_con_product_tag")
    public Mono<ResponseEntity<ProductTagDTO>> getConProductTagByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        ProductTag rt = productTagService.getConProductTag(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productTagDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 产品标签
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductTagDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品标签" },  notes = "ProductTag-GetDraft ")
    @GetMapping("products/{productId}/product_tags/get_draft")
    public Mono<ResponseEntity<ProductTagDTO>> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap ProductTagDTO dto) {
        ProductTag domain = productTagDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ProductTag rt = productTagService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productTagDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_product_tag 产品标签
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductTagDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_product_tag", tags = {"产品标签" },  notes = "ProductTag-fetch_cur_product_tag ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-fetch_cur_product_tag-all') or hasPermission('product',#productId,#dto,'ibizplm-ProductTag-fetch_cur_product_tag')")
    @PostMapping("products/{productId}/product_tags/fetch_cur_product_tag")
    public Mono<ResponseEntity<List<ProductTagDTO>>> fetchCurProductTagByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductTagFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductTagSearchContext context = productTagFilterDtoMapping.toDomain(dto);
        Page<ProductTag> domains = productTagService.fetchCurProductTag(context) ;
        List<ProductTagDTO> list = productTagDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 产品标签
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductTagDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品标签" },  notes = "ProductTag-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductTag-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-ProductTag-fetch_default')")
    @PostMapping("products/{productId}/product_tags/fetch_default")
    public Mono<ResponseEntity<List<ProductTagDTO>>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductTagFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductTagSearchContext context = productTagFilterDtoMapping.toDomain(dto);
        Page<ProductTag> domains = productTagService.fetchDefault(context) ;
        List<ProductTagDTO> list = productTagDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建产品标签
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTag-Create-all')")
    @ApiOperation(value = "批量新建产品标签", tags = {"产品标签" },  notes = "批量新建产品标签")
	@PostMapping("product_tags/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ProductTagDTO> dtos) {
        productTagService.create(productTagDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除产品标签
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTag-Remove-all')")
    @ApiOperation(value = "批量删除产品标签", tags = {"产品标签" },  notes = "批量删除产品标签")
	@DeleteMapping("product_tags/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        productTagService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新产品标签
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTag-Update-all')")
    @ApiOperation(value = "批量更新产品标签", tags = {"产品标签" },  notes = "批量更新产品标签")
	@PutMapping("product_tags/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ProductTagDTO> dtos) {
        productTagService.update(productTagDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存产品标签
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTag-Save-all')")
    @ApiOperation(value = "批量保存产品标签", tags = {"产品标签" },  notes = "批量保存产品标签")
	@PostMapping("product_tags/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ProductTagDTO> dtos) {
        productTagService.save(productTagDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入产品标签
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductTag-Save-all')")
    @ApiOperation(value = "批量导入产品标签", tags = {"产品标签" },  notes = "批量导入产品标签")
	@PostMapping("product_tags/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProductTagDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(productTagService.importData(config,ignoreError,productTagDtoMapping.toDomain(dtos))));
    }

}
