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
    * Activate 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "Activate", tags = {"产品" },  notes = "Product-Activate ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Activate-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Activate')")
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
    * Activate 产品
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
    * Archive 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "Archive", tags = {"产品" },  notes = "Product-Archive ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Archive-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Archive')")
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
    * Archive 产品
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
    * Delete 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "Delete", tags = {"产品" },  notes = "Product-Delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Delete-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Delete')")
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
    * Delete 产品
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
    * Favorite 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "Favorite", tags = {"产品" },  notes = "Product-Favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Favorite-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Favorite')")
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
    * Favorite 产品
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
    * Other_re_space 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "Other_re_space", tags = {"产品" },  notes = "Product-Other_re_space ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Other_re_space-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Other_re_space')")
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
    * Other_re_space 产品
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
    * Product_counters 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "Product_counters", tags = {"产品" },  notes = "Product-Product_counters ")
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
    * Product_counters 产品
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
    * Recover 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "Recover", tags = {"产品" },  notes = "Product-Recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Recover-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Recover')")
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
    * Recover 产品
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
    * Un_favorite 产品
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductDTO>
    */
    @ApiOperation(value = "Un_favorite", tags = {"产品" },  notes = "Product-Un_favorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-Un_favorite-all') or hasPermission(this.productDtoMapping.toDomain(#dto),'ibizplm-Product-Un_favorite')")
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
    * Un_favorite 产品
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
    @PostMapping("products/checkkey")
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
    @GetMapping("products/getdraft")
    public ResponseEntity<ProductDTO> getDraft
            (@SpringQueryMap ProductDTO dto) {
        Product domain = productDtoMapping.toDomain(dto);
        Product rt = productService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchAdmin 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询FetchAdmin", tags = {"产品" },  notes = "Product-FetchAdmin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-FetchAdmin-all') or hasPermission(#dto,'ibizplm-Product-FetchAdmin')")
    @PostMapping("products/fetchadmin")
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
    * 查询FetchArchived 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询FetchArchived", tags = {"产品" },  notes = "Product-FetchArchived ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-FetchArchived-all') or hasPermission(#dto,'ibizplm-Product-FetchArchived')")
    @PostMapping("products/fetcharchived")
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
    * 查询FetchDefault 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"产品" },  notes = "Product-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-FetchDefault-all') or hasPermission(#dto,'ibizplm-Product-FetchDefault')")
    @PostMapping("products/fetchdefault")
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
    * 查询FetchDeleted 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询FetchDeleted", tags = {"产品" },  notes = "Product-FetchDeleted ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-FetchDeleted-all') or hasPermission(#dto,'ibizplm-Product-FetchDeleted')")
    @PostMapping("products/fetchdeleted")
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
    * 查询FetchFavorite 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询FetchFavorite", tags = {"产品" },  notes = "Product-FetchFavorite ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-FetchFavorite-all') or hasPermission(#dto,'ibizplm-Product-FetchFavorite')")
    @PostMapping("products/fetchfavorite")
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
    * 查询FetchNormal 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"产品" },  notes = "Product-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-FetchNormal-all') or hasPermission(#dto,'ibizplm-Product-FetchNormal')")
    @PostMapping("products/fetchnormal")
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
    * 查询FetchReader 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询FetchReader", tags = {"产品" },  notes = "Product-FetchReader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-FetchReader-all') or hasPermission(#dto,'ibizplm-Product-FetchReader')")
    @PostMapping("products/fetchreader")
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
    * 查询FetchUser 产品
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductDTO>>
    */
    @ApiOperation(value = "查询FetchUser", tags = {"产品" },  notes = "Product-FetchUser ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Product-FetchUser-all') or hasPermission(#dto,'ibizplm-Product-FetchUser')")
    @PostMapping("products/fetchuser")
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
