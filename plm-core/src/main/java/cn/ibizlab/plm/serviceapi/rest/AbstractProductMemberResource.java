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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.service.ProductMemberService;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[ProductMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProductMemberResource {

    @Autowired
    public ProductMemberService productMemberService;

    @Autowired
    @Lazy
    public ProductMemberDTOMapping productMemberDtoMapping;

    @Autowired
    @Lazy
    public ProductMemberFilterDTOMapping productMemberFilterDtoMapping;

    /**
    * 创建Create 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"产品成员" },  notes = "ProductMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create')")
    @PostMapping("product_members")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> create
            (@Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO create
            (ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        productMemberService.create(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 产品成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"产品成员" },  notes = "ProductMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Update-all') or hasPermission(this.productMemberService.get(#id),'ibizplm-ProductMember-Update')")
    @VersionCheck(entity = "productmember" , versionfield = "updateTime")
    @PutMapping("product_members/{id}")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 产品成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO updateById
            (String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        productMemberService.update(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_product_member 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "Create_product_member", tags = {"产品成员" },  notes = "ProductMember-Create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create_product_member-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create_product_member')")
    @PostMapping("product_members/create_product_member")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> createProductMember
            (@Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createProductMember(item)));
        else
            rt.set(createProductMember(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_product_member 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO createProductMember
            (ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        ProductMember rt = productMemberService.createProductMember(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"产品成员" },  notes = "ProductMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Save-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Save')")
    @PostMapping("product_members/save")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> save
            (@Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO save
            (ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        productMemberService.save(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"产品成员" },  notes = "ProductMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create-all') or hasPermission('Product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create')")
    @PostMapping("products/{productId}/product_members")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO createByProductId
            (String productId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        productMemberService.create(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"产品成员" },  notes = "ProductMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Update-all') or hasPermission('Product',#productId,this.productMemberService.get(#id),'ibizplm-ProductMember-Update')")
    @VersionCheck(entity = "productmember" , versionfield = "updateTime")
    @PutMapping("products/{productId}/product_members/{id}")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO updateByProductIdAndId
            (String productId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        productMemberService.update(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_product_member 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "Create_product_member", tags = {"产品成员" },  notes = "ProductMember-Create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create_product_member-all') or hasPermission('Product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create_product_member')")
    @PostMapping("products/{productId}/product_members/create_product_member")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> createProductMemberByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createProductMemberByProductId(productId, item)));
        else
            rt.set(createProductMemberByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_product_member 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO createProductMemberByProductId
            (String productId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ProductMember rt = productMemberService.createProductMember(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"产品成员" },  notes = "ProductMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Save-all') or hasPermission('Product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Save')")
    @PostMapping("products/{productId}/product_members/save")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO saveByProductId
            (String productId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        productMemberService.save(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"产品成员" },  notes = "ProductMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create-all') or hasPermission('User',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create')")
    @PostMapping("users/{userId}/product_members")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> createByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByUserId(userId, item)));
        else
            rt.set(createByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO createByUserId
            (String userId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        productMemberService.create(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"产品成员" },  notes = "ProductMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Update-all') or hasPermission('User',#userId,this.productMemberService.get(#id),'ibizplm-ProductMember-Update')")
    @VersionCheck(entity = "productmember" , versionfield = "updateTime")
    @PutMapping("users/{userId}/product_members/{id}")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> updateByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByUserIdAndId(userId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO updateByUserIdAndId
            (String userId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        productMemberService.update(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * Create_product_member 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "Create_product_member", tags = {"产品成员" },  notes = "ProductMember-Create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create_product_member-all') or hasPermission('User',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create_product_member')")
    @PostMapping("users/{userId}/product_members/create_product_member")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> createProductMemberByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createProductMemberByUserId(userId, item)));
        else
            rt.set(createProductMemberByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Create_product_member 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO createProductMemberByUserId
            (String userId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        ProductMember rt = productMemberService.createProductMember(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"产品成员" },  notes = "ProductMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Save-all') or hasPermission('User',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Save')")
    @PostMapping("users/{userId}/product_members/save")
    public ResponseEntity<ResponseWrapper<ProductMemberDTO>> saveByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByUserId(userId, item)));
        else
            rt.set(saveByUserId(userId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO saveByUserId
            (String userId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        productMemberService.save(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 产品成员
    * 
    *
    * @param id id
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"产品成员" },  notes = "ProductMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Get-all')  or hasPermission(this.productMemberDtoMapping.toDomain(returnObject.body),'ibizplm-ProductMember-Get')")
    @GetMapping("product_members/{id}")
    public ResponseEntity<ProductMemberDTO> getById
            (@PathVariable("id") String id) {
        ProductMember rt = productMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 产品成员
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品成员" },  notes = "ProductMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Remove-all') or hasPermission(this.productMemberService.get(#id),'ibizplm-ProductMember-Remove')")
    @DeleteMapping("product_members/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = productMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品成员" },  notes = "ProductMember-CheckKey ")
    @PostMapping("product_members/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        Integer rt = productMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品成员" },  notes = "ProductMember-GetDraft ")
    @GetMapping("product_members/getdraft")
    public ResponseEntity<ProductMemberDTO> getDraft
            (@SpringQueryMap ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        ProductMember rt = productMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_product 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_product", tags = {"产品成员" },  notes = "ProductMember-FetchCur_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-FetchCur_product-all') or hasPermission(#dto,'ibizplm-ProductMember-FetchCur_product')")
    @PostMapping("product_members/fetchcur_product")
    public ResponseEntity<List<ProductMemberDTO>> fetchCurProduct
            (@Validated @RequestBody ProductMemberFilterDTO dto) {
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.searchCurProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ProductMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"产品成员" },  notes = "ProductMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-FetchDefault-all') or hasPermission(#dto,'ibizplm-ProductMember-FetchDefault')")
    @PostMapping("product_members/fetchdefault")
    public ResponseEntity<List<ProductMemberDTO>> fetchDefault
            (@Validated @RequestBody ProductMemberFilterDTO dto) {
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.searchDefault(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"产品成员" },  notes = "ProductMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Get-all')  or hasPermission('Product',#productId,this.productMemberDtoMapping.toDomain(returnObject.body),'ibizplm-ProductMember-Get')")
    @GetMapping("products/{productId}/product_members/{id}")
    public ResponseEntity<ProductMemberDTO> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        ProductMember rt = productMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品成员" },  notes = "ProductMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Remove-all') or hasPermission('Product',#productId,this.productMemberService.get(#id),'ibizplm-ProductMember-Remove')")
    @DeleteMapping("products/{productId}/product_members/{id}")
    public ResponseEntity<Boolean> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = productMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品成员" },  notes = "ProductMember-CheckKey ")
    @PostMapping("products/{productId}/product_members/checkkey")
    public ResponseEntity<Integer> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Integer rt = productMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品成员" },  notes = "ProductMember-GetDraft ")
    @GetMapping("products/{productId}/product_members/getdraft")
    public ResponseEntity<ProductMemberDTO> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ProductMember rt = productMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_product 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<ProductMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_product", tags = {"产品成员" },  notes = "ProductMember-FetchCur_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-FetchCur_product-all') or hasPermission('Product',#productId,#dto,'ibizplm-ProductMember-FetchCur_product')")
    @PostMapping("products/{productId}/product_members/fetchcur_product")
    public ResponseEntity<List<ProductMemberDTO>> fetchCurProductByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.searchCurProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<ProductMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"产品成员" },  notes = "ProductMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-FetchDefault-all') or hasPermission('Product',#productId,#dto,'ibizplm-ProductMember-FetchDefault')")
    @PostMapping("products/{productId}/product_members/fetchdefault")
    public ResponseEntity<List<ProductMemberDTO>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.searchDefault(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"产品成员" },  notes = "ProductMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Get-all')  or hasPermission('User',#userId,this.productMemberDtoMapping.toDomain(returnObject.body),'ibizplm-ProductMember-Get')")
    @GetMapping("users/{userId}/product_members/{id}")
    public ResponseEntity<ProductMemberDTO> getByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        ProductMember rt = productMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品成员" },  notes = "ProductMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Remove-all') or hasPermission('User',#userId,this.productMemberService.get(#id),'ibizplm-ProductMember-Remove')")
    @DeleteMapping("users/{userId}/product_members/{id}")
    public ResponseEntity<Boolean> removeByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = productMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品成员" },  notes = "ProductMember-CheckKey ")
    @PostMapping("users/{userId}/product_members/checkkey")
    public ResponseEntity<Integer> checkKeyByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        Integer rt = productMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品成员" },  notes = "ProductMember-GetDraft ")
    @GetMapping("users/{userId}/product_members/getdraft")
    public ResponseEntity<ProductMemberDTO> getDraftByUserId
            (@PathVariable("userId") String userId, @SpringQueryMap ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        ProductMember rt = productMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchCur_product 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<ProductMemberDTO>>
    */
    @ApiOperation(value = "查询FetchCur_product", tags = {"产品成员" },  notes = "ProductMember-FetchCur_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-FetchCur_product-all') or hasPermission('User',#userId,#dto,'ibizplm-ProductMember-FetchCur_product')")
    @PostMapping("users/{userId}/product_members/fetchcur_product")
    public ResponseEntity<List<ProductMemberDTO>> fetchCurProductByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.searchCurProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<List<ProductMemberDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"产品成员" },  notes = "ProductMember-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-FetchDefault-all') or hasPermission('User',#userId,#dto,'ibizplm-ProductMember-FetchDefault')")
    @PostMapping("users/{userId}/product_members/fetchdefault")
    public ResponseEntity<List<ProductMemberDTO>> fetchDefaultByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.searchDefault(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建产品成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Create-all')")
    @ApiOperation(value = "批量新建产品成员", tags = {"产品成员" },  notes = "批量新建产品成员")
	@PostMapping("product_members/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ProductMemberDTO> dtos) {
        productMemberService.createBatch(productMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除产品成员
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Remove-all')")
    @ApiOperation(value = "批量删除产品成员", tags = {"产品成员" },  notes = "批量删除产品成员")
	@DeleteMapping("product_members/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        productMemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新产品成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Update-all')")
    @ApiOperation(value = "批量更新产品成员", tags = {"产品成员" },  notes = "批量更新产品成员")
	@PutMapping("product_members/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ProductMemberDTO> dtos) {
        productMemberService.updateBatch(productMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存产品成员
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Save-all')")
    @ApiOperation(value = "批量保存产品成员", tags = {"产品成员" },  notes = "批量保存产品成员")
	@PostMapping("product_members/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ProductMemberDTO> dtos) {
        productMemberService.saveBatch(productMemberDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入产品成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Save-all')")
    @ApiOperation(value = "批量导入产品成员", tags = {"产品成员" },  notes = "批量导入产品成员")
	@PostMapping("product_members/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProductMemberDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(productMemberService.importData(config,ignoreError,productMemberDtoMapping.toDomain(dtos)));
    }

}