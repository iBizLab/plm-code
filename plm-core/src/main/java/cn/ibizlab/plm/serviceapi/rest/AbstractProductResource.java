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
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Product] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductResource {

    @Autowired
    public ProductService productService;

    @Autowired
    @Lazy
    public ProductDTOMapping productDtoMapping;

    @Autowired
    @Lazy
    public ProductFilterDTOMapping productFilterDtoMapping;

    /**
    * 创建Create 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"产品" },  notes = "Product-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Create-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Create')")
    @PostMapping("products")
    public ResponseEntity<ResponseWrapper<ProductDTO>> create
            (@Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO create
            (ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        productService.create(domain);
        Product rt = domain;
        return productDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"产品" },  notes = "Product-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Update-all') or hasPermission(this.productService.get(#id),'ibizplm-Product-Update')")
    @VersionCheck(entity = "product" , versionfield = "updateTime")
    @PutMapping("products/{id}")
    public ResponseEntity<ResponseWrapper<ProductDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO updateById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        productService.update(domain);
        Product rt = domain;
        return productDtoMapping.toDto(rt);
    }

    /**
    * activate 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "activate", tags = {"产品" },  notes = "Product-activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-activate-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-activate')")
    @PostMapping("products/{id}/activate")
    public ResponseEntity<ResponseWrapper<ProductDTO>> activateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(activateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(activateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * activate 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO activateById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        Product rt = productService.activate(domain);
        return productDtoMapping.toDto(rt);
    }

    /**
    * archive 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "archive", tags = {"产品" },  notes = "Product-archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-archive-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-archive')")
    @PostMapping("products/{id}/archive")
    public ResponseEntity<ResponseWrapper<ProductDTO>> archiveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(archiveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(archiveById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * archive 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO archiveById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        Product rt = productService.archive(domain);
        return productDtoMapping.toDto(rt);
    }

    /**
    * delete 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "delete", tags = {"产品" },  notes = "Product-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-delete-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-delete')")
    @PostMapping("products/{id}/delete")
    public ResponseEntity<ResponseWrapper<ProductDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * delete 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO deleteById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        Product rt = productService.delete(domain);
        return productDtoMapping.toDto(rt);
    }

    /**
    * favorite 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "favorite", tags = {"产品" },  notes = "Product-favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-favorite-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-favorite')")
    @PostMapping("products/{id}/favorite")
    public ResponseEntity<ResponseWrapper<ProductDTO>> favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * favorite 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO favoriteById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        Product rt = productService.favorite(domain);
        return productDtoMapping.toDto(rt);
    }

    /**
    * other_re_space 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "other_re_space", tags = {"产品" },  notes = "Product-other_re_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-other_re_space-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-other_re_space')")
    @PutMapping("products/{id}/other_re_space")
    public ResponseEntity<ResponseWrapper<ProductDTO>> otherReSpaceById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(otherReSpaceById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(otherReSpaceById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * other_re_space 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO otherReSpaceById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        Product rt = productService.otherReSpace(domain);
        return productDtoMapping.toDto(rt);
    }

    /**
    * product_counters 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "product_counters", tags = {"产品" },  notes = "Product-product_counters ")
    @PostMapping("products/{id}/product_counters")
    public ResponseEntity<ResponseWrapper<ProductDTO>> productCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productCountersById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * product_counters 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO productCountersById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        Product rt = productService.productCounters(domain);
        return productDtoMapping.toDto(rt);
    }

    /**
    * recover 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "recover", tags = {"产品" },  notes = "Product-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-recover-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-recover')")
    @PostMapping("products/{id}/recover")
    public ResponseEntity<ResponseWrapper<ProductDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * recover 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO recoverById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        Product rt = productService.recover(domain);
        return productDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"产品" },  notes = "Product-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Save-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Save')")
    @PostMapping("products/save")
    public ResponseEntity<ResponseWrapper<ProductDTO>> save
            (@Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO save
            (ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        productService.save(domain);
        Product rt = domain;
        return productDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "un_favorite", tags = {"产品" },  notes = "Product-un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-un_favorite-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-un_favorite')")
    @PostMapping("products/{id}/un_favorite")
    public ResponseEntity<ResponseWrapper<ProductDTO>> unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductDTO> dto) {
        ResponseWrapper<ProductDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * un_favorite 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */   
    public ProductDTO unFavoriteById
            (String id, ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        domain.setId(id);
        Product rt = productService.unFavorite(domain);
        return productDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 产品
    * 
    *
    * @param id id
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"产品" },  notes = "Product-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Get-all')  or hasPermission(this.productDtoMapping.toDomain(returnObject.body),'ibizplm-Product-Get')")
    @GetMapping("products/{id}")
    public ResponseEntity<ProductDTO> getById
            (@PathVariable("id") String id) {
        Product rt = productService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 产品
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品" },  notes = "Product-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Remove-all') or hasPermission(this.productService.get(#id),'ibizplm-Product-Remove')")
    @DeleteMapping("products/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = productService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品" },  notes = "Product-CheckKey ")
    @PostMapping("products/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        Integer rt = productService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品" },  notes = "Product-GetDraft ")
    @GetMapping("products/get_draft")
    public ResponseEntity<ProductDTO> getDraft
            (@SpringQueryMap ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        Product rt = productService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_admin 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询fetch_admin", tags = {"产品" },  notes = "Product-fetch_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-fetch_admin-all') or hasPermission(#dto,'ibizplm-Product-fetch_admin')")
    @PostMapping("products/fetch_admin")
    public ResponseEntity<List<ProductDTO>> fetchAdmin
            (@Validated @RequestBody ProductFilterDTO dto) {
        ProductSearchContext context = productFilterDtoMapping.toDomain(dto);
        Page<Product> domains = productService.searchAdmin(context) ;
        List<ProductDTO> list = productDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_archived 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询fetch_archived", tags = {"产品" },  notes = "Product-fetch_archived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-fetch_archived-all') or hasPermission(#dto,'ibizplm-Product-fetch_archived')")
    @PostMapping("products/fetch_archived")
    public ResponseEntity<List<ProductDTO>> fetchArchived
            (@Validated @RequestBody ProductFilterDTO dto) {
        ProductSearchContext context = productFilterDtoMapping.toDomain(dto);
        Page<Product> domains = productService.searchArchived(context) ;
        List<ProductDTO> list = productDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品" },  notes = "Product-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-fetch_default-all') or hasPermission(#dto,'ibizplm-Product-fetch_default')")
    @PostMapping("products/fetch_default")
    public ResponseEntity<List<ProductDTO>> fetchDefault
            (@Validated @RequestBody ProductFilterDTO dto) {
        ProductSearchContext context = productFilterDtoMapping.toDomain(dto);
        Page<Product> domains = productService.searchDefault(context) ;
        List<ProductDTO> list = productDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_deleted 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询fetch_deleted", tags = {"产品" },  notes = "Product-fetch_deleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-fetch_deleted-all') or hasPermission(#dto,'ibizplm-Product-fetch_deleted')")
    @PostMapping("products/fetch_deleted")
    public ResponseEntity<List<ProductDTO>> fetchDeleted
            (@Validated @RequestBody ProductFilterDTO dto) {
        ProductSearchContext context = productFilterDtoMapping.toDomain(dto);
        Page<Product> domains = productService.searchDeleted(context) ;
        List<ProductDTO> list = productDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_favorite 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询fetch_favorite", tags = {"产品" },  notes = "Product-fetch_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-fetch_favorite-all') or hasPermission(#dto,'ibizplm-Product-fetch_favorite')")
    @PostMapping("products/fetch_favorite")
    public ResponseEntity<List<ProductDTO>> fetchFavorite
            (@Validated @RequestBody ProductFilterDTO dto) {
        ProductSearchContext context = productFilterDtoMapping.toDomain(dto);
        Page<Product> domains = productService.searchFavorite(context) ;
        List<ProductDTO> list = productDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"产品" },  notes = "Product-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-fetch_normal-all') or hasPermission(#dto,'ibizplm-Product-fetch_normal')")
    @PostMapping("products/fetch_normal")
    public ResponseEntity<List<ProductDTO>> fetchNormal
            (@Validated @RequestBody ProductFilterDTO dto) {
        ProductSearchContext context = productFilterDtoMapping.toDomain(dto);
        Page<Product> domains = productService.searchNormal(context) ;
        List<ProductDTO> list = productDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_reader 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"产品" },  notes = "Product-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-fetch_reader-all') or hasPermission(#dto,'ibizplm-Product-fetch_reader')")
    @PostMapping("products/fetch_reader")
    public ResponseEntity<List<ProductDTO>> fetchReader
            (@Validated @RequestBody ProductFilterDTO dto) {
        ProductSearchContext context = productFilterDtoMapping.toDomain(dto);
        Page<Product> domains = productService.searchReader(context) ;
        List<ProductDTO> list = productDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_user 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询fetch_user", tags = {"产品" },  notes = "Product-fetch_user ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-fetch_user-all') or hasPermission(#dto,'ibizplm-Product-fetch_user')")
    @PostMapping("products/fetch_user")
    public ResponseEntity<List<ProductDTO>> fetchUser
            (@Validated @RequestBody ProductFilterDTO dto) {
        ProductSearchContext context = productFilterDtoMapping.toDomain(dto);
        Page<Product> domains = productService.searchUser(context) ;
        List<ProductDTO> list = productDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建产品
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Product-Create-all')")
    @ApiOperation(value = "批量新建产品", tags = {"产品" },  notes = "批量新建产品")
	@PostMapping("products/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ProductDTO> dtos) {
        productService.createBatch(productDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除产品
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Product-Remove-all')")
    @ApiOperation(value = "批量删除产品", tags = {"产品" },  notes = "批量删除产品")
	@DeleteMapping("products/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        productService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新产品
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Product-Update-all')")
    @ApiOperation(value = "批量更新产品", tags = {"产品" },  notes = "批量更新产品")
	@PutMapping("products/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ProductDTO> dtos) {
        productService.updateBatch(productDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存产品
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Product-Save-all')")
    @ApiOperation(value = "批量保存产品", tags = {"产品" },  notes = "批量保存产品")
	@PostMapping("products/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ProductDTO> dtos) {
        productService.saveBatch(productDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入产品
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Product-Save-all')")
    @ApiOperation(value = "批量导入产品", tags = {"产品" },  notes = "批量导入产品")
	@PostMapping("products/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProductDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(productService.importData(config,ignoreError,productDtoMapping.toDomain(dtos)));
    }

}
