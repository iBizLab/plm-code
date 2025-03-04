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
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.service.ProductMemberService;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

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
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"产品成员" },  notes = "ProductMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create')")
    @PostMapping("product_members")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>create
            (@Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"产品成员" },  notes = "ProductMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Update-all') or hasPermission(this.productMemberService.get(#id),'ibizplm-ProductMember-Update')")
    @VersionCheck(entity = "productmember" , versionfield = "updateTime")
    @PutMapping("product_members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * change_position 产品成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "change_position", tags = {"产品成员" },  notes = "ProductMember-change_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-change_position-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-change_position')")
    @PostMapping("product_members/{id}/change_position")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>changePositionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changePositionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changePositionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_position 产品成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO changePositionById
            (String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductMember rt = productMemberService.changePosition(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 产品成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"产品成员" },  notes = "ProductMember-change_role ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-change_role-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-change_role')")
    @PostMapping("product_members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>changeRoleById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 产品成员
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO changeRoleById
            (String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductMember rt = productMemberService.changeRole(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * create_product_member 产品成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "create_product_member", tags = {"产品成员" },  notes = "ProductMember-create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-create_product_member-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-create_product_member')")
    @PostMapping("product_members/create_product_member")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>createProductMember
            (@Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createProductMember(item)));
        else
            rt.set(createProductMember(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_product_member 产品成员
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
    * mob_create_product_member 产品成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "mob_create_product_member", tags = {"产品成员" },  notes = "ProductMember-mob_create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-mob_create_product_member-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-mob_create_product_member')")
    @PostMapping("product_members/mob_create_product_member")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>mobCreateProductMember
            (@Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mobCreateProductMember(item)));
        else
            rt.set(mobCreateProductMember(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_create_product_member 产品成员
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO mobCreateProductMember
            (ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        ProductMember rt = productMemberService.mobCreateProductMember(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"产品成员" },  notes = "ProductMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Save-all') or hasPermission(this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Save')")
    @PostMapping("product_members/save")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>save
            (@Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"产品成员" },  notes = "ProductMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create-all') or hasPermission('product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create')")
    @PostMapping("products/{productId}/product_members")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"产品成员" },  notes = "ProductMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Update-all') or hasPermission('product',#productId,this.productMemberService.get(#id),'ibizplm-ProductMember-Update')")
    @VersionCheck(entity = "productmember" , versionfield = "updateTime")
    @PutMapping("products/{productId}/product_members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * change_position 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "change_position", tags = {"产品成员" },  notes = "ProductMember-change_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-change_position-all') or hasPermission('product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-change_position')")
    @PostMapping("products/{productId}/product_members/{id}/change_position")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>changePositionByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changePositionByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changePositionByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_position 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO changePositionByProductIdAndId
            (String productId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductMember rt = productMemberService.changePosition(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"产品成员" },  notes = "ProductMember-change_role ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-change_role-all') or hasPermission('product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-change_role')")
    @PostMapping("products/{productId}/product_members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>changeRoleByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByProductIdAndId(productId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO changeRoleByProductIdAndId
            (String productId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductMember rt = productMemberService.changeRole(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * create_product_member 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "create_product_member", tags = {"产品成员" },  notes = "ProductMember-create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-create_product_member-all') or hasPermission('product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-create_product_member')")
    @PostMapping("products/{productId}/product_members/create_product_member")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>createProductMemberByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createProductMemberByProductId(productId, item)));
        else
            rt.set(createProductMemberByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_product_member 产品成员
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
    * mob_create_product_member 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "mob_create_product_member", tags = {"产品成员" },  notes = "ProductMember-mob_create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-mob_create_product_member-all') or hasPermission('product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-mob_create_product_member')")
    @PostMapping("products/{productId}/product_members/mob_create_product_member")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>mobCreateProductMemberByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mobCreateProductMemberByProductId(productId, item)));
        else
            rt.set(mobCreateProductMemberByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_create_product_member 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO mobCreateProductMemberByProductId
            (String productId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ProductMember rt = productMemberService.mobCreateProductMember(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"产品成员" },  notes = "ProductMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Save-all') or hasPermission('product',#productId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Save')")
    @PostMapping("products/{productId}/product_members/save")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"产品成员" },  notes = "ProductMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create-all') or hasPermission('user',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create')")
    @PostMapping("users/{userId}/product_members")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>createByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByUserId(userId, item)));
        else
            rt.set(createByUserId(userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"产品成员" },  notes = "ProductMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Update-all') or hasPermission('user',#userId,this.productMemberService.get(#id),'ibizplm-ProductMember-Update')")
    @VersionCheck(entity = "productmember" , versionfield = "updateTime")
    @PutMapping("users/{userId}/product_members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>updateByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByUserIdAndId(userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * change_position 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "change_position", tags = {"产品成员" },  notes = "ProductMember-change_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-change_position-all') or hasPermission('user',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-change_position')")
    @PostMapping("users/{userId}/product_members/{id}/change_position")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>changePositionByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changePositionByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changePositionByUserIdAndId(userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_position 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO changePositionByUserIdAndId
            (String userId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductMember rt = productMemberService.changePosition(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"产品成员" },  notes = "ProductMember-change_role ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-change_role-all') or hasPermission('user',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-change_role')")
    @PostMapping("users/{userId}/product_members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>changeRoleByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByUserIdAndId(userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByUserIdAndId(userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO changeRoleByUserIdAndId
            (String userId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductMember rt = productMemberService.changeRole(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * create_product_member 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "create_product_member", tags = {"产品成员" },  notes = "ProductMember-create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-create_product_member-all') or hasPermission('user',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-create_product_member')")
    @PostMapping("users/{userId}/product_members/create_product_member")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>createProductMemberByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createProductMemberByUserId(userId, item)));
        else
            rt.set(createProductMemberByUserId(userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_product_member 产品成员
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
    * mob_create_product_member 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "mob_create_product_member", tags = {"产品成员" },  notes = "ProductMember-mob_create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-mob_create_product_member-all') or hasPermission('user',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-mob_create_product_member')")
    @PostMapping("users/{userId}/product_members/mob_create_product_member")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>mobCreateProductMemberByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mobCreateProductMemberByUserId(userId, item)));
        else
            rt.set(mobCreateProductMemberByUserId(userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_create_product_member 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO mobCreateProductMemberByUserId
            (String userId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        ProductMember rt = productMemberService.mobCreateProductMember(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"产品成员" },  notes = "ProductMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Save-all') or hasPermission('user',#userId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Save')")
    @PostMapping("users/{userId}/product_members/save")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>saveByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByUserId(userId, item)));
        else
            rt.set(saveByUserId(userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
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
    * 创建Create 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"产品成员" },  notes = "ProductMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Create-all') or hasPermission('department',#departmentId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Create')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>createByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByDepartmentIdAndUserId(departmentId, userId, item)));
        else
            rt.set(createByDepartmentIdAndUserId(departmentId, userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO createByDepartmentIdAndUserId
            (String departmentId, String userId, ProductMemberDTO dto) {
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
    * @param departmentId departmentId
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"产品成员" },  notes = "ProductMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Update-all') or hasPermission('department',#departmentId,this.productMemberService.get(#id),'ibizplm-ProductMember-Update')")
    @VersionCheck(entity = "productmember" , versionfield = "updateTime")
    @PutMapping("departments/{departmentId}/users/{userId}/product_members/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>updateByDepartmentIdAndUserIdAndId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByDepartmentIdAndUserIdAndId(departmentId, userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByDepartmentIdAndUserIdAndId(departmentId, userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO updateByDepartmentIdAndUserIdAndId
            (String departmentId, String userId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        productMemberService.update(domain);
        ProductMember rt = domain;
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * change_position 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "change_position", tags = {"产品成员" },  notes = "ProductMember-change_position ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-change_position-all') or hasPermission('department',#departmentId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-change_position')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/{id}/change_position")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>changePositionByDepartmentIdAndUserIdAndId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changePositionByDepartmentIdAndUserIdAndId(departmentId, userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changePositionByDepartmentIdAndUserIdAndId(departmentId, userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_position 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO changePositionByDepartmentIdAndUserIdAndId
            (String departmentId, String userId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductMember rt = productMemberService.changePosition(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * change_role 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "change_role", tags = {"产品成员" },  notes = "ProductMember-change_role ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-change_role-all') or hasPermission('department',#departmentId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-change_role')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/{id}/change_role")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>changeRoleByDepartmentIdAndUserIdAndId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(changeRoleByDepartmentIdAndUserIdAndId(departmentId, userId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(changeRoleByDepartmentIdAndUserIdAndId(departmentId, userId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * change_role 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO changeRoleByDepartmentIdAndUserIdAndId
            (String departmentId, String userId, String id, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        ProductMember rt = productMemberService.changeRole(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * create_product_member 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "create_product_member", tags = {"产品成员" },  notes = "ProductMember-create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-create_product_member-all') or hasPermission('department',#departmentId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-create_product_member')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/create_product_member")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>createProductMemberByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createProductMemberByDepartmentIdAndUserId(departmentId, userId, item)));
        else
            rt.set(createProductMemberByDepartmentIdAndUserId(departmentId, userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * create_product_member 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO createProductMemberByDepartmentIdAndUserId
            (String departmentId, String userId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        ProductMember rt = productMemberService.createProductMember(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * mob_create_product_member 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "mob_create_product_member", tags = {"产品成员" },  notes = "ProductMember-mob_create_product_member ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-mob_create_product_member-all') or hasPermission('department',#departmentId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-mob_create_product_member')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/mob_create_product_member")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>mobCreateProductMemberByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(mobCreateProductMemberByDepartmentIdAndUserId(departmentId, userId, item)));
        else
            rt.set(mobCreateProductMemberByDepartmentIdAndUserId(departmentId, userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * mob_create_product_member 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO mobCreateProductMemberByDepartmentIdAndUserId
            (String departmentId, String userId, ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        ProductMember rt = productMemberService.mobCreateProductMember(domain);
        return productMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"产品成员" },  notes = "ProductMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Save-all') or hasPermission('department',#departmentId,this.productMemberDtoMapping.toDomain(#dto),'ibizplm-ProductMember-Save')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/save")
    public Mono<ResponseEntity<ResponseWrapper<ProductMemberDTO>>>saveByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @Validated @RequestBody RequestWrapper<ProductMemberDTO> dto) {
        ResponseWrapper<ProductMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByDepartmentIdAndUserId(departmentId, userId, item)));
        else
            rt.set(saveByDepartmentIdAndUserId(departmentId, userId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return ResponseEntity<ProductMemberDTO>
    */   
    public ProductMemberDTO saveByDepartmentIdAndUserId
            (String departmentId, String userId, ProductMemberDTO dto) {
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
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"产品成员" },  notes = "ProductMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Get-all')  or hasPermission(this.productMemberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProductMember-Get')")
    @GetMapping("product_members/{id}")
    public Mono<ResponseEntity<ProductMemberDTO>> getById
            (@PathVariable("id") String id) {
        ProductMember rt = productMemberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 产品成员
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品成员" },  notes = "ProductMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Remove-all') or hasPermission(this.productMemberService.get(#id),'ibizplm-ProductMember-Remove')")
    @DeleteMapping("product_members/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = productMemberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 产品成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品成员" },  notes = "ProductMember-CheckKey ")
    @PostMapping("product_members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        CheckKeyStatus rt = productMemberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 产品成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品成员" },  notes = "ProductMember-GetDraft ")
    @GetMapping("product_members/get_draft")
    public Mono<ResponseEntity<ProductMemberDTO>> getDraft
            (@SpringQueryMap ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        ProductMember rt = productMemberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_product 产品成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_product", tags = {"产品成员" },  notes = "ProductMember-fetch_cur_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_cur_product-all') or hasPermission(#dto,'ibizplm-ProductMember-fetch_cur_product')")
    @PostMapping("product_members/fetch_cur_product")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchCurProduct
            (@Validated @RequestBody ProductMemberFilterDTO dto) {
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchCurProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 产品成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品成员" },  notes = "ProductMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_default-all') or hasPermission(#dto,'ibizplm-ProductMember-fetch_default')")
    @PostMapping("product_members/fetch_default")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchDefault
            (@Validated @RequestBody ProductMemberFilterDTO dto) {
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchDefault(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_with_product 产品成员
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_with_product", tags = {"产品成员" },  notes = "ProductMember-fetch_with_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_with_product-all') or hasPermission(#dto,'ibizplm-ProductMember-fetch_with_product')")
    @PostMapping("product_members/fetch_with_product")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchWithProduct
            (@Validated @RequestBody ProductMemberFilterDTO dto) {
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchWithProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"产品成员" },  notes = "ProductMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Get-all')  or hasPermission('product',#productId,this.productMemberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProductMember-Get')")
    @GetMapping("products/{productId}/product_members/{id}")
    public Mono<ResponseEntity<ProductMemberDTO>> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        ProductMember rt = productMemberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 产品成员
    * 
    *
    * @param productId productId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品成员" },  notes = "ProductMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Remove-all') or hasPermission('product',#productId,this.productMemberService.get(#id),'ibizplm-ProductMember-Remove')")
    @DeleteMapping("products/{productId}/product_members/{id}")
    public Mono<ResponseEntity<Boolean>> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = productMemberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品成员" },  notes = "ProductMember-CheckKey ")
    @PostMapping("products/{productId}/product_members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        CheckKeyStatus rt = productMemberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品成员" },  notes = "ProductMember-GetDraft ")
    @GetMapping("products/{productId}/product_members/get_draft")
    public Mono<ResponseEntity<ProductMemberDTO>> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        ProductMember rt = productMemberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_product 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_product", tags = {"产品成员" },  notes = "ProductMember-fetch_cur_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_cur_product-all') or hasPermission('product',#productId,#dto,'ibizplm-ProductMember-fetch_cur_product')")
    @PostMapping("products/{productId}/product_members/fetch_cur_product")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchCurProductByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchCurProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品成员" },  notes = "ProductMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_default-all') or hasPermission('product',#productId,#dto,'ibizplm-ProductMember-fetch_default')")
    @PostMapping("products/{productId}/product_members/fetch_default")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchDefault(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_with_product 产品成员
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_with_product", tags = {"产品成员" },  notes = "ProductMember-fetch_with_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_with_product-all') or hasPermission('product',#productId,#dto,'ibizplm-ProductMember-fetch_with_product')")
    @PostMapping("products/{productId}/product_members/fetch_with_product")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchWithProductByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setProductIdEQ(productId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchWithProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"产品成员" },  notes = "ProductMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Get-all')  or hasPermission('user',#userId,this.productMemberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProductMember-Get')")
    @GetMapping("users/{userId}/product_members/{id}")
    public Mono<ResponseEntity<ProductMemberDTO>> getByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        ProductMember rt = productMemberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 产品成员
    * 
    *
    * @param userId userId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品成员" },  notes = "ProductMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Remove-all') or hasPermission('user',#userId,this.productMemberService.get(#id),'ibizplm-ProductMember-Remove')")
    @DeleteMapping("users/{userId}/product_members/{id}")
    public Mono<ResponseEntity<Boolean>> removeByUserIdAndId
            (@PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = productMemberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品成员" },  notes = "ProductMember-CheckKey ")
    @PostMapping("users/{userId}/product_members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        CheckKeyStatus rt = productMemberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品成员" },  notes = "ProductMember-GetDraft ")
    @GetMapping("users/{userId}/product_members/get_draft")
    public Mono<ResponseEntity<ProductMemberDTO>> getDraftByUserId
            (@PathVariable("userId") String userId, @SpringQueryMap ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        ProductMember rt = productMemberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_product 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_product", tags = {"产品成员" },  notes = "ProductMember-fetch_cur_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_cur_product-all') or hasPermission('user',#userId,#dto,'ibizplm-ProductMember-fetch_cur_product')")
    @PostMapping("users/{userId}/product_members/fetch_cur_product")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchCurProductByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchCurProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品成员" },  notes = "ProductMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_default-all') or hasPermission('user',#userId,#dto,'ibizplm-ProductMember-fetch_default')")
    @PostMapping("users/{userId}/product_members/fetch_default")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchDefaultByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchDefault(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_with_product 产品成员
    * 
    *
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_with_product", tags = {"产品成员" },  notes = "ProductMember-fetch_with_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_with_product-all') or hasPermission('user',#userId,#dto,'ibizplm-ProductMember-fetch_with_product')")
    @PostMapping("users/{userId}/product_members/fetch_with_product")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchWithProductByUserId
            (@PathVariable("userId") String userId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchWithProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param id id
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"产品成员" },  notes = "ProductMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Get-all')  or hasPermission('department',#departmentId,this.productMemberDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ProductMember-Get')")
    @GetMapping("departments/{departmentId}/users/{userId}/product_members/{id}")
    public Mono<ResponseEntity<ProductMemberDTO>> getByDepartmentIdAndUserIdAndId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @PathVariable("id") String id) {
        ProductMember rt = productMemberService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"产品成员" },  notes = "ProductMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-Remove-all') or hasPermission('department',#departmentId,this.productMemberService.get(#id),'ibizplm-ProductMember-Remove')")
    @DeleteMapping("departments/{departmentId}/users/{userId}/product_members/{id}")
    public Mono<ResponseEntity<Boolean>> removeByDepartmentIdAndUserIdAndId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @PathVariable("id") String id) {
        Boolean rt = productMemberService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"产品成员" },  notes = "ProductMember-CheckKey ")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @Validated @RequestBody ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        CheckKeyStatus rt = productMemberService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<ProductMemberDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"产品成员" },  notes = "ProductMember-GetDraft ")
    @GetMapping("departments/{departmentId}/users/{userId}/product_members/get_draft")
    public Mono<ResponseEntity<ProductMemberDTO>> getDraftByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @SpringQueryMap ProductMemberDTO dto) {
        ProductMember domain = productMemberDtoMapping.toDomain(dto);
        domain.setUserId(userId);
        ProductMember rt = productMemberService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_cur_product 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_cur_product", tags = {"产品成员" },  notes = "ProductMember-fetch_cur_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_cur_product-all') or hasPermission('department',#departmentId,#dto,'ibizplm-ProductMember-fetch_cur_product')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/fetch_cur_product")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchCurProductByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchCurProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"产品成员" },  notes = "ProductMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_default-all') or hasPermission('department',#departmentId,#dto,'ibizplm-ProductMember-fetch_default')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/fetch_default")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchDefaultByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchDefault(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_with_product 产品成员
    * 
    *
    * @param departmentId departmentId
    * @param userId userId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ProductMemberDTO>>>
    */
    @ApiOperation(value = "查询fetch_with_product", tags = {"产品成员" },  notes = "ProductMember-fetch_with_product ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ProductMember-fetch_with_product-all') or hasPermission('department',#departmentId,#dto,'ibizplm-ProductMember-fetch_with_product')")
    @PostMapping("departments/{departmentId}/users/{userId}/product_members/fetch_with_product")
    public Mono<ResponseEntity<List<ProductMemberDTO>>> fetchWithProductByDepartmentIdAndUserId
            (@PathVariable("departmentId") String departmentId, @PathVariable("userId") String userId, @Validated @RequestBody ProductMemberFilterDTO dto) {
        dto.setUserIdEQ(userId);
        ProductMemberSearchContext context = productMemberFilterDtoMapping.toDomain(dto);
        Page<ProductMember> domains = productMemberService.fetchWithProduct(context) ;
        List<ProductMemberDTO> list = productMemberDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建产品成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Create-all')")
    @ApiOperation(value = "批量新建产品成员", tags = {"产品成员" },  notes = "批量新建产品成员")
	@PostMapping("product_members/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ProductMemberDTO> dtos) {
        productMemberService.create(productMemberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除产品成员
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Remove-all')")
    @ApiOperation(value = "批量删除产品成员", tags = {"产品成员" },  notes = "批量删除产品成员")
	@DeleteMapping("product_members/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        productMemberService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新产品成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Update-all')")
    @ApiOperation(value = "批量更新产品成员", tags = {"产品成员" },  notes = "批量更新产品成员")
	@PutMapping("product_members/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ProductMemberDTO> dtos) {
        productMemberService.update(productMemberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存产品成员
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Save-all')")
    @ApiOperation(value = "批量保存产品成员", tags = {"产品成员" },  notes = "批量保存产品成员")
	@PostMapping("product_members/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ProductMemberDTO> dtos) {
        productMemberService.save(productMemberDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入产品成员
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ProductMember-Save-all')")
    @ApiOperation(value = "批量导入产品成员", tags = {"产品成员" },  notes = "批量导入产品成员")
	@PostMapping("product_members/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ProductMemberDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(productMemberService.importData(config,ignoreError,productMemberDtoMapping.toDomain(dtos))));
    }

}
