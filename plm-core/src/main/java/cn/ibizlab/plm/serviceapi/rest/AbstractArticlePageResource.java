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
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.wiki.filter.ArticlePageSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

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

    /**
    * 创建Create 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"页面" },  notes = "ArticlePage-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Create-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-Create')")
    @PostMapping("article_pages")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> create
            (@Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"页面" },  notes = "ArticlePage-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Update-all') or hasPermission(this.articlePageService.get(#id),'ibizplm-ArticlePage-Update')")
    @VersionCheck(entity = "articlepage" , versionfield = "updateTime")
    @PutMapping("article_pages/{id}")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * commit_version 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "commit_version", tags = {"页面" },  notes = "ArticlePage-commit_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-commit_version-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-commit_version')")
    @PostMapping("article_pages/{id}/commit_version")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> commitVersionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(commitVersionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(commitVersionById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * delete 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "delete", tags = {"页面" },  notes = "ArticlePage-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-delete-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-delete')")
    @PostMapping("article_pages/{id}/delete")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> deleteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * favorite 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "favorite", tags = {"页面" },  notes = "ArticlePage-favorite ")
    @PostMapping("article_pages/{id}/favorite")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> favoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * new_draft_form_stencil 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "new_draft_form_stencil", tags = {"页面" },  notes = "ArticlePage-new_draft_form_stencil ")
    @PostMapping("article_pages/new_draft_form_stencil")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> newDraftFormStencil
            (@Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(newDraftFormStencil(item)));
        else
            rt.set(newDraftFormStencil(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "publish_page", tags = {"页面" },  notes = "ArticlePage-publish_page ")
    @PostMapping("article_pages/{id}/publish_page")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> publishPageById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(publishPageById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(publishPageById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * publish_page 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO publishPageById
            (String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
        ArticlePage rt = articlePageService.publishPage(domain);
        return articlePageDtoMapping.toDto(rt);
    }

    /**
    * publish_page_test 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "publish_page_test", tags = {"页面" },  notes = "ArticlePage-publish_page_test ")
    @PostMapping("article_pages/{id}/publish_page_test")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> publishPageTestById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(publishPageTestById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(publishPageTestById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "recover", tags = {"页面" },  notes = "ArticlePage-recover ")
    @PostMapping("article_pages/{id}/recover")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> recoverById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "recover_version", tags = {"页面" },  notes = "ArticlePage-recover_version ")
    @PostMapping("article_pages/{id}/recover_version")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> recoverVersionById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverVersionById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverVersionById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"页面" },  notes = "ArticlePage-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Save-all') or hasPermission(this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-Save')")
    @PostMapping("article_pages/save")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> save
            (@Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "save_to_stencil", tags = {"页面" },  notes = "ArticlePage-save_to_stencil ")
    @PostMapping("article_pages/{id}/save_to_stencil")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> saveToStencilById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveToStencilById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveToStencilById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * un_favorite 页面
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "un_favorite", tags = {"页面" },  notes = "ArticlePage-un_favorite ")
    @PostMapping("article_pages/{id}/un_favorite")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> unFavoriteById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 创建Create 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"页面" },  notes = "ArticlePage-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Create-all') or hasPermission('space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-Create')")
    @PostMapping("spaces/{spaceId}/article_pages")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> createBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createBySpaceId(spaceId, item)));
        else
            rt.set(createBySpaceId(spaceId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"页面" },  notes = "ArticlePage-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Update-all') or hasPermission('space',#spaceId,this.articlePageService.get(#id),'ibizplm-ArticlePage-Update')")
    @VersionCheck(entity = "articlepage" , versionfield = "updateTime")
    @PutMapping("spaces/{spaceId}/article_pages/{id}")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> updateBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * commit_version 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "commit_version", tags = {"页面" },  notes = "ArticlePage-commit_version ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-commit_version-all') or hasPermission('space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-commit_version')")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/commit_version")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> commitVersionBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(commitVersionBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(commitVersionBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * delete 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "delete", tags = {"页面" },  notes = "ArticlePage-delete ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-delete-all') or hasPermission('space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-delete')")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/delete")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> deleteBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(deleteBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(deleteBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * favorite 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "favorite", tags = {"页面" },  notes = "ArticlePage-favorite ")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/favorite")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> favoriteBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(favoriteBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(favoriteBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * new_draft_form_stencil 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "new_draft_form_stencil", tags = {"页面" },  notes = "ArticlePage-new_draft_form_stencil ")
    @PostMapping("spaces/{spaceId}/article_pages/new_draft_form_stencil")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> newDraftFormStencilBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(newDraftFormStencilBySpaceId(spaceId, item)));
        else
            rt.set(newDraftFormStencilBySpaceId(spaceId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "publish_page", tags = {"页面" },  notes = "ArticlePage-publish_page ")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/publish_page")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> publishPageBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(publishPageBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(publishPageBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * publish_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */   
    public ArticlePageDTO publishPageBySpaceIdAndId
            (String spaceId, String id, ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setId(id);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "publish_page_test", tags = {"页面" },  notes = "ArticlePage-publish_page_test ")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/publish_page_test")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> publishPageTestBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(publishPageTestBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(publishPageTestBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "recover", tags = {"页面" },  notes = "ArticlePage-recover ")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/recover")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> recoverBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "recover_version", tags = {"页面" },  notes = "ArticlePage-recover_version ")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/recover_version")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> recoverVersionBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(recoverVersionBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(recoverVersionBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"页面" },  notes = "ArticlePage-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Save-all') or hasPermission('space',#spaceId,this.articlePageDtoMapping.toDomain(#dto),'ibizplm-ArticlePage-Save')")
    @PostMapping("spaces/{spaceId}/article_pages/save")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> saveBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveBySpaceId(spaceId, item)));
        else
            rt.set(saveBySpaceId(spaceId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "save_to_stencil", tags = {"页面" },  notes = "ArticlePage-save_to_stencil ")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/save_to_stencil")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> saveToStencilBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(saveToStencilBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(saveToStencilBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * un_favorite 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "un_favorite", tags = {"页面" },  notes = "ArticlePage-un_favorite ")
    @PostMapping("spaces/{spaceId}/article_pages/{id}/un_favorite")
    public ResponseEntity<ResponseWrapper<ArticlePageDTO>> unFavoriteBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<ArticlePageDTO> dto) {
        ResponseWrapper<ArticlePageDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(unFavoriteBySpaceIdAndId(spaceId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(unFavoriteBySpaceIdAndId(spaceId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
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
    * 获取Get 页面
    * 
    *
    * @param id id
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"页面" },  notes = "ArticlePage-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Get-all')  or hasPermission(this.articlePageDtoMapping.toDomain(returnObject.body),'ibizplm-ArticlePage-Get')")
    @GetMapping("article_pages/{id}")
    public ResponseEntity<ArticlePageDTO> getById
            (@PathVariable("id") String id) {
        ArticlePage rt = articlePageService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 页面
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面" },  notes = "ArticlePage-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Remove-all') or hasPermission(this.articlePageService.get(#id),'ibizplm-ArticlePage-Remove')")
    @DeleteMapping("article_pages/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = articlePageService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面" },  notes = "ArticlePage-CheckKey ")
    @PostMapping("article_pages/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        Integer rt = articlePageService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面" },  notes = "ArticlePage-GetDraft ")
    @GetMapping("article_pages/get_draft")
    public ResponseEntity<ArticlePageDTO> getDraft
            (@SpringQueryMap ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        ArticlePage rt = articlePageService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt));
    }

    /**
    * get_draft_pages 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "get_draft_pages", tags = {"页面" },  notes = "ArticlePage-get_draft_pages ")
    @GetMapping("article_pages/get_draft_pages")
    public ResponseEntity<ArticlePageDTO> getDraftPages
            (@SpringQueryMap ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        ArticlePage rt = articlePageService.getDraftPages(domain);
        return ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_advanced_search 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"页面" },  notes = "ArticlePage-fetch_advanced_search ")
    @PostMapping("article_pages/fetch_advanced_search")
    public ResponseEntity<List<ArticlePageDTO>> fetchAdvancedSearch
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchAdvancedSearch(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面" },  notes = "ArticlePage-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_default-all') or hasPermission(#dto,'ibizplm-ArticlePage-fetch_default')")
    @PostMapping("article_pages/fetch_default")
    public ResponseEntity<List<ArticlePageDTO>> fetchDefault
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchDefault(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_draft_page 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_draft_page", tags = {"页面" },  notes = "ArticlePage-fetch_draft_page ")
    @PostMapping("article_pages/fetch_draft_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchDraftPage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchDraftPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_home_page 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_home_page", tags = {"页面" },  notes = "ArticlePage-fetch_home_page ")
    @PostMapping("article_pages/fetch_home_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchHomePage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchHomePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_is_deleted 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_is_deleted", tags = {"页面" },  notes = "ArticlePage-fetch_is_deleted ")
    @PostMapping("article_pages/fetch_is_deleted")
    public ResponseEntity<List<ArticlePageDTO>> fetchIsDeleted
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchIsDeleted(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_favorite_page 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_my_favorite_page", tags = {"页面" },  notes = "ArticlePage-fetch_my_favorite_page ")
    @PostMapping("article_pages/fetch_my_favorite_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchMyFavoritePage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchMyFavoritePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_no_parent_page 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_no_parent_page", tags = {"页面" },  notes = "ArticlePage-fetch_no_parent_page ")
    @PostMapping("article_pages/fetch_no_parent_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchNoParentPage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchNoParentPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 页面
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"页面" },  notes = "ArticlePage-fetch_normal ")
    @PostMapping("article_pages/fetch_normal")
    public ResponseEntity<List<ArticlePageDTO>> fetchNormal
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchNormal(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_only_page 页面
    * 只查询页面。不包含分组及草稿
    *
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_only_page", tags = {"页面" },  notes = "ArticlePage-fetch_only_page 只查询页面。不包含分组及草稿")
    @PostMapping("article_pages/fetch_only_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchOnlyPage
            (@Validated @RequestBody ArticlePageFilterDTO dto) {
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchOnlyPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 获取Get 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"页面" },  notes = "ArticlePage-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Get-all')  or hasPermission('space',#spaceId,this.articlePageDtoMapping.toDomain(returnObject.body),'ibizplm-ArticlePage-Get')")
    @GetMapping("spaces/{spaceId}/article_pages/{id}")
    public ResponseEntity<ArticlePageDTO> getBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        ArticlePage rt = articlePageService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 页面
    * 
    *
    * @param spaceId spaceId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"页面" },  notes = "ArticlePage-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-Remove-all') or hasPermission('space',#spaceId,this.articlePageService.get(#id),'ibizplm-ArticlePage-Remove')")
    @DeleteMapping("spaces/{spaceId}/article_pages/{id}")
    public ResponseEntity<Boolean> removeBySpaceIdAndId
            (@PathVariable("spaceId") String spaceId, @PathVariable("id") String id) {
        Boolean rt = articlePageService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"页面" },  notes = "ArticlePage-CheckKey ")
    @PostMapping("spaces/{spaceId}/article_pages/check_key")
    public ResponseEntity<Integer> checkKeyBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        Integer rt = articlePageService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"页面" },  notes = "ArticlePage-GetDraft ")
    @GetMapping("spaces/{spaceId}/article_pages/get_draft")
    public ResponseEntity<ArticlePageDTO> getDraftBySpaceId
            (@PathVariable("spaceId") String spaceId, @SpringQueryMap ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        ArticlePage rt = articlePageService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt));
    }

    /**
    * get_draft_pages 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<ArticlePageDTO>
    */
    @ApiOperation(value = "get_draft_pages", tags = {"页面" },  notes = "ArticlePage-get_draft_pages ")
    @GetMapping("spaces/{spaceId}/article_pages/get_draft_pages")
    public ResponseEntity<ArticlePageDTO> getDraftPagesBySpaceId
            (@PathVariable("spaceId") String spaceId, @SpringQueryMap ArticlePageDTO dto) {
        ArticlePage domain = articlePageDtoMapping.toDomain(dto);
        domain.setSpaceId(spaceId);
        ArticlePage rt = articlePageService.getDraftPages(domain);
        return ResponseEntity.status(HttpStatus.OK).body(articlePageDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_advanced_search 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_advanced_search", tags = {"页面" },  notes = "ArticlePage-fetch_advanced_search ")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_advanced_search")
    public ResponseEntity<List<ArticlePageDTO>> fetchAdvancedSearchBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchAdvancedSearch(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_default 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"页面" },  notes = "ArticlePage-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-ArticlePage-fetch_default-all') or hasPermission('space',#spaceId,#dto,'ibizplm-ArticlePage-fetch_default')")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_default")
    public ResponseEntity<List<ArticlePageDTO>> fetchDefaultBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchDefault(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_draft_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_draft_page", tags = {"页面" },  notes = "ArticlePage-fetch_draft_page ")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_draft_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchDraftPageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchDraftPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_home_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_home_page", tags = {"页面" },  notes = "ArticlePage-fetch_home_page ")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_home_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchHomePageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchHomePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_is_deleted 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_is_deleted", tags = {"页面" },  notes = "ArticlePage-fetch_is_deleted ")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_is_deleted")
    public ResponseEntity<List<ArticlePageDTO>> fetchIsDeletedBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchIsDeleted(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_my_favorite_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_my_favorite_page", tags = {"页面" },  notes = "ArticlePage-fetch_my_favorite_page ")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_my_favorite_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchMyFavoritePageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchMyFavoritePage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_no_parent_page 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_no_parent_page", tags = {"页面" },  notes = "ArticlePage-fetch_no_parent_page ")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_no_parent_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchNoParentPageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchNoParentPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_normal 页面
    * 
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"页面" },  notes = "ArticlePage-fetch_normal ")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_normal")
    public ResponseEntity<List<ArticlePageDTO>> fetchNormalBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchNormal(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_only_page 页面
    * 只查询页面。不包含分组及草稿
    *
    * @param spaceId spaceId
    * @param dto dto
    * @return ResponseEntity<List<ArticlePageDTO>>
    */
    @ApiOperation(value = "查询fetch_only_page", tags = {"页面" },  notes = "ArticlePage-fetch_only_page 只查询页面。不包含分组及草稿")
    @PostMapping("spaces/{spaceId}/article_pages/fetch_only_page")
    public ResponseEntity<List<ArticlePageDTO>> fetchOnlyPageBySpaceId
            (@PathVariable("spaceId") String spaceId, @Validated @RequestBody ArticlePageFilterDTO dto) {
        dto.setSpaceIdEQ(spaceId);
        ArticlePageSearchContext context = articlePageFilterDtoMapping.toDomain(dto);
        Page<ArticlePage> domains = articlePageService.searchOnlyPage(context) ;
        List<ArticlePageDTO> list = articlePageDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建页面
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Create-all')")
    @ApiOperation(value = "批量新建页面", tags = {"页面" },  notes = "批量新建页面")
	@PostMapping("article_pages/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ArticlePageDTO> dtos) {
        articlePageService.createBatch(articlePageDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除页面
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Remove-all')")
    @ApiOperation(value = "批量删除页面", tags = {"页面" },  notes = "批量删除页面")
	@DeleteMapping("article_pages/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        articlePageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新页面
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Update-all')")
    @ApiOperation(value = "批量更新页面", tags = {"页面" },  notes = "批量更新页面")
	@PutMapping("article_pages/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ArticlePageDTO> dtos) {
        articlePageService.updateBatch(articlePageDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存页面
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Save-all')")
    @ApiOperation(value = "批量保存页面", tags = {"页面" },  notes = "批量保存页面")
	@PostMapping("article_pages/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ArticlePageDTO> dtos) {
        articlePageService.saveBatch(articlePageDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入页面
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-ArticlePage-Save-all')")
    @ApiOperation(value = "批量导入页面", tags = {"页面" },  notes = "批量导入页面")
	@PostMapping("article_pages/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<ArticlePageDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(articlePageService.importData(config,ignoreError,articlePageDtoMapping.toDomain(dtos)));
    }

}
