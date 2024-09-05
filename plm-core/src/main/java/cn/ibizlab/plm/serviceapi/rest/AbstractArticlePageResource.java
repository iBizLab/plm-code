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
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.wiki.filter.ArticlePageSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[ArticlePage] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractArticlePageResource {

    @Autowired
    public ArticlePageService articlePageService;

    @Autowired
    @Lazy
    public ArticlePageDTOMapping articlePageDtoMapping;

    @Autowired
    @Lazy
    public ArticlePageFilterDTOMapping articlePageFilterDtoMapping;

    @Autowired
    @Lazy
    public ArticlePageNameDTOMapping articlePageNameDtoMapping;

    @Autowired
    @Lazy
    public ArticlePageSharedFieldsDTOMapping articlePageSharedFieldsDtoMapping;

    @Autowired
    @Lazy
    public ArticlePageSharedReadDTOMapping articlePageSharedReadDtoMapping;

    /**
    * 创建Create 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"页面" },  notes = "ArticlePage-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Create-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-Create')")
    @PostMapping("article_pages")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>create
            (@Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO create
            (ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        articlePageService.create(domain);
        ArticlePage rt = domain;
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"页面" },  notes = "ArticlePage-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Update-all') or hasPermission(this.articlePageService.get(#id),'ibizplm-ArticlePage-Update')")
    @VersionCheck(entity = "articlepage" , versionfield = "updateTime")
    @PutMapping("article_pages/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO updateById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        articlePageService.update(domain);
        ArticlePage rt = domain;
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * check_access_password 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "check_access_password", tags = {"页面" },  notes = "ArticlePage-check_access_password ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-check_access_password-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-check_access_password')")
    @PostMapping("article_pages/{id}/check_access_password")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>checkAccessPasswordById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(checkAccessPasswordById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(checkAccessPasswordById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_access_password 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO checkAccessPasswordById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.checkAccessPassword(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * closed_shared 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "closed_shared", tags = {"页面" },  notes = "ArticlePage-closed_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-closed_shared-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-closed_shared')")
    @PutMapping("article_pages/{id}/closed_shared")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>closedSharedById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(closedSharedById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(closedSharedById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * closed_shared 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO closedSharedById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.closedShared(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * commit_version 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "commit_version", tags = {"页面" },  notes = "ArticlePage-commit_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-commit_version-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-commit_version')")
    @PostMapping("article_pages/{id}/commit_version")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>commitVersionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(commitVersionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(commitVersionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * commit_version 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO commitVersionById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.commitVersion(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * copy_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "copy_page", tags = {"页面" },  notes = "ArticlePage-copy_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-copy_page-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-copy_page')")
    @PostMapping("article_pages/{id}/copy_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>copyPageById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyPageById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyPageById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO copyPageById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.copyPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * delete 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "delete", tags = {"页面" },  notes = "ArticlePage-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-delete-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-delete')")
    @PostMapping("article_pages/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO deleteById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.delete(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * export_to_pdf 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "export_to_pdf", tags = {"页面" },  notes = "ArticlePage-export_to_pdf ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-export_to_pdf-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-export_to_pdf')")
    @PostMapping("article_pages/{id}/export_to_pdf")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>exportToPdfById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(exportToPdfById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(exportToPdfById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * export_to_pdf 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO exportToPdfById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.exportToPdf(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * favorite 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "favorite", tags = {"页面" },  notes = "ArticlePage-favorite ")
    @PostMapping("article_pages/{id}/favorite")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * favorite 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO favoriteById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.favorite(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * lock_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "lock_page", tags = {"页面" },  notes = "ArticlePage-lock_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-lock_page-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-lock_page')")
    @PostMapping("article_pages/{id}/lock_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>lockPageById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(lockPageById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(lockPageById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * lock_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO lockPageById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.lockPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * move_order 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"页面" },  notes = "ArticlePage-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-move_order-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-move_order')")
    @PostMapping("article_pages/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<ArticlePageDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<List<ArticlePageDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */   
    public List<ArticlePageDTO> moveOrderById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        List<ArticlePage> rt = articlePageService.moveOrder(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * move_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "move_page", tags = {"页面" },  notes = "ArticlePage-move_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-move_page-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-move_page')")
    @PostMapping("article_pages/{id}/move_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>movePageById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(movePageById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(movePageById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO movePageById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.movePage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * name_version_save 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "name_version_save", tags = {"页面" },  notes = "ArticlePage-name_version_save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-name_version_save-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-name_version_save')")
    @PostMapping("article_pages/{id}/name_version_save")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>nameVersionSaveById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(nameVersionSaveById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(nameVersionSaveById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * name_version_save 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO nameVersionSaveById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.nameVersionSave(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * new_draft_form_stencil 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "new_draft_form_stencil", tags = {"页面" },  notes = "ArticlePage-new_draft_form_stencil ")
    @PostMapping("article_pages/new_draft_form_stencil")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>newDraftFormStencil
            (@Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(newDraftFormStencil(item)));
        else
            rt.set(newDraftFormStencil(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * new_draft_form_stencil 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO newDraftFormStencil
            (ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        ArticlePage rt = articlePageService.newDraftFormStencil(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * publish_page 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "publish_page", tags = {"页面" },  notes = "ArticlePage-publish_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-publish_page-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-publish_page')")
    @PostMapping("article_pages/publish_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>publishPage
            (@Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(publishPage(item)));
        else
            rt.set(publishPage(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * publish_page 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO publishPage
            (ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        ArticlePage rt = articlePageService.publishPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * publish_page_test 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "publish_page_test", tags = {"页面" },  notes = "ArticlePage-publish_page_test ")
    @PostMapping("article_pages/{id}/publish_page_test")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>publishPageTestById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(publishPageTestById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(publishPageTestById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * publish_page_test 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO publishPageTestById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.publishPageTest(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * recover 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "recover", tags = {"页面" },  notes = "ArticlePage-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-recover-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-recover')")
    @PostMapping("article_pages/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO recoverById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.recover(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * recover_version 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "recover_version", tags = {"页面" },  notes = "ArticlePage-recover_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-recover_version-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-recover_version')")
    @PostMapping("article_pages/{id}/recover_version")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>recoverVersionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverVersionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverVersionById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover_version 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO recoverVersionById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.recoverVersion(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"页面" },  notes = "ArticlePage-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Save-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-Save')")
    @PostMapping("article_pages/save")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>save
            (@Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO save
            (ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        articlePageService.save(domain);
        ArticlePage rt = domain;
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * save_to_stencil 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "save_to_stencil", tags = {"页面" },  notes = "ArticlePage-save_to_stencil ")
    @PostMapping("article_pages/{id}/save_to_stencil")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>saveToStencilById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveToStencilById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveToStencilById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * save_to_stencil 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO saveToStencilById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.saveToStencil(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * shared_setting 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "shared_setting", tags = {"页面" },  notes = "ArticlePage-shared_setting ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-shared_setting-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-shared_setting')")
    @PostMapping("article_pages/{id}/shared_setting")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>sharedSettingById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sharedSettingById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sharedSettingById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shared_setting 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO sharedSettingById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.sharedSetting(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * shared_url 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "shared_url", tags = {"页面" },  notes = "ArticlePage-shared_url ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-shared_url-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-shared_url')")
    @PostMapping("article_pages/{id}/shared_url")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>sharedUrlById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sharedUrlById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sharedUrlById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shared_url 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO sharedUrlById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.sharedUrl(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "un_favorite", tags = {"页面" },  notes = "ArticlePage-un_favorite ")
    @PostMapping("article_pages/{id}/un_favorite")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * un_favorite 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO unFavoriteById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.unFavorite(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * unlock_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "unlock_page", tags = {"页面" },  notes = "ArticlePage-unlock_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-unlock_page-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-unlock_page')")
    @PostMapping("article_pages/{id}/unlock_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>unlockPageById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unlockPageById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unlockPageById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * unlock_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO unlockPageById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.unlockPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"页面" },  notes = "ArticlePage-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Create-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-Create')")
    @PostMapping("shared_spaces/{spaceId}/article_pages")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>createBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySpaceId(spaceId, item)));
        else
            rt.set(createBySpaceId(spaceId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO createBySpaceId
            (String spaceId, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        articlePageService.create(domain);
        ArticlePage rt = domain;
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"页面" },  notes = "ArticlePage-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Update-all') or hasPermission('shared_space',#spaceId,this.articlePageService.get(#id),'ibizplm-ArticlePage-Update')")
    @VersionCheck(entity = "articlepage" , versionfield = "updateTime")
    @PutMapping("shared_spaces/{spaceId}/article_pages/{id}")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>updateBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO updateBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        articlePageService.update(domain);
        ArticlePage rt = domain;
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * check_access_password 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "check_access_password", tags = {"页面" },  notes = "ArticlePage-check_access_password ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-check_access_password-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-check_access_password')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/check_access_password")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>checkAccessPasswordBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(checkAccessPasswordBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(checkAccessPasswordBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_access_password 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO checkAccessPasswordBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.checkAccessPassword(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * closed_shared 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "closed_shared", tags = {"页面" },  notes = "ArticlePage-closed_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-closed_shared-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-closed_shared')")
    @PutMapping("shared_spaces/{spaceId}/article_pages/{id}/closed_shared")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>closedSharedBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(closedSharedBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(closedSharedBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * closed_shared 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO closedSharedBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.closedShared(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * commit_version 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "commit_version", tags = {"页面" },  notes = "ArticlePage-commit_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-commit_version-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-commit_version')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/commit_version")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>commitVersionBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(commitVersionBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(commitVersionBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * commit_version 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO commitVersionBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.commitVersion(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * copy_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "copy_page", tags = {"页面" },  notes = "ArticlePage-copy_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-copy_page-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-copy_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/copy_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>copyPageBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(copyPageBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(copyPageBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * copy_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO copyPageBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.copyPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * delete 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "delete", tags = {"页面" },  notes = "ArticlePage-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-delete-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-delete')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/delete")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>deleteBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * delete 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO deleteBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.delete(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * export_to_pdf 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "export_to_pdf", tags = {"页面" },  notes = "ArticlePage-export_to_pdf ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-export_to_pdf-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-export_to_pdf')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/export_to_pdf")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>exportToPdfBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(exportToPdfBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(exportToPdfBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * export_to_pdf 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO exportToPdfBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.exportToPdf(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * favorite 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "favorite", tags = {"页面" },  notes = "ArticlePage-favorite ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/favorite")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>favoriteBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * favorite 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO favoriteBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.favorite(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * lock_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "lock_page", tags = {"页面" },  notes = "ArticlePage-lock_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-lock_page-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-lock_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/lock_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>lockPageBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(lockPageBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(lockPageBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * lock_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO lockPageBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.lockPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * move_order 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"页面" },  notes = "ArticlePage-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-move_order-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-move_order')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<ArticlePageDTO>>>>moveOrderBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<List<ArticlePageDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */   
    public List<ArticlePageDTO> moveOrderBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        List<ArticlePage> rt = articlePageService.moveOrder(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * move_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "move_page", tags = {"页面" },  notes = "ArticlePage-move_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-move_page-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-move_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/move_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>movePageBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(movePageBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(movePageBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO movePageBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.movePage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * name_version_save 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "name_version_save", tags = {"页面" },  notes = "ArticlePage-name_version_save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-name_version_save-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-name_version_save')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/name_version_save")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>nameVersionSaveBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(nameVersionSaveBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(nameVersionSaveBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * name_version_save 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO nameVersionSaveBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.nameVersionSave(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * new_draft_form_stencil 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "new_draft_form_stencil", tags = {"页面" },  notes = "ArticlePage-new_draft_form_stencil ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/new_draft_form_stencil")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>newDraftFormStencilBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(newDraftFormStencilBySpaceId(spaceId, item)));
        else
            rt.set(newDraftFormStencilBySpaceId(spaceId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * new_draft_form_stencil 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO newDraftFormStencilBySpaceId
            (String spaceId, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        ArticlePage rt = articlePageService.newDraftFormStencil(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * publish_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "publish_page", tags = {"页面" },  notes = "ArticlePage-publish_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-publish_page-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-publish_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/publish_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>publishPageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(publishPageBySpaceId(spaceId, item)));
        else
            rt.set(publishPageBySpaceId(spaceId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * publish_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO publishPageBySpaceId
            (String spaceId, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        ArticlePage rt = articlePageService.publishPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * publish_page_test 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "publish_page_test", tags = {"页面" },  notes = "ArticlePage-publish_page_test ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/publish_page_test")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>publishPageTestBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(publishPageTestBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(publishPageTestBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * publish_page_test 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO publishPageTestBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.publishPageTest(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * recover 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "recover", tags = {"页面" },  notes = "ArticlePage-recover ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-recover-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-recover')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/recover")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>recoverBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO recoverBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.recover(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * recover_version 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "recover_version", tags = {"页面" },  notes = "ArticlePage-recover_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-recover_version-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-recover_version')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/recover_version")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>recoverVersionBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverVersionBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverVersionBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * recover_version 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO recoverVersionBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.recoverVersion(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"页面" },  notes = "ArticlePage-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Save-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-Save')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/save")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>saveBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySpaceId(spaceId, item)));
        else
            rt.set(saveBySpaceId(spaceId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO saveBySpaceId
            (String spaceId, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        articlePageService.save(domain);
        ArticlePage rt = domain;
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * save_to_stencil 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "save_to_stencil", tags = {"页面" },  notes = "ArticlePage-save_to_stencil ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/save_to_stencil")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>saveToStencilBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveToStencilBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveToStencilBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * save_to_stencil 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO saveToStencilBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.saveToStencil(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * shared_setting 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "shared_setting", tags = {"页面" },  notes = "ArticlePage-shared_setting ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-shared_setting-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-shared_setting')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/shared_setting")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>sharedSettingBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sharedSettingBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sharedSettingBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shared_setting 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO sharedSettingBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.sharedSetting(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * shared_url 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "shared_url", tags = {"页面" },  notes = "ArticlePage-shared_url ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-shared_url-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-shared_url')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/shared_url")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>sharedUrlBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(sharedUrlBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(sharedUrlBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * shared_url 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO sharedUrlBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.sharedUrl(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * un_favorite 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "un_favorite", tags = {"页面" },  notes = "ArticlePage-un_favorite ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/un_favorite")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>unFavoriteBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * un_favorite 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO unFavoriteBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.unFavorite(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * unlock_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "unlock_page", tags = {"页面" },  notes = "ArticlePage-unlock_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-unlock_page-all') or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-unlock_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/{id}/unlock_page")
    public Mono<ResponseEntity<ResponseWrapper<ArticlePageDTO>>>unlockPageBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unlockPageBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unlockPageBySpaceIdAndId(spaceId, id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * unlock_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO unlockPageBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.unlockPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 页面
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"页面" },  notes = "ArticlePage-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Get-all')  or hasPermission(this.articlePageDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ArticlePage-Get')")
    @GetMapping("article_pages/{id}")
    public Mono<ResponseEntity<ArticlePageDTO>> getById
            (@PathVariable("id") String id) {
        ArticlePage rt = articlePageService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 页面
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面" },  notes = "ArticlePage-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Remove-all') or hasPermission(this.articlePageService.get(#id),'ibizplm-ArticlePage-Remove')")
    @DeleteMapping("article_pages/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = articlePageService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面" },  notes = "ArticlePage-CheckKey ")
    @PostMapping("article_pages/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        CheckKeyStatus rt = articlePageService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_shared 页面
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "check_shared", tags = {"页面" },  notes = "ArticlePage-check_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-check_shared-all') or hasPermission(this.articlePageService.get(#id),'ibizplm-ArticlePage-check_shared')")
    @GetMapping("article_pages/{id}/check_shared")
    public Mono<ResponseEntity<ArticlePageDTO>> checkSharedById
            (@PathVariable("id") String id) {
        ArticlePage rt = articlePageService.checkShared(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面" },  notes = "ArticlePage-GetDraft ")
    @GetMapping("article_pages/get_draft")
    public Mono<ResponseEntity<ArticlePageDTO>> getDraft
            (@SpringQueryMap ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        ArticlePage rt = articlePageService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * get_draft_pages 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "get_draft_pages", tags = {"页面" },  notes = "ArticlePage-get_draft_pages ")
    @GetMapping("article_pages/get_draft_pages")
    public Mono<ResponseEntity<ArticlePageDTO>> getDraftPages
            (@SpringQueryMap ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        ArticlePage rt = articlePageService.getDraftPages(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * shared 页面
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "shared", tags = {"页面" },  notes = "ArticlePage-shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-shared-all') or hasPermission(this.articlePageService.get(#id),'ibizplm-ArticlePage-shared')")
    @GetMapping("article_pages/{id}/shared")
    public Mono<ResponseEntity<ArticlePageDTO>> sharedById
            (@PathVariable("id") String id) {
        ArticlePage rt = articlePageService.shared(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_advanced_search 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"页面" },  notes = "ArticlePage-fetch_advanced_search ")
    @PostMapping("article_pages/fetch_advanced_search")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchAdvancedSearch
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchAdvancedSearch(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_all_shared_pages 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageSharedFieldsDTO>>>
    */
    @ApiOperation(value = "查询fetch_all_shared_pages", tags = {"页面" },  notes = "ArticlePage-fetch_all_shared_pages ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_all_shared_pages-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_all_shared_pages')")
    @PostMapping("article_pages/fetch_all_shared_pages")
    public Mono<ResponseEntity<List<ArticlePageSharedFieldsDTO>>> fetchAllSharedPages
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchAllSharedPages(context) ;
        List<ArticlePageSharedFieldsDTO> list = articlePageSharedFieldsDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_page 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_page", tags = {"页面" },  notes = "ArticlePage-fetch_baseline_choose_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_baseline_choose_page-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_baseline_choose_page')")
    @PostMapping("article_pages/fetch_baseline_choose_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchBaselineChoosePage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchBaselineChoosePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_shared 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageNameDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_shared", tags = {"页面" },  notes = "ArticlePage-fetch_choose_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_choose_shared-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_choose_shared')")
    @PostMapping("article_pages/fetch_choose_shared")
    public Mono<ResponseEntity<List<ArticlePageNameDTO>>> fetchChooseShared
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchChooseShared(context) ;
        List<ArticlePageNameDTO> list = articlePageNameDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面" },  notes = "ArticlePage-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_default-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_default')")
    @PostMapping("article_pages/fetch_default")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchDefault
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchDefault(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_draft_page 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_draft_page", tags = {"页面" },  notes = "ArticlePage-fetch_draft_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_draft_page-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_draft_page')")
    @PostMapping("article_pages/fetch_draft_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchDraftPage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchDraftPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_home_page 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_home_page", tags = {"页面" },  notes = "ArticlePage-fetch_home_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_home_page-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_home_page')")
    @PostMapping("article_pages/fetch_home_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchHomePage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchHomePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_is_deleted 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_is_deleted", tags = {"页面" },  notes = "ArticlePage-fetch_is_deleted ")
    @PostMapping("article_pages/fetch_is_deleted")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchIsDeleted
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchIsDeleted(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_favorite_page 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_favorite_page", tags = {"页面" },  notes = "ArticlePage-fetch_my_favorite_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_my_favorite_page-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_my_favorite_page')")
    @PostMapping("article_pages/fetch_my_favorite_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchMyFavoritePage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchMyFavoritePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"页面" },  notes = "ArticlePage-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_my_filter-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_my_filter')")
    @PostMapping("article_pages/fetch_my_filter")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchMyFilter
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchMyFilter(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_parent_page 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_parent_page", tags = {"页面" },  notes = "ArticlePage-fetch_no_parent_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_no_parent_page-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_no_parent_page')")
    @PostMapping("article_pages/fetch_no_parent_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchNoParentPage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchNoParentPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"页面" },  notes = "ArticlePage-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_normal-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_normal')")
    @PostMapping("article_pages/fetch_normal")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchNormal
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchNormal(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_only_page 页面
    * 只查询页面。不包含分组及草稿
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_only_page", tags = {"页面" },  notes = "ArticlePage-fetch_only_page 只查询页面。不包含分组及草稿")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_only_page-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_only_page')")
    @PostMapping("article_pages/fetch_only_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchOnlyPage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchOnlyPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"页面" },  notes = "ArticlePage-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_reader-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_reader')")
    @PostMapping("article_pages/fetch_reader")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchReader
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchReader(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_page 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_page", tags = {"页面" },  notes = "ArticlePage-fetch_shared_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_page-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_shared_page')")
    @PostMapping("article_pages/fetch_shared_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchSharedPage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_reader 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageSharedReadDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_reader", tags = {"页面" },  notes = "ArticlePage-fetch_shared_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_reader-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_shared_reader')")
    @PostMapping("article_pages/fetch_shared_reader")
    public Mono<ResponseEntity<List<ArticlePageSharedReadDTO>>> fetchSharedReader
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedReader(context) ;
        List<ArticlePageSharedReadDTO> list = articlePageSharedReadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_search 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_search", tags = {"页面" },  notes = "ArticlePage-fetch_shared_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_search-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_shared_search')")
    @PostMapping("article_pages/fetch_shared_search")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchSharedSearch
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedSearch(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_sub_pages 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_sub_pages", tags = {"页面" },  notes = "ArticlePage-fetch_shared_sub_pages ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_sub_pages-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_shared_sub_pages')")
    @PostMapping("article_pages/fetch_shared_sub_pages")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchSharedSubPages
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedSubPages(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_with_me 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageSharedFieldsDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_with_me", tags = {"页面" },  notes = "ArticlePage-fetch_shared_with_me ")
    @PostMapping("article_pages/fetch_shared_with_me")
    public Mono<ResponseEntity<List<ArticlePageSharedFieldsDTO>>> fetchSharedWithMe
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedWithMe(context) ;
        List<ArticlePageSharedFieldsDTO> list = articlePageSharedFieldsDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_with_me_edit 页面
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_with_me_edit", tags = {"页面" },  notes = "ArticlePage-fetch_shared_with_me_edit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_with_me_edit-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_shared_with_me_edit')")
    @PostMapping("article_pages/fetch_shared_with_me_edit")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchSharedWithMeEdit
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedWithMeEdit(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"页面" },  notes = "ArticlePage-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Get-all')  or hasPermission('shared_space',#spaceId,this.articlePageDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-ArticlePage-Get')")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{id}")
    public Mono<ResponseEntity<ArticlePageDTO>> getBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        ArticlePage rt = articlePageService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面" },  notes = "ArticlePage-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Remove-all') or hasPermission('shared_space',#spaceId,this.articlePageService.get(#id),'ibizplm-ArticlePage-Remove')")
    @DeleteMapping("shared_spaces/{spaceId}/article_pages/{id}")
    public Mono<ResponseEntity<Boolean>> removeBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        Boolean rt = articlePageService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面" },  notes = "ArticlePage-CheckKey ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        CheckKeyStatus rt = articlePageService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * check_shared 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "check_shared", tags = {"页面" },  notes = "ArticlePage-check_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-check_shared-all') or hasPermission('shared_space',#spaceId,this.articlePageService.get(#id),'ibizplm-ArticlePage-check_shared')")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{id}/check_shared")
    public Mono<ResponseEntity<ArticlePageDTO>> checkSharedBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        ArticlePage rt = articlePageService.checkShared(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * 草稿GetDraft 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面" },  notes = "ArticlePage-GetDraft ")
    @GetMapping("shared_spaces/{spaceId}/article_pages/get_draft")
    public Mono<ResponseEntity<ArticlePageDTO>> getDraftBySpaceId
            (@PathVariable("spaceId") String spaceId, @SpringQueryMap ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        ArticlePage rt = articlePageService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * get_draft_pages 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "get_draft_pages", tags = {"页面" },  notes = "ArticlePage-get_draft_pages ")
    @GetMapping("shared_spaces/{spaceId}/article_pages/get_draft_pages")
    public Mono<ResponseEntity<ArticlePageDTO>> getDraftPagesBySpaceId
            (@PathVariable("spaceId") String spaceId, @SpringQueryMap ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        ArticlePage rt = articlePageService.getDraftPages(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * shared 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return Mono<ResponseEntity<ArticlePageDTO>>
    */
    @ApiOperation(value = "shared", tags = {"页面" },  notes = "ArticlePage-shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-shared-all') or hasPermission('shared_space',#spaceId,this.articlePageService.get(#id),'ibizplm-ArticlePage-shared')")
    @GetMapping("shared_spaces/{spaceId}/article_pages/{id}/shared")
    public Mono<ResponseEntity<ArticlePageDTO>> sharedBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        ArticlePage rt = articlePageService.shared(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_advanced_search 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"页面" },  notes = "ArticlePage-fetch_advanced_search ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_advanced_search")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchAdvancedSearchBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchAdvancedSearch(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_all_shared_pages 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageSharedFieldsDTO>>>
    */
    @ApiOperation(value = "查询fetch_all_shared_pages", tags = {"页面" },  notes = "ArticlePage-fetch_all_shared_pages ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_all_shared_pages-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_all_shared_pages')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_all_shared_pages")
    public Mono<ResponseEntity<List<ArticlePageSharedFieldsDTO>>> fetchAllSharedPagesBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchAllSharedPages(context) ;
        List<ArticlePageSharedFieldsDTO> list = articlePageSharedFieldsDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_baseline_choose_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_baseline_choose_page", tags = {"页面" },  notes = "ArticlePage-fetch_baseline_choose_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_baseline_choose_page-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_baseline_choose_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_baseline_choose_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchBaselineChoosePageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchBaselineChoosePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_choose_shared 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageNameDTO>>>
    */
    @ApiOperation(value = "查询fetch_choose_shared", tags = {"页面" },  notes = "ArticlePage-fetch_choose_shared ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_choose_shared-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_choose_shared')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_choose_shared")
    public Mono<ResponseEntity<List<ArticlePageNameDTO>>> fetchChooseSharedBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchChooseShared(context) ;
        List<ArticlePageNameDTO> list = articlePageNameDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_default 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面" },  notes = "ArticlePage-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_default-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_default')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_default")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchDefaultBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchDefault(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_draft_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_draft_page", tags = {"页面" },  notes = "ArticlePage-fetch_draft_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_draft_page-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_draft_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_draft_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchDraftPageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchDraftPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_home_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_home_page", tags = {"页面" },  notes = "ArticlePage-fetch_home_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_home_page-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_home_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_home_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchHomePageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchHomePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_is_deleted 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_is_deleted", tags = {"页面" },  notes = "ArticlePage-fetch_is_deleted ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_is_deleted")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchIsDeletedBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchIsDeleted(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_favorite_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_favorite_page", tags = {"页面" },  notes = "ArticlePage-fetch_my_favorite_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_my_favorite_page-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_my_favorite_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_my_favorite_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchMyFavoritePageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchMyFavoritePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_filter 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_filter", tags = {"页面" },  notes = "ArticlePage-fetch_my_filter ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_my_filter-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_my_filter')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_my_filter")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchMyFilterBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchMyFilter(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_parent_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_parent_page", tags = {"页面" },  notes = "ArticlePage-fetch_no_parent_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_no_parent_page-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_no_parent_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_no_parent_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchNoParentPageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchNoParentPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"页面" },  notes = "ArticlePage-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_normal-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_normal')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_normal")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchNormalBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchNormal(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_only_page 页面
    * 只查询页面。不包含分组及草稿
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_only_page", tags = {"页面" },  notes = "ArticlePage-fetch_only_page 只查询页面。不包含分组及草稿")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_only_page-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_only_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_only_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchOnlyPageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchOnlyPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_reader 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_reader", tags = {"页面" },  notes = "ArticlePage-fetch_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_reader-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_reader')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_reader")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchReaderBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchReader(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_page", tags = {"页面" },  notes = "ArticlePage-fetch_shared_page ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_page-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_shared_page')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_shared_page")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchSharedPageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_reader 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageSharedReadDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_reader", tags = {"页面" },  notes = "ArticlePage-fetch_shared_reader ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_reader-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_shared_reader')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_shared_reader")
    public Mono<ResponseEntity<List<ArticlePageSharedReadDTO>>> fetchSharedReaderBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedReader(context) ;
        List<ArticlePageSharedReadDTO> list = articlePageSharedReadDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_search 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_search", tags = {"页面" },  notes = "ArticlePage-fetch_shared_search ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_search-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_shared_search')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_shared_search")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchSharedSearchBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedSearch(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_sub_pages 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_sub_pages", tags = {"页面" },  notes = "ArticlePage-fetch_shared_sub_pages ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_sub_pages-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_shared_sub_pages')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_shared_sub_pages")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchSharedSubPagesBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedSubPages(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_with_me 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageSharedFieldsDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_with_me", tags = {"页面" },  notes = "ArticlePage-fetch_shared_with_me ")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_shared_with_me")
    public Mono<ResponseEntity<List<ArticlePageSharedFieldsDTO>>> fetchSharedWithMeBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedWithMe(context) ;
        List<ArticlePageSharedFieldsDTO> list = articlePageSharedFieldsDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_shared_with_me_edit 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return Mono<ResponseEntity<List<ArticlePageDTO>>>
    */
    @ApiOperation(value = "查询fetch_shared_with_me_edit", tags = {"页面" },  notes = "ArticlePage-fetch_shared_with_me_edit ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_shared_with_me_edit-all') or hasPermission('shared_space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_shared_with_me_edit')")
    @PostMapping("shared_spaces/{spaceId}/article_pages/fetch_shared_with_me_edit")
    public Mono<ResponseEntity<List<ArticlePageDTO>>> fetchSharedWithMeEditBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.fetchSharedWithMeEdit(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建页面
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Create-all')")
    @ApiOperation(value = "批量新建页面", tags = {"页面" },  notes = "批量新建页面")
	@PostMapping("article_pages/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<ArticlePageDTO> dtos) {
        articlePageService.create(articlePageDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除页面
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Remove-all')")
    @ApiOperation(value = "批量删除页面", tags = {"页面" },  notes = "批量删除页面")
	@DeleteMapping("article_pages/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        articlePageService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新页面
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Update-all')")
    @ApiOperation(value = "批量更新页面", tags = {"页面" },  notes = "批量更新页面")
	@PutMapping("article_pages/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<ArticlePageDTO> dtos) {
        articlePageService.update(articlePageDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存页面
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Save-all')")
    @ApiOperation(value = "批量保存页面", tags = {"页面" },  notes = "批量保存页面")
	@PostMapping("article_pages/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<ArticlePageDTO> dtos) {
        articlePageService.save(articlePageDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入页面
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Save-all')")
    @ApiOperation(value = "批量导入页面", tags = {"页面" },  notes = "批量导入页面")
	@PostMapping("article_pages/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ArticlePageDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(articlePageService.importData(config,ignoreError,articlePageDtoMapping.toDomain(dtos))));
    }

}
