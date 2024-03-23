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
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.filter.AttentionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Attention] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAttentionResource {

    @Autowired
    public AttentionService attentionService;

    @Autowired
    @Lazy
    public AttentionDTOMapping attentionDtoMapping;

    @Autowired
    @Lazy
    public AttentionFilterDTOMapping attentionFilterDtoMapping;

    @Autowired
    @Lazy
    public Attentionuser_idDTOMapping attentionuserIdDtoMapping;

    /**
    * 创建Create 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AttentionDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"关注" },  notes = "Attention-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-Create-all') or hasPermission(this.attentionDtoMapping.toDomain(#dto),'ibizplm-Attention-Create')")
    @PostMapping("attentions")
    public ResponseEntity<ResponseWrapper<AttentionDTO>> create
            (@Validated @RequestBody RequestWrapper<AttentionDTO> dto) {
        ResponseWrapper<AttentionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AttentionDTO>
    */   
    public AttentionDTO create
            (AttentionDTO dto) {
        Attention domain = attentionDtoMapping.toDomain(dto);
        attentionService.create(domain);
        Attention rt = domain;
        return attentionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 关注
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AttentionDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"关注" },  notes = "Attention-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-Update-all') or hasPermission(this.attentionService.get(#id),'ibizplm-Attention-Update')")
    @VersionCheck(entity = "attention" , versionfield = "updateTime")
    @PutMapping("attentions/{id}")
    public ResponseEntity<ResponseWrapper<AttentionDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<AttentionDTO> dto) {
        ResponseWrapper<AttentionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 关注
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<AttentionDTO>
    */   
    public AttentionDTO updateById
            (String id, AttentionDTO dto) {
        Attention domain = attentionDtoMapping.toDomain(dto);
        domain.setId(id);
        attentionService.update(domain);
        Attention rt = domain;
        return attentionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AttentionDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"关注" },  notes = "Attention-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-Save-all') or hasPermission(this.attentionDtoMapping.toDomain(#dto),'ibizplm-Attention-Save')")
    @PostMapping("attentions/save")
    public ResponseEntity<ResponseWrapper<AttentionDTO>> save
            (@Validated @RequestBody RequestWrapper<AttentionDTO> dto) {
        ResponseWrapper<AttentionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AttentionDTO>
    */   
    public AttentionDTO save
            (AttentionDTO dto) {
        Attention domain = attentionDtoMapping.toDomain(dto);
        attentionService.save(domain);
        Attention rt = domain;
        return attentionDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 关注
    * 
    *
    * @param id id
    * @return ResponseEntity<AttentionDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"关注" },  notes = "Attention-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-Get-all')  or hasPermission(this.attentionDtoMapping.toDomain(returnObject.body),'ibizplm-Attention-Get')")
    @GetMapping("attentions/{id}")
    public ResponseEntity<AttentionDTO> getById
            (@PathVariable("id") String id) {
        Attention rt = attentionService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(attentionDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 关注
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"关注" },  notes = "Attention-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-Remove-all') or hasPermission(this.attentionService.get(#id),'ibizplm-Attention-Remove')")
    @DeleteMapping("attentions/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = attentionService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"关注" },  notes = "Attention-CheckKey ")
    @PostMapping("attentions/checkkey")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody AttentionDTO dto) {
        Attention domain = attentionDtoMapping.toDomain(dto);
        Integer rt = attentionService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<AttentionDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"关注" },  notes = "Attention-GetDraft ")
    @GetMapping("attentions/getdraft")
    public ResponseEntity<AttentionDTO> getDraft
            (@SpringQueryMap AttentionDTO dto) {
        Attention domain = attentionDtoMapping.toDomain(dto);
        Attention rt = attentionService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(attentionDtoMapping.toDto(rt));
    }

    /**
    * 查询FetchAttention_by_ownerid 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<Attentionuser_idDTO>>
    */
    @ApiOperation(value = "查询FetchAttention_by_ownerid", tags = {"关注" },  notes = "Attention-FetchAttention_by_ownerid ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-FetchAttention_by_ownerid-all') or hasPermission(#dto,'ibizplm-Attention-FetchAttention_by_ownerid')")
    @PostMapping("attentions/fetchattention_by_ownerid")
    public ResponseEntity<List<Attentionuser_idDTO>> fetchAttentionByOwnerid
            (@Validated @RequestBody AttentionFilterDTO dto) {
        AttentionSearchContext context = attentionFilterDtoMapping.toDomain(dto);
        Page<Attention> domains = attentionService.searchAttentionByOwnerid(context) ;
        List<Attentionuser_idDTO> list = attentionuserIdDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchComment_attention 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<Attentionuser_idDTO>>
    */
    @ApiOperation(value = "查询FetchComment_attention", tags = {"关注" },  notes = "Attention-FetchComment_attention ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-FetchComment_attention-all') or hasPermission(#dto,'ibizplm-Attention-FetchComment_attention')")
    @PostMapping("attentions/fetchcomment_attention")
    public ResponseEntity<List<Attentionuser_idDTO>> fetchCommentAttention
            (@Validated @RequestBody AttentionFilterDTO dto) {
        AttentionSearchContext context = attentionFilterDtoMapping.toDomain(dto);
        Page<Attention> domains = attentionService.searchCommentAttention(context) ;
        List<Attentionuser_idDTO> list = attentionuserIdDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchDefault 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<AttentionDTO>>
    */
    @ApiOperation(value = "查询FetchDefault", tags = {"关注" },  notes = "Attention-FetchDefault ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-FetchDefault-all') or hasPermission(#dto,'ibizplm-Attention-FetchDefault')")
    @PostMapping("attentions/fetchdefault")
    public ResponseEntity<List<AttentionDTO>> fetchDefault
            (@Validated @RequestBody AttentionFilterDTO dto) {
        AttentionSearchContext context = attentionFilterDtoMapping.toDomain(dto);
        Page<Attention> domains = attentionService.searchDefault(context) ;
        List<AttentionDTO> list = attentionDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询FetchNotify 关注
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<AttentionDTO>>
    */
    @ApiOperation(value = "查询FetchNotify", tags = {"关注" },  notes = "Attention-FetchNotify ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Attention-FetchNotify-all') or hasPermission(#dto,'ibizplm-Attention-FetchNotify')")
    @PostMapping("attentions/fetchnotify")
    public ResponseEntity<List<AttentionDTO>> fetchNotify
            (@Validated @RequestBody AttentionFilterDTO dto) {
        AttentionSearchContext context = attentionFilterDtoMapping.toDomain(dto);
        Page<Attention> domains = attentionService.searchNotify(context) ;
        List<AttentionDTO> list = attentionDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建关注
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Attention-Create-all')")
    @ApiOperation(value = "批量新建关注", tags = {"关注" },  notes = "批量新建关注")
	@PostMapping("attentions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttentionDTO> dtos) {
        attentionService.createBatch(attentionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除关注
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Attention-Remove-all')")
    @ApiOperation(value = "批量删除关注", tags = {"关注" },  notes = "批量删除关注")
	@DeleteMapping("attentions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attentionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新关注
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Attention-Update-all')")
    @ApiOperation(value = "批量更新关注", tags = {"关注" },  notes = "批量更新关注")
	@PutMapping("attentions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttentionDTO> dtos) {
        attentionService.updateBatch(attentionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存关注
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Attention-Save-all')")
    @ApiOperation(value = "批量保存关注", tags = {"关注" },  notes = "批量保存关注")
	@PostMapping("attentions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttentionDTO> dtos) {
        attentionService.saveBatch(attentionDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入关注
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Attention-Save-all')")
    @ApiOperation(value = "批量导入关注", tags = {"关注" },  notes = "批量导入关注")
	@PostMapping("attentions/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<AttentionDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(attentionService.importData(config,ignoreError,attentionDtoMapping.toDomain(dtos)));
    }

}
