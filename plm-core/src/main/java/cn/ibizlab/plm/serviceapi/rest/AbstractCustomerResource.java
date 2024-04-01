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
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.service.CustomerService;
import cn.ibizlab.plm.core.prodmgmt.filter.CustomerSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Customer] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractCustomerResource {

    @Autowired
    public CustomerService customerService;

    @Autowired
    @Lazy
    public CustomerDTOMapping customerDtoMapping;

    @Autowired
    @Lazy
    public CustomerFilterDTOMapping customerFilterDtoMapping;

    @Autowired
    @Lazy
    public CustomerassigneeDTOMapping customerassigneeDtoMapping;

    /**
    * 创建Create 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"客户" },  notes = "Customer-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Create-all') or hasPermission(this.customerDtoMapping.toDomain(#dto),'ibizplm-Customer-Create')")
    @PostMapping("customers")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> create
            (@Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO create
            (CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        customerService.create(domain);
        Customer rt = domain;
        return customerDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"客户" },  notes = "Customer-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Update-all') or hasPermission(this.customerService.get(#id),'ibizplm-Customer-Update')")
    @VersionCheck(entity = "customer" , versionfield = "updateTime")
    @PutMapping("customers/{id}")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO updateById
            (String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        customerService.update(domain);
        Customer rt = domain;
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Add_categories 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Add_categories", tags = {"客户" },  notes = "Customer-Add_categories ")
    @PostMapping("customers/{id}/add_categories")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> addCategoriesById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addCategoriesById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addCategoriesById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Add_categories 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO addCategoriesById
            (String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.addCategories(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Customer_choose_ticket 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Customer_choose_ticket", tags = {"客户" },  notes = "Customer-Customer_choose_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Customer_choose_ticket-all') or hasPermission(this.customerDtoMapping.toDomain(#dto),'ibizplm-Customer-Customer_choose_ticket')")
    @PutMapping("customers/{id}/customer_choose_ticket")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> customerChooseTicketById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerChooseTicketById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerChooseTicketById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Customer_choose_ticket 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO customerChooseTicketById
            (String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.customerChooseTicket(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Del_relation 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"客户" },  notes = "Customer-Del_relation ")
    @PostMapping("customers/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> delRelationById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO delRelationById
            (String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.delRelation(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Others_relation_customer 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Others_relation_customer", tags = {"客户" },  notes = "Customer-Others_relation_customer ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Others_relation_customer-all') or hasPermission(this.customerDtoMapping.toDomain(#dto),'ibizplm-Customer-Others_relation_customer')")
    @PutMapping("customers/{id}/others_relation_customer")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> othersRelationCustomerById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationCustomerById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationCustomerById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Others_relation_customer 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO othersRelationCustomerById
            (String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.othersRelationCustomer(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Product_customer_re_counters 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Product_customer_re_counters", tags = {"客户" },  notes = "Customer-Product_customer_re_counters ")
    @PostMapping("customers/{id}/product_customer_re_counters")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> productCustomerReCountersById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productCustomerReCountersById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productCustomerReCountersById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Product_customer_re_counters 客户
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO productCustomerReCountersById
            (String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.productCustomerReCounters(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"客户" },  notes = "Customer-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Save-all') or hasPermission(this.customerDtoMapping.toDomain(#dto),'ibizplm-Customer-Save')")
    @PostMapping("customers/save")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> save
            (@Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO save
            (CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        customerService.save(domain);
        Customer rt = domain;
        return customerDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"客户" },  notes = "Customer-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Create-all') or hasPermission('Product',#productId,this.customerDtoMapping.toDomain(#dto),'ibizplm-Customer-Create')")
    @PostMapping("products/{productId}/customers")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> createByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByProductId(productId, item)));
        else
            rt.set(createByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO createByProductId
            (String productId, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        customerService.create(domain);
        Customer rt = domain;
        return customerDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"客户" },  notes = "Customer-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Update-all') or hasPermission('Product',#productId,this.customerService.get(#id),'ibizplm-Customer-Update')")
    @VersionCheck(entity = "customer" , versionfield = "updateTime")
    @PutMapping("products/{productId}/customers/{id}")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> updateByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO updateByProductIdAndId
            (String productId, String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        customerService.update(domain);
        Customer rt = domain;
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Add_categories 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Add_categories", tags = {"客户" },  notes = "Customer-Add_categories ")
    @PostMapping("products/{productId}/customers/{id}/add_categories")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> addCategoriesByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(addCategoriesByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(addCategoriesByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Add_categories 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO addCategoriesByProductIdAndId
            (String productId, String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.addCategories(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Customer_choose_ticket 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Customer_choose_ticket", tags = {"客户" },  notes = "Customer-Customer_choose_ticket ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Customer_choose_ticket-all') or hasPermission('Product',#productId,this.customerDtoMapping.toDomain(#dto),'ibizplm-Customer-Customer_choose_ticket')")
    @PutMapping("products/{productId}/customers/{id}/customer_choose_ticket")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> customerChooseTicketByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(customerChooseTicketByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(customerChooseTicketByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Customer_choose_ticket 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO customerChooseTicketByProductIdAndId
            (String productId, String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.customerChooseTicket(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Del_relation 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Del_relation", tags = {"客户" },  notes = "Customer-Del_relation ")
    @PostMapping("products/{productId}/customers/{id}/del_relation")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> delRelationByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(delRelationByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(delRelationByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Del_relation 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO delRelationByProductIdAndId
            (String productId, String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.delRelation(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Others_relation_customer 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Others_relation_customer", tags = {"客户" },  notes = "Customer-Others_relation_customer ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Others_relation_customer-all') or hasPermission('Product',#productId,this.customerDtoMapping.toDomain(#dto),'ibizplm-Customer-Others_relation_customer')")
    @PutMapping("products/{productId}/customers/{id}/others_relation_customer")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> othersRelationCustomerByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(othersRelationCustomerByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(othersRelationCustomerByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Others_relation_customer 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO othersRelationCustomerByProductIdAndId
            (String productId, String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.othersRelationCustomer(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * Product_customer_re_counters 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Product_customer_re_counters", tags = {"客户" },  notes = "Customer-Product_customer_re_counters ")
    @PostMapping("products/{productId}/customers/{id}/product_customer_re_counters")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> productCustomerReCountersByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(productCustomerReCountersByProductIdAndId(productId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(productCustomerReCountersByProductIdAndId(productId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Product_customer_re_counters 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO productCustomerReCountersByProductIdAndId
            (String productId, String id, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setId(id);
        Customer rt = customerService.productCustomerReCounters(domain);
        return customerDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"客户" },  notes = "Customer-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Save-all') or hasPermission('Product',#productId,this.customerDtoMapping.toDomain(#dto),'ibizplm-Customer-Save')")
    @PostMapping("products/{productId}/customers/save")
    public ResponseEntity<ResponseWrapper<CustomerDTO>> saveByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody RequestWrapper<CustomerDTO> dto) {
        ResponseWrapper<CustomerDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByProductId(productId, item)));
        else
            rt.set(saveByProductId(productId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */   
    public CustomerDTO saveByProductId
            (String productId, CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        customerService.save(domain);
        Customer rt = domain;
        return customerDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 客户
    * 
    *
    * @param id id
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"客户" },  notes = "Customer-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Get-all')  or hasPermission(this.customerDtoMapping.toDomain(returnObject.body),'ibizplm-Customer-Get')")
    @GetMapping("customers/{id}")
    public ResponseEntity<CustomerDTO> getById
            (@PathVariable("id") String id) {
        Customer rt = customerService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 客户
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"客户" },  notes = "Customer-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Remove-all') or hasPermission(this.customerService.get(#id),'ibizplm-Customer-Remove')")
    @DeleteMapping("customers/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = customerService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"客户" },  notes = "Customer-CheckKey ")
    @PostMapping("customers/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        Integer rt = customerService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"客户" },  notes = "Customer-GetDraft ")
    @GetMapping("customers/getdraft")
    public ResponseEntity<CustomerDTO> getDraft
            (@SpringQueryMap CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        Customer rt = customerService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoMapping.toDto(rt));
    }

    /**
    * Get_attention 客户
    * 
    *
    * @param id id
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Get_attention", tags = {"客户" },  notes = "Customer-Get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Get_attention-all') or hasPermission(this.customerService.get(#id),'ibizplm-Customer-Get_attention')")
    @GetMapping("customers/{id}/get_attention")
    public ResponseEntity<CustomerDTO> getAttentionById
            (@PathVariable("id") String id) {
        Customer rt = customerService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchComment_notify_assignee 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CustomerassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchComment_notify_assignee", tags = {"客户" },  notes = "Customer-FetchComment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchComment_notify_assignee-all') or hasPermission(#dto,'ibizplm-Customer-FetchComment_notify_assignee')")
    @PostMapping("customers/fetchcomment_notify_assignee")
    public ResponseEntity<List<CustomerassigneeDTO>> fetchCommentNotifyAssignee
            (@Validated @RequestBody CustomerFilterDTO dto) {
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchCommentNotifyAssignee(context) ;
        List<CustomerassigneeDTO> list = customerassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CustomerDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"客户" },  notes = "Customer-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchDefault-all') or hasPermission(#dto,'ibizplm-Customer-FetchDefault')")
    @PostMapping("customers/fetchdefault")
    public ResponseEntity<List<CustomerDTO>> fetchDefault
            (@Validated @RequestBody CustomerFilterDTO dto) {
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchDefault(context) ;
        List<CustomerDTO> list = customerDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_notre_customer 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CustomerDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_notre_customer", tags = {"客户" },  notes = "Customer-FetchIdea_notre_customer ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchIdea_notre_customer-all') or hasPermission(#dto,'ibizplm-Customer-FetchIdea_notre_customer')")
    @PostMapping("customers/fetchidea_notre_customer")
    public ResponseEntity<List<CustomerDTO>> fetchIdeaNotreCustomer
            (@Validated @RequestBody CustomerFilterDTO dto) {
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchIdeaNotreCustomer(context) ;
        List<CustomerDTO> list = customerDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_relation_customer 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CustomerDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_relation_customer", tags = {"客户" },  notes = "Customer-FetchIdea_relation_customer ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchIdea_relation_customer-all') or hasPermission(#dto,'ibizplm-Customer-FetchIdea_relation_customer')")
    @PostMapping("customers/fetchidea_relation_customer")
    public ResponseEntity<List<CustomerDTO>> fetchIdeaRelationCustomer
            (@Validated @RequestBody CustomerFilterDTO dto) {
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchIdeaRelationCustomer(context) ;
        List<CustomerDTO> list = customerDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CustomerDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"客户" },  notes = "Customer-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchNormal-all') or hasPermission(#dto,'ibizplm-Customer-FetchNormal')")
    @PostMapping("customers/fetchnormal")
    public ResponseEntity<List<CustomerDTO>> fetchNormal
            (@Validated @RequestBody CustomerFilterDTO dto) {
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchNormal(context) ;
        List<CustomerDTO> list = customerDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNotify_assignee 客户
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CustomerassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchNotify_assignee", tags = {"客户" },  notes = "Customer-FetchNotify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchNotify_assignee-all') or hasPermission(#dto,'ibizplm-Customer-FetchNotify_assignee')")
    @PostMapping("customers/fetchnotify_assignee")
    public ResponseEntity<List<CustomerassigneeDTO>> fetchNotifyAssignee
            (@Validated @RequestBody CustomerFilterDTO dto) {
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchNotifyAssignee(context) ;
        List<CustomerassigneeDTO> list = customerassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"客户" },  notes = "Customer-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Get-all')  or hasPermission('Product',#productId,this.customerDtoMapping.toDomain(returnObject.body),'ibizplm-Customer-Get')")
    @GetMapping("products/{productId}/customers/{id}")
    public ResponseEntity<CustomerDTO> getByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Customer rt = customerService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"客户" },  notes = "Customer-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Remove-all') or hasPermission('Product',#productId,this.customerService.get(#id),'ibizplm-Customer-Remove')")
    @DeleteMapping("products/{productId}/customers/{id}")
    public ResponseEntity<Boolean> removeByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Boolean rt = customerService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"客户" },  notes = "Customer-CheckKey ")
    @PostMapping("products/{productId}/customers/checkkey")
    public ResponseEntity<Integer> checkKeyByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Integer rt = customerService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"客户" },  notes = "Customer-GetDraft ")
    @GetMapping("products/{productId}/customers/getdraft")
    public ResponseEntity<CustomerDTO> getDraftByProductId
            (@PathVariable("productId") String productId, @SpringQueryMap CustomerDTO dto) {
        Customer domain = customerDtoMapping.toDomain(dto);
        domain.setProductId(productId);
        Customer rt = customerService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoMapping.toDto(rt));
    }

    /**
    * Get_attention 客户
    * 
    *
    * @param productId productId
    * @param id id
    * @return ResponseEntity<CustomerDTO>
    */
    @ApiOperation(value = "Get_attention", tags = {"客户" },  notes = "Customer-Get_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-Get_attention-all') or hasPermission('Product',#productId,this.customerService.get(#id),'ibizplm-Customer-Get_attention')")
    @GetMapping("products/{productId}/customers/{id}/get_attention")
    public ResponseEntity<CustomerDTO> getAttentionByProductIdAndId
            (@PathVariable("productId") String productId, @PathVariable("id") String id) {
        Customer rt = customerService.getAttention(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchComment_notify_assignee 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<CustomerassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchComment_notify_assignee", tags = {"客户" },  notes = "Customer-FetchComment_notify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchComment_notify_assignee-all') or hasPermission('Product',#productId,#dto,'ibizplm-Customer-FetchComment_notify_assignee')")
    @PostMapping("products/{productId}/customers/fetchcomment_notify_assignee")
    public ResponseEntity<List<CustomerassigneeDTO>> fetchCommentNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody CustomerFilterDTO dto) {
        dto.setProductIdEQ(productId);
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchCommentNotifyAssignee(context) ;
        List<CustomerassigneeDTO> list = customerassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<CustomerDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"客户" },  notes = "Customer-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchDefault-all') or hasPermission('Product',#productId,#dto,'ibizplm-Customer-FetchDefault')")
    @PostMapping("products/{productId}/customers/fetchdefault")
    public ResponseEntity<List<CustomerDTO>> fetchDefaultByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody CustomerFilterDTO dto) {
        dto.setProductIdEQ(productId);
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchDefault(context) ;
        List<CustomerDTO> list = customerDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_notre_customer 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<CustomerDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_notre_customer", tags = {"客户" },  notes = "Customer-FetchIdea_notre_customer ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchIdea_notre_customer-all') or hasPermission('Product',#productId,#dto,'ibizplm-Customer-FetchIdea_notre_customer')")
    @PostMapping("products/{productId}/customers/fetchidea_notre_customer")
    public ResponseEntity<List<CustomerDTO>> fetchIdeaNotreCustomerByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody CustomerFilterDTO dto) {
        dto.setProductIdEQ(productId);
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchIdeaNotreCustomer(context) ;
        List<CustomerDTO> list = customerDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchIdea_relation_customer 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<CustomerDTO>>
    */
    @ApiOperation(value = "查询FetchIdea_relation_customer", tags = {"客户" },  notes = "Customer-FetchIdea_relation_customer ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchIdea_relation_customer-all') or hasPermission('Product',#productId,#dto,'ibizplm-Customer-FetchIdea_relation_customer')")
    @PostMapping("products/{productId}/customers/fetchidea_relation_customer")
    public ResponseEntity<List<CustomerDTO>> fetchIdeaRelationCustomerByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody CustomerFilterDTO dto) {
        dto.setProductIdEQ(productId);
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchIdeaRelationCustomer(context) ;
        List<CustomerDTO> list = customerDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNormal 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<CustomerDTO>>
    */
    @ApiOperation(value = "查询FetchNormal", tags = {"客户" },  notes = "Customer-FetchNormal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchNormal-all') or hasPermission('Product',#productId,#dto,'ibizplm-Customer-FetchNormal')")
    @PostMapping("products/{productId}/customers/fetchnormal")
    public ResponseEntity<List<CustomerDTO>> fetchNormalByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody CustomerFilterDTO dto) {
        dto.setProductIdEQ(productId);
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchNormal(context) ;
        List<CustomerDTO> list = customerDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNotify_assignee 客户
    * 
    *
    * @param productId productId
    * @param dto dto
    * @return ResponseEntity<List<CustomerassigneeDTO>>
    */
    @ApiOperation(value = "查询FetchNotify_assignee", tags = {"客户" },  notes = "Customer-FetchNotify_assignee ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Customer-FetchNotify_assignee-all') or hasPermission('Product',#productId,#dto,'ibizplm-Customer-FetchNotify_assignee')")
    @PostMapping("products/{productId}/customers/fetchnotify_assignee")
    public ResponseEntity<List<CustomerassigneeDTO>> fetchNotifyAssigneeByProductId
            (@PathVariable("productId") String productId, @Validated @RequestBody CustomerFilterDTO dto) {
        dto.setProductIdEQ(productId);
        CustomerSearchContext context = customerFilterDtoMapping.toDomain(dto);
        Page<Customer> domains = customerService.searchNotifyAssignee(context) ;
        List<CustomerassigneeDTO> list = customerassigneeDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建客户
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Customer-Create-all')")
    @ApiOperation(value = "批量新建客户", tags = {"客户" },  notes = "批量新建客户")
	@PostMapping("customers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<CustomerDTO> dtos) {
        customerService.createBatch(customerDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除客户
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Customer-Remove-all')")
    @ApiOperation(value = "批量删除客户", tags = {"客户" },  notes = "批量删除客户")
	@DeleteMapping("customers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        customerService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新客户
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Customer-Update-all')")
    @ApiOperation(value = "批量更新客户", tags = {"客户" },  notes = "批量更新客户")
	@PutMapping("customers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<CustomerDTO> dtos) {
        customerService.updateBatch(customerDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存客户
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Customer-Save-all')")
    @ApiOperation(value = "批量保存客户", tags = {"客户" },  notes = "批量保存客户")
	@PostMapping("customers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<CustomerDTO> dtos) {
        customerService.saveBatch(customerDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入客户
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Customer-Save-all')")
    @ApiOperation(value = "批量导入客户", tags = {"客户" },  notes = "批量导入客户")
	@PostMapping("customers/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<CustomerDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(customerService.importData(config,ignoreError,customerDtoMapping.toDomain(dtos)));
    }

}
