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
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.base.service.CategoryService;
import cn.ibizlab.plm.core.base.filter.CategorySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Category] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractCategoryResource {

    @Autowired
    public CategoryService categoryService;

    @Autowired
    @Lazy
    public CategoryDTOMapping categoryDtoMapping;

    @Autowired
    @Lazy
    public CategoryFilterDTOMapping categoryFilterDtoMapping;

    /**
    * 创建Create 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"类别" },  notes = "Category-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-Create-all') or hasPermission(this.categoryDtoMapping.toDomain(#dto),'ibizplm-Category-Create')")
    @PostMapping("categories")
    public ResponseEntity<ResponseWrapper<CategoryDTO>> create
            (@Validated @RequestBody RequestWrapper<CategoryDTO> dto) {
        ResponseWrapper<CategoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */   
    public CategoryDTO create
            (CategoryDTO dto) {
        Category domain = categoryDtoMapping.toDomain(dto);
        categoryService.create(domain);
        Category rt = domain;
        return categoryDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"类别" },  notes = "Category-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-Update-all') or hasPermission(this.categoryService.get(#id),'ibizplm-Category-Update')")
    @VersionCheck(entity = "category" , versionfield = "updateTime")
    @PutMapping("categories/{id}")
    public ResponseEntity<ResponseWrapper<CategoryDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CategoryDTO> dto) {
        ResponseWrapper<CategoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */   
    public CategoryDTO updateById
            (String id, CategoryDTO dto) {
        Category domain = categoryDtoMapping.toDomain(dto);
        domain.setId(id);
        categoryService.update(domain);
        Category rt = domain;
        return categoryDtoMapping.toDto(rt);
    }

    /**
    * Delete_child_category 类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */
    @ApiOperation(value = "Delete_child_category", tags = {"类别" },  notes = "Category-Delete_child_category ")
    @PostMapping("categories/{id}/delete_child_category")
    public ResponseEntity<ResponseWrapper<CategoryDTO>> deleteChildCategoryById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<CategoryDTO> dto) {
        ResponseWrapper<CategoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteChildCategoryById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteChildCategoryById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * Delete_child_category 类别
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */   
    public CategoryDTO deleteChildCategoryById
            (String id, CategoryDTO dto) {
        Category domain = categoryDtoMapping.toDomain(dto);
        domain.setId(id);
        Category rt = categoryService.deleteChildCategory(domain);
        return categoryDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"类别" },  notes = "Category-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-Save-all') or hasPermission(this.categoryDtoMapping.toDomain(#dto),'ibizplm-Category-Save')")
    @PostMapping("categories/save")
    public ResponseEntity<ResponseWrapper<CategoryDTO>> save
            (@Validated @RequestBody RequestWrapper<CategoryDTO> dto) {
        ResponseWrapper<CategoryDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */   
    public CategoryDTO save
            (CategoryDTO dto) {
        Category domain = categoryDtoMapping.toDomain(dto);
        categoryService.save(domain);
        Category rt = domain;
        return categoryDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 类别
    * 
    *
    * @param id id
    * @return ResponseEntity<CategoryDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"类别" },  notes = "Category-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-Get-all')  or hasPermission(this.categoryDtoMapping.toDomain(returnObject.body),'ibizplm-Category-Get')")
    @GetMapping("categories/{id}")
    public ResponseEntity<CategoryDTO> getById
            (@PathVariable("id") String id) {
        Category rt = categoryService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 类别
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"类别" },  notes = "Category-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-Remove-all') or hasPermission(this.categoryService.get(#id),'ibizplm-Category-Remove')")
    @DeleteMapping("categories/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = categoryService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"类别" },  notes = "Category-CheckKey ")
    @PostMapping("categories/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody CategoryDTO dto) {
        Category domain = categoryDtoMapping.toDomain(dto);
        Integer rt = categoryService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<CategoryDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"类别" },  notes = "Category-GetDraft ")
    @GetMapping("categories/getdraft")
    public ResponseEntity<CategoryDTO> getDraft
            (@SpringQueryMap CategoryDTO dto) {
        Category domain = categoryDtoMapping.toDomain(dto);
        Category rt = categoryService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchDefault 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CategoryDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"类别" },  notes = "Category-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-FetchDefault-all') or hasPermission(#dto,'ibizplm-Category-FetchDefault')")
    @PostMapping("categories/fetchdefault")
    public ResponseEntity<List<CategoryDTO>> fetchDefault
            (@Validated @RequestBody CategoryFilterDTO dto) {
        CategorySearchContext context = categoryFilterDtoMapping.toDomain(dto);
        Page<Category> domains = categoryService.searchDefault(context) ;
        List<CategoryDTO> list = categoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNo_section 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CategoryDTO>>
    */
    @ApiOperation(value = "查询FetchNo_section", tags = {"类别" },  notes = "Category-FetchNo_section ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-FetchNo_section-all') or hasPermission(#dto,'ibizplm-Category-FetchNo_section')")
    @PostMapping("categories/fetchno_section")
    public ResponseEntity<List<CategoryDTO>> fetchNoSection
            (@Validated @RequestBody CategoryFilterDTO dto) {
        CategorySearchContext context = categoryFilterDtoMapping.toDomain(dto);
        Page<Category> domains = categoryService.searchNoSection(context) ;
        List<CategoryDTO> list = categoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchProduct_idea_category 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CategoryDTO>>
    */
    @ApiOperation(value = "查询FetchProduct_idea_category", tags = {"类别" },  notes = "Category-FetchProduct_idea_category ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-FetchProduct_idea_category-all') or hasPermission(#dto,'ibizplm-Category-FetchProduct_idea_category')")
    @PostMapping("categories/fetchproduct_idea_category")
    public ResponseEntity<List<CategoryDTO>> fetchProductIdeaCategory
            (@Validated @RequestBody CategoryFilterDTO dto) {
        CategorySearchContext context = categoryFilterDtoMapping.toDomain(dto);
        Page<Category> domains = categoryService.searchProductIdeaCategory(context) ;
        List<CategoryDTO> list = categoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchProduct_plan 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CategoryDTO>>
    */
    @ApiOperation(value = "查询FetchProduct_plan", tags = {"类别" },  notes = "Category-FetchProduct_plan ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Category-FetchProduct_plan-all') or hasPermission(#dto,'ibizplm-Category-FetchProduct_plan')")
    @PostMapping("categories/fetchproduct_plan")
    public ResponseEntity<List<CategoryDTO>> fetchProductPlan
            (@Validated @RequestBody CategoryFilterDTO dto) {
        CategorySearchContext context = categoryFilterDtoMapping.toDomain(dto);
        Page<Category> domains = categoryService.searchProductPlan(context) ;
        List<CategoryDTO> list = categoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchSpace_category 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CategoryDTO>>
    */
    @ApiOperation(value = "查询FetchSpace_category", tags = {"类别" },  notes = "Category-FetchSpace_category ")
    @PostMapping("categories/fetchspace_category")
    public ResponseEntity<List<CategoryDTO>> fetchSpaceCategory
            (@Validated @RequestBody CategoryFilterDTO dto) {
        CategorySearchContext context = categoryFilterDtoMapping.toDomain(dto);
        Page<Category> domains = categoryService.searchSpaceCategory(context) ;
        List<CategoryDTO> list = categoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchSpace_category_top 类别
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<CategoryDTO>>
    */
    @ApiOperation(value = "查询FetchSpace_category_top", tags = {"类别" },  notes = "Category-FetchSpace_category_top ")
    @PostMapping("categories/fetchspace_category_top")
    public ResponseEntity<List<CategoryDTO>> fetchSpaceCategoryTop
            (@Validated @RequestBody CategoryFilterDTO dto) {
        CategorySearchContext context = categoryFilterDtoMapping.toDomain(dto);
        Page<Category> domains = categoryService.searchSpaceCategoryTop(context) ;
        List<CategoryDTO> list = categoryDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建类别
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Category-Create-all')")
    @ApiOperation(value = "批量新建类别", tags = {"类别" },  notes = "批量新建类别")
	@PostMapping("categories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<CategoryDTO> dtos) {
        categoryService.createBatch(categoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除类别
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Category-Remove-all')")
    @ApiOperation(value = "批量删除类别", tags = {"类别" },  notes = "批量删除类别")
	@DeleteMapping("categories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        categoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新类别
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Category-Update-all')")
    @ApiOperation(value = "批量更新类别", tags = {"类别" },  notes = "批量更新类别")
	@PutMapping("categories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<CategoryDTO> dtos) {
        categoryService.updateBatch(categoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存类别
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Category-Save-all')")
    @ApiOperation(value = "批量保存类别", tags = {"类别" },  notes = "批量保存类别")
	@PostMapping("categories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<CategoryDTO> dtos) {
        categoryService.saveBatch(categoryDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入类别
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Category-Save-all')")
    @ApiOperation(value = "批量导入类别", tags = {"类别" },  notes = "批量导入类别")
	@PostMapping("categories/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<CategoryDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(categoryService.importData(config,ignoreError,categoryDtoMapping.toDomain(dtos)));
    }

}
